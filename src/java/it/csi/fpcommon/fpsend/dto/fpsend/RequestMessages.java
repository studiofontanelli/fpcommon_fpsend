package it.csi.fpcommon.fpsend.dto.fpsend;

////{PROTECTED REGION ID(R-2058120449) ENABLED START////}
/**
 * Inserire qui la documentazione della classe RequestMessages.
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
public class RequestMessages implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private it.csi.fpcommon.fpsend.dto.fpsend.Message[] messages = null;

	/**
	 * Imposta il valore della property [messages]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setMessages(it.csi.fpcommon.fpsend.dto.fpsend.Message[] val) {
		if (val == null) {
			messages = null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			messages = new it.csi.fpcommon.fpsend.dto.fpsend.Message[val.length];
			for (int i = 0; i < val.length; i++) { //NOSONAR  Reason:NOTINJ13
				messages[i] = val[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
		}
	}

	////{PROTECTED REGION ID(R507585867) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo messages. 
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
	public it.csi.fpcommon.fpsend.dto.fpsend.Message[] getMessages() {
		if (messages == null) {
			return null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			it.csi.fpcommon.fpsend.dto.fpsend.Message[] copy = new it.csi.fpcommon.fpsend.dto.fpsend.Message[messages.length];
			for (int i = 0; i < messages.length; i++) { //NOSONAR  Reason:NOTINJ13
				copy[i] = messages[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
			return copy;
		}
	}

	/**
	 * @generated
	 */
	private java.lang.String caller = null;

	/**
	 * Imposta il valore della property [caller]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCaller(java.lang.String val) {
		caller = val;
	}

	////{PROTECTED REGION ID(R-1465090230) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo caller. 
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
	public java.lang.String getCaller() {
		return caller;
	}

	/*PROTECTED REGION ID(R2091496381) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
