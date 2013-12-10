package si.matjazcerkvenik.helium.css;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * Set box properties of the element:
 * <ul>
 * <li>background-color</li>
 * <li>margin</li>
 * <li>border</li>
 * <li>padding</li>
 * <li>width</li>
 * </ul>
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class BoxStyle extends BackgroundStyle {
	
	public BoxStyle() {
		
		super();
		
	}
	
	
	public BoxStyle(String selector) {
		
		super(selector);
		
	}
	
	public BoxStyle(HtmlElement e) {
		
		super(e);
		
	}
	
	/**
	 * Set border properties of the box.
	 * @param width in px
	 * @param color
	 */
	public void setBorder(int width, String color) {
		set(Css.BORDER, width + "px solid " + color);
	}
	
	/**
	 * Set margins. Parameter <code>margin</code> accepts one to four integers 
	 * to simulate real CSS styling:
	 * <ul>
	 * <li>one number means that all margins will wave the same value</li>
	 * <li>two numbers mean that top and bottom margins have the same value, as 
	 * well as left and right margins</li>
	 * <li>three numbers - first number is for top margin, second number is for left 
	 * and right margin and the third number is for bottom margin</li>
	 * <li>four numbers provide values for top, right, bottom and left margin separately</li>
	 * </ul>
	 * @param unit
	 * @param margin
	 */
	public void setMargin(String unit, int... margin) {
		String value = "";
		if (margin.length == 1) {
			// all margins the same
			value = margin[0] + unit;
		} else if (margin.length == 2) {
			// top and bottom are the same
			// right and left are the same
			value = margin[0] + unit + " " + margin[1] + unit;
		} else if (margin.length == 3) {
			// top, right and left, bottom
			value = margin[0] + unit + " " + margin[1] + unit + " " + margin[2] + unit;
		} else if (margin.length >= 4) {
			// top, right, bottom, left
			value = margin[0] + unit + " " + margin[1] + unit + " " + margin[2] + unit + " " + margin[3] + unit;
		}
		set(Css.MARGIN, value);
	}
	
	/**
	 * Set paddings. Parameter <code>padding</code> accepts one to four integers 
	 * to simulate real CSS styling:
	 * <ul>
	 * <li>one number means that all paddings will wave the same value</li>
	 * <li>two numbers mean that top and bottom paddings have the same value, as 
	 * well as left and right margins</li>
	 * <li>three numbers - first number is for top padding, second number is for left 
	 * and right padding and the third number is for bottom padding</li>
	 * <li>four numbers provide values for top, right, bottom and left padding separately</li>
	 * </ul>
	 * @param unit
	 * @param padding
	 */
	public void setPadding(String unit, int... padding) {
		String value = "";
		if (padding.length == 1) {
			// all margins the same
			value = padding[0] + unit;
		} else if (padding.length == 2) {
			// top and bottom are the same
			// right and left are the same
			value = padding[0] + unit + " " + padding[1] + unit;
		} else if (padding.length == 3) {
			// top, right and left, bottom
			value = padding[0] + unit + " " + padding[1] + unit + " " + padding[2] + unit;
		} else if (padding.length >= 4) {
			// top, right, bottom, left
			value = padding[0] + unit + " " + padding[1] + unit + " " + padding[2] + unit + " " + padding[3] + unit;
		}
		set(Css.PADDING, value);
	}
	
	/**
	 * Set fixed width of the box.<br>
	 * <b>Remark:</b> fixed width will override auto width parameter
	 * @param w
	 * @param unit
	 */
	public void setWidth(int w, String unit) {
		set(Css.WIDTH, w + unit);
	}
	
	/**
	 * Set auto width of the box.<br>
	 * <b>Remark:</b> auto width will override fixed width parameter
	 */
	public void setAutoWidth() {
		set(Css.WIDTH, "auto");
	}
	
	/**
	 * Set fixed height of the box.<br>
	 * @param h
	 * @param unit
	 */
	public void setHeight(int h, String unit) {
		set(Css.HEIGHT, h + unit);
	}
	
	public void setFloatLeft() {
		set(Css.FLOAT, "left");
	}
	
}
