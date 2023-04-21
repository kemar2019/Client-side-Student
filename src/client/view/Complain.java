package client.view;

import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import domain.ComplaintsAndQueries;
import domain.ComplaintsAndQueriesTable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Complain extends JPanel {
	private ClientHandler client;
    private ComplaintsAndQueries cq;

    private JTextField textField;
    private JTextField textField_3;
    private JScrollPane scrollPane;

    public Complain(ClientHandler client2) {
        client = client2;
        

        // Get all complaints for student
        client.sendAction("Get All Complaints For Student");
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

        // Set panel properties
        setBounds(0, 0, 900, 670);
        setLayout(null);


        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Harassment", "Discrimination", "Missing Grades",
                "Service Delivery", "Campus Security", "Facilities Related", "Academic Appeals", "Disciplinary Matters",
                "Financial Complaints" }));
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
                String cat = (String) comboBox.getSelectedItem();
                String d = textField_3.getText();
                cq = new ComplaintsAndQueries();
                String details = textArea.getText();
                cq.setType("complaint");
                cq.setCategory(cat);
                cq.setStudentId(d);
                cq.setDetails(details);

                // Add complaint
                client.sendAction("Add Complaint_Query");
                client.sendComplaint(cq);
                client.receiveResponse();

                // Refresh table
                client.sendAction("Get All Complaints For Student");
                List<ComplaintsAndQueries> resp = client.receiveObject();
                tableCreator.updateTable(resp);
            }
        });
        btnNewButton.setToolTipText("start a new complain");
        btnNewButton.setBounds(6, 447, 117, 29);
		add(btnNewButton);
		
		scrollPane = new JScrollPane(complaintsTable);
		scrollPane.setBounds(255, 6, 639, 658);
		add(scrollPane);

	}

}
