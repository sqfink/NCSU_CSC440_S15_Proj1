package dbms;

import java.lang.annotation.Annotation;
import java.lang.annotation.AnnotationFormatError;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbms.annotations.Column;

public abstract class Bean {
	public boolean loadFromRS(ResultSet rs) {
		boolean failed = false;
		Field[] fields = this.getClass().getFields();
		for(Field field : fields) {
			field.getAnnotations();
			Annotation[] annotations = field.getAnnotations();
			for (Annotation a : annotations) {
				if (a instanceof Column) {
					Column c = (Column)a;
					try {
						if (c.columnIndex() > 0) {
							field.set(this, rs.getObject(c.columnIndex(), field.getType()));
						} else if (c.columnName().length() > 0) {
							field.set(this, rs.getObject(c.columnName(), field.getType()));
						} else {
							throw new AnnotationFormatError("Column annotation for " + this.getClass().getName() + "." + field.getName() + " did not specify an index or name");
						}
					} catch (SQLException e) {
						failed = true;
						System.err.println("SQL Error while accessing field " + field.getName());
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						failed = true;
						System.err.println("Error while accessing field " + field.getName());
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						failed = true;
						System.err.println("Access Error while setting field " + field.getName());
						e.printStackTrace();
					}
				}
			}
		}
		return failed;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder("");
		s.append(this.getClass().getName());
		s.append("(\n");
		boolean first = true;
		for (Field f : this.getClass().getFields()) {
			if (!first) {
				s.append(",\n");
			}
			first = false;
			s.append("\t");
			s.append(f.getName());
			s.append(": \"");
			try {
				s.append(f.get(this).toString());
			} catch (IllegalArgumentException | IllegalAccessException e) {
				System.err.println("Error retrieving value of field");
				e.printStackTrace();
				s.append("ERORR RETRIEVING FIELD");
			}
			s.append("\"");
		}
		s.append("\n)");
		return s.toString();
	}
}
