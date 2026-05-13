package Locaters;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Repeatative_codes.Repeat;

public class Candidate_Module_Locaters extends Repeat{
	
	
	
	
	@FindBy(xpath="//*[text()='Import CV']/..")
	private WebElement Import_Cv_Button;
	@FindBy(xpath="//*[text()='Import CV/Resume']")
	private WebElement Landed_in_CV_Upload_form;
	private By Upload_Field = By.xpath("//span[contains(@class,'add_candidate_cv')]//input[@type='file']");
	@FindBy(xpath="//div[contains(@class,'ant-row imported_cv_row')]")
	private WebElement Parsing_cv;
    @FindBy(xpath="//*[contains(@class,'justify-content-between')]//button[1]")
	private WebElement Add_Button; 
	@FindBy(xpath="//div[contains(@class,'ant-modal-body')]")
	private WebElement  Pop_up_form;
	@FindBy(xpath="//div[contains(@class,'ant-modal-content')]//button[contains(@class,'ant-btn-primary')]")
	private WebElement Modal_Save_Button; 
	@FindBy(xpath="//div[contains(@class,'ant-modal-content')]//button[contains(@class,'ant-modal-close')]")
	private WebElement Popup_Close_Button; 
	@FindBy(id="job")
	private WebElement Assign_job_input;
	private By form_scroll = By.xpath("(//*[contains(@class,'overflow-scroll overflow-x-scroll-hidden custom-scrollbar')])[1]");
	@FindBy(id="owner")
	private WebElement Owner_input;
	@FindBy(id="recruiter")
	private WebElement recruiter_input;
	@FindBy(id="source")
	private WebElement source_input;
	@FindBy(xpath="(//*[contains(@class,'rc-virtual-list-holder')])[1]")
	private WebElement Owner_Dropdown;
	@FindBy(xpath="(//*[contains(@class,'rc-virtual-list-holder')])[5]")
	private WebElement Owner_Dropdown_backup;
	@FindBy(xpath="(//*[contains(@class,'rc-virtual-list-holder')])[4]")
	private WebElement recruiter_Dropdown;
	@FindBy(xpath="(//*[contains(@class,'rc-virtual-list-holder')])[7]")
	private WebElement recruiter_Dropdown_backup;
	@FindBy(xpath="//div[contains(@class,'ant-notification-notice') and contains(@class,'ant-notification-notice-success')]")
	private WebElement Success_Toast_Message;
	@FindBy(xpath="(//div[contains(@class,'ant-modal-body')]//div[contains(@class,'ant-select-show-search')])[9]")
	private WebElement Ownerfield;
	@FindBy(xpath="(//div[contains(@class,'ant-modal-body')]//div[contains(@class,'ant-select-show-search')])[3]")
	private WebElement Sourcefield;
	@FindBy(xpath="(//div[contains(@class,'ant-modal-body')]//div[contains(@class,'ant-select-show-search')])[10]")
	private WebElement recruiterfield;
	@FindBy(xpath="(//*[contains(@class,'rc-virtual-list-holder')])[3]")
	private WebElement state_Dropdown;
	@FindBy(xpath="(//div[contains(@class,'ant-modal-body')]//div[contains(@class,'ant-select-show-search')])[5]")
	private WebElement State_field;
	@FindBy(xpath="//*[contains(@class,'ant-select-selector')]//input[@id='state' and @type='search']")
	private WebElement State_input;
	private By List_scroll_bar = By.xpath("//div[contains(@class,'rc-virtual-list-scrollbar-thumb')]");
	private By List_scroller = By.xpath("//div[contains(@class,'rc-virtual-list-scrollbar-vertical')]"); 
	@FindBy(xpath="//*[text()='Rows per page:']/..//div[contains(@class,'ant-select-selector')]")
	private WebElement pagination_box; 
	@FindBy(xpath="(//*[contains(@title,'Click to fetch exact count')])")
	private WebElement Exact_count_icon; 
	@FindBy(xpath="//button[contains(@class,'advance-search-btn')]")
	private WebElement Advance_search_button;
	@FindBy(xpath="//div[contains(@class,'talentpool-table-header')]//div[contains(@class,'ant-select-selector')]")
	private List<WebElement> Candidate_List_Filter_Dropdowns;
	@FindBy(xpath="//div[contains(@class,'ant-select-dropdown-placement-bottomLeft')]")
	private WebElement stages_Dropdown;
	@FindBy(xpath="//tbody")
	private WebElement table_body;
	@FindBy(xpath="//*[contains(@class,'pagination-right')]//span")
	private List<WebElement> pagination_count_text;
	@FindBy(xpath="//tbody//tr[contains(@class,'ant-table-row ant-table-row-level-0')]//td[@class='ant-table-cell'][1]")
	private List<WebElement> candidate_names_in_list;
	@FindBy(xpath="//div[@class='ant-tabs-nav-list']")
	private WebElement Tabs_list;
	@FindBy(xpath="//div[contains(@class,' custom-select select_aslink')]//div")
	private WebElement Application_status_Dropdown;
	@FindBy(xpath="(//*[text()='Schedule Interview']/..)[1]")
	private WebElement schedule_interview_button;
	@FindBy(id="endTime")
	private WebElement endTime_input;
	@FindBy(xpath="//*[contains(@class,'ant-radio-wrapper')]")
	private List<WebElement> radio_options;
	@FindBy(id="link")
	private WebElement link_input;
	@FindBy(xpath="(//div[contains(@class,'ant-modal-body')]//div[@class='ant-form-item-control-input'])[8]")
	private WebElement Meeting_link_dropdown_Field;
	@FindBy(id="interviewHost")
	private WebElement interviewHost_input;
	@FindBy(xpath="//*[text()=' Notify ']/..")
	private WebElement notify_button;/*
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
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
	
	public Candidate_Module_Locaters(WebDriver d){
	super(d);	
	PageFactory.initElements(d, this);}

	
	public WebElement Import_Cv_Button(){
	wait_for_theElement(Import_Cv_Button);
	return Import_Cv_Button;}
	public WebElement Landed_in_CV_Upload_form(){
	wait_for_theElement(Landed_in_CV_Upload_form);
	return Landed_in_CV_Upload_form;}
	public WebElement Upload_Field() {
	return wait_for_presence_of_theElement(Upload_Field);}
	public WebElement Parsing_cv(){
	wait_for_theElement(Parsing_cv);
	return Parsing_cv;} 
	public WebElement Add_Button(){
	wait_for_theElement(Add_Button);
	return Add_Button;}
	public WebElement Pop_up_form(){
	wait_for_theElement(Pop_up_form);
	return Pop_up_form;}
	public List<WebElement> Pop_Up_Form_Custom_Dropdown_fields(){
	List<WebElement> Pop_Up_Form_Custom_Dropdown_fields = Pop_up_form().findElements(By.xpath(".//span[@class='ant-select-selection-placeholder' or @class='ant-select-selection-item']/../../.."));
	wait_for_theElement(Pop_Up_Form_Custom_Dropdown_fields);
	return Pop_Up_Form_Custom_Dropdown_fields;}
	public List<WebElement> name_ph_email_input_fieldsBox(){
	return wait_for_nested( Pop_up_form(), By.xpath(".//input[@id='email' or @id='phoneNumber' or @id='firstName' or @id='lastName' or @id='relevantExperience' or @id='totalExperience' or @id='noticePeriod']/../.."));}
	public WebElement Modal_Save_Button(){
	wait_for_theElement(Modal_Save_Button);
	return Modal_Save_Button;} 
	public List<WebElement> name_ph_email_input_fields(){
	return wait_for_nested(Pop_up_form(), By.xpath(".//input[@id='email' or @id='phoneNumber' or @id='firstName' or @id='lastName' or @id='relevantExperience' or @id='totalExperience' or @id='noticePeriod']"));}
	public WebElement Assign_job_input(){
	wait_for_theElement(Assign_job_input);
	return Assign_job_input;}
	public WebElement Pop_Up_close_Button(){
	wait_for_theElement(Popup_Close_Button);
	movetoelement(Popup_Close_Button);
	return Popup_Close_Button;}
	public WebElement form_scroll(){
	return 	wait_for_presence_of_theElement(form_scroll);} 
	public WebElement Owner_input(){
	wait_for_theElement(Owner_input);
	return Owner_input;}
	public WebElement recruiter_input(){
	wait_for_theElement(recruiter_input);
	return recruiter_input;} 
	public WebElement Owner_Dropdown_backup(){
	wait_for_theElement(Owner_Dropdown_backup);
	return Owner_Dropdown_backup;}
	public WebElement Owner_Dropdown(){
	try{wait_for_theElement(Owner_Dropdown_backup);
	return Owner_Dropdown_backup;}
	catch(Exception e){
	wait_for_theElement(Owner_Dropdown);
	return Owner_Dropdown;}}
	public WebElement recruiter_Dropdown_backup(){
	wait_for_theElement(recruiter_Dropdown_backup);
	return recruiter_Dropdown_backup;}
	public WebElement recruiter_Dropdown(){try{
	wait_for_theElement(recruiter_Dropdown_backup);
	return recruiter_Dropdown_backup;}
	catch(Exception ejo){
	wait_for_theElement(recruiter_Dropdown);
	return	recruiter_Dropdown;}}
	public List<WebElement> OwnerOptions(){
	List<WebElement> OwnerOptions = Owner_Dropdown().findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
	wait_for_theElement(OwnerOptions);
	return OwnerOptions;}
	public List<WebElement> RecruiterOptions(){
	List<WebElement> RecruiterOptions = recruiter_Dropdown().findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
	wait_for_theElement(RecruiterOptions);
	return RecruiterOptions;}
	public WebElement Success_Toast_Message(){
	wait_for_theElement(Success_Toast_Message);
	return Success_Toast_Message;}
	public WebElement Ownerfield(){
	wait_for_theElement(Ownerfield);
	return Ownerfield;}
	public WebElement recruiterfield(){
	wait_for_theElement(recruiterfield);
	return recruiterfield;} 
	public WebElement state_Dropdown(){
	wait_for_theElement(state_Dropdown);
	return state_Dropdown;}
	public List<WebElement> state_Dropdown_options(){
	List<WebElement> stateOptions = Owner_Dropdown().findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
	wait_for_theElement(stateOptions);
	return stateOptions;} 
	public WebElement State_field(){
	wait_for_theElement(State_field);
	return State_field;} 
	public WebElement State_input(){
	wait_for_theElement(State_input);
	return State_input;}
	public WebElement List_scroll_bar(){
	WebElement scroll_bar = wait_for_presence_of_theElement(List_scroll_bar);
	movetoelement(scroll_bar);
	return scroll_bar;}
	public WebElement List_scroller(){
	return wait_for_presence_of_theElement(List_scroller);} 
	public WebElement Selected_option(){
	WebElement Selected_option= State_field().findElement(By.xpath(".//span[@class='ant-select-selection-item']"));
	wait_for_theElement(Selected_option);
	return Selected_option;}
	public WebElement pagination_box(){
	wait_for_theElement(pagination_box);
	return pagination_box;}
	public WebElement Exact_count_icon(){
	wait_for_theElement(Exact_count_icon);
	return Exact_count_icon;}
	public List<WebElement> Candidate_List_Filter_Dropdowns(){
	wait_for_theElement(Candidate_List_Filter_Dropdowns);
	return Candidate_List_Filter_Dropdowns;}
	public WebElement Advance_search_button(){
	wait_for_theElement(Advance_search_button);
	return Advance_search_button;}
	public WebElement stages_Dropdown(){
	wait_for_theElement(stages_Dropdown);
	return stages_Dropdown;}
	public WebElement table_body(){
	wait_for_theElement(table_body);
	return table_body;}
	public List<WebElement> pagination_count_text(){
	wait_for_theElement(pagination_count_text);
	return pagination_count_text;}
	public WebElement Sourcefield(){
	wait_for_theElement(Sourcefield);
	return Sourcefield;}
	public WebElement source_input(){
	wait_for_theElement(source_input);
	return source_input;} 
	public WebElement Source_Dropdown(){
	wait_for_theElement(Owner_Dropdown);
	return Owner_Dropdown;}
	public List<WebElement> candidate_names_in_list(){
	wait_for_theElement(candidate_names_in_list);
	return candidate_names_in_list;} 
	public WebElement Tabs_list(){
	wait_for_theElement(Tabs_list);
	return Tabs_list;}
	public List<WebElement> Tab_Buttons(){
	List<WebElement> Tab_Buttons = Tabs_list().findElements(By.xpath(".//div//div"));
	wait_for_theElement(Tab_Buttons);
	return Tab_Buttons;}
	public WebElement Application_status_Dropdown(){
	wait_for_theElement(Application_status_Dropdown);
	return Application_status_Dropdown;}
	public WebElement schedule_interview_button(){
	wait_for_theElement(schedule_interview_button);
	return schedule_interview_button;}
	public WebElement endTime_input(){
	wait_for_theElement(endTime_input);
	return endTime_input;}
	public List<WebElement> radio_options(){
	wait_for_theElement(radio_options);
	return radio_options;}
	public WebElement link_input(){
	wait_for_theElement(link_input);
	return link_input;}
	public WebElement Meeting_link_dropdown_Field(){
	wait_for_theElement(Meeting_link_dropdown_Field);
	return Meeting_link_dropdown_Field;}
	public WebElement interviewHost_input(){
	wait_for_theElement(interviewHost_input);
	return interviewHost_input;} 
	public WebElement notify_button(){
	wait_for_theElement(notify_button);
	return notify_button;}/*
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
