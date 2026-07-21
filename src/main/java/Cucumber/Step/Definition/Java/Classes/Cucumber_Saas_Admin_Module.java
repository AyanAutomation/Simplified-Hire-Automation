package Cucumber.Step.Definition.Java.Classes;

import java.awt.AWTException;
import java.io.IOException;
import java.util.TreeMap;

import Product_Codeclouds.Project.Simplified.Saas_Admin_Module;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Cucumber_Saas_Admin_Module extends Saas_Admin_Module {

	private TreeMap<String, String> Upgrade_Account_Data;

	public void Bind_driver() {

		super.d = Base_Cucumber.D.get();
		super.Target_url = Base_Cucumber.Target_url;
	}

	@Given("login to SaaS Admin portal")
	public void Login_To_Saas_Admin() throws IOException, InterruptedException {

		Bind_driver();

		Saas_Admin_Login();
	}

	@Given("create SaaS Admin draft account using the following feature data")
	public void Create_Draft_Account_Using_Feature_Data(DataTable Data_Table) throws IOException, InterruptedException {

		Bind_driver();

		TreeMap<String, String> Account_Data = new TreeMap<String, String>(Data_Table.asMap(String.class, String.class));

		Draft_Account_Create(Account_Data);
	}

	@Given("create SaaS Admin account using the following feature data")
	public void Create_Account_Using_Feature_Data(DataTable Data_Table) throws IOException, InterruptedException {

		Bind_driver();

		TreeMap<String, String> Account_Data = new TreeMap<String, String>(Data_Table.asMap(String.class, String.class));

		Account_create(Account_Data);
	}

	@Given("verify SaaS Admin account using the following feature data")
	public void Verify_Account_Using_Feature_Data(DataTable Data_Table) throws IOException, InterruptedException {

		Bind_driver();

		TreeMap<String, String> Account_Data = new TreeMap<String, String>(Data_Table.asMap(String.class, String.class));

		check_for_added_Account(Account_Data);
	}

	@Given("delete SaaS Admin lead using the following feature data")
	public void Delete_Lead_Using_Feature_Data(DataTable Data_Table) throws IOException, InterruptedException {

		Bind_driver();

		TreeMap<String, String> Contact_Form_Data = new TreeMap<String, String>(Data_Table.asMap(String.class, String.class));

		Leads_Delete(Contact_Form_Data);
	}

	@Given("approve SaaS Admin lead using the following feature data")
	public void Approve_Lead_Using_Feature_Data(DataTable Data_Table)throws IOException, InterruptedException, AWTException {

		Bind_driver();

		TreeMap<String, String> Plan_Data = new TreeMap<String, String>(Data_Table.asMap(String.class, String.class));

		Leads_Approve(Plan_Data);
	}

	@Given("SaaS Admin account upgrade data is provided from the feature file")
	public void Store_Upgrade_Account_Data(DataTable Data_Table) {

		Bind_driver();

		Upgrade_Account_Data = new TreeMap<String, String>(Data_Table.asMap(String.class, String.class));
	}

	
	@When("the SaaS Admin account plan is upgraded using the following billing feature data")
	public void Upgrade_Account_Plan_Using_Feature_Data(DataTable Data_Table) throws IOException, InterruptedException {

		if (Upgrade_Account_Data == null) {

			throw new IllegalStateException("Account feature data was not prepared before plan upgrade.");
		}

		TreeMap<String, String> Billing_Data = new TreeMap<String, String>(Data_Table.asMap(String.class, String.class));

		String Target_Upgrade_Plan_Name = Upgrade_Account_Data.get("Plan Name");

		Quick_Plan_Upgrade_Several_times(Upgrade_Account_Data, Upgrade_Account_Data, Billing_Data,Target_Upgrade_Plan_Name);
	}
	

	@Given("activate SaaS Admin account using the following feature data")
	public void Activate_Account_Using_Feature_Data(DataTable Data_Table) throws IOException, InterruptedException {

		Bind_driver();

		TreeMap<String, String> Account_Data = new TreeMap<String, String>(Data_Table.asMap(String.class, String.class));

		Account_Activator(Account_Data, 1);
	}
}
