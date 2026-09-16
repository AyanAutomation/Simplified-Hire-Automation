package Cucumber.Step.Definition.Java.Classes;

import java.awt.AWTException;
import java.io.IOException;

import Product_Codeclouds.Project.Simplified.Reports_Module;
import io.cucumber.java.en.Given;

public class Cucumber_Reports_Module extends Reports_Module {

	public void Bind_driver() {

		super.d = Base_Cucumber.D.get();
		super.Target_url = Base_Cucumber.Target_url;
	}

	@Given("validate Reports Open Jobs count against Jobs module Active Jobs count")
	public void Validate_Reports_Open_Jobs_Count() throws IOException, InterruptedException, AWTException {

		Bind_driver();

		Open_Job_Count_of_Report_Check();
	}

	@Given("validate Reports Rejected Candidates count against Candidate module Declined count")
	public void Validate_Reports_Rejected_Candidates_Count() throws IOException, InterruptedException, AWTException {

		Bind_driver();

		Rejected_Candidate_Count_of_Report_Check();
	}

	@Given("validate Reports Upcoming Interviews count against Calendar events")
	public void Validate_Reports_Upcoming_Interviews_Count() throws IOException, InterruptedException {

		Bind_driver();

		upcoming_interview_count_check();
	}
}
