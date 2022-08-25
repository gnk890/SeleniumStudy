package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleDropdown {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gnk89\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.ironspider.ca/forms/dropdowns.htm#example2");
		
		WebElement dd= driver.findElement(By.name("coffee2"));
		
		Select s = new Select(dd);
		System.out.println(s.isMultiple());
		
		s.selectByValue("milk2");
		s.deselectByValue("cream");
		s.selectByValue("sugar");
		s.selectByValue("muffin");
		
		List<WebElement> list= s.getOptions();
		for (WebElement allOptions : list) {
			System.out.println(allOptions.getText());
		}
		
	}

}
