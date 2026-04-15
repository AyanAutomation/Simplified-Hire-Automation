package Locaters;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Repeatative_codes.Repeat;

public class Job_Module_locaters extends Repeat{
	
	
	
	
	@FindBy(xpath="//*[text()='New Job']/..")
	private WebElement Add_Job;
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
	private WebElement State_field_input; /*
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
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
	
	
	
	
	
	
	public Job_Module_locaters(WebDriver d){
	super(d);	
	PageFactory.initElements(d, this);}

	
	public WebElement Add_Job(){
	wait_for_theElement(Add_Job);
	return Add_Job;}
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
	List<WebElement> Ninth_dropdown_Options = eighth_dropdown_list().findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
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
	return State_field_input;}/*
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
