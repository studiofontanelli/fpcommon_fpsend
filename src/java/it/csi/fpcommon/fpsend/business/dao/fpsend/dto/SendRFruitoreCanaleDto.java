package it.csi.fpcommon.fpsend.business.dao.fpsend.dto;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SendRFruitoreCanaleDao.
 * @generated
 */
public class SendRFruitoreCanaleDto extends SendRFruitoreCanalePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DATA_FINE_VAL
	 * @generated
	 */
	protected java.sql.Date dataFineVal;

	/**
	 * Imposta il valore della proprieta' dataFineVal associata alla
	 * colonna DATA_FINE_VAL.
	 * @generated
	 */
	public void setDataFineVal(java.sql.Date val) {

		if (val != null) {
			dataFineVal = new java.sql.Date(val.getTime());
		} else {
			dataFineVal = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataFineVal associata alla
	 * @generated
	 */
	public java.sql.Date getDataFineVal() {

		if (dataFineVal != null) {
			return new java.sql.Date(dataFineVal.getTime());
		} else {
			return null;
		}

	}

	/**
	 * Crea una istanza di SendRFruitoreCanalePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SendRFruitoreCanalePk
	 * @generated
	 */
	public SendRFruitoreCanalePk createPk() {
		return new SendRFruitoreCanalePk(idFruitore, idTipoCanale,
				dataInizioVal);
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
