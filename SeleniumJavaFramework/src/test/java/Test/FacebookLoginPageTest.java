package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Config.PropertiesFile;
import Pages.facebookLoginPage;
import Utils.ExcelUtils;

public class FacebookLoginPageTest {

	static WebDriver driver = null;
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	public static String browserName = null;

	@DataProvider(name = "testdata1")
	public Object[][] getData() throws IOException {

		Object data[][] = testData(
				"C:\\Users\\hp\\Desktop\\Deepika\\SeleniumProject\\SeleniumJavaFramework\\TestData\\UserData.xlsx",
				"Sheet1");
		return data;

	}

	public Object[][] testData(String excelPath, String SheetName) throws IOException {

		ExcelUtils excel = new ExcelUtils(excelPath, SheetName);
		int row = excel.getRowCount();
		int col = excel.getColumnCount();

		System.out.println("row" + row);
		System.out.println("col" + col);

		Object data[][] = new Object[row-1][col];
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				//System.out.println("i" + i);
				//System.out.println("j" + j);

				String name = excel.getCellString(i, j);
				System.out.print(name + " | ");
				data[i-1][j] = name;
			}

			System.out.println();
		}
		return data;
	}

	@BeforeSuite
	public static void setUpTest() {

		htmlReporter = new ExtentHtmlReporter("TC1.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	
	@BeforeTest
	public void setUpBrowser(String browserName) throws IOException {
		PropertiesFile.getProperties();
		
		System.out.println("browser name is"+ browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\hp\\Desktop\\Deepika\\SeleniumProject\\SeleniumJavaFramework\\drivers\\chromedriver\\chromedriver.exe");

			driver = new ChromeDriver();
		}

	}

	@Test(dataProvider = "testdata1")
	public static void registerNewUser(String firstName, String LastName, String password) throws IOException {

		facebookLoginPage fbLogPge = new facebookLoginPage(driver);

		ExtentTest test = extent.createTest("TC1",
				"A new user wants to register himself and create a Facebook Account");

		test.log(Status.INFO, "Test case started executing)");

		test.info("Redirecting to the Facebook Login Page");

		driver.get("https://en-gb.facebook.com/");

		fbLogPge.enterFirstName(firstName);

		fbLogPge.enterLastName("LastName");

		fbLogPge.enterPassword("password");

		fbLogPge.enterPhoneNumber("1234567801");

		fbLogPge.dateDropDown(7);

		fbLogPge.monthDropDown(7);

		fbLogPge.yearDropDown(8);

		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		test.addScreenCaptureFromPath("screenshot.png");

	}

	@AfterTest
	public void tearDownBrowser() {

		driver.close();
		// driver.quit();

	}

	@AfterSuite
	public void tearDownTest() {

		extent.flush();

	}

}
