package com.selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	
	public static void main (String[] args) throws InterruptedException { 
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gnk89\\Downloads\\chromedriver_win32_1\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		driver.findElement(By.id("newWindowsBtn")).click();
		
		
		String parentWindow= driver.getWindowHandle();
		System.out.println(parentWindow);
		
		
		Set<String> handles= driver.getWindowHandles();
		System.out.println(handles);
		
		System.out.println(driver.getCurrentUrl());
		
		//Now switch to new window and perform an action
		
		for (String totalWin : handles) {
			
			driver.switchTo().window(totalWin);
			
		}

		System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();
		driver.findElement(By.id("firstName")).sendKeys("Sathish");
		Thread.sleep(3000);
		//driver.close();
		
		
		driver.switchTo().window(parentWindow);
		driver.findElement(By.id("name")).sendKeys("NAVEEN");
		
		//find no of windows opened
		int noOfWindows= driver.getWindowHandles().size();
		System.out.println(noOfWindows);
		
		
		//Close the new Windows except parent
		
		
		Set<String> allWindows= driver.getWindowHandles();
		
		for (String totalWin2 : allWindows) {
			
			if(!totalWin2.equals(parentWindow)){
				driver.switchTo().window(totalWin2);
				driver.close();				
			}
	
		//switching back to parent window after closing other windows
			
		}
	
		driver.switchTo().window(parentWindow);
		driver.findElement(By.id("name")).sendKeys("KUMAR");	
		
		System.out.println("Finally " +driver.getCurrentUrl());
		
		
		// to go to a particular window 
		Set<String> handles3= driver.getWindowHandles();
		
		driver.findElement(By.id("newWindowsBtn")).click();

		for (String allWin2 : handles3) {
			String allTitles=	driver.switchTo().window(allWin2).getTitle();
			System.out.println(allTitles);
			
		}
		

		
		
		
	}
}
