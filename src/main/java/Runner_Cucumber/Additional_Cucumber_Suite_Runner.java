package Runner_Cucumber;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Listeners(Listerners.Report_Listen.class)
@CucumberOptions(
		features = "src\\main\\java\\Cucumber\\Feature",
		glue = "Cucumber.Step.Definition.Java.Classes",
		tags = "@Job or @Member or @Reports or @SaasAdmin",
		monochrome = true,
		plugin = {
				"pretty",
				"html:target/cucumber-additional-suite.html"
		}
)
public class Additional_Cucumber_Suite_Runner extends AbstractTestNGCucumberTests {

}
