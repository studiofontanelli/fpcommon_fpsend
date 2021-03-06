package it.csi.fpcommon.fpsend.dto.fpsend;

////{PROTECTED REGION ID(R-433085943) ENABLED START////}
/**
 * Inserire qui la documentazione della classe ResponseVerificaEsitoInvioPec.
 * Consigli:
 * <ul>
 * <li> Descrivere il "concetto" rappresentato dall'entita' (qual'&egrave; l'oggetto
 *      del dominio del servizio rappresentato)
 * <li> Se necessario indicare se questo concetto &egrave; mantenuto sugli archivi di
 *      una particolare applicazione
 * <li> Se l'oggetto ha un particolare ciclo di vita (stati, es. creato, da approvare, 
 *      approvato, respinto, annullato.....) si pu&ograve; decidere di descrivere
 *      la state machine qui o nella documentazione dell'interfaccia del servizio
 *      che manipola quest'oggetto
 * </ul>
 * @generated
 */
////{PROTECTED REGION END////}
public class ResponseVerificaEsitoInvioPec implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.String messageId = null;

	/**
	 * Imposta il valore della property [messageId]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setMessageId(java.lang.String val) {
		messageId = val;
	}

	////{PROTECTED REGION ID(R1493613465) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo messageId. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public java.lang.String getMessageId() {
		return messageId;
	}

	/**
	 * @generated
	 */
	private java.lang.String esito = null;

	/**
	 * Imposta il valore della property [esito]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setEsito(java.lang.String val) {
		esito = val;
	}

	////{PROTECTED REGION ID(R627466445) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo esito. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public java.lang.String getEsito() {
		return esito;
	}

	/*PROTECTED REGION ID(R-801874445) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
