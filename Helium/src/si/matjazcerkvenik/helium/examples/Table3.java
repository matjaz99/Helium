package si.matjazcerkvenik.helium.examples;

import java.util.ArrayList;
import java.util.List;

import si.matjazcerkvenik.helium.HtmlElement;
import si.matjazcerkvenik.helium.html.StringElement;
import si.matjazcerkvenik.helium.tools.DynamicTableBuilder;

/**
 * Mixed mode: adding columns and rows
 * 
 * @author matjaz
 *
 */
public class Table3 {
	
	public static void main(String[] args) {
		
		DynamicTableBuilder tb = new DynamicTableBuilder();
		
		List<HtmlElement> col1 = new ArrayList<HtmlElement>();
		col1.add(new StringElement("John"));
		col1.add(new StringElement("Fred"));
		col1.add(new StringElement("Lucy"));
		List<HtmlElement> col2 = new ArrayList<HtmlElement>();
		col2.add(new StringElement("111-222"));
		col2.add(null);
//		col2.add(new StringElement("111-333"));
		col2.add(new StringElement("111-444"));
		
		tb.addColumn("Name", col1);
		tb.addColumn("Phone", col2);
		tb.addColumn("Status", null);
		
		List<HtmlElement> row1 = new ArrayList<HtmlElement>();
		row1.add(new StringElement("Bill"));
		row1.add(new StringElement("222-000"));
		row1.add(new StringElement("Online"));
		
		tb.addRow(row1);

		System.out.println(tb.getHtmlTable().toString());
		
	}
	
}
