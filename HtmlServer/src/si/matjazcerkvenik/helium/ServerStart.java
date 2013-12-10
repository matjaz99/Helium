package si.matjazcerkvenik.helium;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Date;

import si.matjazcerkvenik.helium.server.App;
import si.matjazcerkvenik.helium.server.ConnectionHandler;
import si.matjazcerkvenik.helium.servlets.HomePage;
import si.matjazcerkvenik.helium.servlets.HelloServlet;
import si.matjazcerkvenik.helium.servlets.ImgTest;
import si.matjazcerkvenik.helium.servlets.TestBoxPage;
import si.matjazcerkvenik.helium.servlets.TestPlugin;
import si.matjazcerkvenik.helium.servlets.dummy.DummyWebPage;
import si.matjazcerkvenik.helium.utils.ServerProps;
import si.matjazcerkvenik.simplelogger.SimpleLogger;

/**
 * 
 * http://localhost:8080/index.html
 * http://localhost:8080/indexx.html
 * http://localhost:8080/
 * http://localhost:8080/helium
 * http://localhost:8080/imgtest
 * 
 * Run with following arguments:
 * cfg=cfg/server.properties
 * 
 * 
 * @author matjaz
 *
 */
public class ServerStart {
	
	private static SimpleLogger logger = null;
	
	private static ServerSocket serverSocket = null;
	
	private static boolean serverRunning = true;
	
	
	
	public static void main(String[] args) {
		
		if (args.length < 1) {
			System.out.println("missing configuration path");
			System.exit(0);
		}
		
		for (int i = 0; i < args.length; i++) {
			String[] tempTab = args[i].split("=");
			boolean b = ServerProps.setCfgPropertiesFile(tempTab[1]);
			if (!b) {
				System.out.println("configuration file not found");
				System.exit(0);
			}
		}
		
		System.out.println("HeliumHome: http://localhost:8080/helium");
		
		Runtime.getRuntime().addShutdownHook(new ServerStop());
		
		ServerProps.readProperties();
		getLogger();
		logger.info("Helium Server started - version: " + ServerProps.SERVER_VERSION);
		
		App.registerServlet("/", new HomePage());
		App.registerServlet("/helium", new HomePage());
//		App.registerServlet("/login", new Log);
		App.registerServlet("/hello", new HelloServlet());
		App.registerServlet("/test", new TestPlugin());
		App.registerServlet("/imgtest", new ImgTest());
		App.registerServlet("/box", new TestBoxPage());
		App.registerServlet("/dummy", new DummyWebPage());
		
		try {
			serverSocket = new ServerSocket(ServerProps.SERVER_PORT);
			logger.info("Listening for connections on port " + ServerProps.SERVER_PORT);
			
			while (serverRunning) {
				ConnectionHandler server = new ConnectionHandler(serverSocket.accept());
				logger.trace("Connection opened. (" + new Date() + ")");
				Thread threadRunner = new Thread(server);
				threadRunner.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void stopServer() {
		
		serverRunning = false;
		try {
			serverSocket.close();
			logger.info("socket closed");
		} catch (IOException e) {
			logger.error("IOException when stopping ", e);
		}
		logger.info("Server stopped");
		
	}
	
	
	public static SimpleLogger getLogger() {
		
		if (logger == null) {
			logger = new SimpleLogger();
			logger.setLogLevel(ServerProps.SERVER_LOG_LEVEL);
			logger.setFilename(ServerProps.SERVER_LOG_FILE);
			logger.setWriteToConsole(ServerProps.SERVER_LOG_VERBOSE);
			System.out.println("log file path: " + new File(ServerProps.SERVER_LOG_FILE).getAbsolutePath());
		}
		
		return logger;
		
	}
	
	
	
}
