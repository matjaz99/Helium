package si.matjazcerkvenik.helium.css;

import si.matjazcerkvenik.helium.html.Anchor;

/**
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class LinkStyle extends TextStyle {
	
	
		
	private String linkColor = Color.Blue;
	private String visitedColor = Color.BlueViolet;
	private String hoverColor = Color.Red;
	private String activeColor = Color.Green;
	
	public LinkStyle() {
		super();
	}
	
	public LinkStyle(String selector) {
		super(selector);
	}
	
	public LinkStyle(Anchor a) {
		
		super(a);
		
	}
	
	
	
	
	public void setLinkColor(String color) {
		linkColor = color;
	}

	public void setVisitedColor(String color) {
		visitedColor = color;
	}

	public void setHoverColor(String color) {
		hoverColor = color;
	}

	public void setActiveColor(String color) {
		activeColor = color;
	}




	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(getSelector() + ":link {\n");
		sb.append("\tcolor: " + linkColor + ";\n");
		for (String key : getDeclarations().keySet()) {
			sb.append("\t" + key + ": " + getDeclarations().get(key) + ";\n");
		}
		sb.append("}\n");
		
		sb.append(getSelector() + ":visited {\n");
		sb.append("\tcolor: " + visitedColor + ";\n");
		for (String key : getDeclarations().keySet()) {
			sb.append("\t" + key + ": " + getDeclarations().get(key) + ";\n");
		}
		sb.append("}\n");
		
		sb.append(getSelector() + ":hover {\n");
		sb.append("\tcolor: " + hoverColor + ";\n");
		for (String key : getDeclarations().keySet()) {
			sb.append("\t" + key + ": " + getDeclarations().get(key) + ";\n");
		}
		sb.append("}\n");
		
		sb.append(getSelector() + ":active {\n");
		sb.append("\tcolor: " + activeColor + ";\n");
		for (String key : getDeclarations().keySet()) {
			sb.append("\t" + key + ": " + getDeclarations().get(key) + ";\n");
		}
		sb.append("}\n");
		
		return sb.toString();
	}
	
}
