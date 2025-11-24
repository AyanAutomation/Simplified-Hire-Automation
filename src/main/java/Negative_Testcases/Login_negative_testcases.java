package Negative_Testcases;

import java.io.IOException;
import java.util.TreeMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Enterprise_Codeclouds.Project.Enterprise.Data_Reader;
import Enterprise_Codeclouds.Project.Enterprise.Login;
import Locaters.Login_Locaters;
@Listeners(Listerners.Report_Listen.class)
public class Login_negative_testcases extends Login{
	
	
	@Test
	public void login_validation(TreeMap<String,String> val) throws InterruptedException, IOException{
		
		Login_Locaters l = new Login_Locaters(d);

		d.get(Target_url);
	    l.Login_button().click();
		Thread.sleep(800);
		l.id_field().sendKeys(val.get("id"));
		l.Login_button().click();
		Thread.sleep(800);
		l.id_field().clear();
		l.password_field().sendKeys(val.get("pass"));
		l.Login_button().click();
		Thread.sleep(800);
		l.password_field().clear();
		l.id_field().sendKeys(val.get("id"));
		l.password_field().sendKeys(val.get("pass"));
		l.Login_button().click();
		Thread.sleep(800);
	}
	

	@DataProvider
	public Object[][] login_datas() throws IOException{
		
		Data_Reader f = new Data_Reader();
		
		TreeMap<String,String> lg1 = new TreeMap<String,String>();
		lg1.put("id", f.Data_Fetcher("Login_id"));
		lg1.put("pass", "22355");
		TreeMap<String,String> lg2 = new TreeMap<String,String>();
		lg2.put("id", "aknnnb202@bm.com");
		lg2.put("pass", f.Data_Fetcher("Pass"));
		TreeMap<String,String> lg3 = new TreeMap<String,String>();
		lg3.put("id", "aknnnb202@bm.com");
		lg3.put("pass", "4455m235");

		
		return new Object[][] {{lg1},{lg2},{lg3}};
		}
	
	
	
	

}
