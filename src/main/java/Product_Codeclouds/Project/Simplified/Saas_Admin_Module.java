package Product_Codeclouds.Project.Simplified;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TreeMap;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
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

	@Test
	public void Account_Create() throws IOException, InterruptedException{
		
		
		Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
		
		
		Saas_Admin_Login();
		WebElement Create_Button = p.Create_Account_button();
		Create_Button.click();
		List<WebElement> input = p.Customer_form_inputs();
		List<WebElement> dropdowns = p.Customer_form_dropdowns();
		
		
		
		
		
		
		
		
		
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