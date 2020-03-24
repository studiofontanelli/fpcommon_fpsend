package it.csi.fpcommon.fpsend.business.dao.fpsend.dao.impl;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.mapper.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.qbe.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.metadata.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.*;
import it.csi.fpcommon.fpsend.business.dao.impl.*;
import it.csi.fpcommon.fpsend.business.dao.util.*;
import it.csi.fpcommon.fpsend.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import java.util.Map;
import java.util.TreeMap;

/*PROTECTED REGION ID(R362886786) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO SendTTemplate.
 * Il DAO implementa le seguenti operazioni:
 * - FINDERS:
 *   - byCodTemplate (datagen::CustomFinder)
 * - UPDATERS:

 *    --
 * - DELETERS:

 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SendTTemplateDaoImpl extends AbstractDAO
		implements
			SendTTemplateDao {
	protected static final Logger LOG = Logger
			.getLogger(Constants.APPLICATION_CODE);
	/**
	 * Il DAO utilizza JDBC template per l'implementazione delle query.
	 * @generated
	 */
	protected NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * Imposta il JDBC template utilizato per l'implementazione delle query
	 * @generated
	 */
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	protected SendTTemplateDaoRowMapper byCodTemplateRowMapper = new SendTTemplateDaoRowMapper(
			null, SendTTemplateDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SEND_T_TEMPLATE";
	}

	/** 
	 * Implementazione del finder byCodTemplate
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SendTTemplateDto> findByCodTemplate(int fruitore, String input)
			throws SendTTemplateDaoException {
		LOG.debug("[SendTTemplateDaoImpl::findByCodTemplate] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R-614754403) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		
		sql.append("SELECT a.ID_TEMPLATE, a.COD_TEMPLATE, a.DESCR_TEMPLATE, a.TESTO_TEMPLATE, a.OGGETTO_TEMPLATE ");
		
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1077086091) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		
		sql.append(" FROM SEND_T_TEMPLATE a ");
		sql.append(" join send_r_fruitore_template b on a.id_template = b.id_template ");
		
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R561601515) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		
		sql.append("a.COD_TEMPLATE = :COD_TEMPLATE ");
		sql.append("and b.ID_FRUITORE = :ID_FRUITORE ");
		
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R2113981251) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("COD_TEMPLATE", input);
		paramMap.addValue("ID_FRUITORE", fruitore);

		/*PROTECTED REGION END*/
		List<SendTTemplateDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap,
					byCodTemplateRowMapper);

		} catch (RuntimeException ex) {
			LOG.error(
					"[SendTTemplateDaoImpl::findByCodTemplate] esecuzione query",
					ex);
			throw new SendTTemplateDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SendTTemplateDaoImpl", "findByCodTemplate",
					"esecuzione query", sql.toString());
			LOG.debug("[SendTTemplateDaoImpl::findByCodTemplate] END");
		}
		return list;
	}

}
