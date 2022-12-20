package genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener {
	ExtentTest extentTest;
	ExtentReports extentReports;

	public void onTestStart(ITestResult result) {
		extentTest = extentReports.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, result.getMethod().getMethodName() + " got passed");
	}

	public void onTestFailure(ITestResult result) {
		String path = BaseClassZoo.takeScreenshot(result.getMethod().getMethodName());
		extentTest.log(Status.FAIL, result.getMethod().getMethodName() + " got failed");
		extentTest.log(Status.FAIL, result.getThrowable());
		extentTest.addScreenCaptureFromPath(path);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./ExtentReports/zooManage.html");
		extentSparkReporter.config().setDocumentTitle("Zoo Management");
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);

		extentReports.setSystemInfo("Browser", "Chrome");
		extentReports.setSystemInfo("Build", "10.3.2");
		extentReports.setSystemInfo("Reporter Name", "Sravan");
		extentReports.setSystemInfo("Environment", "Developer");

	}

	public void onFinish(ITestContext context) {
		extentReports.flush();
	}

	public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP, result.getMethod().getMethodName()+ " got skipped");
	}

}
