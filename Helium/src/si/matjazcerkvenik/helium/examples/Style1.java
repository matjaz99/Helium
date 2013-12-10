package si.matjazcerkvenik.helium.examples;

import java.util.ArrayList;
import java.util.List;

import si.matjazcerkvenik.helium.HtmlDocument;
import si.matjazcerkvenik.helium.HtmlElement;
import si.matjazcerkvenik.helium.css.BackgroundStyle;
import si.matjazcerkvenik.helium.css.BoxStyle;
import si.matjazcerkvenik.helium.css.TableStyle;
import si.matjazcerkvenik.helium.css.TextStyle;
import si.matjazcerkvenik.helium.html.Body;
import si.matjazcerkvenik.helium.html.Br;
import si.matjazcerkvenik.helium.html.Div;
import si.matjazcerkvenik.helium.html.Head;
import si.matjazcerkvenik.helium.html.Heading;
import si.matjazcerkvenik.helium.html.Hr;
import si.matjazcerkvenik.helium.html.Paragraph;
import si.matjazcerkvenik.helium.html.StringElement;
import si.matjazcerkvenik.helium.html.Table;
import si.matjazcerkvenik.helium.tools.DynamicTableBuilder;

public class Style1 {
	
	public static void main(String[] args) {
		
//		Head head = new Head("Test");
//		Body body = new Body();
//		
//		
//		Div div0 = new Div();
//		Heading h1 = new Heading(1, "This is a test");
//		h1.setInlineStyle("color", "red");
//		div0.addElement(h1);
//		
//		body.addElement(div0);
//		body.addElement(new Hr());
//		
//		
//		Paragraph p1 = new Paragraph("This is paragraph 1");
//		p1.setInlineStyle(new TextStyle());
//		Paragraph p2 = new Paragraph("This is paragraph 2");
//		p2.setInlineStyle("color", "blue");
//		Paragraph p3 = new Paragraph("This is paragraph 3");
//		p3.setInlineStyle("color", "green");
//		p3.setInlineStyle("font-size", "12px");
//		body.addElement(p1).addElement(p2).addElement(p3);
//		body.addElement(new Hr()).addElement(new Br());
//		
//		
//		Div div1 = new Div();
//		Table t = getTable();
//		div1.addElement(t);
//		div1.setId("div1");
//		div1.setStyle(null, "tbl", new BoxStyle());
//		
//		body.addElement(div1);
//		body.addElement(new Br()).addElement(new Hr());
//		
//		Div div2 = new Div();
//		div2.setInlineStyle("width", "300px");
//		div2.setInlineStyle("border", "1px solid Black");
//		Paragraph p22 = new Paragraph("This is some long text. This is some long text. This is some long text. This is some long text. This is some long text. This is some long text. ");
//		p22.setInlineStyle("color", "blue");
//		div2.addElement(p22);
//		
//		body.addElement(div2);
//		
//		HtmlDocument doc = new HtmlDocument(head, body);
//		doc.setStyle("body", new BackgroundStyle());
//		doc.setStyle(new TableStyle());
		
//		System.out.println(doc.toString());
		
	}
	
	private static Table getTable() {
		
		DynamicTableBuilder tb = new DynamicTableBuilder();
		
		List<HtmlElement> col1 = new ArrayList<HtmlElement>();
		col1.add(new StringElement("John"));
		col1.add(new StringElement("Fred"));
		col1.add(new StringElement("Lucy"));
		List<HtmlElement> col2 = new ArrayList<HtmlElement>();
		col2.add(new StringElement("111-222"));
		col2.add(new StringElement("111-333"));
		col2.add(new StringElement("111-444"));
		
		tb.addColumn("Name", col1);
		tb.addColumn("Phone", col2);
		tb.addColumn("Status", null);
		
		List<HtmlElement> row1 = new ArrayList<HtmlElement>();
		row1.add(new StringElement("Bill"));
		row1.add(new StringElement("222-000"));
		row1.add(new StringElement("Online"));
		
		tb.addRow(row1);

		return tb.getHtmlTable();
		
	}
	
}
