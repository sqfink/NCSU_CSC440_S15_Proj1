package beans;

import beans.annotations.Optional;

public class Student extends Bean {
	public String firstName;
	public String lastName;
	public String phoneNumber;
	public String altPhoneNumber;
	public Place address;
	public String dob;
	public String sex;
	public String category;
	public String nationality;
	public Boolean smoker;
	public String specialNeeds;
	public Person nextOfKin;
	
	@Optional
	public Person livesWith[];
	
	@Optional
	public String additionalInfo;
	
	@Optional
	public Long housingID;
	
	@Optional
	public Long studentID;
}
