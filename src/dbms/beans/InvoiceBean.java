package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class InvoiceBean extends Bean {
	@Column(columnName="invoicenumber")
	public Long invoicenumber;
	
	@Column(columnName="snumber")
	public Long snumber;

	@Column(columnName="staffname")
	public Long staffname;
	
	@Column(columnName="residencename")
	public Long residencename;
	
	@Column(columnName="invoicenumber")
	public Long roomnumber;
	
	@Column(columnName="placenumber")
	public Long placenumber;
	
	@Column(columnName="leasenumber")
	public Long leasenumber;
	
	@Column(columnName="duedate")
	public Long duedate;
	
	@Column(columnName="paiddate")
	public Long paiddate;
	
	@Column(columnName="paymentdue")
	public Long paymentdue;
	
	@Column(columnName="paymenttype")
	public Long paymenttype;
	
	@Column(columnName="location")
	public Long location;
	
	@Column(columnName="department")
	public Long department;
	
	@Column(columnName="position")
	public Long position;
	
	@Column(columnName="dob")
	public Long dob;
	
}
