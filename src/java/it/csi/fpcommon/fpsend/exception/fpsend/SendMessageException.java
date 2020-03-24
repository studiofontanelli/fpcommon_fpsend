package it.csi.fpcommon.fpsend.exception.fpsend;

import it.csi.csi.wrapper.SystemException;
import it.csi.csi.wrapper.UserException;
import it.csi.csi.wrapper.UnrecoverableException;

////{PROTECTED REGION ID(R527266860) ENABLED START////}
/**
 * Inserire qui la documentazione dell'eccezione SendMessageException.
 * Consigli:
 * <ul>
 * <li> Dire se l'eccezione rappresenta una condizione di errore oppure 
 *      una casistica eccezionale applicativa
 * <li> Potrebbe essere meglio non dettagliare tanto la documentazione dell'
 *      eccezione quanto la documentazione delle clausole "throws" nei metodi
 *      che rilanciano effettivamente quest'eccezione
 * </ul>
 * @generated
 */
////{PROTECTED REGION END////}
public class SendMessageException extends UserException {

	/**
	 * il serial version UID di una eccezione csi &egrave; sempre "1" perch&egrave; le
	 * eccezioni CSI non possono contenere features aggiuntive
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	public SendMessageException(String msg, String nestedExcClassName,
			String nestedExcMessage, String nestedExcStackTrace) {
		super(msg, nestedExcClassName, nestedExcMessage, nestedExcStackTrace);
	}

	/**
	 * @generated
	 */
	public SendMessageException(String msg, String nestedExcClassName,
			String nestedExcMessage) {
		super(msg, nestedExcClassName, nestedExcMessage);
	}

	/**
	 * @generated
	 */
	public SendMessageException(String msg, Throwable nested) {
		super(msg, nested);
	}

	/**
	 * @generated
	 */
	public SendMessageException(String msg) {
		super(msg);
	}
}
