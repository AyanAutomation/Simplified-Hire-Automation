package Report;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class Reports {

	public ExtentReports Get_reports() {

		String Report_Folder_Path = System.getProperty("user.dir") + File.separator + "Report_folder";
		String Main_Report_Path = Report_Folder_Path + File.separator + "report.html";
		String Failed_Report_Path = Report_Folder_Path + File.separator + "failed-tests.html";
		String Execution_Time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm:ss a"));

		File Report_Directory = new File(Report_Folder_Path);
		Report_Directory.mkdirs();

		String Custom_CSS =
				"body { font-family: 'Segoe UI', Arial, sans-serif; letter-spacing: 0.1px; } " +
				".nav-wrapper { background: linear-gradient(90deg, #111827 0%, #164e63 50%, #0f766e 100%); box-shadow: 0 8px 24px rgba(0, 0, 0, 0.30); } " +
				".brand-logo { font-weight: 700 !important; letter-spacing: 0.4px; } " +
				".card, .card-panel { border-radius: 14px !important; box-shadow: 0 8px 24px rgba(0, 0, 0, 0.20) !important; overflow: hidden; } " +
				".test-item { border-radius: 12px !important; margin-bottom: 12px !important; border-left-width: 5px !important; box-shadow: 0 5px 16px rgba(0, 0, 0, 0.16); } " +
				".test-content, .test-detail { border-radius: 12px !important; } " +
				".badge { min-width: 72px; border-radius: 20px !important; padding: 5px 12px !important; font-size: 12px !important; font-weight: 700 !important; letter-spacing: 0.3px; } " +
				".badge.pass-bg, .pass-bg { background: linear-gradient(135deg, #16a34a, #22c55e) !important; color: #ffffff !important; } " +
				".badge.fail-bg, .fail-bg { background: linear-gradient(135deg, #dc2626, #ef4444) !important; color: #ffffff !important; } " +
				".badge.skip-bg, .skip-bg { background: linear-gradient(135deg, #d97706, #f59e0b) !important; color: #ffffff !important; } " +
				".badge.warning-bg, .warning-bg { background: linear-gradient(135deg, #ca8a04, #eab308) !important; color: #111827 !important; } " +
				".badge.info-bg, .info-bg { background: linear-gradient(135deg, #0284c7, #38bdf8) !important; color: #ffffff !important; } " +
				".status.pass { color: #22c55e !important; font-weight: 700; } " +
				".status.fail { color: #ef4444 !important; font-weight: 700; } " +
				".status.skip { color: #f59e0b !important; font-weight: 700; } " +
				".table { border-radius: 10px; overflow: hidden; } " +
				".table thead { background: rgba(14, 116, 144, 0.25); font-weight: 700; } " +
				".table tbody tr:hover { background: rgba(56, 189, 248, 0.08); transition: background 0.2s ease; } " +
				".details { line-height: 1.65; } " +
				".exception-message { border-radius: 8px; padding: 10px; background: rgba(239, 68, 68, 0.10); } " +
				".system-view .card-panel { border-top: 4px solid #06b6d4; } " +
				".dashboard-view .card-panel { border-top: 4px solid #22c55e; } " +
				"a { transition: opacity 0.2s ease; } " +
				"a:hover { opacity: 0.82; } " +
				"::-webkit-scrollbar { width: 10px; height: 10px; } " +
				"::-webkit-scrollbar-track { background: #111827; } " +
				"::-webkit-scrollbar-thumb { background: linear-gradient(#0891b2, #0f766e); border-radius: 10px; } " +
				"::-webkit-scrollbar-thumb:hover { background: linear-gradient(#06b6d4, #14b8a6); }";

		ExtentSparkReporter spark = new ExtentSparkReporter(Main_Report_Path);
		spark.config().setReportName("Simplified Automation Execution Dashboard");
		spark.config().setDocumentTitle("Simplified QA Automation Report");
		spark.config().setTheme(Theme.DARK);
		spark.config().setEncoding("UTF-8");
		spark.config().setTimeStampFormat("dd MMM yyyy, hh:mm:ss a");
		spark.config().setTimelineEnabled(true);
		spark.config().setCss(Custom_CSS);
		spark.config().enableOfflineMode(true);
		spark.viewConfigurer().viewOrder().as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY, ViewName.AUTHOR, ViewName.DEVICE, ViewName.EXCEPTION, ViewName.LOG }).apply();

		ExtentSparkReporter failedSpark = new ExtentSparkReporter(Failed_Report_Path).filter().statusFilter().as(new Status[] { Status.FAIL }).apply();
		failedSpark.config().setReportName("Simplified Failed Test Dashboard");
		failedSpark.config().setDocumentTitle("Simplified Failed Automation Tests");
		failedSpark.config().setTheme(Theme.DARK);
		failedSpark.config().setEncoding("UTF-8");
		failedSpark.config().setTimeStampFormat("dd MMM yyyy, hh:mm:ss a");
		failedSpark.config().setTimelineEnabled(true);
		failedSpark.config().setCss(Custom_CSS);
		failedSpark.config().enableOfflineMode(true);
		failedSpark.viewConfigurer().viewOrder().as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.EXCEPTION, ViewName.LOG }).apply();

		ExtentReports report = new ExtentReports();
		report.attachReporter(spark, failedSpark);

		report.setSystemInfo("Project", "Simplified");
		report.setSystemInfo("Automated By", "Ayan Sengupta");
		report.setSystemInfo("Framework", "Selenium + TestNG + Cucumber + ExtentReports");
		report.setSystemInfo("Report Type", "Automation Execution Report");
		report.setSystemInfo("Execution Started", Execution_Time);
		report.setSystemInfo("Environment", System.getProperty("Environment", "Not Provided"));
		report.setSystemInfo("Browser", System.getProperty("Browser", "Not Provided"));
		report.setSystemInfo("Operating System", System.getProperty("os.name"));
		report.setSystemInfo("OS Architecture", System.getProperty("os.arch"));
		report.setSystemInfo("Java Version", System.getProperty("java.version"));
		report.setSystemInfo("User Name", System.getProperty("user.name"));

		return report;
	}
}