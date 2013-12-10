package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * This class represents <code>&lt;title&gt;</code> element, which is 
 * part of <code>&lt;head&gt;</code> element.<br>
 * This element accepts text only.
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class Title extends HtmlElement {
	
	/**
	 * Constructor of <code>&lt;title&gt;</code> element.
	 * @param text
	 */
	public Title(String text) {
		addElement(new StringElement(text));
	}
	
	@Override
	public String getName() {
		return "title";
	}
	
//	@Override
//	public String toString() {
//		return "<title>" + getElementsAsString() + "</title>";
//	}
	
}
