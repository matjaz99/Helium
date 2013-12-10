package si.matjazcerkvenik.helium.server;

import si.matjazcerkvenik.helium.HtmlDocument;

public class Response {
		
	private int errorCode = 200;
	
	private String contentType = "text/html";
	
	private byte[] data = null;


	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	
	public void setData(HtmlDocument htmlDocument) {
		this.data = htmlDocument.toString().getBytes();
	}
	

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void sendRedirect(String newUrl) {
		
	}
	
	
}
