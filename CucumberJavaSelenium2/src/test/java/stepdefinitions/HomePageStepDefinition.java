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
import pageObjects.HomePageLocators;
import utils.TestContextSetup;

@SuppressWarnings("unused")
public class HomePageStepDefinition {

	WebDriver driver;
	String homePageString;
	String DealsPageString;
	TestContextSetup testContextSetup;

	// Constructor
	public HomePageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;

	}

	@Given("User is on GreenKart home page")
	public void user_is_on_green_kart_home_page() {

		testContextSetup.driver = new ChromeDriver();
		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		testContextSetup.driver.manage().window().maximize();

	}

	@When("user searched for string {string}")
	public void user_searched_for_string(String string) throws InterruptedException {
		
		// Enter the string in search box
		HomePageLocators homePageLocators = new HomePageLocators(testContextSetup.driver);
		homePageLocators.searchItem(string);
		
		// Alternate way without using POM class
		// testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(string);
		
 		Thread.sleep(2000);
	}

	@When("extract actual name from the product displayed")
	public void extract_actual_name_from_the_product_displayed() throws InterruptedException {
		
		// Using POM class
		HomePageLocators homePageLocators = new HomePageLocators(testContextSetup.driver);
		testContextSetup.homePageString = homePageLocators.getProductName().split("-")[0].trim();
		
		// Alternate way without using POM class
		// testContextSetup.homePageString = testContextSetup.driver.findElement(By.xpath("//h4")).getText().split("-")[0].trim();
		
		//Explanation: Tomato - 1 Kg -> it will split and take first part in .split("-")[0] and trim the spaces with .trim()
		
		Thread.sleep(2000);
		// Print the name of the product
		System.out.println(testContextSetup.homePageString);
	}

}

//dependency injection -> create object of TestContextSetup class and pass it to the constructor
// this will help to share the data between step definition classes
// this is called dependency injection
// cucumber will create the object of this class and pass it to the constructor
// this is called dependency injection

// single responsibility principle is followed here - one class one
// responsibility

// HomePageStepDefinition class is responsible for home page only
// DealsPageStepDefinition class is responsible for deals page only
// TestContextSetup class is responsible for sharing data between classes only
// TestContextSetup class is a POJO class - Plain Old Java Object class
// it has only data members and getters and setters
// it does not have any business logic
// it is used to share data between step definition classes

//	class loosely coupled - if we change one class it will not
// affect other classes - this is called loose coupling
// class tightly coupled - if we change one class it will
// affect other classes - this is called tight coupling
// here we are using loose coupling - if we change TestContextSetup class
// it will not affect HomePageStepDefinition and DealsPageStepDefinition classes
// if we change HomePageStepDefinition class it will not affect
// DealsPageStepDefinition class
// if we change DealsPageStepDefinition class it will not affect
// HomePageStepDefinition class
// this is called loose coupling
// this is achieved by using dependency injection
// this is a good design pattern - it is called Page Object Model (POM)
// it is a good practice to follow single responsibility principle and loose
// coupling
// it will make the code more maintainable and reusable
// it will make the code more readable and understandable
// it will make the code more testable and debuggable
// it will make the code more scalable and extensible
// it will make the code more robust and reliable
// it will make the code more efficient and effective
// it will make the code more flexible and adaptable
// it will make the code more modular and cohesive
// it will make the code more consistent and uniform
// it will make the code more standard and conventional
// it will make the code more professional and elegant
// it will make the code more beautiful and attractive
// it will make the code more fun and enjoyable
// it will make the code more productive and efficient
// it will make the code more creative and innovative
// it will make the code more collaborative and cooperative
// it will make the code more communicative and interactive
// it will make the code more social and friendly
// it will make the code more ethical and moral
// it will make the code more legal and compliant
// it will make the code more secure and safe
// it will make the code more private and confidential
// it will make the code more transparent and accountable
// it will make the code more sustainable and eco-friendly
// it will make the code more humane and compassionate
// it will make the code more spiritual and philosophical
// it will make the code more holistic and integrative
// it will make the code more futuristic and visionary
// it will make the code more global and universal
// it will make the code more local and specific
