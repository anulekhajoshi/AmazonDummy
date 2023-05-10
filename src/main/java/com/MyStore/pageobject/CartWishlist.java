package com.MyStore.pageobject;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.base.Base;

public class CartWishlist extends Base {


	@FindBy(xpath="//span[@class='nav-cart-icon nav-sprite']")
	private WebElement homecarticon;
	
	@FindBy(xpath="//h1[contains(.,'Shopping Cart')]")
	private WebElement cartpagetitle;
	
	@FindBy(xpath="(//span[@class='a-truncate sc-grid-item-product-title a-size-base-plus'])[1]//span[1]")
	private WebElement cartproduct;
	
	@FindBy(xpath="//div[@id='sc-active-cart']//input[@value='Delete'][1]")
	private WebElement deleteproduct;
	
	@FindBy(xpath="//h1[contains(text(),'Your Amazon Cart is empty.')]")
	private WebElement emptycarttext;
	
	public CartWishlist() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyCartNavigation() {
		DeclareObjects.declareAc().click(driver, homecarticon);
		DeclareObjects.declareAc().fluentWait(driver, cartpagetitle, 20);	
	}
	
	public String getProductAddedinCart() {
		System.out.println("Value of cartproduct is "+cartproduct);
		String getcartproduct=cartproduct.getAttribute("innerHTML");		
		System.out.println("Value of getcartproduct is "+getcartproduct);
		return getcartproduct;
		//assert.assertEquals(getproduct, getcartproduct);
	}		
	public void deleteItemfromcart() {
		DeclareObjects.declareAc().click(driver, deleteproduct);
		DeclareObjects.declareAc().fluentWait(driver, emptycarttext, 20);
		Base.getScreenshotmethod("ProductDeleted");
		System.out.println("pass");
	}
}
