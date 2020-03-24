package it.csi.fpcommon.fpsend.business.fpsend.helper;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendTMessaggioDto;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendTRichiestaDto;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseInsertMessagesDto {
	
	private SendTRichiestaDto sendTRichiestaDto;
	
	private Map<Integer, SendTMessaggioDto> sendTMessageDtoMap;
	
	
	public ResponseInsertMessagesDto(){
		sendTMessageDtoMap = new LinkedHashMap<Integer, SendTMessaggioDto>();
	}
	

	public Map<Integer, SendTMessaggioDto> getSendTMessageDtoMap() {
		return sendTMessageDtoMap;
	}

	public void setSendTMessageDtoMap(Map<Integer, SendTMessaggioDto> sendTMessageDtoMap) {
		this.sendTMessageDtoMap = sendTMessageDtoMap;
	}

	public SendTRichiestaDto getSendTRichiestaDto() {
		return sendTRichiestaDto;
	}

	public void setSendTRichiestaDto(SendTRichiestaDto sendTRichiestaDto) {
		this.sendTRichiestaDto = sendTRichiestaDto;
	}

	
	
	

}
