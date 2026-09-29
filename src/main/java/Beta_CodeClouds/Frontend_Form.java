package Beta_CodeClouds;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
	
@Test
public void Footer_Form_Filler() throws IOException, InterruptedException{
	
	Frontend_Locaters p = new Frontend_Locaters(d);
	Repeat rp = new Repeat(d);
	
	Frontend_Lander("https://www.codeclouds.com/");
	WebElement Footer_From=p.Bottom_form();
	
	rp.Scroll_to_element(Footer_From);
	List<WebElement> Footer_Fields=Footer_From.findElements(By.xpath(".//input[@type='text' or @type='email' or @type='tel']"));
	
}




@Test
public void Jobs_Page_count_check() throws IOException, InterruptedException {

	Frontend_Locaters p = new Frontend_Locaters(d);
	Repeat rp = new Repeat(d);

	Frontend_Lander("https://careers.codeclouds.com/");

	WebElement Apply_Jobs = p.Apply_Job_Header_Button();
	Apply_Jobs.click();

	WebElement jobs_section = p.Job_Type_tags_section();

//	p.Landed_in_Jobs_page_confirmation();

	Thread.sleep(800);

	rp.movetoelement(jobs_section);

	List<WebElement> Job_Types = jobs_section.findElements(By.xpath(".//*[contains(@class,'Apply_tags__')]"));

	int All_Job_Count = 0;
	int Category_Job_Count = 0;

	StringBuilder Category_Count_Summary = new StringBuilder();

	System.out.println();
	System.out.println("━━━━━━━━━━━━━━ 💼 JOB COUNT VALIDATION ━━━━━━━━━━━━━━");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 💼 JOB COUNT VALIDATION ━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📘 Description:</b> Validate category counts, load all available job cards, and verify that the total loaded job cards match the All jobs count.");

	for (WebElement Job_Type : Job_Types) {

		String Job_Type_name = Job_Type.getText().trim();
		int Job_Count = 0;

		if (Job_Type_name.contains("(")) {
			Job_Count = Integer.parseInt(Job_Type_name.substring(Job_Type_name.lastIndexOf("(") + 1, Job_Type_name.lastIndexOf(")")));
		}

		if (Job_Type_name.startsWith("All")) {

			All_Job_Count = Job_Count;

			System.out.println("📌 All Jobs Count = " + All_Job_Count);
			System.out.println();

		} else {

			Category_Job_Count = Category_Job_Count + Job_Count;

			Category_Count_Summary.append(Job_Type_name).append(" = ").append(Job_Count).append(" | ");

			System.out.println("📂 Category = " + Job_Type_name);
			System.out.println("🔢 Count = " + Job_Count);
			System.out.println("➕ Running Total = " + Category_Job_Count);
			System.out.println();
		}
	}

	System.out.println("━━━━━━━━━━━━━━ 📊 CATEGORY COUNT SUMMARY ━━━━━━━━━━━━━━");
	System.out.println();

	System.out.println(Category_Count_Summary);
	System.out.println();

	System.out.println("Combined Category Count = " + Category_Job_Count);
	System.out.println("All Jobs Count = " + All_Job_Count);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📂 Category Counts:</b> " + Category_Count_Summary);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>➕ Combined Category Count:</b> " + Category_Job_Count);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📌 All Jobs Count:</b> " + All_Job_Count);

	if (All_Job_Count == Category_Job_Count) {

		System.out.println("✅ Category count add-up matches All jobs count.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Result:</b> Category count add-up matches the All jobs count.");

	} else {

		System.out.println("❌ Category count add-up mismatch.");
		System.out.println("Expected All Count = " + All_Job_Count);
		System.out.println("Actual Category Total = " + Category_Job_Count);
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Result:</b> Category count mismatch. All = " + All_Job_Count + " | Category Total = " + Category_Job_Count);

		Assert.fail("Category job count mismatch. All = " + All_Job_Count + " | Category Total = " + Category_Job_Count);
	}

	System.out.println("━━━━━━━━━━━━━━ 🔽 SHOW MORE HANDLING ━━━━━━━━━━━━━━");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🔽 Action:</b> Load all available job cards using Show More.");

	WebElement Job_card_section = p.Job_Apply_Card_Table();
	rp.movetoelement(Job_card_section);

	while (rp.check_element_visibility(p.Show_More_button, 2)) {

		WebElement Show_More_button = p.Show_More_button;

		rp.movetoelement(Show_More_button);
		Show_More_button.click();

		System.out.println("🟨 Show More clicked. Loading additional job cards.");
		System.out.println();

		Thread.sleep(500);
	}

	System.out.println("✅ Show More is no longer available.");
	System.out.println("✅ All available job cards are loaded.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Show More is no longer available. All job cards have been loaded.");

	Job_card_section = p.Job_Apply_Card_Table();

	List<WebElement> All_Job_Cards = Job_card_section.findElements(By.xpath(".//a"));

	int Loaded_Job_Card_Count = All_Job_Cards.size();

	System.out.println("━━━━━━━━━━━━━━ 🧾 JOB CARD COUNT VALIDATION ━━━━━━━━━━━━━━");
	System.out.println();

	System.out.println("📌 All Jobs Count = " + All_Job_Count);
	System.out.println("🧾 Loaded Job Cards Count = " + Loaded_Job_Card_Count);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📌 Expected All Jobs Count:</b> " + All_Job_Count);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🧾 Actual Loaded Job Cards Count:</b> " + Loaded_Job_Card_Count);

	if (All_Job_Count == Loaded_Job_Card_Count) {

		System.out.println("✅ Loaded job card count matches All jobs count.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Result:</b> Loaded job card count matches the All jobs count.");

	} else {

		System.out.println("❌ Loaded job card count does not match All jobs count.");
		System.out.println("Expected = " + All_Job_Count);
		System.out.println("Actual = " + Loaded_Job_Card_Count);
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Result:</b> Job card count mismatch. Expected = " + All_Job_Count + " | Actual = " + Loaded_Job_Card_Count);

		Assert.fail("Loaded job card count mismatch. Expected = " + All_Job_Count + " | Actual = " + Loaded_Job_Card_Count);
	}

	System.out.println("━━━━━━━━━━━━━━ ✅ FINAL RESULT ━━━━━━━━━━━━━━");
	System.out.println();
	System.out.println("✅ Category Total = " + Category_Job_Count);
	System.out.println("✅ All Jobs Count = " + All_Job_Count);
	System.out.println("✅ Loaded Job Cards = " + Loaded_Job_Card_Count);
	System.out.println("✅ Job count validation completed successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Final Result:</b> Category Total = " + Category_Job_Count + " | All Jobs = " + All_Job_Count + " | Loaded Job Cards = " + Loaded_Job_Card_Count);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
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