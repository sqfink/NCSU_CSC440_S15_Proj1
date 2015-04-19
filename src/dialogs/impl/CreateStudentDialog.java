package dialogs.impl;

import java.sql.Date;

import dialogs.InputDialog;
import dialogs.annotations.DialogAttributes;
import dialogs.annotations.InputField;

@DialogAttributes(prompt="Enter user attributes")
public class CreateStudentDialog extends InputDialog {
	@InputField(prompt="password for new user", failMessage="Invalid password")
	public String password;
	
	@InputField(prompt="First name", failMessage="Invalid first name. Expected 1 word [a-zA-Z-]{1,32}", regex="^[a-zA-Z-]{1,32}$")
	public String firstName;
	
	@InputField(prompt="Last name", failMessage="Invalid last name. Expected 1 word [a-zA-Z-]{1,32}", regex="^[a-zA-Z-]{1,32}$")
	public String lastName;
	
	@InputField(prompt="Date of birth (YYYY-MM-DD)", failMessage="Invalid date of birth. Expected YYYY-MM-DD", regex="^\\d{4}-\\d{2}-\\d{2}$")
	public Date dob;
	
	@InputField(prompt="Phone number (as a single number)", failMessage="Expected 8-12 digit positive number", regex="^\\d{8,12}$")
	public String phone;
	
	@InputField(prompt="Alternate phone number (optional)", failMessage="Expected 8-12 digit positive number or no input", regex="^\\d{8,12}$", nullable=true)
	public String altphone;
	
	@InputField(prompt="Nationality", failMessage="Expected 1 word of 3-20 letters", regex="^[a-zA-Z]{3,20}$")
	public String nationality;
	
	@InputField(prompt="Address", failMessage="Expected ^[a-zA-Z -.0-9]{5,64}$", regex="^[a-zA-Z -.0-9]{5,64}$")
	public String address;
	
	@InputField(prompt="City", failMessage="Expected 1 word of 2-16 letters", regex="^[a-zA-Z]{2,16}$")
	public String city;
	
	@InputField(prompt="State (optional)", failMessage="Expected 2 capital letters of no input", regex="^(?:|[A-Z]{2})$", nullable=true)
	public String state;
	
	@InputField(prompt="Country", failMessage="Expected 1 word of 2-32 letters", regex="^[a-zA-Z-]{2,32}$")
	public String country;
	
	@InputField(prompt="Postal code",  failMessage="Expected 2-10 alphanumeric characters", regex="^[a-zA-Z- 0-9]{2,10}$")
	public String zip;
	
	@InputField(prompt="Special Needs (optional)", failMessage="Expected ^(?:|[a-zA-Z0-9 -,.]{1,50})$", regex="^(?:|[a-zA-Z0-9 -,.]{1,150})$", nullable=true)
	public String specialNeeds;
	
	@InputField(prompt="Comments (optional)", failMessage="Expected ^(?:|[a-zA-Z0-9 -,.]{1,150})$", regex="^(?:|[a-zA-Z0-9 -,.]{1,150})$", nullable=true)
	public String comments;
	
	@InputField(prompt="Sex M/F", failMessage="Expected M or F", regex="^(?:M|F)$")
	public String sex;
	
	@InputField(prompt="Smoker Y/N", failMessage="Expected Y or N", regex="^(?:Y|N)$")
	public String smoker;
	
	@InputField(prompt="Course of study", failMessage="Expected ^[a-zA-Z -.]{1,128}$", regex="^[a-zA-Z -.]{1,128}$")
	public String course;
	
	@InputField(prompt="Year of study (0 = freshman, 5 = graduate, 99 = guest)", failMessage="Expected a positive integer", regex="^\\d{1,2}$")
	public Long year;

	@InputField(prompt="Next of kin first name", failMessage="Invalid first name. Expected 1 word [a-zA-Z-]{1,32}", regex="^[a-zA-Z-]{1,32}$")
	public String nokfirstName;
	
	@InputField(prompt="Next of kin last name", failMessage="Invalid last name. Expected 1 word [a-zA-Z-]{1,32}", regex="^[a-zA-Z-]{1,32}$")
	public String noklastName;
	
	@InputField(prompt="Next of kin relationship", failMessage="Invalid relationship. Expected 1 word [a-zA-Z-]{1,32}", regex="^[a-zA-Z-]{1,32}$")
	public String nokRelationship;
	
	@InputField(prompt="Next of kin phone number (as a single number)", failMessage="Expected 8-12 digit positive number", regex="^\\d{8,12}$")
	public String nokphone;
	
	@InputField(prompt="Next of kin address", failMessage="Expected ^[a-zA-Z -.0-9]{5,64}$", regex="^[a-zA-Z -.0-9]{5,64}$")
	public String nokaddress;
	
	@InputField(prompt="Next of kin city", failMessage="Expected 1 word of 2-16 letters", regex="^[a-zA-Z]{2,16}$")
	public String nokcity;
	
	@InputField(prompt="Next of kin state (optional)", failMessage="Expected 2 capital letters of no input", regex="^(?:|[A-Z]{2})$", nullable=true)
	public String nokstate;
	
	@InputField(prompt="Next of kin country", failMessage="Expected 1 word of 2-32 letters", regex="^[a-zA-Z-]{2,32}$")
	public String nokcountry;
	
	@InputField(prompt="Next of kin postal code",  failMessage="Expected 2-10 alphanumeric characters", regex="^[a-zA-Z- 0-9]{2,10}$")
	public String nokzip;	
}
