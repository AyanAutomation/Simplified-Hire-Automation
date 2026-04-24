package Product_Codeclouds.Project.Simplified;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
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
		
		Menu_option_selector("Reports");
	    WebElement Filter=	p.Filter_button();
		return Filter;
	
	
	}
	
	
	
	@Test
	public void overview_section_Data_Consistency_checking() throws IOException, InterruptedException {

	Report_Module_Locaters p = new Report_Module_Locaters(d);
	Candidate_Module_Locaters cp = new Candidate_Module_Locaters(d);
	
	int step = 1;

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>🔹 Scenario Title:</b> Capture overview section card data for consistency checking");
	System.out.println();
	System.out.println("🔹 Scenario Title: Capture overview section card data for consistency checking");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📘 Description:</b> Apply the required report filter, fetch all overview section card labels and values, and store them into the overview data map for downstream consistency validation.");
	System.out.println("📘 Description: Apply the required report filter, fetch all overview section card labels and values, and store them into the overview data map for downstream consistency validation.");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>📥 Input:</b> Filter Option = This Month");
	System.out.println("📥 Input: Filter Option = This Month");
	System.out.println();

	Report_Listen.log_print_in_report().log(Status.INFO,
			"<b>✅ Expected:</b> Overview card data should be refreshed for the selected filter, all visible labels and values should be fetched successfully, and the data map should be populated with correct label-value pairs.");
	System.out.println("✅ Expected: Overview card data should be refreshed for the selected filter, all visible labels and values should be fetched successfully, and the data map should be populated with correct label-value pairs.");
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

	IntStream.range(0, overview_section_Labels.size())
			.forEach(i -> {
				String label = overview_section_Labels.get(i).getText().trim();
				String value = overview_section_values.get(i).getText().trim();

				Overview_Cards_Data.put(label, value);

				Report_Listen.log_print_in_report().log(Status.INFO,
						"<b>🟨 Actual:</b> Overview card stored successfully = " + label + " -> " + value);
				System.out.println("🟨 Actual: Overview card stored successfully = " + label + " -> " + value);
			});

	Report_Listen.log_print_in_report().log(Status.PASS,
			"<b>📌 Final Status:</b> Overview section data captured successfully for filter = This Month. Total entries stored = "
					+ Overview_Cards_Data.size());
	System.out.println();
	System.out.println("📌 Final Status: Overview section data captured successfully for filter = This Month. Total entries stored = "
			+ Overview_Cards_Data.size());
	System.out.println();
  
	
	side_menu_expander();
	Candidate_List_Accesor();
	pagination_changer("100");
	List<WebElement> Candidate_Filters = cp.Candidate_List_Filter_Dropdowns();
	WebElement All_stage_filter = Candidate_Filters.get(3);
	All_stage_filter.click();
	WebElement All_stage_filter_dropdown = cp.stages_Dropdown();
	List<WebElement> stages = All_stage_filter_dropdown.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"));
	for(WebElement stage: stages) {
		String stage_name = stage.getAttribute("title").trim();
		if(stage_name.contains("All Stages")) {
			stage.findElement(By.xpath(".//span[contains(@class,'ant-select-item-option-content')]")).click();
			break;
		}
	
	
	}
	
	
	}
	
	
	
	public void filter_option_selector(String option) throws IOException, InterruptedException {
		
		Report_Module_Locaters p = new Report_Module_Locaters(d);
		Repeat rp = new Repeat(d);
		
		WebElement Filter = reports_module_Accessor();
		Filter.click();
		WebElement filter_dropdown= p.Owner_Dropdown();
		rp.movetoelement(filter_dropdown);
		filter_dropdown.findElements(By.xpath(".//div[contains(@class,'ant-select-item') and contains(@class,'ant-select-item-option')]"))
		.stream()
		.filter(e -> e.getText().trim().equals(option))
		.findFirst()
		.orElseThrow(() -> new NoSuchElementException("Filter option not found: " + option))
		.click();
	
}
}
