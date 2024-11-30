package listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.SneakyThrows;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static base.BaseClass.*;

public class Listener implements ITestListener {

    protected static ExtentSparkReporter sparkReporter;
    protected static ExtentReports extentReports;
    protected static ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extentReports.createTest(result.getName());
        test.log(Status.PASS, "Test case " + result.getName() + " PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extentReports.createTest(result.getName());
        test.log(Status.FAIL, "Test Case " + result.getName() + " FAILED");
        test.log(Status.FAIL, "Error " + result.getThrowable());
        test.addScreenCaptureFromPath(captureScreenshot(result.getName()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = extentReports.createTest(result.getName());
        test.log(Status.SKIP, "Test Case " + result.getName() + " SKIPPED");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/src/reports/report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        initiateProperties();
        String projectName = properties.getProperty("projectName");
        sparkReporter.config().setDocumentTitle(projectName + " Test Automation Report");
        sparkReporter.config().setReportName(projectName + " Test Report");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }

    @Override
    @SneakyThrows
    public void onFinish(ITestContext context) {
        extentReports.flush();
        try {
            Desktop.getDesktop().browse(new File(System.getProperty("user.dir") + "/src/reports/report.html").toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
