package testRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"./src/test/resources/Features/Bold.feature",
				    "./src/test/resources/Features/MSWord.feature"}, 
		glue = "stepDefinitions", 
		plugin = { 
				"pretty", 
				"html:test-output.html"
				},
		monochrome = true
		)
public class TestRunner extends AbstractTestNGCucumberTests{}	