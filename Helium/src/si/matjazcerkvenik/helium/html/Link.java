package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;


/**
 * The <code>&lt;link&gt;</code> element is usually used in head of HTML 
 * document to declare stylesheet.
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class Link extends HtmlElement {
	
	public static final String ATTR_REL = "rel";
	public static final String ATTR_TYPE = "type";
	public static final String ATTR_HREF = "href";
	
	/**
	 * Default constructor of <code>&lt;link&gt;</code> element without arguments.
	 */
	public Link() {
	}
	
	/**
	 * Set path to CSS file relative to web directory.
	 * @param stylesheetUrl
	 */
	public Link(String stylesheetUrl) {
		getAttributes().add(ATTR_REL, "stylesheet");
		getAttributes().add(ATTR_TYPE, "text/css");
		getAttributes().add(ATTR_HREF, stylesheetUrl);
	}
	
	@Override
	public String getName() {
		return "link";
	}
	
	@Override
	public String toString() {
		return "<link" + getAttributes().toString() + "/>";
	}
	
}
