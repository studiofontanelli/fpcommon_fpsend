package it.csi.fpcommon.fpsend.business.fpsend;

import it.csi.csi.wrapper.CSIException;
import it.csi.csi.wrapper.SystemException;
import it.csi.csi.wrapper.UnrecoverableException;

import it.csi.fpcommon.fpsend.dto.fpsend.*;

import it.csi.fpcommon.fpsend.interfacecsi.fpsend.*;

import it.csi.fpcommon.fpsend.exception.fpsend.*;

import it.csi.fpcommon.fpsend.business.fpsend.spring.SpringBeanLocator;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.apache.log4j.*;

/**
 * @generated
 */
public class FpsendBean implements SessionBean {

	// business delegate contenente le implementazioni del servizio
	/**
	 * @generated
	 */
	protected FpsendImpl delegate = null;

	/**
	 * @generated
	 */
	public static final String LOGGER_PREFIX = "fpsend";
	public static final Logger logger = Logger.getLogger(LOGGER_PREFIX);

	/// Operazioni esposte dal servizio

	/**
	 * @generated
	 */
	public java.lang.String sendMessage( //NOSONAR  Reason:EIAS

			it.csi.fpcommon.fpsend.dto.fpsend.RequestMessage requestMessage //NOSONAR  Reason:EIAS

			, it.csi.csi.util.DatiMessaggio datiMsg) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[FpsendBean::sendMessage()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch(
					"fpsend");
			// inizio misurazione
			watcher.start();

			java.lang.String valueObjRet = delegate.sendMessage(

			requestMessage

			, datiMsg

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("FpsendBean", "sendMessage()",
					"invocazione servizio [fpsend]::[sendMessage]",
					"(valore input omesso)");
			logger.debug("[FpsendBean::sendMessage()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			ctx.setRollbackOnly();

			throw e;
		} catch (Exception e) {

			ctx.setRollbackOnly();

			throw new UnrecoverableException(
					"Errore non recuperabile durante l'esecuzione del metodo:"
							+ e, e);
		}
	}

	/**
	 * @generated
	 */
	public java.lang.String sendMessages( //NOSONAR  Reason:EIAS

			it.csi.fpcommon.fpsend.dto.fpsend.RequestMessages requestMessages //NOSONAR  Reason:EIAS

			, it.csi.csi.util.DatiMessaggio datiMsg) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[FpsendBean::sendMessages()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch(
					"fpsend");
			// inizio misurazione
			watcher.start();

			java.lang.String valueObjRet = delegate.sendMessages(

			requestMessages

			, datiMsg

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("FpsendBean", "sendMessages()",
					"invocazione servizio [fpsend]::[sendMessages]",
					"(valore input omesso)");
			logger.debug("[FpsendBean::sendMessages()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			ctx.setRollbackOnly();

			throw e;
		} catch (Exception e) {

			ctx.setRollbackOnly();

			throw new UnrecoverableException(
					"Errore non recuperabile durante l'esecuzione del metodo:"
							+ e, e);
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
		try {

			logger.debug("[FpsendBean::sendPec()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch(
					"fpsend");
			// inizio misurazione
			watcher.start();

			it.csi.fpcommon.fpsend.dto.fpsend.ResponseMessage valueObjRet = delegate
					.sendPec(

					requestMessage

					);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("FpsendBean", "sendPec()",
					"invocazione servizio [fpsend]::[sendPec]",
					"(valore input omesso)");
			logger.debug("[FpsendBean::sendPec()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			ctx.setRollbackOnly();

			throw e;
		} catch (Exception e) {

			ctx.setRollbackOnly();

			throw new UnrecoverableException(
					"Errore non recuperabile durante l'esecuzione del metodo:"
							+ e, e);
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
		try {

			logger.debug("[FpsendBean::recuperaPec()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch(
					"fpsend");
			// inizio misurazione
			watcher.start();

			it.csi.fpcommon.fpsend.dto.fpsend.ResponseRecuperaPec valueObjRet = delegate
					.recuperaPec(

					request

					);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("FpsendBean", "recuperaPec()",
					"invocazione servizio [fpsend]::[recuperaPec]",
					"(valore input omesso)");
			logger.debug("[FpsendBean::recuperaPec()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			ctx.setRollbackOnly();

			throw e;
		} catch (Exception e) {

			ctx.setRollbackOnly();

			throw new UnrecoverableException(
					"Errore non recuperabile durante l'esecuzione del metodo:"
							+ e, e);
		}
	}

	/**
	 * @generated
	 */
	public boolean testResources() //NOSONAR  Reason:EIAS 
			throws it.csi.csi.wrapper.CSIException { //NOSONAR  Reason:EIAS 
		return delegate.testResources();
	}

	/**
	 * @generated
	 */
	public it.csi.coopdiag.api.InvocationNode selfCheck( //NOSONAR  Reason:EIAS 
			it.csi.coopdiag.api.CalledResource[] alreadyChecked) //NOSONAR  Reason:EIAS 
			throws it.csi.csi.wrapper.CSIException { //NOSONAR  Reason:EIAS
		return delegate.selfCheck(alreadyChecked);
	}

	/**
	 * @generated
	 */
	public boolean hasSelfCheck() //NOSONAR  Reason:EIAS 
			throws it.csi.csi.wrapper.CSIException { //NOSONAR  Reason:EIAS
		return delegate.hasSelfCheck();
	}

	/// lifecycle dell EJB

	/**
	 * @generated
	 */
	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	/**
	 * @generated
	 */
	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	/**
	 * @generated
	 */
	public void ejbRemove() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	/**
	 * @generated
	 */
	public void ejbCreate() {
	}

	/**
	 * @generated
	 */
	SessionContext ctx = null;

	/**
	 * @generated
	 */
	public void createImpl(Object initOptions) throws EJBException {
		Logger logger = getLogger(null);
		logger.debug("[FpsendBean::createImpl] - START");
		try {
			delegate = (FpsendImpl) SpringBeanLocator.getBean("fpsendImpl");
			delegate.init(initOptions);
			delegate.setSessionContext(ctx);

		}

		catch (Exception ie) {
			logger.debug("[FpsendBean::createImpl] - ERROR", ie);
			throw new EJBException(
					"Errore nella inizializzazione dell'implementazione del servizio fpsend:"
							+ ie.getMessage(), ie);
		} finally {
			logger.debug("[FpsendBean::createImpl] - END");
		}
	}

	/**
	 * @generated
	 */
	public void setSessionContext(SessionContext ctx) throws EJBException,
			RemoteException {

		/// META-TODO: forse sarebbe opportuno accodare il nome del servizio al logger...
		Logger logger = getLogger(null);
		logger.debug("[FpsendBean::setSessionContext] - START");
		this.ctx = ctx;
		// contiene eventuali oggetti inizializzati nella sezione seguente e che
		// devono essere passati all'oggetto delegate
		Object implInitOptions = null;

		/// Inizializzazione risorse
		/*PROTECTED REGION ID(R476300935) ENABLED START*/
		// inserire qui il codice di inziializzazione risorse:
		// non verr&agrave; cancellato dalle successive rignerazioni
		// esempio di cose da fare:
		// -- leggere environment entry o context jndi 
		// -- inizializzare datasource, altre risorse
		// -- inserire le options in 'implInitOptions': saranno poi 
		//    passate al metodo initImpl()
		// NOTA: il contenuto specifico dell'oggetto implInitOptions e'
		// specifico di ogni applicazione		
		/*PROTECTED REGION END*/
		/// creazione dell'implementazione
		createImpl(implInitOptions);
		logger.debug("[FpsendBean::setSessionContext] - END");
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
}
