package dbms.beans;

import dbms.annotations.Column;

public class LoginStudentBean extends StudentBean {
	@Column(columnName="id")
	public Long id;
	
	@Column(columnName="password")
	public String password;
	
}
