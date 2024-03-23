package Features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Logdata {
	WebDriver driver;
@Given("Open the Chrome Bowser and launch the application")
public void test()
{
	 System.out.println("Given Executed...");
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	  driver= new ChromeDriver();					
	  driver.manage().window().maximize();			
	  driver.get("https://www.saucedemo.com/");
}
@When("Enter the Username {string} and Password {string}")
public void enter_the_username_and_password(String string, String string2) {
	System.out.println("When Executed...");
    WebElement ur=driver.findElement(By.name("user-name"));
    ur.sendKeys(string);
    WebElement ps=driver.findElement(By.name("password"));
    ps.sendKeys(string2);
}

@Then("Login the credential")
public void login_the_credential() {
	System.out.println("Then Executed...");
	WebElement l=driver.findElement(By.name("login-button"));
    l.click();
    String expectedURL="https://www.saucedemo.com/inventory.html";
    String actualURL=driver.getCurrentUrl();
    System.out.println("Actual URL"+actualURL);
    Assert.assertEquals(expectedURL,actualURL);
}

}
