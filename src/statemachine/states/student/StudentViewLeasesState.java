package statemachine.states.student;

import java.io.IOException;

import dialogs.impl.student.StudentViewLeasesDialog;
import statemachine.Runner;
import statemachine.State;

public class StudentViewLeasesState extends State {

	@Override
	public String doState(Runner r) {
		StudentViewLeasesDialog d = new StudentViewLeasesDialog();
		try {
			int result = d.doCLIPrompt();
			switch (result) {
			case 1:
				return "StudentDisplayCurrentLease";
			case 2:
				return "StudentDisplayPastLeases";
			case 3:
				return StudentHousingOptionsState.class.getName();
			default:
				throw new IOException("Invalid result returned by prompt");
			}
		} catch (IllegalAccessException | IOException e) {
			System.out.println("Error reading input");
			e.printStackTrace();
			return null;
		}
	}

}
