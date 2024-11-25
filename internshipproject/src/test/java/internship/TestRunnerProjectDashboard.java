package internship;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features= {"src/test/resources/features/projectdashboard.feature"},
glue= "stepdef",
plugin= {"pretty"}) // For viewing the result in a pretty way
public class TestRunnerProjectDashboard extends AbstractTestNGCucumberTests {

}