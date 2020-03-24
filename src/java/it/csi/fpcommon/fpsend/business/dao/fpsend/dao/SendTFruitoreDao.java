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
 * Interfaccia pubblica del DAO SendTFruitore.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SendTFruitoreDao {

	/** 
	 * Implementazione del finder findByCodFruitore
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SendTFruitoreDto> findFindByCodFruitore(String input)
			throws SendTFruitoreDaoException;

}
