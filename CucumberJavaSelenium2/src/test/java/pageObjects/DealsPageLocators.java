package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DealsPageLocators {
	
	public WebDriver driver;

	public DealsPageLocators(WebDriver driver) {
		this.driver = driver;
	}
	
	By search = By.id("search-field");
	By productName = By.xpath("//td[normalize-space()='Tomato']");
	
	public void getSearch() {
	
		driver.findElement(search).click();
	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
	
}
