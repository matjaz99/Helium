package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * Representation of <code>&lt;body&gt;</code> element.
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class Body extends HtmlElement {
	
	/**
	 * Default constructor
	 */
	public Body() {
	}
	
	/**
	 * Constructor of <code>&lt;body&gt;</code> element. HtmlElement is 
	 * the first element in body. Other elements must be added with 
	 * <code>addElement(e)</code> method.
	 * @param e
	 */
	public Body(HtmlElement e) {
		addElement(e);
	}
	
	@Override
	public String getName() {
		return "body";
	}

}
