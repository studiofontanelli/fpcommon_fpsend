package it.csi.fpcommon.fpsend.business.dao.fpsend.dto;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SendTFruitoreDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SendTFruitorePk implements Serializable {

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
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SendTFruitorePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SendTFruitorePk(

	final java.math.BigDecimal idFruitore

	) {

		this.setIdFruitore(idFruitore);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SendTFruitorePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SendTFruitorePk)) {
			return false;
		}

		final SendTFruitorePk _cast = (SendTFruitorePk) _other;

		if (idFruitore == null ? _cast.getIdFruitore() != null : !idFruitore
				.equals(_cast.getIdFruitore())) {
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

		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString() {
		StringBuilder ret = new StringBuilder();

		ret.append("it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendTFruitorePk: ");
		ret.append("idFruitore=" + idFruitore);

		return ret.toString();
	}
}
