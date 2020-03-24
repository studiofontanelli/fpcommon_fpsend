package it.csi.fpcommon.fpsend.business.dao.fpsend.qbe;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.*;
import it.csi.fpcommon.fpsend.business.dao.qbe.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SendTFruitoreDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SendTFruitoreExample extends AbstractExample {

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
	private it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk codFruitore;

	/**
	 * @generated
	 */
	public void setCodFruitore(
			it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk chk) {
		codFruitore = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk getCodFruitore() {
		return codFruitore;
	}

	/**
	 * @generated
	 */
	private it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk descrFruitore;

	/**
	 * @generated
	 */
	public void setDescrFruitore(
			it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk chk) {
		descrFruitore = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk getDescrFruitore() {
		return descrFruitore;
	}

}
