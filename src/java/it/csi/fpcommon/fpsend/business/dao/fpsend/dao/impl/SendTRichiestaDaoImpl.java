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

/*PROTECTED REGION ID(R1252707104) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO SendTRichiesta.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
 * - FINDERS:
 *   - byFruitoreJmsRichiesta (datagen::CustomFinder)
 * - UPDATERS:
 *   - StatoRichiesta (datagen::UpdateColumns)
 * - DELETERS:

 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SendTRichiestaDaoImpl extends AbstractDAO
		implements
			SendTRichiestaDao {
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

	/**
	 * Metodo di inserimento del DAO SendTRichiesta. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SendTRichiestaPk
	 * @generated
	 */

	public SendTRichiestaPk insert(SendTRichiestaDto dto)

	{
		LOG.debug("[SendTRichiestaDaoImpl::insert] START");
		final String sql = "INSERT INTO "
				+ getTableName()
				+ " ( 	ID_RICHIESTA,ID_FRUITORE,ID_STATO_RICHIESTA,ID_JMS_RICHIESTA ) VALUES (  :ID_RICHIESTA , :ID_FRUITORE , :ID_STATO_RICHIESTA , :ID_JMS_RICHIESTA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_RICHIESTA]
		params.addValue("ID_RICHIESTA", dto.getIdRichiesta(),
				java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_FRUITORE]
		params.addValue("ID_FRUITORE", dto.getIdFruitore(),
				java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_STATO_RICHIESTA]
		params.addValue("ID_STATO_RICHIESTA", dto.getIdStatoRichiesta(),
				java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_JMS_RICHIESTA]
		params.addValue("ID_JMS_RICHIESTA", dto.getIdJmsRichiesta(),
				java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SendTRichiestaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the SEND_T_RICHIESTA table.
	 * @generated
	 */
	public void updateColumnsStatoRichiesta(SendTRichiestaDto dto)
			throws SendTRichiestaDaoException {
		LOG.debug("[SendTRichiestaDaoImpl::updateColumnsStatoRichiesta] START");
		final String sql = "UPDATE "
				+ getTableName()
				+ " SET ID_STATO_RICHIESTA = :ID_STATO_RICHIESTA  WHERE ID_RICHIESTA = :ID_RICHIESTA ";

		if (dto.getIdRichiesta() == null) {
			LOG.error("[SendTRichiestaDaoImpl::updateColumnsStatoRichiesta] ERROR chiave primaria non impostata");
			throw new SendTRichiestaDaoException(
					"Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_STATO_RICHIESTA]
		params.addValue("ID_STATO_RICHIESTA", dto.getIdStatoRichiesta(),
				java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_RICHIESTA]
		params.addValue("ID_RICHIESTA", dto.getIdRichiesta(),
				java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SendTRichiestaDaoImpl::updateColumnsStatoRichiesta] END");
	}

	protected SendTRichiestaDaoRowMapper byFruitoreJmsRichiestaRowMapper = new SendTRichiestaDaoRowMapper(
			null, SendTRichiestaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SEND_T_RICHIESTA";
	}

	/** 
	 * Implementazione del finder byFruitoreJmsRichiesta
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SendTRichiestaDto> findByFruitoreJmsRichiesta(int fruitore,
			String input) throws SendTRichiestaDaoException {
		LOG.debug("[SendTRichiestaDaoImpl::findByFruitoreJmsRichiesta] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_RICHIESTA,ID_FRUITORE,ID_STATO_RICHIESTA,ID_JMS_RICHIESTA ");
		sql.append(" FROM SEND_T_RICHIESTA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1102539685) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("ID_FRUITORE = :ID_FRUITORE ");
		sql.append(" and ");
		sql.append("ID_JMS_RICHIESTA = :ID_JMS_RICHIESTA ");

		sql.append("order by ID_RICHIESTA desc ");
		
		
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R2065211603) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("ID_FRUITORE", fruitore);
		paramMap.addValue("ID_JMS_RICHIESTA", input);

		/*PROTECTED REGION END*/
		List<SendTRichiestaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap,
					byFruitoreJmsRichiestaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error(
					"[SendTRichiestaDaoImpl::findByFruitoreJmsRichiesta] esecuzione query",
					ex);
			throw new SendTRichiestaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SendTRichiestaDaoImpl",
					"findByFruitoreJmsRichiesta", "esecuzione query",
					sql.toString());
			LOG.debug("[SendTRichiestaDaoImpl::findByFruitoreJmsRichiesta] END");
		}
		return list;
	}

}
