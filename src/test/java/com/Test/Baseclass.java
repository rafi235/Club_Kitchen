package com.Test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

public class Baseclass {
	
public static WebDriver driver;
	
	public static void getbrowser(String Browser)
	{
	if(Browser.equals("Chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Rafi_Demo\\ClubKitchen\\Browsers\\chromedriver.exe");
	    driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://clubkitchen.at");
	}
	else if(Browser.equals("Firefox")) {
		System.setProperty("webdriver.gecko.driver", "D:\\Rafi_Demo\\ClubKitchen\\Browsers\\geckodriver.exe");
	    driver =new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://clubkitchen.at");	
	}
	else if(Browser.equals("Ie"))
	{
		System.setProperty("webdriver.ie.driver", "D:\\Rafi_Demo\\ClubKitchen\\Browsers\\geckodriver.exe");
	    driver =new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://clubkitchen.at");	
	}
	else
	{
		System.out.println("Browser is not defined correctly");
	}
	}	

	public static void placeanorder() throws InterruptedException {

		driver.findElement(By.xpath("//a[contains(@class,'btn club-home-button shop-menu-btn')]")).click();
		driver.findElement(By.xpath("//input[contains(@id,'address-input')]")).sendKeys("Semperstraﬂe 44, 1180 Wien, Austria");
		driver.findElement(By.xpath("//input[contains(@class,'btn--honest blattgold--form-banner-submit')]")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(@class,'agree-cookie')]")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'image-link-container')])[1]")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//div[contains(text(),'Tomaten-Avocado Salsa (Dip)')]")).click();
		driver.findElement(By.xpath("//button[@id='topup-modal--close']")).click();
		System.out.println("Guest Successfully Added Item into cart");
		
	}
public static void getscreenshot() throws IOException {
		String path="D:\\Rafi_Demo\\ClubKitchen\\Screenshots\\CK_"+Getstemfdate()+".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(source, new File(path));
}
	public static String Getstemfdate()
{
		DateFormat systemdatetime = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		return systemdatetime.format(date);
		}
	public static void windowclose() {
		driver.close();
		driver.quit();
	}
}
