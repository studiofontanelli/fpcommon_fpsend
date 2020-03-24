package it.csi.fpcommon.fpsend.business.dao.fpsend.qbe;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.*;
import it.csi.fpcommon.fpsend.business.dao.qbe.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SendTMessaggioDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SendTMessaggioExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk idMessaggio;

	/**
	 * @generated
	 */
	public void setIdMessaggio(
			it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk chk) {
		idMessaggio = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk getIdMessaggio() {
		return idMessaggio;
	}

	/**
	 * @generated
	 */
	private it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk idRichiesta;

	/**
	 * @generated
	 */
	public void setIdRichiesta(
			it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk chk) {
		idRichiesta = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk getIdRichiesta() {
		return idRichiesta;
	}

	/**
	 * @generated
	 */
	private it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk identMessaggioFruitore;

	/**
	 * @generated
	 */
	public void setIdentMessaggioFruitore(
			it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk chk) {
		identMessaggioFruitore = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk getIdentMessaggioFruitore() {
		return identMessaggioFruitore;
	}

	/**
	 * @generated
	 */
	private it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk idTipoCanale;

	/**
	 * @generated
	 */
	public void setIdTipoCanale(
			it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk chk) {
		idTipoCanale = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk getIdTipoCanale() {
		return idTipoCanale;
	}

	/**
	 * @generated
	 */
	private it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk idTemplate;

	/**
	 * @generated
	 */
	public void setIdTemplate(
			it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk chk) {
		idTemplate = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk getIdTemplate() {
		return idTemplate;
	}

	/**
	 * @generated
	 */
	private it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk idStatoMessaggio;

	/**
	 * @generated
	 */
	public void setIdStatoMessaggio(
			it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk chk) {
		idStatoMessaggio = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk getIdStatoMessaggio() {
		return idStatoMessaggio;
	}

	/**
	 * @generated
	 */
	private it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk dataInserimento;

	/**
	 * @generated
	 */
	public void setDataInserimento(
			it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk chk) {
		dataInserimento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk getDataInserimento() {
		return dataInserimento;
	}

	/**
	 * @generated
	 */
	private it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk dataAggiornamento;

	/**
	 * @generated
	 */
	public void setDataAggiornamento(
			it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk chk) {
		dataAggiornamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk getDataAggiornamento() {
		return dataAggiornamento;
	}

	/**
	 * @generated
	 */
	private it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk idJmsMessaggio;

	/**
	 * @generated
	 */
	public void setIdJmsMessaggio(
			it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk chk) {
		idJmsMessaggio = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk getIdJmsMessaggio() {
		return idJmsMessaggio;
	}

}
