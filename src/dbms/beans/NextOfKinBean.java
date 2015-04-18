package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class NextOfKinBean extends Bean {
	@Column(columnName="firstname")
	public String firstname;

	@Column(columnName="lastname")
	public String lastname;

	@Column(columnName="phone")
	public String phone;

	@Column(columnName="address")
	public String address;

	@Column(columnName="city")
	public String city;

	@Column(columnName="state")
	public String state;
	
	@Column(columnName="country")
	public String country;

	@Column(columnName="zip")
	public String zip;

	@Column(columnName="relationship")
	public String relationship;
	
	@Column(columnName="snumber")
	public Long snumber;
}
