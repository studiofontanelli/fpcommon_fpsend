package it.csi.fpcommon.fpsend.business.fpsend;

import it.csi.coopdiag.api.InvocationNode;
import it.csi.coopdiag.engine.utils.DefaultSelfChecker;
import it.csi.csi.wrapper.CSIException;
import it.csi.csi.wrapper.UnrecoverableException;
import it.csi.fpcommon.fpsend.business.fpsend.helper.MessageSenderHelper;
import it.csi.fpcommon.fpsend.business.fpsend.helper.PecHelper;
import it.csi.fpcommon.fpsend.business.fpsend.helper.PecSenderHelper;

import javax.ejb.SessionContext;

import org.apache.log4j.Logger;

/*PROTECTED REGION ID(R-350807193) ENABLED START*/
// aggiungere qui eventuali import aggiuntive.
// verranno preservate in rigenerazioni successive del progetto
/*PROTECTED REGION END*/

/**
 * @generated
 */
public class FpsendImpl {
	/**
	 * @generated
	 */
	public static final String LOGGER_PREFIX = "fpsend";
	private SessionContext sessionContext;

	public SessionContext getSessionContext() {
		return sessionContext;
	}

	public void setSessionContext(SessionContext sessionContext) {
		this.sessionContext = sessionContext;
	}

	/*PROTECTED REGION ID(R223983625) ENABLED START*/
	private MessageSenderHelper messageSenderHelper;
	private PecSenderHelper pecSenderHelper;
	private PecHelper pecHelper;

	public PecSenderHelper getPecSenderHelper() {
		return pecSenderHelper;
	}

	public void setPecSenderHelper(PecSenderHelper pecSenderHelper) {
		this.pecSenderHelper = pecSenderHelper;
	}

	public PecHelper getPecHelper() {
		return pecHelper;
	}

	public void setPecHelper(PecHelper pecHelper) {
		this.pecHelper = pecHelper;
	}

	public MessageSenderHelper getMessageSenderHelper() {
		return messageSenderHelper;
	}

	public void setMessageSenderHelper(MessageSenderHelper messageSenderHelper) {
		this.messageSenderHelper = messageSenderHelper;
	}
	/*PROTECTED REGION END*/

	/// Implementazione operazioni esposte dal servizio

	/**
	 * @generated
	 */
	public java.lang.String sendMessage( //NOSONAR  Reason:EIAS

			it.csi.fpcommon.fpsend.dto.fpsend.RequestMessage requestMessage //NOSONAR  Reason:EIAS

			, it.csi.csi.util.DatiMessaggio datiMsg

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException

	{ //NOSONAR  Reason:EIAS
		Logger logger = getLogger(null);
		logger.debug("[FpsendImpl::sendMessage] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch(
				"fpsend");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-586267001) ENABLED START*/
		// inserire qui la dichiarazione di variabili locali al metodo
		// non verr&agrave; sovrascritto nelle successive rigenerazioni
		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1106295001) ENABLED START*/
			// inserire qui il codice di implementazione del metodo 'sendMessage'.
			// non verr&agrave; sovrascritto nelle successive rigenerazioni

			 messageSenderHelper.sendMessage(requestMessage, datiMsg.getIdMessaggio());;

			 return null;
			 
			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione", ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione", ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[FpsendImpl::sendMessage] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[FpsendImpl::sendMessage] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex, ex);
				throw new UnrecoverableException(
						"Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("FpsendImpl", "sendMessage()",
					"invocazione servizio [fpsend]::[sendMessage]",
					"(valore input omesso)");
			logger.debug("[FpsendImpl::sendMessage] - END");
		}
	}

	/**
	 * @generated
	 */
	public java.lang.String sendMessages( //NOSONAR  Reason:EIAS

			it.csi.fpcommon.fpsend.dto.fpsend.RequestMessages requestMessages //NOSONAR  Reason:EIAS

			, it.csi.csi.util.DatiMessaggio datiMsg

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException

	{ //NOSONAR  Reason:EIAS
		Logger logger = getLogger(null);
		logger.debug("[FpsendImpl::sendMessages] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch(
				"fpsend");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-994407732) ENABLED START*/
		// inserire qui la dichiarazione di variabili locali al metodo
		// non verr&agrave; sovrascritto nelle successive rigenerazioni
		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R64593452) ENABLED START*/
			// inserire qui il codice di implementazione del metodo 'sendMessages'.
			// non verr&agrave; sovrascritto nelle successive rigenerazioni

			return null;

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione", ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione", ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[FpsendImpl::sendMessages] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[FpsendImpl::sendMessages] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex, ex);
				throw new UnrecoverableException(
						"Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("FpsendImpl", "sendMessages()",
					"invocazione servizio [fpsend]::[sendMessages]",
					"(valore input omesso)");
			logger.debug("[FpsendImpl::sendMessages] - END");
		}
	}

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.dto.fpsend.ResponseMessage sendPec( //NOSONAR  Reason:EIAS

			it.csi.fpcommon.fpsend.dto.fpsend.RequestMessage requestMessage //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException

	{ //NOSONAR  Reason:EIAS
		Logger logger = getLogger(null);
		logger.debug("[FpsendImpl::sendPec] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch(
				"fpsend");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R835467150) ENABLED START*/
		// inserire qui la dichiarazione di variabili locali al metodo
		// non verr&agrave; sovrascritto nelle successive rigenerazioni
		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R531007534) ENABLED START*/
			// inserire qui il codice di implementazione del metodo 'sendPec'.
			// non verr&agrave; sovrascritto nelle successive rigenerazioni

			return null;

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione", ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione", ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[FpsendImpl::sendPec] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[FpsendImpl::sendPec] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex, ex);
				throw new UnrecoverableException(
						"Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("FpsendImpl", "sendPec()",
					"invocazione servizio [fpsend]::[sendPec]",
					"(valore input omesso)");
			logger.debug("[FpsendImpl::sendPec] - END");
		}
	}

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.dto.fpsend.ResponseRecuperaPec recuperaPec( //NOSONAR  Reason:EIAS

			it.csi.fpcommon.fpsend.dto.fpsend.RequestRecuperaPec request //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.fpcommon.fpsend.exception.fpsend.RecuperaPecException

	{ //NOSONAR  Reason:EIAS
		Logger logger = getLogger(null);
		logger.debug("[FpsendImpl::recuperaPec] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch(
				"fpsend");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R177233197) ENABLED START*/
		// inserire qui la dichiarazione di variabili locali al metodo
		// non verr&agrave; sovrascritto nelle successive rigenerazioni
		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-342794803) ENABLED START*/
			// inserire qui il codice di implementazione del metodo 'recuperaPec'.
			// non verr&agrave; sovrascritto nelle successive rigenerazioni

			return null;

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione", ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione", ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[FpsendImpl::recuperaPec] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[FpsendImpl::recuperaPec] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex, ex);
				throw new UnrecoverableException(
						"Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("FpsendImpl", "recuperaPec()",
					"invocazione servizio [fpsend]::[recuperaPec]",
					"(valore input omesso)");
			logger.debug("[FpsendImpl::recuperaPec] - END");
		}
	}

	/// dichiarazione del self checker (utilizzato in monitoraggio e diagnostica)
	/**
	 * @generated
	 */
	String _codS = "fpcommon"; // e' corretto che sia il codice prodotto?
	/**
	 * @generated
	 */
	String _codR = "fpsend";
	/**
	 * @generated
	 */
	String[] _suppS = new String[]{
	/*PROTECTED REGION ID(R997029973) ENABLED START*/
	// inserire qui i codici sistema dei supplier diretti (se ci sono)
	// es: "Sistema1","Sistema2"
	/*PROTECTED REGION END*/
	};
	/**
	 * @generated
	 */
	String[] _suppR = new String[]{
	/*PROTECTED REGION ID(R1290432980) ENABLED START*/
	// inserire qui i codici risorsa dei supplier diretti (se ci sono)
	// es: "risorsa1","risorsa2"
	// (corrispondono ai codici servizio dei corrispondenti servizi -
	// vedere documentazione coop-diag)
	/*PROTECTED REGION END*/
	};

	/**
	 * @generated
	 */
	DefaultSelfChecker schk = new DefaultSelfChecker(_codS, _codR, getLogger(
			null).getName(), _suppS, _suppR, "/checked_resources_fpsend.xml");

	/**
	 * @generated
	 */
	public boolean testResources() //NOSONAR  Reason:EIAS 
			throws it.csi.csi.wrapper.CSIException { //NOSONAR  Reason:EIAS
		Logger logger = getLogger(null);
		logger.debug("[FpsendImpl::testResources()] BEGIN");
		InvocationNode in = new InvocationNode();
		try {
			logger.debug("[FpsendImpl::testResources()] END");
			return schk.testResources();
		} catch (CSIException ex) {
			logger.error("[FpsendImpl::testResources()] : si e' verificato un errore  "
					+ ex);
			throw ex;
		}
	}

	/**
	 * @generated
	 */
	public it.csi.coopdiag.api.InvocationNode selfCheck( //NOSONAR  Reason:EIAS 
			it.csi.coopdiag.api.CalledResource[] alreadyChecked) //NOSONAR  Reason:EIAS 
			throws it.csi.csi.wrapper.CSIException { //NOSONAR  Reason:EIAS
		Logger logger = getLogger(null);
		logger.debug("[FpsendImpl::selfCheck] - BEGIN");
		InvocationNode in = new InvocationNode();
		try {
			return schk.selfCheck(alreadyChecked);
		} catch (CSIException ex) {
			logger.error("[FpsendImpl::selfCheck()] si e' verificato un errore  "
					+ ex);
		}
		logger.debug("[FpsendImpl::selfCheck] - END");
		// restituisco l’invocation node
		return in;
	}

	/**
	 * @generated
	 */
	public boolean hasSelfCheck() //NOSONAR  Reason:EIAS 
			throws it.csi.csi.wrapper.CSIException { //NOSONAR  Reason:EIAS
		return true;
	}

	/// inizializzazione
	/**
	 * @generated
	 */
	public void init(Object initOptions) {
		/*PROTECTED REGION ID(R32104098) ENABLED START*/
		// inserire qui il codice di inizializzazione della implementazione
		// non verr&agrave; sovrascritto da successive rigenerazioni
		/*PROTECTED REGION END*/
	}

	/**
	 * @generated
	 */
	protected Logger getLogger(String subsystem) {
		if (subsystem != null)
			return Logger.getLogger(LOGGER_PREFIX + "." + subsystem);
		else
			return Logger.getLogger(LOGGER_PREFIX);
	}

	/// eventuali metodi aggiuntivi
	/*PROTECTED REGION ID(R1471162004) ENABLED START*/
	// inserire qui la dichiarazione di eventuali metodi aggiuntivi utili
	// per l'implementazione.
	// non verr&agrave; sovrascritto da successive rigenerazioni.
	/*PROTECTED REGION END*/
}
