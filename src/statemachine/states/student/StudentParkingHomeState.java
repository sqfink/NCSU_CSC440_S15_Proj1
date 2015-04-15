package statemachine.states.student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import daos.Dao;
import dbms.DatabaseManager;
import dbms.beans.ParkingRequestBean;
import dbms.beans.SimpleParkingSlot;
import dbms.beans.StudentBean;
import dialogs.impl.parking.NewParkingRequestDialog;
import dialogs.impl.student.StudentParkingHomeDialog;
import statemachine.Runner;
import statemachine.State;
import sun.security.util.PendingException;

public class StudentParkingHomeState extends State {

	@Override
	public String doState(Runner r) {
		StudentParkingHomeDialog d = new StudentParkingHomeDialog();
		String sql;
		StudentBean user = (StudentBean) r.getKV("LoggedInUser"); 
		try {
			int result = d.doCLIPrompt();
			switch (result) {
			case 1:
				return StudentNewParkingRequestState.class.getName();
			case 2:
				return ParkingLotsIntoState.class.getName();
			case 3:
				SimpleParkingSlot slot = Dao.getCurrentParking(user.snumber);
				if (slot == null) {
					System.out.println("No current parking space assignment found");
				} else {
					System.out.println("Current assigned parking slot:");
					System.out.println("\tLot number:     " + slot.lotnumber);
					System.out.println("\tSpace number:   " + slot.spotnumber);
					System.out.println("\tClassification: " + slot.classification);
				}
				return this.getClass().getName();
			case 4:
				
				return StudentParkingViewNearbyHousingState.class.getName();
			case 5:
				sql = "SELECT * FROM `parkingrequests` WHERE `snumber`=" + user.snumber + ";";
				try {
					List<ParkingRequestBean> requests = DatabaseManager.executeBeanQuery(sql, ParkingRequestBean.class);
					if (requests == null || requests.size() == 0) {
						System.out.println("No parking reqests exist.");
					} else {
						for (ParkingRequestBean b : requests) {
							System.out.println("Request ID: " + b.reqnumber);
							if (b.pending) {
								System.out.println("\tRequest pending approval");
							} else {
								String approval = b.approved?"Approved":"Rejected";
								System.out.println("\tApproval state: " + approval);
							}
							if (b.changedby == null || b.changedby == 0) {
								System.out.println("\tCreated on " + b.changedon);
							} else {
								System.out.println("\tChanged on " + b.changedon + " by staffID " + b.changedby);
							}
							if (b.requestlot != null && b.requestlot != 0) {
								System.out.println("\tRequested lot number " + b.requestlot);
							}
							System.out.println("\tRequested parking slot type: " + b.classification);
						}						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return this.getClass().getName();
				//return "StudentParkingRequestStatusState";
			case 6:
				return StudentHomepageState.class.getName();
			default:
				System.out.println("Invalid value returned by dialog");
				return this.getClass().getName();
			}
		} catch (IllegalAccessException | IOException e) {
			System.out.println("Failed to get result");
			e.printStackTrace();
		}
		return null;
	}

}
