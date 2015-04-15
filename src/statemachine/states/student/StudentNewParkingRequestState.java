package statemachine.states.student;

import java.io.IOException;

import dbms.beans.CreateParkingRequestBean;
import dbms.beans.StudentBean;
import dbms.beans.tmpstore.ParkingLotRequestStorBean;
import dialogs.impl.parking.NewParkingRequestDialog;
import dialogs.impl.parking.ParkingLotNumberDialog;
import dialogs.impl.parking.ParkingTypeDialog;
import dialogs.impl.parking.SpecialParkingTypeDialog;
import dialogs.impl.student.StudentParkingHomeDialog;
import statemachine.Runner;
import statemachine.State;

public class StudentNewParkingRequestState extends State {

	@Override
	public String doState(Runner r) {
		NewParkingRequestDialog d = new NewParkingRequestDialog();
		if (r.getKV("ParkingRequest") == null) {
			r.setKV("ParkingRequest", new CreateParkingRequestBean());
		}
		CreateParkingRequestBean req = (CreateParkingRequestBean)r.getKV("ParkingRequest");
		StudentBean user = (StudentBean) r.getKV("LoggedInUser"); 
		req.snumber = user.snumber;
		try {
			int result = d.doCLIPrompt();
			switch (result) {
			case 1:
				ParkingLotNumberDialog pd = new ParkingLotNumberDialog();
				pd.doCLIPrompt();
				req.requestlot = pd.lotNo;
				break;
			case 2:
				ParkingTypeDialog ptd = new ParkingTypeDialog();
				int ptr = ptd.doCLIPrompt();
				switch (ptr) {
				case 1:
					req.classification = "Handicapped";
					break;
				case 2:
					req.classification = "Small car";
					break;
				case 3:
					req.classification = "Large car";
					break;
				case 4:
					req.classification = "Bike";
					break;
				case 5:
					System.out.println("No non-standard parkng availible at this time.");
					//SpecialParkingTypeDialog ptyped = new SpecialParkingTypeDialog();
					//ptyped.doCLIPrompt();
					//req.Type = ptyped.type;
					break;
				case 6:
					System.out.println("Parking space type selection canceled");
					break;
				default:
					throw new IOException("Invalid selection in parking type dialog");
				}
				break;
			case 3:
				return StudentSubmitParkingRequestState.class.getName();
			case 4:
				System.out.println("Pending parking request discarded");
				r.setKV("ParkingRequest", null);
				return StudentParkingHomeState.class.getName();
			default:
				throw new IOException("Invalid selection in StudentParkingHome");
			}
		} catch (IllegalAccessException | IOException e) {
			System.out.println("Failed to retrieve valid information from prompt");
			e.printStackTrace();
		}
		return this.getClass().getName();
	}

}
