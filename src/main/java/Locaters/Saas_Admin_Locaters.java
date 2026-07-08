package Locaters;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Repeatative_codes.Repeat;

public class Saas_Admin_Locaters extends Repeat{

	
	
	
	    @FindBy(xpath="//*[contains(@class,'ant-menu-vertical')]")
	    private WebElement Side_menu;
        @FindBy(xpath="//*[text()='What would you like a demo of?']")
		private WebElement Landed_in_Booking_form_page_confirmation;
		@FindBy(xpath="//*[contains(@class,'bookADemo_form_card__')]//form")
		private WebElement Form;  
		@FindBy(xpath="//button[@type='submit']")
		private WebElement Submit_button; 
		@FindBy(xpath="//h6")
		private List<WebElement> Labels;; 
		@FindBy(xpath="//div[@class='dropdown']")
		private WebElement Country_code_dropdown_field;
		@FindBy(xpath="//ul[contains(@class,'show phoneflag_drp')]")
		private WebElement dropdown_options_list; 
		@FindBy(xpath="//p[@class='font-14 text-secondary']")
		private List<WebElement> Values; 
		@FindBy(xpath="//*[contains(@class,'ant-dropdown-placement-bottomRight')]")
		private WebElement Actions_dropdown;
		@FindBy(xpath="//h2//*[text()='Leads']")
		private WebElement Landed_in_Leads_page_confirmation;  
		@FindBy(xpath="//span[contains(@class,'bookADemo_custom_checkbox__')]")
		private List<WebElement> Product_check_boxes; 
		@FindBy(id="search_search_input")
		private WebElement search_field; 
		@FindBy(xpath="//div[@class='text-right ']")
		private List<WebElement> List_threedots_button; 
		@FindBy(xpath="//*[local-name()='rect' and @role='presentation']")
		private WebElement Loader_element; 
		@FindBy(xpath="//*[text()='Approve ']/..")
		private WebElement  Leads_Approve_button; 
		@FindBy(xpath="//*[@role='tooltip']")
		private WebElement ToolTip;
		@FindBy(xpath="(//iframe[@title='reCAPTCHA'])[1]")
		private WebElement iframe;
        @FindBy(xpath="(//iframe[@title='reCAPTCHA'])[1]")
		private List<WebElement> iframe_list;
        @FindBy(xpath="//span[@id='recaptcha-anchor' and @role='checkbox']")
        private List<WebElement> Captcha_checkbox_list;
        @FindBy(xpath="//span[@id='recaptcha-anchor']//div[contains(@class,'recaptcha-checkbox-border')]")
        private List<WebElement> Captcha_checkbox_border_list;
		@FindBy(xpath="//*[contains(text(),'Form submitted successfully')]")
        private List<WebElement> success_message_list;
        @FindBy(xpath="//*[contains(@id,'error_message')]")
        private List<WebElement> error_message_list; 
        By captcha_normal_iframe_by = By.xpath("//iframe[@title='reCAPTCHA' and contains(@src,'size=normal')]");
        @FindBy(xpath="//iframe[@title='reCAPTCHA' and contains(@src,'size=normal')]")
        private List<WebElement> captcha_normal_iframe_list;
        @FindBy(xpath="//form//p[2]")
		private WebElement Section_below_submit_button; 
		@FindBy(xpath="//*[text()='Create Account']/..")
		private WebElement Create_Account_button; 
		@FindBy(xpath="//*[text()='Customer Information']/..")
		private WebElement Customer_Add_form;
		@FindBy(xpath="//*[@class='app-plan-tab']")
		private WebElement Plan_Tab; 
		@FindBy(id="select_plan_hr")
		private WebElement Hr_Plan_Input_feild; 
		@FindBy(id="select_plan_checkout")
		private WebElement Checkout_Plan_Input_feild;
		@FindBy(id="select_plan_hire")
		private WebElement Hire_Plan_Input_feild;
		@FindBy(id="select_plan_spaces")
		private WebElement Spaces_Plan_Input_feild;
		@FindBy(id="hr_number_of_users")
		private WebElement hr_number_of_users_input_field; 
		@FindBy(id="checkout_number_of_shared_instances")
		private WebElement checkout_number_of_shared_instances_input_field;
		@FindBy(id="hire_number_of_users")
		private WebElement hire_number_of_users_input_field;
		@FindBy(id="spaces_number_of_locations")
		private WebElement spaces_number_of_locations_input_field;
		@FindBy(xpath="(//*[text()='Save as Draft']/..)[2]")
		private WebElement Save_Draft_Button; 
		@FindBy(xpath="(//*[text()='Save & Invite']/..)[2]")
		private WebElement Save_Invite_Button; 
		@FindBy(id="company_country")
		private WebElement Country_input;
		@FindBy(xpath="//*[contains(@class,'ant-select-dropdown-placement-bottomLeft')]")
		private WebElement Country_dropdown; 
		@FindBy(xpath="//*[contains(@class,'ant-notification-notice notify-box')]")
		private WebElement Toast_message; 
		@FindBy(xpath="//*[contains(@class,'ant-notification-notice-close-x')]")
		private WebElement Toast_close_Button;
		@FindBy(xpath="//div[@class='text-truncate']")
		private List<WebElement> Truncated_data_in_list; 
		@FindBy(xpath="//tbody[contains(@class,'ant-table-tbody')]//tr[contains(@class,'ant-table-placeholder')]//*[local-name()='svg' and @role='img']")
		private List<WebElement> Loader; 
		@FindBy(xpath="//*[contains(@class,'d-block line-heigh-2')]")
		private WebElement Invite_link; 
		@FindBy(xpath="//*[contains(@class,'ant-modal-header')]/..")
		private WebElement pop_up_modal; 
		@FindBy(id="password")
		private WebElement password;
		@FindBy(id="confirm_password")
		private WebElement confirm_password; 
		@FindBy(xpath="//*[text()='Almost there…']")
		private WebElement Landed_in_Set_Password_page; 
		@FindBy(xpath="//button[@type='Submit']")
		private WebElement Submit_Button; 
		@FindBy(xpath="//form[contains(@class,'ant-form')]//div[@role='alert' and @data-show='true' and contains(@class,'ant-alert-success')]")
        private WebElement Account_Verified_Success_Message; 
		@FindBy(xpath="//*[text()='Account Manager']/../..//*[@class='ant-form-item-control-input']")
		private WebElement Account_manager_field; 
		@FindBy(id="assigned_to")
		private WebElement Account_Manager_input;
		@FindBy(xpath="//*[text()='Group']/../..//*[@class='ant-form-item-control-input']")
		private WebElement Group_Field;
		@FindBy(id="group_ids")
		private WebElement Group_input; 
		@FindBy(xpath="//*[@class='ant-select-dropdown ant-select-dropdown-placement-bottomLeft ']")
		private WebElement Account_Manager_Dropdown; 
		@FindBy(xpath="//textarea")
		private WebElement Text_Area_Field; 
		@FindBy(xpath="//*[text()='Actions']/../..")
		private WebElement  Action_button; 
		@FindBy(xpath="//h3[text()='Plans & Billing']/../..")
		private WebElement Billing_Tab; 
		@FindBy(xpath="//*[text()='View All']")
		private WebElement  view_all_button; 
		@FindBy(xpath="//div[@class='ant-dropdown ant-dropdown-placement-bottomLeft ']")
		private WebElement Plan_Dropdown; 
		@FindBy(xpath="//*[@class='d-flex flex-column']")
		private WebElement Leads_plan_Approver_section;
		@FindBy(xpath="(//*[@class='rc-virtual-list-holder'])[2]")
		private WebElement rc_virtual_list_holder_two;
	    @FindBy(xpath="(//*[@class='rc-virtual-list-holder'])[1]")
		private WebElement rc_virtual_list_holder_one;
		@FindBy(xpath="(//*[@class='rc-virtual-list-holder'])[3]")
		private WebElement rc_virtual_list_holder_three;
		@FindBy(xpath="(//*[@class='rc-virtual-list-holder'])[4]")
		private WebElement rc_virtual_list_holder_four; 
		@FindBy(xpath="//*[text()='Assign & Create Account']/..")
		private WebElement Assign_Create_Account_button; 
		@FindBy(xpath="//div[@role='alert']//div[@class='ant-notification-notice-description']")
		private WebElement Toast_; /*
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
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
		
		public Saas_Admin_Locaters(WebDriver d){
		super(d);	
		PageFactory.initElements(d, this);}
	
		
		public WebElement Side_menu(){
		wait_for_theElement(Side_menu);
		return Side_menu;}
		public List<WebElement> options(){
		List<WebElement> options = Side_menu().findElements(By.xpath(".//li[contains(@class,'ant-menu-item')]"));
		wait_for_theElement(options);
		return options;} 
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
		public List<WebElement> Labels(){
		wait_for_theElement(Labels);
		return Labels;} 
		public List<WebElement> values(){
		wait_for_theElement(Values);
		return Values;} 
		public WebElement Country_code_dropdown_field(){
		wait_for_theElement(Country_code_dropdown_field);
		return Country_code_dropdown_field;} 
		public WebElement dropdown_options_list(){
		wait_for_theElement(dropdown_options_list);
		return dropdown_options_list;} 
		public WebElement ToolTip(){
		wait_for_theElement(ToolTip);
		return ToolTip;} 
		public WebElement Actions_dropdown(){
		wait_for_theElement(Actions_dropdown);
		return Actions_dropdown;} 
		public WebElement Landed_in_Leads_page_confirmation(){
		wait_for_theElement(Landed_in_Leads_page_confirmation);
		return Landed_in_Leads_page_confirmation;}
		public WebElement Loader_element(){
		wait_for_theElement(Loader_element);
		return Loader_element;}
		public WebElement search_field(){
		wait_for_theElement(search_field);
		return search_field;} 
		public List<WebElement> List_threedots_button(){
		wait_for_theElement(List_threedots_button);
		return List_threedots_button;} 
		public List<WebElement> Action_menu_options(){
		List<WebElement> Action_menu_options = Actions_dropdown().findElements(By.xpath(".//li"));
		wait_for_theElement(Action_menu_options);
		return Action_menu_options;}
		public WebElement Leads_Approve_button(){
		wait_for_theElement(Leads_Approve_button);
		return Leads_Approve_button;}
		public WebElement iframe(){ 
		wait_for_theElement(iframe);
		return iframe;}
        public List<WebElement> iframe_list(){ 
		return iframe_list;}
		public List<WebElement> Captcha_checkbox_list(){
		wait_for_theElement(Captcha_checkbox_list);
		//wait_for_element_to_be_clickable(Captcha_checkbox);
		return Captcha_checkbox_list;}
		public List<WebElement> Captcha_checkbox_border_list() {
	    wait_for_theElement(Captcha_checkbox_border_list);
		//wait_for_element_to_be_clickable(Captcha_checkbox_border);
	    return Captcha_checkbox_border_list;}
		public List<WebElement> success_message_list(){
		wait_for_theElement(success_message_list);
	    return success_message_list;}
        public List<WebElement> error_message_list(){
        wait_for_theElement(error_message_list);
	    return error_message_list;}
        public List<WebElement> captcha_normal_iframe_list(){
        return wait_for_optional_list(captcha_normal_iframe_by, 3);
        } 
		public WebElement Section_below_submit_button(){
		wait_for_theElement(Section_below_submit_button);
		return Section_below_submit_button;} 
		public WebElement Create_Account_button(){
		wait_for_theElement(Create_Account_button);
		return Create_Account_button;}
		public WebElement Customer_Add_form(){
		wait_for_theElement(Customer_Add_form);
		return Customer_Add_form;}
		public List<WebElement> Customer_form_inputs(){
		List<WebElement> Customer_form_inputs = Customer_Add_form().findElements(By.xpath(".//input[@type='text']"));
		wait_for_theElement(Customer_form_inputs);
		return Customer_form_inputs;}
		public List<WebElement> Customer_form_dropdowns(){
		List<WebElement> Customer_form_dropdowns = Customer_Add_form().findElements(By.xpath(".//*[@class='ant-form-item-control-input']"));
		wait_for_theElement(Customer_form_dropdowns);
		return Customer_form_dropdowns;}
		public WebElement Plan_Tab(){
		wait_for_theElement(Plan_Tab);
		return Plan_Tab;}
		public List<WebElement> Plan_toggle_Buttons(){
		List<WebElement> Plan_toggle_Buttons = Plan_Tab().findElements(By.xpath(".//button"));
		wait_for_theElement(Plan_toggle_Buttons);
		return Plan_toggle_Buttons;}
		public List<WebElement> Plan_select_dropdowm(){
		List<WebElement> Plan_select_dropdowm = Plan_Tab().findElements(By.xpath(".//*[@class='ant-form-item-control-input']"));
		wait_for_theElement(Plan_select_dropdowm);
		return Plan_select_dropdowm;}
		public WebElement Hr_Plan_Input_feild(){
		wait_for_theElement(Hr_Plan_Input_feild);
		return Hr_Plan_Input_feild;} 
		public WebElement Checkout_Plan_Input_feild(){
		wait_for_theElement(Checkout_Plan_Input_feild);
		return Checkout_Plan_Input_feild;} 
		public WebElement Hire_Plan_Input_feild(){
		wait_for_theElement(Hire_Plan_Input_feild);
		return Hire_Plan_Input_feild;} 
		public WebElement Spaces_Plan_Input_feild(){
		wait_for_theElement(Spaces_Plan_Input_feild);
		return Spaces_Plan_Input_feild;} 
		public WebElement hr_number_of_users_input_field(){
		wait_for_theElement(hr_number_of_users_input_field);
		return hr_number_of_users_input_field;} 
		public WebElement checkout_number_of_shared_instances_input_field(){
		wait_for_theElement(checkout_number_of_shared_instances_input_field);
		return checkout_number_of_shared_instances_input_field;} 
		public WebElement hire_number_of_users_input_field(){
		wait_for_theElement(hire_number_of_users_input_field);
		return hire_number_of_users_input_field;} 
		public WebElement spaces_number_of_locations_input_field(){
		wait_for_theElement(spaces_number_of_locations_input_field);
		return spaces_number_of_locations_input_field;} 
		public WebElement Save_Draft_Button(){
		wait_for_theElement(Save_Draft_Button);
		return Save_Draft_Button;}
		public WebElement Country_input(){
		wait_for_theElement(Country_input);
		return Country_input;} 
		public WebElement Country_dropdown(){
		wait_for_theElement(Country_dropdown);
		return Country_dropdown;}
		public WebElement Toast_message(){
		wait_for_theElement(Toast_message);
		return Toast_message;} 
		public WebElement Toast_close_Button(){
		wait_for_theElement(Toast_close_Button);
		return Toast_close_Button;}  
		public WebElement Save_Invite_Button(){
		wait_for_theElement(Save_Invite_Button);
		return Save_Invite_Button;}
		public List<WebElement> Truncated_data_in_list(){
		wait_for_theElement(Truncated_data_in_list);
		return Truncated_data_in_list;} 
		public List<WebElement> Loader(){
		wait_for_theElement(Loader);
		return Loader;} 
		public WebElement Invite_link(){
		wait_for_theElement(Invite_link);
		return Invite_link;} 
		public WebElement pop_up_modal(){
		wait_for_theElement(pop_up_modal);
		return pop_up_modal;} 
		public WebElement password(){
		wait_for_theElement(password);
		return password;}
		public WebElement confirm_password(){
		wait_for_theElement(confirm_password);
		return confirm_password;} 
		public WebElement Landed_in_Set_Password_page(){
		wait_for_theElement(Landed_in_Set_Password_page);
		return Landed_in_Set_Password_page;}
		public WebElement Submit_Button(){
		wait_for_theElement(Submit_Button);
		return Submit_Button;}  
		public WebElement Account_Verified_Success_Message(){
		wait_for_theElement(Account_Verified_Success_Message);
		return Account_Verified_Success_Message;} 
		public WebElement Account_manager_field(){
		wait_for_theElement(Account_manager_field);
		return Account_manager_field;}
		public WebElement Account_Manager_input(){
		wait_for_theElement(Account_Manager_input);
		return Account_Manager_input;}
		public WebElement Group_Field(){
		wait_for_theElement(Group_Field);
		return Group_Field;}
		public WebElement Group_input(){
		wait_for_theElement(Group_input);
		return Group_input;} 
		public WebElement Account_Manager_Dropdown(){
		wait_for_theElement(Account_Manager_Dropdown);
		return Account_Manager_Dropdown;} 
		public WebElement Text_Area_Field(){
		wait_for_theElement(Text_Area_Field);
		return Text_Area_Field;} 
		public WebElement Action_button(){
		wait_for_theElement(Action_button);
		return Action_button;} 
		public WebElement Billing_Tab(){
		wait_for_theElement(Billing_Tab);
		return Billing_Tab;} 
		public WebElement view_all_button(){
		wait_for_theElement(view_all_button);
		return view_all_button;} 
		public WebElement Plan_Dropdown(){
		wait_for_theElement(Plan_Dropdown);
		return Plan_Dropdown;}
		public WebElement Leads_plan_Approver(){
		wait_for_theElement(Leads_plan_Approver_section);
		return Leads_plan_Approver_section;}
		public List<WebElement> Approve_Plan_toggle_Buttons(){
		List<WebElement> Approve_Plan_toggle_Buttons = Leads_plan_Approver().findElements(By.xpath(".//button"));
		wait_for_theElement(Approve_Plan_toggle_Buttons);
		return Approve_Plan_toggle_Buttons;}
		public List<WebElement> Leads_plan_select_dropdowm(){
		List<WebElement> Leads_plan_select_dropdowm = Leads_plan_Approver().findElements(By.xpath(".//*[text()='Select Plan']/../..//*[@class='ant-form-item-control-input']"));
		wait_for_theElement(Leads_plan_select_dropdowm);
		return Leads_plan_select_dropdowm;}
		public WebElement rc_virtual_list_holder_two(){
		wait_for_theElement(rc_virtual_list_holder_two);
		return rc_virtual_list_holder_two;}
		public WebElement rc_virtual_list_holder_one(){
		wait_for_theElement(rc_virtual_list_holder_one);
		return rc_virtual_list_holder_one;}
		public WebElement rc_virtual_list_holder_three(){
		wait_for_theElement(rc_virtual_list_holder_three);
		return rc_virtual_list_holder_three;}
		public WebElement rc_virtual_list_holder_four(){
		wait_for_theElement(rc_virtual_list_holder_four);
		return rc_virtual_list_holder_four;} 
		public WebElement Assign_Create_Account_button(){
		wait_for_theElement(Assign_Create_Account_button);
		return Assign_Create_Account_button;}
		public WebElement Toast_(){
		wait_for_theElement(Toast_);
		return Toast_;}/*
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
		return ;}
		public WebElement (){
		wait_for_theElement();
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
