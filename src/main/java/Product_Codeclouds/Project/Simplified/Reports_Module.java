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

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Candidate_Module_Locaters;
import Locaters.Report_Module_Locaters;
import Repeatative_codes.Repeat;

public class Reports_Module extends Candidate_module{
	
	TreeMap<String, String> Overview_Cards_Data = new TreeMap<String, String>();
	
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
		Candidate_Module_Locaters cp = new Candidate_Module_Locaters(d);
		Repeat rp = new Repeat(d);
		Robot r = new Robot();

		int step = 1;

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🔹 Scenario Title:</b> Capture overview section card data and verify candidate count flow");
		System.out.println();
		System.out.println("🔹 Scenario Title: Capture overview section card data and verify candidate count flow");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📘 Description:</b> Open the Reports module, apply the required report filter, capture all overview section labels and values into the overview data map, then navigate to Candidate list, select All Stages, change pagination, and print the exact candidate count confirmation values.");
		System.out.println("📘 Description: Open the Reports module, apply the required report filter, capture all overview section labels and values into the overview data map, then navigate to Candidate list, select All Stages, change pagination, and print the exact candidate count confirmation values.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📥 Input:</b> Report Filter = This Month | Candidate Stage Filter = All Stages | Pagination = 100");
		System.out.println("📥 Input: Report Filter = This Month | Candidate Stage Filter = All Stages | Pagination = 100");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>✅ Expected:</b> Overview card data should be captured successfully for the selected report filter, Candidate list should open successfully, All Stages should be selected, pagination should change to 100, and exact candidate count text should be available.");
		System.out.println("✅ Expected: Overview card data should be captured successfully for the selected report filter, Candidate list should open successfully, All Stages should be selected, pagination should change to 100, and exact candidate count text should be available.");
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
				"<b>Step " + (step++) + ":</b> Fetch overview section labels and values.");
		System.out.println("Step " + (step - 1) + ": Fetch overview section labels and values.");
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
				"<b>Step " + (step++) + ":</b> Expand side menu and open Candidate list page.");
		System.out.println("Step " + (step - 1) + ": Expand side menu and open Candidate list page.");
		System.out.println();

		side_menu_expander();
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
