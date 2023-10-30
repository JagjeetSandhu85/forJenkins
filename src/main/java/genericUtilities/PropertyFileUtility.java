package genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {
	public String readDataFromPropertyFile(String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\7pmCommonData.txt");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		}

}
