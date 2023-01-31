package com.demo.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.demo.testrailIntegration.APIClient;
import com.demo.testrailIntegration.APIException;

public class BasePage {

	//Testrail Configuration
    public static String TEST_RUN_ID                = "6";
    public static String TESTRAIL_USERNAME          = "batch08dec@gmail.com";
    public static String TESTRAIL_PASSWORD          = "469tLerrijFv10Xyq2ZB";
    public static String RAILS_ENGINE_URL           = "https://demowebshopautomation.testrail.io/";// testrail API
    public static final int TEST_CASE_PASSED_STATUS = 1;
    public static final int TEST_CASE_FAILED_STATUS = 5;

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public static ExtentHtmlReporter htmlreport = new ExtentHtmlReporter("ExtentReport" + returnUniqueDate() + ".html");
	public static ExtentReports reports = new ExtentReports();

	// This is the object of extentTest class, by which log is generate.
	public static ExtentTest testlog;
	static {
		prop = new Properties();
		// to read the file
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resources\\configs\\data.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(prop);
		reports.attachReporter(htmlreport);

		// Customize Report property
		htmlreport.config().setReportName("UI Test Automation Report");
		reports.setSystemInfo("Host Name", "Windows 10");
		reports.setSystemInfo("Environment", "QA- Automation Testing");
		reports.setSystemInfo("User Name", "RamyaKumari");
		reports.setSystemInfo("browser", "Chrome");
		reports.setSystemInfo("Site url", prop.getProperty("prodenvurl"));
		htmlreport.config().setDocumentTitle("Automation Report");
		htmlreport.config().setTestViewChartLocation(ChartLocation.TOP);

		// Two default theme of report
		htmlreport.config().setTheme(Theme.STANDARD);
	}

	public static String returnUniqueDate() {
		DateFormat dateformat = new SimpleDateFormat("ddMMyyyyHHmmss");
		Date date = new Date();
		return dateformat.format(date);
	}

	public static String getTitle() {
		return driver.getTitle();
	}

	public static void setUp() {
		// create an instance for Chrome Driver
		driver = new ChromeDriver();
		// Navigate to site url
		driver.get(prop.getProperty("prodenvurl"));
		// Maximize the Browser
		driver.manage().window().maximize();
	}
	public static void setUp(String url) {
		// create an instance for Chrome Driver
		driver = new ChromeDriver();
		// Navigate to site url
		driver.get(url);
		// Maximize the Browser
		driver.manage().window().maximize();
	}

	/*
	 * re-usable methods
	 */
	/*
	 * click on button, link, partial link, checkbox, radio button
	 */
	public static void click(By locator) {
		driver.findElement(locator).click();
	}

	public static void submit(By locator) {
		driver.findElement(locator).submit();
	}

	/*
	 * type data into text fields
	 */
//	@AfterMethod
//	public void getResult(ITestResult result) throws Exception {
//		if (result.getStatus() == ITestResult.FAILURE) {
//			testlog.log(Status.FAIL,
//					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
//			testlog.log(Status.FAIL,
//					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
//			File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			BufferedImage img = ImageIO.read(screen);
//			File filetest = Paths.get(".").toAbsolutePath().normalize().toFile();
//			ImageIO.write(img, "png", new File(filetest + "\\Screenshots\\" + "Test01.png"));
//			testlog.info("Details of " + "Test screenshot", MediaEntityBuilder
//					.createScreenCaptureFromPath(System.getProperty("user.dir") + "\\Screenshots\\" + "Test01.png")
//					.build());
//		} else if (result.getStatus() == ITestResult.SKIP) {
//			// testlog.log(Status.SKIP, "Test Case Skipped is "+result.getName());
//			testlog.log(Status.SKIP,
//					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
//		}
//	}

	public static void type(By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}

	public static void addResultForTestCase(String testCaseId, int status, String error)
			throws IOException, APIException {
		String testRunId = TEST_RUN_ID;// 10
		APIClient client = new APIClient(RAILS_ENGINE_URL);// url of the testrail
		client.setUser(TESTRAIL_USERNAME); // testrail email
		client.setPassword(TESTRAIL_PASSWORD); // testrail password
		Map data = new HashMap();
		data.put("status_id", status);
		data.put("comment", error);
		client.sendPost("add_result_for_case/" + testRunId + "/" + testCaseId + "", data);
	}
	/*
	 * Assertions
	 * 
	 */

	public void testLogPass(String value) {
		testlog.log(Status.PASS, value);
	}

	public void testLogFail(String value) {
		testlog.log(Status.FAIL, value);
	}

	public void testLogError(String value) {
		testlog.log(Status.ERROR, value);
	}

	public void assertEqual(String expected, String actual) {
		//Assert.assertEquals(expected, actual);
	}

	public void assertTrue(boolean istrue) {
	//	Assert.assertTrue(istrue);
	}

	public static void getText(By h1) {
	}

	public static void waitForAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public static void waitForElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
}
