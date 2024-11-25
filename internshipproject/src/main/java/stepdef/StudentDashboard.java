package stepdef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StudentDashboard {
	public WebDriver driver= new ChromeDriver();

	@Given("The details page of Library Management System")
	public void the_details_page_of_library_management_system() {

		driver.get("https://internship-ictak.vercel.app/");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[@href='/login']//child::button")).click();//login button in home page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("princy@gmail.com");//login email
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");//login password
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[@type='submit']")).click();//login button
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().setSize(new Dimension(1200, 800));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//div[@class='card-footer'])[1]")).click();//read more button
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement body = driver.findElement(By.name("acceptTerms"));
		Actions actions = new Actions(driver);
		actions.moveToElement(body).sendKeys(Keys.PAGE_DOWN).perform();//scrolling the page down
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		body.click();
	}
	@When("Clicking on Back button")
	public void clicking_on_back_button() {
		driver.findElement(By.xpath("//button[@tabindex='0'][1]")).click();//back button
	}
	@Then("The page moves to the Student Dashboard Page")
	public void the_page_moves_to_the_student_dashboard_page() {
	}
	
	@Given("The details page of Library Management System after ticking the declaration box")
	public void the_details_page_of_library_management_system_after_ticking_the_declaration_box() {
		driver.get("https://internship-ictak.vercel.app/");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[@href='/login']//child::button")).click();//login button in home page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("princy@gmail.com");//login email
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");//login password
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[@type='submit']")).click();//login button
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().setSize(new Dimension(1200, 800));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//div[@class='card-footer'])[1]")).click();//read more button
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement body = driver.findElement(By.name("acceptTerms"));
		Actions actions = new Actions(driver);
		actions.moveToElement(body).sendKeys(Keys.PAGE_DOWN).perform();//scrolling the page down
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		body.click();
	}
	
	@When("Clicking on Proceed button")
	public void clicking_on_proceed_button() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[@tabindex='0'][2]")).click();//proceed button
	}
	@Then("The page moves to Project Dashboard page")
	public void the_page_moves_to_project_dashboard_page() {
	}
	
	@After
	public void tearDown() throws InterruptedException {
	Thread.sleep(10000);
	driver.quit();
	}
}