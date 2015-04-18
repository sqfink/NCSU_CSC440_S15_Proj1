package statemachine.states.staff;

import java.io.IOException;

import dialogs.impl.staff.StaffDoTicketsMainDialog;
import statemachine.Runner;
import statemachine.State;

public class StaffDoTicketsMainState extends State {

	@Override
	public String doState(Runner r) {
		StaffDoTicketsMainDialog d = new StaffDoTicketsMainDialog();
		try {
			int result = d.doCLIPrompt();
			switch (result) {
			case 1:
				return StaffSelectMaintenenceTicketState.class.getName();
			case 2:
				return StaffMainState.class.getName();
			default:
				throw new IOException("Invalid response returned by dialog");
			}
		} catch (IllegalAccessException | IOException e) {
			System.out.println("Erorr getting response from dialog");
			e.printStackTrace();
		}
		return StaffMainState.class.getName();
	}

}
