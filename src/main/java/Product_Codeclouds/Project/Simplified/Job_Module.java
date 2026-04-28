package Product_Codeclouds.Project.Simplified;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Job_Module_locaters;
import Repeatative_codes.Repeat;

public class Job_Module extends Candidate_module{

	
	
	
	public WebElement Access_Job_Module_List() throws IOException, InterruptedException {

	Job_Module_locaters p = new Job_Module_locaters(d);

	System.out.println();
	System.out.println("--------------------------------------------------");
	System.out.println("Step: Open side menu and access Jobs module list.");
	System.out.println("--------------------------------------------------");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step:</b> Open side menu and access Jobs module list.");

	Menu_option_selector("Jobs");

	WebElement Job_Button = p.Add_Job();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Jobs module list was accessed successfully and Add Job button was located.");
	System.out.println("🟨 Actual: Jobs module list was accessed successfully and Add Job button was located.");
	System.out.println();

	return Job_Button;
}
	
	@Test(dataProvider = "Job_Posting_Data")
    public void Job_Add(TreeMap<String, String> job_data) throws IOException, InterruptedException, AWTException {

	int step = 1;

	Job_Module_locaters p = new Job_Module_locaters(d);
	JavascriptExecutor js = (JavascriptExecutor) d;
	Repeat rp = new Repeat(d);
	Robot r = new Robot();

	String Select_Template = job_data.get("Select Template");

	String Job_Posting_Name = job_data.get("Job Posting Name");
	String Expiry_Date = job_data.get("Expiry Date");
	String Job_Urgency = job_data.get("Job Urgency");

	String Job_Title = job_data.get("Job Title");
	String Department_Division = job_data.get("Department / Division");
	String Employment_Type = job_data.get("Employment Type");
	String Category = job_data.get("Category");

	String Required_Education = job_data.get("Required Education");
	String Required_Experience = job_data.get("Required Experience");
	String Expected_Hiring_Date = job_data.get("Expected Hiring Date");
	String Number_Of_Positions = job_data.get("Number of Positions");
	String When_Positions_Fulfilled = job_data.get("When Positions Fulfilled");

	String Job_Description = job_data.get("Job Description");
	String Job_Requirements = job_data.get("Job Requirements");
	String Benefits = job_data.get("Benefits");

	String Country = job_data.get("Country");
	String City_State = job_data.get("City / State");
	String Remote = job_data.get("Remote");

	String Salary_From_1 = job_data.get("Salary From 1");
	String Salary_To_1 = job_data.get("Salary To 1");
	String Unit_1 = job_data.get("Unit 1");
	String Currency_1 = job_data.get("Currency 1");

	String Salary_From_2 = job_data.get("Salary From 2");
	String Salary_To_2 = job_data.get("Salary To 2");
	String Unit_2 = job_data.get("Unit 2");
	String Currency_2 = job_data.get("Currency 2");

	String Salary_From_3 = job_data.get("Salary From 3");
	String Salary_To_3 = job_data.get("Salary To 3");
	String Unit_3 = job_data.get("Unit 3");
	String Currency_3 = job_data.get("Currency 3");

	String Screening_Question_1 = job_data.get("Screening Question 1");
	String Screening_Question_2 = job_data.get("Screening Question 2");
	String Screening_Question_3 = job_data.get("Screening Question 3");

	String Save_As_Job_Posting_Template = job_data.get("Save As Job Posting Template");

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🔹 Scenario Title:</b> Add new job posting in Hire module");
	System.out.println();
	System.out.println("🔹 Scenario Title: Add new job posting in Hire module");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📘 Description:</b> Open the Job Add form, enter required job posting details, configure screening question, navigate through workflow, and publish the job successfully.");
	System.out.println("📘 Description: Open the Job Add form, enter required job posting details, configure screening question, navigate through workflow, and publish the job successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📥 Input:</b> Job Posting Name = " + Job_Posting_Name
					+ " | Job Title = " + Job_Title
					+ " | Job Urgency = " + Job_Urgency
					+ " | Department / Division = " + Department_Division
					+ " | Employment Type = " + Employment_Type
					+ " | Category = " + Category
					+ " | Required Education = " + Required_Education
					+ " | Required Experience = " + Required_Experience
					+ " | Number Of Positions = " + Number_Of_Positions
					+ " | Screening Question 1 = " + Screening_Question_1);
	System.out.println("📥 Input: Job Posting Name = " + Job_Posting_Name
			+ " | Job Title = " + Job_Title
			+ " | Job Urgency = " + Job_Urgency
			+ " | Department / Division = " + Department_Division
			+ " | Employment Type = " + Employment_Type
			+ " | Category = " + Category
			+ " | Required Education = " + Required_Education
			+ " | Required Experience = " + Required_Experience
			+ " | Number Of Positions = " + Number_Of_Positions
			+ " | Screening Question 1 = " + Screening_Question_1);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>✅ Expected:</b> Job Add form should open successfully, required values should be entered correctly, screening question should be added successfully, workflow page should load properly, and job should be published with success confirmation.");
	System.out.println("✅ Expected: Job Add form should open successfully, required values should be entered correctly, screening question should be added successfully, workflow page should load properly, and job should be published with success confirmation.");
	System.out.println();

	try {
		WebElement JobButton = p.Add_Job();
		JobButton.click();
		WebElement Forms = p.Form();
		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Job Add form was already available.");
		System.out.println("🟨 Actual: Job Add form was already available.");
		System.out.println();

	} catch (Exception eod) {
		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Access Jobs module and open Job Add form.");
		System.out.println("Step " + (step - 1) + ": Access Jobs module and open Job Add form.");
		System.out.println();

		Access_Job_Module_List();
		WebElement JobButton = p.Add_Job();
		JobButton.click();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Add Job button clicked successfully and Job Add form opening was initiated.");
		System.out.println("🟨 Actual: Add Job button clicked successfully and Job Add form opening was initiated.");
		System.out.println();
	}

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Move to Job Add form for stable interaction.");
	System.out.println("Step " + (step - 1) + ": Move to Job Add form for stable interaction.");
	System.out.println();

	try {
		WebElement Form_try = p.Form();
		rp.movetoelement(Form_try);

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Moved to Job Add form successfully.");
		System.out.println("🟨 Actual: Moved to Job Add form successfully.");
		System.out.println();

	} catch (StaleElementReferenceException e) {
		Report_Listen.log_print_in_report().log(Status.WARNING,
				"<b>⚠ Retry:</b> Form element became stale while moving to it. Refetching and retrying the same operation.");
		System.out.println("⚠ Retry: Form element became stale while moving to it. Refetching and retrying the same operation.");
		System.out.println();

		Thread.sleep(800);
		WebElement Form_retry = p.Form();
		rp.movetoelement(Form_retry);

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Form element was refetched and move action completed successfully.");
		System.out.println("🟨 Actual: Form element was refetched and move action completed successfully.");
		System.out.println();
	}

	Thread.sleep(800);
	js.executeScript("window.scrollBy(0,500)");
	Thread.sleep(800);
	WebElement Back_Button = p.Back_button();
	Thread.sleep(800);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Fetch form input fields.");
	System.out.println("Step " + (step - 1) + ": Fetch form input fields.");
	System.out.println();

	List<WebElement> input_fields = p.Form_inputs();
	if (input_fields.size() <= 3) {
		Report_Listen.log_print_in_report().log(Status.WARNING,
				"<b>⚠ Retry:</b> Expected number of input fields not found. Waiting and retrying the same operation.");
		System.out.println("⚠ Retry: Expected number of input fields not found. Waiting and retrying the same operation.");
		System.out.println();

		input_fields.clear();
		Thread.sleep(800);
		input_fields = p.Form_inputs();
	}
	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Form input fields fetched successfully. Total fields found = " + input_fields.size());
	System.out.println("🟨 Actual: Form input fields fetched successfully. Total fields found = " + input_fields.size());
	System.out.println();

	js.executeScript("window.scrollBy(0,500);");

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Fetch custom dropdown fields.");
	System.out.println("Step " + (step - 1) + ": Fetch custom dropdown fields.");
	System.out.println();

	List<WebElement> Custom_Dropdowns = null;

	try {
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(800);
		Custom_Dropdowns = p.Form_Custom_Dropdown_fields();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Custom dropdown fields fetched successfully. Total custom dropdowns found = " + Custom_Dropdowns.size());
		System.out.println("🟨 Actual: Custom dropdown fields fetched successfully. Total custom dropdowns found = " + Custom_Dropdowns.size());
		System.out.println();

	} catch (Exception e) {
		Report_Listen.log_print_in_report().log(Status.WARNING,
				"<b>⚠ Retry:</b> Failed to fetch custom dropdown fields after scroll. Waiting and retrying the same operation.");
		System.out.println("⚠ Retry: Failed to fetch custom dropdown fields after scroll. Waiting and retrying the same operation.");
		System.out.println();

		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(800);
		Custom_Dropdowns = p.Form_Custom_Dropdown_fields();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Custom dropdown fields fetched successfully in retry. Total custom dropdowns found = " + Custom_Dropdowns.size());
		System.out.println("🟨 Actual: Custom dropdown fields fetched successfully in retry. Total custom dropdowns found = " + Custom_Dropdowns.size());
		System.out.println();
	}

	Thread.sleep(1000);
	List<WebElement> Buttons = p.Buttons();
	Thread.sleep(800);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Enter Job Posting Name and select expiry date.");
	System.out.println("Step " + (step - 1) + ": Enter Job Posting Name and select expiry date.");
	System.out.println();

	input_fields.get(0).sendKeys(Job_Posting_Name);
	input_fields.get(1).click();
	List<WebElement> Job_Expiry_Date_options = p.Job_Expiry_unselected_dates_in_calender();
	for (WebElement date_option : Job_Expiry_Date_options) {
		String date_text = date_option.getText().trim();
		if (date_text.contains("30")) {
			date_option.click();
			break;
		}
	}
	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Job Posting Name entered successfully = " + Job_Posting_Name + " and expiry date selected successfully.");
	System.out.println("🟨 Actual: Job Posting Name entered successfully = " + Job_Posting_Name + " and expiry date selected successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Fetch general dropdown fields and select Job Urgency.");
	System.out.println("Step " + (step - 1) + ": Fetch general dropdown fields and select Job Urgency.");
	System.out.println();

	List<WebElement> Dropdowns = p.Form_General_Dropdown_fields();
	System.out.println("Total general dropdown fields found in the form = " + Dropdowns.size());
	System.out.println();

	WebElement Job_Urgency_feild = Dropdowns.get(1);
	Job_Urgency_feild.click();
	List<WebElement> jb_urgency_options = p.First_dropdown_Options();
	for (WebElement option : jb_urgency_options) {
		String option_text = option.getText().trim();
		if (option_text.contains(Job_Urgency)) {
			option.click();
			break;
		}
	}
	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Job Urgency selected successfully = " + Job_Urgency);
	System.out.println("🟨 Actual: Job Urgency selected successfully = " + Job_Urgency);
	System.out.println();

	r.mouseWheel(1);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Enter Job Title.");
	System.out.println("Step " + (step - 1) + ": Enter Job Title.");
	System.out.println();

	WebElement JobTitle_feild;
	try {
		JobTitle_feild = input_fields.get(2);
	} catch (IndexOutOfBoundsException e) {
		WebElement field = p.Job_title_field();
		field.click();
		JobTitle_feild = field.findElement(By.id("jobTitle"));
	}
	JobTitle_feild.sendKeys(Job_Title);
	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Job Title entered successfully = " + Job_Title);
	System.out.println("🟨 Actual: Job Title entered successfully = " + Job_Title);
	System.out.println();

	r.mouseWheel(3);
	Thread.sleep(800);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Select Department / Division.");
	System.out.println("Step " + (step - 1) + ": Select Department / Division.");
	System.out.println();

	WebElement Department_feild = Dropdowns.get(2);
	Thread.sleep(800);
	Department_feild.click();
	WebElement Department_input = p.department_field_input();
	Department_input.sendKeys(Department_Division);
	WebElement Department_Dropdown = p.Second_dropdown_list();
	rp.movetoelement(Department_Dropdown);
	List<WebElement> department_options = p.Second_dropdown_Options();
	Thread.sleep(800);
	for (WebElement dp_opt : department_options) {
		String dpt_opt_text = dp_opt.getText().trim();
		if (dpt_opt_text.contains(Department_Division)) {
			dp_opt.click();
			break;
		}
	}
	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Department option selected successfully = " + Department_Division);
	System.out.println("🟨 Actual: Department option selected successfully = " + Department_Division);
	System.out.println();

	Thread.sleep(800);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Select Employment Type.");
	System.out.println("Step " + (step - 1) + ": Select Employment Type.");
	System.out.println();

	WebElement Employment_Type_feild = Dropdowns.get(3);
	Employment_Type_feild.click();
	List<WebElement> Employment_Type_options = p.Third_dropdown_Options();
	for (WebElement emp_opt : Employment_Type_options) {
		String emp_opt_text = emp_opt.getText().trim();
		if (emp_opt_text.contains("Full")) {
			emp_opt.click();
			break;
		}
	}
	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Employment Type selected successfully = Full Time");
	System.out.println("🟨 Actual: Employment Type selected successfully = Full Time");
	System.out.println();

	r.mouseWheel(2);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Select Category.");
	System.out.println("Step " + (step - 1) + ": Select Category.");
	System.out.println();

	WebElement Category_feild = Custom_Dropdowns.get(0);
	rp.movetoelement(Category_feild);
	Thread.sleep(800);
	Category_feild.click();
	WebElement Category_Input = p.Category_field();
	Category_Input.sendKeys(Category);
	WebElement Category_Dropdown = p.Fourth_dropdown_list();
	rp.movetoelement(Category_Dropdown);
	r.mouseWheel(1);
	List<WebElement> Category_Type_options = p.Fourth_dropdown_Options();
	for (WebElement cat_opt : Category_Type_options) {
		String cat_opt_text = cat_opt.getText().trim();
		if (cat_opt_text.contains(Category)) {
			cat_opt.click();
			break;
		}
	}
	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Category selected successfully = " + Category);
	System.out.println("🟨 Actual: Category selected successfully = " + Category);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Select Required Education.");
	System.out.println("Step " + (step - 1) + ": Select Required Education.");
	System.out.println();

	WebElement Education_feild;
	try {
		Education_feild = Custom_Dropdowns.get(1);
		rp.movetoelement(Education_feild);
		Education_feild.click();
	} catch (Exception e) {
		p.Yes_button().click();
		Education_feild = Custom_Dropdowns.get(1);
		rp.movetoelement(Education_feild);
		Education_feild.click();
	}
	WebElement Education_Input = p.Required_education_input_field();
	Education_Input.sendKeys(Required_Education);
	List<WebElement> Edu_Type_options = p.Fifth_dropdown_Options();
	for (WebElement Edu_opt : Edu_Type_options) {
		String Edu_opt_text = Edu_opt.getText().trim();
		if (Edu_opt_text.contains(Required_Education)) {
			Edu_opt.click();
			break;
		}
	}
	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Required Education selected successfully = " + Required_Education);
	System.out.println("🟨 Actual: Required Education selected successfully = " + Required_Education);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Select Required Experience.");
	System.out.println("Step " + (step - 1) + ": Select Required Experience.");
	System.out.println();

	WebElement Required_Exp_feild;
	try {
		Required_Exp_feild = Dropdowns.get(4);
		rp.movetoelement(Required_Exp_feild);
		Required_Exp_feild.click();
	} catch (Exception e) {
		p.Yes_button().click();
		Required_Exp_feild = Dropdowns.get(4);
		rp.movetoelement(Education_feild);
		Required_Exp_feild.click();
	}

	List<WebElement> Exp_options = p.Sixth_dropdown_Options();
	for (WebElement Exp_opt : Exp_options) {
		String Exp_opt_text = Exp_opt.getText().trim();
		if (Exp_opt_text.contains(Required_Experience)) {
			Exp_opt.click();
			break;
		}
	}
	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Required Experience selected successfully = " + Required_Experience);
	System.out.println("🟨 Actual: Required Experience selected successfully = " + Required_Experience);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Select Expected Hiring Date, Number of Positions, and When Positions Fulfilled.");
	System.out.println("Step " + (step - 1) + ": Select Expected Hiring Date, Number of Positions, and When Positions Fulfilled.");
	System.out.println();

	input_fields.get(3).click();
	p.Second_Today_Button_calendar().click();
	p.Number_of_Positions().click();
	WebElement Number_of_Positions_Input = p.Vacancy_field_input();
	Number_of_Positions_Input.sendKeys(Number_Of_Positions);
	WebElement When_Positions_Fulfilled_feild = Custom_Dropdowns.get(2);
	rp.movetoelement(When_Positions_Fulfilled_feild);
	When_Positions_Fulfilled_feild.click();
	List<WebElement> Position_filled_options = p.Seventh_dropdown_Options();
	for (WebElement pos_fill_opt : Position_filled_options) {
		String Fill_opt_text = pos_fill_opt.getText().trim();
		if (Fill_opt_text.contains(When_Positions_Fulfilled)) {
			pos_fill_opt.click();
			break;
		}
	}
	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Expected Hiring Date selected, Number of Positions entered = " + Number_Of_Positions
					+ ", and When Positions Fulfilled selected = " + When_Positions_Fulfilled);
	System.out.println("🟨 Actual: Expected Hiring Date selected, Number of Positions entered = " + Number_Of_Positions
			+ ", and When Positions Fulfilled selected = " + When_Positions_Fulfilled);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Fetch description editor fields and populate Job Description, Job Requirements, and Benefits.");
	System.out.println("Step " + (step - 1) + ": Fetch description editor fields and populate Job Description, Job Requirements, and Benefits.");
	System.out.println();

	List<WebElement> Description_feilds = null;

	try {
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(800);
		Description_feilds = p.Form_Description_fields();
	} catch (Exception e) {
		r.mouseWheel(15);
		Thread.sleep(1000);
		r.mouseWheel(-15);
		Description_feilds = p.Form_Description_fields();
	}

	WebElement Job_description_feild = Description_feilds.get(0);
	Thread.sleep(800);
	rp.Scroll_to_element(Job_description_feild);
	Thread.sleep(800);
	js.executeScript("window.scrollBy(0,-180)");
	Thread.sleep(800);
	Job_description_feild.sendKeys(Job_Description);

	WebElement Job_Requirement_feild = Description_feilds.get(1);
	rp.Scroll_to_element(Job_Requirement_feild);
	Thread.sleep(800);
	js.executeScript("window.scrollBy(0,-180)");
	Thread.sleep(800);
	Job_Requirement_feild.sendKeys(Job_Requirements);

	WebElement Benefits_feild = Description_feilds.get(2);
	rp.Scroll_to_element(Benefits_feild);
	Thread.sleep(800);
	js.executeScript("window.scrollBy(0,-180)");
	Thread.sleep(800);
	Benefits_feild.sendKeys(Benefits);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Job Description, Job Requirements, and Benefits entered successfully.");
	System.out.println("🟨 Actual: Job Description, Job Requirements, and Benefits entered successfully.");
	System.out.println();

	r.mouseWheel(3);
	Thread.sleep(800);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Select City / State and enter salary range details.");
	System.out.println("Step " + (step - 1) + ": Select City / State and enter salary range details.");
	System.out.println();

	WebElement State_feild = Dropdowns.get(6);
	rp.movetoelement(State_feild);
	State_feild.click();
	p.State_field_input().sendKeys(City_State);
	List<WebElement> State_options = p.eighth_dropdown_Options();
	for (WebElement State_opt : State_options) {
		String State_opt_text = State_opt.getText().trim();
		if (State_opt_text.contains(City_State)) {
			State_opt.click();
			break;
		}
	}
	r.mouseWheel(3);
	Thread.sleep(800);
	input_fields.get(4).sendKeys(Salary_From_1);
	input_fields.get(5).sendKeys(Salary_To_1);

	WebElement Salary_LPA_feild = Dropdowns.get(7);
	rp.movetoelement(Salary_LPA_feild);
	Salary_LPA_feild.click();
	List<WebElement> LPA_options = p.Ninth_dropdown_Options();
	for (WebElement LPA_opt : LPA_options) {
		String LPA_opt_text = LPA_opt.getText().trim();
		if (LPA_opt_text.contains(Unit_1)) {
			LPA_opt.click();
			break;
		}
	}
	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> City / State selected successfully = " + City_State
					+ ", Salary From entered = " + Salary_From_1
					+ ", Salary To entered = " + Salary_To_1
					+ ", and salary unit selected = " + Unit_1);
	System.out.println("🟨 Actual: City / State selected successfully = " + City_State
			+ ", Salary From entered = " + Salary_From_1
			+ ", Salary To entered = " + Salary_To_1
			+ ", and salary unit selected = " + Unit_1);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Submit job form and wait for screening question block.");
	System.out.println("Step " + (step - 1) + ": Submit job form and wait for screening question block.");
	System.out.println();

	WebElement Submit_Button = Buttons.get(8);
	rp.movetoelement(Submit_Button);
	Submit_Button.click();
	Thread.sleep(1800);

	List<WebElement> question_blocks = null;

	try {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(d)
				.withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		question_blocks = wait.until(driver -> {
			List<WebElement> question_try = p.Question_blocks();
			return (question_try != null && question_try.size() > 0) ? question_try : null;
		});

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Screening question block(s) loaded successfully. Total blocks found = " + question_blocks.size());
		System.out.println("🟨 Actual: Screening question block(s) loaded successfully. Total blocks found = " + question_blocks.size());
		System.out.println();

	} catch (Exception e) {
		Thread.sleep(800);
		Submit_Button = Buttons.get(8);
		rp.movetoelement(Submit_Button);
		Submit_Button.click();
		//Thread.sleep(800);

		WebElement error_toast = p.Error_toast_message();
		String error_toast_text = error_toast.getText().trim();
		System.out.println();

		Thread.sleep(800);
		WebElement toast_close = p.Toast_close_button();
		rp.movetoelement(toast_close);
		toast_close.click();
/*
		System.out.println("Error toast message = " + error_toast_text);
		Report_Listen.log_print_in_report().log(Status.WARNING,
				"<b>⚠ Actual:</b> Error toast message captured after submit retry = " + error_toast_text);
		System.out.println();

		Thread.sleep(800);
		WebElement toast_close_two = p.Toast_close_button();
		rp.movetoelement(toast_close_two);
		toast_close_two.click();

		Report_Listen.log_print_in_report().log(Status.WARNING,
				"<b>⚠ Recovery:</b> Existing conflicting job was handled through delete and re-add flow before retrying question block loading.");
		System.out.println("⚠ Recovery: Existing conflicting job was handled through delete and re-add flow before retrying question block loading.");
		System.out.println();*/

		Already_added_Job_delete_and_re_add(error_toast_text, Job_Posting_Name, Back_Button,job_data);

		FluentWait<WebDriver> wat = new FluentWait<WebDriver>(d)
				.withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		question_blocks = wat.until(driver -> {
			List<WebElement> question_retry = p.Question_blocks();
			return (question_retry != null && question_retry.size() > 0) ? question_retry : null;
		});

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Screening question block(s) loaded successfully after recovery flow. Total blocks found = " + question_blocks.size());
		System.out.println("🟨 Actual: Screening question block(s) loaded successfully after recovery flow. Total blocks found = " + question_blocks.size());
		System.out.println();
}

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Enter first screening question and add it.");
	System.out.println("Step " + (step - 1) + ": Enter first screening question and add it.");
	System.out.println();

	WebElement question_block = question_blocks.get(0);
	rp.movetoelement(question_block);
	question_block.click();

	WebElement question_input = question_block.findElement(By.xpath(".//input[@placeholder='Type your question...']"));
	question_input.click();
	question_input.sendKeys(Screening_Question_1);

	List<WebElement> Checkboxes = p.checkboxes();
	Checkboxes.get(0).click();

	p.ADD_button().click();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Screening Question 1 entered successfully = " + Screening_Question_1 + " and Save Question checkbox was selected.");
	System.out.println("🟨 Actual: Screening Question 1 entered successfully = " + Screening_Question_1 + " and Save Question checkbox was selected.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Save and continue to Workflow page.");
	System.out.println("Step " + (step - 1) + ": Save and continue to Workflow page.");
	System.out.println();

	WebElement Save_Button_1 = p.save_and_continue_button();
	Save_Button_1.click();
	p.Landed_on_Workflow_page();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> User landed successfully on Workflow page.");
	System.out.println("🟨 Actual: User landed successfully on Workflow page.");
	System.out.println();

	Thread.sleep(800);
	try {
		WebElement new_toast_close = p.Toast_close_button();
		rp.movetoelement(new_toast_close);
		new_toast_close.click();
        rp.wait_for_invisibilty_of_theElement(new_toast_close);
		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Question-related toast notification was displayed and closed successfully.");
		System.out.println("🟨 Actual: Question-related toast notification was displayed and closed successfully.");
		System.out.println();

	} catch (Exception mmk) {
		System.out.println();
		System.out.println("No error Toast Regarding Questions was displayed, proceeding with the flow.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> No question-related error toast was displayed, so execution proceeded normally.");
		System.out.println("🟨 Actual: No question-related error toast was displayed, so execution proceeded normally.");
		System.out.println();
	}

	Thread.sleep(800);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Continue from Workflow page and publish the job posting.");
	System.out.println("Step " + (step - 1) + ": Continue from Workflow page and publish the job posting.");
	System.out.println();

	WebElement Save_Button_2 = p.save_and_continue_button();
	Save_Button_2.click();
	WebElement owner_text= p.Landed_on_create_job_page();
	Thread.sleep(800);
	r.mouseWheel(-10);
	Thread.sleep(800);
	WebElement Publish_Button = p.Create_Job_button();
	Thread.sleep(800);
	try {
		js.executeScript("arguments[0].click();", Publish_Button);}
	catch(Exception e) {
		Thread.sleep(300);
		r.mouseWheel(-10);
		Thread.sleep(300);
		Publish_Button.click();
	}

	Assert.assertTrue(p.Job_Creation_success_message().isDisplayed(),
			"Job posting creation success message not displayed.");

	Report_Listen.log_print_in_report().log(Status.PASS,
			"<b>🟨 Actual:</b> Job posting was created successfully and success message was displayed for Job Title = " + Job_Title);
	System.out.println("🟨 Actual: Job posting was created successfully and success message was displayed for Job Title = " + Job_Title);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📌 Final Status:</b> Job Add flow completed successfully including job details entry, screening question setup, workflow navigation, and publishing.");
	System.out.println("📌 Final Status: Job Add flow completed successfully including job details entry, screening question setup, workflow navigation, and publishing.");
	System.out.println();
}
	
	public void Already_added_Job_delete_and_re_add(String error_toast_text,String job_name, WebElement Button,TreeMap<String, String> data) throws InterruptedException, IOException, AWTException {
		
		Job_Module_locaters p = new Job_Module_locaters(d);
		JavascriptExecutor js = (JavascriptExecutor) d;
		Repeat rp = new Repeat(d);
		Robot r = new Robot();
		
		if(error_toast_text.contains("Title must be unique")){
    		Thread.sleep(800);
    		WebElement Back_Button = Button;
    		rp.Scroll_to_element(Back_Button);
    		try {
    			r.mouseWheel(-30);
    			Thread.sleep(800);
     	        Back_Button.click();
              
    		} catch (Exception e) {
    			
    		    WebElement Top = p.top_row_of_the_page();
    			rp.Scroll_to_element(Top);
    			WebElement form = p.Form();
    			rp.movetoelement(form);
    			form.click();
    			Thread.sleep(800);
    			
    			r.mouseWheel(-30);
    			Thread.sleep(800);
    			js.executeScript("arguments[0].click();", Back_Button);
    		}
    		
    	 
    		p.search_field().sendKeys(job_name);
    	
    		try {
    			rp.wait_for_invisibilty_of_theElement(p.List_loader());

    		} catch (Exception e) {
    			System.out.println("Loader not visible.");
    			System.out.println();
    			Report_Listen.log_print_in_report().log(Status.INFO,
    					"<b>🟨 Actual:</b> Loader was not visible.");
    		}
    		p.Result_card_heading();
    		List<WebElement> threeDot_buttons = p.Three_dots_buttons();
    		threeDot_buttons.get(0).click();
    		List<WebElement> opts= p.list_dropdowm_options();
    		for(WebElement opt:opts) {
				String opt_text = opt.getText().trim();
				if(opt_text.contains("Delete")) {
					opt.click();
					break;}}
		  p.popup();
		  String Delete_text= p.Bold_text_in_popup().getText().trim();
		  p.Delete_input().sendKeys(Delete_text);
		  p.pop_up_delete_button().click();
		  Job_Add(data);
		}
		
		
	}
	
	

	
@DataProvider
public Object[][] Job_Posting_Data() {

    TreeMap<String, String> data1 = new TreeMap<String, String>();
    data1.put("Select Template", "Custom Template");
    data1.put("Job Posting Name", "Autonomous Swarm Orchestration Drive 01");
    data1.put("Expiry Date", "11-07-2026");
    data1.put("Job Urgency", "High");
    data1.put("Job Title", "Autonomous Swarm Orchestration Engineer");
    data1.put("Department / Division", "Artificial Intelligence and Autonomy");
    data1.put("Employment Type", "Full Time");
    data1.put("Category", "Information Technology");
    data1.put("Required Education", "M.Tech");
    data1.put("Required Experience", "Senior");
    data1.put("Expected Hiring Date", "21-08-2026");
    data1.put("Number of Positions", "1");
    data1.put("When Positions Fulfilled", "Enable Waitlist");
    data1.put("Job Description", "Develop autonomous strike logic, mission behavior, and smart decision systems for UAV platforms.");
    data1.put("Job Requirements", "Experience in autonomy logic, AI systems, mission workflows, and intelligent control.");
    data1.put("Benefits", "Insurance, defense R&D exposure, innovation work, and long term technical growth.");
    data1.put("Country", "India");
    data1.put("City / State", "Karnataka");
    data1.put("Remote", "Yes");
    data1.put("Salary From 1", "1900000");
    data1.put("Salary To 1", "2500000");
    data1.put("Unit 1", "Per Annum");
    data1.put("Currency 1", "INR(₹)");
    data1.put("Salary From 2", "2500001");
    data1.put("Salary To 2", "3300000");
    data1.put("Unit 2", "Per Annum");
    data1.put("Currency 2", "INR(₹)");
    data1.put("Salary From 3", "3300001");
    data1.put("Salary To 3", "4100000");
    data1.put("Unit 3", "Per Annum");
    data1.put("Currency 3", "INR(₹)");
    data1.put("Screening Question 1", "Do you have autonomy or intelligent control experience in UAV or robotics systems?");
    data1.put("Screening Question 2", "Have you worked on mission logic, automated response, or autonomous behaviors?");
    data1.put("Screening Question 3", "Which AI or autonomy frameworks have you used?");
    data1.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data2 = new TreeMap<String, String>();
    data2.put("Select Template", "Custom Template");
    data2.put("Job Posting Name", "Avionics Power Distribution Drive 02");
    data2.put("Expiry Date", "13-07-2026");
    data2.put("Job Urgency", "High");
    data2.put("Job Title", "Avionics Power Distribution Engineer");
    data2.put("Department / Division", "Avionics");
    data2.put("Employment Type", "Full Time");
    data2.put("Category", "Information Technology");
    data2.put("Required Education", "B.Tech");
    data2.put("Required Experience", "Mid-senior");
    data2.put("Expected Hiring Date", "25-08-2026");
    data2.put("Number of Positions", "2");
    data2.put("When Positions Fulfilled", "Close Job");
    data2.put("Job Description", "Support power electronics, onboard wiring, and avionics subsystem health for UAV platforms.");
    data2.put("Job Requirements", "Experience in avionics electronics, power distribution, and onboard system troubleshooting.");
    data2.put("Benefits", "Insurance, hardware exposure, mission systems role, and technical learning.");
    data2.put("Country", "India");
    data2.put("City / State", "Telangana");
    data2.put("Remote", "No");
    data2.put("Salary From 1", "950000");
    data2.put("Salary To 1", "1350000");
    data2.put("Unit 1", "Per Annum");
    data2.put("Currency 1", "INR(₹)");
    data2.put("Salary From 2", "1350001");
    data2.put("Salary To 2", "1750000");
    data2.put("Unit 2", "Per Annum");
    data2.put("Currency 2", "INR(₹)");
    data2.put("Salary From 3", "1750001");
    data2.put("Salary To 3", "2150000");
    data2.put("Unit 3", "Per Annum");
    data2.put("Currency 3", "INR(₹)");
    data2.put("Screening Question 1", "Do you have avionics or onboard power electronics experience?");
    data2.put("Screening Question 2", "Have you handled UAV electronics integration or troubleshooting?");
    data2.put("Screening Question 3", "Which avionics or power modules have you worked on?");
    data2.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data3 = new TreeMap<String, String>();
    data3.put("Select Template", "Custom Template");
    data3.put("Job Posting Name", "Flight Envelope Control Drive 03");
    data3.put("Expiry Date", "15-07-2026");
    data3.put("Job Urgency", "High");
    data3.put("Job Title", "Flight Envelope Control Engineer");
    data3.put("Department / Division", "Flight Control Systems");
    data3.put("Employment Type", "Full Time");
    data3.put("Category", "Information Technology");
    data3.put("Required Education", "B.Tech");
    data3.put("Required Experience", "Senior");
    data3.put("Expected Hiring Date", "29-08-2026");
    data3.put("Number of Positions", "1");
    data3.put("When Positions Fulfilled", "Enable Waitlist");
    data3.put("Job Description", "Improve flight stability, response tuning, and control law performance for drone platforms.");
    data3.put("Job Requirements", "Experience in flight control, stability tuning, control systems, and response validation.");
    data3.put("Benefits", "Insurance, mission critical role, systems depth, and strong growth path.");
    data3.put("Country", "India");
    data3.put("City / State", "Maharashtra");
    data3.put("Remote", "No");
    data3.put("Salary From 1", "1650000");
    data3.put("Salary To 1", "2250000");
    data3.put("Unit 1", "Per Annum");
    data3.put("Currency 1", "INR(₹)");
    data3.put("Salary From 2", "2250001");
    data3.put("Salary To 2", "2850000");
    data3.put("Unit 2", "Per Annum");
    data3.put("Currency 2", "INR(₹)");
    data3.put("Salary From 3", "2850001");
    data3.put("Salary To 3", "3450000");
    data3.put("Unit 3", "Per Annum");
    data3.put("Currency 3", "INR(₹)");
    data3.put("Screening Question 1", "Do you have flight control or stability tuning experience?");
    data3.put("Screening Question 2", "Have you worked on controller tuning or response optimization?");
    data3.put("Screening Question 3", "Which tools have you used for control analysis?");
    data3.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data4 = new TreeMap<String, String>();
    data4.put("Select Template", "Custom Template");
    data4.put("Job Posting Name", "Tactical Perception Fusion Drive 04");
    data4.put("Expiry Date", "17-07-2026");
    data4.put("Job Urgency", "High");
    data4.put("Job Title", "Tactical Perception Fusion Engineer");
    data4.put("Department / Division", "Computer Vision");
    data4.put("Employment Type", "Full Time");
    data4.put("Category", "Information Technology");
    data4.put("Required Education", "M.Tech");
    data4.put("Required Experience", "Mid-senior");
    data4.put("Expected Hiring Date", "02-09-2026");
    data4.put("Number of Positions", "2");
    data4.put("When Positions Fulfilled", "Enable Waitlist");
    data4.put("Job Description", "Develop image intelligence, target recognition, and tracking systems for ISR drones.");
    data4.put("Job Requirements", "Experience in computer vision, image analytics, detection pipelines, and deployment.");
    data4.put("Benefits", "Insurance, AI mission work, research exposure, and strong technical growth.");
    data4.put("Country", "India");
    data4.put("City / State", "Haryana");
    data4.put("Remote", "Yes");
    data4.put("Salary From 1", "1450000");
    data4.put("Salary To 1", "1950000");
    data4.put("Unit 1", "Per Annum");
    data4.put("Currency 1", "INR(₹)");
    data4.put("Salary From 2", "1950001");
    data4.put("Salary To 2", "2550000");
    data4.put("Unit 2", "Per Annum");
    data4.put("Currency 2", "INR(₹)");
    data4.put("Salary From 3", "2550001");
    data4.put("Salary To 3", "3150000");
    data4.put("Unit 3", "Per Annum");
    data4.put("Currency 3", "INR(₹)");
    data4.put("Screening Question 1", "Do you have vision analytics or target detection experience?");
    data4.put("Screening Question 2", "Have you built image tracking or scene intelligence pipelines?");
    data4.put("Screening Question 3", "Which vision tools or frameworks have you used?");
    data4.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data5 = new TreeMap<String, String>();
    data5.put("Select Template", "Custom Template");
    data5.put("Job Posting Name", "Real-Time Flight Stack Drive 05");
    data5.put("Expiry Date", "19-07-2026");
    data5.put("Job Urgency", "High");
    data5.put("Job Title", "Real-Time Flight Stack Engineer");
    data5.put("Department / Division", "Embedded Systems");
    data5.put("Employment Type", "Full Time");
    data5.put("Category", "Information Technology");
    data5.put("Required Education", "B.Tech");
    data5.put("Required Experience", "Mid-senior");
    data5.put("Expected Hiring Date", "05-09-2026");
    data5.put("Number of Positions", "2");
    data5.put("When Positions Fulfilled", "Close Job");
    data5.put("Job Description", "Develop flight firmware, hardware interfaces, and low level real time UAV functions.");
    data5.put("Job Requirements", "Experience in embedded C, RTOS, microcontrollers, and debugging.");
    data5.put("Benefits", "Insurance, firmware ownership, core systems exposure, and career growth.");
    data5.put("Country", "India");
    data5.put("City / State", "West Bengal");
    data5.put("Remote", "No");
    data5.put("Salary From 1", "950000");
    data5.put("Salary To 1", "1350000");
    data5.put("Unit 1", "Per Annum");
    data5.put("Currency 1", "INR(₹)");
    data5.put("Salary From 2", "1350001");
    data5.put("Salary To 2", "1800000");
    data5.put("Unit 2", "Per Annum");
    data5.put("Currency 2", "INR(₹)");
    data5.put("Salary From 3", "1800001");
    data5.put("Salary To 3", "2250000");
    data5.put("Unit 3", "Per Annum");
    data5.put("Currency 3", "INR(₹)");
    data5.put("Screening Question 1", "Do you have embedded firmware or flight stack experience?");
    data5.put("Screening Question 2", "Have you worked with RTOS or real time systems?");
    data5.put("Screening Question 3", "Which MCU or debugging tools have you used?");
    data5.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data6 = new TreeMap<String, String>();
    data6.put("Select Template", "Custom Template");
    data6.put("Job Posting Name", "Secure Airborne Data Links Drive 06");
    data6.put("Expiry Date", "21-07-2026");
    data6.put("Job Urgency", "High");
    data6.put("Job Title", "Secure Airborne Data Links Engineer");
    data6.put("Department / Division", "UAV Engineering");
    data6.put("Employment Type", "Full Time");
    data6.put("Category", "Information Technology");
    data6.put("Required Education", "B.Tech");
    data6.put("Required Experience", "Senior");
    data6.put("Expected Hiring Date", "07-09-2026");
    data6.put("Number of Positions", "1");
    data6.put("When Positions Fulfilled", "Enable Waitlist");
    data6.put("Job Description", "Design secure telemetry channels, communication validation, and UAV link reliability.");
    data6.put("Job Requirements", "Experience in RF systems, telemetry links, antennas, and communication testing.");
    data6.put("Benefits", "Insurance, communications specialization, hardware exposure, and growth.");
    data6.put("Country", "India");
    data6.put("City / State", "Tamil Nadu");
    data6.put("Remote", "No");
    data6.put("Salary From 1", "1450000");
    data6.put("Salary To 1", "1950000");
    data6.put("Unit 1", "Per Annum");
    data6.put("Currency 1", "INR(₹)");
    data6.put("Salary From 2", "1950001");
    data6.put("Salary To 2", "2550000");
    data6.put("Unit 2", "Per Annum");
    data6.put("Currency 2", "INR(₹)");
    data6.put("Salary From 3", "2550001");
    data6.put("Salary To 3", "3150000");
    data6.put("Unit 3", "Per Annum");
    data6.put("Currency 3", "INR(₹)");
    data6.put("Screening Question 1", "Do you have telemetry or RF communication experience?");
    data6.put("Screening Question 2", "Have you worked on secure or reliable UAV links?");
    data6.put("Screening Question 3", "Which RF validation tools have you used?");
    data6.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data7 = new TreeMap<String, String>();
    data7.put("Select Template", "Custom Template");
    data7.put("Job Posting Name", "Inertial Navigation Fusion Drive 07");
    data7.put("Expiry Date", "23-07-2026");
    data7.put("Job Urgency", "High");
    data7.put("Job Title", "Inertial Navigation Fusion Engineer");
    data7.put("Department / Division", "UAV Engineering");
    data7.put("Employment Type", "Full Time");
    data7.put("Category", "Information Technology");
    data7.put("Required Education", "M.Tech");
    data7.put("Required Experience", "Senior");
    data7.put("Expected Hiring Date", "09-09-2026");
    data7.put("Number of Positions", "1");
    data7.put("When Positions Fulfilled", "Close Job");
    data7.put("Job Description", "Develop guidance algorithms, navigation fusion, and route precision for UAV missions.");
    data7.put("Job Requirements", "Experience in navigation logic, GPS INS fusion, and guidance algorithms.");
    data7.put("Benefits", "Insurance, mission systems role, technical depth, and strong growth.");
    data7.put("Country", "India");
    data7.put("City / State", "Uttar Pradesh");
    data7.put("Remote", "No");
    data7.put("Salary From 1", "1750000");
    data7.put("Salary To 1", "2350000");
    data7.put("Unit 1", "Per Annum");
    data7.put("Currency 1", "INR(₹)");
    data7.put("Salary From 2", "2350001");
    data7.put("Salary To 2", "2950000");
    data7.put("Unit 2", "Per Annum");
    data7.put("Currency 2", "INR(₹)");
    data7.put("Salary From 3", "2950001");
    data7.put("Salary To 3", "3550000");
    data7.put("Unit 3", "Per Annum");
    data7.put("Currency 3", "INR(₹)");
    data7.put("Screening Question 1", "Do you have guidance or navigation algorithm experience?");
    data7.put("Screening Question 2", "Have you worked on route control or navigation fusion?");
    data7.put("Screening Question 3", "Which algorithms or tools have you used?");
    data7.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data8 = new TreeMap<String, String>();
    data8.put("Select Template", "Custom Template");
    data8.put("Job Posting Name", "EO-IR Mission Payload Drive 08");
    data8.put("Expiry Date", "25-07-2026");
    data8.put("Job Urgency", "High");
    data8.put("Job Title", "EO-IR Mission Payload Engineer");
    data8.put("Department / Division", "UAV Engineering");
    data8.put("Employment Type", "Full Time");
    data8.put("Category", "Information Technology");
    data8.put("Required Education", "B.Tech");
    data8.put("Required Experience", "Mid-senior");
    data8.put("Expected Hiring Date", "12-09-2026");
    data8.put("Number of Positions", "2");
    data8.put("When Positions Fulfilled", "Enable Waitlist");
    data8.put("Job Description", "Integrate targeting payloads, EO IR sensors, and mission camera packages.");
    data8.put("Job Requirements", "Experience in payload mounting, sensor integration, and validation workflows.");
    data8.put("Benefits", "Insurance, tactical systems role, field relevance, and growth.");
    data8.put("Country", "India");
    data8.put("City / State", "Gujarat");
    data8.put("Remote", "No");
    data8.put("Salary From 1", "1050000");
    data8.put("Salary To 1", "1500000");
    data8.put("Unit 1", "Per Annum");
    data8.put("Currency 1", "INR(₹)");
    data8.put("Salary From 2", "1500001");
    data8.put("Salary To 2", "1950000");
    data8.put("Unit 2", "Per Annum");
    data8.put("Currency 2", "INR(₹)");
    data8.put("Salary From 3", "1950001");
    data8.put("Salary To 3", "2450000");
    data8.put("Unit 3", "Per Annum");
    data8.put("Currency 3", "INR(₹)");
    data8.put("Screening Question 1", "Do you have payload or EO IR integration experience?");
    data8.put("Screening Question 2", "Have you worked on targeting or mission sensor packages?");
    data8.put("Screening Question 3", "What payload types have you integrated?");
    data8.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data9 = new TreeMap<String, String>();
    data9.put("Select Template", "Custom Template");
    data9.put("Job Posting Name", "Ground Command Interface Drive 09");
    data9.put("Expiry Date", "27-07-2026");
    data9.put("Job Urgency", "High");
    data9.put("Job Title", "Ground Command Interface Engineer");
    data9.put("Department / Division", "UAV Engineering");
    data9.put("Employment Type", "Full Time");
    data9.put("Category", "Information Technology");
    data9.put("Required Education", "B.Tech");
    data9.put("Required Experience", "Mid-senior");
    data9.put("Expected Hiring Date", "14-09-2026");
    data9.put("Number of Positions", "2");
    data9.put("When Positions Fulfilled", "Close Job");
    data9.put("Job Description", "Build operator dashboards, telemetry consoles, and mission control workflows.");
    data9.put("Job Requirements", "Experience in control console software, telemetry UI, and mission systems.");
    data9.put("Benefits", "Insurance, defense software role, systems exposure, and growth.");
    data9.put("Country", "India");
    data9.put("City / State", "Odisha");
    data9.put("Remote", "Yes");
    data9.put("Salary From 1", "1050000");
    data9.put("Salary To 1", "1550000");
    data9.put("Unit 1", "Per Annum");
    data9.put("Currency 1", "INR(₹)");
    data9.put("Salary From 2", "1550001");
    data9.put("Salary To 2", "2150000");
    data9.put("Unit 2", "Per Annum");
    data9.put("Currency 2", "INR(₹)");
    data9.put("Salary From 3", "2150001");
    data9.put("Salary To 3", "2750000");
    data9.put("Unit 3", "Per Annum");
    data9.put("Currency 3", "INR(₹)");
    data9.put("Screening Question 1", "Do you have operator console or telemetry software experience?");
    data9.put("Screening Question 2", "Have you built monitoring or mission interfaces?");
    data9.put("Screening Question 3", "Which software stack have you used?");
    data9.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data10 = new TreeMap<String, String>();
    data10.put("Select Template", "Custom Template");
    data10.put("Job Posting Name", "Combat Mission Planning Drive 10");
    data10.put("Expiry Date", "29-07-2026");
    data10.put("Job Urgency", "High");
    data10.put("Job Title", "Combat Mission Planning Engineer");
    data10.put("Department / Division", "UAV Engineering");
    data10.put("Employment Type", "Full Time");
    data10.put("Category", "Information Technology");
    data10.put("Required Education", "B.Tech");
    data10.put("Required Experience", "Senior");
    data10.put("Expected Hiring Date", "16-09-2026");
    data10.put("Number of Positions", "1");
    data10.put("When Positions Fulfilled", "Enable Waitlist");
    data10.put("Job Description", "Build tactical route planning, mission tasking, and waypoint management software.");
    data10.put("Job Requirements", "Experience in planning systems, mapping logic, and mission software workflows.");
    data10.put("Benefits", "Insurance, strategic mission role, systems exposure, and growth.");
    data10.put("Country", "India");
    data10.put("City / State", "Kerala");
    data10.put("Remote", "Yes");
    data10.put("Salary From 1", "1450000");
    data10.put("Salary To 1", "1950000");
    data10.put("Unit 1", "Per Annum");
    data10.put("Currency 1", "INR(₹)");
    data10.put("Salary From 2", "1950001");
    data10.put("Salary To 2", "2550000");
    data10.put("Unit 2", "Per Annum");
    data10.put("Currency 2", "INR(₹)");
    data10.put("Salary From 3", "2550001");
    data10.put("Salary To 3", "3150000");
    data10.put("Unit 3", "Per Annum");
    data10.put("Currency 3", "INR(₹)");
    data10.put("Screening Question 1", "Do you have mission software or mapping experience?");
    data10.put("Screening Question 2", "Have you worked on route logic or waypoint planning?");
    data10.put("Screening Question 3", "Which backend or mission stack have you used?");
    data10.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data11 = new TreeMap<String, String>();
    data11.put("Select Template", "Custom Template");
    data11.put("Job Posting Name", "Synthetic Battlespace Modeling Drive 11");
    data11.put("Expiry Date", "31-07-2026");
    data11.put("Job Urgency", "Medium");
    data11.put("Job Title", "Synthetic Battlespace Modeling Engineer");
    data11.put("Department / Division", "Research and Development");
    data11.put("Employment Type", "Full Time");
    data11.put("Category", "Information Technology");
    data11.put("Required Education", "M.Tech");
    data11.put("Required Experience", "Mid-senior");
    data11.put("Expected Hiring Date", "18-09-2026");
    data11.put("Number of Positions", "1");
    data11.put("When Positions Fulfilled", "Close Job");
    data11.put("Job Description", "Create digital twin simulations, mission scenarios, and virtual test environments.");
    data11.put("JobRequirements", "Experience in simulation, modeling, and scenario based validation.");
    data11.put("Job Requirements", "Experience in simulation, modeling, and scenario based validation.");
    data11.put("Benefits", "Insurance, technical depth, research exposure, and long term learning.");
    data11.put("Country", "India");
    data11.put("City / State", "Rajasthan");
    data11.put("Remote", "Yes");
    data11.put("Salary From 1", "1050000");
    data11.put("Salary To 1", "1500000");
    data11.put("Unit 1", "Per Annum");
    data11.put("Currency 1", "INR(₹)");
    data11.put("Salary From 2", "1500001");
    data11.put("Salary To 2", "2000000");
    data11.put("Unit 2", "Per Annum");
    data11.put("Currency 2", "INR(₹)");
    data11.put("Salary From 3", "2000001");
    data11.put("Salary To 3", "2500000");
    data11.put("Unit 3", "Per Annum");
    data11.put("Currency 3", "INR(₹)");
    data11.put("Screening Question 1", "Do you have simulation or digital twin experience?");
    data11.put("Screening Question 2", "Have you built UAV or robotics test scenarios?");
    data11.put("Screening Question 3", "Which simulation tools have you used?");
    data11.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data12 = new TreeMap<String, String>();
    data12.put("Select Template", "Custom Template");
    data12.put("Job Posting Name", "UAV Test Range Assurance Drive 12");
    data12.put("Expiry Date", "02-08-2026");
    data12.put("Job Urgency", "High");
    data12.put("Job Title", "UAV Test Range Assurance Engineer");
    data12.put("Department / Division", "Testing and Validation");
    data12.put("Employment Type", "Full Time");
    data12.put("Category", "Quality Analysis");
    data12.put("Required Education", "B.Tech");
    data12.put("Required Experience", "Mid-senior");
    data12.put("Expected Hiring Date", "20-09-2026");
    data12.put("Number of Positions", "2");
    data12.put("When Positions Fulfilled", "Close Job");
    data12.put("Job Description", "Run trials, validate subsystems, log defects, and verify field readiness.");
    data12.put("Job Requirements", "Experience in validation planning, test execution, and result analysis.");
    data12.put("Benefits", "Insurance, range testing exposure, systems work, and growth.");
    data12.put("Country", "India");
    data12.put("City / State", "Madhya Pradesh");
    data12.put("Remote", "No");
    data12.put("Salary From 1", "950000");
    data12.put("Salary To 1", "1350000");
    data12.put("Unit 1", "Per Annum");
    data12.put("Currency 1", "INR(₹)");
    data12.put("Salary From 2", "1350001");
    data12.put("Salary To 2", "1750000");
    data12.put("Unit 2", "Per Annum");
    data12.put("Currency 2", "INR(₹)");
    data12.put("Salary From 3", "1750001");
    data12.put("Salary To 3", "2150000");
    data12.put("Unit 3", "Per Annum");
    data12.put("Currency 3", "INR(₹)");
    data12.put("Screening Question 1", "Do you have validation or range testing experience?");
    data12.put("Screening Question 2", "Have you worked on integration or field validation?");
    data12.put("Screening Question 3", "How do you document failures and deviations?");
    data12.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data13 = new TreeMap<String, String>();
    data13.put("Select Template", "Custom Template");
    data13.put("Job Posting Name", "Defense Software Reliability Drive 13");
    data13.put("Expiry Date", "04-08-2026");
    data13.put("Job Urgency", "Medium");
    data13.put("Job Title", "Defense Software Reliability Engineer");
    data13.put("Department / Division", "Quality Assurance");
    data13.put("Employment Type", "Full Time");
    data13.put("Category", "Quality Analysis");
    data13.put("Required Education", "B.Tech");
    data13.put("Required Experience", "Junior");
    data13.put("Expected Hiring Date", "22-09-2026");
    data13.put("Number of Positions", "2");
    data13.put("When Positions Fulfilled", "Enable Waitlist");
    data13.put("Job Description", "Validate mission workflows, regression coverage, and UAV software quality.");
    data13.put("Job Requirements", "Experience in functional testing, regression, and detailed defect reporting.");
    data13.put("Benefits", "Insurance, QA exposure, product learning, and career growth.");
    data13.put("Country", "India");
    data13.put("City / State", "Bihar");
    data13.put("Remote", "Yes");
    data13.put("Salary From 1", "650000");
    data13.put("Salary To 1", "900000");
    data13.put("Unit 1", "Per Annum");
    data13.put("Currency 1", "INR(₹)");
    data13.put("Salary From 2", "900001");
    data13.put("Salary To 2", "1150000");
    data13.put("Unit 2", "Per Annum");
    data13.put("Currency 2", "INR(₹)");
    data13.put("Salary From 3", "1150001");
    data13.put("Salary To 3", "1400000");
    data13.put("Unit 3", "Per Annum");
    data13.put("Currency 3", "INR(₹)");
    data13.put("Screening Question 1", "Do you have functional and regression testing experience?");
    data13.put("Screening Question 2", "Have you validated complete business or mission workflows?");
    data13.put("Screening Question 3", "Which QA tools have you used?");
    data13.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data14 = new TreeMap<String, String>();
    data14.put("Select Template", "Custom Template");
    data14.put("Job Posting Name", "Drone Assembly Process Excellence Drive 14");
    data14.put("Expiry Date", "06-08-2026");
    data14.put("Job Urgency", "High");
    data14.put("Job Title", "Drone Assembly Process Excellence Engineer");
    data14.put("Department / Division", "Manufacturing");
    data14.put("Employment Type", "Full Time");
    data14.put("Category", "Professional Service");
    data14.put("Required Education", "B.Tech");
    data14.put("Required Experience", "Mid-senior");
    data14.put("Expected Hiring Date", "24-09-2026");
    data14.put("Number of Positions", "2");
    data14.put("When Positions Fulfilled", "Close Job");
    data14.put("Job Description", "Support assembly flow, tooling, production quality, and build performance.");
    data14.put("Job Requirements", "Experience in manufacturing operations, process improvement, and assembly workflows.");
    data14.put("Benefits", "Insurance, production exposure, assembly ownership, and role growth.");
    data14.put("Country", "India");
    data14.put("City / State", "Maharashtra");
    data14.put("Remote", "No");
    data14.put("Salary From 1", "850000");
    data14.put("Salary To 1", "1200000");
    data14.put("Unit 1", "Per Annum");
    data14.put("Currency 1", "INR(₹)");
    data14.put("Salary From 2", "1200001");
    data14.put("Salary To 2", "1550000");
    data14.put("Unit 2", "Per Annum");
    data14.put("Currency 2", "INR(₹)");
    data14.put("Salary From 3", "1550001");
    data14.put("Salary To 3", "1950000");
    data14.put("Unit 3", "Per Annum");
    data14.put("Currency 3", "INR(₹)");
    data14.put("Screening Question 1", "Do you have assembly line or drone manufacturing experience?");
    data14.put("Screening Question 2", "Have you improved build quality or production efficiency?");
    data14.put("Screening Question 3", "What hardware manufacturing environment have you worked in?");
    data14.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data15 = new TreeMap<String, String>();
    data15.put("Select Template", "Custom Template");
    data15.put("Job Posting Name", "Composite Airframe Architecture Drive 15");
    data15.put("Expiry Date", "08-08-2026");
    data15.put("Job Urgency", "High");
    data15.put("Job Title", "Composite Airframe Architecture Engineer");
    data15.put("Department / Division", "Mechanical Design");
    data15.put("Employment Type", "Full Time");
    data15.put("Category", "Information Technology");
    data15.put("Required Education", "B.Tech");
    data15.put("Required Experience", "Mid-senior");
    data15.put("Expected Hiring Date", "26-09-2026");
    data15.put("Number of Positions", "2");
    data15.put("When Positions Fulfilled", "Enable Waitlist");
    data15.put("Job Description", "Design UAV structures, housings, and lightweight mission ready assemblies.");
    data15.put("Job Requirements", "Experience in CAD, structural design, and lightweight mechanical systems.");
    data15.put("Benefits", "Insurance, prototype exposure, design ownership, and growth.");
    data15.put("Country", "India");
    data15.put("City / State", "Jharkhand");
    data15.put("Remote", "No");
    data15.put("Salary From 1", "950000");
    data15.put("Salary To 1", "1350000");
    data15.put("Unit 1", "Per Annum");
    data15.put("Currency 1", "INR(₹)");
    data15.put("Salary From 2", "1350001");
    data15.put("Salary To 2", "1800000");
    data15.put("Unit 2", "Per Annum");
    data15.put("Currency 2", "INR(₹)");
    data15.put("Salary From 3", "1800001");
    data15.put("Salary To 3", "2250000");
    data15.put("Unit 3", "Per Annum");
    data15.put("Currency 3", "INR(₹)");
    data15.put("Screening Question 1", "Do you have mechanical or structural UAV design experience?");
    data15.put("Screening Question 2", "Have you worked on lightweight or airframe assemblies?");
    data15.put("Screening Question 3", "Which CAD tools have you used most?");
    data15.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data16 = new TreeMap<String, String>();
    data16.put("Select Template", "Custom Template");
    data16.put("Job Posting Name", "High-Endurance Powertrain Drive 16");
    data16.put("Expiry Date", "10-08-2026");
    data16.put("Job Urgency", "High");
    data16.put("Job Title", "High-Endurance Powertrain Engineer");
    data16.put("Department / Division", "UAV Engineering");
    data16.put("Employment Type", "Full Time");
    data16.put("Category", "Information Technology");
    data16.put("Required Education", "B.Tech");
    data16.put("Required Experience", "Senior");
    data16.put("Expected Hiring Date", "28-09-2026");
    data16.put("Number of Positions", "1");
    data16.put("When Positions Fulfilled", "Close Job");
    data16.put("Job Description", "Improve propulsion efficiency, endurance, motor control, and powertrain reliability.");
    data16.put("Job Requirements", "Experience in propulsion systems, ESCs, motors, endurance analysis, and testing.");
    data16.put("Benefits", "Insurance, deep hardware role, performance optimization, and growth.");
    data16.put("Country", "India");
    data16.put("City / State", "Uttar Pradesh");
    data16.put("Remote", "No");
    data16.put("Salary From 1", "1350000");
    data16.put("Salary To 1", "1850000");
    data16.put("Unit 1", "Per Annum");
    data16.put("Currency 1", "INR(₹)");
    data16.put("Salary From 2", "1850001");
    data16.put("Salary To 2", "2450000");
    data16.put("Unit 2", "Per Annum");
    data16.put("Currency 2", "INR(₹)");
    data16.put("Salary From 3", "2450001");
    data16.put("Salary To 3", "3050000");
    data16.put("Unit 3", "Per Annum");
    data16.put("Currency 3", "INR(₹)");
    data16.put("Screening Question 1", "Do you have propulsion or endurance engineering experience?");
    data16.put("Screening Question 2", "Have you worked on motors, ESCs, or performance tuning?");
    data16.put("Screening Question 3", "What propulsion systems have you optimized?");
    data16.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data17 = new TreeMap<String, String>();
    data17.put("Select Template", "Custom Template");
    data17.put("Job Posting Name", "UAV Capability Portfolio Drive 17");
    data17.put("Expiry Date", "12-08-2026");
    data17.put("Job Urgency", "Medium");
    data17.put("Job Title", "UAV Capability Portfolio Manager");
    data17.put("Department / Division", "Product Management");
    data17.put("Employment Type", "Full Time");
    data17.put("Category", "Information Technology");
    data17.put("Required Education", "MBA");
    data17.put("Required Experience", "Senior");
    data17.put("Expected Hiring Date", "30-09-2026");
    data17.put("Number of Positions", "1");
    data17.put("When Positions Fulfilled", "Enable Waitlist");
    data17.put("Job Description", "Own product planning, roadmap priorities, and platform strategy for defense UAVs.");
    data17.put("Job Requirements", "Experience in product planning, stakeholder management, and platform prioritization.");
    data17.put("Benefits", "Insurance, strategic ownership, defense product exposure, and leadership growth.");
    data17.put("Country", "India");
    data17.put("City / State", "Gujarat");
    data17.put("Remote", "Yes");
    data17.put("Salary From 1", "1550000");
    data17.put("Salary To 1", "2150000");
    data17.put("Unit 1", "Per Annum");
    data17.put("Currency 1", "INR(₹)");
    data17.put("Salary From 2", "2150001");
    data17.put("Salary To 2", "2750000");
    data17.put("Unit 2", "Per Annum");
    data17.put("Currency 2", "INR(₹)");
    data17.put("Salary From 3", "2750001");
    data17.put("Salary To 3", "3350000");
    data17.put("Unit 3", "Per Annum");
    data17.put("Currency 3", "INR(₹)");
    data17.put("Screening Question 1", "Do you have product strategy or platform planning experience?");
    data17.put("Screening Question 2", "Have you worked with engineering and defense stakeholders?");
    data17.put("Screening Question 3", "How do you balance mission need and technical feasibility?");
    data17.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data18 = new TreeMap<String, String>();
    data18.put("Select Template", "Custom Template");
    data18.put("Job Posting Name", "Defense Program Growth Strategy Drive 18");
    data18.put("Expiry Date", "14-08-2026");
    data18.put("Job Urgency", "Medium");
    data18.put("Job Title", "Defense Program Growth Strategy Manager");
    data18.put("Department / Division", "Sales and Business Development");
    data18.put("Employment Type", "Full Time");
    data18.put("Category", "Marketing");
    data18.put("Required Education", "MBA");
    data18.put("Required Experience", "Senior");
    data18.put("Expected Hiring Date", "02-10-2026");
    data18.put("Number of Positions", "1");
    data18.put("When Positions Fulfilled", "Close Job");
    data18.put("Job Description", "Drive defense engagement, growth programs, and strategic UAV solution expansion.");
    data18.put("Job Requirements", "Experience in B2B sales, defense accounts, proposal work, and solution pitching.");
    data18.put("Benefits", "Insurance, strategic role, client exposure, and long term growth.");
    data18.put("Country", "India");
    data18.put("City / State", "Tamil Nadu");
    data18.put("Remote", "No");
    data18.put("Salary From 1", "1250000");
    data18.put("Salary To 1", "1750000");
    data18.put("Unit 1", "Per Annum");
    data18.put("Currency 1", "INR(₹)");
    data18.put("Salary From 2", "1750001");
    data18.put("Salary To 2", "2250000");
    data18.put("Unit 2", "Per Annum");
    data18.put("Currency 2", "INR(₹)");
    data18.put("Salary From 3", "2250001");
    data18.put("Salary To 3", "2850000");
    data18.put("Unit 3", "Per Annum");
    data18.put("Currency 3", "INR(₹)");
    data18.put("Screening Question 1", "Do you have B2B or defense growth experience?");
    data18.put("Screening Question 2", "Have you worked on proposals or strategic client discussions?");
    data18.put("Screening Question 3", "How do you qualify high value defense leads?");
    data18.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data19 = new TreeMap<String, String>();
    data19.put("Select Template", "Custom Template");
    data19.put("Job Posting Name", "Deployed Flight Operations Drive 19");
    data19.put("Expiry Date", "16-08-2026");
    data19.put("Job Urgency", "High");
    data19.put("Job Title", "Deployed Flight Operations Engineer");
    data19.put("Department / Division", "Field Deployment");
    data19.put("Employment Type", "Full Time");
    data19.put("Category", "Professional Service");
    data19.put("Required Education", "B.Tech");
    data19.put("Required Experience", "Mid-senior");
    data19.put("Expected Hiring Date", "04-10-2026");
    data19.put("Number of Positions", "2");
    data19.put("When Positions Fulfilled", "Enable Waitlist");
    data19.put("Job Description", "Support live field trials, deployment checks, and mission issue troubleshooting.");
    data19.put("Job Requirements", "Experience in field testing, operational support, and trial reporting.");
    data19.put("Benefits", "Insurance, mission field exposure, operations learning, and growth.");
    data19.put("Country", "India");
    data19.put("City / State", "Kerala");
    data19.put("Remote", "No");
    data19.put("Salary From 1", "900000");
    data19.put("Salary To 1", "1250000");
    data19.put("Unit 1", "Per Annum");
    data19.put("Currency 1", "INR(₹)");
    data19.put("Salary From 2", "1250001");
    data19.put("Salary To 2", "1650000");
    data19.put("Unit 2", "Per Annum");
    data19.put("Currency 2", "INR(₹)");
    data19.put("Salary From 3", "1650001");
    data19.put("Salary To 3", "2050000");
    data19.put("Unit 3", "Per Annum");
    data19.put("Currency 3", "INR(₹)");
    data19.put("Screening Question 1", "Do you have field deployment or trial support experience?");
    data19.put("Screening Question 2", "Are you comfortable with site work and travel?");
    data19.put("Screening Question 3", "Have you handled mission issues during testing?");
    data19.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data20 = new TreeMap<String, String>();
    data20.put("Select Template", "Custom Template");
    data20.put("Job Posting Name", "Experimental Air Systems Drive 20");
    data20.put("Expiry Date", "18-08-2026");
    data20.put("Job Urgency", "Medium");
    data20.put("Job Title", "Experimental Air Systems Engineer");
    data20.put("Department / Division", "Research and Development");
    data20.put("Employment Type", "Full Time");
    data20.put("Category", "Information Technology");
    data20.put("Required Education", "M.Tech");
    data20.put("Required Experience", "Senior");
    data20.put("Expected Hiring Date", "06-10-2026");
    data20.put("Number of Positions", "1");
    data20.put("When Positions Fulfilled", "Close Job");
    data20.put("Job Description", "Drive advanced UAV concepts, prototypes, and next generation system research.");
    data20.put("Job Requirements", "Experience in research engineering, experimentation, and prototype evaluation.");
    data20.put("Benefits", "Insurance, deep R&D exposure, innovation ownership, and leadership growth.");
    data20.put("Country", "India");
    data20.put("City / State", "Andhra Pradesh");
    data20.put("Remote", "Yes");
    data20.put("Salary From 1", "1450000");
    data20.put("Salary To 1", "1950000");
    data20.put("Unit 1", "Per Annum");
    data20.put("Currency 1", "INR(₹)");
    data20.put("Salary From 2", "1950001");
    data20.put("Salary To 2", "2550000");
    data20.put("Unit 2", "Per Annum");
    data20.put("Currency 2", "INR(₹)");
    data20.put("Salary From 3", "2550001");
    data20.put("Salary To 3", "3150000");
    data20.put("Unit 3", "Per Annum");
    data20.put("Currency 3", "INR(₹)");
    data20.put("Screening Question 1", "Do you have R&D or prototype engineering experience?");
    data20.put("Screening Question 2", "Have you worked on concept evaluation or experimentation?");
    data20.put("Screening Question 3", "How do you document research findings and next steps?");
    data20.put("Save As Job Posting Template", "No");

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
