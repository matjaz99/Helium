package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;

public class Header extends HtmlElement {
	
	public Header() {
	}
	
	public Header(HtmlElement... eList) {
		for (int i = 0; i < eList.length; i++) {
			addElement(eList[i]);
		}
	}
	
	@Override
	public String getName() {
		return "header";
	}
	
}
