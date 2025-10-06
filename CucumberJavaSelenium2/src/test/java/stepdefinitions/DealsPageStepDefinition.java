package stepdefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DealsPageLocators;
import utils.TestContextSetup;

@SuppressWarnings("unused")
public class DealsPageStepDefinition {

	WebDriver driver;
	String homePageString;
	String DealsPageString;
	TestContextSetup testContextSetup;

	// Constructor
	public DealsPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;

	}

	@Then("user searched same string {string} in offers page")
	public void user_searched_same_string_in_offers_page(String string) throws InterruptedException {

		// Click on Top Deals link to go to offers page
		SwitchToDealsPageFromHomePage();

		// Now in Offers page
		// Search for the same vegetable in offers page

		Thread.sleep(2000);

		// Using POM class
		DealsPageLocators offersPageLocators = new DealsPageLocators(testContextSetup.driver);
		offersPageLocators.getSearch();

		// Alternate way without using POM class
		// testContextSetup.driver.findElement(By.id("search-field")).sendKeys(string);

		Thread.sleep(2000);
		// Get the name of the product
		// Using POM class
		testContextSetup.DealsPageString = offersPageLocators.getProductName();

		// Alternate way without using POM class
		// testContextSetup.DealsPageString = testContextSetup.driver.findElement(By.xpath("//td[normalize-space()='Tomato']")).getText();
		// td[normalize-space()='Tomato'] -> Xpath for Tomato in offers page
		
		// Print the name of the product
		System.out.println(testContextSetup.DealsPageString);
	}

	@Then("verify same product in home page exists in offers page")
	public void verify_same_product_in_home_page_exists_in_offers_page() {

//		if (testContextSetup.homePageString.equalsIgnoreCase(testContextSetup.DealsPageString)) {
//			System.out.println("Both names are same");
//		} else {
//			System.out.println("Names are different");
//		}

		// Using TestNG for validation
		Assert.assertEquals(testContextSetup.homePageString, testContextSetup.DealsPageString);

		testContextSetup.driver.close();
		testContextSetup.driver.quit();
	}

	public void SwitchToDealsPageFromHomePage() {
		testContextSetup.driver.findElement(By.xpath("//a[.='Top Deals']")).click();

		// Switch to new tab (Offers page) it opens in a new tab (child window)
		Set<String> s1 = testContextSetup.driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();

		testContextSetup.driver.switchTo().window(childWindow);
		// Now in Offers page
	}
}
