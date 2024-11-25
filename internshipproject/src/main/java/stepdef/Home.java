package stepdef;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Home {
	public WebDriver driver= new ChromeDriver();

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
       
        options.addArguments("--new-private-window");
        options.addArguments("--user-data-dir=D:\\ChromeUserData");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Given("User Launch Chrome browser")
    public void user_Launch_Chrome_browser() {
     
        System.out.println("Chrome browser launched successfully");
    }

    @When("User opens URL {string}")
    public void user_opens_URL(String url) {
        driver.get(url);
    }

    @Then("The home page should load successfully")
    
    
    public void verify_home_page_loads() {
        Assert.assertNotNull(driver.getTitle(), "Home page failed to load");
    }

    @Then("The title should display as {string}")
    public void verify_title(String Title) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.titleIs(Title));
        Assert.assertEquals(driver.getTitle(), Title, "Page title does not match expected title");
       
    }

    @When("User clicks on the Home button")
    public void user_clicks_home_button() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Home']"))).click();
       
    }

    @When("User clicks on the Login button")
    public void user_clicks_login_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Login']"))).click();
    }

    @Then("User should be navigated to the login page")
    public void verify_user_on_login_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "User is not on the login page");
    }

    @After
    public void tearDown() throws InterruptedException {
    Thread.sleep(8000);
        driver.quit();   
    }
    }

