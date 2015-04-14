package statemachine.states.student;

import java.util.List;

import daos.Dao;
import dbms.beans.AptSimpleInfo;
import dbms.beans.HallSimpleInfo;
import dbms.beans.LeaseBean;
import dbms.beans.StudentBean;
import statemachine.Runner;
import statemachine.State;

public class StudentDisplayCurrentLeaseState extends State {

	@Override
	public String doState(Runner r) {
		StudentBean s = (StudentBean) r.getKV("LoggedInUser");
		LeaseBean b = Dao.getCurrentlLease(s.snumber);
		if (b == null) {
			System.out.println("No current leases exist for this user");
		} else {
			System.out.println("Current lease:");
			System.out.println("\tLease ID: " + b.leasenumber);
			System.out.println("\tStarted: " + b.startdate);
			System.out.println("\tEnds: " + b.enddate);
			System.out.println("\tPayement period: " + b.paymentperiod);
			if (b.hallLocation != null && b.hallLocation != 0) {
				List<HallSimpleInfo> i = Dao.getSimpleHallInfo(s.snumber, true);
				System.out.println("\tHall name: " + i.get(0).hallname);
				System.out.println("\tHall room number: " + i.get(0).roomnum);
			} else {
				List<AptSimpleInfo> i = Dao.getSimpleAptInfo(s.snumber, true);
				System.out.println("\tLocation: " + i.get(0).locationName + " Appartment #" + i.get(0).aptnum);
				System.out.println("\tRoom number: " + i.get(0).roomnum);
			}
		}
		return StudentViewLeasesState.class.getName();
	}

}
