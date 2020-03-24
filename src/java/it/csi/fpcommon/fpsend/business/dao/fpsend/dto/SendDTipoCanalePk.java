package it.csi.fpcommon.fpsend.business.dao.fpsend.dto;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SendDTipoCanaleDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SendDTipoCanalePk implements Serializable {

	private static final long serialVersionUID = 1L;

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
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SendDTipoCanalePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SendDTipoCanalePk(

	final Integer idTipoCanale

	) {

		this.setIdTipoCanale(idTipoCanale);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SendDTipoCanalePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SendDTipoCanalePk)) {
			return false;
		}

		final SendDTipoCanalePk _cast = (SendDTipoCanalePk) _other;

		if (idTipoCanale == null
				? _cast.getIdTipoCanale() != null
				: !idTipoCanale.equals(_cast.getIdTipoCanale())) {
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

		if (idTipoCanale != null) {
			_hashCode = 29 * _hashCode + idTipoCanale.hashCode();
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

		ret.append("it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendDTipoCanalePk: ");
		ret.append("idTipoCanale=" + idTipoCanale);

		return ret.toString();
	}
}
