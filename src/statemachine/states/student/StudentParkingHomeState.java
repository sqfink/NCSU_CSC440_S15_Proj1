package statemachine.states.student;

import java.io.IOException;

import dialogs.impl.parking.NewParkingRequestDialog;
import dialogs.impl.student.StudentParkingHomeDialog;
import statemachine.Runner;
import statemachine.State;

public class StudentParkingHomeState extends State {

	@Override
	public String doState(Runner r) {
		StudentParkingHomeDialog d = new StudentParkingHomeDialog();
		try {
			int result = d.doCLIPrompt();
			switch (result) {
			case 1:
				return StudentNewParkingRequestState.class.getName();
			case 2:
				return "ParkingLotsInfoState";
			case 3:
				return "StudentCurrentParkingSpaceInfoState";
			case 4:
				return StudentParkingViewNearbyHousingState.class.getName();
			case 5:
				return "StudentParkingRequestStatusState";
			case 6:
				return StudentHomepageState.class.getName();
			default:
				System.out.println("Invalid value returned by dialog");
				return this.getClass().getName();
			}
		} catch (IllegalAccessException | IOException e) {
			System.out.println("Failed to get result");
			e.printStackTrace();
		}
		return null;
	}

}
