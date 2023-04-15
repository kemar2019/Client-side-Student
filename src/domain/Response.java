package domain;

import java.io.Serializable;

public class Response implements Serializable {
	private static final long serialVersionUID = 1L;
	private Boolean success;
	private String message;

	public Response() {
		this.success = false;
		this.message = "";
	}

	public Response(Boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
