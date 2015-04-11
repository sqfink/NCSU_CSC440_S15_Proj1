package dbms.beans;

import dbms.annotations.Column;

public class LoginStaffBean extends StaffBean {
	@Column(columnName="id")
	public Long id;
	
	@Column(columnName="password")
	public String password;
	
}
