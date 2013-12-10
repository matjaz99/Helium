package si.matjazcerkvenik.helium.servlets;

import java.util.ArrayList;
import java.util.List;

import si.matjazcerkvenik.helium.Attributes;
import si.matjazcerkvenik.helium.HtmlDocument;
import si.matjazcerkvenik.helium.HtmlElement;
import si.matjazcerkvenik.helium.css.BackgroundStyle;
import si.matjazcerkvenik.helium.css.BoxStyle;
import si.matjazcerkvenik.helium.css.Color;
import si.matjazcerkvenik.helium.css.CssStyle;
import si.matjazcerkvenik.helium.css.FontFamily;
import si.matjazcerkvenik.helium.css.LinkStyle;
import si.matjazcerkvenik.helium.css.TableStyle;
import si.matjazcerkvenik.helium.css.TextStyle;
import si.matjazcerkvenik.helium.html.Anchor;
import si.matjazcerkvenik.helium.html.Body;
import si.matjazcerkvenik.helium.html.Br;
import si.matjazcerkvenik.helium.html.Div;
import si.matjazcerkvenik.helium.html.Head;
import si.matjazcerkvenik.helium.html.Hr;
import si.matjazcerkvenik.helium.html.Paragraph;
import si.matjazcerkvenik.helium.html.StringElement;
import si.matjazcerkvenik.helium.html.Table;
import si.matjazcerkvenik.helium.server.IServlet;
import si.matjazcerkvenik.helium.server.Request;
import si.matjazcerkvenik.helium.server.Response;
import si.matjazcerkvenik.helium.tools.DynamicTableBuilder;

public class TestPlugin implements IServlet {
	
	@Override
	public String getName() {
		return "/test";
	}
	
	@Override
	public void doGet(Request req, Response resp) {
		
		Head head = new Head("Test");
		Body body = new Body();
		
		
		
		body.addElement(getParagraphs());
		body.addElement(new Hr());
		
		
		
		body.addElement(getTable1());
		body.addElement(new Hr());
		
		body.addElement(getTable2());
		body.addElement(new Hr());
		

		
		// inline style and css style with margin and padding
		// style with user defined id
		
		body.addElement(getLongTextInBox());
		body.addElement(new Hr());
		
		
		// custom table style
		
		body.addElement(getCustomTableStyledTable());
		body.addElement(new Hr());
		
		
		// set multiple styles
		
		body.addElement(getCustomStyledTable());
		body.addElement(new Hr());
		
		
		// styling of multiple nested elements
		
		body.addElement(getNestedElements());
		body.addElement(new Hr());
		
		
		
		// styling links
		
		body.addElement(getLinks());
		body.addElement(new Hr());
		
		
		// add common styling to the document
		
		HtmlDocument doc = new HtmlDocument(head, body);
		doc.setStyle(new BackgroundStyle("body"));
		
		CssStyle hrStyle = new CssStyle("hr");
		hrStyle.set("color", "#CCC");
		hrStyle.set("background-color", "#CCC");
		hrStyle.set("height", "1px");
		hrStyle.set("border", "0px");
		doc.setStyle(hrStyle);
		
		resp.setData(doc);
		
	}
	
	/**
	 * inline styling, text styling
	 * @return
	 */
	private HtmlElement getParagraphs() {
		
		Div div = new Div();
		div.getAttributes().setId("paragraphs");
		
		Paragraph p1 = new Paragraph("This paragraph is RED with Arial font and size 14px");
		p1.getAttributes().add(Attributes.STYLE, new TextStyle(14, Color.Red, FontFamily.ARIAL, FontFamily.SANS_SERIF).getInlineStyleString());
		
		Paragraph p2 = new Paragraph("This paragraph is BLUE");
		p2.getAttributes().add(Attributes.STYLE, "color: blue;");
		
		// make style and add it to two paragraphs
		TextStyle ts1 = new TextStyle(12, Color.Green, FontFamily.ARIAL);
		Paragraph p3 = new Paragraph("1. This paragraph is GREEN with size 12px");
		p3.getStyles().setStyle(ts1);
		Paragraph p4 = new Paragraph("2. This paragraph is GREEN with size 12px");
		p4.getStyles().setStyle(ts1);
		
		div.addElement(p1).addElement(p2).addElement(p3).addElement(p4);
		
		return div;
		
	}
	
	/**
	 * table styling, apply table style and text style
	 * @return
	 */
	private HtmlElement getTable1() {
		
		TableStyle tbs = new TableStyle();
		TextStyle txs = new TextStyle();
		
		Div div1 = new Div();
		div1.getAttributes().setId("tabela1");
		Table t1 = getHtmlTable1();
		t1.setStyle(tbs);
		t1.getStyles().setStyle(txs);
		div1.addElement(t1);
		
		div1.addElement(new Hr());
		
		Table t2 = getHtmlTable2();
		t2.setStyle(tbs);
		t2.getStyles().setStyle(txs);
		div1.addElement(t2);
		
		return div1;
		
	}
	
	
	private HtmlElement getTable2() {
		
		Div div1 = new Div();
		div1.getAttributes().setId("tabela1a");
		Table t = getHtmlTable2();
		t.getStyles().setStyle(new TableStyle());
		t.getStyles().setStyle(new TextStyle());
		div1.addElement(t);
		
		return div1;
		
	}
	
	private Table getHtmlTable1() {
		
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

		return tb.getHtmlTable();
		
	}
	
	private Table getHtmlTable2() {
		
		DynamicTableBuilder tb = new DynamicTableBuilder();
		
		List<HtmlElement> col1 = new ArrayList<HtmlElement>();
		col1.add(new StringElement("Red"));
		col1.add(new StringElement("Green"));
		col1.add(new StringElement("Blue"));
		List<HtmlElement> col2 = new ArrayList<HtmlElement>();
		col2.add(new StringElement("Apples"));
		col2.add(new StringElement("Strawberries"));
		col2.add(new StringElement("Oranges"));
		List<HtmlElement> col3 = new ArrayList<HtmlElement>();
		col3.add(new StringElement("Die hard 1"));
		col3.add(new StringElement("Die hard 2"));
		col3.add(new StringElement("Die hard 3"));
		List<HtmlElement> col4 = new ArrayList<HtmlElement>();
		col4.add(new StringElement("Volvo"));
		col4.add(new StringElement("Toyota"));
		col4.add(new StringElement("Ford"));
		List<HtmlElement> col5 = new ArrayList<HtmlElement>();
		col5.add(new StringElement("George"));
		col5.add(new StringElement("Lilly"));
		col5.add(new StringElement("Michael"));
		
		tb.addColumn("Colors", col1);
		tb.addColumn("Fruits", col2);
		tb.addColumn("Movies", col3);
		tb.addColumn("Cars", col4);
		tb.addColumn("Names", col5);
		
		return tb.getHtmlTable();
		
	}
	
	
	private HtmlElement getCustomTableStyledTable() {
		
		TableStyle ts = new TableStyle();
		ts.setHeaderRowColor(Color.CadetBlue);
		ts.setEvenRowColor(Color.LightYellow);
		ts.setOddRowColor(Color.LightCyan);
		ts.setBorder(3, Color.LightSeaGreen);
		ts.setCellPadding("px", 5, 20);
		
		Div div3 = new Div();
		div3.getAttributes().setId("tabela2");
		Table t2 = getHtmlTable1();
		t2.getAttributes().setId("tab2");
		t2.setStyle(ts);
//		t2.setStyle(new TextStyle());
		div3.addElement(t2);
		
		return div3;
		
	}
	
	private HtmlElement getCustomStyledTable() {
		
		Div div4 = new Div();
		div4.getAttributes().setId("tab3");
		Table tab = getHtmlTable1();
		tab.getAttributes().setId("tt3");
		
		CssStyle cs1 = new CssStyle();
		cs1.set("border", "1px solid red");
		
		CssStyle cs2 = new CssStyle();
		cs2.setSelector("#" + tab.getAttributes().getId() + " th");
		cs2.set("font-family", FontFamily.MONOSPACE);
		
		BackgroundStyle cs3 = new BackgroundStyle("#" + tab.getAttributes().getId());
		cs3.setBackgroundColor(Color.White);
		
		CssStyle cs4 = new CssStyle();
		cs4.set("background-color", Color.Yellow);
		
		tab.getStyles().setStyle(cs1);
		tab.getStyles().setStyle(cs2);
		tab.getStyles().setStyle(cs3);
		HtmlElement e1 = tab.getTableElement(0, 2);
		e1.getStyles().setStyle(cs4);
		HtmlElement e2 = tab.getTableElement(2, 4);
		e2.getAttributes().setId("el_2_4");
		BackgroundStyle cs5 = new BackgroundStyle(e2);
		cs5.setBackgroundColor(Color.LightGreen);
		e2.getStyles().setStyle(cs5);
		div4.addElement(tab);
		
		return div4;
		
	}
	
	private HtmlElement getLongTextInBox() {
		
		Div div2 = new Div();
		div2.getAttributes().add(Attributes.STYLE, "width: 300px; border: 1px solid Black;");
		BoxStyle bs1 = new BoxStyle();
		bs1.setPadding("px", 20);
		bs1.setMargin("px", 10);
		bs1.setBackgroundColor(Color.Beige);
		div2.getStyles().setStyle(bs1);
		Paragraph p22 = new Paragraph("This is some long text. This is some long text. This is some long text. This is some long text. This is some long text. This is some long text. ");
		p22.getAttributes().setId("p22");
		p22.getStyles().setStyle(new TextStyle());
		div2.addElement(p22);
		
		return div2;
		
	}
	
	
	/**
	 * styling of multiple nested elements
	 * @return
	 */
	private HtmlElement getNestedElements() {
		
		Div div5 = new Div();
		div5.getAttributes().setId("nested");
		Div div5a = new Div();
		div5.addElement(div5a);
		Div div5b = new Div();
		div5a.addElement(div5b);
		Div div5c = new Div(new StringElement("adagdfsg"));
		div5c.getStyles().setStyle(new BoxStyle());
		div5b.addElement(div5c);
		
		return div5;
		
	}
	
	/**
	 * styling links
	 * @return
	 */
	private HtmlElement getLinks() {
		
		Div div = new Div();
		div.getAttributes().setId("linki");
		
		// apply style for all links (according to class x)
		LinkStyle defLinkStyle = new LinkStyle();
		Anchor a1 = new Anchor("http://www.google.com", "Google");
		a1.getStyles().setStyle(defLinkStyle); 
		div.addElement(a1);
		Anchor a2 = new Anchor("http://www.nowhere.com", "Never visited link");
		a2.getStyles().setStyle(defLinkStyle);
		div.addElement(a2);
		
		div.addElement(new Br());
		
		// apply style for all links (according to class y)
		LinkStyle s1s = new LinkStyle();
		s1s.setLinkColor(Color.DarkCyan);
		s1s.setVisitedColor(Color.Brown);
		s1s.setHoverColor(Color.HotPink);
		Anchor b1 = new Anchor("http://www.google.com", "Google");
		b1.getStyles().setStyle(s1s); 
		div.addElement(b1);
		Anchor b2 = new Anchor("http://www.najdi.si", "Najdi.si");
		b2.getStyles().setStyle(s1s);
		div.addElement(b2);
		Anchor b3 = new Anchor("http://www.nowhere.com", "Never visited link");
		b3.getStyles().setStyle(s1s);
		div.addElement(b3);
		
		div.addElement(new Br());
		
		// apply style for this particular link (according to ID)
		Anchor c1 = new Anchor("http://www.najdi.si", "Najdi.si");
		LinkStyle s2 = new LinkStyle(c1);
		s2.setLinkColor(Color.BlueViolet);
		s2.setVisitedColor(Color.LightBlue);
		s2.setHoverColor(Color.Blue);
		c1.getStyles().setStyle(s2);
		div.addElement(c1);
		
		div.addElement(new Br());
		
		Anchor d1 = new Anchor("http://www.w3schools.com", "W3Schools");
		d1.getAttributes().setId("link3");
		CssStyle s3 = new CssStyle();
		s3.setSelector("#" + d1.getAttributes().getId());
		s3.set("font-family", FontFamily.FANTASY);
		d1.getStyles().setStyle(s3);
		div.addElement(d1);
		
		
		return div;
		
	}
	
	
}
