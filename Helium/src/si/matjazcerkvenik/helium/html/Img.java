package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * This class represents HTML element <code>&lt;img&gt;</code>.
 * This class cannot accept child elements.
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class Img extends HtmlElement {
	
	/** URL of an image */
	public static final String ATTR_SRC = "src";
	
	/** The width of the border around an image */
	public static final String ATTR_BORDER = "border";
	
	/** Height of an image */
	public static final String ATTR_HEIGHT = "height";
	
	/** Width of an image */
	public static final String ATTR_WIDTH = "width";
	
	/** Alternate text for an image */
	public static final String ATTR_ALT = "alt";
	
	/**
	 * Default constructor
	 */
	public Img() {
	}
	
	/**
	 * Constructor of Img element with given src attribute.
	 * @param src
	 */
	public Img(String src) {
		setSource(src);		
	}
	
	@Override
	public String getName() {
		return "img";
	}
	
	public void setSource(String src) {
		getAttributes().add(ATTR_SRC, src);
	}
	
	@Override
	public String toString() {
		return "<img" + getAttributes().toString() + " />";
	}
	
}
