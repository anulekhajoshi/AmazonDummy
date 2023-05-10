package com.MyStore.actiondriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.MyStore.base.Base;
import org.openqa.selenium.JavascriptExecutor;
public class Action extends Base{
	
	public void click(WebDriver driver, WebElement ele) {
		Actions act=new Actions(driver);
		act.moveToElement(ele).click().build().perform();	}
	
	public boolean elementvisible(WebDriver driver, WebElement ele) {
		boolean flag=false;
		try {
			flag=ele.isDisplayed();
			flag=true;
		}
		catch(Exception e) {
			flag=false;
		}
		return flag;
	}
	public void javascriptClick(WebDriver driver, WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
		
	}
    
    public void fluentWait(WebDriver driver, WebElement ele, int timeout) {
    	Wait<WebDriver> wt=null;
    	try {
    	     wt= new FluentWait<WebDriver>((WebDriver)driver)
    	    		 .withTimeout(Duration.ofSeconds(timeout))
    	    		 .pollingEvery(Duration.ofSeconds(2))
    	    		 .ignoring(Exception.class);
    	    		 wt.until(ExpectedConditions.visibilityOf(ele));
    	    		 ele.click();}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
	
    public void explicitWait(WebDriver driver, WebElement ele, int timeout) {
    	WebDriverWait wt=new WebDriverWait(driver,timeout);
    	System.out.println(ele);
    	wt.until(ExpectedConditions.visibilityOf(ele));
    	   	
    }
    
    public void handlemultipleWindows() {
    	String parent = driver.getWindowHandle();
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		for(String tab:windows) {
			if(!tab.equals(parent)) {
				driver.switchTo().window(tab);
			}
		}
    }
    public void textbox(WebDriver driver, WebElement ele, String text) {
    	boolean boxvisible=elementvisible(driver,ele);
    	if(boxvisible==true) {
    		ele.sendKeys(text);
    	}    	
    }
    
    public void typetext( WebElement ele, String text) {
    	ele.clear();
    	ele.sendKeys(text);
    }
    
    public void switchToNewTab()
    {
    	Set<String> handles=driver.getWindowHandles();
    	String currentHandle=driver.getWindowHandle();
    	
    	for(String run:handles)
    	{
    	 if(!run.equals(currentHandle)){ driver.switchTo().window(run);}
    	}
    }
    	
   }

