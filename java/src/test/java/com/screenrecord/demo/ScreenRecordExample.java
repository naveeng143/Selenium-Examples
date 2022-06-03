package com.screenrecord.demo;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;

public class ScreenRecordExample {

	public static AndroidDriver driver;

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws InterruptedException, IOException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "MI A3");
		cap.setCapability("udid", "17ae52ddb441");
		cap.setCapability("appPackage", "com.google.android.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);

		try {
			driver.startRecordingScreen(new AndroidStartScreenRecordingOptions().withVideoSize("1280x720")
					.withTimeLimit(Duration.ofSeconds(200)));
			driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click();
			driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
			driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
			driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(driver.getPageSource());
		}

		finally {
			String video= driver.stopRecordingScreen();
			byte[] decode = Base64.getDecoder().decode(video);
			FileUtils.writeByteArrayToFile(new File("appiumRecorded.mp4"), decode);
			driver.quit();
		}
	}

}
