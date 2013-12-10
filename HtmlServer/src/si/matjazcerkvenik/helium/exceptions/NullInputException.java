package si.matjazcerkvenik.helium.exceptions;

public class NullInputException extends Exception {

	private static final long serialVersionUID = 8658079068174880501L;
	private static String MSG = "input stream is null";

	  public NullInputException() {
	    super(MSG);
	  }

	  public NullInputException(String message, Throwable cause) {
	    super(MSG + message, cause);
	  }

	  public NullInputException(String message) {
	    super(MSG + message);
	  }

	  public NullInputException(Throwable cause) {
	    super(MSG, cause);
	  }
	
}
