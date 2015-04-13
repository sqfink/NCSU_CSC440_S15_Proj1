package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class InvoiceBean extends Bean {
	@Column(columnName="invoicenumber")
	public Long invoicenumber;
	
	@Column(columnName="snumber")
	public Long snumber;

	@Column(columnName="staffname")
	public String staffname;
	
	@Column(columnName="residencename")
	public String residencename;
	
	@Column(columnName="invoicenumber")
	public Long roomnumber;
	
	@Column(columnName="placenumber")
	public Long placenumber;
	
	@Column(columnName="leasenumber")
	public Long leasenumber;
	
	@Column(columnName="duedate")
	public String duedate;
	
	@Column(columnName="paiddate")
	public String paiddate;
	
	@Column(columnName="paymentdue")
	public Long paymentdue;
	
	@Column(columnName="paymenttype")
	public String paymenttype;
	
	@Column(columnName="location")
	public String location;
	
	@Column(columnName="department")
	public String department;
	
	@Column(columnName="position")
	public String position;
	
	@Column(columnName="dob")
	public String dob;
	
}
