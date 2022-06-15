package com.ebay.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.qa.base.TestBase;
import com.ebay.qa.pages.HomePage;
import com.ebay.qa.pages.SearchPage;
import com.ebay.qa.util.TestUtil;

public class SearchPageTest extends TestBase {

	TestUtil testUtil;
	HomePage homePages;
	SearchPage searchPages;
	
	public SearchPageTest() {
		super();	
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		testUtil = new TestUtil();
		homePages = new HomePage();
		searchPages = new SearchPage();
	}
	
	@Test(priority = 1)
	public void verfiySearchPageTitleTest() {

		homePages.search();
		
		String pageTitle = homePages.verfiyHomePageTitle();
		Assert.assertEquals(pageTitle, "men's t-shirts: Search Result | eBay");
	}
	
	@Test(priority = 2)
	public void categoriesTest() {
		searchPages.categories();
	}
	
	@Test(priority = 3)
	public void iphoneSearchTest() {
		searchPages.iphoneSearch();
	}
	
	@AfterMethod
	public void tearDownTest() {
		driver.quit();
	}
}
