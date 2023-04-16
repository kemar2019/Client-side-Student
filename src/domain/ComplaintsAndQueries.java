package domain;

import java.io.Serializable;

public class ComplaintsAndQueries implements Serializable {

	private String id;
	private String type;
	private String studentId;
	private String category;
	private String details;
	private String dateEntered;
	private String advisorId;
	private String assignedBy;
	private Boolean resolved;
	

	public ComplaintsAndQueries() {
		this.id = "";
		this.type = "";
		this.studentId = "";
		this.category = "";
		this.details = "";
		this.dateEntered = " ";
		this.advisorId = "";
		this.assignedBy = "";
		this.resolved = false;
	}

	public ComplaintsAndQueries(String id, String type, String studentId, String category, String details, String dateEntered,
			String advisorId, String assignedBy) {
		this.id = id;
		this.type = type;
		this.studentId = studentId;
		this.category = category;
		this.details = details;
		this.dateEntered = dateEntered;
		this.advisorId = advisorId;
		this.assignedBy = assignedBy;
		this.resolved = resolved;
	}

	public ComplaintsAndQueries(ComplaintsAndQueries complaints) {
		
		this.id = complaints.id;
		this.type = complaints.type;
		this.studentId = complaints.studentId;
		this.category = complaints.category;
		this.details = complaints.details;
		this.dateEntered = complaints.dateEntered ;
		this.advisorId = complaints.advisorId;
		this.assignedBy = complaints.assignedBy;
		this.resolved = complaints.resolved;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getDateEntered() {
		return dateEntered;
	}

	public void setDateEntered(String dateEntered) {
		this.dateEntered = dateEntered;
	}

	public String getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(String advisorId) {
		this.advisorId = advisorId;
	}

	public String
	getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}

	
	public Boolean getResolved() {
		return resolved;
	}

	public void setResolved(Boolean resolved) {
		this.resolved = resolved;
	}

	@Override
	public String toString() {
		return "ComplaintsAndQueries [id=" + id + ", type=" + type + ", studentId=" + studentId + ", category="
				+ category + ", details=" + details + ", dateEntered=" + dateEntered + ", advisorId=" + advisorId
				+ ", assignedBy=" + assignedBy + ", resolved=" + resolved + "]";
	}

	
	
	
	
}
