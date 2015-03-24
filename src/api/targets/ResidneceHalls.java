package api.targets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.net.httpserver.HttpExchange;

import api.Target;

public class ResidneceHalls extends Target {
	protected static final Pattern targetPathRE = Pattern.compile("/housing/halls/?(/\\d+)?/?(requestRoom|approveRequest)?/?(\\d+)?"); 
	
	@Override
	public Pattern getTargetRegex() {
		return targetPathRE;
	}

	@Override
	public void handle(HttpExchange req, Matcher m) throws IOException {
		try {
			if (m.group(2) == null || m.group(2).equals("")) { //hall ID not specified
				switch(this.method(req)) {
				case GET:
					//Return list of residence hall IDs with minimal info
					break;
				default:
					sendError(req, 405, "");
				}
			} else if(m.group(3) == null || m.group(3).equals("")) { //hall ID specified but no command and userID
				switch(this.method(req)) {
				case GET:
					//Return full information about residence hall
					break;
				default:
					sendError(req, 405, "");
				}
			}else if(m.group(4) == null || m.group(4).equals("")) { //hall ID specified and command specified but no requestId
				switch(this.method(req)) {
				case GET:
					if (m.group(4).equals("approveRequest")) {
						//return a list of pending requests
					} else {
						sendError(req, 400, "No API endpoint");
					}
					break;
				case POST:
					if (m.group(4).equals("requestRoom")) {
						//if user is student add request for room to student account
					} else {
						sendError(req, 400, "No API endpoint");
					}
					break;
				default:
					sendError(req, 405, "");
				}
			} else { //fully qualified request
				if (m.group(4).equals("approveRequest")) {
					switch(this.method(req)) {
					case GET:
						//return request status
						break;
					case PUT:
						//if allowed update the status of the request
						break;
					default:
						sendError(req, 405, "");
					}
				} else { //is requestRoom
					switch(this.method(req)) {
					case GET: 
						//if user session is student return request status
						//else 400 error
						break;
					case PUT: //update
						//if valid ID and assigned to current user
						//update request information
						break;
					case DELETE: //delete
						//if valid ID and user is owner or admin delete request
						break;
					default:
						sendError(req, 405, "");
					}
				}
			}
		} catch (IllegalArgumentException e) {
			sendError(req, 400, e.getMessage());
		}
	}

}
