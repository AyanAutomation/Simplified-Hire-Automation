package Listerners;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Report.Reports;

public class Report_Listen extends Reports implements ITestListener {

	public static ExtentReports report = new Reports().Get_reports();
	public static final ThreadLocal<ExtentTest> log_report = new ThreadLocal<ExtentTest>();

	public static ExtentTest log_print_in_report() {

		return log_report.get();
	}

	// For Cucumber zone
	public static void start_cucumber_test(String scenario_name) {

		log_report.set(report.createTest(scenario_name));
	}

	// For Cucumber zone
	public static void flush_cucumber_report() {

		report.flush();
	}

	public static void remove_cucumber_test() {

		log_report.remove();
	}

	@Override
	public void onTestStart(ITestResult result) {

		String Test_Method_name = result.getMethod().getMethodName();
		log_report.set(report.createTest(Test_Method_name));
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		log_report.get().log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		log_report.get().log(Status.FAIL, result.getThrowable());

		try {

			Object testClassObject = result.getInstance();
			Class<?> testClass = testClassObject.getClass();

			Field driverField = null;

			while (testClass != null) {

				try {
					driverField = testClass.getDeclaredField("d");
					break;
				} catch (NoSuchFieldException e) {
					testClass = testClass.getSuperclass();
				}
			}

			driverField.setAccessible(true);
			WebDriver d = (WebDriver) driverField.get(testClassObject);

			String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
			String screenshotFolder = System.getProperty("user.dir") + File.separator + "Screenshot";

			File folder = new File(screenshotFolder);

			if (!folder.exists()) {
				folder.mkdirs();
			}

			String screenshotPath = screenshotFolder + File.separator
					+ result.getMethod().getMethodName() + "_" + timestamp + ".png";

			File source = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
			File destination = new File(screenshotPath);

			source.renameTo(destination);

			log_report.get().addScreenCaptureFromPath(screenshotPath);

		} catch (Exception e) {

			log_report.get().log(Status.WARNING, "Screenshot capture failed: " + e.getMessage());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {

		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {

		ITestListener.super.onFinish(context);
		report.flush();
	}
}