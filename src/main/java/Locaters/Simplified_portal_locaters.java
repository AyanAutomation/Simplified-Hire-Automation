package Locaters;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Repeatative_codes.Repeat;

public class Simplified_portal_locaters extends Repeat{
	


		@FindBy(xpath="//*[contains(@class,'cursor-pointer')]/../..")
		private List<WebElement> Apps;
		@FindBy(xpath="//*[contains(@class,'title-row')]//*[text()='Dashboard']")
		private WebElement Landed_in_Dashboard; 
		@FindBy(css="svg[role='img'] rect[role='presentation']")
		private WebElement Loader; /*
		@FindBy(xpath="")
		private WebElement  ; */
		
		public Simplified_portal_locaters(WebDriver d){
		super(d);	
		PageFactory.initElements(d, this);}
	
		
		public List<WebElement> Apps(){
		wait_for_theElement(Apps);
		return Apps;}
		public WebElement Landed_in_Dashboard(){
		wait_for_theElement(Landed_in_Dashboard);
		return Landed_in_Dashboard;} 
		public WebElement Loader(){
		wait_for_theElement(Loader);
		return Loader;} 

}
