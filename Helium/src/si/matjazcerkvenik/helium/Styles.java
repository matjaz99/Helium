package si.matjazcerkvenik.helium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import si.matjazcerkvenik.helium.css.CssStyle;

public class Styles {
	
	private HtmlElement e = null;
	
	private List<CssStyle> cssStyles = new ArrayList<CssStyle>();
	
	public Styles(HtmlElement e) {
		this.e = e;
	}



	/**
	 * Set style for this element. Style is put inside &lt;style&gt; element.
	 * @param css
	 */
	public void setStyle(CssStyle... style) {
		
		for (int i = 0; i < style.length; i++) {
			
			if (style[i].getSelector() == null) {
				
				System.out.println("style is NULL !!!!!!!!!!!!!!!!!!!!!!!!!!!");
//				style[i].setSelector("." + style[i].getStyleId());
//				appendAttribute(Attribute.CLASS, style[i].getStyleId());
				style[i].setSelector(e.getName());
				
			} else if (style[i].getSelector().startsWith("#")) {
				
				// TODO a ni to isto kot setId?
				e.getAttributes().add(Attributes.ID, e.getAttributes().getId());
				
			} else if (style[i].getSelector().startsWith(".")) {
				
				e.getAttributes().append(Attributes.CLASS, style[i].getStyleId());
				
			} else {
				
//				style[i].setSelector(getTagName());
				
			}
			cssStyles.add(style[i]);
			
		}
		
		
	}



	public List<CssStyle> getCssStyles() {
		return cssStyles;
	}
	
	
	
	private static Map<Integer, String> tempCssHash = new HashMap<Integer, String>();
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < cssStyles.size(); i++) {
			String st = cssStyles.get(i).toString();
			if (tempCssHash.containsKey(st.hashCode())) {
//				System.out.println("style already exists1");
			} else {
				tempCssHash.put(st.hashCode(), null);
				sb.append(st);
			}
			
		}
		
		
		return sb.toString().trim();
	}
	
}
