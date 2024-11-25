package stepdef;


import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Login {
	public WebDriver driver= new ChromeDriver();

    @Before
    public void setup() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--new-private-window");
            options.addArguments("--user-data-dir=D:\\ChromeUserData");
            options.addArguments("--disable-dev-shm-usage");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    @Given("User launches the Chrome browser")
    public void user_launches_the_Chrome_browser() {
        Assert.assertNotNull(driver, "WebDriver instance is not initialized");
        System.out.println("Chrome browser launched successfully");
    }

    @When("User navigates to {string}")
    public void user_navigates_to(String url) {
        driver.get(url);
    }

    @When("User clicks on the {string} button in the navbar")
    public void user_clicks_on_button_in_navbar(String buttonName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'" + buttonName + "')]")));
        button.click();
    }

    @When("User enters valid credentials {string} and {string}")
    public void user_enters_valid_credentials(String email, String password) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @When("User clicks the {string} button")
    public void user_clicks_the_button(String buttonText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form//button[@type='submit']")));
        button.click();
    }

    @Then("User should be successfully logged in and redirected to the student dashboard page")
    public void user_should_be_successfully_logged_in_and_redirected_to_the_student_dashboard_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.urlToBe("https://internship-ictak.vercel.app/StudentDashboard"));
            System.out.println("Redirected to: " + driver.getCurrentUrl());
            Assert.assertTrue(driver.getCurrentUrl().equals("https://internship-ictak.vercel.app/StudentDashboard"), "Redirection to StudentDashboard failed.");
        } catch (TimeoutException e) {
            System.out.println("Redirection failed. Current URL: " + driver.getCurrentUrl());
            Assert.fail("redirect to StudentDashboard");
        }
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}



