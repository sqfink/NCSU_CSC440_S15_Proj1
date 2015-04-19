package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class AptDescriptorBean extends Bean {
	@Column(columnName="housingDetailsLocation")
	public Long location;
	
	@Column(columnName="name")
	public String name;
	
	@Column(columnName="requiredYear")
	public Long requiredYear;
	
	@Column(columnName="snumber")
	public Long snumber;
	
	@Column(columnName="aptLocation")
	public Long aptLoc;
	
	@Column(columnName="roomnum")
	public Long roomnum;
	
	@Column(columnName="aptnum")
	public Long aptnum;
}
