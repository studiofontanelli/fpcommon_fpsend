package it.csi.fpcommon.fpsend.business.fpsend.integration;

import it.csi.fpcommon.fpsend.business.adapter.IDtoAdapter;
import it.csi.fpcommon.fpsend.business.fpsend.integration.dto.richiesta.SMS;
import it.csi.fpcommon.fpsend.business.util.Tracer;
import it.csi.fpcommon.fpsend.dto.fpsend.Message;
import it.csi.fpcommon.fpsend.exception.fpsend.DtoConversionException;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class SmsMessageAdapterImpl /*extends AbstractDtoAdapter<SMS, Message>*/ implements IDtoAdapter<SMS, Message> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4213753703932118040L;

	public static final String LOGGER_PREFIX = "stasend.adapter";
	private static Logger log = Logger.getLogger(LOGGER_PREFIX);


	private String pattern = "(0039|39)[0-9]{9,10}";

	public enum Priorita {

		MEDIA("4"), BASSA("2");

		private String value;
		private Priorita(String value) {
			this.value = value;
		}
	};   

	public Message convertTo(SMS t) throws DtoConversionException {
		throw new DtoConversionException("not implemented yet!");
	}

	public SMS convertFrom(Message v) throws DtoConversionException {

		String method = "convertFrom";

		SMS sms = new SMS();
		try{
			// provo a smandruppare il numero di tel 

			String numeroTelefono = v.getRecipient();

			if(log.isDebugEnabled()){
				Tracer.debug(log,  getClass().getName(), method, "numeroTelefono " + numeroTelefono);
			}

			if (!numeroTelefono.matches(pattern)) {
				Tracer.debug(log,  getClass().getName(), method, "numeroTelefono non coerente col patter");
				if(StringUtils.contains(numeroTelefono, "+39")){
					numeroTelefono = StringUtils.replace(numeroTelefono, "+39", "0039");
				}
				else{
					numeroTelefono = "0039" + numeroTelefono;
				}
				if(log.isDebugEnabled()){
					Tracer.debug(log,  getClass().getName(), method, "numeroTelefono adattato " + numeroTelefono);
				}
			}

			sms.setTELEFONO(numeroTelefono);
			sms.setTESTO(StringUtils.substring(v.getBody(), 0, 160));
			sms.setNOTE("-");
			sms.setTTL("86400");
			sms.setCODIFICA("7bit");
			sms.setPRIORITA(Priorita.MEDIA.value);
		}
		catch(Exception e){
			Tracer.error(log,  getClass().getName(), method, "Exception " + e);
			throw new DtoConversionException("Errore in fase di generazione SMS", e);
		}
		return sms;
	}

	public List<Message> convertTo(List<SMS> tList) throws DtoConversionException {
		throw new DtoConversionException("not implemented yet!");
	}


	public List<SMS> convertFrom(List<Message> vList) throws DtoConversionException {
		List<SMS> smss = new ArrayList<SMS>();
		if(vList != null){
			for(Message message : vList){
				SMS sms = convertFrom(message);
				sms.setPRIORITA(Priorita.BASSA.value);
				smss.add(sms);
			}
		}
		return smss;
	}





}
