package api;

import handlers.RequestHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.net.httpserver.HttpExchange;

public abstract class Target extends RequestHandler {

	public abstract Pattern getTargetRegex();
	
	public Matcher matchPath(HttpExchange req) {
		System.out.println("Path: " + req.getRequestURI().getPath());
		return getTargetRegex().matcher(req.getRequestURI().getPath());
	}
	
	public abstract void handle(HttpExchange req, Matcher m) throws IOException;
	
	public void handle(HttpExchange req) throws IOException {
		System.err.println("Invalid call to API target handle(). Add Pattern match result argument");
	}
	
	public RequestMethod method(HttpExchange req) {
		return RequestMethod.valueOf(req.getRequestMethod());
	}
	
}
