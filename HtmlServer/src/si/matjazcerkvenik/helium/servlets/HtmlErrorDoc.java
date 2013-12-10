package si.matjazcerkvenik.helium.servlets;

import si.matjazcerkvenik.helium.HtmlDocument;
import si.matjazcerkvenik.helium.html.Body;
import si.matjazcerkvenik.helium.html.Head;
import si.matjazcerkvenik.helium.html.Heading;
import si.matjazcerkvenik.helium.html.Paragraph;
import si.matjazcerkvenik.helium.server.HttpErrorCodes;

public class HtmlErrorDoc {

	public static HtmlDocument getErrorHtmlDoc(int errorCode, String addInfo) {

		// head
		Head head = new Head("error");

		// body
		Body body = new Body();

		Heading h2 = new Heading(2, errorCode + " - "
				+ HttpErrorCodes.getError(errorCode));
		
		if (addInfo == null) {
			addInfo = "";
		}
		Paragraph p = new Paragraph(addInfo);

		body.addElement(h2).addElement(p);

		HtmlDocument doc = new HtmlDocument(head, body);
		
		return doc;
		
	}

}
