package res;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;




import com.aventstack.extentreports.reporter.ExtentHtmlReporter;




public class ExtentTestNGBuilder extends ExtentManager {
	private static com.aventstack.extentreports.ExtentReports extent;
    private static ThreadLocal parentTest = new ThreadLocal();
    private static ThreadLocal test = new ThreadLocal();

	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.createInstance("extent.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		extent.attachReporter(htmlReporter);
	}
	
    @BeforeClass
    public synchronized void beforeClass() {
        com.aventstack.extentreports.ExtentTest parent = extent.createTest(getClass().getName());
        parentTest.set(parent);
    }

    @BeforeMethod
    public synchronized void beforeMethod(Method method) {
        com.aventstack.extentreports.ExtentTest child = ((com.aventstack.extentreports.ExtentTest) parentTest.get()).createNode(method.getName());
        test.set(child);
    }

    @AfterMethod
    public synchronized void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE)
            ((com.aventstack.extentreports.ExtentTest) test.get()).fail(result.getThrowable());
        else if (result.getStatus() == ITestResult.SKIP)
            ((com.aventstack.extentreports.ExtentTest) test.get()).skip(result.getThrowable());
        else
            ((com.aventstack.extentreports.ExtentTest) test.get()).pass("Test passed");

        extent.flush();
    }

}
