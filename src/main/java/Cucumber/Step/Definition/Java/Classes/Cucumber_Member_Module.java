package Cucumber.Step.Definition.Java.Classes;

import java.io.IOException;

import Product_Codeclouds.Project.Simplified.Member_Module;
import io.cucumber.java.en.Given;

public class Cucumber_Member_Module extends Member_Module {

	public void Bind_driver() {

		super.d = Base_Cucumber.D.get();
		super.Target_url = Base_Cucumber.Target_url;
	}

	@Given("collect all available Member names from Members settings")
	public void Collect_All_Member_Names() throws IOException, InterruptedException {

		Bind_driver();

		Member_List_Data_Collector();

		if (Member_Names.isEmpty()) {

			throw new IllegalStateException("No Member name was collected from the Members list.");
		}
	}
}
