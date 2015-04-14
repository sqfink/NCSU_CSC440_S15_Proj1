package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class StaffPendingHousingBean extends Bean {
	
	@Column(columnName="snumber")
	public Long snumber;
	
	@Column(columnName="reqloc1")
	public Long reqloc1;
	
	@Column(columnName="reqloc2")
	public Long reqloc2;
	
	@Column(columnName="reqloc3")
	public Long reqloc3;
	
	@Column(columnName="reqid")
	public Long reqid;
		
	public Long AssignedRoom = null;
	

	public Long AssignedPlace = null;
}
