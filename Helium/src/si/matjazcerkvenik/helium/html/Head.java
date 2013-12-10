package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * Representation of <code>&lt;head&gt;</code> element.
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class Head extends HtmlElement {
		
	/**
	 * Default constructor
	 */
	public Head() {
	}
	
	/**
	 * Constructor of <code>&lt;head&gt;</code> element with given title.
	 * @param title
	 */
	public Head(String title) {
		addElement(new Title(title));
	}
	
	@Override
	public String getName() {
		return "head";
	}

	
//	@Override
//	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		sb.append("<head");
//		sb.append(getAttributesAsString());
//		sb.append(">");
//		for (int i = 0; i < getElements().size(); i++) {
//			sb.append(getElements().get(i).toString());
//		}
//		sb.append("</head>");
//		return sb.toString();
//	}
	
}
