package api.targets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;

import beans.Place;

import com.sun.net.httpserver.HttpExchange;

import api.Target;

public class Places extends Target {
	protected static final Pattern targetPathRE = Pattern.compile("/place(/\\d+)?"); 
	
	public Pattern getTargetRegex() {
		return targetPathRE;
	}

	@Override
	public void handle(HttpExchange req, Matcher m) throws IOException {
		if (m.group(1) == null || m.group(1).equals("")) {
			System.out.println("No place_id specified");
			switch (method(req)) {
			case GET:
				JSONArray arr = new JSONArray();
				for (int i = 0; i < 7; i++) {
					Place u = new Place();
					u.address_line1 = "" + i + " Fake street";
					u.zipcode = i;
					u.city = "city" + i;
					u.place_id = (long) i;
					arr.put(u.toJSON());
				}
				sendJSON(req, 200, arr.toString());
				break;
			default:
				sendError(req, 405, "");
			}
		} else {
			int placeID = new Integer(m.group(1));
			System.out.println("place_id " + placeID + " specified");
			sendError(req, 404, "No such place");
		}
		
		
		
	}	
}
