package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class StudentBean extends Bean {
	@Column(columnName="id")
	public Long id;
	
	@Column(columnName="password")
	public String password;
	
	@Column(columnName="snumber")
	public Long snumber;
	
	@Column(columnName="firstname")
	public String firstname;

	@Column(columnName="lastname")
	public String lastname;

	@Column(columnName="leasenumber")
	public Long leasenumber;
	
	@Column(columnName="parkingnumber")
	public Long parkingnumber;
	
	@Column(columnName="dob") //Should be ISO8601
	public String dob;
	
	@Column(columnName="phone")
	public String phone;
	
	@Column(columnName="alternatephone")
	public String alternatephone;

	@Column(columnName="nationality")
	public String nationality;
	
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

	@Column(columnName="year")
	public Long year;

	@Column(columnName="specialneeds")
	public String specialneeds;
	
	@Column(columnName="comments")
	public String comments;

	@Column(columnName="sex")
	public String sex;

	@Column(columnName="smoker")
	public String smoker;
	
	@Column(columnName="guest")
	public Boolean guest;
}
