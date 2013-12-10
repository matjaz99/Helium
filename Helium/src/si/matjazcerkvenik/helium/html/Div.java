package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * This class represents <code>&lt;div&gt;</code> element. This element 
 * accepts any element as child element. Usually it is used as wrapper for 
 * other elements.
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class Div extends HtmlElement {
	
	public Div() {
	}
	
	public Div(HtmlElement... eList) {
		for (int i = 0; i < eList.length; i++) {
			addElement(eList[i]);
		}
	}
	
	@Override
	public String getName() {
		return "div";
	}
	
}
