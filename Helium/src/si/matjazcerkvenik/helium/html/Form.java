package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * This class represents <code>&lt;form&gt;</code> element. Among others, 
 * form element contains many <code>&lt;input&gt;</code> elements.
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class Form extends HtmlElement {
	
	public static final String ATTR_ACTION = "action";
	public static final String ATTR_METHOD = "method";
	
	/**
	 * HTTP method definitions
	 */
	public enum METHOD { GET, POST };
	
	/**
	 * Default constructor of <code>&lt;form&gt;</code> element.
	 */
	public Form() {
	}
	
	/**
	 * Constructor of <code>&lt;form&gt;</code> element with action 
	 * attribute and method specification as input arguments.
	 * @param action
	 * @param method
	 */
	public Form(String action, METHOD method) {
		getAttributes().add(ATTR_ACTION, action);
		getAttributes().add(ATTR_METHOD, method.name().toLowerCase());
	}
	
	@Override
	public String getName() {
		return "form";
	}
	
	
}
