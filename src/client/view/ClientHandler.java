package client.view;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import domain.ComplaintsAndQueries;
import domain.Credential;
import domain.Response;
import domain.Student;

public class ClientHandler {
	private Main main;
	private Login Login;
	
	private Socket connectionSocket;
	private static ObjectOutputStream  objOs;
	private ObjectInputStream objIs;
	private String action;
	
	public ClientHandler () {
		this.createConnection();
		//this.configureStreams();
		
	}
	
	private void createConnection() {
		try {
			connectionSocket = new Socket("127.0.0.1",8888);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private void configureStreams() {
		try {
			if (connectionSocket.isClosed()) {
				createConnection();
			}
			objIs = new ObjectInputStream(connectionSocket.getInputStream());
			objOs = new ObjectOutputStream(connectionSocket.getOutputStream());
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
	public void closeConnection() {
		try {
			objOs.close();
			objIs.close();
			connectionSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendAction(String action) {
		this.action = action;
		configureStreams();
		try { 
			objOs.writeObject(action);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void sendStudent(Student stuObj) {
		try {
			objOs.writeObject(stuObj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

		
	
	public void sendStudentId(String stuId) {
		try {
			objOs.writeObject(stuId);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendCredential(Credential cred) {
		try {
			objOs.writeObject(cred);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void sendComplaint(ComplaintsAndQueries cq) {
		try {
			objOs.writeObject(cq);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public boolean receiveResponse() {
		try {
			if (action.equalsIgnoreCase("Login Student")) {
				Response response = (Response) objIs.readObject();
	            if (response.getSuccess() && response.getMessage().equals("Authorized")) {
	            	return true;
					/*
					 * main = new Main(this); Login.setVisible(false);
					 * JOptionPane.showMessageDialog(null, "Login successful!");
					 * main.setVisible(true);
					 */
	            } else {
	                JOptionPane.showMessageDialog(null, "Login failed!");
	            }
			}
			
			/*
			 * if (action.equalsIgnoreCase("Add Student")) {
			 * 
			 * 
			 * 
			 * } if (action.equalsIgnoreCase("Delete Student")) {
			 * 
			 * 
			 * } if (action.equalsIgnoreCase("Get Student")){
			 * 
			 * 
			 * 
			 * } if (action.equalsIgnoreCase("Update Student")) {
			 * 
			 * } if (action.equalsIgnoreCase("Add Supervisor")) {
			 * 
			 * 
			 * } if (action.equalsIgnoreCase("Update Supervisor")) {
			 * 
			 * } if (action.equalsIgnoreCase("Delete Supervisor")) {
			 * 
			 * } if (action.equalsIgnoreCase("Get Supervisor")) {
			 * 
			 * 
			 * } if (action.equalsIgnoreCase("Login Supervisor")) {
			 * 
			 * 
			 * } if (action.equalsIgnoreCase("Add Advisor")) {
			 * 
			 * } if (action.equalsIgnoreCase("Update Advisor")) {
			 * 
			 * } if (action.equalsIgnoreCase("Delete Advisor")) {
			 * 
			 * } if (action.equalsIgnoreCase("Get Advisor")) {
			 * 
			 * } if (action.equalsIgnoreCase("Login Advisor")) {
			 * 
			 * 
			 * }
			 */
			 if (action.equalsIgnoreCase("Add Complaint_Query")) {
				 Response response = (Response) objIs.readObject();
				 if(response.getSuccess()){
					 JOptionPane.showMessageDialog(null, "Complaint log successful!");
					 return true;
				 }else {
					 JOptionPane.showMessageDialog(null, "Complaint log Unsuccessful!");
					 return false;
				 }
				 
			 }
				/*
				 * if (action.equalsIgnoreCase("Update Complaint_Query")) {
				 * 
				 * } if (action.equalsIgnoreCase("Update Resolved Status")) {
				 * 
				 * } if (action.equalsIgnoreCase("Assign Advisor")) {
				 * 
				 * } if (action.equalsIgnoreCase("Get Complaint_Query")) {
				 * 
				 * }if (action.equalsIgnoreCase("Get All Complaint_Query")){
				 * 
				 * }if (action.equalsIgnoreCase("Get All Complaints")){
				 * 
				 * }if (action.equalsIgnoreCase("Get All Queries")){
				 * 
				 * } if (action.equalsIgnoreCase("Get All Complaints By Category")){
				 * 
				 * }if (action.equalsIgnoreCase("Get All Queries By Category")) {
				 * 
				 * }if (action.equalsIgnoreCase("Delete Complaint_Query")) {
				 * 
				 * }if (action.equalsIgnoreCase("Get All Complaint_Query For Advisor")) {
				 * 
				 * }if (action.equalsIgnoreCase("Get All Complaint_Query For Student")) {
				 * 
				 * }if (action.equalsIgnoreCase("Get All Complaints For Advisor")){
				 * 
				 * }if (action.equalsIgnoreCase("Get All Queries For Advisor")){
				 * 
				 * } if (action.equalsIgnoreCase("Get All Complaints For Student")) {
				 * 
				 * }if (action.equalsIgnoreCase("Get All Queries For Student")) {
				 * 
				 * } if (action.equalsIgnoreCase("Add Response")) {
				 * 
				 * }if (action.equalsIgnoreCase("Update Response")) {
				 * 
				 * }if (action.equalsIgnoreCase("Delete Response")){
				 * 
				 * }if (action.equalsIgnoreCase("Get Responses")) {
				 * 
				 * }if (action.equalsIgnoreCase("Send Message")) {}
				 */
			 
			 return false;
		} catch (ClassCastException ex) {
			ex.printStackTrace();
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}catch(EOFException ex){
			System.out.println("EOF "+ ex);
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		return false;
	}

	
	
	

}
