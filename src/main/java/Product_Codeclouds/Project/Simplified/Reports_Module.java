package Product_Codeclouds.Project.Simplified;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Locaters.Report_Module_Locaters;
import Repeatative_codes.Repeat;

public class Reports_Module extends Candidate_module{
	
	
	
	public WebElement reports_module_Accessor() throws IOException, InterruptedException {
		
		Report_Module_Locaters p = new Report_Module_Locaters(d);
		
		Menu_option_selector("Reports");
	    WebElement Filter=	p.Filter_button();
		return Filter;
	
	
	}
	
	
	
	@Test
	public void overview_section_Data_Consistency_checking() throws IOException, InterruptedException {
		
		Report_Module_Locaters p = new Report_Module_Locaters(d);
		
		
	
		filter_option_selector("This Month");
		
		
		
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
