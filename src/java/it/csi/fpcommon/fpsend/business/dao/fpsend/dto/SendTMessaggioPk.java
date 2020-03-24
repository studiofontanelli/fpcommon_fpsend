package it.csi.fpcommon.fpsend.business.dao.fpsend.dto;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SendTMessaggioDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SendTMessaggioPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_MESSAGGIO
	 * @generated
	 */
	protected Integer idMessaggio;

	/**
	 * Imposta il valore della proprieta' idMessaggio associata alla
	 * colonna ID_MESSAGGIO.
	 * @generated
	 */
	public void setIdMessaggio(Integer val) {

		idMessaggio = val;

	}

	/**
	 * Legge il valore della proprieta' idMessaggio associata alla
	 * @generated
	 */
	public Integer getIdMessaggio() {

		return idMessaggio;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SendTMessaggioPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SendTMessaggioPk(

	final Integer idMessaggio

	) {

		this.setIdMessaggio(idMessaggio);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SendTMessaggioPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SendTMessaggioPk)) {
			return false;
		}

		final SendTMessaggioPk _cast = (SendTMessaggioPk) _other;

		if (idMessaggio == null ? _cast.getIdMessaggio() != null : !idMessaggio
				.equals(_cast.getIdMessaggio())) {
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

		if (idMessaggio != null) {
			_hashCode = 29 * _hashCode + idMessaggio.hashCode();
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

		ret.append("it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendTMessaggioPk: ");
		ret.append("idMessaggio=" + idMessaggio);

		return ret.toString();
	}
}
