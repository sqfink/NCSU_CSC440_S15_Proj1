package statemachine.states.staff;

import java.io.IOException;

import dbms.beans.StaffPendingHousingBean;
import dialogs.impl.staff.StaffAssignPlaceDialog;
import dialogs.impl.staff.StaffAssignRoomDialog;
import dialogs.impl.staff.StaffEditHousingRequestDialog;
import statemachine.Runner;
import statemachine.State;

public class StaffEditHousingRequestState extends State {

	@Override
	public String doState(Runner r) {
		if (r.getKV("CurrentStaffPendingHousingBean") == null) {
			System.out.println("Request selection failed");
			return StaffSelectPendingHousingState.class.getName();
		}
		StaffPendingHousingBean b = (StaffPendingHousingBean) r.getKV("CurrentStaffPendingHousingBean");
		StaffEditHousingRequestDialog d = new StaffEditHousingRequestDialog();
		
		try {
			int result = d.doCLIPrompt();
			switch (result) {
			case 1:
				StaffAssignPlaceDialog pd = new StaffAssignPlaceDialog();
				pd.doCLIPrompt();
				b.AssignedPlace = pd.num;
				return this.getClass().getName();
			case 2:
				StaffAssignRoomDialog rd = new StaffAssignRoomDialog();
				rd.doCLIPrompt();
				b.AssignedRoom = rd.num;
				return this.getClass().getName();
			case 3:
				//TODO: update the database with the rejection
				return StaffMainState.class.getName();
			case 4:
				if (b.AssignedPlace == null) {
					System.out.println("Residence assignment must be made before approving the request");
				}
				if (b.AssignedRoom == null) {
					System.out.println("Room assignment must be made before approving the request");
				}
				//TODO: submit the data
				return StaffMainState.class.getName();
			case 5:
				return StaffMainState.class.getName();
			default:
				throw new IOException("Unknown result returned by dialog");
			}
		} catch (IllegalAccessException | IOException e) {
			System.out.println("Error getting result from dialog");
			e.printStackTrace();
		}
		return this.getClass().getName();
	}

}
