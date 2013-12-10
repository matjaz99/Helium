package si.matjazcerkvenik.helium.css;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * Set text properties of the element:
 * <ul>
 * <li>font-family</li>
 * <li>font-size</li>
 * <li>color</li>
 * <li>text-decoration</li>
 * <li>text-shadow</li>
 * </ul>
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class TextStyle extends CssStyle {
	
	// http://www.w3schools.com/css/css_text.asp
	
	public TextStyle() {
		
		super();
		
	}
	
	public TextStyle(int pxSize, String color, String... family) {
		
		super();
		setFontFamily(family);
		setTextColor(color);
		setFontSize(pxSize, "px");
		setTextDecoration("none");
		
	}
	
	public TextStyle(String selector) {
		
		super(selector);
		
	}
	
	public TextStyle(HtmlElement e) {
		
		super(e);
		
	}
	
	public void setFontFamily(String... fonts) {
		
		String ff = "";
		
		for (int i = 0; i < fonts.length; i++) {
			if (i == fonts.length - 1) {
				ff += fonts[i];
			} else {
				ff += fonts[i] + ", ";
			}
			
		}
		
		set("font-family", ff);
		
	}
	
	public void setFontSize(int size, String unit) {
		set("font-size", size + unit);
	}
	
	public void setTextColor(String color) {
		set("color", color);
	}
	
	public void setAlignment(String align) {
		set("text-align", align);
	}
	
	public void setTextDecoration(String decor) {
		set("text-decoration", decor);
	}
	
	/**
	 * Set shadow options for text. negative values for xOffset and yOffset 
	 * are allowed.
	 * @param xOffset
	 * @param yOffset
	 * @param blur
	 * @param color
	 */
	public void setShadow(int xOffset, int yOffset, int blur, String color) {
		set("text-shadow", xOffset + "px " + yOffset + "px " + blur + "px " + color);
	}
	
}
