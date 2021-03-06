package br.ce.wcaquino.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	public static WebDriver driver;
	
	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		if(driver == null) {
			switch (Propriedades.browser) {
				case CHROME: System.setProperty("webdriver.chrome.driver", "/Users/nicol/Documents/drivers/chromedriver.exe"); 
				driver = new ChromeDriver();
				break;
			}
		}
		return driver;
	}
	public static void killDriver() {
		if(driver != null) {
			driver.close();
			driver = null;
		}
	}
}
