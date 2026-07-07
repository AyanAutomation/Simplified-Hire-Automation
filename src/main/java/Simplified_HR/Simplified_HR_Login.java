package Simplified_HR;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Candidate_Module_Locaters;
import Locaters.Side_menu_locaters;
import Product_Codeclouds.Project.Simplified.Side_menu_Handler;
import Repeatative_codes.Repeat;
import Simplified_HR_Locaters.Simplified_Hr_Master_Locaters;

public class Simplified_HR_Login extends Side_menu_Handler{
	
	
	@Test(dataProvider = "User_Create_Data")
	public void Simplified_Hr_User_Add(TreeMap<String, String> user_data) throws IOException, InterruptedException {
		
		Simplified_Hr_Master_Locaters p = new Simplified_Hr_Master_Locaters(d);
		Repeat rp = new Repeat(d);
		Candidate_Module_Locaters ca = new Candidate_Module_Locaters(d);
		
		String First_Name = user_data.get("First Name");
		String Middle_Name = user_data.get("Middle Name");
		String Last_Name = user_data.get("Last Name");

		String Personal_Email = user_data.get("Personal Email");

		String Phone_Country_Code = user_data.get("Phone Country Code");
		String Phone_Number = user_data.get("Phone Number");

		String Mobile_Country_Code = user_data.get("Mobile Country Code");
		String Mobile_Number = user_data.get("Mobile Number");

		String Location = user_data.get("Location");
		String Employment_Type = user_data.get("Employment Type");
		String Work_Week = user_data.get("Work Week");
		String Date_Of_Joining = user_data.get("Date of Joining");
		String Job_Title = user_data.get("Job Title");

		String Work_Email = user_data.get("Work Email");

		String Work_Country_Code = user_data.get("Work Country Code");
		String Work_Number = user_data.get("Work Number");

		String Role = user_data.get("Role");
		String Permission_Group = user_data.get("Permission Group");
		
		Menu_option_selector("Control Center","Users");
		WebElement Add = p.Add_Member_button();
		Add.click();
		p.form();
		Thread.sleep(800);
		List<WebElement> Form_dropdowns =p.dropdowns();	
		p.first_name().sendKeys(First_Name);
		p.middle_name().sendKeys(Middle_Name);
		p.last_name().sendKeys(Last_Name);
		WebElement Emp_Type_dropdown = Form_dropdowns.get(1);
		Emp_Type_dropdown.click();
		p.emp_type_input().sendKeys(Employment_Type);
		WebElement Employment_Type_dropdown_list = ca.Source_Dropdown();
		Thread.sleep(800);
		rp.movetoelement(Employment_Type_dropdown_list);
		Employment_Type_dropdown_list.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"))
				.stream().filter(owneropt -> owneropt.getText().trim().equalsIgnoreCase(Employment_Type)).findFirst()
				.ifPresent(WebElement::click);/*
		WebElement Job_Title_dropdown = p.Job_Title_field();
		Job_Title_dropdown.click();
		p.job_title_input().sendKeys(Job_Title);
		WebElement Job_Title_dropdown_list = ca.state_Dropdown();
		Thread.sleep(800);
		rp.movetoelement(Job_Title_dropdown_list);

		Job_Title_dropdown_list.findElements(By.xpath(".//div[contains(@class,'ant-select-item ant-select-item-option')]"))
				.stream().filter(owneropt -> owneropt.getText().trim().equalsIgnoreCase(Job_Title)).findFirst()
				.ifPresent(WebElement::click); */
		//ChromeDriver
		p.Personal_mail().sendKeys(Personal_Email);
		p.Phone_Number_field().sendKeys(Phone_Number);
		p.Mobile_Number_fied().sendKeys(Mobile_Number);
		p.Work_number_field().sendKeys(Work_Number);
		WebElement Work_Mail_field = p.work_email();
		Work_Mail_field.sendKeys(Work_Email);
		WebElement Save_Button_Below =p.Save_Invite_Button();
	 // rp.Scroll_to_element(Save_Button_Below);
	     Save_Button_Below.click();
	     WebElement Toast = p.Toast();
		 String Toast_text = Toast.getText().trim();
		 Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Actual:</b> Account draft save action completed. Toast message = " + Toast_text);
		 System.out.println("✅ Actual: Account draft save action completed. Toast message = " + Toast_text);
		 System.out.println();
		// p.Toast_close_Button().click();
		 p.Add_Member_button();
		
		
	}
	
	
@DataProvider
public Object[][] User_Create_Data() {

	TreeMap<String, String> data1 = new TreeMap<String, String>();
	data1.put("First Name", "Grigory");
	data1.put("Middle Name", "Pavelovich");
	data1.put("Last Name", "Melnikov");
	data1.put("Personal Email", "grigory.pavelovich.melnikov.personal041@yopmail.com");
	data1.put("Phone Country Code", "+7");
	data1.put("Phone Number", "9256841730");
	data1.put("Mobile Country Code", "+7");
	data1.put("Mobile Number", "9167384925");
	data1.put("Location", "Moscow Business Center");
	data1.put("Employment Type", "Full-Time");
	data1.put("Work Week", "Monday - Friday");
	data1.put("Date of Joining", "05/01/2026");
	data1.put("Job Title", "Military Officer");
	data1.put("Work Email", "grigory.melnikov.work041@yopmail.com");
	data1.put("Work Country Code", "+7");
	data1.put("Work Number", "9037468291");
	data1.put("Role", "Admin");
	data1.put("Permission Group", "Military Admin Group");

	TreeMap<String, String> data2 = new TreeMap<String, String>();
	data2.put("First Name", "Marianne");
	data2.put("Middle Name", "Lucille");
	data2.put("Last Name", "Perrault");
	data2.put("Personal Email", "marianne.lucille.perrault.personal042@yopmail.com");
	data2.put("Phone Country Code", "+33");
	data2.put("Phone Number", "756918243");
	data2.put("Mobile Country Code", "+33");
	data2.put("Mobile Number", "742635819");
	data2.put("Location", "Moscow Business Center");
	data2.put("Employment Type", "Part-Time");
	data2.put("Work Week", "Tuesday - Saturday");
	data2.put("Date of Joining", "05/03/2026");
	data2.put("Job Title", "Forensic Investigator");
	data2.put("Work Email", "marianne.perrault.work042@yopmail.com");
	data2.put("Work Country Code", "+33");
	data2.put("Work Number", "768421935");
	data2.put("Role", "Guest");
	data2.put("Permission Group", "Investigation Guest Group");

	TreeMap<String, String> data3 = new TreeMap<String, String>();
	data3.put("First Name", "Ivan");
	data3.put("Middle Name", "Nikolayevich");
	data3.put("Last Name", "Belyaev");
	data3.put("Personal Email", "ivan.nikolayevich.belyaev.personal043@yopmail.com");
	data3.put("Phone Country Code", "+7");
	data3.put("Phone Number", "9046815723");
	data3.put("Mobile Country Code", "+7");
	data3.put("Mobile Number", "9293748165");
	data3.put("Location", "Moscow Business Center");
	data3.put("Employment Type", "Full-Time");
	data3.put("Work Week", "Monday - Saturday");
	data3.put("Date of Joining", "05/05/2026");
	data3.put("Job Title", "Government Policy Advisor");
	data3.put("Work Email", "ivan.belyaev.work043@yopmail.com");
	data3.put("Work Country Code", "+7");
	data3.put("Work Number", "9165829473");
	data3.put("Role", "Manager");
	data3.put("Permission Group", "Policy Manager Group");

	TreeMap<String, String> data4 = new TreeMap<String, String>();
	data4.put("First Name", "Giada");
	data4.put("Middle Name", "Vittoria");
	data4.put("Last Name", "Santoro");
	data4.put("Personal Email", "giada.vittoria.santoro.personal044@yopmail.com");
	data4.put("Phone Country Code", "+39");
	data4.put("Phone Number", "3516849270");
	data4.put("Mobile Country Code", "+39");
	data4.put("Mobile Number", "3479265814");
	data4.put("Location", "Moscow Business Center");
	data4.put("Employment Type", "Full-Time");
	data4.put("Work Week", "Monday - Friday");
	data4.put("Date of Joining", "05/07/2026");
	data4.put("Job Title", "Intelligence Analyst");
	data4.put("Work Email", "giada.santoro.work044@yopmail.com");
	data4.put("Work Country Code", "+39");
	data4.put("Work Number", "3496718253");
	data4.put("Role", "User");
	data4.put("Permission Group", "Intelligence User Group");

	TreeMap<String, String> data5 = new TreeMap<String, String>();
	data5.put("First Name", "Hugo");
	data5.put("Middle Name", "Jasper");
	data5.put("Last Name", "Whitfield");
	data5.put("Personal Email", "hugo.jasper.whitfield.personal045@yopmail.com");
	data5.put("Phone Country Code", "+44");
	data5.put("Phone Number", "7482916350");
	data5.put("Mobile Country Code", "+44");
	data5.put("Mobile Number", "7526381940");
	data5.put("Location", "Moscow Business Center");
	data5.put("Employment Type", "Full-Time");
	data5.put("Work Week", "Monday - Friday");
	data5.put("Date of Joining", "05/09/2026");
	data5.put("Job Title", "Cybersecurity Specialist");
	data5.put("Work Email", "hugo.whitfield.work045@yopmail.com");
	data5.put("Work Country Code", "+44");
	data5.put("Work Number", "7716384925");
	data5.put("Role", "Admin");
	data5.put("Permission Group", "Cybersecurity Admin Group");

	TreeMap<String, String> data6 = new TreeMap<String, String>();
	data6.put("First Name", "Anouk");
	data6.put("Middle Name", "Frederike");
	data6.put("Last Name", "Maas");
	data6.put("Personal Email", "anouk.frederike.maas.personal046@yopmail.com");
	data6.put("Phone Country Code", "+31");
	data6.put("Phone Number", "641572938");
	data6.put("Mobile Country Code", "+31");
	data6.put("Mobile Number", "653819472");
	data6.put("Location", "Moscow Business Center");
	data6.put("Employment Type", "Part-Time");
	data6.put("Work Week", "Monday - Thursday");
	data6.put("Date of Joining", "05/11/2026");
	data6.put("Job Title", "Military Officer");
	data6.put("Work Email", "anouk.maas.work046@yopmail.com");
	data6.put("Work Country Code", "+31");
	data6.put("Work Number", "682749135");
	data6.put("Role", "Guest");
	data6.put("Permission Group", "Military Guest Group");

	TreeMap<String, String> data7 = new TreeMap<String, String>();
	data7.put("First Name", "Artyom");
	data7.put("Middle Name", "Leonidovich");
	data7.put("Last Name", "Sidorov");
	data7.put("Personal Email", "artyom.leonidovich.sidorov.personal047@yopmail.com");
	data7.put("Phone Country Code", "+7");
	data7.put("Phone Number", "9162847359");
	data7.put("Mobile Country Code", "+7");
	data7.put("Mobile Number", "9257391846");
	data7.put("Location", "Moscow Business Center");
	data7.put("Employment Type", "Full-Time");
	data7.put("Work Week", "Monday - Friday");
	data7.put("Date of Joining", "05/13/2026");
	data7.put("Job Title", "Forensic Investigator");
	data7.put("Work Email", "artyom.sidorov.work047@yopmail.com");
	data7.put("Work Country Code", "+7");
	data7.put("Work Number", "9048265713");
	data7.put("Role", "Manager");
	data7.put("Permission Group", "Investigation Manager Group");

	TreeMap<String, String> data8 = new TreeMap<String, String>();
	data8.put("First Name", "Franziska");
	data8.put("Middle Name", "Helene");
	data8.put("Last Name", "Lenz");
	data8.put("Personal Email", "franziska.helene.lenz.personal048@yopmail.com");
	data8.put("Phone Country Code", "+49");
	data8.put("Phone Number", "15168492730");
	data8.put("Mobile Country Code", "+49");
	data8.put("Mobile Number", "17649283510");
	data8.put("Location", "Moscow Business Center");
	data8.put("Employment Type", "Part-Time");
	data8.put("Work Week", "Tuesday - Saturday");
	data8.put("Date of Joining", "05/15/2026");
	data8.put("Job Title", "Government Policy Advisor");
	data8.put("Work Email", "franziska.lenz.work048@yopmail.com");
	data8.put("Work Country Code", "+49");
	data8.put("Work Number", "15972846310");
	data8.put("Role", "User");
	data8.put("Permission Group", "Policy User Group");

	TreeMap<String, String> data9 = new TreeMap<String, String>();
	data9.put("First Name", "Polina");
	data9.put("Middle Name", "Viktorovna");
	data9.put("Last Name", "Krylova");
	data9.put("Personal Email", "polina.viktorovna.krylova.personal049@yopmail.com");
	data9.put("Phone Country Code", "+7");
	data9.put("Phone Number", "9296184735");
	data9.put("Mobile Country Code", "+7");
	data9.put("Mobile Number", "9164738295");
	data9.put("Location", "Moscow Business Center");
	data9.put("Employment Type", "Full-Time");
	data9.put("Work Week", "Monday - Friday");
	data9.put("Date of Joining", "05/17/2026");
	data9.put("Job Title", "Intelligence Analyst");
	data9.put("Work Email", "polina.krylova.work049@yopmail.com");
	data9.put("Work Country Code", "+7");
	data9.put("Work Number", "9039284617");
	data9.put("Role", "Admin");
	data9.put("Permission Group", "Intelligence Admin Group");

	TreeMap<String, String> data10 = new TreeMap<String, String>();
	data10.put("First Name", "Emil");
	data10.put("Middle Name", "Gustav");
	data10.put("Last Name", "Lindgren");
	data10.put("Personal Email", "emil.gustav.lindgren.personal050@yopmail.com");
	data10.put("Phone Country Code", "+46");
	data10.put("Phone Number", "736481925");
	data10.put("Mobile Country Code", "+46");
	data10.put("Mobile Number", "721594836");
	data10.put("Location", "Moscow Business Center");
	data10.put("Employment Type", "Full-Time");
	data10.put("Work Week", "Monday - Friday");
	data10.put("Date of Joining", "05/19/2026");
	data10.put("Job Title", "Cybersecurity Specialist");
	data10.put("Work Email", "emil.lindgren.work050@yopmail.com");
	data10.put("Work Country Code", "+46");
	data10.put("Work Number", "734682915");
	data10.put("Role", "Guest");
	data10.put("Permission Group", "Cybersecurity Guest Group");

	TreeMap<String, String> data11 = new TreeMap<String, String>();
	data11.put("First Name", "Renata");
	data11.put("Middle Name", "Valerievna");
	data11.put("Last Name", "Novikova");
	data11.put("Personal Email", "renata.valerievna.novikova.personal051@yopmail.com");
	data11.put("Phone Country Code", "+7");
	data11.put("Phone Number", "9156847329");
	data11.put("Mobile Country Code", "+7");
	data11.put("Mobile Number", "9297561843");
	data11.put("Location", "Moscow Business Center");
	data11.put("Employment Type", "Full-Time");
	data11.put("Work Week", "Monday - Saturday");
	data11.put("Date of Joining", "05/21/2026");
	data11.put("Job Title", "Military Officer");
	data11.put("Work Email", "renata.novikova.work051@yopmail.com");
	data11.put("Work Country Code", "+7");
	data11.put("Work Number", "9046172835");
	data11.put("Role", "Manager");
	data11.put("Permission Group", "Military Manager Group");

	TreeMap<String, String> data12 = new TreeMap<String, String>();
	data12.put("First Name", "Adrien");
	data12.put("Middle Name", "Philippe");
	data12.put("Last Name", "Couturier");
	data12.put("Personal Email", "adrien.philippe.couturier.personal052@yopmail.com");
	data12.put("Phone Country Code", "+33");
	data12.put("Phone Number", "741592863");
	data12.put("Mobile Country Code", "+33");
	data12.put("Mobile Number", "756318492");
	data12.put("Location", "Moscow Business Center");
	data12.put("Employment Type", "Part-Time");
	data12.put("Work Week", "Tuesday - Saturday");
	data12.put("Date of Joining", "05/23/2026");
	data12.put("Job Title", "Forensic Investigator");
	data12.put("Work Email", "adrien.couturier.work052@yopmail.com");
	data12.put("Work Country Code", "+33");
	data12.put("Work Number", "762849315");
	data12.put("Role", "User");
	data12.put("Permission Group", "Investigation User Group");

	TreeMap<String, String> data13 = new TreeMap<String, String>();
	data13.put("First Name", "Stanislav");
	data13.put("Middle Name", "Olegovich");
	data13.put("Last Name", "Mironov");
	data13.put("Personal Email", "stanislav.olegovich.mironov.personal053@yopmail.com");
	data13.put("Phone Country Code", "+7");
	data13.put("Phone Number", "9265841730");
	data13.put("Mobile Country Code", "+7");
	data13.put("Mobile Number", "9037485261");
	data13.put("Location", "Moscow Business Center");
	data13.put("Employment Type", "Full-Time");
	data13.put("Work Week", "Monday - Friday");
	data13.put("Date of Joining", "05/25/2026");
	data13.put("Job Title", "Government Policy Advisor");
	data13.put("Work Email", "stanislav.mironov.work053@yopmail.com");
	data13.put("Work Country Code", "+7");
	data13.put("Work Number", "9164937285");
	data13.put("Role", "Admin");
	data13.put("Permission Group", "Policy Admin Group");

	TreeMap<String, String> data14 = new TreeMap<String, String>();
	data14.put("First Name", "Kristine");
	data14.put("Middle Name", "Amalie");
	data14.put("Last Name", "Poulsen");
	data14.put("Personal Email", "kristine.amalie.poulsen.personal054@yopmail.com");
	data14.put("Phone Country Code", "+45");
	data14.put("Phone Number", "29641873");
	data14.put("Mobile Country Code", "+45");
	data14.put("Mobile Number", "31857246");
	data14.put("Location", "Moscow Business Center");
	data14.put("Employment Type", "Part-Time");
	data14.put("Work Week", "Monday - Thursday");
	data14.put("Date of Joining", "05/27/2026");
	data14.put("Job Title", "Intelligence Analyst");
	data14.put("Work Email", "kristine.poulsen.work054@yopmail.com");
	data14.put("Work Country Code", "+45");
	data14.put("Work Number", "28476931");
	data14.put("Role", "Guest");
	data14.put("Permission Group", "Intelligence Guest Group");

	TreeMap<String, String> data15 = new TreeMap<String, String>();
	data15.put("First Name", "Ilya");
	data15.put("Middle Name", "Dmitrievich");
	data15.put("Last Name", "Kozlov");
	data15.put("Personal Email", "ilya.dmitrievich.kozlov.personal055@yopmail.com");
	data15.put("Phone Country Code", "+7");
	data15.put("Phone Number", "9048627351");
	data15.put("Mobile Country Code", "+7");
	data15.put("Mobile Number", "9256147893");
	data15.put("Location", "Moscow Business Center");
	data15.put("Employment Type", "Full-Time");
	data15.put("Work Week", "Monday - Friday");
	data15.put("Date of Joining", "05/29/2026");
	data15.put("Job Title", "Cybersecurity Specialist");
	data15.put("Work Email", "ilya.kozlov.work055@yopmail.com");
	data15.put("Work Country Code", "+7");
	data15.put("Work Number", "9167293845");
	data15.put("Role", "Manager");
	data15.put("Permission Group", "Cybersecurity Manager Group");

	TreeMap<String, String> data16 = new TreeMap<String, String>();
	data16.put("First Name", "Lucia");
	data16.put("Middle Name", "Beatrice");
	data16.put("Last Name", "Esposito");
	data16.put("Personal Email", "lucia.beatrice.esposito.personal056@yopmail.com");
	data16.put("Phone Country Code", "+39");
	data16.put("Phone Number", "3519276840");
	data16.put("Mobile Country Code", "+39");
	data16.put("Mobile Number", "3475182963");
	data16.put("Location", "Moscow Business Center");
	data16.put("Employment Type", "Full-Time");
	data16.put("Work Week", "Monday - Friday");
	data16.put("Date of Joining", "05/31/2026");
	data16.put("Job Title", "Military Officer");
	data16.put("Work Email", "lucia.esposito.work056@yopmail.com");
	data16.put("Work Country Code", "+39");
	data16.put("Work Number", "3497285163");
	data16.put("Role", "User");
	data16.put("Permission Group", "Military User Group");

	TreeMap<String, String> data17 = new TreeMap<String, String>();
	data17.put("First Name", "Timofey");
	data17.put("Middle Name", "Andreevich");
	data17.put("Last Name", "Abramov");
	data17.put("Personal Email", "timofey.andreevich.abramov.personal057@yopmail.com");
	data17.put("Phone Country Code", "+7");
	data17.put("Phone Number", "9036847291");
	data17.put("Mobile Country Code", "+7");
	data17.put("Mobile Number", "9295184736");
	data17.put("Location", "Moscow Business Center");
	data17.put("Employment Type", "Part-Time");
	data17.put("Work Week", "Tuesday - Saturday");
	data17.put("Date of Joining", "06/02/2026");
	data17.put("Job Title", "Forensic Investigator");
	data17.put("Work Email", "timofey.abramov.work057@yopmail.com");
	data17.put("Work Country Code", "+7");
	data17.put("Work Number", "9163845729");
	data17.put("Role", "Admin");
	data17.put("Permission Group", "Investigation Admin Group");

	TreeMap<String, String> data18 = new TreeMap<String, String>();
	data18.put("First Name", "Clara");
	data18.put("Middle Name", "Elise");
	data18.put("Last Name", "Wagner");
	data18.put("Personal Email", "clara.elise.wagner.personal058@yopmail.com");
	data18.put("Phone Country Code", "+43");
	data18.put("Phone Number", "6762948153");
	data18.put("Mobile Country Code", "+43");
	data18.put("Mobile Number", "6647382915");
	data18.put("Location", "Moscow Business Center");
	data18.put("Employment Type", "Full-Time");
	data18.put("Work Week", "Monday - Friday");
	data18.put("Date of Joining", "06/04/2026");
	data18.put("Job Title", "Government Policy Advisor");
	data18.put("Work Email", "clara.wagner.work058@yopmail.com");
	data18.put("Work Country Code", "+43");
	data18.put("Work Number", "6775819246");
	data18.put("Role", "Guest");
	data18.put("Permission Group", "Policy Guest Group");

	TreeMap<String, String> data19 = new TreeMap<String, String>();
	data19.put("First Name", "Galina");
	data19.put("Middle Name", "Borisovna");
	data19.put("Last Name", "Osipova");
	data19.put("Personal Email", "galina.borisovna.osipova.personal059@yopmail.com");
	data19.put("Phone Country Code", "+7");
	data19.put("Phone Number", "9294738165");
	data19.put("Mobile Country Code", "+7");
	data19.put("Mobile Number", "9165284937");
	data19.put("Location", "Moscow Business Center");
	data19.put("Employment Type", "Full-Time");
	data19.put("Work Week", "Monday - Friday");
	data19.put("Date of Joining", "06/06/2026");
	data19.put("Job Title", "Intelligence Analyst");
	data19.put("Work Email", "galina.osipova.work059@yopmail.com");
	data19.put("Work Country Code", "+7");
	data19.put("Work Number", "9047352816");
	data19.put("Role", "Manager");
	data19.put("Permission Group", "Intelligence Manager Group");

	TreeMap<String, String> data20 = new TreeMap<String, String>();
	data20.put("First Name", "Nicolas");
	data20.put("Middle Name", "Baptiste");
	data20.put("Last Name", "Charpentier");
	data20.put("Personal Email", "nicolas.baptiste.charpentier.personal060@yopmail.com");
	data20.put("Phone Country Code", "+33");
	data20.put("Phone Number", "763582941");
	data20.put("Mobile Country Code", "+33");
	data20.put("Mobile Number", "746129835");
	data20.put("Location", "Moscow Business Center");
	data20.put("Employment Type", "Full-Time");
	data20.put("Work Week", "Monday - Friday");
	data20.put("Date of Joining", "06/08/2026");
	data20.put("Job Title", "Cybersecurity Specialist");
	data20.put("Work Email", "nicolas.charpentier.work060@yopmail.com");
	data20.put("Work Country Code", "+33");
	data20.put("Work Number", "752941863");
	data20.put("Role", "User");
	data20.put("Permission Group", "Cybersecurity User Group");

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
	
	
	public void Menu_option_selector(String opt_text, String suboption) throws IOException, InterruptedException {

		Simplified_Hr_Master_Locaters p = new Simplified_Hr_Master_Locaters(d);
		Repeat rp = new Repeat(d);

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🔹 Scenario Title:</b> Select required side menu option in Simplified Hire");
		System.out.println();
		System.out.println("🔹 Scenario Title: Select required side menu option in Simplified Hire");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📘 Description:</b> Access the Simplified Hire dashboard, open the side menu, fetch all available menu options, search for the required option, and click on it.");
		System.out.println(
				"📘 Description: Access the Simplified Hire dashboard, open the side menu, fetch all available menu options, search for the required option, and click on it.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📥 Input:</b> Required Side Menu Option = " + opt_text);
		System.out.println("📥 Input: Required Side Menu Option = " + opt_text);
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>✅ Expected:</b> User should be able to access the Simplified Hire dashboard, fetch all visible side menu options successfully, and click the required side menu option.");
		System.out.println(
				"✅ Expected: User should be able to access the Simplified Hire dashboard, fetch all visible side menu options successfully, and click the required side menu option.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step 1:</b> Access Simplified Hire dashboard before working with side menu.");
		System.out.println("Step 1: Access Simplified Hire dashboard before working with side menu.");
		System.out.println();
	try {
			p.Side_menu();
		} catch (Exception mm) { 
			Simplified_Apps_Accessor(0);
			p.Side_menu();
	}

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Simplified Hire dashboard accessed successfully.");
		System.out.println("🟨 Actual: Simplified Hire dashboard accessed successfully.");
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step 2:</b> Open side menu and fetch all available menu options.");
		System.out.println("Step 2: Open side menu and fetch all available menu options.");
		System.out.println();
        p.Side_menu();
        Thread.sleep(800);
      WebElement second_menu_section= p.Menu_section_two();
		List<WebElement> menu_options = second_menu_section.findElements(By.xpath(".//li"));

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Side menu options fetched successfully. Total menu options found = " + menu_options.size());
		System.out.println("🟨 Actual: Side menu options fetched successfully. Total menu options found = " + menu_options.size());
		System.out.println();

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step 3:</b> Search for side menu option = " + opt_text + " and click on it.");
		System.out.println("Step 3: Search for side menu option = " + opt_text + " and click on it.");
		System.out.println();
		if (opt_text.contains("Control Center")) {
			for(WebElement menu_option:menu_options) {
			String text = menu_option.getText().trim();
			if(text.contains(opt_text)) {
			rp.movetoelement(menu_option);
			WebElement sub_menu = p.First_Submenu();
			rp.movetoelement(sub_menu);
			List<WebElement> submenu_options = sub_menu.findElements(By.xpath(".//li"));
			for(WebElement submenu_option:submenu_options) {
			String subtext = submenu_option.getText().trim();
			if(subtext.contains(suboption)) {
				submenu_option.click();
				break;
			}
			}
			}
			}
			
		}
		
		

	}

}
