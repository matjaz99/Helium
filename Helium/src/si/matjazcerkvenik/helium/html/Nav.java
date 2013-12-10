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
public class Nav extends HtmlElement {
	
	public Nav() {
	}
	
	public Nav(HtmlElement... eList) {
		for (int i = 0; i < eList.length; i++) {
			addElement(eList[i]);
		}
	}
	
	@Override
	public String getName() {
		return "nav";
	}
	
}
