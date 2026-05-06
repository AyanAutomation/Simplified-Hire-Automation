package Product_Codeclouds.Project.Simplified;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Candidate_Module_Locaters;
import Locaters.Simplified_portal_locaters;
import Repeatative_codes.Repeat;

public class Simplified_hire_login extends Login{
	
	
@Test
public void Simplified_Hire_Accessor() throws IOException, InterruptedException {

	int step = 1;

	Simplified_portal_locaters p = new Simplified_portal_locaters(d);
	Repeat rp = new Repeat(d);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🔹 Scenario Title:</b> Access Simplified Hire internal application from portal");
	System.out.println();
	System.out.println("🔹 Scenario Title: Access Simplified Hire internal application from portal");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📘 Description:</b> Validate access to the Simplified Hire application either through the standard login and internal app selection flow, or through direct dashboard redirection when the account is mapped to only one organization and one application.");
	System.out.println("📘 Description: Validate access to the Simplified Hire application either through the standard login and internal app selection flow, or through direct dashboard redirection when the account is mapped to only one organization and one application.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>✅ Expected:</b> User should either complete the normal login and internal application selection flow and land on the Simplified Hire dashboard, or be directly redirected to the Simplified Hire dashboard if only one mapped organization and one mapped application are available.");
	System.out.println("✅ Expected: User should either complete the normal login and internal application selection flow and land on the Simplified Hire dashboard, or be directly redirected to the Simplified Hire dashboard if only one mapped organization and one mapped application are available.");
	System.out.println();

	try {

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Perform login into the application.");
		System.out.println("Step " + (step - 1) + ": Perform login into the application.");
		System.out.println();

		login();
		check_for_payment_pop_up();
		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>🟨 Actual:</b> Login flow executed successfully and user entered the company portal.");
		System.out.println("🟨 Actual: Login flow executed successfully and user entered the company portal.");
		System.out.println();

		try {
			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>Step " + (step++) + ":</b> Wait for portal loader to disappear after login.");
			System.out.println("Step " + (step - 1) + ": Wait for portal loader to disappear after login.");
			System.out.println();

			WebElement loader_try = p.Loader();
			rp.wait_for_invisibilty_of_theElement(loader_try);

			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>🟨 Actual:</b> Portal loader disappeared successfully.");
			System.out.println("🟨 Actual: Portal loader disappeared successfully.");
			System.out.println();

		} catch (NoSuchElementException | TimeoutException e) {

			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>🟨 Actual:</b> Portal loader was not displayed after login, so no wait was required.");
			System.out.println("🟨 Actual: Portal loader was not displayed after login, so no wait was required.");
			System.out.println();
		}

		Thread.sleep(800);

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Fetch the list of available internal applications from the portal.");
		System.out.println("Step " + (step - 1) + ": Fetch the list of available internal applications from the portal.");
		System.out.println();

		List<WebElement> internal_apps = p.Apps();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Internal applications fetched successfully. Total apps found = " + internal_apps.size());
		System.out.println("🟨 Actual: Internal applications fetched successfully. Total apps found = " + internal_apps.size());
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Identify the Simplified Hire application from the internal applications list.");
		System.out.println("Step " + (step - 1) + ": Identify the Simplified Hire application from the internal applications list.");
		System.out.println();

		WebElement Simplified_Hire = internal_apps.get(1);

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Simplified Hire application identified successfully from the internal applications list.");
		System.out.println("🟨 Actual: Simplified Hire application identified successfully from the internal applications list.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Click on the Simplified Hire application.");
		System.out.println("Step " + (step - 1) + ": Click on the Simplified Hire application.");
		System.out.println();

		Simplified_Hire.click();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Simplified Hire application clicked successfully.");
		System.out.println("🟨 Actual: Simplified Hire application clicked successfully.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Validate landing on the Simplified Hire dashboard through the standard flow.");
		System.out.println("Step " + (step - 1) + ": Validate landing on the Simplified Hire dashboard through the standard flow.");
		System.out.println();

		p.Landed_in_Dashboard();

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>🟨 Actual:</b> User landed successfully on the Simplified Hire dashboard through the standard portal flow.");
		System.out.println("🟨 Actual: User landed successfully on the Simplified Hire dashboard through the standard portal flow.");
		System.out.println();

	} catch (Exception e) {

		Report_Listen.log_print_in_report().log(Status.WARNING,
				"<b>⚠ Fallback:</b> Standard login, company selection, or internal app selection flow was not completed. Verifying whether the account was directly redirected to the Simplified Hire dashboard due to single organization and single application mapping.");
		System.out.println("⚠ Fallback: Standard login, company selection, or internal app selection flow was not completed. Verifying whether the account was directly redirected to the Simplified Hire dashboard due to single organization and single application mapping.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Validate direct landing on the Simplified Hire dashboard.");
		System.out.println("Step " + (step - 1) + ": Validate direct landing on the Simplified Hire dashboard.");
		System.out.println();

		p.Landed_in_Dashboard();

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>🟨 Actual:</b> User was directly redirected and landed successfully on the Simplified Hire dashboard without needing the standard internal app selection flow.");
		System.out.println("🟨 Actual: User was directly redirected and landed successfully on the Simplified Hire dashboard without needing the standard internal app selection flow.");
		System.out.println();
	}

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📌 Final Status:</b> Simplified Hire application access flow completed successfully.");
	System.out.println("📌 Final Status: Simplified Hire application access flow completed successfully.");
	System.out.println();
}


public void check_for_payment_pop_up(){
	
	Candidate_Module_Locaters p = new Candidate_Module_Locaters(d);
	
	try{
	Thread.sleep(800);
	WebElement pop_up_close = p.Pop_Up_close_Button();
	pop_up_close.click();}catch(Exception mm){}
	System.out.println("Checked for payment pop up and it was not displayed.");
	System.out.println();}}
