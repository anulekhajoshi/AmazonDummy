package com.MyStore.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.MyStore.actiondriver.Action;
import com.MyStore.pageobject.Checkout;
import com.MyStore.pageobject.Home;
import com.MyStore.pageobject.SearchItemDetail;
import com.MyStore.pageobject.SearchResultPage;
import com.MyStore.pageobject.Signon;
import com.MyStore.utility.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Base {

	public static Properties prop;
	public static WebDriver driver;
	
	
	@BeforeSuite
	public void loadConfig() {
		try{
			  DOMConfigurator.configure("log4j.xml");
			  Log.info("This is beforeSuite Method");
			
			prop=new Properties();		
		FileInputStream ip = new FileInputStream("C:\\Users\\anule\\eclipse-workspace\\MyStore\\Configuration\\Config.properties");
		prop.load(ip);
		System.out.println("config file loaded");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch( IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void launchApp(String browserName)
	{
		
		if(browserName.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("driver object created");
			}
		else if(browserName.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			}
	    driver.get(prop.getProperty("site"));
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	}
	
		
	public static void getScreenshotmethod(String filename) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\Screenshot\\"+filename+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void getfullScreenshotmethod(String filename) {
		Screenshot ss=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
				try {
			ImageIO.write(ss.getImage(),"png",new File(System.getProperty("user.dir")+"\\Screenshot\\"+filename+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
