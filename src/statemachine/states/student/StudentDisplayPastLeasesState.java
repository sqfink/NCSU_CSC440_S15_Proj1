package statemachine.states.student;

import java.util.List;

import daos.Dao;
import dbms.beans.AptSimpleInfo;
import dbms.beans.HallSimpleInfo;
import dbms.beans.LeaseBean;
import dbms.beans.StudentBean;
import statemachine.Runner;
import statemachine.State;

public class StudentDisplayPastLeasesState extends State {

	@Override
	public String doState(Runner r) {
		StudentBean s = (StudentBean) r.getKV("LoggedInUser");
		List<LeaseBean> b = Dao.getPastLeases(s.snumber);
		if (b == null || b.size() == 0) {
			System.out.println("No past leases exist for this user");
		} else {
			List<HallSimpleInfo> h = Dao.getSimpleHallInfo(s.snumber, false);
			List<AptSimpleInfo> a = Dao.getSimpleAptInfo(s.snumber, false);
			
			for (int i = 0; i < b.size(); i++) {
				System.out.println("Past lease " + (i+1) + ":");
				if (b.get(i).hallLocation != null && b.get(i).hallLocation != 0) {
					for (HallSimpleInfo l : h) {
						if (l.leasenumber != b.get(i).leasenumber)
							continue;
						System.out.println("\tLease ID: " + l.leasenumber);
						System.out.println("\tStarted: " + l.startdate);
						System.out.println("\tEnded: " + l.enddate);
						System.out.println("\tPayement period: " + l.payperiod);
						System.out.println("\tHall name: " + l.hallname);
						System.out.println("\tHall room number: " + l.roomnum);
						break;
					}
					
				} else {
					for (AptSimpleInfo l : a) {
						if (l.leasenumber != b.get(i).leasenumber)
							continue;
						System.out.println("\tLease ID: " + l.leasenumber);
						System.out.println("\tStarted: " + l.startdate);
						System.out.println("\tEnded: " + l.enddate);
						System.out.println("\tPayement period: " + l.payperiod);
						System.out.println("\tLocation: " + l.locationName + " Appartment #" + l.aptnum);
						System.out.println("\tRoom number: " + l.roomnum);
						break;
					}
				}
			}
		}
		return StudentViewLeasesState.class.getName();
	}

}
