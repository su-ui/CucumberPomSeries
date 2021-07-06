package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "./src/test/resources/com/features" }, 
glue = { "stepDefinitions", "AppHooks" }, 
//tags = "@All",
plugin = {"pretty", 
		"json:target/cucumber.json",
		
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"timeline:test-output-thread/"
		},
monochrome=true
//dryRun = true

)
public class MyTestRunner {

}
