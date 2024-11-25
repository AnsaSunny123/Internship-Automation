package stepdef;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProjectDahboard {
	public WebDriver driver= new ChromeDriver();
	
	@Given("The Project Dashboard Page after clicking {string} under Library Management System")
	public void the_project_dashboard_page_after_clicking_under_library_management_system(String string) {
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[@tabindex='0'][2]")).click();//proceed button
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Then("The user navigates to the Reference Materials tab for projectdashboard")
	public void the_user_navigates_to_the_reference_materials_tab_for_projectdashboard() throws InterruptedException {
		WebElement ref = driver.findElement(By.id("v-pills-reference-tab"));//reference button
		Actions actions = new Actions(driver);
		actions.moveToElement(ref).sendKeys(Keys.PAGE_UP).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ref.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Get Reference']")).click();
	       Thread.sleep(5000);
	}
	
	@When("The user navigates to the Weekly Submission tab for projectdashboard")
	public void the_user_navigates_to_the_weekly_submission_tab_for_projectdashboard() throws InterruptedException {
		driver.findElement(By.id("v-pills-weekly-tab")).click(); //Weekly Submission
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	       
	       
	       WebElement weekDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select.form-select")));
	       weekDropdown.click();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	       WebElement weekOption = weekDropdown.findElement(By.xpath("//option[@value='1']")); // Replace with a valid week value
	       weekOption.click();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	       System.out.println("Week selected successfully.");
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	       WebElement linkTextarea = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//textarea[@class='form-control'])[1]")));
	       linkTextarea.clear();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	       linkTextarea.sendKeys("https://example.com/submission-link");
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	       WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")));
	       fileInput.sendKeys(System.getProperty("user.dir")+"\\files\\testing.pdf");
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	       WebElement textareas = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//textarea[@class='form-control'])[2]")));
	       textareas.sendKeys("This is a sample submission description.");
	       WebElement submit = driver.findElement(By.xpath("(//button[text()='Add Submission'])[1]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(submit).sendKeys(Keys.PAGE_DOWN).perform();
			submit.click();
			Thread.sleep(10000);
	       Alert alert= wait.until(ExpectedConditions.alertIsPresent()); //Waiting for the confirmation alert
	       Thread.sleep(2500);
	       alert.accept(); //Accepting the confirmation
	}

	@Then("The user reaches the Weekly Submission tab")
	public void the_user_reaches_the_weekly_submission_tab() {
	}

	@When("The user navigates to the Discussion Forum tab for projectdashboard")
	public void the_user_navigates_to_the_discussion_forum_tab_for_projectdashboard() throws InterruptedException {
		WebElement disTab = new WebDriverWait(driver, Duration.ofSeconds(30))
	               .until(ExpectedConditions.presenceOfElementLocated(By.id("v-pills-discussion-tab")));

	       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", disTab);

	       try {
	           disTab.click();
	         
	       } catch (ElementClickInterceptedException e) {
	         
	           ((JavascriptExecutor) driver).executeScript("arguments[0].click();", disTab);
	       }
	       WebElement textarea = driver.findElement(By.cssSelector("textarea[placeholder='Post a new query or edit an existing one...']"));
	       String query = "Welcome to kerala";  
	       textarea.sendKeys(query);

	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	       WebElement postQueryButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Post Query']")));

	       postQueryButton.click();

	       Thread.sleep(7000);
	}

	@Then("The user reaches the Discussion Forum tab")
	public void the_user_reaches_the_discussion_forum_tab() {
	}
//
	@When("The user navigates to the My Grade tab for projectdashboard")
	public void the_user_navigates_to_the_my_grade_tab_for_projectdashboard() throws InterruptedException {
		WebElement myTab = new WebDriverWait(driver, Duration.ofSeconds(30))
	               .until(ExpectedConditions.presenceOfElementLocated(By.id("v-pills-grades-tab")));

	       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", myTab);

	       try {
	           myTab.click();
	           
	       } catch (ElementClickInterceptedException e) {
	         
	           ((JavascriptExecutor) driver).executeScript("arguments[0].click();", myTab);
	       }
	   
	     


	       Thread.sleep(5000);
	}

	@Then("The user reaches the My Grade tab")
	public void the_user_reaches_the_my_grade_tab() {
	}

	@When("The user navigates to the Final Project tab for projectdashboard")
	public void the_user_navigates_to_the_final_project_tab_for_projectdashboard() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('v-pills-final-tab').removeAttribute('disabled');");

        WebElement finalTab = wait.until(ExpectedConditions.elementToBeClickable(By.id("v-pills-final-tab")));
        finalTab.click();
   

       
        WebElement linkTextarea = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='row mb-3'][1]//textarea[@class='form-control']")));
        linkTextarea.clear();
        linkTextarea.sendKeys("https://example.com/submission-link");
     

        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='row mb-3'][2]//input[@type='file']")));
        fileInput.sendKeys(System.getProperty("user.dir")+"\\files\\testing.pdf");


        WebElement descriptionTextarea = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='row mb-3'][3]//textarea[@class='form-control']")));
        descriptionTextarea.clear();
        descriptionTextarea.sendKeys("This is a sample submission description.");
       
        WebElement secondSubmitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Add Submission'])[2]")));
        secondSubmitButton.click();
        handleUnexpectedAlert();
     
        Thread.sleep(5000);
	}

	@Then("The user reaches the Final Project tab")
	public void the_user_reaches_the_final_project_tab() {
	}

	@When("The user navigates to the Viva Tab for projectdashboard")
	public void the_user_navigates_to_the_viva_tab_for_projectdashboard() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("document.getElementById('v-pills-viva-tab').removeAttribute('disabled');");
	       WebElement vivaTab = new WebDriverWait(driver, Duration.ofSeconds(30))
	               .until(ExpectedConditions.presenceOfElementLocated(By.id("v-pills-viva-tab")));

	       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", vivaTab);

	       try {
	           vivaTab.click();
	         
	       } catch (ElementClickInterceptedException e) {
	         
	           ((JavascriptExecutor) driver).executeScript("arguments[0].click();", vivaTab);
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

	@Then("The user reaches the Viva tab")
	public void the_user_reaches_the_viva_tab() {
	}
	
	@After
	public void tearDown() throws InterruptedException {
	Thread.sleep(10000);
	driver.quit();
	}

}
