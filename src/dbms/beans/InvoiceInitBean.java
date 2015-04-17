package dbms.beans;

import java.sql.Date;

import dbms.Bean;
import dbms.annotations.Column;

public class InvoiceInitBean extends Bean {
	@Column(columnName="leasenumber")
	public Long leasenumber;
	
	@Column(columnName="duedate")
	public Date duedate;
}
