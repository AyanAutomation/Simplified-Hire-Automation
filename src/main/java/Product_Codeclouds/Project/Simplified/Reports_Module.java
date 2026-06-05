package Product_Codeclouds.Project.Simplified;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Calender_Module_Locaters;
import Locaters.Candidate_Module_Locaters;
import Locaters.Report_Module_Locaters;
import Repeatative_codes.Repeat;

public class Reports_Module extends Job_Module{
	
	
	
	public WebElement reports_module_Accessor() throws IOException, InterruptedException {

		Report_Module_Locaters p = new Report_Module_Locaters(d);

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step:</b> Navigate to Reports module from side menu.");
		System.out.println();
		System.out.println("Step: Navigate to Reports module from side menu.");
		System.out.println();

		Menu_option_selector("Reports");

		WebElement filter = p.Filter_button();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Reports module opened successfully and Filter button was identified.");
		System.out.println("🟨 Actual: Reports module opened successfully and Filter button was identified.");
		System.out.println();

		return filter;
	}
	
	
	public TreeMap<String,String> Overview_Tab_Data_collector(String Filter_Value,int step) throws IOException, InterruptedException {
		
		
		
		Report_Module_Locaters p = new Report_Module_Locaters(d);
		
		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🔹 Scenario Title:</b> Validate Reports overview Open Jobs count against Jobs module Active Jobs count");
		System.out.println();
		System.out.println("🔹 Scenario Title: Validate Reports overview Open Jobs count against Jobs module Active Jobs count");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📘 Description:</b> Open the Reports module, apply the required report filter, clear previously stored overview data, capture all overview section labels and values into the overview data map, fetch Active Jobs count from the Jobs module, and softly compare the Jobs module count with the Reports overview Open Jobs count.");
		System.out.println("📘 Description: Open the Reports module, apply the required report filter, clear previously stored overview data, capture all overview section labels and values into the overview data map, fetch Active Jobs count from the Jobs module, and softly compare the Jobs module count with the Reports overview Open Jobs count.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📥 Input:</b> Report Filter = This Month | Reports Overview Key = Open Jobs | Job Status Filter = Active | Pagination Value in Jobs Module = 50");
		System.out.println("📥 Input: Report Filter = This Month | Reports Overview Key = Open Jobs | Job Status Filter = Active | Pagination Value in Jobs Module = 50");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>✅ Expected:</b> Reports overview data should be captured freshly, Open Jobs count should be available in the overview data map, Active Jobs count should be fetched from the Jobs module, and both counts should match.");
		System.out.println("✅ Expected: Reports overview data should be captured freshly, Open Jobs count should be available in the overview data map, Active Jobs count should be fetched from the Jobs module, and both counts should match.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Clear previously stored overview card data.");
		System.out.println("Step " + (step - 1) + ": Clear previously stored overview card data.");
		System.out.println();

		Overview_Cards_Data.clear();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Previously stored overview card data cleared successfully.");
		System.out.println("🟨 Actual: Previously stored overview card data cleared successfully.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Apply report filter option = This Month.");
		System.out.println("Step " + (step - 1) + ": Apply report filter option = This Month.");
		System.out.println();

		filter_option_selector(Filter_Value);

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Report filter applied successfully = This Month.");
		System.out.println("🟨 Actual: Report filter applied successfully = This Month.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Fetch overview section labels and values from Reports module.");
		System.out.println("Step " + (step - 1) + ": Fetch overview section labels and values from Reports module.");
		System.out.println();

		List<WebElement> overview_section_Labels = p.Labels();
		List<WebElement> overview_section_values = p.Values();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Overview labels fetched = " + overview_section_Labels.size()
						+ " | Overview values fetched = " + overview_section_values.size());
		System.out.println("🟨 Actual: Overview labels fetched = " + overview_section_Labels.size()
				+ " | Overview values fetched = " + overview_section_values.size());
		System.out.println();

		if (overview_section_Labels.size() != overview_section_values.size()) {

			Report_Listen.log_print_in_report().log(Status.FAIL,
					"<b>❌ Actual:</b> Overview labels count and values count do not match. Labels = "
							+ overview_section_Labels.size() + " | Values = " + overview_section_values.size());
			System.out.println("❌ Actual: Overview labels count and values count do not match. Labels = "
					+ overview_section_Labels.size() + " | Values = " + overview_section_values.size());
			System.out.println();

			throw new IllegalStateException("Overview labels count and values count do not match. Labels = "
					+ overview_section_Labels.size() + ", Values = " + overview_section_values.size());
		}

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Store overview label-value pairs into the overview data map.");
		System.out.println("Step " + (step - 1) + ": Store overview label-value pairs into the overview data map.");
		System.out.println();

		IntStream.range(0, overview_section_Labels.size()).forEach(i -> {

			String label = overview_section_Labels.get(i).getText().trim();
			String value = overview_section_values.get(i).getText().trim();

			Overview_Cards_Data.put(label, value);

			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>🟨 Actual:</b> Overview card stored successfully = " + label + " -> " + value);
			System.out.println("🟨 Actual: Overview card stored successfully = " + label + " -> " + value);
		});

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Overview data map populated successfully. Total entries stored = "
						+ Overview_Cards_Data.size());
		System.out.println("🟨 Actual: Overview data map populated successfully. Total entries stored = "
				+ Overview_Cards_Data.size());
		System.out.println();
		
		return Overview_Cards_Data;
		
	}
	
	
	
	@Test
	public void Open_Job_Count_of_Report_Check() throws IOException, InterruptedException, AWTException {

		Report_Module_Locaters p = new Report_Module_Locaters(d);
		SoftAssert softAssert = new SoftAssert();

		int step = 1;


        TreeMap<String,String> Report_job_Data=Overview_Tab_Data_collector("This Month", step);
		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Expand side menu before switching from Reports module to Jobs module.");
		System.out.println("Step " + (step - 1) + ": Expand side menu before switching from Reports module to Jobs module.");
		System.out.println();

		side_menu_expander();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Side menu expanded successfully.");
		System.out.println("🟨 Actual: Side menu expanded successfully.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Fetch Active Jobs count from Jobs module.");
		System.out.println("Step " + (step - 1) + ": Fetch Active Jobs count from Jobs module.");
		System.out.println();

		String Job_count_From_Job_List = Active_Job_count_fetcher();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Active Jobs count fetched successfully from Jobs module = "
						+ Job_count_From_Job_List);
		System.out.println("🟨 Actual: Active Jobs count fetched successfully from Jobs module = "
				+ Job_count_From_Job_List);
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step " + (step++) + ":</b> Compare Reports overview Open Jobs count with Jobs module Active Jobs count using soft assertion.");
		System.out.println("Step " + (step - 1) + ": Compare Reports overview Open Jobs count with Jobs module Active Jobs count using soft assertion.");
		System.out.println();

		String Open_Jobs_Count_From_Overview = Report_job_Data.get("Open Jobs").trim();
		String Active_Jobs_Count_From_Job_List = Job_count_From_Job_List.trim();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Reports overview Open Jobs count = " + Open_Jobs_Count_From_Overview
						+ " | Jobs module Active Jobs count = " + Active_Jobs_Count_From_Job_List);
		System.out.println("🟨 Actual: Reports overview Open Jobs count = " + Open_Jobs_Count_From_Overview
				+ " | Jobs module Active Jobs count = " + Active_Jobs_Count_From_Job_List);
		System.out.println();

		if (Open_Jobs_Count_From_Overview.equals(Active_Jobs_Count_From_Job_List)) {

			Report_Listen.log_print_in_report().log(Status.PASS,
					"<b>✅ Matched:</b> Reports overview Open Jobs count is matching with Jobs module Active Jobs count. Count = "
							+ Open_Jobs_Count_From_Overview);
			System.out.println("✅ Matched: Reports overview Open Jobs count is matching with Jobs module Active Jobs count. Count = "
					+ Open_Jobs_Count_From_Overview);
			System.out.println();

		} else {

			Report_Listen.log_print_in_report().log(Status.FAIL,
					"<b>❌ Mismatch:</b> Reports overview Open Jobs count is not matching with Jobs module Active Jobs count. Reports Overview Open Jobs = "
							+ Open_Jobs_Count_From_Overview
							+ " | Jobs Module Active Jobs = "
							+ Active_Jobs_Count_From_Job_List);
			System.out.println("❌ Mismatch: Reports overview Open Jobs count is not matching with Jobs module Active Jobs count.");
			System.out.println("Reports Overview Open Jobs = " + Open_Jobs_Count_From_Overview);
			System.out.println("Jobs Module Active Jobs = " + Active_Jobs_Count_From_Job_List);
			System.out.println();
		}

		softAssert.assertEquals(
				Active_Jobs_Count_From_Job_List,
				Open_Jobs_Count_From_Overview,
				"Open Jobs count mismatch. Reports overview Open Jobs = "
						+ Open_Jobs_Count_From_Overview
						+ " but Jobs module Active Jobs = "
						+ Active_Jobs_Count_From_Job_List);

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📌 Final Status:</b> Reports overview Open Jobs count validation completed against Jobs module Active Jobs count. Soft assertion result will be reported at the end.");
		System.out.println("📌 Final Status: Reports overview Open Jobs count validation completed against Jobs module Active Jobs count. Soft assertion result will be reported at the end.");
		System.out.println();

		softAssert.assertAll();
	}
	
	@Test
	public void Rejected_Candidate_Count_of_Report_Check() throws IOException, InterruptedException, AWTException {
		
		Report_Module_Locaters p = new Report_Module_Locaters(d);
		SoftAssert softAssert = new SoftAssert();
		
		
		int step = 1;


        TreeMap<String,String> Reports_Data=Overview_Tab_Data_collector("Last 3 Months", step);
        String Rejected_Candidates_Count_From_Overview = Reports_Data.get("Rejected Candidates").trim();
        System.out.println("Rejected Candidates count captured from Reports overview = " + Rejected_Candidates_Count_From_Overview);
		
	}
	
	
@Test
public void upcoming_interview_count_check() throws IOException, InterruptedException {

	int step = 1;

	Calender_Module_Locaters p = new Calender_Module_Locaters(d);
	Repeat rp = new Repeat(d);

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd h:mm a", Locale.ENGLISH);
	LocalDateTime Current_Date_Time = LocalDateTime.now();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🔹 Scenario Title:</b> Validate Reports Upcoming Interviews count with Calendar event cards");
	System.out.println();
	System.out.println("🔹 Scenario Title: Validate Reports Upcoming Interviews count with Calendar event cards");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Capture Reports overview data for filter = This Month.");
	System.out.println("Step " + (step - 1) + ": Capture Reports overview data for filter = This Month.");
	System.out.println();

	TreeMap<String, String> Reports_job_Data = Overview_Tab_Data_collector("This Month", 1);
	String Upcoming_Interviews_Count_From_Reports = Reports_job_Data.get("Upcoming Interviews").trim();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Reports Upcoming Interviews count captured = "
					+ Upcoming_Interviews_Count_From_Reports);
	System.out.println("🟨 Actual: Reports Upcoming Interviews count captured = "
			+ Upcoming_Interviews_Count_From_Reports);
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Navigate to Calendar module and apply All Interviewers filter.");
	System.out.println("Step " + (step - 1) + ": Navigate to Calendar module and apply All Interviewers filter.");
	System.out.println();

	side_menu_expander();
	Menu_option_selector("Calendar");
    WebElement landing_confirmation_text=p.Landed_in_calender_module();

	WebElement Filter_box = p.Calender_filter();
	WebElement Blocking_element;

	try {

		Blocking_element = p.Intercepting_Element();

	} catch (Exception e){
		
		Report_Listen.log_print_in_report().log(Status.WARNING,
				"<b>⚠ Retry:</b> Blocking/intercepting element was not fetched in first attempt. Refetching the Calendar locator object and trying again.");
		System.out.println("⚠ Retry: Blocking/intercepting element was not fetched in first attempt. Refetching and trying again.");
		System.out.println();

		Thread.sleep(800);
		
		Blocking_element = p.Intercepting_Element();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Blocking/intercepting element fetched successfully after retry.");
		System.out.println("🟨 Actual: Blocking/intercepting element fetched successfully after retry.");
		System.out.println();
		
	}

	rp.bring_target_above_blocking_element_and_click(Blocking_element, Filter_box);
	Thread.sleep(800);

	WebElement filter_dropdown = p.First_Dropdown_List();

	filter_dropdown.findElements(
			By.xpath(".//div[contains(@class,'ant-select-item') and contains(@class,'ant-select-item-option')]"))
			.stream()
			.filter(e -> e.getText().trim().equals("All Interviewers"))
			.findFirst()
			.orElseThrow(() -> new NoSuchElementException("Filter option not found: All Interviewers"))
			.click();

	rp.wait_for_invisibilty_of_theElement(filter_dropdown);
	Thread.sleep(800);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Calendar module opened and All Interviewers filter selected successfully.");
	System.out.println("🟨 Actual: Calendar module opened and All Interviewers filter selected successfully.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Fetch all visible Calendar event cards.");
	System.out.println("Step " + (step - 1) + ": Fetch all visible Calendar event cards.");
	System.out.println();

	List<WebElement> Calender_Event_Cards = p.Calender_event_card();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Calendar event cards fetched successfully. Total visible cards found = "
					+ Calender_Event_Cards.size());
	System.out.println("🟨 Actual: Calendar event cards fetched successfully. Total visible cards found = "
			+ Calender_Event_Cards.size());
	System.out.println();

	int Upcoming_Calendar_Interview_Count = 0;

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Visit each Calendar card, fetch popover Date / Time, and count only future interviews.");
	System.out.println("Step " + (step - 1) + ": Visit each Calendar card, fetch popover Date / Time, and count only future interviews.");
	System.out.println();

	for (WebElement card : Calender_Event_Cards) {

		String card_text = card.getText().trim();

		rp.movetoelement(card);
		Thread.sleep(600);

		WebElement Popup = p.Popover();

		String Date_Time_Text = Popup.findElements(
				By.xpath(".//div[contains(@class,'ant-col ant-col-12 mb-20')]"))
				.stream()
				.map(e -> e.getText().trim())
				.filter(text -> text.contains("Date / Time"))
				.findFirst()
				.orElse("");

		if (Date_Time_Text.equals("")) {

			Report_Listen.log_print_in_report().log(Status.WARNING,
					"<b>⚠ Skipped:</b> Date / Time not found for Calendar card = " + card_text);
			System.out.println("⚠ Skipped: Date / Time not found for Calendar card = " + card_text);
			System.out.println();

			continue;
		}

		String[] date_time_lines = Date_Time_Text.split("\\R");

		String interview_date = date_time_lines[1].trim();
		String interview_start_time = date_time_lines[2].split("-")[0].trim().toUpperCase(Locale.ENGLISH);

		LocalDateTime Interview_Date_Time = LocalDateTime.parse(
				interview_date + " " + interview_start_time,
				formatter);

		if (Interview_Date_Time.isAfter(Current_Date_Time)) {

			Upcoming_Calendar_Interview_Count++;

			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>✅ Counted:</b> Upcoming Calendar interview = " + card_text
							+ " | Date/Time = " + Interview_Date_Time);
			System.out.println("✅ Counted: Upcoming Calendar interview = " + card_text
					+ " | Date/Time = " + Interview_Date_Time);
			System.out.println();

		} else {

			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>⏭ Skipped:</b> Past Calendar interview = " + card_text
							+ " | Date/Time = " + Interview_Date_Time);
			System.out.println("⏭ Skipped: Past Calendar interview = " + card_text
					+ " | Date/Time = " + Interview_Date_Time);
			System.out.println();
		}
		
		rp.movetoelement(landing_confirmation_text);
		Thread.sleep(400);
	}

	String Upcoming_Interviews_Count_From_Calendar = String.valueOf(Upcoming_Calendar_Interview_Count);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step " + (step++) + ":</b> Compare Reports Upcoming Interviews count with Calendar upcoming interview count.");
	System.out.println("Step " + (step - 1) + ": Compare Reports Upcoming Interviews count with Calendar upcoming interview count.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Reports Upcoming Interviews = "
					+ Upcoming_Interviews_Count_From_Reports
					+ " | Calendar Upcoming Interviews = "
					+ Upcoming_Interviews_Count_From_Calendar);
	System.out.println("🟨 Actual: Reports Upcoming Interviews = "
			+ Upcoming_Interviews_Count_From_Reports
			+ " | Calendar Upcoming Interviews = "
			+ Upcoming_Interviews_Count_From_Calendar);
	System.out.println();

	if (Upcoming_Interviews_Count_From_Reports.equals(Upcoming_Interviews_Count_From_Calendar)) {

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>✅ Matched:</b> Reports Upcoming Interviews count matched with Calendar upcoming interview count.");
		System.out.println("✅ Matched: Reports Upcoming Interviews count matched with Calendar upcoming interview count.");
		System.out.println();

	} else {

		Report_Listen.log_print_in_report().log(Status.FAIL,
				"<b>❌ Mismatch:</b> Reports Upcoming Interviews count did not match with Calendar upcoming interview count. Reports = "
						+ Upcoming_Interviews_Count_From_Reports
						+ " | Calendar = "
						+ Upcoming_Interviews_Count_From_Calendar);
		System.out.println("❌ Mismatch: Reports Upcoming Interviews count did not match with Calendar upcoming interview count.");
		System.out.println("Reports = " + Upcoming_Interviews_Count_From_Reports);
		System.out.println("Calendar = " + Upcoming_Interviews_Count_From_Calendar);
		System.out.println();
	}

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📌 Final Status:</b> Upcoming Interviews validation completed and result logged in ExtentReport.");
	System.out.println("📌 Final Status: Upcoming Interviews validation completed and result logged in ExtentReport.");
	System.out.println();
}
	
public void filter_option_selector(String option) throws IOException, InterruptedException {

	Report_Module_Locaters p = new Report_Module_Locaters(d);

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>Step:</b> Open Reports module and verify currently selected report filter option.");
	System.out.println("Step: Open Reports module and verify currently selected report filter option.");
	System.out.println();

	WebElement filter = reports_module_Accessor();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Reports module opened successfully and filter element was identified.");
	System.out.println("🟨 Actual: Reports module opened successfully and filter element was identified.");
	System.out.println();

	WebElement Selected_filter_value_element = filter.findElement(
			By.xpath(".//span[contains(@class,'ant-select-selection-item')]"));

	String Selected_filter_value_text = Selected_filter_value_element.getAttribute("title").trim();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🟨 Actual:</b> Currently selected report filter option = "
					+ Selected_filter_value_text
					+ " | Required filter option = "
					+ option);
	System.out.println("🟨 Actual: Currently selected report filter option = "
			+ Selected_filter_value_text
			+ " | Required filter option = "
			+ option);
	System.out.println();

	if (!option.equals(Selected_filter_value_text)) {

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step:</b> Current filter option is different from required option. Opening filter dropdown.");
		System.out.println("Step: Current filter option is different from required option. Opening filter dropdown.");
		System.out.println();

		filter.click();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Reports filter dropdown opened successfully.");
		System.out.println("🟨 Actual: Reports filter dropdown opened successfully.");
		System.out.println();

		WebElement filter_dropdown = p.Owner_Dropdown();

		filter_dropdown.findElements(
				By.xpath(".//div[contains(@class,'ant-select-item') and contains(@class,'ant-select-item-option')]"))
				.stream()
				.filter(e -> e.getText().trim().equals(option))
				.findFirst()
				.orElseThrow(() -> new NoSuchElementException("Filter option not found: " + option))
				.click();

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>🟨 Actual:</b> Report filter option changed successfully from "
						+ Selected_filter_value_text
						+ " to "
						+ option);
		System.out.println("🟨 Actual: Report filter option changed successfully from "
				+ Selected_filter_value_text
				+ " to "
				+ option);
		System.out.println();

	} else {

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Required report filter option is already selected, so dropdown selection was skipped. Selected option = "
						+ Selected_filter_value_text);
		System.out.println("🟨 Actual: Required report filter option is already selected, so dropdown selection was skipped. Selected option = "
				+ Selected_filter_value_text);
		System.out.println();
	}
}
}
