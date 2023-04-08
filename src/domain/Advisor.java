package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Advisor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	
	
	private String firstName;
	
	
	private String middleName;
	
	
	private String lastName;
	
	
	private String dob;
	
	
	private String email;
	
	
	private String password;

	public Advisor() {
		this.id = 0;
		this.firstName = "";
		this.middleName = "";
		this.lastName = "";
		this.dob = "";
		this.email = "";
		this.password = "";
	}
	
	public Advisor(int id, String firstName, String middleName, String lastName, String dob, String email,
			String password) {
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}

	@Override
	public String toString()
	{
		return "ID#:" + this.id
				+ "\nFirst Name: " + this.firstName
				+ "\nMiddle Name: " + this.middleName
				+ "\nLastName: " + this.lastName
				+ "\nDOB: " + this.dob
				+ "\nEmail: " + this.email + "\n";
	}

	
}
