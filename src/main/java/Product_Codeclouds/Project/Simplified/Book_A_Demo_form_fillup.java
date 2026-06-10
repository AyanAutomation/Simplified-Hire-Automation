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
	
	if(Selected_Product.equals("Simplified Checkout")){
		Product_checkboxes.get(0).click();
		
	}
	if(Selected_Product.equals("Simplified Hire")){
		Product_checkboxes.get(1).click();
		
	}
	if(Selected_Product.equals("Simplified HR")){
		Product_checkboxes.get(2).click();
		
	}
	if(Selected_Product.equals("Simplified Spaces")){
		Product_checkboxes.get(3).click();
		
	}
	if(Selected_Product.equals("Simplified Checkout, Simplified Hire")){
		Product_checkboxes.get(0).click();
		Product_checkboxes.get(1).click();
		
	}

	if(Selected_Product.equals("Simplified HR, Simplified Spaces")){
		Product_checkboxes.get(2).click();
		Product_checkboxes.get(3).click();
		
	}
	if(Selected_Product.equals("Simplified Checkout, Simplified HR")){
		Product_checkboxes.get(0).click();
		Product_checkboxes.get(2).click();
		
	}
	if(Selected_Product.equals("Simplified Checkout, Simplified Hire, Simplified HR")){
		Product_checkboxes.get(0).click();
		Product_checkboxes.get(1).click();
		Product_checkboxes.get(2).click();
	}
	if(Selected_Product.equals("Simplified Checkout, Simplified Hire, Simplified HR, Simplified Spaces")){
		Product_checkboxes.get(0).click();
		Product_checkboxes.get(1).click();
		Product_checkboxes.get(2).click();
		Product_checkboxes.get(3).click();
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

	WebElement Confirmation_Message;

	try {

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

	} catch (Exception e) {

		Thread.sleep(800);

		Confirmation_Message = p.error_message();

		rp.Scroll_to_element(Confirmation_Message);
		rp.movetoelement(Confirmation_Message);

		String Confirmation_Text = Confirmation_Message.getText().trim();

		Report_Listen.log_print_in_report().log(Status.FAIL,
				"<b>❌ Actual:</b> Book a Demo form submission returned error message = "
						+ Confirmation_Text);
		System.out.println("❌ Actual: Book a Demo form submission returned error message = "
				+ Confirmation_Text);
		System.out.println();
	}

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

			break;
		}
	}


}

@DataProvider
public Object[][] Contact_Form_Data() {

	TreeMap<String, String> data1 = new TreeMap<String, String>();
	data1.put("Selected Product", "Simplified Checkout");
	data1.put("First Name", "Fernando Alejandro");
	data1.put("Last Name", "Castellanos");
	data1.put("Email", "fernando.alejandro.castellanos.checkout2026@yopmail.com");
	data1.put("Company Name", "Castellanos Digital Retail SL");
	data1.put("Country Code", "+34");
	data1.put("Phone Number", "612483957");
	data1.put("Message", "We are a Spain-based retail company planning to improve our online checkout journey, reduce failed transactions, and manage customer payment flow more efficiently across multiple product categories and regional markets.");

	TreeMap<String, String> data2 = new TreeMap<String, String>();
	data2.put("Selected Product", "Simplified Hire");
	data2.put("First Name", "Frederik Christian");
	data2.put("Last Name", "Mikkelsen");
	data2.put("Email", "frederik.christian.mikkelsen.hire2026@yopmail.com");
	data2.put("Company Name", "Mikkelsen Talent Consulting ApS");
	data2.put("Country Code", "+45");
	data2.put("Phone Number", "27194836");
	data2.put("Message", "Our Denmark-based recruitment consulting team is searching for a structured hiring platform to manage candidate pipelines, job applications, interview stages, recruiter notes, and client communication from one centralized system.");

	TreeMap<String, String> data3 = new TreeMap<String, String>();
	data3.put("Selected Product", "Simplified HR");
	data3.put("First Name", "Sigrid Amalie");
	data3.put("Last Name", "Johannessen");
	data3.put("Email", "sigrid.amalie.johannessen.hr2026@yopmail.com");
	data3.put("Company Name", "Johannessen People Services AS");
	data3.put("Country Code", "+47");
	data3.put("Phone Number", "48271936");
	data3.put("Message", "We are reviewing HR management platforms for our Norwegian workforce and want to understand how Simplified HR supports employee profiles, leave approvals, attendance records, department structure, and admin-level access permissions.");

	TreeMap<String, String> data4 = new TreeMap<String, String>();
	data4.put("Selected Product", "Simplified Spaces");
	data4.put("First Name", "Louis Philippe");
	data4.put("Last Name", "Vandervelde");
	data4.put("Email", "louis.philippe.vandervelde.spaces2026@yopmail.com");
	data4.put("Company Name", "Vandervelde Workspace Operations BVBA");
	data4.put("Country Code", "+32");
	data4.put("Phone Number", "476293815");
	data4.put("Message", "We manage flexible office spaces in Belgium and would like to explore Simplified Spaces for booking management, room availability tracking, workspace allocation, customer inquiries, and daily branch-level operational control.");

	TreeMap<String, String> data5 = new TreeMap<String, String>();
	data5.put("Selected Product", "Simplified Checkout, Simplified Hire");
	data5.put("First Name", "Diogo Manuel");
	data5.put("Last Name", "Albuquerque");
	data5.put("Email", "diogo.manuel.albuquerque.checkout.hire2026@yopmail.com");
	data5.put("Company Name", "Albuquerque Commerce and Talent Lda");
	data5.put("Country Code", "+351");
	data5.put("Phone Number", "912748539");
	data5.put("Message", "Our Portugal-based business is expanding both digital sales and internal hiring operations, so we want to evaluate Simplified Checkout and Simplified Hire together for payment processing and recruitment workflow management.");

	TreeMap<String, String> data6 = new TreeMap<String, String>();
	data6.put("Selected Product", "Simplified HR, Simplified Spaces");
	data6.put("First Name", "Aoife Margaret");
	data6.put("Last Name", "O Sullivan");
	data6.put("Email", "aoife.margaret.osullivan.hrspaces2026@yopmail.com");
	data6.put("Company Name", "O Sullivan Corporate Operations Ltd");
	data6.put("Country Code", "+353");
	data6.put("Phone Number", "871946235");
	data6.put("Message", "We are an Ireland-based corporate services company looking for a combined solution to manage employee administration and office resource usage, including attendance, leave requests, desk bookings, and meeting room availability.");

	TreeMap<String, String> data7 = new TreeMap<String, String>();
	data7.put("Selected Product", "Simplified Checkout, Simplified HR");
	data7.put("First Name", "Mikael Johannes");
	data7.put("Last Name", "Koskinen");
	data7.put("Email", "mikael.johannes.koskinen.checkouthr2026@yopmail.com");
	data7.put("Company Name", "Koskinen Business Platforms Oy");
	data7.put("Country Code", "+358");
	data7.put("Phone Number", "451927384");
	data7.put("Message", "We would like to review Simplified Checkout and Simplified HR for our Finland operations, mainly to understand payment handling, customer transaction flow, employee profile management, and internal HR approval processes.");

	TreeMap<String, String> data8 = new TreeMap<String, String>();
	data8.put("Selected Product", "Simplified Hire, Simplified HR");
	data8.put("First Name", "Tomas Vaclav");
	data8.put("Last Name", "Novotny");
	data8.put("Email", "tomas.vaclav.novotny.hirehr2026@yopmail.com");
	data8.put("Company Name", "Novotny Workforce Management sro");
	data8.put("Country Code", "+420");
	data8.put("Phone Number", "602847193");
	data8.put("Message", "We are looking for a platform that can manage candidates from application to onboarding and then continue into HR record management, employee administration, attendance tracking, and leave approval after hiring is completed.");

	TreeMap<String, String> data9 = new TreeMap<String, String>();
	data9.put("Selected Product", "Simplified Checkout, Simplified Hire, Simplified HR");
	data9.put("First Name", "Balazs Kristof");
	data9.put("Last Name", "Farkas");
	data9.put("Email", "balazs.kristof.farkas.enterprise2026@yopmail.com");
	data9.put("Company Name", "Farkas Enterprise Systems Kft");
	data9.put("Country Code", "+36");
	data9.put("Phone Number", "307184926");
	data9.put("Message", "Our Hungary-based enterprise team is comparing SaaS products for checkout processing, recruitment management, and HR administration, and we would like a complete module walkthrough with pricing and implementation details.");

	TreeMap<String, String> data10 = new TreeMap<String, String>();
	data10.put("Selected Product", "Simplified Checkout, Simplified Hire, Simplified HR, Simplified Spaces");
	data10.put("First Name", "Ivana Marija");
	data10.put("Last Name", "Kovacevic");
	data10.put("Email", "ivana.marija.kovacevic.fullsuite2026@yopmail.com");
	data10.put("Company Name", "Kovacevic Integrated Services doo");
	data10.put("Country Code", "+385");
	data10.put("Phone Number", "912638475");
	data10.put("Message", "We are evaluating the complete Simplified product suite for our Croatia-based operations, including checkout management, hiring workflow, HR administration, and workspace booking across different departments and office locations.");

	TreeMap<String, String> data11 = new TreeMap<String, String>();
	data11.put("Selected Product", "Simplified Checkout");
	data11.put("First Name", "Nikolaos Alexandros");
	data11.put("Last Name", "Papadopoulos");
	data11.put("Email", "nikolaos.alexandros.papadopoulos.checkout2026@yopmail.com");
	data11.put("Company Name", "Papadopoulos Online Commerce AE");
	data11.put("Country Code", "+30");
	data11.put("Phone Number", "6948273159");
	data11.put("Message", "Our Greece-based online commerce company wants to understand how Simplified Checkout can support smoother payment processing, better order completion rates, transaction visibility, and customer checkout experience improvements.");

	TreeMap<String, String> data12 = new TreeMap<String, String>();
	data12.put("Selected Product", "Simplified Hire");
	data12.put("First Name", "Alexandru Constantin");
	data12.put("Last Name", "Ionescu");
	data12.put("Email", "alexandru.constantin.ionescu.hire2026@yopmail.com");
	data12.put("Company Name", "Ionescu Recruitment Advisory SRL");
	data12.put("Country Code", "+40");
	data12.put("Phone Number", "721493856");
	data12.put("Message", "We are a Romania-based recruitment advisory firm managing several active job openings and need to see how Simplified Hire handles candidate stages, interview scheduling, recruiter collaboration, and hiring reports.");

	TreeMap<String, String> data13 = new TreeMap<String, String>();
	data13.put("Selected Product", "Simplified HR");
	data13.put("First Name", "Jean Baptiste Henri");
	data13.put("Last Name", "Muller");
	data13.put("Email", "jean.baptiste.henri.muller.hr2026@yopmail.com");
	data13.put("Company Name", "Muller Employee Administration SA");
	data13.put("Country Code", "+352");
	data13.put("Phone Number", "621384927");
	data13.put("Message", "We are reviewing Simplified HR for our Luxembourg office and would like to check employee data management, attendance tracking, leave request approval, team hierarchy, department assignment, and admin reporting capabilities.");

	TreeMap<String, String> data14 = new TreeMap<String, String>();
	data14.put("Selected Product", "Simplified Spaces");
	data14.put("First Name", "Marek Stanislav");
	data14.put("Last Name", "Kovac");
	data14.put("Email", "marek.stanislav.kovac.spaces2026@yopmail.com");
	data14.put("Company Name", "Kovac Flexible Workspace sro");
	data14.put("Country Code", "+421");
	data14.put("Phone Number", "904728163");
	data14.put("Message", "We operate shared workspace locations in Slovakia and want a detailed demo of Simplified Spaces for workspace inventory, booking requests, availability monitoring, branch-level management, and customer inquiry tracking.");

	TreeMap<String, String> data15 = new TreeMap<String, String>();
	data15.put("Selected Product", "Simplified Checkout, Simplified Hire, Simplified HR, Simplified Spaces");
	data15.put("First Name", "Luka Andrej");
	data15.put("Last Name", "Kranjc");
	data15.put("Email", "luka.andrej.kranjc.allmodules2026@yopmail.com");
	data15.put("Company Name", "Kranjc Strategic Operations doo");
	data15.put("Country Code", "+386");
	data15.put("Phone Number", "317482965");
	data15.put("Message", "We are a Slovenia-based operations group comparing platforms for digital checkout, recruitment workflow, HR administration, and workspace coordination, and we would like a complete demo covering all available Simplified modules.");

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
		{ data15 }
	};
}








}