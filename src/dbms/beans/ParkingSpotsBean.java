package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class ParkingSpotsBean extends Bean {
	
	@Column(columnName="spotnumber")
	public long spotnumber;

	@Column(columnName="lotnumber")
	public long lotnumber;

	@Column(columnName="classification")
	public String classification;
	
	@Column(columnName="snumber")
	public long snumber;

}
