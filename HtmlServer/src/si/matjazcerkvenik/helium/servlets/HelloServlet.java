package si.matjazcerkvenik.helium.servlets;

import si.matjazcerkvenik.helium.HtmlDocument;
import si.matjazcerkvenik.helium.html.Body;
import si.matjazcerkvenik.helium.html.Div;
import si.matjazcerkvenik.helium.html.Head;
import si.matjazcerkvenik.helium.html.Heading;
import si.matjazcerkvenik.helium.server.IServlet;
import si.matjazcerkvenik.helium.server.Request;
import si.matjazcerkvenik.helium.server.Response;

public class HelloServlet implements IServlet {
	
	@Override
	public String getName() {
		return "/hello";
	}
	
	@Override
	public void doGet(Request req, Response resp) {
		
		Head head = new Head("Hello test");
		
		Div div0 = new Div();
		div0.addElement(new Heading(1, "Hello Helium"));
		
		Body body = new Body();
		body.addElement(div0);
		
		HtmlDocument doc = new HtmlDocument(head, body);
		
		resp.setData(doc);
		
	}
	
}
