package beans;

import beans.annotations.LinkTo;
import beans.annotations.Optional;

public class PersonBean extends Bean {
	
	public String firstName;
	
	public String lastName;
	
	public String dateOfBirth;
	
	@Optional
	public String sex;
	
	public String phone_number;
	
	@Optional
	@LinkTo(className="PlaceBean")
	public Long address;
}
