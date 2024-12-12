package step;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddtoDef {
	
	WebDriver driver;
	@Given("User is on logged page")
	public void user_is_on_logged_page() {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.get("https://www.saucedemo.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@When("User enter credentials and clicks login button")
	public void user_enter_credentials_and_clicks_login_button() {
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
	    driver.findElement(By.name("password")).sendKeys("secret_sauce");
	    driver.findElement(By.name("login-button")).click();
	}
	@Then("user is logged in")
	public void user_is_logged_in() {
		String s = driver.findElement(By.className("app_logo")).getText();
		System.out.println(s);
	}
	@Given("User is on logged  in and on product page")
	public void user_is_on_logged_in_and_on_product_page() {
	    
	}
	@When("user enters clicks on add to cart button of a product")
	public void user_enters_clicks_on_add_to_cart_button_of_a_product() {
		 driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
	}
	@Then("product is added to cart")
	public void product_is_added_to_cart() {
		 String count= driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
		   Assert.assertEquals(count, "1");
	}
	@Then("clicks the cart button")
	public void clicks_the_cart_button() {
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	}
	@Then("product is displayed on cart")
	public void product_is_displayed_on_cart() {
		String pro=driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		Assert.assertEquals(pro, "Sauce Labs Bike Light");
		//driver.close();
	}
	

	@When("user enters clicks on add to cart button of a multiple product")
	public void user_enters_clicks_on_add_to_cart_button_of_a_muliple_product() {
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	}
	@Then("product is added to cart and count is displayed")
	public void product_is_added_to_cart_and_count_is_displayed() {
		String count= driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
		   Assert.assertEquals(count, "2");
		  // driver.close();
	}




}
