package domain;

public class Staff {

	private String id;
	private String firstName;
	private String middleName;
	private String lastname;
	private String dob;
	private String email;
	private String password;
	
	
	public Staff() {
		
		this.id = "";
		this.firstName = "";
		this.middleName = "";
		this.lastname = "";
		this.dob = "";
		this.email = "";
		this.password = "";
	}
	
	
	public Staff(String id, String firstName, String middleName, String lastname, String dob, String email,
			String password) {
		
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastname = lastname;
		this.dob = dob;
		this.email = email;
		this.password = password;
	}
	
	public Staff(Staff sta) {
		
		this.id = sta.id;
		this.firstName = sta.firstName;
		this.middleName = sta.middleName;
		this.lastname = sta.lastname;
		this.dob = sta.dob;
		this.email = sta.email;
		this.password = sta.password;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
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


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
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


	@Override
	public String toString() {
		return "Advisors [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastname="
				+ lastname + ", dob=" + dob + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
}
