package handlers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import api.Target;

import com.sun.net.httpserver.HttpExchange;

public class ApiRequestRouter extends RequestHandler{
	
	protected final String basepath;
	
	private Map<Pattern, Target> handlers;
	
	public ApiRequestRouter(String basepath) {
		this.basepath = basepath;
		handlers = new HashMap<Pattern, Target>();
	}
	
	public void registerTarget(Target r) {
		handlers.put(r.getTargetRegex(), r);
	}
	
	@Override
	public void handle(HttpExchange req) throws IOException {
		try {
			String reqpath = req.getRequestURI().getPath();
			reqpath = reqpath.replaceFirst(Pattern.quote(basepath), "/");
			boolean matched = false;
			for (Pattern re : handlers.keySet()) {
				Matcher m = re.matcher(reqpath);
				if(m.matches()) {
					System.out.println("Handler " + re.pattern() + " matched " + reqpath);
					handlers.get(re).handle(req, m);
					matched = true;
					break;
				}
			}
			if (!matched) {
				System.out.println("No API target handler found for " + reqpath);
				sendError(req, 404, "No such API target");
			}
		} catch (Exception e) {
			System.err.println("Error while processing API request");
			e.printStackTrace();
			sendError(req, 500, "Error while processing request.\n"+e.getMessage());
		}
	}

}
