package si.matjazcerkvenik.helium.css;

import java.util.HashMap;
import java.util.Map;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * Class for defining custom CSS styles.<br>
 * Standard CSS properties (ie. declarations) can be set with 
 * {@link #set(String, String) setDeclaration()} method. 
 * The method accepts Strings, so any custom defined declaration can be used.<br>
 * The following classes provide predefined String, which can be used in declarations:
 * <ul>
 * <li>{@link Color} - list of CSS color names</li>
 * <li>{@link FontFamily} - list of commonly used fonts</li>
 * </ul>
 * Selector of CSS can be set manually or it can be automatically generated 
 * from the <code>id</code> or <code>class</code> attribute of the 
 * element. Every style class uses three different constructors to set selector:<br>
 * <ol>
 * <li>By using default constructor the style is applied according to the class 
 * attribute. The same instance of style can be applied to many different html 
 * elements.</li>
 * <li>Constructor with String signature is used to set any user defined selector. 
 * This instance of CssStyle can be used to set general style for all elements of 
 * the same type.</li>
 * <li>Constructor with HtmlElement signature is used to apply style according to 
 * the <code>id</code> attribute of the HTML element. The same instance of style should only be 
 * applied to one HTML element, but one element can have multiple different CssStyles with 
 * the same selector.</li>
 * </ol>
 * Although <code>CssStyle</code> class can be used to set any custom defined style, 
 * several subtypes of styles are derived from CssStyle:
 * <ul>
 * <li>{@link BackgroundStyle} - set background properties of the element</li>
 * <li>{@link BoxStyle} - set margins, borders and paddings</li>
 * <li>{@link LinkStyle} - set properties of {@link Anchor} element</li>
 * <li>{@link TableStyle} - set background colors and borders of tables</li>
 * <li>{@link TextStyle} - set text properties: font-family, size, color, decoration...</li>
 * </ul>
 * CssStyle class has no styling predefined. Unlike CssStyle, derivations of CssStyle have 
 * default style declarations already predefined.<br>
 * <br>
 * Example:
 * <code>CssStyle myStyle1 = new CssStyle(".bigGreenText");</code><br>
 * <code>myStyle1.setDeclaration("font-size", "20px")</code><br>
 * <code>myStyle1.setDeclaration("color", "green")</code><br>
 * <br>
 * will result in:<br>
 * <br>
 * <code>.bigGreenText {</code><br>
 * <code>font-size: 20px;</code><br>
 * <code>color: green;</code><br>
 * <code>}</code>
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class CssStyle {
	
	/** Selector of style */
	private String selector = null;
	
	/** Map of CSS declarations */
	private Map<String, String> declarations = new HashMap<String, String>();
	
	/** Counter of styles */
	private static int styleCounter = 0;
	
	/** Unique ID of this style */
	private String styleId = null;
	
	/**
	 * Default constructor for custom CssStyle where 
	 * selector is set to '.styleId'.
	 * This style can be applied to the element 
	 * according to its class attribute. 
	 */
	public CssStyle() {
		this.selector = "." + getStyleId();
	}
	
	/**
	 * Create custom style with custom selector.
	 * @param selector
	 */
	public CssStyle(String selector) {
		getStyleId();
		this.selector = selector;
	}
	
	/**
	 * Constructor of CssStyle, where selector is set to '#elementId'.
	 * This style can be applied to the element according 
	 * to the ID attribute. 
	 * 
	 * @param e
	 */
	public CssStyle(HtmlElement e) {
		getStyleId();
		this.selector = "#" + e.getAttributes().getId();
	}
	

	/**
	 * Set selector for this CSS style.
	 * @param selector
	 */
	public void setSelector(String selector) {
		this.selector = selector;
	}
	
	
	/**
	 * Return selector of this style.
	 * @return selector
	 */
	public String getSelector() {
		return selector;
	}
	
	
	/**
	 * Return map of css declarations.
	 * @return declarations
	 */
	public Map<String, String> getDeclarations() {
		return declarations;
	}
	
	
	/**
	 * Set custom CSS declaration.
	 * @param property
	 * @param value
	 */
	public void set(String property, String value) {
		declarations.put(property, value);
	}
	
	
	/**
	 * Style ID is unique ID of every style. It is used for internal purposes only. 
	 * In many cases, style ID is not the same as the selector, but it is part of 
	 * selector.
	 * @return styleId
	 */
	public String getStyleId() {
		if (styleId == null) {
			styleId = "sty" + styleCounter++;
		}
		return styleId;
	}
	
	
	/**
	 * Return string representation of this CSS style. 
	 * @return style
	 */
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(selector + " {\n");
		
		for (String key : declarations.keySet()) {
			sb.append("\t" + key + ": " + declarations.get(key) + ";\n");
		}
		sb.append("}\n");
		
		return sb.toString();
	}
	
	
	/**
	 * Return string representation of inline style (without selector). 
	 * Inline style can only be used inside style attribute of HTML element.
	 * @return inlineStyle
	 */
	public String getInlineStyleString() {
		StringBuilder sb = new StringBuilder();
		for (String key : declarations.keySet()) {
			sb.append(key + ": " + declarations.get(key) + "; ");
		}
		
		return sb.toString();
	}
	
		
}
