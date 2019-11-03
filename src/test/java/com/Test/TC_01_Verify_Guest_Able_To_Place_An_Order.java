package com.Test;

import java.io.IOException;
import org.testng.annotations.Test;

public class TC_01_Verify_Guest_Able_To_Place_An_Order extends Baseclass {
	@Test
	public static void addorderintocart() throws InterruptedException, IOException {
		try {
			Baseclass.getbrowser("Chrome");
			Baseclass.placeanorder();
//			Baseclass.getscreenshot("Order Is Added Into Card");
			Baseclass.getscreenshot();
			Baseclass.windowclose();
		} catch (Exception e) {
			System.out.println("Execution is not compleated :"+e.getMessage());
		}
		
	}



}
