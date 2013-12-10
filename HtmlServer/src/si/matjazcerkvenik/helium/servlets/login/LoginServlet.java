package si.matjazcerkvenik.helium.servlets.login;

import si.matjazcerkvenik.helium.HtmlDocument;
import si.matjazcerkvenik.helium.html.Body;
import si.matjazcerkvenik.helium.html.Div;
import si.matjazcerkvenik.helium.html.Form;
import si.matjazcerkvenik.helium.html.Head;
import si.matjazcerkvenik.helium.html.Input;
import si.matjazcerkvenik.helium.html.StringElement;
import si.matjazcerkvenik.helium.html.Table;
import si.matjazcerkvenik.helium.html.Td;
import si.matjazcerkvenik.helium.html.Tr;
import si.matjazcerkvenik.helium.html.Form.METHOD;
import si.matjazcerkvenik.helium.html.Input.TYPE;
import si.matjazcerkvenik.helium.server.IServlet;
import si.matjazcerkvenik.helium.server.Request;
import si.matjazcerkvenik.helium.server.Response;


public class LoginServlet implements IServlet {
	
	public String getName() {
		return "/login";
	}
	
	public void doGet(Request req, Response resp) {
		
		Form form = new Form("login", METHOD.POST);
		Input in1 = new Input("username", TYPE.TEXT);
		Input in2 = new Input("password", TYPE.PASSWORD);
		
		Td td11 = new Td();
		td11.addElement(new StringElement("Username"));
		Td td12 = new Td();
		td12.addElement(in1);
		
		Tr tr1 = new Tr();
		tr1.addElement(td11);
		tr1.addElement(td12);
		
		Td td21 = new Td();
		td11.addElement(new StringElement("Password"));
		Td td22 = new Td();
		td12.addElement(in2);
		
		Tr tr2 = new Tr();
		tr1.addElement(td21);
		tr1.addElement(td22);
		
		Table table = new Table();
		table.addElement(tr1);
		table.addElement(tr2);
		
		form.addElement(table);
		
		Div div0 = new Div();
		div0.addElement(form);
		
		Head h = new Head("Login");
		Body b = new Body();
		b.addElement(div0);
		
		HtmlDocument doc = new HtmlDocument(h, b);
		
		resp.setData(doc);
		
	}
	
}
