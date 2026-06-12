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

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🔹 Scenario Title:</b> Validate Book a Demo form submission from frontend");
	System.out.println();
	System.out.println("🔹 Scenario Title: Validate Book a Demo form submission from frontend");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📘 Description:</b> Open frontend URL, navigate to Book a Demo page, select available product cards, fill required contact form details, select country code, submit the form, and capture success/error confirmation message.");
	System.out.println("📘 Description: Open frontend URL, navigate to Book a Demo page, select available product cards, fill required contact form details, select country code, submit the form, and capture success/error confirmation message.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📥 Input:</b> Selected Product = " + Selected_Product
					+ " | Name = " + First_Name + " " + Last_Name
					+ " | Email = " + Email
					+ " | Company = " + Company_Name
					+ " | Country Code = " + Country_Code
					+ " | Phone Number = " + Phone_Number
					+ " | Message = " + Message);
	System.out.println("📥 Input: Selected Product = " + Selected_Product
			+ " | Name = " + First_Name + " " + Last_Name
			+ " | Email = " + Email
			+ " | Company = " + Company_Name
			+ " | Country Code = " + Country_Code
			+ " | Phone Number = " + Phone_Number
			+ " | Message = " + Message);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>✅ Expected:</b> User should be able to open the Book a Demo form, fill all required details, submit the form successfully, and receive a proper success or validation message.");
	System.out.println("✅ Expected: User should be able to open the Book a Demo form, fill all required details, submit the form successfully, and receive a proper success or validation message.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Open frontend URL.");
	System.out.println("Step " + (step - 1) + ": Open frontend URL.");
	System.out.println();

	d.get(URL);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Frontend URL opened successfully = " + URL);
	System.out.println("🟨 Actual: Frontend URL opened successfully = " + URL);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Click Book a Demo button from banner.");
	System.out.println("Step " + (step - 1) + ": Click Book a Demo button from banner.");
	System.out.println();

	WebElement Book_Button = p.Book_a_demo_button_Banner();
	Book_Button.click();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Book a Demo button clicked successfully.");
	System.out.println("🟨 Actual: Book a Demo button clicked successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Validate landing on Book a Demo form page.");
	System.out.println("Step " + (step - 1) + ": Validate landing on Book a Demo form page.");
	System.out.println();

	p.Landed_in_Booking_form_page_confirmation();

	Report_Listen.log_print_in_report().log(Status.PASS,
			"<b>🟨 Actual:</b> User landed successfully on Book a Demo form page.");
	System.out.println("🟨 Actual: User landed successfully on Book a Demo form page.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Accept cookies if cookie banner is displayed.");
	System.out.println("Step " + (step - 1) + ": Accept cookies if cookie banner is displayed.");
	System.out.println();

	p.Accept_cookies_button().click();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Cookies accepted successfully.");
	System.out.println("🟨 Actual: Cookies accepted successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Fetch form input fields, message box, submit button, and product cards.");
	System.out.println("Step " + (step - 1) + ": Fetch form input fields, message box, submit button, and product cards.");
	System.out.println();

	List<WebElement> Input_Fields = p.inputs();
	WebElement Message_Box = p.Textarea();
	WebElement Submit_Button = p.Submit_button();
	List<WebElement> Cards = p.Product_cards();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Input fields fetched = " + Input_Fields.size()
					+ " | Product cards fetched = " + Cards.size());
	System.out.println("🟨 Actual: Input fields fetched = " + Input_Fields.size()
			+ " | Product cards fetched = " + Cards.size());
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Select available product cards.");
	System.out.println("Step " + (step - 1) + ": Select available product cards.");
	System.out.println();
    List<WebElement> Product_checkboxes=p.Product_check_boxes();
	
    boolean product_selected = false;
    int selected_product_count = 0;

    Report_Listen.log_print_in_report().log(Status.INFO,
    		"<b>Step " + (step++) + ":</b> Select product checkbox/options as per test data = " + Selected_Product);
    System.out.println("Step " + (step - 1) + ": Select product checkbox/options as per test data = " + Selected_Product);
    System.out.println();

    if (Selected_Product.equals("Simplified Checkout")) {

    	Product_checkboxes.get(0).click();
    	product_selected = true;
    	selected_product_count = 1;

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>🟨 Actual:</b> Product selected successfully = Simplified Checkout");
    	System.out.println("🟨 Actual: Product selected successfully = Simplified Checkout");
    	System.out.println();
    }

    if (Selected_Product.equals("Simplified Hire")) {

    	Product_checkboxes.get(1).click();
    	product_selected = true;
    	selected_product_count = 1;

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>🟨 Actual:</b> Product selected successfully = Simplified Hire");
    	System.out.println("🟨 Actual: Product selected successfully = Simplified Hire");
    	System.out.println();
    }

    if (Selected_Product.equals("Simplified HR")) {

    	Product_checkboxes.get(2).click();
    	product_selected = true;
    	selected_product_count = 1;

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>🟨 Actual:</b> Product selected successfully = Simplified HR");
    	System.out.println("🟨 Actual: Product selected successfully = Simplified HR");
    	System.out.println();
    }

    if (Selected_Product.equals("Simplified Spaces")) {

    	Product_checkboxes.get(3).click();
    	product_selected = true;
    	selected_product_count = 1;

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>🟨 Actual:</b> Product selected successfully = Simplified Spaces");
    	System.out.println("🟨 Actual: Product selected successfully = Simplified Spaces");
    	System.out.println();
    }

    if (Selected_Product.equals("Simplified Checkout, Simplified Hire")) {

    	Product_checkboxes.get(0).click();
    	Product_checkboxes.get(1).click();
    	product_selected = true;
    	selected_product_count = 2;

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>🟨 Actual:</b> Products selected successfully = Simplified Checkout, Simplified Hire");
    	System.out.println("🟨 Actual: Products selected successfully = Simplified Checkout, Simplified Hire");
    	System.out.println();
    }

    if (Selected_Product.equals("Simplified HR, Simplified Spaces")) {

    	Product_checkboxes.get(2).click();
    	Product_checkboxes.get(3).click();
    	product_selected = true;
    	selected_product_count = 2;

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>🟨 Actual:</b> Products selected successfully = Simplified HR, Simplified Spaces");
    	System.out.println("🟨 Actual: Products selected successfully = Simplified HR, Simplified Spaces");
    	System.out.println();
    }

    if (Selected_Product.equals("Simplified Checkout, Simplified HR")) {

    	Product_checkboxes.get(0).click();
    	Product_checkboxes.get(2).click();
    	product_selected = true;
    	selected_product_count = 2;

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>🟨 Actual:</b> Products selected successfully = Simplified Checkout, Simplified HR");
    	System.out.println("🟨 Actual: Products selected successfully = Simplified Checkout, Simplified HR");
    	System.out.println();
    }

    if (Selected_Product.equals("Simplified Checkout, Simplified Hire, Simplified HR")) {

    	Product_checkboxes.get(0).click();
    	Product_checkboxes.get(1).click();
    	Product_checkboxes.get(2).click();
    	product_selected = true;
    	selected_product_count = 3;

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>🟨 Actual:</b> Products selected successfully = Simplified Checkout, Simplified Hire, Simplified HR");
    	System.out.println("🟨 Actual: Products selected successfully = Simplified Checkout, Simplified Hire, Simplified HR");
    	System.out.println();
    }

    if (Selected_Product.equals("Simplified Checkout, Simplified Hire, Simplified HR, Simplified Spaces")) {

    	Product_checkboxes.get(0).click();
    	Product_checkboxes.get(1).click();
    	Product_checkboxes.get(2).click();
    	Product_checkboxes.get(3).click();
    	product_selected = true;
    	selected_product_count = 4;

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>🟨 Actual:</b> Products selected successfully = Simplified Checkout, Simplified Hire, Simplified HR, Simplified Spaces");
    	System.out.println("🟨 Actual: Products selected successfully = Simplified Checkout, Simplified Hire, Simplified HR, Simplified Spaces");
    	System.out.println();
    }

    if (product_selected) {

    	Report_Listen.log_print_in_report().log(Status.PASS,
    			"<b>✅ Actual:</b> Product selection completed successfully. Selected Product Data = "
    					+ Selected_Product
    					+ " | Selected Product Count = "
    					+ selected_product_count);
    	System.out.println("✅ Actual: Product selection completed successfully. Selected Product Data = "
    			+ Selected_Product
    			+ " | Selected Product Count = "
    			+ selected_product_count);
    	System.out.println();

    } else {

    	Report_Listen.log_print_in_report().log(Status.FAIL,
    			"<b>❌ Actual:</b> No matching product checkbox condition found for Selected Product = "
    					+ Selected_Product);
    	System.out.println("❌ Actual: No matching product checkbox condition found for Selected Product = "
    			+ Selected_Product);
    	System.out.println();
    }

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Product cards selected successfully. Total selected cards = " + Cards.size());
	System.out.println("🟨 Actual: Product cards selected successfully. Total selected cards = " + Cards.size());
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Fill name, email, and company details.");
	System.out.println("Step " + (step - 1) + ": Fill name, email, and company details.");
	System.out.println();

	Input_Fields.get(0).sendKeys(First_Name);
	Input_Fields.get(1).sendKeys(Last_Name);
	Input_Fields.get(2).sendKeys(Email);
	Input_Fields.get(3).sendKeys(Company_Name);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Basic form details entered successfully.");
	System.out.println("🟨 Actual: Basic form details entered successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Open country code dropdown and select required country code = " + Country_Code);
	System.out.println("Step " + (step - 1) + ": Open country code dropdown and select required country code = " + Country_Code);
	System.out.println();

	WebElement country_code_field = p.Country_code_dropdown_field();

	Thread.sleep(800);

	try {

		rp.Scroll_to_element(country_code_field);
		country_code_field.click();

	} catch (Exception e) {

		Report_Listen.log_print_in_report().log(Status.WARNING,
				"<b>⚠ Retry:</b> Country code dropdown click failed in first attempt. Retrying after scroll.");
		System.out.println("⚠ Retry: Country code dropdown click failed in first attempt. Retrying after scroll.");
		System.out.println();

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

			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>🟨 Actual:</b> Country code selected successfully = " + text);
			System.out.println("🟨 Actual: Country code selected successfully = " + text);
			System.out.println();

			break;
		}
	}

	if (!country_code_selected) {

		Report_Listen.log_print_in_report().log(Status.FAIL,
				"<b>❌ Actual:</b> Required country code option was not found = " + Country_Code);
		System.out.println("❌ Actual: Required country code option was not found = " + Country_Code);
		System.out.println();
	}

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Fill phone number and message.");
	System.out.println("Step " + (step - 1) + ": Fill phone number and message.");
	System.out.println();

	Input_Fields.get(4).sendKeys(Phone_Number);
	Message_Box.sendKeys(Message);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Phone number and message entered successfully.");
	System.out.println("🟨 Actual: Phone number and message entered successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Submit Book a Demo form.");
	System.out.println("Step " + (step - 1) + ": Submit Book a Demo form.");
	System.out.println();

	rp.Scroll_to_element(Submit_Button);
	rp.movetoelement(Submit_Button);
	Submit_Button.click();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Submit button clicked successfully.");
	System.out.println("🟨 Actual: Submit button clicked successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Capture form submission confirmation message.");
	System.out.println("Step " + (step - 1) + ": Capture form submission confirmation message.");
	System.out.println();

	WebElement Confirmation_Message = null;

//	try {
		Captcha_Bypass();
		WebElement Refetched_Submit_Button = p.Submit_button();
		rp.Scroll_to_element(Refetched_Submit_Button);
		rp.movetoelement(Refetched_Submit_Button);
		Refetched_Submit_Button.click();
		Confirmation_Message = p.success_message();
		String Refetch_Confirmation_Text = Confirmation_Message.getText().trim();
		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>✅ Actual:</b> Book a Demo form submitted successfully. Confirmation message = "
						+ Refetch_Confirmation_Text);
		System.out.println("✅ Actual: Book a Demo form submitted successfully. Confirmation message = "
				+ Refetch_Confirmation_Text);
		System.out.println();

		Confirmation_Message = p.success_message();

		rp.Scroll_to_element(Confirmation_Message);
		rp.movetoelement(Confirmation_Message);

		String Confirmation_Text = Confirmation_Message.getText().trim();

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>✅ Actual:</b> Book a Demo form submitted successfully. Confirmation message = "
						+ Confirmation_Text);
		System.out.println("✅ Actual: Book a Demo form submitted successfully. Confirmation message = "
				+ Confirmation_Text);
		System.out.println();
		
//	} catch (Exception e) {

		Thread.sleep(800);
        Confirmation_Message = p.error_message();

		rp.Scroll_to_element(Confirmation_Message);
		rp.movetoelement(Confirmation_Message);

		String New_Confirmation_Text = Confirmation_Message.getText().trim();

		Report_Listen.log_print_in_report().log(Status.FAIL,
				"<b>❌ Actual:</b> Book a Demo form submission returned error message = "
						+ New_Confirmation_Text);
		System.out.println("❌ Actual: Book a Demo form submission returned error message = "
				+ New_Confirmation_Text);
		System.out.println();
		//}

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📌 Final Status:</b> Book a Demo form submission flow completed and result logged in ExtentReport.");
	System.out.println("📌 Final Status: Book a Demo form submission flow completed and result logged in ExtentReport.");
	System.out.println();
	Lead_Module_Accessor();
	sa.search_field().sendKeys(First_Name);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Search keyword entered successfully = " + First_Name);
	System.out.println("🟨 Actual: Search keyword entered successfully = " + First_Name);
	System.out.println();

	try {

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step:</b> Wait for list loader to disappear after search.");
		System.out.println("Step: Wait for list loader to disappear after search.");
		System.out.println();

		WebElement Loader = sa.Loader_element();
		rp.wait_for_invisibilty_of_theElement(Loader);

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Loader disappeared successfully after search.");
		System.out.println("🟨 Actual: Loader disappeared successfully after search.");
		System.out.println();

	} catch (Exception e) {

		Report_Listen.log_print_in_report().log(Status.WARNING,
				"<b>⚠ Actual:</b> Loader was not found/displayed after search, so loader wait was skipped.");
		System.out.println("⚠ Actual: Loader was not found/displayed after search, so loader wait was skipped.");
		System.out.println();
	}
	
	
	list_threedot_dropdown_option_selector("View Lead");
	sa.Leads_Approve_button();
	Leads_Details_fetcher();
}



 public void Captcha_Bypass() throws InterruptedException {
	 
	 Saas_Admin_Locaters p = new Saas_Admin_Locaters(d);
	 
	WebElement captcha_frame= p.iframe();
	d.switchTo().frame(captcha_frame);
	WebElement captcha_checkbox = p.Captcha_checkbox();
	captcha_checkbox.click(); 
	captcha_frame.click();
	d.switchTo().defaultContent(); 
	
	 
 }

@DataProvider
public Object[][] Contact_Form_Data() {

	TreeMap<String, String> data1 = new TreeMap<String, String>();
	data1.put("Selected Product", "Simplified Checkout");
	data1.put("First Name", "Stefan Elias");
	data1.put("Last Name", "Kirchhoff");
	data1.put("Email", "stefan.elias.kirchhoff.checkout2026@yopmail.com");
	data1.put("Company Name", "Kirchhoff Digital Commerce GmbH");
	data1.put("Country Code", "+49");
	data1.put("Phone Number", "15562749381");
	data1.put("Message", "We are a Germany-based digital commerce company looking for a dependable checkout solution to improve payment completion, reduce cart abandonment, manage customer transactions more clearly, and support smoother online purchase flows across multiple European markets.");

	TreeMap<String, String> data2 = new TreeMap<String, String>();
	data2.put("Selected Product", "Simplified Hire");
	data2.put("First Name", "Marianne Celeste");
	data2.put("Last Name", "Roche");
	data2.put("Email", "marianne.celeste.roche.hire2026@yopmail.com");
	data2.put("Company Name", "Roche Talent Advisory SAS");
	data2.put("Country Code", "+33");
	data2.put("Phone Number", "756928341");
	data2.put("Message", "Our France-based talent advisory team is evaluating recruitment platforms for managing candidate pipelines, interview stages, recruiter feedback, job applications, and client hiring communication in a more organized and transparent way.");

	TreeMap<String, String> data3 = new TreeMap<String, String>();
	data3.put("Selected Product", "Simplified HR");
	data3.put("First Name", "Willem Alexander");
	data3.put("Last Name", "Vermeer");
	data3.put("Email", "willem.alexander.vermeer.hr2026@yopmail.com");
	data3.put("Company Name", "Vermeer People Operations BV");
	data3.put("Country Code", "+31");
	data3.put("Phone Number", "623918475");
	data3.put("Message", "We are reviewing HR platforms for our Netherlands-based workforce and want to understand how Simplified HR handles employee profiles, department allocation, attendance records, leave approvals, role permissions, and HR reporting for administrators.");

	TreeMap<String, String> data4 = new TreeMap<String, String>();
	data4.put("Selected Product", "Simplified Spaces");
	data4.put("First Name", "Sofia Caterina");
	data4.put("Last Name", "Lombardi");
	data4.put("Email", "sofia.caterina.lombardi.spaces2026@yopmail.com");
	data4.put("Company Name", "Lombardi Workspace Management SRL");
	data4.put("Country Code", "+39");
	data4.put("Phone Number", "3517849263");
	data4.put("Message", "We operate flexible workspaces in Italy and would like to explore Simplified Spaces for managing desk availability, meeting room bookings, customer inquiries, branch-level operations, workspace allocation, and availability tracking.");

	TreeMap<String, String> data5 = new TreeMap<String, String>();
	data5.put("Selected Product", "Simplified Checkout, Simplified Hire");
	data5.put("First Name", "Oscar Theodor");
	data5.put("Last Name", "Nygaard");
	data5.put("Email", "oscar.theodor.nygaard.checkout.hire2026@yopmail.com");
	data5.put("Company Name", "Nygaard Commerce and Recruitment AS");
	data5.put("Country Code", "+47");
	data5.put("Phone Number", "48263917");
	data5.put("Message", "Our Norway-based business is expanding online sales and internal hiring operations, so we want to review Simplified Checkout and Simplified Hire together for payment management, candidate tracking, recruiter collaboration, and operational reporting.");

	TreeMap<String, String> data6 = new TreeMap<String, String>();
	data6.put("Selected Product", "Simplified HR, Simplified Spaces");
	data6.put("First Name", "Eleanor Catherine");
	data6.put("Last Name", "Whitmore");
	data6.put("Email", "eleanor.catherine.whitmore.hrspaces2026@yopmail.com");
	data6.put("Company Name", "Whitmore Corporate Services Ltd");
	data6.put("Country Code", "+44");
	data6.put("Phone Number", "7704936281");
	data6.put("Message", "We are a UK-based corporate services company searching for a combined solution to manage HR administration and workspace coordination, including employee attendance, leave requests, desk bookings, meeting room usage, and internal office operations.");

	TreeMap<String, String> data7 = new TreeMap<String, String>();
	data7.put("Selected Product", "Simplified Checkout, Simplified HR");
	data7.put("First Name", "Lukas Benedikt");
	data7.put("Last Name", "Hofer");
	data7.put("Email", "lukas.benedikt.hofer.checkouthr2026@yopmail.com");
	data7.put("Company Name", "Hofer Business Platforms GmbH");
	data7.put("Country Code", "+43");
	data7.put("Phone Number", "6772849136");
	data7.put("Message", "We are an Austria-based company evaluating Simplified Checkout and Simplified HR to understand how customer transaction handling, payment records, employee administration, attendance tracking, and leave approvals can be managed together.");

	TreeMap<String, String> data8 = new TreeMap<String, String>();
	data8.put("Selected Product", "Simplified Hire, Simplified HR");
	data8.put("First Name", "Klara Magdalena");
	data8.put("Last Name", "Zielinska");
	data8.put("Email", "klara.magdalena.zielinska.hirehr2026@yopmail.com");
	data8.put("Company Name", "Zielinska Workforce Solutions Sp z oo");
	data8.put("Country Code", "+48");
	data8.put("Phone Number", "534829716");
	data8.put("Message", "We need a platform that can manage the complete people journey from candidate applications and interview stages to onboarding, employee record creation, attendance management, leave approvals, and HR reporting.");

	TreeMap<String, String> data9 = new TreeMap<String, String>();
	data9.put("Selected Product", "Simplified Checkout, Simplified Hire, Simplified HR");
	data9.put("First Name", "Pablo Ignacio");
	data9.put("Last Name", "Herrera");
	data9.put("Email", "pablo.ignacio.herrera.enterprise2026@yopmail.com");
	data9.put("Company Name", "Herrera Enterprise Systems SL");
	data9.put("Country Code", "+34");
	data9.put("Phone Number", "645918273");
	data9.put("Message", "Our Spain-based enterprise team is comparing SaaS platforms for checkout processing, recruitment workflow, and employee management, and we would like a detailed walkthrough with pricing, implementation, and feature coverage.");

	TreeMap<String, String> data10 = new TreeMap<String, String>();
	data10.put("Selected Product", "Simplified Checkout, Simplified Hire, Simplified HR, Simplified Spaces");
	data10.put("First Name", "Aino Kristiina");
	data10.put("Last Name", "Laaksonen");
	data10.put("Email", "aino.kristiina.laaksonen.fullsuite2026@yopmail.com");
	data10.put("Company Name", "Laaksonen Integrated Operations Oy");
	data10.put("Country Code", "+358");
	data10.put("Phone Number", "457291638");
	data10.put("Message", "We are evaluating the full Simplified product suite for our Finland-based operations, including checkout management, hiring workflows, HR administration, and workspace coordination across multiple departments and office locations.");

	TreeMap<String, String> data11 = new TreeMap<String, String>();
	data11.put("Selected Product", "Simplified Checkout");
	data11.put("First Name", "Adrien Lucien");
	data11.put("Last Name", "Mercier");
	data11.put("Email", "adrien.lucien.mercier.checkout2026@yopmail.com");
	data11.put("Company Name", "Mercier Online Retail SAS");
	data11.put("Country Code", "+33");
	data11.put("Phone Number", "684173925");
	data11.put("Message", "Our online retail company in France wants to improve the customer checkout experience, increase successful order completion, monitor payment activity more clearly, and manage digital sales operations through a reliable checkout platform.");

	TreeMap<String, String> data12 = new TreeMap<String, String>();
	data12.put("Selected Product", "Simplified Hire");
	data12.put("First Name", "Greta Annalena");
	data12.put("Last Name", "Vogel");
	data12.put("Email", "greta.annalena.vogel.hire2026@yopmail.com");
	data12.put("Company Name", "Vogel Executive Search GmbH");
	data12.put("Country Code", "+49");
	data12.put("Phone Number", "17648291735");
	data12.put("Message", "We are an executive search company in Germany handling several active client hiring requirements and want to review candidate management, job pipeline stages, interview feedback, recruiter notes, and hiring performance reports.");

	TreeMap<String, String> data13 = new TreeMap<String, String>();
	data13.put("Selected Product", "Simplified HR");
	data13.put("First Name", "Marco Giovanni");
	data13.put("Last Name", "Pellegrini");
	data13.put("Email", "marco.giovanni.pellegrini.hr2026@yopmail.com");
	data13.put("Company Name", "Pellegrini Employee Services SRL");
	data13.put("Country Code", "+39");
	data13.put("Phone Number", "3481759264");
	data13.put("Message", "We are searching for an HR management system for our Italian workforce and want to review employee data handling, department setup, attendance records, leave request approvals, access permissions, and HR reporting options.");

	TreeMap<String, String> data14 = new TreeMap<String, String>();
	data14.put("Selected Product", "Simplified Spaces");
	data14.put("First Name", "Freja Mathilde");
	data14.put("Last Name", "Sorensen");
	data14.put("Email", "freja.mathilde.sorensen.spaces2026@yopmail.com");
	data14.put("Company Name", "Sorensen Flexible Offices ApS");
	data14.put("Country Code", "+45");
	data14.put("Phone Number", "28749361");
	data14.put("Message", "We manage shared office spaces and meeting rooms in Denmark and want a detailed demo of Simplified Spaces for booking requests, workspace inventory, availability monitoring, customer handling, and multi-location operations.");

	TreeMap<String, String> data15 = new TreeMap<String, String>();
	data15.put("Selected Product", "Simplified Checkout, Simplified Hire");
	data15.put("First Name", "Ewa Karolina");
	data15.put("Last Name", "Wisniewska");
	data15.put("Email", "ewa.karolina.wisniewska.checkout.hire2026@yopmail.com");
	data15.put("Company Name", "Wisniewska Commerce Talent Sp z oo");
	data15.put("Country Code", "+48");
	data15.put("Phone Number", "512763849");
	data15.put("Message", "Our Poland-based company is expanding its online commerce and hiring operations, so we would like to evaluate Simplified Checkout and Simplified Hire for payment processing, candidate tracking, recruiter collaboration, and growth reporting.");

	TreeMap<String, String> data16 = new TreeMap<String, String>();
	data16.put("Selected Product", "Simplified HR, Simplified Spaces");
	data16.put("First Name", "Hugo Sebastian");
	data16.put("Last Name", "Muller");
	data16.put("Email", "hugo.sebastian.muller.hrspaces2026@yopmail.com");
	data16.put("Company Name", "Muller Corporate Operations AG");
	data16.put("Country Code", "+41");
	data16.put("Phone Number", "798173462");
	data16.put("Message", "We are a Switzerland-based operations company looking for HR and workspace management modules to handle employee administration, attendance logs, leave approvals, desk bookings, meeting room planning, and internal operations reporting.");

	TreeMap<String, String> data17 = new TreeMap<String, String>();
	data17.put("Selected Product", "Simplified Checkout, Simplified HR");
	data17.put("First Name", "Carla Beatriz");
	data17.put("Last Name", "Oliveira");
	data17.put("Email", "carla.beatriz.oliveira.checkouthr2026@yopmail.com");
	data17.put("Company Name", "Oliveira Business Systems Lda");
	data17.put("Country Code", "+351");
	data17.put("Phone Number", "917283645");
	data17.put("Message", "We want to review Simplified Checkout and Simplified HR for our Portugal operations, mainly to understand digital payment handling, transaction monitoring, employee profile management, and HR approval workflows.");

	TreeMap<String, String> data18 = new TreeMap<String, String>();
	data18.put("Selected Product", "Simplified Hire, Simplified HR");
	data18.put("First Name", "Viktor Andrei");
	data18.put("Last Name", "Popovici");
	data18.put("Email", "viktor.andrei.popovici.hirehr2026@yopmail.com");
	data18.put("Company Name", "Popovici Workforce Management SRL");
	data18.put("Country Code", "+40");
	data18.put("Phone Number", "731846259");
	data18.put("Message", "Our Romania-based workforce team is looking for a platform that supports candidate tracking, interview management, onboarding coordination, employee records, attendance monitoring, leave approval, and HR reporting after joining.");

	TreeMap<String, String> data19 = new TreeMap<String, String>();
	data19.put("Selected Product", "Simplified Spaces");
	data19.put("First Name", "Lara Elisabeth");
	data19.put("Last Name", "Van Dijk");
	data19.put("Email", "lara.elisabeth.vandijk.spaces2026@yopmail.com");
	data19.put("Company Name", "Van Dijk Workspace Solutions BV");
	data19.put("Country Code", "+31");
	data19.put("Phone Number", "681927354");
	data19.put("Message", "We operate flexible office locations in the Netherlands and would like to review Simplified Spaces for workspace booking, meeting room availability, customer request handling, space inventory management, and branch-level reporting.");

	TreeMap<String, String> data20 = new TreeMap<String, String>();
	data20.put("Selected Product", "Simplified Checkout, Simplified Hire, Simplified HR, Simplified Spaces");
	data20.put("First Name", "Tomasz Aleksander");
	data20.put("Last Name", "Lewandowski");
	data20.put("Email", "tomasz.aleksander.lewandowski.allmodules2026@yopmail.com");
	data20.put("Company Name", "Lewandowski Strategic Operations Sp z oo");
	data20.put("Country Code", "+48");
	data20.put("Phone Number", "509384172");
	data20.put("Message", "We are a Poland-based operations group comparing SaaS platforms for digital checkout, recruitment management, HR administration, and workspace coordination, and we would like a complete demo covering all Simplified modules with detailed pricing information.");

	return new Object[][] {
		{ data1 },/*
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
		{ data20 } */
	};
}








}