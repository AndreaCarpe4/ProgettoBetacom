package com.betacom.bec.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="messaggi_sistema")
public class Messaggi {
	
	@EmbeddedId
	private MessageID msgID;
	
	private String messaggio;

	public MessageID getMsgID() {
		return msgID;
	}

	public void setMsgID(MessageID msgID) {
		this.msgID = msgID;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

}