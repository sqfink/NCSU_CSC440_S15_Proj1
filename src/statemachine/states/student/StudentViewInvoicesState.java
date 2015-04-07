package statemachine.states.student;

import java.io.IOException;

import dialogs.impl.student.StudentViewInvoicesDialog;
import statemachine.Runner;
import statemachine.State;

public class StudentViewInvoicesState extends State {

	@Override
	public String doState(Runner r) {
		StudentViewInvoicesDialog d = new StudentViewInvoicesDialog();
		int result = -1;
		try {
			result = d.doCLIPrompt();
			switch (result) {
			case 1:
				return "StudentDisplayCurrentInvoice";
			case 2:
				return "StudentDisplayPastInvoices";
			case 3:
				return StudentHousingOptionsState.class.getName();
			default:
				System.out.println("Invalid selection");
				return this.getClass().getName();
			}
		} catch (IllegalAccessException | IOException e) {
			System.out.println("Error reading input");
			e.printStackTrace();
		}
		return null;
	}

}
