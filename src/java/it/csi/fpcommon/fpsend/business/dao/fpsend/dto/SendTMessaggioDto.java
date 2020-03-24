package it.csi.fpcommon.fpsend.business.dao.fpsend.dto;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SendTMessaggioDao.
 * @generated
 */
public class SendTMessaggioDto extends SendTMessaggioPk {

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
	 * store della proprieta' associata alla colonna IDENT_MESSAGGIO_FRUITORE
	 * @generated
	 */
	protected String identMessaggioFruitore;

	/**
	 * Imposta il valore della proprieta' identMessaggioFruitore associata alla
	 * colonna IDENT_MESSAGGIO_FRUITORE.
	 * @generated
	 */
	public void setIdentMessaggioFruitore(String val) {

		identMessaggioFruitore = val;

	}

	/**
	 * Legge il valore della proprieta' identMessaggioFruitore associata alla
	 * @generated
	 */
	public String getIdentMessaggioFruitore() {

		return identMessaggioFruitore;

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
	 * store della proprieta' associata alla colonna ID_STATO_MESSAGGIO
	 * @generated
	 */
	protected Integer idStatoMessaggio;

	/**
	 * Imposta il valore della proprieta' idStatoMessaggio associata alla
	 * colonna ID_STATO_MESSAGGIO.
	 * @generated
	 */
	public void setIdStatoMessaggio(Integer val) {

		idStatoMessaggio = val;

	}

	/**
	 * Legge il valore della proprieta' idStatoMessaggio associata alla
	 * @generated
	 */
	public Integer getIdStatoMessaggio() {

		return idStatoMessaggio;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_INSERIMENTO
	 * @generated
	 */
	protected java.sql.Timestamp dataInserimento;

	/**
	 * Imposta il valore della proprieta' dataInserimento associata alla
	 * colonna DATA_INSERIMENTO.
	 * @generated
	 */
	public void setDataInserimento(java.sql.Timestamp val) {

		if (val != null) {
			dataInserimento = new java.sql.Timestamp(val.getTime());
		} else {
			dataInserimento = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataInserimento associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataInserimento() {

		if (dataInserimento != null) {
			return new java.sql.Timestamp(dataInserimento.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DATA_AGGIORNAMENTO
	 * @generated
	 */
	protected java.sql.Timestamp dataAggiornamento;

	/**
	 * Imposta il valore della proprieta' dataAggiornamento associata alla
	 * colonna DATA_AGGIORNAMENTO.
	 * @generated
	 */
	public void setDataAggiornamento(java.sql.Timestamp val) {

		if (val != null) {
			dataAggiornamento = new java.sql.Timestamp(val.getTime());
		} else {
			dataAggiornamento = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataAggiornamento associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataAggiornamento() {

		if (dataAggiornamento != null) {
			return new java.sql.Timestamp(dataAggiornamento.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna ID_JMS_MESSAGGIO
	 * @generated
	 */
	protected Integer idJmsMessaggio;

	/**
	 * Imposta il valore della proprieta' idJmsMessaggio associata alla
	 * colonna ID_JMS_MESSAGGIO.
	 * @generated
	 */
	public void setIdJmsMessaggio(Integer val) {

		idJmsMessaggio = val;

	}

	/**
	 * Legge il valore della proprieta' idJmsMessaggio associata alla
	 * @generated
	 */
	public Integer getIdJmsMessaggio() {

		return idJmsMessaggio;

	}

	/**
	 * Crea una istanza di SendTMessaggioPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SendTMessaggioPk
	 * @generated
	 */
	public SendTMessaggioPk createPk() {
		return new SendTMessaggioPk(idMessaggio);
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
