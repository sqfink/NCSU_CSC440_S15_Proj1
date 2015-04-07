package statemachine.states.student;

import java.io.IOException;

import dialogs.impl.student.StudentHousingOptionsDialog;
import statemachine.Runner;
import statemachine.State;

public class StudentHousingOptionsState extends State {

	@Override
	public String doState(Runner r) {
		StudentHousingOptionsDialog d = new StudentHousingOptionsDialog();
		try {
			int result = d.doCLIPrompt();
			switch (result) {
			case 1:
				return StudentViewInvoicesState.class.getName();
			case 2:
				return StudentViewLeasesState.class.getName();
			case 3:
				return StudentNewRequestState.class.getName();
			case 4:
				return StudentViewCurrentRequestState.class.getName();
			case 5:
				return StudentHomepageState.class.getName();
			default:
				System.out.println("Illegal input returned by dialog");
				return this.getClass().getName();
			}
		} catch (IllegalAccessException | IOException e) {
			System.out.println("Error reading input");
			e.printStackTrace();
			return this.getClass().getName();
		}
	}

}
