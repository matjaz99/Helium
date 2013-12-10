package si.matjazcerkvenik.helium.examples;

import java.util.ArrayList;
import java.util.List;

import si.matjazcerkvenik.helium.HtmlElement;
import si.matjazcerkvenik.helium.html.StringElement;
import si.matjazcerkvenik.helium.tools.DynamicTableBuilder;

/**
 * Create table by adding rows
 * 
 * @author matjaz
 *
 */
public class Table2 {
	
	public static void main(String[] args) {
		
		DynamicTableBuilder tb = new DynamicTableBuilder();
		
		List<HtmlElement> row1 = new ArrayList<HtmlElement>();
		row1.add(new StringElement("John"));
		row1.add(new StringElement("Fred"));
		row1.add(new StringElement("Lucy"));
		List<HtmlElement> row2 = new ArrayList<HtmlElement>();
		row2.add(new StringElement("111-222"));
		row2.add(new StringElement("111-333"));
//		row2.add(new StringElement("111-444"));
		
		tb.addRow(row1);
		tb.addRow(row2);

		System.out.println(tb.getHtmlTable().toString());
		
	}
	
}
