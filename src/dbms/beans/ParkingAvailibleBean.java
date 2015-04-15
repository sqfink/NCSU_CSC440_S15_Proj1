package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class ParkingAvailibleBean extends Bean {
	@Column(columnName="lotnumber")
	public Long lotnumber;
	
	@Column(columnName="classification")
	public String classification;
	
	@Column(columnName="count")
	public Long count;
}
