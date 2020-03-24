package it.csi.fpcommon.fpsend.dto.fpsend;

////{PROTECTED REGION ID(R-1131344138) ENABLED START////}
/**
 * Inserire qui la documentazione della classe Template.
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
public class Template implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.String code = null;

	/**
	 * Imposta il valore della property [code]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCode(java.lang.String val) {
		code = val;
	}

	////{PROTECTED REGION ID(R-552381981) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo code. 
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
	public java.lang.String getCode() {
		return code;
	}

	/**
	 * @generated
	 */
	private it.csi.fpcommon.fpsend.dto.fpsend.PlaceHolder[] placeHolders = null;

	/**
	 * Imposta il valore della property [placeHolders]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPlaceHolders(
			it.csi.fpcommon.fpsend.dto.fpsend.PlaceHolder[] val) {
		if (val == null) {
			placeHolders = null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			placeHolders = new it.csi.fpcommon.fpsend.dto.fpsend.PlaceHolder[val.length];
			for (int i = 0; i < val.length; i++) { //NOSONAR  Reason:NOTINJ13
				placeHolders[i] = val[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
		}
	}

	////{PROTECTED REGION ID(R2079657782) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo placeHolders. 
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
	public it.csi.fpcommon.fpsend.dto.fpsend.PlaceHolder[] getPlaceHolders() {
		if (placeHolders == null) {
			return null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			it.csi.fpcommon.fpsend.dto.fpsend.PlaceHolder[] copy = new it.csi.fpcommon.fpsend.dto.fpsend.PlaceHolder[placeHolders.length];
			for (int i = 0; i < placeHolders.length; i++) { //NOSONAR  Reason:NOTINJ13
				copy[i] = placeHolders[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
			return copy;
		}
	}

	/*PROTECTED REGION ID(R945662010) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
