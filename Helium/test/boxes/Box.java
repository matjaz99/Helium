package si.matjazcerkvenik.htmllib.boxes;

import java.util.ArrayList;
import java.util.List;

import si.matjazcerkvenik.htmllib.Attribute;
import si.matjazcerkvenik.htmllib.Div;
import si.matjazcerkvenik.htmllib.HtmlElement;

public class Box {
		
	private List<Box> boxes = new ArrayList<Box>();
	
	public static int boxCounter = 0;
	
	private String id = null;
	
	private HtmlElement htmlElement = null;
	
	public enum PROPERTY { WIDTH, HEIGHT, MARGIN, BORDER, PADDING, FLOAT }
		
	public enum UNIT { PX, PT, EM, AUTO }
	
	private UNIT unit = UNIT.PT;
	
	private int width = 0;
	private int height = 0;
	private int[] margin = { 0, 0, 0, 0 };
	private int[] padding = { 10, 10, 10, 10 };
	private String[] border = { "1px", "solid", "gray" };
	
	
	public Box() {
		id = "box" + boxCounter++;
	}
	
	public void addBox(Box b) {
		boxes.add(b);
		
	}
	
	
	
	
	public List<Box> getBoxes() {
		return boxes;
	}




	public void setHtmlElement(HtmlElement htmlElement) {
		this.htmlElement = htmlElement;
	}

	public void setProperty(PROPERTY prop, UNIT unit, String... val) {
		// maybe I should do like this...?
		switch (prop) {
		case WIDTH:
//			width = val[0];
			break;
		case BORDER:
			border[0] = val[0];
			border[1] = val[1];
			border[2] = val[2];
			break;

		default:
			break;
		}
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setWidth(int px) {
		width = px;
	}
	
	
	
	public int getWidth() {
		return width;
	}

	public void setHeight(int px) {
		height = px;
	}
	
	public int getHeight() {
		return height;
	}

	public void setBorder(String... b) {
		
	}
	
	public String[] getBorder() {
		return border;
	}

	public void setMargin(int... px) {
		
		if (px.length == 1) {
			// all margins the same
		} else if (px.length == 2) {
			// top and bottom are the same
			// right and left are the same
		} else if (px.length == 3) {
			// top, right and left, bottom
		} else if (px.length == 4) {
			// top, right, bottom, left
		}
		System.out.println("len=" + px.length);
		
	}
	
	public int[] getMargin() {
		return margin;
	}

	public void setPadding(int... px) {
		
		if (px.length == 1) {
			// all margins the same
		} else if (px.length == 2) {
			// top and bottom are the same
			// right and left are the same
		} else if (px.length == 3) {
			// top, right and left, bottom
		} else if (px.length == 4) {
			// top, right, bottom, left
		}
		System.out.println("len=" + px.length);
		
	}
	
	public int[] getPadding() {
		return padding;
	}

	public Div getAsHtmlElement() {
		Div div = new Div();
		div.addAttribute(Attribute.ID, id);
		if (htmlElement != null) {
			div.addElement(htmlElement);
		} else {
			for (int i = 0; i < boxes.size(); i++) {
				div.addElement(boxes.get(i).getAsHtmlElement());
			}
		}
		return div;
	}
	
	public String getStyle() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("#" + id + " {\n");
		if (width != 0) {
			sb.append("width: " + width + "px;\n");
		}
		if (height != 0) {
			sb.append("height: " + height + "px;\n");
		}
		
		String m = "";
		for (int i = 0; i < margin.length; i++) {
			m += margin[i] + "px ";
		}
		sb.append("margin: " + m.trim() + ";\n");
		
		String p = "";
		for (int i = 0; i < padding.length; i++) {
			p += padding[i] + "px ";
		}
		sb.append("padding: " + p.trim() + ";\n");
		
		String b = "";
		for (int i = 0; i < border.length; i++) {
			b += border[i] + " ";
		}
		sb.append("border: " + b.trim() + ";\n");
		sb.append("}");
		
		return sb.toString();
		
	}
	
	public void clearFloat() {
		
	}
	

//	@Override
//	public String toString() {
//		
//		Div div = new Div();
//		for (int i = 0; i < boxes.size(); i++) {
//			div.addElement(boxes.get(i).getAsHtmlElement());
//		}
//		
//		return div.toString();
//	}
	
	
	
}
