package Product_Codeclouds.Project.Simplified;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Job_Module_locaters;
import Repeatative_codes.Repeat;

public class Job_Module extends Candidate_module{

	
	
	
	
	public WebElement Access_Job_Module_List() throws IOException, InterruptedException{
		
		
		Job_Module_locaters p = new Job_Module_locaters(d);
		
		Menu_option_selector("Jobs");
		WebElement Job_Button= p.Add_Job();
		return Job_Button;
	}
	
	@Test(dataProvider = "Job_Posting_Data")
	public void Job_Add(TreeMap<String, String> job_data) throws IOException, InterruptedException, AWTException {
		
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
		
		
		Access_Job_Module_List();
		WebElement JobButton = p.Add_Job();
		JobButton.click();
		try {
			WebElement Form_try = p.Form();
			rp.movetoelement(Form_try);

		} catch (StaleElementReferenceException e) {
			Report_Listen.log_print_in_report().log(Status.WARNING,
					"<b>⚠ Retry:</b> Form element became stale while moving to it. Refetching and retrying the same operation.");
			System.out.println("⚠ Retry: Form element became stale while moving to it. Refetching and retrying the same operation.");

			Thread.sleep(800);
			WebElement Form_retry = p.Form();
			rp.movetoelement(Form_retry);
		}
		Thread.sleep(800);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(800);
		List<WebElement> input_fields = p.Form_inputs();
		js.executeScript("window.scrollBy(0,500);");
		System.out.println();
		List<WebElement> Dropdowns = p.Form_General_Dropdown_fields();
		System.out.println("Total general dropdown fields found in the form = " + Dropdowns.size());
		System.out.println();
		List<WebElement> Custom_Dropdowns = null;

		try {
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(800);
			Custom_Dropdowns = p.Form_Custom_Dropdown_fields();

		} catch (Exception e) {
			Report_Listen.log_print_in_report().log(Status.WARNING,
					"<b>⚠ Retry:</b> Failed to fetch custom dropdown fields after scroll. Waiting and retrying the same operation.");
			System.out.println("⚠ Retry: Failed to fetch custom dropdown fields after scroll. Waiting and retrying the same operation.");

			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(800);
			Custom_Dropdowns = p.Form_Custom_Dropdown_fields();
		}
		Thread.sleep(1000);
		List<WebElement> Buttons = p.Buttons();
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
		Thread.sleep(800);
		input_fields.get(0).sendKeys(Job_Posting_Name);
		input_fields.get(1).click();
		List<WebElement> Job_Expiry_Date_options = p.Job_Expiry_unselected_dates_in_calender();
		for(WebElement date_option:Job_Expiry_Date_options) {
			String date_text = date_option.getText().trim();
			 if(date_text.contains("30")) {
				 date_option.click();
				 break;}}
		WebElement Job_Urgency_feild= Dropdowns.get(1);
		Job_Urgency_feild.click();
		List<WebElement> jb_urgency_options = p.First_dropdown_Options();
		for(WebElement option : jb_urgency_options) {
			String option_text = option.getText().trim();
			 if(option_text.contains(Job_Urgency)) {
				 option.click();
				 break;}}
		r.mouseWheel(1);
		WebElement JobTitle_feild;
        try {
        	JobTitle_feild = input_fields.get(2);
        }catch (IndexOutOfBoundsException e) {
         WebElement field=p.Job_title_field();
         field.click();
         JobTitle_feild =field.findElement(By.id("jobTitle"));
		}
		JobTitle_feild.sendKeys(Job_Title);
		r.mouseWheel(3);
		Thread.sleep(800);
	    WebElement Department_feild = Dropdowns.get(2);
	    Thread.sleep(800);
	    Department_feild.click();
	    WebElement Department_Dropdown = p.Second_dropdown_list();
	    rp.movetoelement(Department_Dropdown);
	    Thread.sleep(800);
	    
	    Thread.sleep(800);
	    boolean department_selected = false;
	    String previous_last_option_text = "";

	    try {
	    	for (int scroll_attempt = 0; scroll_attempt < 40; scroll_attempt++) {

	    		List<WebElement> department_options_try = p.Second_dropdown_Options();

	    		if (department_options_try.size() == 0) {
	    			Thread.sleep(500);
	    			continue;}

	    		for (WebElement option_try : department_options_try) {
	    			String option_text_try = option_try.getAttribute("title").trim();

	    			if (option_text_try.contains(Department_Division)) {
	    				try {
	    					rp.movetoelement(option_try);
	    					option_try.click();
	    					department_selected = true;
	    					break;} catch (Exception click_exception_try) {
	    					try {
	    						rp.movetoelement(option_try);
	    						js.executeScript("arguments[0].click();", option_try);
	    						department_selected = true;
	    						break;} catch (Exception js_click_exception_try) {
	    						System.out.println("Matched department found but click not successful yet = " + option_text_try);}}}}

	    		if (department_selected) {
	    			break;}

	    		WebElement last_option_try = department_options_try.get(department_options_try.size() - 1);
	    		String current_last_option_text_try = last_option_try.getAttribute("title").trim();

	    		if (current_last_option_text_try.equals(previous_last_option_text)) {
	    			System.out.println("Last visible option did not change, stopping scroll at = " + current_last_option_text_try);
	    			break;}

	    		previous_last_option_text = current_last_option_text_try;

	    		try {
	    			js.executeScript("arguments[0].scrollIntoView({block: 'end'});", last_option_try);
	    		} catch (StaleElementReferenceException se) {
	    			List<WebElement> refreshed_options_try = p.Second_dropdown_Options();
	    			if (refreshed_options_try.size() > 0) {
	    				WebElement refreshed_last_option_try = refreshed_options_try.get(refreshed_options_try.size() - 1);
	    				js.executeScript("arguments[0].scrollIntoView({block: 'end'});", refreshed_last_option_try);
	    			}}

	    		Thread.sleep(500);}

	    	if (department_selected) {
	    		Report_Listen.log_print_in_report().log(Status.INFO,
	    				"<b>🟨 Actual:</b> Department option selected successfully = " + Department_Division);
	    		System.out.println("🟨 Actual: Department option selected successfully = " + Department_Division);
	    	} else {
	    		Report_Listen.log_print_in_report().log(Status.FAIL,
	    				"<b>❌ Actual:</b> Department option was not selected = " + Department_Division);
	    		System.out.println("❌ Actual: Department option was not selected = " + Department_Division);
	    		Assert.fail("Department option was not selected = " + Department_Division);
	    	}} catch (Exception e) {
	    	Report_Listen.log_print_in_report().log(Status.WARNING,
	    			"<b>⚠ Retry:</b> Department dropdown handling failed in first attempt. Retrying the same operation.");
	    	System.out.println("⚠ Retry: Department dropdown handling failed in first attempt. Retrying the same operation.");

	    	Thread.sleep(1000);
	    	js.executeScript("window.scrollBy(0,500);");
	    	Thread.sleep(800);
	    	Department_feild.click();
	    	p.Second_dropdown_list();

	    	previous_last_option_text = "";

	    	for (int scroll_attempt_retry = 0; scroll_attempt_retry < 40; scroll_attempt_retry++) {

	    		List<WebElement> department_options_retry = p.Second_dropdown_Options();

	    		if (department_options_retry.size() == 0) {
	    			Thread.sleep(500);
	    			continue;}

	    		for (WebElement option_retry : department_options_retry) {
	    			String option_text_retry = option_retry.getAttribute("title").trim();

	    			if (option_text_retry.contains(Department_Division)) {
	    				try {
	    					rp.movetoelement(option_retry);
	    					option_retry.click();
	    					department_selected = true;
	    					break;

	    				} catch (Exception click_exception_retry) {
	    					try {
	    						rp.movetoelement(option_retry);
	    						js.executeScript("arguments[0].click();", option_retry);
	    						department_selected = true;
	    						break;} catch (Exception js_click_exception_retry) {
	    						System.out.println("Matched department found in retry but click not successful yet = " + option_text_retry);
	    					}}}}

	    		if (department_selected) {
	    			break;}

	    		WebElement last_option_retry = department_options_retry.get(department_options_retry.size() - 1);
	    		String current_last_option_text_retry = last_option_retry.getAttribute("title").trim();

	    		if (current_last_option_text_retry.equals(previous_last_option_text)) {
	    			System.out.println("Last visible option did not change in retry, stopping scroll at = " + current_last_option_text_retry);
	    			break;
	    		}

	    		previous_last_option_text = current_last_option_text_retry;

	    		try {
	    			js.executeScript("arguments[0].scrollIntoView({block: 'end'});", last_option_retry);
	    		} catch (StaleElementReferenceException se) {
	    			List<WebElement> refreshed_options_retry = p.Second_dropdown_Options();
	    			if (refreshed_options_retry.size() > 0) {
	    				WebElement refreshed_last_option_retry = refreshed_options_retry.get(refreshed_options_retry.size() - 1);
	    				js.executeScript("arguments[0].scrollIntoView({block: 'end'});", refreshed_last_option_retry);
	    			}}

	    		Thread.sleep(500);}

	    	if (department_selected) {
	    		Report_Listen.log_print_in_report().log(Status.INFO,
	    				"<b>🟨 Actual:</b> Department option selected successfully in retry = " + Department_Division);
	    		System.out.println("🟨 Actual: Department option selected successfully in retry = " + Department_Division);
	    	} else {
	    		Report_Listen.log_print_in_report().log(Status.FAIL,
	    				"<b>❌ Actual:</b> Department option was not selected even after retry = " + Department_Division);
	    		System.out.println("❌ Actual: Department option was not selected even after retry = " + Department_Division);
	    		Assert.fail("Department option was not selected even after retry = " + Department_Division);
	    	}}
	    
	    WebElement Employment_Type_feild = Dropdowns.get(3);
	    Employment_Type_feild.click();
	    List<WebElement> Employment_Type_options = p.Third_dropdown_Options();
	    for(WebElement emp_opt:Employment_Type_options){
	    	
	    	String emp_opt_text = emp_opt.getText().trim();
	    	if(emp_opt_text.contains("Full")) {
	    		emp_opt.click();
	    		break;}}
	    r.mouseWheel(2);
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
	    for(WebElement cat_opt:Category_Type_options){
	    	String cat_opt_text = cat_opt.getText().trim();
	    	if(cat_opt_text.contains(Category)) {
	    		cat_opt.click();
	    		break;}}
	    WebElement Education_feild;
	    try {
	    Education_feild = Custom_Dropdowns.get(1);
	    rp.movetoelement(Education_feild);
	    Education_feild.click();}catch(Exception e) {
	    	p.Yes_button().click();
	    	Education_feild = Custom_Dropdowns.get(1);
		    rp.movetoelement(Education_feild);
		    Education_feild.click();}
	    WebElement Education_Input = p.Required_education_input_field();
	    Education_Input.sendKeys(Required_Education);
	    List<WebElement> Edu_Type_options = p.Fifth_dropdown_Options();
	    for(WebElement Edu_opt:Edu_Type_options){
	    	String Edu_opt_text = Edu_opt.getText().trim();
	    	if(Edu_opt_text.contains(Required_Education)) {
	    		Edu_opt.click();
	    		break;}}
	    
	    WebElement Required_Exp_feild;
	    
	    try {
	        Required_Exp_feild = Dropdowns.get(4);
		    rp.movetoelement(Required_Exp_feild);
		    Required_Exp_feild.click();}
	    catch(Exception e) {
		    	p.Yes_button().click();
		    	Required_Exp_feild = Dropdowns.get(4);
			    rp.movetoelement(Education_feild);
			    Required_Exp_feild.click();}
	    
	    
	    List<WebElement> Exp_options = p.Sixth_dropdown_Options();
	    for(WebElement Exp_opt:Exp_options){
	    	String Exp_opt_text = Exp_opt.getText().trim();
	    	if(Exp_opt_text.contains(Required_Experience)) {
	    		Exp_opt.click();
	    		break;}}
	    
		input_fields.get(3).click();
		p.Second_Today_Button_calendar().click();
		p.Number_of_Positions().click();
		WebElement Number_of_Positions_Input = p.Vacancy_field_input();
		Number_of_Positions_Input.sendKeys(Number_Of_Positions);
		WebElement When_Positions_Fulfilled_feild = Custom_Dropdowns.get(2);
		rp.movetoelement(When_Positions_Fulfilled_feild);
		When_Positions_Fulfilled_feild.click();
		List<WebElement> Position_filled_options = p.Seventh_dropdown_Options();
	    for(WebElement pos_fill_opt:Position_filled_options){
	    	String Fill_opt_text = pos_fill_opt.getText().trim();
	    	if(Fill_opt_text.contains(When_Positions_Fulfilled)) {
	    		pos_fill_opt.click();
	    		break;}}
	    r.mouseWheel(3);
	    Thread.sleep(800);
	    Description_feilds.get(0).sendKeys(Job_Description);
	    r.mouseWheel(3);
	    Thread.sleep(800);
	    Description_feilds.get(1).sendKeys(Job_Requirements);
	    r.mouseWheel(3);
	    Thread.sleep(800);
	    Description_feilds.get(2).sendKeys(Benefits);
	    r.mouseWheel(3);
	    Thread.sleep(800);
        WebElement State_feild = Dropdowns.get(6);;
	    rp.movetoelement(State_feild);
		State_feild.click();
	    p.State_field_input().sendKeys(City_State);    	
	    List<WebElement> State_options = p.Ninth_dropdown_Options();
	    for(WebElement State_opt:State_options){
	    	String State_opt_text = State_opt.getText().trim();
	    	if(State_opt_text.contains(City_State)) {
	    		State_opt.click();
	    		break;}}    	
	    r.mouseWheel(3);
	    Thread.sleep(800);
	    input_fields.get(4).sendKeys(Salary_From_1);
	    input_fields.get(5).sendKeys(Salary_To_1);
		
	}
	
	
	
@DataProvider
public Object[][] Job_Posting_Data() {

    TreeMap<String, String> data1 = new TreeMap<String, String>();
    data1.put("Select Template", "Custom Template");
    data1.put("Job Posting Name", "AI and Autonomy Engineer Hiring 01");
    data1.put("Expiry Date", "26-06-2026");
    data1.put("Job Urgency", "High");
    data1.put("Job Title", "AI and Autonomy Engineer");
    data1.put("Department / Division", "Artificial Intelligence and Autonomy");
    data1.put("Employment Type", "Full Time");
    data1.put("Category", "Information Technology");
    data1.put("Required Education", "M.Tech");
    data1.put("Required Experience", "Senior");
    data1.put("Expected Hiring Date", "18-08-2026");
    data1.put("Number of Positions", "1");
    data1.put("When Positions Fulfilled", "Enable Waitlist");
    data1.put("Job Description", "Build AI driven autonomy, mission logic, and smart control workflows.");
    data1.put("Job Requirements", "Experience in AI systems, ML integration, and decision logic.");
    data1.put("Benefits", "Insurance, learning support, innovation exposure, and career growth.");
    data1.put("Country", "India");
    data1.put("City / State", "Karnataka");
    data1.put("Remote", "Yes");
    data1.put("Salary From 1", "1800000");
    data1.put("Salary To 1", "2400000");
    data1.put("Unit 1", "Yearly");
    data1.put("Currency 1", "INR(₹)");
    data1.put("Salary From 2", "2400001");
    data1.put("Salary To 2", "3200000");
    data1.put("Unit 2", "Yearly");
    data1.put("Currency 2", "INR(₹)");
    data1.put("Salary From 3", "3200001");
    data1.put("Salary To 3", "4000000");
    data1.put("Unit 3", "Yearly");
    data1.put("Currency 3", "INR(₹)");
    data1.put("Screening Question 1", "Do you have AI or autonomy experience?");
    data1.put("Screening Question 2", "Have you worked on mission logic or decision systems?");
    data1.put("Screening Question 3", "Which ML tools or frameworks have you used?");
    data1.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data2 = new TreeMap<String, String>();
    data2.put("Select Template", "Custom Template");
    data2.put("Job Posting Name", "Avionics Engineer Hiring 02");
    data2.put("Expiry Date", "28-06-2026");
    data2.put("Job Urgency", "High");
    data2.put("Job Title", "Avionics Engineer");
    data2.put("Department / Division", "Avionics");
    data2.put("Employment Type", "Full Time");
    data2.put("Category", "Information Technology");
    data2.put("Required Education", "B.Tech");
    data2.put("Required Experience", "Mid-senior");
    data2.put("Expected Hiring Date", "12-08-2026");
    data2.put("Number of Positions", "2");
    data2.put("When Positions Fulfilled", "Close Job");
    data2.put("Job Description", "Support avionics integration, electronics validation, and interface checks.");
    data2.put("Job Requirements", "Experience in avionics systems, onboard electronics, and troubleshooting.");
    data2.put("Benefits", "Insurance, technical exposure, learning support, and long term growth.");
    data2.put("Country", "India");
    data2.put("City / State", "Telangana");
    data2.put("Remote", "No");
    data2.put("Salary From 1", "900000");
    data2.put("Salary To 1", "1300000");
    data2.put("Unit 1", "Yearly");
    data2.put("Currency 1", "INR(₹)");
    data2.put("Salary From 2", "1300001");
    data2.put("Salary To 2", "1700000");
    data2.put("Unit 2", "Yearly");
    data2.put("Currency 2", "INR(₹)");
    data2.put("Salary From 3", "1700001");
    data2.put("Salary To 3", "2100000");
    data2.put("Unit 3", "Yearly");
    data2.put("Currency 3", "INR(₹)");
    data2.put("Screening Question 1", "Do you have avionics experience?");
    data2.put("Screening Question 2", "Have you handled navigation or signal interfaces?");
    data2.put("Screening Question 3", "What avionics hardware have you supported?");
    data2.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data3 = new TreeMap<String, String>();
    data3.put("Select Template", "Custom Template");
    data3.put("Job Posting Name", "HR Operations Specialist Hiring 03");
    data3.put("Expiry Date", "30-06-2026");
    data3.put("Job Urgency", "Medium");
    data3.put("Job Title", "HR Operations Specialist");
    data3.put("Department / Division", "Human Resources");
    data3.put("Employment Type", "Full Time");
    data3.put("Category", "Professional Service");
    data3.put("Required Education", "MBA");
    data3.put("Required Experience", "Junior");
    data3.put("Expected Hiring Date", "10-07-2026");
    data3.put("Number of Positions", "1");
    data3.put("When Positions Fulfilled", "Close Job");
    data3.put("Job Description", "Manage onboarding, records, attendance support, and HR coordination.");
    data3.put("Job Requirements", "Experience in HR operations, documentation, and employee handling.");
    data3.put("Benefits", "Health cover, paid leave, stable culture, and HR career growth.");
    data3.put("Country", "India");
    data3.put("City / State", "Maharashtra");
    data3.put("Remote", "No");
    data3.put("Salary From 1", "400000");
    data3.put("Salary To 1", "600000");
    data3.put("Unit 1", "Yearly");
    data3.put("Currency 1", "INR(₹)");
    data3.put("Salary From 2", "600001");
    data3.put("Salary To 2", "800000");
    data3.put("Unit 2", "Yearly");
    data3.put("Currency 2", "INR(₹)");
    data3.put("Salary From 3", "800001");
    data3.put("Salary To 3", "1000000");
    data3.put("Unit 3", "Yearly");
    data3.put("Currency 3", "INR(₹)");
    data3.put("Screening Question 1", "Do you have onboarding or attendance experience?");
    data3.put("Screening Question 2", "Have you managed HR records or policy communication?");
    data3.put("Screening Question 3", "How do you keep employee data confidential?");
    data3.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data4 = new TreeMap<String, String>();
    data4.put("Select Template", "Custom Template");
    data4.put("Job Posting Name", "Product Manager - UAV Platforms Hiring 04");
    data4.put("Expiry Date", "02-07-2026");
    data4.put("Job Urgency", "High");
    data4.put("Job Title", "Product Manager - UAV Platforms");
    data4.put("Department / Division", "Product Management");
    data4.put("Employment Type", "Full Time");
    data4.put("Category", "Information Technology");
    data4.put("Required Education", "MBA");
    data4.put("Required Experience", "Senior");
    data4.put("Expected Hiring Date", "20-08-2026");
    data4.put("Number of Positions", "1");
    data4.put("When Positions Fulfilled", "Enable Waitlist");
    data4.put("Job Description", "Own requirements, roadmap priorities, and delivery alignment.");
    data4.put("Job Requirements", "Experience in product planning, stakeholder management, and prioritization.");
    data4.put("Benefits", "Insurance, roadmap ownership, visibility, and leadership growth.");
    data4.put("Country", "India");
    data4.put("City / State", "Haryana");
    data4.put("Remote", "Yes");
    data4.put("Salary From 1", "1600000");
    data4.put("Salary To 1", "2200000");
    data4.put("Unit 1", "Yearly");
    data4.put("Currency 1", "INR(₹)");
    data4.put("Salary From 2", "2200001");
    data4.put("Salary To 2", "2800000");
    data4.put("Unit 2", "Yearly");
    data4.put("Currency 2", "INR(₹)");
    data4.put("Salary From 3", "2800001");
    data4.put("Salary To 3", "3400000");
    data4.put("Unit 3", "Yearly");
    data4.put("Currency 3", "INR(₹)");
    data4.put("Screening Question 1", "Do you have product roadmap experience?");
    data4.put("Screening Question 2", "Have you worked with engineering and business teams?");
    data4.put("Screening Question 3", "How do you balance user and business needs?");
    data4.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data5 = new TreeMap<String, String>();
    data5.put("Select Template", "Custom Template");
    data5.put("Job Posting Name", "Quality Assurance Engineer Hiring 05");
    data5.put("Expiry Date", "05-07-2026");
    data5.put("Job Urgency", "High");
    data5.put("Job Title", "Quality Assurance Engineer");
    data5.put("Department / Division", "Quality Assurance");
    data5.put("Employment Type", "Full Time");
    data5.put("Category", "Quality Analysis");
    data5.put("Required Education", "B.Tech");
    data5.put("Required Experience", "Junior");
    data5.put("Expected Hiring Date", "18-08-2026");
    data5.put("Number of Positions", "2");
    data5.put("When Positions Fulfilled", "Close Job");
    data5.put("Job Description", "Validate workflows, execute regression, and report defects clearly.");
    data5.put("Job Requirements", "Experience in functional testing, regression, and bug reporting.");
    data5.put("Benefits", "Insurance, learning support, QA exposure, and career growth.");
    data5.put("Country", "India");
    data5.put("City / State", "West Bengal");
    data5.put("Remote", "Yes");
    data5.put("Salary From 1", "600000");
    data5.put("Salary To 1", "850000");
    data5.put("Unit 1", "Yearly");
    data5.put("Currency 1", "INR(₹)");
    data5.put("Salary From 2", "850001");
    data5.put("Salary To 2", "1100000");
    data5.put("Unit 2", "Yearly");
    data5.put("Currency 2", "INR(₹)");
    data5.put("Salary From 3", "1100001");
    data5.put("Salary To 3", "1350000");
    data5.put("Unit 3", "Yearly");
    data5.put("Currency 3", "INR(₹)");
    data5.put("Screening Question 1", "Do you have functional and regression testing experience?");
    data5.put("Screening Question 2", "Have you created end to end test scenarios?");
    data5.put("Screening Question 3", "Which QA tools have you used?");
    data5.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data6 = new TreeMap<String, String>();
    data6.put("Select Template", "Custom Template");
    data6.put("Job Posting Name", "Technical Customer Support Specialist Hiring 06");
    data6.put("Expiry Date", "08-07-2026");
    data6.put("Job Urgency", "Medium");
    data6.put("Job Title", "Technical Customer Support Specialist");
    data6.put("Department / Division", "Customer Support");
    data6.put("Employment Type", "Full Time");
    data6.put("Category", "Professional Service");
    data6.put("Required Education", "B.Sc");
    data6.put("Required Experience", "Entry-level");
    data6.put("Expected Hiring Date", "25-07-2026");
    data6.put("Number of Positions", "2");
    data6.put("When Positions Fulfilled", "Enable Waitlist");
    data6.put("Job Description", "Handle tickets, issue triage, and basic customer troubleshooting.");
    data6.put("Job Requirements", "Exposure to support workflows, escalation, and client communication.");
    data6.put("Benefits", "Insurance, support exposure, stable role, and growth.");
    data6.put("Country", "India");
    data6.put("City / State", "Tamil Nadu");
    data6.put("Remote", "Yes");
    data6.put("Salary From 1", "350000");
    data6.put("Salary To 1", "500000");
    data6.put("Unit 1", "Yearly");
    data6.put("Currency 1", "INR(₹)");
    data6.put("Salary From 2", "500001");
    data6.put("Salary To 2", "650000");
    data6.put("Unit 2", "Yearly");
    data6.put("Currency 2", "INR(₹)");
    data6.put("Salary From 3", "650001");
    data6.put("Salary To 3", "800000");
    data6.put("Unit 3", "Yearly");
    data6.put("Currency 3", "INR(₹)");
    data6.put("Screening Question 1", "Do you have ticket handling experience?");
    data6.put("Screening Question 2", "Can you coordinate with product or engineering teams?");
    data6.put("Screening Question 3", "Have you supported technical users before?");
    data6.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data7 = new TreeMap<String, String>();
    data7.put("Select Template", "Custom Template");
    data7.put("Job Posting Name", "Embedded Systems Engineer Hiring 07");
    data7.put("Expiry Date", "10-07-2026");
    data7.put("Job Urgency", "High");
    data7.put("Job Title", "Embedded Systems Engineer");
    data7.put("Department / Division", "Embedded Systems");
    data7.put("Employment Type", "Full Time");
    data7.put("Category", "Information Technology");
    data7.put("Required Education", "B.Tech");
    data7.put("Required Experience", "Mid-senior");
    data7.put("Expected Hiring Date", "28-08-2026");
    data7.put("Number of Positions", "2");
    data7.put("When Positions Fulfilled", "Enable Waitlist");
    data7.put("Job Description", "Develop firmware and support low level system integration.");
    data7.put("Job Requirements", "Experience in embedded C, microcontrollers, and debugging.");
    data7.put("Benefits", "Health insurance, technical learning, and core engineering exposure.");
    data7.put("Country", "India");
    data7.put("City / State", "Uttar Pradesh");
    data7.put("Remote", "No");
    data7.put("Salary From 1", "850000");
    data7.put("Salary To 1", "1200000");
    data7.put("Unit 1", "Yearly");
    data7.put("Currency 1", "INR(₹)");
    data7.put("Salary From 2", "1200001");
    data7.put("Salary To 2", "1600000");
    data7.put("Unit 2", "Yearly");
    data7.put("Currency 2", "INR(₹)");
    data7.put("Salary From 3", "1600001");
    data7.put("Salary To 3", "2000000");
    data7.put("Unit 3", "Yearly");
    data7.put("Currency 3", "INR(₹)");
    data7.put("Screening Question 1", "Do you have firmware or embedded experience?");
    data7.put("Screening Question 2", "Have you worked with microcontrollers?");
    data7.put("Screening Question 3", "Which boards or tools have you used?");
    data7.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data8 = new TreeMap<String, String>();
    data8.put("Select Template", "Custom Template");
    data8.put("Job Posting Name", "Cybersecurity Engineer Hiring 08");
    data8.put("Expiry Date", "12-07-2026");
    data8.put("Job Urgency", "High");
    data8.put("Job Title", "Cybersecurity Engineer");
    data8.put("Department / Division", "Cybersecurity");
    data8.put("Employment Type", "Full Time");
    data8.put("Category", "Information Technology");
    data8.put("Required Education", "B.Tech");
    data8.put("Required Experience", "Mid-senior");
    data8.put("Expected Hiring Date", "30-08-2026");
    data8.put("Number of Positions", "1");
    data8.put("When Positions Fulfilled", "Close Job");
    data8.put("Job Description", "Secure systems, review access controls, and support hardening.");
    data8.put("Job Requirements", "Good understanding of security checks, access validation, and risk review.");
    data8.put("Benefits", "Insurance, security exposure, ongoing learning, and specialization.");
    data8.put("Country", "India");
    data8.put("City / State", "Gujarat");
    data8.put("Remote", "Yes");
    data8.put("Salary From 1", "1000000");
    data8.put("Salary To 1", "1400000");
    data8.put("Unit 1", "Yearly");
    data8.put("Currency 1", "INR(₹)");
    data8.put("Salary From 2", "1400001");
    data8.put("Salary To 2", "1800000");
    data8.put("Unit 2", "Yearly");
    data8.put("Currency 2", "INR(₹)");
    data8.put("Salary From 3", "1800001");
    data8.put("Salary To 3", "2200000");
    data8.put("Unit 3", "Yearly");
    data8.put("Currency 3", "INR(₹)");
    data8.put("Screening Question 1", "Do you have vulnerability assessment experience?");
    data8.put("Screening Question 2", "Have you reviewed access or security risks?");
    data8.put("Screening Question 3", "Which security tools do you use most?");
    data8.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data9 = new TreeMap<String, String>();
    data9.put("Select Template", "Custom Template");
    data9.put("Job Posting Name", "Mechanical Design Engineer Hiring 09");
    data9.put("Expiry Date", "14-07-2026");
    data9.put("Job Urgency", "High");
    data9.put("Job Title", "Mechanical Design Engineer");
    data9.put("Department / Division", "Mechanical Design");
    data9.put("Employment Type", "Full Time");
    data9.put("Category", "Information Technology");
    data9.put("Required Education", "B.Tech");
    data9.put("Required Experience", "Mid-senior");
    data9.put("Expected Hiring Date", "05-09-2026");
    data9.put("Number of Positions", "2");
    data9.put("When Positions Fulfilled", "Enable Waitlist");
    data9.put("Job Description", "Design structures, enclosures, and assemblies for development work.");
    data9.put("Job Requirements", "Hands on experience with CAD, design review, and prototypes.");
    data9.put("Benefits", "Insurance, design ownership, engineering visibility, and growth.");
    data9.put("Country", "India");
    data9.put("City / State", "Odisha");
    data9.put("Remote", "No");
    data9.put("Salary From 1", "900000");
    data9.put("Salary To 1", "1300000");
    data9.put("Unit 1", "Yearly");
    data9.put("Currency 1", "INR(₹)");
    data9.put("Salary From 2", "1300001");
    data9.put("Salary To 2", "1700000");
    data9.put("Unit 2", "Yearly");
    data9.put("Currency 2", "INR(₹)");
    data9.put("Salary From 3", "1700001");
    data9.put("Salary To 3", "2100000");
    data9.put("Unit 3", "Yearly");
    data9.put("Currency 3", "INR(₹)");
    data9.put("Screening Question 1", "Do you have CAD based design experience?");
    data9.put("Screening Question 2", "Have you built enclosures or assemblies?");
    data9.put("Screening Question 3", "Which design tools do you use?");
    data9.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data10 = new TreeMap<String, String>();
    data10.put("Select Template", "Custom Template");
    data10.put("Job Posting Name", "Finance and Administration Executive Hiring 10");
    data10.put("Expiry Date", "16-07-2026");
    data10.put("Job Urgency", "Medium");
    data10.put("Job Title", "Finance and Administration Executive");
    data10.put("Department / Division", "Finance and Administration");
    data10.put("Employment Type", "Full Time");
    data10.put("Category", "Professional Service");
    data10.put("Required Education", "B.Com");
    data10.put("Required Experience", "Junior");
    data10.put("Expected Hiring Date", "25-08-2026");
    data10.put("Number of Positions", "1");
    data10.put("When Positions Fulfilled", "Close Job");
    data10.put("Job Description", "Support billing, expenses, vendor coordination, and admin tasks.");
    data10.put("Job Requirements", "Experience in invoices, records, spreadsheets, and coordination.");
    data10.put("Benefits", "Paid leave, insurance, stable environment, and finance exposure.");
    data10.put("Country", "India");
    data10.put("City / State", "Kerala");
    data10.put("Remote", "No");
    data10.put("Salary From 1", "350000");
    data10.put("Salary To 1", "550000");
    data10.put("Unit 1", "Yearly");
    data10.put("Currency 1", "INR(₹)");
    data10.put("Salary From 2", "550001");
    data10.put("Salary To 2", "750000");
    data10.put("Unit 2", "Yearly");
    data10.put("Currency 2", "INR(₹)");
    data10.put("Salary From 3", "750001");
    data10.put("Salary To 3", "950000");
    data10.put("Unit 3", "Yearly");
    data10.put("Currency 3", "INR(₹)");
    data10.put("Screening Question 1", "Do you have invoice or expense tracking experience?");
    data10.put("Screening Question 2", "Have you worked on finance records or admin support?");
    data10.put("Screening Question 3", "Which spreadsheets or tools have you used?");
    data10.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data11 = new TreeMap<String, String>();
    data11.put("Select Template", "Custom Template");
    data11.put("Job Posting Name", "Operations Coordinator Hiring 11");
    data11.put("Expiry Date", "18-07-2026");
    data11.put("Job Urgency", "Medium");
    data11.put("Job Title", "Operations Coordinator");
    data11.put("Department / Division", "Operations");
    data11.put("Employment Type", "Full Time");
    data11.put("Category", "Professional Service");
    data11.put("Required Education", "BBA");
    data11.put("Required Experience", "Junior");
    data11.put("Expected Hiring Date", "30-08-2026");
    data11.put("Number of Positions", "1");
    data11.put("When Positions Fulfilled", "Close Job");
    data11.put("Job Description", "Support daily operations, reporting, and follow up activities.");
    data11.put("Job Requirements", "Experience in coordination, reporting, and documentation is preferred.");
    data11.put("Benefits", "Insurance, process exposure, coordination role, and business growth.");
    data11.put("Country", "India");
    data11.put("City / State", "Rajasthan");
    data11.put("Remote", "No");
    data11.put("Salary From 1", "380000");
    data11.put("Salary To 1", "580000");
    data11.put("Unit 1", "Yearly");
    data11.put("Currency 1", "INR(₹)");
    data11.put("Salary From 2", "580001");
    data11.put("Salary To 2", "780000");
    data11.put("Unit 2", "Yearly");
    data11.put("Currency 2", "INR(₹)");
    data11.put("Salary From 3", "780001");
    data11.put("Salary To 3", "980000");
    data11.put("Unit 3", "Yearly");
    data11.put("Currency 3", "INR(₹)");
    data11.put("Screening Question 1", "Do you have operations experience?");
    data11.put("Screening Question 2", "Have you managed reporting or follow ups?");
    data11.put("Screening Question 3", "How do you track multiple tasks?");
    data11.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data12 = new TreeMap<String, String>();
    data12.put("Select Template", "Custom Template");
    data12.put("Job Posting Name", "Supply Chain and Procurement Specialist Hiring 12");
    data12.put("Expiry Date", "20-07-2026");
    data12.put("Job Urgency", "Medium");
    data12.put("Job Title", "Supply Chain and Procurement Specialist");
    data12.put("Department / Division", "Supply Chain and Procurement");
    data12.put("Employment Type", "Full Time");
    data12.put("Category", "Professional Service");
    data12.put("Required Education", "BBA");
    data12.put("Required Experience", "Mid-senior");
    data12.put("Expected Hiring Date", "05-09-2026");
    data12.put("Number of Positions", "1");
    data12.put("When Positions Fulfilled", "Close Job");
    data12.put("Job Description", "Manage sourcing, purchase planning, and vendor coordination.");
    data12.put("Job Requirements", "Experience in procurement, purchase tracking, and supply flow.");
    data12.put("Benefits", "Insurance, procurement ownership, and long term career growth.");
    data12.put("Country", "India");
    data12.put("City / State", "Madhya Pradesh");
    data12.put("Remote", "No");
    data12.put("Salary From 1", "500000");
    data12.put("Salary To 1", "700000");
    data12.put("Unit 1", "Yearly");
    data12.put("Currency 1", "INR(₹)");
    data12.put("Salary From 2", "700001");
    data12.put("Salary To 2", "900000");
    data12.put("Unit 2", "Yearly");
    data12.put("Currency 2", "INR(₹)");
    data12.put("Salary From 3", "900001");
    data12.put("Salary To 3", "1100000");
    data12.put("Unit 3", "Yearly");
    data12.put("Currency 3", "INR(₹)");
    data12.put("Screening Question 1", "Do you have sourcing or procurement experience?");
    data12.put("Screening Question 2", "Have you managed purchase orders or inventory flow?");
    data12.put("Screening Question 3", "How do you handle supply delays?");
    data12.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data13 = new TreeMap<String, String>();
    data13.put("Select Template", "Custom Template");
    data13.put("Job Posting Name", "Research and Development Engineer Hiring 13");
    data13.put("Expiry Date", "22-07-2026");
    data13.put("Job Urgency", "Medium");
    data13.put("Job Title", "Research and Development Engineer");
    data13.put("Department / Division", "Research and Development");
    data13.put("Employment Type", "Full Time");
    data13.put("Category", "Information Technology");
    data13.put("Required Education", "M.Tech");
    data13.put("Required Experience", "Senior");
    data13.put("Expected Hiring Date", "10-09-2026");
    data13.put("Number of Positions", "2");
    data13.put("When Positions Fulfilled", "Enable Waitlist");
    data13.put("Job Description", "Explore new ideas, test concepts, and support prototype work.");
    data13.put("Job Requirements", "Strong analytical mindset with research and experimentation exposure.");
    data13.put("Benefits", "Insurance, innovation exposure, and strong growth path.");
    data13.put("Country", "India");
    data13.put("City / State", "Bihar");
    data13.put("Remote", "No");
    data13.put("Salary From 1", "1200000");
    data13.put("Salary To 1", "1600000");
    data13.put("Unit 1", "Yearly");
    data13.put("Currency 1", "INR(₹)");
    data13.put("Salary From 2", "1600001");
    data13.put("Salary To 2", "2100000");
    data13.put("Unit 2", "Yearly");
    data13.put("Currency 2", "INR(₹)");
    data13.put("Salary From 3", "2100001");
    data13.put("Salary To 3", "2600000");
    data13.put("Unit 3", "Yearly");
    data13.put("Currency 3", "INR(₹)");
    data13.put("Screening Question 1", "Do you have research or prototype experience?");
    data13.put("Screening Question 2", "Have you worked on proof of concept tasks?");
    data13.put("Screening Question 3", "How do you document findings?");
    data13.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data14 = new TreeMap<String, String>();
    data14.put("Select Template", "Custom Template");
    data14.put("Job Posting Name", "Test and Validation Engineer Hiring 14");
    data14.put("Expiry Date", "24-07-2026");
    data14.put("Job Urgency", "High");
    data14.put("Job Title", "Test and Validation Engineer");
    data14.put("Department / Division", "Testing and Validation");
    data14.put("Employment Type", "Full Time");
    data14.put("Category", "Quality Analysis");
    data14.put("Required Education", "B.Tech");
    data14.put("Required Experience", "Mid-senior");
    data14.put("Expected Hiring Date", "15-09-2026");
    data14.put("Number of Positions", "2");
    data14.put("When Positions Fulfilled", "Close Job");
    data14.put("Job Description", "Plan tests, execute validations, and report results clearly.");
    data14.put("Job Requirements", "Experience in validation planning, execution, and result analysis.");
    data14.put("Benefits", "Insurance, lab exposure, and steady role growth.");
    data14.put("Country", "India");
    data14.put("City / State", "Maharashtra");
    data14.put("Remote", "No");
    data14.put("Salary From 1", "900000");
    data14.put("Salary To 1", "1300000");
    data14.put("Unit 1", "Yearly");
    data14.put("Currency 1", "INR(₹)");
    data14.put("Salary From 2", "1300001");
    data14.put("Salary To 2", "1700000");
    data14.put("Unit 2", "Yearly");
    data14.put("Currency 2", "INR(₹)");
    data14.put("Salary From 3", "1700001");
    data14.put("Salary To 3", "2100000");
    data14.put("Unit 3", "Yearly");
    data14.put("Currency 3", "INR(₹)");
    data14.put("Screening Question 1", "Do you have validation execution experience?");
    data14.put("Screening Question 2", "Have you worked on integration or performance validation?");
    data14.put("Screening Question 3", "How do you report failures clearly?");
    data14.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data15 = new TreeMap<String, String>();
    data15.put("Select Template", "Custom Template");
    data15.put("Job Posting Name", "UAV Field Deployment Engineer Hiring 15");
    data15.put("Expiry Date", "26-07-2026");
    data15.put("Job Urgency", "High");
    data15.put("Job Title", "UAV Field Deployment Engineer");
    data15.put("Department / Division", "Field Deployment");
    data15.put("Employment Type", "Full Time");
    data15.put("Category", "Professional Service");
    data15.put("Required Education", "B.Tech");
    data15.put("Required Experience", "Junior");
    data15.put("Expected Hiring Date", "20-09-2026");
    data15.put("Number of Positions", "2");
    data15.put("When Positions Fulfilled", "Close Job");
    data15.put("Job Description", "Support field setup, deployment checks, and live troubleshooting.");
    data15.put("Job Requirements", "Experience in hardware setup and customer side technical support.");
    data15.put("Benefits", "Travel support, insurance, field exposure, and growth.");
    data15.put("Country", "India");
    data15.put("City / State", "Jharkhand");
    data15.put("Remote", "No");
    data15.put("Salary From 1", "650000");
    data15.put("Salary To 1", "900000");
    data15.put("Unit 1", "Yearly");
    data15.put("Currency 1", "INR(₹)");
    data15.put("Salary From 2", "900001");
    data15.put("Salary To 2", "1200000");
    data15.put("Unit 2", "Yearly");
    data15.put("Currency 2", "INR(₹)");
    data15.put("Salary From 3", "1200001");
    data15.put("Salary To 3", "1500000");
    data15.put("Unit 3", "Yearly");
    data15.put("Currency 3", "INR(₹)");
    data15.put("Screening Question 1", "Do you have field support experience?");
    data15.put("Screening Question 2", "Are you comfortable with travel?");
    data15.put("Screening Question 3", "Have you handled live hardware issues?");
    data15.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data16 = new TreeMap<String, String>();
    data16.put("Select Template", "Custom Template");
    data16.put("Job Posting Name", "Product QA Analyst Hiring 16");
    data16.put("Expiry Date", "28-07-2026");
    data16.put("Job Urgency", "Medium");
    data16.put("Job Title", "Product QA Analyst");
    data16.put("Department / Division", "Product Quality");
    data16.put("Employment Type", "Full Time");
    data16.put("Category", "Product QA");
    data16.put("Required Education", "B.Tech");
    data16.put("Required Experience", "Junior");
    data16.put("Expected Hiring Date", "25-09-2026");
    data16.put("Number of Positions", "2");
    data16.put("When Positions Fulfilled", "Enable Waitlist");
    data16.put("Job Description", "Validate product behavior and support release quality.");
    data16.put("Job Requirements", "Experience in product testing, workflows, and defect handling.");
    data16.put("Benefits", "Insurance, product exposure, team collaboration, and growth.");
    data16.put("Country", "India");
    data16.put("City / State", "Uttar Pradesh");
    data16.put("Remote", "Yes");
    data16.put("Salary From 1", "550000");
    data16.put("Salary To 1", "800000");
    data16.put("Unit 1", "Yearly");
    data16.put("Currency 1", "INR(₹)");
    data16.put("Salary From 2", "800001");
    data16.put("Salary To 2", "1050000");
    data16.put("Unit 2", "Yearly");
    data16.put("Currency 2", "INR(₹)");
    data16.put("Salary From 3", "1050001");
    data16.put("Salary To 3", "1300000");
    data16.put("Unit 3", "Yearly");
    data16.put("Currency 3", "INR(₹)");
    data16.put("Screening Question 1", "Do you have product validation experience?");
    data16.put("Screening Question 2", "Have you checked business workflows end to end?");
    data16.put("Screening Question 3", "How do you balance logic and user experience?");
    data16.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data17 = new TreeMap<String, String>();
    data17.put("Select Template", "Custom Template");
    data17.put("Job Posting Name", "UI QA Analyst Hiring 17");
    data17.put("Expiry Date", "30-07-2026");
    data17.put("Job Urgency", "Medium");
    data17.put("Job Title", "UI QA Analyst");
    data17.put("Department / Division", "Design QA");
    data17.put("Employment Type", "Full Time");
    data17.put("Category", "UI Testing");
    data17.put("Required Education", "B.Des");
    data17.put("Required Experience", "Junior");
    data17.put("Expected Hiring Date", "28-09-2026");
    data17.put("Number of Positions", "1");
    data17.put("When Positions Fulfilled", "Close Job");
    data17.put("Job Description", "Validate visuals, responsive behavior, and front end quality.");
    data17.put("Job Requirements", "Experience in UI checks, design comparison, and issue reporting.");
    data17.put("Benefits", "Insurance, design exposure, and specialization growth.");
    data17.put("Country", "India");
    data17.put("City / State", "Gujarat");
    data17.put("Remote", "Yes");
    data17.put("Salary From 1", "450000");
    data17.put("Salary To 1", "650000");
    data17.put("Unit 1", "Yearly");
    data17.put("Currency 1", "INR(₹)");
    data17.put("Salary From 2", "650001");
    data17.put("Salary To 2", "850000");
    data17.put("Unit 2", "Yearly");
    data17.put("Currency 2", "INR(₹)");
    data17.put("Salary From 3", "850001");
    data17.put("Salary To 3", "1050000");
    data17.put("Unit 3", "Yearly");
    data17.put("Currency 3", "INR(₹)");
    data17.put("Screening Question 1", "Do you have UI testing experience?");
    data17.put("Screening Question 2", "Have you reported visual issues before?");
    data17.put("Screening Question 3", "Which tools do you use for UI checks?");
    data17.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data18 = new TreeMap<String, String>();
    data18.put("Select Template", "Custom Template");
    data18.put("Job Posting Name", "Manufacturing Engineer Hiring 18");
    data18.put("Expiry Date", "01-08-2026");
    data18.put("Job Urgency", "High");
    data18.put("Job Title", "Manufacturing Engineer");
    data18.put("Department / Division", "Manufacturing");
    data18.put("Employment Type", "Full Time");
    data18.put("Category", "Professional Service");
    data18.put("Required Education", "B.Tech");
    data18.put("Required Experience", "Mid-senior");
    data18.put("Expected Hiring Date", "05-10-2026");
    data18.put("Number of Positions", "2");
    data18.put("When Positions Fulfilled", "Close Job");
    data18.put("Job Description", "Improve production flow and documentation quality.");
    data18.put("Job Requirements", "Experience in manufacturing operations and process improvement.");
    data18.put("Benefits", "Health cover, production exposure, and role growth.");
    data18.put("Country", "India");
    data18.put("City / State", "Tamil Nadu");
    data18.put("Remote", "No");
    data18.put("Salary From 1", "800000");
    data18.put("Salary To 1", "1100000");
    data18.put("Unit 1", "Yearly");
    data18.put("Currency 1", "INR(₹)");
    data18.put("Salary From 2", "1100001");
    data18.put("Salary To 2", "1450000");
    data18.put("Unit 2", "Yearly");
    data18.put("Currency 2", "INR(₹)");
    data18.put("Salary From 3", "1450001");
    data18.put("Salary To 3", "1800000");
    data18.put("Unit 3", "Yearly");
    data18.put("Currency 3", "INR(₹)");
    data18.put("Screening Question 1", "Do you have manufacturing workflow experience?");
    data18.put("Screening Question 2", "Have you improved process efficiency before?");
    data18.put("Screening Question 3", "What technical environments have you worked in?");
    data18.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data19 = new TreeMap<String, String>();
    data19.put("Select Template", "Custom Template");
    data19.put("Job Posting Name", "Accessibility QA Engineer Hiring 19");
    data19.put("Expiry Date", "03-08-2026");
    data19.put("Job Urgency", "High");
    data19.put("Job Title", "Accessibility QA Engineer");
    data19.put("Department / Division", "Inclusive Quality");
    data19.put("Employment Type", "Full Time");
    data19.put("Category", "Accessibility Testing");
    data19.put("Required Education", "B.Tech");
    data19.put("Required Experience", "Mid-senior");
    data19.put("Expected Hiring Date", "12-10-2026");
    data19.put("Number of Positions", "1");
    data19.put("When Positions Fulfilled", "Enable Waitlist");
    data19.put("Job Description", "Test accessibility, keyboard flow, and inclusive usability.");
    data19.put("Job Requirements", "Experience in accessibility checks, focus handling, and UI review.");
    data19.put("Benefits", "Insurance, meaningful impact, and specialization growth.");
    data19.put("Country", "India");
    data19.put("City / State", "Kerala");
    data19.put("Remote", "Yes");
    data19.put("Salary From 1", "750000");
    data19.put("Salary To 1", "1050000");
    data19.put("Unit 1", "Yearly");
    data19.put("Currency 1", "INR(₹)");
    data19.put("Salary From 2", "1050001");
    data19.put("Salary To 2", "1350000");
    data19.put("Unit 2", "Yearly");
    data19.put("Currency 2", "INR(₹)");
    data19.put("Salary From 3", "1350001");
    data19.put("Salary To 3", "1650000");
    data19.put("Unit 3", "Yearly");
    data19.put("Currency 3", "INR(₹)");
    data19.put("Screening Question 1", "Do you have accessibility testing experience?");
    data19.put("Screening Question 2", "Have you validated keyboard navigation?");
    data19.put("Screening Question 3", "How do you judge accessibility quality?");
    data19.put("Save As Job Posting Template", "No");

    TreeMap<String, String> data20 = new TreeMap<String, String>();
    data20.put("Select Template", "Custom Template");
    data20.put("Job Posting Name", "Technical Documentation Specialist Hiring 20");
    data20.put("Expiry Date", "05-08-2026");
    data20.put("Job Urgency", "Low");
    data20.put("Job Title", "Technical Documentation Specialist");
    data20.put("Department / Division", "Documentation");
    data20.put("Employment Type", "Full Time");
    data20.put("Category", "Documentation");
    data20.put("Required Education", "M.A");
    data20.put("Required Experience", "Entry-level");
    data20.put("Expected Hiring Date", "15-10-2026");
    data20.put("Number of Positions", "1");
    data20.put("When Positions Fulfilled", "Close Job");
    data20.put("Job Description", "Prepare guides, release notes, and process documentation.");
    data20.put("Job Requirements", "Strong writing, structure, and documentation discipline.");
    data20.put("Benefits", "Stable role, insurance, documentation exposure, and process ownership.");
    data20.put("Country", "India");
    data20.put("City / State", "Andhra Pradesh");
    data20.put("Remote", "Yes");
    data20.put("Salary From 1", "300000");
    data20.put("Salary To 1", "500000");
    data20.put("Unit 1", "Yearly");
    data20.put("Currency 1", "INR(₹)");
    data20.put("Salary From 2", "500001");
    data20.put("Salary To 2", "700000");
    data20.put("Unit 2", "Yearly");
    data20.put("Currency 2", "INR(₹)");
    data20.put("Salary From 3", "700001");
    data20.put("Salary To 3", "900000");
    data20.put("Unit 3", "Yearly");
    data20.put("Currency 3", "INR(₹)");
    data20.put("Screening Question 1", "Do you have technical documentation experience?");
    data20.put("Screening Question 2", "Have you maintained release notes or process docs?");
    data20.put("Screening Question 3", "How do you keep documentation accurate?");
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
