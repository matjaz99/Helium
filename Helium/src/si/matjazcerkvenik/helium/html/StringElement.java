package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * Special case of element, which is basically not an element at all.
 * This is just a container of text (String). It has no start tag or 
 * end tag. Just text.<br>
 * This class can be used in text elements, where other HTML elements 
 * can be nested inside text.<br>
 * Example:<br>
 * <code>p.addHtmlElement(new StringElement("This text is ")).addHtmlElement(new Bold("bold"));</code>
 * Output will be:<br>
 * <code>&lt;p&gt;This text is &lt;b&gt;bold&lt;/b&gt;&lt;/p&gt;</code>
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class StringElement extends HtmlElement {
	
	private String text = null;

	public StringElement(String text) {
		this.text = text;
	}
	
	@Override
	public String getName() {
		// not applicable
		return null;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
	

}
