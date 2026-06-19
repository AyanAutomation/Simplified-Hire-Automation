package Product_Codeclouds.Project.Simplified;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

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
public class Book_A_Demo_form_fillup extends Saas_Admin_Module{
	
	
	
	

@Test(dataProvider = "Contact_Form_Data")
public void book_a_demo_form_fillup(TreeMap<String, String> form_data) throws IOException, InterruptedException {
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

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🔹 Scenario Title:</b> Validate Book a Demo form submission from frontend");
	System.out.println();
	System.out.println("🔹 Scenario Title: Validate Book a Demo form submission from frontend");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📘 Description:</b> Open frontend URL, navigate to Book a Demo page, select product checkbox/options as per test data, fill required contact form details, select country code, submit the form, handle CAPTCHA if it appears, capture success/error message, and verify lead details in SaaS Admin.");
	System.out.println("📘 Description: Open frontend URL, navigate to Book a Demo page, select product checkbox/options as per test data, fill required contact form details, select country code, submit the form, handle CAPTCHA if it appears, capture success/error message, and verify lead details in SaaS Admin.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📥 Input:</b> Selected Product = " + Selected_Product + " | Name = " + First_Name + " " + Last_Name + " | Email = " + Email + " | Company = " + Company_Name + " | Country Code = " + Country_Code + " | Phone Number = " + Phone_Number + " | Message = " + Message);
	System.out.println("📥 Input: Selected Product = " + Selected_Product + " | Name = " + First_Name + " " + Last_Name + " | Email = " + Email + " | Company = " + Company_Name + " | Country Code = " + Country_Code + " | Phone Number = " + Phone_Number + " | Message = " + Message);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>✅ Expected:</b> User should be able to fill and submit the Book a Demo form. If CAPTCHA appears, it should be completed and the form should be submitted again. If CAPTCHA is absent, success or duplicate/error message should be captured directly.");
	System.out.println("✅ Expected: User should be able to fill and submit the Book a Demo form. If CAPTCHA appears, it should be completed and the form should be submitted again. If CAPTCHA is absent, success or duplicate/error message should be captured directly.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Open frontend URL.");
	System.out.println("Step " + (step - 1) + ": Open frontend URL.");
	d.get(URL);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Frontend URL opened successfully = " + URL);
	System.out.println("🟨 Actual: Frontend URL opened successfully = " + URL);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Click Book a Demo button from banner.");
	System.out.println("Step " + (step - 1) + ": Click Book a Demo button from banner.");
	WebElement Book_Button = p.Book_a_demo_button_Banner();
	Book_Button.click();
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Book a Demo button clicked successfully.");
	System.out.println("🟨 Actual: Book a Demo button clicked successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Validate landing on Book a Demo form page.");
	System.out.println("Step " + (step - 1) + ": Validate landing on Book a Demo form page.");
	p.Landed_in_Booking_form_page_confirmation();
	Report_Listen.log_print_in_report().log(Status.PASS, "<b>🟨 Actual:</b> User landed successfully on Book a Demo form page.");
	System.out.println("🟨 Actual: User landed successfully on Book a Demo form page.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Accept cookies if cookie banner is displayed.");
	System.out.println("Step " + (step - 1) + ": Accept cookies if cookie banner is displayed.");
	try {
		p.Accept_cookies_button().click();
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Cookies accepted successfully.");
		System.out.println("🟨 Actual: Cookies accepted successfully.");
	} catch (Exception e) {
		Report_Listen.log_print_in_report().log(Status.WARNING, "<b>⚠ Actual:</b> Cookie banner was not displayed, so cookie accept step was skipped.");
		System.out.println("⚠ Actual: Cookie banner was not displayed, so cookie accept step was skipped.");
	}
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Fetch form input fields, message box, submit button, and product cards.");
	System.out.println("Step " + (step - 1) + ": Fetch form input fields, message box, submit button, and product cards.");
	List<WebElement> Input_Fields = p.inputs();
	WebElement Message_Box = p.Textarea();
	WebElement Submit_Button = p.Submit_button();
	List<WebElement> Cards = p.Product_cards();
	List<WebElement> Product_checkboxes = p.Product_check_boxes();
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Input fields fetched = " + Input_Fields.size() + " | Product cards fetched = " + Cards.size() + " | Product checkboxes fetched = " + Product_checkboxes.size());
	System.out.println("🟨 Actual: Input fields fetched = " + Input_Fields.size() + " | Product cards fetched = " + Cards.size() + " | Product checkboxes fetched = " + Product_checkboxes.size());
	System.out.println();

	boolean product_selected = false;
	int selected_product_count = 0;
	String Selected_Product_Value = Selected_Product.trim();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Select product checkbox/options as per test data = " + Selected_Product_Value);
	System.out.println("Step " + (step - 1) + ": Select product checkbox/options as per test data = " + Selected_Product_Value);

	if (Selected_Product_Value.equals("Simplified Checkout")) {
		Product_checkboxes.get(0).click(); product_selected = true; selected_product_count = 1;
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Product selected successfully = Simplified Checkout");
		System.out.println("🟨 Actual: Product selected successfully = Simplified Checkout");
	}
	if (Selected_Product_Value.equals("Simplified Hire")) {
		Product_checkboxes.get(1).click(); product_selected = true; selected_product_count = 1;
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Product selected successfully = Simplified Hire");
		System.out.println("🟨 Actual: Product selected successfully = Simplified Hire");
	}
	if (Selected_Product_Value.equals("Simplified HR")) {
		Product_checkboxes.get(2).click(); product_selected = true; selected_product_count = 1;
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Product selected successfully = Simplified HR");
		System.out.println("🟨 Actual: Product selected successfully = Simplified HR");
	}
	if (Selected_Product_Value.equals("Simplified Spaces")) {
		Product_checkboxes.get(3).click(); product_selected = true; selected_product_count = 1;
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Product selected successfully = Simplified Spaces");
		System.out.println("🟨 Actual: Product selected successfully = Simplified Spaces");
	}
	if (Selected_Product_Value.equals("Simplified Checkout, Simplified Hire")) {
		Product_checkboxes.get(0).click(); Product_checkboxes.get(1).click(); product_selected = true; selected_product_count = 2;
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Products selected successfully = Simplified Checkout, Simplified Hire");
		System.out.println("🟨 Actual: Products selected successfully = Simplified Checkout, Simplified Hire");
	}
	if (Selected_Product_Value.equals("Simplified Checkout, Simplified HR")) {
		Product_checkboxes.get(0).click(); Product_checkboxes.get(2).click(); product_selected = true; selected_product_count = 2;
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Products selected successfully = Simplified Checkout, Simplified HR");
		System.out.println("🟨 Actual: Products selected successfully = Simplified Checkout, Simplified HR");
	}
	if (Selected_Product_Value.equals("Simplified Checkout, Simplified Spaces")) {
		Product_checkboxes.get(0).click(); Product_checkboxes.get(3).click(); product_selected = true; selected_product_count = 2;
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Products selected successfully = Simplified Checkout, Simplified Spaces");
		System.out.println("🟨 Actual: Products selected successfully = Simplified Checkout, Simplified Spaces");
	}
	if (Selected_Product_Value.equals("Simplified Hire, Simplified HR")) {
		Product_checkboxes.get(1).click(); Product_checkboxes.get(2).click(); product_selected = true; selected_product_count = 2;
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Products selected successfully = Simplified Hire, Simplified HR");
		System.out.println("🟨 Actual: Products selected successfully = Simplified Hire, Simplified HR");
	}
	if (Selected_Product_Value.equals("Simplified Hire, Simplified Spaces")) {
		Product_checkboxes.get(1).click(); Product_checkboxes.get(3).click(); product_selected = true; selected_product_count = 2;
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Products selected successfully = Simplified Hire, Simplified Spaces");
		System.out.println("🟨 Actual: Products selected successfully = Simplified Hire, Simplified Spaces");
	}
	if (Selected_Product_Value.equals("Simplified HR, Simplified Spaces")) {
		Product_checkboxes.get(2).click(); Product_checkboxes.get(3).click(); product_selected = true; selected_product_count = 2;
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Products selected successfully = Simplified HR, Simplified Spaces");
		System.out.println("🟨 Actual: Products selected successfully = Simplified HR, Simplified Spaces");
	}
	if (Selected_Product_Value.equals("Simplified Checkout, Simplified Hire, Simplified HR")) {
		Product_checkboxes.get(0).click(); Product_checkboxes.get(1).click(); Product_checkboxes.get(2).click(); product_selected = true; selected_product_count = 3;
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Products selected successfully = Simplified Checkout, Simplified Hire, Simplified HR");
		System.out.println("🟨 Actual: Products selected successfully = Simplified Checkout, Simplified Hire, Simplified HR");
	}
	if (Selected_Product_Value.equals("Simplified Checkout, Simplified Hire, Simplified Spaces")) {
		Product_checkboxes.get(0).click(); Product_checkboxes.get(1).click(); Product_checkboxes.get(3).click(); product_selected = true; selected_product_count = 3;
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Products selected successfully = Simplified Checkout, Simplified Hire, Simplified Spaces");
		System.out.println("🟨 Actual: Products selected successfully = Simplified Checkout, Simplified Hire, Simplified Spaces");
	}
	if (Selected_Product_Value.equals("Simplified Checkout, Simplified HR, Simplified Spaces")) {
		Product_checkboxes.get(0).click(); Product_checkboxes.get(2).click(); Product_checkboxes.get(3).click(); product_selected = true; selected_product_count = 3;
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Products selected successfully = Simplified Checkout, Simplified HR, Simplified Spaces");
		System.out.println("🟨 Actual: Products selected successfully = Simplified Checkout, Simplified HR, Simplified Spaces");
	}
	if (Selected_Product_Value.equals("Simplified Hire, Simplified HR, Simplified Spaces")) {
		Product_checkboxes.get(1).click(); Product_checkboxes.get(2).click(); Product_checkboxes.get(3).click(); product_selected = true; selected_product_count = 3;
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Products selected successfully = Simplified Hire, Simplified HR, Simplified Spaces");
		System.out.println("🟨 Actual: Products selected successfully = Simplified Hire, Simplified HR, Simplified Spaces");
	}
	if (Selected_Product_Value.equals("Simplified Checkout, Simplified Hire, Simplified HR, Simplified Spaces")) {
		Product_checkboxes.get(0).click(); Product_checkboxes.get(1).click(); Product_checkboxes.get(2).click(); Product_checkboxes.get(3).click(); product_selected = true; selected_product_count = 4;
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Products selected successfully = Simplified Checkout, Simplified Hire, Simplified HR, Simplified Spaces");
		System.out.println("🟨 Actual: Products selected successfully = Simplified Checkout, Simplified Hire, Simplified HR, Simplified Spaces");
	}
	System.out.println();

	if (product_selected) {
		Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Product selection completed successfully. Selected Product Data = " + Selected_Product_Value + " | Selected Product Count = " + selected_product_count);
		System.out.println("✅ Actual: Product selection completed successfully. Selected Product Data = " + Selected_Product_Value + " | Selected Product Count = " + selected_product_count);
	} else {
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> No matching product checkbox condition found for Selected Product = " + Selected_Product_Value);
		System.out.println("❌ Actual: No matching product checkbox condition found for Selected Product = " + Selected_Product_Value);
		return;
	}
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Fill first name, last name, email, and company details.");
	System.out.println("Step " + (step - 1) + ": Fill first name, last name, email, and company details.");
	Input_Fields.get(0).sendKeys(First_Name);
	Input_Fields.get(1).sendKeys(Last_Name);
	Input_Fields.get(2).sendKeys(Email);
	Input_Fields.get(3).sendKeys(Company_Name);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Basic form details entered successfully.");
	System.out.println("🟨 Actual: Basic form details entered successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Open country code dropdown and select required country code = " + Country_Code);
	System.out.println("Step " + (step - 1) + ": Open country code dropdown and select required country code = " + Country_Code);
	WebElement country_code_field = p.Country_code_dropdown_field();
	Thread.sleep(800);
	try {
		rp.Scroll_to_element(country_code_field);
		country_code_field.click();
	} catch (Exception e) {
		Report_Listen.log_print_in_report().log(Status.WARNING, "<b>⚠ Retry:</b> Country code dropdown click failed in first attempt. Retrying after scroll.");
		System.out.println("⚠ Retry: Country code dropdown click failed in first attempt. Retrying after scroll.");
		Thread.sleep(800);
		rp.Scroll_to_element(country_code_field);
		country_code_field.click();
	}
	WebElement country_code_Dropdown = p.dropdown_options_list();
	List<WebElement> options = country_code_Dropdown.findElements(By.xpath(".//li"));
	boolean country_code_selected = false;
	for (WebElement option : options) {
		String text = option.getText().trim();
		System.out.println("Country code option found = " + text);
		if (text.contains(Country_Code)) {
			rp.movetoelement(option);
			option.click();
			country_code_selected = true;
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Country code selected successfully = " + text);
			System.out.println("🟨 Actual: Country code selected successfully = " + text);
			break;
		}
	}
	if (!country_code_selected) {
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> Required country code option was not found = " + Country_Code);
		System.out.println("❌ Actual: Required country code option was not found = " + Country_Code);
		return;
	}
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Fill phone number and message.");
	System.out.println("Step " + (step - 1) + ": Fill phone number and message.");
	Input_Fields.get(4).sendKeys(Phone_Number);
	Message_Box.sendKeys(Message);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Phone number and message entered successfully.");
	System.out.println("🟨 Actual: Phone number and message entered successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Submit Book a Demo form first time.");
	System.out.println("Step " + (step - 1) + ": Submit Book a Demo form first time.");
	rp.Scroll_to_element(Submit_Button);
	rp.movetoelement(Submit_Button);
	Submit_Button.click();
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Submit button clicked successfully for the first time.");
	System.out.println("🟨 Actual: Submit button clicked successfully for the first time.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Check whether visible checkbox CAPTCHA appeared after first submit.");
	System.out.println("Step " + (step - 1) + ": Check whether visible checkbox CAPTCHA appeared after first submit.");

	boolean captcha_appeared = false;
	boolean captcha_status = false;
	boolean form_submitted_successfully = false;

	List<WebElement> captcha_frames = sa.captcha_normal_iframe_list();

	if (captcha_frames.size() == 0) {
		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Visible checkbox CAPTCHA iframe not found after waiting. CAPTCHA handling skipped.");
		System.out.println("🟨 Actual: Visible checkbox CAPTCHA iframe not found after waiting. CAPTCHA handling skipped.");
	} else {
		captcha_appeared = true;
		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Visible checkbox CAPTCHA iframe found. Count = " + captcha_frames.size());
		System.out.println("🟨 Actual: Visible checkbox CAPTCHA iframe found. Count = " + captcha_frames.size());
		captcha_status = Captcha_Bypass(captcha_frames.get(0));
	}
	System.out.println();

	if (captcha_appeared && captcha_status) {
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Click Submit button again after CAPTCHA completion.");
		System.out.println("Step " + (step - 1) + ": Click Submit button again after CAPTCHA completion.");
		WebElement Refetched_Submit_Button = p.Submit_button();
		rp.Scroll_to_element(Refetched_Submit_Button);
		rp.movetoelement(Refetched_Submit_Button);
		Refetched_Submit_Button.click();
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Submit button clicked successfully after CAPTCHA completion.");
		System.out.println("🟨 Actual: Submit button clicked successfully after CAPTCHA completion.");
	} else if (captcha_appeared && !captcha_status) {
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> CAPTCHA appeared but was not completed successfully. Second submit skipped. Checking success/error message now.");
		System.out.println("❌ Actual: CAPTCHA appeared but was not completed successfully. Second submit skipped. Checking success/error message now.");
	} else {
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> CAPTCHA was absent, so second submit was not required.");
		System.out.println("🟨 Actual: CAPTCHA was absent, so second submit was not required.");
	}
	System.out.println();

	Thread.sleep(1000);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Capture Book a Demo form submission result message.");
	System.out.println("Step " + (step - 1) + ": Capture Book a Demo form submission result message.");
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

			Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Book a Demo form submitted successfully. Success message = " + Confirmation_Text);
			System.out.println("✅ Actual: Book a Demo form submitted successfully. Success message = " + Confirmation_Text);

			form_submitted_successfully = true;

		}}
	catch (Exception e) {

	 if(Success_Message_List==null) {
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Success message was not found. Checking error message now.");
		System.out.println("🟨 Actual: Success message was not found. Checking error message now.");

		List<WebElement> Error_Message_List = sa.error_message_list();

		if (Error_Message_List != null && Error_Message_List.size() > 0) {
			WebElement Error_Message = Error_Message_List.get(0);
			rp.Scroll_to_element(Error_Message);
			rp.movetoelement(Error_Message);

			String Error_Text = Error_Message.getText().trim();

			if (Error_Text.toLowerCase().contains("already")) {
				Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> Book a Demo form was not submitted because duplicate data already exists. Error message = " + Error_Text);
				System.out.println("❌ Actual: Book a Demo form was not submitted because duplicate data already exists. Error message = " + Error_Text);
			} else if (Error_Text.toLowerCase().contains("something went wrong")) {
				Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> Book a Demo form submission failed due to unexpected application/server error. Error message = " + Error_Text);
				System.out.println("❌ Actual: Book a Demo form submission failed due to unexpected application/server error. Error message = " + Error_Text);
			} else {
				Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> Book a Demo form submission returned error message = " + Error_Text);
				System.out.println("❌ Actual: Book a Demo form submission returned error message = " + Error_Text);
			}

		} else {
			String msg = captcha_appeared && !captcha_status ? "CAPTCHA appeared but was not completed successfully, and no success/error message was displayed." : "No success or error message was displayed after Book a Demo form submission.";
			Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> " + msg);
			System.out.println("❌ Actual: " + msg);
		}
	}}

	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📌 Final Status:</b> Book a Demo form submission flow completed and result logged in ExtentReport.");
	System.out.println("📌 Final Status: Book a Demo form submission flow completed and result logged in ExtentReport.");
	System.out.println();

	if (!form_submitted_successfully) {
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> Lead verification skipped because Book a Demo form was not submitted successfully.");
		System.out.println("❌ Actual: Lead verification skipped because Book a Demo form was not submitted successfully.");
		System.out.println();
		return;
	}

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Navigate to SaaS Admin Lead module and search submitted lead.");
	System.out.println("Step " + (step - 1) + ": Navigate to SaaS Admin Lead module and search submitted lead.");
	Lead_Module_Accessor();
	sa.search_field().sendKeys(First_Name);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Search keyword entered successfully = " + First_Name);
	System.out.println("🟨 Actual: Search keyword entered successfully = " + First_Name);
	System.out.println();

	try {
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step:</b> Wait for list loader to disappear after search.");
		System.out.println("Step: Wait for list loader to disappear after search.");
		WebElement Loader = sa.Loader_element();
		rp.wait_for_invisibilty_of_theElement(Loader);
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Loader disappeared successfully after search.");
		System.out.println("🟨 Actual: Loader disappeared successfully after search.");
	} catch (Exception e) {
		Report_Listen.log_print_in_report().log(Status.WARNING, "<b>⚠ Actual:</b> Loader was not found/displayed after search, so loader wait was skipped.");
		System.out.println("⚠ Actual: Loader was not found/displayed after search, so loader wait was skipped.");
	}
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Open lead action menu and view lead details.");
	System.out.println("Step " + (step - 1) + ": Open lead action menu and view lead details.");
	list_threedot_dropdown_option_selector("View Lead");
	sa.Leads_Approve_button();
	Leads_Details_fetcher();
	Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Final Status:</b> Book a Demo form submission and lead details verification completed successfully.");
	System.out.println("✅ Final Status: Book a Demo form submission and lead details verification completed successfully.");
	System.out.println();
}



public boolean Captcha_Bypass(WebElement captcha_frame) throws InterruptedException {
	
	Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
	Repeat rp = new Repeat(d);
	boolean iframe_switched = false;
	String captcha_stage = "CAPTCHA handling started";

	try {
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step:</b> Handle visible checkbox CAPTCHA.");
		System.out.println("Step: Handle visible checkbox CAPTCHA.");

		captcha_stage = "Switch into size=normal CAPTCHA iframe";
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> CAPTCHA iframe src = " + captcha_frame.getAttribute("src"));
		System.out.println("🟨 Debug: CAPTCHA iframe src = " + captcha_frame.getAttribute("src"));

		rp.Scroll_to_element(captcha_frame);
		d.switchTo().frame(captcha_frame);
		iframe_switched = true;

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Switched into visible checkbox CAPTCHA iframe successfully.");
		System.out.println("🟨 Actual: Switched into visible checkbox CAPTCHA iframe successfully.");

		captcha_stage = "Find CAPTCHA checkbox inside size=normal iframe";
		List<WebElement> checkbox_list = p.Captcha_checkbox_list();
		List<WebElement> border_list = p.Captcha_checkbox_border_list();

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> Checkbox count = " + checkbox_list.size() + " | Border count = " + border_list.size());
		System.out.println("🟨 Debug: Checkbox count = " + checkbox_list.size() + " | Border count = " + border_list.size());

		if (checkbox_list.size() == 0 && border_list.size() == 0) {
			Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ CAPTCHA Failure Point:</b> size=normal iframe found, but checkbox/border element not found inside iframe.");
			System.out.println("❌ CAPTCHA Failure Point: size=normal iframe found, but checkbox/border element not found inside iframe.");
			return false;
		}

		WebElement captcha_target = checkbox_list.size() > 0 ? checkbox_list.get(0) : border_list.get(0);

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> CAPTCHA target | tag = " + captcha_target.getTagName() + " | id = " + captcha_target.getAttribute("id") + " | class = " + captcha_target.getAttribute("class") + " | role = " + captcha_target.getAttribute("role") + " | aria-checked = " + captcha_target.getAttribute("aria-checked"));
		System.out.println("🟨 Debug: CAPTCHA target | tag = " + captcha_target.getTagName() + " | id = " + captcha_target.getAttribute("id") + " | class = " + captcha_target.getAttribute("class") + " | role = " + captcha_target.getAttribute("role") + " | aria-checked = " + captcha_target.getAttribute("aria-checked"));

		captcha_stage = "Click CAPTCHA checkbox";
		try {
			captcha_target.click();
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> CAPTCHA target clicked successfully.");
			System.out.println("🟨 Actual: CAPTCHA target clicked successfully.");
		} catch (Exception click_exception) {
			Report_Listen.log_print_in_report().log(Status.WARNING, "<b>⚠ Retry:</b> Normal CAPTCHA click failed. Retrying with JavaScript click. Reason = " + click_exception.getMessage());
			System.out.println("⚠ Retry: Normal CAPTCHA click failed. Retrying with JavaScript click. Reason = " + click_exception.getMessage());
			rp.Java_script_executor_CLICK(captcha_target);
		}

		Thread.sleep(1200);

		captcha_stage = "Verify CAPTCHA checked state";
		List<WebElement> anchor_list = d.findElements(By.xpath("//*[@id='recaptcha-anchor']"));
		String captcha_status = anchor_list.size() > 0 ? anchor_list.get(0).getAttribute("aria-checked") : "not-found";

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> CAPTCHA verification | anchor count = " + anchor_list.size() + " | aria-checked = " + captcha_status);
		System.out.println("🟨 Debug: CAPTCHA verification | anchor count = " + anchor_list.size() + " | aria-checked = " + captcha_status);

		if (captcha_status.equals("true")) {
			Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> CAPTCHA checkbox clicked and verified successfully.");
			System.out.println("✅ Actual: CAPTCHA checkbox clicked and verified successfully.");
			return true;
		}

		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ CAPTCHA Failure Point:</b> CAPTCHA clicked but aria-checked was not true. Actual = " + captcha_status);
		System.out.println("❌ CAPTCHA Failure Point: CAPTCHA clicked but aria-checked was not true. Actual = " + captcha_status);
		return false;

	} catch (Exception e) {
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ CAPTCHA Failure Point:</b> CAPTCHA handling failed. Failed Stage = " + captcha_stage + " | Reason = " + e.getMessage());
		System.out.println("❌ CAPTCHA Failure Point: CAPTCHA handling failed. Failed Stage = " + captcha_stage + " | Reason = " + e.getMessage());
		return false;
	} finally {
		if (iframe_switched) {
			d.switchTo().defaultContent();
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Switched back to default content after CAPTCHA handling.");
			System.out.println("🟨 Actual: Switched back to default content after CAPTCHA handling.");
		}
	}
}

@DataProvider
public Object[][] Contact_Form_Data() {

	TreeMap<String, String> data1 = new TreeMap<String, String>();
	data1.put("Selected Product", "Simplified Checkout");
	data1.put("First Name", "Anselm Friedrich");
	data1.put("Last Name", "Kruger");
	data1.put("Email", "anselm.friedrich.kruger.checkout046@yopmail.com");
	data1.put("Company Name", "Kruger Retail Technologies GmbH");
	data1.put("Country Code", "+49");
	data1.put("Phone Number", "15593827460");
	data1.put("Message", "We are evaluating Simplified Checkout for our Germany-based retail technology business to improve online payment completion, reduce checkout friction, monitor transaction status more clearly, and support a smoother customer purchase journey.");

	TreeMap<String, String> data2 = new TreeMap<String, String>();
	data2.put("Selected Product", "Simplified Hire");
	data2.put("First Name", "Solene Camille");
	data2.put("Last Name", "Renard");
	data2.put("Email", "solene.camille.renard.hire047@yopmail.com");
	data2.put("Company Name", "Renard Hiring Strategy SAS");
	data2.put("Country Code", "+33");
	data2.put("Phone Number", "763582914");
	data2.put("Message", "Our France-based hiring strategy team is looking for a recruitment platform to manage job applications, candidate pipelines, interview feedback, recruiter collaboration, and hiring-stage visibility from one organized system.");

	TreeMap<String, String> data3 = new TreeMap<String, String>();
	data3.put("Selected Product", "Simplified HR");
	data3.put("First Name", "Eirik Magnus");
	data3.put("Last Name", "Haldorsen");
	data3.put("Email", "eirik.magnus.haldorsen.hr048@yopmail.com");
	data3.put("Company Name", "Haldorsen People Services AS");
	data3.put("Country Code", "+47");
	data3.put("Phone Number", "48261539");
	data3.put("Message", "We are reviewing Simplified HR for our Norway-based team and want to understand employee profile management, attendance logs, leave approval workflows, department mapping, role-based permissions, and reporting options.");

	TreeMap<String, String> data4 = new TreeMap<String, String>();
	data4.put("Selected Product", "Simplified Spaces");
	data4.put("First Name", "Bianca Rosalba");
	data4.put("Last Name", "Ferretti");
	data4.put("Email", "bianca.rosalba.ferretti.spaces049@yopmail.com");
	data4.put("Company Name", "Ferretti Workspace Partners SRL");
	data4.put("Country Code", "+39");
	data4.put("Phone Number", "3468291750");
	data4.put("Message", "We manage flexible workspace locations in Italy and want to explore Simplified Spaces for meeting room bookings, desk availability, customer inquiry handling, workspace allocation, and branch-level operational tracking.");

	TreeMap<String, String> data5 = new TreeMap<String, String>();
	data5.put("Selected Product", "Simplified Checkout, Simplified Hire");
	data5.put("First Name", "Theodore Alistair");
	data5.put("Last Name", "Winslow");
	data5.put("Email", "theodore.alistair.winslow.checkout.hire050@yopmail.com");
	data5.put("Company Name", "Winslow Commerce Talent Ltd");
	data5.put("Country Code", "+44");
	data5.put("Phone Number", "7539462810");
	data5.put("Message", "Our UK-based company is expanding digital sales and hiring operations, so we want to evaluate Simplified Checkout and Simplified Hire together for payment flow management, candidate tracking, recruitment visibility, and operational reporting.");

	TreeMap<String, String> data6 = new TreeMap<String, String>();
	data6.put("Selected Product", "Simplified HR, Simplified Spaces");
	data6.put("First Name", "Fleur Anouk");
	data6.put("Last Name", "Peeters");
	data6.put("Email", "fleur.anouk.peeters.hrspaces051@yopmail.com");
	data6.put("Company Name", "Peeters Office People BVBA");
	data6.put("Country Code", "+32");
	data6.put("Phone Number", "471638295");
	data6.put("Message", "We are a Belgium-based operations company looking for a combined solution to manage employee records, attendance, leave requests, desk booking, meeting room availability, and internal office coordination.");

	TreeMap<String, String> data7 = new TreeMap<String, String>();
	data7.put("Selected Product", "Simplified Checkout, Simplified HR");
	data7.put("First Name", "Lorenz Elias");
	data7.put("Last Name", "Wimmer");
	data7.put("Email", "lorenz.elias.wimmer.checkouthr052@yopmail.com");
	data7.put("Company Name", "Wimmer Business Operations GmbH");
	data7.put("Country Code", "+43");
	data7.put("Phone Number", "6992748163");
	data7.put("Message", "We want to review Simplified Checkout and Simplified HR for our Austria-based operations, mainly to understand transaction monitoring, customer payment handling, employee administration, attendance tracking, and HR approval workflows.");

	TreeMap<String, String> data8 = new TreeMap<String, String>();
	data8.put("Selected Product", "Simplified Hire, Simplified HR");
	data8.put("First Name", "Patrycja Helena");
	data8.put("Last Name", "Borowiec");
	data8.put("Email", "patrycja.helena.borowiec.hirehr053@yopmail.com");
	data8.put("Company Name", "Borowiec Workforce Platforms Sp z oo");
	data8.put("Country Code", "+48");
	data8.put("Phone Number", "517384926");
	data8.put("Message", "We need a platform that can support the full employee journey from candidate applications and interview stages to onboarding, employee record creation, attendance monitoring, leave approval, and HR reporting.");

	TreeMap<String, String> data9 = new TreeMap<String, String>();
	data9.put("Selected Product", "Simplified Checkout, Simplified Hire, Simplified HR");
	data9.put("First Name", "Javier Alonso");
	data9.put("Last Name", "Vidal");
	data9.put("Email", "javier.alonso.vidal.enterprise054@yopmail.com");
	data9.put("Company Name", "Vidal Enterprise SaaS SL");
	data9.put("Country Code", "+34");
	data9.put("Phone Number", "622847391");
	data9.put("Message", "Our Spain-based enterprise team is comparing SaaS platforms for checkout processing, hiring management, and HR administration, and we would like a complete walkthrough with feature details, pricing plans, and implementation guidance.");

	TreeMap<String, String> data10 = new TreeMap<String, String>();
	data10.put("Selected Product", "Simplified Checkout, Simplified Hire, Simplified HR, Simplified Spaces");
	data10.put("First Name", "Veera Emilia");
	data10.put("Last Name", "Lehtinen");
	data10.put("Email", "veera.emilia.lehtinen.fullsuite055@yopmail.com");
	data10.put("Company Name", "Lehtinen Integrated Services Oy");
	data10.put("Country Code", "+358");
	data10.put("Phone Number", "449183627");
	data10.put("Message", "We are evaluating the complete Simplified product suite for our Finland-based operations, including checkout management, recruitment workflow, HR administration, and workspace coordination across multiple departments and office locations.");

	TreeMap<String, String> data11 = new TreeMap<String, String>();
	data11.put("Selected Product", "Simplified Checkout");
	data11.put("First Name", "Bastien Olivier");
	data11.put("Last Name", "Marchand");
	data11.put("Email", "bastien.olivier.marchand.checkout056@yopmail.com");
	data11.put("Company Name", "Marchand Digital Retail SAS");
	data11.put("Country Code", "+33");
	data11.put("Phone Number", "695728413");
	data11.put("Message", "Our France-based online retail business wants to improve checkout reliability, increase successful payment completion, reduce customer friction during purchase, and gain better transaction visibility for digital sales operations.");

	TreeMap<String, String> data12 = new TreeMap<String, String>();
	data12.put("Selected Product", "Simplified Hire");
	data12.put("First Name", "Annika Rosalie");
	data12.put("Last Name", "Seidel");
	data12.put("Email", "annika.rosalie.seidel.hire057@yopmail.com");
	data12.put("Company Name", "Seidel Executive Hiring GmbH");
	data12.put("Country Code", "+49");
	data12.put("Phone Number", "17729481630");
	data12.put("Message", "We are an executive hiring company in Germany managing multiple senior recruitment processes and want to review candidate profile handling, job stage tracking, interviewer feedback, recruiter collaboration, and recruitment reporting.");

	TreeMap<String, String> data13 = new TreeMap<String, String>();
	data13.put("Selected Product", "Simplified HR");
	data13.put("First Name", "Federico Tommaso");
	data13.put("Last Name", "Greco");
	data13.put("Email", "federico.tommaso.greco.hr058@yopmail.com");
	data13.put("Company Name", "Greco Employee Management SRL");
	data13.put("Country Code", "+39");
	data13.put("Phone Number", "3539182746");
	data13.put("Message", "We are searching for an HR management platform for our Italian workforce and want to understand employee data handling, department structure, attendance logs, leave approval flow, administrator access, and reporting options.");

	TreeMap<String, String> data14 = new TreeMap<String, String>();
	data14.put("Selected Product", "Simplified Spaces");
	data14.put("First Name", "Katrine Sofie");
	data14.put("Last Name", "Nyholm");
	data14.put("Email", "katrine.sofie.nyholm.spaces059@yopmail.com");
	data14.put("Company Name", "Nyholm Flexible Offices ApS");
	data14.put("Country Code", "+45");
	data14.put("Phone Number", "31298476");
	data14.put("Message", "We manage shared workspaces and meeting facilities in Denmark and would like to review Simplified Spaces for booking requests, workspace inventory, availability monitoring, customer handling, and multi-location operational reporting.");

	TreeMap<String, String> data15 = new TreeMap<String, String>();
	data15.put("Selected Product", "Simplified Checkout, Simplified Hire");
	data15.put("First Name", "Dorota Malgorzata");
	data15.put("Last Name", "Lisowska");
	data15.put("Email", "dorota.malgorzata.lisowska.checkout.hire060@yopmail.com");
	data15.put("Company Name", "Lisowska Commerce Talent Sp z oo");
	data15.put("Country Code", "+48");
	data15.put("Phone Number", "515837492");
	data15.put("Message", "Our Poland-based business is expanding online sales and recruitment activities, so we want to evaluate Checkout and Hire modules for payment processing, candidate management, recruiter collaboration, and business performance reporting.");

	TreeMap<String, String> data16 = new TreeMap<String, String>();
	data16.put("Selected Product", "Simplified HR, Simplified Spaces");
	data16.put("First Name", "Lukas Adrian");
	data16.put("Last Name", "Burkhardt");
	data16.put("Email", "lukas.adrian.burkhardt.hrspaces061@yopmail.com");
	data16.put("Company Name", "Burkhardt Corporate Operations AG");
	data16.put("Country Code", "+41");
	data16.put("Phone Number", "776492813");
	data16.put("Message", "We are a Switzerland-based operations company looking for HR and workspace management modules to manage employee administration, attendance logs, leave approvals, desk bookings, meeting room planning, office usage, and internal reports.");

	TreeMap<String, String> data17 = new TreeMap<String, String>();
	data17.put("Selected Product", "Simplified Checkout, Simplified HR");
	data17.put("First Name", "Mariana Sofia");
	data17.put("Last Name", "Teixeira");
	data17.put("Email", "mariana.sofia.teixeira.checkouthr062@yopmail.com");
	data17.put("Company Name", "Teixeira Business Systems Lda");
	data17.put("Country Code", "+351");
	data17.put("Phone Number", "934728615");
	data17.put("Message", "We want to review Simplified Checkout and Simplified HR for our Portugal-based operations, especially online payment processing, transaction monitoring, employee record handling, attendance management, and HR approval workflows.");

	TreeMap<String, String> data18 = new TreeMap<String, String>();
	data18.put("Selected Product", "Simplified Hire, Simplified HR");
	data18.put("First Name", "Andrei Constantin");
	data18.put("Last Name", "Lazar");
	data18.put("Email", "andrei.constantin.lazar.hirehr063@yopmail.com");
	data18.put("Company Name", "Lazar Workforce Management SRL");
	data18.put("Country Code", "+40");
	data18.put("Phone Number", "745918326");
	data18.put("Message", "Our Romania-based workforce team is looking for a platform that supports candidate tracking, interview coordination, onboarding management, employee records, attendance logs, leave approvals, and HR reporting after hiring.");

	TreeMap<String, String> data19 = new TreeMap<String, String>();
	data19.put("Selected Product", "Simplified Spaces");
	data19.put("First Name", "Maarten Jeroen");
	data19.put("Last Name", "Verhoef");
	data19.put("Email", "maarten.jeroen.verhoef.spaces064@yopmail.com");
	data19.put("Company Name", "Verhoef Workspace Solutions BV");
	data19.put("Country Code", "+31");
	data19.put("Phone Number", "653827914");
	data19.put("Message", "We operate flexible office locations in the Netherlands and want to review Simplified Spaces for workspace bookings, meeting room availability, customer request handling, space inventory management, and branch-level reporting.");

	TreeMap<String, String> data20 = new TreeMap<String, String>();
	data20.put("Selected Product", "Simplified Checkout, Simplified Hire, Simplified HR, Simplified Spaces");
	data20.put("First Name", "Zuzanna Alicja");
	data20.put("Last Name", "Pawlak");
	data20.put("Email", "zuzanna.alicja.pawlak.allmodules065@yopmail.com");
	data20.put("Company Name", "Pawlak Strategic Operations Sp z oo");
	data20.put("Country Code", "+48");
	data20.put("Phone Number", "504681927");
	data20.put("Message", "We are a Poland-based operations group comparing SaaS platforms for digital checkout, recruitment workflow, HR administration, and workspace coordination, and we would like a complete demo covering all Simplified modules with pricing information.");

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