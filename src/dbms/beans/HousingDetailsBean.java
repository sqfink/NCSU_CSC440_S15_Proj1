package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class HousingDetailsBean extends Bean {
	@Column(columnName="housingDetailsLocation")
	public Long location;
	
	@Column(columnName="name")
	public String name;
	
	@Column(columnName="address")
	public String address;
	
	@Column(columnName="city")
	public String city;
	
	@Column(columnName="zip")
	public String zip;
	
	@Column(columnName="phone")
	public String phone;
}
