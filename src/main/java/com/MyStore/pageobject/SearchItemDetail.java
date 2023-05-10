package com.MyStore.pageobject;

import com.MyStore.base.Base;
import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import com.MyStore.actiondriver.Action;

public class SearchItemDetail extends Base{
	Action act=new Action();
	
	@FindBy(id="add-to-cart-button")/*xpath="//div[@id='desktop_qualifiedBuyBox']//input[@id='add-to-cart-button']")*/
	private WebElement addtocart;
	
	@FindBy(xpath="//div[@id='desktop_qualifiedBuyBox']//input[@id='buy-now-button']")
	private WebElement buynow;
	
	@FindBy(xpath="//div/span[contains(.,'Added to Cart')]")
	private WebElement cartadded;
	
	@FindBy(xpath="//input[@name='proceedToRetailCheckout']")
	private WebElement proceedtobuy;
	
	@FindBy(xpath="//span[@id='productTitle']")
	private WebElement Producttitle;
		
	public SearchItemDetail() {
		PageFactory.initElements(driver, this);
	}
    
	public void performAddtoCart() {	
		act.explicitWait(driver, addtocart, 20);		
		act.click(driver, addtocart);		
	//	act.explicitWait(driver, cartadded, 20);
	}
	public void clickproceedtobuy() {
		boolean itemadded= act.elementvisible(driver, cartadded);
		if(itemadded==true) {
			act.click(driver, proceedtobuy);
		}	
	}
	
	
	public String getproductTitle() {		
		String prodtitle=Producttitle.getText();
		System.out.println("Selected Product title is: "+prodtitle);
		return prodtitle;
	}
	
	public void buyNowFunction() throws InterruptedException {
		
		act.handlemultipleWindows();
		System.out.println("xpath of buynow is: "+buynow);
		act.explicitWait(driver, buynow, 20);
		act.click(driver, buynow);
		
	}
}
