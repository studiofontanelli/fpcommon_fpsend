package it.csi.fpcommon.fpsend.business.dao.fpsend.metadata;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.*;
import it.csi.fpcommon.fpsend.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SendRFruitoreCanaleMetadata extends DAOMetadata {

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
	 * DAO: [SendRFruitoreCanale]
	 * tabella: [SEND_R_FRUITORE_CANALE].
	 */
	public SendRFruitoreCanaleMetadata() {
		columnNames = new String[]{"ID_FRUITORE", "ID_TIPO_CANALE",
				"DATA_INIZIO_VAL", "DATA_FINE_VAL"};
		propertyNames = new String[]{"idFruitore", "idTipoCanale",
				"dataInizioVal", "dataFineVal"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [SendRFruitoreCanale] fa riferimento
	 * (SEND_R_FRUITORE_CANALE).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SEND_R_FRUITORE_CANALE";
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
