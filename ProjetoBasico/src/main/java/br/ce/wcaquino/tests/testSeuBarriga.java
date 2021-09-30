package br.ce.wcaquino.tests;

import org.junit.Test;
import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.SeuBarrigaPage;

public class testSeuBarriga extends BaseTest {
	
private SeuBarrigaPage page = new SeuBarrigaPage();
	
@Test
public void fazLogin() throws InterruptedException {
	Thread.sleep(2000);
	page.setEmail("nicolasnssn@gmail.com");
	page.setSenha("b5b4b3b2b1");
	page.entrar();
	page.adicionarConta("Nicolas");
	page.checkContaAdicionada();
	page.editarConta("F");
	page.checkContaAlterada();
	page.adicionarConta("NicolasF");
	page.checkContaRepetida();
	page.criarMovimentacao();
	page.criarMovimentacaoData("30/09/2021");
	page.CriarMovimentacaoDataPagamento("30/09/2021");
	page.CriarMovimentacaoDescricao("abc");
	page.CriarMovimentacaoInteressado("abc");
	page.CriarMovimentacaoValor("10");
	page.CriarMovimentacaoPago();
	page.CriarMovimentacaoSalvar();
	page.checkMovimentacaoCriada();
	page.criarMovimentacao();
	page.CriarMovimentacaoSalvar();
	page.checkRegrasMovimentacao();
	page.checkMovimentacaoFutura("30/09/2022", "30/09/2021", "abc", "abc", "10");
	page.acountList();
	page.acountDeleteWithTrasations();
	page.verConta();
	page.checkConta();
	page.removeMovimentacao();
	page.checkMensagemMovimentacaoRemovida();
	page.acountList();
	page.deletaConta();
}

}
