package Product_Codeclouds.Project.Simplified;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.stream.IntStream;

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
	    
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

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

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 🌐 APPLICATION ACCESS ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ 🌐 APPLICATION ACCESS ━━━━━━━━━━━━━━");

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

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 🔐 CREDENTIAL ENTRY ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ 🔐 CREDENTIAL ENTRY ━━━━━━━━━━━━━━");

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

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 🏢 PORTAL ACCESS ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ 🏢 PORTAL ACCESS ━━━━━━━━━━━━━━");

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
	        System.out.println();
	    }

	    Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	    System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	    System.out.println();
	}
	
	
public void Saas_Admin_Menu_navigation(String opt_text) throws IOException, InterruptedException {

	    
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 🧭 SAAS ADMIN MENU NAVIGATION ━━━━━━━━━━━━━━</b>");
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>📥 Input:</b> Required Menu Option = " + opt_text);
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>✅ Expected:</b> Required SaaS Admin side menu option should be found and opened successfully.");
		System.out.println("━━━━━━━━━━━━━━ 🧭 SAAS ADMIN MENU NAVIGATION ━━━━━━━━━━━━━━");
		System.out.println("📥 Input: Required Menu Option = " + opt_text);
		System.out.println("✅ Expected: Required SaaS Admin side menu option should be found and opened successfully.");
		System.out.println();

		Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
	   
	/*	try {
			p.Side_menu();
	} catch (Exception mm) { */
			Saas_Admin_Login();
			p.Side_menu();
	//	}
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
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");


	}
	
	
	public void Lead_Module_Accessor() throws IOException, InterruptedException {

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 📂 LEADS MODULE ACCESS ━━━━━━━━━━━━━━</b>");
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step:</b> Open the SaaS Admin Leads module.");
		System.out.println("━━━━━━━━━━━━━━ 📂 LEADS MODULE ACCESS ━━━━━━━━━━━━━━");
		System.out.println("Step: Open the SaaS Admin Leads module.");

		Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
		
		Saas_Admin_Menu_navigation("Leads");
		p.Landed_in_Leads_page_confirmation();
		Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> SaaS Admin Leads module opened successfully.");
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
		System.out.println("✅ Actual: SaaS Admin Leads module opened successfully.");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		
}
	
	
	
	public void list_threedot_dropdown_option_selector(String option) throws InterruptedException {

		Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
		Repeat rp = new Repeat(d);
		
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ ⋮ ROW ACTION MENU ━━━━━━━━━━━━━━</b>");
		System.out.println("━━━━━━━━━━━━━━ ⋮ ROW ACTION MENU ━━━━━━━━━━━━━━");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step:</b> Click on 3 dot button of the first lead in the list to view dropdown options.");
		System.out.println("Step: Click on 3 dot button of the first lead in the list to view dropdown options.");
		System.out.println();
		Thread.sleep(1000);
		List<WebElement>Three_dot_Button= p.List_threedots_button();
		WebElement  First_Rows_Three_dot_Button = Three_dot_Button.get(0);
		rp.movetoelement(First_Rows_Three_dot_Button);
		First_Rows_Three_dot_Button.click();
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step:</b> Open first row three-dot action menu.");
		System.out.println("Step: Open first row three-dot action menu.");


		
		 
        

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> First row three-dot button clicked successfully.");
		System.out.println("🟨 Actual: First row three-dot button clicked successfully.");

		List<WebElement> Dropdown_Options = null;

		try {
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step:</b> Fetch action menu dropdown options after first click.");
			System.out.println("Step: Fetch action menu dropdown options after first click.");

			Dropdown_Options = p.Action_menu_options();

			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Action menu options fetched successfully. Option count = " + Dropdown_Options.size());
			System.out.println("🟨 Actual: Action menu options fetched successfully. Option count = " + Dropdown_Options.size());

		} catch(Exception e) {
			Report_Listen.log_print_in_report().log(Status.WARNING, "<b>⚠ Actual:</b> Action menu options were not fetched after first click. Retrying by clicking first row three-dot button again.<br><b>Reason:</b> " + e.getMessage());
			System.out.println("⚠ Actual: Action menu options were not fetched after first click. Retrying by clicking first row three-dot button again.");
			System.out.println("Reason: " + e.getMessage());

			Three_dot_Button = p.List_threedots_button();
			First_Rows_Three_dot_Button = Three_dot_Button.get(0);

			rp.movetoelement(First_Rows_Three_dot_Button);
			First_Rows_Three_dot_Button.click();

			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> First row three-dot button re-clicked successfully.");
			System.out.println("🟨 Actual: First row three-dot button re-clicked successfully.");

			Dropdown_Options = p.Action_menu_options();

			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Action menu options fetched successfully after retry. Option count = " + Dropdown_Options.size());
			System.out.println("🟨 Actual: Action menu options fetched successfully after retry. Option count = " + Dropdown_Options.size());
		}
		System.out.println();

		boolean Option_Selected = false;

		for(WebElement ele : Dropdown_Options) {

			String text = ele.getText().trim();

			System.out.println("🟨 Debug: Dropdown option found = " + text);

			if(text.equalsIgnoreCase(option)) {

				rp.movetoelement(ele);
				ele.click();

				Option_Selected = true;

				Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Dropdown option selected successfully = " + text);
				System.out.println("🟨 Actual: Dropdown option selected successfully = " + text);
				System.out.println();

				break;
			}
		}

		if(!Option_Selected) {
			Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> Required dropdown option was not found. Expected option = " + option);
			System.out.println("❌ Actual: Required dropdown option was not found. Expected option = " + option);
			System.out.println();
		}


		Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");


	}
	
	


@Test(dataProvider="Account_Create_Data")
public void Draft_Account_Create(TreeMap<String, String> account_data) throws IOException, InterruptedException{

		
		String Company_Name = account_data.get("Company Name");
		String Plan_Name = account_data.get("Plan Name");
		String Users = account_data.get("Users");
		
		Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
		Repeat rp = new Repeat(d);
			

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 📝 DRAFT ACCOUNT CREATION ━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📥 Input:</b> Company = " + Company_Name + " | Plan = " + Plan_Name + " | Users = " + Users);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>✅ Expected:</b> Account form should be saved successfully as a draft and the account list should remain accessible.");
	System.out.println("━━━━━━━━━━━━━━ 📝 DRAFT ACCOUNT CREATION ━━━━━━━━━━━━━━");
	System.out.println("📥 Input: Company = " + Company_Name + " | Plan = " + Plan_Name + " | Users = " + Users);
	System.out.println("✅ Expected: Account form should be saved successfully as a draft and the account list should remain accessible.");
	System.out.println();

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

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 📬 DRAFT CONFIRMATION ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ 📬 DRAFT CONFIRMATION ━━━━━━━━━━━━━━");

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
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

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

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 👤 ACCOUNT CREATION ━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📥 Input:</b> Company = " + Company_Name + " | Email = " + Email + " | Plan = " + Plan_Name + " | Users = " + Users);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>✅ Expected:</b> Account should be saved, invitation should be generated, and the account list should remain accessible.");
	System.out.println("━━━━━━━━━━━━━━ 👤 ACCOUNT CREATION ━━━━━━━━━━━━━━");
	System.out.println("📥 Input: Company = " + Company_Name + " | Email = " + Email + " | Plan = " + Plan_Name + " | Users = " + Users);
	System.out.println("✅ Expected: Account should be saved, invitation should be generated, and the account list should remain accessible.");
	System.out.println();

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

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 📬 INVITATION CONFIRMATION ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ 📬 INVITATION CONFIRMATION ━━━━━━━━━━━━━━");

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
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

	System.out.println(); }


public int /* void */Account_Activator(TreeMap<String, String> account_create_data,int step) throws IOException, InterruptedException{

	Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
	Repeat rp = new Repeat(d);
	Data_Reader f = new Data_Reader();

	String Email = account_create_data.get("Email");
	String Company_Name = account_create_data.get("Company Name");
	String Plan_Name = account_create_data.get("Plan Name");
	String Users = account_create_data.get("Users");
 
	
 

	WebElement Create_Button;
	String Admin_Window = d.getWindowHandle();
	String Activation_Window = "";

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🔹 Scenario Section:</b> Validate account activation using generated invite link.");
	System.out.println("🔹 Scenario Section: Validate account activation using generated invite link.");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📘 Description:</b> Search the newly invited account in SaaS Admin, open Get Invite Link action, copy invite link, open it in a new tab, set password, submit activation form, validate account verified success message, and switch back to SaaS Admin tab for further operations.");
	System.out.println("📘 Description: Search the newly invited account in SaaS Admin, open Get Invite Link action, copy invite link, open it in a new tab, set password, submit activation form, validate account verified success message, and switch back to SaaS Admin tab for further operations.");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📥 Input:</b> Email = " + Email + " | Company = " + Company_Name + " | Plan = " + Plan_Name + " | Users = " + Users);
	System.out.println("📥 Input: Email = " + Email + " | Company = " + Company_Name + " | Plan = " + Plan_Name + " | Users = " + Users);

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>✅ Expected:</b> Account invite link should open successfully, password should be set, account verified success message should be displayed, and control should return to the SaaS Admin account list tab without closing any browser tab.");
	System.out.println("✅ Expected: Account invite link should open successfully, password should be set, account verified success message should be displayed, and control should return to the SaaS Admin account list tab without closing any browser tab.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 🗂️ ACTIVATION SETUP ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ 🗂️ ACTIVATION SETUP ━━━━━━━━━━━━━━");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Store current SaaS Admin tab/window before opening invite link.");
	System.out.println("Step " + (step - 1) + ": Store current SaaS Admin tab/window before opening invite link.");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> SaaS Admin window stored successfully. Window Handle = " + Admin_Window);
	System.out.println("🟨 Actual: SaaS Admin window stored successfully. Window Handle = " + Admin_Window);
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
	WebElement Filter_Clear_Button = p.filter_clear_button();
	Filter_Clear_Button.click();
	try {
		List<WebElement> Loaders = p.Loader();

		if(Loaders != null && Loaders.size() > 0) {
			rp.wait_for_invisibilty_of_theElement(Loaders);

			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Account list loading completed successfully.");
			System.out.println("🟨 Actual: Account list loading completed successfully.");
		} else {
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Account list was already available. Loader was not displayed.");
			System.out.println("🟨 Actual: Account list was already available. Loader was not displayed.");
		}

	} catch(Exception e) {
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Account list was already available. Loader wait was skipped.");
		System.out.println("🟨 Actual: Account list was already available. Loader wait was skipped.");
	}

	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Search invited account using email = " + Email);
	System.out.println("Step " + (step - 1) + ": Search invited account using email = " + Email);
    
	WebElement Search = p.search_field();

	Thread.sleep(750);
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

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 🔗 INVITE LINK ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ 🔗 INVITE LINK ━━━━━━━━━━━━━━");

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
	Activation_Window = d.getWindowHandle();
	d.navigate().to(Invite_link);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Invite link opened successfully in new tab. Activation Window Handle = " + Activation_Window);
	System.out.println("🟨 Actual: Invite link opened successfully in new tab. Activation Window Handle = " + Activation_Window);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 🔐 PASSWORD ACTIVATION ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ 🔐 PASSWORD ACTIVATION ━━━━━━━━━━━━━━");

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

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ ↩️ RETURN TO SAAS ADMIN ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ ↩️ RETURN TO SAAS ADMIN ━━━━━━━━━━━━━━");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Switch back to previous SaaS Admin tab/window after account activation.");
	System.out.println("Step " + (step - 1) + ": Switch back to previous SaaS Admin tab/window after account activation.");
	d.switchTo().window(Admin_Window);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Control switched back to SaaS Admin window successfully without closing any browser tab. Current Window Handle = " + d.getWindowHandle());
	System.out.println("🟨 Actual: Control switched back to SaaS Admin window successfully without closing any browser tab. Current Window Handle = " + d.getWindowHandle());
	System.out.println();
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

	return step;
}

@Test(dataProvider="Account_Create_Data")
public void check_for_added_Account(TreeMap<String, String> account_data)throws InterruptedException, IOException {

	Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
	Repeat rp = new Repeat(d);

	String Email = account_data.get("Email");
	String Company_Name = account_data.get("Company Name");
	String Plan_Name = account_data.get("Plan Name");
	String Users = account_data.get("Users");

	int step = 1;
	boolean account_found = false;

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

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

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 🔍 ACCOUNT SEARCH ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ 🔍 ACCOUNT SEARCH ━━━━━━━━━━━━━━");

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

	System.out.println("🟨 Debug: Account list truncated data count after search = " + truncated_datas.size());
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ ✅ ACCOUNT VERIFICATION ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ ✅ ACCOUNT VERIFICATION ━━━━━━━━━━━━━━");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Verify searched email is present in account list.");
	System.out.println("Step " + (step - 1) + ": Verify searched email is present in account list.");

	for(WebElement truncated_data:truncated_datas) {
		String Text = truncated_data.getText().trim();

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

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

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

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🔹 Scenario Title:</b> Validate SaaS Admin Account creation with app plan, account manager, group, and staff notes assignment.");
	System.out.println("🔹 Scenario Title: Validate SaaS Admin Account creation with app plan, account manager, group, and staff notes assignment.");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📘 Description:</b> Login into SaaS Admin, open Create Account form, enter account holder details, select country, fill contact information, assign app plan, enter limit/user value, select account manager, assign group, enter staff notes, and continue account creation flow.");
	System.out.println("📘 Description: Login into SaaS Admin, open Create Account form, enter account holder details, select country, fill contact information, assign app plan, enter limit/user value, select account manager, assign group, enter staff notes, and continue account creation flow.");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📥 Input:</b> Name = " + First_Name + " " + Middle_Name + " " + Last_Name + " | Company = " + Company_Name + " | Country = " + Country + " | Email = " + Email + " | Country Code = " + Country_Code + " | Phone Number = " + Phone_Number + " | Subscribe News = " + Subscribe_News + " | Subscribe Status = " + Subscribe_News_Status + " | App Name = " + App_Name + " | App Enabled = " + App_Enabled + " | App Enabled Status = " + App_Enabled_Status + " | Plan Name = " + Plan_Name + " | Users = " + Users + " | Group = " + Group + " | Account Manager = " + Account_Manager);
	System.out.println("📥 Input: Name = " + First_Name + " " + Middle_Name + " " + Last_Name + " | Company = " + Company_Name + " | Country = " + Country + " | Email = " + Email + " | Country Code = " + Country_Code + " | Phone Number = " + Phone_Number + " | Subscribe News = " + Subscribe_News + " | Subscribe Status = " + Subscribe_News_Status + " | App Name = " + App_Name + " | App Enabled = " + App_Enabled + " | App Enabled Status = " + App_Enabled_Status + " | Plan Name = " + Plan_Name + " | Users = " + Users + " | Group = " + Group + " | Account Manager = " + Account_Manager);

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>✅ Expected:</b> Admin should be able to fill the account creation form, assign the selected app plan, select account manager, assign group, and enter staff notes successfully.");
	System.out.println("✅ Expected: Admin should be able to fill the account creation form, assign the selected app plan, select account manager, assign group, and enter staff notes successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 🌐 FORM ACCESS ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ 🌐 FORM ACCESS ━━━━━━━━━━━━━━");

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

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 👤 ACCOUNT DETAILS ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ 👤 ACCOUNT DETAILS ━━━━━━━━━━━━━━");

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
	Thread.sleep(800);
	WebElement country_list = p.Country_dropdown();
	List<WebElement> country_options = country_list.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
	System.out.println("🟨 Debug: Country dropdown option count = " + country_options.size());

	if(country_options.size() > 0) {
		country_options.get(0).click();
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Country selected successfully = " + Country);
		System.out.println("🟨 Actual: Country selected successfully = " + Country);
	} else {
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> Country option was not found after searching country = " + Country);
		System.out.println("❌ Actual: Country option was not found after searching country = " + Country);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

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

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 📦 APP PLAN ASSIGNMENT ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ 📦 APP PLAN ASSIGNMENT ━━━━━━━━━━━━━━");

	step = App_Plan_Assigner(Form_Data, step);

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 🧑‍💼 ACCOUNT MAPPING ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ 🧑‍💼 ACCOUNT MAPPING ━━━━━━━━━━━━━━");

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

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 📝 STAFF NOTES ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ 📝 STAFF NOTES ━━━━━━━━━━━━━━");

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

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 📦 APP PLAN ASSIGNMENT ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ 📦 APP PLAN ASSIGNMENT ━━━━━━━━━━━━━━");

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
	System.out.println("🟨 Debug: App Name = " + App_Name + " | App Type = " + App_Type + " | App Enabled = " + App_Enabled + " | Boolean Status = " + App_Enabled_Status + " | Apps To Assign = " + Apps_To_Assign);

	if(!App_Enabled_Status) {
		Report_Listen.log_print_in_report().log(Status.WARNING, "<b>⚠ Actual:</b> App plan assignment skipped because App Enabled data = " + App_Enabled + " | App Type = " + App_Type);
		System.out.println("⚠ Actual: App plan assignment skipped because App Enabled data = " + App_Enabled + " | App Type = " + App_Type);
		System.out.println();
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

		return step;
	}

	if(Apps_To_Assign.size() == 0) {
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> No valid app type found for app plan assignment. App Type = " + App_Type);
		System.out.println("❌ Actual: No valid app type found for app plan assignment. App Type = " + App_Type);
		System.out.println();
		return step;
	}
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 🔘 APPLICATION ENABLEMENT ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ 🔘 APPLICATION ENABLEMENT ━━━━━━━━━━━━━━");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Enable required app toggles based on App Type.");
	System.out.println("Step " + (step - 1) + ": Enable required app toggles based on App Type.");
	List<WebElement> Plan_Toggles = p.Plan_toggle_Buttons();
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

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 🗂️ PLAN SELECTION ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ 🗂️ PLAN SELECTION ━━━━━━━━━━━━━━");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Fetch app plan dropdown fields.");
	System.out.println("Step " + (step - 1) + ": Fetch app plan dropdown fields.");
	List<WebElement> Plan_Select = p.Plan_select_dropdowm();
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

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 🔢 APP LIMITS ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ 🔢 APP LIMITS ━━━━━━━━━━━━━━");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Enter limit/user value for assigned app plans.");
	System.out.println("Step " + (step - 1) + ": Enter limit/user value for assigned app plans.");
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
	data1.put("First Name", "Hartmut");
	data1.put("Middle Name", "Elias");
	data1.put("Last Name", "Kronauer");
	data1.put("Company Name", "Kronauer Integrated SaaS GmbH");
	data1.put("Country", "Germany");
	data1.put("Email", "hartmut.elias.kronauer.account186@yopmail.com");
	data1.put("Subscribe News", "Yes");
	data1.put("Country Code", "+49");
	data1.put("Phone Number", "15763928410");
	data1.put("App Type", "all");
	data1.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data1.put("App Enabled", "Yes");
	data1.put("Checkout Plan Name", "Ayan Monthly Checkout Business Plan");
	data1.put("Spaces Plan Name", "Ayan Monthly Spaces Business Plan");
	data1.put("Hire Plan Name", "Ayan Monthly Hire Business Plan");
	data1.put("Hr Plan Name", "Ayan Monthly HR Business Plan");
	data1.put("Users", "48");
	data1.put("Group", "Gold II");
	data1.put("Account Manager", "Ayan Test Manager");
	data1.put("Staff Notes", "Creating this Germany-based all app account to validate monthly plans across Checkout, Spaces, Hire, and HR with newsletter subscription, user allocation, group selection, and account manager mapping.");

	TreeMap<String, String> data2 = new TreeMap<String, String>();
	data2.put("First Name", "Faustine");
	data2.put("Middle Name", "Mireille");
	data2.put("Last Name", "Dervaux");
	data2.put("Company Name", "Dervaux Checkout Consulting SAS");
	data2.put("Country", "France");
	data2.put("Email", "faustine.mireille.dervaux.account187@yopmail.com");
	data2.put("Subscribe News", "No");
	data2.put("Country Code", "+33");
	data2.put("Phone Number", "748526193");
	data2.put("App Type", "checkout");
	data2.put("App Name", "Simplified Checkout");
	data2.put("App Enabled", "Yes");
	data2.put("Plan Name", "Ayan Custom Days Checkout Premium Plan");
	data2.put("Users", "23");
	data2.put("Group", "Diamond");
	data2.put("Account Manager", "Ayan Test Manager");
	data2.put("Staff Notes", "Testing France-based Checkout account creation with the custom-days premium plan, newsletter disabled state, user allocation, Diamond group selection, and new customer contact details.");

	TreeMap<String, String> data3 = new TreeMap<String, String>();
	data3.put("First Name", "Oystein");
	data3.put("Middle Name", "Magnar");
	data3.put("Last Name", "Helland");
	data3.put("Company Name", "Helland Unified Operations AS");
	data3.put("Country", "Norway");
	data3.put("Email", "oystein.magnar.helland.account188@yopmail.com");
	data3.put("Subscribe News", "Yes");
	data3.put("Country Code", "+47");
	data3.put("Phone Number", "47491836");
	data3.put("App Type", "all");
	data3.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data3.put("App Enabled", "Yes");
	data3.put("Checkout Plan Name", "Ayan Checkout New Yearly Plan");
	data3.put("Spaces Plan Name", "Ayan Weekly Spaces Growth Plan");
	data3.put("Hire Plan Name", "Ayan Custom Weeks Hire Flex Plan");
	data3.put("Hr Plan Name", "Ayan Yearly HR Enterprise Plan");
	data3.put("Users", "57");
	data3.put("Group", "Silver");
	data3.put("Account Manager", "Ayan Test Manager");
	data3.put("Staff Notes", "Validating Norway-based all app account creation with yearly Checkout, weekly Spaces, custom-weeks Hire, and yearly HR plans together with user count, subscription, and group mapping.");

	TreeMap<String, String> data4 = new TreeMap<String, String>();
	data4.put("First Name", "Beatrice");
	data4.put("Middle Name", "Lucilla");
	data4.put("Last Name", "Nardini");
	data4.put("Company Name", "Nardini Workspace Management SRL");
	data4.put("Country", "Italy");
	data4.put("Email", "beatrice.lucilla.nardini.account189@yopmail.com");
	data4.put("Subscribe News", "No");
	data4.put("Country Code", "+39");
	data4.put("Phone Number", "3516289470");
	data4.put("App Type", "spaces");
	data4.put("App Name", "Simplified Spaces");
	data4.put("App Enabled", "Yes");
	data4.put("Plan Name", "Ayan New Professional Diamond Plan");
	data4.put("Users", "31");
	data4.put("Group", "Gold");
	data4.put("Account Manager", "Ayan Test Manager");
	data4.put("Staff Notes", "Creating this Italy-based Spaces account to verify the professional Diamond plan, user allocation, newsletter disabled state, Gold group assignment, and staff note storage.");

	TreeMap<String, String> data5 = new TreeMap<String, String>();
	data5.put("First Name", "Alistair");
	data5.put("Middle Name", "Dominic");
	data5.put("Last Name", "Thornecroft");
	data5.put("Company Name", "Thornecroft Multi Product Services Ltd");
	data5.put("Country", "United Kingdom");
	data5.put("Email", "alistair.dominic.thornecroft.account190@yopmail.com");
	data5.put("Subscribe News", "Yes");
	data5.put("Country Code", "+44");
	data5.put("Phone Number", "7439265810");
	data5.put("App Type", "all");
	data5.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data5.put("App Enabled", "Yes");
	data5.put("Checkout Plan Name", "Ayan Yearly Checkout Enterprise Plan");
	data5.put("Spaces Plan Name", "Ayan Yearly Spaces Enterprise Plan");
	data5.put("Hire Plan Name", "Ayan Custom Months Hire Premium Plan");
	data5.put("Hr Plan Name", "Ayan Yearly HR Enterprise Plan");
	data5.put("Users", "66");
	data5.put("Group", "Gold II");
	data5.put("Account Manager", "Ayan Test Manager");
	data5.put("Staff Notes", "Testing UK-based all app account creation with enterprise Checkout and Spaces plans, custom-months Hire plan, yearly HR plan, newsletter subscription, and Gold II group selection.");

	TreeMap<String, String> data6 = new TreeMap<String, String>();
	data6.put("First Name", "Dieuwertje");
	data6.put("Middle Name", "Anneke");
	data6.put("Last Name", "Kromhout");
	data6.put("Company Name", "Kromhout Employee Services BV");
	data6.put("Country", "Netherlands");
	data6.put("Email", "dieuwertje.anneke.kromhout.account191@yopmail.com");
	data6.put("Subscribe News", "No");
	data6.put("Country Code", "+31");
	data6.put("Phone Number", "681739254");
	data6.put("App Type", "hr");
	data6.put("App Name", "Simplified HR");
	data6.put("App Enabled", "Yes");
	data6.put("Plan Name", "Ayan Custom Days HR Flex Plan");
	data6.put("Users", "42");
	data6.put("Group", "Diamond");
	data6.put("Account Manager", "Ayan Test Manager");
	data6.put("Staff Notes", "Creating this Netherlands-based HR account to validate the custom-days HR plan, user count, newsletter disabled state, Diamond group selection, and account manager assignment.");

	TreeMap<String, String> data7 = new TreeMap<String, String>();
	data7.put("First Name", "Tassilo");
	data7.put("Middle Name", "Rupert");
	data7.put("Last Name", "Kerschbaumer");
	data7.put("Company Name", "Kerschbaumer Complete Business GmbH");
	data7.put("Country", "Austria");
	data7.put("Email", "tassilo.rupert.kerschbaumer.account192@yopmail.com");
	data7.put("Subscribe News", "Yes");
	data7.put("Country Code", "+43");
	data7.put("Phone Number", "6762948315");
	data7.put("App Type", "all");
	data7.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data7.put("App Enabled", "Yes");
	data7.put("Checkout Plan Name", "AYan 5 day biilling plan");
	data7.put("Spaces Plan Name", "Ayan Daily Spaces Starter Plan");
	data7.put("Hire Plan Name", "Ayan Monthly Hire Business Plan");
	data7.put("Hr Plan Name", "Ayan HR New Weekly Plan");
	data7.put("Users", "52");
	data7.put("Group", "Silver");
	data7.put("Account Manager", "Ayan Test Manager");
	data7.put("Staff Notes", "Testing Austria-based all app account creation with five-day Checkout billing, daily Spaces, monthly Hire, and weekly HR plans, including newsletter selection and user assignment.");

	TreeMap<String, String> data8 = new TreeMap<String, String>();
	data8.put("First Name", "Kazimiera");
	data8.put("Middle Name", "Irena");
	data8.put("Last Name", "Dobrowolska");
	data8.put("Company Name", "Dobrowolska Recruitment Services Sp z oo");
	data8.put("Country", "Poland");
	data8.put("Email", "kazimiera.irena.dobrowolska.account193@yopmail.com");
	data8.put("Subscribe News", "No");
	data8.put("Country Code", "+48");
	data8.put("Phone Number", "517483962");
	data8.put("App Type", "hire");
	data8.put("App Name", "Simplified Hire");
	data8.put("App Enabled", "Yes");
	data8.put("Plan Name", "Ayan Custom Weeks Hire Flex Plan");
	data8.put("Users", "36");
	data8.put("Group", "Gold");
	data8.put("Account Manager", "Ayan Test Manager");
	data8.put("Staff Notes", "Creating this Poland-based Hire account to validate the custom-weeks Hire plan, newsletter disabled condition, user count, Gold group assignment, and account manager mapping.");

	TreeMap<String, String> data9 = new TreeMap<String, String>();
	data9.put("First Name", "Gonzalo");
	data9.put("Middle Name", "Esteban");
	data9.put("Last Name", "Mendizabal");
	data9.put("Company Name", "Mendizabal Enterprise Operations SL");
	data9.put("Country", "Spain");
	data9.put("Email", "gonzalo.esteban.mendizabal.account194@yopmail.com");
	data9.put("Subscribe News", "Yes");
	data9.put("Country Code", "+34");
	data9.put("Phone Number", "634928175");
	data9.put("App Type", "all");
	data9.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data9.put("App Enabled", "Yes");
	data9.put("Checkout Plan Name", "Ayan Custom Days Checkout Advance Plan");
	data9.put("Spaces Plan Name", "Ayan Monthly Spaces Business Plan");
	data9.put("Hire Plan Name", "Ayan Custom Months Hire Premium Plan");
	data9.put("Hr Plan Name", "Ayan Monthly HR Business Plan");
	data9.put("Users", "69");
	data9.put("Group", "Gold II");
	data9.put("Account Manager", "Ayan Test Manager");
	data9.put("Staff Notes", "Verifying Spain-based all app account creation with custom-days Checkout, monthly Spaces, custom-months Hire, and monthly HR plans with newsletter subscription and user allocation.");

	TreeMap<String, String> data10 = new TreeMap<String, String>();
	data10.put("First Name", "Cyrill");
	data10.put("Middle Name", "Lucien");
	data10.put("Last Name", "Zehnder");
	data10.put("Company Name", "Zehnder Checkout Platforms AG");
	data10.put("Country", "Switzerland");
	data10.put("Email", "cyrill.lucien.zehnder.account195@yopmail.com");
	data10.put("Subscribe News", "No");
	data10.put("Country Code", "+41");
	data10.put("Phone Number", "761839425");
	data10.put("App Type", "checkout");
	data10.put("App Name", "Simplified Checkout");
	data10.put("App Enabled", "Yes");
	data10.put("Plan Name", "Ayan Daily Checkout Starter Plan");
	data10.put("Users", "28");
	data10.put("Group", "Diamond");
	data10.put("Account Manager", "Ayan Test Manager");
	data10.put("Staff Notes", "Creating this Switzerland-based Checkout account to verify the daily starter plan, user allocation, newsletter disabled state, Diamond group selection, and staff note capture.");

	TreeMap<String, String> data11 = new TreeMap<String, String>();
	data11.put("First Name", "Sverker");
	data11.put("Middle Name", "Olof");
	data11.put("Last Name", "Nylander");
	data11.put("Company Name", "Nylander Unified People Systems AB");
	data11.put("Country", "Sweden");
	data11.put("Email", "sverker.olof.nylander.account196@yopmail.com");
	data11.put("Subscribe News", "Yes");
	data11.put("Country Code", "+46");
	data11.put("Phone Number", "708526193");
	data11.put("App Type", "all");
	data11.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data11.put("App Enabled", "Yes");
	data11.put("Checkout Plan Name", "Ayan Monthly Checkout Business Plan");
	data11.put("Spaces Plan Name", "Ayan Weekly Spaces Growth Plan");
	data11.put("Hire Plan Name", "Ayan Monthly Hire Business Plan");
	data11.put("Hr Plan Name", "Ayan Weekly HR Growth Plan");
	data11.put("Users", "54");
	data11.put("Group", "Silver");
	data11.put("Account Manager", "Ayan Test Manager");
	data11.put("Staff Notes", "Testing Sweden-based all app account creation with monthly Checkout, weekly Spaces, monthly Hire, and weekly HR plans, newsletter enabled state, users value, and Silver group mapping.");

	TreeMap<String, String> data12 = new TreeMap<String, String>();
	data12.put("First Name", "Gaetan");
	data12.put("Middle Name", "Marcel");
	data12.put("Last Name", "Courtois");
	data12.put("Company Name", "Courtois Flexible Workspace SAS");
	data12.put("Country", "France");
	data12.put("Email", "gaetan.marcel.courtois.account197@yopmail.com");
	data12.put("Subscribe News", "No");
	data12.put("Country Code", "+33");
	data12.put("Phone Number", "753826194");
	data12.put("App Type", "spaces");
	data12.put("App Name", "Simplified Spaces");
	data12.put("App Enabled", "Yes");
	data12.put("Plan Name", "Ayan Daily Spaces Starter Plan");
	data12.put("Users", "26");
	data12.put("Group", "Gold");
	data12.put("Account Manager", "Ayan Test Manager");
	data12.put("Staff Notes", "Creating this France-based Spaces account to validate the daily starter plan, newsletter disabled condition, users value, Gold group selection, and customer profile creation.");

	TreeMap<String, String> data13 = new TreeMap<String, String>();
	data13.put("First Name", "Teodoro");
	data13.put("Middle Name", "Marcello");
	data13.put("Last Name", "Foscari");
	data13.put("Company Name", "Foscari Enterprise SaaS SRL");
	data13.put("Country", "Italy");
	data13.put("Email", "teodoro.marcello.foscari.account198@yopmail.com");
	data13.put("Subscribe News", "Yes");
	data13.put("Country Code", "+39");
	data13.put("Phone Number", "3496371825");
	data13.put("App Type", "all");
	data13.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data13.put("App Enabled", "Yes");
	data13.put("Checkout Plan Name", "Ayan Yearly Checkout Enterprise Plan");
	data13.put("Spaces Plan Name", "Ayan New Professional Diamond Plan");
	data13.put("Hire Plan Name", "Ayan Custom Weeks Hire Flex Plan");
	data13.put("Hr Plan Name", "Ayan Custom Days HR Flex Plan");
	data13.put("Users", "62");
	data13.put("Group", "Gold II");
	data13.put("Account Manager", "Ayan Test Manager");
	data13.put("Staff Notes", "Validating Italy-based all app account creation with enterprise Checkout, professional Spaces, custom-weeks Hire, and custom-days HR plans, including users and subscription fields.");

	TreeMap<String, String> data14 = new TreeMap<String, String>();
	data14.put("First Name", "Roderik");
	data14.put("Middle Name", "Willem");
	data14.put("Last Name", "Van Mierlo");
	data14.put("Company Name", "Van Mierlo Human Resources BV");
	data14.put("Country", "Netherlands");
	data14.put("Email", "roderik.willem.vanmierlo.account199@yopmail.com");
	data14.put("Subscribe News", "No");
	data14.put("Country Code", "+31");
	data14.put("Phone Number", "686317942");
	data14.put("App Type", "hr");
	data14.put("App Name", "Simplified HR");
	data14.put("App Enabled", "Yes");
	data14.put("Plan Name", "Ayan Daily HR Starter Plan");
	data14.put("Users", "40");
	data14.put("Group", "Diamond");
	data14.put("Account Manager", "Ayan Test Manager");
	data14.put("Staff Notes", "Testing Netherlands-based HR account creation with the daily starter plan, users value, newsletter disabled state, Diamond group assignment, and internal staff notes.");

	TreeMap<String, String> data15 = new TreeMap<String, String>();
	data15.put("First Name", "Dragos");
	data15.put("Middle Name", "Mihnea");
	data15.put("Last Name", "Stanescu");
	data15.put("Company Name", "Stanescu Unified Business SRL");
	data15.put("Country", "Romania");
	data15.put("Email", "dragos.mihnea.stanescu.account200@yopmail.com");
	data15.put("Subscribe News", "Yes");
	data15.put("Country Code", "+40");
	data15.put("Phone Number", "736294851");
	data15.put("App Type", "all");
	data15.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data15.put("App Enabled", "Yes");
	data15.put("Checkout Plan Name", "Ayan Custom Days Checkout Premium Plan");
	data15.put("Spaces Plan Name", "Ayan Monthly Spaces Business Plan");
	data15.put("Hire Plan Name", "Ayan Monthly Hire Business Plan");
	data15.put("Hr Plan Name", "Ayan Monthly HR Business Plan");
	data15.put("Users", "74");
	data15.put("Group", "Silver");
	data15.put("Account Manager", "Ayan Test Manager");
	data15.put("Staff Notes", "Creating Romania-based all app account with custom-days Checkout and monthly Spaces, Hire, and HR plans, including newsletter subscription, users field, and Silver group.");

	TreeMap<String, String> data16 = new TreeMap<String, String>();
	data16.put("First Name", "Elwira");
	data16.put("Middle Name", "Jadwiga");
	data16.put("Last Name", "Michalska");
	data16.put("Company Name", "Michalska Talent Management Sp z oo");
	data16.put("Country", "Poland");
	data16.put("Email", "elwira.jadwiga.michalska.account201@yopmail.com");
	data16.put("Subscribe News", "No");
	data16.put("Country Code", "+48");
	data16.put("Phone Number", "512738946");
	data16.put("App Type", "hire");
	data16.put("App Name", "Simplified Hire");
	data16.put("App Enabled", "Yes");
	data16.put("Plan Name", "Ayan Custom Months Hire Premium Plan");
	data16.put("Users", "38");
	data16.put("Group", "Gold");
	data16.put("Account Manager", "Ayan Test Manager");
	data16.put("Staff Notes", "Creating this Poland-based Hire account to verify the custom-months premium plan, newsletter disabled state, user allocation, Gold group selection, and account manager mapping.");

	TreeMap<String, String> data17 = new TreeMap<String, String>();
	data17.put("First Name", "Peregrine");
	data17.put("Middle Name", "Cedric");
	data17.put("Last Name", "Ashcombe");
	data17.put("Company Name", "Ashcombe Multi Application Services Ltd");
	data17.put("Country", "United Kingdom");
	data17.put("Email", "peregrine.cedric.ashcombe.account202@yopmail.com");
	data17.put("Subscribe News", "Yes");
	data17.put("Country Code", "+44");
	data17.put("Phone Number", "7491836250");
	data17.put("App Type", "all");
	data17.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data17.put("App Enabled", "Yes");
	data17.put("Checkout Plan Name", "Ayan Checkout New Yearly Plan");
	data17.put("Spaces Plan Name", "Ayan Yearly Spaces Enterprise Plan");
	data17.put("Hire Plan Name", "Ayan Monthly Hire Business Plan");
	data17.put("Hr Plan Name", "Ayan HR New Weekly Plan");
	data17.put("Users", "60");
	data17.put("Group", "Gold II");
	data17.put("Account Manager", "Ayan Test Manager");
	data17.put("Staff Notes", "Testing UK-based all app account creation with yearly Checkout and Spaces plans, monthly Hire, weekly HR, newsletter subscription, users value, and Gold II group.");

	TreeMap<String, String> data18 = new TreeMap<String, String>();
	data18.put("First Name", "Hakon");
	data18.put("Middle Name", "Eirik");
	data18.put("Last Name", "Nystuen");
	data18.put("Company Name", "Nystuen Complete Operations AS");
	data18.put("Country", "Norway");
	data18.put("Email", "hakon.eirik.nystuen.account203@yopmail.com");
	data18.put("Subscribe News", "No");
	data18.put("Country Code", "+47");
	data18.put("Phone Number", "47638291");
	data18.put("App Type", "all");
	data18.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data18.put("App Enabled", "Yes");
	data18.put("Checkout Plan Name", "Ayan Daily Checkout Starter Plan");
	data18.put("Spaces Plan Name", "Ayan Daily Spaces Starter Plan");
	data18.put("Hire Plan Name", "Ayan Custom Weeks Hire Flex Plan");
	data18.put("Hr Plan Name", "Ayan Daily HR Starter Plan");
	data18.put("Users", "45");
	data18.put("Group", "Diamond");
	data18.put("Account Manager", "Ayan Test Manager");
	data18.put("Staff Notes", "Creating Norway-based all app account with daily Checkout, daily Spaces, custom-weeks Hire, and daily HR plans, newsletter disabled state, user allocation, and Diamond group.");

	TreeMap<String, String> data19 = new TreeMap<String, String>();
	data19.put("First Name", "Friederike");
	data19.put("Middle Name", "Luise");
	data19.put("Last Name", "Tannenhof");
	data19.put("Company Name", "Tannenhof Enterprise Platforms GmbH");
	data19.put("Country", "Germany");
	data19.put("Email", "friederike.luise.tannenhof.account204@yopmail.com");
	data19.put("Subscribe News", "Yes");
	data19.put("Country Code", "+49");
	data19.put("Phone Number", "15273948610");
	data19.put("App Type", "all");
	data19.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data19.put("App Enabled", "Yes");
	data19.put("Checkout Plan Name", "Ayan Custom Days Checkout Advance Plan");
	data19.put("Spaces Plan Name", "Ayan Weekly Spaces Growth Plan");
	data19.put("Hire Plan Name", "Ayan Custom Months Hire Premium Plan");
	data19.put("Hr Plan Name", "Ayan Weekly HR Growth Plan");
	data19.put("Users", "71");
	data19.put("Group", "Silver");
	data19.put("Account Manager", "Ayan Test Manager");
	data19.put("Staff Notes", "Validating Germany-based all app account with custom-days Checkout, weekly Spaces, custom-months Hire, and weekly HR plans, including users, subscription, and Silver group.");

	TreeMap<String, String> data20 = new TreeMap<String, String>();
	data20.put("First Name", "Capucine");
	data20.put("Middle Name", "Elodie");
	data20.put("Last Name", "Verlaine");
	data20.put("Company Name", "Verlaine Enterprise Coordination SAS");
	data20.put("Country", "France");
	data20.put("Email", "capucine.elodie.verlaine.account205@yopmail.com");
	data20.put("Subscribe News", "No");
	data20.put("Country Code", "+33");
	data20.put("Phone Number", "761928435");
	data20.put("App Type", "all");
	data20.put("App Name", "Simplified Checkout, Simplified Spaces, Simplified HR, Simplified Hire");
	data20.put("App Enabled", "Yes");
	data20.put("Checkout Plan Name", "Ayan Monthly Checkout Business Plan");
	data20.put("Spaces Plan Name", "Ayan New Professional Diamond Plan");
	data20.put("Hire Plan Name", "Ayan Monthly Hire Business Plan");
	data20.put("Hr Plan Name", "Ayan Custom Days HR Flex Plan");
	data20.put("Users", "53");
	data20.put("Group", "Gold");
	data20.put("Account Manager", "Ayan Test Manager");
	data20.put("Staff Notes", "Creating France-based all app account with monthly Checkout, professional Spaces, monthly Hire, and custom-days HR plans, newsletter disabled state, users value, and Gold group.");

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
	Repeat rp = new Repeat(d);
	
	TreeMap<String, String> lead_details = new TreeMap<String, String>();
	
	int step = 1;
	
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🔹 Scenario Section:</b> Lead Details Validation");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📘 Description:</b> Open the lead details page and capture the available lead information before performing further lead actions.");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>✅ Expected:</b> Lead details should be available and important lead field values should be captured successfully.");
	
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println("🔹 Scenario Section: Lead Details Validation");
	System.out.println("📘 Description: Open the lead details page and capture the available lead information before performing further lead actions.");
	System.out.println("✅ Expected: Lead details should be available and important lead field values should be captured successfully.");
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println();
	
	WebElement Approve_button;
	
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Validate whether the lead details page is already open.");
	System.out.println("Step " + (step - 1) + ": Validate whether the lead details page is already open.");
	
	try {
		Approve_button = p.Leads_Approve_button();
		
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Lead details page is already open and approval action is available.");
		System.out.println("🟨 Actual: Lead details page is already open and approval action is available.");
	} catch (Exception e) { 
		
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Lead details page was not open. Navigating to Leads module and opening the first lead details.");
		System.out.println("🟨 Actual: Lead details page was not open. Navigating to Leads module and opening the first lead details.");
		
		Saas_Admin_Menu_navigation("Leads");
		
		try {
			List<WebElement> loaders = p.Loader();
			rp.wait_for_invisibilty_of_theElement(loaders);
			
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Leads list loader disappeared successfully.");
			System.out.println("🟨 Actual: Leads list loader disappeared successfully.");
		} catch(Exception loaderException) {
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Leads list loader was not displayed or already disappeared.");
			System.out.println("🟨 Actual: Leads list loader was not displayed or already disappeared.");
		}
		
		list_threedot_dropdown_option_selector("View Lead");
		
		try {
			Approve_button = p.Leads_Approve_button();
			
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Lead details page opened successfully from Leads list.");
			System.out.println("🟨 Actual: Lead details page opened successfully from Leads list.");
		} catch(Exception openLeadException) {
			
			String errorMessage = "Lead details page did not open properly after selecting View Lead.";
			
			Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure Point:</b> " + errorMessage + "<br><b>Exception:</b> " + openLeadException.getMessage());
			System.out.println("❌ Failure Point: " + errorMessage);
			System.out.println("Exception Reason: " + openLeadException.getMessage());
			openLeadException.printStackTrace();
			System.out.println();
			
			throw new RuntimeException(errorMessage, openLeadException);
		}
	}
	System.out.println();
	
	Thread.sleep(1200);
	
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Fetch lead detail labels.");
	System.out.println("Step " + (step - 1) + ": Fetch lead detail labels.");
	
	List<WebElement> Labels;
	
	try {
		Labels = p.Labels();
		
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Lead detail labels fetched successfully. Label count = " + Labels.size());
		System.out.println("🟨 Actual: Lead detail labels fetched successfully. Label count = " + Labels.size());
	} catch (Exception e) {
		
		Report_Listen.log_print_in_report().log(Status.WARNING, "<b>⚠ Retry:</b> Lead detail labels were not ready. Retrying once.");
		System.out.println("⚠ Retry: Lead detail labels were not ready. Retrying once.");
		
		try {
			Thread.sleep(1000);
			Labels = p.Labels();
			
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Lead detail labels fetched successfully after retry. Label count = " + Labels.size());
			System.out.println("🟨 Actual: Lead detail labels fetched successfully after retry. Label count = " + Labels.size());
		} catch (Exception retryEx) {
			
			String errorMessage = "Lead detail labels could not be fetched from lead details page.";
			
			Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure Point:</b> " + errorMessage + "<br><b>Exception:</b> " + retryEx.getMessage());
			System.out.println("❌ Failure Point: " + errorMessage);
			System.out.println("Exception Reason: " + retryEx.getMessage());
			retryEx.printStackTrace();
			System.out.println();
			
			throw new RuntimeException(errorMessage, retryEx);
		}
	}
	System.out.println();
	
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Fetch lead detail values.");
	System.out.println("Step " + (step - 1) + ": Fetch lead detail values.");
	
	List<WebElement> Values;
	
	try {
		Values = p.values();
		
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Lead detail values fetched successfully. Value count = " + Values.size());
		System.out.println("🟨 Actual: Lead detail values fetched successfully. Value count = " + Values.size());
	} catch (Exception e) {
		
		Report_Listen.log_print_in_report().log(Status.WARNING, "<b>⚠ Retry:</b> Lead detail values were not ready. Retrying once.");
		System.out.println("⚠ Retry: Lead detail values were not ready. Retrying once.");
		
		try {
			Thread.sleep(1000);
			Values = p.values();
			
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Lead detail values fetched successfully after retry. Value count = " + Values.size());
			System.out.println("🟨 Actual: Lead detail values fetched successfully after retry. Value count = " + Values.size());
		} catch (Exception retryEx) {
			
			String errorMessage = "Lead detail values could not be fetched from lead details page.";
			
			Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure Point:</b> " + errorMessage + "<br><b>Exception:</b> " + retryEx.getMessage());
			System.out.println("❌ Failure Point: " + errorMessage);
			System.out.println("Exception Reason: " + retryEx.getMessage());
			retryEx.printStackTrace();
			System.out.println();
			
			throw new RuntimeException(errorMessage, retryEx);
		}
	}
	System.out.println();
	
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Capture available lead details.");
	System.out.println("Step " + (step - 1) + ": Capture available lead details.");
	
	int Label_Count = Labels.size();
	int Value_Index = 0;
	
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> Lead label count = " + Labels.size() + " | Lead value count = " + Values.size());
	System.out.println("🟨 Debug: Lead label count = " + Labels.size() + " | Lead value count = " + Values.size());
	System.out.println();
	
	for(int i = 0; i < Label_Count; i++) {
		
		String label = Labels.get(i).getText().trim();
		
		if(label.toLowerCase().contains("requested demo")) {
			
			String tooltip_values = "";
			
			try {
				
				List<WebElement> cards = p.App_cards();
				
				Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> Requested Demo App icon/card count = " + cards.size());
				System.out.println("🟨 Debug: Requested Demo App icon/card count = " + cards.size());
				
				if(cards == null || cards.size() == 0) {
					
					String errorMessage = "Requested Demo App cards/icons were not found on lead details page. Label = " + label;
					
					Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure Point:</b> " + errorMessage);
					System.out.println("❌ Failure Point: " + errorMessage);
					System.out.println();
					
					throw new IllegalStateException(errorMessage);
				}
				
				for(WebElement card : cards) {
					
					rp.movetoelement(card);
					Thread.sleep(800);
					
					WebElement Tooltip = p.Visibile_tooltip();
					String tooltip_text = Tooltip.getText().trim();
					
					if(tooltip_text.length() > 0) {
						
						if(tooltip_values.length() > 0) {
							tooltip_values = tooltip_values + ", ";
						}
						
						tooltip_values = tooltip_values + tooltip_text;
						
						Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> Requested Demo App tooltip captured = " + tooltip_text);
						System.out.println("🟨 Debug: Requested Demo App tooltip captured = " + tooltip_text);
					}
				}
				
				if(tooltip_values.trim().length() == 0) {
					
					String errorMessage = "Requested Demo App tooltip text was not captured even though app cards/icons were found. Card Count = " + cards.size() + " | Label = " + label;
					
					Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure Point:</b> " + errorMessage);
					System.out.println("❌ Failure Point: " + errorMessage);
					System.out.println();
					
					throw new IllegalStateException(errorMessage);
				}
				
				lead_details.put(label, tooltip_values);
				
				Report_Listen.log_print_in_report().log(Status.INFO, "<b>📌 Lead Detail:</b> " + label + " = " + tooltip_values);
				System.out.println("📌 Lead Detail: " + label + " = " + tooltip_values);
				
			} catch(Exception e) {
				
				String errorMessage = "Failed to capture Requested Demo App tooltip values. Label = " + label;
				
				Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure Point:</b> " + errorMessage + "<br><b>Exception:</b> " + e.getMessage());
				System.out.println("❌ Failure Point: " + errorMessage);
				System.out.println("Exception Reason: " + e.getMessage());
				e.printStackTrace();
				System.out.println();
				
				throw new RuntimeException(errorMessage, e);
			}
			
		} else {
			
			if(Value_Index >= Values.size()) {
				
				String errorMessage = "Lead value is missing for label. Label = " + label + " | Label Index = " + i + " | Current Value Index = " + Value_Index + " | Total Values = " + Values.size();
				
				Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure Point:</b> " + errorMessage);
				System.out.println("❌ Failure Point: " + errorMessage);
				System.out.println();
				
				throw new IllegalStateException(errorMessage);
			}
			
			String value = Values.get(Value_Index).getText().trim();
			Value_Index++;
			
			lead_details.put(label, value);
			
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>📌 Lead Detail:</b> " + label + " = " + value);
			System.out.println("📌 Lead Detail: " + label + " = " + value);
		}
	}
	
	System.out.println();
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> Final consumed normal value count = " + Value_Index + " | Total normal values available = " + Values.size());
	System.out.println("🟨 Debug: Final consumed normal value count = " + Value_Index + " | Total normal values available = " + Values.size());
	System.out.println();
	
	if(lead_details.size() > 0) {
		Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Lead details captured successfully. Total captured fields = " + lead_details.size());
		System.out.println("✅ Actual: Lead details captured successfully. Total captured fields = " + lead_details.size());
	} else {
		
		String errorMessage = "No lead details were captured from the lead details page.";
		
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure Point:</b> " + errorMessage);
		System.out.println("❌ Failure Point: " + errorMessage);
		System.out.println();
		
		throw new IllegalStateException(errorMessage);
	}
	
	System.out.println();
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	
	return lead_details;
}

@Test(dataProvider="Contact_Form_Data")
public void Leads_Delete(TreeMap<String, String> form_data) throws IOException, InterruptedException{
	
	Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
	Repeat rp = new Repeat(d);
	
	String Email = form_data.get("Email");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🔹 Scenario Title:</b> Delete SaaS Admin Lead");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📘 Description:</b> Open the Leads module, search the required lead by email, select Delete from the row action menu, confirm deletion, and validate the confirmation message.");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📥 Input:</b> Lead Email = " + Email);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>✅ Expected:</b> Required lead should be deleted successfully and a deletion confirmation message should be displayed.");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println("🔹 Scenario Title: Delete SaaS Admin Lead");
	System.out.println("📘 Description: Open the Leads module, search the required lead by email, select Delete from the row action menu, confirm deletion, and validate the confirmation message.");
	System.out.println("📥 Input: Lead Email = " + Email);
	System.out.println("✅ Expected: Required lead should be deleted successfully and a deletion confirmation message should be displayed.");
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println();

	WebElement Lead_module_Heading;
	
	
	try {
		Lead_module_Heading=p.Leads_page_heading_title();
		
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Lead details page is already open and approval action is available.");
		System.out.println("🟨 Actual: Lead details page is already open and approval action is available.");
	} catch (Exception e) { 
		
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Lead details page was not open. Navigating to Leads module and opening the first lead details.");
		System.out.println("🟨 Actual: Lead details page was not open. Navigating to Leads module and opening the first lead details.");
		
		Saas_Admin_Menu_navigation("Leads");
		
		
		try {
			List<WebElement> Loaders = p.Loader();

			if(Loaders != null && Loaders.size() > 0) {
				rp.wait_for_invisibilty_of_theElement(Loaders);

				Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Account list loading completed successfully.");
				System.out.println("🟨 Actual: Account list loading completed successfully.");
			} else {
				Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Account list was already available. Loader was not displayed.");
				System.out.println("🟨 Actual: Account list was already available. Loader was not displayed.");
			}

		} catch(Exception emk) {
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Account list was already available. Loader wait was skipped.");
			System.out.println("🟨 Actual: Account list was already available. Loader wait was skipped.");
		}

		System.out.println();}

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 🔍 LEAD SEARCH ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ 🔍 LEAD SEARCH ━━━━━━━━━━━━━━");

	WebElement Search = p.search_field();
	Search.sendKeys(Email);
    Thread.sleep(1000);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Email entered successfully in account search field = " + Email);
	System.out.println("🟨 Actual: Email entered successfully in account search field = " + Email);
	System.out.println();
	
	try {
		List<WebElement> Reloaders = p.Loader();

		if(Reloaders != null && Reloaders.size() > 0) {
			rp.wait_for_invisibilty_of_theElement(Reloaders);

			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Account list loading completed successfully.");
			System.out.println("🟨 Actual: Account list loading completed successfully.");
		} else {
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Account list was already available. Loader was not displayed.");
			System.out.println("🟨 Actual: Account list was already available. Loader was not displayed.");
		}

	} catch(Exception emkm) {
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Account list was already available. Loader wait was skipped.");
		System.out.println("🟨 Actual: Account list was already available. Loader wait was skipped.");
	}
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 🗑️ DELETE CONFIRMATION ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ 🗑️ DELETE CONFIRMATION ━━━━━━━━━━━━━━");

	list_threedot_dropdown_option_selector("Delete");
	WebElement Delete_popup_button = p.Delete_button_red();	
	rp.movetoelement(Delete_popup_button);
	Delete_popup_button.click();
	WebElement Delete_Confirm_Popup = p.Toast_();
	String Delete_Confirm_Popup_Text = Delete_Confirm_Popup.getText().trim();
	Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Lead deleted successfully. Confirmation message = " + Delete_Confirm_Popup_Text);
	System.out.println("✅ Actual: Lead deleted successfully. Confirmation message = " + Delete_Confirm_Popup_Text);
	System.out.println();
	rp.wait_for_invisibilty_of_theElement(Delete_Confirm_Popup);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

	
	
}



@Test(dataProvider="Plan_Type_Name_Data")
public void Leads_Approve(TreeMap<String, String> Plan_data) throws IOException, InterruptedException, AWTException{
	
	Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
	Repeat rp = new Repeat(d);
	Candidate_Module_Locaters ca = new Candidate_Module_Locaters(d);
	
	JavascriptExecutor js = (JavascriptExecutor)d;
	
	String Checkout_plan_name=Plan_data.get("Checkout Plan Name");
	String Spaces_plan_name=Plan_data.get("Spaces Plan Name");
	String Hire_plan_name=Plan_data.get("Hire Plan Name");
	String Hr_plan_name=Plan_data.get("Hr Plan Name");
	
	String App_type_id = null;
	int step = 1;
	int Enabled_App_Count = 0;
	int Selected_Plan_Count = 0;
	
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🔹 Scenario Title:</b> Validate Lead Approval with App Plan Assignment");
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println("🔹 Scenario Title: Validate Lead Approval with App Plan Assignment");
	
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📘 Description:</b> Review the lead, approve it, assign the correct plan for each enabled application, and create the account successfully.");
	System.out.println("📘 Description: Review the lead, approve it, assign the correct plan for each enabled application, and create the account successfully.");
	
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📥 Input:</b> Hire Plan = " + Hire_plan_name + " | Checkout Plan = " + Checkout_plan_name + " | HR Plan = " + Hr_plan_name + " | Spaces Plan = " + Spaces_plan_name);
	System.out.println("📥 Input: Hire Plan = " + Hire_plan_name + " | Checkout Plan = " + Checkout_plan_name + " | HR Plan = " + Hr_plan_name + " | Spaces Plan = " + Spaces_plan_name);
	
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>✅ Expected:</b> Every enabled application should receive the correct plan and the lead should be converted into an account successfully.");
	System.out.println("✅ Expected: Every enabled application should receive the correct plan and the lead should be converted into an account successfully.");
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println();
	
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Open and verify lead details before approval.");
	System.out.println("Step " + (step - 1) + ": Open and verify lead details before approval.");
	Leads_Details_fetcher();
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Lead details reviewed successfully.");
	System.out.println("🟨 Actual: Lead details reviewed successfully.");
	System.out.println();
	
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Start lead approval process.");
	System.out.println("Step " + (step - 1) + ": Start lead approval process.");
	WebElement Approve_button=  p.Leads_Approve_button();
	rp.movetoelement(Approve_button);
	Approve_button.click();
	Thread.sleep(800);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Lead approval plan assignment popup opened successfully.");
	System.out.println("🟨 Actual: Lead approval plan assignment popup opened successfully.");
	System.out.println();
	
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Identify enabled applications for plan assignment.");
	System.out.println("Step " + (step - 1) + ": Identify enabled applications for plan assignment.");
	List<WebElement> Plan_Toggles = p.Approve_Plan_toggle_Buttons();
	System.out.println();
	
	int[] Plan_Assign_Result = Leads_Approve_Plan_Assigner(Plan_data, Plan_Toggles, step);
	step = Plan_Assign_Result[0];
	Enabled_App_Count = Plan_Assign_Result[1];
	Selected_Plan_Count = Plan_Assign_Result[2];
	int Plan_Assign_Status = Plan_Assign_Result[3];
	
	if(Plan_Assign_Status == 0) {
		return;
	}
	
	if(Enabled_App_Count == 0) {
		Report_Listen.log_print_in_report().log(Status.WARNING, "<b>⚠ Actual:</b> No enabled application was found for plan assignment.");
		System.out.println("⚠ Actual: No enabled application was found for plan assignment.");
		System.out.println();
		return;
	}
	
	if(Selected_Plan_Count != Enabled_App_Count) {
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> Plan assignment was incomplete. Enabled Applications = " + Enabled_App_Count + " | Plans Selected = " + Selected_Plan_Count);
		System.out.println("❌ Actual: Plan assignment was incomplete. Enabled Applications = " + Enabled_App_Count + " | Plans Selected = " + Selected_Plan_Count);
		System.out.println();
		return;
	}
	
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Confirm lead approval and account creation.");
	System.out.println("Step " + (step - 1) + ": Confirm lead approval and account creation.");
	WebElement Approve_Confirm_button = p.Assign_Create_Account_button();
	rp.Scroll_to_element(Approve_Confirm_button);
	Approve_Confirm_button.click();
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Lead approval confirmation submitted successfully.");
	System.out.println("🟨 Actual: Lead approval confirmation submitted successfully.");
	System.out.println();
	
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Verify approval confirmation message.");
	System.out.println("Step " + (step - 1) + ": Verify approval confirmation message.");
	WebElement Approve_Confirm_Popup = p.Toast_();
	String Approve_Confirm_Popup_Text = Approve_Confirm_Popup.getText().trim();
	Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Lead approved successfully. Confirmation message = " + Approve_Confirm_Popup_Text);
	System.out.println("✅ Actual: Lead approved successfully. Confirmation message = " + Approve_Confirm_Popup_Text);
	System.out.println();
	rp.wait_for_invisibilty_of_theElement(Approve_Confirm_Popup);
	
	Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Final Result:</b> Lead approval flow completed successfully. Enabled Applications = " + Enabled_App_Count + " | Plans Assigned = " + Selected_Plan_Count);
	System.out.println("✅ Final Result: Lead approval flow completed successfully. Enabled Applications = " + Enabled_App_Count + " | Plans Assigned = " + Selected_Plan_Count);
	System.out.println();
	
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	
}

public int[] Leads_Approve_Plan_Assigner(TreeMap<String, String> Plan_data, List<WebElement> Plan_Toggles, int step) throws InterruptedException{
	
	Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
	Repeat rp = new Repeat(d);
	
	String Checkout_plan_name=Plan_data.get("Checkout Plan Name");
	String Spaces_plan_name=Plan_data.get("Spaces Plan Name");
	String Hire_plan_name=Plan_data.get("Hire Plan Name");
	String Hr_plan_name=Plan_data.get("Hr Plan Name");
	
	String App_type_id = null;
	int Enabled_App_Count = 0;
	int Selected_Plan_Count = 0;
	int Plan_Assign_Status = 1;
	
	WebElement Plan_Input_Field = null;
	
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 📦 ENABLED APP PLAN ASSIGNMENT ━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━ 📦 ENABLED APP PLAN ASSIGNMENT ━━━━━━━━━━━━━━");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Assign matching plans to enabled applications.");
	System.out.println("Step " + (step - 1) + ": Assign matching plans to enabled applications.");
	
	for(WebElement toggle:Plan_Toggles){
		
		String Toggle_Status = toggle.getAttribute("aria-checked") == null ? "" : toggle.getAttribute("aria-checked").trim();
		
		if(Toggle_Status.contains("true")) {
			
			Enabled_App_Count++;
			
			WebElement Plan_Input_box = toggle.findElement(By.xpath("./../../..//*[text()='Select Plan']/../..//*[@class='ant-form-item-control-input']"));
			WebElement App_type=toggle.findElement(By.xpath("./../../..//input[contains(@id,'select_plan_')]"));
			App_type_id=App_type.getAttribute("id").trim();
			
			String Expected_Plan_Name = "";
			String App_Display_Name = "";
			
			if(App_type_id.contains("select_plan_hire")){
				Expected_Plan_Name = Hire_plan_name;
				App_Display_Name = "Simplified Hire";
			}
			if(App_type_id.contains("select_plan_checkout")){
				Expected_Plan_Name = Checkout_plan_name;
				App_Display_Name = "Simplified Checkout";
			}
			if(App_type_id.contains("select_plan_hr")){
				Expected_Plan_Name = Hr_plan_name;
				App_Display_Name = "Simplified HR";
			}
			if(App_type_id.contains("select_plan_spaces")){
				Expected_Plan_Name = Spaces_plan_name;
				App_Display_Name = "Simplified Spaces";
			}
			
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>📌 Enabled Application:</b> " + App_Display_Name + " | Required Plan = " + Expected_Plan_Name);
			System.out.println("📌 Enabled Application: " + App_Display_Name + " | Required Plan = " + Expected_Plan_Name);
			System.out.println();
			
			if(Expected_Plan_Name == null || Expected_Plan_Name.trim().length() == 0) {
				Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> Plan assignment could not continue because the required plan name is missing for " + App_Display_Name);
				System.out.println("❌ Actual: Plan assignment could not continue because the required plan name is missing for " + App_Display_Name);
				System.out.println();
				Plan_Assign_Status = 0;
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

				return new int[] {step, Enabled_App_Count, Selected_Plan_Count, Plan_Assign_Status};
			}
			
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Select required plan for " + App_Display_Name + ".");
			System.out.println("Step " + (step - 1) + ": Select required plan for " + App_Display_Name + ".");
			
			Plan_Input_Field = Plan_Input_box;
			rp.Scroll_to_element(Plan_Input_Field);
			Thread.sleep(800);
			rp.movetoelement(Plan_Input_Field);
			Plan_Input_Field.click();
			Thread.sleep(800);
			
			try {
				App_type.sendKeys(Expected_Plan_Name);
			} catch(Exception searchIssue) {
				Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Plan list opened for " + App_Display_Name + ". Proceeding with available plan options.");
				System.out.println("🟨 Actual: Plan list opened for " + App_Display_Name + ". Proceeding with available plan options.");
			}
			
			WebElement Dropdown_List = d.findElement(By.xpath("//div[contains(@class,'ant-select-dropdown') and not(contains(@class,'ant-select-dropdown-hidden'))]//div[contains(@class,'rc-virtual-list-holder')]"));
			rp.wait_for_theElement(Dropdown_List);
			Thread.sleep(800);
			rp.movetoelement(Dropdown_List);
			
			List<WebElement> Options = Dropdown_List.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
			
			boolean Plan_Selected = false;
			
			for(WebElement Option:Options){
				
				String Option_Text = Option.getText().trim();
				
				if(Option_Text.equalsIgnoreCase(Expected_Plan_Name.trim()) || Option_Text.contains(Expected_Plan_Name.trim())){
					
					rp.movetoelement(Option);
					Option.click();
					Plan_Selected = true;
					Selected_Plan_Count++;
					
					Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Plan selected successfully for " + App_Display_Name + " = " + Option_Text);
					System.out.println("🟨 Actual: Plan selected successfully for " + App_Display_Name + " = " + Option_Text);
					System.out.println();
					break;
				}
			}
			
			if(!Plan_Selected) {
				
				Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Required plan was not visible immediately for " + App_Display_Name + ". Checking additional plan options.");
				System.out.println("🟨 Actual: Required plan was not visible immediately for " + App_Display_Name + ". Checking additional plan options.");
				
				rp.Scroll_to_bottom_of_list(Dropdown_List);
				Thread.sleep(800);
				
				Options = Dropdown_List.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
				
				for(WebElement Option:Options){
					
					String Option_Text = Option.getText().trim();
					
					if(Option_Text.equalsIgnoreCase(Expected_Plan_Name.trim()) || Option_Text.contains(Expected_Plan_Name.trim())){
						
						rp.movetoelement(Option);
						Option.click();
						Plan_Selected = true;
						Selected_Plan_Count++;
						
						Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Plan selected successfully for " + App_Display_Name + " = " + Option_Text);
						System.out.println("🟨 Actual: Plan selected successfully for " + App_Display_Name + " = " + Option_Text);
						System.out.println();
						break;
					}
				}
			}
			
			if(!Plan_Selected) {
				Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> Required plan was not found for " + App_Display_Name + ". Expected Plan = " + Expected_Plan_Name);
				System.out.println("❌ Actual: Required plan was not found for " + App_Display_Name + ". Expected Plan = " + Expected_Plan_Name);
				System.out.println();
				Plan_Assign_Status = 0;
				return new int[] {step, Enabled_App_Count, Selected_Plan_Count, Plan_Assign_Status};
			}
			
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>✅ Completed:</b> Plan assignment completed for " + App_Display_Name);
			System.out.println("✅ Completed: Plan assignment completed for " + App_Display_Name);
			System.out.println();
		}
	}
	
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

	return new int[] {step, Enabled_App_Count, Selected_Plan_Count, Plan_Assign_Status};
}




@DataProvider
public Object[][] Plan_Type_Name_Data() {

	TreeMap<String, String> data1 = new TreeMap<String, String>();
	data1.put("Checkout App Type", "checkout");
	data1.put("Checkout Plan Name", "Ayan Checkout New Yearly Plan");
	data1.put("Spaces App Type", "spaces");
	data1.put("Spaces Plan Name", "Ayan New Professional Diamond Plan");
	data1.put("Hr App Type", "hr");
	data1.put("Hr Plan Name", "Ayan HR New Weekly Plan");
	data1.put("Hire App Type", "hire");
	data1.put("Hire Plan Name", "Ayan Monthly Hire Business Plan");

	TreeMap<String, String> data2 = new TreeMap<String, String>();
	data2.put("Checkout App Type", "checkout");
	data2.put("Checkout Plan Name", "Ayan Daily Checkout Starter Plan");
	data2.put("Spaces App Type", "spaces");
	data2.put("Spaces Plan Name", "Ayan Monthly Spaces Business Plan");
	data2.put("Hr App Type", "hr");
	data2.put("Hr Plan Name", "Ayan Daily HR Starter Plan");
	data2.put("Hire App Type", "hire");
	data2.put("Hire Plan Name", "Ayan Custom Weeks Hire Flex Plan");

	TreeMap<String, String> data3 = new TreeMap<String, String>();
	data3.put("Checkout App Type", "checkout");
	data3.put("Checkout Plan Name", "Ayan Monthly Checkout Business Plan");
	data3.put("Spaces App Type", "spaces");
	data3.put("Spaces Plan Name", "Ayan Daily Spaces Starter Plan");
	data3.put("Hr App Type", "hr");
	data3.put("Hr Plan Name", "Ayan Weekly HR Growth Plan");
	data3.put("Hire App Type", "hire");
	data3.put("Hire Plan Name", "Ayan Custom Months Hire Premium Plan");

	TreeMap<String, String> data4 = new TreeMap<String, String>();
	data4.put("Checkout App Type", "checkout");
	data4.put("Checkout Plan Name", "Ayan Yearly Checkout Enterprise Plan");
	data4.put("Spaces App Type", "spaces");
	data4.put("Spaces Plan Name", "Ayan Weekly Spaces Growth Plan");
	data4.put("Hr App Type", "hr");
	data4.put("Hr Plan Name", "Ayan Monthly HR Business Plan");
	data4.put("Hire App Type", "hire");
	data4.put("Hire Plan Name", "Ayan Monthly Hire Business Plan");

	TreeMap<String, String> data5 = new TreeMap<String, String>();
	data5.put("Checkout App Type", "checkout");
	data5.put("Checkout Plan Name", "Ayan Custom Days Checkout Premium Plan");
	data5.put("Spaces App Type", "spaces");
	data5.put("Spaces Plan Name", "Ayan Yearly Spaces Enterprise Plan");
	data5.put("Hr App Type", "hr");
	data5.put("Hr Plan Name", "Ayan Yearly HR Enterprise Plan");
	data5.put("Hire App Type", "hire");
	data5.put("Hire Plan Name", "Ayan Custom Weeks Hire Flex Plan");

	TreeMap<String, String> data6 = new TreeMap<String, String>();
	data6.put("Checkout App Type", "checkout");
	data6.put("Checkout Plan Name", "AYan 5 day biilling plan");
	data6.put("Spaces App Type", "spaces");
	data6.put("Spaces Plan Name", "Ayan New Professional Diamond Plan");
	data6.put("Hr App Type", "hr");
	data6.put("Hr Plan Name", "Ayan Custom Days HR Flex Plan");
	data6.put("Hire App Type", "hire");
	data6.put("Hire Plan Name", "Ayan Custom Months Hire Premium Plan");

	TreeMap<String, String> data7 = new TreeMap<String, String>();
	data7.put("Checkout App Type", "checkout");
	data7.put("Checkout Plan Name", "Ayan Custom Days Checkout Advance Plan");
	data7.put("Spaces App Type", "spaces");
	data7.put("Spaces Plan Name", "Ayan Monthly Spaces Business Plan");
	data7.put("Hr App Type", "hr");
	data7.put("Hr Plan Name", "Ayan HR New Weekly Plan");
	data7.put("Hire App Type", "hire");
	data7.put("Hire Plan Name", "Ayan Monthly Hire Business Plan");

	TreeMap<String, String> data8 = new TreeMap<String, String>();
	data8.put("Checkout App Type", "checkout");
	data8.put("Checkout Plan Name", "Ayan Checkout New Yearly Plan");
	data8.put("Spaces App Type", "spaces");
	data8.put("Spaces Plan Name", "Ayan Daily Spaces Starter Plan");
	data8.put("Hr App Type", "hr");
	data8.put("Hr Plan Name", "Ayan Daily HR Starter Plan");
	data8.put("Hire App Type", "hire");
	data8.put("Hire Plan Name", "Ayan Custom Weeks Hire Flex Plan");

	TreeMap<String, String> data9 = new TreeMap<String, String>();
	data9.put("Checkout App Type", "checkout");
	data9.put("Checkout Plan Name", "Ayan Daily Checkout Starter Plan");
	data9.put("Spaces App Type", "spaces");
	data9.put("Spaces Plan Name", "Ayan Weekly Spaces Growth Plan");
	data9.put("Hr App Type", "hr");
	data9.put("Hr Plan Name", "Ayan Weekly HR Growth Plan");
	data9.put("Hire App Type", "hire");
	data9.put("Hire Plan Name", "Ayan Custom Months Hire Premium Plan");

	TreeMap<String, String> data10 = new TreeMap<String, String>();
	data10.put("Checkout App Type", "checkout");
	data10.put("Checkout Plan Name", "Ayan Monthly Checkout Business Plan");
	data10.put("Spaces App Type", "spaces");
	data10.put("Spaces Plan Name", "Ayan Yearly Spaces Enterprise Plan");
	data10.put("Hr App Type", "hr");
	data10.put("Hr Plan Name", "Ayan Monthly HR Business Plan");
	data10.put("Hire App Type", "hire");
	data10.put("Hire Plan Name", "Ayan Monthly Hire Business Plan");

	TreeMap<String, String> data11 = new TreeMap<String, String>();
	data11.put("Checkout App Type", "checkout");
	data11.put("Checkout Plan Name", "Ayan Yearly Checkout Enterprise Plan");
	data11.put("Spaces App Type", "spaces");
	data11.put("Spaces Plan Name", "Ayan New Professional Diamond Plan");
	data11.put("Hr App Type", "hr");
	data11.put("Hr Plan Name", "Ayan Yearly HR Enterprise Plan");
	data11.put("Hire App Type", "hire");
	data11.put("Hire Plan Name", "Ayan Custom Weeks Hire Flex Plan");

	TreeMap<String, String> data12 = new TreeMap<String, String>();
	data12.put("Checkout App Type", "checkout");
	data12.put("Checkout Plan Name", "Ayan Custom Days Checkout Premium Plan");
	data12.put("Spaces App Type", "spaces");
	data12.put("Spaces Plan Name", "Ayan Monthly Spaces Business Plan");
	data12.put("Hr App Type", "hr");
	data12.put("Hr Plan Name", "Ayan Custom Days HR Flex Plan");
	data12.put("Hire App Type", "hire");
	data12.put("Hire Plan Name", "Ayan Custom Months Hire Premium Plan");

	TreeMap<String, String> data13 = new TreeMap<String, String>();
	data13.put("Checkout App Type", "checkout");
	data13.put("Checkout Plan Name", "AYan 5 day biilling plan");
	data13.put("Spaces App Type", "spaces");
	data13.put("Spaces Plan Name", "Ayan Daily Spaces Starter Plan");
	data13.put("Hr App Type", "hr");
	data13.put("Hr Plan Name", "Ayan HR New Weekly Plan");
	data13.put("Hire App Type", "hire");
	data13.put("Hire Plan Name", "Ayan Monthly Hire Business Plan");

	TreeMap<String, String> data14 = new TreeMap<String, String>();
	data14.put("Checkout App Type", "checkout");
	data14.put("Checkout Plan Name", "Ayan Custom Days Checkout Advance Plan");
	data14.put("Spaces App Type", "spaces");
	data14.put("Spaces Plan Name", "Ayan Weekly Spaces Growth Plan");
	data14.put("Hr App Type", "hr");
	data14.put("Hr Plan Name", "Ayan Daily HR Starter Plan");
	data14.put("Hire App Type", "hire");
	data14.put("Hire Plan Name", "Ayan Custom Weeks Hire Flex Plan");

	TreeMap<String, String> data15 = new TreeMap<String, String>();
	data15.put("Checkout App Type", "checkout");
	data15.put("Checkout Plan Name", "Ayan Checkout New Yearly Plan");
	data15.put("Spaces App Type", "spaces");
	data15.put("Spaces Plan Name", "Ayan Yearly Spaces Enterprise Plan");
	data15.put("Hr App Type", "hr");
	data15.put("Hr Plan Name", "Ayan Weekly HR Growth Plan");
	data15.put("Hire App Type", "hire");
	data15.put("Hire Plan Name", "Ayan Custom Months Hire Premium Plan");

	TreeMap<String, String> data16 = new TreeMap<String, String>();
	data16.put("Checkout App Type", "checkout");
	data16.put("Checkout Plan Name", "Ayan Daily Checkout Starter Plan");
	data16.put("Spaces App Type", "spaces");
	data16.put("Spaces Plan Name", "Ayan New Professional Diamond Plan");
	data16.put("Hr App Type", "hr");
	data16.put("Hr Plan Name", "Ayan Monthly HR Business Plan");
	data16.put("Hire App Type", "hire");
	data16.put("Hire Plan Name", "Ayan Monthly Hire Business Plan");

	TreeMap<String, String> data17 = new TreeMap<String, String>();
	data17.put("Checkout App Type", "checkout");
	data17.put("Checkout Plan Name", "Ayan Monthly Checkout Business Plan");
	data17.put("Spaces App Type", "spaces");
	data17.put("Spaces Plan Name", "Ayan Monthly Spaces Business Plan");
	data17.put("Hr App Type", "hr");
	data17.put("Hr Plan Name", "Ayan Yearly HR Enterprise Plan");
	data17.put("Hire App Type", "hire");
	data17.put("Hire Plan Name", "Ayan Custom Weeks Hire Flex Plan");

	TreeMap<String, String> data18 = new TreeMap<String, String>();
	data18.put("Checkout App Type", "checkout");
	data18.put("Checkout Plan Name", "Ayan Yearly Checkout Enterprise Plan");
	data18.put("Spaces App Type", "spaces");
	data18.put("Spaces Plan Name", "Ayan Daily Spaces Starter Plan");
	data18.put("Hr App Type", "hr");
	data18.put("Hr Plan Name", "Ayan Custom Days HR Flex Plan");
	data18.put("Hire App Type", "hire");
	data18.put("Hire Plan Name", "Ayan Custom Months Hire Premium Plan");

	TreeMap<String, String> data19 = new TreeMap<String, String>();
	data19.put("Checkout App Type", "checkout");
	data19.put("Checkout Plan Name", "Ayan Custom Days Checkout Premium Plan");
	data19.put("Spaces App Type", "spaces");
	data19.put("Spaces Plan Name", "Ayan Weekly Spaces Growth Plan");
	data19.put("Hr App Type", "hr");
	data19.put("Hr Plan Name", "Ayan HR New Weekly Plan");
	data19.put("Hire App Type", "hire");
	data19.put("Hire Plan Name", "Ayan Monthly Hire Business Plan");

	TreeMap<String, String> data20 = new TreeMap<String, String>();
	data20.put("Checkout App Type", "checkout");
	data20.put("Checkout Plan Name", "Ayan Custom Days Checkout Advance Plan");
	data20.put("Spaces App Type", "spaces");
	data20.put("Spaces Plan Name", "Ayan Yearly Spaces Enterprise Plan");
	data20.put("Hr App Type", "hr");
	data20.put("Hr Plan Name", "Ayan Monthly HR Business Plan");
	data20.put("Hire App Type", "hire");
	data20.put("Hire Plan Name", "Ayan Custom Weeks Hire Flex Plan");

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


public String Quick_Plan_Upgrade_Several_times(TreeMap<String, String> form_data,TreeMap<String, String> Account_data,TreeMap<String, String> Plan_Data,String Target_Upgrade_Plan_Name) throws IOException, InterruptedException {

	Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
	Repeat rp = new Repeat(d);

	String First_Name = Plan_Data.get("First Name");
	String Last_Name = Plan_Data.get("Last Name");
	String Address = Plan_Data.get("Address");
	String Country = Plan_Data.get("Country");
	String City = Plan_Data.get("City");
	String State = Plan_Data.get("State");
	String Zip = Plan_Data.get("Zip");
	String Email = form_data.get("Email");

	if(Target_Upgrade_Plan_Name == null
			|| Target_Upgrade_Plan_Name.trim().isEmpty()) {

		Target_Upgrade_Plan_Name = Account_data.get("Plan Name");
	}

	if(Target_Upgrade_Plan_Name == null
			|| Target_Upgrade_Plan_Name.trim().isEmpty()) {

		Target_Upgrade_Plan_Name = "Ayan";
	}

	int step = 1;

	String Selected_Upgrade_Plan_Name = "";
	String Active_Plan_Name = "";

	/*
	 * Scenario details
	 */
	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>"
	);

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>🔹 Scenario Title:</b> Validate SaaS Admin Account Plan Upgrade"
	);

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>📘 Description:</b> Search the created account, open its current application plan, select another available plan, configure billing details, submit the plan upgrade, identify the plan marked as Active, and verify that active plan in the account list."
	);

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>📥 Input:</b> Email = " + Email
			+ " | Target Plan Reference = " + Target_Upgrade_Plan_Name
			+ " | Billing Name = " + First_Name + " " + Last_Name
			+ " | Country = " + Country
			+ " | State = " + State
			+ " | City = " + City
			+ " | Zip = " + Zip
	);

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>✅ Expected:</b> Another eligible plan should be selected, the upgrade should complete successfully, the active plan should be identified, and the same active plan should appear in the account list."
	);

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>"
	);

	System.out.println();
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println("🔹 Scenario Title: Validate SaaS Admin Account Plan Upgrade");
	System.out.println();
	System.out.println(
			"📘 Description: Search the created account, open its current application plan, "
			+ "select another available plan, configure billing details, submit the plan upgrade, "
			+ "identify the plan marked as Active, and verify that active plan in the account list."
	);
	System.out.println();
	System.out.println(
			"📥 Input: Email = " + Email
			+ " | Target Plan Reference = " + Target_Upgrade_Plan_Name
			+ " | Billing Name = " + First_Name + " " + Last_Name
			+ " | Country = " + Country
			+ " | State = " + State
			+ " | City = " + City
			+ " | Zip = " + Zip
	);
	System.out.println();
	System.out.println(
			"✅ Expected: Another eligible plan should be selected, the upgrade should complete "
			+ "successfully, the active plan should be identified, and the same active plan "
			+ "should appear in the account list."
	);
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println();

	/*
	 * Ensure account list page is available
	 */
	try {

		p.Create_Account_button();

		System.out.println(
				"🟨 Debug: Account list page is already available."
		);

	} catch(Exception accountPageException) {

		System.out.println(
				"🟨 Debug: Account list page was not available. Performing SaaS Admin login."
		);

		System.out.println(
				"🟨 Debug Reason: "
				+ accountPageException.getMessage()
		);

		Saas_Admin_Login();
		p.Create_Account_button();
	}

	try {

		rp.wait_for_invisibilty_of_theElement(p.Loader());

		System.out.println(
				"🟨 Debug: Account list loader disappeared successfully."
		);

	} catch(Exception loaderException) {

		System.out.println(
				"🟨 Debug: Account list loader was absent or already disappeared."
		);

		System.out.println(
				"🟨 Debug Reason: "
				+ loaderException.getMessage()
		);
	}

	/*
	 * Account details section
	 */
	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>━━━━━━━━━━━━━━ 🔍 ACCOUNT DETAILS ━━━━━━━━━━━━━━</b>"
	);

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>Step " + (step++)
			+ ":</b> Search the created account using its registered email."
	);

	System.out.println(
			"━━━━━━━━━━━━━━ 🔍 ACCOUNT DETAILS ━━━━━━━━━━━━━━"
	);

	System.out.println(
			"Step " + (step - 1)
			+ ": Search the created account using its registered email."
	);

	WebElement Search = p.search_field();

	Search.clear();
	Search.sendKeys(Email);

	Thread.sleep(2000);

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>🟨 Actual:</b> Account searched successfully using Email = "
			+ Email
	);

	System.out.println(
			"🟨 Actual: Account searched successfully using Email = "
			+ Email
	);

	System.out.println();

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>Step " + (step++)
			+ ":</b> Open the searched account and capture its current plan."
	);

	System.out.println(
			"Step " + (step - 1)
			+ ": Open the searched account and capture its current plan."
	);

	list_threedot_dropdown_option_selector("View Account");

	p.Action_button();

	WebElement Billing_section = p.Billing_Tab();

	rp.Scroll_to_element(Billing_section);

	Thread.sleep(1200);

	List<WebElement> Plan_section = Billing_section.findElements(
			By.xpath(
					".//div[@class='wrap-panel-row px-3 py-4 cursor-pointer border-bottom']"
			)
	);

	WebElement Plan_One = Plan_section.get(0);

	String Plan_Name_One = Plan_One.findElement(
			By.xpath(
					".//div[@class='ant-col ant-col-12']//p"
			)
	).getText().trim();

	String Current_Plan_Name =
			Plan_Name_One.split("\\|")[0].trim();

	Report_Listen.log_print_in_report().log(
			Status.PASS,
			"<b>✅ Actual:</b> Current account plan captured successfully = "
			+ Current_Plan_Name
	);

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>"
	);

	System.out.println(
			"✅ Actual: Current account plan captured successfully = "
			+ Current_Plan_Name
	);

	System.out.println();

	System.out.println(
			"🟨 Debug: Current Plan Full Text = "
			+ Plan_Name_One
	);

	System.out.println(
			"🟨 Debug: Target Plan Reference = "
			+ Target_Upgrade_Plan_Name
	);

	System.out.println(
			"🟨 Debug: Account App Type = "
			+ Account_data.get("App Type")
	);

	System.out.println(
			"🟨 Debug: Account Plan Name = "
			+ Account_data.get("Plan Name")
	);

	System.out.println(
			"🟨 Debug: Checkout Plan Name = "
			+ Account_data.get("Checkout Plan Name")
	);

	System.out.println(
			"🟨 Debug: Hire Plan Name = "
			+ Account_data.get("Hire Plan Name")
	);

	System.out.println(
			"🟨 Debug: HR Plan Name = "
			+ Account_data.get("Hr Plan Name")
	);

	System.out.println(
			"🟨 Debug: Spaces Plan Name = "
			+ Account_data.get("Spaces Plan Name")
	);

	System.out.println();

	/*
	 * Plan selection section
	 */
	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>━━━━━━━━━━━━━━ 🔄 PLAN SELECTION ━━━━━━━━━━━━━━</b>"
	);

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>Step " + (step++)
			+ ":</b> Open the Change Plan option for the current application plan."
	);

	System.out.println(
			"━━━━━━━━━━━━━━ 🔄 PLAN SELECTION ━━━━━━━━━━━━━━"
	);

	System.out.println(
			"Step " + (step - 1)
			+ ": Open the Change Plan option for the current application plan."
	);

	Plan_One.findElement(
			By.xpath(
					".//span[@aria-label='setting']"
			)
	).click();

	List<WebElement> Plan_Action_Options =
			p.Plan_Dropdown().findElements(
					By.xpath(".//li")
			);

	WebElement Change_Plan_Option = null;

	for(WebElement option : Plan_Action_Options) {

		String Option_Text =
				option.getText().trim();

		System.out.println(
				"🟨 Debug: Plan action option found = "
				+ Option_Text
		);

		if(Option_Text.contains("Change Plan")) {

			Change_Plan_Option = option;
			break;
		}
	}

	if(Change_Plan_Option == null) {

		String errorMessage =
				"Change Plan option was not found. Current Plan = "
				+ Current_Plan_Name
				+ " | Email = " + Email;

		Report_Listen.log_print_in_report().log(
				Status.FAIL,
				"<b>❌ Failure:</b> " + errorMessage
		);

		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>"
		);

		System.out.println(
				"❌ Failure: " + errorMessage
		);

		throw new IllegalStateException(errorMessage);
	}

	Change_Plan_Option.click();

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>🟨 Actual:</b> Change Plan option opened successfully."
	);

	System.out.println(
			"🟨 Actual: Change Plan option opened successfully."
	);

	System.out.println();

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>Step " + (step++)
			+ ":</b> Search and select another available plan."
	);

	System.out.println(
			"Step " + (step - 1)
			+ ": Search and select another available plan."
	);

	WebElement Pop_up = p.pop_up_modal();

	WebElement Modal_dropdown = Pop_up.findElement(
			By.xpath(
					".//*[contains(@class,'ant-select-single') "
					+ "and contains(@class,'ant-select-show-arrow')]"
			)
	);

	rp.movetoelement(Modal_dropdown);
	Modal_dropdown.click();

	Thread.sleep(800);

	try {

		WebElement input_search_box = d.findElement(
				By.xpath(
						"//div[contains(@class,'ant-select-open')]"
						+ "//input[@type='search']"
				)
		);

		input_search_box.click();
		input_search_box.clear();
		input_search_box.sendKeys("Ayan");

		System.out.println(
				"🟨 Debug: Plan search text entered using visible search input = Ayan"
		);

	} catch(Exception searchInputException) {

		System.out.println(
				"🟨 Debug: Visible plan search input was unavailable. Using active element."
		);

		System.out.println(
				"🟨 Debug Reason: "
				+ searchInputException.getMessage()
		);

		d.switchTo().activeElement().sendKeys("Ayan");
	}

	Thread.sleep(1000);

	WebElement Visible_Dropdown = d.findElement(
			By.xpath(
					"//div[contains(@class,'ant-select-dropdown') "
					+ "and not(contains(@class,'ant-select-dropdown-hidden'))]"
			)
	);

	WebElement Plan_List = Visible_Dropdown.findElement(
			By.xpath(
					".//div[contains(@class,'rc-virtual-list-holder')]"
			)
	);

	List<WebElement> planoptions =
			Visible_Dropdown.findElements(
					By.xpath(
							".//div[contains(@class,'ant-select-item-option')]"
					)
			);

	WebElement Upgrade_Plan_Option = null;

	for(WebElement planoption : planoptions) {

		String planoption_text =
				planoption.getText().trim();

		System.out.println(
				"🟨 Debug: Plan option found = "
				+ planoption_text
		);

		if(planoption_text.toLowerCase().contains("ayan")
				&& !planoption_text.equalsIgnoreCase(
						Current_Plan_Name
				)) {

			Upgrade_Plan_Option = planoption;
			break;
		}
	}

	if(Upgrade_Plan_Option == null) {

		rp.Scroll_to_bottom_of_list(Plan_List);

		Thread.sleep(800);

		planoptions = Visible_Dropdown.findElements(
				By.xpath(
						".//div[contains(@class,'ant-select-item-option')]"
				)
		);

		for(WebElement planoption : planoptions) {

			String planoption_text =
					planoption.getText().trim();

			System.out.println(
					"🟨 Debug: Plan option found after scroll = "
					+ planoption_text
			);

			if(planoption_text.toLowerCase().contains("ayan")
					&& !planoption_text.equalsIgnoreCase(
							Current_Plan_Name
					)) {

				Upgrade_Plan_Option = planoption;
				break;
			}
		}
	}

	if(Upgrade_Plan_Option == null) {

		String errorMessage =
				"No alternative Ayan plan was found. Current Plan = "
				+ Current_Plan_Name
				+ " | Email = " + Email;

		Report_Listen.log_print_in_report().log(
				Status.FAIL,
				"<b>❌ Failure:</b> " + errorMessage
		);

		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>"
		);

		System.out.println(
				"❌ Failure: " + errorMessage
		);

		throw new IllegalStateException(errorMessage);
	}

	Selected_Upgrade_Plan_Name =
			Upgrade_Plan_Option.getText().trim();

	rp.movetoelement(Upgrade_Plan_Option);
	Upgrade_Plan_Option.click();

	Report_Listen.log_print_in_report().log(
			Status.PASS,
			"<b>✅ Actual:</b> Upgrade plan selected successfully = "
			+ Selected_Upgrade_Plan_Name
	);

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>"
	);

	System.out.println(
			"✅ Actual: Upgrade plan selected successfully = "
			+ Selected_Upgrade_Plan_Name
	);

	System.out.println();

	/*
	 * Billing configuration section
	 */
	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>━━━━━━━━━━━━━━ 🧾 BILLING CONFIGURATION ━━━━━━━━━━━━━━</b>"
	);

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>Step " + (step++)
			+ ":</b> Continue with the selected upgrade plan."
	);

	System.out.println(
			"━━━━━━━━━━━━━━ 🧾 BILLING CONFIGURATION ━━━━━━━━━━━━━━"
	);

	System.out.println(
			"Step " + (step - 1)
			+ ": Continue with the selected upgrade plan."
	);

	p.Continue_button().click();

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>🟨 Actual:</b> Continued successfully with the selected upgrade plan."
	);

	System.out.println(
			"🟨 Actual: Continued successfully with the selected upgrade plan."
	);

	System.out.println();

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>Step " + (step++)
			+ ":</b> Select billing frequency and plan start date."
	);

	System.out.println(
			"Step " + (step - 1)
			+ ": Select billing frequency and plan start date."
	);

	WebElement Upgrade_Popup = p.Plan_change_popup();

	List<WebElement> inputfields = Upgrade_Popup.findElements(
			By.xpath(
					"./../../../../.."
					+ "//div[@class='ant-form-item-control-input-content']"
			)
	);

	inputfields.get(0).click();

	WebElement Billing_Frequency_List =
			p.rc_virtual_list_holder_two();

	rp.Scroll_to_bottom_of_list(
			Billing_Frequency_List
	);

	WebElement Billing_Frequency_First_Option =
			Billing_Frequency_List.findElements(
					By.xpath(
							".//div[contains(@class,"
							+ "'ant-select-item ant-select-item-option')]"
					)
			).get(0);

	String Selected_Billing_Frequency =
			Billing_Frequency_First_Option
					.getText()
					.trim();

	Billing_Frequency_First_Option.click();

	inputfields.get(1).click();

	WebElement Start_Date_List =
			p.rc_virtual_list_holder_three();

	rp.Scroll_to_bottom_of_list(
			Start_Date_List
	);

	WebElement Start_Date_second_Option =
			Start_Date_List.findElements(
					By.xpath(
							".//div[contains(@class,"
							+ "'ant-select-item ant-select-item-option')]"
					)
			).get(1);

	String Selected_Start_Date =
			Start_Date_second_Option
					.getText()
					.trim();

	Start_Date_second_Option.click();

	Report_Listen.log_print_in_report().log(
			Status.PASS,
			"<b>✅ Actual:</b> Billing configuration selected successfully. "
			+ "Billing Frequency = " + Selected_Billing_Frequency
			+ " | Start Date = " + Selected_Start_Date
	);

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>"
	);

	System.out.println(
			"✅ Actual: Billing configuration selected successfully. "
			+ "Billing Frequency = " + Selected_Billing_Frequency
			+ " | Start Date = " + Selected_Start_Date
	);

	System.out.println();

	p.Submit_button().click();

	/*
	 * Billing address section
	 */
	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>━━━━━━━━━━━━━━ 📍 BILLING ADDRESS ━━━━━━━━━━━━━━</b>"
	);

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>Step " + (step++)
			+ ":</b> Enter the billing address details."
	);

	System.out.println(
			"━━━━━━━━━━━━━━ 📍 BILLING ADDRESS ━━━━━━━━━━━━━━"
	);

	System.out.println(
			"Step " + (step - 1)
			+ ": Enter the billing address details."
	);

	WebElement Last_Popup = p.form_original();

	WebElement FirstName = p.first_name();
	WebElement LastName = p.last_name();
	WebElement Address_Field = p.address();
	WebElement Country_Feild = p.country();
	WebElement State_Feild = p.state();
	WebElement City_Feild = p.city();
	WebElement Zip_Feild = p.zipcode();

	FirstName.clear();
	FirstName.sendKeys(First_Name);

	LastName.clear();
	LastName.sendKeys(Last_Name);

	Address_Field.clear();
	Address_Field.sendKeys(Address);

	List<WebElement> popup_inputs =
			Last_Popup.findElements(
					By.xpath(
							".//*[@class='ant-form-item-control-input']"
					)
			);

	popup_inputs.get(3).click();

	Country_Feild.clear();
	Country_Feild.sendKeys(Country);

	WebElement Country_List =
			p.rc_virtual_list_holder_two();

	rp.Scroll_to_bottom_of_list(
			Country_List
	);

	Country_List.findElements(
			By.xpath(
					".//div[contains(@class,"
					+ "'ant-select-item ant-select-item-option')]"
			)
	).get(0).click();

	State_Feild.clear();
	State_Feild.sendKeys(State);

	City_Feild.clear();
	City_Feild.sendKeys(City);

	Zip_Feild.clear();
	Zip_Feild.sendKeys(Zip);

	Report_Listen.log_print_in_report().log(
			Status.PASS,
			"<b>✅ Actual:</b> Billing address entered successfully. "
			+ "Country = " + Country
			+ " | State = " + State
			+ " | City = " + City
			+ " | Zip = " + Zip
	);

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>"
	);

	System.out.println(
			"✅ Actual: Billing address entered successfully. "
			+ "Country = " + Country
			+ " | State = " + State
			+ " | City = " + City
			+ " | Zip = " + Zip
	);

	System.out.println();

	/*
	 * Plan upgrade section
	 */
	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>━━━━━━━━━━━━━━ 🚀 PLAN UPGRADE ━━━━━━━━━━━━━━</b>"
	);

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>Step " + (step++)
			+ ":</b> Submit and verify the plan upgrade."
	);

	System.out.println(
			"━━━━━━━━━━━━━━ 🚀 PLAN UPGRADE ━━━━━━━━━━━━━━"
	);

	System.out.println(
			"Step " + (step - 1)
			+ ": Submit and verify the plan upgrade."
	);

	WebElement Subscribe_button =
			p.Submit_button();

	rp.Scroll_to_element(
			Subscribe_button
	);

	Subscribe_button.click();

	p.Upgrade_Successful_message();

	Report_Listen.log_print_in_report().log(
			Status.PASS,
			"<b>✅ Actual:</b> Plan upgrade confirmation displayed successfully. "
			+ "Previous Plan = " + Current_Plan_Name
			+ " | Selected Upgrade Plan = "
			+ Selected_Upgrade_Plan_Name
	);

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>"
	);

	System.out.println(
			"✅ Actual: Plan upgrade confirmation displayed successfully."
	);

	System.out.println(
			"Previous Plan = "
			+ Current_Plan_Name
	);

	System.out.println(
			"Selected Upgrade Plan = "
			+ Selected_Upgrade_Plan_Name
	);

	System.out.println();

	WebElement Close_button = d.findElement(
			By.xpath(
					"(//*[@aria-modal='true']"
					+ "//*[@aria-label='Close'])[2]"
			)
	);

	rp.wait_for_theElement(Close_button);

	Close_button.click();

	Thread.sleep(1000);

	/*
	 * Active plan identification section
	 */
	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>━━━━━━━━━━━━━━ 🟢 ACTIVE PLAN IDENTIFICATION ━━━━━━━━━━━━━━</b>"
	);

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>Step " + (step++)
			+ ":</b> Identify the account plan carrying the Active tag."
	);

	System.out.println(
			"━━━━━━━━━━━━━━ 🟢 ACTIVE PLAN IDENTIFICATION ━━━━━━━━━━━━━━"
	);

	System.out.println(
			"Step " + (step - 1)
			+ ": Identify the account plan carrying the Active tag."
	);

	Billing_section = p.Billing_Tab();

	rp.Scroll_to_element(Billing_section);

	Plan_section = Billing_section.findElements(
			By.xpath(
					".//div[@class='wrap-panel-row px-3 py-4 cursor-pointer border-bottom']"
			)
	);

	for(WebElement plan_section : Plan_section) {

		List<WebElement> Plan_Tags =
				plan_section.findElements(
						By.xpath(
								".//span[contains(@class,'ant-tag')]"
						)
				);

		if(Plan_Tags.isEmpty()) {

			System.out.println(
					"🟨 Debug: No plan tag found inside this plan section."
			);

			continue;
		}

		String Tag_Text =
				Plan_Tags.get(0)
						.getText()
						.trim();

		System.out.println(
				"🟨 Debug: Plan tag found = "
				+ Tag_Text
		);

		if(Tag_Text.toLowerCase().contains("active")) {

			WebElement Active_Plan_Element =
					plan_section.findElement(
							By.xpath(
									".//div[@class='ant-col ant-col-12']//p"
							)
					);

			String Active_Plan_Full_Text =
					Active_Plan_Element
							.getText()
							.trim();

			Active_Plan_Name =
					Active_Plan_Full_Text
							.split("\\|")[0]
							.trim();

			Report_Listen.log_print_in_report().log(
					Status.PASS,
					"<b>✅ Actual:</b> Active account plan identified successfully = "
					+ Active_Plan_Name
			);

			System.out.println(
					"✅ Actual: Active account plan identified successfully = "
					+ Active_Plan_Name
			);

			System.out.println(
					"🟨 Debug: Active Plan Full Text = "
					+ Active_Plan_Full_Text
			);

			System.out.println();

			break;
		}
	}

	if(Active_Plan_Name.isEmpty()) {

		String errorMessage =
				"No account plan carrying the Active tag was found after upgrade. "
				+ "Email = " + Email;

		Report_Listen.log_print_in_report().log(
				Status.FAIL,
				"<b>❌ Failure:</b> " + errorMessage
		);

		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>"
		);

		System.out.println(
				"❌ Failure: " + errorMessage
		);

		throw new IllegalStateException(errorMessage);
	}

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>"
	);

	System.out.println(
			"━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
	);

	System.out.println();

	d.navigate().to(
			"https://accounts.dev.besimplified.net/accounts"
	);

	try {

		rp.wait_for_invisibilty_of_theElement(
				p.Loader()
		);

		System.out.println(
				"🟨 Debug: Post-upgrade account list loader disappeared."
		);

	} catch(Exception loaderException) {

		System.out.println(
				"🟨 Debug: Post-upgrade account list loader was absent or already disappeared."
		);

		System.out.println(
				"🟨 Debug Reason: "
				+ loaderException.getMessage()
		);
	}

	/*
	 * Final verification section
	 */
	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>━━━━━━━━━━━━━━ ✅ FINAL VERIFICATION ━━━━━━━━━━━━━━</b>"
	);

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>Step " + (step++)
			+ ":</b> Verify that the identified active plan is displayed in the account list."
	);

	System.out.println(
			"━━━━━━━━━━━━━━ ✅ FINAL VERIFICATION ━━━━━━━━━━━━━━"
	);

	System.out.println(
			"Step " + (step - 1)
			+ ": Verify that the identified active plan is displayed in the account list."
	);

	try {

		p.filter_clear_button().click();

		System.out.println(
				"🟨 Debug: Existing account-list filters cleared successfully."
		);

	} catch(Exception filterException) {

		System.out.println(
				"🟨 Debug: No account-list filter required clearing."
		);

		System.out.println(
				"🟨 Debug Reason: "
				+ filterException.getMessage()
		);
	}

	try {

		rp.wait_for_invisibilty_of_theElement(
				p.Loader()
		);

		System.out.println(
				"🟨 Debug: Account list loader disappeared after clearing filters."
		);

	} catch(Exception loaderException) {

		System.out.println(
				"🟨 Debug: Account list loader was absent or already disappeared."
		);

		System.out.println(
				"🟨 Debug Reason: "
				+ loaderException.getMessage()
		);
	}

	Search = p.search_field();

	Search.clear();
	Search.sendKeys(Email);

	Thread.sleep(2000);

	List<WebElement> Plan_Column_vals =
			p.Table_Third_Column_Plan_Column_Values();

	for(WebElement value : Plan_Column_vals) {

		String Plan_Column_Text =
				value.getText().trim();

		System.out.println(
				"🟨 Debug: Plan column value found = "
				+ Plan_Column_Text
		);

		if(Plan_Column_Text
				.toLowerCase()
				.contains(
						Active_Plan_Name.toLowerCase()
				)) {

			Report_Listen.log_print_in_report().log(
					Status.PASS,
					"<b>✅ Final Result:</b> Plan upgrade verification completed successfully. "
					+ "Active Plan = " + Active_Plan_Name
					+ " | Selected Upgrade Plan = "
					+ Selected_Upgrade_Plan_Name
					+ " | Email = " + Email
			);

			Report_Listen.log_print_in_report().log(
					Status.INFO,
					"<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>"
			);

			System.out.println(
					"✅ Final Result: Plan upgrade verification completed successfully."
			);

			System.out.println(
					"Active Plan displayed in account list = "
					+ Active_Plan_Name
			);

			System.out.println(
					"Selected Upgrade Plan = "
					+ Selected_Upgrade_Plan_Name
			);

			System.out.println(
					"Email = " + Email
			);

			System.out.println(
					"━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
			);

			System.out.println();

			return Selected_Upgrade_Plan_Name;
		}
	}

	String errorMessage =
			"Expected Active Plan = "
			+ Active_Plan_Name
			+ " was not found in the account list after upgrade. "
			+ "Selected Upgrade Plan = "
			+ Selected_Upgrade_Plan_Name
			+ " | Email = " + Email;

	Report_Listen.log_print_in_report().log(
			Status.FAIL,
			"<b>❌ Final Result:</b> " + errorMessage
	);

	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>"
	);

	System.out.println(
			"❌ Final Result: " + errorMessage
	);

	System.out.println(
			"━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
	);

	System.out.println();

	throw new IllegalStateException(errorMessage);
}

@DataProvider
public Object[][] Account_create_and_Plan_Upgrade_combined_data_provider() {
	
	
	
	Object[][] Create_Account_datas = Account_Create_Data();
	Object[][] Plan_upgrade_datas = Plan_Upgrade_Billing_Data();
	
	int n =  IntStream.of( Create_Account_datas.length, Plan_upgrade_datas.length).min().orElse(0);

	
	Object[][] combined_data = new Object[n][2];
	int i=0;
    while(i<n){
    	combined_data[i][0] = Create_Account_datas[i][0];       // Account Create datas
    	combined_data[i][1] = Plan_upgrade_datas[i][0];  // Upgrade Plan Datas
    	
        i++;
    }
    return combined_data;
	
}


@DataProvider
public Object[][] Acount_Create_and_Form_data_combined_data_provider() {
	
	
	
	Object[][] Create_Account_datas = Account_Create_Data();
	Object[][] Form_datas = Contact_Form_Data();
	
	int n =  IntStream.of( Create_Account_datas.length, Form_datas.length).min().orElse(0);

	
	Object[][] combined_data = new Object[n][2];
	int i=0;
    while(i<n){
    	combined_data[i][0] = Create_Account_datas[i][0];       // Account Create datas
    	combined_data[i][1] = Form_datas[i][0];  // Upgrade Plan Datas
    	
        i++;
    }
    return combined_data;
	
}


@DataProvider
public Object[][] Plan_Upgrade_Billing_Data() {

	TreeMap<String, String> data1 = new TreeMap<String, String>();
	data1.put("First Name", "Adrian");
	data1.put("Last Name", "Keller");
	data1.put("Address", "18 Lindenstrasse, Business Tower 4");
	data1.put("Country", "Germany");
	data1.put("City", "Berlin");
	data1.put("State", "Berlin");
	data1.put("Zip", "10115");

	TreeMap<String, String> data2 = new TreeMap<String, String>();
	data2.put("First Name", "Claire");
	data2.put("Last Name", "Morel");
	data2.put("Address", "42 Rue Lafayette, Suite 305");
	data2.put("Country", "France");
	data2.put("City", "Paris");
	data2.put("State", "Ile-de-France");
	data2.put("Zip", "75009");

	TreeMap<String, String> data3 = new TreeMap<String, String>();
	data3.put("First Name", "Matteo");
	data3.put("Last Name", "Ricci");
	data3.put("Address", "27 Via Torino, Floor 2");
	data3.put("Country", "Italy");
	data3.put("City", "Milan");
	data3.put("State", "Lombardy");
	data3.put("Zip", "20123");

	TreeMap<String, String> data4 = new TreeMap<String, String>();
	data4.put("First Name", "Sophie");
	data4.put("Last Name", "Van Dijk");
	data4.put("Address", "64 Herengracht, Office 12B");
	data4.put("Country", "Netherlands");
	data4.put("City", "Amsterdam");
	data4.put("State", "North Holland");
	data4.put("Zip", "1015BN");

	TreeMap<String, String> data5 = new TreeMap<String, String>();
	data5.put("First Name", "Oliver");
	data5.put("Last Name", "Whitfield");
	data5.put("Address", "91 King Street, Unit 7");
	data5.put("Country", "United Kingdom");
	data5.put("City", "London");
	data5.put("State", "England");
	data5.put("Zip", "SW1A 1AA");

	TreeMap<String, String> data6 = new TreeMap<String, String>();
	data6.put("First Name", "Isabella");
	data6.put("Last Name", "Martinez");
	data6.put("Address", "35 Calle de Alcala, Planta 4");
	data6.put("Country", "Spain");
	data6.put("City", "Madrid");
	data6.put("State", "Community of Madrid");
	data6.put("Zip", "28014");

	TreeMap<String, String> data7 = new TreeMap<String, String>();
	data7.put("First Name", "Erik");
	data7.put("Last Name", "Lundgren");
	data7.put("Address", "22 Drottninggatan, Workspace 8");
	data7.put("Country", "Sweden");
	data7.put("City", "Stockholm");
	data7.put("State", "Stockholm County");
	data7.put("Zip", "11151");

	TreeMap<String, String> data8 = new TreeMap<String, String>();
	data8.put("First Name", "Nora");
	data8.put("Last Name", "Bergheim");
	data8.put("Address", "14 Karl Johans Gate, Office 6");
	data8.put("Country", "Norway");
	data8.put("City", "Oslo");
	data8.put("State", "Oslo");
	data8.put("Zip", "0154");

	TreeMap<String, String> data9 = new TreeMap<String, String>();
	data9.put("First Name", "Lukas");
	data9.put("Last Name", "Meier");
	data9.put("Address", "58 Bahnhofstrasse, Level 3");
	data9.put("Country", "Switzerland");
	data9.put("City", "Zurich");
	data9.put("State", "Zurich");
	data9.put("Zip", "8001");

	TreeMap<String, String> data10 = new TreeMap<String, String>();
	data10.put("First Name", "Emily");
	data10.put("Last Name", "Anderson");
	data10.put("Address", "120 Madison Avenue, Suite 904");
	data10.put("Country", "United States");
	data10.put("City", "New York");
	data10.put("State", "New York");
	data10.put("Zip", "10016");

	TreeMap<String, String> data11 = new TreeMap<String, String>();
	data11.put("First Name", "Henrik");
	data11.put("Last Name", "Schneider");
	data11.put("Address", "73 Maximilianstrasse, Office 210");
	data11.put("Country", "Germany");
	data11.put("City", "Munich");
	data11.put("State", "Bavaria");
	data11.put("Zip", "80539");

	TreeMap<String, String> data12 = new TreeMap<String, String>();
	data12.put("First Name", "Juliette");
	data12.put("Last Name", "Bernard");
	data12.put("Address", "16 Rue Victor Hugo, Batiment B");
	data12.put("Country", "France");
	data12.put("City", "Lyon");
	data12.put("State", "Auvergne-Rhone-Alpes");
	data12.put("Zip", "69002");

	TreeMap<String, String> data13 = new TreeMap<String, String>();
	data13.put("First Name", "Alessandro");
	data13.put("Last Name", "Ferrari");
	data13.put("Address", "49 Via Nazionale, Scala A");
	data13.put("Country", "Italy");
	data13.put("City", "Rome");
	data13.put("State", "Lazio");
	data13.put("Zip", "00184");

	TreeMap<String, String> data14 = new TreeMap<String, String>();
	data14.put("First Name", "Mila");
	data14.put("Last Name", "Jansen");
	data14.put("Address", "31 Coolsingel, Business Center");
	data14.put("Country", "Netherlands");
	data14.put("City", "Rotterdam");
	data14.put("State", "South Holland");
	data14.put("Zip", "3012AD");

	TreeMap<String, String> data15 = new TreeMap<String, String>();
	data15.put("First Name", "George");
	data15.put("Last Name", "Harrington");
	data15.put("Address", "77 Deansgate, Floor 5");
	data15.put("Country", "United Kingdom");
	data15.put("City", "Manchester");
	data15.put("State", "England");
	data15.put("Zip", "M3 2BW");

	TreeMap<String, String> data16 = new TreeMap<String, String>();
	data16.put("First Name", "Lucia");
	data16.put("Last Name", "Navarro");
	data16.put("Address", "88 Passeig de Gracia, Oficina 9");
	data16.put("Country", "Spain");
	data16.put("City", "Barcelona");
	data16.put("State", "Catalonia");
	data16.put("Zip", "08008");

	TreeMap<String, String> data17 = new TreeMap<String, String>();
	data17.put("First Name", "Astrid");
	data17.put("Last Name", "Nyström");
	data17.put("Address", "45 Sodra Forstadsgatan, Unit 11");
	data17.put("Country", "Sweden");
	data17.put("City", "Malmo");
	data17.put("State", "Skane County");
	data17.put("Zip", "21143");

	TreeMap<String, String> data18 = new TreeMap<String, String>();
	data18.put("First Name", "Magnus");
	data18.put("Last Name", "Haukeland");
	data18.put("Address", "9 Bryggen, Office 3");
	data18.put("Country", "Norway");
	data18.put("City", "Bergen");
	data18.put("State", "Vestland");
	data18.put("Zip", "5003");

	TreeMap<String, String> data19 = new TreeMap<String, String>();
	data19.put("First Name", "Elena");
	data19.put("Last Name", "Vogel");
	data19.put("Address", "26 Rue du Rhone, Suite 15");
	data19.put("Country", "Switzerland");
	data19.put("City", "Geneva");
	data19.put("State", "Geneva");
	data19.put("Zip", "1204");

	TreeMap<String, String> data20 = new TreeMap<String, String>();
	data20.put("First Name", "Daniel");
	data20.put("Last Name", "Carter");
	data20.put("Address", "430 North Michigan Avenue, Suite 1200");
	data20.put("Country", "United States");
	data20.put("City", "Chicago");
	data20.put("State", "Illinois");
	data20.put("Zip", "60611");

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

@DataProvider
public Object[][] Contact_Form_Data() {

	TreeMap<String, String> data1 = new TreeMap<String, String>();
	data1.put("Selected Product", "Simplified Checkout");
	data1.put("First Name", "Ansgar Volker");
	data1.put("Last Name", "Kraneburg");
	data1.put("Email", "ansgar.volker.kraneburg.checkout326@yopmail.com");
	data1.put("Company Name", "Kraneburg Digital Commerce GmbH");
	data1.put("Country Code", "+49");
	data1.put("Phone Number", "15726483910");
	data1.put("Message", "We are evaluating Simplified Checkout to streamline payment processing, reduce cart abandonment, improve transaction visibility, simplify customer purchases, and strengthen digital commerce reporting.");

	TreeMap<String, String> data2 = new TreeMap<String, String>();
	data2.put("Selected Product", "Simplified Hire");
	data2.put("First Name", "Sidonie Blanche");
	data2.put("Last Name", "Montferrand");
	data2.put("Email", "sidonie.blanche.montferrand.hire327@yopmail.com");
	data2.put("Company Name", "Montferrand Talent Advisory SAS");
	data2.put("Country Code", "+33");
	data2.put("Phone Number", "752638491");
	data2.put("Message", "Our recruitment team wants to review Simplified Hire for vacancy management, candidate tracking, recruiter collaboration, interview feedback, hiring-stage movement, and recruitment analytics.");

	TreeMap<String, String> data3 = new TreeMap<String, String>();
	data3.put("Selected Product", "Simplified HR");
	data3.put("First Name", "Otso Viljami");
	data3.put("Last Name", "Kettunen");
	data3.put("Email", "otso.viljami.kettunen.hr328@yopmail.com");
	data3.put("Company Name", "Kettunen People Services Oy");
	data3.put("Country Code", "+358");
	data3.put("Phone Number", "458936271");
	data3.put("Message", "We are exploring Simplified HR for employee record management, attendance monitoring, leave approvals, department administration, role permissions, internal communication, and workforce reporting.");

	TreeMap<String, String> data4 = new TreeMap<String, String>();
	data4.put("Selected Product", "Simplified Spaces");
	data4.put("First Name", "Rinaldo Ettore");
	data4.put("Last Name", "Gherardi");
	data4.put("Email", "rinaldo.ettore.gherardi.spaces329@yopmail.com");
	data4.put("Company Name", "Gherardi Workspace Management SRL");
	data4.put("Country Code", "+39");
	data4.put("Phone Number", "3539461827");
	data4.put("Message", "We manage multiple flexible offices and want to evaluate Simplified Spaces for desk reservations, meeting-room scheduling, customer inquiries, branch availability, and workspace utilization reporting.");

	TreeMap<String, String> data5 = new TreeMap<String, String>();
	data5.put("Selected Product", "Simplified Checkout, Simplified Hire");
	data5.put("First Name", "Neville Ambrose");
	data5.put("Last Name", "Pembroke");
	data5.put("Email", "neville.ambrose.pembroke.checkout.hire330@yopmail.com");
	data5.put("Company Name", "Pembroke Commerce and Talent Ltd");
	data5.put("Country Code", "+44");
	data5.put("Phone Number", "7583164920");
	data5.put("Message", "Our UK-based company wants to combine online payment management with recruitment workflows, including transaction monitoring, candidate pipelines, recruiter collaboration, and operational reporting.");

	TreeMap<String, String> data6 = new TreeMap<String, String>();
	data6.put("Selected Product", "Simplified HR, Simplified Spaces");
	data6.put("First Name", "Annelot Marijke");
	data6.put("Last Name", "Van Heusden");
	data6.put("Email", "annelot.marijke.vanheusden.hrspaces331@yopmail.com");
	data6.put("Company Name", "Van Heusden People and Offices BV");
	data6.put("Country Code", "+31");
	data6.put("Phone Number", "684297531");
	data6.put("Message", "We need an integrated solution for employee administration, attendance, leave requests, desk reservations, meeting rooms, office availability, and internal operational reporting.");

	TreeMap<String, String> data7 = new TreeMap<String, String>();
	data7.put("Selected Product", "Simplified Checkout, Simplified HR");
	data7.put("First Name", "Korbinian Severus");
	data7.put("Last Name", "Aichinger");
	data7.put("Email", "korbinian.severus.aichinger.checkouthr332@yopmail.com");
	data7.put("Company Name", "Aichinger Business Operations GmbH");
	data7.put("Country Code", "+43");
	data7.put("Phone Number", "6778421935");
	data7.put("Message", "We want to review Simplified Checkout and Simplified HR for transaction processing, payment visibility, employee administration, attendance management, leave approvals, and consolidated reporting.");

	TreeMap<String, String> data8 = new TreeMap<String, String>();
	data8.put("Selected Product", "Simplified Hire, Simplified HR");
	data8.put("First Name", "Miloslawa Halina");
	data8.put("Last Name", "Jankowska");
	data8.put("Email", "miloslawa.halina.jankowska.hirehr333@yopmail.com");
	data8.put("Company Name", "Jankowska Workforce Platforms Sp z oo");
	data8.put("Country Code", "+48");
	data8.put("Phone Number", "518372946");
	data8.put("Message", "Our organization needs connected recruitment and HR workflows covering applications, interviews, hiring decisions, onboarding, employee records, attendance, and leave administration.");

	TreeMap<String, String> data9 = new TreeMap<String, String>();
	data9.put("Selected Product", "Simplified Checkout, Simplified Hire, Simplified HR");
	data9.put("First Name", "Rogier Quinten");
	data9.put("Last Name", "Van Renssen");
	data9.put("Email", "rogier.quinten.vanrenssen.enterprise334@yopmail.com");
	data9.put("Company Name", "Van Renssen Enterprise Services BV");
	data9.put("Country Code", "+31");
	data9.put("Phone Number", "639825174");
	data9.put("Message", "Our enterprise team is comparing platforms for checkout operations, recruitment management, and HR administration, including access control, workflow configuration, reporting, and implementation support.");

	TreeMap<String, String> data10 = new TreeMap<String, String>();
	data10.put("Selected Product", "Simplified Checkout, Simplified Hire, Simplified HR, Simplified Spaces");
	data10.put("First Name", "Heidemarie Berta");
	data10.put("Last Name", "Kirchberg");
	data10.put("Email", "heidemarie.berta.kirchberg.fullsuite335@yopmail.com");
	data10.put("Company Name", "Kirchberg Integrated Solutions GmbH");
	data10.put("Country Code", "+49");
	data10.put("Phone Number", "16359284710");
	data10.put("Message", "We are evaluating the complete Simplified suite for checkout processing, recruitment workflows, HR administration, workspace booking, branch coordination, and cross-department reporting.");

	TreeMap<String, String> data11 = new TreeMap<String, String>();
	data11.put("Selected Product", "Simplified Checkout");
	data11.put("First Name", "Eusebio Ramon");
	data11.put("Last Name", "Valcarcel");
	data11.put("Email", "eusebio.ramon.valcarcel.checkout336@yopmail.com");
	data11.put("Company Name", "Valcarcel Digital Transactions SL");
	data11.put("Country Code", "+34");
	data11.put("Phone Number", "612847395");
	data11.put("Message", "Our digital commerce team wants to improve checkout reliability, increase successful payment completion, reduce purchase friction, monitor transactions, and analyze online sales performance.");

	TreeMap<String, String> data12 = new TreeMap<String, String>();
	data12.put("Selected Product", "Simplified Hire");
	data12.put("First Name", "Clarissa Donata");
	data12.put("Last Name", "Bellocchi");
	data12.put("Email", "clarissa.donata.bellocchi.hire337@yopmail.com");
	data12.put("Company Name", "Bellocchi Recruitment Partners SRL");
	data12.put("Country Code", "+39");
	data12.put("Phone Number", "3487162950");
	data12.put("Message", "We are managing several hiring campaigns and want Simplified Hire for candidate profiles, job pipelines, interview coordination, recruiter assignments, hiring-stage updates, and recruitment reports.");

	TreeMap<String, String> data13 = new TreeMap<String, String>();
	data13.put("Selected Product", "Simplified HR");
	data13.put("First Name", "Isak Melker");
	data13.put("Last Name", "Norstrom");
	data13.put("Email", "isak.melker.norstrom.hr338@yopmail.com");
	data13.put("Company Name", "Norstrom People Management AB");
	data13.put("Country Code", "+46");
	data13.put("Phone Number", "702583946");
	data13.put("Message", "We are searching for an HR platform to manage employee profiles, organizational structures, attendance records, leave workflows, user permissions, internal communication, and workforce analytics.");

	TreeMap<String, String> data14 = new TreeMap<String, String>();
	data14.put("Selected Product", "Simplified Spaces");
	data14.put("First Name", "Pieterjan Stijn");
	data14.put("Last Name", "De Smet");
	data14.put("Email", "pieterjan.stijn.desmet.spaces339@yopmail.com");
	data14.put("Company Name", "De Smet Flexible Offices BV");
	data14.put("Country Code", "+32");
	data14.put("Phone Number", "472638915");
	data14.put("Message", "We operate shared-office locations and want Simplified Spaces for desk booking, room scheduling, customer requests, resource availability, location coordination, and workspace performance analysis.");

	TreeMap<String, String> data15 = new TreeMap<String, String>();
	data15.put("Selected Product", "Simplified Checkout, Simplified Hire");
	data15.put("First Name", "Maud Perrine");
	data15.put("Last Name", "Rochat");
	data15.put("Email", "maud.perrine.rochat.checkout.hire340@yopmail.com");
	data15.put("Company Name", "Rochat Commerce Talent AG");
	data15.put("Country Code", "+41");
	data15.put("Phone Number", "765294831");
	data15.put("Message", "Our business wants to connect checkout operations with recruitment management for improved payment visibility, applicant tracking, recruiter collaboration, hiring decisions, and centralized reporting.");

	TreeMap<String, String> data16 = new TreeMap<String, String>();
	data16.put("Selected Product", "Simplified HR, Simplified Spaces");
	data16.put("First Name", "Veit Alois");
	data16.put("Last Name", "Hohenacker");
	data16.put("Email", "veit.alois.hohenacker.hrspaces341@yopmail.com");
	data16.put("Company Name", "Hohenacker Corporate Services GmbH");
	data16.put("Country Code", "+49");
	data16.put("Phone Number", "15468392710");
	data16.put("Message", "We need HR and workspace modules to manage employee information, attendance, leave requests, desk reservations, meeting-room availability, office utilization, and internal reports.");

	TreeMap<String, String> data17 = new TreeMap<String, String>();
	data17.put("Selected Product", "Simplified Checkout, Simplified HR");
	data17.put("First Name", "Ronja Tilde");
	data17.put("Last Name", "Svanberg");
	data17.put("Email", "ronja.tilde.svanberg.checkouthr342@yopmail.com");
	data17.put("Company Name", "Svanberg Business Systems AB");
	data17.put("Country Code", "+46");
	data17.put("Phone Number", "736829145");
	data17.put("Message", "We are evaluating Checkout and HR modules for online payment operations, transaction monitoring, employee profile management, attendance visibility, leave approvals, and consolidated reporting.");

	TreeMap<String, String> data18 = new TreeMap<String, String>();
	data18.put("Selected Product", "Simplified Hire, Simplified HR");
	data18.put("First Name", "Orsola Fiammetta");
	data18.put("Last Name", "Albrizzi");
	data18.put("Email", "orsola.fiammetta.albrizzi.hirehr343@yopmail.com");
	data18.put("Company Name", "Albrizzi Workforce Solutions SRL");
	data18.put("Country Code", "+39");
	data18.put("Phone Number", "3459362810");
	data18.put("Message", "Our workforce team wants an integrated recruitment and HR system supporting candidate tracking, interview feedback, onboarding, employee records, attendance, leave approvals, and HR reporting.");

	TreeMap<String, String> data19 = new TreeMap<String, String>();
	data19.put("Selected Product", "Simplified Spaces");
	data19.put("First Name", "Asbjorn Leif");
	data19.put("Last Name", "Hvidberg");
	data19.put("Email", "asbjorn.leif.hvidberg.spaces344@yopmail.com");
	data19.put("Company Name", "Hvidberg Workspace Services ApS");
	data19.put("Country Code", "+45");
	data19.put("Phone Number", "42831597");
	data19.put("Message", "We manage shared workspaces and want to review Simplified Spaces for desk allocation, meeting-room scheduling, customer requests, branch availability, multi-location coordination, and utilization reports.");

	TreeMap<String, String> data20 = new TreeMap<String, String>();
	data20.put("Selected Product", "Simplified Checkout, Simplified Hire, Simplified HR, Simplified Spaces");
	data20.put("First Name", "Seraina Fabienne");
	data20.put("Last Name", "Meierhans");
	data20.put("Email", "seraina.fabienne.meierhans.allmodules345@yopmail.com");
	data20.put("Company Name", "Meierhans Strategic Operations AG");
	data20.put("Country Code", "+41");
	data20.put("Phone Number", "798426315");
	data20.put("Message", "We are comparing complete business platforms and would like a demonstration of all Simplified modules covering checkout, recruitment, HR administration, workspace operations, pricing, configuration, and implementation.");

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

}