package dialogs;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.annotation.Annotation;
import java.lang.annotation.AnnotationFormatError;
import java.lang.reflect.Field;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dialogs.annotations.DialogAttributes;
import dialogs.annotations.InputField;

public abstract class InputDialog {
	private boolean hasPrompt = false;
	
	protected String getInput(InputStream inStream) throws IOException {
		String buf = "";
		int b = -1;
		while ((b = inStream.read()) != -1 && (char)b != '\n') {
			if ((char)b != '\n' && (char)b != '\r')
				buf += (char)b;
		}
		return buf;
	}
	
	protected String doField(InputField f, PrintStream outStream, InputStream inStream, boolean nullable) throws IOException {
		Pattern p = Pattern.compile(f.regex());
		Matcher match = null;
		do {
			if (hasPrompt)
				outStream.print("\t");
			outStream.print(f.prompt() + ": ");
			String line = getInput(inStream);
			if ((line == null || line.length() == 0) && nullable) {
				return "";
			}
			if (line == null || line.length() == 0) {
				outStream.println(f.failMessage());
				continue;
			}
			match = p.matcher(line);
			if (match == null || !match.matches())
				outStream.println(f.failMessage());
		} while (match == null || !match.matches());
		return match.group(0);
	}
	
	public void doCLIPrompt() throws IllegalAccessException, IOException {
		doCLIPrompt(System.out, System.in);
	}
	
	public void doCLIPrompt(PrintStream outStream, InputStream inStream) throws IllegalAccessException, IOException {
		Annotation[] classAnnotations = this.getClass().getAnnotations();
		boolean configuredOk = false;
		for (Annotation a : classAnnotations) {
			if (a instanceof DialogAttributes) {
				DialogAttributes d = (DialogAttributes) a;
				if (d.prompt().length() > 0) {
					hasPrompt = true;
					outStream.println(d.prompt() + ":");
				}
				configuredOk = true;
				break;
			}
		}
		if (!configuredOk) {
			throw new AnnotationFormatError("DialogAttributes annotation was expected but not present");
		}
		
		Field[] fields = this.getClass().getFields();
		for(Field field : fields) {
			field.getAnnotations();
			Annotation[] annotations = field.getAnnotations();
			for (Annotation a : annotations) {
				if (a instanceof InputField) {
					InputField f = (InputField)a;
					String strVal = doField(f, outStream, inStream, f.nullable());
					Class<?> fieldType = field.getType();
					Object value = null;
					if (fieldType == Integer.class) {
						value = new Integer(strVal);
					} else if (fieldType == String.class) {
						value = strVal;
					} else if (fieldType == Double.class) {
						value = new Double(strVal);
					} else if (fieldType == Character.class) {
						value = new Character(strVal.charAt(0));
					} else if (fieldType == Long.class) {
						value = new Long(strVal);
					} else if (fieldType == Float.class) {
						value = new Float(strVal);
					} else if (fieldType == Short.class) {
						value = new Short(strVal);
					} else if (fieldType == Date.class) {
						do {
							try {
								value = Date.valueOf(strVal);
							} catch (IllegalArgumentException ex) {
								System.out.println("Not a valid date");
								strVal = doField(f, outStream, inStream, f.nullable());
								value = null;
							}
						} while (value == null);
					} else {
						throw new IllegalAccessException("No supported conversion availible for field type " + fieldType.getName());
					}
					field.set(this, value);
				}
			}
		}
	}
}
