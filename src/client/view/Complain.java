package client.view;

import javax.swing.JPanel;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableModel;

import domain.ComplaintsAndQueries;

import java.awt.Color;
//import java.util.ArrayList;
//import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Complain extends JPanel {
	private ClientHandler client;
	private ComplaintsAndQueries cq;
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 * @param client2 
	 */
	public Complain(ClientHandler client2) {
		client = client2;
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		setBounds(0,0,900,670);
		setLayout(null);
		
		//client.sendAction("Get All Complaint_Query For Student");
		//client.receiveResponse();
		
		table = new JTable();
		table.setBounds(257, 6, 637, 658);
		add(table);
		
		
		
		
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
			//int id = Integer.parseInt(d);
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

	}
	
	
	
	
	
}
