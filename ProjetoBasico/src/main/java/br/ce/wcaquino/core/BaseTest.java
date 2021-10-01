package br.ce.wcaquino.core;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {
	
	@Rule
	public TestName testName = new TestName();
	
	@Before
	public void inicializa() {
		getDriver().get("http://seubarriga.wcaquino.me/login");
	}
	
//	@After
//	public void fecha() throws IOException {
//		TakesScreenshot ss = (TakesScreenshot) getDriver();
//		File arquivo = ss.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + ".jpg"));
//		
//		DriverFactory.killDriver();
//	}
}
