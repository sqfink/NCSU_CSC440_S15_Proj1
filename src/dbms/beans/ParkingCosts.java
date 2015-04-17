package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class ParkingCosts extends Bean {
	@Column(columnName="cost")
	public Long cost;
}
