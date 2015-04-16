package statemachine.states.student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import daos.Dao;
import dbms.beans.LeaseBean;
import dbms.beans.LeaseRequestBean;
import dbms.beans.LeaseTerminationRequestBean;
import dbms.beans.StudentBean;
import dialogs.impl.student.ViewStatusPickerDialog;
import statemachine.Runner;
import statemachine.State;

public class StudentViewCurrentRequestState extends State{

	@Override
	public String doState(Runner r) {
		StudentBean s = (StudentBean) r.getKV("LoggedInUser");
		ViewStatusPickerDialog dlg = new ViewStatusPickerDialog();
		try {
			int result = dlg.doCLIPrompt();
			switch (result) {
			case 1:
				List<LeaseRequestBean> l = Dao.getLeaseRequestsByStudent(s.snumber);
				if (l == null || l.size() == 0) {
					System.out.println("No pending lease requests");
				} else {
					for (LeaseRequestBean b : l) {
						System.out.println("Lease request " + b.reqid);
						System.out.println("\tLast changed on " + b.changedon);
						System.out.println("\tStatus: " + b.status);
					}
				}
				break;
			case 2:
				LeaseBean lb = Dao.getCurrentlLease(s.snumber);
				try {
					List<LeaseTerminationRequestBean> trb = Dao.getLeaseTerminationRequestsByStudent(lb.leasenumber);
					if (trb == null || trb.size() == 0) {
						System.out.println("No lease termination requests exist");
						break;
					}
					for (LeaseTerminationRequestBean t : trb) {
						System.out.println("Lease termination request " + t.requestid);
						System.out.println("\tStatus: " + t.status);
						System.out.println("\tLast modified " + t.changedon);
						if (t.staffnumber != null && t.staffnumber != 0) {
							System.out.println("\tChanged by staff ID " + t.staffnumber);
						}
						System.out.println("\tRequested lease termination date: " + t.enddate);
						System.out.println("\tReason: " + t.reason);
					}
				} catch (SQLException | NullPointerException e) {
					System.out.println("Unable to find any pending lease termination requests");
					e.printStackTrace();
				}
				break;
			case 3:
				//return to previous
				break;
			default:
				System.out.println("Invalid input was accepted?");
				break;
			}
			
		} catch (IllegalAccessException | IOException e) {
			System.out.println("Error retreiving input");
			e.printStackTrace();
		}

		
		return StudentHousingOptionsState.class.getName();
	}

}
