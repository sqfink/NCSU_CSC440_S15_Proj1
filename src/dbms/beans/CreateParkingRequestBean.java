package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class CreateParkingRequestBean extends Bean {
	
	@Column(columnName="snumber")
	public Long snumber;

	@Column(columnName="classification")
	public String classification;
	
	@Column(columnName="requestlot")
	public Long requestlot;
}
