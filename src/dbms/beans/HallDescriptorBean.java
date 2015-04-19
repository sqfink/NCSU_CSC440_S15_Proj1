package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class HallDescriptorBean extends Bean {
	@Column(columnName="housingDetailsLocation")
	public Long location;
	
	@Column(columnName="name")
	public String name;
	
	@Column(columnName="requiredYear")
	public Long requiredYear;
	
	@Column(columnName="snumber")
	public Long snumber;
	
	@Column(columnName="hallLocation")
	public Long hallLoc;
	
	@Column(columnName="roomnum")
	public Long roomnum;
}
