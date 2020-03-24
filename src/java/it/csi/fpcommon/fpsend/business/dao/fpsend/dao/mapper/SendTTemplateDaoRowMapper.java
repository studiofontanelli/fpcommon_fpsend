package it.csi.fpcommon.fpsend.business.dao.fpsend.dao.mapper;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.impl.BaseDaoRowMapper;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO SendTTemplateDao
 * @generated
 */
public class SendTTemplateDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	SendTTemplateDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public SendTTemplateDaoRowMapper(String[] columnsToRead, Class dtoClass,
			SendTTemplateDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (SendTTemplateDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SendTTemplateDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof SendTTemplateDto) {
			return mapRow_internal((SendTTemplateDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public SendTTemplateDto mapRow_internal(SendTTemplateDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		SendTTemplateDto dto = objectToFill;

		// colonna [ID_TEMPLATE]
		if (mapAllColumns || columnsToReadMap.get("ID_TEMPLATE") != null)
			dto.setIdTemplate(rs.getBigDecimal("ID_TEMPLATE"));

		// colonna [OGGETTO_TEMPLATE]
		if (mapAllColumns || columnsToReadMap.get("OGGETTO_TEMPLATE") != null)
			dto.setOggettoTemplate(rs.getString("OGGETTO_TEMPLATE"));

		// colonna [COD_TEMPLATE]
		if (mapAllColumns || columnsToReadMap.get("COD_TEMPLATE") != null)
			dto.setCodTemplate(rs.getString("COD_TEMPLATE"));

		// colonna [DESCR_TEMPLATE]
		if (mapAllColumns || columnsToReadMap.get("DESCR_TEMPLATE") != null)
			dto.setDescrTemplate(rs.getString("DESCR_TEMPLATE"));

		// colonna [TESTO_TEMPLATE]
		if (mapAllColumns || columnsToReadMap.get("TESTO_TEMPLATE") != null)
			dto.setTestoTemplate(rs.getString("TESTO_TEMPLATE"));

		return dto;
	}

}
