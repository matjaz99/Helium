package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;


public class Script extends HtmlElement {
	
	public static final String ATTR_TYPE = "type";
	
	public static final String ATTR_SRC = "src";
	
	public Script() {
		getAttributes().add(ATTR_TYPE, "text/javascript");
	}
	
	public Script(String url) {
		getAttributes().add(ATTR_SRC, url);
	}
	
	@Override
	public String getName() {
		return "script";
	}
	
}
