package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * This class represents <code>&lt;li&gt;</code> element. This element 
 * accepts any element as child element. Usually it is used as wrapper for 
 * other elements.
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class Li extends HtmlElement {
	
	public Li() {
	}
	
	/**
	 * Constructor of <code>&lt;li&gt;</code> element accepts plain text 
	 * as input parameter.
	 * @param text
	 */
	public Li(String text) {
		addElement(new StringElement(text));
	}
	
	@Override
	public String getName() {
		return "li";
	}
	
}
