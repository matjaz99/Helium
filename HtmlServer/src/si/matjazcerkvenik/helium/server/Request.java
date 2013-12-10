package si.matjazcerkvenik.helium.server;

import java.util.Date;
import java.util.HashMap;

public class Request {
	
	private Date date = null;
	private String method = null;
	private String fileRequested = null;
	private HashMap<String, String> params = new HashMap<String, String>();
	private String host = null;
	private String userAgent = null;
	private String accept = null;
	private String acceptLanguage = null;
	private String acceptEncoding = null;
	private String cookie = null;
	private String connection = null;
	private String referer = null;
	
	
	
	private void parseParams() {
		
		if (fileRequested != null) {
			String[] tempTab = fileRequested.split("\\?");
			fileRequested = tempTab[0];
			if (tempTab.length > 1) {
				String[] tempTab2 = tempTab[1].split("&");
				for (int i = 0; i < tempTab2.length; i++) {
					String[] tempTab3 = tempTab2[i].split("=");
					if (tempTab3.length == 1) {
						params.put(tempTab3[0], "");
					} else {
						params.put(tempTab3[0], tempTab3[1]);
					}
					
				}
			}
		}
//		for (String s : params.keySet()) {
//			logger.info("Param: key=" + s + " value=" + params.get(s));
//		}
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getFileRequested() {
		return fileRequested;
	}

	public void setFileRequested(String fileRequested) {
		this.fileRequested = fileRequested;
		parseParams();
	}

	public HashMap<String, String> getParams() {
		return params;
	}

	public void setParams(HashMap<String, String> params) {
		this.params = params;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getAcceptLanguage() {
		return acceptLanguage;
	}

	public void setAcceptLanguage(String acceptLanguage) {
		this.acceptLanguage = acceptLanguage;
	}

	public String getAcceptEncoding() {
		return acceptEncoding;
	}

	public void setAcceptEncoding(String acceptEncoding) {
		this.acceptEncoding = acceptEncoding;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Request [User-Agent=" + userAgent);
		sb.append(" Accept-Language=" + acceptLanguage);
		sb.append(" Accept=" + accept);
		sb.append(" Connection=" + connection + "]");
		return sb.toString();
	}
	
}
