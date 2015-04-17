package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class LeaseCostsBean extends Bean {
	@Column(columnName="leasenumber")
	public Long leasenumber;
	
	@Column(columnName="snumber")
	public Long snumber;
	
	@Column(columnName="terminationfee")
	public Double terminationfee;
	
	@Column(columnName="rent")
	public Double rent;
	
	@Column(columnName="deposit")
	public Double deposit;
}
