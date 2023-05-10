package com.MyStore.testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.MyStore.base.Base;
import com.MyStore.pageobject.DeclareObjects;
import com.MyStore.utility.Log;

public class SearchAmazon extends Base{
	
	Base bs=new Base();
	
	@BeforeMethod
	public void launch()
	{
		launchApp("Chrome");
		
	}
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.isSuccess()) {
			Base.getScreenshotmethod(result.getMethod().getMethodName());
		}
		else {
			Base.getScreenshotmethod(result.getMethod().getMethodName()+"fail");
		}
		driver.quit();
	}
	
	@Test 
	public void verifyAmazonSearchAddedToCartFeature() throws InterruptedException {
		DeclareObjects.declareHm().login();
		
		DeclareObjects.declareSo().loginFunction(prop.getProperty("email"), prop.getProperty("password"));
		Log.info("Logged into Amazon account");
		DeclareObjects.declareHm().searchbox("Women Top");
		Log.info("search the product");
		DeclareObjects.declareHm().searchResultfunction();
		Log.info("got the search result");
		DeclareObjects.declareSp().selectItemList();
		Log.info("select a product from the search result");
		DeclareObjects.declareAc().handlemultipleWindows();
		Log.info("focus shifter to the product tab");
		DeclareObjects.declareSd().performAddtoCart();	
		Log.info("added product to the cart");
		DeclareObjects.declareSd().clickproceedtobuy();
		Log.info("continue to buy the product");
		DeclareObjects.checkoutCk().verifyCheckOutPage();	
		Log.info("verify the checkout page");
	}
	
	@Test
	public void verifyAmazonSearchBuyNowFeature() throws InterruptedException {
		DeclareObjects.declareHm().login();
		DeclareObjects.declareSo().loginFunction(prop.getProperty("email"), prop.getProperty("password"));
		DeclareObjects.declareHm().searchbox("Women Top");
		DeclareObjects.declareHm().searchResultfunction();
		DeclareObjects.declareSp().selectItemList();
		DeclareObjects.declareSd().buyNowFunction();		
		DeclareObjects.checkoutCk().verifyCheckOutPage();	
	}
	
	
}
