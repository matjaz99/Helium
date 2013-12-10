package si.matjazcerkvenik.helium.tools;

public class Util {
	
	/** a counter of elements; used for automatic assigning of IDs */
	private static int elementCounter = 0;
	
	public static int getCount() {
		return elementCounter++;
	}
	
}
