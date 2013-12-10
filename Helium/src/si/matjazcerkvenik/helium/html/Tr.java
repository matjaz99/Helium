package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * This element represents a row in table, ie. <code>Tr</code> element. 
 * This element should accept only <code>Th</code> or 
 * <code>Td</code> child elements.
 * 
 * @author Matjaž Cerkvenik
 *
 */
public class Tr extends HtmlElement {
	
	@Override
	public String getName() {
		return "tr";
	}
	
}
