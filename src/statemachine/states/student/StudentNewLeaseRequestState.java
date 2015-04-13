package statemachine.states.student;

import java.io.IOException;
import java.sql.Date;

import dbms.beans.tmpstore.LeaseRequestStorBean;
import dialogs.impl.newlease.AppartmentTypeSelectionDialog;
import dialogs.impl.newlease.HousingTypeSelectionDialog;
import dialogs.impl.newlease.LeaseLengthDialog;
import dialogs.impl.newlease.LeasePaymentOptionsDialog;
import dialogs.impl.newlease.LeaseStartDateDialog;
import dialogs.impl.newlease.NewLeaseMainDialog;
import statemachine.Runner;
import statemachine.State;

public class StudentNewLeaseRequestState extends State {

	@Override
	public String doState(Runner r) {
		LeaseRequestStorBean b = null;
		if (r.getKV("LeaseRequest") == null) {
			b = new LeaseRequestStorBean();
			r.setKV("LeaseRequest", b);
		} else {
			b = (LeaseRequestStorBean) r.getKV("LeaseRequest");
		}
		
		do {
			NewLeaseMainDialog maind = new NewLeaseMainDialog();
			try {
				int mainResult = maind.doCLIPrompt();
				switch (mainResult) {
				case 1:
					LeaseLengthDialog lend = new LeaseLengthDialog(); 
					int lenr = lend.doCLIPrompt();
					switch(lenr) {
					case 1:
						b.housingLen = "Full";
						break;
					case 2:
						b.housingLen = "Semester";
						break;
					case 3:
						System.out.println("Housing term input canceled");
						break;
					default:
						System.out.println("Invalid selection");
					}
					break;
				case 2:
					HousingTypeSelectionDialog housd = new HousingTypeSelectionDialog();
					int housr = housd.doCLIPrompt();
					switch (housr) {
					case 1:
						AppartmentTypeSelectionDialog appd = new AppartmentTypeSelectionDialog();
						int appr = appd.doCLIPrompt();
						switch (appr) {
						case 1:
							//TODO: add display and selection of location
							System.out.println("Selection of housing location not implemented");
							break;
						case 2:
							//TODO: add display and selection of location
							System.out.println("Selection of housing location not implemented");
							break;
						case 3:
							System.out.println("Housing type selection canceled");
							break;
						}
						break;
					case 2:
						//TODO: add display and selection of location
						System.out.println("Selection of housing location not implemented");
						break;
					case 3:
						System.out.println("Housing type selection canceled");
						break;
					}
					break;
				case 3:
					LeaseStartDateDialog startd = new LeaseStartDateDialog();
					Date d = null;
					do {
						try {
							startd.doCLIPrompt();
							d = Date.valueOf(startd.startDate);
							if (d.before(new Date(new java.util.Date().getTime()))) {
								System.out.println("Lease start date must be in the future");
								d = null;
							}
						} catch (IllegalArgumentException e) {
							System.out.println("Lease start date not valid");
							d = null;
						}
					} while (d == null);
					b.startDate = d.toString();
					break;
				case 4:
					LeasePaymentOptionsDialog payd = new LeasePaymentOptionsDialog();
					int payr = payd.doCLIPrompt();
					switch (payr) {
					case 1:
						b.paymentPeriod = "Month";
						break;
					case 2:
						b.paymentPeriod = "Semester";
						break;
					case 3:
						System.out.println("Payment period selection aborted");
						break;
					}
					break;
				case 5:
					System.out.println("Submitting lease request");
					return "SaveLeaseRequestState";
				case 6:
					System.out.println("New lease request discarded");
					r.setKV("LeaseRequest", null);
					return StudentHousingOptionsState.class.getName();
				default:
					throw new IOException("Illegal response returned by dialog");
				}
			} catch (IllegalAccessException | IOException e) {
				System.out.println("Error processing request");
				e.printStackTrace();
			}
		} while(true);
	}
}
