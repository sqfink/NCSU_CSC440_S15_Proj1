package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class LoginTestBean extends Bean {
	@Column(columnIndex = 1)
	public Long ID;
	
	@Column(columnIndex = 2)
	public String Username;
	
	@Column(columnIndex = 3)
	public String PasswordHash;
}
