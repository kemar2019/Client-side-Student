package client.view;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Quary extends JPanel  {
	
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;

	/**
	 * Create the panel.
	 * @param client 
	 */
	public Quary(ClientHandler client) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		setBounds(0,0,900,670);
		setLayout(null);
		
		table = new JTable();
		table.setBounds(257, 6, 637, 658);
		add(table);
		
		JLabel lblNewLabel = new JLabel("Student name:");
		lblNewLabel.setBounds(6, 166, 97, 16);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(115, 161, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("QueryList:");
		lblNewLabel_1.setBounds(6, 68, 97, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setBounds(6, 205, 97, 16);
		add(lblNewLabel_2);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(115, 199, 130, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("tel. Number:");
		lblNewLabel_3.setBounds(6, 243, 97, 16);
		add(lblNewLabel_3);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(115, 237, 130, 26);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ID #:");
		lblNewLabel_4.setBounds(6, 127, 61, 16);
		add(lblNewLabel_4);
		
		JTextField textField_3 = new JTextField();
		textField_3.setBounds(115, 122, 130, 26);
		add(textField_3);
		textField_3.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(6, 291, 239, 209);
		add(textArea);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.setToolTipText("start a new complain");
		btnNewButton.setBounds(6, 512, 117, 29);
		add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Campus Life ", "Career Path ", "Academic Records", "Language Support", "Job Opportunities", "Cultural Adjustment", "Insurance Requirements", "Internship Opportunities", "Scholarship Applications", "Mental Health Resources", "Immigration Requirements"}));
		comboBox.setBounds(106, 64, 139, 27);
		add(comboBox);

	}

}
