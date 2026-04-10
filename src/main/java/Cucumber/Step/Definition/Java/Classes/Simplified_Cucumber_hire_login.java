package Cucumber.Step.Definition.Java.Classes;

import java.io.IOException;

import Product_Codeclouds.Project.Simplified.Simplified_hire_login;
import io.cucumber.java.en.Given;

public class Simplified_Cucumber_hire_login extends Simplified_hire_login{
	
	
	
	public void Bind_driver(){
		
		super.d= Base_Cucumber.D.get();
        super.Target_url=Base_Cucumber.Target_url;
		
		
	}
	@Given("Access Hire DashBoard")
	public void Simplified_Hire_Cucumber_Accessor() throws IOException, InterruptedException {
		
		Bind_driver();
		Simplified_Hire_Accessor();
		
		
		
		
	
	}
}
