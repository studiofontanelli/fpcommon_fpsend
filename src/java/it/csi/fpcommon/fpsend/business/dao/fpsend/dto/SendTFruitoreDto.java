package it.csi.fpcommon.fpsend.business.dao.fpsend.dto;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SendTFruitoreDao.
 * @generated
 */
public class SendTFruitoreDto extends SendTFruitorePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna COD_FRUITORE
	 * @generated
	 */
	protected String codFruitore;

	/**
	 * Imposta il valore della proprieta' codFruitore associata alla
	 * colonna COD_FRUITORE.
	 * @generated
	 */
	public void setCodFruitore(String val) {

		codFruitore = val;

	}

	/**
	 * Legge il valore della proprieta' codFruitore associata alla
	 * @generated
	 */
	public String getCodFruitore() {

		return codFruitore;

	}

	/**
	 * store della proprieta' associata alla colonna DESCR_FRUITORE
	 * @generated
	 */
	protected String descrFruitore;

	/**
	 * Imposta il valore della proprieta' descrFruitore associata alla
	 * colonna DESCR_FRUITORE.
	 * @generated
	 */
	public void setDescrFruitore(String val) {

		descrFruitore = val;

	}

	/**
	 * Legge il valore della proprieta' descrFruitore associata alla
	 * @generated
	 */
	public String getDescrFruitore() {

		return descrFruitore;

	}

	/**
	 * Crea una istanza di SendTFruitorePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SendTFruitorePk
	 * @generated
	 */
	public SendTFruitorePk createPk() {
		return new SendTFruitorePk(idFruitore);
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
