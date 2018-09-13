package cucumber.testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/cucumber/features",
		glue = "cucumber/stepDefinitions",//glue with the package name not the class file
		format = {"json:target/cucumber.json","html:target/site/cucumber-pretty"})
public class TestRunner {

}
