package Cucumber.Step.Definition.Java.Classes;

import java.io.IOException;
import java.util.TreeMap;

import Product_Codeclouds.Project.Simplified.Side_menu_Handler;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class Cucumber_Side_Menu extends Side_menu_Handler {

	public void Bind_driver() {

		super.d = Base_Cucumber.D.get();
		super.Target_url = Base_Cucumber.Target_url;
	}

	@Given("open the Simplified Hire side menu option using the following feature data")
	public void Open_Side_Menu_Option_Using_Feature_Data(DataTable Data_Table)
			throws IOException, InterruptedException {

		Bind_driver();

		TreeMap<String, String> Menu_Data = new TreeMap<String, String>(Data_Table.asMap(String.class, String.class));

		String Menu_Option = Menu_Data.get("Menu Option");

		if (Menu_Option == null || Menu_Option.trim().isEmpty()) {

			throw new IllegalArgumentException("Menu Option is missing from the feature DataTable.");
		}

		Menu_option_selector(Menu_Option);
	}

	@Given("expand the Simplified Hire side menu")
	public void Expand_Simplified_Hire_Side_Menu() throws IOException, InterruptedException {

		Bind_driver();

		side_menu_expander();
	}
}
