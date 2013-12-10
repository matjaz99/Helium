package si.matjazcerkvenik.helium;

import java.util.ArrayList;
import java.util.List;

import si.matjazcerkvenik.helium.html.Bold;
import si.matjazcerkvenik.helium.html.Div;
import si.matjazcerkvenik.helium.html.Span;

public class Test {
	
	public static void main(String[] args) {
		
		List<Object> list = new ArrayList<Object>();
		
		String s = "aa";
		Span span = new Span("span");
		HtmlElement h = new Div();
		h.addElement(new Bold("bb"));
		
		list.add(s);
		list.add(span);
		list.add(h);
		
		for (Object o : list) {
			if (o instanceof String) {
				System.out.println("Object is type String: " + o.toString());
			} else if (o instanceof Span) {
				System.out.println("Object is type Span: " + o.toString());
			} else if (o instanceof HtmlElement) {
					System.out.println("Object is type HtmlElement: " + o.toString());
				}
		}
	}
	
}
