package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;


public class HomePageTest extends BaseTest{
	
	
	@Test
	private void homePageTitleTest() {
		String actualTitle = homepage.getHomePageTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
	}
	
	@Test
	private void homePageURL() {
		
		String actualURL = homepage.getHomePageURL();
		Assert.assertEquals(actualURL, "https://naveenautomationlabs.com/opencart/");
	}
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{"MacBook"},
			{"imac"},
			{"Samsung"}
			
		};
	}
	
	@Test(dataProvider = "getProductData")
	private void searchTest(String productName) {
		
		String actualSearchHeader = homepage.doSearch(productName);
		Assert.assertEquals(actualSearchHeader, "Search - "+productName);
	}
	
	
}
