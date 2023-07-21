package com.selenium.Alert;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggetDropDownGoogle {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.google.com/");

		driver.manage().window().maximize();
		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("babu");
		List<WebElement> elements = driver
				.findElements(By.xpath("//div[@class='wM6W7d' and @role='presentation']//span"));
		System.out.println(elements.size());

		for (int i = 0; i < elements.size(); i++) {
			String text = elements.get(i).getText();
			if (text.equals("babu88")) {
				elements.get(i).click();
				break;
			}

		}

		/*
		 * for (WebElement element : elements) { String str = element.getText(); if
		 * (str.equals("babu88")) { element.click(); } }
		 */

	}

}
