package si.matjazcerkvenik.helium.examples;

import si.matjazcerkvenik.helium.HtmlDocument;
import si.matjazcerkvenik.helium.html.Body;
import si.matjazcerkvenik.helium.html.Head;
import si.matjazcerkvenik.helium.html.Heading;

public class HelloWorld {
	
	public static void main(String[] args) {
		
		Head head = new Head("Hello world example");
		Body body = new Body();
		
		Heading h1 = new Heading(1, "Hello world");
		body.addElement(h1);
		
		HtmlDocument doc = new HtmlDocument(head, body);
		
		System.out.println(doc);
		
	}
	
}
