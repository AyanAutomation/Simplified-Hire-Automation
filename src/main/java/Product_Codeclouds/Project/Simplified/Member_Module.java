package Product_Codeclouds.Project.Simplified;

import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Candidate_Module_Locaters;
import Locaters.Job_Module_locaters;
import Locaters.Member_Module_locaters;
import Repeatative_codes.Repeat;

public class Member_Module extends Candidate_module{

public TreeSet<String> Member_Names=new TreeSet<String>();
	
	
	public WebElement Member_List_Accesor() throws IOException, InterruptedException {
		
		Member_Module_locaters p = new Member_Module_locaters(d);
		
		Menu_option_selector("Settings");
	    WebElement Internal_menu=p.Setting_internal_Menu();
		List<WebElement> Menu_options = Internal_menu.findElements(By.xpath(".//*[contains(@class,'ant-menu-item-only-child')]"));
		for(WebElement option:Menu_options) {
			if(option.getText().equals("Members")) {
				option.click();
				break;}}
		
		
		WebElement Member_AddButton=p.Member_Add_Button();
		return Member_AddButton;
	}
	

	public void Member_List_Data_Collector() throws IOException, InterruptedException{
		
		Candidate_Module_Locaters p = new Candidate_Module_Locaters(d);
		Repeat rp = new Repeat(d);
	    Job_Module_locaters jb = new Job_Module_locaters(d);
		
	    Member_Names.clear();
		Member_List_Accesor();
		Thread.sleep(800);
		   try {
				rp.wait_for_invisibilty_of_theElement(jb.List_loader());

			} catch (Exception e) {
				System.out.println("Loader not visible.");
				System.out.println();
				Report_Listen.log_print_in_report().log(Status.INFO,
						"<b>🟨 Actual:</b> Loader was not visible.");
			}
		List<WebElement> Member_names = p.candidate_names_in_list();
		for(WebElement member:Member_names) {
			WebElement member_name=member.findElement(By.xpath(".//div[2]"));
			String name=member_name.getText().trim();
			Member_Names.add(name);
			System.out.println(name);
			System.out.println();
		}
		
		d.navigate().to("https://ayan-steel-hire.dev.besimplified.net/candidates");

		
		
	}
	
	
}
