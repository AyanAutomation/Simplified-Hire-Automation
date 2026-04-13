package Product_Codeclouds.Project.Simplified;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

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
	public void Job_Add(TreeMap<String, String> job_data) throws IOException, InterruptedException {
		
		Job_Module_locaters p = new Job_Module_locaters(d);
		JavascriptExecutor js = (JavascriptExecutor) d;
		Repeat rp = new Repeat(d);
		
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
		List<WebElement> Dropdowns = p.Form_General_Dropdown_fields();
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
		
		List<WebElement> Buttons = p.Buttons();
		List<WebElement> Description_feilds = null;

		try {
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(800);
			Description_feilds = p.Form_Description_fields();

		} catch (Exception e) {
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(1000);
			Description_feilds = p.Form_Description_fields();
		}
		
		input_fields.get(0).sendKeys(Job_Posting_Name);
		input_fields.get(1).click();
		p.Today_Button_calendar().click();
		WebElement Job_Urgency_feild= Dropdowns.get(1);
		Job_Urgency_feild.click();
		List<WebElement> jb_urgency_options = p.First_dropdown_Options();
		for(WebElement option : jb_urgency_options) {
			String option_text = option.getText().trim();
			 if(option_text.contains(Job_Urgency)) {
				 option.click();
				 break;}}
		WebElement JobTitle_feild = input_fields.get(2);

		JobTitle_feild.sendKeys(Job_Title);
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
	    WebElement Category_feild = Custom_Dropdowns.get(1);
	    js.executeScript("arguments[0].click();", Category_feild);/*
	    p.Category_field().sendKeys(Category);/*
		input_fields.get(4).sendKeys();
		input_fields.get(5).sendKeys(); */
		
	}
	
	
	
	@DataProvider
	public Object[][] Job_Posting_Data() {

	    TreeMap<String, String> data1 = new TreeMap<String, String>();
	    data1.put("Select Template", "Custom Template");
	    data1.put("Job Posting Name", "Automation QA Engineer Hiring 01");
	    data1.put("Expiry Date", "30-04-2026");
	    data1.put("Job Urgency", "High");
	    data1.put("Job Title", "Automation Test Engineer");
	    data1.put("Department / Division", "Quality Assurance");
	    data1.put("Employment Type", "Full Time");
	    data1.put("Category", "IT / Software");
	    data1.put("Required Education", "B.Tech");
	    data1.put("Required Experience", "3-5 Years");
	    data1.put("Expected Hiring Date", "15-05-2026");
	    data1.put("Number of Positions", "3");
	    data1.put("When Positions Fulfilled", "Close Job Posting");
	    data1.put("Job Description", "We are hiring an Automation Test Engineer to join our growing quality engineering team. The candidate will be responsible for designing, maintaining, and executing automated test cases for web-based applications, validating end-to-end user flows, identifying regression impact areas, and collaborating with developers, business analysts, and product stakeholders to ensure high product quality. The role requires hands-on experience in functional automation, defect reporting, test design, and framework usage across fast-paced release cycles.");
	    data1.put("Job Requirements", "Strong hands-on experience in Java, Selenium WebDriver, TestNG, Maven, Git, and basic SQL. Good understanding of SDLC, STLC, bug life cycle, data validation, functional testing, smoke testing, regression testing, and cross-browser verification. Candidate should be comfortable with locators, synchronization handling, reusable framework components, reporting, and debugging flaky automation scenarios in dynamic UI applications.");
	    data1.put("Benefits", "Competitive compensation, health insurance coverage, performance-based increments, paid leave, exposure to enterprise-level QA practices, career growth support, collaborative team culture, and opportunities to work on modern automation tools and evolving testing processes.");
	    data1.put("Country", "India");
	    data1.put("City / State", "Kolkata, West Bengal");
	    data1.put("Remote", "Yes");
	    data1.put("Salary From 1", "500000");
	    data1.put("Salary To 1", "700000");
	    data1.put("Unit 1", "Yearly");
	    data1.put("Currency 1", "INR(₹)");
	    data1.put("Salary From 2", "700001");
	    data1.put("Salary To 2", "900000");
	    data1.put("Unit 2", "Yearly");
	    data1.put("Currency 2", "INR(₹)");
	    data1.put("Salary From 3", "900001");
	    data1.put("Salary To 3", "1200000");
	    data1.put("Unit 3", "Yearly");
	    data1.put("Currency 3", "INR(₹)");
	    data1.put("Save As Job Posting Template", "No");

	    TreeMap<String, String> data2 = new TreeMap<String, String>();
	    data2.put("Select Template", "Custom Template");
	    data2.put("Job Posting Name", "Senior QA Automation Hiring 02");
	    data2.put("Expiry Date", "02-05-2026");
	    data2.put("Job Urgency", "Medium");
	    data2.put("Job Title", "Senior QA Automation Engineer");
	    data2.put("Department / Division", "Engineering");
	    data2.put("Employment Type", "Full Time");
	    data2.put("Category", "Software Testing");
	    data2.put("Required Education", "B.Sc");
	    data2.put("Required Experience", "5-7 Years");
	    data2.put("Expected Hiring Date", "01-06-2026");
	    data2.put("Number of Positions", "2");
	    data2.put("When Positions Fulfilled", "Keep Open");
	    data2.put("Job Description", "We are looking for a Senior QA Automation Engineer who can take ownership of automation strategy, test planning, reusable suite maintenance, and release-level validation for multiple modules. The candidate will work closely with product managers, developers, and QA members to improve automation coverage, reduce manual effort, investigate failures, and support quality practices from requirement analysis to production release validation. This role is ideal for someone who can contribute technically while also bringing process maturity to the team.");
	    data2.put("Job Requirements", "Strong experience in Java, Selenium, TestNG, API testing, framework design, defect analysis, CI/CD integration, version control, and reporting. Candidate should understand robust locator strategies, wait handling, stale element handling, reusable utility methods, and hybrid automation practices. Exposure to agile methodology, sprint testing, and root cause analysis of unstable automation cases is preferred.");
	    data2.put("Benefits", "Medical insurance, annual performance review, flexible work policy, learning and development support, exposure to large-scale enterprise applications, structured QA processes, and opportunities for long-term technical growth.");
	    data2.put("Country", "India");
	    data2.put("City / State", "Bengaluru, Karnataka");
	    data2.put("Remote", "No");
	    data2.put("Salary From 1", "800000");
	    data2.put("Salary To 1", "1000000");
	    data2.put("Unit 1", "Yearly");
	    data2.put("Currency 1", "INR(₹)");
	    data2.put("Salary From 2", "1000001");
	    data2.put("Salary To 2", "1300000");
	    data2.put("Unit 2", "Yearly");
	    data2.put("Currency 2", "INR(₹)");
	    data2.put("Salary From 3", "1300001");
	    data2.put("Salary To 3", "1600000");
	    data2.put("Unit 3", "Yearly");
	    data2.put("Currency 3", "INR(₹)");
	    data2.put("Save As Job Posting Template", "Yes");

	    TreeMap<String, String> data3 = new TreeMap<String, String>();
	    data3.put("Select Template", "Custom Template");
	    data3.put("Job Posting Name", "Manual QA Executive Hiring 03");
	    data3.put("Expiry Date", "05-05-2026");
	    data3.put("Job Urgency", "Low");
	    data3.put("Job Title", "Manual Test Engineer");
	    data3.put("Department / Division", "Quality Assurance");
	    data3.put("Employment Type", "Full Time");
	    data3.put("Category", "Testing");
	    data3.put("Required Education", "BCA");
	    data3.put("Required Experience", "1-3 Years");
	    data3.put("Expected Hiring Date", "20-05-2026");
	    data3.put("Number of Positions", "4");
	    data3.put("When Positions Fulfilled", "Close Job Posting");
	    data3.put("Job Description", "We are seeking a Manual Test Engineer to validate application workflows, identify defects, prepare detailed test scenarios, execute regression cycles, and collaborate with product and development teams to ensure feature stability. The role includes testing new functionality, validating change impact, reporting defects with clarity, and supporting release sign-off activities. Candidates should be detail-oriented, methodical, and capable of performing structured validation across multiple modules.");
	    data3.put("Job Requirements", "Experience in manual testing, test case design, test execution, bug reporting, requirement understanding, regression testing, smoke testing, sanity testing, and UI validation. Candidate should be comfortable with spreadsheets, defect tracking tools, documenting observations, and communicating with developers and analysts regarding defects and edge cases.");
	    data3.put("Benefits", "Paid leave, insurance support, structured onboarding, collaborative QA environment, learning exposure, internal mentoring, and career progression opportunities in product quality and testing specialization.");
	    data3.put("Country", "India");
	    data3.put("City / State", "Hyderabad, Telangana");
	    data3.put("Remote", "No");
	    data3.put("Salary From 1", "300000");
	    data3.put("Salary To 1", "450000");
	    data3.put("Unit 1", "Yearly");
	    data3.put("Currency 1", "INR(₹)");
	    data3.put("Salary From 2", "450001");
	    data3.put("Salary To 2", "550000");
	    data3.put("Unit 2", "Yearly");
	    data3.put("Currency 2", "INR(₹)");
	    data3.put("Salary From 3", "550001");
	    data3.put("Salary To 3", "650000");
	    data3.put("Unit 3", "Yearly");
	    data3.put("Currency 3", "INR(₹)");
	    data3.put("Save As Job Posting Template", "No");

	    TreeMap<String, String> data4 = new TreeMap<String, String>();
	    data4.put("Select Template", "Custom Template");
	    data4.put("Job Posting Name", "API Test Engineer Hiring 04");
	    data4.put("Expiry Date", "07-05-2026");
	    data4.put("Job Urgency", "High");
	    data4.put("Job Title", "API Test Engineer");
	    data4.put("Department / Division", "Quality Engineering");
	    data4.put("Employment Type", "Full Time");
	    data4.put("Category", "IT / Software");
	    data4.put("Required Education", "B.Tech");
	    data4.put("Required Experience", "2-4 Years");
	    data4.put("Expected Hiring Date", "25-05-2026");
	    data4.put("Number of Positions", "2");
	    data4.put("When Positions Fulfilled", "Close Job Posting");
	    data4.put("Job Description", "We are hiring an API Test Engineer to validate backend services, perform request-response verification, check data integrity, and build stable API-level validation coverage for business-critical modules. The role includes validating endpoints, analyzing payloads, ensuring schema consistency, handling integration-level issues, and contributing to improved backend quality across releases. Candidates should be comfortable with functional testing as well as structured debugging of API failures.");
	    data4.put("Job Requirements", "Experience with API testing concepts, request methods, status code validation, JSON payload verification, authentication handling, basic database validation, Postman or automation exposure, and understanding of service integration flows. Familiarity with Java-based automation, Rest Assured, and backend validation practices is preferred.");
	    data4.put("Benefits", "Competitive pay, insurance benefits, technical learning opportunities, involvement in core backend quality processes, supportive team culture, and scope for long-term specialization in service testing and automation.");
	    data4.put("Country", "India");
	    data4.put("City / State", "Pune, Maharashtra");
	    data4.put("Remote", "Yes");
	    data4.put("Salary From 1", "450000");
	    data4.put("Salary To 1", "650000");
	    data4.put("Unit 1", "Yearly");
	    data4.put("Currency 1", "INR(₹)");
	    data4.put("Salary From 2", "650001");
	    data4.put("Salary To 2", "850000");
	    data4.put("Unit 2", "Yearly");
	    data4.put("Currency 2", "INR(₹)");
	    data4.put("Salary From 3", "850001");
	    data4.put("Salary To 3", "1050000");
	    data4.put("Unit 3", "Yearly");
	    data4.put("Currency 3", "INR(₹)");
	    data4.put("Save As Job Posting Template", "No");

	    TreeMap<String, String> data5 = new TreeMap<String, String>();
	    data5.put("Select Template", "Custom Template");
	    data5.put("Job Posting Name", "SDET Hiring 05");
	    data5.put("Expiry Date", "08-05-2026");
	    data5.put("Job Urgency", "High");
	    data5.put("Job Title", "Software Development Engineer in Test");
	    data5.put("Department / Division", "Engineering");
	    data5.put("Employment Type", "Full Time");
	    data5.put("Category", "Software Engineering");
	    data5.put("Required Education", "B.Tech");
	    data5.put("Required Experience", "4-6 Years");
	    data5.put("Expected Hiring Date", "10-06-2026");
	    data5.put("Number of Positions", "2");
	    data5.put("When Positions Fulfilled", "Keep Open");
	    data5.put("Job Description", "We are seeking a Software Development Engineer in Test who can contribute to both test automation and framework-level engineering improvements. The candidate will help build scalable automation solutions, stabilize regression coverage, improve pipeline health, and collaborate with engineering teams to establish better quality gates across products. This role requires strong technical depth, ownership mindset, and the ability to work on both test design and automation architecture refinement.");
	    data5.put("Job Requirements", "Strong experience in Java, Selenium, TestNG, automation framework design, CI/CD integration, debugging, synchronization handling, code review understanding, API validation, and quality process improvements. Candidate should be comfortable working with reusable components, design patterns, and long-term automation maintainability goals.");
	    data5.put("Benefits", "Attractive salary, insurance coverage, performance incentives, exposure to architecture-level quality engineering, technical growth opportunities, flexible team collaboration model, and access to learning resources.");
	    data5.put("Country", "India");
	    data5.put("City / State", "Chennai, Tamil Nadu");
	    data5.put("Remote", "Yes");
	    data5.put("Salary From 1", "900000");
	    data5.put("Salary To 1", "1200000");
	    data5.put("Unit 1", "Yearly");
	    data5.put("Currency 1", "INR(₹)");
	    data5.put("Salary From 2", "1200001");
	    data5.put("Salary To 2", "1500000");
	    data5.put("Unit 2", "Yearly");
	    data5.put("Currency 2", "INR(₹)");
	    data5.put("Salary From 3", "1500001");
	    data5.put("Salary To 3", "1800000");
	    data5.put("Unit 3", "Yearly");
	    data5.put("Currency 3", "INR(₹)");
	    data5.put("Save As Job Posting Template", "Yes");

	    TreeMap<String, String> data6 = new TreeMap<String, String>();
	    data6.put("Select Template", "Custom Template");
	    data6.put("Job Posting Name", "Junior QA Analyst Hiring 06");
	    data6.put("Expiry Date", "09-05-2026");
	    data6.put("Job Urgency", "Medium");
	    data6.put("Job Title", "Junior QA Analyst");
	    data6.put("Department / Division", "Quality Assurance");
	    data6.put("Employment Type", "Full Time");
	    data6.put("Category", "Entry Level");
	    data6.put("Required Education", "B.Com");
	    data6.put("Required Experience", "0-1 Years");
	    data6.put("Expected Hiring Date", "18-05-2026");
	    data6.put("Number of Positions", "5");
	    data6.put("When Positions Fulfilled", "Close Job Posting");
	    data6.put("Job Description", "We are hiring Junior QA Analysts to support application validation, execute test cases, document results, and assist senior team members in identifying product defects. The role is well suited for candidates who want to build a career in software testing and quality assurance. Responsibilities include learning product functionality, testing across modules, maintaining clarity in observations, and contributing to smooth release validation activities.");
	    data6.put("Job Requirements", "Basic understanding of software testing concepts, good communication skills, willingness to learn, ability to write simple test scenarios, and comfort with executing application workflows carefully. Candidates with internship or project exposure to QA, defect reporting, or UI validation will be preferred.");
	    data6.put("Benefits", "Structured training, supportive onboarding, health coverage, team mentoring, practical project exposure, and gradual career progression within QA and automation streams.");
	    data6.put("Country", "India");
	    data6.put("City / State", "Noida, Uttar Pradesh");
	    data6.put("Remote", "No");
	    data6.put("Salary From 1", "240000");
	    data6.put("Salary To 1", "320000");
	    data6.put("Unit 1", "Yearly");
	    data6.put("Currency 1", "INR(₹)");
	    data6.put("Salary From 2", "320001");
	    data6.put("Salary To 2", "380000");
	    data6.put("Unit 2", "Yearly");
	    data6.put("Currency 2", "INR(₹)");
	    data6.put("Salary From 3", "380001");
	    data6.put("Salary To 3", "450000");
	    data6.put("Unit 3", "Yearly");
	    data6.put("Currency 3", "INR(₹)");
	    data6.put("Save As Job Posting Template", "No");

	    TreeMap<String, String> data7 = new TreeMap<String, String>();
	    data7.put("Select Template", "Custom Template");
	    data7.put("Job Posting Name", "Performance Test Engineer Hiring 07");
	    data7.put("Expiry Date", "11-05-2026");
	    data7.put("Job Urgency", "High");
	    data7.put("Job Title", "Performance Test Engineer");
	    data7.put("Department / Division", "Quality Engineering");
	    data7.put("Employment Type", "Full Time");
	    data7.put("Category", "Engineering");
	    data7.put("Required Education", "B.Tech");
	    data7.put("Required Experience", "3-5 Years");
	    data7.put("Expected Hiring Date", "05-06-2026");
	    data7.put("Number of Positions", "2");
	    data7.put("When Positions Fulfilled", "Close Job Posting");
	    data7.put("Job Description", "We are looking for a Performance Test Engineer to evaluate application responsiveness, stability, and scalability under expected and peak usage conditions. The candidate will prepare workload scenarios, execute performance tests, analyze bottlenecks, and collaborate with engineering teams to identify system limitations and recommend improvements. This role is critical for ensuring stable platform behavior in high-demand conditions.");
	    data7.put("Job Requirements", "Good understanding of performance testing concepts such as load, stress, spike, endurance, and response time analysis. Experience with performance tools, monitoring basics, log interpretation, and performance result analysis is preferred. Ability to document bottlenecks clearly and work closely with developers on performance improvements is important.");
	    data7.put("Benefits", "Insurance coverage, performance-linked growth, technical exposure to system-level quality validation, collaborative environment, learning support, and long-term engineering opportunities.");
	    data7.put("Country", "India");
	    data7.put("City / State", "Mumbai, Maharashtra");
	    data7.put("Remote", "Yes");
	    data7.put("Salary From 1", "650000");
	    data7.put("Salary To 1", "850000");
	    data7.put("Unit 1", "Yearly");
	    data7.put("Currency 1", "INR(₹)");
	    data7.put("Salary From 2", "850001");
	    data7.put("Salary To 2", "1050000");
	    data7.put("Unit 2", "Yearly");
	    data7.put("Currency 2", "INR(₹)");
	    data7.put("Salary From 3", "1050001");
	    data7.put("Salary To 3", "1250000");
	    data7.put("Unit 3", "Yearly");
	    data7.put("Currency 3", "INR(₹)");
	    data7.put("Save As Job Posting Template", "No");

	    TreeMap<String, String> data8 = new TreeMap<String, String>();
	    data8.put("Select Template", "Custom Template");
	    data8.put("Job Posting Name", "Mobile QA Engineer Hiring 08");
	    data8.put("Expiry Date", "12-05-2026");
	    data8.put("Job Urgency", "Medium");
	    data8.put("Job Title", "Mobile Test Engineer");
	    data8.put("Department / Division", "Quality Assurance");
	    data8.put("Employment Type", "Full Time");
	    data8.put("Category", "Mobile Testing");
	    data8.put("Required Education", "B.Tech");
	    data8.put("Required Experience", "2-4 Years");
	    data8.put("Expected Hiring Date", "12-06-2026");
	    data8.put("Number of Positions", "2");
	    data8.put("When Positions Fulfilled", "Keep Open");
	    data8.put("Job Description", "We are hiring a Mobile Test Engineer to validate Android and iOS application functionality, verify usability across devices, test release builds, and support stable product delivery in mobile environments. The role includes exploratory testing, functional testing, defect validation, and ensuring consistency across devices, OS versions, and responsive behaviors. Candidates should be comfortable identifying both functional and UI-level issues in mobile platforms.");
	    data8.put("Job Requirements", "Experience in mobile application testing, test case execution, issue reporting, build validation, cross-device verification, and regression testing. Exposure to mobile automation tools, log capture, API validation, and responsive behavior analysis will be an advantage.");
	    data8.put("Benefits", "Medical benefits, paid leave, device testing exposure, product-based QA learning, supportive work culture, and opportunities to grow into mobile automation and advanced testing responsibilities.");
	    data8.put("Country", "India");
	    data8.put("City / State", "Ahmedabad, Gujarat");
	    data8.put("Remote", "No");
	    data8.put("Salary From 1", "400000");
	    data8.put("Salary To 1", "550000");
	    data8.put("Unit 1", "Yearly");
	    data8.put("Currency 1", "INR(₹)");
	    data8.put("Salary From 2", "550001");
	    data8.put("Salary To 2", "700000");
	    data8.put("Unit 2", "Yearly");
	    data8.put("Currency 2", "INR(₹)");
	    data8.put("Salary From 3", "700001");
	    data8.put("Salary To 3", "850000");
	    data8.put("Unit 3", "Yearly");
	    data8.put("Currency 3", "INR(₹)");
	    data8.put("Save As Job Posting Template", "Yes");

	    TreeMap<String, String> data9 = new TreeMap<String, String>();
	    data9.put("Select Template", "Custom Template");
	    data9.put("Job Posting Name", "Test Lead Hiring 09");
	    data9.put("Expiry Date", "13-05-2026");
	    data9.put("Job Urgency", "High");
	    data9.put("Job Title", "QA Test Lead");
	    data9.put("Department / Division", "Quality Engineering");
	    data9.put("Employment Type", "Full Time");
	    data9.put("Category", "Leadership");
	    data9.put("Required Education", "MCA");
	    data9.put("Required Experience", "6-8 Years");
	    data9.put("Expected Hiring Date", "20-06-2026");
	    data9.put("Number of Positions", "1");
	    data9.put("When Positions Fulfilled", "Close Job Posting");
	    data9.put("Job Description", "We are looking for a QA Test Lead to manage testing activities across modules, coordinate with stakeholders, review coverage quality, guide team members, and help deliver stable releases. The candidate will balance execution oversight with reporting, defect triage participation, release planning input, and quality decision support. This is a leadership role that requires both hands-on understanding and people coordination capability.");
	    data9.put("Job Requirements", "Strong experience in QA leadership, test planning, requirement analysis, defect review, regression strategy, release validation, and communication with cross-functional teams. Exposure to both manual and automation testing, reporting practices, and project coordination in agile environments is required.");
	    data9.put("Benefits", "Leadership role benefits, insurance coverage, performance incentives, strategic involvement in product quality, collaborative work culture, and long-term career progression into QA management or senior quality engineering roles.");
	    data9.put("Country", "India");
	    data9.put("City / State", "Delhi, Delhi");
	    data9.put("Remote", "Yes");
	    data9.put("Salary From 1", "1100000");
	    data9.put("Salary To 1", "1400000");
	    data9.put("Unit 1", "Yearly");
	    data9.put("Currency 1", "INR(₹)");
	    data9.put("Salary From 2", "1400001");
	    data9.put("Salary To 2", "1700000");
	    data9.put("Unit 2", "Yearly");
	    data9.put("Currency 2", "INR(₹)");
	    data9.put("Salary From 3", "1700001");
	    data9.put("Salary To 3", "2000000");
	    data9.put("Unit 3", "Yearly");
	    data9.put("Currency 3", "INR(₹)");
	    data9.put("Save As Job Posting Template", "No");

	    TreeMap<String, String> data10 = new TreeMap<String, String>();
	    data10.put("Select Template", "Custom Template");
	    data10.put("Job Posting Name", "QA Intern Hiring 10");
	    data10.put("Expiry Date", "14-05-2026");
	    data10.put("Job Urgency", "Low");
	    data10.put("Job Title", "QA Intern");
	    data10.put("Department / Division", "Quality Assurance");
	    data10.put("Employment Type", "Internship");
	    data10.put("Category", "Internship");
	    data10.put("Required Education", "BCA");
	    data10.put("Required Experience", "0 Years");
	    data10.put("Expected Hiring Date", "01-06-2026");
	    data10.put("Number of Positions", "3");
	    data10.put("When Positions Fulfilled", "Close Job Posting");
	    data10.put("Job Description", "We are inviting applications for QA Intern roles for candidates interested in software testing and product quality. Interns will support basic test execution, bug reporting, learning documentation, scenario preparation, and supervised validation activities under the guidance of senior QA members. This role provides exposure to real project workflows, release testing, and structured QA practices in a professional environment.");
	    data10.put("Job Requirements", "Basic computer knowledge, good communication skills, interest in software quality, attention to detail, and willingness to learn testing processes. Candidates with academic or project exposure to software applications, documentation, or validation work will be an advantage.");
	    data10.put("Benefits", "Internship certificate, practical project exposure, structured learning support, mentorship from experienced QA members, and possibility of long-term growth based on performance.");
	    data10.put("Country", "India");
	    data10.put("City / State", "Jaipur, Rajasthan");
	    data10.put("Remote", "No");
	    data10.put("Salary From 1", "120000");
	    data10.put("Salary To 1", "180000");
	    data10.put("Unit 1", "Yearly");
	    data10.put("Currency 1", "INR(₹)");
	    data10.put("Salary From 2", "180001");
	    data10.put("Salary To 2", "220000");
	    data10.put("Unit 2", "Yearly");
	    data10.put("Currency 2", "INR(₹)");
	    data10.put("Salary From 3", "220001");
	    data10.put("Salary To 3", "260000");
	    data10.put("Unit 3", "Yearly");
	    data10.put("Currency 3", "INR(₹)");
	    data10.put("Save As Job Posting Template", "No");

	    TreeMap<String, String> data11 = new TreeMap<String, String>();
	    data11.put("Select Template", "Custom Template");
	    data11.put("Job Posting Name", "Regression Test Specialist Hiring 11");
	    data11.put("Expiry Date", "15-05-2026");
	    data11.put("Job Urgency", "Medium");
	    data11.put("Job Title", "Regression Test Specialist");
	    data11.put("Department / Division", "Quality Engineering");
	    data11.put("Employment Type", "Full Time");
	    data11.put("Category", "Testing");
	    data11.put("Required Education", "B.Tech");
	    data11.put("Required Experience", "3-5 Years");
	    data11.put("Expected Hiring Date", "18-06-2026");
	    data11.put("Number of Positions", "2");
	    data11.put("When Positions Fulfilled", "Keep Open");
	    data11.put("Job Description", "We are looking for a Regression Test Specialist to manage release cycle validation, maintain high-risk coverage areas, ensure repeatable regression execution quality, and identify defects introduced by ongoing changes. The role requires disciplined execution, strong defect reporting, requirement traceability awareness, and the ability to work efficiently in release-driven environments.");
	    data11.put("Job Requirements", "Experience in regression planning, change impact validation, smoke and sanity verification, defect logging, scenario prioritization, and coordination with developers and QA members during release validation. Candidates should be methodical, quality-focused, and comfortable handling repeatable test coverage processes.");
	    data11.put("Benefits", "Health benefits, release-cycle product exposure, stable team environment, career growth options, structured QA practices, and opportunities to contribute significantly to release quality.");
	    data11.put("Country", "India");
	    data11.put("City / State", "Lucknow, Uttar Pradesh");
	    data11.put("Remote", "Yes");
	    data11.put("Salary From 1", "500000");
	    data11.put("Salary To 1", "650000");
	    data11.put("Unit 1", "Yearly");
	    data11.put("Currency 1", "INR(₹)");
	    data11.put("Salary From 2", "650001");
	    data11.put("Salary To 2", "780000");
	    data11.put("Unit 2", "Yearly");
	    data11.put("Currency 2", "INR(₹)");
	    data11.put("Salary From 3", "780001");
	    data11.put("Salary To 3", "920000");
	    data11.put("Unit 3", "Yearly");
	    data11.put("Currency 3", "INR(₹)");
	    data11.put("Save As Job Posting Template", "No");

	    TreeMap<String, String> data12 = new TreeMap<String, String>();
	    data12.put("Select Template", "Custom Template");
	    data12.put("Job Posting Name", "UAT Coordinator Hiring 12");
	    data12.put("Expiry Date", "16-05-2026");
	    data12.put("Job Urgency", "Medium");
	    data12.put("Job Title", "UAT Coordinator");
	    data12.put("Department / Division", "Business QA");
	    data12.put("Employment Type", "Full Time");
	    data12.put("Category", "Business Testing");
	    data12.put("Required Education", "MBA");
	    data12.put("Required Experience", "3-5 Years");
	    data12.put("Expected Hiring Date", "25-06-2026");
	    data12.put("Number of Positions", "1");
	    data12.put("When Positions Fulfilled", "Close Job Posting");
	    data12.put("Job Description", "We are hiring a UAT Coordinator to manage business validation activities, align test readiness with stakeholders, support issue clarification, and ensure that final user acceptance testing runs smoothly before release approval. This role includes coordination, communication, issue tracking, and helping business users validate whether delivered functionality meets expected process needs.");
	    data12.put("Job Requirements", "Experience in user acceptance testing coordination, communication with business stakeholders, issue documentation, testing follow-up, functional understanding, and release readiness support. Candidate should be comfortable working between business users and technical teams.");
	    data12.put("Benefits", "Supportive work culture, insurance benefits, role visibility across stakeholders, structured testing environment, and growth opportunities in business QA, product coordination, and release management.");
	    data12.put("Country", "India");
	    data12.put("City / State", "Kochi, Kerala");
	    data12.put("Remote", "No");
	    data12.put("Salary From 1", "550000");
	    data12.put("Salary To 1", "700000");
	    data12.put("Unit 1", "Yearly");
	    data12.put("Currency 1", "INR(₹)");
	    data12.put("Salary From 2", "700001");
	    data12.put("Salary To 2", "850000");
	    data12.put("Unit 2", "Yearly");
	    data12.put("Currency 2", "INR(₹)");
	    data12.put("Salary From 3", "850001");
	    data12.put("Salary To 3", "1000000");
	    data12.put("Unit 3", "Yearly");
	    data12.put("Currency 3", "INR(₹)");
	    data12.put("Save As Job Posting Template", "Yes");

	    TreeMap<String, String> data13 = new TreeMap<String, String>();
	    data13.put("Select Template", "Custom Template");
	    data13.put("Job Posting Name", "Database QA Hiring 13");
	    data13.put("Expiry Date", "17-05-2026");
	    data13.put("Job Urgency", "High");
	    data13.put("Job Title", "Database Test Engineer");
	    data13.put("Department / Division", "Quality Engineering");
	    data13.put("Employment Type", "Full Time");
	    data13.put("Category", "Database Testing");
	    data13.put("Required Education", "B.Tech");
	    data13.put("Required Experience", "3-5 Years");
	    data13.put("Expected Hiring Date", "28-06-2026");
	    data13.put("Number of Positions", "2");
	    data13.put("When Positions Fulfilled", "Close Job Posting");
	    data13.put("Job Description", "We are looking for a Database Test Engineer to validate stored data accuracy, query results, integration-level data flow, and consistency of business logic reflected in backend systems. The role involves performing data checks, comparing expected and actual records, supporting defect isolation, and ensuring backend data integrity for business-critical modules.");
	    data13.put("Job Requirements", "Good knowledge of SQL, joins, validation queries, data comparison, database verification concepts, and issue reporting. Exposure to backend validation in application testing, API-data consistency checking, and structured defect analysis is preferred.");
	    data13.put("Benefits", "Insurance coverage, technical growth opportunities, exposure to backend systems, stable work culture, and role development into advanced data validation and quality engineering practices.");
	    data13.put("Country", "India");
	    data13.put("City / State", "Chandigarh, Chandigarh");
	    data13.put("Remote", "Yes");
	    data13.put("Salary From 1", "600000");
	    data13.put("Salary To 1", "800000");
	    data13.put("Unit 1", "Yearly");
	    data13.put("Currency 1", "INR(₹)");
	    data13.put("Salary From 2", "800001");
	    data13.put("Salary To 2", "950000");
	    data13.put("Unit 2", "Yearly");
	    data13.put("Currency 2", "INR(₹)");
	    data13.put("Salary From 3", "950001");
	    data13.put("Salary To 3", "1100000");
	    data13.put("Unit 3", "Yearly");
	    data13.put("Currency 3", "INR(₹)");
	    data13.put("Save As Job Posting Template", "No");

	    TreeMap<String, String> data14 = new TreeMap<String, String>();
	    data14.put("Select Template", "Custom Template");
	    data14.put("Job Posting Name", "Automation Architect Hiring 14");
	    data14.put("Expiry Date", "18-05-2026");
	    data14.put("Job Urgency", "High");
	    data14.put("Job Title", "Automation Architect");
	    data14.put("Department / Division", "Engineering");
	    data14.put("Employment Type", "Full Time");
	    data14.put("Category", "Architecture");
	    data14.put("Required Education", "B.Tech");
	    data14.put("Required Experience", "8-10 Years");
	    data14.put("Expected Hiring Date", "05-07-2026");
	    data14.put("Number of Positions", "1");
	    data14.put("When Positions Fulfilled", "Keep Open");
	    data14.put("Job Description", "We are seeking an Automation Architect to define quality engineering direction, establish scalable automation design patterns, guide framework evolution, and support technical decisions around maintainability, reporting, execution reliability, and tool selection. The role includes enabling teams with better automation standards, improving overall engineering quality, and ensuring sustainable automation practices across multiple projects or products.");
	    data14.put("Job Requirements", "Deep expertise in Java automation, Selenium, TestNG, framework architecture, CI/CD integration, design patterns, automation scalability, synchronization strategy, execution reliability, reporting standards, and technical mentorship. Ability to guide engineering teams and review automation direction at a strategic level is essential.");
	    data14.put("Benefits", "Leadership-level compensation, insurance, architecture ownership, exposure to large-scale product engineering, strategic technical influence, and long-term growth in quality engineering leadership.");
	    data14.put("Country", "India");
	    data14.put("City / State", "Gurugram, Haryana");
	    data14.put("Remote", "Yes");
	    data14.put("Salary From 1", "1800000");
	    data14.put("Salary To 1", "2200000");
	    data14.put("Unit 1", "Yearly");
	    data14.put("Currency 1", "INR(₹)");
	    data14.put("Salary From 2", "2200001");
	    data14.put("Salary To 2", "2600000");
	    data14.put("Unit 2", "Yearly");
	    data14.put("Currency 2", "INR(₹)");
	    data14.put("Salary From 3", "2600001");
	    data14.put("Salary To 3", "3000000");
	    data14.put("Unit 3", "Yearly");
	    data14.put("Currency 3", "INR(₹)");
	    data14.put("Save As Job Posting Template", "Yes");

	    TreeMap<String, String> data15 = new TreeMap<String, String>();
	    data15.put("Select Template", "Custom Template");
	    data15.put("Job Posting Name", "QA Executive Hiring 15");
	    data15.put("Expiry Date", "19-05-2026");
	    data15.put("Job Urgency", "Medium");
	    data15.put("Job Title", "QA Executive");
	    data15.put("Department / Division", "Operations QA");
	    data15.put("Employment Type", "Full Time");
	    data15.put("Category", "Quality");
	    data15.put("Required Education", "B.A");
	    data15.put("Required Experience", "1-2 Years");
	    data15.put("Expected Hiring Date", "10-06-2026");
	    data15.put("Number of Positions", "3");
	    data15.put("When Positions Fulfilled", "Close Job Posting");
	    data15.put("Job Description", "We are hiring QA Executives to support day-to-day validation of product changes, report defects accurately, execute standard test scenarios, and contribute to stable quality checks before releases. The role requires discipline, attention to detail, and clear communication while working with functional flows across multiple modules.");
	    data15.put("Job Requirements", "Experience in functional testing, UI validation, bug logging, basic regression verification, and documenting test observations. Familiarity with requirement understanding and structured communication with the team is preferred.");
	    data15.put("Benefits", "Insurance support, stable work environment, learning opportunities, supportive team culture, and career path toward advanced QA and automation roles.");
	    data15.put("Country", "India");
	    data15.put("City / State", "Bhubaneswar, Odisha");
	    data15.put("Remote", "No");
	    data15.put("Salary From 1", "280000");
	    data15.put("Salary To 1", "380000");
	    data15.put("Unit 1", "Yearly");
	    data15.put("Currency 1", "INR(₹)");
	    data15.put("Salary From 2", "380001");
	    data15.put("Salary To 2", "450000");
	    data15.put("Unit 2", "Yearly");
	    data15.put("Currency 2", "INR(₹)");
	    data15.put("Salary From 3", "450001");
	    data15.put("Salary To 3", "520000");
	    data15.put("Unit 3", "Yearly");
	    data15.put("Currency 3", "INR(₹)");
	    data15.put("Save As Job Posting Template", "No");

	    TreeMap<String, String> data16 = new TreeMap<String, String>();
	    data16.put("Select Template", "Custom Template");
	    data16.put("Job Posting Name", "Web QA Engineer Hiring 16");
	    data16.put("Expiry Date", "20-05-2026");
	    data16.put("Job Urgency", "High");
	    data16.put("Job Title", "Web QA Engineer");
	    data16.put("Department / Division", "Product QA");
	    data16.put("Employment Type", "Full Time");
	    data16.put("Category", "Web Testing");
	    data16.put("Required Education", "B.Tech");
	    data16.put("Required Experience", "2-4 Years");
	    data16.put("Expected Hiring Date", "15-06-2026");
	    data16.put("Number of Positions", "2");
	    data16.put("When Positions Fulfilled", "Close Job Posting");
	    data16.put("Job Description", "We are seeking a Web QA Engineer to validate browser-based workflows, identify cross-browser inconsistencies, test responsive behavior, and support stable web product delivery. The role includes executing functional and visual checks, participating in regression cycles, and helping maintain application quality in dynamic UI-based modules.");
	    data16.put("Job Requirements", "Experience with web application testing, browser validation, defect reporting, requirement understanding, regression execution, and handling dynamic UI changes. Exposure to automation or UI inspection tools will be beneficial.");
	    data16.put("Benefits", "Health insurance, collaborative environment, growth opportunities, technical learning exposure, and supportive team processes focused on product quality.");
	    data16.put("Country", "India");
	    data16.put("City / State", "Indore, Madhya Pradesh");
	    data16.put("Remote", "Yes");
	    data16.put("Salary From 1", "420000");
	    data16.put("Salary To 1", "560000");
	    data16.put("Unit 1", "Yearly");
	    data16.put("Currency 1", "INR(₹)");
	    data16.put("Salary From 2", "560001");
	    data16.put("Salary To 2", "700000");
	    data16.put("Unit 2", "Yearly");
	    data16.put("Currency 2", "INR(₹)");
	    data16.put("Salary From 3", "700001");
	    data16.put("Salary To 3", "840000");
	    data16.put("Unit 3", "Yearly");
	    data16.put("Currency 3", "INR(₹)");
	    data16.put("Save As Job Posting Template", "Yes");

	    TreeMap<String, String> data17 = new TreeMap<String, String>();
	    data17.put("Select Template", "Custom Template");
	    data17.put("Job Posting Name", "Release QA Coordinator Hiring 17");
	    data17.put("Expiry Date", "21-05-2026");
	    data17.put("Job Urgency", "Medium");
	    data17.put("Job Title", "Release QA Coordinator");
	    data17.put("Department / Division", "Release Management");
	    data17.put("Employment Type", "Full Time");
	    data17.put("Category", "Coordination");
	    data17.put("Required Education", "MBA");
	    data17.put("Required Experience", "4-6 Years");
	    data17.put("Expected Hiring Date", "30-06-2026");
	    data17.put("Number of Positions", "1");
	    data17.put("When Positions Fulfilled", "Keep Open");
	    data17.put("Job Description", "We are hiring a Release QA Coordinator to manage quality readiness across planned releases, coordinate validation timelines, track open issues, support sign-off decisions, and ensure effective communication between product, QA, and engineering teams. The role is important for keeping release validation organized and visible across stakeholders.");
	    data17.put("Job Requirements", "Experience in release coordination, testing follow-up, status reporting, defect tracking, quality readiness validation, and communication with multiple teams. Candidate should be structured, proactive, and comfortable working with time-sensitive release activities.");
	    data17.put("Benefits", "Insurance, stakeholder visibility, structured role ownership, collaborative environment, and career progression in release coordination and QA management.");
	    data17.put("Country", "India");
	    data17.put("City / State", "Coimbatore, Tamil Nadu");
	    data17.put("Remote", "No");
	    data17.put("Salary From 1", "700000");
	    data17.put("Salary To 1", "850000");
	    data17.put("Unit 1", "Yearly");
	    data17.put("Currency 1", "INR(₹)");
	    data17.put("Salary From 2", "850001");
	    data17.put("Salary To 2", "1000000");
	    data17.put("Unit 2", "Yearly");
	    data17.put("Currency 2", "INR(₹)");
	    data17.put("Salary From 3", "1000001");
	    data17.put("Salary To 3", "1150000");
	    data17.put("Unit 3", "Yearly");
	    data17.put("Currency 3", "INR(₹)");
	    data17.put("Save As Job Posting Template", "No");

	    TreeMap<String, String> data18 = new TreeMap<String, String>();
	    data18.put("Select Template", "Custom Template");
	    data18.put("Job Posting Name", "Security Test Engineer Hiring 18");
	    data18.put("Expiry Date", "22-05-2026");
	    data18.put("Job Urgency", "High");
	    data18.put("Job Title", "Security Test Engineer");
	    data18.put("Department / Division", "Security QA");
	    data18.put("Employment Type", "Full Time");
	    data18.put("Category", "Security Testing");
	    data18.put("Required Education", "B.Tech");
	    data18.put("Required Experience", "3-5 Years");
	    data18.put("Expected Hiring Date", "05-07-2026");
	    data18.put("Number of Positions", "1");
	    data18.put("When Positions Fulfilled", "Close Job Posting");
	    data18.put("Job Description", "We are looking for a Security Test Engineer to support application-level security validation, identify common risk areas, collaborate on secure testing practices, and report vulnerabilities or weakness patterns in a structured manner. The role includes validating input handling, authentication-related behaviors, access control issues, and basic application security concerns.");
	    data18.put("Job Requirements", "Understanding of security testing basics, authentication and authorization concepts, input validation checks, session behavior, access validation, and defect reporting. Exposure to security tools, vulnerability categories, or risk-based validation is an added advantage.");
	    data18.put("Benefits", "Specialized role exposure, insurance benefits, technical learning opportunities, quality and security collaboration, and long-term growth in security-focused testing and risk validation.");
	    data18.put("Country", "India");
	    data18.put("City / State", "Visakhapatnam, Andhra Pradesh");
	    data18.put("Remote", "Yes");
	    data18.put("Salary From 1", "750000");
	    data18.put("Salary To 1", "950000");
	    data18.put("Unit 1", "Yearly");
	    data18.put("Currency 1", "INR(₹)");
	    data18.put("Salary From 2", "950001");
	    data18.put("Salary To 2", "1150000");
	    data18.put("Unit 2", "Yearly");
	    data18.put("Currency 2", "INR(₹)");
	    data18.put("Salary From 3", "1150001");
	    data18.put("Salary To 3", "1350000");
	    data18.put("Unit 3", "Yearly");
	    data18.put("Currency 3", "INR(₹)");
	    data18.put("Save As Job Posting Template", "Yes");

	    TreeMap<String, String> data19 = new TreeMap<String, String>();
	    data19.put("Select Template", "Custom Template");
	    data19.put("Job Posting Name", "Test Automation Analyst Hiring 19");
	    data19.put("Expiry Date", "23-05-2026");
	    data19.put("Job Urgency", "Medium");
	    data19.put("Job Title", "Test Automation Analyst");
	    data19.put("Department / Division", "Automation QA");
	    data19.put("Employment Type", "Full Time");
	    data19.put("Category", "Automation");
	    data19.put("Required Education", "B.Tech");
	    data19.put("Required Experience", "2-4 Years");
	    data19.put("Expected Hiring Date", "10-07-2026");
	    data19.put("Number of Positions", "2");
	    data19.put("When Positions Fulfilled", "Keep Open");
	    data19.put("Job Description", "We are hiring a Test Automation Analyst to build and execute automated test scenarios, analyze automation failures, improve reusable coverage, and support release-quality improvements through stable automation execution. The candidate will work with functional teams to understand flows, convert repeatable cases into automation, and contribute to higher coverage and faster regression cycles.");
	    data19.put("Job Requirements", "Hands-on experience in Java, Selenium, TestNG, automation execution, synchronization handling, locators, framework usage, and defect analysis. Candidate should be comfortable with debugging automation failures and maintaining reusable test flows.");
	    data19.put("Benefits", "Insurance support, automation-focused learning, technical project exposure, structured QA practices, supportive engineering culture, and career progression within automation quality engineering.");
	    data19.put("Country", "India");
	    data19.put("City / State", "Nagpur, Maharashtra");
	    data19.put("Remote", "No");
	    data19.put("Salary From 1", "500000");
	    data19.put("Salary To 1", "650000");
	    data19.put("Unit 1", "Yearly");
	    data19.put("Currency 1", "INR(₹)");
	    data19.put("Salary From 2", "650001");
	    data19.put("Salary To 2", "800000");
	    data19.put("Unit 2", "Yearly");
	    data19.put("Currency 2", "INR(₹)");
	    data19.put("Salary From 3", "800001");
	    data19.put("Salary To 3", "950000");
	    data19.put("Unit 3", "Yearly");
	    data19.put("Currency 3", "INR(₹)");
	    data19.put("Save As Job Posting Template", "No");

	    TreeMap<String, String> data20 = new TreeMap<String, String>();
	    data20.put("Select Template", "Custom Template");
	    data20.put("Job Posting Name", "Functional QA Specialist Hiring 20");
	    data20.put("Expiry Date", "24-05-2026");
	    data20.put("Job Urgency", "Medium");
	    data20.put("Job Title", "Functional QA Specialist");
	    data20.put("Department / Division", "Quality Assurance");
	    data20.put("Employment Type", "Full Time");
	    data20.put("Category", "Functional Testing");
	    data20.put("Required Education", "B.Sc");
	    data20.put("Required Experience", "3-5 Years");
	    data20.put("Expected Hiring Date", "12-07-2026");
	    data20.put("Number of Positions", "2");
	    data20.put("When Positions Fulfilled", "Close Job Posting");
	    data20.put("Job Description", "We are seeking a Functional QA Specialist to validate business workflows thoroughly, identify requirement mismatches, support issue clarification, and ensure stable behavior of applications before release. The role emphasizes deep functional understanding, careful scenario coverage, and consistent collaboration with analysts, product owners, and developers.");
	    data20.put("Job Requirements", "Experience in functional testing, scenario preparation, test execution, issue reporting, requirement analysis, and end-to-end workflow validation. Candidate should be able to understand business logic and validate applications beyond superficial UI checks.");
	    data20.put("Benefits", "Paid leave, health benefits, role stability, business-domain learning, collaborative team support, and strong opportunities to grow further in QA and product validation responsibilities.");
	    data20.put("Country", "India");
	    data20.put("City / State", "Patna, Bihar");
	    data20.put("Remote", "Yes");
	    data20.put("Salary From 1", "450000");
	    data20.put("Salary To 1", "600000");
	    data20.put("Unit 1", "Yearly");
	    data20.put("Currency 1", "INR(₹)");
	    data20.put("Salary From 2", "600001");
	    data20.put("Salary To 2", "750000");
	    data20.put("Unit 2", "Yearly");
	    data20.put("Currency 2", "INR(₹)");
	    data20.put("Salary From 3", "750001");
	    data20.put("Salary To 3", "900000");
	    data20.put("Unit 3", "Yearly");
	    data20.put("Currency 3", "INR(₹)");
	    data20.put("Save As Job Posting Template", "No");

	    TreeMap<String, String> data21 = new TreeMap<String, String>();
	    data21.put("Select Template", "Custom Template");
	    data21.put("Job Posting Name", "Product QA Engineer Hiring 21");
	    data21.put("Expiry Date", "25-05-2026");
	    data21.put("Job Urgency", "High");
	    data21.put("Job Title", "Product QA Engineer");
	    data21.put("Department / Division", "Product Quality");
	    data21.put("Employment Type", "Full Time");
	    data21.put("Category", "Product QA");
	    data21.put("Required Education", "B.Tech");
	    data21.put("Required Experience", "3-5 Years");
	    data21.put("Expected Hiring Date", "15-07-2026");
	    data21.put("Number of Positions", "2");
	    data21.put("When Positions Fulfilled", "Keep Open");
	    data21.put("Job Description", "We are looking for a Product QA Engineer to validate product functionality from a business and user perspective, ensure release readiness, collaborate on change analysis, and contribute to improving product quality standards. The role includes validating critical workflows, reporting defects with clarity, and participating in product-level quality discussions.");
	    data21.put("Job Requirements", "Experience in product validation, functional testing, regression planning, requirement clarification, defect management, and coordination with product, design, and engineering teams. Candidate should have a product mindset and strong attention to end-user experience.");
	    data21.put("Benefits", "Insurance benefits, product-focused work environment, cross-functional exposure, collaborative team culture, growth opportunities, and long-term role stability.");
	    data21.put("Country", "India");
	    data21.put("City / State", "Ranchi, Jharkhand");
	    data21.put("Remote", "No");
	    data21.put("Salary From 1", "600000");
	    data21.put("Salary To 1", "780000");
	    data21.put("Unit 1", "Yearly");
	    data21.put("Currency 1", "INR(₹)");
	    data21.put("Salary From 2", "780001");
	    data21.put("Salary To 2", "920000");
	    data21.put("Unit 2", "Yearly");
	    data21.put("Currency 2", "INR(₹)");
	    data21.put("Salary From 3", "920001");
	    data21.put("Salary To 3", "1080000");
	    data21.put("Unit 3", "Yearly");
	    data21.put("Currency 3", "INR(₹)");
	    data21.put("Save As Job Posting Template", "Yes");

	    TreeMap<String, String> data22 = new TreeMap<String, String>();
	    data22.put("Select Template", "Custom Template");
	    data22.put("Job Posting Name", "UI QA Analyst Hiring 22");
	    data22.put("Expiry Date", "26-05-2026");
	    data22.put("Job Urgency", "Medium");
	    data22.put("Job Title", "UI QA Analyst");
	    data22.put("Department / Division", "Design QA");
	    data22.put("Employment Type", "Full Time");
	    data22.put("Category", "UI Testing");
	    data22.put("Required Education", "B.Des");
	    data22.put("Required Experience", "2-4 Years");
	    data22.put("Expected Hiring Date", "18-07-2026");
	    data22.put("Number of Positions", "1");
	    data22.put("When Positions Fulfilled", "Close Job Posting");
	    data22.put("Job Description", "We are hiring a UI QA Analyst to validate visual consistency, responsive behavior, alignment with design expectations, usability details, and front-end quality across application screens. The role involves careful observation, structured reporting of design and layout issues, and close coordination with developers and design stakeholders.");
	    data22.put("Job Requirements", "Experience in UI testing, responsive validation, cross-browser checks, design comparison, defect reporting, and understanding of front-end usability issues. Candidate should have sharp visual attention and the ability to document discrepancies clearly.");
	    data22.put("Benefits", "Design-focused role exposure, collaborative culture, insurance support, UI quality specialization opportunities, and strong growth potential in experience-focused product validation.");
	    data22.put("Country", "India");
	    data22.put("City / State", "Surat, Gujarat");
	    data22.put("Remote", "Yes");
	    data22.put("Salary From 1", "420000");
	    data22.put("Salary To 1", "550000");
	    data22.put("Unit 1", "Yearly");
	    data22.put("Currency 1", "INR(₹)");
	    data22.put("Salary From 2", "550001");
	    data22.put("Salary To 2", "680000");
	    data22.put("Unit 2", "Yearly");
	    data22.put("Currency 2", "INR(₹)");
	    data22.put("Salary From 3", "680001");
	    data22.put("Salary To 3", "820000");
	    data22.put("Unit 3", "Yearly");
	    data22.put("Currency 3", "INR(₹)");
	    data22.put("Save As Job Posting Template", "No");

	    TreeMap<String, String> data23 = new TreeMap<String, String>();
	    data23.put("Select Template", "Custom Template");
	    data23.put("Job Posting Name", "Accessibility QA Hiring 23");
	    data23.put("Expiry Date", "27-05-2026");
	    data23.put("Job Urgency", "High");
	    data23.put("Job Title", "Accessibility Test Engineer");
	    data23.put("Department / Division", "Inclusive Quality");
	    data23.put("Employment Type", "Full Time");
	    data23.put("Category", "Accessibility Testing");
	    data23.put("Required Education", "B.Tech");
	    data23.put("Required Experience", "3-5 Years");
	    data23.put("Expected Hiring Date", "20-07-2026");
	    data23.put("Number of Positions", "1");
	    data23.put("When Positions Fulfilled", "Keep Open");
	    data23.put("Job Description", "We are seeking an Accessibility Test Engineer to validate whether application features align with accessibility expectations, identify usability barriers, test keyboard navigation and focus behavior, and help improve inclusive product quality. The role requires careful validation of accessible workflows and reporting of issues in a structured and actionable manner.");
	    data23.put("Job Requirements", "Experience in accessibility validation, keyboard navigation checks, focus handling analysis, UI behavior review, and defect documentation. Knowledge of accessibility principles and user-friendly validation practices will be highly valued.");
	    data23.put("Benefits", "Specialized testing role, collaborative quality culture, insurance support, meaningful product impact, and strong long-term growth in inclusive design and accessibility QA practices.");
	    data23.put("Country", "India");
	    data23.put("City / State", "Thiruvananthapuram, Kerala");
	    data23.put("Remote", "Yes");
	    data23.put("Salary From 1", "650000");
	    data23.put("Salary To 1", "820000");
	    data23.put("Unit 1", "Yearly");
	    data23.put("Currency 1", "INR(₹)");
	    data23.put("Salary From 2", "820001");
	    data23.put("Salary To 2", "980000");
	    data23.put("Unit 2", "Yearly");
	    data23.put("Currency 2", "INR(₹)");
	    data23.put("Salary From 3", "980001");
	    data23.put("Salary To 3", "1150000");
	    data23.put("Unit 3", "Yearly");
	    data23.put("Currency 3", "INR(₹)");
	    data23.put("Save As Job Posting Template", "Yes");

	    TreeMap<String, String> data24 = new TreeMap<String, String>();
	    data24.put("Select Template", "Custom Template");
	    data24.put("Job Posting Name", "QA Documentation Analyst Hiring 24");
	    data24.put("Expiry Date", "28-05-2026");
	    data24.put("Job Urgency", "Low");
	    data24.put("Job Title", "QA Documentation Analyst");
	    data24.put("Department / Division", "Quality Process");
	    data24.put("Employment Type", "Full Time");
	    data24.put("Category", "Documentation");
	    data24.put("Required Education", "M.A");
	    data24.put("Required Experience", "2-4 Years");
	    data24.put("Expected Hiring Date", "22-07-2026");
	    data24.put("Number of Positions", "1");
	    data24.put("When Positions Fulfilled", "Close Job Posting");
	    data24.put("Job Description", "We are hiring a QA Documentation Analyst to maintain testing artifacts, update validation records, improve process documentation, support release notes from a QA perspective, and help ensure clarity in quality-related communication. The role is ideal for someone who is organized, detail-oriented, and comfortable managing testing documentation and reporting material.");
	    data24.put("Job Requirements", "Experience in documentation, test case maintenance, reporting support, release artifact preparation, process understanding, and coordination with QA teams. Strong written communication and structured thinking are important for this role.");
	    data24.put("Benefits", "Stable role, insurance support, process-oriented work environment, quality team collaboration, and opportunities to grow into QA process and coordination responsibilities.");
	    data24.put("Country", "India");
	    data24.put("City / State", "Mysuru, Karnataka");
	    data24.put("Remote", "No");
	    data24.put("Salary From 1", "380000");
	    data24.put("Salary To 1", "500000");
	    data24.put("Unit 1", "Yearly");
	    data24.put("Currency 1", "INR(₹)");
	    data24.put("Salary From 2", "500001");
	    data24.put("Salary To 2", "620000");
	    data24.put("Unit 2", "Yearly");
	    data24.put("Currency 2", "INR(₹)");
	    data24.put("Salary From 3", "620001");
	    data24.put("Salary To 3", "740000");
	    data24.put("Unit 3", "Yearly");
	    data24.put("Currency 3", "INR(₹)");
	    data24.put("Save As Job Posting Template", "No");

	    TreeMap<String, String> data25 = new TreeMap<String, String>();
	    data25.put("Select Template", "Custom Template");
	    data25.put("Job Posting Name", "Backend QA Engineer Hiring 25");
	    data25.put("Expiry Date", "29-05-2026");
	    data25.put("Job Urgency", "High");
	    data25.put("Job Title", "Backend QA Engineer");
	    data25.put("Department / Division", "Engineering");
	    data25.put("Employment Type", "Full Time");
	    data25.put("Category", "Backend Testing");
	    data25.put("Required Education", "B.Tech");
	    data25.put("Required Experience", "3-5 Years");
	    data25.put("Expected Hiring Date", "25-07-2026");
	    data25.put("Number of Positions", "2");
	    data25.put("When Positions Fulfilled", "Keep Open");
	    data25.put("Job Description", "We are hiring a Backend QA Engineer to validate server-side logic, service integration behavior, data consistency, and business rule correctness across backend-driven modules. The role includes service-level testing, integration flow validation, data checks, and structured debugging support for backend defects. Candidates should be comfortable validating functionality that is not always visible directly on the UI.");
	    data25.put("Job Requirements", "Strong understanding of backend validation, API testing, data integrity checks, request-response analysis, issue debugging, and defect reporting. Experience in SQL, service testing, and backend-focused quality analysis is preferred.");
	    data25.put("Benefits", "Competitive salary, technical role growth, backend systems exposure, insurance support, collaborative environment, and strong long-term career scope in backend quality engineering.");
	    data25.put("Country", "India");
	    data25.put("City / State", "Vadodara, Gujarat");
	    data25.put("Remote", "Yes");
	    data25.put("Salary From 1", "650000");
	    data25.put("Salary To 1", "850000");
	    data25.put("Unit 1", "Yearly");
	    data25.put("Currency 1", "INR(₹)");
	    data25.put("Salary From 2", "850001");
	    data25.put("Salary To 2", "1050000");
	    data25.put("Unit 2", "Yearly");
	    data25.put("Currency 2", "INR(₹)");
	    data25.put("Salary From 3", "1050001");
	    data25.put("Salary To 3", "1250000");
	    data25.put("Unit 3", "Yearly");
	    data25.put("Currency 3", "INR(₹)");
	    data25.put("Save As Job Posting Template", "Yes");

	    TreeMap<String, String> data26 = new TreeMap<String, String>();
	    data26.put("Select Template", "Custom Template");
	    data26.put("Job Posting Name", "Agile QA Engineer Hiring 26");
	    data26.put("Expiry Date", "30-05-2026");
	    data26.put("Job Urgency", "Medium");
	    data26.put("Job Title", "Agile QA Engineer");
	    data26.put("Department / Division", "Agile Delivery");
	    data26.put("Employment Type", "Full Time");
	    data26.put("Category", "Agile QA");
	    data26.put("Required Education", "B.Tech");
	    data26.put("Required Experience", "2-4 Years");
	    data26.put("Expected Hiring Date", "28-07-2026");
	    data26.put("Number of Positions", "2");
	    data26.put("When Positions Fulfilled", "Close Job Posting");
	    data26.put("Job Description", "We are looking for an Agile QA Engineer to work closely with sprint teams, validate stories during development cycles, support quick feedback, and help maintain release readiness through continuous testing practices. The candidate will participate actively in agile ceremonies, clarify acceptance criteria, and ensure fast yet stable feature validation across iterations.");
	    data26.put("Job Requirements", "Experience in agile QA, sprint testing, user story validation, defect reporting, collaboration with developers and product owners, and basic automation or regression understanding. Candidate should be comfortable in fast-moving delivery environments.");
	    data26.put("Benefits", "Insurance coverage, agile team environment, strong collaboration culture, learning opportunities, and career growth in delivery-focused QA roles.");
	    data26.put("Country", "India");
	    data26.put("City / State", "Nashik, Maharashtra");
	    data26.put("Remote", "No");
	    data26.put("Salary From 1", "500000");
	    data26.put("Salary To 1", "650000");
	    data26.put("Unit 1", "Yearly");
	    data26.put("Currency 1", "INR(₹)");
	    data26.put("Salary From 2", "650001");
	    data26.put("Salary To 2", "800000");
	    data26.put("Unit 2", "Yearly");
	    data26.put("Currency 2", "INR(₹)");
	    data26.put("Salary From 3", "800001");
	    data26.put("Salary To 3", "950000");
	    data26.put("Unit 3", "Yearly");
	    data26.put("Currency 3", "INR(₹)");
	    data26.put("Save As Job Posting Template", "No");

	    TreeMap<String, String> data27 = new TreeMap<String, String>();
	    data27.put("Select Template", "Custom Template");
	    data27.put("Job Posting Name", "Enterprise QA Engineer Hiring 27");
	    data27.put("Expiry Date", "31-05-2026");
	    data27.put("Job Urgency", "High");
	    data27.put("Job Title", "Enterprise QA Engineer");
	    data27.put("Department / Division", "Enterprise Solutions");
	    data27.put("Employment Type", "Full Time");
	    data27.put("Category", "Enterprise Testing");
	    data27.put("Required Education", "B.Tech");
	    data27.put("Required Experience", "4-6 Years");
	    data27.put("Expected Hiring Date", "30-07-2026");
	    data27.put("Number of Positions", "2");
	    data27.put("When Positions Fulfilled", "Keep Open");
	    data27.put("Job Description", "We are hiring an Enterprise QA Engineer to validate complex business workflows, support multi-module integration testing, analyze enterprise application behavior, and contribute to stable release readiness for large-scale business systems. The role includes deep functional validation, issue investigation, and coordination across multiple stakeholders and interconnected modules.");
	    data27.put("Job Requirements", "Experience in enterprise application testing, end-to-end validation, integration flow testing, defect analysis, release coordination support, and structured quality reporting. Ability to understand interconnected business processes is highly important.");
	    data27.put("Benefits", "Insurance, enterprise product exposure, stable work environment, role visibility, technical growth opportunities, and long-term career development in enterprise-quality engineering.");
	    data27.put("Country", "India");
	    data27.put("City / State", "Raipur, Chhattisgarh");
	    data27.put("Remote", "Yes");
	    data27.put("Salary From 1", "800000");
	    data27.put("Salary To 1", "1000000");
	    data27.put("Unit 1", "Yearly");
	    data27.put("Currency 1", "INR(₹)");
	    data27.put("Salary From 2", "1000001");
	    data27.put("Salary To 2", "1200000");
	    data27.put("Unit 2", "Yearly");
	    data27.put("Currency 2", "INR(₹)");
	    data27.put("Salary From 3", "1200001");
	    data27.put("Salary To 3", "1400000");
	    data27.put("Unit 3", "Yearly");
	    data27.put("Currency 3", "INR(₹)");
	    data27.put("Save As Job Posting Template", "Yes");

	    TreeMap<String, String> data28 = new TreeMap<String, String>();
	    data28.put("Select Template", "Custom Template");
	    data28.put("Job Posting Name", "Lead Automation Engineer Hiring 28");
	    data28.put("Expiry Date", "02-06-2026");
	    data28.put("Job Urgency", "High");
	    data28.put("Job Title", "Lead Automation Engineer");
	    data28.put("Department / Division", "Automation Engineering");
	    data28.put("Employment Type", "Full Time");
	    data28.put("Category", "Leadership");
	    data28.put("Required Education", "B.Tech");
	    data28.put("Required Experience", "7-9 Years");
	    data28.put("Expected Hiring Date", "05-08-2026");
	    data28.put("Number of Positions", "1");
	    data28.put("When Positions Fulfilled", "Close Job Posting");
	    data28.put("Job Description", "We are seeking a Lead Automation Engineer to drive automation initiatives, mentor engineers, improve framework stability, guide coverage expansion, and ensure reliable execution of automation suites across products. The role requires technical leadership, hands-on problem solving, ownership of automation quality, and close collaboration with cross-functional teams to improve delivery speed without compromising quality.");
	    data28.put("Job Requirements", "Strong expertise in Java, Selenium, TestNG, framework design, reporting, execution stability, reusable utilities, CI/CD integration, debugging, and technical mentoring. Candidate should be capable of owning automation direction and helping the team scale coverage effectively.");
	    data28.put("Benefits", "Leadership compensation, insurance coverage, technical ownership, mentoring opportunities, collaborative engineering environment, career progression, and exposure to strategic quality engineering initiatives.");
	    data28.put("Country", "India");
	    data28.put("City / State", "Kolkata, West Bengal");
	    data28.put("Remote", "Yes");
	    data28.put("Salary From 1", "1400000");
	    data28.put("Salary To 1", "1700000");
	    data28.put("Unit 1", "Yearly");
	    data28.put("Currency 1", "INR(₹)");
	    data28.put("Salary From 2", "1700001");
	    data28.put("Salary To 2", "2000000");
	    data28.put("Unit 2", "Yearly");
	    data28.put("Currency 2", "INR(₹)");
	    data28.put("Salary From 3", "2000001");
	    data28.put("Salary To 3", "2300000");
	    data28.put("Unit 3", "Yearly");
	    data28.put("Currency 3", "INR(₹)");
	    data28.put("Save As Job Posting Template", "Yes");

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
	            { data20 },
	            { data21 },
	            { data22 },
	            { data23 },
	            { data24 },
	            { data25 },
	            { data26 },
	            { data27 },
	            { data28 } */
	    };
	}
	
	
}
