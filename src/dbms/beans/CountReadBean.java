package dbms.beans;

import dbms.Bean;
import dbms.annotations.Column;

public class CountReadBean extends Bean {
	@Column(columnIndex=1)
	public Long count;
}
