package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableRowColumn {
static WebDriver driver;
	
public static void main(String[]args)
	{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/javascript/index.html");
	
		
		
		
		
		
		
		//Ist Column
		
		WebElement table = driver.findElement(By.xpath("//table[1]"));

		List<WebElement> firstCells = table.findElements(By.xpath("//table[1]//tbody//tr//td[1]"));
		firstCells.forEach(firstCell->System.out.println("" + firstCell.getText()));
		
		
		//
	}
}
