package it.csi.fpcommon.fpsend.business.fpsend;

import it.csi.fpcommon.fpsend.dto.fpsend.*;

import it.csi.fpcommon.fpsend.exception.fpsend.*;

/**
 * Interfaccia remota dell'EJB che implementa il servizio fpsend.
 * @generated
 */
public interface FpsendRemote extends javax.ejb.EJBObject {

	/**
	 * @generated
	 */
	public java.lang.String sendMessage( //NOSONAR  Reason:EIAS

			it.csi.fpcommon.fpsend.dto.fpsend.RequestMessage requestMessage //NOSONAR  Reason:EIAS

			, it.csi.csi.util.DatiMessaggio datiMsg) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException;

	/**
	 * @generated
	 */
	public java.lang.String sendMessages( //NOSONAR  Reason:EIAS

			it.csi.fpcommon.fpsend.dto.fpsend.RequestMessages requestMessages //NOSONAR  Reason:EIAS

			, it.csi.csi.util.DatiMessaggio datiMsg) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException;

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.dto.fpsend.ResponseMessage sendPec( //NOSONAR  Reason:EIAS

			it.csi.fpcommon.fpsend.dto.fpsend.RequestMessage requestMessage //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException;

	/**
	 * @generated
	 */
	public it.csi.fpcommon.fpsend.dto.fpsend.ResponseRecuperaPec recuperaPec( //NOSONAR  Reason:EIAS

			it.csi.fpcommon.fpsend.dto.fpsend.RequestRecuperaPec request //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.fpcommon.fpsend.exception.fpsend.RecuperaPecException;

	/**
	 * @generated
	 */
	public boolean testResources() //NOSONAR  Reason:EIAS
			throws it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException; //NOSONAR  Reason:EIAS

	/**
	 * @generated
	 */
	public it.csi.coopdiag.api.InvocationNode selfCheck( //NOSONAR  Reason:EIAS 
			it.csi.coopdiag.api.CalledResource[] alreadyChecked) //NOSONAR  Reason:EIAS
			throws it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException; //NOSONAR  Reason:EIAS

	/**
	 * @generated
	 */
	public boolean hasSelfCheck() //NOSONAR  Reason:EIAS
			throws it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException; //NOSONAR  Reason:EIAS

}
