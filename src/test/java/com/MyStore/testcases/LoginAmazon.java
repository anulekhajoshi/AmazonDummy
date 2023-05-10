package com.MyStore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.MyStore.base.Base;
import com.MyStore.pageobject.Home;
import com.MyStore.pageobject.Signon;

public class LoginAmazon extends Base{
	Home hm;
	Signon so;
@BeforeTest
public void launch()
{
	launchApp("Chrome");
	
}
@AfterTest
public void close() {
	driver.quit();
}


@Test
public void loginVerify(){
	hm= new Home();
	so= new Signon();
	hm.login();
	so.loginFunction(prop.getProperty("email"), prop.getProperty("password"));
	String fetchtitle= hm.verifyTitle();
	String title="Amazon Sign In";
	Assert.assertTrue(fetchtitle.equals(title));
	
}
}
