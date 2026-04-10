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
				"<b>Step:</b> Open side menu and fetch all available menu options.");
		System.out.println("Step: Open side menu and fetch all available menu options.");
		
		Simplified_Hire_Accessor();
		p.Side_menu();
		List<WebElement> menu_options = p.options();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Side menu options fetched successfully. Total menu options found = " + menu_options.size());
		System.out.println("🟨 Actual: Side menu options fetched successfully. Total menu options found = " + menu_options.size());

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step:</b> Search for side menu option = " + opt_text + " and click on it.");
		System.out.println("Step: Search for side menu option = " + opt_text + " and click on it.");

		for (WebElement menuop : menu_options) {
			String menuop_text = menuop.getText().trim();

			if (menuop_text.equalsIgnoreCase(opt_text)) {
				menuop.click();

				Report_Listen.log_print_in_report().log(Status.PASS,
						"<b>🟨 Actual:</b> Side menu option clicked successfully = " + opt_text);
				System.out.println("🟨 Actual: Side menu option clicked successfully = " + opt_text);
				break;
			}
		}
	}
}