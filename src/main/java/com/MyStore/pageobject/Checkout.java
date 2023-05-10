/* This page contains all the web elements of Checkout; page and functions related to home page*/
package com.MyStore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.MyStore.actiondriver.Action;
import com.MyStore.base.Base;

public class Checkout extends Base{
    Action act=new Action();
	@FindBy(xpath="//h1[contains(.,'Checkout')]")
	WebElement checkout;
	
	public Checkout() {
		PageFactory.initElements(driver, this);
	}
		
	public void verifyCheckOutPage() {
		act.fluentWait(driver, checkout, 30);
		System.out.println("Reached checkout");
	}
}
