package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class SimpleParkingSlot extends Bean {
	@Column(columnName="spotnumber")
	public Long spotnumber;
	
	@Column(columnName="lotnumber")
	public Long lotnumber;
	
	@Column(columnName="classification")
	public String classification;
	
	@Column(columnName="snumber")
	public Long snumber;
}
