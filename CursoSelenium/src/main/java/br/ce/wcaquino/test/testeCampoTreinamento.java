package br.ce.wcaquino.test;
import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.DSl;

public class testeCampoTreinamento extends BaseTest{
	
	private DSl dsl;
	
	@Before
	public void inicializa() {
		
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSl(); 
	}
	 
	@Test
	public void NomeEntrada() {
		dsl.escreve("/html/body/center/form/table/tbody/tr[1]/td[2]/input", "Nicolas");
		Assert.assertEquals("Nicolas", dsl.obterValorCampo("/html/body/center/form/table/tbody/tr[1]/td[2]/input"));
	}
	
	@Test
	public void SobrenomeEntrada() {
		dsl.escreve("/html/body/center/form/table/tbody/tr[2]/td[2]/input", "Fraga");
		Assert.assertEquals("Fraga", dsl.obterValorCampo("/html/body/center/form/table/tbody/tr[2]/td[2]/input"));
	}
	
	@Test
	public void RadioButonClick() {
		dsl.clicarRadio("/html/body/center/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/input");
		Assert.assertTrue(dsl.isRadioMarcado("/html/body/center/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/input"));
	}
	
	@Test
	public void CheckBoxClick() {
		dsl.clicarRadio("/html/body/center/form/table/tbody/tr[4]/td[2]/table/tbody/tr/td[1]/input");
		Assert.assertTrue(dsl.isRadioMarcado("/html/body/center/form/table/tbody/tr[4]/td[2]/table/tbody/tr/td[1]/input"));		
	}
	
	@Test
	public void ListaEscolaridadeCombo() {
		dsl.selecionarCombo("/html/body/center/form/table/tbody/tr[5]/td[2]/select", "Superior");
		Assert.assertEquals("Superior", dsl.obterValorCombo("/html/body/center/form/table/tbody/tr[5]/td[2]/select"));
	}
	
	@Test
	public void ListaEscolaridadeVisibilidade() {
		WebElement element = getDriver().findElement(By.xpath("/html/body/center/form/table/tbody/tr[5]/td[2]/select"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		for(WebElement option : options) {
			if(option.getText().equals("Mestrado"));{
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);	
	}
	
	@Test
	public void PraticaEsportesCombo() {
		dsl.selecionarCombo("/html/body/center/form/table/tbody/tr[6]/td[2]/select", "Natacao");
		dsl.selecionarCombo("/html/body/center/form/table/tbody/tr[6]/td[2]/select", "Corrida");
		dsl.selecionarCombo("/html/body/center/form/table/tbody/tr[6]/td[2]/select", "O que eh esporte?");
		
		WebElement element = getDriver().findElement(By.xpath("/html/body/center/form/table/tbody/tr[6]/td[2]/select"));
		Select combo = new Select(element);
		
		combo.deselectByVisibleText("Corrida");
		List<WebElement> allSelectedOptions =  combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());	
	}

	@Test
	public void botaoClickMe() {
		dsl.clicarBotao("/html/body/center/form/input[2]");
		WebElement botao = getDriver().findElement(By.xpath("/html/body/center/form/input[2]"));	
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	}
	
//	@Test
//	public void linkVoltar() {
//		dsl.clicarLink("/html/body/center/a");
//		Assert.assertEquals("Voltou!",dsl.obterTexto("/html/body/center/div[2]"));
//	}
//	
	@Test
	public void DeveBuscarTextoNaPagina() {
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));
		}
	
//	@Test
//	public void DeveInteragirComRespostaDemorada() throws InterruptedException {
//		dsl.clicarBotao("/html/body/center/form/input[5]");
//		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		dsl.escreve("/html/body/center/div[2]/input", "aqui");
//		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
//		wait.until(ExpectedConditions.textToBe(null, null));
//	}
}
