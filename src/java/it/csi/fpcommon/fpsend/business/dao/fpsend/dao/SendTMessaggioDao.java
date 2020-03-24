package it.csi.fpcommon.fpsend.business.dao.fpsend.dao;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.qbe.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.metadata.*;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.*;
import it.csi.fpcommon.fpsend.business.dao.util.*;
import it.csi.fpcommon.fpsend.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interfaccia pubblica del DAO SendTMessaggio.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SendTMessaggioDao {

	/**
	 * Metodo di inserimento del DAO SendTMessaggio. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SendTMessaggioPk
	 * @generated
	 */

	public SendTMessaggioPk insert(SendTMessaggioDto dto)

	;

	/** 
	 * Updates selected columns in the SEND_T_MESSAGGIO table.
	 * @generated
	 */
	public void updateColumnsStatoMessaggio(SendTMessaggioDto dto)
			throws SendTMessaggioDaoException;

	/** 
	 * Custom updater in the SEND_T_MESSAGGIO table.
	 * @generated
	 */
	public void customUpdaterUpdateStato(String filter, Integer value)
			throws SendTMessaggioDaoException;

	/** 
	 * Implementazione del finder byIdRichiesta
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SendTMessaggioDto> findByIdRichiesta(Integer input)
			throws SendTMessaggioDaoException;

}
