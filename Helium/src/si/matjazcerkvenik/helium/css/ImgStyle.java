package si.matjazcerkvenik.helium.css;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * Set properties of img element:
 * <ul>
 * <li>width</li>
 * <li>height</li>
 * </ul>
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class ImgStyle extends CssStyle {
	
	public ImgStyle() {
		super();
	}
	
	public ImgStyle(String selector) {
		super(selector);
	}
	
	public ImgStyle(HtmlElement e) {
		super(e);
	}
	
	public void setWidth(int w) {
		set(Css.WIDTH, w + "px");
	}
	
	public void setHeight(int h) {
		set(Css.HEIGHT, h + "px");
	}
	
}
