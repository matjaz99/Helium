package si.matjazcerkvenik.htmllib.boxes;

public class BoxTest {
	
	public static void main(String[] args) {
		
		Box b0 = new Box();
		b0.setMargin(10, 20);
		
		Box b11 = new Box();
		b11.setMargin(10, 20);
		Box b12 = new Box();
		b12.setMargin(10, 20);
		
		HorizontalBoxLayout hbl = new HorizontalBoxLayout();
		hbl.addBox(b11);
		hbl.addBox(b12);
		
		b0.addBox(hbl);
		
	}
	
}
