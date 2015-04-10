package statemachine.states.staff;

import java.io.IOException;

import dialogs.impl.staff.StaffMainDialog;
import statemachine.Runner;
import statemachine.State;

public class StaffMainState extends State {

	@Override
	public String doState(Runner r) {
		StaffMainDialog d = new StaffMainDialog();
		try {
			int result = d.doCLIPrompt();
			switch (result) {
			case 1:
				return StaffDoRequestsMainState.class.getName();
			case 2:
				return "StaffDoTicketsMainState";
			case 3:
				System.out.println("Bye!");
				return null;
			default:
				throw new IOException("Unextpected result returned from prompt");
			}
		} catch (IllegalAccessException | IOException e) {
			System.out.println("Unexpected error reading input");
			e.printStackTrace();
		}
		return this.getClass().getName();
	}

}
