package helpers;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import daos.Dao;
import dbms.beans.InvoiceInitBean;
import dbms.beans.LeaseBean;
import dbms.beans.LeaseCostsBean;
import dbms.beans.ParkingCosts;
import dbms.beans.SemesterBean;

public class InvoiceManager {
	
	public boolean isNewMonth() {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(Dao.getLastInvoiceGenDate());
			int lastM = c.get(Calendar.MONTH);
			c.setTime(new Date(System.currentTimeMillis()));
			int curM = c.get(Calendar.MONTH);
			return lastM != curM;
		} catch (NullPointerException | SQLException e) {
			e.printStackTrace();
			return true;
		}
	}

	public boolean isNewSemester() {
		try {
			List<SemesterBean> semList = Dao.getSemesterList();
			SemesterBean lastSemester = null;
			Date lastGen = Dao.getLastInvoiceGenDate();
			lastGen = Date.valueOf(lastGen.toString().replaceAll("\\d{4}", "0000"));
			for (SemesterBean b : semList) {
				if ((lastGen.after(b.start) || lastGen.equals(b.start)) && lastGen.before(b.end)) {
					lastSemester = b;
					break;
				}
			}
			Date today = new Date(System.currentTimeMillis());
			today = Date.valueOf(today.toString().replaceAll("\\d{4}", "0000"));
			for (SemesterBean b : semList) {
				if ((today.after(b.start) || today.equals(b.start)) && today.before(b.end)) {
					return !(b == lastSemester); 
				}
			}
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public int diffMonths(Date start, Date end) {
		Calendar s = Calendar.getInstance();
		s.setTime(start);
		
		Calendar e = Calendar.getInstance();
		e.setTime(end);
		
		int dY = e.get(Calendar.YEAR) - s.get(Calendar.YEAR);
		int dM = e.get(Calendar.MONTH) - s.get(Calendar.MONTH);
		
		return dM + 12 * dY;
	}
	
	public void tryGenInvoice(LeaseBean l) {
		LeaseCostsBean costs = Dao.getCostsByLease(l.leasenumber);
		if (costs == null){
			System.out.println("Could not generate invoice for lease " + l.leasenumber + ". No costs could be found.");
			return;
		}
		InvoiceInitBean invoice = new InvoiceInitBean();
		ParkingCosts pcost = Dao.getParkingFee(l.snumber);
		invoice.leasenumber = l.leasenumber;
		double rentcosts = 0;
		double parkingcosts = 0;
		if (l.paymentperiod.equals("MONTH")) {
			rentcosts = costs.rent;
			parkingcosts = pcost.cost;
		} else { //must be semester
			List<SemesterBean> semList = Dao.getSemesterList();
			int monthsInSemester  = 1;
			for (SemesterBean s : semList) {
				if ((s.end.after(l.startdate) || s.end.equals(l.startdate)) && s.start.before(l.enddate)) {
					monthsInSemester = diffMonths(s.start, s.end);
					break;
				}	
			}
			parkingcosts = monthsInSemester * pcost.cost;
			rentcosts = monthsInSemester * costs.rent;
		}
		
		Long invoiceNum = null;
		try {
			invoiceNum = Dao.initInvoice(invoice);
		} catch (SQLException e) {
			System.out.println("Error initializing invoice");
			e.printStackTrace();
			return;
		}
		
		Dao.addLineItem(invoiceNum, rentcosts, "Rent");
		Dao.addLineItem(invoiceNum, parkingcosts, "Parking");
		if (!Dao.invoicesExistForLease(l.leasenumber)) {
			Dao.addLineItem(invoiceNum, costs.deposit, "Deposit");
		}
	}
}
