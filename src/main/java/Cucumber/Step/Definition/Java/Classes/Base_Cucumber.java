package Cucumber.Step.Definition.Java.Classes;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Enterprise_Codeclouds.Project.Enterprise.Data_Reader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Cucumber {
	
	public static WebDriver d;
	public static String Target_url;
	
	
	@Before
	public void setup() throws IOException{
		
		Data_Fetcher_Cucumber f = new Data_Fetcher_Cucumber();
		
	String Browser = System.getProperty("Browsername")!=null ? System.getProperty("Browsername") : f.Data_Fetcher("Browser",d);	
	Target_url = System.getProperty("url")!=null ? System.getProperty("url"):f.Data_Fetcher("Url",d);
	
	if(Browser.equalsIgnoreCase("Chrome")){
		
		
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		d.manage().window().maximize();}
	
	if(Browser.equalsIgnoreCase("Firefox")){
		
		
		WebDriverManager.firefoxdriver().setup();
		d = new FirefoxDriver();
		d.manage().window().maximize();}}
	
	
	
	@After
	public void Kill(){
		
		if(d!=null){
			
			d.quit();}
	
	
	

}}
