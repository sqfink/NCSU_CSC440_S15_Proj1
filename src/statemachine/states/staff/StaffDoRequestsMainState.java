package statemachine.states.staff;

import java.io.IOException;

import dbms.beans.StaffPendingHousingBean;
import dialogs.impl.staff.StaffRequestsMainDialog;
import statemachine.Runner;
import statemachine.State;

public class StaffDoRequestsMainState extends State {

	@Override
	public String doState(Runner r) {
		StaffRequestsMainDialog d = new StaffRequestsMainDialog();
		try {
			int result = d.doCLIPrompt();
			switch (result) {
			case 1:
				return StaffSelectPendingHousingState.class.getName();
			case 2:
				return StaffSelectPendingLeaseTerminationState.class.getName();
			case 3:
				return StaffSelectPendingParkingState.class.getName();
			case 4:
				return StaffMainState.class.getName();
			default:
				throw new IOException("Failed to read from input");
			}
		} catch (IllegalAccessException | IOException e) {
			System.out.println("Error reeading dialog result");
			e.printStackTrace();
		}
		return this.getClass().getName();
	}

}
