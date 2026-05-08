package Locaters;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Repeatative_codes.Repeat;

public class Member_Module_locaters extends Repeat{
	
	
	
	
	@FindBy(xpath="//*[contains(@class,'setting-menu-height')]")
	private WebElement Setting_internal_Menu;
	@FindBy(xpath="//*[text()='Add Member']/..")
	private WebElement Member_Add_Button;
	@FindBy(xpath="//form")
	private WebElement Form;
	@FindBy(xpath="//button[@type='button' and contains(@class,'ant-btn css')]")
	private List<WebElement> Buttons;
    @FindBy(xpath="(//a[text()='Today']/..)[2]")
	private WebElement Second_Today_Button_calendar; 
	@FindBy(xpath="(//*[contains(@class,'ant-select-dropdown css')])[1]")
	private WebElement First_dropdown_list;
	@FindBy(xpath="(//*[contains(@class,'rc-virtual-list-holder')])[4]")
	private WebElement Second_dropdown_list;
	@FindBy(xpath="(//*[contains(@class,'rc-virtual-list-holder')])[5]")
	private WebElement Third_dropdown_list;
	@FindBy(xpath="//div[@class='rc-virtual-list-holder-inner']")
	private WebElement List_holder_Inner; 
	@FindBy(xpath="//input[@id='category']")
	private WebElement Category_field;  
	@FindBy(xpath="//*[text()='Yes']/..") 
	private WebElement Yes_button;
	@FindBy(xpath="(//*[contains(@class,'rc-virtual-list-holder')])[7]")
	private WebElement Fourth_dropdown_list;
	@FindBy(xpath="//input[@id='required_education']")
	private WebElement Required_education_input_field;
	@FindBy(xpath="(//*[contains(@class,'rc-virtual-list-holder')])[9]")
	private WebElement Fifth_dropdown_list;
	@FindBy(xpath="(//*[contains(@class,'rc-virtual-list-holder')])[11]")
	private WebElement  Sixth_dropdown_list;
	@FindBy(xpath="(//*[contains(@class,'rc-virtual-list-holder')])[13]")
	private WebElement Seventh_dropdown_list;
	@FindBy(xpath="(//*[contains(@class,'rc-virtual-list-holder')])[15]")
	private WebElement  eighth_dropdown_list;
	@FindBy(xpath="(//*[contains(@class,'rc-virtual-list-holder')])[17]")
	private WebElement  Ninth_dropdown_list;
	@FindBy(xpath="(//div[@class='ant-form-item-control-input-content'])[4]")
	private WebElement Job_title_field;
	@FindBy(xpath="(//table)[1]")
	private WebElement Calendar_table; 
	@FindBy(xpath="//input[@id='vacancy']")
	private WebElement Vacancy_field_input; 
    @FindBy(xpath="//input[@id='city_1']")
	private WebElement State_field_input; 
	@FindBy(xpath="//input[@id='department']")
	private WebElement department_field_input; 
	@FindBy(xpath="//div[@class='border rounded p-20 pl-24 pr-24 accordion-bg']")
	private List<WebElement> Question_blocks; 
	@FindBy(xpath="//*[@placeholder='Type your question...']")
	private List<WebElement> Question_input_fields;
	@FindBy(xpath="//*[text()='Add']/..")
	private WebElement ADD_button;
	@FindBy(xpath="//*[@type='checkbox']/..")
	private List<WebElement> checkboxes;
	@FindBy(xpath="(//*[text()='Save & Continue']/..)[2]")
	private WebElement save_and_continue_button;
	@FindBy(xpath="//*[text()='Create Job']/..")
	private WebElement  Create_Job_button;
	@FindBy(xpath="//*[text()='The job was created successfully!']/..")
	private WebElement Job_Creation_success_message;
	@FindBy(xpath="//h3[text()='Workflow']")
	private WebElement Landed_on_Workflow_page; 
	@FindBy(xpath="//div[contains(@class,'ant-notification-notice') and contains(@class,'ant-notification-notice-error') and contains(@class,'notify-box')]")
	private WebElement Error_toast_message;
	@FindBy(xpath="//*[text()='Back']/..")
	private WebElement Back_button; 
	@FindBy(xpath="//*[contains(@placeholder,'Search')]")
	private WebElement search_field;
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement Search_field_input;
	@FindBy(css="svg[role='img']:nth-of-type(1)")
	private WebElement List_loader;
	@FindBy(xpath="//*[contains(@aria-label,'more')]")
	private List<WebElement> Three_dots_buttons;
	@FindBy(xpath="//*[contains(@class,'ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light')]")
	private WebElement three_dots_dropdown_menu;
	@FindBy(xpath="//*[@role='dialog']")
	private WebElement popup;
	@FindBy(xpath="//a[@aria-label='Close']")
	private WebElement Toast_close_button;
	@FindBy(xpath="(//*[contains(@class,'ant-row justify-content-between')])[1]")
	private WebElement top_row_of_the_page;
	@FindBy(xpath="//h3[contains(@class,'main-heading-color font-')]")
	private WebElement Result_card_heading;
    private By questionfields = By.xpath("//div[@class='border rounded p-20 pl-24 pr-24 accordion-bg']"); 
	@FindBy(xpath="//*[text()='Owner']") 
	private WebElement Landed_on_create_job_page; /*
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;*/
	
	
	
	
	
	
	public Member_Module_locaters(WebDriver d){
	super(d);	
	PageFactory.initElements(d, this);}

	
	public WebElement Setting_internal_Menu(){
	wait_for_theElement(Setting_internal_Menu);
	return Setting_internal_Menu;}
	public WebElement Form(){
	wait_for_theElement(Form);
	return Form;}
	public List<WebElement> Form_inputs() {
	List<WebElement> Form_inputs = Form().findElements(By.xpath(".//input[@type='text' or @class='ant-select-selection-item' or @placeholder='Select date']"));
	wait_for_theElement(Form_inputs);
	return Form_inputs;}
	public List<WebElement> Form_General_Dropdown_fields() {
	List<WebElement> Form_General_Dropdown_fields = Form().findElements(By.xpath(".//*[contains(@class,'ant-select-selection-item')]"));
	wait_for_theElement(Form_General_Dropdown_fields);
	return Form_General_Dropdown_fields;} 
	public List<WebElement> Form_Custom_Dropdown_fields() {
	List<WebElement> Form_Custom_Dropdown_fields = Form().findElements(By.xpath(".//span[@class='ant-select-selection-placeholder']/../../.."));
	wait_for_theElement(Form_Custom_Dropdown_fields);
	return Form_Custom_Dropdown_fields;}
	public List<WebElement> Form_Description_fields() {
	List<WebElement> Form_Description_fields = Form().findElements(By.xpath(".//div[contains(@class,'ck ck-content ck-editor__editable') and @aria-label='Editor editing area: main. Press Alt+0 for help.' and @role='textbox']"));
	wait_for_theElement(Form_Description_fields);
	return Form_Description_fields;}
	public List<WebElement> Buttons() {
    wait_for_theElement(Buttons);
	return Buttons;}
	public WebElement Second_Today_Button_calendar(){
	wait_for_theElement(Second_Today_Button_calendar);
	return Second_Today_Button_calendar;} 
	public WebElement First_dropdown_list(){
	wait_for_theElement(First_dropdown_list);
	return First_dropdown_list;}
	public List<WebElement> First_dropdown_Options(){
	List<WebElement> First_dropdown_Options = First_dropdown_list().findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
	wait_for_theElement(First_dropdown_Options);
	return First_dropdown_Options;}
	public WebElement Second_dropdown_list(){
	wait_for_theElement(Second_dropdown_list);
	return Second_dropdown_list;}
	public List<WebElement> Second_dropdown_Options(){
	WebElement panel=Second_dropdown_list();
	List<WebElement> Second_dropdown_Options=wait_for_nested(panel,By.xpath(".//div[contains(@class,'ant-select-item') and contains(@class,'ant-select-item-option') and @title]"));
	return Second_dropdown_Options;}
	public WebElement List_holder_Inner(){
	wait_for_theElement(List_holder_Inner);
	return List_holder_Inner;}
	public WebElement Third_dropdown_list(){
	wait_for_theElement(Third_dropdown_list);
	return Third_dropdown_list;} 
	public List<WebElement> Third_dropdown_Options(){
	List<WebElement> Third_dropdown_Options = Third_dropdown_list().findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
	wait_for_theElement(Third_dropdown_Options);
	return Third_dropdown_Options;}
	public WebElement Fourth_dropdown_list(){
	wait_for_theElement(Fourth_dropdown_list);
	return Fourth_dropdown_list;} 
	public List<WebElement> Fourth_dropdown_Options(){
	List<WebElement> Fourth_dropdown_Options = Fourth_dropdown_list().findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
	wait_for_theElement(Fourth_dropdown_Options);
	return Fourth_dropdown_Options;}
	public WebElement Category_field(){
	wait_for_theElement(Category_field);
	return Category_field;}
	public WebElement Yes_button(){
	wait_for_theElement(Yes_button);
	return Yes_button;}
	public WebElement Required_education_input_field(){
	wait_for_theElement(Required_education_input_field);
	return Required_education_input_field;} 
	public WebElement Fifth_dropdown_list(){
	wait_for_theElement(Fifth_dropdown_list);
	return Fifth_dropdown_list;} 
	public List<WebElement> Fifth_dropdown_Options(){
	List<WebElement> Fifth_dropdown_Options = Fifth_dropdown_list().findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
	wait_for_theElement(Fifth_dropdown_Options);
	return Fifth_dropdown_Options;}
	public WebElement Sixth_dropdown_list(){
	wait_for_theElement(Sixth_dropdown_list);
	return Sixth_dropdown_list;} 
	public List<WebElement> Sixth_dropdown_Options(){
	List<WebElement> Sixth_dropdown_Options = Sixth_dropdown_list().findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
	wait_for_theElement(Sixth_dropdown_Options);
	return Sixth_dropdown_Options;}
	public WebElement Seventh_dropdown_list(){
	wait_for_theElement(Seventh_dropdown_list);
	return Seventh_dropdown_list;} 
	public List<WebElement> Seventh_dropdown_Options(){
	List<WebElement> Seventh_dropdown_Options = Seventh_dropdown_list().findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
	wait_for_theElement(Seventh_dropdown_Options);
	return Seventh_dropdown_Options;}
	public WebElement eighth_dropdown_list(){
	wait_for_theElement(eighth_dropdown_list);
	return eighth_dropdown_list;} 
	public List<WebElement> eighth_dropdown_Options(){
	List<WebElement> eighth_dropdown_Options = eighth_dropdown_list().findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
	wait_for_theElement(eighth_dropdown_Options);
	return eighth_dropdown_Options;}
	public WebElement Ninth_dropdown_list(){
	wait_for_theElement(Ninth_dropdown_list);
	return Ninth_dropdown_list;} 
	public List<WebElement> Ninth_dropdown_Options(){
	List<WebElement> Ninth_dropdown_Options = Ninth_dropdown_list().findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
	wait_for_theElement(Ninth_dropdown_Options);
	return Ninth_dropdown_Options;}
	public WebElement Job_title_field(){
	wait_for_theElement(Job_title_field);
	return Job_title_field;}
	public WebElement JobExpiry_Calendar_table(){
	wait_for_theElement(Calendar_table);
	return Calendar_table;}
	public List<WebElement> Job_Expiry_unselected_dates_in_calender(){
	List<WebElement> Job_Expiry_unselected_dates_in_calender = JobExpiry_Calendar_table().findElements(By.xpath(".//td[@class='ant-picker-cell ant-picker-cell-in-view']"));
	wait_for_theElement(Job_Expiry_unselected_dates_in_calender);
	return Job_Expiry_unselected_dates_in_calender;} 
	public WebElement Number_of_Positions() {
	WebElement Number_of_Positions = Form().findElement(By.xpath(".//div[@class='ant-input-number-input-wrap']/../../.."));
	wait_for_theElement(Number_of_Positions);
	return Number_of_Positions;} 
	public WebElement Vacancy_field_input(){
	wait_for_theElement(Vacancy_field_input);
	return Vacancy_field_input;}
	public WebElement State_field_input(){
	wait_for_theElement(State_field_input);
	return State_field_input;}
	public WebElement department_field_input(){
	wait_for_theElement(department_field_input);
	return department_field_input;} 
	public List<WebElement> Question_blocks(){
	List<By> locatorList = Arrays.asList(questionfields);
    return wait_for_presence_of_theElement(locatorList);} 
	public List<WebElement> Question_input_fields(){
	wait_for_theElement(Question_input_fields);
	return Question_input_fields;}
	public WebElement ADD_button(){
	wait_for_theElement(ADD_button);
	return ADD_button;}
	public List<WebElement> checkboxes(){
	wait_for_theElement(checkboxes);
	return checkboxes;} 
	public WebElement save_and_continue_button(){
	wait_for_theElement(save_and_continue_button);
	return save_and_continue_button;} 
	public WebElement Create_Job_button(){
	wait_for_theElement(Create_Job_button);
	return Create_Job_button;}
	public WebElement Job_Creation_success_message(){
	wait_for_theElement(Job_Creation_success_message);
	return Job_Creation_success_message;}  
	public WebElement Landed_on_Workflow_page(){
	wait_for_theElement(Landed_on_Workflow_page);
	return Landed_on_Workflow_page;}
	public WebElement Error_toast_message(){
	wait_for_theElement(Error_toast_message);
	return Error_toast_message;} 
	public WebElement Back_button(){
	wait_for_theElement(Back_button);
	return Back_button;}  
	public WebElement search_field(){
	wait_for_theElement(search_field);
	return search_field;}
	public WebElement Search_field_input(){
	wait_for_theElement(Search_field_input);
	return Search_field_input;}
	public WebElement List_loader(){
	wait_for_theElement(List_loader);
	return List_loader;} 
	public List<WebElement> Three_dots_buttons(){
	wait_for_theElement(Three_dots_buttons);
	return Three_dots_buttons;}
	public WebElement three_dots_dropdown_menu(){
	wait_for_theElement(three_dots_dropdown_menu);
	return three_dots_dropdown_menu;}
	public List<WebElement> list_dropdowm_options(){
	List<WebElement> list_dropdowm_options = three_dots_dropdown_menu().findElements(By.xpath(".//*[contains(@class,'item-only-child')]//button"));
	wait_for_theElement(list_dropdowm_options);
	return list_dropdowm_options;} 
	public WebElement popup(){
	wait_for_theElement(popup);
	return popup;}
	public WebElement Delete_input(){
	WebElement Delete_input = popup().findElement(By.xpath(".//*[contains(@class,'ant-input-outlined')]"));
	wait_for_theElement(Delete_input);
	return Delete_input;}
	public WebElement Bold_text_in_popup(){
	WebElement Bold_text_in_popup = popup().findElement(By.xpath(".//strong"));
	wait_for_theElement(Bold_text_in_popup);
	return Bold_text_in_popup;} 
	public WebElement pop_up_delete_button(){
	WebElement pop_up_delete_button = popup().findElement(By.xpath(".//*[text()='Delete']/.."));
	wait_for_theElement(pop_up_delete_button);
	return pop_up_delete_button;}
	public WebElement Toast_close_button(){
	wait_for_theElement(Toast_close_button);
	return Toast_close_button;}
	public WebElement top_row_of_the_page(){
	wait_for_theElement(top_row_of_the_page);
	return top_row_of_the_page;} 
	public WebElement Result_card_heading(){
	wait_for_theElement(Result_card_heading);
	return Result_card_heading;}
	public WebElement Member_Add_Button(){
	wait_for_theElement(Member_Add_Button);
	return Member_Add_Button;} /*
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}  */

}
