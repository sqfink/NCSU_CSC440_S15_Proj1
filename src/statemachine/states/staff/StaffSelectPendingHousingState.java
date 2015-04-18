package statemachine.states.staff;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dbms.DatabaseManager;
import dbms.beans.StaffBean;
import dbms.beans.StaffPendingHousingBean;
import dialogs.ListSelectionDialog;
import statemachine.Runner;
import statemachine.State;

public class StaffSelectPendingHousingState extends State {

	private List<StaffPendingHousingBean> getBeanList() throws SQLException {
		String sql = "SELECT * FROM newleasereq WHERE status='PENDING';"; //TODO: Query goes here
		return DatabaseManager.executeBeanQuery(sql, StaffPendingHousingBean.class);
	}
	
	private class Selector extends ListSelectionDialog<StaffPendingHousingBean> {

		public Selector(List<StaffPendingHousingBean> in) {
			super(in);
		}

		@Override
		protected String EntityPrinter(StaffPendingHousingBean element) {
			return String.format("Sudent Number:%s RequestID:%s Requested Housing Location:%s", element.snumber, element.reqid, element.reqloc1);
		}
		
	}
	
	@Override
	public String doState(Runner r) {
		try {
			r.setKV("CurrentStaffPendingHousingBean", null);
			List<StaffPendingHousingBean> l = getBeanList();
			ListSelectionDialog<StaffPendingHousingBean> d = new Selector(l);
			if (l.size() == 0) {
				System.out.println("There are no pending housing requests");
				return StaffDoRequestsMainState.class.getName();
			}
			r.setKV("CurrentStaffPendingHousingBean", d.doCLIPrompt());
			return StaffEditHousingRequestState.class.getName();
		} catch (SQLException e) {
			System.out.println("Error retrieving data from database");
			e.printStackTrace();
		} catch (IllegalAccessException | IOException e) {
			System.out.println("Error reading response from input");
			e.printStackTrace();
		}
		return StaffDoRequestsMainState.class.getName();
	}

}
