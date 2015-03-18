import handlers.ApiRequestRouter;
import handlers.RequestHandler;
import handlers.StaticContentServer;

import java.io.IOException;
import java.net.InetSocketAddress;

import api.Target;
import api.targets.Places;
import beans.PlaceBean;

import com.sun.net.httpserver.HttpServer;


public class main {

	public static void main(String[] args) {
		try {
			HttpServer server;
			System.setProperty("java.net.preferIPv4Stack" , "true"); // Don't default to IPv6
			server = HttpServer.create(new InetSocketAddress(8000), 0);
			server.createContext("/", new StaticContentServer("/", "wwwdata"));
			ApiRequestRouter api = new ApiRequestRouter("/api/");
			api.registerTarget(new Places());
			server.createContext("/api/", api);
			server.setExecutor(null);
			server.start();
			System.out.println("Server listenening on " + server.getAddress());
			
		} catch (IOException e) {
			System.err.println("Failed to create HTTP server");
			e.printStackTrace();
		}
	}

}
