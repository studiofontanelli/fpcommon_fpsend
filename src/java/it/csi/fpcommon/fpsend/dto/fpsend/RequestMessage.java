package it.csi.fpcommon.fpsend.dto.fpsend;

////{PROTECTED REGION ID(R2011818996) ENABLED START////}
/**
 * Inserire qui la documentazione della classe RequestMessage.
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
public class RequestMessage implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private it.csi.fpcommon.fpsend.dto.fpsend.Message message = null;

	/**
	 * Imposta il valore della property [message]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setMessage(it.csi.fpcommon.fpsend.dto.fpsend.Message val) {
		message = val;
	}

	////{PROTECTED REGION ID(R1873901971) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo message. 
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
	public it.csi.fpcommon.fpsend.dto.fpsend.Message getMessage() {
		return message;
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

	////{PROTECTED REGION ID(R-1753772929) ENABLED START////}
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

	/*PROTECTED REGION ID(R-1273209092) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
