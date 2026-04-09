package Cucumber.Step.Definition.Java.Classes;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Product_Codeclouds.Project.Simplified.Data_Reader;
import Product_Codeclouds.Project.Simplified.Login;
import Locaters.Login_Locaters;
import io.cucumber.java.en.Given;

public class Cucumber_Login extends Login{
	
	
	public void BindDriver(){
		
		super.d= Base_Cucumber.d;
		super.Target_url= Base_Cucumber.Target_url;
		
	}

    @Given("Cucumber Postive login")	
    @Test
	public void login_by_cucumber() throws IOException{
    	
    	BindDriver();
    	login();
		
		
		
	}
	
	
	
}
