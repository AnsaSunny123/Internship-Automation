package internship;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features= {"src/test/resources/features/logout.feature"},
glue= "stepdef",
plugin= {"pretty"}) // For viewing the result in a pretty way
public class TestRunnerLogOut extends AbstractTestNGCucumberTests {

}