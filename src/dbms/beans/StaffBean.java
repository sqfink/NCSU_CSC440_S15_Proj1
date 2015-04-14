package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class StaffBean extends Bean {
	@Column(columnName="staffnumber")
	public Long staffnumber;

	@Column(columnName="firstname")
	public String firstname;

	@Column(columnName="lastname")
	public String lastname;
	
	@Column(columnName="department")
	public String department;
	
	@Column(columnName="position")
	public String position;

	@Column(columnName="dob")
	public String dob;

	@Column(columnName="address")
	public String address;

	@Column(columnName="city")
	public String city;

	@Column(columnName="state")
	public String state;

	@Column(columnName="zip")
	public String zip;
	
	@Column(columnName="country")
	public String country;

	@Column(columnName="sex")
	public String sex;

}
