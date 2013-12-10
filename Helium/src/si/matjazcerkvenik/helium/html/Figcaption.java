package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * Paragraph class represents <code>&lt;figcaption&gt;</code> element.<br>
 * This elements usually contains text only.
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class Figcaption extends HtmlElement {
	
	/**
	 * Constructor of empty <code>&lt;p&gt;</code> element.
	 */
	public Figcaption() {
	}
	
	/**
	 * Constructor of <code>&lt;p&gt;</code> element accepts plain text 
	 * as input parameter.
	 * @param text
	 */
	public Figcaption(String text) {
		addElement(new StringElement(text));
	}
	
	
	@Override
	public String getName() {
		return "figcaption";
	}
	
}
