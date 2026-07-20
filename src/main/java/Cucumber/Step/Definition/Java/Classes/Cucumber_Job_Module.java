package Cucumber.Step.Definition.Java.Classes;

import java.awt.AWTException;
import java.io.IOException;
import java.util.TreeMap;

import Product_Codeclouds.Project.Simplified.Job_Module;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class Cucumber_Job_Module extends Job_Module {

	public void Bind_driver() {

		super.d = Base_Cucumber.D.get();
		super.Target_url = Base_Cucumber.Target_url;
	}

	@Given("add Job using the following feature data")
	public void Add_Job_Using_Feature_Data(DataTable Data_Table)
			throws IOException, InterruptedException, AWTException {

		Bind_driver();

		TreeMap<String, String> Job_Data = new TreeMap<String, String>(Data_Table.asMap(String.class, String.class));

		Job_Add(Job_Data);
	}

	@Given("fetch total Active Jobs count from Jobs module")
	public void Fetch_Total_Active_Jobs_Count() throws IOException, InterruptedException {

		Bind_driver();

		String Active_Job_Count = Active_Job_count_fetcher();

		if (Active_Job_Count == null || Active_Job_Count.trim().isEmpty()) {

			throw new IllegalStateException("Active Jobs count was not returned.");
		}
	}
}
