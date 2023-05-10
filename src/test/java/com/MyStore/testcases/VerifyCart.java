package com.MyStore.testcases;

import static org.testng.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.MyStore.base.Base;
import com.MyStore.pageobject.DeclareObjects;


public class VerifyCart extends Base{
		
		
		
		@BeforeMethod
		public void launch()
		{
			launchApp("Chrome");
			
		}
		
		@Test
		public void verifyproductaddedtocart() throws InterruptedException {
			DeclareObjects.declareHm().login();
			DeclareObjects.declareSo().loginFunction(prop.getProperty("email"), prop.getProperty("password"));
			DeclareObjects.declareHm().searchbox("electronics");		
			DeclareObjects.declareHm().searchResultfunction();
			Base.getScreenshotmethod("searchResultPage");
			DeclareObjects.declareSp().selectItemList();
			DeclareObjects.declareAc().handlemultipleWindows();
			String prodTitle=DeclareObjects.declareSd().getproductTitle();	
			Base.getScreenshotmethod("productselected");
			DeclareObjects.declareSd().performAddtoCart();	
			DeclareObjects.declarecw().verifyCartNavigation();
			Base.getScreenshotmethod("CartPage");
			String prodcarttitle=DeclareObjects.declarecw().getProductAddedinCart().replaceAll("ं", "");		
			String carttitle=prodcarttitle.replaceAll("\\(.+?\\)","").trim();
		    System.out.println("Value of getcartproduct is: " + carttitle);
			Assert.assertTrue(carttitle.equalsIgnoreCase(prodTitle));
			DeclareObjects.declarecw().deleteItemfromcart();
		}
		
		@AfterMethod
		public void tearDown(ITestResult result) {
			if(result.isSuccess()) {
				Base.getfullScreenshotmethod(result.getTestName());
			}
			else {
				Base.getfullScreenshotmethod(result.getTestName()+"fail");
			}
			driver.quit();
		}
		
}
