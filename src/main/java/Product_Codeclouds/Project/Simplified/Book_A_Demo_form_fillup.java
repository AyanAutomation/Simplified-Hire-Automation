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
public class Book_A_Demo_form_fillup extends Saas_Admin_Module{
	
	
	
	

	@Test(dataProvider = "combined_data_provider")
	public void book_a_demo_form_fillup(TreeMap<String, String> form_data, TreeMap<String, String> Plan_data) throws IOException, InterruptedException, AWTException {
	
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

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📥 Lead Approval Plan Input:</b> Hire Plan = " + Hire_plan_name + " | Checkout Plan = " + Checkout_plan_name + " | HR Plan = " + Hr_plan_name + " | Spaces Plan = " + Spaces_plan_name);
	System.out.println("📥 Lead Approval Plan Input: Hire Plan = " + Hire_plan_name + " | Checkout Plan = " + Checkout_plan_name + " | HR Plan = " + Hr_plan_name + " | Spaces Plan = " + Spaces_plan_name);
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
	TreeMap<String,String> Leads_Label_values = Leads_Details_fetcher();

	TreeMap<String,String> Expected_Lead_Data = new TreeMap<String,String>();
	Expected_Lead_Data.put("First Name", First_Name);
	Expected_Lead_Data.put("Last Name", Last_Name);
	Expected_Lead_Data.put("Email", Email);
	Expected_Lead_Data.put("Company Name", Company_Name);
	Expected_Lead_Data.put("Country Code", Country_Code);
	Expected_Lead_Data.put("Phone Number", Phone_Number);
	Expected_Lead_Data.put("Message", Message);
	Expected_Lead_Data.put("Selected Product", Selected_Product);

	boolean lead_data_matched = true;

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Verify submitted Book a Demo data with fetched SaaS Admin lead details.");
	System.out.println("Step " + (step - 1) + ": Verify submitted Book a Demo data with fetched SaaS Admin lead details.");

	for(Map.Entry<String,String> pair : Leads_Label_values.entrySet()) {

		String Admin_Label = pair.getKey().trim();
		String Admin_Value = pair.getValue().trim();
		String Admin_Label_Lower = Admin_Label.toLowerCase();

		String Expected_Value = null;

		if(Admin_Label_Lower.contains("first") && Admin_Label_Lower.contains("name")) {
			Expected_Value = First_Name;
		} else if(Admin_Label_Lower.contains("last") && Admin_Label_Lower.contains("name")) {
			Expected_Value = Last_Name;
		} else if(Admin_Label_Lower.contains("email")) {
			Expected_Value = Email;
		} else if(Admin_Label_Lower.contains("company")) {
			Expected_Value = Company_Name;
		} else if(Admin_Label_Lower.contains("country") && Admin_Label_Lower.contains("code")) {
			Expected_Value = Country_Code;
		} else if(Admin_Label_Lower.contains("phone") || Admin_Label_Lower.contains("mobile") || Admin_Label_Lower.contains("contact")) {
			Expected_Value = Phone_Number;
		} else if(Admin_Label_Lower.contains("message") || Admin_Label_Lower.contains("requirement") || Admin_Label_Lower.contains("description")) {
			Expected_Value = Message;
		} else if(Admin_Label_Lower.contains("product") || Admin_Label_Lower.contains("app") || Admin_Label_Lower.contains("service")) {
			Expected_Value = Selected_Product;
		}

		if(Expected_Value != null) {
			String Expected_Value_Normalized = Expected_Value.replaceAll("\\s+", " ").trim();
			String Admin_Value_Normalized = Admin_Value.replaceAll("\\s+", " ").trim();

			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Debug:</b> Comparing Lead Field | Label = " + Admin_Label + " | Expected = " + Expected_Value_Normalized + " | Actual = " + Admin_Value_Normalized);
			System.out.println("🟨 Debug: Comparing Lead Field | Label = " + Admin_Label + " | Expected = " + Expected_Value_Normalized + " | Actual = " + Admin_Value_Normalized);

			if(Admin_Value_Normalized.contains(Expected_Value_Normalized) || Expected_Value_Normalized.contains(Admin_Value_Normalized)) {
				Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Match:</b> Lead field matched successfully. Label = " + Admin_Label + " | Value = " + Admin_Value_Normalized);
				System.out.println("✅ Match: Lead field matched successfully. Label = " + Admin_Label + " | Value = " + Admin_Value_Normalized);
			} else {
				lead_data_matched = false;
				Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Mismatch:</b> Lead field value mismatch. Label = " + Admin_Label + " | Expected = " + Expected_Value_Normalized + " | Actual = " + Admin_Value_Normalized);
				System.out.println("❌ Mismatch: Lead field value mismatch. Label = " + Admin_Label + " | Expected = " + Expected_Value_Normalized + " | Actual = " + Admin_Value_Normalized);
			}
		} else {
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Skipped:</b> No matching frontend input key mapped for admin label = " + Admin_Label + " | Admin Value = " + Admin_Value);
			System.out.println("🟨 Skipped: No matching frontend input key mapped for admin label = " + Admin_Label + " | Admin Value = " + Admin_Value);
		}

		System.out.println();
	}

	if(lead_data_matched) {
		Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> All available mapped Book a Demo lead details matched successfully with SaaS Admin fetched data.");
		System.out.println("✅ Actual: All available mapped Book a Demo lead details matched successfully with SaaS Admin fetched data.");
	} else {
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> One or more Book a Demo lead detail values did not match with SaaS Admin fetched data.");
		System.out.println("❌ Actual: One or more Book a Demo lead detail values did not match with SaaS Admin fetched data.");
		System.out.println();
		return;
	}
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Start SaaS Admin lead approval and plan assignment flow.");
	System.out.println("Step " + (step - 1) + ": Start SaaS Admin lead approval and plan assignment flow.");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📌 Approval Context:</b> The submitted lead will now be approved and assigned with the matching enabled application plans.");
	System.out.println("📌 Approval Context: The submitted lead will now be approved and assigned with the matching enabled application plans.");
	System.out.println();

	Leads_Approve(Plan_data);

	Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Final Status:</b> Book a Demo form submission, SaaS Admin lead verification, lead approval, app plan assignment, and account creation flow completed successfully.");
	System.out.println("✅ Final Status: Book a Demo form submission, SaaS Admin lead verification, lead approval, app plan assignment, and account creation flow completed successfully.");
	System.out.println();
	
	Account_Activator(form_data,step); 
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
public Object[][] combined_data_provider() {
	
	
	
	Object[][] book_demo_form_datas = Contact_Form_Data();
	Object[][] Plan_datas = Plan_Type_Name_Data();
	
	int n =  IntStream.of( book_demo_form_datas.length, Plan_datas.length).min().orElse(0);

	
	Object[][] combined_data = new Object[n][2];
	int i=0;
    while(i<n){
    	combined_data[i][0] = book_demo_form_datas[i][0];       // Frontend Book a Demo form data
    	combined_data[i][1] = Plan_datas[i][0];  // Lead Plan Assigner Data
    	
        i++;
    }
    return combined_data;
	
}







}