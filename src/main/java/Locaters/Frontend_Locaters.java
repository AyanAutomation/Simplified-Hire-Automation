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
		private List <WebElement> New_Error_book_demo_form;
		@FindBy(xpath="//button[text()='Let’s Chat']")
		private WebElement  Lets_Chat_button;
		@FindBy(id="contactform7")
		private WebElement Contact_form;
		@FindBy(id="name")
		private WebElement Full_Name;
		@FindBy(id="email")
		private WebElement email;
		@FindBy(id="company")
		private WebElement company;
		@FindBy(id="message")
		private WebElement message;
		@FindBy(xpath="//button[@type='submit' and contains(@class,'contact_popup-module__')]")
		private WebElement SubmitButton; 
		@FindBy(xpath="//div[contains(@class,'contactform-success')]")
		private WebElement  Form_Submission_Success_Message; 
		@FindBy(xpath="//div[contains(@class,'contact_popup_spinner_border__KtU1Y')]")
		private WebElement Loading_spinner; 
		@FindBy(id="phone")
		private WebElement phone_number;
		@FindBy(xpath="//div[@class='ant-form-item-explain-error']")
		public WebElement Error_message; 
		@FindBy(xpath="//label[.//input[@id='privacy']]")
		private WebElement Privacy_checkbox;
		@FindBy(id="privacy")
		private WebElement Privacy_checkbox_input;
		@FindBy(xpath="//div[contains(@class,'cookies_main') and contains(@class,'animate')]//button[contains(@class,'acceptAll_btn')]")
		public WebElement Cookie_Accept_button;
		@FindBy(xpath="//div[contains(@id,'inquiryOption')]//label[contains(@class,'ant-checkbox-wrapper ant-checkbox-wrapper-')]")
		private List <WebElement> Inquiry_Options; 
		@FindBy(xpath="//div[contains(@class,'modal-content contact_popup-module__')]")
		private WebElement Poup_Modal;
		@FindBy(xpath="//form[contains(@class,'consult_form contact_modal_popupform salesBtn')]")
		private WebElement Bottom_form;
		@FindBy(xpath="//a[@href='/jobs/' and contains(@class,'btn Nav_nav_btn__')]")
		private WebElement Apply_Job_Header_Button;
		@FindBy(xpath="//*[contains(@class,'Apply_all_tags__')]")
		private WebElement Job_Type_tags_section;
		@FindBy(xpath="//h1[text()='Careers at CodeClouds']")
		private WebElement Landed_in_Jobs_page_confirmation;
		@FindBy(xpath="//div[contains(@class,'row d-none d-xl-flex')]")
		private WebElement  Job_Apply_Card_Table;
		@FindBy(xpath="//button[contains(@class,'Apply_load_more__')]")
		public WebElement Show_More_button;
		@FindBy(xpath="//select")
		private WebElement Select_Dropdown_Field;
		@FindBy(xpath="//div[contains(@class,'Apply_showing__')]")
		private WebElement Total_Job_Count_From_Listing_Summary;
		@FindBy(xpath = "//div[contains(@class,'contactform_success')]//p[contains(normalize-space(),'Thanks for contacting us')]")
        WebElement Contact_Form_Success_Message;/*
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
		return New_Error_book_demo_form;}
		public WebElement Lets_Chat_button(){
		wait_for_theElement(Lets_Chat_button);
		return Lets_Chat_button;}
		public WebElement Contact_form(){
		wait_for_theElement(Contact_form);
		return Contact_form;}
		public WebElement Full_Name(){
		wait_for_theElement(Full_Name);
		return Full_Name;}
		public WebElement email(){
		wait_for_theElement(email);
		return email;}
		public WebElement company(){
		wait_for_theElement(company);
		return company;}
		public WebElement message(){
		wait_for_theElement(message);
		return message;}
		public WebElement SubmitButton(){
		wait_for_theElement(SubmitButton);
		return SubmitButton;}
		public WebElement Form_Submission_Success_Message(){
		wait_for_theElement(Form_Submission_Success_Message);
		return Form_Submission_Success_Message;}
		public WebElement Loading_spinner(){
		wait_for_theElement(Loading_spinner);
		return Loading_spinner;}
		public WebElement phone_number(){
		wait_for_theElement(phone_number);
		return phone_number;}
		public WebElement Privacy_checkbox(){
		wait_for_theElement(Privacy_checkbox);
		return Privacy_checkbox;}
		public WebElement Privacy_checkbox_input(){
		wait_for_theElement(Privacy_checkbox_input);
		return Privacy_checkbox_input;}
		public List <WebElement> Inquiry_Options(){
		wait_for_theElement(Inquiry_Options);
		return Inquiry_Options;}
		public WebElement Poup_Modal(){
		wait_for_theElement(Poup_Modal);
		return Poup_Modal;}
		public WebElement Bottom_form(){
		wait_for_theElement(Bottom_form);
		return Bottom_form;}
		public WebElement Apply_Job_Header_Button(){
		wait_for_theElement(Apply_Job_Header_Button);
		return Apply_Job_Header_Button;} 
		public WebElement Job_Type_tags_section(){
		wait_for_theElement(Job_Type_tags_section);
		return Job_Type_tags_section;}
		public WebElement Landed_in_Jobs_page_confirmation(){
		wait_for_theElement(Landed_in_Jobs_page_confirmation);
		return Landed_in_Jobs_page_confirmation;}
		public WebElement Job_Apply_Card_Table(){
		wait_for_theElement(Job_Apply_Card_Table);
		return Job_Apply_Card_Table;}
		public WebElement Select_Dropdown_Field(){
		wait_for_theElement(Select_Dropdown_Field);
		return Select_Dropdown_Field;}
		public WebElement Total_Job_Count_From_Listing_Summary(){
		wait_for_theElement(Total_Job_Count_From_Listing_Summary);
		return Total_Job_Count_From_Listing_Summary;}
		public WebElement Contact_Form_Success_Message(){
		wait_for_theElement(Contact_Form_Success_Message);
		return Contact_Form_Success_Message;}/*
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
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
