package Product_Codeclouds.Project.Simplified;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Listeners;


import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Login_Locaters;
import Repeatative_codes.Repeat;

@Listeners(Listerners.Report_Listen.class)
public class Login extends Base {

public void login() throws IOException {

    int step = 1;

    Login_Locaters lg = new Login_Locaters(d);
    Data_Reader f = new Data_Reader();
    Repeat rp = new Repeat(d);

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>🔹 Scenario Title:</b> Login with valid configured credentials and enter company portal");
    System.out.println();
    System.out.println("🔹 Scenario Title: Login with valid configured credentials and enter company portal");
    System.out.println();

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>📘 Description:</b> Open the application URL, wait until login page is loaded, enter configured credentials, verify password visibility interaction, click Login button, and validate successful entry into the company portal either through company selection flow or direct landing flow.");
    System.out.println("📘 Description: Open the application URL, wait until login page is loaded, enter configured credentials, verify password visibility interaction, click Login button, and validate successful entry into the company portal either through company selection flow or direct landing flow.");
    System.out.println();

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>📥 Input:</b> Target URL = " + Target_url
                    + " | Login ID = " + f.Data_Fetcher("Login_id")
                    + " | Password = " + f.Data_Fetcher("Pass"));
    System.out.println("📥 Input: Target URL = " + Target_url
            + " | Login ID = " + f.Data_Fetcher("Login_id")
            + " | Password = " + f.Data_Fetcher("Pass"));
    System.out.println();

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>✅ Expected:</b> Application should open successfully, login page should load properly, credentials should be accepted, password eye icon should be clickable, login should succeed, and user should enter the company portal either through company selection or direct landing.");
    System.out.println("✅ Expected: Application should open successfully, login page should load properly, credentials should be accepted, password eye icon should be clickable, login should succeed, and user should enter the company portal either through company selection or direct landing.");
    System.out.println();

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Open target application URL and wait until login page is loaded.");
    System.out.println("Step " + (step - 1) + ": Open target application URL and wait until login page is loaded.");
    System.out.println();

    d.get(Target_url);

    try {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(d)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(driver -> {
            lg.Landed_in_login_page();
            return true;
        });

    } catch (Exception e) {

        Report_Listen.log_print_in_report().log(Status.WARNING,
                "<b>⚠ Retry:</b> Initial wait for login page load failed. Retrying the same operation again.");
        System.out.println("⚠ Retry: Initial wait for login page load failed. Retrying the same operation again.");
        System.out.println();

        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(d)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(driver -> {
            lg.Landed_in_login_page();
            return true;
        });
    }

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>🟨 Actual:</b> Application URL opened successfully and login page loaded = " + Target_url);
    System.out.println("🟨 Actual: Application URL opened successfully and login page loaded = " + Target_url);
    System.out.println();

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Enter Login ID into the login field.");
    System.out.println("Step " + (step - 1) + ": Enter Login ID into the login field.");
    System.out.println();

    try {
        WebElement id_field_initial = lg.id_field();
        rp.movetoelement(id_field_initial);
        id_field_initial.click();
        id_field_initial.sendKeys(f.Data_Fetcher("Login_id"));

    } catch (StaleElementReferenceException e) {

        Report_Listen.log_print_in_report().log(Status.WARNING,
                "<b>⚠ Retry:</b> Login ID field became stale. Refetching the element and retrying the operation.");
        System.out.println("⚠ Retry: Login ID field became stale. Refetching the element and retrying the operation.");
        System.out.println();

        WebElement id_field_refetched = lg.id_field();
        rp.movetoelement(id_field_refetched);
        id_field_refetched.click();
        id_field_refetched.sendKeys(f.Data_Fetcher("Login_id"));
    }

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>🟨 Actual:</b> Login ID entered successfully = " + f.Data_Fetcher("Login_id"));
    System.out.println("🟨 Actual: Login ID entered successfully = " + f.Data_Fetcher("Login_id"));
    System.out.println();

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Enter Password into the password field.");
    System.out.println("Step " + (step - 1) + ": Enter Password into the password field.");
    System.out.println();

    lg.password_field().sendKeys(f.Data_Fetcher("Pass"));

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>🟨 Actual:</b> Password entered successfully.");
    System.out.println("🟨 Actual: Password entered successfully.");
    System.out.println();

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Click password eye icon to verify password visibility functionality.");
    System.out.println("Step " + (step - 1) + ": Click password eye icon to verify password visibility functionality.");
    System.out.println();

    lg.password_eye_button().click();

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>🟨 Actual:</b> Password eye icon clicked successfully.");
    System.out.println("🟨 Actual: Password eye icon clicked successfully.");
    System.out.println();

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Click on Login button.");
    System.out.println("Step " + (step - 1) + ": Click on Login button.");
    System.out.println();

    lg.Login_button().click();

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>🟨 Actual:</b> Login button clicked successfully.");
    System.out.println("🟨 Actual: Login button clicked successfully.");
    System.out.println();

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Validate post-login flow and enter the company portal.");
    System.out.println("Step " + (step - 1) + ": Validate post-login flow and enter the company portal.");
    System.out.println();

    try {
        lg.login_confirmation();

        Report_Listen.log_print_in_report().log(Status.INFO,
                "<b>🟨 Actual:</b> Initial login confirmation validated successfully. Company selection flow is available.");
        System.out.println("🟨 Actual: Initial login confirmation validated successfully. Company selection flow is available.");
        System.out.println();

        Report_Listen.log_print_in_report().log(Status.INFO,
                "<b>Step " + (step++) + ":</b> Identify company option from the company selection screen and move to it.");
        System.out.println("Step " + (step - 1) + ": Identify company option from the company selection screen and move to it.");
        System.out.println();

        WebElement company_option = lg.Company_selection();
        rp.movetoelement(company_option);

        Report_Listen.log_print_in_report().log(Status.INFO,
                "<b>🟨 Actual:</b> Company option identified and move action performed successfully.");
        System.out.println("🟨 Actual: Company option identified and move action performed successfully.");
        System.out.println();

        Report_Listen.log_print_in_report().log(Status.INFO,
                "<b>Step " + (step++) + ":</b> Click on the company option to enter the company portal.");
        System.out.println("Step " + (step - 1) + ": Click on the company option to enter the company portal.");
        System.out.println();

        company_option.click();

        Report_Listen.log_print_in_report().log(Status.INFO,
                "<b>🟨 Actual:</b> Company option clicked successfully.");
        System.out.println("🟨 Actual: Company option clicked successfully.");
        System.out.println();

        Report_Listen.log_print_in_report().log(Status.INFO,
                "<b>Step " + (step++) + ":</b> Wait for the company option loader to disappear.");
        System.out.println("Step " + (step - 1) + ": Wait for the company option loader to disappear.");
        System.out.println();

        WebElement loader = lg.company_option_loader();
        rp.wait_for_invisibilty_of_theElement(loader);

        Report_Listen.log_print_in_report().log(Status.INFO,
                "<b>🟨 Actual:</b> Company option loader disappeared successfully.");
        System.out.println("🟨 Actual: Company option loader disappeared successfully.");
        System.out.println();

        Report_Listen.log_print_in_report().log(Status.INFO,
                "<b>Step " + (step++) + ":</b> Validate successful login inside the company portal after company selection.");
        System.out.println("Step " + (step - 1) + ": Validate successful login inside the company portal after company selection.");
        System.out.println();

        lg.login_confirmation_inside_company_portal();

        Report_Listen.log_print_in_report().log(Status.PASS,
                "<b>🟨 Actual:</b> User entered successfully inside the company portal through company selection flow and login confirmation was validated.");
        System.out.println("🟨 Actual: User entered successfully inside the company portal through company selection flow and login confirmation was validated.");
        System.out.println();

    } catch (Exception e) {

        Report_Listen.log_print_in_report().log(Status.WARNING,
                "<b>⚠ Fallback:</b> Company selection flow was not displayed or not completed. Verifying whether the user was directly redirected into the company portal.");
        System.out.println("⚠ Fallback: Company selection flow was not displayed or not completed. Verifying whether the user was directly redirected into the company portal.");
        System.out.println();

        Report_Listen.log_print_in_report().log(Status.INFO,
                "<b>Step " + (step++) + ":</b> Validate direct landing inside the company portal.");
        System.out.println("Step " + (step - 1) + ": Validate direct landing inside the company portal.");
        System.out.println();

        lg.login_confirmation_inside_company_portal();

        Report_Listen.log_print_in_report().log(Status.PASS,
                "<b>🟨 Actual:</b> User was directly redirected and entered successfully inside the company portal without needing company selection.");
        System.out.println("🟨 Actual: User was directly redirected and entered successfully inside the company portal without needing company selection.");
        System.out.println();
    }

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>📌 Final Status:</b> Login flow completed successfully for URL = " + Target_url);
    System.out.println("📌 Final Status: Login flow completed successfully for URL = " + Target_url);
    System.out.println();

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>🔗 URL:</b> " + Target_url);
    System.out.println("🔗 URL: " + Target_url);
    System.out.println();
}
}
