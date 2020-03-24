package it.csi.fpcommon.fpsend.business.dao.fpsend.qbe;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.*;
import it.csi.fpcommon.fpsend.business.dao.qbe.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SendDTipoCanaleDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SendDTipoCanaleExample extends AbstractExample {

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
	private it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk codTipoCanale;

	/**
	 * @generated
	 */
	public void setCodTipoCanale(
			it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk chk) {
		codTipoCanale = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk getCodTipoCanale() {
		return codTipoCanale;
	}

	/**
	 * @generated
	 */
	private it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk descrTipoCanale;

	/**
	 * @generated
	 */
	public void setDescrTipoCanale(
			it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk chk) {
		descrTipoCanale = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk getDescrTipoCanale() {
		return descrTipoCanale;
	}

}
