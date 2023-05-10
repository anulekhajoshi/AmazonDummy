package com.MyStore.pageobject;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.actiondriver.Action;
import com.MyStore.base.Base;

public class SearchResultPage extends Base{
	Action act=new Action();
	
	@FindBy(xpath="//div[@data-cel-widget='search_result_3']")
	private WebElement selectItem;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectItemList() {		
		act.explicitWait(driver, selectItem, 20);
		act.click(driver, selectItem);
	
	}
	
}
