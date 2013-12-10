package si.matjazcerkvenik.helium;


public class ServerStop extends Thread {
	
	@Override
	public void run() {
		
		ServerStart.stopServer();
		
	}
	
}
