package Features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
    WebDriver driver;

    @Given("Open the Chrome and launch the application")
    public void open_the_chrome_and_launch_the_application() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @When("Enter the Username and Password")
    public void enter_the_username_and_password() {
        WebElement username = driver.findElement(By.name("user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");
    }

    @Then("Reset the credential")
    public void reset_the_credential() {
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();
    }

    @Then("User is successfully logged in")
    public void verify_successful_login() {
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
    }

    @When("User clicks on the logout button")
    public void click_logout_button() throws InterruptedException {
        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn")); // Assuming class name for menu button
        menuButton.click();
        Thread.sleep(2000); // Adjust wait time if needed for menu animation

        WebElement logoutButton = driver.findElement(By.linkText("Logout")); // Adjust locator for logout button
        logoutButton.click();
    }

    @Then("User is redirected to the login page")
    public void verify_logout_redirection() {
        String expectedURL = "https://www.saucedemo.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
    }
}
