package dbms.beans;

import java.sql.Date;

import dbms.Bean;
import dbms.annotations.Column;

public class InvoiceBean extends Bean {
	@Column(columnName="invoicenumber")
	public Long invoicenumber;
	
	@Column(columnName="snumber")
	public Long snumber;

	@Column(columnName="staffnumber")
	public String staffnumber;
	
	@Column(columnName="leasenumber")
	public Long leasenumber;
	
	@Column(columnName="duedate")
	public Date duedate;
	
	@Column(columnName="paiddate")
	public Date paiddate;
	
	@Column(columnName="paymentdue")
	public Long paymentdue;
	
	@Column(columnName="paymenttype")
	public String paymenttype;
	
}
