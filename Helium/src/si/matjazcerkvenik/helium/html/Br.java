package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * Simple line break element (<code>&lt;br&gt;</code>).<br>
 * This element cannot accept any child elements.
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class Br extends HtmlElement {
	
	@Override
	public String getName() {
		return "br";
	}
	
	@Override
	public String toString() {
		return "<br" + getAttributes().toString() + "/>";
	}
	
}
