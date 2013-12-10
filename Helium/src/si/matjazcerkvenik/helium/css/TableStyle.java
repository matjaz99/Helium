package si.matjazcerkvenik.helium.css;

import si.matjazcerkvenik.helium.html.Table;

/**
 * Set style properties of the {@link Table} element:
 * <ul>
 * <li>background-color</li>
 * <li>cell padding</li>
 * <li>odd row background-color</li>
 * <li>even row background-color</li>
 * <li>border</li>
 * </ul>
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class TableStyle extends CssStyle {
	
	// http://www.w3schools.com/css/css_table.asp
	// http://www.textfixer.com/resources/css-tables.php
	// http://coding.smashingmagazine.com/2008/08/13/top-10-css-table-designs/
	// http://tablestyler.com/
		
	private String headerRowColor = Color.DarkSeaGreen;
	private String oddRowColor = Color.Beige;
	private String evenRowColor = Color.Bisque;
	private String cellPadding = "5px";
	
	private String hRowSelector = "hRow";
	private String oRowSelector = "oRow";
	private String eRowSelector = "eRow";
		
	public TableStyle() {
		
		super();
		setSelector(".tbl" + getStyleId());
		hRowSelector += getStyleId();
		oRowSelector += getStyleId();
		eRowSelector += getStyleId();
		
		setBorder(1, Color.Green);
	}
	
	/**
	 * Since the styling of tables is quite complex, you must provide 
	 * a reference to the table you wish to style. CSS selectors are 
	 * defined on the basis of table element id. Each table must have 
	 * unique id.
	 * @param table
	 */
	public TableStyle(Table table) {
		
		// TODO styling according to ID
		
//		hRowSelector += table.getId();
//		oRowSelector += table.getId();
//		eRowSelector += table.getId();
//		setSelector(".tbl" + table.getId());
		
		setSelector(".tbl" + getStyleId());
		hRowSelector += getStyleId();
		oRowSelector += getStyleId();
		eRowSelector += getStyleId();
		
		setBorder(1, Color.Green);
	}
	
	

	/**
	 * Set background {@link Color} for table header.
	 * @param color
	 */
	public void setHeaderRowColor(String color) {
		headerRowColor = color;
	}
	
	/**
	 * Set background {@link Color} for odd rows.
	 * @param color
	 */
	public void setOddRowColor(String color) {
		oddRowColor = color;
	}
	
	/**
	 * Set background {@link Color} for even rows.
	 * @param color
	 */
	public void setEvenRowColor(String color) {
		evenRowColor = color;
	}
	
	/**
	 * Set table border and grid lines.
	 * @param width
	 * @param color
	 */
	public void setBorder(int width, String color) {
		set("border", width + "px solid " + color);
	}
	
	/**
	 * Set cell padding
	 * @param unit
	 * @param padding
	 */
	public void setCellPadding(String unit, int... padding) {
		String value = "";
		if (padding.length == 1) {
			value = padding[0] + unit;
		} else if (padding.length == 2) {
			value = padding[0] + unit + " " + padding[1] + unit;
		} else if (padding.length == 3) {
			value = padding[0] + unit + " " + padding[1] + unit + " " + padding[2] + unit;
		} else if (padding.length >= 4) {
			value = padding[0] + unit + " " + padding[1] + unit + " " + padding[2] + unit + " " + padding[3] + unit;
		}
		cellPadding = value;
	}
	
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(getSelector() + " {\n");
		sb.append("\tborder-collapse: collapse;\n");
		sb.append("}\n");
		
		sb.append(getSelector() + ", " + getSelector() + " th, " + getSelector() + " td {\n");
		for (String key : getDeclarations().keySet()) {
			sb.append("\t" + key + ": " + getDeclarations().get(key) + ";\n");
		}
		sb.append("}\n");
		
//		sb.append("." + hRowSelector + " {\n");
//		sb.append("\tbackground-color: " + headerRowColor + ";\n");
//		sb.append("}\n");
		
//		sb.append("." + oRowSelector + " {\n");
//		sb.append("\tbackground-color: " + oddRowColor + ";\n");
//		sb.append("}\n");
		
//		sb.append("." + eRowSelector + " {\n");
//		sb.append("\tbackground-color: " + evenRowColor + ";\n");
//		sb.append("}\n");
		
		sb.append("." + hRowSelector + " th {\n");
		sb.append("\tpadding: " + cellPadding + ";\n");
		sb.append("\tbackground-color: " + headerRowColor + ";\n");
		sb.append("}\n");
		
		sb.append("." + oRowSelector + " td {\n");
		sb.append("\tpadding: " + cellPadding + ";\n");
		sb.append("\tbackground-color: " + oddRowColor + ";\n");
		sb.append("}\n");
		
		sb.append("." + eRowSelector + " td {\n");
		sb.append("\tpadding: " + cellPadding + ";\n");
		sb.append("\tbackground-color: " + evenRowColor + ";\n");
		sb.append("}\n");
		
		return sb.toString();
	}
	
	
}
