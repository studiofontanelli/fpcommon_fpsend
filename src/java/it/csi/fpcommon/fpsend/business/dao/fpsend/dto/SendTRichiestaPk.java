package it.csi.fpcommon.fpsend.business.dao.fpsend.dto;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SendTRichiestaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SendTRichiestaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_RICHIESTA
	 * @generated
	 */
	protected Integer idRichiesta;

	/**
	 * Imposta il valore della proprieta' idRichiesta associata alla
	 * colonna ID_RICHIESTA.
	 * @generated
	 */
	public void setIdRichiesta(Integer val) {

		idRichiesta = val;

	}

	/**
	 * Legge il valore della proprieta' idRichiesta associata alla
	 * @generated
	 */
	public Integer getIdRichiesta() {

		return idRichiesta;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SendTRichiestaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SendTRichiestaPk(

	final Integer idRichiesta

	) {

		this.setIdRichiesta(idRichiesta);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SendTRichiestaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SendTRichiestaPk)) {
			return false;
		}

		final SendTRichiestaPk _cast = (SendTRichiestaPk) _other;

		if (idRichiesta == null ? _cast.getIdRichiesta() != null : !idRichiesta
				.equals(_cast.getIdRichiesta())) {
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

		if (idRichiesta != null) {
			_hashCode = 29 * _hashCode + idRichiesta.hashCode();
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

		ret.append("it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendTRichiestaPk: ");
		ret.append("idRichiesta=" + idRichiesta);

		return ret.toString();
	}
}
