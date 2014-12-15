// This entire file is part of my masterpiece.
// Eli Lichtenberg

package data;

import java.util.Locale;
import java.util.ResourceBundle;

public class DataManagerFactory {
	
	public static final String DATA_RESOURCE_PACKAGE = "data/";
	public static final String DATA_RESOURCE_NAME = "dataConfigurations";
	
	private ResourceBundle myDataConfigs;
	
	public DataManagerFactory() {
		Locale loc = new Locale("en", "US");
		myDataConfigs = ResourceBundle.getBundle(DATA_RESOURCE_PACKAGE + DATA_RESOURCE_NAME);
	}
	
	public DataManager create() {
		String dataType = myDataConfigs.getString("Type");
		//String dataType = "JSON";
		return constructDataManager(dataType);
	}

	private DataManager constructDataManager(String dataType) {
		if(dataType.equals("JSON")) {
			return new JSONDataManager();
		}
//		Examples of other DataManager classes that could be created.
//		else if(dataType.equals("XML")) {
//			return new XMLDataManager();
//		}
//		else if(dataType.equals("CSV")) {
//			return new CSVDataManager();
//		}
		return null;
	}
	
}