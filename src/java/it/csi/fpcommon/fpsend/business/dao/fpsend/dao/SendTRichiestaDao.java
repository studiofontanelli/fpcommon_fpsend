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
 * Interfaccia pubblica del DAO SendTRichiesta.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SendTRichiestaDao {

	/**
	 * Metodo di inserimento del DAO SendTRichiesta. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SendTRichiestaPk
	 * @generated
	 */

	public SendTRichiestaPk insert(SendTRichiestaDto dto)

	;

	/** 
	 * Updates selected columns in the SEND_T_RICHIESTA table.
	 * @generated
	 */
	public void updateColumnsStatoRichiesta(SendTRichiestaDto dto)
			throws SendTRichiestaDaoException;

	/** 
	 * Implementazione del finder byFruitoreJmsRichiesta
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SendTRichiestaDto> findByFruitoreJmsRichiesta(int fruitore,
			String input) throws SendTRichiestaDaoException;

}
