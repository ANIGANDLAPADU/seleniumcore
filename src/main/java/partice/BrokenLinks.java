package partice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		/* WebDriverManager.chromedriver().setup(); */
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> nolinks = driver.findElements(By.tagName("a"));
		System.out.println(nolinks.size());
		for (WebElement elements : nolinks) {
			String arr = elements.getAttribute("href");
			if (arr == null || arr.isEmpty()) {
				continue;
			}

			URL url = new URL(arr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			if (conn.getResponseCode() >= 400) {
				System.out.println("URL is not a broken link" + arr);
			} else {
				System.out.println("URL is broken link " + arr);
			}
		}
	}
}
