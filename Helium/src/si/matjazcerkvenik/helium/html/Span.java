package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * This class represents <code>&lt;span&gt;</code> element. This element 
 * accepts any element as child element. Usually it is used as wrapper for 
 * other elements.
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class Span extends HtmlElement {
	
	public Span() {
	}
	
	public Span(String text) {
		addElement(new StringElement(text));
	}
	
	@Override
	public String getName() {
		return "span";
	}
	
}
