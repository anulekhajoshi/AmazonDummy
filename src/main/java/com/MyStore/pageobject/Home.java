package com.MyStore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.MyStore.actiondriver.Action;
import com.MyStore.base.Base;

public class Home extends Base{

	Action action=new Action();
	@FindBy(xpath="//a[@aria-label='Amazon.in']")
	private WebElement logo;
	
	@FindBy(xpath="//span[contains(.,'Hello, sign in')]")
	private WebElement signin;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchbox;
	
	@FindBy(id="nav-search-submit-button")
	private WebElement searchbutton;
			
	public Home() {
		PageFactory.initElements(driver,this);
		System.out.println("Home variable initialized");
			}
	public String verifyTitle() {		
	    String gettitle=driver.getTitle();
	    System.out.println("window title is: "+gettitle);
	    return gettitle;
	}
	public void login() {
		
		action.explicitWait(driver, signin, 30);
		action.click(driver, signin);		
	}
	public void searchbox(String txt) {
		action.explicitWait(driver, searchbox, 30);
		System.out.println("searchbox xpath is: "+searchbox);
		action.textbox(driver, searchbox, txt);
	}
	public void searchResultfunction() {
		action.click(driver, searchbutton);
		
	}
}
