package br.ce.wcaquino.page;

import br.ce.wcaquino.core.BasePage;

public class CampoTreinamentoPage extends BasePage {

	public void setNome(String nome) {
		dsl.escreve("/html/body/center/form/table/tbody/tr[1]/td[2]/input", nome);
	}

	public void setSobrenome(String sobrenome) {
		dsl.escreve("/html/body/center/form/table/tbody/tr[2]/td[2]/input", sobrenome);
	}
	
	public void setSexoMasculino() {
		dsl.clicarRadio("/html/body/center/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/input");
	}
	
	public void setComidaFavoritaCarne() {
		dsl.clicarRadio("/html/body/center/form/table/tbody/tr[4]/td[2]/table/tbody/tr/td[1]/input");
	}
	
	public void setEscolaridade(String valor) {
		dsl.selecionarCombo("/html/body/center/form/table/tbody/tr[5]/td[2]/select", valor);
	}
	
	public void setEsporte(String valor) {
		dsl.selecionarCombo("/html/body/center/form/table/tbody/tr[6]/td[2]/select", valor);
	}
	
	public void cadastrar() {
		dsl.clicarBotao("/html/body/center/form/table/tbody/tr[10]/td/input");
	}
}

