package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * Paragraph class represents <code>&lt;p&gt;</code> element.<br>
 * This elements usually contains text only.
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class Paragraph extends HtmlElement {
	
	/**
	 * Constructor of empty <code>&lt;p&gt;</code> element.
	 */
	public Paragraph() {
	}
	
	/**
	 * Constructor of <code>&lt;p&gt;</code> element accepts plain text 
	 * as input parameter.
	 * @param text
	 */
	public Paragraph(String text) {
		addElement(new StringElement(text));
	}
	
	
	@Override
	public String getName() {
		return "p";
	}
	
}
