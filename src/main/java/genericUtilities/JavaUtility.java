package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	// this method will return random number for every execution
	// @ return
	
	public int  getRandomNumber()
	
	{
		Random r = new Random();
		return r.nextInt(1000);
	}
	// this method will generate the current system date in Specified format
	
	public String getSystemDate() {
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		String date = formatter.format(d);
		return date;

}

}
