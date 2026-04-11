package Product_Codeclouds.Project.Simplified;

import java.io.IOException;

import Locaters.Job_Module_locaters;

public class Job_Module extends Candidate_module{

	
	
	
	
	public void Access_Job_Module_List() throws IOException, InterruptedException{
		
		
		Job_Module_locaters p = new Job_Module_locaters(d);
		
		Menu_option_selector("Jobs");
		
	}
	
	
	public void Job_Add() throws IOException, InterruptedException {
		
		Job_Module_locaters p = new Job_Module_locaters(d);
		
		
		Access_Job_Module_List();
		
		
	}
}
