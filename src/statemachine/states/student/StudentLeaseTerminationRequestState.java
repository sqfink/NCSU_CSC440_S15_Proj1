package statemachine.states.student;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import daos.Dao;
import dbms.beans.AptSimpleInfo;
import dbms.beans.HallSimpleInfo;
import dbms.beans.LeaseBean;
import dbms.beans.LeaseTerminationRequestBean;
import dbms.beans.StudentBean;
import dialogs.impl.DateDialog;
import dialogs.impl.student.LeaseTermReasonDialog;
import statemachine.Runner;
import statemachine.State;

public class StudentLeaseTerminationRequestState extends State {

	@Override
	public String doState(Runner r) {
		StudentBean s = (StudentBean) r.getKV("LoggedInUser");
		LeaseBean lb = Dao.getCurrentlLease(s.snumber);
		LeaseTerminationRequestBean tb = new LeaseTerminationRequestBean();
		if (lb == null) {
			System.out.println("No current leases exist for this user");
		} else {
			System.out.println("Current lease:");
			System.out.println("\tLease ID: " + lb.leasenumber);
			System.out.println("\tStarted: " + lb.startdate);
			System.out.println("\tEnds: " + lb.enddate);
			System.out.println("\tPayement period: " + lb.paymentperiod);
			if (lb.hallLocation != null && lb.hallLocation != 0) {
				List<HallSimpleInfo> i = Dao.getSimpleHallInfo(s.snumber, true);
				System.out.println("\tHall name: " + i.get(0).hallname);
				System.out.println("\tHall room number: " + i.get(0).roomnum);
			} else {
				List<AptSimpleInfo> i = Dao.getSimpleAptInfo(s.snumber, true);
				System.out.println("\tLocation: " + i.get(0).locationName + " Appartment #" + i.get(0).aptnum);
				System.out.println("\tRoom number: " + i.get(0).roomnum);
			}
			System.out.println();
			System.out.println("What is your requested termination date for the lease");
			DateDialog dd = new DateDialog();
			boolean first = true;
			do {
				try {
					dd.doCLIPrompt();
					tb.enddate = Date.valueOf(dd.startDate);
					if (tb.enddate.before(lb.startdate) || tb.enddate.before(new Date(System.currentTimeMillis()))) {
						System.out.println("End date must be in the future");
						continue;
					}
					if (tb.enddate.after(lb.enddate)) {
						System.out.println("End date cannot be after current lease end date");
						continue;
					}
					break;
				} catch(IllegalArgumentException | IllegalAccessException | IOException e) {
					tb.enddate = null;
					dd.startDate = null;
					System.out.println("Not a valid date, try again.");
				}
			} while (true);
			LeaseTermReasonDialog re = new LeaseTermReasonDialog();
			do {
				try {
					re.doCLIPrompt();
				} catch (IllegalAccessException | IOException e) {
					System.out.println("Invalid input");
					e.printStackTrace();
				} 
			} while(re.reason == null || re.reason.length() == 0);
			tb.reason = re.reason;
			tb.leasenumber = lb.leasenumber;
			try {
				Dao.addLeaseTerminationRequest(tb);
				System.out.println("Request submitted OK");
			} catch (SQLException e) {
				System.out.println("Faled to submit request. Check error logs for details");
				e.printStackTrace();
			}
		}
		return StudentHousingOptionsState.class.getName();
	}

}
