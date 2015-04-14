package dbms.beans;

import java.sql.Date;

import dbms.Bean;
import dbms.annotations.Column;

public class HallSimpleInfo extends Bean {
	@Column(columnName="roomnum")
	public Long roomnum;
	
	@Column(columnName="name")
	public String hallname;
	
	@Column(columnName="startdate")
	public Date startdate;

	@Column(columnName="enddate")
	public Date enddate;
	
	@Column(columnName="leasenumber")
	public Long leasenumber;
	
	@Column(columnName="paymentperiod")
	public String payperiod;
}
