package si.matjazcerkvenik.helium.servlets;

import si.matjazcerkvenik.helium.HtmlDocument;
import si.matjazcerkvenik.helium.html.Body;
import si.matjazcerkvenik.helium.html.Head;
import si.matjazcerkvenik.helium.html.Heading;
import si.matjazcerkvenik.helium.html.Paragraph;
import si.matjazcerkvenik.helium.server.HttpErrorCodes;
import si.matjazcerkvenik.helium.server.IServlet;
import si.matjazcerkvenik.helium.server.Request;
import si.matjazcerkvenik.helium.server.Response;

public class ErrorServlet implements IServlet {
	
	private int errorCode = 404;

	private String addInfo = null;

	@Override
	public String getName() {
		return "Error";
	}

	@Override
	public void doGet(Request req, Response resp) {

		// head
		Head head = new Head("error");

		// body
		Body body = new Body();

		Heading h2 = new Heading(2, errorCode + " " + HttpErrorCodes.getError(errorCode));
		Paragraph p = new Paragraph(addInfo);

		body.addElement(h2).addElement(p);

		HtmlDocument doc = new HtmlDocument(head, body);

		resp.setData(doc);

	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getAddInfo() {
		return addInfo;
	}

	public void setAddInfo(String addInfo) {
		this.addInfo = addInfo;
	}
	
	

}
