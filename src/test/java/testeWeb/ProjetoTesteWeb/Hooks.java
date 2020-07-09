package testeWeb.ProjetoTesteWeb;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import resources.DriverInit;

public class Hooks extends DriverInit {

	@BeforeSuite
	public void inicializarDriver() throws IOException {
		driver = initializeDriver();
	}
	
	@BeforeTest
	public void paginaInicial() {
		driver.get("http://automationpractice.com/");
	}
	
	@AfterSuite
	public void fecharDriver() throws IOException {
		driver.close();
	}
}
