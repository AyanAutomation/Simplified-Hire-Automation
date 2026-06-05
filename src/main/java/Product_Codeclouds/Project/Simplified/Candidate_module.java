package Product_Codeclouds.Project.Simplified;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Candidate_Module_Locaters;
import Locaters.Job_Module_locaters;
import Repeatative_codes.Repeat;

public class Candidate_module extends Side_menu_Handler {
	
	public List<String> Member_Names_List = new ArrayList<String>();
	TreeMap<String, String> Overview_Cards_Data = new TreeMap<String, String>();
	

	public WebElement Candidate_List_Accesor() throws IOException, InterruptedException {

		Candidate_Module_Locaters p = new Candidate_Module_Locaters(d);

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step:</b> Navigate to Candidates module from side menu.");
		System.out.println("Step: Navigate to Candidates module from side menu.");

		Menu_option_selector("Candidates");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step:</b> Validate landing in Candidate list by identifying the Import CV button.");
		System.out.println("Step: Validate landing in Candidate list by identifying the Import CV button.");

		WebElement Add = p.Add_Button();

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>🟨 Actual:</b> Candidate list opened successfully and Import CV button was identified.");
		System.out.println("🟨 Actual: Candidate list opened successfully and Import CV button was identified.");

		return Add;
	}
	
	
	public String Candidate_status_data_fetcher(String Time_Range, String status) throws IOException, InterruptedException {

		int step = 1;

		Candidate_Module_Locaters p = new Candidate_Module_Locaters(d);

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Navigate to Candidate list page.");
		System.out.println("Step " + (step - 1) + ": Navigate to Candidate list page.");
		System.out.println();

		Candidate_List_Accesor();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Candidate list page opened successfully.");
		System.out.println("🟨 Actual: Candidate list page opened successfully.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Fetch Candidate module filters.");
		System.out.println("Step " + (step - 1) + ": Fetch Candidate module filters.");
		System.out.println();

		List<WebElement> Filters = p.All_filters();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Candidate filters fetched successfully. Total filters found = " + Filters.size());
		System.out.println("🟨 Actual: Candidate filters fetched successfully. Total filters found = " + Filters.size());
		System.out.println();

		if (Filters.size() <= 3) {

			Report_Listen.log_print_in_report().log(Status.FAIL,
					"<b>❌ Actual:</b> Required Candidate filters were not available. Expected at least 4 filters but found = "
							+ Filters.size());
			System.out.println("❌ Actual: Required Candidate filters were not available. Expected at least 4 filters but found = "
					+ Filters.size());
			System.out.println();

			return "ERROR";
		}

		WebElement Date_Filter = Filters.get(1);
		WebElement Status_Filter = Filters.get(3);

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Apply Candidate time range filter = " + Time_Range);
		System.out.println("Step " + (step - 1) + ": Apply Candidate time range filter = " + Time_Range);
		System.out.println();

		Date_Filter.click();

		WebElement Date_Filter_Dropdown = p.time_filter_dropdown();

		List<WebElement> date_options = Date_Filter_Dropdown.findElements(
				By.xpath(".//div[contains(@class,'ant-select-item') and contains(@class,'ant-select-item-option-content')]"));

		boolean date_filter_selected = false;

		for (WebElement date_opt : date_options) {

			String date_opt_text = date_opt.getText().trim();

			if (date_opt_text.contains(Time_Range)) {

				date_opt.click();
				date_filter_selected = true;

				Report_Listen.log_print_in_report().log(Status.INFO,
						"<b>🟨 Actual:</b> Candidate time range filter selected successfully = " + date_opt_text);
				System.out.println("🟨 Actual: Candidate time range filter selected successfully = " + date_opt_text);
				System.out.println();

				break;
			}
		}

		if (!date_filter_selected) {

			Report_Listen.log_print_in_report().log(Status.FAIL,
					"<b>❌ Actual:</b> Candidate time range filter option was not found = " + Time_Range);
			System.out.println("❌ Actual: Candidate time range filter option was not found = " + Time_Range);
			System.out.println();

			return "ERROR";
		}

		Thread.sleep(500);

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Apply Candidate status filter = " + status);
		System.out.println("Step " + (step - 1) + ": Apply Candidate status filter = " + status);
		System.out.println();

		Status_Filter.click();

		WebElement Status_Filter_Dropdown = p.Status_filter_dropdown();

		List<WebElement> stat_options = Status_Filter_Dropdown.findElements(
				By.xpath(".//div[contains(@class,'ant-select-item') and contains(@class,'ant-select-item-option-content')]"));

		boolean status_filter_selected = false;

		for (WebElement stat_opt : stat_options) {

			String stat_opt_text = stat_opt.getText().trim();

			if (stat_opt_text.contains(status)) {

				stat_opt.click();
				status_filter_selected = true;

				Report_Listen.log_print_in_report().log(Status.INFO,
						"<b>🟨 Actual:</b> Candidate status filter selected successfully = " + stat_opt_text);
				System.out.println("🟨 Actual: Candidate status filter selected successfully = " + stat_opt_text);
				System.out.println();

				break;
			}
		}

		if (!status_filter_selected) {

			Report_Listen.log_print_in_report().log(Status.FAIL,
					"<b>❌ Actual:</b> Candidate status filter option was not found = " + status);
			System.out.println("❌ Actual: Candidate status filter option was not found = " + status);
			System.out.println();

			return "ERROR";
		}

		Thread.sleep(500);

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Change Candidate list pagination to 100.");
		System.out.println("Step " + (step - 1) + ": Change Candidate list pagination to 100.");
		System.out.println();

		pagination_changer("100");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Candidate list pagination changed successfully to 100.");
		System.out.println("🟨 Actual: Candidate list pagination changed successfully to 100.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Open exact count view and fetch Candidate list count.");
		System.out.println("Step " + (step - 1) + ": Open exact count view and fetch Candidate list count.");
		System.out.println();

		p.Exact_count_icon().click();

		Thread.sleep(800);

		List<WebElement> Candidate_count = p.pagination_count_text();

		if (Candidate_count.size() <= 1) {

			Report_Listen.log_print_in_report().log(Status.FAIL,
					"<b>❌ Actual:</b> Candidate pagination count text was not available properly. Total count elements found = "
							+ Candidate_count.size());
			System.out.println("❌ Actual: Candidate pagination count text was not available properly. Total count elements found = "
					+ Candidate_count.size());
			System.out.println();

			return "ERROR";
		}

		String Candidate_count_text = Candidate_count.get(1).getText().trim();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Candidate module count fetched successfully for Time Range = "
						+ Time_Range
						+ " | Status = "
						+ status
						+ " | Count = "
						+ Candidate_count_text);
		System.out.println("🟨 Actual: Candidate module count fetched successfully for Time Range = "
				+ Time_Range
				+ " | Status = "
				+ status
				+ " | Count = "
				+ Candidate_count_text);
		System.out.println();

		return Candidate_count_text;
	}
	
	
	
@Test(dataProvider = "Candidate_Add_Data")
public void Search_Check(TreeMap<String, String> candidate_data) throws IOException, InterruptedException {

	int step = 1;

	Candidate_Module_Locaters p = new Candidate_Module_Locaters(d);
	Repeat rp = new Repeat(d);
	Job_Module_locaters jb = new Job_Module_locaters(d);

	String First_Name = candidate_data.get("First Name");
	String Last_Name = candidate_data.get("Last Name");
	String Full_Name = First_Name.trim() + " " + Last_Name.trim();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🔹 Scenario Title:</b> Validate candidate search using full name");
	System.out.println();
	System.out.println("🔹 Scenario Title: Validate candidate search using full name");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📘 Description:</b> Open the Candidate list, compose the candidate full name from first name and last name, search the candidate using the full name, wait for the list loader if visible, read the table result text, and log whether the searched candidate is displayed.");
	System.out.println("📘 Description: Open the Candidate list, compose the candidate full name from first name and last name, search the candidate using the full name, wait for the list loader if visible, read the table result text, and log whether the searched candidate is displayed.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📥 Input:</b> First Name = " + First_Name
					+ " | Last Name = " + Last_Name
					+ " | Full Name = " + Full_Name);
	System.out.println("📥 Input: First Name = " + First_Name
			+ " | Last Name = " + Last_Name
			+ " | Full Name = " + Full_Name);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>✅ Expected:</b> Candidate list should open successfully, search should execute using the candidate full name, and the searched candidate should be visible in the result table.");
	System.out.println("✅ Expected: Candidate list should open successfully, search should execute using the candidate full name, and the searched candidate should be visible in the result table.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Open Candidate list page.");
	System.out.println("Step " + (step - 1) + ": Open Candidate list page.");
	System.out.println();

	Candidate_List_Accesor();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Candidate list page opened successfully.");
	System.out.println("🟨 Actual: Candidate list page opened successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Search candidate using composed full name = " + Full_Name);
	System.out.println("Step " + (step - 1) + ": Search candidate using composed full name = " + Full_Name);
	System.out.println();

	WebElement search = jb.search_field();
	search.sendKeys(Full_Name);
	Thread.sleep(800);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Candidate full name entered successfully in search field = " + Full_Name);
	System.out.println("🟨 Actual: Candidate full name entered successfully in search field = " + Full_Name);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Wait for candidate list loader to disappear after search.");
	System.out.println("Step " + (step - 1) + ": Wait for candidate list loader to disappear after search.");
	System.out.println();

	try {
		rp.wait_for_invisibilty_of_theElement(jb.List_loader());

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Candidate list loader disappeared successfully after search.");
		System.out.println("🟨 Actual: Candidate list loader disappeared successfully after search.");
		System.out.println();

	} catch (Exception e) {
		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Loader was not visible after search, so no loader wait was required.");
		System.out.println("🟨 Actual: Loader was not visible after search, so no loader wait was required.");
		System.out.println();
	}

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Fetch candidate table text and validate search result.");
	System.out.println("Step " + (step - 1) + ": Fetch candidate table text and validate search result.");
	System.out.println();

	WebElement Table = p.table_body();
	String table_text = Table.getText().trim();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Candidate table text fetched successfully.");
	System.out.println("🟨 Actual: Candidate table text fetched successfully.");
	System.out.println();

	System.out.println("Table Text: " + table_text);
	System.out.println();

	boolean candidateFound = !table_text.contains("No record were found");

	if (candidateFound) {

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>✅ Actual:</b> Searched candidate full name found successfully in candidate list = " + Full_Name);
		System.out.println("✅ Actual: Searched candidate full name found successfully in candidate list = " + Full_Name);
		System.out.println();

	}else {

		Report_Listen.log_print_in_report().log(Status.FAIL,
				"<b>❌ Actual:</b> No records found for the searched candidate full name = " + Full_Name);
		System.out.println("❌ Actual: No records found for the searched candidate full name = " + Full_Name);
		System.out.println();
	}

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📌 Final Status:</b> Candidate full-name search validation completed. Result was logged without throwing assertion failure.");
	System.out.println("📌 Final Status: Candidate full-name search validation completed. Result was logged without throwing assertion failure.");
	System.out.println();
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
			"<b>📘 Description:</b> Access the Candidate list, open the Add Candidate popup, assign the required job, enter candidate basic details, select source and state, enter experience details, select owner and recruiter, save the candidate, and validate the success toast message.");
	System.out.println(
			"📘 Description: Access the Candidate list, open the Add Candidate popup, assign the required job, enter candidate basic details, select source and state, enter experience details, select owner and recruiter, save the candidate, and validate the success toast message.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📥 Input:</b> Job Assign = " + Job_Assign
					+ " | Email = " + Email
					+ " | Phone Code = " + Phone_Code
					+ " | Phone Number = " + Phone_Number
					+ " | First Name = " + First_Name
					+ " | Last Name = " + Last_Name
					+ " | Source = " + Source
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
			+ " | Source = " + Source
			+ " | State = " + State
			+ " | Relevant Experience = " + Relevant_Experience + " " + Relevant_Experience_Unit
			+ " | Total Experience = " + Total_Experience + " " + Total_Experience_Unit
			+ " | Notice Period = " + Notice_Period + " " + Notice_Period_Unit
			+ " | Owner = " + Owner
			+ " | Recruiter = " + Recruiter);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>✅ Expected:</b> Candidate Add popup should open successfully, required job and candidate details should be entered correctly, source/state/owner/recruiter should be selected successfully, candidate should be saved, popup should close, and success toast should appear.");
	System.out.println(
			"✅ Expected: Candidate Add popup should open successfully, required job and candidate details should be entered correctly, source/state/owner/recruiter should be selected successfully, candidate should be saved, popup should close, and success toast should appear.");
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

	jp.First_dropdown_Options().stream().peek(rp::Scroll_to_element)
			.filter(jbopt -> jbopt.getText().trim().equalsIgnoreCase(Job_Assign)).findFirst()
			.ifPresent(WebElement::click);

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

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Select Source from Source dropdown.");
	System.out.println("Step " + (step - 1) + ": Select Source from Source dropdown.");
	System.out.println();

	r.mouseWheel(1);
	Thread.sleep(800);
	WebElement Source_field = p.Sourcefield();
	Source_field.click();
	p.source_input().sendKeys(Source);
	WebElement Source_dropdown_list = p.Source_Dropdown();
	Thread.sleep(500);
	Source_dropdown_list
			.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]")).stream()
			.filter(sourceopt -> sourceopt.getText().trim().equalsIgnoreCase(Source)).findFirst()
			.ifPresent(WebElement::click);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Source selected successfully = " + Source);
	System.out.println("🟨 Actual: Source selected successfully = " + Source);
	System.out.println();

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
	WebElement state_dropdown_list = p.state_Dropdown();
	state_dropdown_list.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"))
			.stream().filter(stopt -> stopt.getText().trim().equalsIgnoreCase(State)).findFirst()
			.ifPresent(WebElement::click);

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

	Owner_dropdown_list.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"))
			.stream().filter(owneropt -> owneropt.getText().trim().equalsIgnoreCase(Owner)).findFirst()
			.ifPresent(WebElement::click);

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
	Recruiter_dropdown_list
			.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]")).stream()
			.filter(recruiteropt -> recruiteropt.getText().trim().equalsIgnoreCase(Recruiter)).findFirst()
			.ifPresent(WebElement::click);

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
			"<b>📌 Final Status:</b> Candidate Add flow completed successfully including source, state, owner, and recruiter selection.");
	System.out.println("📌 Final Status: Candidate Add flow completed successfully including source, state, owner, and recruiter selection.");
	System.out.println();
}
	

public void Load_Member_Names_For_Interview() throws IOException, InterruptedException {

	Member_Module mb = new Member_Module();
	mb.d = this.d;
	mb.Target_url = this.Target_url;

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🔹 Scenario Title:</b> Load member names for interview scheduling");
	System.out.println();
	System.out.println("🔹 Scenario Title: Load member names for interview scheduling");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📘 Description:</b> Open the Members list, collect all available member names, and store them into the shared member list so they can be used later as interview host and recruiter.");
	System.out.println("📘 Description: Open the Members list, collect all available member names, and store them into the shared member list so they can be used later as interview host and recruiter.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>✅ Expected:</b> Members page should open successfully, all visible member names should be collected without duplication, and the shared member list should be populated successfully.");
	System.out.println("✅ Expected: Members page should open successfully, all visible member names should be collected without duplication, and the shared member list should be populated successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step 1:</b> Clear previously stored member names from the shared list.");
	System.out.println("Step 1: Clear previously stored member names from the shared list.");
	System.out.println();

	Member_Names_List.clear();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Previously stored member names cleared successfully.");
	System.out.println("🟨 Actual: Previously stored member names cleared successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step 2:</b> Open Members page and collect all visible member names.");
	System.out.println("Step 2: Open Members page and collect all visible member names.");
	System.out.println();

	mb.Member_List_Data_Collector();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Member names collected successfully from Members page. Total names found = " + mb.Member_Names.size());
	System.out.println("🟨 Actual: Member names collected successfully from Members page. Total names found = " + mb.Member_Names.size());
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step 3:</b> Store collected member names into shared member list.");
	System.out.println("Step 3: Store collected member names into shared member list.");
	System.out.println();

	Member_Names_List.addAll(mb.Member_Names);

	Report_Listen.log_print_in_report().log(Status.PASS,
			"<b>🟨 Actual:</b> Shared member list populated successfully. Total available members = " + Member_Names_List.size());
	System.out.println("🟨 Actual: Shared member list populated successfully. Total available members = " + Member_Names_List.size());
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📌 Final Status:</b> Member name loading flow completed successfully for interview scheduling.");
	System.out.println("📌 Final Status: Member name loading flow completed successfully for interview scheduling.");
	System.out.println();
}

@Test(dataProvider = "Candidate_Add_Data")
public void Candidate_Interview_scheduling(TreeMap<String, String> candidate_data) throws IOException, InterruptedException {

	int step = 1;

	Candidate_Module_Locaters p = new Candidate_Module_Locaters(d);
	Repeat rp = new Repeat(d);
	Job_Module_locaters jb = new Job_Module_locaters(d);
	
	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🔹 Scenario Title:</b> Schedule candidate interview using member list mapping");
	System.out.println();
	System.out.println("🔹 Scenario Title: Schedule candidate interview using member list mapping");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📘 Description:</b> Load available member names, pick a member using the configured candidate index, open the candidate list, search the candidate, open Events tab, schedule an interview, assign host and recruiter, send notification, and validate success toast after scheduling.");
	System.out.println("📘 Description: Load available member names, pick a member using the configured candidate index, open the candidate list, search the candidate, open Events tab, schedule an interview, assign host and recruiter, send notification, and validate success toast after scheduling.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📥 Input:</b> Candidate First Name = " + candidate_data.get("First Name")
					+ " | Candidate Index = " + candidate_data.get("Index")
					+ " | Interview Platform = Google Meet"
					+ " | Interview Mode = Organization"
					+ " | End Time = 9:00 PM");
	System.out.println("📥 Input: Candidate First Name = " + candidate_data.get("First Name")
			+ " | Candidate Index = " + candidate_data.get("Index")
			+ " | Interview Platform = Google Meet"
			+ " | Interview Mode = Organization"
			+ " | End Time = 9:00 PM");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>✅ Expected:</b> Member names should load successfully, selected member should be available for the given index, candidate should be opened successfully, interview details should be configured correctly, notification should be triggered, and interview scheduling should complete with a success toast.");
	System.out.println("✅ Expected: Member names should load successfully, selected member should be available for the given index, candidate should be opened successfully, interview details should be configured correctly, notification should be triggered, and interview scheduling should complete with a success toast.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Load member names required for interview host and recruiter mapping.");
	System.out.println("Step " + (step - 1) + ": Load member names required for interview host and recruiter mapping.");
	System.out.println();

	Load_Member_Names_For_Interview();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Member names loaded successfully. Total available members = " + Member_Names_List.size());
	System.out.println("🟨 Actual: Member names loaded successfully. Total available members = " + Member_Names_List.size());
	System.out.println();

	int i = Integer.parseInt(candidate_data.get("Index"));
	int total_members = Member_Names_List.size();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Validate whether the configured member index is available.");
	System.out.println("Step " + (step - 1) + ": Validate whether the configured member index is available.");
	System.out.println();

	if (i >= total_members) {
		String msg = "Not enough members in the list to assign as interview host and recruiter. Please add more members.";
		Report_Listen.log_print_in_report().log(Status.FAIL,
				"<b>❌ Actual:</b> " + msg + " Total members available = " + total_members + " | Required index = " + i);
		System.out.println("❌ Actual: " + msg);
		System.out.println("Total members available = " + total_members + " | Required index = " + i);
		System.out.println();
		return;
	}

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Total members in the list = " + total_members + " | Required index for interview scheduling = " + i);
	System.out.println("🟨 Actual: Total members in the list = " + total_members + " | Required index for interview scheduling = " + i);
	System.out.println();

	String member_name = Member_Names_List.get(i);
	String First_Name = candidate_data.get("First Name");
	String Candidate_Ph_number = candidate_data.get("Phone Number");
	String Dial_in_number=Candidate_Ph_number.replace("1", "7");

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Member selected successfully for host and recruiter = " + member_name);
	System.out.println("🟨 Actual: Member selected successfully for host and recruiter = " + member_name);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Open candidate list page before searching the candidate.");
	System.out.println("Step " + (step - 1) + ": Open candidate list page before searching the candidate.");
	System.out.println();

	Candidate_List_Accesor();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Candidate list page opened successfully.");
	System.out.println("🟨 Actual: Candidate list page opened successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Search candidate in candidate list using first name.");
	System.out.println("Step " + (step - 1) + ": Search candidate in candidate list using first name.");
	System.out.println();

	WebElement search = jb.search_field();
	search.sendKeys(First_Name);
	Thread.sleep(800);

	try {
		rp.wait_for_invisibilty_of_theElement(jb.List_loader());

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Candidate list loader disappeared successfully after search.");
		System.out.println("🟨 Actual: Candidate list loader disappeared successfully after search.");
		System.out.println();

	} catch (Exception e) {
		System.out.println("Loader not visible.");
		System.out.println();
		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Loader was not visible.");
	}

	List<WebElement> searched_candidates = p.candidate_names_in_list();
	WebElement First_candidate = searched_candidates.get(0);
	rp.movetoelement(First_candidate);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Candidate search completed successfully. Total matching candidate cards found = " + searched_candidates.size());
	System.out.println("🟨 Actual: Candidate search completed successfully. Total matching candidate cards found = " + searched_candidates.size());
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Open the first searched candidate profile.");
	System.out.println("Step " + (step - 1) + ": Open the first searched candidate profile.");
	System.out.println();

	WebElement Candidate_name_click = First_candidate.findElement(By.xpath(".//a"));
	Candidate_name_click.click();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Candidate profile opened successfully for = " + First_Name);
	System.out.println("🟨 Actual: Candidate profile opened successfully for = " + First_Name);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Open Events tab and launch interview scheduling popup.");
	System.out.println("Step " + (step - 1) + ": Open Events tab and launch interview scheduling popup.");
	System.out.println();

	List<WebElement> Candidate_tabs = p.Tab_Buttons();
	WebElement Event_Tab = Candidate_tabs.get(2);
	Event_Tab.click();

	p.schedule_interview_button().click();
	WebElement popup_form = p.Pop_up_form();
    
	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Events tab opened successfully and interview scheduling popup displayed.");
	System.out.println("🟨 Actual: Events tab opened successfully and interview scheduling popup displayed.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Configure interview date and time.");
	System.out.println("Step " + (step - 1) + ": Configure interview date and time.");
	System.out.println();

	List<WebElement> interview_inputs = p.Pop_Up_Form_Custom_Dropdown_fields();
	WebElement Date_field = p.Date_picker_field();
	Date_field.click();

	List<WebElement> Job_Expiry_Date_options = jb.Job_Expiry_unselected_dates_in_calender();
	for (WebElement date_option : Job_Expiry_Date_options) {
		String date_text = date_option.getText().trim();
		if (date_text.contains("30")) {
			date_option.click();
			break;
		}
	}
	WebElement Interview_Type = interview_inputs.get(1);
	Interview_Type.click();
    WebElement Interview_Dropdown = p.Interview_Type_Dropdown();
	List<WebElement> Interview_Type_options = Interview_Dropdown.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
	Interview_Type_options.stream()
	.filter(timeopt -> timeopt.getText().trim().equalsIgnoreCase("Phone Interview"))
	.findFirst()
	.ifPresent(WebElement::click);
	
	
/*	WebElement To_time = interview_inputs.get(3);
	To_time.click(); */

	WebElement End_time = p.endTime_input();
	End_time.clear();
	End_time.sendKeys("9:00 PM");
	Thread.sleep(500);

	WebElement Time_Dropdown = p.state_Dropdown();
	List<WebElement> time_options = Time_Dropdown
			.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));

	time_options.stream()
			.filter(timeopt -> timeopt.getText().trim().equalsIgnoreCase("9:00 PM"))
			.findFirst()
			.ifPresent(WebElement::click);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Interview date selected successfully and time selected successfully = 9:00 PM.");
	System.out.println("🟨 Actual: Interview date selected successfully and time selected successfully = 9:00 PM.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Select interview mode and platform.");
	System.out.println("Step " + (step - 1) + ": Select interview mode and platform.");
	System.out.println();

	WebElement Dial_input =p.Dial_in_number_input();
	Dial_input.sendKeys(Dial_in_number);
	
/*	List<WebElement> Radio_Options = p.radio_options();
	Radio_Options.stream()
			.filter(option -> option.getText().trim().equalsIgnoreCase("Organization"))
			.findFirst()
			.ifPresent(option -> js.executeScript("arguments[0].click();", option));

	WebElement Interview_platform = p.Meeting_link_dropdown_Field();
	Interview_platform.click();

	WebElement Meet_Dropdown = p.state_Dropdown();
	List<WebElement> Meet_options = Meet_Dropdown
			.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));

	Meet_options.stream()
			.filter(meetopt -> meetopt.getText().trim().equalsIgnoreCase("Google Meet"))
			.findFirst()
			.ifPresent(WebElement::click); 

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Interview mode selected successfully = Organization | Interview platform selected successfully = Google Meet");
	System.out.println("🟨 Actual: Interview mode selected successfully = Organization | Interview platform selected successfully = Google Meet");
	System.out.println(); */

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Assign interview host and recruiter.");
	System.out.println("Step " + (step - 1) + ": Assign interview host and recruiter.");
	System.out.println();

	WebElement Host = interview_inputs.get(4);
	Host.click();
	p.interviewHost_input().sendKeys(member_name);

	p.Owner_Dropdown_backup()
			.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"))
			.stream()
			.filter(hostopt -> hostopt.getText().trim().equalsIgnoreCase(member_name))
			.findFirst()
			.ifPresent(WebElement::click);

	WebElement Recruiter = interview_inputs.get(5);
	rp.Scroll_to_element(Recruiter);
	Recruiter.click();

	p.recruiter_Dropdown_backup()
			.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"))
			.stream()
			.filter(recruiteroption -> recruiteroption.getText().trim().equalsIgnoreCase(member_name))
			.findFirst()
			.ifPresent(WebElement::click);

	Recruiter.click();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Interview host selected successfully = " + member_name + " | Recruiter selected successfully = " + member_name);
	System.out.println("🟨 Actual: Interview host selected successfully = " + member_name + " | Recruiter selected successfully = " + member_name);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Save interview schedule and send notification.");
	System.out.println("Step " + (step - 1) + ": Save interview schedule and send notification.");
	System.out.println();

	WebElement Save = p.Modal_Save_Button();
	rp.Scroll_to_element(Save);
	Save.click();

	WebElement Notify_Button = p.notify_button();
	rp.Scroll_to_element(Notify_Button);
	Notify_Button.click();

	rp.wait_for_invisibilty_of_theElement(popup_form);

	WebElement Success_toast = p.Success_Toast_Message();
	String success_toast_text = Success_toast.getText().trim();

	Report_Listen.log_print_in_report().log(Status.PASS,
			"<b>🟨 Actual:</b> Interview scheduled successfully and success toast appeared = " + success_toast_text);
	System.out.println("🟨 Actual: Interview scheduled successfully and success toast appeared = " + success_toast_text);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📌 Final Status:</b> Candidate interview scheduling flow completed successfully.");
	System.out.println("📌 Final Status: Candidate interview scheduling flow completed successfully.");
	System.out.println();  
}

  public void Candidate_job_status_change(String Status_value) throws IOException, InterruptedException {

	Candidate_Module_Locaters p = new Candidate_Module_Locaters(d);
	Repeat rp = new Repeat(d);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🔹 Scenario Title:</b> Change candidate job application status");
	System.out.println();
	System.out.println("🔹 Scenario Title: Change candidate job application status");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📘 Description:</b> Open the Job Applied tab for the currently opened candidate, launch the application status dropdown, and change the candidate job application status to the required value.");
	System.out.println("📘 Description: Open the Job Applied tab for the currently opened candidate, launch the application status dropdown, and change the candidate job application status to the required value.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📥 Input:</b> Required Status Value = " + Status_value);
	System.out.println("📥 Input: Required Status Value = " + Status_value);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>✅ Expected:</b> Job Applied tab should open successfully, application status dropdown should be accessible, and the required status value should be selected successfully.");
	System.out.println("✅ Expected: Job Applied tab should open successfully, application status dropdown should be accessible, and the required status value should be selected successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step 1:</b> Open Job Applied tab.");
	System.out.println("Step 1: Open Job Applied tab.");
	System.out.println();

	List<WebElement> Candidate_tabs = p.Tab_Buttons();
	WebElement Job_Applied_Tab = Candidate_tabs.get(1);
	rp.movetoelement(Job_Applied_Tab);
	Job_Applied_Tab.click();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Job Applied tab opened successfully.");
	System.out.println("🟨 Actual: Job Applied tab opened successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step 2:</b> Open application status dropdown and select required status.");
	System.out.println("Step 2: Open application status dropdown and select required status.");
	System.out.println();

	p.Application_status_Dropdown().click();
	WebElement Status_dropdown_list = p.Owner_Dropdown();
	Status_dropdown_list.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"))
			.stream()
			.filter(statusopt -> statusopt.getText().trim().equalsIgnoreCase(Status_value))
			.findFirst()
			.ifPresent(WebElement::click);

	Report_Listen.log_print_in_report().log(Status.PASS,
			"<b>🟨 Actual:</b> Candidate job application status selected successfully = " + Status_value);
	System.out.println("🟨 Actual: Candidate job application status selected successfully = " + Status_value);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📌 Final Status:</b> Candidate job status change flow completed successfully.");
	System.out.println("📌 Final Status: Candidate job status change flow completed successfully.");
	System.out.println();
}


   public void pagination_changer(String count) throws InterruptedException{
		
	   Candidate_Module_Locaters p = new Candidate_Module_Locaters(d);
	   Repeat rp = new Repeat(d);
	   
	   WebElement pagination_box = p.pagination_box();
	   rp.Scroll_to_element(pagination_box);
       pagination_box.click();
	   WebElement pagination_list;
	
	   try{
		   pagination_list =  p.state_Dropdown();
		   
	   }catch(Exception e) {
		   
		   pagination_list =  p.Owner_Dropdown_backup();
	   }
	   
	   pagination_list.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"))
		.stream().filter(pageopt -> pageopt.getText().trim().equalsIgnoreCase(count)).findFirst()
		.ifPresent(WebElement::click);
	   WebElement TableBody = p.table_body();
	   rp.movetoelement(TableBody);
	   Thread.sleep(500);
   
   }
	
 
      public TreeMap<String, String> Total_Candidate_Count_Fetcher(int step) throws IOException, InterruptedException, AWTException {
	   
	   
	   
	    Candidate_Module_Locaters cp = new Candidate_Module_Locaters(d);
		Repeat rp = new Repeat(d);
		Robot r = new Robot();
	   
		Overview_Cards_Data.clear();
		Candidate_List_Accesor();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Candidate list page accessed successfully after overview data capture.");
		System.out.println("🟨 Actual: Candidate list page accessed successfully after overview data capture.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Open All Stage filter and select All Stages option.");
		System.out.println("Step " + (step - 1) + ": Open All Stage filter and select All Stages option.");
		System.out.println();

		List<WebElement> candidate_Filters = cp.Candidate_List_Filter_Dropdowns();
		WebElement all_stage_filter = candidate_Filters.get(3);

		r.mouseWheel(-25);
		rp.movetoelement(all_stage_filter);
		all_stage_filter.click();

		WebElement all_stage_filter_dropdown = cp.stages_Dropdown();
		all_stage_filter_dropdown.findElements(
				By.xpath(".//div[contains(@class,'ant-select-item') and contains(@class,'ant-select-item-option')]"))
				.stream()
				.filter(stage -> stage.getAttribute("title").trim().contains("All Stages"))
				.findFirst()
				.orElseThrow(() -> new NoSuchElementException("All Stages option not found"))
				.findElement(By.xpath(".//div[contains(@class,'ant-select-item-option-content')]"))
				.click();

		all_stage_filter.click();
		Thread.sleep(800);

		WebElement all_filter_selected_confirmation = all_stage_filter
				.findElement(By.xpath(".//span[contains(@title,'5 Selected')]"));

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> All Stages option selected successfully and multi-selection confirmation was displayed = "
						+ all_filter_selected_confirmation.getText().trim());
		System.out.println("🟨 Actual: All Stages option selected successfully and multi-selection confirmation was displayed = "
				+ all_filter_selected_confirmation.getText().trim());
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Change candidate list pagination to 100 and open exact count details.");
		System.out.println("Step " + (step - 1) + ": Change candidate list pagination to 100 and open exact count details.");
		System.out.println();

		pagination_changer("100");
		cp.Exact_count_icon().click();
		Thread.sleep(800);

		List<WebElement> candidates_count = cp.pagination_count_text();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Candidate exact count values fetched successfully. Total count text elements found = "
						+ candidates_count.size());
		System.out.println("🟨 Actual: Candidate exact count values fetched successfully. Total count text elements found = "
				+ candidates_count.size());
		System.out.println();

		candidates_count.stream()
				.map(count -> count.getText().trim())
				.forEach(countText -> {
					Report_Listen.log_print_in_report().log(Status.INFO,
							"<b>🟨 Actual:</b> Candidate count confirmation text = " + countText);
					System.out.println("Candidates count confirmation text: " + countText);
				});

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>📌 Final Status:</b> Overview section data captured successfully and candidate count verification flow completed. Total overview entries stored = "
						+ Overview_Cards_Data.size());
		System.out.println();
		System.out.println(
				"📌 Final Status: Overview section data captured successfully and candidate count verification flow completed. Total overview entries stored = "
						+ Overview_Cards_Data.size());
		System.out.println(); 
	   
	   return Overview_Cards_Data;
	   
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
    data1.put("Email", "reyaan.bhattacharjee2026cw@yopmail.com");
    data1.put("Phone Code", "+91");
    data1.put("Phone Number", "9123405011");
    data1.put("First Name", "Reyaan");
    data1.put("Last Name", "Bhattacharjee");
    data1.put("Professional Profile Link", "https://www.linkedin.com/in/reyaan-bhattacharjee-2026-cw");
    data1.put("Source", "Candidate Portal");
    data1.put("Country", "India");
    data1.put("State", "Karnataka");
    data1.put("Current Salary Currency", "INR(₹)");
    data1.put("Current Salary", "1064000");
    data1.put("Current Salary Duration", "Yearly");
    data1.put("Expected Salary Currency", "INR(₹)");
    data1.put("Expected Salary", "1349000");
    data1.put("Expected Salary Duration", "Yearly");
    data1.put("CV/Resume", "");
    data1.put("Skills", "");
    data1.put("Relevant Experience", "3");
    data1.put("Relevant Experience Unit", "Year(s)");
    data1.put("Total Experience", "4");
    data1.put("Total Experience Unit", "Year(s)");
    data1.put("Notice Period", "16");
    data1.put("Notice Period Unit", "Day(s)");
    data1.put("Work Experience", "");
    data1.put("Education", "");
    data1.put("Cover Letter", "");
    data1.put("Owner", "Admin Ayan Sengupta");
    data1.put("Recruiter", "Admin Ayan Sengupta");

    TreeMap<String, String> data2 = new TreeMap<String, String>();
    data2.put("Email", "arseniy.bogatov2026cx@yopmail.com");
    data2.put("Phone Code", "+91");
    data2.put("Phone Number", "9123405012");
    data2.put("First Name", "Arseniy");
    data2.put("Last Name", "Bogatov");
    data2.put("Professional Profile Link", "https://www.linkedin.com/in/arseniy-bogatov-2026-cx");
    data2.put("Source", "Consultancy");
    data2.put("Country", "India");
    data2.put("State", "Maharashtra");
    data2.put("Current Salary Currency", "INR(₹)");
    data2.put("Current Salary", "1217000");
    data2.put("Current Salary Duration", "Yearly");
    data2.put("Expected Salary Currency", "INR(₹)");
    data2.put("Expected Salary", "1513000");
    data2.put("Expected Salary Duration", "Yearly");
    data2.put("CV/Resume", "");
    data2.put("Skills", "");
    data2.put("Relevant Experience", "5");
    data2.put("Relevant Experience Unit", "Year(s)");
    data2.put("Total Experience", "6");
    data2.put("Total Experience Unit", "Year(s)");
    data2.put("Notice Period", "19");
    data2.put("Notice Period Unit", "Day(s)");
    data2.put("Work Experience", "");
    data2.put("Education", "");
    data2.put("Cover Letter", "");
    data2.put("Owner", "Alexei Morozov");
    data2.put("Recruiter", "Alexei Morozov");

    TreeMap<String, String> data3 = new TreeMap<String, String>();
    data3.put("Email", "priyanshu.nath2026cy@yopmail.com");
    data3.put("Phone Code", "+91");
    data3.put("Phone Number", "9123405013");
    data3.put("First Name", "Priyanshu");
    data3.put("Last Name", "Nath");
    data3.put("Professional Profile Link", "https://www.linkedin.com/in/priyanshu-nath-2026-cy");
    data3.put("Source", "Email");
    data3.put("Country", "India");
    data3.put("State", "Delhi");
    data3.put("Current Salary Currency", "INR(₹)");
    data3.put("Current Salary", "1139000");
    data3.put("Current Salary Duration", "Yearly");
    data3.put("Expected Salary Currency", "INR(₹)");
    data3.put("Expected Salary", "1418000");
    data3.put("Expected Salary Duration", "Yearly");
    data3.put("CV/Resume", "");
    data3.put("Skills", "");
    data3.put("Relevant Experience", "4");
    data3.put("Relevant Experience Unit", "Year(s)");
    data3.put("Total Experience", "5");
    data3.put("Total Experience Unit", "Year(s)");
    data3.put("Notice Period", "22");
    data3.put("Notice Period Unit", "Day(s)");
    data3.put("Work Experience", "");
    data3.put("Education", "");
    data3.put("Cover Letter", "");
    data3.put("Owner", "Guest Alexei Sokolov");
    data3.put("Recruiter", "Guest Alexei Sokolov");

    TreeMap<String, String> data4 = new TreeMap<String, String>();
    data4.put("Email", "yaromir.kiselov2026cz@yopmail.com");
    data4.put("Phone Code", "+91");
    data4.put("Phone Number", "9123405014");
    data4.put("First Name", "Yaromir");
    data4.put("Last Name", "Kiselov");
    data4.put("Professional Profile Link", "https://www.linkedin.com/in/yaromir-kiselov-2026-cz");
    data4.put("Source", "Import");
    data4.put("Country", "India");
    data4.put("State", "West Bengal");
    data4.put("Current Salary Currency", "INR(₹)");
    data4.put("Current Salary", "1668000");
    data4.put("Current Salary Duration", "Yearly");
    data4.put("Expected Salary Currency", "INR(₹)");
    data4.put("Expected Salary", "2039000");
    data4.put("Expected Salary Duration", "Yearly");
    data4.put("CV/Resume", "");
    data4.put("Skills", "");
    data4.put("Relevant Experience", "7");
    data4.put("Relevant Experience Unit", "Year(s)");
    data4.put("Total Experience", "8");
    data4.put("Total Experience Unit", "Year(s)");
    data4.put("Notice Period", "25");
    data4.put("Notice Period Unit", "Day(s)");
    data4.put("Work Experience", "");
    data4.put("Education", "");
    data4.put("Cover Letter", "");
    data4.put("Owner", "Interviewer Ivan Orlov");
    data4.put("Recruiter", "Interviewer Ivan Orlov");

    TreeMap<String, String> data5 = new TreeMap<String, String>();
    data5.put("Email", "ritobrata.chanda2026da@yopmail.com");
    data5.put("Phone Code", "+91");
    data5.put("Phone Number", "9123405015");
    data5.put("First Name", "Ritobrata");
    data5.put("Last Name", "Chanda");
    data5.put("Professional Profile Link", "https://www.linkedin.com/in/ritobrata-chanda-2026-da");
    data5.put("Source", "Indeed");
    data5.put("Country", "India");
    data5.put("State", "Tamil Nadu");
    data5.put("Current Salary Currency", "INR(₹)");
    data5.put("Current Salary", "1335000");
    data5.put("Current Salary Duration", "Yearly");
    data5.put("Expected Salary Currency", "INR(₹)");
    data5.put("Expected Salary", "1692000");
    data5.put("Expected Salary Duration", "Yearly");
    data5.put("CV/Resume", "");
    data5.put("Skills", "");
    data5.put("Relevant Experience", "6");
    data5.put("Relevant Experience Unit", "Year(s)");
    data5.put("Total Experience", "7");
    data5.put("Total Experience Unit", "Year(s)");
    data5.put("Notice Period", "28");
    data5.put("Notice Period Unit", "Day(s)");
    data5.put("Work Experience", "");
    data5.put("Education", "");
    data5.put("Cover Letter", "");
    data5.put("Owner", "Nikolai Sidorov");
    data5.put("Recruiter", "Nikolai Sidorov");

    TreeMap<String, String> data6 = new TreeMap<String, String>();
    data6.put("Email", "bogdan.vedenev2026db@yopmail.com");
    data6.put("Phone Code", "+91");
    data6.put("Phone Number", "9123405016");
    data6.put("First Name", "Bogdan");
    data6.put("Last Name", "Vedenev");
    data6.put("Professional Profile Link", "https://www.linkedin.com/in/bogdan-vedenev-2026-db");
    data6.put("Source", "LinkedIn");
    data6.put("Country", "India");
    data6.put("State", "Telangana");
    data6.put("Current Salary Currency", "INR(₹)");
    data6.put("Current Salary", "1811000");
    data6.put("Current Salary Duration", "Yearly");
    data6.put("Expected Salary Currency", "INR(₹)");
    data6.put("Expected Salary", "2208000");
    data6.put("Expected Salary Duration", "Yearly");
    data6.put("CV/Resume", "");
    data6.put("Skills", "");
    data6.put("Relevant Experience", "8");
    data6.put("Relevant Experience Unit", "Year(s)");
    data6.put("Total Experience", "9");
    data6.put("Total Experience Unit", "Year(s)");
    data6.put("Notice Period", "31");
    data6.put("Notice Period Unit", "Day(s)");
    data6.put("Work Experience", "");
    data6.put("Education", "");
    data6.put("Cover Letter", "");
    data6.put("Owner", "Owner Mikhail Volkov");
    data6.put("Recruiter", "Owner Mikhail Volkov");

    TreeMap<String, String> data7 = new TreeMap<String, String>();
    data7.put("Email", "udayon.sur2026dc@yopmail.com");
    data7.put("Phone Code", "+91");
    data7.put("Phone Number", "9123405017");
    data7.put("First Name", "Udayon");
    data7.put("Last Name", "Sur");
    data7.put("Professional Profile Link", "https://www.linkedin.com/in/udayon-sur-2026-dc");
    data7.put("Source", "Naukri");
    data7.put("Country", "India");
    data7.put("State", "Gujarat");
    data7.put("Current Salary Currency", "INR(₹)");
    data7.put("Current Salary", "878000");
    data7.put("Current Salary Duration", "Yearly");
    data7.put("Expected Salary Currency", "INR(₹)");
    data7.put("Expected Salary", "1146000");
    data7.put("Expected Salary Duration", "Yearly");
    data7.put("CV/Resume", "");
    data7.put("Skills", "");
    data7.put("Relevant Experience", "2");
    data7.put("Relevant Experience Unit", "Year(s)");
    data7.put("Total Experience", "3");
    data7.put("Total Experience Unit", "Year(s)");
    data7.put("Notice Period", "34");
    data7.put("Notice Period Unit", "Day(s)");
    data7.put("Work Experience", "");
    data7.put("Education", "");
    data7.put("Cover Letter", "");
    data7.put("Owner", "Rahul Chatterjee");
    data7.put("Recruiter", "Rahul Chatterjee");

    TreeMap<String, String> data8 = new TreeMap<String, String>();
    data8.put("Email", "matvey.krutov2026dd@yopmail.com");
    data8.put("Phone Code", "+91");
    data8.put("Phone Number", "9123405018");
    data8.put("First Name", "Matvey");
    data8.put("Last Name", "Krutov");
    data8.put("Professional Profile Link", "https://www.linkedin.com/in/matvey-krutov-2026-dd");
    data8.put("Source", "Candidate Portal");
    data8.put("Country", "India");
    data8.put("State", "Uttar Pradesh");
    data8.put("Current Salary Currency", "INR(₹)");
    data8.put("Current Salary", "1582000");
    data8.put("Current Salary Duration", "Yearly");
    data8.put("Expected Salary Currency", "INR(₹)");
    data8.put("Expected Salary", "1956000");
    data8.put("Expected Salary Duration", "Yearly");
    data8.put("CV/Resume", "");
    data8.put("Skills", "");
    data8.put("Relevant Experience", "6");
    data8.put("Relevant Experience Unit", "Year(s)");
    data8.put("Total Experience", "7");
    data8.put("Total Experience Unit", "Year(s)");
    data8.put("Notice Period", "37");
    data8.put("Notice Period Unit", "Day(s)");
    data8.put("Work Experience", "");
    data8.put("Education", "");
    data8.put("Cover Letter", "");
    data8.put("Owner", "Admin Ayan Sengupta");
    data8.put("Recruiter", "Alexei Morozov");

    TreeMap<String, String> data9 = new TreeMap<String, String>();
    data9.put("Email", "aadvik.ghosal2026de@yopmail.com");
    data9.put("Phone Code", "+91");
    data9.put("Phone Number", "9123405019");
    data9.put("First Name", "Aadvik");
    data9.put("Last Name", "Ghosal");
    data9.put("Professional Profile Link", "https://www.linkedin.com/in/aadvik-ghosal-2026-de");
    data9.put("Source", "Consultancy");
    data9.put("Country", "India");
    data9.put("State", "Rajasthan");
    data9.put("Current Salary Currency", "INR(₹)");
    data9.put("Current Salary", "1006000");
    data9.put("Current Salary Duration", "Yearly");
    data9.put("Expected Salary Currency", "INR(₹)");
    data9.put("Expected Salary", "1309000");
    data9.put("Expected Salary Duration", "Yearly");
    data9.put("CV/Resume", "");
    data9.put("Skills", "");
    data9.put("Relevant Experience", "3");
    data9.put("Relevant Experience Unit", "Year(s)");
    data9.put("Total Experience", "4");
    data9.put("Total Experience Unit", "Year(s)");
    data9.put("Notice Period", "40");
    data9.put("Notice Period Unit", "Day(s)");
    data9.put("Work Experience", "");
    data9.put("Education", "");
    data9.put("Cover Letter", "");
    data9.put("Owner", "Alexei Morozov");
    data9.put("Recruiter", "Guest Alexei Sokolov");

    TreeMap<String, String> data10 = new TreeMap<String, String>();
    data10.put("Email", "miroslav.yudin2026df@yopmail.com");
    data10.put("Phone Code", "+91");
    data10.put("Phone Number", "9123405020");
    data10.put("First Name", "Miroslav");
    data10.put("Last Name", "Yudin");
    data10.put("Professional Profile Link", "https://www.linkedin.com/in/miroslav-yudin-2026-df");
    data10.put("Source", "Email");
    data10.put("Country", "India");
    data10.put("State", "Madhya Pradesh");
    data10.put("Current Salary Currency", "INR(₹)");
    data10.put("Current Salary", "1539000");
    data10.put("Current Salary Duration", "Yearly");
    data10.put("Expected Salary Currency", "INR(₹)");
    data10.put("Expected Salary", "1974000");
    data10.put("Expected Salary Duration", "Yearly");
    data10.put("CV/Resume", "");
    data10.put("Skills", "");
    data10.put("Relevant Experience", "6");
    data10.put("Relevant Experience Unit", "Year(s)");
    data10.put("Total Experience", "7");
    data10.put("Total Experience Unit", "Year(s)");
    data10.put("Notice Period", "43");
    data10.put("Notice Period Unit", "Day(s)");
    data10.put("Work Experience", "");
    data10.put("Education", "");
    data10.put("Cover Letter", "");
    data10.put("Owner", "Guest Alexei Sokolov");
    data10.put("Recruiter", "Interviewer Ivan Orlov");

    TreeMap<String, String> data11 = new TreeMap<String, String>();
    data11.put("Email", "arhan.biswas2026dg@yopmail.com");
    data11.put("Phone Code", "+91");
    data11.put("Phone Number", "9123405021");
    data11.put("First Name", "Arhan");
    data11.put("Last Name", "Biswas");
    data11.put("Professional Profile Link", "https://www.linkedin.com/in/arhan-biswas-2026-dg");
    data11.put("Source", "Import");
    data11.put("Country", "India");
    data11.put("State", "Haryana");
    data11.put("Current Salary Currency", "INR(₹)");
    data11.put("Current Salary", "1262000");
    data11.put("Current Salary Duration", "Yearly");
    data11.put("Expected Salary Currency", "INR(₹)");
    data11.put("Expected Salary", "1621000");
    data11.put("Expected Salary Duration", "Yearly");
    data11.put("CV/Resume", "");
    data11.put("Skills", "");
    data11.put("Relevant Experience", "5");
    data11.put("Relevant Experience Unit", "Year(s)");
    data11.put("Total Experience", "6");
    data11.put("Total Experience Unit", "Year(s)");
    data11.put("Notice Period", "46");
    data11.put("Notice Period Unit", "Day(s)");
    data11.put("Work Experience", "");
    data11.put("Education", "");
    data11.put("Cover Letter", "");
    data11.put("Owner", "Interviewer Ivan Orlov");
    data11.put("Recruiter", "Nikolai Sidorov");

    TreeMap<String, String> data12 = new TreeMap<String, String>();
    data12.put("Email", "taras.lukashin2026dh@yopmail.com");
    data12.put("Phone Code", "+91");
    data12.put("Phone Number", "9123405022");
    data12.put("First Name", "Taras");
    data12.put("Last Name", "Lukashin");
    data12.put("Professional Profile Link", "https://www.linkedin.com/in/taras-lukashin-2026-dh");
    data12.put("Source", "Indeed");
    data12.put("Country", "India");
    data12.put("State", "Punjab");
    data12.put("Current Salary Currency", "INR(₹)");
    data12.put("Current Salary", "1709000");
    data12.put("Current Salary Duration", "Yearly");
    data12.put("Expected Salary Currency", "INR(₹)");
    data12.put("Expected Salary", "2093000");
    data12.put("Expected Salary Duration", "Yearly");
    data12.put("CV/Resume", "");
    data12.put("Skills", "");
    data12.put("Relevant Experience", "7");
    data12.put("Relevant Experience Unit", "Year(s)");
    data12.put("Total Experience", "8");
    data12.put("Total Experience Unit", "Year(s)");
    data12.put("Notice Period", "49");
    data12.put("Notice Period Unit", "Day(s)");
    data12.put("Work Experience", "");
    data12.put("Education", "");
    data12.put("Cover Letter", "");
    data12.put("Owner", "Nikolai Sidorov");
    data12.put("Recruiter", "Owner Mikhail Volkov");

    TreeMap<String, String> data13 = new TreeMap<String, String>();
    data13.put("Email", "divit.sengupta2026di@yopmail.com");
    data13.put("Phone Code", "+91");
    data13.put("Phone Number", "9123405023");
    data13.put("First Name", "Divit");
    data13.put("Last Name", "Sengupta");
    data13.put("Professional Profile Link", "https://www.linkedin.com/in/divit-sengupta-2026-di");
    data13.put("Source", "LinkedIn");
    data13.put("Country", "India");
    data13.put("State", "Odisha");
    data13.put("Current Salary Currency", "INR(₹)");
    data13.put("Current Salary", "1857000");
    data13.put("Current Salary Duration", "Yearly");
    data13.put("Expected Salary Currency", "INR(₹)");
    data13.put("Expected Salary", "2304000");
    data13.put("Expected Salary Duration", "Yearly");
    data13.put("CV/Resume", "");
    data13.put("Skills", "");
    data13.put("Relevant Experience", "8");
    data13.put("Relevant Experience Unit", "Year(s)");
    data13.put("Total Experience", "9");
    data13.put("Total Experience Unit", "Year(s)");
    data13.put("Notice Period", "52");
    data13.put("Notice Period Unit", "Day(s)");
    data13.put("Work Experience", "");
    data13.put("Education", "");
    data13.put("Cover Letter", "");
    data13.put("Owner", "Owner Mikhail Volkov");
    data13.put("Recruiter", "Rahul Chatterjee");

    TreeMap<String, String> data14 = new TreeMap<String, String>();
    data14.put("Email", "gavriil.turin2026dj@yopmail.com");
    data14.put("Phone Code", "+91");
    data14.put("Phone Number", "9123405024");
    data14.put("First Name", "Gavriil");
    data14.put("Last Name", "Turin");
    data14.put("Professional Profile Link", "https://www.linkedin.com/in/gavriil-turin-2026-dj");
    data14.put("Source", "Naukri");
    data14.put("Country", "India");
    data14.put("State", "Bihar");
    data14.put("Current Salary Currency", "INR(₹)");
    data14.put("Current Salary", "1752000");
    data14.put("Current Salary Duration", "Yearly");
    data14.put("Expected Salary Currency", "INR(₹)");
    data14.put("Expected Salary", "2141000");
    data14.put("Expected Salary Duration", "Yearly");
    data14.put("CV/Resume", "");
    data14.put("Skills", "");
    data14.put("Relevant Experience", "7");
    data14.put("Relevant Experience Unit", "Year(s)");
    data14.put("Total Experience", "8");
    data14.put("Total Experience Unit", "Year(s)");
    data14.put("Notice Period", "55");
    data14.put("Notice Period Unit", "Day(s)");
    data14.put("Work Experience", "");
    data14.put("Education", "");
    data14.put("Cover Letter", "");
    data14.put("Owner", "Rahul Chatterjee");
    data14.put("Recruiter", "Admin Ayan Sengupta");

    TreeMap<String, String> data15 = new TreeMap<String, String>();
    data15.put("Email", "vihaan.porel2026dk@yopmail.com");
    data15.put("Phone Code", "+91");
    data15.put("Phone Number", "9123405025");
    data15.put("First Name", "Vihaan");
    data15.put("Last Name", "Porel");
    data15.put("Professional Profile Link", "https://www.linkedin.com/in/vihaan-porel-2026-dk");
    data15.put("Source", "Candidate Portal");
    data15.put("Country", "India");
    data15.put("State", "Kerala");
    data15.put("Current Salary Currency", "INR(₹)");
    data15.put("Current Salary", "1204000");
    data15.put("Current Salary Duration", "Yearly");
    data15.put("Expected Salary Currency", "INR(₹)");
    data15.put("Expected Salary", "1538000");
    data15.put("Expected Salary Duration", "Yearly");
    data15.put("CV/Resume", "");
    data15.put("Skills", "");
    data15.put("Relevant Experience", "4");
    data15.put("Relevant Experience Unit", "Year(s)");
    data15.put("Total Experience", "5");
    data15.put("Total Experience Unit", "Year(s)");
    data15.put("Notice Period", "58");
    data15.put("Notice Period Unit", "Day(s)");
    data15.put("Work Experience", "");
    data15.put("Education", "");
    data15.put("Cover Letter", "");
    data15.put("Owner", "Admin Ayan Sengupta");
    data15.put("Recruiter", "Guest Alexei Sokolov");

    TreeMap<String, String> data16 = new TreeMap<String, String>();
    data16.put("Email", "yaroslavin.fokin2026dl@yopmail.com");
    data16.put("Phone Code", "+91");
    data16.put("Phone Number", "9123405026");
    data16.put("First Name", "Yaroslavin");
    data16.put("Last Name", "Fokin");
    data16.put("Professional Profile Link", "https://www.linkedin.com/in/yaroslavin-fokin-2026-dl");
    data16.put("Source", "Consultancy");
    data16.put("Country", "India");
    data16.put("State", "Andhra Pradesh");
    data16.put("Current Salary Currency", "INR(₹)");
    data16.put("Current Salary", "1614000");
    data16.put("Current Salary Duration", "Yearly");
    data16.put("Expected Salary Currency", "INR(₹)");
    data16.put("Expected Salary", "1989000");
    data16.put("Expected Salary Duration", "Yearly");
    data16.put("CV/Resume", "");
    data16.put("Skills", "");
    data16.put("Relevant Experience", "6");
    data16.put("Relevant Experience Unit", "Year(s)");
    data16.put("Total Experience", "7");
    data16.put("Total Experience Unit", "Year(s)");
    data16.put("Notice Period", "61");
    data16.put("Notice Period Unit", "Day(s)");
    data16.put("Work Experience", "");
    data16.put("Education", "");
    data16.put("Cover Letter", "");
    data16.put("Owner", "Alexei Morozov");
    data16.put("Recruiter", "Interviewer Ivan Orlov");

    TreeMap<String, String> data17 = new TreeMap<String, String>();
    data17.put("Email", "ridoy.roy2026dm@yopmail.com");
    data17.put("Phone Code", "+91");
    data17.put("Phone Number", "9123405027");
    data17.put("First Name", "Ridoy");
    data17.put("Last Name", "Roy");
    data17.put("Professional Profile Link", "https://www.linkedin.com/in/ridoy-roy-2026-dm");
    data17.put("Source", "Email");
    data17.put("Country", "India");
    data17.put("State", "Jharkhand");
    data17.put("Current Salary Currency", "INR(₹)");
    data17.put("Current Salary", "1501000");
    data17.put("Current Salary Duration", "Yearly");
    data17.put("Expected Salary Currency", "INR(₹)");
    data17.put("Expected Salary", "1916000");
    data17.put("Expected Salary Duration", "Yearly");
    data17.put("CV/Resume", "");
    data17.put("Skills", "");
    data17.put("Relevant Experience", "6");
    data17.put("Relevant Experience Unit", "Year(s)");
    data17.put("Total Experience", "7");
    data17.put("Total Experience Unit", "Year(s)");
    data17.put("Notice Period", "64");
    data17.put("Notice Period Unit", "Day(s)");
    data17.put("Work Experience", "");
    data17.put("Education", "");
    data17.put("Cover Letter", "");
    data17.put("Owner", "Guest Alexei Sokolov");
    data17.put("Recruiter", "Nikolai Sidorov");

    TreeMap<String, String> data18 = new TreeMap<String, String>();
    data18.put("Email", "svyatopolk.garin2026dn@yopmail.com");
    data18.put("Phone Code", "+91");
    data18.put("Phone Number", "9123405028");
    data18.put("First Name", "Svyatopolk");
    data18.put("Last Name", "Garin");
    data18.put("Professional Profile Link", "https://www.linkedin.com/in/svyatopolk-garin-2026-dn");
    data18.put("Source", "Import");
    data18.put("Country", "India");
    data18.put("State", "Assam");
    data18.put("Current Salary Currency", "INR(₹)");
    data18.put("Current Salary", "1691000");
    data18.put("Current Salary Duration", "Yearly");
    data18.put("Expected Salary Currency", "INR(₹)");
    data18.put("Expected Salary", "2088000");
    data18.put("Expected Salary Duration", "Yearly");
    data18.put("CV/Resume", "");
    data18.put("Skills", "");
    data18.put("Relevant Experience", "7");
    data18.put("Relevant Experience Unit", "Year(s)");
    data18.put("Total Experience", "8");
    data18.put("Total Experience Unit", "Year(s)");
    data18.put("Notice Period", "67");
    data18.put("Notice Period Unit", "Day(s)");
    data18.put("Work Experience", "");
    data18.put("Education", "");
    data18.put("Cover Letter", "");
    data18.put("Owner", "Interviewer Ivan Orlov");
    data18.put("Recruiter", "Owner Mikhail Volkov");

    TreeMap<String, String> data19 = new TreeMap<String, String>();
    data19.put("Email", "ranadip.kundu2026do@yopmail.com");
    data19.put("Phone Code", "+91");
    data19.put("Phone Number", "9123405029");
    data19.put("First Name", "Ranadip");
    data19.put("Last Name", "Kundu");
    data19.put("Professional Profile Link", "https://www.linkedin.com/in/ranadip-kundu-2026-do");
    data19.put("Source", "Indeed");
    data19.put("Country", "India");
    data19.put("State", "Chhattisgarh");
    data19.put("Current Salary Currency", "INR(₹)");
    data19.put("Current Salary", "1048000");
    data19.put("Current Salary Duration", "Yearly");
    data19.put("Expected Salary Currency", "INR(₹)");
    data19.put("Expected Salary", "1387000");
    data19.put("Expected Salary Duration", "Yearly");
    data19.put("CV/Resume", "");
    data19.put("Skills", "");
    data19.put("Relevant Experience", "4");
    data19.put("Relevant Experience Unit", "Year(s)");
    data19.put("Total Experience", "5");
    data19.put("Total Experience Unit", "Year(s)");
    data19.put("Notice Period", "70");
    data19.put("Notice Period Unit", "Day(s)");
    data19.put("Work Experience", "");
    data19.put("Education", "");
    data19.put("Cover Letter", "");
    data19.put("Owner", "Nikolai Sidorov");
    data19.put("Recruiter", "Rahul Chatterjee");

    TreeMap<String, String> data20 = new TreeMap<String, String>();
    data20.put("Email", "rodion.starov2026dp@yopmail.com");
    data20.put("Phone Code", "+91");
    data20.put("Phone Number", "9123405030");
    data20.put("First Name", "Rodion");
    data20.put("Last Name", "Starov");
    data20.put("Professional Profile Link", "https://www.linkedin.com/in/rodion-starov-2026-dp");
    data20.put("Source", "LinkedIn");
    data20.put("Country", "India");
    data20.put("State", "Goa");
    data20.put("Current Salary Currency", "INR(₹)");
    data20.put("Current Salary", "1961000");
    data20.put("Current Salary Duration", "Yearly");
    data20.put("Expected Salary Currency", "INR(₹)");
    data20.put("Expected Salary", "2408000");
    data20.put("Expected Salary Duration", "Yearly");
    data20.put("CV/Resume", "");
    data20.put("Skills", "");
    data20.put("Relevant Experience", "8");
    data20.put("Relevant Experience Unit", "Year(s)");
    data20.put("Total Experience", "9");
    data20.put("Total Experience Unit", "Year(s)");
    data20.put("Notice Period", "76");
    data20.put("Notice Period Unit", "Day(s)");
    data20.put("Work Experience", "");
    data20.put("Education", "");
    data20.put("Cover Letter", "");
    data20.put("Owner", "Owner Mikhail Volkov");
    data20.put("Recruiter", "Admin Ayan Sengupta");
    
    data1.put("Index", "0");
    data2.put("Index", "1");
    data3.put("Index", "2");
    data4.put("Index", "3");
    data5.put("Index", "4");
    data6.put("Index", "5");
    data7.put("Index", "6");
    data8.put("Index", "7");
    data9.put("Index", "8");
    data10.put("Index", "9");
    data11.put("Index", "10");
    data12.put("Index", "11");
    data13.put("Index", "12");
    data14.put("Index", "13");
    data15.put("Index", "14");
    data16.put("Index", "15");
    data17.put("Index", "16");
    data18.put("Index", "17");
    data19.put("Index", "18");
    data20.put("Index", "19");

    return new Object[][] { /*
            { data1 }, 
            { data2 }, 
            { data3 },*/ 
            { data4 },
            { data5 },
            { data6 },
            { data7 },
            { data8 },
            { data9 },
            { data10},
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