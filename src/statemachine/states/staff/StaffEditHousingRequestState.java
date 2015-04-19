package statemachine.states.staff;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import daos.Dao;
import dbms.beans.AptDescriptorBean;
import dbms.beans.HallDescriptorBean;
import dbms.beans.LeaseBean;
import dbms.beans.StaffBean;
import dbms.beans.StaffPendingHousingBean;
import dbms.beans.StudentBean;
import dialogs.impl.staff.DescriptorPickerDialog;
import dialogs.impl.staff.StaffAssignPlaceDialog;
import dialogs.impl.staff.StaffAssignRoomDialog;
import dialogs.impl.staff.StaffEditHousingRequestDialog;
import statemachine.Runner;
import statemachine.State;

public class StaffEditHousingRequestState extends State {

	@Override
	public String doState(Runner r) {
		StaffBean staff = (StaffBean) r.getKV("LoggedInUser");
		
		if (r.getKV("CurrentStaffPendingHousingBean") == null) {
			System.out.println("Request selection failed");
			return StaffSelectPendingHousingState.class.getName();
		}
		StaffPendingHousingBean b = (StaffPendingHousingBean) r.getKV("CurrentStaffPendingHousingBean");
		
		if (r.getKV("LeaseBean") == null) {
			r.setKV("LeaseBean", new LeaseBean());
		}
		LeaseBean lease = (LeaseBean) r.getKV("LeaseBean");
		
		StaffEditHousingRequestDialog d = new StaffEditHousingRequestDialog();
		b.staffnumber = staff.staffnumber;
		try {
			StudentBean student = Dao.getStudent(b.snumber);
			
			int result = d.doCLIPrompt();
			switch (result) {
			case 1:
				List<AptDescriptorBean> la = Dao.getAptLocations(student.year);
				if (la == null || la.size() == 0) {
					System.out.println("Student does not qulify for any appartments");
				} else {
					DescriptorPickerDialog pa = new DescriptorPickerDialog(la);
					AptDescriptorBean rea = (AptDescriptorBean) pa.doCLIPrompt();
					lease.aptLocation = rea.aptLoc;
					b.AssignedPlace = rea.aptLoc;
					b.AssignedRoom = rea.roomnum;
				}
				return this.getClass().getName();
			case 2:
				List<HallDescriptorBean> lh = Dao.getHallLocations(student.year);
				DescriptorPickerDialog ph = new DescriptorPickerDialog(lh);
				HallDescriptorBean reh = (HallDescriptorBean) ph.doCLIPrompt();
				lease.hallLocation = reh.hallLoc;
				b.AssignedPlace = reh.hallLoc;
				b.AssignedRoom = reh.roomnum;
				return this.getClass().getName();
			case 3:
				if (b.AssignedPlace == null) {
					System.out.println("Residence assignment must be made before approving the request");
					return this.getClass().getName();
				}
				if (b.AssignedRoom == null) {
					System.out.println("Room assignment must be made before approving the request");
					return this.getClass().getName();
				}
				Dao.approveLeaseRequest(b);
				
				lease.active = false;
				lease.enddate = b.enddate;
				lease.startdate = b.startdate;
				lease.paymentperiod = b.paymentperiod;
				lease.snumber = student.snumber;
				Dao.createLease(lease);
				return StaffMainState.class.getName();
			case 4:
				Dao.rejectLeaseRequestByReqID(b.reqid);
				return StaffMainState.class.getName();
			case 5:
				return StaffMainState.class.getName();
			default:
				throw new IOException("Unknown result returned by dialog");
			}
		} catch (IllegalAccessException | IOException e) {
			System.out.println("Error getting result from dialog");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error retreiving data from server. Check error log for details");
			e.printStackTrace();
		}
		return this.getClass().getName();
	}

}
