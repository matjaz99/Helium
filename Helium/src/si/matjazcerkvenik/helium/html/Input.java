package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * This class represents <code>&lt;input&gt;</code> element. This element 
 * is usually used within <code>&lt;form&gt;</code> element.<br>
 * This element cannot have child elements.
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class Input extends HtmlElement {
	
	public static final String ATTR_TYPE = "type";
	public static final String ATTR_NAME = "name";
	
	/**
	 * Type definitions of <code>&lt;input&gt;</code> element.
	 */
	public enum TYPE { BUTTON, CHECKBOX, FILE, HIDDEN, IMAGE, PASSWORD,
		RADIO, RESET, SUBMIT, TEXT };
		
	public Input() {
	}
	
	public Input(String name, TYPE type) {
		getAttributes().add(ATTR_TYPE, type.name().toLowerCase());
		getAttributes().add(ATTR_NAME, name);
	}
	
	@Override
	public String getName() {
		return "input";
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<input");
		sb.append(getAttributes().toString());
		sb.append("/>");
		return sb.toString();
	}
	
}
