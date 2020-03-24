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

/*PROTECTED REGION ID(R1790811970) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO SendRFruitoreCanale.
 * Il DAO implementa le seguenti operazioni:
 * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findCanaliAttivibyFruitore (datagen::CustomFinder)
 * - UPDATERS:

 *    --
 * - DELETERS:

 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SendRFruitoreCanaleDaoImpl extends AbstractDAO
		implements
			SendRFruitoreCanaleDao {
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

	protected SendRFruitoreCanaleDaoRowMapper findByPrimaryKeyRowMapper = new SendRFruitoreCanaleDaoRowMapper(
			null, SendRFruitoreCanaleDto.class, this);

	protected SendRFruitoreCanaleDaoRowMapper findCanaliAttivibyFruitoreRowMapper = new SendRFruitoreCanaleDaoRowMapper(
			null, SendRFruitoreCanaleDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SEND_R_FRUITORE_CANALE";
	}

	/** 
	 * Returns all rows from the SEND_R_FRUITORE_CANALE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SendRFruitoreCanaleDto findByPrimaryKey(SendRFruitoreCanalePk pk)
			throws SendRFruitoreCanaleDaoException {
		LOG.debug("[SendRFruitoreCanaleDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_FRUITORE,ID_TIPO_CANALE,DATA_INIZIO_VAL,DATA_FINE_VAL FROM "
						+ getTableName()
						+ " WHERE ID_FRUITORE = :ID_FRUITORE  AND ID_TIPO_CANALE = :ID_TIPO_CANALE  AND DATA_INIZIO_VAL = :DATA_INIZIO_VAL ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_FRUITORE]
		params.addValue("ID_FRUITORE", pk.getIdFruitore(),
				java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_TIPO_CANALE]
		params.addValue("ID_TIPO_CANALE", pk.getIdTipoCanale(),
				java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO_VAL]
		params.addValue("DATA_INIZIO_VAL", pk.getDataInizioVal(),
				java.sql.Types.DATE);

		List<SendRFruitoreCanaleDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params,
					findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error(
					"[SendRFruitoreCanaleDaoImpl::findByPrimaryKey] ERROR esecuzione query",
					ex);
			throw new SendRFruitoreCanaleDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SendRFruitoreCanaleDaoImpl",
					"findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[SendRFruitoreCanaleDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder findCanaliAttivibyFruitore
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SendRFruitoreCanaleDto> findFindCanaliAttivibyFruitore(
			Integer input) throws SendRFruitoreCanaleDaoException {
		LOG.debug("[SendRFruitoreCanaleDaoImpl::findFindCanaliAttivibyFruitore] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_FRUITORE,ID_TIPO_CANALE,DATA_INIZIO_VAL,DATA_FINE_VAL ");
		sql.append(" FROM SEND_R_FRUITORE_CANALE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-2139852693) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		
		sql.append("ID_FRUITORE = :ID_FRUITORE");
		
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-26720573) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("ID_FRUITORE", input);

		/*PROTECTED REGION END*/
		List<SendRFruitoreCanaleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap,
					findCanaliAttivibyFruitoreRowMapper);

		} catch (RuntimeException ex) {
			LOG.error(
					"[SendRFruitoreCanaleDaoImpl::findFindCanaliAttivibyFruitore] esecuzione query",
					ex);
			throw new SendRFruitoreCanaleDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SendRFruitoreCanaleDaoImpl",
					"findFindCanaliAttivibyFruitore", "esecuzione query",
					sql.toString());
			LOG.debug("[SendRFruitoreCanaleDaoImpl::findFindCanaliAttivibyFruitore] END");
		}
		return list;
	}

}
