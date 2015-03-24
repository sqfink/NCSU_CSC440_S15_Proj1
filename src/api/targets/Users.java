package api.targets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import beans.User;

import com.sun.net.httpserver.HttpExchange;

import api.Target;

public class Users extends Target {
	protected static final Pattern targetPathRE = Pattern.compile("/user/?(/\\d+)?"); 
	
	@Override
	public Pattern getTargetRegex() {
		return targetPathRE;
	}

	@Override
	public void handle(HttpExchange req, Matcher m) throws IOException {
		try {
			if (m.group(2) == null || m.group(2).equals("")) { //User ID not specified
				switch(this.method(req)) {
				case GET:
					//return list of user names and IDs
					break;
				case POST:
					User u = new User();
					u = (User)u.fromJSON(readFully(req.getRequestBody()));
					//Insert u into the DB
					break;
				default:
					sendError(req, 405, "");
				}
			} else { //User ID specified
				switch(this.method(req)) {
				case GET:
					//return the User that corresponds to the ID in m.group(2)
					break;
				case UPDATE:
					User u = new User();
					u = (User)u.fromJSON(readFully(req.getRequestBody()));
					//Update u with ID (m.group(2)) in DB
					break;
				case DELETE:
					//delete the ID id prermissions allow
					break;
				default:
					sendError(req, 405, "");
				}
			}
		} catch (IllegalArgumentException e) {
			sendError(req, 400, e.getMessage());
		}
	}

}
