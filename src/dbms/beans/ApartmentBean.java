package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class ApartmentBean extends Bean {
	
	@Column(columnName="rent")
	public float rent;

	@Column(columnName="deposit")
	public float deposit;

	@Column(columnName="apttype")
	public String apttype;
	
	@Column(columnName="housingDetailsLocation")
	public int housingDetailsLocation;

	@Column(columnName="aptnum")
	public int aptnum;

	@Column(columnName="family")
	public int family;

}
