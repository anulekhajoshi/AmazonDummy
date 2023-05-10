package com.MyStore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.MyStore.actiondriver.Action;
import com.MyStore.base.Base;

public class Signon extends Base{
	Action action= new Action();
	
	@FindBy(xpath="//input[@id='ap_email']")
	private WebElement emailid;
	
	@FindBy(id="continue")
	private WebElement contButton;

	@FindBy(xpath="//input[@id='ap_password']")
	private WebElement password;
	
	@FindBy(id="signInSubmit")
	private WebElement signonsubmit;
	
	
	public Signon() {
		PageFactory.initElements(driver, this);
		System.out.println("Signon variable initialized");
		}
	
	public void loginFunction(String emailaddr, String pwd)
	{
		System.out.println(emailid+""+contButton);
		action.fluentWait(driver, emailid, 20);
        action.typetext(emailid, emailaddr);
        action.click(driver, contButton);
        action.typetext(password, pwd);
        action.click(driver, signonsubmit);
        
	}
}
