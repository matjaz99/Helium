package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * This class represents <code>&lt;b&gt;</code> element.
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class Bold extends HtmlElement {
	
	public Bold() {
	}
	
	public Bold(String text) {
		addElement(new StringElement(text));
	}
	
	@Override
	public String getName() {
		return "b";
	}
	
}
