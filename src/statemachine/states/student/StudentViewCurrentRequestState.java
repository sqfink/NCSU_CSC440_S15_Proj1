package statemachine.states.student;

import java.util.List;

import daos.Dao;
import dbms.beans.LeaseRequestBean;
import dbms.beans.StudentBean;
import statemachine.Runner;
import statemachine.State;

public class StudentViewCurrentRequestState extends State{

	@Override
	public String doState(Runner r) {
		StudentBean s = (StudentBean) r.getKV("LoggedInUser");
		List<LeaseRequestBean> l = Dao.getLeaseRequestsByStudent(s.snumber);
		if (l == null || l.size() == 0) {
			System.out.println("No pending lease requests");
		} else {
			for (LeaseRequestBean b : l) {
				System.out.println("Lease request " + b.reqid);
				System.out.println("\tLast changed on " + b.changedon);
				System.out.println("\tStatus: " + b.status);
			}
		}
		return StudentHousingOptionsState.class.getName();
	}

}
