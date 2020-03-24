package it.csi.fpcommon.fpsend.business.dao.fpsend.metadata;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.*;
import it.csi.fpcommon.fpsend.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SendTMessaggioMetadata extends DAOMetadata {

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
	 * DAO: [SendTMessaggio]
	 * tabella: [SEND_T_MESSAGGIO].
	 */
	public SendTMessaggioMetadata() {
		columnNames = new String[]{"ID_MESSAGGIO", "ID_RICHIESTA",
				"IDENT_MESSAGGIO_FRUITORE", "ID_TIPO_CANALE", "ID_TEMPLATE",
				"ID_STATO_MESSAGGIO", "DATA_INSERIMENTO", "DATA_AGGIORNAMENTO",
				"ID_JMS_MESSAGGIO"};
		propertyNames = new String[]{"idMessaggio", "idRichiesta",
				"identMessaggioFruitore", "idTipoCanale", "idTemplate",
				"idStatoMessaggio", "dataInserimento", "dataAggiornamento",
				"idJmsMessaggio"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [SendTMessaggio] fa riferimento
	 * (SEND_T_MESSAGGIO).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SEND_T_MESSAGGIO";
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
