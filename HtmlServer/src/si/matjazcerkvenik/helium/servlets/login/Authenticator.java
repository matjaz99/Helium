package si.matjazcerkvenik.helium.servlets.login;

import si.matjazcerkvenik.helium.server.DbMng;
import si.matjazcerkvenik.helium.server.IAuthenticate;
import si.matjazcerkvenik.helium.server.User;

public class Authenticator implements IAuthenticate {

	public User authenticate(String name, String password) {

		User u = null;

		// get db connection
		DbMng.getInstance().getConnection();
		DbMng.getInstance().execute(
				"select * from users where username=\"" + name + "\""
						+ " and password=\"" + password + "\"");

		if (name.equals(password)) {

			u = new User();
			u.setUsername(name);
			u.setPassword("*****");
			u.setGroup("group1");
			u.setRole("role1");

		}

		return u;

	}
	
	public void createNewUser(User user) {
		
		
		
	}

}
