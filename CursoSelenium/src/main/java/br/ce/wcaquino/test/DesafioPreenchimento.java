package br.ce.wcaquino.test;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DesafioPreenchimento {
	
	@Test
	public void preenchimentoDoFormulario( ) {
		System.setProperty("webdriver.chrome.driver", "/Users/nicol/Documents/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement nome = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[1]/td[2]/input"));
		WebElement sobrenome = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[2]/td[2]/input"));
		WebElement sexo = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/input"));
		WebElement comidaFavorita = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[4]/td[2]/table/tbody/tr/td[1]/input"));
		WebElement escolaridade = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[5]/td[2]/select"));
		WebElement esportes = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[6]/td[2]/select"));
		WebElement cadastrar = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[10]/td/input"));
		Select combo1 = new Select(escolaridade);
		Select combo2 = new Select(esportes);
		
		nome.click();
		nome.sendKeys("Nicolas");
		sobrenome.click();
		sobrenome.sendKeys("Fraga");
		sexo.click();
		Assert.assertTrue(sexo.isSelected());
		comidaFavorita.click();
		Assert.assertTrue(comidaFavorita.isSelected());
		combo1.selectByVisibleText("Superior");
		combo2.selectByVisibleText("Natacao");
		cadastrar.click();
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/center/div[2]/span")).isDisplayed());
	}

}
