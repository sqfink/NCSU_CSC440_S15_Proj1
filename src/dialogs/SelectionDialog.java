package dialogs;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.annotation.Annotation;
import java.lang.annotation.AnnotationFormatError;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;


public abstract class SelectionDialog {
	
	protected String getInput(InputStream inStream) throws IOException {
		String buf = "";
		int b = -1;
		while ((b = inStream.read()) != -1 && (char)b != '\n') {
			if ((char)b != '\n' && (char)b != '\r')
				buf += (char)b;
		}
		return buf;
	}
	
	protected Integer doInput(int maxId, PrintStream outStream, InputStream inStream) throws IOException {
		Pattern p = Pattern.compile("^\\d+$");
		Matcher match = null;
		do {
			outStream.print("Selection: ");
			String line = getInput(inStream);
			if (line == null || line.length() == 0) {
				outStream.println("Invalid input");
				continue;
			}
			match = p.matcher(line);
			if (match == null || !match.matches()) {
				outStream.println("Invalid option");
			} else if (new Integer(match.group(0)) < 1 || new Integer(match.group(0)) > maxId) {
				outStream.println("Selection out of bounds");
				match = null;
			}
		} while (match == null || !match.matches());
		return new Integer(match.group(0));
	}
	
	public int doCLIPrompt() throws IllegalAccessException, IOException {
		return doCLIPrompt(System.out, System.in);
	}
	
	public int doCLIPrompt(PrintStream outStream, InputStream inStream) throws IllegalAccessException, IOException {
		Annotation[] classAnnotations = this.getClass().getAnnotations();
		SelectionOptions d = null;
		boolean configuredOk = false;
		for (Annotation a : classAnnotations) {
			if (a instanceof SelectionOptions) {
				d = (SelectionOptions) a;
				outStream.println("Choose an option:");
				configuredOk = true;
				break;
			}
		}
		if (!configuredOk) {
			throw new AnnotationFormatError("SelectionOptions annotation was expected but not present");
		}
		
		if (d.options() == null || d.options().length == 0) {
			throw new AnnotationFormatError("SelectionOptions must have at least one option specified");
		}
		
		int index = 1;
		for (SelectionOption opt : d.options()) {
			outStream.println("\t[" + index + "] " + opt.prompt());
			index++;
		}
		int result = doInput(d.options().length, outStream, inStream);
		return d.options()[result - 1].value();
	}
}
