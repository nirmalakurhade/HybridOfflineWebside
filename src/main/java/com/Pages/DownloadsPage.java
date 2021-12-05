package com.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DownloadsPage {
	WebDriver driver;
	
	public DownloadsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
public boolean bitusers() {
		
		List<WebElement> downloadlist = driver.findElements(By.xpath("//tr//td[2]"));
		List<WebElement> bituser = driver.findElements(By.xpath("//tr//td[5]"));
		
		ArrayList<String> actList = new ArrayList<String>();
		actList.add("Java Development Kit ");
		actList.add("Google Chrome ");
		actList.add("Mozilla Firefox");
		actList.add("Gecko Driver for Latest firefox");
		
		ArrayList<String> expList = new ArrayList<String>();
		
		for (int i = 0 ; i<downloadlist.size();i++) {
			if(downloadlist.get(i).getText().equals("32bit"));
			String name = bituser.get(i).getText();
			System.out.println(name);
			expList.add(name);
			}
		if(actList.equals(expList)) {
			System.out.println("It's all are 32bit user");
			return true;
		}else {
			System.out.println("All are not 32bit user");
			return false;
		}
}
}