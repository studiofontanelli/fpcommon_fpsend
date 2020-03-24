package it.csi.fpcommon.fpsend.business.fpsend.integration.dto;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendTMessaggioDto;
import it.csi.fpcommon.fpsend.dto.fpsend.Message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MessageProviderRequest  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3641077579628281650L;
	
	
	private String channel;
	private List<Message> messages;
	private Map<String, SendTMessaggioDto> sendTMessagesMap = null;
	
	public MessageProviderRequest(String channel){
		this.channel = channel;
		this.messages = new ArrayList<Message>();
		sendTMessagesMap = new LinkedHashMap<String, SendTMessaggioDto>();
	}

	public Map<String, SendTMessaggioDto> getSendTMessagesMap() {
		return sendTMessagesMap;
	}

	public String getChannel() {
		return channel;
	}

	public List<Message> getMessages() {
		return messages;
	}

	

	
	
	
	
	
	
	
}
