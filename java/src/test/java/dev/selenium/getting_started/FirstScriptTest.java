package dev.selenium.getting_started;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FirstScriptTest {
	public WebDriver driver;

	@Test
	public void eightComponents() {
		driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		Assertions.assertEquals("Facebook – log in or sign up", driver.getTitle());

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement searchBox = driver.findElement(By.id("email"));
//		WebElement searchButton = driver.findElement(By.name("passs"));

		searchBox.sendKeys("Selenium4");

		WebElement firstResult = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("nav")));
		firstResult.sendKeys("Selenium");

		driver.quit();
	}
}
