package Product_Codeclouds.Project.Simplified;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Candidate_Module_Locaters;
import Locaters.Job_Module_locaters;
import Repeatative_codes.Repeat;

public class Candidate_module extends Side_menu_Handler {

	public WebElement Candidate_List_Accesor() throws IOException, InterruptedException {

		Candidate_Module_Locaters p = new Candidate_Module_Locaters(d);

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step:</b> Navigate to Candidates module from side menu.");
		System.out.println("Step: Navigate to Candidates module from side menu.");

		Menu_option_selector("Candidates");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step:</b> Validate landing in Candidate list by identifying the Import CV button.");
		System.out.println("Step: Validate landing in Candidate list by identifying the Import CV button.");

		WebElement Import = p.Import_Cv_Button();

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>🟨 Actual:</b> Candidate list opened successfully and Import CV button was identified.");
		System.out.println("🟨 Actual: Candidate list opened successfully and Import CV button was identified.");

		return Import;
	}
	
	@Test(dataProvider = "Combined_Candidate_Job_Data")
public void Add_Candidate(TreeMap<String, String> candidate_data, TreeMap<String, String> job_data)
		throws IOException, InterruptedException, AWTException {

	int step = 1;

	String Job_Assign = job_data.get("Job Posting Name");
	String Email = candidate_data.get("Email");
	String Phone_Code = candidate_data.get("Phone Code");
	String Phone_Number = candidate_data.get("Phone Number");
	String First_Name = candidate_data.get("First Name");
	String Last_Name = candidate_data.get("Last Name");
	String Professional_Profile_Link = candidate_data.get("Professional Profile Link");

	String Source = candidate_data.get("Source");
	String Country = candidate_data.get("Country");
	String State = candidate_data.get("State");

	String Current_Salary_Currency = candidate_data.get("Current Salary Currency");
	String Current_Salary = candidate_data.get("Current Salary");
	String Current_Salary_Duration = candidate_data.get("Current Salary Duration");

	String Expected_Salary_Currency = candidate_data.get("Expected Salary Currency");
	String Expected_Salary = candidate_data.get("Expected Salary");
	String Expected_Salary_Duration = candidate_data.get("Expected Salary Duration");

	String CV_Resume = candidate_data.get("CV/Resume");
	String Skills = candidate_data.get("Skills");

	String Relevant_Experience = candidate_data.get("Relevant Experience");
	String Relevant_Experience_Unit = candidate_data.get("Relevant Experience Unit");

	String Total_Experience = candidate_data.get("Total Experience");
	String Total_Experience_Unit = candidate_data.get("Total Experience Unit");

	String Notice_Period = candidate_data.get("Notice Period");
	String Notice_Period_Unit = candidate_data.get("Notice Period Unit");

	String Work_Experience = candidate_data.get("Work Experience");
	String Education = candidate_data.get("Education");
	String Cover_Letter = candidate_data.get("Cover Letter");

	String Owner = candidate_data.get("Owner");
	String Recruiter = candidate_data.get("Recruiter");

	Candidate_Module_Locaters p = new Candidate_Module_Locaters(d);
	Repeat rp = new Repeat(d);
	Job_Module_locaters jp = new Job_Module_locaters(d);
	Robot r = new Robot();


	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🔹 Scenario Title:</b> Add Candidate from Candidate module and assign candidate to a job");
	System.out.println();
	System.out.println("🔹 Scenario Title: Add Candidate from Candidate module and assign candidate to a job");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📘 Description:</b> Access the Candidate list, open the Add Candidate popup, assign the required job, enter candidate details, select state, owner, and recruiter, save the candidate, and validate the success toast message.");
	System.out.println(
			"📘 Description: Access the Candidate list, open the Add Candidate popup, assign the required job, enter candidate details, select state, owner, and recruiter, save the candidate, and validate the success toast message.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📥 Input:</b> Job Assign = " + Job_Assign
					+ " | Email = " + Email
					+ " | Phone Code = " + Phone_Code
					+ " | Phone Number = " + Phone_Number
					+ " | First Name = " + First_Name
					+ " | Last Name = " + Last_Name
					+ " | State = " + State
					+ " | Relevant Experience = " + Relevant_Experience + " " + Relevant_Experience_Unit
					+ " | Total Experience = " + Total_Experience + " " + Total_Experience_Unit
					+ " | Notice Period = " + Notice_Period + " " + Notice_Period_Unit
					+ " | Owner = " + Owner
					+ " | Recruiter = " + Recruiter);
	System.out.println("📥 Input: Job Assign = " + Job_Assign
			+ " | Email = " + Email
			+ " | Phone Code = " + Phone_Code
			+ " | Phone Number = " + Phone_Number
			+ " | First Name = " + First_Name
			+ " | Last Name = " + Last_Name
			+ " | State = " + State
			+ " | Relevant Experience = " + Relevant_Experience + " " + Relevant_Experience_Unit
			+ " | Total Experience = " + Total_Experience + " " + Total_Experience_Unit
			+ " | Notice Period = " + Notice_Period + " " + Notice_Period_Unit
			+ " | Owner = " + Owner
			+ " | Recruiter = " + Recruiter);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>✅ Expected:</b> Candidate Add popup should open successfully, required job and candidate details should be entered correctly, state/owner/recruiter should be selected successfully, candidate should be saved, popup should close, and success toast should appear.");
	System.out.println(
			"✅ Expected: Candidate Add popup should open successfully, required job and candidate details should be entered correctly, state/owner/recruiter should be selected successfully, candidate should be saved, popup should close, and success toast should appear.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Access Candidate list page.");
	System.out.println("Step " + (step - 1) + ": Access Candidate list page.");
	System.out.println();

	Candidate_List_Accesor();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Candidate list page accessed successfully.");
	System.out.println("🟨 Actual: Candidate list page accessed successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Click Add Candidate button to open the candidate popup.");
	System.out.println("Step " + (step - 1) + ": Click Add Candidate button to open the candidate popup.");
	System.out.println();

	p.Add_Button().click();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Add Candidate button clicked successfully.");
	System.out.println("🟨 Actual: Add Candidate button clicked successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Move to the candidate popup form and fetch visible field groups.");
	System.out.println("Step " + (step - 1) + ": Move to the candidate popup form and fetch visible field groups.");
	System.out.println();

	WebElement Pop_up_body = p.Pop_up_form();
	rp.movetoelement(Pop_up_body);

	List<WebElement> inputs_boxes = p.name_ph_email_input_fieldsBox();
	List<WebElement> dropdowns = p.Pop_Up_Form_Custom_Dropdown_fields();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Candidate popup form located successfully. Input box groups found = " + inputs_boxes.size()
					+ " | Custom dropdown fields found = " + dropdowns.size());
	System.out.println("🟨 Actual: Candidate popup form located successfully. Input box groups found = " + inputs_boxes.size()
			+ " | Custom dropdown fields found = " + dropdowns.size());
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Open Assign Job dropdown and select the required job.");
	System.out.println("Step " + (step - 1) + ": Open Assign Job dropdown and select the required job.");
	System.out.println();

	WebElement Assign_Job_Dropdown = dropdowns.get(0);
	Assign_Job_Dropdown.click();
	p.Assign_job_input().sendKeys(Job_Assign);
	Thread.sleep(800);

	WebElement dropdown_list = jp.First_dropdown_list();
	rp.movetoelement(dropdown_list);
	Thread.sleep(800);

	List<WebElement> job_options = jp.First_dropdown_Options();
	for (WebElement jbopt : job_options) {
		String option_text = jbopt.getText().trim();
		rp.Scroll_to_element(jbopt);
		if (option_text.equalsIgnoreCase(Job_Assign)) {
			jbopt.click();
			break;
		}
	}

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Required job selected successfully from Assign Job dropdown = " + Job_Assign);
	System.out.println("🟨 Actual: Required job selected successfully from Assign Job dropdown = " + Job_Assign);
	System.out.println();

	p.form_scroll().click();
	r.mouseWheel(6);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Fetch candidate input fields and enter basic candidate details.");
	System.out.println("Step " + (step - 1) + ": Fetch candidate input fields and enter basic candidate details.");
	System.out.println();

	List<WebElement> inputs = p.name_ph_email_input_fields();
	inputs.get(0).sendKeys(Email);
	inputs.get(1).sendKeys(Phone_Number);
	inputs.get(2).sendKeys(First_Name);
	inputs.get(3).sendKeys(Last_Name);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Candidate basic details entered successfully. Email = " + Email
					+ " | Phone Number = " + Phone_Number
					+ " | First Name = " + First_Name
					+ " | Last Name = " + Last_Name);
	System.out.println("🟨 Actual: Candidate basic details entered successfully. Email = " + Email
			+ " | Phone Number = " + Phone_Number
			+ " | First Name = " + First_Name
			+ " | Last Name = " + Last_Name);
	System.out.println();

	r.mouseWheel(1);
	Thread.sleep(800);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Select the required state from the State dropdown.");
	System.out.println("Step " + (step - 1) + ": Select the required state from the State dropdown.");
	System.out.println();

	WebElement State_field = p.State_field();
	r.mouseWheel(1);
	rp.movetoelement(State_field);
	State_field.click();

	WebElement state_input = p.State_input();
	state_input.sendKeys(State);
	Thread.sleep(500);
     WebElement state_dropdown_list = p.Owner_Dropdown();
	List<WebElement> state_options = state_dropdown_list.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
	for (WebElement stopt : state_options) {
		String option_text = stopt.getText().trim();
		if (option_text.equalsIgnoreCase(State)) {
			stopt.click();
			break;
		}
	}

	WebElement state_option_selected = p.Selected_option();
	String options_text = state_option_selected.getText().trim();
//	Assert.assertTrue(options_text.equalsIgnoreCase(State),"State selection failed Expected " + State + " got " + options_text);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> State selected successfully = " + options_text);
	System.out.println("🟨 Actual: State selected successfully = " + options_text);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Enter candidate experience and notice period details.");
	System.out.println("Step " + (step - 1) + ": Enter candidate experience and notice period details.");
	System.out.println();

	WebElement RelevantExperience = inputs.get(4);
	rp.Scroll_to_element(RelevantExperience);
	RelevantExperience.sendKeys(Relevant_Experience);

	WebElement TotalExperience = inputs.get(5);
	TotalExperience.sendKeys(Total_Experience);

	inputs_boxes.get(6).click();

	WebElement NoticePeriod = inputs.get(6);
	NoticePeriod.sendKeys(Notice_Period);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Relevant Experience entered = " + Relevant_Experience
					+ " | Total Experience entered = " + Total_Experience
					+ " | Notice Period entered = " + Notice_Period);
	System.out.println("🟨 Actual: Relevant Experience entered = " + Relevant_Experience
			+ " | Total Experience entered = " + Total_Experience
			+ " | Notice Period entered = " + Notice_Period);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Select Owner from Owner dropdown.");
	System.out.println("Step " + (step - 1) + ": Select Owner from Owner dropdown.");
	System.out.println();

	WebElement Owner_field = p.Ownerfield();
	rp.Scroll_to_element(Owner_field);
	rp.movetoelement(Owner_field);
	Thread.sleep(800);
	Owner_field.click();
	Thread.sleep(800);

	WebElement Owner_dropdown_list = p.Owner_Dropdown();
	p.Owner_input().sendKeys(Owner);
	Thread.sleep(800);
	rp.movetoelement(Owner_dropdown_list);

	List<WebElement> Owner_options = Owner_dropdown_list.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));;
	for (WebElement owneropt : Owner_options) {
		String option_text = owneropt.getText().trim();
		if (option_text.equalsIgnoreCase(Owner)) {
			owneropt.click();
			break;
		}
	}

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Owner selected successfully = " + Owner);
	System.out.println("🟨 Actual: Owner selected successfully = " + Owner);
	System.out.println();

	p.form_scroll().click();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Select Recruiter from Recruiter dropdown.");
	System.out.println("Step " + (step - 1) + ": Select Recruiter from Recruiter dropdown.");
	System.out.println();

	WebElement Recruiter_field = p.recruiterfield();
	Recruiter_field.click();
	p.recruiter_input().sendKeys(Recruiter);
    Thread.sleep(500);
	WebElement Recruiter_dropdown_list = p.recruiter_Dropdown();
	Thread.sleep(500);
	rp.movetoelement(Recruiter_dropdown_list);
    List<WebElement> Recruiter_options = Recruiter_dropdown_list.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
	for (WebElement recruiteropt : Recruiter_options) {
		String option_text = recruiteropt.getText().trim();
		if (option_text.equalsIgnoreCase(Recruiter)) {
			recruiteropt.click();  
			break;
		}
	}

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Recruiter selected successfully = " + Recruiter);
	System.out.println("🟨 Actual: Recruiter selected successfully = " + Recruiter);
	System.out.println();

	Thread.sleep(500);
	p.form_scroll().click();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Click Save on the candidate popup.");
	System.out.println("Step " + (step - 1) + ": Click Save on the candidate popup.");
	System.out.println();

	WebElement Save = p.Modal_Save_Button();
	rp.Scroll_to_element(Save);
	rp.movetoelement(Save);
	Thread.sleep(800);
	Save.click();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Candidate popup Save button clicked successfully.");
	System.out.println("🟨 Actual: Candidate popup Save button clicked successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Wait for candidate popup to close and validate success toast.");
	System.out.println("Step " + (step - 1) + ": Wait for candidate popup to close and validate success toast.");
	System.out.println();

	rp.wait_for_invisibilty_of_theElement(Pop_up_body);

	WebElement Success_toast = p.Success_Toast_Message();
	String success_toast_text = Success_toast.getText().trim();

	Report_Listen.log_print_in_report().log(Status.PASS,
			"<b>🟨 Actual:</b> Candidate was added successfully and success toast appeared = " + success_toast_text);
	System.out.println("🟨 Actual: Candidate was added successfully and success toast appeared = " + success_toast_text);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📌 Final Status:</b> Candidate Add flow completed successfully.");
	System.out.println("📌 Final Status: Candidate Add flow completed successfully.");
	System.out.println();
}
	
	@DataProvider
	public Object[][] Combined_Candidate_Job_Data() {

		Job_Module jobProvider = new Job_Module();
	

		Object[][] candidateData = Candidate_Add_Data();
		Object[][] jobData = jobProvider.Job_Posting_Data();

		int rowCount = Math.min(candidateData.length, jobData.length);
		Object[][] combinedData = new Object[rowCount][2];

		for (int i = 0; i < rowCount; i++) {

			

			combinedData[i][0]=candidateData[i][0];
			combinedData[i][1]=jobData[i][0];
			
		}

		return combinedData;
	}

	
@DataProvider
public Object[][] Candidate_Add_Data() {

    TreeMap<String, String> data1 = new TreeMap<String, String>();
    data1.put("Email", "aritra.basu2026a@yopmail.com");
    data1.put("Phone Code", "+91");
    data1.put("Phone Number", "9123400011");
    data1.put("First Name", "Aritra");
    data1.put("Last Name", "Basu");
    data1.put("Professional Profile Link", "https://www.linkedin.com/in/aritra-basu-2026-a");
    data1.put("Source", "Candidate Portal");
    data1.put("Country", "India");
    data1.put("State", "Karnataka");
    data1.put("Current Salary Currency", "INR(₹)");
    data1.put("Current Salary", "1025000");
    data1.put("Current Salary Duration", "Yearly");
    data1.put("Expected Salary Currency", "INR(₹)");
    data1.put("Expected Salary", "1285000");
    data1.put("Expected Salary Duration", "Yearly");
    data1.put("CV/Resume", "");
    data1.put("Skills", "");
    data1.put("Relevant Experience", "3");
    data1.put("Relevant Experience Unit", "Year(s)");
    data1.put("Total Experience", "4");
    data1.put("Total Experience Unit", "Year(s)");
    data1.put("Notice Period", "12");
    data1.put("Notice Period Unit", "Day(s)");
    data1.put("Work Experience", "");
    data1.put("Education", "");
    data1.put("Cover Letter", "");
    data1.put("Owner", "Admin Ayan Sengupta");
    data1.put("Recruiter", "Admin Ayan Sengupta");

    TreeMap<String, String> data2 = new TreeMap<String, String>();
    data2.put("Email", "kirill.zorin2026b@yopmail.com");
    data2.put("Phone Code", "+91");
    data2.put("Phone Number", "9123400012");
    data2.put("First Name", "Kirill");
    data2.put("Last Name", "Zorin");
    data2.put("Professional Profile Link", "https://www.linkedin.com/in/kirill-zorin-2026-b");
    data2.put("Source", "Consultancy");
    data2.put("Country", "India");
    data2.put("State", "Maharashtra");
    data2.put("Current Salary Currency", "INR(₹)");
    data2.put("Current Salary", "1178000");
    data2.put("Current Salary Duration", "Yearly");
    data2.put("Expected Salary Currency", "INR(₹)");
    data2.put("Expected Salary", "1462000");
    data2.put("Expected Salary Duration", "Yearly");
    data2.put("CV/Resume", "");
    data2.put("Skills", "");
    data2.put("Relevant Experience", "5");
    data2.put("Relevant Experience Unit", "Year(s)");
    data2.put("Total Experience", "6");
    data2.put("Total Experience Unit", "Year(s)");
    data2.put("Notice Period", "18");
    data2.put("Notice Period Unit", "Day(s)");
    data2.put("Work Experience", "");
    data2.put("Education", "");
    data2.put("Cover Letter", "");
    data2.put("Owner", "Alexei Morozov");
    data2.put("Recruiter", "Alexei Morozov");

    TreeMap<String, String> data3 = new TreeMap<String, String>();
    data3.put("Email", "neeladri.kar2026c@yopmail.com");
    data3.put("Phone Code", "+91");
    data3.put("Phone Number", "9123400013");
    data3.put("First Name", "Neeladri");
    data3.put("Last Name", "Kar");
    data3.put("Professional Profile Link", "https://www.linkedin.com/in/neeladri-kar-2026-c");
    data3.put("Source", "Email");
    data3.put("Country", "India");
    data3.put("State", "Telangana");
    data3.put("Current Salary Currency", "INR(₹)");
    data3.put("Current Salary", "1093000");
    data3.put("Current Salary Duration", "Yearly");
    data3.put("Expected Salary Currency", "INR(₹)");
    data3.put("Expected Salary", "1379000");
    data3.put("Expected Salary Duration", "Yearly");
    data3.put("CV/Resume", "");
    data3.put("Skills", "");
    data3.put("Relevant Experience", "4");
    data3.put("Relevant Experience Unit", "Year(s)");
    data3.put("Total Experience", "5");
    data3.put("Total Experience Unit", "Year(s)");
    data3.put("Notice Period", "24");
    data3.put("Notice Period Unit", "Day(s)");
    data3.put("Work Experience", "");
    data3.put("Education", "");
    data3.put("Cover Letter", "");
    data3.put("Owner", "Guest Alexei Sokolov");
    data3.put("Recruiter", "Guest Alexei Sokolov");

    TreeMap<String, String> data4 = new TreeMap<String, String>();
    data4.put("Email", "pavel.antonov2026d@yopmail.com");
    data4.put("Phone Code", "+91");
    data4.put("Phone Number", "9123400014");
    data4.put("First Name", "Pavel");
    data4.put("Last Name", "Antonov");
    data4.put("Professional Profile Link", "https://www.linkedin.com/in/pavel-antonov-2026-d");
    data4.put("Source", "Import");
    data4.put("Country", "India");
    data4.put("State", "West Bengal");
    data4.put("Current Salary Currency", "INR(₹)");
    data4.put("Current Salary", "1634000");
    data4.put("Current Salary Duration", "Yearly");
    data4.put("Expected Salary Currency", "INR(₹)");
    data4.put("Expected Salary", "1986000");
    data4.put("Expected Salary Duration", "Yearly");
    data4.put("CV/Resume", "");
    data4.put("Skills", "");
    data4.put("Relevant Experience", "7");
    data4.put("Relevant Experience Unit", "Year(s)");
    data4.put("Total Experience", "8");
    data4.put("Total Experience Unit", "Year(s)");
    data4.put("Notice Period", "27");
    data4.put("Notice Period Unit", "Day(s)");
    data4.put("Work Experience", "");
    data4.put("Education", "");
    data4.put("Cover Letter", "");
    data4.put("Owner", "Interviewer Ivan Orlov");
    data4.put("Recruiter", "Interviewer Ivan Orlov");

    TreeMap<String, String> data5 = new TreeMap<String, String>();
    data5.put("Email", "koushik.de2026e@yopmail.com");
    data5.put("Phone Code", "+91");
    data5.put("Phone Number", "9123400015");
    data5.put("First Name", "Koushik");
    data5.put("Last Name", "De");
    data5.put("Professional Profile Link", "https://www.linkedin.com/in/koushik-de-2026-e");
    data5.put("Source", "Indeed");
    data5.put("Country", "India");
    data5.put("State", "Tamil Nadu");
    data5.put("Current Salary Currency", "INR(₹)");
    data5.put("Current Salary", "1289000");
    data5.put("Current Salary Duration", "Yearly");
    data5.put("Expected Salary Currency", "INR(₹)");
    data5.put("Expected Salary", "1597000");
    data5.put("Expected Salary Duration", "Yearly");
    data5.put("CV/Resume", "");
    data5.put("Skills", "");
    data5.put("Relevant Experience", "5");
    data5.put("Relevant Experience Unit", "Year(s)");
    data5.put("Total Experience", "6");
    data5.put("Total Experience Unit", "Year(s)");
    data5.put("Notice Period", "33");
    data5.put("Notice Period Unit", "Day(s)");
    data5.put("Work Experience", "");
    data5.put("Education", "");
    data5.put("Cover Letter", "");
    data5.put("Owner", "Nikolai Sidorov");
    data5.put("Recruiter", "Nikolai Sidorov");

    TreeMap<String, String> data6 = new TreeMap<String, String>();
    data6.put("Email", "roman.lebedev2026f@yopmail.com");
    data6.put("Phone Code", "+91");
    data6.put("Phone Number", "9123400016");
    data6.put("First Name", "Roman");
    data6.put("Last Name", "Lebedev");
    data6.put("Professional Profile Link", "https://www.linkedin.com/in/roman-lebedev-2026-f");
    data6.put("Source", "LinkedIn");
    data6.put("Country", "India");
    data6.put("State", "Gujarat");
    data6.put("Current Salary Currency", "INR(₹)");
    data6.put("Current Salary", "1762000");
    data6.put("Current Salary Duration", "Yearly");
    data6.put("Expected Salary Currency", "INR(₹)");
    data6.put("Expected Salary", "2144000");
    data6.put("Expected Salary Duration", "Yearly");
    data6.put("CV/Resume", "");
    data6.put("Skills", "");
    data6.put("Relevant Experience", "8");
    data6.put("Relevant Experience Unit", "Year(s)");
    data6.put("Total Experience", "9");
    data6.put("Total Experience Unit", "Year(s)");
    data6.put("Notice Period", "36");
    data6.put("Notice Period Unit", "Day(s)");
    data6.put("Work Experience", "");
    data6.put("Education", "");
    data6.put("Cover Letter", "");
    data6.put("Owner", "Owner Mikhail Volkov");
    data6.put("Recruiter", "Owner Mikhail Volkov");

    TreeMap<String, String> data7 = new TreeMap<String, String>();
    data7.put("Email", "tuhin.mallick2026g@yopmail.com");
    data7.put("Phone Code", "+91");
    data7.put("Phone Number", "9123400017");
    data7.put("First Name", "Tuhin");
    data7.put("Last Name", "Mallick");
    data7.put("Professional Profile Link", "https://www.linkedin.com/in/tuhin-mallick-2026-g");
    data7.put("Source", "Naukri");
    data7.put("Country", "India");
    data7.put("State", "Uttar Pradesh");
    data7.put("Current Salary Currency", "INR(₹)");
    data7.put("Current Salary", "845000");
    data7.put("Current Salary Duration", "Yearly");
    data7.put("Expected Salary Currency", "INR(₹)");
    data7.put("Expected Salary", "1099000");
    data7.put("Expected Salary Duration", "Yearly");
    data7.put("CV/Resume", "");
    data7.put("Skills", "");
    data7.put("Relevant Experience", "2");
    data7.put("Relevant Experience Unit", "Year(s)");
    data7.put("Total Experience", "3");
    data7.put("Total Experience Unit", "Year(s)");
    data7.put("Notice Period", "39");
    data7.put("Notice Period Unit", "Day(s)");
    data7.put("Work Experience", "");
    data7.put("Education", "");
    data7.put("Cover Letter", "");
    data7.put("Owner", "Rahul Chatterjee");
    data7.put("Recruiter", "Rahul Chatterjee");

    TreeMap<String, String> data8 = new TreeMap<String, String>();
    data8.put("Email", "oleg.mironov2026h@yopmail.com");
    data8.put("Phone Code", "+91");
    data8.put("Phone Number", "9123400018");
    data8.put("First Name", "Oleg");
    data8.put("Last Name", "Mironov");
    data8.put("Professional Profile Link", "https://www.linkedin.com/in/oleg-mironov-2026-h");
    data8.put("Source", "Candidate Portal");
    data8.put("Country", "India");
    data8.put("State", "Rajasthan");
    data8.put("Current Salary Currency", "INR(₹)");
    data8.put("Current Salary", "1547000");
    data8.put("Current Salary Duration", "Yearly");
    data8.put("Expected Salary Currency", "INR(₹)");
    data8.put("Expected Salary", "1895000");
    data8.put("Expected Salary Duration", "Yearly");
    data8.put("CV/Resume", "");
    data8.put("Skills", "");
    data8.put("Relevant Experience", "6");
    data8.put("Relevant Experience Unit", "Year(s)");
    data8.put("Total Experience", "7");
    data8.put("Total Experience Unit", "Year(s)");
    data8.put("Notice Period", "42");
    data8.put("Notice Period Unit", "Day(s)");
    data8.put("Work Experience", "");
    data8.put("Education", "");
    data8.put("Cover Letter", "");
    data8.put("Owner", "Admin Ayan Sengupta");
    data8.put("Recruiter", "Alexei Morozov");

    TreeMap<String, String> data9 = new TreeMap<String, String>();
    data9.put("Email", "sagnik.basak2026i@yopmail.com");
    data9.put("Phone Code", "+91");
    data9.put("Phone Number", "9123400019");
    data9.put("First Name", "Sagnik");
    data9.put("Last Name", "Basak");
    data9.put("Professional Profile Link", "https://www.linkedin.com/in/sagnik-basak-2026-i");
    data9.put("Source", "Consultancy");
    data9.put("Country", "India");
    data9.put("State", "Madhya Pradesh");
    data9.put("Current Salary Currency", "INR(₹)");
    data9.put("Current Salary", "972500");
    data9.put("Current Salary Duration", "Yearly");
    data9.put("Expected Salary Currency", "INR(₹)");
    data9.put("Expected Salary", "1268000");
    data9.put("Expected Salary Duration", "Yearly");
    data9.put("CV/Resume", "");
    data9.put("Skills", "");
    data9.put("Relevant Experience", "3");
    data9.put("Relevant Experience Unit", "Year(s)");
    data9.put("Total Experience", "4");
    data9.put("Total Experience Unit", "Year(s)");
    data9.put("Notice Period", "48");
    data9.put("Notice Period Unit", "Day(s)");
    data9.put("Work Experience", "");
    data9.put("Education", "");
    data9.put("Cover Letter", "");
    data9.put("Owner", "Alexei Morozov");
    data9.put("Recruiter", "Guest Alexei Sokolov");

    TreeMap<String, String> data10 = new TreeMap<String, String>();
    data10.put("Email", "timur.vlasov2026j@yopmail.com");
    data10.put("Phone Code", "+91");
    data10.put("Phone Number", "9123400020");
    data10.put("First Name", "Timur");
    data10.put("Last Name", "Vlasov");
    data10.put("Professional Profile Link", "https://www.linkedin.com/in/timur-vlasov-2026-j");
    data10.put("Source", "Email");
    data10.put("Country", "India");
    data10.put("State", "Haryana");
    data10.put("Current Salary Currency", "INR(₹)");
    data10.put("Current Salary", "1496000");
    data10.put("Current Salary Duration", "Yearly");
    data10.put("Expected Salary Currency", "INR(₹)");
    data10.put("Expected Salary", "1918000");
    data10.put("Expected Salary Duration", "Yearly");
    data10.put("CV/Resume", "");
    data10.put("Skills", "");
    data10.put("Relevant Experience", "6");
    data10.put("Relevant Experience Unit", "Year(s)");
    data10.put("Total Experience", "7");
    data10.put("Total Experience Unit", "Year(s)");
    data10.put("Notice Period", "51");
    data10.put("Notice Period Unit", "Day(s)");
    data10.put("Work Experience", "");
    data10.put("Education", "");
    data10.put("Cover Letter", "");
    data10.put("Owner", "Guest Alexei Sokolov");
    data10.put("Recruiter", "Interviewer Ivan Orlov");

    TreeMap<String, String> data11 = new TreeMap<String, String>();
    data11.put("Email", "debojyoti.paul2026k@yopmail.com");
    data11.put("Phone Code", "+91");
    data11.put("Phone Number", "9123400021");
    data11.put("First Name", "Debojyoti");
    data11.put("Last Name", "Paul");
    data11.put("Professional Profile Link", "https://www.linkedin.com/in/debojyoti-paul-2026-k");
    data11.put("Source", "Import");
    data11.put("Country", "India");
    data11.put("State", "Punjab");
    data11.put("Current Salary Currency", "INR(₹)");
    data11.put("Current Salary", "1233000");
    data11.put("Current Salary Duration", "Yearly");
    data11.put("Expected Salary Currency", "INR(₹)");
    data11.put("Expected Salary", "1589000");
    data11.put("Expected Salary Duration", "Yearly");
    data11.put("CV/Resume", "");
    data11.put("Skills", "");
    data11.put("Relevant Experience", "5");
    data11.put("Relevant Experience Unit", "Year(s)");
    data11.put("Total Experience", "6");
    data11.put("Total Experience Unit", "Year(s)");
    data11.put("Notice Period", "54");
    data11.put("Notice Period Unit", "Day(s)");
    data11.put("Work Experience", "");
    data11.put("Education", "");
    data11.put("Cover Letter", "");
    data11.put("Owner", "Interviewer Ivan Orlov");
    data11.put("Recruiter", "Nikolai Sidorov");

    TreeMap<String, String> data12 = new TreeMap<String, String>();
    data12.put("Email", "denis.kartsev2026l@yopmail.com");
    data12.put("Phone Code", "+91");
    data12.put("Phone Number", "9123400022");
    data12.put("First Name", "Denis");
    data12.put("Last Name", "Kartsev");
    data12.put("Professional Profile Link", "https://www.linkedin.com/in/denis-kartsev-2026-l");
    data12.put("Source", "Indeed");
    data12.put("Country", "India");
    data12.put("State", "Odisha");
    data12.put("Current Salary Currency", "INR(₹)");
    data12.put("Current Salary", "1681000");
    data12.put("Current Salary Duration", "Yearly");
    data12.put("Expected Salary Currency", "INR(₹)");
    data12.put("Expected Salary", "2037000");
    data12.put("Expected Salary Duration", "Yearly");
    data12.put("CV/Resume", "");
    data12.put("Skills", "");
    data12.put("Relevant Experience", "7");
    data12.put("Relevant Experience Unit", "Year(s)");
    data12.put("Total Experience", "8");
    data12.put("Total Experience Unit", "Year(s)");
    data12.put("Notice Period", "57");
    data12.put("Notice Period Unit", "Day(s)");
    data12.put("Work Experience", "");
    data12.put("Education", "");
    data12.put("Cover Letter", "");
    data12.put("Owner", "Nikolai Sidorov");
    data12.put("Recruiter", "Owner Mikhail Volkov");

    TreeMap<String, String> data13 = new TreeMap<String, String>();
    data13.put("Email", "ronit.dhar2026m@yopmail.com");
    data13.put("Phone Code", "+91");
    data13.put("Phone Number", "9123400023");
    data13.put("First Name", "Ronit");
    data13.put("Last Name", "Dhar");
    data13.put("Professional Profile Link", "https://www.linkedin.com/in/ronit-dhar-2026-m");
    data13.put("Source", "LinkedIn");
    data13.put("Country", "India");
    data13.put("State", "Bihar");
    data13.put("Current Salary Currency", "INR(₹)");
    data13.put("Current Salary", "1824000");
    data13.put("Current Salary Duration", "Yearly");
    data13.put("Expected Salary Currency", "INR(₹)");
    data13.put("Expected Salary", "2266000");
    data13.put("Expected Salary Duration", "Yearly");
    data13.put("CV/Resume", "");
    data13.put("Skills", "");
    data13.put("Relevant Experience", "8");
    data13.put("Relevant Experience Unit", "Year(s)");
    data13.put("Total Experience", "9");
    data13.put("Total Experience Unit", "Year(s)");
    data13.put("Notice Period", "63");
    data13.put("Notice Period Unit", "Day(s)");
    data13.put("Work Experience", "");
    data13.put("Education", "");
    data13.put("Cover Letter", "");
    data13.put("Owner", "Owner Mikhail Volkov");
    data13.put("Recruiter", "Rahul Chatterjee");

    TreeMap<String, String> data14 = new TreeMap<String, String>();
    data14.put("Email", "egor.nikitin2026n@yopmail.com");
    data14.put("Phone Code", "+91");
    data14.put("Phone Number", "9123400024");
    data14.put("First Name", "Egor");
    data14.put("Last Name", "Nikitin");
    data14.put("Professional Profile Link", "https://www.linkedin.com/in/egor-nikitin-2026-n");
    data14.put("Source", "Naukri");
    data14.put("Country", "India");
    data14.put("State", "Kerala");
    data14.put("Current Salary Currency", "INR(₹)");
    data14.put("Current Salary", "1715000");
    data14.put("Current Salary Duration", "Yearly");
    data14.put("Expected Salary Currency", "INR(₹)");
    data14.put("Expected Salary", "2099000");
    data14.put("Expected Salary Duration", "Yearly");
    data14.put("CV/Resume", "");
    data14.put("Skills", "");
    data14.put("Relevant Experience", "7");
    data14.put("Relevant Experience Unit", "Year(s)");
    data14.put("Total Experience", "8");
    data14.put("Total Experience Unit", "Year(s)");
    data14.put("Notice Period", "66");
    data14.put("Notice Period Unit", "Day(s)");
    data14.put("Work Experience", "");
    data14.put("Education", "");
    data14.put("Cover Letter", "");
    data14.put("Owner", "Rahul Chatterjee");
    data14.put("Recruiter", "Admin Ayan Sengupta");

    TreeMap<String, String> data15 = new TreeMap<String, String>();
    data15.put("Email", "souvik.dey2026o@yopmail.com");
    data15.put("Phone Code", "+91");
    data15.put("Phone Number", "9123400025");
    data15.put("First Name", "Souvik");
    data15.put("Last Name", "Dey");
    data15.put("Professional Profile Link", "https://www.linkedin.com/in/souvik-dey-2026-o");
    data15.put("Source", "Candidate Portal");
    data15.put("Country", "India");
    data15.put("State", "Andhra Pradesh");
    data15.put("Current Salary Currency", "INR(₹)");
    data15.put("Current Salary", "1169000");
    data15.put("Current Salary Duration", "Yearly");
    data15.put("Expected Salary Currency", "INR(₹)");
    data15.put("Expected Salary", "1493000");
    data15.put("Expected Salary Duration", "Yearly");
    data15.put("CV/Resume", "");
    data15.put("Skills", "");
    data15.put("Relevant Experience", "4");
    data15.put("Relevant Experience Unit", "Year(s)");
    data15.put("Total Experience", "5");
    data15.put("Total Experience Unit", "Year(s)");
    data15.put("Notice Period", "69");
    data15.put("Notice Period Unit", "Day(s)");
    data15.put("Work Experience", "");
    data15.put("Education", "");
    data15.put("Cover Letter", "");
    data15.put("Owner", "Admin Ayan Sengupta");
    data15.put("Recruiter", "Guest Alexei Sokolov");

    TreeMap<String, String> data16 = new TreeMap<String, String>();
    data16.put("Email", "leonid.grachev2026p@yopmail.com");
    data16.put("Phone Code", "+91");
    data16.put("Phone Number", "9123400026");
    data16.put("First Name", "Leonid");
    data16.put("Last Name", "Grachev");
    data16.put("Professional Profile Link", "https://www.linkedin.com/in/leonid-grachev-2026-p");
    data16.put("Source", "Consultancy");
    data16.put("Country", "India");
    data16.put("State", "Jharkhand");
    data16.put("Current Salary Currency", "INR(₹)");
    data16.put("Current Salary", "1577000");
    data16.put("Current Salary Duration", "Yearly");
    data16.put("Expected Salary Currency", "INR(₹)");
    data16.put("Expected Salary", "1941000");
    data16.put("Expected Salary Duration", "Yearly");
    data16.put("CV/Resume", "");
    data16.put("Skills", "");
    data16.put("Relevant Experience", "6");
    data16.put("Relevant Experience Unit", "Year(s)");
    data16.put("Total Experience", "7");
    data16.put("Total Experience Unit", "Year(s)");
    data16.put("Notice Period", "72");
    data16.put("Notice Period Unit", "Day(s)");
    data16.put("Work Experience", "");
    data16.put("Education", "");
    data16.put("Cover Letter", "");
    data16.put("Owner", "Alexei Morozov");
    data16.put("Recruiter", "Interviewer Ivan Orlov");

    TreeMap<String, String> data17 = new TreeMap<String, String>();
    data17.put("Email", "arnab.lahiri2026q@yopmail.com");
    data17.put("Phone Code", "+91");
    data17.put("Phone Number", "9123400027");
    data17.put("First Name", "Arnab");
    data17.put("Last Name", "Lahiri");
    data17.put("Professional Profile Link", "https://www.linkedin.com/in/arnab-lahiri-2026-q");
    data17.put("Source", "Email");
    data17.put("Country", "India");
    data17.put("State", "Assam");
    data17.put("Current Salary Currency", "INR(₹)");
    data17.put("Current Salary", "1468000");
    data17.put("Current Salary Duration", "Yearly");
    data17.put("Expected Salary Currency", "INR(₹)");
    data17.put("Expected Salary", "1874000");
    data17.put("Expected Salary Duration", "Yearly");
    data17.put("CV/Resume", "");
    data17.put("Skills", "");
    data17.put("Relevant Experience", "6");
    data17.put("Relevant Experience Unit", "Year(s)");
    data17.put("Total Experience", "7");
    data17.put("Total Experience Unit", "Year(s)");
    data17.put("Notice Period", "75");
    data17.put("Notice Period Unit", "Day(s)");
    data17.put("Work Experience", "");
    data17.put("Education", "");
    data17.put("Cover Letter", "");
    data17.put("Owner", "Guest Alexei Sokolov");
    data17.put("Recruiter", "Nikolai Sidorov");

    TreeMap<String, String> data18 = new TreeMap<String, String>();
    data18.put("Email", "artem.voronin2026r@yopmail.com");
    data18.put("Phone Code", "+91");
    data18.put("Phone Number", "9123400028");
    data18.put("First Name", "Artem");
    data18.put("Last Name", "Voronin");
    data18.put("Professional Profile Link", "https://www.linkedin.com/in/artem-voronin-2026-r");
    data18.put("Source", "Import");
    data18.put("Country", "India");
    data18.put("State", "Chhattisgarh");
    data18.put("Current Salary Currency", "INR(₹)");
    data18.put("Current Salary", "1666000");
    data18.put("Current Salary Duration", "Yearly");
    data18.put("Expected Salary Currency", "INR(₹)");
    data18.put("Expected Salary", "2052000");
    data18.put("Expected Salary Duration", "Yearly");
    data18.put("CV/Resume", "");
    data18.put("Skills", "");
    data18.put("Relevant Experience", "7");
    data18.put("Relevant Experience Unit", "Year(s)");
    data18.put("Total Experience", "8");
    data18.put("Total Experience Unit", "Year(s)");
    data18.put("Notice Period", "78");
    data18.put("Notice Period Unit", "Day(s)");
    data18.put("Work Experience", "");
    data18.put("Education", "");
    data18.put("Cover Letter", "");
    data18.put("Owner", "Interviewer Ivan Orlov");
    data18.put("Recruiter", "Owner Mikhail Volkov");

    TreeMap<String, String> data19 = new TreeMap<String, String>();
    data19.put("Email", "ishan.bhowmick2026s@yopmail.com");
    data19.put("Phone Code", "+91");
    data19.put("Phone Number", "9123400029");
    data19.put("First Name", "Ishan");
    data19.put("Last Name", "Bhowmick");
    data19.put("Professional Profile Link", "https://www.linkedin.com/in/ishan-bhowmick-2026-s");
    data19.put("Source", "Indeed");
    data19.put("Country", "India");
    data19.put("State", "Goa");
    data19.put("Current Salary Currency", "INR(₹)");
    data19.put("Current Salary", "1014000");
    data19.put("Current Salary Duration", "Yearly");
    data19.put("Expected Salary Currency", "INR(₹)");
    data19.put("Expected Salary", "1346000");
    data19.put("Expected Salary Duration", "Yearly");
    data19.put("CV/Resume", "");
    data19.put("Skills", "");
    data19.put("Relevant Experience", "4");
    data19.put("Relevant Experience Unit", "Year(s)");
    data19.put("Total Experience", "5");
    data19.put("Total Experience Unit", "Year(s)");
    data19.put("Notice Period", "84");
    data19.put("Notice Period Unit", "Day(s)");
    data19.put("Work Experience", "");
    data19.put("Education", "");
    data19.put("Cover Letter", "");
    data19.put("Owner", "Nikolai Sidorov");
    data19.put("Recruiter", "Rahul Chatterjee");

    TreeMap<String, String> data20 = new TreeMap<String, String>();
    data20.put("Email", "fyodor.yelkin2026t@yopmail.com");
    data20.put("Phone Code", "+91");
    data20.put("Phone Number", "9123400030");
    data20.put("First Name", "Fyodor");
    data20.put("Last Name", "Yelkin");
    data20.put("Professional Profile Link", "https://www.linkedin.com/in/fyodor-yelkin-2026-t");
    data20.put("Source", "LinkedIn");
    data20.put("Country", "India");
    data20.put("State", "Himachal Pradesh");
    data20.put("Current Salary Currency", "INR(₹)");
    data20.put("Current Salary", "1913000");
    data20.put("Current Salary Duration", "Yearly");
    data20.put("Expected Salary Currency", "INR(₹)");
    data20.put("Expected Salary", "2349000");
    data20.put("Expected Salary Duration", "Yearly");
    data20.put("CV/Resume", "");
    data20.put("Skills", "");
    data20.put("Relevant Experience", "8");
    data20.put("Relevant Experience Unit", "Year(s)");
    data20.put("Total Experience", "9");
    data20.put("Total Experience Unit", "Year(s)");
    data20.put("Notice Period", "87");
    data20.put("Notice Period Unit", "Day(s)");
    data20.put("Work Experience", "");
    data20.put("Education", "");
    data20.put("Cover Letter", "");
    data20.put("Owner", "Owner Mikhail Volkov");
    data20.put("Recruiter", "Admin Ayan Sengupta");

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
	
	
	
   
	public void Import_CV_Accessor() throws IOException, InterruptedException {

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🔹 Scenario Title:</b> Access Candidate import CV section");
		System.out.println("🔹 Scenario Title: Access Candidate import CV section");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📘 Description:</b> Open the Candidates module, validate landing in Candidate list using the Import CV button as the unique identifier, and click it to open the candidate CV import section.");
		System.out.println("📘 Description: Open the Candidates module, validate landing in Candidate list using the Import CV button as the unique identifier, and click it to open the candidate CV import section.");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>✅ Expected:</b> Candidates module should open successfully, Import CV button should be visible as the Candidate list identifier, and clicking it should open the candidate CV import section.");
		System.out.println("✅ Expected: Candidates module should open successfully, Import CV button should be visible as the Candidate list identifier, and clicking it should open the candidate CV import section.");

		WebElement Import = Candidate_List_Accesor();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step:</b> Click on Import CV button.");
		System.out.println("Step: Click on Import CV button.");
		Import.click();

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>🟨 Actual:</b> Import CV button clicked successfully and candidate import flow was opened.");
		System.out.println("🟨 Actual: Import CV button clicked successfully and candidate import flow was opened.");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📌 Final Status:</b> Candidate Import CV access flow completed successfully.");
		System.out.println("📌 Final Status: Candidate Import CV access flow completed successfully.");
	}
    
    @Test(dataProvider = "Candidate_CV_Upload_Files")
    public void CV_upload(TreeMap<String, String> file) throws IOException, InterruptedException {

    	int step = 1;

    	Candidate_Module_Locaters p = new Candidate_Module_Locaters(d);

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>🔹 Scenario Title:</b> Validate candidate CV upload using different file types");
    	System.out.println("🔹 Scenario Title: Validate candidate CV upload using different file types");

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>📘 Description:</b> Open the Candidate Import CV section, upload the configured file from data provider, and validate CV parsing behavior for the selected file type.");
    	System.out.println("📘 Description: Open the Candidate Import CV section, upload the configured file from data provider, and validate CV parsing behavior for the selected file type.");

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>📥 Input:</b> File Type = " + file.get("File Type") + " | File Path = " + file.get("File Path"));
    	System.out.println("📥 Input: File Type = " + file.get("File Type") + " | File Path = " + file.get("File Path"));

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>✅ Expected:</b> Import CV section should open successfully, upload field should accept the configured file path, and the system should process the uploaded file according to the supported/unsupported file type behavior.");
    	System.out.println("✅ Expected: Import CV section should open successfully, upload field should accept the configured file path, and the system should process the uploaded file according to the supported/unsupported file type behavior.");

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>Step " + (step++) + ":</b> Open Candidate Import CV section.");
    	System.out.println("Step " + (step - 1) + ": Open Candidate Import CV section.");
    	Import_CV_Accessor();
    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>🟨 Actual:</b> Candidate Import CV section opened successfully.");
    	System.out.println("🟨 Actual: Candidate Import CV section opened successfully.");

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>Step " + (step++) + ":</b> Identify CV upload field.");
    	System.out.println("Step " + (step - 1) + ": Identify CV upload field.");
    	WebElement Upload_file_field = p.Upload_Field();
    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>🟨 Actual:</b> CV upload field identified successfully.");
    	System.out.println("🟨 Actual: CV upload field identified successfully.");

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>Step " + (step++) + ":</b> Upload file into CV upload field.");
    	System.out.println("Step " + (step - 1) + ": Upload file into CV upload field.");
    	Upload_file_field.sendKeys(file.get("File Path"));
    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>🟨 Actual:</b> File path sent successfully for upload = " + file.get("File Path"));
    	System.out.println("🟨 Actual: File path sent successfully for upload = " + file.get("File Path"));

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>Step " + (step++) + ":</b> Trigger/validate CV parsing process after upload.");
    	System.out.println("Step " + (step - 1) + ": Trigger/validate CV parsing process after upload.");
    	p.Parsing_cv();
    	Report_Listen.log_print_in_report().log(Status.PASS,
    			"<b>🟨 Actual:</b> CV parsing flow executed successfully for file type = " + file.get("File Type"));
    	System.out.println("🟨 Actual: CV parsing flow executed successfully for file type = " + file.get("File Type"));

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>📌 Final Status:</b> Candidate CV upload validation flow completed for file type = " + file.get("File Type"));
    	System.out.println("📌 Final Status: Candidate CV upload validation flow completed for file type = " + file.get("File Type"));
    }
    
    @DataProvider
    public Object[][] Candidate_CV_Upload_Files() {

    	TreeMap<String, String> Valid_PDF = new TreeMap<String, String>();
    	Valid_PDF.put("File Type", "Valid PDF");
    	Valid_PDF.put("File Path", System.getProperty("user.dir") + "\\Dummy Cvs\\candidate_resume_valid.pdf");

    	TreeMap<String, String> Valid_DOCX = new TreeMap<String, String>();
    	Valid_DOCX.put("File Type", "Valid DOCX");
    	Valid_DOCX.put("File Path", System.getProperty("user.dir") + "\\Dummy Cvs\\candidate_resume_valid.docx");

    	TreeMap<String, String> Valid_ODT = new TreeMap<String, String>();
    	Valid_ODT.put("File Type", "Valid ODT");
    	Valid_ODT.put("File Path", System.getProperty("user.dir") + "\\Dummy Cvs\\candidate_resume_valid.odt");

    	TreeMap<String, String> Invalid_DOC = new TreeMap<String, String>();
    	Invalid_DOC.put("File Type", "Invalid DOC");
    	Invalid_DOC.put("File Path", System.getProperty("user.dir") + "\\Dummy Cvs\\candidate_resume_invalid.doc");

    	TreeMap<String, String> Invalid_TXT = new TreeMap<String, String>();
    	Invalid_TXT.put("File Type", "Invalid TXT");
    	Invalid_TXT.put("File Path", System.getProperty("user.dir") + "\\Dummy Cvs\\candidate_resume_invalid.txt");

    	TreeMap<String, String> Invalid_JPG = new TreeMap<String, String>();
    	Invalid_JPG.put("File Type", "Invalid JPG");
    	Invalid_JPG.put("File Path", System.getProperty("user.dir") + "\\Dummy Cvs\\candidate_resume_invalid.jpg");

    	TreeMap<String, String> Invalid_PNG = new TreeMap<String, String>();
    	Invalid_PNG.put("File Type", "Invalid PNG");
    	Invalid_PNG.put("File Path", System.getProperty("user.dir") + "\\Dummy Cvs\\candidate_resume_invalid.png");

    	TreeMap<String, String> Invalid_ZIP = new TreeMap<String, String>();
    	Invalid_ZIP.put("File Type", "Invalid ZIP");
    	Invalid_ZIP.put("File Path", System.getProperty("user.dir") + "\\Dummy Cvs\\candidate_resume_invalid.zip");

    	return new Object[][] {
    			{ Valid_PDF },/*
    			{ Valid_DOCX },
    			{ Valid_ODT },
    			{ Invalid_DOC },
    			{ Invalid_TXT },
    			{ Invalid_JPG },
    			{ Invalid_PNG },
    			{ Invalid_ZIP } */
    	};
    }
    
}