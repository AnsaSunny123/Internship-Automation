package internship;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features= {"src/test/resources/features/home.feature","src/test/resources/features/login.feature","src/test/resources/features/logout.feature","src/test/resources/features/projectdashboard.feature","src/test/resources/features/signup.feature","src/test/resources/features/studentdashboard.feature"},
glue= "stepdef",
plugin= {"pretty"}) // For viewing the result in a pretty way
public class TestRunnerComplete extends AbstractTestNGCucumberTests {

}