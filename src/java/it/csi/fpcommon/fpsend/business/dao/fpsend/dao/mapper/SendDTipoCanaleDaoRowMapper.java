package it.csi.fpcommon.fpsend.business.dao.fpsend.dao.mapper;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.impl.BaseDaoRowMapper;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SendDTipoCanaleDao
 * @generated
 */
public class SendDTipoCanaleDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SendDTipoCanaleDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SendDTipoCanaleDaoRowMapper(String[] columnsToRead, Class dtoClass,
			SendDTipoCanaleDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SendDTipoCanaleDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SendDTipoCanaleDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SendDTipoCanaleDto) {
			return mapRow_internal((SendDTipoCanaleDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SendDTipoCanaleDto mapRow_internal(SendDTipoCanaleDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		SendDTipoCanaleDto dto = objectToFill;

		// colonna [ID_TIPO_CANALE]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_CANALE") != null)
			dto.setIdTipoCanale((Integer) rs.getObject("ID_TIPO_CANALE"));

		// colonna [COD_TIPO_CANALE]
		if (mapAllColumns || columnsToReadMap.get("COD_TIPO_CANALE") != null)
			dto.setCodTipoCanale(rs.getString("COD_TIPO_CANALE"));

		// colonna [DESCR_TIPO_CANALE]
		if (mapAllColumns || columnsToReadMap.get("DESCR_TIPO_CANALE") != null)
			dto.setDescrTipoCanale(rs.getString("DESCR_TIPO_CANALE"));

		return dto;
	}

}
