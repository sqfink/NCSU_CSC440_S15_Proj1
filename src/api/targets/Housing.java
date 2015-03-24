package api.targets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.net.httpserver.HttpExchange;

import api.Target;

public class Housing extends Target {
	protected static final Pattern targetPathRE = Pattern.compile("/housing/?"); 
	
	@Override
	public Pattern getTargetRegex() {
		return targetPathRE;
	}

	@Override
	public void handle(HttpExchange req, Matcher m) throws IOException {
		switch (method(req)) {
		case GET:
			//Return a list of housing types
		default:
			sendError(req, 405, "");
		}
	}

}
