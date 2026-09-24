package Beta_CodeClouds;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Frontend_Locaters;
import Locaters.Saas_Admin_Locaters;
import Product_Codeclouds.Project.Simplified.Book_A_Demo_form_fillup;
import Product_Codeclouds.Project.Simplified.Data_Reader;
import Repeatative_codes.Repeat;

public class Frontend_Form extends Book_A_Demo_form_fillup {

@Test
public void form_fill_up() throws IOException, InterruptedException {

	Data_Reader f = new Data_Reader();
	Repeat rp = new Repeat(d);
	Frontend_Locaters p = new Frontend_Locaters(d);
	Saas_Admin_Locaters sa = new Saas_Admin_Locaters(d);
	
	JavascriptExecutor js = (JavascriptExecutor) d;

	String URL =  System.getProperty("Link") !=null ? System.getProperty("Link") :  f.Data_Fetcher("Beta_Url");
	System.out.println();
	System.out.println("🌐 Frontend Test URL = " + URL);
	System.out.println();
	
	
	String[] Email_Names = {
			"Sergei Belov", 
			"Viktor Orlov", 
			"Kirill Antonov",
			"Pavel Mikhailov",
			"Yulia Romanova",
			"Marina Lebedeva",
			"Tobias Kruger",
			"Daniel Hartmann",
			"Leon Braun",
			"Sebastian Keller",
			"Laura Neumann",
			"Katharina Vogel"
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

	int Total_Repetition = 6;

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🔹 Scenario Title:</b> Repeated frontend contact-form submission validation");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📘 Description:</b> Submit the frontend contact form using multiple customer contact details, handle privacy confirmation and CAPTCHA when required, and verify successful submission.");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📥 Input:</b> Contact Sets = " + Emails.length + " | Repetition Per Contact = " + Total_Repetition + " | Total Submissions = " + (Emails.length * Total_Repetition));
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>✅ Expected:</b> Every configured contact-form submission should complete successfully and display the confirmation message.");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");

	System.out.println();
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println("🔹 Scenario: Repeated frontend contact-form submission validation");
	System.out.println("📥 Contact Sets = " + Emails.length);
	System.out.println("📥 Repetition Per Contact = " + Total_Repetition);
	System.out.println("📥 Total Submissions = " + (Emails.length * Total_Repetition));
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println();

	d.get(URL);
    Thread.sleep(800);
    Permission_Allow_Popup_Handling(2);
	WebElement Header_Chat_Button = p.Lets_Chat_button();
	Header_Chat_Button.click();
	

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

			long Step_Start_Time = System.currentTimeMillis();

			WebElement FullName = p.Full_Name();
			WebElement Email = p.email();
			WebElement Phone = p.phone_number();
			WebElement Company = p.company();
			WebElement Message = p.message();

			System.out.println("⏱ DEBUG | Form element fetch = " + (System.currentTimeMillis() - Step_Start_Time) + " ms");

			Step_Start_Time = System.currentTimeMillis();

			FullName.sendKeys(Full_Name_Value);
			Email.sendKeys(Email_Value);
			Phone.sendKeys(Phone_Number_Value);
			Company.sendKeys(Company_Value);
			Message.sendKeys(Message_Value);

			System.out.println("⏱ DEBUG | Form data entry = " + (System.currentTimeMillis() - Step_Start_Time) + " ms");

			Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Contact details were entered successfully.");
			System.out.println("✅ Actual: Form data entered successfully.");
			System.out.println();

			System.out.println("━━━━━━━━━━━━━━ 🚀 INITIAL SUBMISSION ━━━━━━━━━━━━━━");

			Step_Start_Time = System.currentTimeMillis();

			WebElement SubmitButton = p.SubmitButton();

			System.out.println("⏱ DEBUG | Initial Submit button fetch = " + (System.currentTimeMillis() - Step_Start_Time) + " ms");

			Step_Start_Time = System.currentTimeMillis();

			js.executeScript("document.querySelector('.modal.fade.show').scrollBy(0,1000)");

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

			Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Form submitted successfully. Name = " + Full_Name_Value + " | Email = " + Email_Value + " | Company = " + Company_Value + " | Submission = " + Repeat_Count + "/" + Total_Repetition + " | Confirmation = " + Success_Message_Text);

			System.out.println("✅ Actual: Form submitted successfully.");
			System.out.println("Name = " + Full_Name_Value);
			System.out.println("Email = " + Email_Value);
			System.out.println("Company = " + Company_Value);
			System.out.println("Phone Number = " + Phone_Number_Value);
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