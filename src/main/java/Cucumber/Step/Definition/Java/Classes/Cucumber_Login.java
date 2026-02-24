package Cucumber.Step.Definition.Java.Classes;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Enterprise_Codeclouds.Project.Enterprise.Data_Reader;
import Locaters.Login_Locaters;
import io.cucumber.java.en.Given;

public class Cucumber_Login {

    @Given("Cucumber Postive login")	
    @Test
	public void login_by_cucumber() throws IOException{
    	
    WebDriver  d = Base_Cucumber.d;
    String url = Base_Cucumber.Target_url;
    Login_Locaters lg = new Login_Locaters(d);	
    Data_Fetcher_Cucumber f = new Data_Fetcher_Cucumber();
		
	d.get(url);
	lg.id_field().sendKeys(f.Data_Fetcher("Login_id",d));	
	lg.password_field().sendKeys(f.Data_Fetcher("Pass",d));	
	lg.password_eye_button().click();
	lg.Login_button().click();
	lg.login_confirmation();
		
		
		
		
		
	}
	
	
	
}
