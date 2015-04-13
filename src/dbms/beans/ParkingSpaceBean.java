package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class ParkingSpaceBean extends Bean {
	@Column(columnName="snumber")
	public Long snumber;
	
	@Column(columnName="spotNumber")
	public Long spotNumber;
	
	@Column(columnName="lotnumber")
	public Long lotNumber;
	
	@Column(columnName="classification")
	public String classification;
}
