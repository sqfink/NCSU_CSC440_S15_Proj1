package statemachine.states.student;

import java.io.IOException;

import dialogs.impl.student.StudentHomepageDialog;
import statemachine.Runner;
import statemachine.State;

public class StudentHomepageState extends State {

	@Override
	public String doState(Runner r) {
		StudentHomepageDialog d = new StudentHomepageDialog();
		try {
			int result = d.doCLIPrompt();
			switch(result) {
			case 1:
				return StudentHousingOptionsState.class.getName();
			case 2:
				return "StudentParkingState";
			case 3:
				System.out.println("Bye!");
				return null;
			default:
				System.out.println("Invalid selection");
				return null;
			}
		} catch (IllegalAccessException | IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
