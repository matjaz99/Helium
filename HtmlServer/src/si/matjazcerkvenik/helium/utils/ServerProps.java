package si.matjazcerkvenik.helium.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import si.matjazcerkvenik.simplelogger.LEVEL;

public class ServerProps {
	
	private static String SERVER_PROPERTIES = "cfg/server.properties";
	
	public static String SERVER_VERSION = "0.0";
	public static int SERVER_PORT = 5000;
	public static String SERVER_PAGES_DIR = "./pages";
	public static String PAGE_DEFAULT = "index.html";
	public static String SERVER_LOG_FILE = "log/MyHttpServer.log";
	public static int SERVER_LOG_LEVEL = LEVEL.INFO;
	public static boolean SERVER_LOG_VERBOSE = false;
	public static int SERVER_CONNECTION_QUEUE_SIZE = 50;
			
	public static void readProperties() {

		Properties props = new Properties();

		try {

			props.load(new FileInputStream(SERVER_PROPERTIES));

			SERVER_VERSION = props.getProperty("server.version");
			SERVER_PORT = Integer.parseInt(props.getProperty("server.port"));
			SERVER_CONNECTION_QUEUE_SIZE = Integer.
					parseInt(props.getProperty("server.connection.queue.size"));
			
			SERVER_PAGES_DIR = props.getProperty("server.pages.dir");
			PAGE_DEFAULT = props.getProperty("page.default");
			
			SERVER_LOG_FILE = props.getProperty("log.file");
			SERVER_LOG_LEVEL = LEVEL.getLevel(props.getProperty("log.level"));
			SERVER_LOG_VERBOSE = Boolean.parseBoolean(props.getProperty("log.verbose"));

		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean setCfgPropertiesFile(String s) {
		
		File f = new File(s);
		System.out.println("Configuration: " + f.getAbsolutePath());
		if (f.exists()) {
			return true;
		}
		return false;
		
	}

}
