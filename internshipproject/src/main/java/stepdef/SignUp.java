package stepdef;


import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUp {
	public WebDriver driver= new ChromeDriver();

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=D:\\Chromedatasign");
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("User opens URL for signup {string}")
    public void user_opens_URL(String url) {
        driver.get(url);
    }

    @When("User clicks on the Login button for signup")
    public void user_clicks_login_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Login']"))).click();
        handleUnexpectedAlert();
    }

    @When("User clicks on the New User Register link")
    public void user_clicks_new_user_register_link() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='New User? Register']"))).click();
        handleUnexpectedAlert();
    }

    @Then("The signup page should load successfully")
    public void verify_signup_page_loads() {
        Assert.assertNotNull(driver.getTitle(), "Signup page failed to load");
    }

    @When("User enters name {string}, email {string}, password {string}, phone number {string}, and batch name {string}")
    public void user_enters_valid_details(String name, String email, String password, String phone, String batch) {
        driver.findElement(By.xpath("//input[@type='text' and @placeholder='Name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@type='email' and @placeholder='Email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@type='password' and @placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='text' and @placeholder='Phone Number']")).sendKeys(phone);
        driver.findElement(By.xpath("//input[@type='text' and @placeholder='Batch Name']")).sendKeys(batch);
    }

    @When("User agrees to the terms and conditions")
    public void user_agrees_to_terms_and_conditions() {
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox.click();
    }

    @When("User clicks on the Continue button")
    public void user_clicks_on_the_continue_button() {
        WebElement continueButton = driver.findElement(By.xpath("//button[text()='Continue']"));
        continueButton.click();
        handleUnexpectedAlert();
    }

    @Then("User should be successfully signed up and redirected to the login page")
    public void user_should_be_successfully_signed_up() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
        try {
            wait.until(ExpectedConditions.urlContains("/login"));
            Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Redirection to login page failed.");
        } catch (TimeoutException e) {
            System.out.println("Failed to redirect. Current URL " + driver.getCurrentUrl());
            Assert.fail("Expected to redirect to /login");
        }
    }

   
   public void handleUnexpectedAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (TimeoutException e) {
            
        }
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
