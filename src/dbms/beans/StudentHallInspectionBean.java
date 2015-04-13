package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class StudentHallInspectionBean extends Bean {

	@Column(columnName="inspectionID")
	public long inspectionID;

	@Column(columnName="staffnumber")
	public long staffnumber;

	@Column(columnName="leasenumber")
	public long leasenumber;
	
	@Column(columnName="inspectiondate")
	public String inspectiondate;

	@Column(columnName="propertycondition")
	public String propertycondition;

	@Column(columnName="comments")
	public String comments;

}
