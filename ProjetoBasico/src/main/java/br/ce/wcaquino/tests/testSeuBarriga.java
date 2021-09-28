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
}

}
