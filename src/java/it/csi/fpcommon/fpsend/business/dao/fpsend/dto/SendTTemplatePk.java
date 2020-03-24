package it.csi.fpcommon.fpsend.business.dao.fpsend.dto;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SendTTemplateDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SendTTemplatePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TEMPLATE
	 * @generated
	 */
	protected java.math.BigDecimal idTemplate;

	/**
	 * Imposta il valore della proprieta' idTemplate associata alla
	 * colonna ID_TEMPLATE.
	 * @generated
	 */
	public void setIdTemplate(java.math.BigDecimal val) {

		idTemplate = val;

	}

	/**
	 * Legge il valore della proprieta' idTemplate associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdTemplate() {

		return idTemplate;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SendTTemplatePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SendTTemplatePk(

	final java.math.BigDecimal idTemplate

	) {

		this.setIdTemplate(idTemplate);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SendTTemplatePk sono equals se i valori di tutti i campi coincidono.
	 * 
	 * @param _other
	 * @return boolean se i due oggetti sono uguali
	 */
	public boolean equals(Object _other) {
		if (_other == null) {
			return false;
		}

		if (_other == this) {
			return true;
		}

		if (!(_other instanceof SendTTemplatePk)) {
			return false;
		}

		final SendTTemplatePk _cast = (SendTTemplatePk) _other;

		if (idTemplate == null ? _cast.getIdTemplate() != null : !idTemplate
				.equals(_cast.getIdTemplate())) {
			return false;
		}

		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode() {
		int _hashCode = 0;

		if (idTemplate != null) {
			_hashCode = 29 * _hashCode + idTemplate.hashCode();
		}

		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString() {
		StringBuilder ret = new StringBuilder();

		ret.append("it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendTTemplatePk: ");
		ret.append("idTemplate=" + idTemplate);

		return ret.toString();
	}
}
