package com.ebay.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ebay.qa.base.TestBase;

public class SearchPage extends TestBase{

	@FindBy(id ="gh-cat")
	WebElement cate;
	
	@FindBy(id ="gh-ac")
	WebElement searchBox;
	
	@FindBy(id ="gh-btn")
	WebElement searchBttn;
	
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verfiySearchPageTitle() {
		
		// getTitle() return data in string.
		
		return driver.getTitle();
	}
	
	public String categories() {
		
		String searData = prop.getProperty("search");
		searchBox.sendKeys(searData);
		searchBttn.click();
		
		String drop = cate.getText();
		System.out.println(drop);
		return drop;
	}
	
	public void iphoneSearch() {
		
		String searData = prop.getProperty("search1");
		searchBox.sendKeys(searData);
		
		Select drop = new Select(cate);
		drop.selectByValue("15032");
		
		
		//System.out.println(cate.getText());
		//if this will not work then add List<WebElement>
		//and store cate dropdown and add for and if loops.
		
		//List<WebElement> Dropdown = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
		/*for(int i=0; i<Dropdown.size(); i++){
			if(Dropdown.get(i).isSelected()) {
			System.out.println(Dropdown.get(i).getText()+ "------"+ Dropdown.get(i).isSelected());
		}
		}*/
		searchBttn.click();
		
	}
	
	
}
