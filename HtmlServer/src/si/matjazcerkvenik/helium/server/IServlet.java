package si.matjazcerkvenik.helium.server;

public interface IServlet {
	
	public String getName();
	
	public void doGet(Request req, Response resp);
	
}
