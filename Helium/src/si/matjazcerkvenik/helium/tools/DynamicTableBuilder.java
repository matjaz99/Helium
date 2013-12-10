package si.matjazcerkvenik.helium.tools;

import java.util.ArrayList;
import java.util.List;

import si.matjazcerkvenik.helium.HtmlElement;
import si.matjazcerkvenik.helium.html.StringElement;
import si.matjazcerkvenik.helium.html.Table;
import si.matjazcerkvenik.helium.html.Td;
import si.matjazcerkvenik.helium.html.Th;
import si.matjazcerkvenik.helium.html.Tr;

/**
 * Dynamically expanding TableBuilder.
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class DynamicTableBuilder {

	private List<Column> table = null;

	/**
	 * Create new empty table.
	 */
	public DynamicTableBuilder() {
		table = new ArrayList<Column>();
	}
	
	/**
	 * Add new column to the table.<br>
	 * If list is null, empty column will be added.
	 * @param list
	 */
	public void addColumn(List<HtmlElement> list) {
		Column c = new Column();
		c.setColumnData(list);
		table.add(c);
	}
	
	/**
	 * Add new column to the table and specify the name of column.
	 * @param colName
	 * @param list
	 */
	public void addColumn(String colName, List<HtmlElement> list) {
		Column c = new Column();
		c.setColName(colName);
		c.setColumnData(list);
		table.add(c);
	}
	
	
//	public int addElement(int colIndex, HtmlElement e) {
//		if (colIndex >= table.size()) {
//			return -1;
//		}
//		table.get(colIndex).addElement(e);
//		return colIndex;
//	}
	
	public void makeAllColumnsTheSameLength() {
		
		int maxLength = 0;
		for (Column c : table) {
			if (c.size() > maxLength) {
				maxLength = c.size();
			}
		}
		
		for (int i = 0; i < table.size(); i++) {
			Column c = table.get(i);
			if (c.size() < maxLength) {
				while (c.size() != maxLength) {
//					c.addElement(null);
					c.addElement(new StringElement("&nbsp;"));
				}
			}
		}
		
	}
	
	/**
	 * A new row to the table
	 * @param list
	 */
	public void addRow(List<HtmlElement> list) {
		if (table.size() < list.size()) {
			
			while (table.size() != list.size()) {
				table.add(new Column());
			}
			
		}
		makeAllColumnsTheSameLength();
		for (int i = 0; i < list.size(); i++) {
			table.get(i).addElement(list.get(i));
		}
		
	}
	
	
	
	

	private class Column {
		
		private List<HtmlElement> rows = null;
		
		private String colName = null;
		
		public Column() {
			rows = new ArrayList<HtmlElement>();
		}
		
		public String getColName() {
			return colName;
		}

		public void setColName(String colName) {
			this.colName = colName;
		}


		public void setColumnData(List<HtmlElement> list) {
			if (list == null) {
				return;
			}
			rows.addAll(list);
		}
		
		public void addElement(HtmlElement e) {
			rows.add(e);
		}
		
		public HtmlElement getElement(int i) {
			if (i >= rows.size()) {
				return null;
			}
			return rows.get(i);
		}

		public List<HtmlElement> getRows() {
			return rows;
		}
		
		public int size() {
			return rows.size();
		}

		
		
	}
	

	/**
	 * Add <code>th</code> elements as first row in table.<br>
	 * The method returns true if at least one column 
	 * has <code>colName</code> different than <code>null</code>.<br>
	 * Return <code>false</code> if all column names are 
	 * <code>null</code>.
	 * @return true/false
	 */
	private boolean useHeaders() {
		
		for (Column c : table) {
			if (c.getColName() != null) {
				return true;
			}
		}
		
		return false;
	}
	

	public List<Column> getTable() {
		return table;
	}

	public void setTable(List<Column> table) {
		this.table = table;
	}
	
	public Table getHtmlTable() {
		
		makeAllColumnsTheSameLength();
		
		Table t = new Table();
		
		if (useHeaders()) {
			Tr tr = new Tr();
//			tr.addAttribute(Attribute.CLASS, "hRow");
			for (int i = 0; i < table.size(); i++) {
				Th th = new Th();
				th.addElement(new StringElement(table.get(i).getColName()));
				tr.addElement(th);
			}
			t.addElement(tr);
		}
		
		int rows = table.get(0).size();
		for (int i = 0; i < rows; i++) {
			Tr tr = new Tr();
//			if (i % 2 == 0) {
//				tr.addAttribute(Attribute.CLASS, "eRow");
//			} else {
//				tr.addAttribute(Attribute.CLASS, "oRow");
//			}
			for (int j = 0; j < table.size(); j++) {
				Td td = new Td();
				if (table.get(j).getElement(i) != null) {
					String s = table.get(j).getElement(i).toString();
					td.addElement(new StringElement(s));
				}
				tr.addElement(td);
			}
			t.addElement(tr);
		}
		
		return t;
	}
	

	@Override
	public String toString() {
		if (table.size() == 0) {
			return "";
		}
		makeAllColumnsTheSameLength();
		StringBuilder sb = new StringBuilder();
		sb.append("<table>\n");
		if (useHeaders()) {
			sb.append("<tr>\n");
			for (int i = 0; i < table.size(); i++) {
				sb.append("<th>\n");
				sb.append(table.get(i).getColName());
				sb.append("</th>\n");
			}
			sb.append("</tr>\n");
		}
		int rows = table.get(0).size();
		for (int i = 0; i < rows; i++) {
			sb.append("<tr>\n");
			for (int j = 0; j < table.size(); j++) {
				sb.append("<td>");
				sb.append(table.get(j).getElement(i));
				sb.append("</td>\n");
			}
			sb.append("</tr>\n");
		}
		sb.append("</table>");
		return sb.toString();
	}

	public static void main(String[] args) {
		
		DynamicTableBuilder tb = new DynamicTableBuilder();
		List<HtmlElement> col1 = new ArrayList<HtmlElement>();
		col1.add(new StringElement("A"));
		col1.add(new StringElement("B"));
		col1.add(new StringElement("C"));
		List<HtmlElement> col2 = new ArrayList<HtmlElement>();
		col2.add(new StringElement("D"));
		col2.add(new StringElement("E"));
		col2.add(new StringElement("F"));
		
		tb.addColumn(col1);
		tb.addColumn(col2);
		
		List<HtmlElement> row1 = new ArrayList<HtmlElement>();
		row1.add(new StringElement("X"));
		row1.add(new StringElement("Y"));
		row1.add(new StringElement("Z"));
		
		tb.addRow(row1);
		
		for (int i = 0; i < tb.getTable().size(); i++) {
			Column c = tb.getTable().get(i);
			for (int j = 0; j < c.size(); j++) {
				if (j > 0) System.out.print(", ");
				System.out.print(c.getRows().get(j));
			}
			System.out.println();
		}
		
		int rows = tb.getTable().get(0).size();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < tb.getTable().size(); j++) {
				if (j > 0) System.out.print(", ");
				System.out.print(tb.getTable().get(j).getElement(i));
			}
			System.out.println();
		}
		

		System.out.println(tb.toString());

	}

}
