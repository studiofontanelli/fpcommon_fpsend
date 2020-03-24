package it.csi.fpcommon.fpsend.business.dao.fpsend.dto;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SendTRichiestaDao.
 * @generated
 */
public class SendTRichiestaDto extends SendTRichiestaPk {

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
	 * store della proprieta' associata alla colonna ID_STATO_RICHIESTA
	 * @generated
	 */
	protected Integer idStatoRichiesta;

	/**
	 * Imposta il valore della proprieta' idStatoRichiesta associata alla
	 * colonna ID_STATO_RICHIESTA.
	 * @generated
	 */
	public void setIdStatoRichiesta(Integer val) {

		idStatoRichiesta = val;

	}

	/**
	 * Legge il valore della proprieta' idStatoRichiesta associata alla
	 * @generated
	 */
	public Integer getIdStatoRichiesta() {

		return idStatoRichiesta;

	}

	/**
	 * store della proprieta' associata alla colonna ID_JMS_RICHIESTA
	 * @generated
	 */
	protected String idJmsRichiesta;

	/**
	 * Imposta il valore della proprieta' idJmsRichiesta associata alla
	 * colonna ID_JMS_RICHIESTA.
	 * @generated
	 */
	public void setIdJmsRichiesta(String val) {

		idJmsRichiesta = val;

	}

	/**
	 * Legge il valore della proprieta' idJmsRichiesta associata alla
	 * @generated
	 */
	public String getIdJmsRichiesta() {

		return idJmsRichiesta;

	}

	/**
	 * Crea una istanza di SendTRichiestaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SendTRichiestaPk
	 * @generated
	 */
	public SendTRichiestaPk createPk() {
		return new SendTRichiestaPk(idRichiesta);
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
