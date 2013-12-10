package si.matjazcerkvenik.helium.tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import si.matjazcerkvenik.helium.HtmlElement;
import si.matjazcerkvenik.helium.html.StringElement;
import si.matjazcerkvenik.helium.html.Table;

/**
 * Table builder from SQL result sets.
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class SqlTableBuilder {
	
	/**
	 * Get html table
	 * @param resultSet
	 * @return table
	 * @throws SQLException
	 */
	public Table getTable(ResultSet resultSet) throws SQLException {
		
		DynamicTableBuilder tb = new DynamicTableBuilder();
		
		System.out.println("catalog/table = " + resultSet.getMetaData().getCatalogName(1) + "/" + resultSet.getMetaData().getTableName(1));

		
		for (int i = 1; i < resultSet.getMetaData().getColumnCount() + 1; i++) {
			
			String colLabel = resultSet.getMetaData().getColumnLabel(i);
			
			List<HtmlElement> list = new ArrayList<HtmlElement>();
			
			while (resultSet.next()) {
				
				list.add(new StringElement(resultSet.getString(i)));
				
			}
			
			
			tb.addColumn(colLabel, list);
			resultSet.beforeFirst();
						
			
		}
		
		return tb.getHtmlTable();
		
	}
	
}
