package br.ce.wcaquino.pages;

import static org.junit.Assert.assertEquals;
import br.ce.wcaquino.core.BasePage;

public class SeuBarrigaPage extends BasePage{
	
	public void setEmail(String email) {
		escreve("/html/body/div[2]/form/div[1]/input", email);
	}

	public void setSenha(String senha) {
		escreve("/html/body/div[2]/form/div[2]/input", senha);
	}
	
	public void entrar() {
		clicarBotao("/html/body/div[2]/form/button");
	}
	
	public void adicionarConta(String nome) {
		clicarBotao("/html/body/nav/div/div[2]/ul/li[2]/a");
		clicarBotao("/html/body/nav/div/div[2]/ul/li[2]/ul/li[1]/a");
		escreve("/html/body/div[2]/form/div[1]/div/input", nome);
		clicarBotao("/html/body/div[2]/form/div[2]/button");
	}
	
	public void checkContaAdicionada() {
		assertEquals(obterTexto("/html/body/div[1]"), "Conta adicionada com sucesso!");
	}
	
	public void editarConta(String nome) {
		clicarBotao("/html/body/table/tbody/tr/td[2]/a[1]/span");
		escreve("/html/body/div[2]/form/div[1]/div/input", nome);
		clicarBotao("/html/body/div[2]/form/div[2]/button");
	}
	
	public void checkContaAlterada() {
		assertEquals(obterTexto("/html/body/div[1]"), "Conta alterada com sucesso!");
	}
	
	public void checkContaRepetida() {
		assertEquals(obterTexto("/html/body/div[1]"), "Já existe uma conta com esse nome!");
	}
	
	public void criarMovimentacao() {
		clicarBotao("/html/body/nav/div/div[2]/ul/li[3]/a");
	}
	
	public void criarMovimentacaoData(String dataNow) {
		escreve("/html/body/div[2]/form/div[1]/div[2]/input", dataNow);
	}
	
	public void CriarMovimentacaoDataPagamento(String data) {
		escreve("/html/body/div[2]/form/div[1]/div[3]/input", data);
	}
	
	public void CriarMovimentacaoDescricao(String descricao) {
		escreve("/html/body/div[2]/form/div[2]/div[1]/input", descricao);
	}
	
	public void CriarMovimentacaoInteressado(String interessado) {
		escreve("/html/body/div[2]/form/div[2]/div[2]/input", interessado);
	}
	
	public void CriarMovimentacaoValor(String valor) {
		escreve("/html/body/div[2]/form/div[3]/div[1]/input", valor);
	}
	
	public void CriarMovimentacaoPago() {
		clicarBotao("/html/body/div[2]/form/div[3]/div[3]/div/input[1]");
	}
	
	public void CriarMovimentacaoSalvar() {
		clicarBotao("/html/body/div[2]/form/div[4]/button");
	}
	
	public void checkMovimentacaoCriada() {
		assertEquals(obterTexto("/html/body/div[1]"), "Movimentação adicionada com sucesso!");
	}
	
	public void checkRegrasMovimentacao() {
		assertEquals(obterTexto("/html/body/div[1]/ul/li[1]"), "Data da Movimentação é obrigatório");
		assertEquals(obterTexto("/html/body/div[1]/ul/li[2]"), "Data do pagamento é obrigatório");
		assertEquals(obterTexto("/html/body/div[1]/ul/li[3]"), "Descrição é obrigatório");
		assertEquals(obterTexto("/html/body/div[1]/ul/li[4]"), "Interessado é obrigatório");
		assertEquals(obterTexto("/html/body/div[1]/ul/li[5]"), "Valor é obrigatório");
		assertEquals(obterTexto("/html/body/div[1]/ul/li[6]"), "Valor deve ser um número");
	}

	public void checkMovimentacaoFutura(String dataFutura, String data, String descricao, String interessado, String valor) {
		escreve("/html/body/div[3]/form/div[1]/div[2]/input", dataFutura);
		escreve("/html/body/div[3]/form/div[1]/div[3]/input", data);
		escreve("/html/body/div[3]/form/div[2]/div[1]/input", descricao);
		escreve("/html/body/div[3]/form/div[2]/div[2]/input", interessado);
		escreve("/html/body/div[3]/form/div[3]/div[1]/input", valor);
		clicarBotao("/html/body/div[3]/form/div[4]");
		
		assertEquals(obterTexto("/html/body/div[1]"), "Data da Movimentação deve ser menor ou igual à data atual");
	}
	
	public void removeMovimentacao() {
		clicarBotao("/html/body/nav/div/div[2]/ul/li[4]/a");
		clicarBotao("/html/body/div[2]/table/tbody/tr/td[6]/a/span");
	}
	
	public void checkMensagemMovimentacaoRemovida() {
		assertEquals(obterTexto("/html/body/div[1]"), "Movimentação removida com sucesso!");
	}
	
	public void acountList() {
		clicarBotao("/html/body/nav/div/div[2]/ul/li[2]/a");
		clicarBotao("/html/body/nav/div/div[2]/ul/li[2]/ul/li[2]/a");
	}
	
	public void acountDeleteWithTrasations() {
		clicarBotao("/html/body/table/tbody/tr/td[2]/a[2]/span");
		assertEquals(obterTexto("/html/body/div[1]"), "Conta em uso na movimentações");
	}
	
	public void verConta() {
		clicarBotao("/html/body/nav/div/div[2]/ul/li[1]/a");
	}
	
	public void checkConta() {
		assertEquals(obterTexto("/html/body/div/table/tbody/tr/td[1]"), "NicolasF");
		assertEquals(obterTexto("/html/body/div/table/tbody/tr/td[2]"), "10.00");
	}
	
	public void deletaConta() {
		clicarBotao("/html/body/table/tbody/tr/td[2]/a[2]/span");
	}
	
}
