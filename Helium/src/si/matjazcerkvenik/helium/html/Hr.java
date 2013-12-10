package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * Simple <code>&lt;hr&gt;</code> element.<br>
 * This element cannot accept any child elements.
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class Hr extends HtmlElement {
	
	@Override
	public String getName() {
		return "hr";
	}
	
	@Override
	public String toString() {
		return "<hr" + getAttributes().toString() + "/>";
	}
	
}
