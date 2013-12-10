package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.Attributes;
import si.matjazcerkvenik.helium.HtmlElement;
import si.matjazcerkvenik.helium.css.TableStyle;


/**
 * This class represents <code>&lt;table&gt;</code> element.<br>
 * It should accept only <code>&lt;tr&gt;</code> element.
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class Table extends HtmlElement {
		
	@Override
	public String getName() {
		return "table";
	}
	
	/**
	 * Default constructor for HTML table.
	 */
	public Table() {
	}
	
	
	/**
	 * Get element at specified row and column position. If the element 
	 * does not exist at the specified position, null is returned.
	 * @param col
	 * @param row
	 * @return e
	 */
	public HtmlElement getTableElement(int col, int row) {
		
		if (row < 0 || col < 0) {
			return null;
		}
		
		// get row
		if (row < getElements().size()) {
			
			HtmlElement r = getElements().get(row);
			
			if (col < r.getElements().size()) {
				
				// get column
				return r.getElements().get(col);
				
			}
			
			
			
			
			
		}
		
		
		
		
		
		
		
		return null;
		
	}
	
	/**
	 * Set table style. To achieve this, table must have 
	 * unique id assigned (otherwise it will be automatically generated). 
	 * Rows are equipped with special class attribute to mark header row and 
	 * odd and even rows.<br>
	 * <b>Warning:</b> Once the style is applied, ID of table may not 
	 * be changed.
	 * @param css
	 */
	public void setStyle(TableStyle css) {
		
//		appendAttribute(Attribute.CLASS, css.getSelector());
		getAttributes().append(Attributes.CLASS, "tbl" + css.getStyleId());
		
		for (int i = 0; i < getElements().size(); i++) {
			
			HtmlElement row = getElements().get(i);
			
			// check if Th element
			if (row.getElements().get(0) instanceof Th) {
				
//				row.appendAttribute(Attribute.CLASS, "hRow" + getId());
				row.getAttributes().append(Attributes.CLASS, "hRow" + css.getStyleId());
				
			} else if (row.getElements().get(0) instanceof Td) {
				
				if (i % 2 == 0) {
//					row.appendAttribute(Attribute.CLASS, "eRow" + getId());
					row.getAttributes().append(Attributes.CLASS, "eRow" + css.getStyleId());
				} else {
//					row.appendAttribute(Attribute.CLASS, "oRow" + getId());
					row.getAttributes().append(Attributes.CLASS, "oRow" + css.getStyleId());
				}
				
			}
			
		}
		
//		cssStyles.add(css);
		getStyles().setStyle(css);
		
		
	}
	
}
