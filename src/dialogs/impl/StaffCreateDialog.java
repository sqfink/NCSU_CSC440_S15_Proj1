package dialogs.impl;

import java.sql.Date;

import dialogs.InputDialog;
import dialogs.annotations.DialogAttributes;
import dialogs.annotations.InputField;

@DialogAttributes(prompt="Enter user details")
public class StaffCreateDialog extends InputDialog {
	@InputField(prompt="password for new user", failMessage="Invalid password")
	public String password;
	
	@InputField(prompt="First name", failMessage="Invalid first name. Expected 1 word [a-zA-Z-]{1,32}", regex="^[a-zA-Z-]{1,32}$")
	public String firstName;
	
	@InputField(prompt="Last name", failMessage="Invalid last name. Expected 1 word [a-zA-Z-]{1,32}", regex="^[a-zA-Z-]{1,32}$")
	public String lastName;
	
	@InputField(prompt="Date of birth (YYYY-MM-DD)", failMessage="Invalid date of birth. Expected YYYY-MM-DD", regex="^\\d{4}-\\d{2}-\\d{2}$")
	public Date dob;
	
	@InputField(prompt="Department", failMessage="Invalid department. Expected 1 word [a-zA-Z-]{1,32}", regex="^[a-zA-Z-]{1,32}$")
	public String department;

	@InputField(prompt="Position", failMessage="Invalid position. Expected 1 word [a-zA-Z-]{1,32}", regex="^[a-zA-Z-]{1,32}$")
	public String position;
	
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
	
	@InputField(prompt="Sex M/F", failMessage="Expected M or F", regex="^(?:M|F)$")
	public String sex;
	
}
