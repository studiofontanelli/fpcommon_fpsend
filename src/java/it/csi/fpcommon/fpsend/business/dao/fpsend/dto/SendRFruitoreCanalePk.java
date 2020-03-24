package it.csi.fpcommon.fpsend.business.dao.fpsend.dto;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SendRFruitoreCanaleDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SendRFruitoreCanalePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_FRUITORE
	 * @generated
	 */
	protected java.math.BigDecimal idFruitore;

	/**
	 * Imposta il valore della proprieta' idFruitore associata alla
	 * colonna ID_FRUITORE.
	 * @generated
	 */
	public void setIdFruitore(java.math.BigDecimal val) {

		idFruitore = val;

	}

	/**
	 * Legge il valore della proprieta' idFruitore associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdFruitore() {

		return idFruitore;

	}

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_CANALE
	 * @generated
	 */
	protected Integer idTipoCanale;

	/**
	 * Imposta il valore della proprieta' idTipoCanale associata alla
	 * colonna ID_TIPO_CANALE.
	 * @generated
	 */
	public void setIdTipoCanale(Integer val) {

		idTipoCanale = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoCanale associata alla
	 * @generated
	 */
	public Integer getIdTipoCanale() {

		return idTipoCanale;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_INIZIO_VAL
	 * @generated
	 */
	protected java.sql.Date dataInizioVal;

	/**
	 * Imposta il valore della proprieta' dataInizioVal associata alla
	 * colonna DATA_INIZIO_VAL.
	 * @generated
	 */
	public void setDataInizioVal(java.sql.Date val) {

		if (val != null) {
			dataInizioVal = new java.sql.Date(val.getTime());
		} else {
			dataInizioVal = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataInizioVal associata alla
	 * @generated
	 */
	public java.sql.Date getDataInizioVal() {

		if (dataInizioVal != null) {
			return new java.sql.Date(dataInizioVal.getTime());
		} else {
			return null;
		}

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SendRFruitoreCanalePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SendRFruitoreCanalePk(

	final java.math.BigDecimal idFruitore, final Integer idTipoCanale,
			final java.sql.Date dataInizioVal

	) {

		this.setIdFruitore(idFruitore);

		this.setIdTipoCanale(idTipoCanale);

		this.setDataInizioVal(dataInizioVal);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SendRFruitoreCanalePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SendRFruitoreCanalePk)) {
			return false;
		}

		final SendRFruitoreCanalePk _cast = (SendRFruitoreCanalePk) _other;

		if (idFruitore == null ? _cast.getIdFruitore() != null : !idFruitore
				.equals(_cast.getIdFruitore())) {
			return false;
		}

		if (idTipoCanale == null
				? _cast.getIdTipoCanale() != null
				: !idTipoCanale.equals(_cast.getIdTipoCanale())) {
			return false;
		}

		if (dataInizioVal == null
				? _cast.getDataInizioVal() != null
				: !dataInizioVal.equals(_cast.getDataInizioVal())) {
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

		if (idFruitore != null) {
			_hashCode = 29 * _hashCode + idFruitore.hashCode();
		}

		if (idTipoCanale != null) {
			_hashCode = 29 * _hashCode + idTipoCanale.hashCode();
		}

		if (dataInizioVal != null) {
			_hashCode = 29 * _hashCode + dataInizioVal.hashCode();
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

		ret.append("it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendRFruitoreCanalePk: ");
		ret.append("idFruitore=" + idFruitore);

		ret.append("it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendRFruitoreCanalePk: ");
		ret.append("idTipoCanale=" + idTipoCanale);

		ret.append("it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendRFruitoreCanalePk: ");
		ret.append("dataInizioVal=" + dataInizioVal);

		return ret.toString();
	}
}
