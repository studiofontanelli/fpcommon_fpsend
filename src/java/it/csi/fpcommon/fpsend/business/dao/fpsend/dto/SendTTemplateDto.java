package it.csi.fpcommon.fpsend.business.dao.fpsend.dto;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SendTTemplateDao.
 * @generated
 */
public class SendTTemplateDto extends SendTTemplatePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna OGGETTO_TEMPLATE
	 * @generated
	 */
	protected String oggettoTemplate;

	/**
	 * Imposta il valore della proprieta' oggettoTemplate associata alla
	 * colonna OGGETTO_TEMPLATE.
	 * @generated
	 */
	public void setOggettoTemplate(String val) {

		oggettoTemplate = val;

	}

	/**
	 * Legge il valore della proprieta' oggettoTemplate associata alla
	 * @generated
	 */
	public String getOggettoTemplate() {

		return oggettoTemplate;

	}

	/**
	 * store della proprieta' associata alla colonna COD_TEMPLATE
	 * @generated
	 */
	protected String codTemplate;

	/**
	 * Imposta il valore della proprieta' codTemplate associata alla
	 * colonna COD_TEMPLATE.
	 * @generated
	 */
	public void setCodTemplate(String val) {

		codTemplate = val;

	}

	/**
	 * Legge il valore della proprieta' codTemplate associata alla
	 * @generated
	 */
	public String getCodTemplate() {

		return codTemplate;

	}

	/**
	 * store della proprieta' associata alla colonna DESCR_TEMPLATE
	 * @generated
	 */
	protected String descrTemplate;

	/**
	 * Imposta il valore della proprieta' descrTemplate associata alla
	 * colonna DESCR_TEMPLATE.
	 * @generated
	 */
	public void setDescrTemplate(String val) {

		descrTemplate = val;

	}

	/**
	 * Legge il valore della proprieta' descrTemplate associata alla
	 * @generated
	 */
	public String getDescrTemplate() {

		return descrTemplate;

	}

	/**
	 * store della proprieta' associata alla colonna TESTO_TEMPLATE
	 * @generated
	 */
	protected String testoTemplate;

	/**
	 * Imposta il valore della proprieta' testoTemplate associata alla
	 * colonna TESTO_TEMPLATE.
	 * @generated
	 */
	public void setTestoTemplate(String val) {

		testoTemplate = val;

	}

	/**
	 * Legge il valore della proprieta' testoTemplate associata alla
	 * @generated
	 */
	public String getTestoTemplate() {

		return testoTemplate;

	}

	/**
	 * Crea una istanza di SendTTemplatePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SendTTemplatePk
	 * @generated
	 */
	public SendTTemplatePk createPk() {
		return new SendTTemplatePk(idTemplate);
	}

	/**
	 * la semantica dell'equals del DTO e' la stessa della PK
	 * (ovvero della superclasse).
	 * @param other l'oggetto con cui effettuare il confronto
	 * @return true se i due oggetti sono semanticamente da considerarsi uguali
	 */
	public boolean equals(Object other) {
		return super.equals(other);
	}

	/**
	 * la semantica dell'hashCode del DTO e' la stessa della PK
	 * (ovvero della superclasse).
	 * 
	 * @return int
	 */
	public int hashCode() {
		return super.hashCode();
	}

}
