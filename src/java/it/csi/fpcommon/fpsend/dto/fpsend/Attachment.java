package it.csi.fpcommon.fpsend.dto.fpsend;

////{PROTECTED REGION ID(R432467103) ENABLED START////}
/**
 * Inserire qui la documentazione della classe Attachment.
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
public class Attachment implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.String name = null;

	/**
	 * Imposta il valore della property [name]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setName(java.lang.String val) {
		name = val;
	}

	////{PROTECTED REGION ID(R-849018966) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo name. 
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
	public java.lang.String getName() {
		return name;
	}

	/**
	 * @generated
	 */
	private byte[] attachment = null;

	/**
	 * Imposta il valore della property [attachment]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setAttachment(byte[] val) {
		if (val == null) {
			attachment = null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			attachment = new byte[val.length];
			for (int i = 0; i < val.length; i++) { //NOSONAR  Reason:NOTINJ13
				attachment[i] = val[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
		}
	}

	////{PROTECTED REGION ID(R-200127742) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo attachment. 
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
	public byte[] getAttachment() {
		if (attachment == null) {
			return null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			byte[] copy = new byte[attachment.length];
			for (int i = 0; i < attachment.length; i++) { //NOSONAR  Reason:NOTINJ13
				copy[i] = attachment[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
			return copy;
		}
	}

	/*PROTECTED REGION ID(R-1622538895) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
