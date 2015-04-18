package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class LineItemBean extends Bean {
	@Column(columnName="invoicenumber")
	public Long invoicenumber;
	
	@Column(columnName="fee")
	public Double fee;
	
	@Column(columnName="itemtype")
	public String description;
}
