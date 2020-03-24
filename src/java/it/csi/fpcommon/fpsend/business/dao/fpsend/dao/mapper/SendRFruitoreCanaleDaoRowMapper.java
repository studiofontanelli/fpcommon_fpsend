package it.csi.fpcommon.fpsend.business.dao.fpsend.dao.mapper;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.impl.BaseDaoRowMapper;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SendRFruitoreCanaleDao
 * @generated
 */
public class SendRFruitoreCanaleDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SendRFruitoreCanaleDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SendRFruitoreCanaleDaoRowMapper(String[] columnsToRead,
			Class dtoClass, SendRFruitoreCanaleDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SendRFruitoreCanaleDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SendRFruitoreCanaleDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SendRFruitoreCanaleDto) {
			return mapRow_internal((SendRFruitoreCanaleDto) dtoInstance, rs,
					row);
		}

		return dtoInstance;
	}

	public SendRFruitoreCanaleDto mapRow_internal(
			SendRFruitoreCanaleDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		SendRFruitoreCanaleDto dto = objectToFill;

		// colonna [ID_FRUITORE]
		if (mapAllColumns || columnsToReadMap.get("ID_FRUITORE") != null)
			dto.setIdFruitore(rs.getBigDecimal("ID_FRUITORE"));

		// colonna [ID_TIPO_CANALE]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_CANALE") != null)
			dto.setIdTipoCanale((Integer) rs.getObject("ID_TIPO_CANALE"));

		// colonna [DATA_INIZIO_VAL]
		if (mapAllColumns || columnsToReadMap.get("DATA_INIZIO_VAL") != null)
			dto.setDataInizioVal(rs.getDate("DATA_INIZIO_VAL"));

		// colonna [DATA_FINE_VAL]
		if (mapAllColumns || columnsToReadMap.get("DATA_FINE_VAL") != null)
			dto.setDataFineVal(rs.getDate("DATA_FINE_VAL"));

		return dto;
	}

}
