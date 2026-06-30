package Product_Codeclouds.Project.Simplified;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
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
public void Draft_Account_Create(TreeMap<String, String> account_data) throws IOException, InterruptedException{

		
		String Company_Name = account_data.get("Company Name");
		String Plan_Name = account_data.get("Plan Name");
		String Users = account_data.get("Users");
		
		Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
		Repeat rp = new Repeat(d);
			

	 int Start_step = 1;
	 int step = Form_Filler(account_data,Start_step);

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
	
@Test(dataProvider="Account_Create_Data")
public void Account_create(TreeMap<String, String> account_data) throws InterruptedException, IOException{

	Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
	Repeat rp = new Repeat(d);

	String Email = account_data.get("Email");
	String Company_Name = account_data.get("Company Name");
	String Plan_Name = account_data.get("Plan Name");
	String Users = account_data.get("Users");

	int Start_step = 1;
	int step = Form_Filler(account_data,Start_step);

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Click Save & Invite button after filling account creation form.");
	System.out.println("Step " + (step - 1) + ": Click Save & Invite button after filling account creation form.");
	WebElement Save_Button_Below = p.Save_Invite_Button();
	rp.Scroll_to_element(Save_Button_Below);
	Save_Button_Below.click();
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Save & Invite button clicked successfully for Email = " + Email);
	System.out.println("🟨 Actual: Save & Invite button clicked successfully for Email = " + Email);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Capture toast message after Save & Invite action.");
	System.out.println("Step " + (step - 1) + ": Capture toast message after Save & Invite action.");
	WebElement Toast = p.Toast_message();
	String Toast_text = Toast.getText().trim();
	Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Account Save & Invite action completed. Toast message = " + Toast_text);
	System.out.println("✅ Actual: Account Save & Invite action completed. Toast message = " + Toast_text);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Close toast message and confirm account list page is available.");
	System.out.println("Step " + (step - 1) + ": Close toast message and confirm account list page is available.");
	p.Toast_close_Button().click();
	p.Create_Account_button();
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Toast closed successfully and Create Account button is available again.");
	System.out.println("🟨 Actual: Toast closed successfully and Create Account button is available again.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Start account activation flow using generated invite link.");
	System.out.println("Step " + (step - 1) + ": Start account activation flow using generated invite link.");
	Account_Activator(account_data, step);

	Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Final Result:</b> Account creation and activation flow completed successfully. Company = " + Company_Name + " | Email = " + Email + " | Plan = " + Plan_Name + " | Users = " + Users);
	System.out.println("✅ Final Result: Account creation and activation flow completed successfully. Company = " + Company_Name + " | Email = " + Email + " | Plan = " + Plan_Name + " | Users = " + Users);
	System.out.println(); }

public int Account_Activator(TreeMap<String, String> account_data, int step) throws IOException, InterruptedException{

	Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
	Repeat rp = new Repeat(d);
	Data_Reader f = new Data_Reader();

	String Email = account_data.get("Email");
	String Company_Name = account_data.get("Company Name");
	String Plan_Name = account_data.get("Plan Name");
	String Users = account_data.get("Users");

	WebElement Create_Button;

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🔹 Scenario Section:</b> Validate account activation using generated invite link.");
	System.out.println("🔹 Scenario Section: Validate account activation using generated invite link.");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📘 Description:</b> Search the newly invited account in SaaS Admin, open Get Invite Link action, copy invite link, open it in a new tab, set password, submit activation form, and validate account verified success message.");
	System.out.println("📘 Description: Search the newly invited account in SaaS Admin, open Get Invite Link action, copy invite link, open it in a new tab, set password, submit activation form, and validate account verified success message.");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📥 Input:</b> Email = " + Email + " | Company = " + Company_Name + " | Plan = " + Plan_Name + " | Users = " + Users);
	System.out.println("📥 Input: Email = " + Email + " | Company = " + Company_Name + " | Plan = " + Plan_Name + " | Users = " + Users);

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>✅ Expected:</b> Account invite link should open successfully, password should be set, and account verified success message should be displayed.");
	System.out.println("✅ Expected: Account invite link should open successfully, password should be set, and account verified success message should be displayed.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Check whether SaaS Admin account list page is already accessible.");
	System.out.println("Step " + (step - 1) + ": Check whether SaaS Admin account list page is already accessible.");

	try {
		Create_Button = p.Create_Account_button();
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Create Account button found. SaaS Admin account list page is already accessible.");
		System.out.println("🟨 Actual: Create Account button found. SaaS Admin account list page is already accessible.");
	} catch(Exception r) {
		Report_Listen.log_print_in_report().log(Status.WARNING, "<b>⚠ Actual:</b> Create Account button was not found. SaaS Admin login will be performed again.<br><b>Reason:</b> " + r.getMessage());
		System.out.println("⚠ Actual: Create Account button was not found. SaaS Admin login will be performed again.");
		System.out.println("Reason: " + r.getMessage());

		Saas_Admin_Login();
		Create_Button = p.Create_Account_button();

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> SaaS Admin login completed and Create Account button is now available.");
		System.out.println("🟨 Actual: SaaS Admin login completed and Create Account button is now available.");
	}
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Wait for account list loader to disappear before searching invited account.");
	System.out.println("Step " + (step - 1) + ": Wait for account list loader to disappear before searching invited account.");
	List<WebElement> Loaders = p.Loader();
	rp.wait_for_invisibilty_of_theElement(Loaders);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Initial account list loader disappeared successfully.");
	System.out.println("🟨 Actual: Initial account list loader disappeared successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Search invited account using email = " + Email);
	System.out.println("Step " + (step - 1) + ": Search invited account using email = " + Email);
	WebElement Search = p.search_field();
	Search.sendKeys(Email);
	Thread.sleep(1000);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Email entered successfully in account search field = " + Email);
	System.out.println("🟨 Actual: Email entered successfully in account search field = " + Email);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Wait for account list reload after search.");
	System.out.println("Step " + (step - 1) + ": Wait for account list reload after search.");
	List<WebElement> Reloaders = p.Loader();
	rp.wait_for_invisibilty_of_theElement(Reloaders);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Account list reload completed after search.");
	System.out.println("🟨 Actual: Account list reload completed after search.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Open row action menu and select Get Invite Link option.");
	System.out.println("Step " + (step - 1) + ": Open row action menu and select Get Invite Link option.");
	list_threedot_dropdown_option_selector("Get Invite Link");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Get Invite Link option selected successfully for searched account.");
	System.out.println("🟨 Actual: Get Invite Link option selected successfully for searched account.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Validate invite link popup modal and capture invite link.");
	System.out.println("Step " + (step - 1) + ": Validate invite link popup modal and capture invite link.");
	p.pop_up_modal();
	WebElement Invite = p.Invite_link();
	String Invite_link = Invite.getText().trim();
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Invite link popup opened and invite link captured successfully.");
	System.out.println("🟨 Actual: Invite link popup opened and invite link captured successfully.");
	System.out.println("Invite Link Is ------> " + Invite_link);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Open invite link in a new browser tab.");
	System.out.println("Step " + (step - 1) + ": Open invite link in a new browser tab.");
	d.switchTo().newWindow(WindowType.TAB);
	d.navigate().to(Invite_link);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Invite link opened successfully in new tab.");
	System.out.println("🟨 Actual: Invite link opened successfully in new tab.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Validate user landed on Set Password page.");
	System.out.println("Step " + (step - 1) + ": Validate user landed on Set Password page.");
	p.Landed_in_Set_Password_page();
	Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> User landed successfully on Set Password page.");
	System.out.println("✅ Actual: User landed successfully on Set Password page.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Enter password and confirm password.");
	System.out.println("Step " + (step - 1) + ": Enter password and confirm password.");
	String Pass = f.Data_Fetcher("Pass");
	WebElement passfield = p.password();
	WebElement Confirm_pass_field = p.confirm_password();
	passfield.sendKeys(Pass);
	Confirm_pass_field.sendKeys(Pass);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Password and confirm password entered successfully.");
	System.out.println("🟨 Actual: Password and confirm password entered successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Submit Set Password form to activate account.");
	System.out.println("Step " + (step - 1) + ": Submit Set Password form to activate account.");
	WebElement Submit = p.Submit_Button();
	rp.movetoelement(Submit);
	Submit.click();
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Set Password form submitted successfully.");
	System.out.println("🟨 Actual: Set Password form submitted successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Capture account verified success message.");
	System.out.println("Step " + (step - 1) + ": Capture account verified success message.");
	WebElement Success = p.Account_Verified_Success_Message();
	String Success_Message = Success.getText().trim();
	Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Account activation completed successfully. Success message = " + Success_Message);
	System.out.println("✅ Actual: Account activation completed successfully. Success message = " + Success_Message);
	System.out.println();

	return step;
}

public void check_for_added_Account(TreeMap<String, String> account_data)throws InterruptedException, IOException {

	Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
	Repeat rp = new Repeat(d);

	String Email = account_data.get("Email");
	String Company_Name = account_data.get("Company Name");
	String Plan_Name = account_data.get("Plan Name");
	String Users = account_data.get("Users");

	int step = 1;
	boolean account_found = false;

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🔹 Scenario Title:</b> Validate created draft account is available in SaaS Admin account list.");
	System.out.println("🔹 Scenario Title: Validate created draft account is available in SaaS Admin account list.");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📘 Description:</b> Open SaaS Admin account list, search the newly created account by email, fetch the listed account data, and verify that the expected email is displayed in the account list.");
	System.out.println("📘 Description: Open SaaS Admin account list, search the newly created account by email, fetch the listed account data, and verify that the expected email is displayed in the account list.");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📥 Input:</b> Email = " + Email + " | Company = " + Company_Name + " | Plan = " + Plan_Name + " | Users = " + Users);
	System.out.println("📥 Input: Email = " + Email + " | Company = " + Company_Name + " | Plan = " + Plan_Name + " | Users = " + Users);

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>✅ Expected:</b> The newly created draft account should be searchable and the account email should be visible in the SaaS Admin account list.");
	System.out.println("✅ Expected: The newly created draft account should be searchable and the account email should be visible in the SaaS Admin account list.");
	System.out.println();

	WebElement Create_Button;

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Check whether SaaS Admin account list page is already accessible.");
	System.out.println("Step " + (step - 1) + ": Check whether SaaS Admin account list page is already accessible.");

	try {
		Create_Button = p.Create_Account_button();
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Create Account button found. SaaS Admin account list page is already accessible.");
		System.out.println("🟨 Actual: Create Account button found. SaaS Admin account list page is already accessible.");
	} catch(Exception r) {
		Report_Listen.log_print_in_report().log(Status.WARNING, "<b>⚠ Actual:</b> Create Account button was not found. SaaS Admin login will be performed again.<br><b>Reason:</b> " + r.getMessage());
		System.out.println("⚠ Actual: Create Account button was not found. SaaS Admin login will be performed again.");
		System.out.println("Reason: " + r.getMessage());

		Saas_Admin_Login();
		Create_Button = p.Create_Account_button();

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> SaaS Admin login completed and Create Account button is now available.");
		System.out.println("🟨 Actual: SaaS Admin login completed and Create Account button is now available.");
	}
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Search created account using email = " + Email);
	System.out.println("Step " + (step - 1) + ": Search created account using email = " + Email);
	List<WebElement> Loaders = p.Loader();
	rp.wait_for_invisibilty_of_theElement(Loaders);
	WebElement Search = p.search_field();
	Search.sendKeys(Email);
    Thread.sleep(1000);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Email entered successfully in account search field = " + Email);
	System.out.println("🟨 Actual: Email entered successfully in account search field = " + Email);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Fetch account list data after search.");
	System.out.println("Step " + (step - 1) + ": Fetch account list data after search.");
	List<WebElement> Reloaders = p.Loader();
	rp.wait_for_invisibilty_of_theElement(Reloaders);
	List<WebElement> truncated_datas = p.Truncated_data_in_list();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> Account list truncated data count after search = " + truncated_datas.size());
	System.out.println("🟨 Debug: Account list truncated data count after search = " + truncated_datas.size());
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Verify searched email is present in account list.");
	System.out.println("Step " + (step - 1) + ": Verify searched email is present in account list.");

	for(WebElement truncated_data:truncated_datas) {
		String Text = truncated_data.getText().trim();

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> Account list visible text checked = " + Text);
		System.out.println("🟨 Debug: Account list visible text checked = " + Text);

		if(Text.contains(Email)) {
			account_found = true;
			Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Created account email found in account list = " + Email);
			System.out.println("✅ Actual: Created account email found in account list = " + Email);
			break;
		}
	}

	if(account_found) {
		Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Final Result:</b> Draft account verification completed successfully. Account found for Email = " + Email + " | Company = " + Company_Name);
		System.out.println("✅ Final Result: Draft account verification completed successfully. Account found for Email = " + Email + " | Company = " + Company_Name);
	} else {
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Final Result:</b> Draft account verification failed. Account email was not found in the account list after search. Expected Email = " + Email);
		System.out.println("❌ Final Result: Draft account verification failed. Account email was not found in the account list after search. Expected Email = " + Email);
	}

	System.out.println();
}

public int Form_Filler(TreeMap<String, String> Form_Data, int step) throws InterruptedException, IOException{

	String First_Name = Form_Data.get("First Name");
	String Middle_Name = Form_Data.get("Middle Name");
	String Last_Name = Form_Data.get("Last Name");
	String Company_Name = Form_Data.get("Company Name");
	String Country = Form_Data.get("Country");
	String Email = Form_Data.get("Email");
	String Subscribe_News = Form_Data.get("Subscribe News");
	String Country_Code = Form_Data.get("Country Code");
	String Phone_Number = Form_Data.get("Phone Number");

	String App_Name = Form_Data.get("App Name");
	String App_Enabled = Form_Data.get("App Enabled");
	String Plan_Name = Form_Data.get("Plan Name");
	String Users = Form_Data.get("Users");

	String Group = Form_Data.get("Group");
	String Account_Manager = Form_Data.get("Account Manager");

	String Staff_Notes = Form_Data.get("Staff Notes");

	boolean Subscribe_News_Status = Subscribe_News.equalsIgnoreCase("Yes");
	boolean App_Enabled_Status = App_Enabled.equalsIgnoreCase("Yes");

	Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
	Repeat rp = new Repeat(d);

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🔹 Scenario Title:</b> Validate SaaS Admin Account creation with app plan, account manager, group, and staff notes assignment.");
	System.out.println("🔹 Scenario Title: Validate SaaS Admin Account creation with app plan, account manager, group, and staff notes assignment.");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📘 Description:</b> Login into SaaS Admin, open Create Account form, enter account holder details, select country, fill contact information, assign app plan, enter limit/user value, select account manager, assign group, enter staff notes, and continue account creation flow.");
	System.out.println("📘 Description: Login into SaaS Admin, open Create Account form, enter account holder details, select country, fill contact information, assign app plan, enter limit/user value, select account manager, assign group, enter staff notes, and continue account creation flow.");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📥 Input:</b> Name = " + First_Name + " " + Middle_Name + " " + Last_Name + " | Company = " + Company_Name + " | Country = " + Country + " | Email = " + Email + " | Country Code = " + Country_Code + " | Phone Number = " + Phone_Number + " | Subscribe News = " + Subscribe_News + " | Subscribe Status = " + Subscribe_News_Status + " | App Name = " + App_Name + " | App Enabled = " + App_Enabled + " | App Enabled Status = " + App_Enabled_Status + " | Plan Name = " + Plan_Name + " | Users = " + Users + " | Group = " + Group + " | Account Manager = " + Account_Manager);
	System.out.println("📥 Input: Name = " + First_Name + " " + Middle_Name + " " + Last_Name + " | Company = " + Company_Name + " | Country = " + Country + " | Email = " + Email + " | Country Code = " + Country_Code + " | Phone Number = " + Phone_Number + " | Subscribe News = " + Subscribe_News + " | Subscribe Status = " + Subscribe_News_Status + " | App Name = " + App_Name + " | App Enabled = " + App_Enabled + " | App Enabled Status = " + App_Enabled_Status + " | Plan Name = " + Plan_Name + " | Users = " + Users + " | Group = " + Group + " | Account Manager = " + Account_Manager);

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>✅ Expected:</b> Admin should be able to fill the account creation form, assign the selected app plan, select account manager, assign group, and enter staff notes successfully.");
	System.out.println("✅ Expected: Admin should be able to fill the account creation form, assign the selected app plan, select account manager, assign group, and enter staff notes successfully.");
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
	WebElement Country_dropdown_field = dropdowns.get(4);
	Country_dropdown_field.click();
	p.Country_input().sendKeys(Country);
	WebElement country_list = p.Country_dropdown();
	List<WebElement> country_options = country_list.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> Country dropdown option count = " + country_options.size());
	System.out.println("🟨 Debug: Country dropdown option count = " + country_options.size());

	if(country_options.size() > 0) {
		country_options.get(0).click();
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Country selected successfully = " + Country);
		System.out.println("🟨 Actual: Country selected successfully = " + Country);
	} else {
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> Country option was not found after searching country = " + Country);
		System.out.println("❌ Actual: Country option was not found after searching country = " + Country);
		return step;
	}
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Fill email and phone number details.");
	System.out.println("Step " + (step - 1) + ": Fill email and phone number details.");
	input.get(4).sendKeys(Email);
	input.get(5).sendKeys(Phone_Number);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Contact details entered successfully. Email = " + Email + " | Phone Number = " + Phone_Number);
	System.out.println("🟨 Actual: Contact details entered successfully. Email = " + Email + " | Phone Number = " + Phone_Number);
	System.out.println();

	step = App_Plan_Assigner(Form_Data, step);

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Select account manager. Account Manager = " + Account_Manager);
	System.out.println("Step " + (step - 1) + ": Select account manager. Account Manager = " + Account_Manager);
	WebElement AccManager_feild = p.Account_manager_field();
	rp.movetoelement(AccManager_feild);
	AccManager_feild.click();
	p.Account_Manager_input().sendKeys(Account_Manager);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Account manager name entered in dropdown search field = " + Account_Manager);
	System.out.println("🟨 Actual: Account manager name entered in dropdown search field = " + Account_Manager);

	WebElement accdrpdwn = p.Account_Manager_Dropdown();
	rp.movetoelement(accdrpdwn);
	List<WebElement> opts = accdrpdwn.findElements(By.xpath(".//div[@class='ant-select-item-option-content']"));
	boolean account_manager_selected = false;

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> Account manager dropdown option count = " + opts.size());
	System.out.println("🟨 Debug: Account manager dropdown option count = " + opts.size());

	for(WebElement opt : opts) {
		String Text = opt.getText().trim();
		System.out.println("Account manager option found = " + Text);

		if(Text.contains(Account_Manager)) {
			rp.movetoelement(opt);
			opt.click();
			account_manager_selected = true;
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Account manager selected successfully = " + Text);
			System.out.println("🟨 Actual: Account manager selected successfully = " + Text);
			break;
		}
	}

	if(!account_manager_selected) {
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> Required account manager was not found in dropdown. Expected Account Manager = " + Account_Manager);
		System.out.println("❌ Actual: Required account manager was not found in dropdown. Expected Account Manager = " + Account_Manager);
		return step;
	}
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Select account group. Group = " + Group);
	System.out.println("Step " + (step - 1) + ": Select account group. Group = " + Group);
	WebElement Group_feild = p.Group_Field();
	rp.movetoelement(Group_feild);
	Group_feild.click();
	Thread.sleep(800);
	p.Group_input().sendKeys(Group);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Group name entered in dropdown search field = " + Group);
	System.out.println("🟨 Actual: Group name entered in dropdown search field = " + Group);

	WebElement group_dpdwn = p.Account_Manager_Dropdown();
	rp.movetoelement(group_dpdwn);
	List<WebElement> gpopts = group_dpdwn.findElements(By.xpath(".//div[@class='ant-select-item-option-content']"));
	boolean group_selected = false;

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> Group dropdown option count = " + gpopts.size());
	System.out.println("🟨 Debug: Group dropdown option count = " + gpopts.size());

	for(WebElement gpopt : gpopts) {
		String Group_Text = gpopt.getText().trim();
		System.out.println("Group option found = " + Group_Text);

		if(Group_Text.contains(Group)) {
			rp.movetoelement(gpopt);
			gpopt.click();
			group_selected = true;
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Group selected successfully = " + Group_Text);
			System.out.println("🟨 Actual: Group selected successfully = " + Group_Text);
			break;
		}
	}

	if(!group_selected) {
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> Required group was not found in dropdown. Expected Group = " + Group);
		System.out.println("❌ Actual: Required group was not found in dropdown. Expected Group = " + Group);
		return step;
	}
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Enter staff notes.");
	System.out.println("Step " + (step - 1) + ": Enter staff notes.");
	WebElement Staff_Note_feild = p.Text_Area_Field();
	rp.movetoelement(Staff_Note_feild);
	Staff_Note_feild.click();
	Staff_Note_feild.sendKeys(Staff_Notes);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Staff notes entered successfully. Notes = " + Staff_Notes);
	System.out.println("🟨 Actual: Staff notes entered successfully. Notes = " + Staff_Notes);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Account form filling completed successfully with app plan, account manager, group, and staff notes. Company = " + Company_Name + " | Email = " + Email);
	System.out.println("✅ Actual: Account form filling completed successfully with app plan, account manager, group, and staff notes. Company = " + Company_Name + " | Email = " + Email);
	System.out.println();

	return step;
}
	public int App_Plan_Assigner(TreeMap<String, String> Form_Data, int step) throws InterruptedException, IOException{

	String App_Name = Form_Data.get("App Name");
	String App_Enabled = Form_Data.get("App Enabled");
	String Plan_Name = Form_Data.get("Plan Name");
	String Users = Form_Data.get("Users");
	String App_Type = Form_Data.get("App Type");

	boolean App_Enabled_Status = App_Enabled != null && App_Enabled.equalsIgnoreCase("Yes");
	String App_Type_Lower = App_Type == null ? "" : App_Type.toLowerCase().trim();

	Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
	Repeat rp = new Repeat(d);
	JavascriptExecutor js = (JavascriptExecutor) d;

	List<String> Apps_To_Assign = new ArrayList<String>();

	if(App_Type_Lower.contains("all")) {
		Apps_To_Assign.add("hr");
		Apps_To_Assign.add("checkout");
		Apps_To_Assign.add("hire");
		Apps_To_Assign.add("spaces");
	} else {
		if(App_Type_Lower.contains("hr")) {
			Apps_To_Assign.add("hr");
		}
		if(App_Type_Lower.contains("checkout")) {
			Apps_To_Assign.add("checkout");
		}
		if(App_Type_Lower.contains("hire")) {
			Apps_To_Assign.add("hire");
		}
		if(App_Type_Lower.contains("spaces")) {
			Apps_To_Assign.add("spaces");
		}
	}

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Navigate to app plan assignment section.");
	System.out.println("Step " + (step - 1) + ": Navigate to app plan assignment section.");
	WebElement Plan_Tab = p.Plan_Tab();
	rp.Scroll_to_element(Plan_Tab);
	js.executeScript("window.scrollBy(0, -180);");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> App plan assignment section reached successfully.");
	System.out.println("🟨 Actual: App plan assignment section reached successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Validate app plan assignment test data.");
	System.out.println("Step " + (step - 1) + ": Validate app plan assignment test data.");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> App Name = " + App_Name + " | App Type = " + App_Type + " | App Enabled = " + App_Enabled + " | Boolean Status = " + App_Enabled_Status + " | Apps To Assign = " + Apps_To_Assign);
	System.out.println("🟨 Debug: App Name = " + App_Name + " | App Type = " + App_Type + " | App Enabled = " + App_Enabled + " | Boolean Status = " + App_Enabled_Status + " | Apps To Assign = " + Apps_To_Assign);

	if(!App_Enabled_Status) {
		Report_Listen.log_print_in_report().log(Status.WARNING, "<b>⚠ Actual:</b> App plan assignment skipped because App Enabled data = " + App_Enabled + " | App Type = " + App_Type);
		System.out.println("⚠ Actual: App plan assignment skipped because App Enabled data = " + App_Enabled + " | App Type = " + App_Type);
		System.out.println();
		return step;
	}

	if(Apps_To_Assign.size() == 0) {
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> No valid app type found for app plan assignment. App Type = " + App_Type);
		System.out.println("❌ Actual: No valid app type found for app plan assignment. App Type = " + App_Type);
		System.out.println();
		return step;
	}
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Enable required app toggles based on App Type.");
	System.out.println("Step " + (step - 1) + ": Enable required app toggles based on App Type.");
	List<WebElement> Plan_Toggles = p.Plan_toggle_Buttons();
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> App toggle count fetched = " + Plan_Toggles.size());
	System.out.println("🟨 Debug: App toggle count fetched = " + Plan_Toggles.size());

	for(String Current_App : Apps_To_Assign) {

		int Toggle_Index = -1;
		String App_Display_Name = "";

		if(Current_App.equals("hr")) {
			Toggle_Index = 0;
			App_Display_Name = "Simplified HR";
		}
		if(Current_App.equals("checkout")) {
			Toggle_Index = 1;
			App_Display_Name = "Simplified Checkout";
		}
		if(Current_App.equals("hire")) {
			Toggle_Index = 2;
			App_Display_Name = "Simplified Hire";
		}
		if(Current_App.equals("spaces")) {
			Toggle_Index = 3;
			App_Display_Name = "Simplified Spaces";
		}

		if(Toggle_Index >= 0 && Plan_Toggles.size() > Toggle_Index) {
			WebElement App_Toggle = Plan_Toggles.get(Toggle_Index);
			App_Toggle.click();
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> " + App_Display_Name + " toggle clicked successfully. Toggle Index = " + Toggle_Index);
			System.out.println("🟨 Actual: " + App_Display_Name + " toggle clicked successfully. Toggle Index = " + Toggle_Index);
		} else {
			Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> Toggle was not available for app = " + App_Display_Name + " | Required Toggle Index = " + Toggle_Index + " | Actual Toggle Count = " + Plan_Toggles.size());
			System.out.println("❌ Actual: Toggle was not available for app = " + App_Display_Name + " | Required Toggle Index = " + Toggle_Index + " | Actual Toggle Count = " + Plan_Toggles.size());
			System.out.println();
			return step;
		}
	}

	Thread.sleep(800);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Required app toggle actions completed. App Name = " + App_Name + " | App Type = " + App_Type + " | Apps Enabled = " + Apps_To_Assign);
	System.out.println("🟨 Actual: Required app toggle actions completed. App Name = " + App_Name + " | App Type = " + App_Type + " | Apps Enabled = " + Apps_To_Assign);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Fetch app plan dropdown fields.");
	System.out.println("Step " + (step - 1) + ": Fetch app plan dropdown fields.");
	List<WebElement> Plan_Select = p.Plan_select_dropdowm();
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> Plan dropdown field count fetched = " + Plan_Select.size() + " | Required App Count = " + Apps_To_Assign.size());
	System.out.println("🟨 Debug: Plan dropdown field count fetched = " + Plan_Select.size() + " | Required App Count = " + Apps_To_Assign.size());
	System.out.println();

	for(int i = 0; i < Apps_To_Assign.size(); i++) {

		String Current_App = Apps_To_Assign.get(i);
		String App_Display_Name = "";
		String Current_Plan_Name = Plan_Name;
		WebElement Plan_Input_Field = null;
		int Dropdown_Holder_Index = 3 + (i * 2);

		if(Current_App.equals("hr")) {
			App_Display_Name = "Simplified HR";
			Plan_Input_Field = p.Hr_Plan_Input_feild();
			if(App_Type_Lower.contains("all")) {
				Current_Plan_Name = Form_Data.get("Hr Plan Name");
			}
		}
		if(Current_App.equals("checkout")) {
			App_Display_Name = "Simplified Checkout";
			Plan_Input_Field = p.Checkout_Plan_Input_feild();
			if(App_Type_Lower.contains("all")) {
				Current_Plan_Name = Form_Data.get("Checkout Plan Name");
			}
		}
		if(Current_App.equals("hire")) {
			App_Display_Name = "Simplified Hire";
			Plan_Input_Field = p.Hire_Plan_Input_feild();
			if(App_Type_Lower.contains("all")) {
				Current_Plan_Name = Form_Data.get("Hire Plan Name");
			}
		}
		if(Current_App.equals("spaces")) {
			App_Display_Name = "Simplified Spaces";
			Plan_Input_Field = p.Spaces_Plan_Input_feild();
			if(App_Type_Lower.contains("all")) {
				Current_Plan_Name = Form_Data.get("Spaces Plan Name");
			}
		}

		if(Current_Plan_Name == null || Current_Plan_Name.trim().length() == 0) {
			Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> Plan name is missing for " + App_Display_Name + ". App Type = " + App_Type);
			System.out.println("❌ Actual: Plan name is missing for " + App_Display_Name + ". App Type = " + App_Type);
			System.out.println();
			return step;
		}

		if(Plan_Select.size() <= i) {
			Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> Plan dropdown field was not available for " + App_Display_Name + ". Required Index = " + i + " | Actual Dropdown Count = " + Plan_Select.size());
			System.out.println("❌ Actual: Plan dropdown field was not available for " + App_Display_Name + ". Required Index = " + i + " | Actual Dropdown Count = " + Plan_Select.size());
			System.out.println();
			return step;
		}

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Open " + App_Display_Name + " plan dropdown and search plan.");
		System.out.println("Step " + (step - 1) + ": Open " + App_Display_Name + " plan dropdown and search plan.");
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> App = " + App_Display_Name + " | Plan Dropdown Index = " + i + " | Dropdown Holder Index = " + Dropdown_Holder_Index + " | Plan Name = " + Current_Plan_Name);
		System.out.println("🟨 Debug: App = " + App_Display_Name + " | Plan Dropdown Index = " + i + " | Dropdown Holder Index = " + Dropdown_Holder_Index + " | Plan Name = " + Current_Plan_Name);

		WebElement Plan_select_field = Plan_Select.get(i);
		rp.movetoelement(Plan_select_field);
		Plan_select_field.click();
		Plan_Input_Field.sendKeys(Current_Plan_Name);
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> " + App_Display_Name + " plan search field used and plan name entered = " + Current_Plan_Name);
		System.out.println("🟨 Actual: " + App_Display_Name + " plan search field used and plan name entered = " + Current_Plan_Name);

		WebElement Dropdown_List = d.findElement(By.xpath("(//*[contains(@class,'rc-virtual-list-holder')])[" + Dropdown_Holder_Index + "]"));
		rp.wait_for_theElement(Dropdown_List);
		Thread.sleep(800);
		rp.movetoelement(Dropdown_List);

		List<WebElement> plan_options = Dropdown_List.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> " + App_Display_Name + " plan option count after search = " + plan_options.size() + " | Searched Plan = " + Current_Plan_Name);
		System.out.println("🟨 Debug: " + App_Display_Name + " plan option count after search = " + plan_options.size() + " | Searched Plan = " + Current_Plan_Name);

		if(plan_options.size() > 0) {
			plan_options.get(0).click();
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> " + App_Display_Name + " plan selected successfully = " + Current_Plan_Name);
			System.out.println("🟨 Actual: " + App_Display_Name + " plan selected successfully = " + Current_Plan_Name);
		} else {
			Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> No plan option found for " + App_Display_Name + " after searching plan = " + Current_Plan_Name);
			System.out.println("❌ Actual: No plan option found for " + App_Display_Name + " after searching plan = " + Current_Plan_Name);
			System.out.println();
			return step;
		}
		System.out.println();
	}

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Enter limit/user value for assigned app plans.");
	System.out.println("Step " + (step - 1) + ": Enter limit/user value for assigned app plans.");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> Limit/user value will be entered for Apps = " + Apps_To_Assign + " | Value = " + Users);
	System.out.println("🟨 Debug: Limit/user value will be entered for Apps = " + Apps_To_Assign + " | Value = " + Users);

	for(String Current_App : Apps_To_Assign) {

		String App_Display_Name = "";
		WebElement Limit_Field = null;
		String Field_Name = "";

		if(Current_App.equals("hr")) {
			App_Display_Name = "Simplified HR";
			Limit_Field = p.hr_number_of_users_input_field();
			Field_Name = "Number of Users";
		}
		if(Current_App.equals("checkout")) {
			App_Display_Name = "Simplified Checkout";
			Limit_Field = p.checkout_number_of_shared_instances_input_field();
			Field_Name = "Shared Instances";
		}
		if(Current_App.equals("hire")) {
			App_Display_Name = "Simplified Hire";
			Limit_Field = p.hire_number_of_users_input_field();
			Field_Name = "Number of Users";
		}
		if(Current_App.equals("spaces")) {
			App_Display_Name = "Simplified Spaces";
			Limit_Field = p.spaces_number_of_locations_input_field();
			Field_Name = "Number of Locations";
		}

		Limit_Field.sendKeys(Users);
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> " + App_Display_Name + " " + Field_Name + " field filled successfully. Value = " + Users);
		System.out.println("🟨 Actual: " + App_Display_Name + " " + Field_Name + " field filled successfully. Value = " + Users);
	}

	Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> App plan assignment completed successfully. App Name = " + App_Name + " | App Type = " + App_Type + " | Assigned Apps = " + Apps_To_Assign + " | Entered Value = " + Users);
	System.out.println("✅ Actual: App plan assignment completed successfully. App Name = " + App_Name + " | App Type = " + App_Type + " | Assigned Apps = " + Apps_To_Assign + " | Entered Value = " + Users);
	System.out.println();

	return step;
}
	
@DataProvider
public Object[][] Account_Create_Data() {

	TreeMap<String, String> data1 = new TreeMap<String, String>();
	data1.put("First Name", "Eberhard");
	data1.put("Middle Name", "Karl");
	data1.put("Last Name", "Reinhardt");
	data1.put("Company Name", "Reinhardt Unified Commerce GmbH");
	data1.put("Country", "Germany");
	data1.put("Email", "eberhard.karl.reinhardt.account126@yopmail.com");
	data1.put("Subscribe News", "Yes");
	data1.put("Country Code", "+49");
	data1.put("Phone Number", "15268497310");
	data1.put("App Type", "all");
	data1.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data1.put("App Enabled", "Yes");
	data1.put("Checkout Plan Name", "Checkout Weekly 999");
	data1.put("Spaces Plan Name", "Ayan Weekly Spaces Growth Plan");
	data1.put("Hire Plan Name", "testyearly");
	data1.put("Hr Plan Name", "Ayan Weekly HR Growth Plan");
	data1.put("Users", "42");
	data1.put("Group", "Gold II");
	data1.put("Account Manager", "Ayan Test Manager");
	data1.put("Staff Notes", "Creating this Germany-based account to validate all app type selection with weekly checkout, weekly spaces, yearly hire, and weekly HR plans, along with users value, group selection, and account manager mapping.");

	TreeMap<String, String> data2 = new TreeMap<String, String>();
	data2.put("First Name", "Aurore");
	data2.put("Middle Name", "Delphine");
	data2.put("Last Name", "Girard");
	data2.put("Company Name", "Girard Checkout Advisory SAS");
	data2.put("Country", "France");
	data2.put("Email", "aurore.delphine.girard.account127@yopmail.com");
	data2.put("Subscribe News", "No");
	data2.put("Country Code", "+33");
	data2.put("Phone Number", "762918435");
	data2.put("App Type", "checkout");
	data2.put("App Name", "Simplified Checkout");
	data2.put("App Enabled", "Yes");
	data2.put("Plan Name", "Checkout Weekly 999");
	data2.put("Users", "18");
	data2.put("Group", "Diamond");
	data2.put("Account Manager", "Ayan Test Manager");
	data2.put("Staff Notes", "Testing France-based checkout account creation with weekly checkout plan selection, users value, newsletter disabled state, valid group selection, and customer contact details.");

	TreeMap<String, String> data3 = new TreeMap<String, String>();
	data3.put("First Name", "Torvald");
	data3.put("Middle Name", "Marius");
	data3.put("Last Name", "Finstad");
	data3.put("Company Name", "Finstad Integrated Operations AS");
	data3.put("Country", "Norway");
	data3.put("Email", "torvald.marius.finstad.account128@yopmail.com");
	data3.put("Subscribe News", "Yes");
	data3.put("Country Code", "+47");
	data3.put("Phone Number", "48293617");
	data3.put("App Type", "all");
	data3.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data3.put("App Enabled", "Yes");
	data3.put("Checkout Plan Name", "Ayan Checkout New Yearly Plan");
	data3.put("Spaces Plan Name", "Ayan Yearly Spaces Enterprise Plan");
	data3.put("Hire Plan Name", "testyearly");
	data3.put("Hr Plan Name", "Ayan Yearly HR Enterprise Plan");
	data3.put("Users", "57");
	data3.put("Group", "Silver");
	data3.put("Account Manager", "Ayan Test Manager");
	data3.put("Staff Notes", "Validating Norway-based all app account creation with yearly checkout, yearly spaces, yearly hire, and yearly HR plan selections, including users field value, group selection, and internal account manager mapping.");

	TreeMap<String, String> data4 = new TreeMap<String, String>();
	data4.put("First Name", "Chiara");
	data4.put("Middle Name", "Benedetta");
	data4.put("Last Name", "Mancini");
	data4.put("Company Name", "Mancini Workspace Services SRL");
	data4.put("Country", "Italy");
	data4.put("Email", "chiara.benedetta.mancini.account129@yopmail.com");
	data4.put("Subscribe News", "No");
	data4.put("Country Code", "+39");
	data4.put("Phone Number", "3506289417");
	data4.put("App Type", "spaces");
	data4.put("App Name", "Simplified Spaces");
	data4.put("App Enabled", "Yes");
	data4.put("Plan Name", "Ayan Yearly Spaces Enterprise Plan");
	data4.put("Users", "26");
	data4.put("Group", "Gold");
	data4.put("Account Manager", "Ayan Test Manager");
	data4.put("Staff Notes", "Creating this Italy-based spaces account to verify yearly spaces enterprise plan assignment, users value, newsletter disabled state, valid group selection, and staff note capture.");

	TreeMap<String, String> data5 = new TreeMap<String, String>();
	data5.put("First Name", "Cedric");
	data5.put("Middle Name", "Alistair");
	data5.put("Last Name", "Rowntree");
	data5.put("Company Name", "Rowntree Enterprise Platforms Ltd");
	data5.put("Country", "United Kingdom");
	data5.put("Email", "cedric.alistair.rowntree.account130@yopmail.com");
	data5.put("Subscribe News", "Yes");
	data5.put("Country Code", "+44");
	data5.put("Phone Number", "7436928150");
	data5.put("App Type", "all");
	data5.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data5.put("App Enabled", "Yes");
	data5.put("Checkout Plan Name", "Ayan Yearly Checkout Enterprise Plan");
	data5.put("Spaces Plan Name", "Ayan Weekly Spaces Growth Plan");
	data5.put("Hire Plan Name", "Ayan Monthly Hire Business Plan");
	data5.put("Hr Plan Name", "Ayan HR New Weekly Plan");
	data5.put("Users", "63");
	data5.put("Group", "Gold II");
	data5.put("Account Manager", "Ayan Test Manager");
	data5.put("Staff Notes", "Testing UK-based all app account creation with yearly checkout, weekly spaces, monthly hire, and weekly HR plans, users value, newsletter subscription, valid group, and internal staff note validation.");

	TreeMap<String, String> data6 = new TreeMap<String, String>();
	data6.put("First Name", "Marit");
	data6.put("Middle Name", "Johanna");
	data6.put("Last Name", "Overmars");
	data6.put("Company Name", "Overmars Employee Systems BV");
	data6.put("Country", "Netherlands");
	data6.put("Email", "marit.johanna.overmars.account131@yopmail.com");
	data6.put("Subscribe News", "No");
	data6.put("Country Code", "+31");
	data6.put("Phone Number", "681739524");
	data6.put("App Type", "hr");
	data6.put("App Name", "Simplified HR");
	data6.put("App Enabled", "Yes");
	data6.put("Plan Name", "Ayan HR New Weekly Plan");
	data6.put("Users", "35");
	data6.put("Group", "Diamond");
	data6.put("Account Manager", "Ayan Test Manager");
	data6.put("Staff Notes", "Creating this Netherlands-based HR account to verify weekly HR plan assignment, users field value, newsletter disabled state, valid group selection, and account manager mapping.");

	TreeMap<String, String> data7 = new TreeMap<String, String>();
	data7.put("First Name", "Bastian");
	data7.put("Middle Name", "Erich");
	data7.put("Last Name", "Kollmann");
	data7.put("Company Name", "Kollmann Unified SaaS GmbH");
	data7.put("Country", "Austria");
	data7.put("Email", "bastian.erich.kollmann.account132@yopmail.com");
	data7.put("Subscribe News", "Yes");
	data7.put("Country Code", "+43");
	data7.put("Phone Number", "6762849153");
	data7.put("App Type", "all");
	data7.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data7.put("App Enabled", "Yes");
	data7.put("Checkout Plan Name", "test weekly checkout plan");
	data7.put("Spaces Plan Name", "Space Weekly Plan 99");
	data7.put("Hire Plan Name", "testyearly");
	data7.put("Hr Plan Name", "Ayan Weekly HR Growth Plan");
	data7.put("Users", "44");
	data7.put("Group", "Silver");
	data7.put("Account Manager", "Ayan Test Manager");
	data7.put("Staff Notes", "Testing Austria-based all app account creation with weekly checkout, weekly spaces, yearly hire, and weekly HR plans, including users value, newsletter selection, group assignment, and account manager mapping.");

	TreeMap<String, String> data8 = new TreeMap<String, String>();
	data8.put("First Name", "Kinga");
	data8.put("Middle Name", "Elzbieta");
	data8.put("Last Name", "Wroblewska");
	data8.put("Company Name", "Wroblewska Recruitment Systems Sp z oo");
	data8.put("Country", "Poland");
	data8.put("Email", "kinga.elzbieta.wroblewska.account133@yopmail.com");
	data8.put("Subscribe News", "No");
	data8.put("Country Code", "+48");
	data8.put("Phone Number", "514829637");
	data8.put("App Type", "hire");
	data8.put("App Name", "Simplified Hire");
	data8.put("App Enabled", "Yes");
	data8.put("Plan Name", "testyearly");
	data8.put("Users", "22");
	data8.put("Group", "Gold");
	data8.put("Account Manager", "Ayan Test Manager");
	data8.put("Staff Notes", "This Poland-based hire account is used to validate yearly hire plan assignment, users value, newsletter disabled condition, valid group selection, and customer profile details.");

	TreeMap<String, String> data9 = new TreeMap<String, String>();
	data9.put("First Name", "Iker");
	data9.put("Middle Name", "Rafael");
	data9.put("Last Name", "Belmonte");
	data9.put("Company Name", "Belmonte Multi App Operations SL");
	data9.put("Country", "Spain");
	data9.put("Email", "iker.rafael.belmonte.account134@yopmail.com");
	data9.put("Subscribe News", "Yes");
	data9.put("Country Code", "+34");
	data9.put("Phone Number", "638492715");
	data9.put("App Type", "all");
	data9.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data9.put("App Enabled", "Yes");
	data9.put("Checkout Plan Name", "Ayan Checkout New Yearly Plan");
	data9.put("Spaces Plan Name", "Ayan Yearly Spaces Enterprise Plan");
	data9.put("Hire Plan Name", "testyearly");
	data9.put("Hr Plan Name", "Ayan Yearly HR Enterprise Plan");
	data9.put("Users", "69");
	data9.put("Group", "Gold II");
	data9.put("Account Manager", "Ayan Test Manager");
	data9.put("Staff Notes", "Verifying Spain-based all app account creation with yearly checkout, yearly spaces, yearly hire, and yearly HR plans, users value, newsletter subscription, valid group, and staff note coverage.");

	TreeMap<String, String> data10 = new TreeMap<String, String>();
	data10.put("First Name", "Noah");
	data10.put("Middle Name", "Emil");
	data10.put("Last Name", "Frei");
	data10.put("Company Name", "Frei Checkout Solutions AG");
	data10.put("Country", "Switzerland");
	data10.put("Email", "noah.emil.frei.account135@yopmail.com");
	data10.put("Subscribe News", "No");
	data10.put("Country Code", "+41");
	data10.put("Phone Number", "762915483");
	data10.put("App Type", "checkout");
	data10.put("App Name", "Simplified Checkout");
	data10.put("App Enabled", "Yes");
	data10.put("Plan Name", "Ayan Yearly Checkout Enterprise Plan");
	data10.put("Users", "31");
	data10.put("Group", "Diamond");
	data10.put("Account Manager", "Ayan Test Manager");
	data10.put("Staff Notes", "Creating this Switzerland-based checkout account to verify yearly checkout enterprise plan assignment, users value, newsletter disabled condition, valid group, and staff note save flow.");

	TreeMap<String, String> data11 = new TreeMap<String, String>();
	data11.put("First Name", "Astrid");
	data11.put("Middle Name", "Helene");
	data11.put("Last Name", "Norberg");
	data11.put("Company Name", "Norberg Unified People Services AB");
	data11.put("Country", "Sweden");
	data11.put("Email", "astrid.helene.norberg.account136@yopmail.com");
	data11.put("Subscribe News", "Yes");
	data11.put("Country Code", "+46");
	data11.put("Phone Number", "708426391");
	data11.put("App Type", "all");
	data11.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data11.put("App Enabled", "Yes");
	data11.put("Checkout Plan Name", "Checkout Weekly 999");
	data11.put("Spaces Plan Name", "Ayan Weekly Spaces Growth Plan");
	data11.put("Hire Plan Name", "Ayan Monthly Hire Business Plan");
	data11.put("Hr Plan Name", "Ayan Weekly HR Growth Plan");
	data11.put("Users", "52");
	data11.put("Group", "Silver");
	data11.put("Account Manager", "Ayan Test Manager");
	data11.put("Staff Notes", "Testing Sweden-based all app account creation with weekly checkout, weekly spaces, monthly hire, and weekly HR plans, users count, newsletter subscription enabled, and group selection.");

	TreeMap<String, String> data12 = new TreeMap<String, String>();
	data12.put("First Name", "Etienne");
	data12.put("Middle Name", "Luc");
	data12.put("Last Name", "Perrot");
	data12.put("Company Name", "Perrot Workspace Advisory SAS");
	data12.put("Country", "France");
	data12.put("Email", "etienne.luc.perrot.account137@yopmail.com");
	data12.put("Subscribe News", "No");
	data12.put("Country Code", "+33");
	data12.put("Phone Number", "754683921");
	data12.put("App Type", "spaces");
	data12.put("App Name", "Simplified Spaces");
	data12.put("App Enabled", "Yes");
	data12.put("Plan Name", "Ayan Weekly Spaces Growth Plan");
	data12.put("Users", "27");
	data12.put("Group", "Gold");
	data12.put("Account Manager", "Ayan Test Manager");
	data12.put("Staff Notes", "Creating this France-based spaces account to validate weekly spaces growth plan selection, users value, newsletter unchecked condition, valid group selection, and internal staff note coverage.");

	TreeMap<String, String> data13 = new TreeMap<String, String>();
	data13.put("First Name", "Marcello");
	data13.put("Middle Name", "Vittorio");
	data13.put("Last Name", "Sanna");
	data13.put("Company Name", "Sanna Enterprise SaaS SRL");
	data13.put("Country", "Italy");
	data13.put("Email", "marcello.vittorio.sanna.account138@yopmail.com");
	data13.put("Subscribe News", "Yes");
	data13.put("Country Code", "+39");
	data13.put("Phone Number", "3496825714");
	data13.put("App Type", "all");
	data13.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data13.put("App Enabled", "Yes");
	data13.put("Checkout Plan Name", "Ayan Yearly Checkout Enterprise Plan");
	data13.put("Spaces Plan Name", "Space Weekly Plan 99");
	data13.put("Hire Plan Name", "testyearly");
	data13.put("Hr Plan Name", "Ayan HR New Weekly Plan");
	data13.put("Users", "58");
	data13.put("Group", "Gold II");
	data13.put("Account Manager", "Ayan Test Manager");
	data13.put("Staff Notes", "Validating Italy-based all app account creation with yearly checkout, weekly spaces, yearly hire, and weekly HR plans, users value, newsletter subscription, valid group selection, and account manager assignment.");

	TreeMap<String, String> data14 = new TreeMap<String, String>();
	data14.put("First Name", "Diederik");
	data14.put("Middle Name", "Pieter");
	data14.put("Last Name", "Voskamp");
	data14.put("Company Name", "Voskamp Employee Operations BV");
	data14.put("Country", "Netherlands");
	data14.put("Email", "diederik.pieter.voskamp.account139@yopmail.com");
	data14.put("Subscribe News", "No");
	data14.put("Country Code", "+31");
	data14.put("Phone Number", "682495173");
	data14.put("App Type", "hr");
	data14.put("App Name", "Simplified HR");
	data14.put("App Enabled", "Yes");
	data14.put("Plan Name", "Ayan Yearly HR Enterprise Plan");
	data14.put("Users", "46");
	data14.put("Group", "Diamond");
	data14.put("Account Manager", "Ayan Test Manager");
	data14.put("Staff Notes", "Testing Netherlands-based HR account creation with yearly HR enterprise plan assignment, users field value, newsletter disabled state, valid group selection, and staff note entry.");

	TreeMap<String, String> data15 = new TreeMap<String, String>();
	data15.put("First Name", "Mihai");
	data15.put("Middle Name", "Gabriel");
	data15.put("Last Name", "Ionescu");
	data15.put("Company Name", "Ionescu Unified Business Operations SRL");
	data15.put("Country", "Romania");
	data15.put("Email", "mihai.gabriel.ionescu.account140@yopmail.com");
	data15.put("Subscribe News", "Yes");
	data15.put("Country Code", "+40");
	data15.put("Phone Number", "735928416");
	data15.put("App Type", "all");
	data15.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data15.put("App Enabled", "Yes");
	data15.put("Checkout Plan Name", "test weekly checkout plan");
	data15.put("Spaces Plan Name", "Ayan Yearly Spaces Enterprise Plan");
	data15.put("Hire Plan Name", "testyearly");
	data15.put("Hr Plan Name", "Ayan Yearly HR Enterprise Plan");
	data15.put("Users", "64");
	data15.put("Group", "Silver");
	data15.put("Account Manager", "Ayan Test Manager");
	data15.put("Staff Notes", "Creating Romania-based all app account to verify weekly checkout, yearly spaces, yearly hire, and yearly HR plan assignment, users field entry, newsletter subscription, and valid group selection.");

	TreeMap<String, String> data16 = new TreeMap<String, String>();
	data16.put("First Name", "Tereza");
	data16.put("Middle Name", "Lucja");
	data16.put("Last Name", "Nowicka");
	data16.put("Company Name", "Nowicka Talent Advisory Sp z oo");
	data16.put("Country", "Poland");
	data16.put("Email", "tereza.lucja.nowicka.account141@yopmail.com");
	data16.put("Subscribe News", "No");
	data16.put("Country Code", "+48");
	data16.put("Phone Number", "516374829");
	data16.put("App Type", "hire");
	data16.put("App Name", "Simplified Hire");
	data16.put("App Enabled", "Yes");
	data16.put("Plan Name", "testyearly");
	data16.put("Users", "29");
	data16.put("Group", "Gold");
	data16.put("Account Manager", "Ayan Test Manager");
	data16.put("Staff Notes", "Creating this Poland-based hire account to verify yearly hire plan selection, users value, newsletter disabled condition, valid group assignment, and internal account manager mapping.");

	TreeMap<String, String> data17 = new TreeMap<String, String>();
	data17.put("First Name", "Beatrice");
	data17.put("Middle Name", "Annabel");
	data17.put("Last Name", "Kingsley");
	data17.put("Company Name", "Kingsley Multi Product Services Ltd");
	data17.put("Country", "United Kingdom");
	data17.put("Email", "beatrice.annabel.kingsley.account142@yopmail.com");
	data17.put("Subscribe News", "Yes");
	data17.put("Country Code", "+44");
	data17.put("Phone Number", "7469281350");
	data17.put("App Type", "all");
	data17.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data17.put("App Enabled", "Yes");
	data17.put("Checkout Plan Name", "Ayan Checkout New Yearly Plan");
	data17.put("Spaces Plan Name", "Ayan Weekly Spaces Growth Plan");
	data17.put("Hire Plan Name", "Ayan Monthly Hire Business Plan");
	data17.put("Hr Plan Name", "Ayan Weekly HR Growth Plan");
	data17.put("Users", "55");
	data17.put("Group", "Gold II");
	data17.put("Account Manager", "Ayan Test Manager");
	data17.put("Staff Notes", "Testing UK-based all app account creation with yearly checkout, weekly spaces, monthly hire, and weekly HR plans together, users value, newsletter subscription, and valid group selection.");

	TreeMap<String, String> data18 = new TreeMap<String, String>();
	data18.put("First Name", "Nora");
	data18.put("Middle Name", "Sofie");
	data18.put("Last Name", "Eikeland");
	data18.put("Company Name", "Eikeland Unified Operations AS");
	data18.put("Country", "Norway");
	data18.put("Email", "nora.sofie.eikeland.account143@yopmail.com");
	data18.put("Subscribe News", "No");
	data18.put("Country Code", "+47");
	data18.put("Phone Number", "47928361");
	data18.put("App Type", "all");
	data18.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data18.put("App Enabled", "Yes");
	data18.put("Checkout Plan Name", "Checkout Weekly 999");
	data18.put("Spaces Plan Name", "Ayan Yearly Spaces Enterprise Plan");
	data18.put("Hire Plan Name", "testyearly");
	data18.put("Hr Plan Name", "Ayan HR New Weekly Plan");
	data18.put("Users", "49");
	data18.put("Group", "Diamond");
	data18.put("Account Manager", "Ayan Test Manager");
	data18.put("Staff Notes", "Creating Norway-based all app account with weekly checkout, yearly spaces, yearly hire, and weekly HR plan selection, users value, newsletter disabled state, and group mapping.");

	TreeMap<String, String> data19 = new TreeMap<String, String>();
	data19.put("First Name", "Greta");
	data19.put("Middle Name", "Wilhelmina");
	data19.put("Last Name", "Hartmann");
	data19.put("Company Name", "Hartmann Complete SaaS GmbH");
	data19.put("Country", "Germany");
	data19.put("Email", "greta.wilhelmina.hartmann.account144@yopmail.com");
	data19.put("Subscribe News", "Yes");
	data19.put("Country Code", "+49");
	data19.put("Phone Number", "15762839410");
	data19.put("App Type", "all");
	data19.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data19.put("App Enabled", "Yes");
	data19.put("Checkout Plan Name", "Ayan Yearly Checkout Enterprise Plan");
	data19.put("Spaces Plan Name", "Ayan Weekly Spaces Growth Plan");
	data19.put("Hire Plan Name", "testyearly");
	data19.put("Hr Plan Name", "Ayan Yearly HR Enterprise Plan");
	data19.put("Users", "67");
	data19.put("Group", "Silver");
	data19.put("Account Manager", "Ayan Test Manager");
	data19.put("Staff Notes", "Validating Germany-based all app account with yearly checkout, weekly spaces, yearly hire, and yearly HR plans, users value, newsletter subscription, valid group selection, and staff notes.");

	TreeMap<String, String> data20 = new TreeMap<String, String>();
	data20.put("First Name", "Amara");
	data20.put("Middle Name", "Elise");
	data20.put("Last Name", "Dufour");
	data20.put("Company Name", "Dufour Enterprise Coordination SAS");
	data20.put("Country", "France");
	data20.put("Email", "amara.elise.dufour.account145@yopmail.com");
	data20.put("Subscribe News", "No");
	data20.put("Country Code", "+33");
	data20.put("Phone Number", "768514293");
	data20.put("App Type", "all");
	data20.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data20.put("App Enabled", "Yes");
	data20.put("Checkout Plan Name", "test weekly checkout plan");
	data20.put("Spaces Plan Name", "Ayan Weekly Spaces Growth Plan");
	data20.put("Hire Plan Name", "Ayan Monthly Hire Business Plan");
	data20.put("Hr Plan Name", "Ayan Weekly HR Growth Plan");
	data20.put("Users", "53");
	data20.put("Group", "Gold");
	data20.put("Account Manager", "Ayan Test Manager");
	data20.put("Staff Notes", "Creating France-based all app account to verify weekly checkout, weekly spaces, monthly hire, and weekly HR plans together, users field value, newsletter disabled state, and valid group selection.");

	return new Object[][] {
		{ data1 },
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
		{ data15 },
		{ data16 },
		{ data17 },
		{ data18 },
		{ data19 },
		{ data20 }
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