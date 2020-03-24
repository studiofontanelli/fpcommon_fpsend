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

/*PROTECTED REGION ID(R1072977090) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO SendDTipoCanale.
 * Il DAO implementa le seguenti operazioni:
 * - FINDERS:
 *   - findCanaliAttiviByFruitore (datagen::CustomFinder)
 * - UPDATERS:

 *    --
 * - DELETERS:

 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SendDTipoCanaleDaoImpl extends AbstractDAO
		implements
			SendDTipoCanaleDao {
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

	protected SendDTipoCanaleDaoRowMapper findCanaliAttiviByFruitoreRowMapper = new SendDTipoCanaleDaoRowMapper(
			null, SendDTipoCanaleDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SEND_D_TIPO_CANALE";
	}

	/** 
	 * Implementazione del finder findCanaliAttiviByFruitore
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SendDTipoCanaleDto> findFindCanaliAttiviByFruitore(String input)
			throws SendDTipoCanaleDaoException {
		LOG.debug("[SendDTipoCanaleDaoImpl::findFindCanaliAttiviByFruitore] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R-786889195) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		
		sql.append("SELECT a.ID_TIPO_CANALE, a.COD_TIPO_CANALE, a.DESCR_TIPO_CANALE ");
		
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1997949949) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		
		sql.append(" FROM SEND_D_TIPO_CANALE a ");
		sql.append(" join send_r_fruitore_canale r on a.id_tipo_canale = r.id_tipo_canale ");
		sql.append(" join send_t_fruitore f on f.id_fruitore = r.id_fruitore ");
		
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-275235213) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		
		sql.append("f.cod_fruitore = :COD_FRUITORE ");
		sql.append("and to_char (now(), 'yyyy/MM/dd') >= to_char (r.data_inizio_val, 'yyyy/MM/dd') ");
		sql.append("and to_char (now(), 'yyyy/MM/dd') <= to_char (COALESCE(r.data_fine_val, now()), 'yyyy/MM/dd') ");

		
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1941846459) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("COD_FRUITORE", input);

		/*PROTECTED REGION END*/
		List<SendDTipoCanaleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap,
					findCanaliAttiviByFruitoreRowMapper);

		} catch (RuntimeException ex) {
			LOG.error(
					"[SendDTipoCanaleDaoImpl::findFindCanaliAttiviByFruitore] esecuzione query",
					ex);
			throw new SendDTipoCanaleDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SendDTipoCanaleDaoImpl",
					"findFindCanaliAttiviByFruitore", "esecuzione query",
					sql.toString());
			LOG.debug("[SendDTipoCanaleDaoImpl::findFindCanaliAttiviByFruitore] END");
		}
		return list;
	}

}
