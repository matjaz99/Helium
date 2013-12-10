package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;


/**
 * This class represents <code>&lt;a&gt;</code> element which is probably most 
 * used element in HTML. It provides many constructors for easy 
 * creation of links in HTML document.
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class Anchor extends HtmlElement {
	
	/** Specifies the URL of the page the link goes to */
	public static final String ATTR_HREF = "href";
	
	/** Specifies the language of the linked document */
	public static final String ATTR_HREFLANG = "hreflang";
	
	/** Specifies where to open the linked document */
	public static final String ATTR_TARGET = "target";
	
	/**
	 * Target definitions of <code>&lt;a&gt;</code> element.
	 */
	public enum TARGET { _BLANK, _PARENT, _SELF, _TOP };
	
	/**
	 * Default constructor of empty anchor element:<br>
	 * <code>&lt;a&gt;&lt;/a&gt;</code>
	 */
	public Anchor() {
	}
	
	/**
	 * Constructor of anchor element with href attribute, but with no child element:<br>
	 * <code>&lt;a href="url"&gt;&lt;/a&gt;</code>
	 * @param url
	 */
	public Anchor(String url) {
		setHref(url);
	}
	
	/**
	 * Constructor of anchor element with href attribute and child element:<br>
	 * <code>&lt;a href="url"&gt;&lt;...&gt;&lt;/a&gt;</code>
	 * @param url
	 * @param e
	 */
	public Anchor(String url, HtmlElement e) {
		setHref(url);
		addElement(e);
	}
	
	/**
	 * Constructor of anchor element with href attribute and text (link):<br>
	 * <code>&lt;a href="url"&gt;text&lt;/a&gt;</code>
	 * @param url
	 * @param text
	 */
	public Anchor(String url, String text) {
		setHref(url);
		addElement(new StringElement(text));
	}
	
	@Override
	public String getName() {
		return "a";
	}
	
	/**
	 * Add <code>href</code> attribute for given url.<br>
	 * This is simplified version of addAttribute method.
	 * The same can be achieved by calling 
	 * <code>addAttribute(Anchor.ATTR_HREF, "http://...")</code> 
	 * method.
	 * @param url
	 */
	public void setHref(String url) {
		getAttributes().add(ATTR_HREF, url);
	}
	
}
