package Product_Codeclouds.Project.Simplified;

import java.io.IOException;
import java.util.TreeMap;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Candidate_Module_Locaters;

public class Candidate_module extends Side_menu_Handler {

	public WebElement Candidate_List_Accesor() throws IOException, InterruptedException {

		Candidate_Module_Locaters p = new Candidate_Module_Locaters(d);

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step:</b> Navigate to Candidates module from side menu.");
		System.out.println("Step: Navigate to Candidates module from side menu.");

		Menu_option_selector("Candidates");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step:</b> Validate landing in Candidate list by identifying the Import CV button.");
		System.out.println("Step: Validate landing in Candidate list by identifying the Import CV button.");

		WebElement Import = p.Import_Cv_Button();

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>🟨 Actual:</b> Candidate list opened successfully and Import CV button was identified.");
		System.out.println("🟨 Actual: Candidate list opened successfully and Import CV button was identified.");

		return Import;
	}
	
	
	
   
	public void Import_CV_Accessor() throws IOException, InterruptedException {

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🔹 Scenario Title:</b> Access Candidate import CV section");
		System.out.println("🔹 Scenario Title: Access Candidate import CV section");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📘 Description:</b> Open the Candidates module, validate landing in Candidate list using the Import CV button as the unique identifier, and click it to open the candidate CV import section.");
		System.out.println("📘 Description: Open the Candidates module, validate landing in Candidate list using the Import CV button as the unique identifier, and click it to open the candidate CV import section.");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>✅ Expected:</b> Candidates module should open successfully, Import CV button should be visible as the Candidate list identifier, and clicking it should open the candidate CV import section.");
		System.out.println("✅ Expected: Candidates module should open successfully, Import CV button should be visible as the Candidate list identifier, and clicking it should open the candidate CV import section.");

		WebElement Import = Candidate_List_Accesor();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step:</b> Click on Import CV button.");
		System.out.println("Step: Click on Import CV button.");
		Import.click();

		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>🟨 Actual:</b> Import CV button clicked successfully and candidate import flow was opened.");
		System.out.println("🟨 Actual: Import CV button clicked successfully and candidate import flow was opened.");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📌 Final Status:</b> Candidate Import CV access flow completed successfully.");
		System.out.println("📌 Final Status: Candidate Import CV access flow completed successfully.");
	}
    
    @Test(dataProvider = "Candidate_CV_Upload_Files")
    public void CV_upload(TreeMap<String, String> file) throws IOException, InterruptedException {

    	int step = 1;

    	Candidate_Module_Locaters p = new Candidate_Module_Locaters(d);

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>🔹 Scenario Title:</b> Validate candidate CV upload using different file types");
    	System.out.println("🔹 Scenario Title: Validate candidate CV upload using different file types");

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>📘 Description:</b> Open the Candidate Import CV section, upload the configured file from data provider, and validate CV parsing behavior for the selected file type.");
    	System.out.println("📘 Description: Open the Candidate Import CV section, upload the configured file from data provider, and validate CV parsing behavior for the selected file type.");

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>📥 Input:</b> File Type = " + file.get("File Type") + " | File Path = " + file.get("File Path"));
    	System.out.println("📥 Input: File Type = " + file.get("File Type") + " | File Path = " + file.get("File Path"));

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>✅ Expected:</b> Import CV section should open successfully, upload field should accept the configured file path, and the system should process the uploaded file according to the supported/unsupported file type behavior.");
    	System.out.println("✅ Expected: Import CV section should open successfully, upload field should accept the configured file path, and the system should process the uploaded file according to the supported/unsupported file type behavior.");

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>Step " + (step++) + ":</b> Open Candidate Import CV section.");
    	System.out.println("Step " + (step - 1) + ": Open Candidate Import CV section.");
    	Import_CV_Accessor();
    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>🟨 Actual:</b> Candidate Import CV section opened successfully.");
    	System.out.println("🟨 Actual: Candidate Import CV section opened successfully.");

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>Step " + (step++) + ":</b> Identify CV upload field.");
    	System.out.println("Step " + (step - 1) + ": Identify CV upload field.");
    	WebElement Upload_file_field = p.Upload_Field();
    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>🟨 Actual:</b> CV upload field identified successfully.");
    	System.out.println("🟨 Actual: CV upload field identified successfully.");

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>Step " + (step++) + ":</b> Upload file into CV upload field.");
    	System.out.println("Step " + (step - 1) + ": Upload file into CV upload field.");
    	Upload_file_field.sendKeys(file.get("File Path"));
    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>🟨 Actual:</b> File path sent successfully for upload = " + file.get("File Path"));
    	System.out.println("🟨 Actual: File path sent successfully for upload = " + file.get("File Path"));

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>Step " + (step++) + ":</b> Trigger/validate CV parsing process after upload.");
    	System.out.println("Step " + (step - 1) + ": Trigger/validate CV parsing process after upload.");
    	p.Parsing_cv();
    	Report_Listen.log_print_in_report().log(Status.PASS,
    			"<b>🟨 Actual:</b> CV parsing flow executed successfully for file type = " + file.get("File Type"));
    	System.out.println("🟨 Actual: CV parsing flow executed successfully for file type = " + file.get("File Type"));

    	Report_Listen.log_print_in_report().log(Status.INFO,
    			"<b>📌 Final Status:</b> Candidate CV upload validation flow completed for file type = " + file.get("File Type"));
    	System.out.println("📌 Final Status: Candidate CV upload validation flow completed for file type = " + file.get("File Type"));
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