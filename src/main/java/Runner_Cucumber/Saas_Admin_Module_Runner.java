package Runner_Cucumber;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Listeners(Listerners.Report_Listen.class)
@CucumberOptions(
		features = "src\\main\\java\\Cucumber\\Feature\\Saas Admin Module.feature",
		glue = "Cucumber.Step.Definition.Java.Classes",
		monochrome = true,
		plugin = {
				"pretty",
				"html:target/cucumber-saas-admin-module.html"
		}
)
public class Saas_Admin_Module_Runner
		extends AbstractTestNGCucumberTests {

}
