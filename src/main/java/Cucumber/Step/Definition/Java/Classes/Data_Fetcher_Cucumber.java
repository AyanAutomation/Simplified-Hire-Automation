package Cucumber.Step.Definition.Java.Classes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Data_Fetcher_Cucumber {

	public String Data_Fetcher(String Key,WebDriver d) throws IOException {
		FileInputStream f = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Data\\data.properties");
		
		Properties prop = new Properties();
		prop.load(f);
	    return prop.getProperty(Key);}
	
	
}
