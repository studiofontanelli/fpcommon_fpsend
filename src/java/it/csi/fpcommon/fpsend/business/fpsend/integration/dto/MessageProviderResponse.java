package it.csi.fpcommon.fpsend.business.fpsend.integration.dto;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendTMessaggioDto;
import it.csi.fpcommon.fpsend.dto.fpsend.Message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MessageProviderResponse  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4237904121006366853L;

	
	
	private boolean containError = false;
	private String channel;
	private List<Message> messages;
	
	private Map<String, SendTMessaggioDto> sendTMessagesMap = null;
	private Map<Integer, List<SendTMessaggioDto>> sendTMessagesByStatusMap = null;
	
	
	
	public MessageProviderResponse(String channel,List<Message> messages, Map<String, SendTMessaggioDto> sendTMessagesMap ){
		this.channel = channel;
		this.messages = messages;
		this.sendTMessagesMap = sendTMessagesMap;
		sendTMessagesByStatusMap =new LinkedHashMap<Integer, List<SendTMessaggioDto>>();
	}
	
	
	public void addSendTMessaggioToStatusMap(Integer status, SendTMessaggioDto dto){
		if(!sendTMessagesByStatusMap.containsKey(status)){
			sendTMessagesByStatusMap.put(status, new ArrayList<SendTMessaggioDto>());
		}
		sendTMessagesByStatusMap.get(status).add(dto);
	}

	public Map<Integer, List<SendTMessaggioDto>> getSendTMessaggiByStatusMap() {
		return sendTMessagesByStatusMap;
	}

	public Collection<SendTMessaggioDto> getAllSendTMessaggioDto(){
		return sendTMessagesMap.values();
	}
	
	public SendTMessaggioDto getSendTMessaggioDtoByMessage(Message message){
		return sendTMessagesMap.get(message.getPk()+"");
	}
	
	

	public String getChannel() {
		return channel;
	}

	public List<Message> getMessages() {
		return messages;
	}



	public boolean isContainError() {
		return containError;
	}



	public void setContainError(boolean containError) {
		this.containError = containError;
	}
	
	
}
