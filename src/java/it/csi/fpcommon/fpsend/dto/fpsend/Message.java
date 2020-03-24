package it.csi.fpcommon.fpsend.dto.fpsend;

////{PROTECTED REGION ID(R683965963) ENABLED START////}
/**
 * Inserire qui la documentazione della classe Message.
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
public class Message implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private it.csi.fpcommon.fpsend.dto.fpsend.Template template = null;

	/**
	 * Imposta il valore della property [template]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setTemplate(it.csi.fpcommon.fpsend.dto.fpsend.Template val) {
		template = val;
	}

	////{PROTECTED REGION ID(R-476967035) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo template. 
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
	public it.csi.fpcommon.fpsend.dto.fpsend.Template getTemplate() {
		return template;
	}

	/**
	 * @generated
	 */
	private java.lang.String channel = null;

	/**
	 * Imposta il valore della property [channel]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setChannel(java.lang.String val) {
		channel = val;
	}

	////{PROTECTED REGION ID(R-1450562408) ENABLED START////}
	
	
	public int getPk() {
		return hashCode();
	}
	
	
	/**
	 * Inserire qui la documentazione dell'attributo channel. 
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
	public java.lang.String getChannel() {
		return channel;
	}

	/**
	 * @generated
	 */
	private java.lang.String callerInternalCode = null;

	/**
	 * Imposta il valore della property [callerInternalCode]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCallerInternalCode(java.lang.String val) {
		callerInternalCode = val;
	}

	////{PROTECTED REGION ID(R-1326565696) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo callerInternalCode. 
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
	public java.lang.String getCallerInternalCode() {
		return callerInternalCode;
	}

	/**
	 * @generated
	 */
	private java.lang.String sender = null;

	/**
	 * Imposta il valore della property [sender]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setSender(java.lang.String val) {
		sender = val;
	}

	////{PROTECTED REGION ID(R-422403072) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo sender. 
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
	public java.lang.String getSender() {
		return sender;
	}

	/**
	 * @generated
	 */
	private java.lang.String recipient = null;

	/**
	 * Imposta il valore della property [recipient]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setRecipient(java.lang.String val) {
		recipient = val;
	}

	////{PROTECTED REGION ID(R1232244846) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo recipient. 
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
	public java.lang.String getRecipient() {
		return recipient;
	}

	/**
	 * @generated
	 */
	private java.lang.String[] recipients = null;

	/**
	 * Imposta il valore della property [recipients]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setRecipients(java.lang.String[] val) {
		if (val == null) {
			recipients = null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			recipients = new java.lang.String[val.length];
			for (int i = 0; i < val.length; i++) { //NOSONAR  Reason:NOTINJ13
				recipients[i] = val[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
		}
	}

	////{PROTECTED REGION ID(R-455115323) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo recipients. 
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
	public java.lang.String[] getRecipients() {
		if (recipients == null) {
			return null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			java.lang.String[] copy = new java.lang.String[recipients.length];
			for (int i = 0; i < recipients.length; i++) { //NOSONAR  Reason:NOTINJ13
				copy[i] = recipients[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
			return copy;
		}
	}

	/**
	 * @generated
	 */
	private java.lang.String body = null;

	/**
	 * Imposta il valore della property [body]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setBody(java.lang.String val) {
		body = val;
	}

	////{PROTECTED REGION ID(R387889709) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo body. 
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
	public java.lang.String getBody() {
		return body;
	}

	/**
	 * @generated
	 */
	private java.lang.String subject = null;

	/**
	 * Imposta il valore della property [subject]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setSubject(java.lang.String val) {
		subject = val;
	}

	////{PROTECTED REGION ID(R237569217) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo subject. 
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
	public java.lang.String getSubject() {
		return subject;
	}

	/**
	 * @generated
	 */
	private it.csi.fpcommon.fpsend.dto.fpsend.Attachment attachment = null;

	/**
	 * Imposta il valore della property [attachment]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setAttachment(it.csi.fpcommon.fpsend.dto.fpsend.Attachment val) {
		attachment = val;
	}

	////{PROTECTED REGION ID(R-2071329426) ENABLED START////}
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
	public it.csi.fpcommon.fpsend.dto.fpsend.Attachment getAttachment() {
		return attachment;
	}

	/*PROTECTED REGION ID(R543345457) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
