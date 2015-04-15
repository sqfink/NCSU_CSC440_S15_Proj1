package statemachine.states.student;

import java.util.HashMap;
import java.util.List;

import daos.Dao;
import dbms.beans.ParkingAvailibleBean;
import statemachine.Runner;
import statemachine.State;

public class ParkingLotsIntoState extends State {

	@Override
	public String doState(Runner r) {
		List<ParkingAvailibleBean> l = Dao.getParkingAvailibilities();
		if (l == null || l.size() == 0) {
			System.out.println("No parking is availivble");
		} else {
			HashMap<Long, Long[]> m = new HashMap<Long, Long[]>(); 
			for (ParkingAvailibleBean b : l) {
				if (!m.containsKey(b.lotnumber)) {
					m.put(b.lotnumber, new Long[4]);
				}
				Long[] a = m.get(b.lotnumber);
				if (b.classification.equals("Bike")) {
					a[0] = b.count;
				} else if (b.classification.equals("Handicapped")) {
					a[1] = b.count;
				} else if (b.classification.equals("Large Car")) {
					a[2] = b.count;
				} else if (b.classification.equals("Small Car")) {
					a[3] = b.count;
				} 
			}
			for (Long o : m.keySet()) {
				Long[] a = m.get(o);
				System.out.println("Lot " + o + " availible spaces:");
				System.out.println("\tBike:        " + (a[0]==null?"0":a[0].toString()));
				System.out.println("\tHandicapped: " + (a[1]==null?"0":a[1].toString()));
				System.out.println("\tLarge Car:   " + (a[2]==null?"0":a[2].toString()));
				System.out.println("\tSmall Car:   " + (a[3]==null?"0":a[3].toString()));
			}
		}
		return StudentParkingHomeState.class.getName();
	}

}
