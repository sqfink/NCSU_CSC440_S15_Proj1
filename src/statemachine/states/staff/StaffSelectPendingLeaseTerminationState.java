package statemachine.states.staff;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import daos.Dao;
import dbms.DatabaseManager;
import dbms.beans.InvoiceBean;
import dbms.beans.LoginStaffBean;
import dbms.beans.StaffPendingHousingBean;
import dbms.beans.tmpstore.StaffLeaseTerminationStorBean;
import dialogs.ListSelectionDialog;
import dialogs.impl.staff.StaffAssignDamagesDialog;
import dialogs.impl.staff.StaffAssignInspectionDateDialog;
import dialogs.impl.staff.StaffLeaseTerminationMainDialog;
import statemachine.Runner;
import statemachine.State;

public class StaffSelectPendingLeaseTerminationState extends State {

	public boolean validateDate(String s) {
		try {
			Date d = Date.valueOf(s);
			if (d.before(new Date(946684800))) {
				System.out.println("Specified date too far in the past");
				return false;
			}
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println("Specified date is not valid");
			return false;
		}
	}
	
	private List<StaffLeaseTerminationStorBean> getBeanList() throws SQLException {
		String sql = "SELECT * FROM leaseterminaterequest WHERE status='PENDING';";
		return DatabaseManager.executeBeanQuery(sql, StaffLeaseTerminationStorBean.class);
	}
	
	private class Selector extends ListSelectionDialog<StaffLeaseTerminationStorBean> {

		public Selector(List<StaffLeaseTerminationStorBean> in) {
			super(in);
		}

		@Override
		protected String EntityPrinter(StaffLeaseTerminationStorBean element) {
			return String.format("Lease Number:%s RequestID:%s Reason:%s", element.leasenumber, element.requestid, element.reason);
		}
		
	}
	
	@Override
	public String doState(Runner r) {
		StaffLeaseTerminationStorBean b = null;
		b = (StaffLeaseTerminationStorBean)r.getKV("StaffLeaseTerminationStorBean");
		if(b == null) {
			try {
				List<StaffLeaseTerminationStorBean> l = getBeanList();
				ListSelectionDialog<StaffLeaseTerminationStorBean> dialog = new Selector(l);
				if (l.size() == 0) {
					System.out.println("There are no pending lease termination requests");
					return StaffMainState.class.getName();
				} else {
					b = dialog.doCLIPrompt();
					LoginStaffBean lisb = (LoginStaffBean)r.getKV("LoggedInUser");
					b.staffnumber = lisb.id;
					r.setKV("StaffLeaseTerminationStorBean", b);
				}
			} catch (SQLException | IOException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		StaffLeaseTerminationMainDialog d = new StaffLeaseTerminationMainDialog();
		try {
			int result = d.doCLIPrompt();
			switch (result) {
			case 1:
				StaffAssignInspectionDateDialog ad = new StaffAssignInspectionDateDialog();
				do {
					ad.doCLIPrompt();
				} while (ad.str == null || !validateDate(ad.str));
				b.InspectionDate = ad.str;
				return this.getClass().getName();
			case 2:
				StaffAssignDamagesDialog dmg = new StaffAssignDamagesDialog();
				do {
					dmg.doCLIPrompt();
				} while (dmg.str == null);
				b.Damages = dmg.str;
				return this.getClass().getName();
			case 3:
				if(b.InspectionDate == null) {
					System.out.println("Enter an Inspection Date before approving.");
					return this.getClass().getName();
				}
				if(b.Damages == null) {
					System.out.println("Enter Damage Charges before approving. If there are no charges enter 0");
					return this.getClass().getName();
				}
				Dao.approveLeaseTerminationRequest(b);
				r.setKV("StaffLeaseTerminationStorBean", null);
				return StaffDoRequestsMainState.class.getName();
			case 4:
				Dao.rejectLeaseTerminationRequeset(b);
				r.setKV("StaffLeaseTerminationStorBean", null);
				return StaffDoRequestsMainState.class.getName();
			case 5:
				r.setKV("StaffLeaseTerminationStorBean", null);
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
