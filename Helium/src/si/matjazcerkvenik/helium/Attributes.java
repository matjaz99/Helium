package si.matjazcerkvenik.helium;

import java.util.HashMap;
import java.util.Map;

import si.matjazcerkvenik.helium.tools.Util;

public class Attributes {
	
	private Map<String, String> attributes = new HashMap<String, String>();
	
	/* GLOBAL ATTRIBUTES */
	/** Unique id for an element */
	public static final String ID = "id";
	/**
	 * One or more class names for an element (refers to a class in a style
	 * sheet)
	 */
	public static final String CLASS = "class";
	/** Language of the element's content */
	public static final String LANG = "lang";
	/** Inline CSS style for an element */
	public static final String STYLE = "style";
	/** Information about an element */
	public static final String TITLE = "title";
	
	/* EVENT ATTRIBUTES */
	/** Fires after the page is finished loading */
	public static final String ONLOAD = "onload";
	/** Fires once a page has unloaded (or the browser window has been closed) */
	public static final String ONUNLOAD = "onunload";
	/** Fires on a mouse click on the element */
	public static final String ONCLICK = "onclick";
	/** Fires when a mouse button is pressed down on an element */
	public static final String ONMOUSEDOWN = "onmousedown";
	/** Fires when the mouse pointer moves out of an element */
	public static final String ONMOUSEOUT = "onmouseout";
	/** Fires when the mouse pointer moves over an element */
	public static final String ONMOUSEOVER = "onmouseover";
	/** Fires when a mouse button is released over an element */
	public static final String ONMOUSEUP = "onmouseup";
	
	
	
	/**
	 * Manually set element ID. You must apply ID 
	 * before applying any style, because CSS styles are generated 
	 * on the basis of ID. Once the style is added, ID may not be changed!<br>
	 * Anyway, HtmlLib is designed in this way, that the user does not need 
	 * to take care of IDs, unless necessary. HtmlLib automatically 
	 * assigns IDs to elements when needed.
	 * @param id
	 */
	public void setId(String id) {
		attributes.put(Attributes.ID, id);
	}
	
	/**
	 * Get element id. If id is not already assigned, it will 
	 * be automatically generated when this method is called.
	 * @return id
	 */
	public String getId() {
		String id = attributes.get(Attributes.ID);
		if (id == null) {
			attributes.put(Attributes.ID, "e" + Util.getCount());
		}
		return attributes.get(Attributes.ID);
	}
	
	/**
	 * Add attribute to element. If attribute with the same name 
	 * already exist, its value will be overwritten with new one.<br>
	 * Remark: to modify existing attribute, first read attribute, modify 
	 * it then save it back as new parameter.
	 * @param attrName
	 * @param attrValue
	 */
	public void add(String attrName, String attrValue) {
		attributes.put(attrName, attrValue);
	}
	
	/**
	 * Append new value of the attribute. If attribute does not exist 
	 * yet, it will be added (the same as addAttribute method). If 
	 * attribute already exists, new value will be appended to that 
	 * attribute.
	 * @param attrName
	 * @param attrValue
	 */
	public void append(String attrName, String attrValue) {
		String v = attributes.get(attrName);
		if (v == null) {
			attributes.put(attrName, attrValue);
		} else {
			v += " " + attrValue;
			attributes.put(attrName, v);
		}
	}
	
	/**
	 * Return string representation of all attributes in key="value" format.
	 * If no attributes are found, empty string is returned.
	 * @return attributes
	 */
	@Override
	public String toString() {
		
		if (attributes.isEmpty()) return "";
		
		StringBuilder sb = new StringBuilder();
		for (String key : attributes.keySet()) {
			sb.append(key + "=\"" + attributes.get(key) + "\" ");
		}
		return " " + sb.toString();
	}
	
}
