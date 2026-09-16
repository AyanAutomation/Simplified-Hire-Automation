package Runner_Cucumber;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Listeners(Listerners.Report_Listen.class)
@CucumberOptions(
		features = "src\\main\\java\\Cucumber\\Feature\\Side Menu.feature",
		glue = "Cucumber.Step.Definition.Java.Classes",
		monochrome = true,
		plugin = {
				"pretty",
				"html:target/cucumber-side-menu.html"
		}
)
public class Side_Menu_Runner
		extends AbstractTestNGCucumberTests {

}
