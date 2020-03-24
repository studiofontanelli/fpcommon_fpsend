package it.csi.fpcommon.fpsend.business.fpsend;

import it.csi.fpcommon.fpsend.dto.fpsend.*;

import it.csi.fpcommon.fpsend.exception.fpsend.*;

/**
 * Interfaccia locale dell'EJB che implementa il servizio fpsend.
 * @generated
 */
public interface FpsendLocal
		extends
			javax.ejb.EJBLocalObject,
			it.csi.fpcommon.fpsend.interfacecsi.fpsend.FpsendSrv {

	/**
	 * @generated
	 */
	public boolean testResources() //NOSONAR  Reason:EIAS 
			throws it.csi.csi.wrapper.CSIException; //NOSONAR  Reason:EIAS

	/**
	 * @generated
	 */
	public it.csi.coopdiag.api.InvocationNode selfCheck( //NOSONAR  Reason:EIAS 
			it.csi.coopdiag.api.CalledResource[] alreadyChecked) //NOSONAR  Reason:EIAS 
			throws it.csi.csi.wrapper.CSIException; //NOSONAR  Reason:EIAS

	/**
	 * @generated
	 */
	public boolean hasSelfCheck() //NOSONAR  Reason:EIAS
			throws it.csi.csi.wrapper.CSIException; //NOSONAR  Reason:EIAS

}
