package si.matjazcerkvenik.helium.servlets.dummy;

import si.matjazcerkvenik.helium.HtmlDocument;
import si.matjazcerkvenik.helium.HtmlElement;
import si.matjazcerkvenik.helium.HtmlDocument.DOCTYPE;
import si.matjazcerkvenik.helium.css.BackgroundStyle;
import si.matjazcerkvenik.helium.css.BoxStyle;
import si.matjazcerkvenik.helium.css.Color;
import si.matjazcerkvenik.helium.css.Css;
import si.matjazcerkvenik.helium.css.CssStyle;
import si.matjazcerkvenik.helium.css.FontFamily;
import si.matjazcerkvenik.helium.css.ImgStyle;
import si.matjazcerkvenik.helium.css.LinkStyle;
import si.matjazcerkvenik.helium.css.TextStyle;
import si.matjazcerkvenik.helium.html.Anchor;
import si.matjazcerkvenik.helium.html.Body;
import si.matjazcerkvenik.helium.html.Div;
import si.matjazcerkvenik.helium.html.Head;
import si.matjazcerkvenik.helium.html.Heading;
import si.matjazcerkvenik.helium.html.Img;
import si.matjazcerkvenik.helium.html.Li;
import si.matjazcerkvenik.helium.html.Paragraph;
import si.matjazcerkvenik.helium.html.StringElement;
import si.matjazcerkvenik.helium.html.Ul;

public class HelloDiv5 {
	
public HtmlDocument getHtmlDoc() {
		
		HtmlDocument doc = new HtmlDocument();
		doc.setDoctype(DOCTYPE.DOCTYPE_HTML5);
		
		Head head = new Head("DIV5 example");
		Body body = new Body();
		
		// body styles
		BoxStyle bodyStyle = new BoxStyle("body");
		bodyStyle.set(Css.BACKGROUND_COLOR, "#DDDDDD");
		bodyStyle.set(Css.MARGIN, "0px auto");
		bodyStyle.set("max-width", "1000px");
//		bodyStyle.set(Css.BORDER, "3px solid #DDDDDD");
//		bodyStyle.set("border-color", "#DDDDDD");
		doc.setStyle(bodyStyle);
		
		TextStyle txtStyle = new TextStyle("body");
		txtStyle.setFontFamily(FontFamily.CENTURY_GOTHIC, FontFamily.TAHOMA, FontFamily.ARIAL, FontFamily.VERDANA, FontFamily.SANS_SERIF);
		doc.setStyle(txtStyle);
		
		CssStyle h1Sty = new CssStyle("h1");
		h1Sty.set(Css.FONT_SIZE, "50px");
		h1Sty.set(Css.MARGIN, "0px");
		CssStyle h2Sty = new CssStyle("h2");
		h2Sty.set(Css.COLOR, Color.White);
		h2Sty.set(Css.FONT_SIZE, "20px");
		h2Sty.set(Css.MARGIN, "0px");
		CssStyle h3Sty = new CssStyle("h3");
		h3Sty.set(Css.FONT_SIZE, "15px");
		h3Sty.set(Css.TEXT_ALIGN, "center");
		h3Sty.set(Css.COLOR, Color.Navy);
		h3Sty.set(Css.MARGIN, "0px");
		ImgStyle iStyle = new ImgStyle("img");
		iStyle.setWidth(100);
		iStyle.setHeight(100);
		doc.setStyle(h1Sty, h2Sty, h3Sty, iStyle);
		
		
		// header
		body.addElement(getHeader());
		
		
		// main container
		Div mainContainer = new Div();
		mainContainer.getAttributes().setId("mainContainer");
		
		BackgroundStyle mainStyle = new BackgroundStyle(mainContainer);
		mainStyle.setBackgroundColor("#AAAAFF");
		mainContainer.getStyles().setStyle(mainStyle);
		
		mainContainer.addElement(getNavArea());
		
		Div section = new Div();
		
		section.addElement(getArticle1());
		section.addElement(getArticle2());
		
		CssStyle sectStyle = new CssStyle();
		sectStyle.set(Css.DISPLAY, "block");
		sectStyle.set(Css.WIDTH, "50%");
		sectStyle.set(Css.FLOAT, "left");
		section.getStyles().setStyle(sectStyle);
		
		
		mainContainer.addElement(section);
		
		
		Div aside = new Div();
		aside.addElement(new Heading(3, "By the way..."));
		aside.addElement(new Paragraph("You can always use traditional HTML tags such as p, h1, h2, div, etc..."));
		
		CssStyle asStyle = new CssStyle();
		asStyle.set(Css.DISPLAY, "block");
		asStyle.set(Css.WIDTH, "25%");
		asStyle.set(Css.FLOAT, "left");
		BoxStyle asBox = new BoxStyle();
		asBox.setMargin("px", 15);
		asBox.set(Css.COLOR, Color.Yellow);
		TextStyle asTxt = new TextStyle();
		asTxt.setTextColor(Color.White);
		asTxt.setFontSize(15, "px");
		asTxt.set("font-style", "italic");
		asTxt.set(Css.MARGIN, "15px");
		
		aside.getStyles().setStyle(asStyle);
		aside.getElements().get(0).getStyles().setStyle(asBox);
		aside.getElements().get(1).getStyles().setStyle(asTxt);
		
		
		mainContainer.addElement(aside);
		
		Div footer41 = new Div(new StringElement("Thanks for visiting"));
		footer41.getStyles().setStyle(getFooterStyle());
		mainContainer.addElement(footer41);
		
		body.addElement(mainContainer);
		
		doc.setHead(head);
		doc.setBody(body);
		
		return doc;
		
	}
	
	private HtmlElement getHeader() {
		
		Heading h01 = new Heading(1, "Hello DIV5");
		Heading h02 = new Heading(2, "Enjoy the ride");
		Heading h04 = new Heading(4, "Fancy!");
		Div header01 = new Div(h01, h02, h04);
		
//		BoxStyle hBox = new BoxStyle();
//		hBox.setBackgroundColor(Color.LightBlue);
//		hBox.set("display", "block");
//		hBox.set(Css.COLOR, Color.Yellow);
//		hBox.set("text-align", "center");
//		hBox.setMargin("px", 0);
//		hBox.setPadding("px", 10);
		
		BoxStyle h2Box = new BoxStyle();
		h2Box.setMargin("px", 0);
		
		h02.getStyles().setStyle(h2Box);
		header01.getStyles().setStyle(getHeaderStyle());
		
		return header01;
		
	}
	
	private Div getArticle1() {
		
		Div article21 = new Div();
		Div h22 = new Div(new Heading(1, "Welcome"));
		Paragraph p23 = new Paragraph("This is example how to use semantic tags");
		Paragraph p24 = new Paragraph("This page looks better if you link it to the stylesheet");
		Div figure25 = new Div();
		Img img26 = new Img("img/Giraffe-512.png");
		Img img27 = new Img("img/Elephant-512.png");
		Div figcaption = new Div(new StringElement("HTML5 is cool"));
		Div footer29 = new Div(new StringElement("Welcome footer"));
		figure25.addElement(img26);
		figure25.addElement(img27);
		figure25.addElement(figcaption);
		
		article21.addElement(h22);
		article21.addElement(p23, p24);
		article21.addElement(figure25);
		article21.addElement(footer29);
		
		article21.getStyles().setStyle(getArticleStyle());
		h22.getStyles().setStyle(getHeaderStyle());
		h22.getStyles().setStyle(getArticleHeaderAndFooterStyle());
		h22.getElements().get(0).getStyles().setStyle(getArticleH1Style());
		figcaption.getStyles().setStyle(getFigcaptionStyle());
		footer29.getStyles().setStyle(getFooterStyle());
		footer29.getStyles().setStyle(getArticleHeaderAndFooterStyle());
		
		return article21;
		
	}
	
	private Div getArticle2() {
		
		Div article31 = new Div();
		Div h32 = new Div(new Heading(1, "Features in HTML5"));
		Ul ul = new Ul();
		ul.addElement(new Li("Canvas and SVG graphics"));
		ul.addElement(new Li("Geolocation"));
		ul.addElement(new Li("Microdata"));
		ul.addElement(new Li("Web sockets"));
		ul.addElement(new Li("Web SQL"));
		Div footer33 = new Div(new StringElement("Features footer"));
		
		article31.addElement(h32);
		article31.addElement(ul);
		article31.addElement(footer33);
		
		article31.getStyles().setStyle(getArticleStyle());
		h32.getStyles().setStyle(getHeaderStyle());
		h32.getStyles().setStyle(getArticleHeaderAndFooterStyle());
		h32.getElements().get(0).getStyles().setStyle(getArticleH1Style());
		footer33.getStyles().setStyle(getFooterStyle());
		footer33.getStyles().setStyle(getArticleHeaderAndFooterStyle());
		
		return article31;
		
	}
	
	private Div getNavArea() {
		
		Heading h11 = new Heading(3, "Links");
		Anchor a11 = new Anchor("http://www.google.com", "Google");
		Anchor a12 = new Anchor("http://www.najdi.si", "Najdi.si");
		Anchor a13 = new Anchor("http://www.matjazcerkvenik.si", "Matjaz");
		Div nav = new Div(h11, a11, a12, a13);
		
		CssStyle s = new CssStyle(nav);
		s.set(Css.DISPLAY, "block");
		s.set(Css.WIDTH, "25%");
		s.set(Css.FLOAT, "left");
		nav.getStyles().setStyle(s);
		
		LinkStyle as = new LinkStyle();
		as.setLinkColor(Color.Navy);
		as.setHoverColor(Color.Orange);
		as.set(Css.DISPLAY, "block");
		as.set("border-bottom", "1px solid Yellow");
		as.set(Css.PADDING, "10px");
		as.setTextDecoration("none");
		as.set("font-weight", "bold");
		as.set(Css.MARGIN, "2px");
		
		a11.getStyles().setStyle(as);
		a12.getStyles().setStyle(as);
		a13.getStyles().setStyle(as);
		
		return nav;
		
	}
	
	private CssStyle getHeaderStyle() {
		
		BoxStyle hBox = new BoxStyle();
		hBox.setBackgroundColor(Color.LightBlue);
		hBox.set("display", "block");
		hBox.set(Css.COLOR, Color.Yellow);
		hBox.set("text-align", "center");
		hBox.setMargin("px", 0);
		hBox.setPadding("px", 10);
		
		return hBox;
		
	}
	
	private CssStyle getFooterStyle() {
		
		CssStyle s = new CssStyle();
		s.set("clear", "both");
		s.set("display", "block");
		s.set(Css.BACKGROUND_COLOR, Color.LightBlue);
		s.set(Css.COLOR, Color.Yellow);
		s.set(Css.TEXT_ALIGN, "center");
		s.set(Css.PADDING, "15px");
		
		return s;
		
	}
	
	private CssStyle getArticleStyle() {
		
		BoxStyle s = new BoxStyle();
		s.setBackgroundColor("#eee");
		s.set(Css.DISPLAY, "block");
		s.setMargin("px", 10);
		s.setPadding("px", 10);
		
		return s;
		
	}
	
	private CssStyle getArticleHeaderAndFooterStyle() {
		
		BoxStyle s = new BoxStyle();
		s.setPadding("px", 5);
		
		return s;
		
	}
	
	private CssStyle getArticleH1Style() {
		
		TextStyle s = new TextStyle();
		s.setFontSize(18, "px");
		
		return s;
		
	}
	
	private CssStyle getFigcaptionStyle() {
		
		TextStyle s = new TextStyle();
		s.setFontSize(10, "px");
		s.setTextColor(Color.Blue);
		s.setAlignment("center");
		
		return s;
		
	}
	
}
