package br.ce.wcaquino.test;
import org.openqa.selenium.WebDriver;

import br.ce.wcaquino.core.DSl;

public class desafioPrimefacesPage {

	private DSl dsl;
	
	public desafioPrimefacesPage(WebDriver driver) {
		dsl = new DSl();
	}
	
	public void setBasic(String texto) {
		dsl.clicarRadio("/html/body/div[1]/div[6]/div[2]/div/form/div/div[1]/div");
		dsl.clicarRadio("/html/body/div[5]/div[1]/ul/li[2]");	
	}
	
}
