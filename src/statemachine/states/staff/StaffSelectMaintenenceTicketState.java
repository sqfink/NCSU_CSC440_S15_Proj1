package statemachine.states.staff;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import daos.Dao;
import dbms.DatabaseManager;
import dbms.beans.LoginStaffBean;
import dbms.beans.MaintenanceTicketBean;
import dialogs.ListSelectionDialog;
import dialogs.impl.staff.StaffCompleteMaintenenceTicketDialog;
import dialogs.impl.staff.StaffMaintenanceTicketDamageDialog;
import statemachine.Runner;
import statemachine.State;

public class StaffSelectMaintenenceTicketState extends State {
	
	private List<MaintenanceTicketBean> getBeanList() throws SQLException {
		String sql = "SELECT * FROM maintnencetickets WHERE status='Pending';";
		return DatabaseManager.executeBeanQuery(sql, MaintenanceTicketBean.class);
	}
	
	private class Selector extends ListSelectionDialog<MaintenanceTicketBean> {

		public Selector(List<MaintenanceTicketBean> in) {
			super(in);
		}

		@Override
		protected String EntityPrinter(MaintenanceTicketBean element) {
			return String.format("Ticket Number: %s Issued By Student: %s Issue: %s Comments: %s", element.ticketnumber, element.createdby, element.issue, element.comments);
		} 
		
	}
	
	@Override
	public String doState(Runner r) {
		MaintenanceTicketBean b = null;
		b = (MaintenanceTicketBean)r.getKV("MaintenanceTicketBean");
		if(b == null) {
			try {
				List<MaintenanceTicketBean> l = getBeanList();
				ListSelectionDialog<MaintenanceTicketBean> dialog = new Selector(l);
				if (l.size() == 0) {
					System.out.println("There are no pending maintanence tickets");
					return StaffMainState.class.getName();
				} else {
					b = dialog.doCLIPrompt();
					LoginStaffBean lisb = (LoginStaffBean)r.getKV("LoggedInUser");
					b.changedby = lisb.id;
					r.setKV("MaintenanceTicketBean", b);
				}
			} catch (SQLException | IOException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		StaffCompleteMaintenenceTicketDialog d = new StaffCompleteMaintenenceTicketDialog();
		try {
			int result = d.doCLIPrompt();
			switch (result) {
			case 1:
				StaffMaintenanceTicketDamageDialog pd = new StaffMaintenanceTicketDamageDialog();
				pd.doCLIPrompt();
				b.damagecharges = pd.num;
				LoginStaffBean lisb = (LoginStaffBean)r.getKV("LoggedInUser");
				b.changedby = lisb.id;
				Dao.processMaintenanceTicket(b);
				r.setKV("MaintenanceTicketBean", null);
				return StaffDoTicketsMainState.class.getName();
			case 2:
				r.setKV("MaintenanceTicketBean", null);
				return StaffDoTicketsMainState.class.getName();

			default:
				throw new IOException("Invalid response returned by dialog");
			}
		} catch (IllegalAccessException | IOException e) {
			System.out.println("Erorr getting response from dialog");
			e.printStackTrace();
		}
		r.setKV("MaintenanceTicketBean", null);
		return StaffDoTicketsMainState.class.getName();
	}

}
