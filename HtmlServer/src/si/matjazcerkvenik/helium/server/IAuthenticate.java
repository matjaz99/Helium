package si.matjazcerkvenik.helium.server;

public interface IAuthenticate {
	
	public User authenticate(String name, String password);
	
	public void createNewUser(User user);
	
}
