package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpath {

	public static void main(String[] args) 
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gnk89\\Downloads\\chromedriver_win32_1\\chromedriver.exe");
    	
    	WebDriver driver= new ChromeDriver();
    	driver.get("https://www.amazon.in/");
    	driver.manage().window().maximize();
    	
    WebElement text= driver.findElement(By.xpath("//h2[text()='Shop & Pay | Earn rewards daily']/following::script/following::div/following::div[@id=\"desktop-grid-3\"]/child::div/child::div/h2"));
    	
		System.out.println(text.getText());
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
