package statemachine.states.student;

import daos.Dao;
import dbms.beans.LeaseRequestBean;
import statemachine.Runner;
import statemachine.State;

public class SaveLeaseRequestState extends State {

	@Override
	public String doState(Runner r) {
		LeaseRequestBean b = null;
		b = (LeaseRequestBean) r.getKV("LeaseRequest");
		if (b == null) {
			System.out.println("Error submitting request. Request not found");
			return StudentNewLeaseRequestState.class.getName();
		}
		Dao.addLeaseRequest(b);
		System.out.println("Lease request submitted");
		return StudentHomepageState.class.getName();
	}

}
