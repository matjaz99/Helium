package si.matjazcerkvenik.helium.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import si.matjazcerkvenik.helium.ServerStart;
import si.matjazcerkvenik.helium.server.IServlet;
import si.matjazcerkvenik.helium.server.Request;
import si.matjazcerkvenik.helium.server.Response;
import si.matjazcerkvenik.helium.utils.ServerProps;
import si.matjazcerkvenik.simplelogger.SimpleLogger;

public class FileServlet implements IServlet {
	
	private SimpleLogger logger = ServerStart.getLogger();
	
	@Override
	public String getName() {
		return null;
	}
	
	@Override
	public void doGet(Request req, Response resp) {
		
		File file = new File(ServerProps.SERVER_PAGES_DIR,
				req.getFileRequested());

		int fileLength = (int) file.length();

		FileInputStream fileIn = null;

		byte[] fileData = new byte[fileLength];

		try {
			
			fileIn = new FileInputStream(file);
			fileIn.read(fileData);
			
			resp.setData(fileData);
			
			// get the file's MIME content type
			resp.setContentType(getContentType(req.getFileRequested()));
			
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException: " + req.getFileRequested() + " " + e.getMessage());
			resp.setData(HtmlErrorDoc.getErrorHtmlDoc(404, "File "
					+ req.getFileRequested() + " not found"));
			resp.setErrorCode(404);
		} catch (IOException e) {
			logger.error("IOException: ", e);
			resp.setData(HtmlErrorDoc.getErrorHtmlDoc(500, null));
			resp.setErrorCode(500);
		} finally {
			try {
				if (fileIn != null) {
					fileIn.close();
				}
			} catch (IOException e) {
				logger.error("IOException: ", e);
			}
		}
		
		
		
	}
	
	private String getContentType(String fileRequested) {
		if (fileRequested.endsWith(".htm") || fileRequested.endsWith(".html")) {
			return "text/html";
		} else if (fileRequested.endsWith(".gif")) {
			return "image/gif";
		} else if (fileRequested.endsWith(".jpg")
				|| fileRequested.endsWith(".jpeg")) {
			return "image/jpeg";
		} else if (fileRequested.endsWith(".png")) {
			return "image/png";
		} else if (fileRequested.endsWith(".css")) {
			return "text/css";
		} else if (fileRequested.endsWith(".class")
				|| fileRequested.endsWith(".jar")) {
			return "applicaton/octet-stream";
		} else {
			return "text/plain";
		}
	}
	
	

}
