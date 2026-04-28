package Cucumber.Step.Definition.Java.Classes;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import Listerners.Report_Listen;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Cucumber {

	public static final ThreadLocal<WebDriver> D = new ThreadLocal<WebDriver>();
	public static WebDriver d;
	public static String Target_url;

	@Before
	public void setup(Scenario scenario) throws IOException {

		Data_Fetcher_Cucumber f = new Data_Fetcher_Cucumber();

		String Browser = System.getProperty("Browsername") != null
				? System.getProperty("Browsername")
				: f.Data_Fetcher("Browser", D.get());

		Target_url = System.getProperty("url") != null
				? System.getProperty("url")
				: f.Data_Fetcher("Url", D.get());

		Report_Listen.start_cucumber_test(scenario.getName());

		WebDriver local_d;

		if (Browser.contains("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if (Browser.contains("headless")) {
				options.addArguments("headless");
			}
			local_d = new ChromeDriver(options);

			D.set(local_d);
		}

		if (Browser.contains("Firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			if (Browser.contains("headless")) {
				options.addArguments("headless");
			}
			local_d = new FirefoxDriver(options);

			D.set(local_d);
		}

		d = D.get();
		d.manage().window().maximize();
	}

	@After
	public void Kill() {

		D.get().quit();
		Report_Listen.flush_cucumber_report();
		Report_Listen.remove_cucumber_test();
		D.remove();
	}
}