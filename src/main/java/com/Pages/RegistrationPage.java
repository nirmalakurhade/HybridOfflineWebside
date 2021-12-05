package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	WebDriver driver;
	public RegistrationPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	public LoginPage clickOnAlreadyMembership() {
		driver.findElement(By.partialLinkText("membership")).click();
		return new LoginPage(driver);
	}
	public boolean registrationForm() {
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("mobile")).clear();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
		
		driver.findElement(By.id("name")).sendKeys("nirmala");
		driver.findElement(By.id("mobile")).sendKeys("984763553");
		driver.findElement(By.id("email")).sendKeys("nirmala123@gmail.com");
		driver.findElement(By.id("password")).sendKeys("3456899");
		driver.findElement(By.xpath("//button")).click();
		String act=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String exp="User registered successfully.";
		
		if(act.equals(exp)) {
			System.out.println("User registered ");
			return true;
		}else {
			System.out.println("User not registered ");
			return false;
			
		}
	}

}