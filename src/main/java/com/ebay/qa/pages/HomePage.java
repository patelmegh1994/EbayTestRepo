package com.ebay.qa.pages;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.ebay.qa.base.TestBase;


public class HomePage extends TestBase {
	
	@FindBy(xpath = "//div[@id= 'mainContent']/div[1]/ul/li")
	List<WebElement> header;
	
	@FindBy(xpath = "//li[@id = 'gh-minicart-hover']/div/a[1]")
	WebElement cart;
	
	@FindBy(xpath ="//h2[contains(text(),'Your cart is empty')]")
	WebElement cartMsg;
	
	@FindBy(id ="gh-ac")
	WebElement searchBox;
	
	@FindBy(id ="gh-btn")
	WebElement searchBtn;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verfiyHomePageTitle() {
		// getTitle() return data in string.
		return driver.getTitle();
	}
	
	public int headerList() {
		
		//List<WebElement> head = header.findElements(By.tagName("li"));
		
		
		for(WebElement a: header) {
			System.out.println(a.getText());
		}
		
		return header.size();
		
	}
	
	public String miniCart() {
		
		Actions action = new Actions(driver);
		action.moveToElement(cart).build().perform();
		
		//System.out.println(cartMsg);
		
		return cartMsg.getText();
	}
	
	public SearchPage search() {
		
		String searchData = prop.getProperty("search");
		searchBox.sendKeys(searchData);
		searchBtn.click();
		
		return new SearchPage();
	}
}
