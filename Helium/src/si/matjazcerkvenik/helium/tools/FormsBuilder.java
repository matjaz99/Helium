package si.matjazcerkvenik.helium.tools;

import si.matjazcerkvenik.helium.HtmlElement;
import si.matjazcerkvenik.helium.html.Div;
import si.matjazcerkvenik.helium.html.Form;
import si.matjazcerkvenik.helium.html.Input;
import si.matjazcerkvenik.helium.html.Input.TYPE;

public class FormsBuilder {
	
	// http://www.htmlgoodies.com/tutorials/forms/article.php/3888746/HTML-Forms-From-Basics-to-Style-Layouts.htm
	
	/**
	 * Return <code>&lt;form&gt;</code> element with two input fields: 
	 * username and password.
	 * @return form
	 */
	public static HtmlElement getBasicLoginForm() {
		
		Form form = new Form();
		
		Input usr = new Input("user", TYPE.TEXT);
		Input psw = new Input("pass", TYPE.PASSWORD);
		Input btn = new Input("loginBtn", TYPE.SUBMIT);
		
		form.addElement(usr);
		form.addElement(psw);
		form.addElement(btn);
		
		return form;
		
	}
	
	public static HtmlElement getSubmitForm() {
		
		Div div = new Div();
		
		return div;
		
	}
	
	public static HtmlElement getCheckBoxGroup() {
		
		Div div = new Div();
		
		return div;
		
	}
	
}
