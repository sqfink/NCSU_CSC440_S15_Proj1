package handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
 * Provides helper methods for common HTTP server tasks
 * @author Samuel Fink
 */
public abstract class RequestHandler implements HttpHandler {
	
	/** Reads the entire contents of a request body into a string <br>
	 *  Implementation from http://stackoverflow.com/questions/309424/read-convert-an-inputstream-to-a-string
	 * @param in A stream to the contents from
	 * @return A String containing the entire contents of the stream
	 * @throws IOException There was an error accessing the stream object
	 */
	static public String readFully(InputStream in) throws IOException {
		InputStreamReader is = new InputStreamReader(in);
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(is);
		String read = br.readLine();

		while(read != null) {
		    sb.append(read);
		    read = br.readLine();

		}
		return sb.toString();
	}
	
	/** A simple wrapper to send a HTTP response code and optionally a message as text
	 * @note The request output stream is closed as part of this function. Attempting to write to it will cause errors. 
	 * @param req The incoming request to respond to
	 * @param code The response code to send
	 * @param message A message to send back to the client. null will be replaced with ""
	 * @throws IOException There was an error sending the response
	 */
	static public void sendError(HttpExchange req, int i, String message) throws IOException {
		if (req == null) 
			throw new IllegalArgumentException("The request object must be set");
		
		if (message == null)
			message = "";
		
		req.sendResponseHeaders(i, message.length());
		OutputStream os = req.getResponseBody();
		os.write(message.getBytes());
		os.close();
	}
	
	/** A simple wrapper to send a HTTP response code and optionally a message with content-type set to application/json
	 * @note The request output stream is closed as part of this function. Attempting to write to it will cause errors. 
	 * @param req The incoming request to respond to
	 * @param code The response code to send
	 * @param message A message to send back to the client. null will be replaced with ""
	 * @throws IOException There was an error sending the response
	 */
	public void sendJSON(HttpExchange req, int code, String message) throws IOException {
		if (req == null) 
			throw new IllegalArgumentException("The request object must be set");
		
		if (message == null)
			message = "";
		
		req.getResponseHeaders().set("Content-Type","application/json");
		req.sendResponseHeaders(code, message.length());
		OutputStream os = req.getResponseBody();
		os.write(message.getBytes());
		os.close();
	}
	
	/** Pipes the contents of one stream into another then closes both streams
	 * @param is The input to copy
	 * @param os The target for the data to be copied to
	 * @throws IOException There was an error performing the IO
	 */
	static public long pipeStreams(InputStream is, OutputStream os) throws IOException {
		byte[] buf = new byte[512]; // 512 appears to be best performance memory allocation size on windows 64-bit HotSpot 8
		long totalLen = 0;
		int len;
		while( (len = is.read(buf)) > 0) {
			os.write(buf, 0, len);
			totalLen += len;
		}
		os.close();
		is.close();
		return totalLen;
	}
	
}
