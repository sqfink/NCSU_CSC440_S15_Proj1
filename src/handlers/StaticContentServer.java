package handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

import com.sun.net.httpserver.HttpExchange;

/** An super basic implementation of a static content directory server HttpHandler
 * @author Samuel Fink
 */
public class StaticContentServer extends RequestHandler {

	/** Workaround for windows breaking file paths
	 */
	private static final String system_pathsep = System.getProperty("file.separator");
	
	/** The prefix to be removed from the request URI
	 */
	private final String wwwpath; 
	
	/** The absolute system path to inject before the file being served 
	 */
	private final String basepath;
	
	/** Gets the MIME type string for a file
	 * @param localFile The file to get the type of
	 * @return the file tyoe or application/octet-stream if unknown
	 */
	public static String getFileExt(File localFile) {
		String result = null;
		
		try {
			result = Files.probeContentType(Paths.get(localFile.getAbsolutePath()));
		} catch (IOException e) {
			System.err.println("Error attempting to get file type");
			e.printStackTrace();
		}
		
		if (result != null)
			return result;
		
		if (localFile.getName().endsWith(".js")) {
			return "application/javascript";
		}
		return "application/octet-stream";	
	}
	
	/** Initialize the server handler
	 * @param basepath The path context that the handler is set up for
	 * @param wwwpath The path to the webroot directory to serve
	 */
	public StaticContentServer(String basepath, String wwwpath) {
			
		if (basepath == null || wwwpath == null)
			throw new IllegalArgumentException("All parameters must be set");
		
		this.basepath = basepath;
		
		if (new File(wwwpath).exists() && new File(wwwpath).isDirectory()) { // Ensure that the directory exists
			this.wwwpath = new File(wwwpath).getAbsolutePath() + system_pathsep;
		} else {
			throw new IllegalArgumentException("Specified path is not a valid directory");
		}

	}
	
	/**
	 * Attempts to serve the static file requested
	 */
	@Override
	public void handle(HttpExchange req) throws IOException {
		try {
			String reqpath = req.getRequestURI().getPath();
			System.out.println("Got static " + req.getRequestMethod() + " request for " + reqpath + " from " + req.getRemoteAddress());
			
			if (!req.getRequestMethod().equals("GET")) { // Only serve static get requests
				
				System.out.println("Illegal method request");
				sendError(req, 405, "Only GET requests are supported for this URL");
				
			} else if (reqpath.contains("..")) { // Disallow tree walking.
				
				System.out.println("Illegal relpath requested");
				sendError(req, 403, "Illegal relative path");
				
			} else { // Try to serve the file
				
				String localpath = wwwpath + reqpath.replaceFirst(Pattern.quote(basepath), "");
				
				if (localpath.indexOf("?") > 0) // Remove get variables from the path. Looks like it is already stripped before this point
					localpath.substring(0, localpath.indexOf("?") - 1);
				
				File localFile = new File(localpath);
				
				if (!localFile.exists() || !localFile.canRead()) { // Ensure file exists
					
					System.out.println("Local file " + localFile + " not found");
					sendError(req, 404, "File not found");
					
				} else { // Read and pipe the file to the output stream
					
					System.out.println("Serving local file " + localFile);
					System.out.println("Content-Type: " + getFileExt(localFile));
					req.getResponseHeaders().set("Content-Type",getFileExt(localFile)); 
					req.sendResponseHeaders(200, localFile.length());
					
					if (pipeStreams(new FileInputStream(localFile), req.getResponseBody()) != localFile.length()) {
						System.out.println("Warning: transmitted size != indicated size");
					}
					
				}
			}
		} catch (Exception e) {
			System.err.println("Error while serving static file " + e.getMessage());
			e.printStackTrace();
			sendError(req, 500, "");
		}
	}

}
