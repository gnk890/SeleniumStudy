package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webelement {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\gnk89\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.instagram.com/accounts/login/?");
		
		Thread.sleep(3000);
		
		WebElement name= driver.findElement(By.name("username"));
		name.sendKeys("8120202029");
		
		WebElement pass= driver.findElement(By.name("password"));
		pass.sendKeys("Selenium1");
		
		//WebElement logbutton= driver.findElement(By.name("password"));
		//logbutton.click();
		

		
		
	}

}
