package com.MyStore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dummy {

	@Test
	public void Anu()
	{
		String ab="BLINKIN Cotton Pyjamas for Women Combo Pack of 2 with Side Pockets";
		String cd="BLINKIN Cotton Pyjamas For Womenं Combo Pack Of 2 With Side Pockets (Color_Maroon|Navy Blue,Size_3XL)".replaceAll("ं", "");
		String finalcd=cd.replaceAll("\\(.+?\\)","").trim();
		System.out.println(finalcd);
		Assert.assertTrue(finalcd.equalsIgnoreCase(ab));
	}
}
