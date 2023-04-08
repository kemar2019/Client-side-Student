package domain;

import java.io.Serializable;

public class Message implements Serializable {
	private String senderName;
	private String message;
	
	public Message() {
		this.senderName = "";
		this.message = "";
	}

	public Message(String senderName, String message) {
		this.senderName = senderName;
		this.message = message;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [senderName=" + senderName + ", message=" + message + "]";
	}
	
	
}
