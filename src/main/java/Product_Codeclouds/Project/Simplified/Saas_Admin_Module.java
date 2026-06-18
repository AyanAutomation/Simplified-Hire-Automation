package Product_Codeclouds.Project.Simplified;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Candidate_Module_Locaters;
import Locaters.Login_Locaters;
import Locaters.Saas_Admin_Locaters;
import Repeatative_codes.Repeat;

@Listeners(Listerners.Report_Listen.class)
public class Saas_Admin_Module extends Base{


	public void Saas_Admin_Login() throws IOException, InterruptedException {
		
		int step = 1;
		
		Login_Locaters lg = new Login_Locaters(d);
		Data_Reader f = new Data_Reader();
	    Repeat rp = new Repeat(d);
	    
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🔹 Scenario Title:</b> Login with valid configured credentials and enter company portal");
	    System.out.println();
	    System.out.println("🔹 Scenario Title: Login with valid configured credentials and enter company portal");
	    System.out.println();

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>📘 Description:</b> Open the application URL, wait until login page is loaded, enter configured credentials, verify password visibility interaction, click Login button, and validate successful entry into the company portal either through company selection flow or direct landing flow.");
	    System.out.println("📘 Description: Open the application URL, wait until login page is loaded, enter configured credentials, verify password visibility interaction, click Login button, and validate successful entry into the company portal either through company selection flow or direct landing flow.");
	    System.out.println();

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>📥 Input:</b> Target URL = " + Target_url
	                    + " | Login ID = " + f.Data_Fetcher("Login_id")
	                    + " | Password = " + f.Data_Fetcher("Pass"));
	    System.out.println("📥 Input: Target URL = " + Target_url
	            + " | Login ID = " + f.Data_Fetcher("Login_id")
	            + " | Password = " + f.Data_Fetcher("Pass"));
	    System.out.println();

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>✅ Expected:</b> Application should open successfully, login page should load properly, credentials should be accepted, password eye icon should be clickable, login should succeed, and user should enter the company portal either through company selection or direct landing.");
	    System.out.println("✅ Expected: Application should open successfully, login page should load properly, credentials should be accepted, password eye icon should be clickable, login should succeed, and user should enter the company portal either through company selection or direct landing.");
	    System.out.println();

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Open target application URL and wait until login page is loaded.");
	    System.out.println("Step " + (step - 1) + ": Open target application URL and wait until login page is loaded.");
	    System.out.println();

	    d.get(Target_url);

	    try {
	        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(d)
	                .withTimeout(Duration.ofSeconds(120))
	                .pollingEvery(Duration.ofMillis(500))
	                .ignoring(NoSuchElementException.class)
	                .ignoring(StaleElementReferenceException.class);

	        wait.until(driver -> {
	            lg.Landed_in_login_page();
	            return true;
	        });

	    } catch (Exception e) {

	        Report_Listen.log_print_in_report().log(Status.WARNING,
	                "<b>⚠ Retry:</b> Initial wait for login page load failed. Retrying the same operation again.");
	        System.out.println("⚠ Retry: Initial wait for login page load failed. Retrying the same operation again.");
	        System.out.println();

	        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(d)
	                .withTimeout(Duration.ofSeconds(120))
	                .pollingEvery(Duration.ofMillis(500))
	                .ignoring(NoSuchElementException.class)
	                .ignoring(StaleElementReferenceException.class);

	        wait.until(driver -> {
	            lg.Landed_in_login_page();
	            return true;
	        });
	    }

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🟨 Actual:</b> Application URL opened successfully and login page loaded = " + Target_url);
	    System.out.println("🟨 Actual: Application URL opened successfully and login page loaded = " + Target_url);
	    System.out.println();

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Enter Login ID into the login field.");
	    System.out.println("Step " + (step - 1) + ": Enter Login ID into the login field.");
	    System.out.println();

	    try {
	        WebElement id_field_initial = lg.id_field();
	        rp.movetoelement(id_field_initial);
	        id_field_initial.click();
	        Thread.sleep(800);
	        id_field_initial.sendKeys(f.Data_Fetcher("Admin_Login_id"));

	    } catch (StaleElementReferenceException e) {

	        Report_Listen.log_print_in_report().log(Status.WARNING,
	                "<b>⚠ Retry:</b> Login ID field became stale. Refetching the element and retrying the operation.");
	        System.out.println("⚠ Retry: Login ID field became stale. Refetching the element and retrying the operation.");
	        System.out.println();

	        WebElement id_field_refetched = lg.id_field();
	        rp.movetoelement(id_field_refetched);
	        id_field_refetched.click();
	        id_field_refetched.sendKeys(f.Data_Fetcher("Admin_Login_id"));
	    }

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🟨 Actual:</b> Login ID entered successfully = " + f.Data_Fetcher("Admin_Login_id"));
	    System.out.println("🟨 Actual: Login ID entered successfully = " + f.Data_Fetcher("Admin_Login_id"));
	    System.out.println();

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Enter Password into the password field.");
	    System.out.println("Step " + (step - 1) + ": Enter Password into the password field.");
	    System.out.println();

	    lg.password_field().sendKeys(f.Data_Fetcher("Admin_Pass"));

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🟨 Actual:</b> Password entered successfully.");
	    System.out.println("🟨 Actual: Password entered successfully.");
	    System.out.println();

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Click password eye icon to verify password visibility functionality.");
	    System.out.println("Step " + (step - 1) + ": Click password eye icon to verify password visibility functionality.");
	    System.out.println();

	    lg.password_eye_button().click();

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🟨 Actual:</b> Password eye icon clicked successfully.");
	    System.out.println("🟨 Actual: Password eye icon clicked successfully.");
	    System.out.println();

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Click on Login button.");
	    System.out.println("Step " + (step - 1) + ": Click on Login button.");
	    System.out.println();

	    lg.Login_button().click();

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🟨 Actual:</b> Login button clicked successfully.");
	    System.out.println("🟨 Actual: Login button clicked successfully.");
	    System.out.println();

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Validate post-login flow and enter the company portal.");
	    System.out.println("Step " + (step - 1) + ": Validate post-login flow and enter the company portal.");
	    System.out.println();

	    try {

	        Report_Listen.log_print_in_report().log(Status.INFO,
	                "<b>Step " + (step++) + ":</b> Validate whether the user was directly redirected inside the company portal.");
	        System.out.println("Step " + (step - 1) + ": Validate whether the user was directly redirected inside the company portal.");
	        System.out.println();
	        FluentWait<WebDriver> wit = new FluentWait<WebDriver>(d)
	                .withTimeout(Duration.ofSeconds(120))
	                .pollingEvery(Duration.ofMillis(500))
	                .ignoring(NoSuchElementException.class)
	                .ignoring(StaleElementReferenceException.class);
	        wit.until(driver -> {
	        	lg.login_confirmation_inside_company_portal();
	            return true;
	        });
	   
	        

	        Report_Listen.log_print_in_report().log(Status.PASS,
	                "<b>🟨 Actual:</b> User was directly redirected and entered successfully inside the company portal without needing company selection.");
	        System.out.println("🟨 Actual: User was directly redirected and entered successfully inside the company portal without needing company selection.");
	        System.out.println();

	    } catch (Exception e) {

	        Report_Listen.log_print_in_report().log(Status.WARNING,
	                "<b>⚠ Fallback:</b> Direct company portal landing was not detected. Proceeding with company selection flow.");
	        System.out.println("⚠ Fallback: Direct company portal landing was not detected. Proceeding with company selection flow.");
	        System.out.println();

	        Report_Listen.log_print_in_report().log(Status.INFO,
	                "<b>Step " + (step++) + ":</b> Validate initial login confirmation and confirm that company selection flow is available.");
	        System.out.println("Step " + (step - 1) + ": Validate initial login confirmation and confirm that company selection flow is available.");
	        System.out.println();

	        lg.login_confirmation();

	        Report_Listen.log_print_in_report().log(Status.INFO,
	                "<b>🟨 Actual:</b> Initial login confirmation validated successfully. Company selection flow is available.");
	        System.out.println("🟨 Actual: Initial login confirmation validated successfully. Company selection flow is available.");
	        System.out.println();

	        Report_Listen.log_print_in_report().log(Status.INFO,
	                "<b>Step " + (step++) + ":</b> Identify company option from the company selection screen and move to it.");
	        System.out.println("Step " + (step - 1) + ": Identify company option from the company selection screen and move to it.");
	        System.out.println();}}
	
	
	public void Saas_Admin_Menu_navigation(String opt_text) throws IOException, InterruptedException {

	    
		Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
	   
		try {
			p.Side_menu();
		} catch (Exception mm) {
			Saas_Admin_Login();
			p.Side_menu();
		}
		List<WebElement> menu_options = p.options();
		boolean option_clicked = menu_options.stream().filter(menuop -> menuop.getText().trim().equalsIgnoreCase(opt_text))
				.findFirst().map(menuop -> {
					menuop.click();
					return true;
				}).orElse(false);

		if (option_clicked) {
			Report_Listen.log_print_in_report().log(Status.PASS,
					"<b>🟨 Actual:</b> Side menu option clicked successfully = " + opt_text);
			System.out.println("🟨 Actual: Side menu option clicked successfully = " + opt_text);
			System.out.println();
		}

		if (!option_clicked) {
			Report_Listen.log_print_in_report().log(Status.FAIL,
					"<b>❌ Actual:</b> Required side menu option was not found = " + opt_text);
			System.out.println("❌ Actual: Required side menu option was not found = " + opt_text);
			System.out.println();
		}
	}
	
	
	public void Lead_Module_Accessor() throws IOException, InterruptedException {

		Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
		
		Saas_Admin_Menu_navigation("Leads");
		p.Landed_in_Leads_page_confirmation();
		
		
}
	
	
	
	
	public void list_threedot_dropdown_option_selector(String option) throws InterruptedException {

		Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
		Repeat rp = new Repeat(d);
		
		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step:</b> Click on 3 dot button of the first lead in the list to view dropdown options.");
		System.out.println("Step: Click on 3 dot button of the first lead in the list to view dropdown options.");
		System.out.println();
		List<WebElement> Three_dot_Button= p.List_threedots_button();
		Three_dot_Button.get(0).click();
		List<WebElement> Dropdown_Options = p.Action_menu_options();
		for (WebElement ele : Dropdown_Options) {

			String text = ele.getText().trim();

			System.out.println("Dropdown option found = " + text);

			if (text.equalsIgnoreCase(option)) {

				rp.movetoelement(ele);
				ele.click();

				Report_Listen.log_print_in_report().log(Status.INFO,
						"<b>🟨 Actual:</b> Dropdown option selected successfully = " + text);
				System.out.println("🟨 Actual: Dropdown option selected successfully = " + text);
				System.out.println();

				break;}}


	}

	@Test(dataProvider="Account_Create_Data")
public void Account_Create(TreeMap<String, String> account_data) throws IOException, InterruptedException{

	String First_Name = account_data.get("First Name");
	String Middle_Name = account_data.get("Middle Name");
	String Last_Name = account_data.get("Last Name");
	String Company_Name = account_data.get("Company Name");
	String Country = account_data.get("Country");
	String Email = account_data.get("Email");
	String Subscribe_News = account_data.get("Subscribe News");
	String Country_Code = account_data.get("Country Code");
	String Phone_Number = account_data.get("Phone Number");

	String App_Name = account_data.get("App Name");
	String App_Enabled = account_data.get("App Enabled");
	String Plan_Name = account_data.get("Plan Name");
	String Users = account_data.get("Users");

	String Group = account_data.get("Group");
	String Account_Manager = account_data.get("Account Manager");

	String Staff_Notes = account_data.get("Staff Notes");

	boolean Subscribe_News_Status = Subscribe_News.equalsIgnoreCase("Yes");
	boolean App_Enabled_Status = App_Enabled.equalsIgnoreCase("Yes");

	Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
	Repeat rp = new Repeat(d);
	JavascriptExecutor js = (JavascriptExecutor) d;
	Candidate_Module_Locaters ca = new Candidate_Module_Locaters(d);

	int step = 1;

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🔹 Scenario Title:</b> Validate SaaS Admin Account creation with HR plan assignment.");
	System.out.println("🔹 Scenario Title: Validate SaaS Admin Account creation with HR plan assignment.");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📘 Description:</b> Login into SaaS Admin, open Create Account form, enter account holder details, select country, fill contact information, enable HR plan, select HR plan, enter number of users, save as draft, and validate toast message.");
	System.out.println("📘 Description: Login into SaaS Admin, open Create Account form, enter account holder details, select country, fill contact information, enable HR plan, select HR plan, enter number of users, save as draft, and validate toast message.");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📥 Input:</b> Name = " + First_Name + " " + Middle_Name + " " + Last_Name + " | Company = " + Company_Name + " | Country = " + Country + " | Email = " + Email + " | Country Code = " + Country_Code + " | Phone Number = " + Phone_Number + " | App Name = " + App_Name + " | App Enabled = " + App_Enabled + " | Plan Name = " + Plan_Name + " | Users = " + Users + " | Group = " + Group + " | Account Manager = " + Account_Manager);
	System.out.println("📥 Input: Name = " + First_Name + " " + Middle_Name + " " + Last_Name + " | Company = " + Company_Name + " | Country = " + Country + " | Email = " + Email + " | Country Code = " + Country_Code + " | Phone Number = " + Phone_Number + " | App Name = " + App_Name + " | App Enabled = " + App_Enabled + " | Plan Name = " + Plan_Name + " | Users = " + Users + " | Group = " + Group + " | Account Manager = " + Account_Manager);

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>✅ Expected:</b> Admin should be able to create/save the account draft successfully with selected HR plan and entered user count. Proper confirmation toast should be displayed.");
	System.out.println("✅ Expected: Admin should be able to create/save the account draft successfully with selected HR plan and entered user count. Proper confirmation toast should be displayed.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Login into SaaS Admin portal.");
	System.out.println("Step " + (step - 1) + ": Login into SaaS Admin portal.");
	Saas_Admin_Login();
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> SaaS Admin login completed successfully.");
	System.out.println("🟨 Actual: SaaS Admin login completed successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Click Create Account button.");
	System.out.println("Step " + (step - 1) + ": Click Create Account button.");
	WebElement Create_Button = p.Create_Account_button();
	Create_Button.click();
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Create Account button clicked successfully.");
	System.out.println("🟨 Actual: Create Account button clicked successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Fetch account form input fields and dropdown fields.");
	System.out.println("Step " + (step - 1) + ": Fetch account form input fields and dropdown fields.");
	List<WebElement> input = p.Customer_form_inputs();
	List<WebElement> dropdowns = p.Customer_form_dropdowns();
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Account form fields fetched successfully. Input count = " + input.size() + " | Dropdown count = " + dropdowns.size());
	System.out.println("🟨 Actual: Account form fields fetched successfully. Input count = " + input.size() + " | Dropdown count = " + dropdowns.size());
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Fill account holder name and company details.");
	System.out.println("Step " + (step - 1) + ": Fill account holder name and company details.");
	input.get(0).sendKeys(First_Name);
	input.get(1).sendKeys(Middle_Name);
	input.get(2).sendKeys(Last_Name);
	input.get(3).sendKeys(Company_Name);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Name and company details entered successfully. Name = " + First_Name + " " + Middle_Name + " " + Last_Name + " | Company = " + Company_Name);
	System.out.println("🟨 Actual: Name and company details entered successfully. Name = " + First_Name + " " + Middle_Name + " " + Last_Name + " | Company = " + Company_Name);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Select country from country dropdown. Country = " + Country);
	System.out.println("Step " + (step - 1) + ": Select country from country dropdown. Country = " + Country);
	WebElement Country_dropdown_field=dropdowns.get(4);
	Country_dropdown_field.click();
	p.Country_input().sendKeys(Country);
	WebElement country_list=p.Country_dropdown();
	List<WebElement> country_options = country_list.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> Country dropdown option count = " + country_options.size());
	System.out.println("🟨 Debug: Country dropdown option count = " + country_options.size());
	country_options.get(0).click();
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Country selected successfully = " + Country);
	System.out.println("🟨 Actual: Country selected successfully = " + Country);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Fill email and phone number details.");
	System.out.println("Step " + (step - 1) + ": Fill email and phone number details.");
	input.get(4).sendKeys(Email);
	input.get(5).sendKeys(Phone_Number);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Contact details entered successfully. Email = " + Email + " | Phone Number = " + Phone_Number);
	System.out.println("🟨 Actual: Contact details entered successfully. Email = " + Email + " | Phone Number = " + Phone_Number);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Navigate to Plan section.");
	System.out.println("Step " + (step - 1) + ": Navigate to Plan section.");
	WebElement Plan_Tab = p.Plan_Tab();
	rp.Scroll_to_element(Plan_Tab);
	js.executeScript("window.scrollBy(0, -180);");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Plan section reached successfully.");
	System.out.println("🟨 Actual: Plan section reached successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Enable HR plan toggle.");
	System.out.println("Step " + (step - 1) + ": Enable HR plan toggle.");
	List<WebElement> Plan_Toggles = p.Plan_toggle_Buttons();
	WebElement HR_swicth = Plan_Toggles.get(0);
	HR_swicth.click();
	Thread.sleep(800);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> HR plan toggle clicked successfully. App Enabled data = " + App_Enabled + " | Boolean Status = " + App_Enabled_Status);
	System.out.println("🟨 Actual: HR plan toggle clicked successfully. App Enabled data = " + App_Enabled + " | Boolean Status = " + App_Enabled_Status);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Open HR plan dropdown and search plan. Plan Name = " + Plan_Name);
	System.out.println("Step " + (step - 1) + ": Open HR plan dropdown and search plan. Plan Name = " + Plan_Name);
	List<WebElement> Plan_Select = p.Plan_select_dropdowm();
	WebElement Hr_Plan_select_field = Plan_Select.get(0);
	rp.movetoelement(Hr_Plan_select_field);
	Hr_Plan_select_field.click();
	p.Hr_Plan_Input_feild().sendKeys(Plan_Name);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> HR plan name entered in plan search field = " + Plan_Name);
	System.out.println("🟨 Actual: HR plan name entered in plan search field = " + Plan_Name);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Select searched HR plan from dropdown list.");
	System.out.println("Step " + (step - 1) + ": Select searched HR plan from dropdown list.");
	WebElement Owner_dropdown_list = d.findElement(By.xpath("(//*[contains(@class,'rc-virtual-list-holder')])[3]"));
	rp.wait_for_theElement(Owner_dropdown_list);
	Thread.sleep(800);
	rp.movetoelement(Owner_dropdown_list);
	List<WebElement> hr_plan_options= Owner_dropdown_list.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));;
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> HR plan option count after search = " + hr_plan_options.size());
	System.out.println("🟨 Debug: HR plan option count after search = " + hr_plan_options.size());
	hr_plan_options.get(0).click();
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> HR plan selected successfully = " + Plan_Name);
	System.out.println("🟨 Actual: HR plan selected successfully = " + Plan_Name);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Enter number of users for selected HR plan. Users = " + Users);
	System.out.println("Step " + (step - 1) + ": Enter number of users for selected HR plan. Users = " + Users);
	p.hr_number_of_users_input_field().sendKeys(Users);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Number of users entered successfully = " + Users);
	System.out.println("🟨 Actual: Number of users entered successfully = " + Users);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Click Save Draft button.");
	System.out.println("Step " + (step - 1) + ": Click Save Draft button.");
	WebElement Save_draft_Button_Below =p.Save_Draft_Button();
	rp.Scroll_to_element(Save_draft_Button_Below);
	Save_draft_Button_Below.click();
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Save Draft button clicked successfully.");
	System.out.println("🟨 Actual: Save Draft button clicked successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Capture toast message after saving account draft.");
	System.out.println("Step " + (step - 1) + ": Capture toast message after saving account draft.");
	WebElement Toast = p.Toast_message();
	String Toast_text = Toast.getText().trim();
	Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Account draft save action completed. Toast message = " + Toast_text);
	System.out.println("✅ Actual: Account draft save action completed. Toast message = " + Toast_text);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Close toast message and validate Create Account button is available again.");
	System.out.println("Step " + (step - 1) + ": Close toast message and validate Create Account button is available again.");
	p.Toast_close_Button().click();
	p.Create_Account_button();
	Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Final Result:</b> Account creation draft flow completed successfully for company = " + Company_Name + " | Plan = " + Plan_Name + " | Users = " + Users);
	System.out.println("✅ Final Result: Account creation draft flow completed successfully for company = " + Company_Name + " | Plan = " + Plan_Name + " | Users = " + Users);
	System.out.println();
}
	
@DataProvider
public Object[][] Account_Create_Data() {

	TreeMap<String, String> data1 = new TreeMap<String, String>();
	data1.put("First Name", "Julian");
	data1.put("Middle Name", "Theodor");
	data1.put("Last Name", "Bachmann");
	data1.put("Company Name", "Bachmann Employee Operations GmbH");
	data1.put("Country", "Germany");
	data1.put("Email", "julian.theodor.bachmann.hr016@yopmail.com");
	data1.put("Subscribe News", "Yes");
	data1.put("Country Code", "+49");
	data1.put("Phone Number", "15972846310");
	data1.put("App Name", "Simplified HR");
	data1.put("App Enabled", "Yes");
	data1.put("Plan Name", "Ayan HR New Weekly Plan");
	data1.put("Users", "14");
	data1.put("Group", "Germany Weekly HR Group");
	data1.put("Account Manager", "Admin Ayan Sengupta");
	data1.put("Staff Notes", "Creating this Germany-based HR account to validate weekly plan assignment, mandatory users field input, customer contact details, newsletter subscription, and internal account manager mapping.");

	TreeMap<String, String> data2 = new TreeMap<String, String>();
	data2.put("First Name", "Camille");
	data2.put("Middle Name", "Antoinette");
	data2.put("Last Name", "Dubois");
	data2.put("Company Name", "Dubois People Advisory SAS");
	data2.put("Country", "France");
	data2.put("Email", "camille.antoinette.dubois.hr017@yopmail.com");
	data2.put("Subscribe News", "No");
	data2.put("Country Code", "+33");
	data2.put("Phone Number", "769284135");
	data2.put("App Name", "Simplified HR");
	data2.put("App Enabled", "Yes");
	data2.put("Plan Name", "Ayan Daily HR Starter Plan");
	data2.put("Users", "9");
	data2.put("Group", "France Starter HR Group");
	data2.put("Account Manager", "Admin Ayan Sengupta");
	data2.put("Staff Notes", "Testing France-based customer account creation with daily HR starter plan, users field value, newsletter disabled, customer information entry, and staff notes save behavior.");

	TreeMap<String, String> data3 = new TreeMap<String, String>();
	data3.put("First Name", "Magnus");
	data3.put("Middle Name", "Kristian");
	data3.put("Last Name", "Eriksen");
	data3.put("Company Name", "Eriksen Workforce Services AS");
	data3.put("Country", "Norway");
	data3.put("Email", "magnus.kristian.eriksen.hr018@yopmail.com");
	data3.put("Subscribe News", "Yes");
	data3.put("Country Code", "+47");
	data3.put("Phone Number", "48926371");
	data3.put("App Name", "Simplified HR");
	data3.put("App Enabled", "Yes");
	data3.put("Plan Name", "Ayan Weekly HR Growth Plan");
	data3.put("Users", "19");
	data3.put("Group", "Norway Growth HR Group");
	data3.put("Account Manager", "Admin Ayan Sengupta");
	data3.put("Staff Notes", "Validating Norway-based account creation using weekly HR growth plan with unique phone number, user count, newsletter subscription, internal group, and account manager selection.");

	TreeMap<String, String> data4 = new TreeMap<String, String>();
	data4.put("First Name", "Alessandro");
	data4.put("Middle Name", "Vittorio");
	data4.put("Last Name", "Marchetti");
	data4.put("Company Name", "Marchetti Corporate People SRL");
	data4.put("Country", "Italy");
	data4.put("Email", "alessandro.vittorio.marchetti.hr019@yopmail.com");
	data4.put("Subscribe News", "No");
	data4.put("Country Code", "+39");
	data4.put("Phone Number", "3486729154");
	data4.put("App Name", "Simplified HR");
	data4.put("App Enabled", "Yes");
	data4.put("Plan Name", "Ayan Monthly HR Business Plan");
	data4.put("Users", "24");
	data4.put("Group", "Italy Monthly HR Group");
	data4.put("Account Manager", "Admin Ayan Sengupta");
	data4.put("Staff Notes", "Creating this Italy-based customer account to verify monthly HR business plan selection, users value entry, customer details, internal group mapping, and staff note capture.");

	TreeMap<String, String> data5 = new TreeMap<String, String>();
	data5.put("First Name", "Arthur");
	data5.put("Middle Name", "William Edward");
	data5.put("Last Name", "Pembroke");
	data5.put("Company Name", "Pembroke HR Management Ltd");
	data5.put("Country", "United Kingdom");
	data5.put("Email", "arthur.william.pembroke.hr020@yopmail.com");
	data5.put("Subscribe News", "Yes");
	data5.put("Country Code", "+44");
	data5.put("Phone Number", "7428193657");
	data5.put("App Name", "Simplified HR");
	data5.put("App Enabled", "Yes");
	data5.put("Plan Name", "Ayan Yearly HR Enterprise Plan");
	data5.put("Users", "38");
	data5.put("Group", "UK Enterprise HR Group");
	data5.put("Account Manager", "Admin Ayan Sengupta");
	data5.put("Staff Notes", "Testing UK-based enterprise account creation with yearly HR plan, large user count, newsletter subscription enabled, complete customer profile details, and internal staff note validation.");

	TreeMap<String, String> data6 = new TreeMap<String, String>();
	data6.put("First Name", "Isabelle");
	data6.put("Middle Name", "Marie Claire");
	data6.put("Last Name", "Laurent");
	data6.put("Company Name", "Laurent Employee Services SAS");
	data6.put("Country", "France");
	data6.put("Email", "isabelle.marie.laurent.hr021@yopmail.com");
	data6.put("Subscribe News", "No");
	data6.put("Country Code", "+33");
	data6.put("Phone Number", "718294635");
	data6.put("App Name", "Simplified HR");
	data6.put("App Enabled", "Yes");
	data6.put("Plan Name", "Ayan Custom Days HR Flex Plan");
	data6.put("Users", "17");
	data6.put("Group", "France Custom HR Group");
	data6.put("Account Manager", "Admin Ayan Sengupta");
	data6.put("Staff Notes", "Creating this France-based account to verify custom days HR plan assignment, mandatory users field, newsletter unchecked state, country code selection, and staff notes entry.");

	TreeMap<String, String> data7 = new TreeMap<String, String>();
	data7.put("First Name", "Florian");
	data7.put("Middle Name", "Matthias");
	data7.put("Last Name", "Steinberger");
	data7.put("Company Name", "Steinberger Business Operations GmbH");
	data7.put("Country", "Austria");
	data7.put("Email", "florian.matthias.steinberger.hr022@yopmail.com");
	data7.put("Subscribe News", "Yes");
	data7.put("Country Code", "+43");
	data7.put("Phone Number", "6763918247");
	data7.put("App Name", "Simplified HR");
	data7.put("App Enabled", "Yes");
	data7.put("Plan Name", "Ayan HR New Weekly Plan");
	data7.put("Users", "28");
	data7.put("Group", "Austria Weekly HR Group");
	data7.put("Account Manager", "Admin Ayan Sengupta");
	data7.put("Staff Notes", "Testing Austria-based account creation with weekly HR plan, unique European customer details, users input field, newsletter selection, internal group assignment, and account manager mapping.");

	TreeMap<String, String> data8 = new TreeMap<String, String>();
	data8.put("First Name", "Magdalena");
	data8.put("Middle Name", "Zofia");
	data8.put("Last Name", "Kowalczyk");
	data8.put("Company Name", "Kowalczyk People Systems Sp z oo");
	data8.put("Country", "Poland");
	data8.put("Email", "magdalena.zofia.kowalczyk.hr023@yopmail.com");
	data8.put("Subscribe News", "No");
	data8.put("Country Code", "+48");
	data8.put("Phone Number", "512739684");
	data8.put("App Name", "Simplified HR");
	data8.put("App Enabled", "Yes");
	data8.put("Plan Name", "Ayan Daily HR Starter Plan");
	data8.put("Users", "13");
	data8.put("Group", "Poland Starter HR Group");
	data8.put("Account Manager", "Admin Ayan Sengupta");
	data8.put("Staff Notes", "This Poland-based customer account is used to validate daily starter plan selection, users field value, newsletter disabled state, contact details, and internal account setup information.");

	TreeMap<String, String> data9 = new TreeMap<String, String>();
	data9.put("First Name", "Hendrik");
	data9.put("Middle Name", "Willem");
	data9.put("Last Name", "Van Leeuwen");
	data9.put("Company Name", "Van Leeuwen Corporate HR BV");
	data9.put("Country", "Netherlands");
	data9.put("Email", "hendrik.willem.vanleeuwen.hr024@yopmail.com");
	data9.put("Subscribe News", "Yes");
	data9.put("Country Code", "+31");
	data9.put("Phone Number", "647392815");
	data9.put("App Name", "Simplified HR");
	data9.put("App Enabled", "Yes");
	data9.put("Plan Name", "Ayan Weekly HR Growth Plan");
	data9.put("Users", "31");
	data9.put("Group", "Netherlands Growth HR Group");
	data9.put("Account Manager", "Admin Ayan Sengupta");
	data9.put("Staff Notes", "Verifying Netherlands-based customer account creation with weekly growth HR plan, users field input, newsletter subscription, realistic phone number, and staff note data.");

	TreeMap<String, String> data10 = new TreeMap<String, String>();
	data10.put("First Name", "Claudia");
	data10.put("Middle Name", "Annemarie");
	data10.put("Last Name", "Fischer");
	data10.put("Company Name", "Fischer Integrated HR Operations GmbH");
	data10.put("Country", "Germany");
	data10.put("Email", "claudia.annemarie.fischer.hr025@yopmail.com");
	data10.put("Subscribe News", "No");
	data10.put("Country Code", "+49");
	data10.put("Phone Number", "16273948105");
	data10.put("App Name", "Simplified HR");
	data10.put("App Enabled", "Yes");
	data10.put("Plan Name", "Ayan Monthly HR Business Plan");
	data10.put("Users", "26");
	data10.put("Group", "Germany Business HR Group");
	data10.put("Account Manager", "Admin Ayan Sengupta");
	data10.put("Staff Notes", "Creating Germany-based customer account to verify monthly business plan assignment, mandatory users field, company details, country selection, phone number entry, and staff note save flow.");

	TreeMap<String, String> data11 = new TreeMap<String, String>();
	data11.put("First Name", "Rafael");
	data11.put("Middle Name", "Enrique");
	data11.put("Last Name", "Montes");
	data11.put("Company Name", "Montes Workforce Advisory SL");
	data11.put("Country", "Spain");
	data11.put("Email", "rafael.enrique.montes.hr026@yopmail.com");
	data11.put("Subscribe News", "Yes");
	data11.put("Country Code", "+34");
	data11.put("Phone Number", "634819275");
	data11.put("App Name", "Simplified HR");
	data11.put("App Enabled", "Yes");
	data11.put("Plan Name", "Ayan Yearly HR Enterprise Plan");
	data11.put("Users", "42");
	data11.put("Group", "Spain Enterprise HR Group");
	data11.put("Account Manager", "Admin Ayan Sengupta");
	data11.put("Staff Notes", "Testing Spain-based enterprise account creation with yearly HR plan, high users count, newsletter subscription enabled, complete customer details, and internal group assignment.");

	TreeMap<String, String> data12 = new TreeMap<String, String>();
	data12.put("First Name", "Elena");
	data12.put("Middle Name", "Giovanna");
	data12.put("Last Name", "Bellini");
	data12.put("Company Name", "Bellini Employee Advisory SRL");
	data12.put("Country", "Italy");
	data12.put("Email", "elena.giovanna.bellini.hr027@yopmail.com");
	data12.put("Subscribe News", "No");
	data12.put("Country Code", "+39");
	data12.put("Phone Number", "3668291745");
	data12.put("App Name", "Simplified HR");
	data12.put("App Enabled", "Yes");
	data12.put("Plan Name", "Ayan Custom Days HR Flex Plan");
	data12.put("Users", "20");
	data12.put("Group", "Italy Custom HR Group");
	data12.put("Account Manager", "Admin Ayan Sengupta");
	data12.put("Staff Notes", "Creating Italy-based customer account to validate custom HR plan assignment, users field input, newsletter unchecked condition, country code selection, and internal staff note coverage.");

	TreeMap<String, String> data13 = new TreeMap<String, String>();
	data13.put("First Name", "Sven");
	data13.put("Middle Name", "Alexander");
	data13.put("Last Name", "Lindholm");
	data13.put("Company Name", "Lindholm People Services AB");
	data13.put("Country", "Sweden");
	data13.put("Email", "sven.alexander.lindholm.hr028@yopmail.com");
	data13.put("Subscribe News", "Yes");
	data13.put("Country Code", "+46");
	data13.put("Phone Number", "721938465");
	data13.put("App Name", "Simplified HR");
	data13.put("App Enabled", "Yes");
	data13.put("Plan Name", "Ayan Weekly HR Growth Plan");
	data13.put("Users", "34");
	data13.put("Group", "Sweden Growth HR Group");
	data13.put("Account Manager", "Admin Ayan Sengupta");
	data13.put("Staff Notes", "Validating Sweden-based HR account creation with weekly growth plan, newsletter subscription, mandatory users field, unique customer email, and internal account manager selection.");

	TreeMap<String, String> data14 = new TreeMap<String, String>();
	data14.put("First Name", "Quinten");
	data14.put("Middle Name", "Alexander");
	data14.put("Last Name", "Verhoeven");
	data14.put("Company Name", "Verhoeven Corporate HR BV");
	data14.put("Country", "Netherlands");
	data14.put("Email", "quinten.alexander.verhoeven.hr029@yopmail.com");
	data14.put("Subscribe News", "No");
	data14.put("Country Code", "+31");
	data14.put("Phone Number", "684193725");
	data14.put("App Name", "Simplified HR");
	data14.put("App Enabled", "Yes");
	data14.put("Plan Name", "Ayan Monthly HR Business Plan");
	data14.put("Users", "23");
	data14.put("Group", "Netherlands Monthly HR Group");
	data14.put("Account Manager", "Admin Ayan Sengupta");
	data14.put("Staff Notes", "Testing Netherlands-based customer account creation with monthly HR business plan, users field value, newsletter disabled state, full contact details, and staff note entry.");

	TreeMap<String, String> data15 = new TreeMap<String, String>();
	data15.put("First Name", "Beatrice");
	data15.put("Middle Name", "Johanna");
	data15.put("Last Name", "Altenburg");
	data15.put("Company Name", "Altenburg Strategic HR Operations AG");
	data15.put("Country", "Switzerland");
	data15.put("Email", "beatrice.johanna.altenburg.hr030@yopmail.com");
	data15.put("Subscribe News", "Yes");
	data15.put("Country Code", "+41");
	data15.put("Phone Number", "798426531");
	data15.put("App Name", "Simplified HR");
	data15.put("App Enabled", "Yes");
	data15.put("Plan Name", "Ayan Yearly HR Enterprise Plan");
	data15.put("Users", "48");
	data15.put("Group", "Switzerland Enterprise HR Group");
	data15.put("Account Manager", "Admin Ayan Sengupta");
	data15.put("Staff Notes", "Creating Switzerland-based enterprise account to verify yearly HR plan assignment, users field entry, newsletter subscription, internal group mapping, account manager selection, and staff note save behavior.");

	return new Object[][] { /*
		{ data1 }, */
		{ data2 },
		{ data3 },
		{ data4 },
		{ data5 },
		{ data6 },
		{ data7 },
		{ data8 },
		{ data9 },
		{ data10 },
		{ data11 },
		{ data12 },
		{ data13 },
		{ data14 },
		{ data15 } 
	};
}
	
	
	
	

public TreeMap<String, String> Leads_Details_fetcher() throws IOException, InterruptedException {
	
	Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
	
	
	TreeMap<String, String> lead_details = new TreeMap<>();
	
   WebElement Approve_button;
  try {
	  Approve_button=  p.Leads_Approve_button();
	  
  } catch (Exception e) {
	  
	  Saas_Admin_Menu_navigation("Leads");
      list_threedot_dropdown_option_selector("View Lead");
      Approve_button=p.Leads_Approve_button();
  }
List<WebElement> Labels = p.Labels();
List<WebElement> Values = p.values(); 

for(int i=0;i<Math.min(Labels.size(), Values.size());i++) {
	
	String label = Labels.get(i).getText().trim();
	String value = Values.get(i).getText().trim();
	
	lead_details.put(label, value);
	System.out.println();
    System.out.println(label + " : " + value);
    System.out.println();

}
return lead_details;
}}