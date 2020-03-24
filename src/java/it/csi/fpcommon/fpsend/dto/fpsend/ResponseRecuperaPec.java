package it.csi.fpcommon.fpsend.dto.fpsend;

////{PROTECTED REGION ID(R615153416) ENABLED START////}
/**
 * Inserire qui la documentazione della classe ResponseRecuperaPec.
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
public class ResponseRecuperaPec implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

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

	////{PROTECTED REGION ID(R7916334) ENABLED START////}
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

	/**
	 * @generated
	 */
	private byte[] file = null;

	/**
	 * Imposta il valore della property [file]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setFile(byte[] val) {
		if (val == null) {
			file = null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			file = new byte[val.length];
			for (int i = 0; i < val.length; i++) { //NOSONAR  Reason:NOTINJ13
				file[i] = val[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
		}
	}

	////{PROTECTED REGION ID(R-1108103036) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo file. 
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
	public byte[] getFile() {
		if (file == null) {
			return null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			byte[] copy = new byte[file.length];
			for (int i = 0; i < file.length; i++) { //NOSONAR  Reason:NOTINJ13
				copy[i] = file[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
			return copy;
		}
	}

	/**
	 * @generated
	 */
	private java.lang.String pecType = null;

	/**
	 * Imposta il valore della property [pecType]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPecType(java.lang.String val) {
		pecType = val;
	}

	////{PROTECTED REGION ID(R-217021088) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo pecType. 
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
	public java.lang.String getPecType() {
		return pecType;
	}

	/**
	 * @generated
	 */
	private java.util.Date dataConsegna = null;

	/**
	 * Imposta il valore della property [dataConsegna]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataConsegna(java.util.Date val) {
		dataConsegna = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R389637464) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataConsegna. 
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
	public java.util.Date getDataConsegna() {
		return (dataConsegna == null ? null : new java.util.Date(
				dataConsegna.getTime()));
	}

	/*PROTECTED REGION ID(R703800852) ENABLED START*/
	 
	public static final String MESSAGGIO_RICEVUTO = "MESSAGGIO_RICEVUTO";
	 public static final String MESSAGGIO_NON_RICEVUTO = "MESSAGGIO_NON_RICEVUTO";
	
	 /*PROTECTED REGION END*/
}
