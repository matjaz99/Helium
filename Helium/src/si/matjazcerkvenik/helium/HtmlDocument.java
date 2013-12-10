package si.matjazcerkvenik.helium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import si.matjazcerkvenik.helium.css.CssStyle;
import si.matjazcerkvenik.helium.html.Body;
import si.matjazcerkvenik.helium.html.Head;
import si.matjazcerkvenik.helium.html.Style;

/**
 * This class represents the whole HTML document (<code>&lt;html&gt;</code>). 
 * It consists of two main HTML elements: head and body.
 * 
 * @author matjaz
 *
 */
public class HtmlDocument {
	
	private DOCTYPE doctype = null;
	private Head head = null;
	private Body body = null;
	
	private List<CssStyle> cssStyles = new ArrayList<CssStyle>();
	
	private static Map<Integer, String> tempCssHash = new HashMap<Integer, String>();
	
	/**
	 * DOCTYPE definitions.<br>
	 * Remark: XHTML is not fully supported in HtmlLib yet!
	 *
	 */
	public enum DOCTYPE {
		
		DOCTYPE_HTML5 ("<!DOCTYPE html>"),
		DOCTYPE_HTML401_STRICT ("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">"),
		DOCTYPE_HTML401_TRANSITIONAL ("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">"),
		DOCTYPE_HTML401_FRAMESET ("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Frameset//EN\" \"http://www.w3.org/TR/html4/frameset.dtd\">"),
		DOCTYPE_XHTML10_STRICT ("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">"),
		DOCTYPE_XHTML10_TRANSITIONAL ("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"),
		DOCTYPE_XHTML10_FRAMESET ("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Frameset//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd\">"),
		DOCTYPE_XHTML11 ("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">");
		
		private String dType = null;
		
		private DOCTYPE(String s) {
			dType = s;
		}
		
		public String getDoctype() {
			return dType;
		}
		
	}
	
	/**
	 * Constructor of empty <code>&lt;html&gt;</code> element.
	 */
	public HtmlDocument() {
	}

	/**
	 * Constructor of <code>&lt;html&gt;</code> element with given 
	 * <code>&lt;head&gt;</code> and <code>&lt;body&gt;</code> element.
	 * @param head
	 * @param body
	 */
	public HtmlDocument(Head head, Body body) {
		this.head = head;
		this.body = body;
	}
	
	/**
	 * Get <code>&lt;head&gt;</code> element.
	 * @return head
	 */
	public Head getHead() {
		return head;
	}

	/**
	 * Set <code>&lt;head&gt;</code> element.
	 * @param head
	 */
	public void setHead(Head head) {
		this.head = head;
	}

	/**
	 * Get <code>&lt;body&gt;</code> element.
	 * @return body
	 */
	public Body getBody() {
		return body;
	}

	/**
	 * Set <code>&lt;body&gt;</code> element.
	 * @param body
	 */
	public void setBody(Body body) {
		this.body = body;
	}

	/**
	 * Get DOCTYPE declaration
	 * @return doctype
	 */
	public DOCTYPE getDoctype() {
		return doctype;
	}

	/**
	 * Set DOCTYPE declaration
	 * @param doctype
	 */
	public void setDoctype(DOCTYPE doctype) {
		this.doctype = doctype;
	}
	
	public void setStyle(CssStyle... css) {
		
		for (int i = 0; i < css.length; i++) {
			cssStyles.add(css[i]);
		}
		
	}
	
	private void generateStyleElement() {
		
		StringBuilder sb = new StringBuilder();
		
		// get document styles
		for (int i = 0; i < cssStyles.size(); i++) {
			String st = cssStyles.get(i).toString();
			if (tempCssHash.containsKey(st.hashCode())) {
				System.out.println("style already exists " + st.substring(0, st.indexOf("{")));
			} else {
				tempCssHash.put(st.hashCode(), null);
				sb.append(st);
			}
			
		}
		
		// get element styles
		List<CssStyle> elStyles = body.toList();
		
		for (int i = 0; i < elStyles.size(); i++) {
			String st = elStyles.get(i).toString();
			if (tempCssHash.containsKey(st.hashCode())) {
				System.out.println("style already exists2 " + st.substring(0, st.indexOf("{")));
			} else {
				tempCssHash.put(st.hashCode(), null);
				sb.append(st);
			}
		}
		
		tempCssHash.clear();
		
		Style style = new Style(sb.toString().trim());
		head.addElement(style);
		
	}
	
	

	@Override
	public String toString() {
		
		generateStyleElement();
		
		StringBuilder sb = new StringBuilder();
		if (doctype != null) {
			sb.append(doctype.getDoctype());
		}
		sb.append("<html>");
		sb.append(head.toString());
		sb.append(body.toString());
		sb.append("</html>");
		return sb.toString();
	}
	
}
