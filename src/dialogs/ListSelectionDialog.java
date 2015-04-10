package dialogs;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public abstract class ListSelectionDialog<T> {
	
	protected List<T> elements;
	
	public ListSelectionDialog(List<T> in) {
		elements = in;
	}
	
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
	
	public T doCLIPrompt() throws IllegalAccessException, IOException {
		return doCLIPrompt(System.out, System.in);
	}
	
	public T doCLIPrompt(PrintStream outStream, InputStream inStream) throws IOException {
		outStream.println("Choose an option:");		
		int index = 1;
		for (T opt : elements) {
			outStream.println("\t[" + index + "] " + EntityPrinter(opt));
			index++;
		}
		int result = doInput(elements.size(), outStream, inStream);
		return elements.get(result - 1);
	}
	
	protected abstract String EntityPrinter(T element);
	
}
