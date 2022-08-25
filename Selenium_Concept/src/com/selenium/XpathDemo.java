package com.selenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {
	
	static WebDriver driver;
	static List<Integer> allPricesList= new ArrayList<>();
	static List<String>  allBrandNames= new ArrayList<>();
	Integer lp = Collections.min(allPricesList) ;
	static List<WebElement> allDisPrices= new ArrayList<>();
	
	
	public static void browserLaunch() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\gnk89\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.get("https://www.myntra.com/kids?f=Categories%3ATshirts%3A%3AGender%3Aboys%20girls%2Cgirls&plaEnabled=false");
		
	}
	
	public static void getLowestPrice() {
		
		 allDisPrices=driver.findElements(By.xpath("//li[@class='product-base']/a/div[@class=\'product-productMetaInfo\']/div[@class=\'product-price\']/span/span[@class=\'product-discountedPrice\']"));
		
		for (WebElement disPrice : allDisPrices) {
			
			String replace= disPrice.getText().replace("Rs. ","");
			Integer price= Integer.valueOf(replace);
			allPricesList.add(price);
		}
		
		System.out.println("Total dresses with discounted price: "+allPricesList.size());
		System.out.println("Lowest Price:" +Collections.min(allPricesList));
	}
	
	public static void getProductNameofLowestPrice(Integer lp){
		
		for (WebElement brName : allDisPrices) {
			if(brName.getText().contains(String.valueOf(lp))) {
			
				WebElement path= driver.findElement(By.xpath("//li[@class=\"product-base\"]/a/div[@class=\"product-productMetaInfo\"]/div[@class=\"product-price\"]/span/span[@class=\"product-discountedPrice\"]/ancestor::div[@class=\"product-productMetaInfo\"]/h3[@class=\"product-brand\"]"));
				System.out.println("Brand name of Lowest price is:"+ path.getText());
		}}
			
	}
	
	
	
	public static void main (String[] args) throws InterruptedException {
		browserLaunch();
		Thread.sleep(3000);
		getLowestPrice();
		getProductNameofLowestPrice(lp);
		
	
	
	}
	
	
	
}

	


