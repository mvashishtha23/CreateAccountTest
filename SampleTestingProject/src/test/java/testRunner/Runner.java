package testRunner;

	import io.cucumber.testng.CucumberOptions;
	import io.cucumber.testng.AbstractTestNGCucumberTests;

	@CucumberOptions(
	    features = ".//features/accountRegistration.feature",
	    glue = "stepsDefinition",
	    plugin = {"pretty", "html:target/cucumber-reports.html"},
	    monochrome = true
	)
	public class Runner extends AbstractTestNGCucumberTests {}
