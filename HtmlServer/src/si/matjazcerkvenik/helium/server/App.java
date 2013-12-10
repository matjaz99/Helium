package si.matjazcerkvenik.helium.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import si.matjazcerkvenik.helium.HtmlElement;
import si.matjazcerkvenik.helium.html.StringElement;
import si.matjazcerkvenik.helium.html.Table;
import si.matjazcerkvenik.helium.tools.DynamicTableBuilder;
import si.matjazcerkvenik.helium.utils.ServerProps;

public class App {
	
	private static LinkedList<Connection> connectionQueue = new LinkedList<Connection>();
		
	private static HashMap<String, IServlet> srvlts = new HashMap<String, IServlet>();

	
	public static void addToConnectionQueue(Connection c) {

		if (connectionQueue.size() > ServerProps.SERVER_CONNECTION_QUEUE_SIZE) {
			connectionQueue.poll();
		}
		connectionQueue.add(c);

	}
	
	public static void updateQueue(Connection c) {
		
		for (Connection conn : connectionQueue) {
			if (conn.getUuid().equals(c.getUuid())) {
				conn.getResponse().setErrorCode(c.getResponse().getErrorCode());
			}
		}
		
	}
	
	public static Table getAllRequestsAsHtmlTable() {
		
		DynamicTableBuilder tb = new DynamicTableBuilder();
		
		List<HtmlElement> dates = new ArrayList<HtmlElement>();
		List<HtmlElement> reqFile = new ArrayList<HtmlElement>();
		List<HtmlElement> errC = new ArrayList<HtmlElement>();
		List<HtmlElement> uuids = new ArrayList<HtmlElement>();
		
		for (int i = 0; i < connectionQueue.size(); i++) {
			
			Connection c = connectionQueue.get(i);
			
			dates.add(new StringElement(c.getRequest().getDate().toString()));
			reqFile.add(new StringElement(c.getRequest().getFileRequested()));
			errC.add(new StringElement(c.getResponse().getErrorCode() + ""));
			uuids.add(new StringElement(c.getUuid()));
			
		}
		
		tb.addColumn("Date", dates);
		tb.addColumn("File requested", reqFile);
		tb.addColumn("Error code", errC);
		tb.addColumn("UUID", uuids);
		
		return tb.getHtmlTable();
	}
	

	
	public static void registerServlet(String name, IServlet servlet) {
		
		srvlts.put(name, servlet);
		
	}
	
	public static IServlet getServlet(String name) {
		
		return srvlts.get(name);
		
	}
	
	public static HashMap<String, IServlet> getAllServlets() {
		
		return srvlts;
		
	}

}
