package Locaters;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Repeatative_codes.Repeat;

public class Frontend_Locaters extends Repeat{

	
	
	
		@FindBy(xpath="//*[contains(@class,'me-xl-')]//a[contains(@class,'BorderButton_border')]")
		private WebElement  Book_a_demo_button_Banner; 
        @FindBy(xpath="//*[text()='What would you like a demo of?']")
		private WebElement Landed_in_Booking_form_page_confirmation;
		@FindBy(xpath="//*[contains(@class,'bookADemo_form_card__')]//form")
		private WebElement Form;  
		@FindBy(xpath="//button[@type='submit']")
		private WebElement Submit_button; 
		@FindBy(xpath="//*[contains(@class,'bookADemo_product_grid')]")
		private WebElement product_grid; 
		@FindBy(xpath="//div[@class='dropdown']")
		private WebElement Country_code_dropdown_field;
		@FindBy(xpath="//ul[contains(@class,'show phoneflag_drp')]")
		private WebElement dropdown_options_list; 
		@FindBy(xpath="//*[contains(@class,'acceptAll_btn')]")
		private WebElement Accept_cookies_button; 
		@FindBy(xpath="//*[contains(@class,'book_demo_success_message')]")
		private WebElement success_message;
		@FindBy(id="book_demo_error_message")
		private WebElement error_message;  
		@FindBy(xpath="//span[contains(@class,'bookADemo_custom_checkbox__')]")
		private List<WebElement> Product_check_boxes; 
		@FindBy(id="book_demo_error_message")
		private List <WebElement> New_Error_book_demo_form;/*
		@FindBy(xpath="")
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ; */
		
		public Frontend_Locaters(WebDriver d){
		super(d);	
		PageFactory.initElements(d, this);}
	
		
		public WebElement Book_a_demo_button_Banner(){
		wait_for_theElement(Book_a_demo_button_Banner);
		return Book_a_demo_button_Banner;}
		public WebElement Landed_in_Booking_form_page_confirmation(){
		wait_for_theElement(Landed_in_Booking_form_page_confirmation);
		return Landed_in_Booking_form_page_confirmation;} 
		public WebElement Form(){
		wait_for_theElement(Form);
		return Form;} 
		public List<WebElement> inputs (){
		List<WebElement> inputs = Form().findElements(By.xpath(".//input"));
		wait_for_theElement(inputs);
		return inputs;}
		public WebElement Textarea(){
		WebElement Textarea = Form().findElement(By.xpath(".//textarea[contains(@class,'bookADemo_form_textarea')]"));
		wait_for_theElement(Textarea);
		return Textarea;} 
		public WebElement Submit_button(){
		wait_for_theElement(Submit_button);
		return Submit_button;}
		public WebElement product_grid(){
		wait_for_theElement(product_grid);
		return product_grid;} 
		public List<WebElement> Product_cards(){
		List<WebElement> Product_cards = product_grid().findElements(By.xpath(".//label"));
		wait_for_theElement(Product_cards);
		return Product_cards;} 
		public WebElement Country_code_dropdown_field(){
		wait_for_theElement(Country_code_dropdown_field);
		return Country_code_dropdown_field;} 
		public WebElement dropdown_options_list(){
		wait_for_theElement(dropdown_options_list);
		return dropdown_options_list;} 
		public WebElement Accept_cookies_button(){
		wait_for_theElement(Accept_cookies_button);
		return Accept_cookies_button;} 
		public WebElement success_message(){
		wait_for_theElement(success_message);
		return success_message;} 
		public WebElement error_message(){
		wait_for_theElement(error_message);
		return error_message;}
		public List<WebElement> Product_check_boxes(){
		wait_for_theElement(Product_check_boxes);
		return Product_check_boxes;}
		public List <WebElement> New_Error_book_demo_form(){
		wait_for_theElement(New_Error_book_demo_form);
		return New_Error_book_demo_form;}/*
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;} */
	
}
