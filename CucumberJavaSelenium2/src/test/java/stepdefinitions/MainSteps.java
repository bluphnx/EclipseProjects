// single stepdefinition for scenario with multiple steps in different pages with window handling and validation using TestNG 

/*
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

public class MainSteps {

	WebDriver driver;
	String homePageString;
	String DealsPageString;

	@Given("User is on GreenKart home page")
	public void user_is_on_green_kart_home_page() {

		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();

	}

	@When("user searched for string {string}")
	public void user_searched_for_string(String string) throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(string);

	}

	@When("extract actual name from the product displayed")
	public void extract_actual_name_from_the_product_displayed() throws InterruptedException {
		Thread.sleep(2000);
		homePageString = driver.findElement(By.xpath("//h4")).getText().split("-")[0].trim();
		// Tomato - 1 Kg -> it will split and take first part in .split("-")[0] and trim
		// the spaces with .trim()
		System.out.println(homePageString);
	}

	@SuppressWarnings("unused")
	@Then("user searched same string {string} in offers page")
	public void user_searched_same_string_in_offers_page(String string) throws InterruptedException {
		driver.findElement(By.xpath("//a[.='Top Deals']")).click();

		// Switch to new tab (Offers page) it opens in a new tab (child window)
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();

		driver.switchTo().window(childWindow);
		// Now in Offers page
		// Search for the same vegetable in offers page

		Thread.sleep(2000);
		driver.findElement(By.id("search-field")).sendKeys(string);
		Thread.sleep(2000);
		DealsPageString  = driver.findElement(By.xpath("//td[normalize-space()='Tomato']")).getText(); // td[normalize-space()='Tomato']
		System.out.println(DealsPageString);
	}

	@Then("verify same product in home page exists in offers page")
	public void verify_same_product_in_home_page_exists_in_offers_page() {

//		if (actualName.equalsIgnoreCase(check)) {
//			System.out.println("Both names are same");
//		} else {
//			System.out.println("Names are different");
//		}
		
		// Using TestNG for validation
		Assert.assertEquals(homePageString, DealsPageString);

		driver.close();
		driver.quit();
	}
}

*/