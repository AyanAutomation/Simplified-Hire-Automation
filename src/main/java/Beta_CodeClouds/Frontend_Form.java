package Beta_CodeClouds;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Frontend_Locaters;
import Locaters.Saas_Admin_Locaters;
import Product_Codeclouds.Project.Simplified.Book_A_Demo_form_fillup;
import Product_Codeclouds.Project.Simplified.Data_Reader;
import Repeatative_codes.Repeat;

public class Frontend_Form extends Book_A_Demo_form_fillup {
	
	
public void Frontend_Lander(String Site_Link) throws IOException, InterruptedException{
	
	Frontend_Locaters p = new Frontend_Locaters(d);
	Data_Reader f = new Data_Reader();
	Repeat rp = new Repeat(d);
	
	String URL = System.getProperty("Link") != null ? System.getProperty("Link") : Site_Link;

	System.out.println();
	System.out.println("🌐 Frontend Test URL = " + URL);
	System.out.println();
	d.get(URL);
	Permission_Allow_Popup_Handling(2);
	Thread.sleep(800);
    
}	
	
@Test(dataProvider = "Contact_Form_Data")
public void Footer_Form_Filler(TreeMap<String, String> data) throws IOException, InterruptedException {

	Frontend_Locaters p = new Frontend_Locaters(d);
	Repeat rp = new Repeat(d);

	String Full_Name = data.get("Full Name");
	String Email = data.get("Email");
	String Country_Code = data.get("Country Code");
	String Phone = data.get("Phone");
	String Company = data.get("Company");
	String Message = data.get("Message");
	String Privacy_Policy = data.get("Privacy Policy");
	String Newsletter = data.get("Newsletter");

	System.out.println();
	System.out.println("━━━━━━━━━━━━━━ 📩 FOOTER CONTACT FORM EXECUTION ━━━━━━━━━━━━━━");
	System.out.println();
	System.out.println("👤 Dataset Name = " + Full_Name);
	System.out.println();

	try {

		Frontend_Lander("https://www.codeclouds.com/");

		WebElement Footer_From = p.Bottom_form();
		rp.wait_for_theElement(Footer_From);
		rp.Scroll_to_element(Footer_From);

		List<WebElement> Footer_Fields = Footer_From.findElements(By.xpath(".//input[@type='text' or @type='email' or @type='tel']"));
		List<WebElement> Message_Fields = Footer_From.findElements(By.xpath(".//textarea"));
		List<WebElement> Footer_Checkboxes = Footer_From.findElements(By.xpath(".//input[@type='checkbox']"));
		List<WebElement> Submit_Buttons = Footer_From.findElements(By.xpath(".//button[@type='submit']"));

		Footer_Form_Debug(Footer_Fields, Message_Fields, Footer_Checkboxes, Submit_Buttons);

		if (Footer_Fields.size() < 4 || Message_Fields.isEmpty() || Footer_Checkboxes.size() < 2 || Submit_Buttons.isEmpty()) {
			throw new AssertionError("Required footer form elements are missing.");
		}

		WebElement Full_Name_Field = Footer_Fields.get(0);
		WebElement Email_Field = Footer_Fields.get(1);
		WebElement Phone_Field = Footer_Fields.get(2);
		WebElement Company_Field = Footer_Fields.get(3);
		WebElement Message_Field = Message_Fields.get(0);
		WebElement Privacy_Policy_Checkbox = Footer_Checkboxes.get(0);
		WebElement Newsletter_Checkbox = Footer_Checkboxes.get(1);
		WebElement Submit_Button = Submit_Buttons.get(0);

		rp.wait_for_theElement(Full_Name_Field);
		rp.wait_for_theElement(Email_Field);
		rp.wait_for_theElement(Phone_Field);
		rp.wait_for_theElement(Company_Field);
		rp.wait_for_theElement(Message_Field);
		rp.wait_for_theElement(Submit_Button);

		Thread.sleep(500);

		Full_Name_Field.sendKeys(Full_Name);
		Email_Field.sendKeys(Email);
		Phone_Field.sendKeys(Phone);
		Company_Field.sendKeys(Company);
		Message_Field.sendKeys(Message);

		rp.wait_for_element_to_be_clickable(Privacy_Policy_Checkbox);
		rp.wait_for_element_to_be_clickable(Newsletter_Checkbox);

		if (Privacy_Policy.equals("true") != Privacy_Policy_Checkbox.isSelected()) {
			Privacy_Policy_Checkbox.click();
		}

		if (Newsletter.equals("true") != Newsletter_Checkbox.isSelected()) {
			Newsletter_Checkbox.click();
		}

		System.out.println();
		System.out.println("━━━━━━━━━━━━━━ 📋 FORM DATA SUMMARY ━━━━━━━━━━━━━━");
		System.out.println();
		System.out.println("👤 Full Name      = " + Full_Name);
		System.out.println("📧 Email          = " + Email);
		System.out.println("🌍 Country Code   = " + Country_Code);
		System.out.println("📞 Phone          = " + Phone);
		System.out.println("🏢 Company        = " + Company);
		System.out.println("💬 Message        = " + Message);
		System.out.println("🔒 Privacy Policy = " + Privacy_Policy);
		System.out.println("📨 Newsletter     = " + Newsletter);
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO, "<b>📩 Contact Form Submission</b>");
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>👤 Name:</b> " + Full_Name);
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>📧 Email:</b> " + Email);
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🏢 Company:</b> " + Company);
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>🔒 Privacy Policy:</b> " + (Privacy_Policy.equals("true") ? "Accepted" : "Not Accepted"));
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>📨 Newsletter:</b> " + (Newsletter.equals("true") ? "Subscribed" : "Not Subscribed"));

		rp.wait_for_element_to_be_clickable(Submit_Button);
		Submit_Button.click();

		WebElement Success_Message = p.Contact_Form_Success_Message();
		rp.wait_for_theElement(Success_Message);

		String Success_Message_Text = Success_Message.getText().trim();

		System.out.println("📨 Success Message = " + Success_Message_Text);
		System.out.println();

		if (Success_Message_Text.contains("Thanks for contacting us")) {

			System.out.println("✅ Contact form submitted successfully.");
			System.out.println();

			Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Result:</b> Contact form submitted successfully.");
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>📨 Confirmation:</b> " + Success_Message_Text);

		} else {

			Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Result:</b> Contact form submission confirmation was not received.");

			Assert.fail("Unexpected contact form success message. Actual = " + Success_Message_Text);
		}

	} catch (RuntimeException | AssertionError e) {

		Footer_Form_Error_Debug(e);

		throw e;
	}

	System.out.println("━━━━━━━━━━━━━━ ✅ FOOTER FORM EXECUTION COMPLETED ━━━━━━━━━━━━━━");
	System.out.println();
}

public void Footer_Form_Debug(List<WebElement> Footer_Fields, List<WebElement> Message_Fields, List<WebElement> Footer_Checkboxes, List<WebElement> Submit_Buttons) {

	System.out.println();
	System.out.println("━━━━━━━━━━━━━━ 🔎 FOOTER FORM DEBUG ━━━━━━━━━━━━━━");
	System.out.println();

	System.out.println("🧩 Input Fields Found = " + Footer_Fields.size() + " | Expected = 4");
	System.out.println("💬 Message Fields Found = " + Message_Fields.size() + " | Expected = 1");
	System.out.println("☑️ Checkboxes Found = " + Footer_Checkboxes.size() + " | Expected = 2");
	System.out.println("🔘 Submit Buttons Found = " + Submit_Buttons.size() + " | Expected = 1");
	System.out.println();

	if (Footer_Fields.size() >= 4) {
		System.out.println("👤 Full Name Field   → Displayed = " + Footer_Fields.get(0).isDisplayed() + " | Enabled = " + Footer_Fields.get(0).isEnabled());
		System.out.println("📧 Email Field       → Displayed = " + Footer_Fields.get(1).isDisplayed() + " | Enabled = " + Footer_Fields.get(1).isEnabled());
		System.out.println("📞 Phone Field       → Displayed = " + Footer_Fields.get(2).isDisplayed() + " | Enabled = " + Footer_Fields.get(2).isEnabled());
		System.out.println("🏢 Company Field     → Displayed = " + Footer_Fields.get(3).isDisplayed() + " | Enabled = " + Footer_Fields.get(3).isEnabled());
	}

	if (!Message_Fields.isEmpty()) {
		System.out.println("💬 Message Field     → Displayed = " + Message_Fields.get(0).isDisplayed() + " | Enabled = " + Message_Fields.get(0).isEnabled());
	}

	if (Footer_Checkboxes.size() >= 2) {
		System.out.println("🔒 Privacy Checkbox  → Displayed = " + Footer_Checkboxes.get(0).isDisplayed() + " | Enabled = " + Footer_Checkboxes.get(0).isEnabled() + " | Selected = " + Footer_Checkboxes.get(0).isSelected());
		System.out.println("📨 Newsletter        → Displayed = " + Footer_Checkboxes.get(1).isDisplayed() + " | Enabled = " + Footer_Checkboxes.get(1).isEnabled() + " | Selected = " + Footer_Checkboxes.get(1).isSelected());
	}

	if (!Submit_Buttons.isEmpty()) {
		System.out.println("🔘 Submit Button     → Displayed = " + Submit_Buttons.get(0).isDisplayed() + " | Enabled = " + Submit_Buttons.get(0).isEnabled());
	}

	System.out.println();

	if (Footer_Fields.size() != 4) {
		System.out.println("⚠️ INPUT LOCATOR WARNING → Expected 4 fields but found " + Footer_Fields.size() + ". Locator may be missing elements or matching additional elements.");
	}

	if (Message_Fields.size() != 1) {
		System.out.println("⚠️ MESSAGE LOCATOR WARNING → Expected 1 textarea but found " + Message_Fields.size() + ". Locator may be non-unique.");
	}

	if (Footer_Checkboxes.size() != 2) {
		System.out.println("⚠️ CHECKBOX LOCATOR WARNING → Expected 2 checkboxes but found " + Footer_Checkboxes.size() + ".");
	}

	if (Submit_Buttons.size() != 1) {
		System.out.println("⚠️ SUBMIT LOCATOR WARNING → Expected 1 submit button but found " + Submit_Buttons.size() + ". Locator may be non-unique.");
	}

	System.out.println();
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println();
}

public void Footer_Form_Error_Debug(Throwable e) {

	System.out.println();
	System.out.println("━━━━━━━━━━━━━━ ❌ FOOTER FORM ERROR DEBUG ━━━━━━━━━━━━━━");
	System.out.println();

	System.out.println("Exception Type = " + e.getClass().getSimpleName());
	System.out.println("Exception Message = " + e.getMessage());
	System.out.println();

	if (e instanceof org.openqa.selenium.TimeoutException) {
		System.out.println("🔎 Reason → Required element did not become visible/clickable within the configured wait time.");
	} else if (e instanceof org.openqa.selenium.NoSuchElementException) {
		System.out.println("🔎 Reason → Required element could not be located. Check locator and current DOM.");
	} else if (e instanceof org.openqa.selenium.ElementNotInteractableException) {
		System.out.println("🔎 Reason → Element exists but cannot currently be interacted with. It may be hidden, disabled, or the wrong matched element.");
	} else if (e instanceof org.openqa.selenium.ElementClickInterceptedException) {
		System.out.println("🔎 Reason → Another element or overlay is blocking the click.");
	} else if (e instanceof org.openqa.selenium.StaleElementReferenceException) {
		System.out.println("🔎 Reason → DOM changed after the element was fetched and the stored WebElement became stale.");
	} else if (e instanceof IndexOutOfBoundsException) {
		System.out.println("🔎 Reason → Locator returned fewer elements than expected and the requested index was unavailable.");
	} else {
		System.out.println("🔎 Reason → Unexpected automation execution error.");
	}

	System.out.println();
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println();
}

@DataProvider
public Object[][] Contact_Form_Data() {

	TreeMap<String, String> data1 = new TreeMap<String, String>();
	data1.put("Full Name", "Adrian Test Mircea");
	data1.put("Email", "adrianmircea89@gmail.com");
	data1.put("Country Code", "+91");
	data1.put("Phone", "9184206317");
	data1.put("Company", "NovaTech Digital Solutions");
	data1.put("Message", "We are looking for a reliable technology partner to develop and maintain a scalable web application for our growing business. Please share details about your development process, project timelines, and engagement models.");
	data1.put("Privacy Policy", "true");
	data1.put("Newsletter", "true");

	TreeMap<String, String> data2 = new TreeMap<String, String>();
	data2.put("Full Name", "Lucian Test Kovarik");
	data2.put("Email", "luciankovarik@gmail.com");
	data2.put("Country Code", "+91");
	data2.put("Phone", "9273518642");
	data2.put("Company", "Vector Cloud Systems");
	data2.put("Message", "Our organization is planning a custom software project and we would like to understand your available development services, technical capabilities, estimated delivery timeline, and support options.");
	data2.put("Privacy Policy", "true");
	data2.put("Newsletter", "false");

	TreeMap<String, String> data3 = new TreeMap<String, String>();
	data3.put("Full Name", "Marek Test Zielinski");
	data3.put("Email", "marekzielinski92@gmail.com");
	data3.put("Country Code", "+91");
	data3.put("Phone", "9362745198");
	data3.put("Company", "Arctic Business Technologies");
	data3.put("Message", "We need assistance with designing and developing a modern business platform that can support multiple users and integrations. Please let us know how your team can help us with this requirement.");
	data3.put("Privacy Policy", "true");
	data3.put("Newsletter", "true");

	TreeMap<String, String> data4 = new TreeMap<String, String>();
	data4.put("Full Name", "Nadia Test Velikova");
	data4.put("Email", "nadiavelikova@gmail.com");
	data4.put("Country Code", "+91");
	data4.put("Phone", "9451637284");
	data4.put("Company", "Eastern Digital Networks");
	data4.put("Message", "We are currently evaluating development partners for an upcoming digital transformation project. We would like to discuss our requirements, available resources, project approach, and expected implementation schedule.");
	data4.put("Privacy Policy", "true");
	data4.put("Newsletter", "false");

	TreeMap<String, String> data5 = new TreeMap<String, String>();
	data5.put("Full Name", "Emil Test Saarinen");
	data5.put("Email", "emilsaarinen88@gmail.com");
	data5.put("Country Code", "+91");
	data5.put("Phone", "9546823175");
	data5.put("Company", "BrightWave Software Solutions");
	data5.put("Message", "Our company is interested in developing a customized web and mobile solution. Please provide information regarding your development process, technology expertise, estimated project duration, and post-launch support.");
	data5.put("Privacy Policy", "true");
	data5.put("Newsletter", "true");

	TreeMap<String, String> data6 = new TreeMap<String, String>();
	data6.put("Full Name", "Petra Test Novakova");
	data6.put("Email", "petranovakova91@gmail.com");
	data6.put("Country Code", "+91");
	data6.put("Phone", "9635714286");
	data6.put("Company", "FutureGrid Technologies");
	data6.put("Message", "We would like to discuss a new enterprise application requirement with your team. The solution should be scalable, secure, user friendly, and capable of integrating with our existing business systems.");
	data6.put("Privacy Policy", "true");
	data6.put("Newsletter", "false");

	TreeMap<String, String> data7 = new TreeMap<String, String>();
	data7.put("Full Name", "Dorian Test Ionescu");
	data7.put("Email", "dorianionescu@gmail.com");
	data7.put("Country Code", "+91");
	data7.put("Phone", "9724681357");
	data7.put("Company", "RheinTech Systems GmbH");
	data7.put("Message", "We are searching for an experienced development team for a long-term software engagement. Please share information regarding your available services, team structure, development methodology, and communication process.");
	data7.put("Privacy Policy", "true");
	data7.put("Newsletter", "true");

	TreeMap<String, String> data8 = new TreeMap<String, String>();
	data8.put("Full Name", "Freja Test Lindberg");
	data8.put("Email", "frejalindberg90@gmail.com");
	data8.put("Country Code", "+91");
	data8.put("Phone", "9813572468");
	data8.put("Company", "Frankfurt Digital Works GmbH");
	data8.put("Message", "Our team is planning to modernize an existing business application and introduce several new features. We would like to discuss the project scope, required technologies, estimated timeline, and development cost.");
	data8.put("Privacy Policy", "true");
	data8.put("Newsletter", "false");

	TreeMap<String, String> data9 = new TreeMap<String, String>();
	data9.put("Full Name", "Bastien Test Moreau");
	data9.put("Email", "bastienmoreau87@gmail.com");
	data9.put("Country Code", "+91");
	data9.put("Phone", "9902468135");
	data9.put("Company", "Bavaria Cloud Services GmbH");
	data9.put("Message", "We need a technology partner capable of handling product design, development, testing, deployment, and ongoing maintenance. Please contact us to discuss our requirements and possible engagement options.");
	data9.put("Privacy Policy", "true");
	data9.put("Newsletter", "true");

	TreeMap<String, String> data10 = new TreeMap<String, String>();
	data10.put("Full Name", "Stefan Test Radoslav");
	data10.put("Email", "stefanradoslav@gmail.com");
	data10.put("Country Code", "+91");
	data10.put("Phone", "9091357246");
	data10.put("Company", "Stuttgart DataWorks GmbH");
	data10.put("Message", "We are exploring options for building a new customer-facing digital platform and would like to understand your development capabilities, delivery process, quality assurance approach, and long-term support services.");
	data10.put("Privacy Policy", "true");
	data10.put("Newsletter", "false");

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
		{ data10 }
	};
}
@Test
public void Jobs_Page_count_check() throws IOException, InterruptedException {

	Frontend_Locaters p = new Frontend_Locaters(d);

	Frontend_Lander("https://careers.codeclouds.com/");

	WebElement Apply_Jobs = p.Apply_Job_Header_Button();
	Apply_Jobs.click();

	Thread.sleep(800);

	// Positions Available is selected by default
	Job_Count_Validation();

	WebElement Sort_Field = p.Select_Dropdown_Field();
	Select Sort_Dropdown = new Select(Sort_Field);

	Sort_Dropdown.selectByVisibleText("Fulfilled");

	Thread.sleep(800);

	Job_Count_Validation();
}


public void Job_Count_Validation() throws InterruptedException {

	Frontend_Locaters p = new Frontend_Locaters(d);
	Repeat rp = new Repeat(d);

	WebElement Sort_Field = p.Select_Dropdown_Field();
	Select Sort_Dropdown = new Select(Sort_Field);

	String Selected_Sort_Value = Sort_Dropdown.getFirstSelectedOption().getText().trim();

	System.out.println();
	System.out.println("━━━━━━━━━━━━━━ 💼 " + Selected_Sort_Value.toUpperCase() + " COUNT VALIDATION ━━━━━━━━━━━━━━");
	System.out.println();

	WebElement jobs_section = p.Job_Type_tags_section();
	rp.movetoelement(jobs_section);

	List<WebElement> Job_Types = jobs_section.findElements(By.xpath(".//*[contains(@class,'Apply_tags__')]"));

	int All_Job_Count = 0;
	int Category_Job_Count = 0;

	StringBuilder Category_Count_Report = new StringBuilder();

	Category_Count_Report.append("<div style='border:1px solid #3c5268;border-radius:8px;padding:14px;'>");
	Category_Count_Report.append("<div style='font-size:16px;font-weight:bold;margin-bottom:12px;'>📊 " + Selected_Sort_Value + " — Job Category Breakdown</div>");
	Category_Count_Report.append("<table style='width:100%;border-collapse:collapse;'>");
	Category_Count_Report.append("<tr style='border-bottom:1px solid #506273;'>");
	Category_Count_Report.append("<th style='text-align:left;padding:8px;'>Job Category</th>");
	Category_Count_Report.append("<th style='text-align:right;padding:8px;'>Count</th>");
	Category_Count_Report.append("</tr>");

	for (WebElement Job_Type : Job_Types) {

		String Job_Type_name = Job_Type.getText().trim();
		int Job_Count = 0;

		if (Job_Type_name.contains("(")) {
			Job_Count = Integer.parseInt(Job_Type_name.substring(Job_Type_name.lastIndexOf("(") + 1, Job_Type_name.lastIndexOf(")")));
		}

		String Job_Category_Name = Job_Type_name;

		if (Job_Type_name.contains("(")) {
			Job_Category_Name = Job_Type_name.substring(0, Job_Type_name.lastIndexOf("(")).trim();
		}

		if (Job_Type_name.startsWith("All")) {

			All_Job_Count = Job_Count;

			System.out.println("📌 All Jobs Count = " + All_Job_Count);
			System.out.println();

		} else {

			Category_Job_Count = Category_Job_Count + Job_Count;

			System.out.println("📂 " + Job_Category_Name + " = " + Job_Count);
			System.out.println("➕ Running Total = " + Category_Job_Count);
			System.out.println();

			Category_Count_Report.append("<tr style='border-bottom:1px solid #394b5c;'>");
			Category_Count_Report.append("<td style='padding:8px;'>📁 " + Job_Category_Name + "</td>");
			Category_Count_Report.append("<td style='text-align:right;padding:8px;font-weight:bold;'>" + Job_Count + "</td>");
			Category_Count_Report.append("</tr>");
		}
	}

	Category_Count_Report.append("<tr style='border-top:2px solid #8ca0b3;'>");
	Category_Count_Report.append("<td style='padding:10px;font-size:15px;font-weight:bold;'>TOTAL</td>");
	Category_Count_Report.append("<td style='text-align:right;padding:10px;font-size:16px;font-weight:bold;'>" + Category_Job_Count + "</td>");
	Category_Count_Report.append("</tr>");
	Category_Count_Report.append("</table>");
	Category_Count_Report.append("</div>");

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<div style='font-size:15px;font-weight:bold;'>💼 Job View: " + Selected_Sort_Value + "</div>");

	Report_Listen.log_print_in_report().log(Status.INFO, Category_Count_Report.toString());

	WebElement Job_card_section = p.Job_Apply_Card_Table();
	rp.movetoelement(Job_card_section);

	while (rp.check_element_visibility(p.Show_More_button, 2)) {

		WebElement Show_More_button = p.Show_More_button;

		rp.movetoelement(Show_More_button);
		Show_More_button.click();

		System.out.println("🟨 Show More clicked. Loading additional jobs.");
		System.out.println();

		Thread.sleep(500);
	}

	System.out.println("✅ All jobs loaded for " + Selected_Sort_Value);
	System.out.println();

	Job_card_section = p.Job_Apply_Card_Table();

	List<WebElement> All_Job_Cards = Job_card_section.findElements(By.xpath(".//a"));

	int Loaded_Job_Card_Count = All_Job_Cards.size();

	WebElement Showing_Details_Element = p.Total_Job_Count_From_Listing_Summary();

	String Showing_Details_Text = Showing_Details_Element.getText().trim();

	String[] Showing_Details = Showing_Details_Text.replace("Showing ", "").replace(" jobs", "").split(" ");

	int Showing_List_Count = Integer.parseInt(Showing_Details[2]);
	int Showing_Total_Job_Count = Integer.parseInt(Showing_Details[4]);

	System.out.println("━━━━━━━━━━━━━━ 📊 COUNT RECONCILIATION ━━━━━━━━━━━━━━");
	System.out.println();
	System.out.println("All Jobs Count = " + All_Job_Count);
	System.out.println("Category Total = " + Category_Job_Count);
	System.out.println("Showing Loaded = " + Showing_List_Count);
	System.out.println("Showing Total = " + Showing_Total_Job_Count);
	System.out.println("Displayed Job Listings = " + Loaded_Job_Card_Count);
	System.out.println();

	String Count_Reconciliation_Report =
			"<div style='border:1px solid #3c5268;border-radius:8px;padding:14px;'>" +
			"<div style='font-size:16px;font-weight:bold;margin-bottom:12px;'>🧾 Count Reconciliation</div>" +

			"<table style='width:100%;border-collapse:collapse;'>" +

			"<tr style='border-bottom:1px solid #394b5c;'>" +
			"<td style='padding:8px;'>📌 All Jobs</td>" +
			"<td style='text-align:right;padding:8px;font-weight:bold;'>" + All_Job_Count + "</td>" +
			"</tr>" +

			"<tr style='border-bottom:1px solid #394b5c;'>" +
			"<td style='padding:8px;'>➕ Category Total</td>" +
			"<td style='text-align:right;padding:8px;font-weight:bold;'>" + Category_Job_Count + "</td>" +
			"</tr>" +

			"<tr style='border-bottom:1px solid #394b5c;'>" +
			"<td style='padding:8px;'>📋 Jobs Shown</td>" +
			"<td style='text-align:right;padding:8px;font-weight:bold;'>" + Showing_List_Count + "</td>" +
			"</tr>" +

			"<tr style='border-bottom:1px solid #394b5c;'>" +
			"<td style='padding:8px;'>📋 Listing Total</td>" +
			"<td style='text-align:right;padding:8px;font-weight:bold;'>" + Showing_Total_Job_Count + "</td>" +
			"</tr>" +

			"<tr style='border-top:2px solid #8ca0b3;'>" +
			"<td style='padding:10px;font-size:15px;font-weight:bold;'>🧾 Job Listings Displayed</td>" +
			"<td style='text-align:right;padding:10px;font-size:16px;font-weight:bold;'>" + Loaded_Job_Card_Count + "</td>" +
			"</tr>" +

			"</table>" +
			"</div>";

	Report_Listen.log_print_in_report().log(Status.INFO, Count_Reconciliation_Report);

	if (All_Job_Count == Category_Job_Count &&
			All_Job_Count == Showing_List_Count &&
			All_Job_Count == Showing_Total_Job_Count &&
			All_Job_Count == Loaded_Job_Card_Count) {

		System.out.println("✅ All " + Selected_Sort_Value + " job counts matched successfully.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<div style='font-size:15px;font-weight:bold;'>✅ " + Selected_Sort_Value + " job counts are fully reconciled. All displayed totals match.</div>");

	} else {

		System.out.println("❌ " + Selected_Sort_Value + " job count mismatch.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.FAIL,
				"<div style='font-size:15px;font-weight:bold;'>❌ " + Selected_Sort_Value + " job counts do not reconcile. One or more displayed totals are inconsistent.</div>");

		Assert.fail(Selected_Sort_Value + " job count mismatch.");
	}

	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println();
}

public void Filter_Check(){
	
	
	
	
	
}


@Test
public void form_fill_up() throws IOException, InterruptedException {

	
	Repeat rp = new Repeat(d);
	Frontend_Locaters p = new Frontend_Locaters(d);
	Saas_Admin_Locaters sa = new Saas_Admin_Locaters(d);

	JavascriptExecutor js = (JavascriptExecutor) d;

	

	String[] Email_Names = {
			"Sergei Belov Test",
			"Viktor Orlov Test",
			"Kirill Antonov Test",
			"Pavel Mikhailov Test",
			"Yulia Romanova Test",
			"Marina Lebedeva Test",
			"Tobias Kruger Test",
			"Daniel Hartmann Test",
			"Leon Braun Test",
			"Sebastian Keller Test",
			"Laura Neumann Test",
			"Katharina Vogel Test"
	};

	String[] Emails = {
			"ayan.sengupta@codeclouds.com",
			"ayan.sengupta@codeclouds.com",
			"ayan.sengupta@codeclouds.com",
			"ayan.sengupta@codeclouds.com",
			"ayan.sengupta@codeclouds.com",
			"ayan.sengupta@codeclouds.com",
			"ayan.sengupta@codeclouds.com",
			"ayan.sengupta@codeclouds.com",
			"ayan.sengupta@codeclouds.com",
			"ayan.sengupta@codeclouds.com",
			"ayan.sengupta@codeclouds.com",
			"ayan.sengupta@codeclouds.com"
	};

	String[] Company_Values = {
			"Siberia Digital Networks",
			"NovaTech Business Systems",
			"Arctic Cloud Solutions",
			"VectorSoft Technologies",
			"Moscow Data Systems",
			"EastBridge Digital Group",
			"RheinTech Systems GmbH",
			"Frankfurt Digital Works GmbH",
			"Bavaria Cloud Services GmbH",
			"Hamburg Logic Labs GmbH",
			"Stuttgart DataWorks GmbH",
			"Cologne Enterprise Solutions GmbH"
	};

	String[] Inquiry_Option_Names = {
			"Talent Hiring",
			"Enterprise Solutions",
			"Web & App Development",
			"Creative Design",
			"Partners & Investors",
			"Press",
			"Other"
	};

	int Total_Repetition = 6;
	int Checkbox_Combination = 1;

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🔹 Scenario Title:</b> Repeated frontend contact-form submission validation");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📘 Description:</b> Submit the frontend contact form using multiple customer contact details and different inquiry combinations, handle privacy confirmation and CAPTCHA when required, and verify successful submission.");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📥 Input:</b> Contact Sets = " + Emails.length + " | Repetition Per Contact = " + Total_Repetition + " | Total Submissions = " + (Emails.length * Total_Repetition));
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>✅ Expected:</b> Every submission should contain at least one inquiry option, use a different inquiry combination, and complete successfully.");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");

	System.out.println();
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println("🔹 Scenario: Repeated frontend contact-form submission validation");
	System.out.println("📥 Contact Sets = " + Emails.length);
	System.out.println("📥 Repetition Per Contact = " + Total_Repetition);
	System.out.println("📥 Total Submissions = " + (Emails.length * Total_Repetition));
	System.out.println("📥 Available Inquiry Options = " + Inquiry_Option_Names.length);
	System.out.println("📥 Possible Non-Empty Checkbox Combinations = " + ((1 << Inquiry_Option_Names.length) - 1));
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println();

	
	Frontend_Lander("https://www.codeclouds.com/");
	WebElement Header_Chat_Button = p.Lets_Chat_button();
	Header_Chat_Button.click();

	WebElement Modal = p.Poup_Modal();

	System.out.println();
	System.out.println("━━━━━━━━━━━━━━ 📋 CONTACT MODAL VALIDATION ━━━━━━━━━━━━━━");
	System.out.println();

	boolean Modal_Status = rp.check_element_visibility(Modal, 5);

	System.out.println("🧪 DEBUG | Contact modal displayed = " + Modal_Status);
	System.out.println();

	if (Modal_Status) {

		Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Contact form popup opened successfully.");
		System.out.println("✅ Contact form popup opened successfully.");

	} else {

		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> Contact form popup did not appear after clicking Let's Chat.");
		System.out.println("❌ Contact form popup did not appear after clicking Let's Chat.");

		throw new AssertionError("Contact form popup did not appear after clicking Let's Chat.");
	}

	System.out.println();

	for (int Email_Index = 0; Email_Index < Emails.length; Email_Index++) {

		String Full_Name_Value = Email_Names[Email_Index];
		String Email_Value = Emails[Email_Index];
		String Company_Value = Company_Values[Email_Index];

		for (int Repeat_Count = 1; Repeat_Count <= Total_Repetition; Repeat_Count++) {

			long Iteration_Start_Time = System.currentTimeMillis();

			StringBuilder Phone_Number_Builder = new StringBuilder("98765");
			Phone_Number_Builder.append(String.format("%03d", Email_Index + 1));
			Phone_Number_Builder.append(String.format("%02d", Repeat_Count));

			String Phone_Number_Value = Phone_Number_Builder.toString();
			String Message_Value;

			if (Repeat_Count == 1) {

				Message_Value = "Hello, we are currently exploring options to improve our web platform and would like to understand more about your development services, estimated timelines, and engagement process.";

			} else if (Repeat_Count == 2) {

				Message_Value = "Hi, our team is reviewing potential technology partners for an upcoming software project. Please share some information about your development process, available services, and how we can discuss our requirements.";

			} else {

				Message_Value = "Hello, I would like to speak with your team regarding a custom software requirement for our company. Please let me know a suitable time to discuss the project scope, estimated delivery timeline, and next steps.";
			}

			Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 📋 FORM SUBMISSION ━━━━━━━━━━━━━━</b>");
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>📥 Input:</b> Name = " + Full_Name_Value + " | Email = " + Email_Value + " | Company = " + Company_Value + " | Phone = " + Phone_Number_Value + " | Submission = " + Repeat_Count + "/" + Total_Repetition);

			System.out.println("━━━━━━━━━━━━━━ 🤖 FORM SUBMISSION ━━━━━━━━━━━━━━");
			System.out.println("Name = " + Full_Name_Value);
			System.out.println("Email = " + Email_Value);
			System.out.println("Company = " + Company_Value);
			System.out.println("Phone = " + Phone_Number_Value);
			System.out.println("Repeat = " + Repeat_Count + "/" + Total_Repetition);
			System.out.println();

			System.out.println("━━━━━━━━━━━━━━ ☑️ INQUIRY CHECKBOX COMBINATION ━━━━━━━━━━━━━━");
			System.out.println();

			Modal = p.Poup_Modal();

			js.executeScript("arguments[0].scrollTo(0,0);", Modal);

			List<WebElement> Checkboxes = p.Inquiry_Options();

			int Maximum_Combinations = (1 << Checkboxes.size()) - 1;

			if (Checkbox_Combination > Maximum_Combinations) {
				Checkbox_Combination = 1;
			}

			int Current_Combination = Checkbox_Combination;

			System.out.println("🧪 DEBUG | Checkbox count = " + Checkboxes.size());
			System.out.println("🧪 DEBUG | Combination Number = " + Current_Combination + "/" + Maximum_Combinations);
			System.out.println();

			/*
			 * PASS 1
			 *
			 * Select every checkbox that SHOULD be selected first.
			 *
			 * This is intentional.
			 * We do not uncheck the existing default selection before
			 * another required checkbox has been selected.
			 */

			for (int Checkbox_Index = 0; Checkbox_Index < Checkboxes.size(); Checkbox_Index++) {

				Checkboxes = p.Inquiry_Options();

				WebElement Checkbox = Checkboxes.get(Checkbox_Index);

				boolean Should_Be_Selected = (Current_Combination & (1 << Checkbox_Index)) != 0;

				Boolean Currently_Selected = (Boolean) js.executeScript(
						"const e=arguments[0];" +
						"const input=(e.matches && e.matches(\"input[type='checkbox']\")) ? e : e.querySelector(\"input[type='checkbox']\");" +
						"return input ? input.checked : false;",
						Checkbox
				);

				System.out.println("🧪 DEBUG | PASS 1 | Option = " + Inquiry_Option_Names[Checkbox_Index] + " | Current = " + Currently_Selected + " | Required = " + Should_Be_Selected);

				if (Should_Be_Selected && !Currently_Selected) {

					Checkbox.click();

					System.out.println("🧪 DEBUG | Selected = " + Inquiry_Option_Names[Checkbox_Index]);
				}
			}

			System.out.println();

			/*
			 * PASS 2
			 *
			 * Now deselect options that are NOT part of the required combination.
			 *
			 * Because required options were selected in PASS 1 first,
			 * the form never temporarily reaches zero selections.
			 */

			for (int Checkbox_Index = 0; Checkbox_Index < Checkboxes.size(); Checkbox_Index++) {

				Checkboxes = p.Inquiry_Options();

				WebElement Checkbox = Checkboxes.get(Checkbox_Index);

				boolean Should_Be_Selected = (Current_Combination & (1 << Checkbox_Index)) != 0;

				Boolean Currently_Selected = (Boolean) js.executeScript(
						"const e=arguments[0];" +
						"const input=(e.matches && e.matches(\"input[type='checkbox']\")) ? e : e.querySelector(\"input[type='checkbox']\");" +
						"return input ? input.checked : false;",
						Checkbox
				);

				System.out.println("🧪 DEBUG | PASS 2 | Option = " + Inquiry_Option_Names[Checkbox_Index] + " | Current = " + Currently_Selected + " | Required = " + Should_Be_Selected);

				if (!Should_Be_Selected && Currently_Selected) {

					Checkbox.click();

					System.out.println("🧪 DEBUG | Deselected = " + Inquiry_Option_Names[Checkbox_Index]);
				}
			}

			System.out.println();
			System.out.println("━━━━━━━━━━━━━━ 🔎 FINAL CHECKBOX STATE ━━━━━━━━━━━━━━");
			System.out.println();

			Checkboxes = p.Inquiry_Options();

			int Selected_Checkbox_Count = 0;
			StringBuilder Selected_Inquiry_Options = new StringBuilder();

			for (int Checkbox_Index = 0; Checkbox_Index < Checkboxes.size(); Checkbox_Index++) {

				WebElement Checkbox = Checkboxes.get(Checkbox_Index);

				Boolean Final_Selected_Status = (Boolean) js.executeScript(
						"const e=arguments[0];" +
						"const input=(e.matches && e.matches(\"input[type='checkbox']\")) ? e : e.querySelector(\"input[type='checkbox']\");" +
						"return input ? input.checked : false;",
						Checkbox
				);

				System.out.println("🧪 DEBUG | Final State | " + Inquiry_Option_Names[Checkbox_Index] + " = " + Final_Selected_Status);

				if (Final_Selected_Status) {

					Selected_Checkbox_Count++;

					if (Selected_Inquiry_Options.length() > 0) {
						Selected_Inquiry_Options.append(", ");
					}

					Selected_Inquiry_Options.append(Inquiry_Option_Names[Checkbox_Index]);
				}
			}

			/*
			 * Safety fallback.
			 *
			 * A submission must never proceed with zero selected inquiry options.
			 */

			if (Selected_Checkbox_Count == 0) {

				System.out.println();
				System.out.println("⚠ DEBUG | No inquiry option remained selected.");
				System.out.println("🧪 DEBUG | Applying mandatory fallback selection = Talent Hiring.");
				System.out.println();

				Checkboxes = p.Inquiry_Options();

				Checkboxes.get(0).click();

				Selected_Checkbox_Count = 1;

				Selected_Inquiry_Options.setLength(0);
				Selected_Inquiry_Options.append(Inquiry_Option_Names[0]);

				Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> No inquiry option remained selected after applying the combination. Talent Hiring was selected as the mandatory fallback.");
			}

			System.out.println();
			System.out.println("✅ Inquiry checkbox combination applied successfully.");
			System.out.println("Combination Number = " + Current_Combination);
			System.out.println("Selected Checkbox Count = " + Selected_Checkbox_Count);
			System.out.println("Selected Options = " + Selected_Inquiry_Options);
			System.out.println();

			Report_Listen.log_print_in_report().log(Status.INFO, "<b>📥 Inquiry Selection:</b> Combination = " + Current_Combination + " | Selected Options = " + Selected_Inquiry_Options);
			Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Inquiry checkbox combination applied successfully. Selected Count = " + Selected_Checkbox_Count);

			Checkbox_Combination++;

			long Step_Start_Time = System.currentTimeMillis();

			WebElement FullName = p.Full_Name();
			WebElement Email = p.email();
			WebElement Phone = p.phone_number();
			WebElement Company = p.company();
			WebElement Message = p.message();

			System.out.println("⏱ DEBUG | Form element fetch = " + (System.currentTimeMillis() - Step_Start_Time) + " ms");

			System.out.println();
			System.out.println("━━━━━━━━━━━━━━ 📝 FORM DATA ENTRY TIMING ━━━━━━━━━━━━━━");

			Step_Start_Time = System.currentTimeMillis();

			FullName.sendKeys(Full_Name_Value);
			Email.sendKeys(Email_Value);
			Phone.sendKeys(Phone_Number_Value);
			Company.sendKeys(Company_Value);

			System.out.println("⏱ DEBUG | Name + Email + Phone + Company entry = " + (System.currentTimeMillis() - Step_Start_Time) + " ms");

			Step_Start_Time = System.currentTimeMillis();

			js.executeScript(
					"const element = arguments[0];" +
					"const value = arguments[1];" +
					"const setter = Object.getOwnPropertyDescriptor(HTMLTextAreaElement.prototype, 'value').set;" +
					"setter.call(element, value);" +
					"element.dispatchEvent(new Event('input', {bubbles:true}));" +
					"element.dispatchEvent(new Event('change', {bubbles:true}));",
					Message,
					Message_Value
			);

			System.out.println("⏱ DEBUG | Message entry using JavaScript = " + (System.currentTimeMillis() - Step_Start_Time) + " ms");
			System.out.println("🧪 DEBUG | Message length = " + Message_Value.length() + " characters");
			System.out.println();

			Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Contact details were entered successfully.");
			System.out.println("✅ Actual: Form data entered successfully.");
			System.out.println();

			System.out.println("━━━━━━━━━━━━━━ 🚀 INITIAL SUBMISSION ━━━━━━━━━━━━━━");

			Step_Start_Time = System.currentTimeMillis();

			WebElement SubmitButton = p.SubmitButton();

			System.out.println("⏱ DEBUG | Initial Submit button fetch = " + (System.currentTimeMillis() - Step_Start_Time) + " ms");

			Step_Start_Time = System.currentTimeMillis();

			Modal = p.Poup_Modal();

			js.executeScript("arguments[0].scrollBy(0,1000);", Modal);

			rp.movetoelement(SubmitButton);
			SubmitButton.click();

			System.out.println("⏱ DEBUG | Initial Submit scroll + move + click = " + (System.currentTimeMillis() - Step_Start_Time) + " ms");

			Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Form submission was initiated.");
			System.out.println("🟨 Actual: Initial form submission initiated.");

			System.out.println();
			System.out.println("━━━━━━━━━━━━━━ 🔒 PRIVACY VALIDATION ━━━━━━━━━━━━━━");

			Step_Start_Time = System.currentTimeMillis();

			boolean Privacy_Error_Status = rp.check_element_visibility(p.Error_message, 2);

			System.out.println("⏱ DEBUG | Privacy validation check = " + (System.currentTimeMillis() - Step_Start_Time) + " ms");
			System.out.println("🧪 DEBUG | Privacy validation displayed = " + Privacy_Error_Status);

			if (Privacy_Error_Status) {

				long Privacy_Start_Time = System.currentTimeMillis();

				Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Privacy confirmation was required. The privacy confirmation will be refreshed and the form submitted again.");
				System.out.println("🟨 Actual: Privacy validation appeared.");

				Step_Start_Time = System.currentTimeMillis();

				WebElement privacy_checkbox = p.Privacy_checkbox();

				System.out.println("⏱ DEBUG | Privacy checkbox fetch = " + (System.currentTimeMillis() - Step_Start_Time) + " ms");

				Step_Start_Time = System.currentTimeMillis();

				privacy_checkbox.click();

				System.out.println("⏱ DEBUG | Privacy first toggle = " + (System.currentTimeMillis() - Step_Start_Time) + " ms");

				Thread.sleep(200);

				Step_Start_Time = System.currentTimeMillis();

				privacy_checkbox.click();

				System.out.println("⏱ DEBUG | Privacy second toggle = " + (System.currentTimeMillis() - Step_Start_Time) + " ms");

				Step_Start_Time = System.currentTimeMillis();

				SubmitButton = p.SubmitButton();

				System.out.println("⏱ DEBUG | Privacy retry Submit refetch = " + (System.currentTimeMillis() - Step_Start_Time) + " ms");

				Step_Start_Time = System.currentTimeMillis();

				rp.Scroll_to_element(SubmitButton);
				rp.movetoelement(SubmitButton);
				SubmitButton.click();

				System.out.println("⏱ DEBUG | Privacy retry Submit scroll + move + click = " + (System.currentTimeMillis() - Step_Start_Time) + " ms");
				System.out.println("⏱ DEBUG | Complete privacy handling = " + (System.currentTimeMillis() - Privacy_Start_Time) + " ms");

				Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Privacy confirmation was refreshed and the form was submitted again.");

			} else {

				Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Privacy validation was not displayed. No additional privacy action was required.");
				System.out.println("🟨 Actual: Privacy validation not required.");
			}

			System.out.println();
			System.out.println("━━━━━━━━━━━━━━ 🔐 CAPTCHA HANDLING ━━━━━━━━━━━━━━");
			System.out.println("🧪 DEBUG | CAPTCHA check started after form submission.");

			boolean captcha_appeared = false;
			boolean captcha_status = false;

			Step_Start_Time = System.currentTimeMillis();

			List<WebElement> captcha_frames = sa.captcha_normal_iframe_list();

			System.out.println("⏱ DEBUG | CAPTCHA iframe lookup = " + (System.currentTimeMillis() - Step_Start_Time) + " ms");
			System.out.println("🧪 DEBUG | CAPTCHA iframe count = " + captcha_frames.size());

			if (captcha_frames.size() == 0) {

				Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> CAPTCHA verification was not required for this submission.");
				System.out.println("🟨 Actual: CAPTCHA was not displayed.");
				System.out.println("🧪 DEBUG | Original submission will continue without CAPTCHA retry.");

			} else {

				captcha_appeared = true;

				Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> CAPTCHA verification was required. CAPTCHA handling started.");
				System.out.println("🟨 Actual: CAPTCHA displayed.");

				long Captcha_Start_Time = System.currentTimeMillis();

				System.out.println("⏱ DEBUG | Captcha_Bypass() START");

				captcha_status = Captcha_Bypass(captcha_frames.get(0));

				long Captcha_Duration = System.currentTimeMillis() - Captcha_Start_Time;

				System.out.println("⏱ DEBUG | Captcha_Bypass() END");
				System.out.println("⏱ DEBUG | Captcha_Bypass() duration = " + Captcha_Duration + " ms");
				System.out.println("⏱ DEBUG | Captcha_Bypass() duration = " + String.format("%.2f", Captcha_Duration / 1000.0) + " seconds");
				System.out.println("🧪 DEBUG | Captcha_Bypass() result = " + captcha_status);

				if (captcha_status) {

					Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> CAPTCHA verification completed successfully.");

				} else {

					Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> CAPTCHA verification could not be completed successfully.");
				}
			}

			System.out.println();

			if (captcha_appeared && captcha_status) {

				System.out.println("━━━━━━━━━━━━━━ 🔁 POST-CAPTCHA SUBMISSION ━━━━━━━━━━━━━━");

				Step_Start_Time = System.currentTimeMillis();

				WebElement Refetched_Submit_Button = p.SubmitButton();

				System.out.println("⏱ DEBUG | Post-CAPTCHA Submit refetch = " + (System.currentTimeMillis() - Step_Start_Time) + " ms");

				Step_Start_Time = System.currentTimeMillis();

				rp.Scroll_to_element(Refetched_Submit_Button);
				rp.movetoelement(Refetched_Submit_Button);
				Refetched_Submit_Button.click();

				System.out.println("⏱ DEBUG | Post-CAPTCHA Submit scroll + move + click = " + (System.currentTimeMillis() - Step_Start_Time) + " ms");

				Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Form submission continued successfully after CAPTCHA verification.");
				System.out.println("✅ Actual: Form resubmitted after CAPTCHA.");

			} else if (captcha_appeared && !captcha_status) {

				Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Actual:</b> Form submission could not continue because CAPTCHA verification was unsuccessful.");
				System.out.println("❌ Actual: CAPTCHA appeared but verification could not be confirmed.");

				throw new AssertionError("CAPTCHA verification was not completed successfully. Email = " + Email_Value + " | Repeat = " + Repeat_Count + "/" + Total_Repetition);

			} else {

				Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> CAPTCHA was absent. No CAPTCHA resubmission was required.");
				System.out.println("🧪 DEBUG | No CAPTCHA retry submission required.");
			}

			System.out.println();
			System.out.println("━━━━━━━━━━━━━━ ⏳ SUBMISSION PROCESSING ━━━━━━━━━━━━━━");
			System.out.println("🧪 DEBUG | Submission has already been triggered.");
			System.out.println("🧪 DEBUG | Loader may appear only after Submit and is treated as an optional intermediate state.");
			System.out.println("🧪 DEBUG | Final synchronization will use the submission confirmation message.");

			Step_Start_Time = System.currentTimeMillis();

			WebElement Success_Message = p.Form_Submission_Success_Message();

			System.out.println("⏱ DEBUG | Success message fetch = " + (System.currentTimeMillis() - Step_Start_Time) + " ms");

			Step_Start_Time = System.currentTimeMillis();

			String Success_Message_Text = Success_Message.getText().trim();

			System.out.println("⏱ DEBUG | Success message text read = " + (System.currentTimeMillis() - Step_Start_Time) + " ms");

			Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Form submitted successfully. Name = " + Full_Name_Value + " | Email = " + Email_Value + " | Company = " + Company_Value + " | Inquiry = " + Selected_Inquiry_Options + " | Submission = " + Repeat_Count + "/" + Total_Repetition + " | Confirmation = " + Success_Message_Text);

			System.out.println("✅ Actual: Form submitted successfully.");
			System.out.println("Name = " + Full_Name_Value);
			System.out.println("Email = " + Email_Value);
			System.out.println("Company = " + Company_Value);
			System.out.println("Phone Number = " + Phone_Number_Value);
			System.out.println("Inquiry Combination = " + Current_Combination);
			System.out.println("Selected Inquiry Options = " + Selected_Inquiry_Options);
			System.out.println("Repeat = " + Repeat_Count + "/" + Total_Repetition);
			System.out.println("Confirmation = " + Success_Message_Text);
			System.out.println();

			Step_Start_Time = System.currentTimeMillis();

			rp.wait_for_invisibilty_of_theElement(Success_Message);

			long Success_Disappear_Duration = System.currentTimeMillis() - Step_Start_Time;

			System.out.println("⏱ DEBUG | Success confirmation disappearance wait = " + Success_Disappear_Duration + " ms");

			Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Submission completed successfully. The form is ready for the next submission.");

			long Iteration_Total_Duration = System.currentTimeMillis() - Iteration_Start_Time;

			System.out.println();
			System.out.println("━━━━━━━━━━━━━━ ⏱ ITERATION TIMING SUMMARY ━━━━━━━━━━━━━━");
			System.out.println("Name = " + Full_Name_Value);
			System.out.println("Email = " + Email_Value);
			System.out.println("Company = " + Company_Value);
			System.out.println("Inquiry Combination = " + Current_Combination);
			System.out.println("Selected Inquiry Options = " + Selected_Inquiry_Options);
			System.out.println("Repeat = " + Repeat_Count + "/" + Total_Repetition);
			System.out.println("⏱ Total iteration duration = " + Iteration_Total_Duration + " ms");
			System.out.println("⏱ Total iteration duration = " + String.format("%.2f", Iteration_Total_Duration / 1000.0) + " seconds");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println();
		}
	}

	Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Final Result:</b> Frontend contact-form submission validation completed successfully. Total Submissions = " + (Emails.length * Total_Repetition));
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");

	System.out.println("✅ Final Result: Frontend contact-form submission validation completed successfully.");
	System.out.println("Contact Sets = " + Emails.length);
	System.out.println("Repetition Per Contact = " + Total_Repetition);
	System.out.println("Total Submissions = " + (Emails.length * Total_Repetition));
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println();
}



public void Permission_Allow_Popup_Handling(Integer seconds) {

	Repeat rp = new Repeat(d);
	Frontend_Locaters p = new Frontend_Locaters(d);

	WebElement Cookie_Accept_Button = p.Cookie_Accept_button;

	if (rp.check_element_visibility(Cookie_Accept_Button, seconds)) {
		Cookie_Accept_Button.click();
		rp.wait_for_invisibilty_of_theElement(Cookie_Accept_Button);
		System.out.println("✅ Permission popup handled successfully.");
	} else {
		System.out.println("🟨 Permission popup not displayed.");
	}
}



}