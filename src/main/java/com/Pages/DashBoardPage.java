package com.Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.ObjectRepository.DashRepository;

public class DashBoardPage extends DashRepository {
  WebDriver driver;
  public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
  public long TotalinnerBox() {
  	 List<WebElement> Boxlist = driver.findElements(By.xpath("//div[@class=\"inner\"]"));
  	 int Boxcount = Boxlist.size();
	return Boxcount;
     }
 
  public String DashboardPage() {
 	 String login =  DashBoard.getText();
 	 String Exp ="Java By Kiran";
	return Exp;
  }
   
  public boolean TotalCourses() {
 	 ArrayList<String>actCourses = new ArrayList<String>();
 	 actCourses.add("Selenium");
 	 actCourses.add("Java / J2EE");
 	 actCourses.add("Python");
 	 actCourses.add("Php");
 	 
 	 ArrayList<String>ExpCourses = new ArrayList<String>();
 	 List<WebElement> list = Courses;
 	 for(WebElement wb : list) {
 		String text = wb.getText();
 		ExpCourses.add(text);
 	 }
	return true;
  }
  
 public long TotalMoreInfoLink() {
 	 List<WebElement> list = MoreInfo;
 	 int count = list.size();
	return count;
  }
  
	public String WindowHandeling() throws Exception {
		String mainwin = driver.getWindowHandle();
		List<WebElement> links =infowindows;

		for (WebElement link : links)
			link.click();
		Thread.sleep(5000);
		Set<String> allwins = driver.getWindowHandles();
		for (String window : allwins) {
			System.out.println("id or handle of window: " + window);

			driver.switchTo().window(window);
			System.out.println(" title of child window : " + driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			
			if (!window.equals(mainwin));
			driver.switchTo().window(mainwin);
			String act = MainWindowTitle.getText();
			String Exp = "Java By Kiran";
		}
		return null;
  }
  public long NoOfIcons() {
 	 List<WebElement> TotalIcons= Icons;
 	 int IconCount = TotalIcons.size();
	return IconCount;
  }
  public UserPage NavigateUsersPage(WebDriver driver) {
		driver.findElement(By.linkText("Users")).click();
		return new UserPage(driver);
	}
  
  public OperatorsPage NavigateOperatorsPage(WebDriver driver) {
		driver.findElement(By.linkText("Operators")).click();
		return new OperatorsPage(driver);

	}

	public UsefulLinksPage NavigateUsefulLinksPage(WebDriver driver) {
		driver.findElement(By.linkText("Useful Links")).click();
		return new UsefulLinksPage(driver);
	}

	public DownloadsPage NavigateDownloadsPage(WebDriver driver) {
		driver.findElement(By.linkText("Downloads")).click();
		return new DownloadsPage(driver);
	}

	public LoginPage NavigateLogoutPage(WebDriver driver) {
		driver.findElement(By.linkText("Logout")).click();
		return new LoginPage(driver);
	}

}
