package Cucumber.Step.Definition.Java.Classes;

import java.awt.AWTException;
import java.io.IOException;
import java.util.TreeMap;

import Product_Codeclouds.Project.Simplified.Candidate_module;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Cucumber_Candidate_Module extends Candidate_module {

	private TreeMap<String, String> Candidate_Data;

	public void Bind_driver() {

		super.d = Base_Cucumber.D.get();
		super.Target_url = Base_Cucumber.Target_url;
	}

	@Given("search Candidate using the following feature data")
	public void Search_Candidate_Using_Feature_Data(DataTable Data_Table) throws IOException, InterruptedException {

		Bind_driver();

		TreeMap<String, String> Search_Data = new TreeMap<String, String>(Data_Table.asMap(String.class, String.class));

		Search_Check(Search_Data);
	}

	@Given("Candidate Add data is provided from the feature file")
	public void Store_Candidate_Add_Data(DataTable Data_Table) {

		Bind_driver();

		Candidate_Data = new TreeMap<String, String>(Data_Table.asMap(String.class, String.class));
	}

	@When("the Candidate is added using the following Job feature data")
	public void Add_Candidate_Using_Feature_Data(DataTable Data_Table)
			throws IOException, InterruptedException, AWTException {

		if (Candidate_Data == null) {

			throw new IllegalStateException("Candidate feature data was not prepared before Job assignment.");
		}

		TreeMap<String, String> Job_Data = new TreeMap<String, String>(Data_Table.asMap(String.class, String.class));

		Add_Candidate(Candidate_Data, Job_Data);
	}

	@Given("schedule Candidate interview using the following feature data")
	public void Schedule_Interview_Using_Feature_Data(DataTable Data_Table) throws IOException, InterruptedException {

		Bind_driver();

		TreeMap<String, String> Interview_Data = new TreeMap<String, String>(Data_Table.asMap(String.class, String.class));

		Candidate_Interview_scheduling(Interview_Data);
	}

	@Given("upload Candidate CV using the following feature data")
	public void Upload_Candidate_CV_Using_Feature_Data(DataTable Data_Table) throws IOException, InterruptedException {

		Bind_driver();

		TreeMap<String, String> CV_Data = new TreeMap<String, String>(Data_Table.asMap(String.class, String.class));

		String File_Path = CV_Data.get("File Path");

		if (File_Path != null && File_Path.startsWith("${user.dir}")) {

			CV_Data.put("File Path", System.getProperty("user.dir") + File_Path.substring("${user.dir}".length()));
		}

		CV_upload(CV_Data);
	}

	@Given("fetch total Candidate count from Candidate module")
	public void Fetch_Total_Candidate_Count() throws IOException, InterruptedException, AWTException {

		Bind_driver();

		Total_Candidate_Count_Fetcher(1);
	}
}
