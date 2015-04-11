package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class StaffBean extends Bean {
	@Column(columnName="staffnumber")
	public Long staffnumber;
	
	@Column(columnName="staffname")
	public String staffname;

	@Column(columnName="location")
	public String location;

	@Column(columnName="department")
	public String department;

	@Column(columnName="position")
	public String dob;

	@Column(columnName="address")
	public String address;

	@Column(columnName="city")
	public String city;

	@Column(columnName="state")
	public String state;

	@Column(columnName="zip")
	public String zip;

	@Column(columnName="sex")
	public String sex;

}
