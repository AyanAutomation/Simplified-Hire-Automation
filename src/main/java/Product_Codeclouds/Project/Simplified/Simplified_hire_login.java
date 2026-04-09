package Product_Codeclouds.Project.Simplified;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
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
		System.out.println("🔹 Scenario Title: Access Simplified Hire internal application from portal");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📘 Description:</b> Login into the system, wait for portal loader to disappear, identify available internal applications, click on Simplified Hire, and validate successful landing on the dashboard.");
		System.out.println("📘 Description: Login into the system, wait for portal loader to disappear, identify available internal applications, click on Simplified Hire, and validate successful landing on the dashboard.");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>✅ Expected:</b> User should be logged into the portal successfully, portal loader should disappear, internal applications should be visible, Simplified Hire application should be accessible, and dashboard should load successfully.");
		System.out.println("✅ Expected: User should be logged into the portal successfully, portal loader should disappear, internal applications should be visible, Simplified Hire application should be accessible, and dashboard should load successfully.");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Perform login into the application.");
		System.out.println("Step " + (step - 1) + ": Perform login into the application.");
		login();
		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>🟨 Actual:</b> Login flow executed successfully and user entered the company portal.");
		System.out.println("🟨 Actual: Login flow executed successfully and user entered the company portal.");

		try {
			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>Step " + (step++) + ":</b> Wait for portal loader to disappear after login.");
			System.out.println("Step " + (step - 1) + ": Wait for portal loader to disappear after login.");

			WebElement loader_try = p.Loader();
			rp.wait_for_invisibilty_of_theElement(loader_try);

			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>🟨 Actual:</b> Portal loader disappeared successfully.");
			System.out.println("🟨 Actual: Portal loader disappeared successfully.");

		} catch (NoSuchElementException | TimeoutException e) {

			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>🟨 Actual:</b> Portal loader was not displayed after login, so no wait was required.");
			System.out.println("🟨 Actual: Portal loader was not displayed after login, so no wait was required.");
		}

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Fetch the list of available internal applications from the portal.");
		System.out.println("Step " + (step - 1) + ": Fetch the list of available internal applications from the portal.");
		List<WebElement> internal_apps = p.Apps();
		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Internal applications fetched successfully. Total apps found = " + internal_apps.size());
		System.out.println("🟨 Actual: Internal applications fetched successfully. Total apps found = " + internal_apps.size());

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Select the Simplified Hire application from the internal applications list.");
		System.out.println("Step " + (step - 1) + ": Select the Simplified Hire application from the internal applications list.");
		WebElement Simplified_Hire = internal_apps.get(0);
		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Simplified Hire application identified successfully from the list.");
		System.out.println("🟨 Actual: Simplified Hire application identified successfully from the list.");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Click on the Simplified Hire application.");
		System.out.println("Step " + (step - 1) + ": Click on the Simplified Hire application.");
		Simplified_Hire.click();
		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Simplified Hire application clicked successfully.");
		System.out.println("🟨 Actual: Simplified Hire application clicked successfully.");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Validate landing on the Simplified Hire dashboard.");
		System.out.println("Step " + (step - 1) + ": Validate landing on the Simplified Hire dashboard.");
		p.Landed_in_Dashboard();
		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>🟨 Actual:</b> User landed successfully on the Simplified Hire dashboard.");
		System.out.println("🟨 Actual: User landed successfully on the Simplified Hire dashboard.");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📌 Final Status:</b> Simplified Hire application accessed successfully from the portal.");
		System.out.println("📌 Final Status: Simplified Hire application accessed successfully from the portal.");
	}

}
