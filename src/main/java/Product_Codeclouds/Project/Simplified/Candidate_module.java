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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Candidate_Module_Locaters;
import Locaters.Job_Module_locaters;
import Repeatative_codes.Repeat;
@Listeners(Listerners.Report_Listen.class)
public class Candidate_module extends Side_menu_Handler {
	
	public List<String> Member_Names_List = new ArrayList<String>();
	TreeMap<String, String> Overview_Cards_Data = new TreeMap<String, String>();
	

	public WebElement Candidate_List_Accesor() throws IOException, InterruptedException {

		Candidate_Module_Locaters p = new Candidate_Module_Locaters(d);

		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>━━━━━━━━━━━━━━ 📂 CANDIDATE MODULE ACCESS ━━━━━━━━━━━━━━</b>"
		);
		System.out.println("━━━━━━━━━━━━━━ 📂 CANDIDATE MODULE ACCESS ━━━━━━━━━━━━━━");

		Menu_option_selector("Candidates");

		WebElement Add = p.Add_Button();

		Report_Listen.log_print_in_report().log(
				Status.PASS,
				"<b>✅ Actual:</b> Candidate module opened successfully."
		);
		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>"
		);

		System.out.println("✅ Actual: Candidate module opened successfully.");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println();

		return Add;
	}
	
	
	public String Candidate_status_data_fetcher(String Time_Range, String status) throws IOException, InterruptedException {

		int step = 1;
		Candidate_Module_Locaters p = new Candidate_Module_Locaters(d);

		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>"
		);
		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>🔹 Scenario Title:</b> Fetch Candidate Count by Time Range and Status"
		);
		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>📥 Input:</b> Time Range = " + Time_Range + " | Status = " + status
		);
		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>✅ Expected:</b> Candidate filters should be applied successfully and the matching candidate count should be returned."
		);

		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("🔹 Scenario Title: Fetch Candidate Count by Time Range and Status");
		System.out.println("📥 Input: Time Range = " + Time_Range + " | Status = " + status);
		System.out.println("✅ Expected: Candidate filters should be applied successfully and the matching candidate count should be returned.");
		System.out.println();

		Candidate_List_Accesor();

		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>━━━━━━━━━━━━━━ 🔎 FILTER APPLICATION ━━━━━━━━━━━━━━</b>"
		);
		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>Step " + (step++) + ":</b> Apply Time Range = " + Time_Range + " and Status = " + status + "."
		);

		System.out.println("━━━━━━━━━━━━━━ 🔎 FILTER APPLICATION ━━━━━━━━━━━━━━");
		System.out.println("Step " + (step - 1) + ": Apply Time Range = " + Time_Range + " and Status = " + status + ".");

		List<WebElement> Filters = p.All_filters();
		System.out.println("🟨 Debug: Candidate filter count = " + Filters.size());

		if(Filters.size() <= 3) {
			String errorMessage = "Required Candidate filters were not available. Expected at least 4 filters but found = " + Filters.size();
			Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure:</b> " + errorMessage);
			throw new IllegalStateException(errorMessage);
		}

		WebElement Date_Filter = Filters.get(1);
		WebElement Status_Filter = Filters.get(3);

		Date_Filter.click();
		List<WebElement> date_options = p.time_filter_dropdown().findElements(
				By.xpath(".//div[contains(@class,'ant-select-item') and contains(@class,'ant-select-item-option-content')]")
		);

		WebElement Required_Date_Option = null;
		for(WebElement date_opt : date_options) {
			String date_opt_text = date_opt.getText().trim();
			System.out.println("🟨 Debug: Time range option found = " + date_opt_text);
			if(date_opt_text.contains(Time_Range)) {
				Required_Date_Option = date_opt;
				break;
			}
		}

		if(Required_Date_Option == null) {
			String errorMessage = "Candidate time range filter option was not found = " + Time_Range;
			Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure:</b> " + errorMessage);
			throw new IllegalStateException(errorMessage);
		}
		Required_Date_Option.click();

		Thread.sleep(500);

		Status_Filter.click();
		List<WebElement> stat_options = p.Status_filter_dropdown().findElements(
				By.xpath(".//div[contains(@class,'ant-select-item') and contains(@class,'ant-select-item-option-content')]")
		);

		WebElement Required_Status_Option = null;
		for(WebElement stat_opt : stat_options) {
			String stat_opt_text = stat_opt.getText().trim();
			System.out.println("🟨 Debug: Status option found = " + stat_opt_text);
			if(stat_opt_text.contains(status)) {
				Required_Status_Option = stat_opt;
				break;
			}
		}

		if(Required_Status_Option == null) {
			String errorMessage = "Candidate status filter option was not found = " + status;
			Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure:</b> " + errorMessage);
			throw new IllegalStateException(errorMessage);
		}
		Required_Status_Option.click();
		Thread.sleep(500);

		Report_Listen.log_print_in_report().log(
				Status.PASS,
				"<b>✅ Actual:</b> Candidate filters applied successfully. Time Range = " + Time_Range + " | Status = " + status
		);
		System.out.println("✅ Actual: Candidate filters applied successfully. Time Range = " + Time_Range + " | Status = " + status);
		System.out.println();

		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>━━━━━━━━━━━━━━ 🔢 COUNT VERIFICATION ━━━━━━━━━━━━━━</b>"
		);
		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>Step " + (step++) + ":</b> Display up to 100 candidates and fetch the exact matching count."
		);

		System.out.println("━━━━━━━━━━━━━━ 🔢 COUNT VERIFICATION ━━━━━━━━━━━━━━");
		System.out.println("Step " + (step - 1) + ": Display up to 100 candidates and fetch the exact matching count.");

		pagination_changer("100");
		p.Exact_count_icon().click();
		Thread.sleep(800);

		List<WebElement> Candidate_count = p.pagination_count_text();
		System.out.println("🟨 Debug: Candidate count element total = " + Candidate_count.size());

		if(Candidate_count.size() <= 1) {
			String errorMessage = "Candidate exact count was not available after applying filters.";
			Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure:</b> " + errorMessage);
			throw new IllegalStateException(errorMessage);
		}

		String Candidate_count_text = Candidate_count.get(1).getText().trim();

		Report_Listen.log_print_in_report().log(
				Status.PASS,
				"<b>✅ Final Result:</b> Candidate count fetched successfully. Time Range = " + Time_Range
				+ " | Status = " + status + " | Count = " + Candidate_count_text
		);
		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>"
		);

		System.out.println("✅ Final Result: Candidate count fetched successfully. Time Range = " + Time_Range
				+ " | Status = " + status + " | Count = " + Candidate_count_text);
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
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

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🔹 Scenario Title:</b> Validate Candidate Search by Full Name");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📥 Input:</b> Candidate Full Name = " + Full_Name);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>✅ Expected:</b> The searched candidate should be displayed in the Candidate list.");

	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println("🔹 Scenario Title: Validate Candidate Search by Full Name");
	System.out.println("📥 Input: Candidate Full Name = " + Full_Name);
	System.out.println("✅ Expected: The searched candidate should be displayed in the Candidate list.");
	System.out.println();

	Candidate_List_Accesor();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 🔍 CANDIDATE SEARCH ━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Search Candidate using Full Name = " + Full_Name);
	System.out.println("━━━━━━━━━━━━━━ 🔍 CANDIDATE SEARCH ━━━━━━━━━━━━━━");
	System.out.println("Step " + (step - 1) + ": Search Candidate using Full Name = " + Full_Name);

	WebElement search = jb.search_field();
	search.clear();
	search.sendKeys(Full_Name);
	Thread.sleep(800);

	try {
		rp.wait_for_invisibilty_of_theElement(jb.List_loader());
		System.out.println("🟨 Debug: Candidate list loader disappeared after search.");
	} catch(Exception e) {
		System.out.println("🟨 Debug: Candidate list loader was not displayed after search.");
	}

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ ✅ RESULT VERIFICATION ━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Verify the searched Candidate in the result table.");
	System.out.println("━━━━━━━━━━━━━━ ✅ RESULT VERIFICATION ━━━━━━━━━━━━━━");
	System.out.println("Step " + (step - 1) + ": Verify the searched Candidate in the result table.");

	String table_text = p.table_body().getText().trim();
	System.out.println("🟨 Debug: Candidate table text = " + table_text);

	if(table_text.contains("No record were found")) {
		String errorMessage = "Candidate was not found using Full Name = " + Full_Name;
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Final Result:</b> " + errorMessage);
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
		throw new IllegalStateException(errorMessage);
	}

	Report_Listen.log_print_in_report().log(
			Status.PASS,
			"<b>✅ Final Result:</b> Candidate was found successfully using Full Name = " + Full_Name
	);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");

	System.out.println("✅ Final Result: Candidate was found successfully using Full Name = " + Full_Name);
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println();
}
	
	
@Test(dataProvider = "Combined_Candidate_Job_Data")
public void Add_Candidate(TreeMap<String, String> candidate_data, TreeMap<String, String> job_data)
		throws IOException, InterruptedException, AWTException {

	int step = 1;

	String Job_Assign = job_data.get("Job Posting Name");
	String Email = candidate_data.get("Email");
	String Phone_Number = candidate_data.get("Phone Number");
	String First_Name = candidate_data.get("First Name");
	String Last_Name = candidate_data.get("Last Name");
	String Source = candidate_data.get("Source");
	String State = candidate_data.get("State");
	String Relevant_Experience = candidate_data.get("Relevant Experience");
	String Total_Experience = candidate_data.get("Total Experience");
	String Notice_Period = candidate_data.get("Notice Period");
	String Owner = candidate_data.get("Owner");
	String Recruiter = candidate_data.get("Recruiter");

	Candidate_Module_Locaters p = new Candidate_Module_Locaters(d);
	Repeat rp = new Repeat(d);
	Job_Module_locaters jp = new Job_Module_locaters(d);
	Robot r = new Robot();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🔹 Scenario Title:</b> Add Candidate and Assign a Job");
	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>📥 Input:</b> Candidate = " + First_Name + " " + Last_Name
			+ " | Email = " + Email + " | Job = " + Job_Assign
			+ " | Source = " + Source + " | State = " + State
			+ " | Owner = " + Owner + " | Recruiter = " + Recruiter
	);
	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>✅ Expected:</b> Candidate details should be saved successfully with the required job, source, state, owner, and recruiter."
	);

	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println("🔹 Scenario Title: Add Candidate and Assign a Job");
	System.out.println("📥 Input: Candidate = " + First_Name + " " + Last_Name + " | Email = " + Email
			+ " | Job = " + Job_Assign + " | Source = " + Source + " | State = " + State
			+ " | Owner = " + Owner + " | Recruiter = " + Recruiter);
	System.out.println("✅ Expected: Candidate details should be saved successfully with the required job, source, state, owner, and recruiter.");
	System.out.println();

	Candidate_List_Accesor();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 📝 CANDIDATE FORM ACCESS ━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Open the Add Candidate form.");
	System.out.println("━━━━━━━━━━━━━━ 📝 CANDIDATE FORM ACCESS ━━━━━━━━━━━━━━");
	System.out.println("Step " + (step - 1) + ": Open the Add Candidate form.");

	p.Add_Button().click();
	WebElement Pop_up_body = p.Pop_up_form();
	rp.movetoelement(Pop_up_body);

	List<WebElement> inputs_boxes = p.name_ph_email_input_fieldsBox();
	List<WebElement> dropdowns = p.Pop_Up_Form_Custom_Dropdown_fields();
	System.out.println("🟨 Debug: Candidate input group count = " + inputs_boxes.size());
	System.out.println("🟨 Debug: Candidate dropdown count = " + dropdowns.size());

	Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Add Candidate form opened successfully.");
	System.out.println("✅ Actual: Add Candidate form opened successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 💼 JOB ASSIGNMENT ━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Assign Candidate to Job = " + Job_Assign);
	System.out.println("━━━━━━━━━━━━━━ 💼 JOB ASSIGNMENT ━━━━━━━━━━━━━━");
	System.out.println("Step " + (step - 1) + ": Assign Candidate to Job = " + Job_Assign);

	WebElement Assign_Job_Dropdown = dropdowns.get(0);
	Assign_Job_Dropdown.click();
	p.Assign_job_input().sendKeys(Job_Assign);
	Thread.sleep(800);

	WebElement dropdown_list = jp.First_dropdown_list();
	rp.movetoelement(dropdown_list);
	Thread.sleep(800);

	WebElement Required_Job_Option = null;
	for(WebElement job_option : jp.First_dropdown_Options()) {
		String Job_Option_Text = job_option.getText().trim();
		System.out.println("🟨 Debug: Job option found = " + Job_Option_Text);
		if(Job_Option_Text.equalsIgnoreCase(Job_Assign)) {
			Required_Job_Option = job_option;
			break;
		}
	}

	if(Required_Job_Option == null) {
		String errorMessage = "Required Job was not found in Assign Job dropdown = " + Job_Assign;
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure:</b> " + errorMessage);
		throw new IllegalStateException(errorMessage);
	}

	rp.Scroll_to_element(Required_Job_Option);
	Required_Job_Option.click();
	Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Candidate assigned successfully to Job = " + Job_Assign);
	System.out.println("✅ Actual: Candidate assigned successfully to Job = " + Job_Assign);
	System.out.println();

	p.form_scroll().click();
	r.mouseWheel(6);

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 👤 CANDIDATE DETAILS ━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Enter Candidate details and select Source and State.");
	System.out.println("━━━━━━━━━━━━━━ 👤 CANDIDATE DETAILS ━━━━━━━━━━━━━━");
	System.out.println("Step " + (step - 1) + ": Enter Candidate details and select Source and State.");

	List<WebElement> inputs = p.name_ph_email_input_fields();
	inputs.get(0).sendKeys(Email);
	inputs.get(1).sendKeys(Phone_Number);
	inputs.get(2).sendKeys(First_Name);
	inputs.get(3).sendKeys(Last_Name);

	r.mouseWheel(1);
	Thread.sleep(800);
	p.Sourcefield().click();
	p.source_input().sendKeys(Source);
	Thread.sleep(500);

	List<WebElement> Source_Options = p.Source_Dropdown().findElements(
			By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]")
	);
	WebElement Required_Source_Option = null;
	for(WebElement source_option : Source_Options) {
		String Source_Option_Text = source_option.getText().trim();
		System.out.println("🟨 Debug: Source option found = " + Source_Option_Text);
		if(Source_Option_Text.equalsIgnoreCase(Source)) {
			Required_Source_Option = source_option;
			break;
		}
	}
	if(Required_Source_Option == null) {
		String errorMessage = "Required Candidate Source was not found = " + Source;
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure:</b> " + errorMessage);
		throw new IllegalStateException(errorMessage);
	}
	Required_Source_Option.click();

	WebElement State_field = p.State_field();
	r.mouseWheel(1);
	rp.movetoelement(State_field);
	State_field.click();
	p.State_input().sendKeys(State);
	Thread.sleep(500);

	List<WebElement> State_Options = p.state_Dropdown().findElements(
			By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]")
	);
	WebElement Required_State_Option = null;
	for(WebElement state_option : State_Options) {
		String State_Option_Text = state_option.getText().trim();
		System.out.println("🟨 Debug: State option found = " + State_Option_Text);
		if(State_Option_Text.equalsIgnoreCase(State)) {
			Required_State_Option = state_option;
			break;
		}
	}
	if(Required_State_Option == null) {
		String errorMessage = "Required Candidate State was not found = " + State;
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure:</b> " + errorMessage);
		throw new IllegalStateException(errorMessage);
	}
	Required_State_Option.click();

	String options_text = p.Selected_option().getText().trim();
	Report_Listen.log_print_in_report().log(
			Status.PASS,
			"<b>✅ Actual:</b> Candidate details entered successfully. Candidate = " + First_Name + " " + Last_Name
			+ " | Email = " + Email + " | Source = " + Source + " | State = " + options_text
	);
	System.out.println("✅ Actual: Candidate details entered successfully. Candidate = " + First_Name + " " + Last_Name
			+ " | Email = " + Email + " | Source = " + Source + " | State = " + options_text);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 📊 EXPERIENCE DETAILS ━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Enter Candidate experience and notice-period details.");
	System.out.println("━━━━━━━━━━━━━━ 📊 EXPERIENCE DETAILS ━━━━━━━━━━━━━━");
	System.out.println("Step " + (step - 1) + ": Enter Candidate experience and notice-period details.");

	WebElement RelevantExperience = inputs.get(4);
	rp.Scroll_to_element(RelevantExperience);
	RelevantExperience.sendKeys(Relevant_Experience);
	inputs.get(5).sendKeys(Total_Experience);
	inputs_boxes.get(6).click();
	inputs.get(6).sendKeys(Notice_Period);

	Report_Listen.log_print_in_report().log(
			Status.PASS,
			"<b>✅ Actual:</b> Experience details entered successfully. Relevant Experience = " + Relevant_Experience
			+ " | Total Experience = " + Total_Experience + " | Notice Period = " + Notice_Period
	);
	System.out.println("✅ Actual: Experience details entered successfully. Relevant Experience = " + Relevant_Experience
			+ " | Total Experience = " + Total_Experience + " | Notice Period = " + Notice_Period);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 👥 OWNER AND RECRUITER ━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Assign Candidate Owner and Recruiter.");
	System.out.println("━━━━━━━━━━━━━━ 👥 OWNER AND RECRUITER ━━━━━━━━━━━━━━");
	System.out.println("Step " + (step - 1) + ": Assign Candidate Owner and Recruiter.");

	WebElement Owner_field = p.Ownerfield();
	rp.Scroll_to_element(Owner_field);
	rp.movetoelement(Owner_field);
	Thread.sleep(800);
	Owner_field.click();
	Thread.sleep(800);
	p.Owner_input().sendKeys(Owner);
	Thread.sleep(800);

	List<WebElement> Owner_Options = p.Owner_Dropdown().findElements(
			By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]")
	);
	WebElement Required_Owner_Option = null;
	for(WebElement owner_option : Owner_Options) {
		String Owner_Option_Text = owner_option.getText().trim();
		System.out.println("🟨 Debug: Owner option found = " + Owner_Option_Text);
		if(Owner_Option_Text.equalsIgnoreCase(Owner)) {
			Required_Owner_Option = owner_option;
			break;
		}
	}
	if(Required_Owner_Option == null) {
		String errorMessage = "Required Candidate Owner was not found = " + Owner;
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure:</b> " + errorMessage);
		throw new IllegalStateException(errorMessage);
	}
	Required_Owner_Option.click();

	p.form_scroll().click();
	WebElement Recruiter_field = p.recruiterfield();
	Recruiter_field.click();
	p.recruiter_input().sendKeys(Recruiter);
	Thread.sleep(500);

	List<WebElement> Recruiter_Options = p.recruiter_Dropdown().findElements(
			By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]")
	);
	WebElement Required_Recruiter_Option = null;
	for(WebElement recruiter_option : Recruiter_Options) {
		String Recruiter_Option_Text = recruiter_option.getText().trim();
		System.out.println("🟨 Debug: Recruiter option found = " + Recruiter_Option_Text);
		if(Recruiter_Option_Text.equalsIgnoreCase(Recruiter)) {
			Required_Recruiter_Option = recruiter_option;
			break;
		}
	}
	if(Required_Recruiter_Option == null) {
		String errorMessage = "Required Candidate Recruiter was not found = " + Recruiter;
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure:</b> " + errorMessage);
		throw new IllegalStateException(errorMessage);
	}
	Required_Recruiter_Option.click();

	Report_Listen.log_print_in_report().log(
			Status.PASS,
			"<b>✅ Actual:</b> Candidate Owner and Recruiter assigned successfully. Owner = " + Owner + " | Recruiter = " + Recruiter
	);
	System.out.println("✅ Actual: Candidate Owner and Recruiter assigned successfully. Owner = " + Owner + " | Recruiter = " + Recruiter);
	System.out.println();

	Thread.sleep(500);
	p.form_scroll().click();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 💾 SAVE AND CONFIRMATION ━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Save the Candidate and verify the confirmation message.");
	System.out.println("━━━━━━━━━━━━━━ 💾 SAVE AND CONFIRMATION ━━━━━━━━━━━━━━");
	System.out.println("Step " + (step - 1) + ": Save the Candidate and verify the confirmation message.");

	WebElement Save = p.Modal_Save_Button();
	rp.Scroll_to_element(Save);
	rp.movetoelement(Save);
	Thread.sleep(800);
	Save.click();

	rp.wait_for_invisibilty_of_theElement(Pop_up_body);
	String success_toast_text = p.Success_Toast_Message().getText().trim();

	Report_Listen.log_print_in_report().log(
			Status.PASS,
			"<b>✅ Final Result:</b> Candidate added successfully. Candidate = " + First_Name + " " + Last_Name
			+ " | Job = " + Job_Assign + " | Confirmation = " + success_toast_text
	);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");

	System.out.println("✅ Final Result: Candidate added successfully. Candidate = " + First_Name + " " + Last_Name
			+ " | Job = " + Job_Assign + " | Confirmation = " + success_toast_text);
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println();
}
	

	public void Load_Member_Names_For_Interview() throws IOException, InterruptedException {

		Member_Module mb = new Member_Module();
		mb.d = this.d;
		mb.Target_url = this.Target_url;

		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>━━━━━━━━━━━━━━ 👥 MEMBER DATA PREPARATION ━━━━━━━━━━━━━━</b>"
		);
		System.out.println("━━━━━━━━━━━━━━ 👥 MEMBER DATA PREPARATION ━━━━━━━━━━━━━━");

		Member_Names_List.clear();
		mb.Member_List_Data_Collector();

		System.out.println("🟨 Debug: Member names fetched = " + mb.Member_Names.size());

		if(mb.Member_Names.isEmpty()) {
			String errorMessage = "No member names were available for interview scheduling.";
			Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure:</b> " + errorMessage);
			throw new IllegalStateException(errorMessage);
		}

		Member_Names_List.addAll(mb.Member_Names);

		Report_Listen.log_print_in_report().log(
				Status.PASS,
				"<b>✅ Actual:</b> Member names loaded successfully for interview scheduling. Total Members = " + Member_Names_List.size()
		);
		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>"
		);

		System.out.println("✅ Actual: Member names loaded successfully for interview scheduling. Total Members = " + Member_Names_List.size());
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println();
	}

@Test(dataProvider = "Candidate_Add_Data")
public void Candidate_Interview_scheduling(TreeMap<String, String> candidate_data) throws IOException, InterruptedException {

	int step = 1;
	Candidate_Module_Locaters p = new Candidate_Module_Locaters(d);
	Repeat rp = new Repeat(d);
	Job_Module_locaters jb = new Job_Module_locaters(d);

	String First_Name = candidate_data.get("First Name");
	String Candidate_Index = candidate_data.get("Index");
	String Candidate_Ph_number = candidate_data.get("Phone Number");
	String Dial_in_number = Candidate_Ph_number.replace("1", "7");

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🔹 Scenario Title:</b> Schedule Candidate Phone Interview");
	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>📥 Input:</b> Candidate = " + First_Name + " | Member Index = " + Candidate_Index
			+ " | Interview Type = Phone Interview | End Time = 9:00 PM"
	);
	Report_Listen.log_print_in_report().log(
			Status.INFO,
			"<b>✅ Expected:</b> The Candidate interview should be scheduled successfully with a valid host, recruiter, dial-in number, and notification."
	);

	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println("🔹 Scenario Title: Schedule Candidate Phone Interview");
	System.out.println("📥 Input: Candidate = " + First_Name + " | Member Index = " + Candidate_Index
			+ " | Interview Type = Phone Interview | End Time = 9:00 PM");
	System.out.println("✅ Expected: The Candidate interview should be scheduled successfully with a valid host, recruiter, dial-in number, and notification.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 👥 MEMBER MAPPING ━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Load and select a member for interview host and recruiter mapping.");
	System.out.println("━━━━━━━━━━━━━━ 👥 MEMBER MAPPING ━━━━━━━━━━━━━━");
	System.out.println("Step " + (step - 1) + ": Load and select a member for interview host and recruiter mapping.");

	Load_Member_Names_For_Interview();

	int i = Integer.parseInt(Candidate_Index);
	if(i >= Member_Names_List.size()) {
		String errorMessage = "Not enough members are available for Member Index = " + i
				+ ". Total Members = " + Member_Names_List.size();
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure:</b> " + errorMessage);
		throw new IllegalStateException(errorMessage);
	}

	String member_name = Member_Names_List.get(i);
	Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Interview host and recruiter selected from member data = " + member_name);
	System.out.println("✅ Actual: Interview host and recruiter selected from member data = " + member_name);
	System.out.println();

	Candidate_List_Accesor();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 🔍 CANDIDATE ACCESS ━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Search and open Candidate = " + First_Name);
	System.out.println("━━━━━━━━━━━━━━ 🔍 CANDIDATE ACCESS ━━━━━━━━━━━━━━");
	System.out.println("Step " + (step - 1) + ": Search and open Candidate = " + First_Name);

	WebElement search = jb.search_field();
	search.clear();
	search.sendKeys(First_Name);
	Thread.sleep(800);

	try {
		rp.wait_for_invisibilty_of_theElement(jb.List_loader());
		System.out.println("🟨 Debug: Candidate list loader disappeared after search.");
	} catch(Exception e) {
		System.out.println("🟨 Debug: Candidate list loader was not displayed after search.");
	}

	List<WebElement> searched_candidates = p.candidate_names_in_list();
	System.out.println("🟨 Debug: Matching Candidate count = " + searched_candidates.size());
	if(searched_candidates.isEmpty()) {
		String errorMessage = "No Candidate was found using First Name = " + First_Name;
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure:</b> " + errorMessage);
		throw new IllegalStateException(errorMessage);
	}

	WebElement First_candidate = searched_candidates.get(0);
	rp.movetoelement(First_candidate);
	First_candidate.findElement(By.xpath(".//a")).click();

	List<WebElement> Candidate_tabs = p.Tab_Buttons();
	Candidate_tabs.get(2).click();
	p.schedule_interview_button().click();
	WebElement popup_form = p.Pop_up_form();

	Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Candidate profile opened and interview scheduling form displayed successfully.");
	System.out.println("✅ Actual: Candidate profile opened and interview scheduling form displayed successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 📅 INTERVIEW DETAILS ━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Configure interview date, type, end time, and dial-in number.");
	System.out.println("━━━━━━━━━━━━━━ 📅 INTERVIEW DETAILS ━━━━━━━━━━━━━━");
	System.out.println("Step " + (step - 1) + ": Configure interview date, type, end time, and dial-in number.");

	List<WebElement> interview_inputs = p.Pop_Up_Form_Custom_Dropdown_fields();
	p.Date_picker_field().click();

	WebElement Required_Date_Option = null;
	for(WebElement date_option : jb.Job_Expiry_unselected_dates_in_calender()) {
		String date_text = date_option.getText().trim();
		System.out.println("🟨 Debug: Interview date option found = " + date_text);
		if(date_text.contains("30")) {
			Required_Date_Option = date_option;
			break;
		}
	}
	if(Required_Date_Option == null) {
		String errorMessage = "Interview date option containing 30 was not available.";
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure:</b> " + errorMessage);
		throw new IllegalStateException(errorMessage);
	}
	Required_Date_Option.click();

	interview_inputs.get(1).click();
	List<WebElement> Interview_Type_options = p.Interview_Type_Dropdown().findElements(
			By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]")
	);
	WebElement Required_Interview_Type = null;
	for(WebElement interview_type_option : Interview_Type_options) {
		String Interview_Type_Text = interview_type_option.getText().trim();
		System.out.println("🟨 Debug: Interview type option found = " + Interview_Type_Text);
		if(Interview_Type_Text.equalsIgnoreCase("Phone Interview")) {
			Required_Interview_Type = interview_type_option;
			break;
		}
	}
	if(Required_Interview_Type == null) {
		String errorMessage = "Phone Interview option was not available.";
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure:</b> " + errorMessage);
		throw new IllegalStateException(errorMessage);
	}
	Required_Interview_Type.click();

	WebElement End_time = p.endTime_input();
	End_time.clear();
	End_time.sendKeys("9:00 PM");
	Thread.sleep(500);

	List<WebElement> time_options = p.state_Dropdown().findElements(
			By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]")
	);
	WebElement Required_Time_Option = null;
	for(WebElement time_option : time_options) {
		String Time_Option_Text = time_option.getText().trim();
		System.out.println("🟨 Debug: Interview end-time option found = " + Time_Option_Text);
		if(Time_Option_Text.equalsIgnoreCase("9:00 PM")) {
			Required_Time_Option = time_option;
			break;
		}
	}
	if(Required_Time_Option == null) {
		String errorMessage = "Interview End Time option was not available = 9:00 PM";
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure:</b> " + errorMessage);
		throw new IllegalStateException(errorMessage);
	}
	Required_Time_Option.click();

	p.Dial_in_number_input().sendKeys(Dial_in_number);

	Report_Listen.log_print_in_report().log(
			Status.PASS,
			"<b>✅ Actual:</b> Interview details configured successfully. Type = Phone Interview | End Time = 9:00 PM | Dial-in Number = " + Dial_in_number
	);
	System.out.println("✅ Actual: Interview details configured successfully. Type = Phone Interview | End Time = 9:00 PM | Dial-in Number = " + Dial_in_number);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 🧑‍💼 HOST AND RECRUITER ━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Assign the interview host and recruiter.");
	System.out.println("━━━━━━━━━━━━━━ 🧑‍💼 HOST AND RECRUITER ━━━━━━━━━━━━━━");
	System.out.println("Step " + (step - 1) + ": Assign the interview host and recruiter.");

	WebElement Host = interview_inputs.get(4);
	Host.click();
	p.interviewHost_input().sendKeys(member_name);

	List<WebElement> Host_Options = p.Owner_Dropdown_backup().findElements(
			By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]")
	);
	WebElement Required_Host_Option = null;
	for(WebElement host_option : Host_Options) {
		String Host_Option_Text = host_option.getText().trim();
		System.out.println("🟨 Debug: Host option found = " + Host_Option_Text);
		if(Host_Option_Text.equalsIgnoreCase(member_name)) {
			Required_Host_Option = host_option;
			break;
		}
	}
	if(Required_Host_Option == null) {
		String errorMessage = "Required Interview Host was not found = " + member_name;
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure:</b> " + errorMessage);
		throw new IllegalStateException(errorMessage);
	}
	Required_Host_Option.click();

	WebElement Recruiter = interview_inputs.get(5);
	rp.Scroll_to_element(Recruiter);
	Recruiter.click();

	List<WebElement> Recruiter_Options = p.recruiter_Dropdown_backup().findElements(
			By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]")
	);
	WebElement Required_Recruiter_Option = null;
	for(WebElement recruiter_option : Recruiter_Options) {
		String Recruiter_Option_Text = recruiter_option.getText().trim();
		System.out.println("🟨 Debug: Interview recruiter option found = " + Recruiter_Option_Text);
		if(Recruiter_Option_Text.equalsIgnoreCase(member_name)) {
			Required_Recruiter_Option = recruiter_option;
			break;
		}
	}
	if(Required_Recruiter_Option == null) {
		String errorMessage = "Required Interview Recruiter was not found = " + member_name;
		Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure:</b> " + errorMessage);
		throw new IllegalStateException(errorMessage);
	}
	Required_Recruiter_Option.click();

	Report_Listen.log_print_in_report().log(
			Status.PASS,
			"<b>✅ Actual:</b> Interview host and recruiter assigned successfully = " + member_name
	);
	System.out.println("✅ Actual: Interview host and recruiter assigned successfully = " + member_name);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ 📩 SAVE AND NOTIFICATION ━━━━━━━━━━━━━━</b>");
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Save the interview schedule and send the notification.");
	System.out.println("━━━━━━━━━━━━━━ 📩 SAVE AND NOTIFICATION ━━━━━━━━━━━━━━");
	System.out.println("Step " + (step - 1) + ": Save the interview schedule and send the notification.");

	WebElement Save = p.Modal_Save_Button();
	rp.Scroll_to_element(Save);
	Save.click();

	WebElement Notify_Button = p.notify_button();
	rp.Scroll_to_element(Notify_Button);
	Notify_Button.click();

	rp.wait_for_invisibilty_of_theElement(popup_form);
	String success_toast_text = p.Success_Toast_Message().getText().trim();

	Report_Listen.log_print_in_report().log(
			Status.PASS,
			"<b>✅ Final Result:</b> Candidate interview scheduled successfully. Candidate = " + First_Name
			+ " | Host/Recruiter = " + member_name + " | Confirmation = " + success_toast_text
	);
	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");

	System.out.println("✅ Final Result: Candidate interview scheduled successfully. Candidate = " + First_Name
			+ " | Host/Recruiter = " + member_name + " | Confirmation = " + success_toast_text);
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println();
}

	public void Candidate_job_status_change(String Status_value) throws IOException, InterruptedException {

		Candidate_Module_Locaters p = new Candidate_Module_Locaters(d);
		Repeat rp = new Repeat(d);

		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>━━━━━━━━━━━━━━ 🔄 JOB APPLICATION STATUS UPDATE ━━━━━━━━━━━━━━</b>"
		);
		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>📥 Input:</b> Required Status = " + Status_value
		);
		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>✅ Expected:</b> Candidate job application status should be updated successfully."
		);

		System.out.println("━━━━━━━━━━━━━━ 🔄 JOB APPLICATION STATUS UPDATE ━━━━━━━━━━━━━━");
		System.out.println("📥 Input: Required Status = " + Status_value);
		System.out.println("✅ Expected: Candidate job application status should be updated successfully.");

		List<WebElement> Candidate_tabs = p.Tab_Buttons();
		WebElement Job_Applied_Tab = Candidate_tabs.get(1);
		rp.movetoelement(Job_Applied_Tab);
		Job_Applied_Tab.click();

		p.Application_status_Dropdown().click();
		List<WebElement> Status_Options = p.Owner_Dropdown().findElements(
				By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]")
		);

		WebElement Required_Status_Option = null;
		for(WebElement status_option : Status_Options) {
			String Status_Option_Text = status_option.getText().trim();
			System.out.println("🟨 Debug: Application status option found = " + Status_Option_Text);
			if(Status_Option_Text.equalsIgnoreCase(Status_value)) {
				Required_Status_Option = status_option;
				break;
			}
		}

		if(Required_Status_Option == null) {
			String errorMessage = "Required Candidate job application status was not found = " + Status_value;
			Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure:</b> " + errorMessage);
			throw new IllegalStateException(errorMessage);
		}

		Required_Status_Option.click();

		Report_Listen.log_print_in_report().log(
				Status.PASS,
				"<b>✅ Final Result:</b> Candidate job application status updated successfully = " + Status_value
		);
		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>"
		);

		System.out.println("✅ Final Result: Candidate job application status updated successfully = " + Status_value);
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
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

		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>━━━━━━━━━━━━━━ 🔎 FILTER CONFIGURATION ━━━━━━━━━━━━━━</b>"
		);
		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>Step " + (step++) + ":</b> Select All Stages before fetching the total Candidate count."
		);

		System.out.println("━━━━━━━━━━━━━━ 🔎 FILTER CONFIGURATION ━━━━━━━━━━━━━━");
		System.out.println("Step " + (step - 1) + ": Select All Stages before fetching the total Candidate count.");

		List<WebElement> candidate_Filters = cp.Candidate_List_Filter_Dropdowns();
		WebElement all_stage_filter = candidate_Filters.get(3);

		r.mouseWheel(-25);
		rp.movetoelement(all_stage_filter);
		all_stage_filter.click();

		List<WebElement> Stage_Options = cp.stages_Dropdown().findElements(
				By.xpath(".//div[contains(@class,'ant-select-item') and contains(@class,'ant-select-item-option')]")
		);

		WebElement All_Stages_Option = null;
		for(WebElement stage_option : Stage_Options) {
			String Stage_Title = stage_option.getAttribute("title");
			System.out.println("🟨 Debug: Stage option title = " + Stage_Title);
			if(Stage_Title != null && Stage_Title.trim().contains("All Stages")) {
				All_Stages_Option = stage_option;
				break;
			}
		}

		if(All_Stages_Option == null) {
			String errorMessage = "All Stages option was not found in Candidate stage filter.";
			Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure:</b> " + errorMessage);
			throw new NoSuchElementException(errorMessage);
		}

		All_Stages_Option.findElement(
				By.xpath(".//div[contains(@class,'ant-select-item-option-content')]")
		).click();

		all_stage_filter.click();
		Thread.sleep(800);

		String Selection_Confirmation = all_stage_filter
				.findElement(By.xpath(".//span[contains(@title,'5 Selected')]"))
				.getText().trim();
		System.out.println("🟨 Debug: Stage selection confirmation = " + Selection_Confirmation);

		Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> All Candidate stages selected successfully.");
		System.out.println("✅ Actual: All Candidate stages selected successfully.");
		System.out.println();

		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>━━━━━━━━━━━━━━ 🔢 CANDIDATE COUNT VERIFICATION ━━━━━━━━━━━━━━</b>"
		);
		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>Step " + (step++) + ":</b> Display up to 100 Candidates and fetch the exact total count."
		);

		System.out.println("━━━━━━━━━━━━━━ 🔢 CANDIDATE COUNT VERIFICATION ━━━━━━━━━━━━━━");
		System.out.println("Step " + (step - 1) + ": Display up to 100 Candidates and fetch the exact total count.");

		pagination_changer("100");
		cp.Exact_count_icon().click();
		Thread.sleep(800);

		List<WebElement> candidates_count = cp.pagination_count_text();
		System.out.println("🟨 Debug: Candidate count text element total = " + candidates_count.size());

		if(candidates_count.size() <= 1) {
			String errorMessage = "Candidate exact count was not available.";
			Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Failure:</b> " + errorMessage);
			throw new IllegalStateException(errorMessage);
		}

		for(WebElement count : candidates_count) {
			System.out.println("🟨 Debug: Candidate count confirmation text = " + count.getText().trim());
		}

		String Total_Candidate_Count = candidates_count.get(1).getText().trim();
		Overview_Cards_Data.put("Total Candidate Count", Total_Candidate_Count);

		Report_Listen.log_print_in_report().log(
				Status.PASS,
				"<b>✅ Final Result:</b> Total Candidate count fetched successfully = " + Total_Candidate_Count
		);
		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>"
		);

		System.out.println("✅ Final Result: Total Candidate count fetched successfully = " + Total_Candidate_Count);
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
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

		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>━━━━━━━━━━━━━━ 📄 IMPORT CV ACCESS ━━━━━━━━━━━━━━</b>"
		);
		System.out.println("━━━━━━━━━━━━━━ 📄 IMPORT CV ACCESS ━━━━━━━━━━━━━━");

		WebElement Import = Candidate_List_Accesor();
		Import.click();

		Report_Listen.log_print_in_report().log(
				Status.PASS,
				"<b>✅ Actual:</b> Candidate Import CV section opened successfully."
		);
		Report_Listen.log_print_in_report().log(
				Status.INFO,
				"<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>"
		);

		System.out.println("✅ Actual: Candidate Import CV section opened successfully.");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println();
	}
    
    @Test(dataProvider = "Candidate_CV_Upload_Files")
    public void CV_upload(TreeMap<String, String> file) throws IOException, InterruptedException {

    	int step = 1;
    	Candidate_Module_Locaters p = new Candidate_Module_Locaters(d);

    	String File_Type = file.get("File Type");
    	String File_Path = file.get("File Path");
    	String Expected_Result;

    	if(File_Type.toLowerCase().startsWith("valid")) {
    		Expected_Result = "The CV should be accepted and parsed successfully.";
    	} else {
    		Expected_Result = "The unsupported file should be rejected and CV parsing should not complete.";
    	}

    	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
    	Report_Listen.log_print_in_report().log(Status.INFO, "<b>🔹 Scenario Title:</b> Validate Candidate CV Upload");
    	Report_Listen.log_print_in_report().log(Status.INFO, "<b>📥 Input:</b> File Type = " + File_Type);
    	Report_Listen.log_print_in_report().log(Status.INFO, "<b>✅ Expected:</b> " + Expected_Result);

    	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    	System.out.println("🔹 Scenario Title: Validate Candidate CV Upload");
    	System.out.println("📥 Input: File Type = " + File_Type);
    	System.out.println("✅ Expected: " + Expected_Result);
    	System.out.println("🟨 Debug: Upload File Path = " + File_Path);
    	System.out.println();

    	Import_CV_Accessor();

    	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ ⬆️ FILE UPLOAD ━━━━━━━━━━━━━━</b>");
    	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Upload the configured Candidate CV file.");
    	System.out.println("━━━━━━━━━━━━━━ ⬆️ FILE UPLOAD ━━━━━━━━━━━━━━");
    	System.out.println("Step " + (step - 1) + ": Upload the configured Candidate CV file.");

    	p.Upload_Field().sendKeys(File_Path);

    	Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Candidate CV file submitted successfully. File Type = " + File_Type);
    	System.out.println("✅ Actual: Candidate CV file submitted successfully. File Type = " + File_Type);
    	System.out.println();

    	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━ ✅ UPLOAD RESULT ━━━━━━━━━━━━━━</b>");
    	Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Verify the CV upload result.");
    	System.out.println("━━━━━━━━━━━━━━ ✅ UPLOAD RESULT ━━━━━━━━━━━━━━");
    	System.out.println("Step " + (step - 1) + ": Verify the CV upload result.");

    	if(File_Type.toLowerCase().startsWith("valid")) {

    		p.Parsing_cv();

    		Report_Listen.log_print_in_report().log(
    				Status.PASS,
    				"<b>✅ Final Result:</b> Candidate CV was uploaded and parsed successfully. File Type = " + File_Type
    		);
    		Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");

    		System.out.println("✅ Final Result: Candidate CV was uploaded and parsed successfully. File Type = " + File_Type);
    		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    		System.out.println();
    		return;
    	}

    	try {
    		p.Parsing_cv();
    	} catch(Exception expectedRejection) {

    		System.out.println("🟨 Debug: Unsupported CV file was rejected. Reason = " + expectedRejection.getMessage());

    		Report_Listen.log_print_in_report().log(
    				Status.PASS,
    				"<b>✅ Final Result:</b> Unsupported Candidate CV file was rejected successfully. File Type = " + File_Type
    		);
    		Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");

    		System.out.println("✅ Final Result: Unsupported Candidate CV file was rejected successfully. File Type = " + File_Type);
    		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    		System.out.println();
    		return;
    	}

    	String errorMessage = "Unsupported Candidate CV file was accepted unexpectedly. File Type = " + File_Type;
    	Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Final Result:</b> " + errorMessage);
    	Report_Listen.log_print_in_report().log(Status.INFO, "<b>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</b>");
    	throw new IllegalStateException(errorMessage);
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