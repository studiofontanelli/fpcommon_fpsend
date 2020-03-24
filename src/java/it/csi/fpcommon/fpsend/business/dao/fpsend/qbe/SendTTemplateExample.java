package it.csi.fpcommon.fpsend.business.dao.fpsend.qbe;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.*;
import it.csi.fpcommon.fpsend.business.dao.qbe.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SendTTemplateDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SendTTemplateExample extends AbstractExample {

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
	private it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk oggettoTemplate;

	/**
	 * @generated
	 */
	public void setOggettoTemplate(
			it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk chk) {
		oggettoTemplate = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk getOggettoTemplate() {
		return oggettoTemplate;
	}

	/**
	 * @generated
	 */
	private it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk codTemplate;

	/**
	 * @generated
	 */
	public void setCodTemplate(
			it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk chk) {
		codTemplate = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk getCodTemplate() {
		return codTemplate;
	}

	/**
	 * @generated
	 */
	private it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk descrTemplate;

	/**
	 * @generated
	 */
	public void setDescrTemplate(
			it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk chk) {
		descrTemplate = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk getDescrTemplate() {
		return descrTemplate;
	}

	/**
	 * @generated
	 */
	private it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk testoTemplate;

	/**
	 * @generated
	 */
	public void setTestoTemplate(
			it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk chk) {
		testoTemplate = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.business.dao.qbe.FieldChk getTestoTemplate() {
		return testoTemplate;
	}

}
