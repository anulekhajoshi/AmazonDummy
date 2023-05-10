package com.MyStore.pageobject;
import com.MyStore.base.Base;
import com.MyStore.actiondriver.Action;

public class DeclareObjects extends Base{
	
	
	
	public static Action declareAc () {
		Action  action=new Action();
		return action;
		
	}
	public static Home declareHm () {
		Home hm=new Home();
		return hm;
		
	}
	public static Signon declareSo () {
		Signon so=new Signon();
		return so;
		
	}
	public static SearchResultPage declareSp () {
		SearchResultPage sp=new SearchResultPage();
		return sp;
		
	}
	public static SearchItemDetail declareSd () {
		SearchItemDetail sd=new SearchItemDetail();
		return sd;
		
	}
	public static Checkout checkoutCk() {
		Checkout ck=new Checkout();
		return ck;
		
	}
	public static CartWishlist declarecw() {
		CartWishlist cw=new CartWishlist();
		return cw;
		
	}
	/*
    
	sp=new SearchResultPage();
	sd=new SearchItemDetail();
	co=new Checkout();*/
}
