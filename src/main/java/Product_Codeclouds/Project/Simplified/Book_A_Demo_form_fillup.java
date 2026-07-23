package Product_Codeclouds.Project.Simplified;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Frontend_Locaters;
import Locaters.Saas_Admin_Locaters;
import Repeatative_codes.Repeat;

@Listeners(Listerners.Report_Listen.class)
public class Book_A_Demo_form_fillup extends Saas_Admin_Module {

	@Test(dataProvider = "combined_data_provider")
	public void book_a_demo_form_fillup(TreeMap<String, String> form_data, TreeMap<String, String> Plan_data,TreeMap<String, String> upgrade_plan_datas, TreeMap<String, String> account_create_data)throws IOException, InterruptedException, AWTException {

		int step = 1;

		Data_Reader f = new Data_Reader();
		Repeat rp = new Repeat(d);
		Frontend_Locaters p = new Frontend_Locaters(d);
		Saas_Admin_Locaters sa = new Saas_Admin_Locaters(d);

		String Selected_Product = form_data.get("Selected Product");
		String First_Name = form_data.get("First Name");
		String Last_Name = form_data.get("Last Name");
		String Email = form_data.get("Email");
		String Company_Name = form_data.get("Company Name");
		String Country_Code = form_data.get("Country Code");
		String Phone_Number = form_data.get("Phone Number");
		String Message = form_data.get("Message");

		String URL = f.Data_Fetcher("Frontend_url");

		String Checkout_plan_name = Plan_data.get("Checkout Plan Name");

		String Spaces_plan_name = Plan_data.get("Spaces Plan Name");

		String Hire_plan_name = Plan_data.get("Hire Plan Name");

		String Hr_plan_name = Plan_data.get("Hr Plan Name");

		String Target_Upgrade_Plan_Name = account_create_data.get("Plan Name");

		if (Target_Upgrade_Plan_Name == null || Target_Upgrade_Plan_Name.trim().length() == 0) {

			if (Selected_Product.toLowerCase().contains("checkout")
					&& account_create_data.get("Checkout Plan Name") != null) {

				Target_Upgrade_Plan_Name = account_create_data.get("Checkout Plan Name");

			} else if (Selected_Product.toLowerCase().contains("hire")
					&& account_create_data.get("Hire Plan Name") != null) {

				Target_Upgrade_Plan_Name = account_create_data.get("Hire Plan Name");

			} else if (Selected_Product.toLowerCase().contains("hr")
					&& account_create_data.get("Hr Plan Name") != null) {

				Target_Upgrade_Plan_Name = account_create_data.get("Hr Plan Name");

			} else if (Selected_Product.toLowerCase().contains("spaces")
					&& account_create_data.get("Spaces Plan Name") != null) {

				Target_Upgrade_Plan_Name = account_create_data.get("Spaces Plan Name");
			}
		}

		if (Target_Upgrade_Plan_Name == null || Target_Upgrade_Plan_Name.trim().length() == 0) {

			Target_Upgrade_Plan_Name = "Ayan";
		}

		String Upgrade_Users = account_create_data.get("Users");

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");

		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🔹 Scenario Title:</b> Validate Book a Demo form submission, field validation, lead approval, plan upgrade, and account activation");

		System.out.println();
		System.out.println(
				"🔹 Scenario Title: Validate Book a Demo form submission, field validation, lead approval, plan upgrade, and account activation");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📘 Description:</b> Open the frontend URL, navigate to the Book a Demo page, select products according to the test data, validate that numeric characters are rejected in the First Name and Last Name fields, enter valid contact details, submit the form, handle CAPTCHA when displayed, verify the submitted lead in SaaS Admin, approve the lead, upgrade the assigned plan, and activate the account.");

		System.out.println(
				"📘 Description: Open the frontend URL, navigate to the Book a Demo page, select products according to the test data, validate that numeric characters are rejected in the First Name and Last Name fields, enter valid contact details, submit the form, handle CAPTCHA when displayed, verify the submitted lead in SaaS Admin, approve the lead, upgrade the assigned plan, and activate the account.");

		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📥 Input:</b> Selected Product = " + Selected_Product + " | Name = " + First_Name + " " + Last_Name
						+ " | Email = " + Email + " | Company = " + Company_Name + " | Country Code = " + Country_Code
						+ " | Phone Number = " + Phone_Number + " | Message = " + Message);

		System.out.println("📥 Input: Selected Product = " + Selected_Product + " | Name = " + First_Name + " "
				+ Last_Name + " | Email = " + Email + " | Company = " + Company_Name + " | Country Code = "
				+ Country_Code + " | Phone Number = " + Phone_Number + " | Message = " + Message);

		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📥 Lead Approval Plan Input:</b> Hire Plan = " + Hire_plan_name + " | Checkout Plan = "
						+ Checkout_plan_name + " | HR Plan = " + Hr_plan_name + " | Spaces Plan = " + Spaces_plan_name);

		System.out.println("📥 Lead Approval Plan Input: Hire Plan = " + Hire_plan_name + " | Checkout Plan = "
				+ Checkout_plan_name + " | HR Plan = " + Hr_plan_name + " | Spaces Plan = " + Spaces_plan_name);

		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>📥 Plan Upgrade Input:</b> Target Upgrade Plan = "
				+ Target_Upgrade_Plan_Name + " | Users = " + Upgrade_Users + " | Billing First Name = "
				+ upgrade_plan_datas.get("First Name") + " | Billing Last Name = " + upgrade_plan_datas.get("Last Name")
				+ " | Country = " + upgrade_plan_datas.get("Country") + " | City = " + upgrade_plan_datas.get("City")
				+ " | State = " + upgrade_plan_datas.get("State") + " | Zip = " + upgrade_plan_datas.get("Zip"));

		System.out.println("📥 Plan Upgrade Input: Target Upgrade Plan = " + Target_Upgrade_Plan_Name + " | Users = "
				+ Upgrade_Users + " | Billing First Name = " + upgrade_plan_datas.get("First Name")
				+ " | Billing Last Name = " + upgrade_plan_datas.get("Last Name") + " | Country = "
				+ upgrade_plan_datas.get("Country") + " | City = " + upgrade_plan_datas.get("City") + " | State = "
				+ upgrade_plan_datas.get("State") + " | Zip = " + upgrade_plan_datas.get("Zip"));

		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>✅ Expected:</b> First Name and Last Name fields should display validation errors when numeric characters are entered. Valid contact details should be accepted, the Book a Demo request should be submitted successfully, and the submitted lead details should match the SaaS Admin record. The lead should then be approved, its plan should be upgraded, and the account should be activated.");

		System.out.println(
				"✅ Expected: First Name and Last Name fields should display validation errors when numeric characters are entered. Valid contact details should be accepted, the Book a Demo request should be submitted successfully, and the submitted lead details should match the SaaS Admin record. The lead should then be approved, its plan should be upgraded, and the account should be activated.");

		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 🌐 FRONTEND ACCESS ━━━━━━━━━━━━━━</b>");

		System.out.println("━━━━━━━━━━━━━━ 🌐 FRONTEND ACCESS ━━━━━━━━━━━━━━");

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Open the frontend URL.");

		System.out.println("Step " + (step - 1) + ": Open the frontend URL.");

		d.get(URL);

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>✅ Actual:</b> Frontend URL opened successfully = " + URL);

		System.out.println("✅ Actual: Frontend URL opened successfully = " + URL);

		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Click the Book a Demo button from the banner.");

		System.out.println("Step " + (step - 1) + ": Click the Book a Demo button from the banner.");

		WebElement Book_Button = p.Book_a_demo_button_Banner();

		Book_Button.click();

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>✅ Actual:</b> Book a Demo button clicked successfully.");

		System.out.println("✅ Actual: Book a Demo button clicked successfully.");

		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Validate landing on the Book a Demo form page.");

		System.out.println("Step " + (step - 1) + ": Validate landing on the Book a Demo form page.");

		p.Landed_in_Booking_form_page_confirmation();

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>✅ Actual:</b> User landed successfully on the Book a Demo form page.");

		System.out.println("✅ Actual: User landed successfully on the Book a Demo form page.");

		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Accept cookies when the cookie banner is displayed.");

		System.out.println("Step " + (step - 1) + ": Accept cookies when the cookie banner is displayed.");

		try {

			p.Accept_cookies_button().click();

			Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Cookies accepted successfully.");

			System.out.println("✅ Actual: Cookies accepted successfully.");

		} catch (Exception e) {

			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>⚠ Actual:</b> Cookie banner was not displayed, so the cookie acceptance step was skipped.");

			System.out.println("⚠ Actual: Cookie banner was not displayed, so the cookie acceptance step was skipped.");
		}

		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>━━━━━━━━━━━━━━ 🧩 PRODUCT SELECTION ━━━━━━━━━━━━━━</b>");

		System.out.println("━━━━━━━━━━━━━━ 🧩 PRODUCT SELECTION ━━━━━━━━━━━━━━");

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++)
				+ ":</b> Fetch form input fields, message box, submit button, product cards, and product checkboxes.");

		System.out.println("Step " + (step - 1)
				+ ": Fetch form input fields, message box, submit button, product cards, and product checkboxes.");

		List<WebElement> Input_Fields = p.inputs();

		WebElement Message_Box = p.Textarea();

		WebElement Submit_Button = p.Submit_button();

		List<WebElement> Cards = p.Product_cards();

		List<WebElement> Product_checkboxes = p.Product_check_boxes();

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Input Fields = " + Input_Fields.size()
				+ " | Product Cards = " + Cards.size() + " | Product Checkboxes = " + Product_checkboxes.size());

		System.out.println("🟨 Actual: Input Fields = " + Input_Fields.size() + " | Product Cards = " + Cards.size()
				+ " | Product Checkboxes = " + Product_checkboxes.size());

		System.out.println();

		boolean product_selected = false;
		int selected_product_count = 0;

		String Selected_Product_Value = Selected_Product.trim();

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++)
				+ ":</b> Select product checkbox options according to test data = " + Selected_Product_Value);

		System.out.println("Step " + (step - 1) + ": Select product checkbox options according to test data = "
				+ Selected_Product_Value);

		if (Selected_Product_Value.equals("Simplified Checkout")) {

			Product_checkboxes.get(0).click();

			product_selected = true;
			selected_product_count = 1;
		}

		if (Selected_Product_Value.equals("Simplified Hire")) {

			Product_checkboxes.get(1).click();

			product_selected = true;
			selected_product_count = 1;
		}

		if (Selected_Product_Value.equals("Simplified HR")) {

			Product_checkboxes.get(2).click();

			product_selected = true;
			selected_product_count = 1;
		}

		if (Selected_Product_Value.equals("Simplified Spaces")) {

			Product_checkboxes.get(3).click();

			product_selected = true;
			selected_product_count = 1;
		}

		if (Selected_Product_Value.equals("Simplified Checkout, Simplified Hire")) {

			Product_checkboxes.get(0).click();
			Product_checkboxes.get(1).click();

			product_selected = true;
			selected_product_count = 2;
		}

		if (Selected_Product_Value.equals("Simplified Checkout, Simplified HR")) {

			Product_checkboxes.get(0).click();
			Product_checkboxes.get(2).click();

			product_selected = true;
			selected_product_count = 2;
		}

		if (Selected_Product_Value.equals("Simplified Checkout, Simplified Spaces")) {

			Product_checkboxes.get(0).click();
			Product_checkboxes.get(3).click();

			product_selected = true;
			selected_product_count = 2;
		}

		if (Selected_Product_Value.equals("Simplified Hire, Simplified HR")) {

			Product_checkboxes.get(1).click();
			Product_checkboxes.get(2).click();

			product_selected = true;
			selected_product_count = 2;
		}

		if (Selected_Product_Value.equals("Simplified Hire, Simplified Spaces")) {

			Product_checkboxes.get(1).click();
			Product_checkboxes.get(3).click();

			product_selected = true;
			selected_product_count = 2;
		}

		if (Selected_Product_Value.equals("Simplified HR, Simplified Spaces")) {

			Product_checkboxes.get(2).click();
			Product_checkboxes.get(3).click();

			product_selected = true;
			selected_product_count = 2;
		}

		if (Selected_Product_Value.equals("Simplified Checkout, Simplified Hire, Simplified HR")) {

			Product_checkboxes.get(0).click();
			Product_checkboxes.get(1).click();
			Product_checkboxes.get(2).click();

			product_selected = true;
			selected_product_count = 3;
		}

		if (Selected_Product_Value.equals("Simplified Checkout, Simplified Hire, Simplified Spaces")) {

			Product_checkboxes.get(0).click();
			Product_checkboxes.get(1).click();
			Product_checkboxes.get(3).click();

			product_selected = true;
			selected_product_count = 3;
		}

		if (Selected_Product_Value.equals("Simplified Checkout, Simplified HR, Simplified Spaces")) {

			Product_checkboxes.get(0).click();
			Product_checkboxes.get(2).click();
			Product_checkboxes.get(3).click();

			product_selected = true;
			selected_product_count = 3;
		}

		if (Selected_Product_Value.equals("Simplified Hire, Simplified HR, Simplified Spaces")) {

			Product_checkboxes.get(1).click();
			Product_checkboxes.get(2).click();
			Product_checkboxes.get(3).click();

			product_selected = true;
			selected_product_count = 3;
		}

		if (Selected_Product_Value.equals("Simplified Checkout, Simplified Hire, Simplified HR, Simplified Spaces")) {

			Product_checkboxes.get(0).click();
			Product_checkboxes.get(1).click();
			Product_checkboxes.get(2).click();
			Product_checkboxes.get(3).click();

			product_selected = true;
			selected_product_count = 4;
		}

		if (product_selected) {

			Report_Listen.log_print_in_report().log(Status.PASS,
					"<b>✅ Actual:</b> Product selection completed successfully. Selected Products = "
							+ Selected_Product_Value + " | Selected Product Count = " + selected_product_count);

			System.out.println("✅ Actual: Product selection completed successfully. Selected Products = "
					+ Selected_Product_Value + " | Selected Product Count = " + selected_product_count);

		} else {

			Report_Listen.log_print_in_report().log(Status.FAIL,
					"<b>❌ Actual:</b> No matching product checkbox condition was found for Selected Product = "
							+ Selected_Product_Value);

			System.out.println("❌ Actual: No matching product checkbox condition was found for Selected Product = "
					+ Selected_Product_Value);

			throw new AssertionError("No matching product checkbox condition was found for Selected Product = "
					+ Selected_Product_Value);
		}

		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>━━━━━━━━━━━━━━ 📝 CONTACT DETAILS AND FIELD VALIDATION ━━━━━━━━━━━━━━</b>");

		System.out.println("━━━━━━━━━━━━━━ 📝 CONTACT DETAILS AND FIELD VALIDATION ━━━━━━━━━━━━━━");

		WebElement First_Name_Field = Input_Fields.get(0);

		WebElement Last_Name_Field = Input_Fields.get(1);

		WebElement Email_Field = Input_Fields.get(2);

		WebElement Company_Name_Field = Input_Fields.get(3);

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Validate that the First Name field rejects numeric characters.");

		System.out.println("Step " + (step - 1) + ": Validate that the First Name field rejects numeric characters.");

		String First_Name_With_Number = First_Name + "2";

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📥 Negative Validation Input:</b> First Name = " + First_Name_With_Number);

		System.out.println("📥 Negative Validation Input: First Name = " + First_Name_With_Number);

		First_Name_Field.sendKeys(First_Name_With_Number);

		List <WebElement> First_Name_Error = p.New_Error_book_demo_form();
        WebElement First_error=First_Name_Error.get(0);
		rp.Scroll_to_element(First_error);

		String First_Name_Error_Text = First_error.getText().trim();

		if (!First_Name_Error_Text.isEmpty()) {

			Report_Listen.log_print_in_report().log(Status.PASS,
					"<b>✅ Actual:</b> First Name validation error was displayed successfully after entering numeric characters. Error Message = "
							+ First_Name_Error_Text);

			System.out.println(
					"✅ Actual: First Name validation error was displayed successfully after entering numeric characters. Error Message = "
							+ First_Name_Error_Text);

		} else {

			Report_Listen.log_print_in_report().log(Status.FAIL,
					"<b>❌ Actual:</b> First Name validation error was not displayed after entering invalid value = "
							+ First_Name_With_Number);

			System.out.println("❌ Actual: First Name validation error was not displayed after entering invalid value = "
					+ First_Name_With_Number);

			throw new AssertionError("First Name validation error was not displayed after entering invalid value = "
					+ First_Name_With_Number);
		}

		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Clear the invalid First Name and enter the valid First Name.");

		System.out.println("Step " + (step - 1) + ": Clear the invalid First Name and enter the valid First Name.");

		rp.Scroll_to_element(First_Name_Field);

		First_Name_Field.clear();

		First_Name_Field.sendKeys(First_Name);

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>✅ Actual:</b> Invalid First Name was cleared and the valid First Name was entered successfully = "
						+ First_Name);

		System.out
				.println("✅ Actual: Invalid First Name was cleared and the valid First Name was entered successfully = "
						+ First_Name);

		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Validate that the Last Name field rejects numeric characters.");

		System.out.println("Step " + (step - 1) + ": Validate that the Last Name field rejects numeric characters.");

		String Last_Name_With_Number = Last_Name + "2";

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📥 Negative Validation Input:</b> Last Name = " + Last_Name_With_Number);

		System.out.println("📥 Negative Validation Input: Last Name = " + Last_Name_With_Number);

		Last_Name_Field.sendKeys(Last_Name_With_Number);

		List <WebElement> Last_Name_Error = p.New_Error_book_demo_form();
        WebElement firsterrror=Last_Name_Error.get(0);
		rp.Scroll_to_element(firsterrror);

		String Last_Name_Error_Text = firsterrror.getText().trim();

		if (!Last_Name_Error_Text.isEmpty()) {

			Report_Listen.log_print_in_report().log(Status.PASS,
					"<b>✅ Actual:</b> Last Name validation error was displayed successfully after entering numeric characters. Error Message = "
							+ Last_Name_Error_Text);

			System.out.println(
					"✅ Actual: Last Name validation error was displayed successfully after entering numeric characters. Error Message = "
							+ Last_Name_Error_Text);

		} else {

			Report_Listen.log_print_in_report().log(Status.FAIL,
					"<b>❌ Actual:</b> Last Name validation error was not displayed after entering invalid value = "
							+ Last_Name_With_Number);

			System.out.println("❌ Actual: Last Name validation error was not displayed after entering invalid value = "
					+ Last_Name_With_Number);

			throw new AssertionError("Last Name validation error was not displayed after entering invalid value = "
					+ Last_Name_With_Number);
		}

		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Clear the invalid Last Name and enter the valid contact details.");

		System.out.println("Step " + (step - 1) + ": Clear the invalid Last Name and enter the valid contact details.");

		rp.Scroll_to_element(Last_Name_Field);

		Last_Name_Field.clear();

		Last_Name_Field.sendKeys(Last_Name);

		Email_Field.sendKeys(Email);

		Company_Name_Field.sendKeys(Company_Name);

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>✅ Actual:</b> Valid contact details were entered successfully. First Name = " + First_Name
						+ " | Last Name = " + Last_Name + " | Email = " + Email + " | Company Name = " + Company_Name);

		System.out.println("✅ Actual: Valid contact details were entered successfully. First Name = " + First_Name
				+ " | Last Name = " + Last_Name + " | Email = " + Email + " | Company Name = " + Company_Name);

		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++)
				+ ":</b> Open the country-code dropdown and select the required country code = " + Country_Code);

		System.out.println("Step " + (step - 1)
				+ ": Open the country-code dropdown and select the required country code = " + Country_Code);

		WebElement country_code_field = p.Country_code_dropdown_field();

		Thread.sleep(800);

		try {

			rp.Scroll_to_element(country_code_field);

			country_code_field.click();

		} catch (Exception e) {

			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>⚠ Retry:</b> Country-code dropdown click failed during the first attempt. Retrying after scrolling.");

			System.out.println(
					"⚠ Retry: Country-code dropdown click failed during the first attempt. Retrying after scrolling.");

			Thread.sleep(800);

			rp.Scroll_to_element(country_code_field);

			country_code_field.click();
		}

		WebElement country_code_Dropdown = p.dropdown_options_list();

		List<WebElement> options = country_code_Dropdown.findElements(By.xpath(".//li"));

		boolean country_code_selected = false;

		for (WebElement option : options) {

			String text = option.getText().trim();

			System.out.println("Country-code option found = " + text);

			if (text.contains(Country_Code)) {

				rp.movetoelement(option);

				option.click();

				country_code_selected = true;

				Report_Listen.log_print_in_report().log(Status.PASS,
						"<b>✅ Actual:</b> Country code selected successfully = " + text);

				System.out.println("✅ Actual: Country code selected successfully = " + text);

				break;
			}
		}

		if (!country_code_selected) {

			Report_Listen.log_print_in_report().log(Status.FAIL,
					"<b>❌ Actual:</b> Required country-code option was not found = " + Country_Code);

			System.out.println("❌ Actual: Required country-code option was not found = " + Country_Code);

			throw new AssertionError("Required country-code option was not found = " + Country_Code);
		}

		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Enter the phone number and message.");

		System.out.println("Step " + (step - 1) + ": Enter the phone number and message.");

		Input_Fields.get(4).sendKeys(Phone_Number);

		Message_Box.sendKeys(Message);

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>✅ Actual:</b> Phone number and message were entered successfully. Phone Number = " + Phone_Number);

		System.out.println(
				"✅ Actual: Phone number and message were entered successfully. Phone Number = " + Phone_Number);

		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 🚀 FORM SUBMISSION ━━━━━━━━━━━━━━</b>");

		System.out.println("━━━━━━━━━━━━━━ 🚀 FORM SUBMISSION ━━━━━━━━━━━━━━");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Submit the Book a Demo form for the first time.");

		System.out.println("Step " + (step - 1) + ": Submit the Book a Demo form for the first time.");

		rp.Scroll_to_element(Submit_Button);

		rp.movetoelement(Submit_Button);

		Submit_Button.click();

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>✅ Actual:</b> Submit button clicked successfully for the first time.");

		System.out.println("✅ Actual: Submit button clicked successfully for the first time.");

		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>━━━━━━━━━━━━━━ 🔐 CAPTCHA HANDLING ━━━━━━━━━━━━━━</b>");

		System.out.println("━━━━━━━━━━━━━━ 🔐 CAPTCHA HANDLING ━━━━━━━━━━━━━━");

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++)
				+ ":</b> Check whether a visible checkbox CAPTCHA appeared after the first submission.");

		System.out.println("Step " + (step - 1)
				+ ": Check whether a visible checkbox CAPTCHA appeared after the first submission.");

		boolean captcha_appeared = false;
		boolean captcha_status = false;
		boolean form_submitted_successfully = false;

		List<WebElement> captcha_frames = sa.captcha_normal_iframe_list();

		if (captcha_frames.size() == 0) {

			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>🟨 Actual:</b> Visible checkbox CAPTCHA iframe was not found. CAPTCHA handling was skipped.");

			System.out
					.println("🟨 Actual: Visible checkbox CAPTCHA iframe was not found. CAPTCHA handling was skipped.");

		} else {

			captcha_appeared = true;

			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>🟨 Actual:</b> Visible checkbox CAPTCHA iframe was found. Iframe Count = "
							+ captcha_frames.size());

			System.out.println(
					"🟨 Actual: Visible checkbox CAPTCHA iframe was found. Iframe Count = " + captcha_frames.size());

			captcha_status = Captcha_Bypass(captcha_frames.get(0));
			Thread.sleep(4800);
		}

		System.out.println();

		if (captcha_appeared && captcha_status) {

			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>Step " + (step++) + ":</b> Submit the Book a Demo form again after CAPTCHA completion.");

			System.out.println("Step " + (step - 1) + ": Submit the Book a Demo form again after CAPTCHA completion.");

			WebElement Refetched_Submit_Button = p.Submit_button();

			rp.Scroll_to_element(Refetched_Submit_Button);

			rp.movetoelement(Refetched_Submit_Button);

			Refetched_Submit_Button.click();

			Report_Listen.log_print_in_report().log(Status.PASS,
					"<b>✅ Actual:</b> Submit button clicked successfully after CAPTCHA completion.");

			System.out.println("✅ Actual: Submit button clicked successfully after CAPTCHA completion.");

		} else if (captcha_appeared && !captcha_status) {

			Report_Listen.log_print_in_report().log(Status.FAIL,
					"<b>❌ Actual:</b> CAPTCHA appeared but was not completed successfully. The second submission was skipped.");

			System.out.println(
					"❌ Actual: CAPTCHA appeared but was not completed successfully. The second submission was skipped.");

		} else {

			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>🟨 Actual:</b> CAPTCHA was absent, so a second submission was not required.");

			System.out.println("🟨 Actual: CAPTCHA was absent, so a second submission was not required.");
		}

		System.out.println();

		Thread.sleep(1000);

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>━━━━━━━━━━━━━━ 📬 SUBMISSION RESULT ━━━━━━━━━━━━━━</b>");

		System.out.println("━━━━━━━━━━━━━━ 📬 SUBMISSION RESULT ━━━━━━━━━━━━━━");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Capture the Book a Demo form submission result.");

		System.out.println("Step " + (step - 1) + ": Capture the Book a Demo form submission result.");

		WebElement below_submit_button = sa.Section_below_submit_button();

		Thread.sleep(800);

		rp.Scroll_to_element(below_submit_button);

		List<WebElement> Success_Message_List = null;

		try {

			Success_Message_List = sa.success_message_list();

			if (Success_Message_List != null && Success_Message_List.size() > 0) {

				WebElement Confirmation_Message = Success_Message_List.get(0);

				rp.Scroll_to_element(Confirmation_Message);

				rp.movetoelement(Confirmation_Message);

				String Confirmation_Text = Confirmation_Message.getText().trim();

				Report_Listen.log_print_in_report().log(Status.PASS,
						"<b>✅ Actual:</b> Book a Demo form submitted successfully. Success Message = "
								+ Confirmation_Text);

				System.out.println(
						"✅ Actual: Book a Demo form submitted successfully. Success Message = " + Confirmation_Text);

				form_submitted_successfully = true;
			}

		} catch (Exception e) {

			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>🟨 Actual:</b> Success message was not found. The error-message section will now be checked.");

			System.out.println(
					"🟨 Actual: Success message was not found. The error-message section will now be checked.");
		}

		if (!form_submitted_successfully) {

			List<WebElement> Error_Message_List = null;

			try {

				Error_Message_List = sa.error_message_list();

			} catch (Exception e) {

				Report_Listen.log_print_in_report().log(Status.INFO,
						"<b>🟨 Actual:</b> Error-message elements were not available after submission.");

				System.out.println("🟨 Actual: Error-message elements were not available after submission.");
			}

			if (Error_Message_List != null && Error_Message_List.size() > 0) {

				WebElement Error_Message = Error_Message_List.get(0);

				rp.Scroll_to_element(Error_Message);

				rp.movetoelement(Error_Message);

				String Error_Text = Error_Message.getText().trim();

				if (Error_Text.toLowerCase().contains("already")) {

					Report_Listen.log_print_in_report().log(Status.FAIL,
							"<b>❌ Actual:</b> Book a Demo form was not submitted because duplicate data already exists. Error Message = "
									+ Error_Text);

					System.out.println(
							"❌ Actual: Book a Demo form was not submitted because duplicate data already exists. Error Message = "
									+ Error_Text);

				} else if (Error_Text.toLowerCase().contains("something went wrong")) {

					Report_Listen.log_print_in_report().log(Status.FAIL,
							"<b>❌ Actual:</b> Book a Demo form submission failed due to an application or server error. Error Message = "
									+ Error_Text);

					System.out.println(
							"❌ Actual: Book a Demo form submission failed due to an application or server error. Error Message = "
									+ Error_Text);

				} else {

					Report_Listen.log_print_in_report().log(Status.FAIL,
							"<b>❌ Actual:</b> Book a Demo form returned an error message = " + Error_Text);

					System.out.println("❌ Actual: Book a Demo form returned an error message = " + Error_Text);
				}

			} else {

				String msg;

				if (captcha_appeared && !captcha_status) {

					msg = "CAPTCHA appeared but was not completed successfully, and no success or error message was displayed.";

				} else {

					msg = "No success or error message was displayed after the Book a Demo form submission.";
				}

				Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> " + msg);

				System.out.println("❌ Actual: " + msg);
			}
		}

		System.out.println();

		if (!form_submitted_successfully) {

			Report_Listen.log_print_in_report().log(Status.FAIL,
					"<b>❌ Final Status:</b> Book a Demo form submission failed. Lead verification and all dependent workflows were stopped.");

			System.out.println(
					"❌ Final Status: Book a Demo form submission failed. Lead verification and all dependent workflows were stopped.");

			throw new AssertionError("Book a Demo form was not submitted successfully for Email = " + Email);
		}

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>✅ Final Status:</b> Book a Demo form submission completed successfully. Proceeding to SaaS Admin lead verification.");

		System.out.println(
				"✅ Final Status: Book a Demo form submission completed successfully. Proceeding to SaaS Admin lead verification.");

		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>━━━━━━━━━━━━━━ 🔎 LEAD VERIFICATION ━━━━━━━━━━━━━━</b>");

		System.out.println("━━━━━━━━━━━━━━ 🔎 LEAD VERIFICATION ━━━━━━━━━━━━━━");

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++)
				+ ":</b> Navigate to the SaaS Admin Lead module and search for the submitted lead.");

		System.out.println(
				"Step " + (step - 1) + ": Navigate to the SaaS Admin Lead module and search for the submitted lead.");

		Lead_Module_Accessor();

		sa.search_field().sendKeys(First_Name);

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Lead search keyword entered successfully = " + First_Name);

		System.out.println("🟨 Actual: Lead search keyword entered successfully = " + First_Name);

		System.out.println();

		Thread.sleep(1000);

		try {

			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>Step " + (step++) + ":</b> Wait for the lead-list loader to disappear after the search.");

			System.out.println("Step " + (step - 1) + ": Wait for the lead-list loader to disappear after the search.");

			WebElement Loader = sa.Loader_element();

			rp.wait_for_invisibilty_of_theElement(Loader);

			Report_Listen.log_print_in_report().log(Status.PASS,
					"<b>✅ Actual:</b> Lead-list loader disappeared successfully.");

			System.out.println("✅ Actual: Lead-list loader disappeared successfully.");

		} catch (Exception e) {

			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>⚠ Actual:</b> Lead-list loader was not displayed, so the loader wait was skipped.");

			System.out.println("⚠ Actual: Lead-list loader was not displayed, so the loader wait was skipped.");
		}

		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Open the lead action menu and view the submitted lead details.");

		System.out.println("Step " + (step - 1) + ": Open the lead action menu and view the submitted lead details.");

		list_threedot_dropdown_option_selector("View Lead");

		sa.Leads_Approve_button();

		TreeMap<String, String> Leads_Label_values = Leads_Details_fetcher();

		boolean lead_data_matched = true;

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++)
				+ ":</b> Compare submitted Book a Demo data with the fetched SaaS Admin lead details.");

		System.out.println("Step " + (step - 1)
				+ ": Compare submitted Book a Demo data with the fetched SaaS Admin lead details.");

		for (Map.Entry<String, String> pair : Leads_Label_values.entrySet()) {

			String Admin_Label = pair.getKey().trim();

			String Admin_Value = pair.getValue().trim();

			String Admin_Label_Lower = Admin_Label.toLowerCase();

			String Expected_Value = null;

			if (Admin_Label_Lower.contains("first") && Admin_Label_Lower.contains("name")) {

				Expected_Value = First_Name;

			} else if (Admin_Label_Lower.contains("last") && Admin_Label_Lower.contains("name")) {

				Expected_Value = Last_Name;

			} else if (Admin_Label_Lower.contains("email")) {

				Expected_Value = Email;

			} else if (Admin_Label_Lower.contains("company")) {

				Expected_Value = Company_Name;

			} else if (Admin_Label_Lower.contains("country") && Admin_Label_Lower.contains("code")) {

				Expected_Value = Country_Code;

			} else if (Admin_Label_Lower.contains("phone") || Admin_Label_Lower.contains("mobile")
					|| Admin_Label_Lower.contains("contact")) {

				Expected_Value = Phone_Number;

			} else if (Admin_Label_Lower.contains("message") || Admin_Label_Lower.contains("requirement")
					|| Admin_Label_Lower.contains("description")) {

				Expected_Value = Message;

			} else if (Admin_Label_Lower.contains("product") || Admin_Label_Lower.contains("app")
					|| Admin_Label_Lower.contains("service")) {

				Expected_Value = Selected_Product;
			}

			if (Expected_Value != null) {

				String Expected_Value_Normalized = Expected_Value.replaceAll("\\s+", " ").trim();

				String Admin_Value_Normalized = Admin_Value.replaceAll("\\s+", " ").trim();

				System.out.println("🟨 Debug: Comparing Lead Field" + " | Label = " + Admin_Label + " | Expected = "
						+ Expected_Value_Normalized + " | Actual = " + Admin_Value_Normalized);

				if (Admin_Value_Normalized.contains(Expected_Value_Normalized)
						|| Expected_Value_Normalized.contains(Admin_Value_Normalized)) {

					Report_Listen.log_print_in_report().log(Status.PASS,
							"<b>✅ Match:</b> Lead field matched successfully. Label = " + Admin_Label + " | Expected = "
									+ Expected_Value_Normalized + " | Actual = " + Admin_Value_Normalized);

					System.out.println("✅ Match: Lead field matched successfully. Label = " + Admin_Label
							+ " | Expected = " + Expected_Value_Normalized + " | Actual = " + Admin_Value_Normalized);

				} else {

					lead_data_matched = false;

					Report_Listen.log_print_in_report().log(Status.FAIL,
							"<b>❌ Mismatch:</b> Lead field value mismatch. Label = " + Admin_Label + " | Expected = "
									+ Expected_Value_Normalized + " | Actual = " + Admin_Value_Normalized);

					System.out.println("❌ Mismatch: Lead field value mismatch. Label = " + Admin_Label
							+ " | Expected = " + Expected_Value_Normalized + " | Actual = " + Admin_Value_Normalized);
				}

			} else {

				Report_Listen.log_print_in_report().log(Status.INFO,
						"<b>🟨 Skipped:</b> No matching frontend input key was mapped for Admin Label = " + Admin_Label
								+ " | Admin Value = " + Admin_Value);

				System.out.println("🟨 Skipped: No matching frontend input key was mapped for Admin Label = "
						+ Admin_Label + " | Admin Value = " + Admin_Value);
			}

			System.out.println();
		}

		if (lead_data_matched) {

			Report_Listen.log_print_in_report().log(Status.PASS,
					"<b>✅ Actual:</b> All available mapped Book a Demo lead details matched successfully with the SaaS Admin data.");

			System.out.println(
					"✅ Actual: All available mapped Book a Demo lead details matched successfully with the SaaS Admin data.");

		} else {

			Report_Listen.log_print_in_report().log(Status.FAIL,
					"<b>❌ Actual:</b> One or more Book a Demo lead details did not match the SaaS Admin data.");

			System.out.println("❌ Actual: One or more Book a Demo lead details did not match the SaaS Admin data.");

			throw new AssertionError("One or more Book a Demo lead details did not match the SaaS Admin data.");
		}

		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ ✅ LEAD APPROVAL ━━━━━━━━━━━━━━</b>");

		System.out.println("━━━━━━━━━━━━━━ ✅ LEAD APPROVAL ━━━━━━━━━━━━━━");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Start the SaaS Admin lead approval and plan assignment flow.");

		System.out.println("Step " + (step - 1) + ": Start the SaaS Admin lead approval and plan assignment flow.");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📌 Approval Context:</b> The verified Book a Demo lead will be approved and assigned the enabled application plans.");

		System.out.println(
				"📌 Approval Context: The verified Book a Demo lead will be approved and assigned the enabled application plans.");

		System.out.println();

		Leads_Approve(Plan_data);

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>✅ Actual:</b> SaaS Admin lead approval and application plan assignment completed successfully.");

		System.out
				.println("✅ Actual: SaaS Admin lead approval and application plan assignment completed successfully.");

		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 🔄 PLAN UPGRADE ━━━━━━━━━━━━━━</b>");

		System.out.println("━━━━━━━━━━━━━━ 🔄 PLAN UPGRADE ━━━━━━━━━━━━━━");

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++)
				+ ":</b> Upgrade the created account plan using the target plan and billing data.");

		System.out.println(
				"Step " + (step - 1) + ": Upgrade the created account plan using the target plan and billing data.");

		Target_Upgrade_Plan_Name = Quick_Plan_Upgrade_Several_times(form_data, account_create_data, upgrade_plan_datas,Target_Upgrade_Plan_Name);

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>✅ Actual:</b> Account plan upgrade flow completed successfully. Final Plan Name = "
						+ Target_Upgrade_Plan_Name);

		System.out.println("✅ Actual: Account plan upgrade flow completed successfully. Final Plan Name = "
				+ Target_Upgrade_Plan_Name);

		System.out.println();

		TreeMap<String, String> activation_data = new TreeMap<String, String>();

		activation_data.putAll(form_data);

		activation_data.put("Plan Name", Target_Upgrade_Plan_Name);

		activation_data.put("Users", Upgrade_Users);

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>━━━━━━━━━━━━━━ 🔑 ACCOUNT ACTIVATION ━━━━━━━━━━━━━━</b>");

		System.out.println("━━━━━━━━━━━━━━ 🔑 ACCOUNT ACTIVATION ━━━━━━━━━━━━━━");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Activate the created account using the upgraded plan and users value.");

		System.out.println(
				"Step " + (step - 1) + ": Activate the created account using the upgraded plan and users value.");

		Account_Activator(activation_data, step);

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>✅ Final Status:</b> Book a Demo field validation, form submission, SaaS Admin lead verification, lead approval, plan upgrade, and account activation completed successfully.");

		System.out.println(
				"✅ Final Status: Book a Demo field validation, form submission, SaaS Admin lead verification, lead approval, plan upgrade, and account activation completed successfully.");

		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");

		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}

	public boolean Captcha_Bypass(WebElement captcha_frame) throws InterruptedException {

		Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
		Repeat rp = new Repeat(d);
		boolean iframe_switched = false;
		String captcha_stage = "CAPTCHA handling started";

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🔹 Scenario Section:</b> CAPTCHA Validation");
		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📘 Description:</b> Switch into the visible CAPTCHA iframe, identify the checkbox control, complete the CAPTCHA interaction, verify the checked state, and return to the main page.");
		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>✅ Expected:</b> CAPTCHA checkbox should be completed successfully and control should return to the default page content.");
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");

		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("🔹 Scenario Section: CAPTCHA Validation");
		System.out.println(
				"📘 Description: Switch into the visible CAPTCHA iframe, identify the checkbox control, complete the CAPTCHA interaction, verify the checked state, and return to the main page.");
		System.out.println(
				"✅ Expected: CAPTCHA checkbox should be completed successfully and control should return to the default page content.");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println();

		try {
			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>━━━━━━━━━━━━━━ 🔐 CAPTCHA CHECKBOX ━━━━━━━━━━━━━━</b>");
			System.out.println("━━━━━━━━━━━━━━ 🔐 CAPTCHA CHECKBOX ━━━━━━━━━━━━━━");

			Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step:</b> Handle visible checkbox CAPTCHA.");
			System.out.println("Step: Handle visible checkbox CAPTCHA.");

			captcha_stage = "Switch into size=normal CAPTCHA iframe";
			System.out.println("🟨 Debug: CAPTCHA iframe src = " + captcha_frame.getAttribute("src"));

			rp.Scroll_to_element(captcha_frame);
			d.switchTo().frame(captcha_frame);
			iframe_switched = true;

			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>🟨 Actual:</b> Switched into visible checkbox CAPTCHA iframe successfully.");
			System.out.println("🟨 Actual: Switched into visible checkbox CAPTCHA iframe successfully.");

			captcha_stage = "Find CAPTCHA checkbox inside size=normal iframe";
			List<WebElement> checkbox_list = p.Captcha_checkbox_list();
			List<WebElement> border_list = p.Captcha_checkbox_border_list();

			System.out.println(
					"🟨 Debug: Checkbox count = " + checkbox_list.size() + " | Border count = " + border_list.size());

			if (checkbox_list.size() == 0 && border_list.size() == 0) {
				Report_Listen.log_print_in_report().log(Status.FAIL,
						"<b>❌ CAPTCHA Failure Point:</b> size=normal iframe found, but checkbox/border element not found inside iframe.");
				System.out.println(
						"❌ CAPTCHA Failure Point: size=normal iframe found, but checkbox/border element not found inside iframe.");
				return false;
			}

			WebElement captcha_target = checkbox_list.size() > 0 ? checkbox_list.get(0) : border_list.get(0);

			System.out.println("🟨 Debug: CAPTCHA target | tag = " + captcha_target.getTagName() + " | id = "
					+ captcha_target.getAttribute("id") + " | class = " + captcha_target.getAttribute("class")
					+ " | role = " + captcha_target.getAttribute("role") + " | aria-checked = "
					+ captcha_target.getAttribute("aria-checked"));

			captcha_stage = "Click CAPTCHA checkbox";
			try {
				captcha_target.click();
				Report_Listen.log_print_in_report().log(Status.INFO,
						"<b>🟨 Actual:</b> CAPTCHA target clicked successfully.");
				System.out.println("🟨 Actual: CAPTCHA target clicked successfully.");
			} catch (Exception click_exception) {
				Report_Listen.log_print_in_report().log(Status.WARNING,
						"<b>⚠ Retry:</b> Normal CAPTCHA click failed. Retrying with JavaScript click. Reason = "
								+ click_exception.getMessage());
				System.out.println("⚠ Retry: Normal CAPTCHA click failed. Retrying with JavaScript click. Reason = "
						+ click_exception.getMessage());
				rp.Java_script_executor_CLICK(captcha_target);
			}

			Thread.sleep(1200);

			captcha_stage = "Verify CAPTCHA checked state";
			List<WebElement> anchor_list = d.findElements(By.xpath("//*[@id='recaptcha-anchor']"));
			String captcha_status = anchor_list.size() > 0 ? anchor_list.get(0).getAttribute("aria-checked")
					: "not-found";

			System.out.println("🟨 Debug: CAPTCHA verification | anchor count = " + anchor_list.size()
					+ " | aria-checked = " + captcha_status);

			if (captcha_status.equals("true")) {
				Report_Listen.log_print_in_report().log(Status.PASS,
						"<b>✅ Actual:</b> CAPTCHA checkbox clicked and verified successfully.");
				System.out.println("✅ Actual: CAPTCHA checkbox clicked and verified successfully.");
				return true;
			}

			Report_Listen.log_print_in_report().log(Status.FAIL,
					"<b>❌ CAPTCHA Failure Point:</b> CAPTCHA clicked but aria-checked was not true. Actual = "
							+ captcha_status);
			System.out.println("❌ CAPTCHA Failure Point: CAPTCHA clicked but aria-checked was not true. Actual = "
					+ captcha_status);
			return false;

		} catch (Exception e) {
			Report_Listen.log_print_in_report().log(Status.FAIL,
					"<b>❌ CAPTCHA Failure Point:</b> CAPTCHA handling failed. Failed Stage = " + captcha_stage
							+ " | Reason = " + e.getMessage());
			System.out.println("❌ CAPTCHA Failure Point: CAPTCHA handling failed. Failed Stage = " + captcha_stage
					+ " | Reason = " + e.getMessage());
			return false;
		} finally {
			if (iframe_switched) {
				d.switchTo().defaultContent();
				Report_Listen.log_print_in_report().log(Status.INFO,
						"<b>🟨 Actual:</b> Switched back to default content after CAPTCHA handling.");
				System.out.println("🟨 Actual: Switched back to default content after CAPTCHA handling.");
			}
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		}
		
		
	}

	

}