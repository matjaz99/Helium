package si.matjazcerkvenik.helium.examples;

import java.util.ArrayList;
import java.util.List;

import si.matjazcerkvenik.helium.HtmlElement;
import si.matjazcerkvenik.helium.html.StringElement;
import si.matjazcerkvenik.helium.html.Table;
import si.matjazcerkvenik.helium.tools.DynamicTableBuilder;

/**
 * Create table by adding columns.
 * 
 * @author matjaz
 *
 */
public class Table1 {
	
	public static void main(String[] args) {
		
		DynamicTableBuilder tb = new DynamicTableBuilder();
		
		List<HtmlElement> col1 = new ArrayList<HtmlElement>();
		col1.add(new StringElement("John"));
		col1.add(new StringElement("Fred"));
		col1.add(new StringElement("Lucy"));
		List<HtmlElement> col2 = new ArrayList<HtmlElement>();
		col2.add(new StringElement("111-222"));
		col2.add(new StringElement("111-333"));
		col2.add(new StringElement("111-444"));
		
		tb.addColumn(col1);
		tb.addColumn(col2);
		tb.addColumn(null);
		
		Table t = tb.getHtmlTable();
		
		System.out.println(t.toString());
		
	}
	
}
