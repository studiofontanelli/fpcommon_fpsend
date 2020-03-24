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
 * Interfaccia pubblica del DAO SendRFruitoreCanale.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SendRFruitoreCanaleDao {

	/** 
	 * Returns all rows from the SEND_R_FRUITORE_CANALE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SendRFruitoreCanaleDto findByPrimaryKey(SendRFruitoreCanalePk pk)
			throws SendRFruitoreCanaleDaoException;

	/** 
	 * Implementazione del finder findCanaliAttivibyFruitore
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SendRFruitoreCanaleDto> findFindCanaliAttivibyFruitore(
			Integer input) throws SendRFruitoreCanaleDaoException;

}
