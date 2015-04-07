package statemachine.states.student;

import statemachine.Runner;
import statemachine.State;

public class StudentViewCurrentRequestState extends State{

	@Override
	public String doState(Runner r) {
		System.out.println("Current requests view not implemented.");
		return StudentHousingOptionsState.class.getName();
	}

}
