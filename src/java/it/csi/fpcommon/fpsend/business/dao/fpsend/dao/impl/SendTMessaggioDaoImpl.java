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

/*PROTECTED REGION ID(R-2079181650) ENABLED START*/
// aggiungere qui eventuali import custom. 

import  it.csi.fpcommon.fpsend.business.util.DateFormat;

/*PROTECTED REGION END*/

/**
 * Implementazione del DAO SendTMessaggio.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
 * - FINDERS:
 *   - byIdRichiesta (datagen::CustomFinder)
 * - UPDATERS:
 *   - StatoMessaggio (datagen::UpdateColumns)
 *   - updateStato (datagen::CustomUpdater)
 * - DELETERS:

 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class SendTMessaggioDaoImpl extends AbstractDAO
		implements
			SendTMessaggioDao {
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
	 * Metodo di inserimento del DAO SendTMessaggio. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SendTMessaggioPk
	 * @generated
	 */

	public SendTMessaggioPk insert(SendTMessaggioDto dto)

	{
		LOG.debug("[SendTMessaggioDaoImpl::insert] START");
		final String sql = "INSERT INTO "
				+ getTableName()
				+ " ( 	ID_MESSAGGIO,ID_RICHIESTA,IDENT_MESSAGGIO_FRUITORE,ID_TIPO_CANALE,ID_TEMPLATE,ID_STATO_MESSAGGIO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,ID_JMS_MESSAGGIO ) VALUES (  :ID_MESSAGGIO , :ID_RICHIESTA , :IDENT_MESSAGGIO_FRUITORE , :ID_TIPO_CANALE , :ID_TEMPLATE , :ID_STATO_MESSAGGIO , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :ID_JMS_MESSAGGIO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_MESSAGGIO]
		params.addValue("ID_MESSAGGIO", dto.getIdMessaggio(),
				java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_RICHIESTA]
		params.addValue("ID_RICHIESTA", dto.getIdRichiesta(),
				java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [IDENT_MESSAGGIO_FRUITORE]
		params.addValue("IDENT_MESSAGGIO_FRUITORE",
				dto.getIdentMessaggioFruitore(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_TIPO_CANALE]
		params.addValue("ID_TIPO_CANALE", dto.getIdTipoCanale(),
				java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_TEMPLATE]
		params.addValue("ID_TEMPLATE", dto.getIdTemplate(),
				java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ID_STATO_MESSAGGIO]
		params.addValue("ID_STATO_MESSAGGIO", dto.getIdStatoMessaggio(),
				java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(),
				java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(),
				java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [ID_JMS_MESSAGGIO]
		params.addValue("ID_JMS_MESSAGGIO", dto.getIdJmsMessaggio(),
				java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[SendTMessaggioDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the SEND_T_MESSAGGIO table.
	 * @generated
	 */
	public void updateColumnsStatoMessaggio(SendTMessaggioDto dto)
			throws SendTMessaggioDaoException {
		LOG.debug("[SendTMessaggioDaoImpl::updateColumnsStatoMessaggio] START");
		final String sql = "UPDATE "
				+ getTableName()
				+ " SET ID_STATO_MESSAGGIO = :ID_STATO_MESSAGGIO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO  WHERE ID_MESSAGGIO = :ID_MESSAGGIO ";

		if (dto.getIdMessaggio() == null) {
			LOG.error("[SendTMessaggioDaoImpl::updateColumnsStatoMessaggio] ERROR chiave primaria non impostata");
			throw new SendTMessaggioDaoException(
					"Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_STATO_MESSAGGIO]
		params.addValue("ID_STATO_MESSAGGIO", dto.getIdStatoMessaggio(),
				java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(),
				java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [ID_MESSAGGIO]
		params.addValue("ID_MESSAGGIO", dto.getIdMessaggio(),
				java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SendTMessaggioDaoImpl::updateColumnsStatoMessaggio] END");
	}

	/** 
	 * Custom updater in the SEND_T_MESSAGGIO table.
	 * @generated
	 */
	public void customUpdaterUpdateStato(String filter, Integer value)
			throws SendTMessaggioDaoException {
		LOG.debug("[SendTMessaggioDaoImpl::customUpdaterUpdateStato] START");
		/*PROTECTED REGION ID(R-2013786986) ENABLED START*/
		

		final String sql = "UPDATE "
				+ getTableName()
				+ "  SET ID_STATO_MESSAGGIO = :ID_STATO_MESSAGGIO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO  WHERE ID_MESSAGGIO in " + filter;
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		//params.addValue("IN", filter, java.sql.Types.INTEGER);
		params.addValue("ID_STATO_MESSAGGIO", value );
		params.addValue("DATA_AGGIORNAMENTO", DateFormat.getCurrentTimestampDate());
		
		/*PROTECTED REGION END*/

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[SendTMessaggioDaoImpl::customUpdaterUpdateStato] END");
	}

	protected SendTMessaggioDaoRowMapper byIdRichiestaRowMapper = new SendTMessaggioDaoRowMapper(
			null, SendTMessaggioDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SEND_T_MESSAGGIO";
	}

	/** 
	 * Implementazione del finder byIdRichiesta
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SendTMessaggioDto> findByIdRichiesta(Integer input)
			throws SendTMessaggioDaoException {
		LOG.debug("[SendTMessaggioDaoImpl::findByIdRichiesta] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_MESSAGGIO,ID_RICHIESTA,IDENT_MESSAGGIO_FRUITORE,ID_TIPO_CANALE,ID_TEMPLATE,ID_STATO_MESSAGGIO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,ID_JMS_MESSAGGIO ");
		sql.append(" FROM SEND_T_MESSAGGIO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1938795885) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("nome = :nome");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1857333761) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("nome", input);

		/*PROTECTED REGION END*/
		List<SendTMessaggioDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap,
					byIdRichiestaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error(
					"[SendTMessaggioDaoImpl::findByIdRichiesta] esecuzione query",
					ex);
			throw new SendTMessaggioDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("SendTMessaggioDaoImpl", "findByIdRichiesta",
					"esecuzione query", sql.toString());
			LOG.debug("[SendTMessaggioDaoImpl::findByIdRichiesta] END");
		}
		return list;
	}

}
