package si.matjazcerkvenik.helium.server;

import java.util.HashMap;
import java.util.Map;

public class HttpErrorCodes {

	private static Map<Integer, String> errorCodes = new HashMap<Integer, String>();

	static {
		errorCodes.put(200, "OK");
		errorCodes.put(201, "Created");
		errorCodes.put(202, "Accepted");
		errorCodes.put(204, "No Content");
		errorCodes.put(301, "Moved Permanently");
		errorCodes.put(302, "Moved Temporarily");
		errorCodes.put(304, "Not Modified");
		errorCodes.put(400, "Bad Request");
		errorCodes.put(401, "Unauthorized");
		errorCodes.put(403, "Forbidden");
		errorCodes.put(404, "Not Found");
		errorCodes.put(500, "Internal Server Error");
		errorCodes.put(501, "Not Implemented");
		errorCodes.put(502, "Bad Gateway");
		errorCodes.put(503, "Service Unavailable");
	}

	public static String getError(int errorCode) {

		if (errorCodes.containsKey(errorCode)) {
			return errorCodes.get(errorCode);
		}
		return "Unknown error";

	}

}
