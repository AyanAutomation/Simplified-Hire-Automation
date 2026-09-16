package Cucumber.Step.Definition.Java.Classes;

import java.awt.AWTException;
import java.io.IOException;
import java.util.TreeMap;

import Product_Codeclouds.Project.Simplified.Book_A_Demo_form_fillup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Cucumber_Book_A_Demo extends Book_A_Demo_form_fillup {

	private TreeMap<String, String> Form_Data;
	private TreeMap<String, String> Plan_Data;
	private TreeMap<String, String> Upgrade_Billing_Data;
	private TreeMap<String, String> Account_Data;

	public void Bind_driver() {

		super.d = Base_Cucumber.D.get();
		super.Target_url = Base_Cucumber.Target_url;
	}

	@Given("Book a Demo form data is provided from the feature file")
	public void Store_Book_A_Demo_Form_Data(DataTable Data_Table) {

		Bind_driver();

		Form_Data = new TreeMap<String, String>(Data_Table.asMap(String.class, String.class));
	}

	@Given("Book a Demo lead plan data is provided from the feature file")
	public void Store_Book_A_Demo_Plan_Data(DataTable Data_Table) {

		Plan_Data = new TreeMap<String, String>(Data_Table.asMap(String.class, String.class));
	}

	@Given("Book a Demo upgrade billing data is provided from the feature file")
	public void Store_Book_A_Demo_Billing_Data(DataTable Data_Table) {

		Upgrade_Billing_Data = new TreeMap<String, String>(Data_Table.asMap(String.class, String.class));
	}

	@Given("Book a Demo account data is provided from the feature file")
	public void Store_Book_A_Demo_Account_Data(DataTable Data_Table) {

		Account_Data = new TreeMap<String, String>(Data_Table.asMap(String.class, String.class));
	}

	@When("the Book a Demo end to end flow is executed")
	public void Execute_Book_A_Demo_Flow() throws IOException, InterruptedException, AWTException {

		if (Form_Data == null || Plan_Data == null || Upgrade_Billing_Data == null || Account_Data == null) {

			throw new IllegalStateException("Book a Demo feature data was not prepared completely.");
		}

		book_a_demo_form_fillup(Form_Data, Plan_Data, Upgrade_Billing_Data, Account_Data);
	}
}
