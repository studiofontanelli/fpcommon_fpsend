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

/*PROTECTED REGION ID(R432372738) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO SendTFruitore.
 * Il DAO implementa le seguenti operazioni:
 * - FINDERS:
 *   - findByCodFruitore (datagen::CustomFinder)
 * - UPDATERS:

 *    --
 * - DELETERS:

 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SendTFruitoreDaoImpl extends AbstractDAO
		implements
			SendTFruitoreDao {
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

	protected SendTFruitoreDaoRowMapper findByCodFruitoreRowMapper = new SendTFruitoreDaoRowMapper(
			null, SendTFruitoreDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SEND_T_FRUITORE";
	}

	/** 
	 * Implementazione del finder findByCodFruitore
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SendTFruitoreDto> findFindByCodFruitore(String input)
			throws SendTFruitoreDaoException {
		LOG.debug("[SendTFruitoreDaoImpl::findFindByCodFruitore] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_FRUITORE,COD_FRUITORE,DESCR_FRUITORE ");
		sql.append(" FROM SEND_T_FRUITORE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R945595204) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("COD_FRUITORE = :COD_FRUITORE");
		
		
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1132883722) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("COD_FRUITORE", input);

		/*PROTECTED REGION END*/
		List<SendTFruitoreDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap,
					findByCodFruitoreRowMapper);

		} catch (RuntimeException ex) {
			LOG.error(
					"[SendTFruitoreDaoImpl::findFindByCodFruitore] esecuzione query",
					ex);
			throw new SendTFruitoreDaoException("Query failed", ex);
		} finally {
			stopWatch
					.dumpElapsed("SendTFruitoreDaoImpl",
							"findFindByCodFruitore", "esecuzione query",
							sql.toString());
			LOG.debug("[SendTFruitoreDaoImpl::findFindByCodFruitore] END");
		}
		return list;
	}

}
