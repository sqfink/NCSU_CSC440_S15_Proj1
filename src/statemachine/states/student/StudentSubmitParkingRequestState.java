package statemachine.states.student;

import dbms.beans.tmpstore.ParkingLotRequestStorBean;
import statemachine.Runner;
import statemachine.State;

public class StudentSubmitParkingRequestState extends State {

	@Override
	public String doState(Runner r) {
		if (r.getKV("ParkingRequest") == null) {
			System.out.println("Error: Parking request not initialized");
			return StudentNewParkingRequestState.class.getName();
		}
		ParkingLotRequestStorBean b = (ParkingLotRequestStorBean) r.getKV("ParkingRequest");
		if (b.Type == null) {
			System.out.println("Error: Parking spot type not set");
			return StudentNewParkingRequestState.class.getName();
		} 
		String sql = "SELECT COUNT(*) FROM `parkinglots` WHERE `lotnumber`=\"" + b.lotNum + "\";";
		
		return null;
	}

}
