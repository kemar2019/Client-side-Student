package domain;

import java.io.Serializable;

public class CQResponse implements Serializable {
	private int id;
	private int c_q_id;
	private String response;
	private String responseTime;
	
	public CQResponse() {
		this.id = 0;
		this.c_q_id = 0;
		this.response = "";
		this.responseTime = "";
	}

	public CQResponse(int id, int c_q_id, String response, String responseTime) {
		this.id = id;
		this.c_q_id = c_q_id;
		this.response = response;
		this.responseTime = responseTime;
	}
	
	public CQResponse(CQResponse responses) {
		this.id = responses.id;
		this.c_q_id = responses.c_q_id;
		this.response = responses.response;
		this.responseTime = responses.responseTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getC_q_id() {
		return c_q_id;
	}

	public void setC_q_id(int c_q_id) {
		this.c_q_id = c_q_id;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

	@Override
	public String toString() {
		return "Responses [id=" + id + ", c_q_id=" + c_q_id + ", response=" + response + ", responseTime="
				+ responseTime + "]";
	}
	
	

}
