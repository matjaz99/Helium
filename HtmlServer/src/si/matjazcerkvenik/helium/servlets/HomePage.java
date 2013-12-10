package si.matjazcerkvenik.helium.servlets;

import java.util.Iterator;

import si.matjazcerkvenik.helium.HtmlDocument;
import si.matjazcerkvenik.helium.css.BoxStyle;
import si.matjazcerkvenik.helium.css.TextStyle;
import si.matjazcerkvenik.helium.html.Anchor;
import si.matjazcerkvenik.helium.html.Body;
import si.matjazcerkvenik.helium.html.Br;
import si.matjazcerkvenik.helium.html.Div;
import si.matjazcerkvenik.helium.html.Head;
import si.matjazcerkvenik.helium.html.Heading;
import si.matjazcerkvenik.helium.html.Hr;
import si.matjazcerkvenik.helium.html.Img;
import si.matjazcerkvenik.helium.html.Paragraph;
import si.matjazcerkvenik.helium.html.Span;
import si.matjazcerkvenik.helium.html.StringElement;
import si.matjazcerkvenik.helium.html.Table;
import si.matjazcerkvenik.helium.html.Td;
import si.matjazcerkvenik.helium.html.Tr;
import si.matjazcerkvenik.helium.server.App;
import si.matjazcerkvenik.helium.server.IServlet;
import si.matjazcerkvenik.helium.server.Request;
import si.matjazcerkvenik.helium.server.Response;

public class HomePage implements IServlet {

	@Override
	public String getName() {
		return "/helium";
	}

	@Override
	public void doGet(Request req, Response resp) {

		Body body = new Body();

		// header
		Div div0 = new Div();

		Div div01 = new Div();
		Img img = new Img("/img/Home-Server-icon.png");
		div01.addElement(img);

		Div div02 = new Div();
		Heading h1 = new Heading(3);
		h1.addElement(new StringElement("Helium Server Home Page"));
		
		div02.addElement(h1);

		div0.addElement(div01);
		div0.addElement(div02);

		body.addElement(div0);
		body.addElement(new Hr());
		// header end
		
		

		// table
		Div div1 = new Div();
		div1.addElement(new Span("History"));
		div1.addElement(App.getAllRequestsAsHtmlTable());
		body.addElement(div1);
		
		body.addElement(new Hr()).addElement(new Br());
		
		// registered servlets
		Div div2 = getRegisteredServlets();
		body.addElement(div2);

		body.addElement(new Br());

		Hr hr = new Hr();
		body.addElement(hr);

		Anchor a = new Anchor();
		a.getAttributes().add(Anchor.ATTR_HREF, "http://localhost:8080/helium");
		a.addElement(new StringElement("Refresh"));
		body.addElement(a);

		HtmlDocument doc = new HtmlDocument();
		
		Head head = new Head("Helium Home");
		doc.setHead(head);
		doc.setBody(body);

		resp.setData(doc);
	}
	
	private Div getRegisteredServlets() {
		
		Div div = new Div();
		Table t = new Table();
		
		for (Iterator<String> it = App.getAllServlets().keySet().iterator(); it.hasNext();) {
			String name = it.next();
			IServlet s = App.getServlet(name);
			
			Td td1 = new Td();
			Td td2 = new Td();
			td1.addElement(new StringElement(name));
			Anchor a = new Anchor("http://localhost:8080" + s.getName());
			a.addElement(new StringElement("http://localhost:8080" + s.getName()));
			td2.addElement(a);
			
			Tr tr = new Tr();
			tr.addElement(td1);
			tr.addElement(td2);
			
			t.addElement(tr);
			
		}
		
		div.addElement(new Heading(3, "Registered Servlets"));
		div.addElement(t);
		return div;
		
	}

}
