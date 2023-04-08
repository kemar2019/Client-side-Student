package domain;

import java.io.Serializable;

public class Credential implements Serializable {
	private int id;
	private String password;
	
	public Credential() {
		this.id = 0;
		this.password = "";
	}

	public Credential(int id, String password) {
		this.id = id;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Credential [id=" + id + ", password=" + password + "]";
	}
	
	
}
