package it.csi.fpcommon.fpsend.business.dao.fpsend.dao.mapper;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.impl.BaseDaoRowMapper;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SendTFruitoreDao
 * @generated
 */
public class SendTFruitoreDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SendTFruitoreDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SendTFruitoreDaoRowMapper(String[] columnsToRead, Class dtoClass,
			SendTFruitoreDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SendTFruitoreDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SendTFruitoreDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SendTFruitoreDto) {
			return mapRow_internal((SendTFruitoreDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SendTFruitoreDto mapRow_internal(SendTFruitoreDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		SendTFruitoreDto dto = objectToFill;

		// colonna [ID_FRUITORE]
		if (mapAllColumns || columnsToReadMap.get("ID_FRUITORE") != null)
			dto.setIdFruitore(rs.getBigDecimal("ID_FRUITORE"));

		// colonna [COD_FRUITORE]
		if (mapAllColumns || columnsToReadMap.get("COD_FRUITORE") != null)
			dto.setCodFruitore(rs.getString("COD_FRUITORE"));

		// colonna [DESCR_FRUITORE]
		if (mapAllColumns || columnsToReadMap.get("DESCR_FRUITORE") != null)
			dto.setDescrFruitore(rs.getString("DESCR_FRUITORE"));

		return dto;
	}

}
