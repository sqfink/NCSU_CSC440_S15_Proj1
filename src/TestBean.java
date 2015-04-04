
import dbms.Bean;
import dbms.annotations.Column;

public class TestBean extends Bean {
	@Column(columnIndex = 1)
	public Long Id;
	
	@Column(columnIndex = 2)
	public String firstName;
	
	@Column(columnName = "rate")
	public Double rate;
}
