package Product_Codeclouds.Project.Simplified;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Side_menu_locaters;

public class Side_menu_Handler extends Simplified_hire_login {

	public void Menu_option_selector(String opt_text) throws IOException, InterruptedException {

		Side_menu_locaters p = new Side_menu_locaters(d);

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🔹 Scenario Title:</b> Select required side menu option in Simplified Hire");
		System.out.println();
		System.out.println("🔹 Scenario Title: Select required side menu option in Simplified Hire");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📘 Description:</b> Access the Simplified Hire dashboard, open the side menu, fetch all available menu options, search for the required option, and click on it.");
		System.out.println(
				"📘 Description: Access the Simplified Hire dashboard, open the side menu, fetch all available menu options, search for the required option, and click on it.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📥 Input:</b> Required Side Menu Option = " + opt_text);
		System.out.println("📥 Input: Required Side Menu Option = " + opt_text);
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>✅ Expected:</b> User should be able to access the Simplified Hire dashboard, fetch all visible side menu options successfully, and click the required side menu option.");
		System.out.println(
				"✅ Expected: User should be able to access the Simplified Hire dashboard, fetch all visible side menu options successfully, and click the required side menu option.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step 1:</b> Access Simplified Hire dashboard before working with side menu.");
		System.out.println("Step 1: Access Simplified Hire dashboard before working with side menu.");
		System.out.println();
		try {
			p.Side_menu();
		} catch (Exception mm) {
			Simplified_Hire_Accessor();
			p.Side_menu();
		}

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Simplified Hire dashboard accessed successfully.");
		System.out.println("🟨 Actual: Simplified Hire dashboard accessed successfully.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step 2:</b> Open side menu and fetch all available menu options.");
		System.out.println("Step 2: Open side menu and fetch all available menu options.");
		System.out.println();

		List<WebElement> menu_options = p.options();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Side menu options fetched successfully. Total menu options found = " + menu_options.size());
		System.out.println("🟨 Actual: Side menu options fetched successfully. Total menu options found = " + menu_options.size());
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step 3:</b> Search for side menu option = " + opt_text + " and click on it.");
		System.out.println("Step 3: Search for side menu option = " + opt_text + " and click on it.");
		System.out.println();

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

	public void side_menu_expander() throws IOException, InterruptedException {

		Side_menu_locaters p = new Side_menu_locaters(d);

		WebElement Menu_expand = p.Menu_Expander();
		Menu_expand.click();
		p.Side_menu();
	}
}