package statemachine.states.student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dbms.DatabaseManager;
import dbms.beans.ParkingRequestBean;
import dbms.beans.StudentBean;
import dialogs.impl.parking.NewParkingRequestDialog;
import dialogs.impl.student.StudentParkingHomeDialog;
import statemachine.Runner;
import statemachine.State;

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
				return "ParkingLotsInfoState";
			case 3:
				
				return this.getClass().getName();
				//return "StudentCurrentParkingSpaceInfoState";
			case 4:
				return StudentParkingViewNearbyHousingState.class.getName();
			case 5:
				sql = "SELECT * FROM `parkingrequests` WHERE `snumber`=" + user.snumber + ";";
				try {
					List<ParkingRequestBean> requests = DatabaseManager.executeBeanQuery(sql, ParkingRequestBean.class);
					if (requests == null || requests.size() == 0) {
						System.out.println("No parking reqests exist.");
					} else {
						System.out.println("Request ID: " + requests.get(0).reqnumber);
						String approval = requests.get(0).approved?"Approved":"Not yet approced";
						System.out.println("Approval state: " + approval);
						
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
