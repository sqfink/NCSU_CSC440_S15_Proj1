package dbms.beans;

import java.sql.Date;

import dbms.Bean;
import dbms.annotations.Column;

public class SemesterBean extends Bean {
	@Column(columnName="semesterid")
	public Long id;
	
	@Column(columnName="start")
	public Date start;

	@Column(columnName="end")
	public Date end;

	@Column(columnName="name")
	public String name;
	
}
