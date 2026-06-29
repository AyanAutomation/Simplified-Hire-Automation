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
	System.out.println();
}

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

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🔹 Scenario Title:</b> Validate SaaS Admin Account creation with app plan assignment.");
	System.out.println("🔹 Scenario Title: Validate SaaS Admin Account creation with app plan assignment.");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📘 Description:</b> Login into SaaS Admin, open Create Account form, enter account holder details, select country, fill contact information, assign app plan, enter user count, and continue account creation flow.");
	System.out.println("📘 Description: Login into SaaS Admin, open Create Account form, enter account holder details, select country, fill contact information, assign app plan, enter user count, and continue account creation flow.");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📥 Input:</b> Name = " + First_Name + " " + Middle_Name + " " + Last_Name + " | Company = " + Company_Name + " | Country = " + Country + " | Email = " + Email + " | Country Code = " + Country_Code + " | Phone Number = " + Phone_Number + " | App Name = " + App_Name + " | App Enabled = " + App_Enabled + " | Plan Name = " + Plan_Name + " | Users = " + Users + " | Group = " + Group + " | Account Manager = " + Account_Manager);
	System.out.println("📥 Input: Name = " + First_Name + " " + Middle_Name + " " + Last_Name + " | Company = " + Company_Name + " | Country = " + Country + " | Email = " + Email + " | Country Code = " + Country_Code + " | Phone Number = " + Phone_Number + " | App Name = " + App_Name + " | App Enabled = " + App_Enabled + " | Plan Name = " + Plan_Name + " | Users = " + Users + " | Group = " + Group + " | Account Manager = " + Account_Manager);

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>✅ Expected:</b> Admin should be able to fill the account creation form and assign the selected app plan successfully.");
	System.out.println("✅ Expected: Admin should be able to fill the account creation form and assign the selected app plan successfully.");
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

	step = App_Plan_Assigner(Form_Data, step);

	return step;
}
	
	public int App_Plan_Assigner(TreeMap<String, String> Form_Data, int step) throws InterruptedException, IOException{

	String App_Name = Form_Data.get("App Name");
	String App_Enabled = Form_Data.get("App Enabled");
	String Plan_Name = Form_Data.get("Plan Name");
	String Users = Form_Data.get("Users");
	String App_Type = Form_Data.get("App Type");

	boolean App_Enabled_Status = App_Enabled.equalsIgnoreCase("Yes");
	String App_Type_Lower = App_Type.toLowerCase().trim();

	Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
	Repeat rp = new Repeat(d);
	JavascriptExecutor js = (JavascriptExecutor) d;

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Navigate to app plan assignment section.");
	System.out.println("Step " + (step - 1) + ": Navigate to app plan assignment section.");
	WebElement Plan_Tab = p.Plan_Tab();
	rp.Scroll_to_element(Plan_Tab);
	js.executeScript("window.scrollBy(0, -180);");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> App plan assignment section reached successfully.");
	System.out.println("🟨 Actual: App plan assignment section reached successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Enable required app toggle based on App Type.");
	System.out.println("Step " + (step - 1) + ": Enable required app toggle based on App Type.");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> App Name = " + App_Name + " | App Type = " + App_Type + " | App Enabled = " + App_Enabled + " | Boolean Status = " + App_Enabled_Status);
	System.out.println("🟨 Debug: App Name = " + App_Name + " | App Type = " + App_Type + " | App Enabled = " + App_Enabled + " | Boolean Status = " + App_Enabled_Status);

	if(App_Enabled_Status) {
		List<WebElement> Plan_Toggles = p.Plan_toggle_Buttons();
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> App toggle count fetched = " + Plan_Toggles.size());
		System.out.println("🟨 Debug: App toggle count fetched = " + Plan_Toggles.size());

		if(App_Type_Lower.contains("hr")) {
			WebElement HR_swicth = Plan_Toggles.get(0);
			HR_swicth.click();
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Simplified HR toggle clicked successfully.");
			System.out.println("🟨 Actual: Simplified HR toggle clicked successfully.");
		}
		if(App_Type_Lower.contains("checkout")) {
			WebElement checkout_swicth = Plan_Toggles.get(1);
			checkout_swicth.click();
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Simplified Checkout toggle clicked successfully.");
			System.out.println("🟨 Actual: Simplified Checkout toggle clicked successfully.");
		}
		if(App_Type_Lower.contains("hire")) {
			WebElement Hire_swicth = Plan_Toggles.get(2);
			Hire_swicth.click();
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Simplified Hire toggle clicked successfully.");
			System.out.println("🟨 Actual: Simplified Hire toggle clicked successfully.");
		}
		if(App_Type_Lower.contains("spaces")) {
			WebElement Spaces_swicth = Plan_Toggles.get(3);
			Spaces_swicth.click();
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Simplified Spaces toggle clicked successfully.");
			System.out.println("🟨 Actual: Simplified Spaces toggle clicked successfully.");
		}

		Thread.sleep(800);
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Required app toggle action completed. App Name = " + App_Name + " | App Type = " + App_Type + " | App Enabled data = " + App_Enabled);
		System.out.println("🟨 Actual: Required app toggle action completed. App Name = " + App_Name + " | App Type = " + App_Type + " | App Enabled data = " + App_Enabled);
	} else {
		Report_Listen.log_print_in_report().log(Status.WARNING, "<b>⚠ Actual:</b> App plan toggle skipped because App Enabled data = " + App_Enabled + " | App Type = " + App_Type);
		System.out.println("⚠ Actual: App plan toggle skipped because App Enabled data = " + App_Enabled + " | App Type = " + App_Type);
		return step;
	}
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Open app plan dropdown and search required plan.");
	System.out.println("Step " + (step - 1) + ": Open app plan dropdown and search required plan.");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> Plan search input will be selected based on App Type = " + App_Type + " | Plan Name = " + Plan_Name);
	System.out.println("🟨 Debug: Plan search input will be selected based on App Type = " + App_Type + " | Plan Name = " + Plan_Name);

	List<WebElement> Plan_Select = p.Plan_select_dropdowm();
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> Plan dropdown field count fetched = " + Plan_Select.size());
	System.out.println("🟨 Debug: Plan dropdown field count fetched = " + Plan_Select.size());

	WebElement Plan_select_field = Plan_Select.get(0);
	rp.movetoelement(Plan_select_field);
	Plan_select_field.click();
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> App plan dropdown opened successfully.");
	System.out.println("🟨 Actual: App plan dropdown opened successfully.");

	if(App_Type_Lower.contains("hr")) {
		p.Hr_Plan_Input_feild().sendKeys(Plan_Name);
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> HR plan search field used and plan name entered = " + Plan_Name);
		System.out.println("🟨 Actual: HR plan search field used and plan name entered = " + Plan_Name);
	}
	if(App_Type_Lower.contains("checkout")) {
		p.Checkout_Plan_Input_feild().sendKeys(Plan_Name);
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Checkout plan search field used and plan name entered = " + Plan_Name);
		System.out.println("🟨 Actual: Checkout plan search field used and plan name entered = " + Plan_Name);
	}
	if(App_Type_Lower.contains("hire")) {
		p.Hire_Plan_Input_feild().sendKeys(Plan_Name);
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Hire plan search field used and plan name entered = " + Plan_Name);
		System.out.println("🟨 Actual: Hire plan search field used and plan name entered = " + Plan_Name);
	}
	if(App_Type_Lower.contains("spaces")) {
		p.Spaces_Plan_Input_feild().sendKeys(Plan_Name);
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Spaces plan search field used and plan name entered = " + Plan_Name);
		System.out.println("🟨 Actual: Spaces plan search field used and plan name entered = " + Plan_Name);
	}
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Select searched app plan from dropdown list.");
	System.out.println("Step " + (step - 1) + ": Select searched app plan from dropdown list.");
	WebElement Owner_dropdown_list = d.findElement(By.xpath("(//*[contains(@class,'rc-virtual-list-holder')])[3]"));
	rp.wait_for_theElement(Owner_dropdown_list);
	Thread.sleep(800);
	rp.movetoelement(Owner_dropdown_list);

	List<WebElement> plan_options = Owner_dropdown_list.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> App plan option count after search = " + plan_options.size() + " | Searched Plan = " + Plan_Name + " | App Type = " + App_Type);
	System.out.println("🟨 Debug: App plan option count after search = " + plan_options.size() + " | Searched Plan = " + Plan_Name + " | App Type = " + App_Type);

	if(plan_options.size() > 0) {
		plan_options.get(0).click();
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> App plan selected successfully. App Type = " + App_Type + " | Plan Name = " + Plan_Name);
		System.out.println("🟨 Actual: App plan selected successfully. App Type = " + App_Type + " | Plan Name = " + Plan_Name);
	} else {
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> No app plan option found after searching plan. App Type = " + App_Type + " | Plan Name = " + Plan_Name);
		System.out.println("❌ Actual: No app plan option found after searching plan. App Type = " + App_Type + " | Plan Name = " + Plan_Name);
		return step;
	}
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Enter limit/user value for selected app plan.");
	System.out.println("Step " + (step - 1) + ": Enter limit/user value for selected app plan.");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> Field selection will be done based on App Type = " + App_Type + " | Value = " + Users);
	System.out.println("🟨 Debug: Field selection will be done based on App Type = " + App_Type + " | Value = " + Users);

	if(App_Type_Lower.contains("hr")) {
		p.hr_number_of_users_input_field().sendKeys(Users);
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> HR number of users field filled successfully. Users = " + Users);
		System.out.println("🟨 Actual: HR number of users field filled successfully. Users = " + Users);
	}
	if(App_Type_Lower.contains("checkout")) {
		p.checkout_number_of_shared_instances_input_field().sendKeys(Users);
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Checkout shared instances field filled successfully. Shared Instances = " + Users);
		System.out.println("🟨 Actual: Checkout shared instances field filled successfully. Shared Instances = " + Users);
	}
	if(App_Type_Lower.contains("hire")) {
		p.hire_number_of_users_input_field().sendKeys(Users);
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Hire number of users field filled successfully. Users = " + Users);
		System.out.println("🟨 Actual: Hire number of users field filled successfully. Users = " + Users);
	}
	if(App_Type_Lower.contains("spaces")) {
		p.spaces_number_of_locations_input_field().sendKeys(Users);
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Spaces number of locations field filled successfully. Locations = " + Users);
		System.out.println("🟨 Actual: Spaces number of locations field filled successfully. Locations = " + Users);
	}

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>✅ Actual:</b> App plan assignment completed successfully. App Name = " + App_Name + " | App Type = " + App_Type + " | Plan Name = " + Plan_Name + " | Entered Value = " + Users);
	System.out.println("✅ Actual: App plan assignment completed successfully. App Name = " + App_Name + " | App Type = " + App_Type + " | Plan Name = " + Plan_Name + " | Entered Value = " + Users);
	System.out.println();

	return step;
}
	
@DataProvider
public Object[][] Account_Create_Data() {

	TreeMap<String, String> data1 = new TreeMap<String, String>();
	data1.put("First Name", "Johann");
	data1.put("Middle Name", "Leopold");
	data1.put("Last Name", "Adler");
	data1.put("Company Name", "Adler Checkout Systems GmbH");
	data1.put("Country", "Germany");
	data1.put("Email", "johann.leopold.adler.account076@yopmail.com");
	data1.put("Subscribe News", "Yes");
	data1.put("Country Code", "+49");
	data1.put("Phone Number", "15738492610");
	data1.put("App Type", "checkout");
	data1.put("App Name", "Simplified Checkout");
	data1.put("App Enabled", "Yes");
	data1.put("Plan Name", "Ayan Monthly Checkout Business Plan");
	data1.put("Users", "22");
	data1.put("Group", "Germany Checkout Business Group");
	data1.put("Account Manager", "Admin Ayan Sengupta");
	data1.put("Staff Notes", "Creating this Germany-based account to validate checkout app assignment with monthly checkout business plan, users value, newsletter subscription, customer details, and account manager mapping.");

	TreeMap<String, String> data2 = new TreeMap<String, String>();
	data2.put("First Name", "Mireille");
	data2.put("Middle Name", "Odette");
	data2.put("Last Name", "Vasseur");
	data2.put("Company Name", "Vasseur Workspace Services SAS");
	data2.put("Country", "France");
	data2.put("Email", "mireille.odette.vasseur.account077@yopmail.com");
	data2.put("Subscribe News", "No");
	data2.put("Country Code", "+33");
	data2.put("Phone Number", "769284153");
	data2.put("App Type", "spaces");
	data2.put("App Name", "Simplified Spaces");
	data2.put("App Enabled", "Yes");
	data2.put("Plan Name", "Ayan Daily Spaces Starter Plan");
	data2.put("Users", "15");
	data2.put("Group", "France Spaces Starter Group");
	data2.put("Account Manager", "Admin Ayan Sengupta");
	data2.put("Staff Notes", "Testing France-based account creation with spaces app assignment, daily spaces starter plan, users value, newsletter disabled state, and staff notes save behavior.");

	TreeMap<String, String> data3 = new TreeMap<String, String>();
	data3.put("First Name", "Anders");
	data3.put("Middle Name", "Henrik");
	data3.put("Last Name", "Solberg");
	data3.put("Company Name", "Solberg HR Operations AS");
	data3.put("Country", "Norway");
	data3.put("Email", "anders.henrik.solberg.account078@yopmail.com");
	data3.put("Subscribe News", "Yes");
	data3.put("Country Code", "+47");
	data3.put("Phone Number", "48173926");
	data3.put("App Type", "hr");
	data3.put("App Name", "Simplified HR");
	data3.put("App Enabled", "Yes");
	data3.put("Plan Name", "HR Plan");
	data3.put("Users", "28");
	data3.put("Group", "Norway HR Operations Group");
	data3.put("Account Manager", "Admin Ayan Sengupta");
	data3.put("Staff Notes", "Validating Norway-based account creation with HR app assignment, HR Plan selection, users value, newsletter subscription, internal group mapping, and account manager selection.");

	TreeMap<String, String> data4 = new TreeMap<String, String>();
	data4.put("First Name", "Vittorio");
	data4.put("Middle Name", "Alessandro");
	data4.put("Last Name", "Rinaldi");
	data4.put("Company Name", "Rinaldi Hiring Solutions SRL");
	data4.put("Country", "Italy");
	data4.put("Email", "vittorio.alessandro.rinaldi.account079@yopmail.com");
	data4.put("Subscribe News", "No");
	data4.put("Country Code", "+39");
	data4.put("Phone Number", "3514839276");
	data4.put("App Type", "hire");
	data4.put("App Name", "Simplified Hire");
	data4.put("App Enabled", "Yes");
	data4.put("Plan Name", "15 day Freemium");
	data4.put("Users", "17");
	data4.put("Group", "Italy Hire Freemium Group");
	data4.put("Account Manager", "Admin Ayan Sengupta");
	data4.put("Staff Notes", "Creating this Italy-based account to verify hire app assignment, 15 day Freemium plan selection, users value, unique contact details, and staff note capture.");

	TreeMap<String, String> data5 = new TreeMap<String, String>();
	data5.put("First Name", "Benedict");
	data5.put("Middle Name", "Oliver");
	data5.put("Last Name", "Ashcroft");
	data5.put("Company Name", "Ashcroft Digital Payments Ltd");
	data5.put("Country", "United Kingdom");
	data5.put("Email", "benedict.oliver.ashcroft.account080@yopmail.com");
	data5.put("Subscribe News", "Yes");
	data5.put("Country Code", "+44");
	data5.put("Phone Number", "7463918520");
	data5.put("App Type", "checkout");
	data5.put("App Name", "Simplified Checkout");
	data5.put("App Enabled", "Yes");
	data5.put("Plan Name", "New Flow - Paid Plan 1");
	data5.put("Users", "39");
	data5.put("Group", "UK Checkout Paid Group");
	data5.put("Account Manager", "Admin Ayan Sengupta");
	data5.put("Staff Notes", "Testing UK-based checkout account creation with New Flow paid plan, users value, newsletter subscription enabled, customer profile details, and internal staff note validation.");

	TreeMap<String, String> data6 = new TreeMap<String, String>();
	data6.put("First Name", "Femke");
	data6.put("Middle Name", "Johanna");
	data6.put("Last Name", "Blom");
	data6.put("Company Name", "Blom Flexible Offices BV");
	data6.put("Country", "Netherlands");
	data6.put("Email", "femke.johanna.blom.account081@yopmail.com");
	data6.put("Subscribe News", "No");
	data6.put("Country Code", "+31");
	data6.put("Phone Number", "682913745");
	data6.put("App Type", "spaces");
	data6.put("App Name", "Simplified Spaces");
	data6.put("App Enabled", "Yes");
	data6.put("Plan Name", "Space Weekly Plan 99");
	data6.put("Users", "18");
	data6.put("Group", "Netherlands Spaces Weekly Group");
	data6.put("Account Manager", "Admin Ayan Sengupta");
	data6.put("Staff Notes", "Creating this Netherlands-based account to verify spaces app assignment, weekly spaces plan selection, users value, newsletter unchecked state, and country code selection.");

	TreeMap<String, String> data7 = new TreeMap<String, String>();
	data7.put("First Name", "Clemens");
	data7.put("Middle Name", "Josef");
	data7.put("Last Name", "Leitner");
	data7.put("Company Name", "Leitner Employee Management GmbH");
	data7.put("Country", "Austria");
	data7.put("Email", "clemens.josef.leitner.account082@yopmail.com");
	data7.put("Subscribe News", "Yes");
	data7.put("Country Code", "+43");
	data7.put("Phone Number", "6643918275");
	data7.put("App Type", "hr");
	data7.put("App Name", "Simplified HR");
	data7.put("App Enabled", "Yes");
	data7.put("Plan Name", "Ayan Monthly HR Business Plan");
	data7.put("Users", "34");
	data7.put("Group", "Austria HR Business Group");
	data7.put("Account Manager", "Admin Ayan Sengupta");
	data7.put("Staff Notes", "Testing Austria-based account creation with HR app assignment, monthly HR business plan, users input field, newsletter selection, and internal group assignment.");

	TreeMap<String, String> data8 = new TreeMap<String, String>();
	data8.put("First Name", "Milena");
	data8.put("Middle Name", "Agnieszka");
	data8.put("Last Name", "Zielinska");
	data8.put("Company Name", "Zielinska Recruitment Systems Sp z oo");
	data8.put("Country", "Poland");
	data8.put("Email", "milena.agnieszka.zielinska.account083@yopmail.com");
	data8.put("Subscribe News", "No");
	data8.put("Country Code", "+48");
	data8.put("Phone Number", "512946378");
	data8.put("App Type", "hire");
	data8.put("App Name", "Simplified Hire");
	data8.put("App Enabled", "Yes");
	data8.put("Plan Name", "Ayan Monthly Hire Business Plan");
	data8.put("Users", "26");
	data8.put("Group", "Poland Hire Business Group");
	data8.put("Account Manager", "Admin Ayan Sengupta");
	data8.put("Staff Notes", "This Poland-based customer account is used to validate hire app assignment, monthly hire business plan, users value, newsletter disabled state, and internal account setup information.");

	TreeMap<String, String> data9 = new TreeMap<String, String>();
	data9.put("First Name", "Rodrigo");
	data9.put("Middle Name", "Mateo");
	data9.put("Last Name", "Naranjo");
	data9.put("Company Name", "Naranjo Checkout Advisory SL");
	data9.put("Country", "Spain");
	data9.put("Email", "rodrigo.mateo.naranjo.account084@yopmail.com");
	data9.put("Subscribe News", "Yes");
	data9.put("Country Code", "+34");
	data9.put("Phone Number", "621573849");
	data9.put("App Type", "checkout");
	data9.put("App Name", "Simplified Checkout");
	data9.put("App Enabled", "Yes");
	data9.put("Plan Name", "Checkout Weekly 999");
	data9.put("Users", "31");
	data9.put("Group", "Spain Checkout Weekly Group");
	data9.put("Account Manager", "Admin Ayan Sengupta");
	data9.put("Staff Notes", "Verifying Spain-based customer account creation with checkout app assignment, Checkout Weekly 999 plan, users value, newsletter subscription, and realistic phone number.");

	TreeMap<String, String> data10 = new TreeMap<String, String>();
	data10.put("First Name", "Severin");
	data10.put("Middle Name", "Felix");
	data10.put("Last Name", "Baumann");
	data10.put("Company Name", "Baumann Workspace Operations AG");
	data10.put("Country", "Switzerland");
	data10.put("Email", "severin.felix.baumann.account085@yopmail.com");
	data10.put("Subscribe News", "No");
	data10.put("Country Code", "+41");
	data10.put("Phone Number", "762938415");
	data10.put("App Type", "spaces");
	data10.put("App Name", "Simplified Spaces");
	data10.put("App Enabled", "Yes");
	data10.put("Plan Name", "Ayan Weekly Spaces Growth Plan");
	data10.put("Users", "27");
	data10.put("Group", "Switzerland Spaces Growth Group");
	data10.put("Account Manager", "Admin Ayan Sengupta");
	data10.put("Staff Notes", "Creating Switzerland-based customer account to verify spaces app assignment, weekly spaces growth plan, users value, company details, country selection, and staff note save flow.");

	TreeMap<String, String> data11 = new TreeMap<String, String>();
	data11.put("First Name", "Elsa");
	data11.put("Middle Name", "Matilda");
	data11.put("Last Name", "Sjostrand");
	data11.put("Company Name", "Sjostrand People Services AB");
	data11.put("Country", "Sweden");
	data11.put("Email", "elsa.matilda.sjostrand.account086@yopmail.com");
	data11.put("Subscribe News", "Yes");
	data11.put("Country Code", "+46");
	data11.put("Phone Number", "707361284");
	data11.put("App Type", "hr");
	data11.put("App Name", "Simplified HR");
	data11.put("App Enabled", "Yes");
	data11.put("Plan Name", "Ayan Custom Days HR Flex Plan");
	data11.put("Users", "43");
	data11.put("Group", "Sweden HR Custom Group");
	data11.put("Account Manager", "Admin Ayan Sengupta");
	data11.put("Staff Notes", "Testing Sweden-based account creation with HR app assignment, custom days HR flex plan, users count, newsletter subscription enabled, and internal group assignment.");

	TreeMap<String, String> data12 = new TreeMap<String, String>();
	data12.put("First Name", "Pascal");
	data12.put("Middle Name", "Remi");
	data12.put("Last Name", "Delacroix");
	data12.put("Company Name", "Delacroix Talent Advisory SAS");
	data12.put("Country", "France");
	data12.put("Email", "pascal.remi.delacroix.account087@yopmail.com");
	data12.put("Subscribe News", "No");
	data12.put("Country Code", "+33");
	data12.put("Phone Number", "754291638");
	data12.put("App Type", "hire");
	data12.put("App Name", "Simplified Hire");
	data12.put("App Enabled", "Yes");
	data12.put("Plan Name", "lessthan3-1");
	data12.put("Users", "12");
	data12.put("Group", "France Hire Trial Group");
	data12.put("Account Manager", "Admin Ayan Sengupta");
	data12.put("Staff Notes", "Creating France-based customer account to validate hire app assignment, lessthan3-1 plan, users value, newsletter unchecked condition, and staff note coverage.");

	TreeMap<String, String> data13 = new TreeMap<String, String>();
	data13.put("First Name", "Gabriele");
	data13.put("Middle Name", "Francesco");
	data13.put("Last Name", "Lombardi");
	data13.put("Company Name", "Lombardi Payment Services SRL");
	data13.put("Country", "Italy");
	data13.put("Email", "gabriele.francesco.lombardi.account088@yopmail.com");
	data13.put("Subscribe News", "Yes");
	data13.put("Country Code", "+39");
	data13.put("Phone Number", "3482769153");
	data13.put("App Type", "checkout");
	data13.put("App Name", "Simplified Checkout");
	data13.put("App Enabled", "Yes");
	data13.put("Plan Name", "Ayan Custom Days Checkout Advance Plan");
	data13.put("Users", "35");
	data13.put("Group", "Italy Checkout Advance Group");
	data13.put("Account Manager", "Admin Ayan Sengupta");
	data13.put("Staff Notes", "Validating Italy-based account creation with checkout app assignment, custom days checkout advance plan, users value, newsletter subscription, and account manager selection.");

	TreeMap<String, String> data14 = new TreeMap<String, String>();
	data14.put("First Name", "Jeroen");
	data14.put("Middle Name", "Sebastiaan");
	data14.put("Last Name", "Kuipers");
	data14.put("Company Name", "Kuipers Corporate Spaces BV");
	data14.put("Country", "Netherlands");
	data14.put("Email", "jeroen.sebastiaan.kuipers.account089@yopmail.com");
	data14.put("Subscribe News", "No");
	data14.put("Country Code", "+31");
	data14.put("Phone Number", "681274953");
	data14.put("App Type", "spaces");
	data14.put("App Name", "Simplified Spaces");
	data14.put("App Enabled", "Yes");
	data14.put("Plan Name", "Custom Plan 999");
	data14.put("Users", "24");
	data14.put("Group", "Netherlands Spaces Custom Group");
	data14.put("Account Manager", "Admin Ayan Sengupta");
	data14.put("Staff Notes", "Testing Netherlands-based customer account creation with spaces app assignment, Custom Plan 999, users value, newsletter disabled state, full contact details, and staff note entry.");

	TreeMap<String, String> data15 = new TreeMap<String, String>();
	data15.put("First Name", "Radu");
	data15.put("Middle Name", "Alexandru");
	data15.put("Last Name", "Popescu");
	data15.put("Company Name", "Popescu Strategic HR Operations SRL");
	data15.put("Country", "Romania");
	data15.put("Email", "radu.alexandru.popescu.account090@yopmail.com");
	data15.put("Subscribe News", "Yes");
	data15.put("Country Code", "+40");
	data15.put("Phone Number", "742638915");
	data15.put("App Type", "hr");
	data15.put("App Name", "Simplified HR");
	data15.put("App Enabled", "Yes");
	data15.put("Plan Name", "Pro Test New");
	data15.put("Users", "52");
	data15.put("Group", "Romania HR Pro Group");
	data15.put("Account Manager", "Admin Ayan Sengupta");
	data15.put("Staff Notes", "Creating Romania-based enterprise account to verify HR app assignment, Pro Test New plan, users field entry, newsletter subscription, internal group mapping, and staff note save behavior.");

	return new Object[][] {
	//	{ data1 },
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