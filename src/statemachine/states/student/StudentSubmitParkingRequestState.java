package statemachine.states.student;

import java.sql.SQLException;

import daos.Dao;
import dbms.beans.CreateParkingRequestBean;
import dbms.beans.ParkingRequestBean;
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
		
		CreateParkingRequestBean b = (CreateParkingRequestBean) r.getKV("ParkingRequest");
		if (b.classification == null) {
			System.out.println("Error: Parking spot type not set");
			return StudentNewParkingRequestState.class.getName();
		}
		if (b.requestlot == null) {
			System.out.println("Notice: No lot number request added");
		}

		try {
			Dao.insertParkingRequestBean(b);
			System.out.println("Parking request submitted");
			return StudentHomepageState.class.getName();
		} catch (SQLException e) {
			System.out.println("Unable to submit request. Invalid lot number.");
			e.printStackTrace();
			return StudentNewParkingRequestState.class.getName();
		}
		
	}

}
