package statemachine.states.student;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import daos.Dao;
import dbms.beans.AptFullInfo;
import dbms.beans.HousingDetailsBean;
import dbms.beans.LeaseRequestBean;
import dbms.beans.SemesterBean;
import dbms.beans.StudentBean;
import dialogs.impl.DateDialog;
import dialogs.impl.newlease.AppartmentTypeSelectionDialog;
import dialogs.impl.newlease.AptDataListDailog;
import dialogs.impl.newlease.HousingLocationSelectDialog;
import dialogs.impl.newlease.HousingTypeSelectionDialog;
import dialogs.impl.newlease.LeasePaymentOptionsDialog;
import dialogs.impl.newlease.NewLeaseMainDialog;
import statemachine.Runner;
import statemachine.State;

public class StudentNewLeaseRequestState extends State {

	@Override
	public String doState(Runner r) {
		StudentBean s = (StudentBean) r.getKV("LoggedInUser");
		LeaseRequestBean b = null;
		if (r.getKV("LeaseRequest") == null) {
			b = new LeaseRequestBean();
			b.snumber = s.snumber;
			r.setKV("LeaseRequest", b);
		} else {
			b = (LeaseRequestBean) r.getKV("LeaseRequest");
		}
		
		do {
			NewLeaseMainDialog maind = new NewLeaseMainDialog();
			try {
				int mainResult = maind.doCLIPrompt();
				switch (mainResult) {
				case 1:
					List<HousingDetailsBean> locs = Dao.getHousingLocations(s.year);
					if (locs == null || locs.size() == 0) {
						System.out.println("No housing locations availible to this user");
						break;
					}
					HousingLocationSelectDialog locd = new HousingLocationSelectDialog(locs);
					for (int i = 0; i < 3; i++) {
						HousingDetailsBean locb =  (HousingDetailsBean) locd.doCLIPrompt();
						switch(i) {
						case 0:
							b.reqloc1 = locb.location;
							break;
						case 1:
							if (locb != null)
								b.reqloc2 = locb.location;
							break;
						case 2:
							if (locb != null)
								b.reqloc2 = locb.location;
							break;
						}
						if (i == 0)
							locs.add(null);
						if (locb == null)
							break;
					}
					break;
				case 2:
					List<SemesterBean> l = Dao.getSemesterList();
					System.out.println("Semesters:");
					for (SemesterBean lb : l) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd");
						System.out.println("\t" + lb.name + " starts " + dateFormat.format(lb.start) + " ends " + dateFormat.format(lb.end));
					}
					System.out.println("Lease start date:");
					DateDialog startd = new DateDialog();
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
					b.startdate = d;
					System.out.println("Lease end date:");
					d = null;
					do {
						try {
							startd.doCLIPrompt();
							d = Date.valueOf(startd.startDate);
							if (d.before(new Date(new java.util.Date().getTime()))) {
								System.out.println("Lease end date must be after the selected start date of " + b.startdate);
								d = null;
							}
						} catch (IllegalArgumentException e) {
							System.out.println("Lease end date not valid");
							d = null;
						}
					} while (d == null);
					b.enddate = d;
					break;
				case 3:
					LeasePaymentOptionsDialog payd = new LeasePaymentOptionsDialog();
					int payr = payd.doCLIPrompt();
					switch (payr) {
					case 1:
						b.paymentperiod = "MONTH";
						break;
					case 2:
						b.paymentperiod = "SEMESTER";
						break;
					case 3:
						System.out.println("Payment period selection aborted");
						break;
					}
					break;
				case 4:
					System.out.println("Submitting lease request");
					r.setKV("LeaseRequest", b);
					return SaveLeaseRequestState.class.getName();
				case 5:
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
