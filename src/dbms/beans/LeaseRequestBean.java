package dbms.beans;

import java.sql.Date;
import java.sql.Timestamp;

import dbms.Bean;
import dbms.annotations.Column;

public class LeaseRequestBean extends Bean {
	
	@Column(columnName="reqid")
	public Long reqid;
	
	@Column(columnName="snumber")
	public Long snumber;
	
	@Column(columnName="reqloc1")
	public Long reqloc1;
	
	@Column(columnName="reqloc2")
	public Long reqloc2;
	
	@Column(columnName="reqloc3")
	public Long reqloc3;
	
	@Column(columnName="status")
	public String status;
	
	@Column(columnName="paymentperiod")
	public String paymentperiod;
	
	@Column(columnName="staffnumber")
	public Long staffnumber;
	
	@Column(columnName="changedon")
	public Timestamp changedon;
	
	@Column(columnName="leasenumber")
	public Long leasenumber;

	@Column(columnName="startdate")
	public Date startdate;

	@Column(columnName="enddate")
	public Date enddate;
	
}
