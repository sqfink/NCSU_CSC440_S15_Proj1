package dbms.beans;

import java.sql.Date;
import java.sql.Timestamp;

import dbms.Bean;
import dbms.annotations.Column;

public class LeaseTerminationRequestBean extends Bean {
	
	@Column(columnName="requestid")
	public Long requestid;
	
	@Column(columnName="leasenumber")
	public Long leasenumber; 
	
	@Column(columnName="status")
	public String status;
	
	@Column(columnName="reason")
	public String reason;
	
	@Column(columnName="enddate")
	public Date enddate;
	
	@Column(columnName="staffnumber")
	public Long staffnumber;
	
	@Column(columnName="changedon")
	public Timestamp changedon;
	
}
