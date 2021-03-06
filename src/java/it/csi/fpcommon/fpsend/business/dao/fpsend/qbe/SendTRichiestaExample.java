package it.csi.fpcommon.fpsend.business.dao.fpsend.qbe;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.*;
import it.csi.fpcommon.fpsend.business.dao.qbe.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SendTRichiestaDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SendTRichiestaExample extends AbstractExample {

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
	private it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk idFruitore;

	/**
	 * @generated
	 */
	public void setIdFruitore(
			it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk chk) {
		idFruitore = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk getIdFruitore() {
		return idFruitore;
	}

	/**
	 * @generated
	 */
	private it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk idStatoRichiesta;

	/**
	 * @generated
	 */
	public void setIdStatoRichiesta(
			it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk chk) {
		idStatoRichiesta = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk getIdStatoRichiesta() {
		return idStatoRichiesta;
	}

	/**
	 * @generated
	 */
	private it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk idJmsRichiesta;

	/**
	 * @generated
	 */
	public void setIdJmsRichiesta(
			it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk chk) {
		idJmsRichiesta = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk getIdJmsRichiesta() {
		return idJmsRichiesta;
	}

}
