package client.view;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import domain.ComplaintsAndQueries;
import domain.ComplaintsAndQueriesTable;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Quary extends JPanel  {
	
	private static final long serialVersionUID = 1L;
	private ComplaintsAndQueries cq;
	private ClientHandler client;
	/**
	 * Create the panel.
	 * @param client 
	 */
	public Quary(ClientHandler client) {
		this.client = client;
		 // Get all complaints for student
        client.sendAction("Get All Queries For Student");
        List<ComplaintsAndQueries> resp = client.receiveObject();

        // Create complaints table
        ComplaintsAndQueriesTable tableCreator = new ComplaintsAndQueriesTable(resp);
        JTable complaintsTable = tableCreator.createTable();
        complaintsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Allow only one row to be selected at a time
        
     // Add a listener to detect when a row is selected
        complaintsTable.addMouseListener((MouseListener) new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    List<ComplaintsAndQueries> complaints = client.receiveObject();
					// Get the ComplaintsAndQueries object for the selected row
                    ComplaintsAndQueries selectedComplaint = complaints.get(row);
                    // Perform your assign action here using the selectedComplaint object
                }
            }
        });
		
		
		setBounds(0,0,900,670);
		setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("QueryList:");
		lblNewLabel_1.setBounds(6, 68, 97, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("ID #:");
		lblNewLabel_4.setBounds(6, 127, 61, 16);
		add(lblNewLabel_4);
		
		JTextField textField_3 = new JTextField();
		textField_3.setBounds(115, 122, 130, 26);
		add(textField_3);
		textField_3.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(6, 172, 239, 209);
		add(textArea);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Campus Life ", "Career Path ", "Academic Records", "Language Support", "Job Opportunities", "Cultural Adjustment", "Insurance Requirements", "Internship Opportunities", "Scholarship Applications", "Mental Health Resources", "Immigration Requirements"}));
		comboBox.setBounds(106, 64, 139, 27);
		add(comboBox);

		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String cat = (String) comboBox.getSelectedItem();
	                String d = textField_3.getText();
	                String details = textArea.getText();
	                cq = new ComplaintsAndQueries();
	                cq.setType("query");
	                cq.setCategory(cat);
	                cq.setStudentId(d);
	                cq.setDetails(details);

	                // Add complaint
	                client.sendAction("Add Complaint_Query");
	                client.sendComplaint(cq);
	                client.receiveResponse();

	                // Refresh table
	                client.sendAction("Get All Queries For Student");
	                List<ComplaintsAndQueries> resp = client.receiveObject();
	                tableCreator.updateTable(resp);
				
				
			}
		});
		btnNewButton.setToolTipText("start a new complain");
		btnNewButton.setBounds(6, 407, 117, 29);
		add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane(complaintsTable);
		scrollPane.setBounds(255, 6, 639, 658);
		add(scrollPane);
		
	}

}
