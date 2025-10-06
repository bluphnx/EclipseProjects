package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageLocators {

	public WebDriver driver;
	
	public HomePageLocators(WebDriver driver) {
		this.driver = driver;
	}
	
	By search =  By.xpath("//input[@type='search']");
	By productName = By.xpath("//h4");
	
	public void searchItem(String item) {
		driver.findElement(search).sendKeys(item);
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
}
