package statemachine.states.staff;

import java.io.IOException;
import java.sql.Date;

import dbms.beans.tmpstore.StaffLeaseTerminationStorBean;
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
	
	@Override
	public String doState(Runner r) {
		StaffLeaseTerminationStorBean b = null;
		if (r.getKV("LeaseTerminationRequestBean") == null) {
			b = new StaffLeaseTerminationStorBean();
			r.setKV("LeaseTerminationRequestBean", b);
		} else {
			b = (StaffLeaseTerminationStorBean) r.getKV("LeaseTerminationRequestBean");
		}
		
		StaffLeaseTerminationMainDialog d = new StaffLeaseTerminationMainDialog();
		try {
			int result = d.doCLIPrompt();
			switch (result) {
			case 1:
				StaffAssignInspectionDateDialog ad = new StaffAssignInspectionDateDialog();
				do {
					ad.doCLIPrompt();
				} while (ad.str == null || validateDate(ad.str));
				b.InspectionDate = ad.str;
				return this.getClass().getName();
			case 2:
				StaffAssignDamagesDialog dmg = new StaffAssignDamagesDialog();
				do {
					dmg.doCLIPrompt();
				} while (dmg.str == null || validateDate(dmg.str));
				b.InspectionDate = dmg.str;
				return this.getClass().getName();
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				r.setKV("LeaseTerminationRequestBean", null);
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
