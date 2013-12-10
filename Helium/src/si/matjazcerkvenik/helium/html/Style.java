package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * This class represents <code>&lt;style&gt;</code> element for 
 * style definitions.<br>
 * This elements cannot accept child elements, but only style 
 * definitions according to valid CSS syntax.<br>
 * Styles are not supported by HtmlLib (yet); you can add styles 
 * by using <code>&lt;StringElement&gt;</code> element.
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class Style extends HtmlElement {
	
	public static final String ATTR_TYPE = "type";
	
	/**
	 * Constructor of <code>&lt;style&gt;</code> element. MIME type 
	 * attribute of CSS is automatically added.
	 */
	public Style() {
		getAttributes().add(ATTR_TYPE, "text/css");
	}
	
	public Style(String style) {
		getAttributes().add(ATTR_TYPE, "text/css");
		addElement(new StringElement(style));
	}
	
	@Override
	public String getName() {
		return "style";
	}
	
}
