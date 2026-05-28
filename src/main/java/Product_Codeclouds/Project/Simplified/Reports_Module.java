package Product_Codeclouds.Project.Simplified;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
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
	
	
	
	@Test
	public void overview_section_Data_Consistency_checking() throws IOException, InterruptedException, AWTException {

		Report_Module_Locaters p = new Report_Module_Locaters(d);
		SoftAssert softAssert = new SoftAssert();

		int step = 1;

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

		filter_option_selector("This Month");

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

		String Open_Jobs_Count_From_Overview = Overview_Cards_Data.get("Open Jobs").trim();
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
	
	
	
	public void filter_option_selector(String option) throws IOException, InterruptedException {

		Report_Module_Locaters p = new Report_Module_Locaters(d);

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step:</b> Open filter dropdown and select report filter option = " + option);
		System.out.println("Step: Open filter dropdown and select report filter option = " + option);
		System.out.println();

		WebElement filter = reports_module_Accessor();
		filter.click();

		WebElement filter_dropdown = p.Owner_Dropdown();
		filter_dropdown.findElements(
				By.xpath(".//div[contains(@class,'ant-select-item') and contains(@class,'ant-select-item-option')]"))
				.stream()
				.filter(e -> e.getText().trim().equals(option))
				.findFirst()
				.orElseThrow(() -> new NoSuchElementException("Filter option not found: " + option))
				.click();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Filter option selected successfully = " + option);
		System.out.println("🟨 Actual: Filter option selected successfully = " + option);
		System.out.println();
	}
}
