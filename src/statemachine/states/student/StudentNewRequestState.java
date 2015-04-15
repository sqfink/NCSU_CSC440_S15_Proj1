package statemachine.states.student;

import java.io.IOException;

import dialogs.impl.student.StudentNewRequestDialog;
import statemachine.Runner;
import statemachine.State;

public class StudentNewRequestState extends State {

	@Override
	public String doState(Runner r) {
		StudentNewRequestDialog d = new StudentNewRequestDialog();
		try {
			int result = d.doCLIPrompt();
			switch (result) {
			case 1:
				return StudentNewLeaseRequestState.class.getName();
			case 2:
				return StudentLeaseTerminationRequestState.class.getName();
			case 3:
				return StudentHousingOptionsState.class.getName();
			default:
				throw new IOException("Invalid result returned by prompt");
			}
		} catch (IllegalAccessException | IOException e) {
			System.out.println("Error reading input");
			e.printStackTrace();
		}
		return null;
	}

}
