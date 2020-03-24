package it.csi.fpcommon.fpsend.business.dao.fpsend.dto;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SendDTipoCanaleDao.
 * @generated
 */
public class SendDTipoCanaleDto extends SendDTipoCanalePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna COD_TIPO_CANALE
	 * @generated
	 */
	protected String codTipoCanale;

	/**
	 * Imposta il valore della proprieta' codTipoCanale associata alla
	 * colonna COD_TIPO_CANALE.
	 * @generated
	 */
	public void setCodTipoCanale(String val) {

		codTipoCanale = val;

	}

	/**
	 * Legge il valore della proprieta' codTipoCanale associata alla
	 * @generated
	 */
	public String getCodTipoCanale() {

		return codTipoCanale;

	}

	/**
	 * store della proprieta' associata alla colonna DESCR_TIPO_CANALE
	 * @generated
	 */
	protected String descrTipoCanale;

	/**
	 * Imposta il valore della proprieta' descrTipoCanale associata alla
	 * colonna DESCR_TIPO_CANALE.
	 * @generated
	 */
	public void setDescrTipoCanale(String val) {

		descrTipoCanale = val;

	}

	/**
	 * Legge il valore della proprieta' descrTipoCanale associata alla
	 * @generated
	 */
	public String getDescrTipoCanale() {

		return descrTipoCanale;

	}

	/**
	 * Crea una istanza di SendDTipoCanalePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SendDTipoCanalePk
	 * @generated
	 */
	public SendDTipoCanalePk createPk() {
		return new SendDTipoCanalePk(idTipoCanale);
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
