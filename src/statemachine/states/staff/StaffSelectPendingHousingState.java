package statemachine.states.staff;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dbms.DatabaseManager;
import dbms.beans.StaffPendingHousingBean;
import dialogs.ListSelectionDialog;
import statemachine.Runner;
import statemachine.State;

public class StaffSelectPendingHousingState extends State {

	private List<StaffPendingHousingBean> getBeanList() throws SQLException {
		String sql = null; //TODO: Query goes here
		return DatabaseManager.executeBeanQuery(sql, StaffPendingHousingBean.class);
	}
	
	private class Selector extends ListSelectionDialog<StaffPendingHousingBean> {

		public Selector(List<StaffPendingHousingBean> in) {
			super(in);
		}

		@Override
		protected String EntityPrinter(StaffPendingHousingBean element) {
			// TODO Auto-generated method stub
			return null;
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
				return StaffMainState.class.getName();
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
		return StaffMainState.class.getName();
	}

}
