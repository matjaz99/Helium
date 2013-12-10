package si.matjazcerkvenik.helium;

import java.util.ArrayList;
import java.util.List;

import si.matjazcerkvenik.helium.css.CssStyle;

/**
 * Abstract representation of HTML element. Each HTML element consists of 
 * attributes and one or more child elements.<br>
 * This class cannot be instanced because it is abstract. Instead you must 
 * instance concrete class that represents concrete HTML element 
 * (eg. Div).<br>
 * This class provides methods for adding child elements and setting 
 * attributes.
 * 
 * @author Matjaž Cerkvenik
 *
 */
public abstract class HtmlElement {
	
	// http://www.w3schools.com/tags/default.asp
	// http://www.w3schools.com/jsref/dom_obj_document.asp
	// http://www.w3schools.com/jsref/dom_obj_all.asp
	
	/* list of attributes of this element */
	private Attributes attributes = new Attributes();
	
	/* list of child elements */
	private List<HtmlElement> elements = new ArrayList<HtmlElement>();
	
	private Styles styles = new Styles(this);
	
	/**
	 * Return name of HTML element.
	 * @return name
	 */
	public abstract String getName();

	/**
	 * Add child element
	 * @param e
	 * @return HtmlElement
	 */
	public HtmlElement addElement(HtmlElement... e) {
		for (int i = 0; i < e.length; i++) {
			elements.add(e[i]);
		}
		return this;

	}
	
	
	/**
	 * Get all child elements
	 * @return elements
	 */
	public List<HtmlElement> getElements() {
		return elements;
	}

	
	/**
	 * Return all attributes
	 * @return attributes
	 */
	public Attributes getAttributes() {
		return attributes;
	}
	
	
	public Styles getStyles() {
		return styles;
	}
	
	
	
	
	
	
	
	/* ****************** */
	/*   PREPARE OUTPUT   */
	/* ****************** */
	
	
	
	
	

	/**
	 * Return string representation of child elements.
	 * @return elements
	 */
	private String getElementsAsString() {
		
		if (elements.isEmpty()) return "";
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < elements.size(); i++) {
			String s = elements.get(i).toString();
			sb.append(s);
		}
		return sb.toString();
	}
	
	
	/**
	 * Return list of CssStyles of this and all child elements.
	 * @return elStyles
	 */
	public List<CssStyle> toList() {
		
		List<CssStyle> elStyles = new ArrayList<CssStyle>();
		elStyles.addAll(styles.getCssStyles());
		elStyles.addAll(getCssStylesAsList());
		
		return elStyles;
		
	}
	
	/**
	 * Return list of styles of all child elements.
	 * @return elStyles
	 */
	private List<CssStyle> getCssStylesAsList() {
		
		List<CssStyle> elStyles = new ArrayList<CssStyle>();
		
		if (elements.isEmpty()) return elStyles;
		
		for (int i = 0; i < elements.size(); i++) {
			elStyles.addAll(elements.get(i).toList());
		}
		return elStyles;
	}

	
	/**
	 * Return string representation of this and all child elements.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<").append(getName());
		sb.append(attributes.toString());
		sb.append(">\n");
		sb.append(getElementsAsString());
		sb.append("</").append(getName()).append(">\n");
		return sb.toString();
	}
	
	
}
