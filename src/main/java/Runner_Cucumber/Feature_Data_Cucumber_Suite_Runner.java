package Runner_Cucumber;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Listeners(Listerners.Report_Listen.class)
@CucumberOptions(
		features = "src\\main\\java\\Cucumber\\Feature",
		glue = "Cucumber.Step.Definition.Java.Classes",
		tags = "@BookDemo or @Candidate or @Job or @Member or @Reports or @SideMenu or @SaasAdmin",
		monochrome = true,
		plugin = {
				"pretty",
				"html:target/cucumber-feature-data-suite.html"
		}
)
public class Feature_Data_Cucumber_Suite_Runner
		extends AbstractTestNGCucumberTests {

}
