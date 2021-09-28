package br.ce.wcaquino.test;

//import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class desafioPrimefaces {
	
	private WebDriver driver;
	private desafioPrimefacesPage page;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "/Users/nicol/Documents/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=06477");
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(1200, 765));
		page =new desafioPrimefacesPage(driver);
	}
	
//	@After
//	public void fecha() {
//		driver.close();
//	}
	
	@Test
	public void deveRealizarPreenchimentoPrimefaces() {
		page.setBasic("Option1");
	}
	
}
