package it.csi.fpcommon.fpsend.business.fpsend.helper;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendTMessaggioDto;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendTRichiestaDto;

public class ResponseInsertMessageDto {
	
	private SendTRichiestaDto sendTRichiestaDto;
	
	private SendTMessaggioDto sendTMessaggio;

	public SendTRichiestaDto getSendTRichiestaDto() {
		return sendTRichiestaDto;
	}

	public void setSendTRichiestaDto(SendTRichiestaDto sendTRichiestaDto) {
		this.sendTRichiestaDto = sendTRichiestaDto;
	}

	public SendTMessaggioDto getSendTMessaggio() {
		return sendTMessaggio;
	}

	public void setSendTMessaggio(SendTMessaggioDto sendTMessaggio) {
		this.sendTMessaggio = sendTMessaggio;
	}

	
	
	

}
