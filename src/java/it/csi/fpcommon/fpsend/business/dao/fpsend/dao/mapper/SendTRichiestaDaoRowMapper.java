package it.csi.fpcommon.fpsend.business.dao.fpsend.dao.mapper;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.impl.BaseDaoRowMapper;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SendTRichiestaDao
 * @generated
 */
public class SendTRichiestaDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SendTRichiestaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SendTRichiestaDaoRowMapper(String[] columnsToRead, Class dtoClass,
			SendTRichiestaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SendTRichiestaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SendTRichiestaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SendTRichiestaDto) {
			return mapRow_internal((SendTRichiestaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SendTRichiestaDto mapRow_internal(SendTRichiestaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		SendTRichiestaDto dto = objectToFill;

		// colonna [ID_RICHIESTA]
		if (mapAllColumns || columnsToReadMap.get("ID_RICHIESTA") != null)
			dto.setIdRichiesta((Integer) rs.getObject("ID_RICHIESTA"));

		// colonna [ID_FRUITORE]
		if (mapAllColumns || columnsToReadMap.get("ID_FRUITORE") != null)
			dto.setIdFruitore(rs.getBigDecimal("ID_FRUITORE"));

		// colonna [ID_STATO_RICHIESTA]
		if (mapAllColumns || columnsToReadMap.get("ID_STATO_RICHIESTA") != null)
			dto.setIdStatoRichiesta((Integer) rs
					.getObject("ID_STATO_RICHIESTA"));

		// colonna [ID_JMS_RICHIESTA]
		if (mapAllColumns || columnsToReadMap.get("ID_JMS_RICHIESTA") != null)
			dto.setIdJmsRichiesta(rs.getString("ID_JMS_RICHIESTA"));

		return dto;
	}

}
