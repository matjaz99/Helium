package si.matjazcerkvenik.helium.css;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * Set background properties of the element:
 * <ul>
 * <li>background-color</li>
 * <li>background-image</li>
 * <li>background-repeat</li>
 * </ul>
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class BackgroundStyle extends CssStyle {
	
	// http://www.w3schools.com/css/css_background.asp
			
	public BackgroundStyle() {
		
		super();
		
	}
	
	public BackgroundStyle(String selector) {
		
		super(selector);
		
	}
	
	public BackgroundStyle(HtmlElement e) {
		
		super(e);
		
	}
	
	/**
	 * Set background color of the box.
	 * @param color
	 */
	public void setBackgroundColor(String color) {
		set(Css.BACKGROUND_COLOR, color);
	}
	
	public void setBackgroundImage(String url) {
		set(Css.BACKGROUND_IMAGE, "url('" + url + "')");
	}
	
	public void setRepeatOption(String r) {
		set(Css.BACKGROUND_REPEAT, r);
	}
	
}
