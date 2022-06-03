package Grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeGridTest {
	public static void main(String[] args) throws MalformedURLException {
		WebDriver driver = new ChromeDriver();
		String url = "http://localhost:4444/wd/hub";
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
		caps.setPlatform(org.openqa.selenium.Platform.MAC);
		driver = new RemoteWebDriver((new URL(url)), caps);
		driver.get("https://www.facebook.com");
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}
	
	
 
}