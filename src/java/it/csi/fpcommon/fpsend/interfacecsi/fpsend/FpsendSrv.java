package it.csi.fpcommon.fpsend.interfacecsi.fpsend;

import it.csi.fpcommon.fpsend.dto.fpsend.*;
import it.csi.fpcommon.fpsend.exception.fpsend.*;

////{PROTECTED REGION ID(R-1216480676) ENABLED START////}
/**
 * Inserire qui la documentazione dell'interfaccia pubblica del servizio fpsend.
 * Consigli:
 * <ul>
 * <li> Descrivere qual'&egrave; lo scopo generale del servizio
 * <li> Se necessario fornire una overview delle funzioni messe a disposizione
 *      eventualmente raggruppandole logicamente. Il dettaglio dei singoli
 *      metodi va documentato in corrispondenza dei metodi stessi
 * <li> Se necessario descrivere gli scenari di utilizzo pi&ugrave; frequenti, ovvero
 *      le "coreografie" (nel caso sia necessario richiamare in una sequenza
 *      particolare i metodi
 * <li> Inserire informazioni quali il livello di securizzazione A0-A3
 * <li> Inserire varie ed eventuali... 
 * </ul>
 * @generated
 */
////{PROTECTED REGION END////}
public interface FpsendSrv {

	////{PROTECTED REGION ID(R284160899) ENABLED START////}
	
	public static final String CHANNEL_EMAIL = "EMAIL";
	public static final String CHANNEL_SMS = "SMS";
	public static final String CHANNEL_MOCK_EMAIL = "MOCK_EMAIL";
	public static final String CHANNEL_MOCK_SMS = "MOCK_SMS";
	public static final String CHANNEL_PEC = "PEC";
	public static final String CHANNEL_MOCK_PEC = "MOCK_PEC";

	public static final String EMPTY_PLACE_HOLDER = "***__|__***";
	
	
	
	
	/**
	 * Inserire qui la documentazione del metodo sendMessage.
	 * Descrivere dettagliatamente:
	 * <ul>
	 * <li>la semantica del metodo (facendo riferimento ai parametri). E' importante 
	 *     elencare casi particolari (dati non trovati, ecc...)
	 * <li> i singoli parametri (nelle sezioni apposite sottostanti): &egrave; importante
	 *      indicare:
	 *      <ul>
	 *      <li>se il parametro &egrave; obbligatorio
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      </ul>
	 * <li> le eccezioni rilanciate (nelle sezioni apposite sottostanti)
	 * <li> il tipo di ritorno
	 * </ul>
	 * @param requestMessage [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	 	
	 * @return java.lang.String
	 * @throws SendMessageException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.String sendMessage( //NOSONAR  Reason:EIAS

			it.csi.fpcommon.fpsend.dto.fpsend.RequestMessage requestMessage //NOSONAR  Reason:EIAS

			, it.csi.csi.util.DatiMessaggio datiMsg //NOSONAR  Reason:EIAS
	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R219053392) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo sendMessages.
	 * Descrivere dettagliatamente:
	 * <ul>
	 * <li>la semantica del metodo (facendo riferimento ai parametri). E' importante 
	 *     elencare casi particolari (dati non trovati, ecc...)
	 * <li> i singoli parametri (nelle sezioni apposite sottostanti): &egrave; importante
	 *      indicare:
	 *      <ul>
	 *      <li>se il parametro &egrave; obbligatorio
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      </ul>
	 * <li> le eccezioni rilanciate (nelle sezioni apposite sottostanti)
	 * <li> il tipo di ritorno
	 * </ul>
	 * @param requestMessages [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	 	
	 * @return java.lang.String
	 * @throws SendMessageException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.String sendMessages( //NOSONAR  Reason:EIAS

			it.csi.fpcommon.fpsend.dto.fpsend.RequestMessages requestMessages //NOSONAR  Reason:EIAS

			, it.csi.csi.util.DatiMessaggio datiMsg //NOSONAR  Reason:EIAS
	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R44286602) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo sendPec.
	 * Descrivere dettagliatamente:
	 * <ul>
	 * <li>la semantica del metodo (facendo riferimento ai parametri). E' importante 
	 *     elencare casi particolari (dati non trovati, ecc...)
	 * <li> i singoli parametri (nelle sezioni apposite sottostanti): &egrave; importante
	 *      indicare:
	 *      <ul>
	 *      <li>se il parametro &egrave; obbligatorio
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      </ul>
	 * <li> le eccezioni rilanciate (nelle sezioni apposite sottostanti)
	 * <li> il tipo di ritorno
	 * </ul>
	 * @param requestMessage [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	 	
	 * @return it.csi.fpcommon.fpsend.dto.fpsend.ResponseMessage
	 * @throws SendMessageException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.fpcommon.fpsend.dto.fpsend.ResponseMessage sendPec( //NOSONAR  Reason:EIAS

			it.csi.fpcommon.fpsend.dto.fpsend.RequestMessage requestMessage //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1047661097) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo recuperaPec.
	 * Descrivere dettagliatamente:
	 * <ul>
	 * <li>la semantica del metodo (facendo riferimento ai parametri). E' importante 
	 *     elencare casi particolari (dati non trovati, ecc...)
	 * <li> i singoli parametri (nelle sezioni apposite sottostanti): &egrave; importante
	 *      indicare:
	 *      <ul>
	 *      <li>se il parametro &egrave; obbligatorio
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      </ul>
	 * <li> le eccezioni rilanciate (nelle sezioni apposite sottostanti)
	 * <li> il tipo di ritorno
	 * </ul>
	 * @param request [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	 	
	 * @return it.csi.fpcommon.fpsend.dto.fpsend.ResponseRecuperaPec
	 * @throws RecuperaPecException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.fpcommon.fpsend.dto.fpsend.ResponseRecuperaPec recuperaPec( //NOSONAR  Reason:EIAS

			it.csi.fpcommon.fpsend.dto.fpsend.RequestRecuperaPec request //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.fpcommon.fpsend.exception.fpsend.RecuperaPecException; //NOSONAR  Reason:EIAS

	/**
	 * @generated
	 */
	public boolean testResources() throws it.csi.csi.wrapper.CSIException; //NOSONAR  Reason:EIAS

	/**
	 * @generated
	 */
	public it.csi.coopdiag.api.InvocationNode selfCheck( //NOSONAR  Reason:EIAS 
			it.csi.coopdiag.api.CalledResource[] alreadyChecked) //NOSONAR  Reason:EIAS
			throws it.csi.csi.wrapper.CSIException; //NOSONAR  Reason:EIAS

	/**
	 * @generated
	 */
	public boolean hasSelfCheck() throws it.csi.csi.wrapper.CSIException; //NOSONAR  Reason:EIAS

}
