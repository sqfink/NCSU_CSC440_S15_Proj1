package dbms.beans;

import java.sql.Date;
import java.sql.Timestamp;

import dbms.Bean;
import dbms.annotations.Column;

public class MaintenanceTicketBean extends Bean {
	
	@Column(columnName="ticketnumber")
	public Long ticketnumber;
	
	@Column(columnName="issue")
	public String issue;
	
	@Column(columnName="createdon")
	public Date createdon;
	
	@Column(columnName="status")
	public String status;
	
	@Column(columnName="createdby")
	public Long createdby;
	
	@Column(columnName="comments")
	public String comments;
	
	@Column(columnName="changedby")
	public Long changedby;

	@Column(columnName="changedon")
	public Timestamp changedon;

}
