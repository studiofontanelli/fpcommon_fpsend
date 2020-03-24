package it.csi.fpcommon.fpsend.business.dao.fpsend.metadata;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.*;
import it.csi.fpcommon.fpsend.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SendTTemplateMetadata extends DAOMetadata {

	/**
	 * contiene l'elenco dei nomi delle property del DTO associato al DAO a cui
	 * questi metadati fanno riferimento
	 */
	private final String[] propertyNames;

	/**
	 * contiene l'elenco dei nomi delle colonne della tabella associata al DAO a cui
	 * questi metadati fanno riferimento
	 */
	private final String[] columnNames;

	/**
	 * Contiene i metadati relativi a:
	 * DAO: [SendTTemplate]
	 * tabella: [SEND_T_TEMPLATE].
	 */
	public SendTTemplateMetadata() {
		columnNames = new String[]{"ID_TEMPLATE", "OGGETTO_TEMPLATE",
				"COD_TEMPLATE", "DESCR_TEMPLATE", "TESTO_TEMPLATE"};
		propertyNames = new String[]{"idTemplate", "oggettoTemplate",
				"codTemplate", "descrTemplate", "testoTemplate"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [SendTTemplate] fa riferimento
	 * (SEND_T_TEMPLATE).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SEND_T_TEMPLATE";
	}

	/**
	 * Method 'getColumnNames'
	 * Restutuisce l'insieme dei nomi delle colonne gestite dal DAO.
	 * @return String[]
	 * @generated
	 */
	public String[] getColumnNames() {
		String ris[] = new String[columnNames.length];
		System.arraycopy(columnNames, 0, ris, 0, columnNames.length);
		return ris;
	}

}
