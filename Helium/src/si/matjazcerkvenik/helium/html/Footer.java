package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;

public class Footer extends HtmlElement {
	
	public Footer() {
	}
	
	public Footer(HtmlElement... eList) {
		for (int i = 0; i < eList.length; i++) {
			addElement(eList[i]);
		}
	}
	
	@Override
	public String getName() {
		return "footer";
	}
	
}
