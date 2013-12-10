package si.matjazcerkvenik.helium.server;

import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;

import si.matjazcerkvenik.helium.ServerStart;
import si.matjazcerkvenik.helium.servlets.FileServlet;
import si.matjazcerkvenik.simplelogger.SimpleLogger;

public class Connection {

	private SimpleLogger logger = ServerStart.getLogger();

	private UUID uuid = null;

	public Connection() {
		uuid = UUID.randomUUID();
	}

	private Request request = null;

	private Response response = null;

	public void setInput(List<String> input) {

		request = new Request();

		StringTokenizer parse = new StringTokenizer(input.get(0));
		request.setMethod(parse.nextToken().toUpperCase());
		request.setFileRequested(parse.nextToken());
		
		request.setDate(new Date());

//		logger.info("Request [input=" + input + " method="
//				+ request.getMethod() + " fileRequested="
//				+ request.getFileRequested() + "]");
		logger.info("Request [method="
				+ request.getMethod() + " fileRequested="
				+ request.getFileRequested() + " uuid=" + uuid.toString() + "]");
		
		for (int i = 1; i < input.size(); i++) {
			if (input.get(i).startsWith("User-Agent:")) {
				String[] tmp = input.get(i).split("User-Agent:");
				request.setUserAgent(tmp[1].trim());
			} else if (input.get(i).startsWith("Host:")) {
				String[] tmp = input.get(i).split("Host:");
				request.setHost(tmp[1].trim());
			} else if (input.get(i).startsWith("Accept:")) {
				String[] tmp = input.get(i).split("Accept:");
				request.setAccept(tmp[1].trim());
			} else if (input.get(i).startsWith("Accept-Language:")) {
				String[] tmp = input.get(i).split("Accept-Language:");
				request.setAcceptLanguage(tmp[1].trim());
			} else if (input.get(i).startsWith("Accept-Encoding:")) {
				String[] tmp = input.get(i).split("Accept-Encoding:");
				request.setAcceptEncoding(tmp[1].trim());
			} else if (input.get(i).startsWith("Cookie:")) {
				String[] tmp = input.get(i).split("Cookie:");
				request.setCookie(tmp[1].trim());
			} else if (input.get(i).startsWith("Connection:")) {
				String[] tmp = input.get(i).split("Connection:");
				request.setConnection(tmp[1].trim());
			} else if (input.get(i).startsWith("Referer:")) {
				String[] tmp = input.get(i).split("Referer:");
				request.setReferer(tmp[1].trim());
			}
		}

		logger.debug(request.toString());

	}

	public void process() {

		response = new Response();
		
		IServlet s = null;

		// methods other than GET and HEAD are not implemented
		if (!request.getMethod().equals("GET")
				&& !request.getMethod().equals("HEAD")) {
			// logger.error("501 Not Implemented: " + req.getMethod()
			// + " method.");

			s = App.getServlet("Error");
			s.doGet(request, response);
			return;
		}
		
		
		if (request.getFileRequested().equals("/")) {
			response.sendRedirect("/helium");
			return;
		}

		s = App.getServlet(request.getFileRequested());

		// process servlet
		if (s != null) {
			s.doGet(request, response);
			return;
		}

		// process file request
		if (request.getFileRequested().endsWith(".html")
				|| request.getFileRequested().endsWith(".png")
				|| request.getFileRequested().endsWith(".css")) {
			s = new FileServlet();
			s.doGet(request, response);
			return;
		}

	}

	public Response getResponse() {
		return response;
	}

	public Request getRequest() {
		return request;
	}

	public String getUuid() {
		return uuid.toString();
	}
	
	

}
