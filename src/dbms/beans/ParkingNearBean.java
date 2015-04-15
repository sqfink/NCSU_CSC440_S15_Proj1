package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class ParkingNearBean extends Bean {
	@Column(columnName="lotnumber")
	public Long lotnumber;
	
	@Column(columnName="name")
	public String name;
	
	@Column(columnName="near")
	public Long housingLocation;
	
	@Column(columnName="address")
	public String address;
	
	@Column(columnName="city")
	public String city;
	
	@Column(columnName="zip")
	public String zip;
	
	@Column(columnName="phone")
	public String phone;
}
