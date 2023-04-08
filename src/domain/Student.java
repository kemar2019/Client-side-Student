package domain;

import java.io.Serializable;

public class Student implements Serializable {
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dob;
	private String email;
	private String password;
	private String phone;

	public Student(int id, String firstName, String middleName, String lastName,
			String dob, String email, String password, String phone) {
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public Student() {
		this.id = 0;
		this.firstName = "";
		this.middleName = "";
		this.lastName = "";
		this.dob = "";
		this.email = "";
		this.password = "";
		this.phone = "";
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
				+ "\nEmail: " + this.email + "\n"
				+ "\nPhone: " + this.phone + "\n";
	}

}
