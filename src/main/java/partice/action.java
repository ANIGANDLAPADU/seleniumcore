package partice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class action {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)", "");

	}
}
