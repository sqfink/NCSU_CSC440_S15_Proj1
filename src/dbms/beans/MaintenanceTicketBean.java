package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class MaintenanceTicketBean extends Bean {
	
	@Column(columnName="ticketnumber")
	public Long ticketnumber;
	
	@Column(columnName="issue")
	public String issue;
	
	@Column(columnName="createdon")
	public String createdon;
	
	@Column(columnName="status")
	public String status;
	
	@Column(columnName="createdby")
	public Long createdby;
	
	@Column(columnName="comments")
	public String comments;

}
