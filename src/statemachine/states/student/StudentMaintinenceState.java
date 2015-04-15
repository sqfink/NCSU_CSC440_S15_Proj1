package statemachine.states.student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import daos.Dao;
import dbms.beans.MaintenanceTicketBean;
import dbms.beans.StudentBean;
import dialogs.impl.student.MaintinenceIssueDialog;
import dialogs.impl.student.StudentMaintinenceDialog;
import statemachine.Runner;
import statemachine.State;

public class StudentMaintinenceState extends State {

	@Override
	public String doState(Runner r) {
		StudentMaintinenceDialog d = new StudentMaintinenceDialog();
		StudentBean s = (StudentBean) r.getKV("LoggedInUser");
		try {
			MaintenanceTicketBean b = null;
			int result = d.doCLIPrompt();
			switch (result) {
			case 1:
				MaintinenceIssueDialog is =  new MaintinenceIssueDialog();
				is.doCLIPrompt();
				b = new MaintenanceTicketBean();
				b.comments = is.description;
				b.createdby = s.snumber;
				b.issue = is.issue;
				try {
					Dao.createMaintinenceTicket(b);
					System.out.println("Ticket created OK");
				} catch (SQLException e) {
					System.out.println("Failed to create ticket. Check error log for details");
					e.printStackTrace();
				}
			case 2:
				try {
					List<MaintenanceTicketBean> l = Dao.getMaintenanceTicketsByStudent(s.snumber);
					if (l == null || l.size() == 0) {
						System.out.println("No maintinence tickets exist for this user");
					} else {
						for (MaintenanceTicketBean lb : l) {
							System.out.println("Ticket " + lb.ticketnumber);
							System.out.println("\tIssue: " + lb.issue);
							System.out.println("\tDescription: " + lb.comments);
							System.out.println("\tFiled on: " + lb.createdon);
							System.out.println("\tStatus: " + lb.status);
							if (lb.changedby != null && lb.changedby != 0) {
								System.out.println("\tLast modified on: " + lb.changedon + " by staffID " + lb.changedby);
							}
						}
					}
				} catch (SQLException e) {
					System.out.println("Error retrieving maintinence tickets");
					e.printStackTrace();
				}
				break;
			case 3:
				//go back
				break;
			default:
				throw new IOException("Invalid selection returned");
			}
		} catch (IllegalAccessException | IOException e) {
			System.out.println("Unexpected input");
			e.printStackTrace();
		}
		return StudentHomepageState.class.getName();
	}

}
