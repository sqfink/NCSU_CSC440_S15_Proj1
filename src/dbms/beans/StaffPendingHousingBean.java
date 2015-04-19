package dbms.beans;

import java.sql.Date;
import java.sql.Timestamp;

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
	
	public Long staffnumber = null;
	
	public Long AssignedRoom = null;
	
	public Long AssignedPlace = null;

	@Column(columnName="status")
	public String status;
	
	@Column(columnName="paymentperiod")
	public String paymentperiod;
	
	@Column(columnName="changedon")
	public Timestamp changedon;
	
	@Column(columnName="leasenumber")
	public Long leasenumber;

	@Column(columnName="startdate")
	public Date startdate;

	@Column(columnName="enddate")
	public Date enddate;
	
}
