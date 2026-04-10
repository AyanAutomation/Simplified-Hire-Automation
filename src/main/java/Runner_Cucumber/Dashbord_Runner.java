package Runner_Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= "src\\main\\java\\Cucumber\\Feature\\Access Dashboard.feature",
	    glue="Cucumber.Step.Definition.Java.Classes",
		monochrome=true,
		plugin= {"pretty","html:target/cucumber.html"}
		
		)




public class Dashbord_Runner extends AbstractTestNGCucumberTests{

}
