package com.ebay.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.qa.base.TestBase;
import com.ebay.qa.pages.HomePage;
import com.ebay.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	HomePage homePages;
	TestUtil testUtil;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePages = new HomePage(); // if we don't create object for Homepage then throw the null pointer.
		
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String pageTitle = homePages.verfiyHomePageTitle();
		Assert.assertEquals(pageTitle, "Electronics, Cars, Fashion, Collectibles & More | eBay");
		
	}
	
	@Test(priority = 2)
	public void headerLinkTest() {
	 int list = homePages.headerList();
		Assert.assertEquals(list, 13, "The number of links are not matched");
	}
	
	@Test(priority = 3)
	public void miniCartTest() {
		String crtMssg = homePages.miniCart();
		Assert.assertEquals(crtMssg, "Your cart is empty", "The Cart message doesn't Match.");
	}
	
	//@Test(priority = 4)
	public void searchTest() {
		homePages.search();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
