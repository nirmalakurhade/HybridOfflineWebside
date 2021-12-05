package com.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ObjectRepository.AddUserRepository;

public class AddUserPage extends AddUserRepository{
	WebDriver driver;
	
	public AddUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean userpageColumn() {
		ArrayList<String> Totallables = new ArrayList<String>();
		List<WebElement> lables = userColumn;
		for (WebElement wb : lables) {
			String text = wb.getText();
			Totallables.add(text);
		}
		ArrayList<String> actlables = new ArrayList<String>();
		actlables.add("Username");
		actlables.add("Mobile");
		actlables.add("Email");
		actlables.add("Courses");
		actlables.add("Gender");
		actlables.add("State");
		actlables.add("Password");
		actlables.add("Friend Mobile");
		return true;

	}

	public long SideBar() {
		List<WebElement> SideBar = NoOfSideBar;
		int count = SideBar.size();
		return count;
	}

	public String URL() {
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		return URL;
	}

	public String PageTitle() {
		String actHeading = Title.getText();
		String ExpHeading = "Java By Kiran";
		return ExpHeading;
	}

	public String SubmitButton() {
		String button = submitbtn.getText();
		String Expbutton = "Submit";
		return Expbutton;
	}
	public UserPage clickOnCancle() {
		driver.findElement(By.xpath("//span[text()='Cancel']")).click();
		return new UserPage(driver);
	}

	public String adduserdata() throws Exception {
		uname.sendKeys("nirmala");
		Nomobile.sendKeys("123456789");
		umail.sendKeys("kiran@gmail.com");
		usercourse.sendKeys("java");
		GenderSelect.click();
		WebElement St = driver.findElement(By.xpath("//select"));
		Select select = new Select(St);
		select.selectByVisibleText("Maharashtra");
		password.sendKeys("wewewefbc");
		MobileNo.sendKeys("987654321");
		driver.findElement(By.id("submit")).click();
		driver.switchTo().alert().getText();
		Thread.sleep(3000);
		String a=driver.switchTo().alert().getText();
		String exp="User Added Successfully. You can not see added user.";
		driver.switchTo().alert().accept();
		
		return exp;
	}
	}

