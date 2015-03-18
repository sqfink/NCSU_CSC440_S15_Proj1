package beans;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.json.JSONException;
import org.json.JSONObject;

import beans.annotations.Nullable;
import beans.annotations.Optional;


public abstract class Bean {
	public JSONObject toJSON() {
		try{
			Field[] fields = this.getClass().getFields();
			JSONObject j = new JSONObject();
			for(Field field : fields) {
				field.getAnnotations();
				Annotation[] annotations = field.getAnnotations();
				boolean isOptional = false;
				boolean isNullable = false;
				for (Annotation a : annotations) {
					if (a instanceof Optional) {
						isOptional = true;
					} else if (a instanceof Nullable) {
						isNullable = true;
					}
				}
				if (isOptional) {
					j.putOpt(field.getName(), field.get(this));
				} else {
					Object obj = field.get(this);
					if (!isNullable && obj == null) {
						throw new IllegalArgumentException("Field " + field.getName() + " was null but expected a value");
					}
					j.put(field.getName(), obj);
				}
			}
			return j;
		} catch (JSONException | IllegalAccessException e) {
			System.err.println("Error writing Bean to JSON");
			e.printStackTrace();
			return null;
		}
	}
	
	public String toString() {
		return toJSON().toString();
	}
	
	public Bean fromJSON(JSONObject j) {
		try{
			Field[] fields = this.getClass().getFields();
			for(Field field : fields) {
				Annotation[] annotations = field.getAnnotations();
				boolean isOptional = false;
				boolean isNullable = false;
				for (Annotation a : annotations) {
					if (a instanceof Optional) {
						isOptional = true;
					} else if (a instanceof Nullable) {
						isNullable = true;
					}
				}
				if(j.has(field.getName())) {
					if(j.get(field.getName()) == null && !isNullable) {
						throw new IllegalArgumentException("Value expected for field " + field.getName() + " but was null");
					}
					field.set(this, j.get(field.getName()));
				} else if(isOptional) {
					field.set(this, null);
				} else {
					throw new IllegalArgumentException("Expected field " + field.getName() + " was missing from JSON object");
				}
			}
		} catch (JSONException | IllegalAccessException e) {
			System.err.println("Error loading bean from JSON");
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public Bean fromJSON(String s) {
		return fromJSON(new JSONObject(s));
	}
}
