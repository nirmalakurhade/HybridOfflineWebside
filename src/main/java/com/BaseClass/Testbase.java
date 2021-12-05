package com.BaseClass;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.Pages.LoginPage;
import com.Utility.PropertiesUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Testbase {
	WebDriver driver;
	public LoginPage lp;
	public PropertiesUtils pu = null;
	public static ExtentReports report;
	public static ExtentSparkReporter spark;
	private Logger log = Logger.getLogger(Testbase.class);

	public WebDriver Initialization() {

		log.info("opening a new chrome browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		
		return driver;
	}

	public void  ExtentReportInitialization(){
		
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/target/Reports/ExtentReport.html");
		report = new ExtentReports();
		report.setSystemInfo("Host Name", "Nirmala.jbk");
		report.setSystemInfo("Environment", "Test Automation");
		report.attachReporter(spark);
	}
	
	//public void ReadExcel() {
		// FileInputStream fis = new FileInputStream("Test.xls");
		// Workbook workbook = Workbook.getWorkbook(fis);
		// Sheet sheet = workbook.getSheet(0);

		// int columns = sheet.getColumns();

		// System.out.println("rows >> " +rows);
		// System.out.println("columns >> " +columns);

		// Cell cell =sheet.getCell(1, 2);
		// String val = cell.getContents();
		// System.out.println("val >> " +val);
	
}