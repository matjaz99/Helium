package si.matjazcerkvenik.htmllib.boxes;

public class HorizontalBoxLayout extends Box {
	
	public String getStyle() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("#" + getId() + " {\n");
		sb.append("float: left;\n");
		
		if (getWidth() != 0) {
			sb.append("width: " + getWidth() + "px;\n");
		}
		if (getHeight() != 0) {
			sb.append("height: " + getHeight() + "px;\n");
		}
		
		String m = "";
		for (int i = 0; i < getMargin().length; i++) {
			m += getMargin()[i] + "px ";
		}
		sb.append("margin: " + m.trim() + ";\n");
		
		String p = "";
		for (int i = 0; i < getPadding().length; i++) {
			p += getPadding()[i] + "px ";
		}
		sb.append("padding: " + p.trim() + ";\n");
		
		String b = "";
		for (int i = 0; i < getBorder().length; i++) {
			b += getBorder()[i] + " ";
		}
		sb.append("border: " + b.trim() + ";\n");
		sb.append("}");
		
		return sb.toString();
		
	}
	
}
