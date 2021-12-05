package com.Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.ObjectRepository.UserRepository;

public class UserPage extends UserRepository{
	WebDriver driver;
	
	public UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public String Heading() {
		String act =  OnUserpage.getText();
		String Exp = "Java By Kiran";
		System.out.println(Exp);
		return Exp;
	}

	public boolean ColumnTitle() {
		ArrayList<String> ColumnTitle = new ArrayList<String>();
		List<WebElement> CTitle = NoOfColumn;
		for (WebElement wb : CTitle) {
			String Text = wb.getText();
			ColumnTitle.add(Text);
		}
		ArrayList<String> ExpTitle = new ArrayList<String>();
		ExpTitle.add("#");
		ExpTitle.add("Username");
		ExpTitle.add("Email");
		ExpTitle.add("Mobile");
		ExpTitle.add("Course");
		ExpTitle.add("Gender");
		ExpTitle.add("State");
		ExpTitle.add("Action");
		if (ColumnTitle.equals(ExpTitle)) {
			System.out.println("Column title is matching.");
			return true;
		} else {
			System.out.println("Column title is not matching.");
			return false;
		}
	}

	public long StateSelected() {
		List<WebElement> actState = NoOfState;
		String Exp = "Maharashtra";
		System.out.println(Exp);
		int count = actState.size();
		return count;
	}
	public String AlertHandle() throws Exception {
		driver.findElement(By.linkText("Delete")).click();
		driver.switchTo().alert().getText();
		Thread.sleep(3000);
		String Text = driver.switchTo().alert().getText();
		String ExpText = "You can not delete Default User";
		driver.switchTo().alert().accept();
		System.out.println(Text);
		return ExpText;
	}

	public boolean ListTitle() {
		String actText = driver.findElement(By.xpath("//h3")).getText();
		String expText = "User List";
		if (actText.equals(expText)) {
			System.out.println("BoxHeader text is matching.");
			return true;
		} else {
			System.out.println("BoxHeader text is not matching.");
			return false;
		}
	}
		/*public boolean TotalMaleUsers() {

			List<WebElement> genderList = driver.findElements(By.xpath("//tr//td[6]"));
			List<WebElement> userList = driver.findElements(By.xpath("//tr//td[2]"));
			
			ArrayList<String> actList = new ArrayList<String>();
			actList.add("Kiran");
			actList.add("Sagar");
			
			ArrayList<String> expList = new ArrayList<String>();
			
			for (int i = 0 ; i<genderList.size();i++) {
				if(genderList.get(i).getText().contentEquals("Male"));
				String name = userList.get(i).getText();
				System.out.println(name);
				expList.add(name);
				}
			if(actList.equals(expList)) {
				System.out.println(" matching Male users");
				return true;
			}else {
				System.out.println("Not matching Male users ");
				return false;
			}
			}
		
		/*public boolean TotalFemaleUsers() throws Exception {
			List<WebElement> genderList = driver.findElements(By.xpath("//tr//td[6]"));
			List<WebElement> userList = driver.findElements(By.xpath("//tr//td[2]"));

			ArrayList<WebElement> expList = new ArrayList<WebElement>();
			
			DataFormatter df = new DataFormatter();
			FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\CoursesList.xls");
            Workbook wb = WorkbookFactory.create(fi);
            Sheet sh = wb.getSheet("FemaleUsers");
            int count = sh.getLastRowNum();
            
            for(int i=0; i<=count ; i++) {
            	Cell cell = sh.getRow(i).getCell(0);
            	String text = df.formatCellValue(cell);
            	expList.add(Text);
            }
			ArrayList<String> actList = new ArrayList<String>();
			for(int i =0;i<genderList.size();i++) {
				if(genderList.get(i).getText().equals("Female")) {
					String text = userList.get(i).getText();
					actList.add(text);
				}
			}
			if (actList.equals(expList)) {
				System.out.println("matched Female users");
				return true;
			} else {
				System.out.println("Not matched Female users");
		
			return false;
		}
		}*/
		/*public boolean TotalGmailUsers() {
			List<WebElement> gmail = driver.findElements(By.xpath("//tr//td[3]"));
			ArrayList<String> actusers = new ArrayList<String>();
			actusers.add("kiran@gmail.com");
			actusers.add("sagar@gmail.com");
			actusers.add("monica@gmail.com");
			actusers.add("kimaya@gmail.com");
			
			ArrayList<String> expusers= new ArrayList<String>();
			
			for(int i=0; i < gmail.size(); i++) {
				if (gmail.get(i).getText().contains("@gmail.com"));
				String name = gmail.get(i).getText();	
			     expusers.add(name);
		}
			if (actusers.equals(expusers)) {
				System.out.println("users having correct mail");
				return true;
			}else {
				System.out.println("users having incorrect mail");
				return false;
			}
		}*/
		
		public boolean CheckMobileNo() throws Exception {

			ArrayList<String> actList = new ArrayList<String>();

			List<WebElement> users = driver.findElements(By.xpath("//tr//td[2]"));
			List<WebElement> mobile = driver.findElements(By.xpath("//tr//td[4]"));
			
			for(int i=0; i<mobile.size();i++ ) {
				String mb = mobile.get(i).getText();
				char[] c = mb.toCharArray();
				int lenght = c.length;
				
				if(lenght<10) {
					String text = users.get(i).getText();
					actList.add(text);
				}
			}
			ArrayList<String> expList = new ArrayList<String>();
			expList.add("Sagar");
			expList.add("Kimaya");
			
			System.out.println("incorrect mobile no: " + actList);
			
			if (actList.equals(expList)) {
				System.out.println("correct mobile no.");
				return true;
			} else {
				System.out.println("incorrect mobile no");
			return false;
		}
		}
	/*public boolean GetHomepageUrl() throws Exception {
		HomeUrl.click();;
		String WindowText = Text.getText();
		Thread.sleep(3000);
		String ExpText = "Certified Software Developer";
		if (WindowText.equals(ExpText)) {
			System.out.println("correct Text Display");
			return true;
		} else {
			System.out.println("incorrect Text");
		return false;
	}
}*/
	public AddUserPage clickOnAddUser() {
		driver.findElement(By.xpath("//button[text()='Add User']")).click();
		return new AddUserPage(driver);
	}

	public ArrayList<String> data(String filePath, String SheetName, int refColNumber, int OutputColNumber, String txt)
			throws Exception {
		ArrayList<String> expList = new ArrayList<String>();

		DataFormatter df = new DataFormatter();

		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();

		for (int i = 0; i <= count; i++) {

			Cell cell = sh.getRow(i).getCell(refColNumber);
			String text = df.formatCellValue(cell);

			if (text.contains(txt)) {
				Cell cell1 = sh.getRow(i).getCell(OutputColNumber);
				String text1 = df.formatCellValue(cell1);
				System.out.println(text1);
				expList.add(text1);
			}
		}
		return expList;
	}

}
