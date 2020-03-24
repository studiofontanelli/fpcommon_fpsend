package it.csi.fpcommon.fpsend.business.dao.fpsend.dao.mapper;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.impl.BaseDaoRowMapper;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SendTMessaggioDao
 * @generated
 */
public class SendTMessaggioDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SendTMessaggioDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SendTMessaggioDaoRowMapper(String[] columnsToRead, Class dtoClass,
			SendTMessaggioDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SendTMessaggioDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SendTMessaggioDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SendTMessaggioDto) {
			return mapRow_internal((SendTMessaggioDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SendTMessaggioDto mapRow_internal(SendTMessaggioDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		SendTMessaggioDto dto = objectToFill;

		// colonna [ID_MESSAGGIO]
		if (mapAllColumns || columnsToReadMap.get("ID_MESSAGGIO") != null)
			dto.setIdMessaggio((Integer) rs.getObject("ID_MESSAGGIO"));

		// colonna [ID_RICHIESTA]
		if (mapAllColumns || columnsToReadMap.get("ID_RICHIESTA") != null)
			dto.setIdRichiesta((Integer) rs.getObject("ID_RICHIESTA"));

		// colonna [IDENT_MESSAGGIO_FRUITORE]
		if (mapAllColumns
				|| columnsToReadMap.get("IDENT_MESSAGGIO_FRUITORE") != null)
			dto.setIdentMessaggioFruitore(rs
					.getString("IDENT_MESSAGGIO_FRUITORE"));

		// colonna [ID_TIPO_CANALE]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_CANALE") != null)
			dto.setIdTipoCanale((Integer) rs.getObject("ID_TIPO_CANALE"));

		// colonna [ID_TEMPLATE]
		if (mapAllColumns || columnsToReadMap.get("ID_TEMPLATE") != null)
			dto.setIdTemplate(rs.getBigDecimal("ID_TEMPLATE"));

		// colonna [ID_STATO_MESSAGGIO]
		if (mapAllColumns || columnsToReadMap.get("ID_STATO_MESSAGGIO") != null)
			dto.setIdStatoMessaggio((Integer) rs
					.getObject("ID_STATO_MESSAGGIO"));

		// colonna [DATA_INSERIMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("DATA_INSERIMENTO"));

		// colonna [DATA_AGGIORNAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_AGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("DATA_AGGIORNAMENTO"));

		// colonna [ID_JMS_MESSAGGIO]
		if (mapAllColumns || columnsToReadMap.get("ID_JMS_MESSAGGIO") != null)
			dto.setIdJmsMessaggio((Integer) rs.getObject("ID_JMS_MESSAGGIO"));

		return dto;
	}

}
