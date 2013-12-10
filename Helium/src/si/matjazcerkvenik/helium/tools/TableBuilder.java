package si.matjazcerkvenik.helium.tools;

import si.matjazcerkvenik.helium.HtmlElement;
import si.matjazcerkvenik.helium.html.StringElement;

/**
 * Fixed size TableBuilder.
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class TableBuilder {

	private HtmlElement[][] table = null;

	public TableBuilder() {
	}

	public TableBuilder(int x, int y) {
		table = new StringElement[x][y];
	}

	public void addTableElement(int x, int y, HtmlElement e) {

		table[x][y] = e;

	}

	public HtmlElement[][] getTable() {
		return table;
	}

	public void setTable(HtmlElement[][] table) {
		this.table = table;
	}

	@Override
	public String toString() {
		if (table.length == 0 && table[0].length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<table>");
		int rows = table.length;
		int cols = table[0].length;
		// for each row
		for (int row = 0; row < rows; row++) {
			sb.append("<tr>");
			// for each column in the row
			for (int col = 0; col < cols; col++) {
//				if (col > 0)
//					System.out.print(", ");
//				System.out.print(tb.getTable()[row][col]);
				sb.append("<td>");
				sb.append(table[row][col]);
				sb.append("</td>");
			}
			sb.append("</tr>");
		}
		sb.append("</table>\n");
		return sb.toString();
	}

	public static void main(String[] args) {

		TableBuilder tb = new TableBuilder(2, 3);
		tb.addTableElement(0, 0, new StringElement("A"));
		tb.addTableElement(0, 1, new StringElement("B"));
		tb.addTableElement(0, 2, new StringElement("C"));
		tb.addTableElement(1, 0, new StringElement("D"));
		tb.addTableElement(1, 1, new StringElement("E"));
		tb.addTableElement(1, 2, new StringElement("F"));

		int rows = tb.getTable().length;
		int cols = tb.getTable()[0].length;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (col > 0)
					System.out.print(", ");
				System.out.print(tb.getTable()[row][col]);
			}
			System.out.println();
		}

		System.out.println(tb.toString());

	}

}
