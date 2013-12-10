package si.matjazcerkvenik.helium.servlets;

import si.matjazcerkvenik.helium.HtmlDocument;
import si.matjazcerkvenik.helium.server.IServlet;
import si.matjazcerkvenik.helium.server.Request;
import si.matjazcerkvenik.helium.server.Response;

public class TestBoxPage implements IServlet {
	
	@Override
	public String getName() {
		return "/box";
	}
	
	@Override
	public void doGet(Request req, Response resp) {
				
		HtmlDocument doc = null;
		
		doc = getVerticalBox();
//		doc = getHorizontalBox();
		

		resp.setData(doc);
		
	}
	
	private HtmlDocument getVerticalBox() {
		
//		Box box = new VerticalBoxLayout();
//		box.setWidth(200);
////		box.setHeight(100);
//		
//		Box box1 = new Box();
//		box1.setWidth(50);
//		box1.setHeight(50);
//		box1.setHtmlElement(new StringElement("test box"));
//		
//		Box box2 = new Box();
//		box2.setWidth(50);
//		box2.setHeight(50);
//		box2.setHtmlElement(new Anchor("http://localhost:8080/box", "box"));
//		
//		box.addBox(box1);
//		box.addBox(box2);
//		
//		Head head = new Head("BoxTest");
//		String styles = box.getStyle();
//		for (int i = 0; i < box.getBoxes().size(); i++) {
//			styles += box.getBoxes().get(i).getStyle();
//		}
//		Style st = new Style();
//		st.addElement(new StringElement(styles));
//		head.addElement(st);
//		
//		Body body = new Body();
//		body.addElement(box.getAsHtmlElement());
//		
//		HtmlDocument doc = new HtmlDocument();
//		doc.setHead(head);
//		doc.setBody(body);
//		
//		return doc;
		return null;
		
	}
	
//	private HtmlDocument getHorizontalBox() {
//		
//		Box box = new Box();
//		box.setWidth(200);
////		box.setHeight(100);
//		
//		Box box1 = new HorizontalBoxLayout();
//		box1.setWidth(50);
//		box1.setHeight(50);
//		box1.setHtmlElement(new StringElement("test box"));
//		
//		Box box2 = new HorizontalBoxLayout();
//		box2.setWidth(50);
//		box2.setHeight(50);
//		box2.setHtmlElement(new Anchor("http://localhost:8080/box", "box"));
//		
//		box.addBox(box1);
//		box.addBox(box2);
//		
//		Head head = new Head("BoxTest");
//		String styles = box.getStyle();
//		for (int i = 0; i < box.getBoxes().size(); i++) {
//			styles += box.getBoxes().get(i).getStyle();
//		}
//		Style st = new Style();
//		st.addElement(new StringElement(styles));
//		head.addElement(st);
//		
//		Body body = new Body();
//		body.addElement(box.getAsHtmlElement());
//		
//		HtmlDocument doc = new HtmlDocument();
//		doc.setHead(head);
//		doc.setBody(body);
//		
//		return doc;
//		
//	}
	
}
