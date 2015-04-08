package statemachine.states.student;

import java.io.IOException;

import dialogs.impl.parking.ParkingLotNumberDialog;
import dialogs.impl.parking.ViewNearbyDialog;
import statemachine.Runner;
import statemachine.State;

public class StudentParkingViewNearbyHousingState extends State {

	@Override
	public String doState(Runner r) {
		ViewNearbyDialog d = new ViewNearbyDialog();
		try {
			int result = d.doCLIPrompt();
			switch (result) {
			case 1:
				ParkingLotNumberDialog p = new ParkingLotNumberDialog();
				p.doCLIPrompt();
				//TODO: Show details matching the lot number
				System.out.println("NOT IMPLEMENTED: Show nearby housing for lot " + p.lotNo);
			default:
				//just go back
				break;
			}
		} catch (IllegalAccessException | IOException e) {
			System.out.println("Invalid selection returned from dialog");
			e.printStackTrace();
			return this.getClass().getName();
		}
		return StudentParkingHomeState.class.getName();
	}

}
