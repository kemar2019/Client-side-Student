package domain;

import java.io.Serializable;

public class ChatMessage implements Serializable {
	private int fromId;
	private String fromUserType;
	private int toId;
	private String toUserType;
	private String message;
	
	public ChatMessage() {
		this.fromId = 0;
		this.fromUserType = "";
		this.toId = 0;
		this.toUserType = "";
		this.message = "";
	}
	
	public ChatMessage(int fromId, String fromUserType, int toId, String toUserType, String message) {
		this.fromId = fromId;
		this.fromUserType = fromUserType;
		this.toId = toId;
		this.toUserType = toUserType;
		this.message = message;
	}

	public int getFromId() {
		return fromId;
	}

	public void setFromId(int fromId) {
		this.fromId = fromId;
	}

	public String getFromUserType() {
		return fromUserType;
	}

	public void setFromUserType(String fromUserType) {
		this.fromUserType = fromUserType;
	}

	public int getToId() {
		return toId;
	}

	public void setToId(int toId) {
		this.toId = toId;
	}

	public String getToUserType() {
		return toUserType;
	}

	public void setToUserType(String toUserType) {
		this.toUserType = toUserType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ChatMessage [fromId=" + fromId + ", fromUserType=" + fromUserType + ", toId=" + toId + ", toUserType="
				+ toUserType + ", message=" + message + "]";
	}
	
	
	
}
