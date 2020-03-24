package it.csi.fpcommon.fpsend.business.fpsend.helper;

import it.csi.fpcommon.fpsend.dto.fpsend.RequestRecuperaPec;
import it.csi.fpcommon.fpsend.dto.fpsend.ResponseRecuperaPec;
import it.csi.fpcommon.fpsend.exception.fpsend.RecuperaPecException;
import it.legalmail.client.imap.Folder;

import java.io.IOException;

import javax.mail.MessagingException;

public interface PecHelper {

	ResponseRecuperaPec recuperaPec( RequestRecuperaPec request) throws RecuperaPecException;

	boolean isMessageReceived(Folder folder, String messageID) throws MessagingException, IOException;

}
