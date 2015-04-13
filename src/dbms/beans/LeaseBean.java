package dbms.beans;

import java.sql.Date;

import dbms.Bean;
import dbms.annotations.Column;

public class LeaseBean extends Bean {
	@Column(columnName="leasenumber")
	public Long leasenumber;
	
	@Column(columnName="hallLocation")
	public Long hallLocation;
	
	@Column(columnName="aptLocation")
	public Long aptLocation;
	
	@Column(columnName="snumber")
	public Long snumber;
	
	@Column(columnName="paymentperiod")
	public String paymentperiod;
	
	@Column(columnName="rentalperiod")
	public String rentalperiod;
	
	@Column(columnName="startdate")
	public Date startdate;
	
	@Column(columnName="ended")
	public boolean ended;
	
	@Column(columnName="active")
	public boolean active;
	
	@Column(columnName="pending")
	public boolean pending;
}
