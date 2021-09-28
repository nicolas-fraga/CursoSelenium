package br.ce.wcaquino.test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testeCampoTreinamento2 {	
	
private WebDriver driver;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "/Users/nicol/Documents/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(1200, 765));
	}
	
	@After
	public void fecha() {
		driver.close();
	}
	
	@Test
	public void alertaSimples() {
		driver.findElement(By.xpath("/html/body/center/center/input[1]")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Alert Simples", alert.getText());
		String textoAlerta = alert.getText(); 
		alert.accept();
		driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[1]/td[2]/input")).sendKeys(textoAlerta);
//		Runtime.getRuntime().exec("tskill chromedriver");
	}
	
	@Test
	public void alertaConfirm() {
		try {		
		driver.findElement(By.xpath("/html/body/center/center/input[2]")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
//		Thread.sleep(2000);
		alerta.accept();
		Assert.assertEquals("Confirmado", alerta.getText());
//		Thread.sleep(2000);
		alerta.accept();
		
		driver.findElement(By.xpath("/html/body/center/center/input[2]")).click();
		alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
//		Thread.sleep(2000);
		alerta.dismiss();
		Assert.assertEquals("Negado", alerta.getText());
//		Thread.sleep(2000);
		alerta.accept();
		}
		catch (Exception e) {
			System.out.println("erro");
		}
	}
	
		@Test
		public void alertaPrompt() {
			String dois = "2";
			
			driver.findElement(By.xpath("/html/body/center/center/input[3]")).click();
			Alert alerta = driver.switchTo().alert();
			Assert.assertEquals("Digite um numero", alerta.getText());
			alerta.sendKeys(dois);
			alerta.accept();
			Assert.assertEquals(alerta.getText(), "Era " + dois + "?");
			alerta.accept();
			alerta.accept();
	}
		
		@Test
		public void botaoDentroDoFrame() {
			driver.switchTo().frame("frame1");
			driver.findElement(By.xpath("/html/body/input")).click();
			Alert alerta = driver.switchTo().alert();
			String textoDoAlerta = alerta.getText();
			Assert.assertEquals("Frame OK!", textoDoAlerta);
			alerta.accept();
			
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[1]/td[2]/input")).sendKeys(textoDoAlerta);
		}
		
		@Test
		public void deveInteragirComJanelas() {
			driver.findElement(By.xpath("/html/body/center/form/input[3]")).click();
			
			driver.switchTo().window("Popup");
			driver.findElement(By.xpath("/html/body/textarea")).sendKeys("aqui");
			driver.close();
			
			driver.switchTo().window("");
			driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[7]/td[2]/textarea")).sendKeys("aqui");
		}
		
		@Test
		public void deveInteragirComJanelasSemTitulo() {
			driver.findElement(By.xpath("/html/body/center/form/input[4]")).click();
		
			driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
			driver.findElement(By.xpath("/html/body/textarea")).sendKeys("aqui");
			driver.close();
			
			driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);	
			driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[7]/td[2]/textarea")).sendKeys("aqui");
		}
}
