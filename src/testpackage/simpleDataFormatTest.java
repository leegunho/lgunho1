package testpackage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class simpleDataFormatTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sf.format(new Date());
		
		System.out.println("현재시간:"+sf.format(new Date()));

	}

}
