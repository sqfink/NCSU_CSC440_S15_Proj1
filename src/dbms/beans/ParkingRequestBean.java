package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class ParkingRequestBean extends Bean {
	@Column(columnName="reqnumber")
	public Long reqnumber;
	
	@Column(columnName="snumber")
	public Long snumber;
	
	@Column(columnName="farok")
	public Boolean farok;
	
	@Column(columnName="classification")
	public String classification;
	
	@Column(columnName="approved")
	public Boolean approved;
}
