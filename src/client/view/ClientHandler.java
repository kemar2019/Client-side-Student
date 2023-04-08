package client.view;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import domain.Credential;
import domain.Student;

public class ClientHandler {
	private Main main;
	private Login Login;
	
	private Socket connectionSocket;
	private  static ObjectOutputStream  objOs;
	private ObjectInputStream objIs;
	private String action;
	
	public ClientHandler () {
		this.createConnection();
		this.configureStreams();
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
	
	
	
	public void receiveResponse() {
		try {
			if (action.equalsIgnoreCase("Login Student")) {
				Boolean flag = (Boolean) objIs.readObject();
				if (flag == true) {
			        Login.dispose();
			        JOptionPane.showMessageDialog(null,"Login Successful", "Login",JOptionPane.INFORMATION_MESSAGE);
			        main.setVisible(true);
			    }
			}
			if (action.equalsIgnoreCase("Find Student")) {
				Student student = new Student();
				student = (Student) objIs.readObject();
				if (student == null) {
					JOptionPane.showMessageDialog(null,"Record could not be found ", "find Record Status",JOptionPane.ERROR_MESSAGE);
				return;
				}	
				
			}
			
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
	}
	
	

}
