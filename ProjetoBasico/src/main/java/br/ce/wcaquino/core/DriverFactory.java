package br.ce.wcaquino.core;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverFactory {

	public static WebDriver driver;
	
	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		if(driver == null) {
			switch (Propriedades.browser) {
				case CHROME: System.setProperty("webdriver.chrome.driver", "/CursoSelenium/ProjetoBasico/target/drivers/chromedriver.exe"); 
				driver = new ChromeDriver();
				break;
				case OPERA:System.setProperty("webdriver.opera.driver", "/CursoSelenium/ProjetoBasico/target/drivers/operadriver.exe");
				driver = new OperaDriver();
				break;
			}
		}
		return driver;
	}
	public static void killDriver() throws IOException {
		if(driver != null) {
			driver.close();
			Runtime.getRuntime().exec("tskill chromedriver");
			driver = null;
		}
	}
}
