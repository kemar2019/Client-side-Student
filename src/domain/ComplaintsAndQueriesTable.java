package domain;

import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ComplaintsAndQueriesTable {
	
	private List<ComplaintsAndQueries> complaints;
	

	public ComplaintsAndQueriesTable(List<ComplaintsAndQueries> complaints) {
	    this.complaints = complaints;
	}

	    public JTable createTable() {
	        String[] columnNames = {"ID", "Type", "StudentID", "Category", "Details", "AdvisoryID", "Assigned By", "Date Entered", "Resolved"};
	        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
	        if (complaints != null && !complaints.isEmpty()) {
	        for (ComplaintsAndQueries complaint : complaints) {
	            Object[] row = {complaint.getId(), complaint.getType(), complaint.getStudentId(), complaint.getCategory(), complaint.getDetails(), complaint.getAdvisorId(), complaint.getAssignedBy(), complaint.getDateEntered(), ""};
	            model.addRow(row);
	        }
	        }

	        JTable table = new JTable(model);
	        return table;
	    }

		public void updateTable(List<ComplaintsAndQueries> resp) {
			// TODO Auto-generated method stub
			
		}

	   
	    
}
