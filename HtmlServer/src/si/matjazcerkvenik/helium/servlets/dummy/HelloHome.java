package si.matjazcerkvenik.helium.servlets.dummy;

import si.matjazcerkvenik.helium.HtmlDocument;
import si.matjazcerkvenik.helium.HtmlElement;
import si.matjazcerkvenik.helium.HtmlDocument.DOCTYPE;
import si.matjazcerkvenik.helium.css.BackgroundStyle;
import si.matjazcerkvenik.helium.css.BoxStyle;
import si.matjazcerkvenik.helium.css.Color;
import si.matjazcerkvenik.helium.css.CssStyle;
import si.matjazcerkvenik.helium.css.FontFamily;
import si.matjazcerkvenik.helium.css.TextStyle;
import si.matjazcerkvenik.helium.html.Body;
import si.matjazcerkvenik.helium.html.Div;
import si.matjazcerkvenik.helium.html.Head;
import si.matjazcerkvenik.helium.html.StringElement;

public class HelloHome {
	
	private HtmlDocument doc;
	private Head head = new Head("Home example");
	private Body body = new Body();
	
	
	public HtmlDocument getHtmlDoc() {
		
		doc = new HtmlDocument(head, body);
		doc.setDoctype(DOCTYPE.DOCTYPE_HTML5);
		
		body.getStyles().setStyle(getBodyStyles());
		
//		body.addElement(getLeftBox());
//		body.addElement(getRightBox());
//		body.addElement(getClearDiv());
		body.addElement(getMainBox());
		
		return doc;
		
	}
	
	private CssStyle[] getBodyStyles() {
		
		CssStyle[] styles = new CssStyle[3];
		
		BackgroundStyle bs = new BackgroundStyle("body");
		bs.setBackgroundColor(Color.AntiqueWhite);
		styles[0] = bs;
		
		BoxStyle bx = new BoxStyle("body");
		bx.setMargin("px", 0);
		bx.setPadding("px", 0);
		styles[1] = bx;
		
		TextStyle txtStyle = new TextStyle("body");
		txtStyle.setFontFamily(FontFamily.TAHOMA, FontFamily.ARIAL, FontFamily.VERDANA, FontFamily.SANS_SERIF);
		styles[2] = txtStyle;
		
		return styles;
		
	}
	
	private HtmlElement getMainBox() {
		
		Div div = new Div();
		
		BoxStyle box = new BoxStyle(div);
		box.setWidth(100, "px");
		box.setBorder(1, Color.Gray);
		box.setPadding("px", 10);
		box.setFloatLeft();
		
		div.addElement(getLeftBox());
		div.addElement(getRightBox());
		
		div.getStyles().setStyle(box);
		
		return div;
		
	}
	
	private HtmlElement getLeftBox() {
		
		Div div = new Div();
		
		BoxStyle box = new BoxStyle(div);
		box.setWidth(100, "px");
		box.setBorder(1, Color.Gray);
		box.setPadding("px", 10);
//		box.setFloatLeft();
		div.getStyles().setStyle(box);
		
		BoxStyle box1 = new BoxStyle();
		box1.setAutoWidth();
		box1.setHeight(50, "px");
		box1.setBorder(1, Color.Blue);
		
		Div div1 = new Div();
		div1.addElement(new StringElement("HOME"));
		div1.getStyles().setStyle(box1);
		
		Div div2 = new Div();
		div2.addElement(new StringElement("PAGE1"));
		div2.getStyles().setStyle(box1);
		
		div.addElement(div1);
		div.addElement(div2);
		div.addElement(getClearDiv());
		
		return div;
		
	}
	
	private HtmlElement getRightBox() {
		
		Div div = new Div();
		
		BoxStyle box = new BoxStyle(div);
		box.setWidth(100, "%");
//		box.setFloatLeft();
		box.setBorder(1, Color.Gray);
		div.getStyles().setStyle(box);
		
		BoxStyle box1 = new BoxStyle();
		box1.setBorder(1, Color.Blue);
		box1.setAutoWidth();
		
		Div div1 = new Div();
		div1.addElement(new StringElement("adsfasdf"));
		div1.getStyles().setStyle(box1);
		
		Div div2 = new Div();
		div2.addElement(new StringElement("agsergsdgf"));
		div2.getStyles().setStyle(box1);
		
		div.addElement(div1);
		div.addElement(div2);
		div.addElement(getClearDiv());
		
		return div;
		
	}
	
	private Div getClearDiv() {
		CssStyle c = new CssStyle();
		c.set("clear", "both");
		Div d = new Div();
		d.getStyles().setStyle(c);
		return d;
		
	}
	
	
	
}
