package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class AptFullInfo extends Bean {

	@Column(columnName="name")
	public String locationName;

	@Column(columnName="aptnum")
	public Long aptnum;
	
	@Column(columnName="rent")
	public Double rent;

	@Column(columnName="deposit")
	public Double deposit;

	@Column(columnName="apttype")
	public String apttype;
	
	@Column(columnName="address")
	public String address;
	
	@Column(columnName="city")
	public String city;
	
	@Column(columnName="zip")
	public String zip;
	
	@Column(columnName="requiredYear")
	public Long requiredYear;
	
	@Column(columnName="phone")
	public String phone;
	
	@Column(columnName="family")
	public Boolean family;
}
