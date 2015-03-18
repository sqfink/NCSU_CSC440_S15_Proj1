package beans;

import beans.annotations.Nullable;
import beans.annotations.Optional;
import beans.annotations.PrimaryKey;

public class PlaceBean extends Bean {
	@Optional
	@PrimaryKey
	public Long place_id;
	
	public String address_line1;
	
	@Nullable
	@Optional
	public String address_line2;
	
	public String city;

	public Integer zipcode;
}
