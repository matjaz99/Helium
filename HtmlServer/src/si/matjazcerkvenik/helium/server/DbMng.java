package si.matjazcerkvenik.helium.server;

public class DbMng {
	
	private static DbMng dbMng = null;
	
	private DbMng() {
		// is singleton
	}
	
	public static DbMng getInstance() {
		if (dbMng == null) {
			dbMng = new DbMng();
		}
		return dbMng;
	}
	
	public void getConnection() {
		// get connection from the pool
	}
	
	
	public void insert() {
		
	}
	
	public void select() {
		
	}
	
	public void execute(String sql) {
		
	}
	
}
