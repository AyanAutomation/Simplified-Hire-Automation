package Product_Codeclouds.Project.Simplified;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Candidate_Module_Locaters;
import Repeatative_codes.Repeat;

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
	
	@Test(dataProvider = "combinedData")
	public void Add_Candidate(TreeMap<String, String> candidate_data, TreeMap<String, String> job_data) throws IOException, InterruptedException{
		
		String Job_Assign = job_data.get("Job Posting Name");
		String Email = candidate_data.get("Email");
		String Phone_Code = candidate_data.get("Phone Code");
		String Phone_Number = candidate_data.get("Phone Number");
		String First_Name = candidate_data.get("First Name");
		String Last_Name = candidate_data.get("Last Name");
		String Professional_Profile_Link = candidate_data.get("Professional Profile Link");

		String Source = candidate_data.get("Source");
		String Country = candidate_data.get("Country");
		String State = candidate_data.get("State");

		String Current_Salary_Currency = candidate_data.get("Current Salary Currency");
		String Current_Salary = candidate_data.get("Current Salary");
		String Current_Salary_Duration = candidate_data.get("Current Salary Duration");

		String Expected_Salary_Currency = candidate_data.get("Expected Salary Currency");
		String Expected_Salary = candidate_data.get("Expected Salary");
		String Expected_Salary_Duration = candidate_data.get("Expected Salary Duration");

		String CV_Resume = candidate_data.get("CV/Resume");
		String Skills = candidate_data.get("Skills");

		String Relevant_Experience = candidate_data.get("Relevant Experience");
		String Relevant_Experience_Unit = candidate_data.get("Relevant Experience Unit");

		String Total_Experience = candidate_data.get("Total Experience");
		String Total_Experience_Unit = candidate_data.get("Total Experience Unit");

		String Notice_Period = candidate_data.get("Notice Period");
		String Notice_Period_Unit = candidate_data.get("Notice Period Unit");

		String Work_Experience = candidate_data.get("Work Experience");
		String Education = candidate_data.get("Education");
		String Cover_Letter = candidate_data.get("Cover Letter");

		String Owner = candidate_data.get("Owner");
		String Recruiter = candidate_data.get("Recruiter");
		
		Candidate_Module_Locaters p = new Candidate_Module_Locaters(d);
		Repeat rp = new Repeat(d);
		
		Candidate_List_Accesor();
		p.Add_Button().click();
		WebElement Pop_up_body=p.Pop_up_form();
		rp.movetoelement(Pop_up_body);
		Set<WebElement> inputs_boxes = new LinkedHashSet<WebElement>(p.name_ph_email_input_fieldsBox());
		LinkedHashSet<WebElement> dropdowns = new LinkedHashSet<WebElement>(p.Pop_Up_Form_Custom_Dropdown_fields());
		Set<WebElement> inputs = new LinkedHashSet<WebElement>(p.name_ph_email_input_fields());
		
		
		
		
		
	}
	
	@DataProvider
	public Object[][] Combined_Candidate_Job_Data() {

		Job_Module jobProvider = new Job_Module();
	

		Object[][] candidateData = Candidate_Add_Data();
		Object[][] jobData = jobProvider.Job_Posting_Data();

		int rowCount = Math.min(candidateData.length, jobData.length);
		Object[][] combinedData = new Object[rowCount][2];

		for (int i = 0; i < rowCount; i++) {

			

			combinedData[i][0]=candidateData[i][0];
			combinedData[i][1]=jobData[i][0];
			
		}

		return combinedData;
	}

	
	@DataProvider
	public Object[][] Candidate_Add_Data() {

	    TreeMap<String, String> data1 = new TreeMap<String, String>();
	    data1.put("Email", "arjun.nair01@yopmail.com");
	    data1.put("Phone Code", "+91");
	    data1.put("Phone Number", "9876543210");
	    data1.put("First Name", "Arjun");
	    data1.put("Last Name", "Nair");
	    data1.put("Professional Profile Link", "https://www.linkedin.com/in/arjunnair01");
	    data1.put("Source", "Candidate Portal");
	    data1.put("Country", "India");
	    data1.put("State", "");
	    data1.put("Current Salary Currency", "INR(₹)");
	    data1.put("Current Salary", "1200000");
	    data1.put("Current Salary Duration", "Yearly");
	    data1.put("Expected Salary Currency", "INR(₹)");
	    data1.put("Expected Salary", "1500000");
	    data1.put("Expected Salary Duration", "Yearly");
	    data1.put("CV/Resume", "");
	    data1.put("Skills", "");
	    data1.put("Relevant Experience", "4");
	    data1.put("Relevant Experience Unit", "Year(s)");
	    data1.put("Total Experience", "5");
	    data1.put("Total Experience Unit", "Year(s)");
	    data1.put("Notice Period", "30");
	    data1.put("Notice Period Unit", "Day(s)");
	    data1.put("Work Experience", "");
	    data1.put("Education", "");
	    data1.put("Cover Letter", "");
	    data1.put("Owner", "Admin Ayan Sengupta");
	    data1.put("Recruiter", "Admin Ayan Sengupta");

	    TreeMap<String, String> data2 = new TreeMap<String, String>();
	    data2.put("Email", "alexei.morozov02@yopmail.com");
	    data2.put("Phone Code", "+91");
	    data2.put("Phone Number", "9812345678");
	    data2.put("First Name", "Alexei");
	    data2.put("Last Name", "Morozov");
	    data2.put("Professional Profile Link", "https://www.linkedin.com/in/alexeimorozov02");
	    data2.put("Source", "Consultancy");
	    data2.put("Country", "India");
	    data2.put("State", "");
	    data2.put("Current Salary Currency", "INR(₹)");
	    data2.put("Current Salary", "1400000");
	    data2.put("Current Salary Duration", "Yearly");
	    data2.put("Expected Salary Currency", "INR(₹)");
	    data2.put("Expected Salary", "1750000");
	    data2.put("Expected Salary Duration", "Yearly");
	    data2.put("CV/Resume", "");
	    data2.put("Skills", "");
	    data2.put("Relevant Experience", "6");
	    data2.put("Relevant Experience Unit", "Year(s)");
	    data2.put("Total Experience", "7");
	    data2.put("Total Experience Unit", "Year(s)");
	    data2.put("Notice Period", "45");
	    data2.put("Notice Period Unit", "Day(s)");
	    data2.put("Work Experience", "");
	    data2.put("Education", "");
	    data2.put("Cover Letter", "");
	    data2.put("Owner", "Alexei Morozov");
	    data2.put("Recruiter", "Alexei Morozov");

	    TreeMap<String, String> data3 = new TreeMap<String, String>();
	    data3.put("Email", "vivek.sharma03@yopmail.com");
	    data3.put("Phone Code", "+91");
	    data3.put("Phone Number", "9823456781");
	    data3.put("First Name", "Vivek");
	    data3.put("Last Name", "Sharma");
	    data3.put("Professional Profile Link", "https://www.linkedin.com/in/viveksharma03");
	    data3.put("Source", "Email");
	    data3.put("Country", "India");
	    data3.put("State", "");
	    data3.put("Current Salary Currency", "INR(₹)");
	    data3.put("Current Salary", "1000000");
	    data3.put("Current Salary Duration", "Yearly");
	    data3.put("Expected Salary Currency", "INR(₹)");
	    data3.put("Expected Salary", "1300000");
	    data3.put("Expected Salary Duration", "Yearly");
	    data3.put("CV/Resume", "");
	    data3.put("Skills", "");
	    data3.put("Relevant Experience", "3");
	    data3.put("Relevant Experience Unit", "Year(s)");
	    data3.put("Total Experience", "4");
	    data3.put("Total Experience Unit", "Year(s)");
	    data3.put("Notice Period", "60");
	    data3.put("Notice Period Unit", "Day(s)");
	    data3.put("Work Experience", "");
	    data3.put("Education", "");
	    data3.put("Cover Letter", "");
	    data3.put("Owner", "Guest Alexei Sokolov");
	    data3.put("Recruiter", "Guest Alexei Sokolov");

	    TreeMap<String, String> data4 = new TreeMap<String, String>();
	    data4.put("Email", "nikolai.sidorov04@yopmail.com");
	    data4.put("Phone Code", "+91");
	    data4.put("Phone Number", "9834567812");
	    data4.put("First Name", "Nikolai");
	    data4.put("Last Name", "Sidorov");
	    data4.put("Professional Profile Link", "https://www.linkedin.com/in/nikolaisidorov04");
	    data4.put("Source", "Import");
	    data4.put("Country", "India");
	    data4.put("State", "");
	    data4.put("Current Salary Currency", "INR(₹)");
	    data4.put("Current Salary", "1600000");
	    data4.put("Current Salary Duration", "Yearly");
	    data4.put("Expected Salary Currency", "INR(₹)");
	    data4.put("Expected Salary", "2000000");
	    data4.put("Expected Salary Duration", "Yearly");
	    data4.put("CV/Resume", "");
	    data4.put("Skills", "");
	    data4.put("Relevant Experience", "7");
	    data4.put("Relevant Experience Unit", "Year(s)");
	    data4.put("Total Experience", "8");
	    data4.put("Total Experience Unit", "Year(s)");
	    data4.put("Notice Period", "30");
	    data4.put("Notice Period Unit", "Day(s)");
	    data4.put("Work Experience", "");
	    data4.put("Education", "");
	    data4.put("Cover Letter", "");
	    data4.put("Owner", "Interviewer Ivan Orlov");
	    data4.put("Recruiter", "Interviewer Ivan Orlov");

	    TreeMap<String, String> data5 = new TreeMap<String, String>();
	    data5.put("Email", "sourav.bose05@yopmail.com");
	    data5.put("Phone Code", "+91");
	    data5.put("Phone Number", "9845678123");
	    data5.put("First Name", "Sourav");
	    data5.put("Last Name", "Bose");
	    data5.put("Professional Profile Link", "https://www.linkedin.com/in/souravbose05");
	    data5.put("Source", "Indeed");
	    data5.put("Country", "India");
	    data5.put("State", "");
	    data5.put("Current Salary Currency", "INR(₹)");
	    data5.put("Current Salary", "1300000");
	    data5.put("Current Salary Duration", "Yearly");
	    data5.put("Expected Salary Currency", "INR(₹)");
	    data5.put("Expected Salary", "1650000");
	    data5.put("Expected Salary Duration", "Yearly");
	    data5.put("CV/Resume", "");
	    data5.put("Skills", "");
	    data5.put("Relevant Experience", "6");
	    data5.put("Relevant Experience Unit", "Year(s)");
	    data5.put("Total Experience", "7");
	    data5.put("Total Experience Unit", "Year(s)");
	    data5.put("Notice Period", "90");
	    data5.put("Notice Period Unit", "Day(s)");
	    data5.put("Work Experience", "");
	    data5.put("Education", "");
	    data5.put("Cover Letter", "");
	    data5.put("Owner", "Nikolai Sidorov");
	    data5.put("Recruiter", "Nikolai Sidorov");

	    TreeMap<String, String> data6 = new TreeMap<String, String>();
	    data6.put("Email", "mikhail.volkov06@yopmail.com");
	    data6.put("Phone Code", "+91");
	    data6.put("Phone Number", "9856781234");
	    data6.put("First Name", "Mikhail");
	    data6.put("Last Name", "Volkov");
	    data6.put("Professional Profile Link", "https://www.linkedin.com/in/mikhailvolkov06");
	    data6.put("Source", "LinkedIn");
	    data6.put("Country", "India");
	    data6.put("State", "");
	    data6.put("Current Salary Currency", "INR(₹)");
	    data6.put("Current Salary", "1700000");
	    data6.put("Current Salary Duration", "Yearly");
	    data6.put("Expected Salary Currency", "INR(₹)");
	    data6.put("Expected Salary", "2100000");
	    data6.put("Expected Salary Duration", "Yearly");
	    data6.put("CV/Resume", "");
	    data6.put("Skills", "");
	    data6.put("Relevant Experience", "8");
	    data6.put("Relevant Experience Unit", "Year(s)");
	    data6.put("Total Experience", "9");
	    data6.put("Total Experience Unit", "Year(s)");
	    data6.put("Notice Period", "60");
	    data6.put("Notice Period Unit", "Day(s)");
	    data6.put("Work Experience", "");
	    data6.put("Education", "");
	    data6.put("Cover Letter", "");
	    data6.put("Owner", "Owner Mikhail Volkov");
	    data6.put("Recruiter", "Owner Mikhail Volkov");

	    TreeMap<String, String> data7 = new TreeMap<String, String>();
	    data7.put("Email", "pritam.ghosh07@yopmail.com");
	    data7.put("Phone Code", "+91");
	    data7.put("Phone Number", "9867891234");
	    data7.put("First Name", "Pritam");
	    data7.put("Last Name", "Ghosh");
	    data7.put("Professional Profile Link", "https://www.linkedin.com/in/pritamghosh07");
	    data7.put("Source", "Naukri");
	    data7.put("Country", "India");
	    data7.put("State", "");
	    data7.put("Current Salary Currency", "INR(₹)");
	    data7.put("Current Salary", "800000");
	    data7.put("Current Salary Duration", "Yearly");
	    data7.put("Expected Salary Currency", "INR(₹)");
	    data7.put("Expected Salary", "1050000");
	    data7.put("Expected Salary Duration", "Yearly");
	    data7.put("CV/Resume", "");
	    data7.put("Skills", "");
	    data7.put("Relevant Experience", "2");
	    data7.put("Relevant Experience Unit", "Year(s)");
	    data7.put("Total Experience", "3");
	    data7.put("Total Experience Unit", "Year(s)");
	    data7.put("Notice Period", "15");
	    data7.put("Notice Period Unit", "Day(s)");
	    data7.put("Work Experience", "");
	    data7.put("Education", "");
	    data7.put("Cover Letter", "");
	    data7.put("Owner", "Rahul Chatterjee");
	    data7.put("Recruiter", "Rahul Chatterjee");

	    TreeMap<String, String> data8 = new TreeMap<String, String>();
	    data8.put("Email", "ivan.orlov08@yopmail.com");
	    data8.put("Phone Code", "+91");
	    data8.put("Phone Number", "9876501234");
	    data8.put("First Name", "Ivan");
	    data8.put("Last Name", "Orlov");
	    data8.put("Professional Profile Link", "https://www.linkedin.com/in/ivanorlov08");
	    data8.put("Source", "Candidate Portal");
	    data8.put("Country", "India");
	    data8.put("State", "");
	    data8.put("Current Salary Currency", "INR(₹)");
	    data8.put("Current Salary", "1500000");
	    data8.put("Current Salary Duration", "Yearly");
	    data8.put("Expected Salary Currency", "INR(₹)");
	    data8.put("Expected Salary", "1850000");
	    data8.put("Expected Salary Duration", "Yearly");
	    data8.put("CV/Resume", "");
	    data8.put("Skills", "");
	    data8.put("Relevant Experience", "6");
	    data8.put("Relevant Experience Unit", "Year(s)");
	    data8.put("Total Experience", "7");
	    data8.put("Total Experience Unit", "Year(s)");
	    data8.put("Notice Period", "30");
	    data8.put("Notice Period Unit", "Day(s)");
	    data8.put("Work Experience", "");
	    data8.put("Education", "");
	    data8.put("Cover Letter", "");
	    data8.put("Owner", "Admin Ayan Sengupta");
	    data8.put("Recruiter", "Alexei Morozov");

	    TreeMap<String, String> data9 = new TreeMap<String, String>();
	    data9.put("Email", "debasis.roy09@yopmail.com");
	    data9.put("Phone Code", "+91");
	    data9.put("Phone Number", "9876502345");
	    data9.put("First Name", "Debasis");
	    data9.put("Last Name", "Roy");
	    data9.put("Professional Profile Link", "https://www.linkedin.com/in/debasisroy09");
	    data9.put("Source", "Consultancy");
	    data9.put("Country", "India");
	    data9.put("State", "");
	    data9.put("Current Salary Currency", "INR(₹)");
	    data9.put("Current Salary", "950000");
	    data9.put("Current Salary Duration", "Yearly");
	    data9.put("Expected Salary Currency", "INR(₹)");
	    data9.put("Expected Salary", "1250000");
	    data9.put("Expected Salary Duration", "Yearly");
	    data9.put("CV/Resume", "");
	    data9.put("Skills", "");
	    data9.put("Relevant Experience", "3");
	    data9.put("Relevant Experience Unit", "Year(s)");
	    data9.put("Total Experience", "4");
	    data9.put("Total Experience Unit", "Year(s)");
	    data9.put("Notice Period", "60");
	    data9.put("Notice Period Unit", "Day(s)");
	    data9.put("Work Experience", "");
	    data9.put("Education", "");
	    data9.put("Cover Letter", "");
	    data9.put("Owner", "Alexei Morozov");
	    data9.put("Recruiter", "Guest Alexei Sokolov");

	    TreeMap<String, String> data10 = new TreeMap<String, String>();
	    data10.put("Email", "aleksei.sokolov10@yopmail.com");
	    data10.put("Phone Code", "+91");
	    data10.put("Phone Number", "9876503456");
	    data10.put("First Name", "Aleksei");
	    data10.put("Last Name", "Sokolov");
	    data10.put("Professional Profile Link", "https://www.linkedin.com/in/alekseisokolov10");
	    data10.put("Source", "Email");
	    data10.put("Country", "India");
	    data10.put("State", "");
	    data10.put("Current Salary Currency", "INR(₹)");
	    data10.put("Current Salary", "1450000");
	    data10.put("Current Salary Duration", "Yearly");
	    data10.put("Expected Salary Currency", "INR(₹)");
	    data10.put("Expected Salary", "1850000");
	    data10.put("Expected Salary Duration", "Yearly");
	    data10.put("CV/Resume", "");
	    data10.put("Skills", "");
	    data10.put("Relevant Experience", "6");
	    data10.put("Relevant Experience Unit", "Year(s)");
	    data10.put("Total Experience", "7");
	    data10.put("Total Experience Unit", "Year(s)");
	    data10.put("Notice Period", "45");
	    data10.put("Notice Period Unit", "Day(s)");
	    data10.put("Work Experience", "");
	    data10.put("Education", "");
	    data10.put("Cover Letter", "");
	    data10.put("Owner", "Guest Alexei Sokolov");
	    data10.put("Recruiter", "Interviewer Ivan Orlov");

	    TreeMap<String, String> data11 = new TreeMap<String, String>();
	    data11.put("Email", "abhishek.pal11@yopmail.com");
	    data11.put("Phone Code", "+91");
	    data11.put("Phone Number", "9876504567");
	    data11.put("First Name", "Abhishek");
	    data11.put("Last Name", "Pal");
	    data11.put("Professional Profile Link", "https://www.linkedin.com/in/abhishekpal11");
	    data11.put("Source", "Import");
	    data11.put("Country", "India");
	    data11.put("State", "");
	    data11.put("Current Salary Currency", "INR(₹)");
	    data11.put("Current Salary", "1250000");
	    data11.put("Current Salary Duration", "Yearly");
	    data11.put("Expected Salary Currency", "INR(₹)");
	    data11.put("Expected Salary", "1550000");
	    data11.put("Expected Salary Duration", "Yearly");
	    data11.put("CV/Resume", "");
	    data11.put("Skills", "");
	    data11.put("Relevant Experience", "5");
	    data11.put("Relevant Experience Unit", "Year(s)");
	    data11.put("Total Experience", "6");
	    data11.put("Total Experience Unit", "Year(s)");
	    data11.put("Notice Period", "90");
	    data11.put("Notice Period Unit", "Day(s)");
	    data11.put("Work Experience", "");
	    data11.put("Education", "");
	    data11.put("Cover Letter", "");
	    data11.put("Owner", "Interviewer Ivan Orlov");
	    data11.put("Recruiter", "Nikolai Sidorov");

	    TreeMap<String, String> data12 = new TreeMap<String, String>();
	    data12.put("Email", "sergei.petrov12@yopmail.com");
	    data12.put("Phone Code", "+91");
	    data12.put("Phone Number", "9876505678");
	    data12.put("First Name", "Sergei");
	    data12.put("Last Name", "Petrov");
	    data12.put("Professional Profile Link", "https://www.linkedin.com/in/sergeipetrov12");
	    data12.put("Source", "Indeed");
	    data12.put("Country", "India");
	    data12.put("State", "");
	    data12.put("Current Salary Currency", "INR(₹)");
	    data12.put("Current Salary", "1600000");
	    data12.put("Current Salary Duration", "Yearly");
	    data12.put("Expected Salary Currency", "INR(₹)");
	    data12.put("Expected Salary", "1950000");
	    data12.put("Expected Salary Duration", "Yearly");
	    data12.put("CV/Resume", "");
	    data12.put("Skills", "");
	    data12.put("Relevant Experience", "7");
	    data12.put("Relevant Experience Unit", "Year(s)");
	    data12.put("Total Experience", "8");
	    data12.put("Total Experience Unit", "Year(s)");
	    data12.put("Notice Period", "60");
	    data12.put("Notice Period Unit", "Day(s)");
	    data12.put("Work Experience", "");
	    data12.put("Education", "");
	    data12.put("Cover Letter", "");
	    data12.put("Owner", "Nikolai Sidorov");
	    data12.put("Recruiter", "Owner Mikhail Volkov");

	    TreeMap<String, String> data13 = new TreeMap<String, String>();
	    data13.put("Email", "ritwik.saha13@yopmail.com");
	    data13.put("Phone Code", "+91");
	    data13.put("Phone Number", "9876506789");
	    data13.put("First Name", "Ritwik");
	    data13.put("Last Name", "Saha");
	    data13.put("Professional Profile Link", "https://www.linkedin.com/in/ritwiksaha13");
	    data13.put("Source", "LinkedIn");
	    data13.put("Country", "India");
	    data13.put("State", "");
	    data13.put("Current Salary Currency", "INR(₹)");
	    data13.put("Current Salary", "1800000");
	    data13.put("Current Salary Duration", "Yearly");
	    data13.put("Expected Salary Currency", "INR(₹)");
	    data13.put("Expected Salary", "2200000");
	    data13.put("Expected Salary Duration", "Yearly");
	    data13.put("CV/Resume", "");
	    data13.put("Skills", "");
	    data13.put("Relevant Experience", "8");
	    data13.put("Relevant Experience Unit", "Year(s)");
	    data13.put("Total Experience", "9");
	    data13.put("Total Experience Unit", "Year(s)");
	    data13.put("Notice Period", "45");
	    data13.put("Notice Period Unit", "Day(s)");
	    data13.put("Work Experience", "");
	    data13.put("Education", "");
	    data13.put("Cover Letter", "");
	    data13.put("Owner", "Owner Mikhail Volkov");
	    data13.put("Recruiter", "Rahul Chatterjee");

	    TreeMap<String, String> data14 = new TreeMap<String, String>();
	    data14.put("Email", "yuri.ivanov14@yopmail.com");
	    data14.put("Phone Code", "+91");
	    data14.put("Phone Number", "9876507890");
	    data14.put("First Name", "Yuri");
	    data14.put("Last Name", "Ivanov");
	    data14.put("Professional Profile Link", "https://www.linkedin.com/in/yuriivanov14");
	    data14.put("Source", "Naukri");
	    data14.put("Country", "India");
	    data14.put("State", "");
	    data14.put("Current Salary Currency", "INR(₹)");
	    data14.put("Current Salary", "1700000");
	    data14.put("Current Salary Duration", "Yearly");
	    data14.put("Expected Salary Currency", "INR(₹)");
	    data14.put("Expected Salary", "2050000");
	    data14.put("Expected Salary Duration", "Yearly");
	    data14.put("CV/Resume", "");
	    data14.put("Skills", "");
	    data14.put("Relevant Experience", "7");
	    data14.put("Relevant Experience Unit", "Year(s)");
	    data14.put("Total Experience", "8");
	    data14.put("Total Experience Unit", "Year(s)");
	    data14.put("Notice Period", "30");
	    data14.put("Notice Period Unit", "Day(s)");
	    data14.put("Work Experience", "");
	    data14.put("Education", "");
	    data14.put("Cover Letter", "");
	    data14.put("Owner", "Rahul Chatterjee");
	    data14.put("Recruiter", "Admin Ayan Sengupta");

	    TreeMap<String, String> data15 = new TreeMap<String, String>();
	    data15.put("Email", "ritam.sen15@yopmail.com");
	    data15.put("Phone Code", "+91");
	    data15.put("Phone Number", "9876508901");
	    data15.put("First Name", "Ritam");
	    data15.put("Last Name", "Sen");
	    data15.put("Professional Profile Link", "https://www.linkedin.com/in/ritamsen15");
	    data15.put("Source", "Candidate Portal");
	    data15.put("Country", "India");
	    data15.put("State", "");
	    data15.put("Current Salary Currency", "INR(₹)");
	    data15.put("Current Salary", "1150000");
	    data15.put("Current Salary Duration", "Yearly");
	    data15.put("Expected Salary Currency", "INR(₹)");
	    data15.put("Expected Salary", "1450000");
	    data15.put("Expected Salary Duration", "Yearly");
	    data15.put("CV/Resume", "");
	    data15.put("Skills", "");
	    data15.put("Relevant Experience", "4");
	    data15.put("Relevant Experience Unit", "Year(s)");
	    data15.put("Total Experience", "5");
	    data15.put("Total Experience Unit", "Year(s)");
	    data15.put("Notice Period", "30");
	    data15.put("Notice Period Unit", "Day(s)");
	    data15.put("Work Experience", "");
	    data15.put("Education", "");
	    data15.put("Cover Letter", "");
	    data15.put("Owner", "Admin Ayan Sengupta");
	    data15.put("Recruiter", "Guest Alexei Sokolov");

	    TreeMap<String, String> data16 = new TreeMap<String, String>();
	    data16.put("Email", "dmitry.sokolin16@yopmail.com");
	    data16.put("Phone Code", "+91");
	    data16.put("Phone Number", "9876509012");
	    data16.put("First Name", "Dmitry");
	    data16.put("Last Name", "Sokolin");
	    data16.put("Professional Profile Link", "https://www.linkedin.com/in/dmitrysokolin16");
	    data16.put("Source", "Consultancy");
	    data16.put("Country", "India");
	    data16.put("State", "");
	    data16.put("Current Salary Currency", "INR(₹)");
	    data16.put("Current Salary", "1550000");
	    data16.put("Current Salary Duration", "Yearly");
	    data16.put("Expected Salary Currency", "INR(₹)");
	    data16.put("Expected Salary", "1900000");
	    data16.put("Expected Salary Duration", "Yearly");
	    data16.put("CV/Resume", "");
	    data16.put("Skills", "");
	    data16.put("Relevant Experience", "6");
	    data16.put("Relevant Experience Unit", "Year(s)");
	    data16.put("Total Experience", "7");
	    data16.put("Total Experience Unit", "Year(s)");
	    data16.put("Notice Period", "60");
	    data16.put("Notice Period Unit", "Day(s)");
	    data16.put("Work Experience", "");
	    data16.put("Education", "");
	    data16.put("Cover Letter", "");
	    data16.put("Owner", "Alexei Morozov");
	    data16.put("Recruiter", "Interviewer Ivan Orlov");

	    TreeMap<String, String> data17 = new TreeMap<String, String>();
	    data17.put("Email", "subhojit.mondal17@yopmail.com");
	    data17.put("Phone Code", "+91");
	    data17.put("Phone Number", "9876510123");
	    data17.put("First Name", "Subhojit");
	    data17.put("Last Name", "Mondal");
	    data17.put("Professional Profile Link", "https://www.linkedin.com/in/subhojitmondal17");
	    data17.put("Source", "Email");
	    data17.put("Country", "India");
	    data17.put("State", "");
	    data17.put("Current Salary Currency", "INR(₹)");
	    data17.put("Current Salary", "1450000");
	    data17.put("Current Salary Duration", "Yearly");
	    data17.put("Expected Salary Currency", "INR(₹)");
	    data17.put("Expected Salary", "1850000");
	    data17.put("Expected Salary Duration", "Yearly");
	    data17.put("CV/Resume", "");
	    data17.put("Skills", "");
	    data17.put("Relevant Experience", "6");
	    data17.put("Relevant Experience Unit", "Year(s)");
	    data17.put("Total Experience", "7");
	    data17.put("Total Experience Unit", "Year(s)");
	    data17.put("Notice Period", "45");
	    data17.put("Notice Period Unit", "Day(s)");
	    data17.put("Work Experience", "");
	    data17.put("Education", "");
	    data17.put("Cover Letter", "");
	    data17.put("Owner", "Guest Alexei Sokolov");
	    data17.put("Recruiter", "Nikolai Sidorov");

	    TreeMap<String, String> data18 = new TreeMap<String, String>();
	    data18.put("Email", "viktor.romanov18@yopmail.com");
	    data18.put("Phone Code", "+91");
	    data18.put("Phone Number", "9876511234");
	    data18.put("First Name", "Viktor");
	    data18.put("Last Name", "Romanov");
	    data18.put("Professional Profile Link", "https://www.linkedin.com/in/viktorromanov18");
	    data18.put("Source", "Import");
	    data18.put("Country", "India");
	    data18.put("State", "");
	    data18.put("Current Salary Currency", "INR(₹)");
	    data18.put("Current Salary", "1650000");
	    data18.put("Current Salary Duration", "Yearly");
	    data18.put("Expected Salary Currency", "INR(₹)");
	    data18.put("Expected Salary", "2000000");
	    data18.put("Expected Salary Duration", "Yearly");
	    data18.put("CV/Resume", "");
	    data18.put("Skills", "");
	    data18.put("Relevant Experience", "7");
	    data18.put("Relevant Experience Unit", "Year(s)");
	    data18.put("Total Experience", "8");
	    data18.put("Total Experience Unit", "Year(s)");
	    data18.put("Notice Period", "90");
	    data18.put("Notice Period Unit", "Day(s)");
	    data18.put("Work Experience", "");
	    data18.put("Education", "");
	    data18.put("Cover Letter", "");
	    data18.put("Owner", "Interviewer Ivan Orlov");
	    data18.put("Recruiter", "Owner Mikhail Volkov");

	    TreeMap<String, String> data19 = new TreeMap<String, String>();
	    data19.put("Email", "sudipta.sarkar19@yopmail.com");
	    data19.put("Phone Code", "+91");
	    data19.put("Phone Number", "9876512345");
	    data19.put("First Name", "Sudipta");
	    data19.put("Last Name", "Sarkar");
	    data19.put("Professional Profile Link", "https://www.linkedin.com/in/sudiptasarkar19");
	    data19.put("Source", "Indeed");
	    data19.put("Country", "India");
	    data19.put("State", "");
	    data19.put("Current Salary Currency", "INR(₹)");
	    data19.put("Current Salary", "1000000");
	    data19.put("Current Salary Duration", "Yearly");
	    data19.put("Expected Salary Currency", "INR(₹)");
	    data19.put("Expected Salary", "1300000");
	    data19.put("Expected Salary Duration", "Yearly");
	    data19.put("CV/Resume", "");
	    data19.put("Skills", "");
	    data19.put("Relevant Experience", "4");
	    data19.put("Relevant Experience Unit", "Year(s)");
	    data19.put("Total Experience", "5");
	    data19.put("Total Experience Unit", "Year(s)");
	    data19.put("Notice Period", "30");
	    data19.put("Notice Period Unit", "Day(s)");
	    data19.put("Work Experience", "");
	    data19.put("Education", "");
	    data19.put("Cover Letter", "");
	    data19.put("Owner", "Nikolai Sidorov");
	    data19.put("Recruiter", "Rahul Chatterjee");

	    TreeMap<String, String> data20 = new TreeMap<String, String>();
	    data20.put("Email", "maksim.belov20@yopmail.com");
	    data20.put("Phone Code", "+91");
	    data20.put("Phone Number", "9876513456");
	    data20.put("First Name", "Maksim");
	    data20.put("Last Name", "Belov");
	    data20.put("Professional Profile Link", "https://www.linkedin.com/in/maksimbelov20");
	    data20.put("Source", "LinkedIn");
	    data20.put("Country", "India");
	    data20.put("State", "");
	    data20.put("Current Salary Currency", "INR(₹)");
	    data20.put("Current Salary", "1900000");
	    data20.put("Current Salary Duration", "Yearly");
	    data20.put("Expected Salary Currency", "INR(₹)");
	    data20.put("Expected Salary", "2300000");
	    data20.put("Expected Salary Duration", "Yearly");
	    data20.put("CV/Resume", "");
	    data20.put("Skills", "");
	    data20.put("Relevant Experience", "8");
	    data20.put("Relevant Experience Unit", "Year(s)");
	    data20.put("Total Experience", "9");
	    data20.put("Total Experience Unit", "Year(s)");
	    data20.put("Notice Period", "60");
	    data20.put("Notice Period Unit", "Day(s)");
	    data20.put("Work Experience", "");
	    data20.put("Education", "");
	    data20.put("Cover Letter", "");
	    data20.put("Owner", "Owner Mikhail Volkov");
	    data20.put("Recruiter", "Admin Ayan Sengupta");

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
	            { data20 } */
	    };
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