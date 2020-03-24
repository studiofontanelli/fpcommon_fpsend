package it.csi.fpcommon.fpsend.business.fpsend.integration.impl;

import it.csi.fpcommon.fpsend.business.fpsend.integration.MessageProvider;
import it.csi.fpcommon.fpsend.business.fpsend.integration.dto.richiesta.RICHIESTASMS;
import it.csi.fpcommon.fpsend.business.fpsend.integration.dto.richiesta.SMS;
import it.csi.fpcommon.fpsend.business.fpsend.integration.dto.risposta.nodetail.MESSAGGIO;
import it.csi.fpcommon.fpsend.business.util.Tracer;
import it.csi.fpcommon.fpsend.business.util.XmlSerializer;
import it.csi.fpcommon.fpsend.dto.fpsend.Message;
import it.csi.fpcommon.fpsend.exception.fpsend.DtoConversionException;
import it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException;

import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class MockSmsMessageProviderImpl extends SmsMessageProviderImpl implements MessageProvider {

	public static final String LOGGER_PREFIX = "stasend.integration";

	private static Logger log = Logger.getLogger(LOGGER_PREFIX);

	private String dataInvioSms = "01/01/2020 00:00"; 

	public SMS convertMessage(Message message) throws DtoConversionException{
		SMS sms =  getSmsMessageAdapterImpl().convertFrom(message);
		sms.setDATAINVIO(dataInvioSms);
		return sms;
	}

	public List<SMS> convertMessage(List<Message> messages) throws DtoConversionException{

		String method = "convertMessage"; 
		List<SMS> smsToSend =  getSmsMessageAdapterImpl().convertFrom(messages);
		
		for(SMS sms : smsToSend){
			sms.setDATAINVIO(dataInvioSms);
		}
		
		Tracer.debug(log, getClass().getName(), method, "sending " + smsToSend.size() + " SMS (s)");
		return smsToSend;

	}
	
	public MESSAGGIO inviaSms (RICHIESTASMS richiestaSms, String urlGateway)  throws  SendMessageException {
		String method = "inviaSms";

		MESSAGGIO messaggioRisposta = null;

		try {
			if(log.isDebugEnabled()){
				Tracer.debug(log, getClass().getName(), method, "********** RICHIESTA SMS *************");
				Tracer.debug(log, getClass().getName(), method, XmlSerializer.objectToXml(richiestaSms));
			}

			JAXBContext jaxbContext;

			jaxbContext = JAXBContext.newInstance(RICHIESTASMS.class.getPackage().getName());


			Marshaller marshaller = jaxbContext.createMarshaller();
			StringWriter sw = new StringWriter();
			marshaller.marshal(richiestaSms, sw);


			Tracer.debug(log, getClass().getName(), method, "XML \n " + sw);

			String xmlSms = sw.toString();

			String intestazioneXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";

			if(StringUtils.contains(sw.toString(), intestazioneXml)){
				Tracer.debug(log, getClass().getName(), method, "rimuovo l'intestazione");
				xmlSms = StringUtils.remove(sw.toString(), intestazioneXml);
			}

			Tracer.debug(log, getClass().getName(), method, "xmlSms \n " + xmlSms);

			Tracer.info(log, getClass().getName(), method, "chiamata al servizio non effettuata..........");

			messaggioRisposta = new MESSAGGIO();
			
			messaggioRisposta.setTITOLO("MOCK SMS");
			//messaggioRisposta.setTITOLO("ERRORE");
			messaggioRisposta.setDESCRIZIONE("Invio Mock effettuato con successo!");

		} catch (JAXBException e) {
			Tracer.error(log, getClass().getName(), method, "JAXBException " + e);
			throw new SendMessageException(e.getMessage());

		} 
		return messaggioRisposta;
	}


	

}
