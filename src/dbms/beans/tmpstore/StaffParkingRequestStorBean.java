package dbms.beans.tmpstore;

import dbms.Bean;
import dbms.annotations.Column;

public class StaffParkingRequestStorBean extends Bean {
	
	public Long changedby;
	
	@Column(columnName="snumber")
	public Long snumber;
	
	@Column(columnName="requestlot")
	public Long requestlot;
	
	@Column(columnName="lreqid")
	public Long lreqid;
	
	@Column(columnName="reqnumber")
	public Long reqnumber;
	
	@Column(columnName="classification")
	public String classification;

}
