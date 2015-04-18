package statemachine.states.staff;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import daos.Dao;
import dbms.DatabaseManager;
import dbms.beans.LoginStaffBean;
import dbms.beans.tmpstore.StaffParkingRequestStorBean;
import dialogs.ListSelectionDialog;
import dialogs.impl.staff.StaffSelectPendingParkingMainDialog;
import statemachine.Runner;
import statemachine.State;

public class StaffSelectPendingParkingState extends State {
	
	private List<StaffParkingRequestStorBean> getBeanList() throws SQLException {
		String sql = "SELECT * FROM parkingrequests WHERE pending=1;";
		return DatabaseManager.executeBeanQuery(sql, StaffParkingRequestStorBean.class);
	}
	
	private class Selector extends ListSelectionDialog<StaffParkingRequestStorBean> {

		public Selector(List<StaffParkingRequestStorBean> in) {
			super(in);
		}

		@Override
		protected String EntityPrinter(StaffParkingRequestStorBean element) {
			return String.format("Student: %s Lot Number: %s Spot Classification: %s RequestID: %s", element.snumber, element.requestlot, element.classification, element.reqnumber);
		} 
		
	}
	
	@Override
	public String doState(Runner r) {
		StaffParkingRequestStorBean b = null;
		b = (StaffParkingRequestStorBean)r.getKV("StaffParkingRequestStorBean");
		if(b == null) {
			try {
				List<StaffParkingRequestStorBean> l = getBeanList();
				ListSelectionDialog<StaffParkingRequestStorBean> dialog = new Selector(l);
				if (l.size() == 0) {
					System.out.println("There are no pending parking requests");
					return StaffDoRequestsMainState.class.getName();
				} else {
					b = dialog.doCLIPrompt();
					LoginStaffBean lisb = (LoginStaffBean)r.getKV("LoggedInUser");
					b.changedby = lisb.id;
					r.setKV("StaffParkingRequestStorBean", b);
				}
			} catch (SQLException | IOException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		StaffSelectPendingParkingMainDialog d = new StaffSelectPendingParkingMainDialog();
		try {
			int result = d.doCLIPrompt();
			switch (result) {
			case 1:
				if(!Dao.tryApproveParkingRequest(b)) {
					System.out.println("The requested parking lot does not contain an unassigned parking spot with the requested classification");
					return this.getClass().getName();
				}
				r.setKV("StaffParkingRequestStorBean", null);
				return StaffDoRequestsMainState.class.getName();
			case 2:
				Dao.rejectParkingRequest(b);
				r.setKV("StaffParkingRequestStorBean", null);
				return StaffDoRequestsMainState.class.getName();
			case 3:
				r.setKV("StaffParkingRequestStorBean", null);
				return StaffDoRequestsMainState.class.getName();
			default:
				throw new IOException("Invalid response returned by dialog");
			}
		} catch (IllegalAccessException | IOException e) {
			System.out.println("Erorr getting response from dialog");
			e.printStackTrace();
		}
		return StaffDoRequestsMainState.class.getName();
	}

}
