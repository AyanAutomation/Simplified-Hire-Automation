package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Locaters.Login_Locaters;


@Listeners(Listerners.Report_Listen.class)
public class Login extends Base{
	
	
    @Test
	public void login() throws IOException{
		
	Login_Locaters lg = new Login_Locaters(d);	
	Data_Reader f = new Data_Reader();
		
	d.get(Target_url);
	lg.id_field().sendKeys(f.Data_Fetcher("Login_id"));	
	lg.password_field().sendKeys(f.Data_Fetcher("Pass"));	
	lg.password_eye_button().click();
	lg.Login_button().click();
	lg.login_confirmation();	
	}

}
