package statemachine.states.student;

import statemachine.Runner;
import statemachine.State;

public class StudentDisplayCurrentLeaseState extends State {

	@Override
	public String doState(Runner r) {
		
		return StudentViewLeasesState.class.getName();
	}

}
