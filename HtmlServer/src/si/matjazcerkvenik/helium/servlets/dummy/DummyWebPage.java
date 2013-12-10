package si.matjazcerkvenik.helium.servlets.dummy;

import si.matjazcerkvenik.helium.HtmlDocument;
import si.matjazcerkvenik.helium.HtmlElement;
import si.matjazcerkvenik.helium.css.BackgroundRepeat;
import si.matjazcerkvenik.helium.css.BackgroundStyle;
import si.matjazcerkvenik.helium.css.BoxStyle;
import si.matjazcerkvenik.helium.css.Color;
import si.matjazcerkvenik.helium.css.Css;
import si.matjazcerkvenik.helium.css.CssStyle;
import si.matjazcerkvenik.helium.css.FontFamily;
import si.matjazcerkvenik.helium.css.LinkStyle;
import si.matjazcerkvenik.helium.css.TextStyle;
import si.matjazcerkvenik.helium.html.Anchor;
import si.matjazcerkvenik.helium.html.Body;
import si.matjazcerkvenik.helium.html.Br;
import si.matjazcerkvenik.helium.html.Div;
import si.matjazcerkvenik.helium.html.Head;
import si.matjazcerkvenik.helium.html.Paragraph;
import si.matjazcerkvenik.helium.html.StringElement;
import si.matjazcerkvenik.helium.server.IServlet;
import si.matjazcerkvenik.helium.server.Request;
import si.matjazcerkvenik.helium.server.Response;

public class DummyWebPage implements IServlet {
	
	@Override
	public String getName() {
		return "/dummy";
	}
	
	@Override
	public void doGet(Request req, Response resp) {
		
		Head head = new Head("DummyWebPage");
		Body body = new Body();
		
		Div div0 = new Div();
		div0.getAttributes().setId("body");
		BoxStyle box0 = new BoxStyle(div0);
		box0.setWidth(800, "px");
		box0.set(Css.MARGIN, "0px auto");
		div0.getStyles().setStyle(box0);
		
		div0.addElement(getHeader());
		
		if (req.getParams() == null || req.getParams().isEmpty()) {
			
			Paragraph p = new Paragraph("Please select page:");
			Anchor a1 = new Anchor("http://localhost:8080/dummy?p=home", "Home");
			Anchor a2 = new Anchor("http://localhost:8080/dummy?p=page1", "Page1");
			
			div0.addElement(p).addElement(a1).addElement(new StringElement(" | ")).addElement(a2);
			
		} else if (req.getParams().containsKey("p")) {
			
			String page = req.getParams().get("p");
			
			if (page.equals("home")) {
				
				HelloHome h = new HelloHome();
				resp.setData(h.getHtmlDoc());
				return;
				
			} else if (page.equals("page1")) {
				
				Paragraph p = new Paragraph("Page1");
				div0.addElement(p);
				
			} else if (page.equals("html5")) {
				
				HelloHtml5 h = new HelloHtml5();
				resp.setData(h.getHtmlDoc());
				return;
				
			} else if (page.equals("div5")) {
				
				HelloDiv5 h = new HelloDiv5();
				resp.setData(h.getHtmlDoc());
				return;
				
			} else {
				
			}
			
			
		} else {
			
			
			
		}
		
		body.addElement(div0);
		
		
		HtmlDocument doc = new HtmlDocument(head, body);
		
		BackgroundStyle bkgStyle = new BackgroundStyle("body");
		bkgStyle.setBackgroundColor("#222222");
		doc.setStyle(bkgStyle);
		
		TextStyle txtStyle = new TextStyle("body");
		txtStyle.setFontFamily(FontFamily.VERDANA, FontFamily.SANS_SERIF);
		txtStyle.setTextColor(Color.White);
		doc.setStyle(txtStyle);
		
		CssStyle generalStyle = new CssStyle("*");
		generalStyle.set(Css.MARGIN, "0px");
		generalStyle.set(Css.PADDING, "0px");
		doc.setStyle(generalStyle);
		
		CssStyle hrStyle = new CssStyle("hr");
		hrStyle.set("color", "#CCC");
		hrStyle.set("background-color", "#CCC");
		hrStyle.set("height", "1px");
		hrStyle.set("border", "0px");
		doc.setStyle(hrStyle);
		
		LinkStyle links = new LinkStyle("a");
		links.setActiveColor(Color.Blue);
		links.setHoverColor(Color.DarkRed);
		links.setVisitedColor(Color.DarkKhaki);
		doc.setStyle(links);
		
		resp.setData(doc);
		
	}
	
	private HtmlElement getHeader() {
		
		Div div0 = new Div();
		div0.getAttributes().setId("header");
		
		BoxStyle bs0 = new BoxStyle(div0);
		bs0.setAutoWidth();
		bs0.setHeight(80, "px");
		bs0.setBorder(1, Color.WhiteSmoke);
		bs0.setBackgroundImage("img/hBack.png");
		bs0.setRepeatOption(BackgroundRepeat.repeat_x);
		bs0.setPadding("px", 10);

		div0.getStyles().setStyle(bs0);
		
		BoxStyle bs1 = new BoxStyle();
//		bs1.setWidth(100, "px");
		bs1.setBorder(1, Color.WhiteSmoke);
		bs1.setPadding("px", 5, 20);
		
		Anchor a1 = new Anchor("http://localhost:8080/dummy?p=home", "Home");
		a1.getStyles().setStyle(bs1);
		Anchor a2 = new Anchor("http://localhost:8080/dummy?p=page1", "Page1");
		a2.getStyles().setStyle(bs1);
		Anchor a3 = new Anchor("http://localhost:8080/dummy?p=html5", "HTML5");
		a3.getStyles().setStyle(bs1);
		Anchor a4 = new Anchor("http://localhost:8080/dummy?p=div5", "DIV5");
		a4.getStyles().setStyle(bs1);
		
		Div div1 = new Div();
		div1.addElement(a1, a2, a3, a4);
		
		div0.addElement(div1);
		
		return div0;
		
	}
	
}
