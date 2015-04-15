package statemachine.states.student;

import java.io.IOException;
import java.util.List;

import daos.Dao;
import dbms.beans.ParkingNearBean;
import dbms.beans.StudentBean;
import dialogs.impl.parking.ParkingLotNumberDialog;
import dialogs.impl.parking.ViewNearbyDialog;
import statemachine.Runner;
import statemachine.State;

public class StudentParkingViewNearbyHousingState extends State {

	@Override
	public String doState(Runner r) {
		ViewNearbyDialog d = new ViewNearbyDialog();
		StudentBean user = (StudentBean) r.getKV("LoggedInUser"); 
		try {
			int result = d.doCLIPrompt();
			switch (result) {
			case 1:
				ParkingLotNumberDialog p = new ParkingLotNumberDialog();
				p.doCLIPrompt();
				
				List<ParkingNearBean> b = Dao.getParkingNear(p.lotNo);
				System.out.println("Housing near lot " + p.lotNo);
				for (ParkingNearBean bs : b) {
					System.out.println("Housing location: " + bs.name);
					System.out.println("\tAddress: " + bs.address + " " + bs.city + ", " + bs.zip);
					System.out.println("\tPhone number: " + bs.phone);
				}
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
