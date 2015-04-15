package dbms.beans;

import java.sql.Timestamp;

import dbms.Bean;
import dbms.annotations.Column;

public class ParkingRequestBean extends Bean {
	@Column(columnName="reqnumber")
	public Long reqnumber;
	
	@Column(columnName="requestlot")
	public Long requestlot;
	
	@Column(columnName="snumber")
	public Long snumber;
	
	@Column(columnName="farok")
	public Boolean farok;
	
	@Column(columnName="classification")
	public String classification;
	
	@Column(columnName="approved")
	public Boolean approved;
	
	@Column(columnName="changedon")
	public Timestamp changedon;
	
	@Column(columnName="changedby")
	public Long changedby;
	
	@Column(columnName="pending")
	public Boolean pending;
}
