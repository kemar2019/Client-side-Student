package client.view;

import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import domain.ComplaintsAndQueries;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Complain extends JPanel {
	private ClientHandler client;
	private ComplaintsAndQueries cq;
	private static Complain currentInstance;
	//private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_3;
	private  JScrollPane scrollPane;

	
	
	public Complain(ClientHandler client2) {
		currentInstance = this;
		client = client2;
		client.sendAction("Get All Complaints For Student");
		
		
		
		
		
		
		setBounds(0,0,900,670);
		setLayout(null);
		
		
		
		
		JLabel lblNewLabel = new JLabel("Student name:");
		lblNewLabel.setBounds(6, 166, 97, 16);
		add(lblNewLabel);
		
		textField = new JTextField();
		lblNewLabel.setLabelFor(textField);
		textField.setBounds(115, 161, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Harassment", "Discrimination", "Missing Grades", "Service Delivery", "Campus Security", "Facilities Related", "Academic Appeals", "Disciplinary Matters", "Financial Complaints"}));
		comboBox.setBounds(115, 64, 130, 27);
		add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Complain List:");
		lblNewLabel_1.setBounds(6, 68, 97, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("ID #:");
		lblNewLabel_4.setBounds(6, 127, 61, 16);
		add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		lblNewLabel_4.setLabelFor(textField_3);
		textField_3.setBounds(115, 122, 130, 26);
		add(textField_3);
		textField_3.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(6, 211, 239, 209);
		add(textArea);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String	cat = (String) comboBox.getSelectedItem();
			String d = textField_3.getText();
			cq = new ComplaintsAndQueries();
			client.sendAction("Add Complaint_Query");
			cq.setType("complaint");
			cq.setCategory(cat);
			cq.setStudentId(d);
			cq.setDetails("Test Details");
			client.sendComplaint(cq);
			client.receiveResponse();
				
			}
		});
		btnNewButton.setToolTipText("start a new complain");
		btnNewButton.setBounds(6, 447, 117, 29);
		add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(255, 6, 639, 658);
		add(scrollPane);

	}
	
	public static JScrollPane getScrollPane() {
        if (currentInstance == null) {
            throw new IllegalStateException("No current instance of Complain");
        }
        return currentInstance.scrollPane;
    }
	
	
	
	
	
}
