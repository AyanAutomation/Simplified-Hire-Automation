package Runner_Cucumber;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Listeners(Listerners.Report_Listen.class)
@CucumberOptions(
		features = "src\\main\\java\\Cucumber\\Feature\\Book A Demo.feature",
		glue = "Cucumber.Step.Definition.Java.Classes",
		monochrome = true,
		plugin = {
				"pretty",
				"html:target/cucumber-book-a-demo.html"
		}
)
public class Book_A_Demo_Runner
		extends AbstractTestNGCucumberTests {

}
