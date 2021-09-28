package br.ce.wcaquino.test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.ce.wcaquino.page.CampoTreinamentoPage;

public class TesteCadastro {
	
	private WebDriver driver;
	private CampoTreinamentoPage page;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "/Users/nicol/Documents/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(1200, 765));
		page = new CampoTreinamentoPage();
	}
	
	@After
	public void fecha() {
		driver.close();
	}
	
	@Test
	public void deveRealizarCadastroComSucesso() {
		page.setNome("Nicolas");
		page.setSobrenome("Fraga");
		page.setSexoMasculino();
		page.setComidaFavoritaCarne();
		page.setEscolaridade("Mestrado");
		page.setEsporte("Natacao");
		page.cadastrar();
	}

}
