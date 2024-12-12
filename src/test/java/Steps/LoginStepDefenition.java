package Steps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

 
public class LoginStepDefenition {
	WebDriver driver;
	@SuppressWarnings("deprecation")
	@Given("user is on login page")
	public void user_is_on_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://saucedemo.com/");
	}

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}

	@When("Clicks login button")
	public void clicks_login_button() {
		driver.findElement(By.id("login-button")).click();
	}

	@Then("User is logged in and navigated to product page")
	public void user_is_logged_in_and_navigated_to_product_page() {
		String s = driver.findElement(By.className("app logo")).getText();
	    Assert.assertEquals("Swag Labs", s);
	    driver.close();
	}

 
 
}
