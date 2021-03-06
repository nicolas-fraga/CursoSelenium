package br.ce.wcaquino.core;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	public void escreve(String xpathcampo, String texto) {
		getDriver().findElement(By.xpath(xpathcampo)).sendKeys(texto);;
	}
	
	public String obterValorCampo(String xpathCampo) {
		return getDriver().findElement(By.xpath(xpathCampo)).getAttribute("value");
	}
	
	public void clicarRadio(String xpathCampo) {
		getDriver().findElement(By.xpath(xpathCampo)).click();
	}
	
	public Boolean isRadioMarcado(String xpathCampo) {
		return getDriver().findElement(By.xpath(xpathCampo)).isSelected();
	}
	
	public void selecionarCombo(String xpathcampo, String valor) {
		WebElement element = getDriver().findElement(By.xpath(xpathcampo));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public String obterValorCombo(String xpathcampo) {
		WebElement element = getDriver().findElement(By.xpath(xpathcampo));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
		
	}
	
	public void clicarBotao(String xpathcampo) {
		getDriver().findElement(By.xpath(xpathcampo)).click();
	}
	
	public void clicarLink(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
	}
	
	public String obterTexto(String xpathcampo) {
		return getDriver().findElement(By.xpath(xpathcampo)).getText();
	}

}
