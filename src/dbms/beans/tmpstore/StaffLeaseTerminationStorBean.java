package dbms.beans.tmpstore;

import java.sql.Date;

import dbms.Bean;
import dbms.annotations.Column;

public class StaffLeaseTerminationStorBean extends Bean {

	public String InspectionDate = null;
	
	public String Damages = null;
	
	@Column(columnName="requestid")
	public Long requestid;
	
	@Column(columnName="leasenumber")
	public Long leasenumber;
	
	@Column(columnName="reason")
	public String reason;
	
	@Column(columnName="enddate")
	public Date enddate;
	
	public Long staffnumber;

}
