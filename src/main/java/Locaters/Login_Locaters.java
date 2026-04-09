package Locaters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Repeatative_codes.Repeat;

public class Login_Locaters extends Repeat{
	
	
	
	
	@FindBy(id="custom-email-id")
	private WebElement  id_field;
	@FindBy(id="password")
	private WebElement  password_field;
	@FindBy(xpath="//*[contains(@class,'ant-input-suffix')]//*[contains(@class,'anticon-eye')]")
	private WebElement  password_eye_button;
	@FindBy(xpath="//button[@type='Submit']")
	private WebElement  Login_button;
	@FindBy(xpath="")
	private WebElement  Success_toast;
	@FindBy(xpath="//div[@class='ant-alert-description']")
	private WebElement  Error_messages; 
	@FindBy(xpath="//h2[text()='Organization Sign In']")
	private WebElement  login_confirmation; 
	@FindBy(xpath="//*[text()='Welcome']")
	private WebElement  Landed_in_login_page;
	@FindBy(xpath="//*[contains(@title,'CodeClouds IT Solution')]/../../..")
	private WebElement Company_selection;
	@FindBy(xpath="//*[contains(@class,'logo justify-content')]")
	private WebElement login_confirmation_inside_company_portal;
	@FindBy(xpath="//span[@aria-label='loading' and contains(@class,'anticon-loading')]")
	private WebElement company_option_loader; 
	
	public Login_Locaters(WebDriver d){
	super(d);	
	PageFactory.initElements(d, this);}
	
 
	 
	public WebElement id_field(){
	wait_for_theElement(id_field);
	return id_field;}
	public WebElement password_field(){
	wait_for_theElement(password_field);
	return password_field;}
	public WebElement password_eye_button(){
	wait_for_theElement(password_eye_button);
	return password_eye_button;}
	public WebElement Login_button(){
	wait_for_theElement(Login_button);
	return Login_button;}
	public WebElement Success_toast(){
	wait_for_theElement(Success_toast);	
	return Success_toast;}
	public WebElement Error_messages(){
	wait_for_theElement(Error_messages);
	return Error_messages;} 
	public WebElement login_confirmation(){
	wait_for_theElement(login_confirmation);
	return login_confirmation;} 
	public WebElement Landed_in_login_page(){
	wait_for_theElement(Landed_in_login_page);
	return Landed_in_login_page;}
	public WebElement Company_selection(){
	wait_for_theElement(Company_selection);
	return Company_selection;}
	public WebElement login_confirmation_inside_company_portal(){
	wait_for_theElement(login_confirmation_inside_company_portal);
	return login_confirmation_inside_company_portal;} 
	public WebElement company_option_loader(){
	wait_for_theElement(company_option_loader);
	return company_option_loader;} 
	
	
	
	
}
