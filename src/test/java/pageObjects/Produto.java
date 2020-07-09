package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Produto {

	public WebDriver driver;
	
    By collor = By.cssSelector("[title='Blue']");
    By add_cart = By.cssSelector("[id*='add_to_cart'] span"); 
    By proceed_cart = By.cssSelector("[title*='Proceed'] span");
    		
	public Produto(WebDriver driver) {
		this.driver = driver;
	}
	
	private void selecionar_cor(String cor) {
		if (cor.equalsIgnoreCase("azul")) {
			WebDriverWait w = new WebDriverWait(driver, 10);
			w.until(ExpectedConditions.elementToBeClickable(collor));
			driver.findElement(collor).click();
		}
	}
	
	private void adicionar_ao_carrinho() {
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.elementToBeClickable(add_cart));
		driver.findElement(add_cart).click();
	}
	
	private void proceder_ao_carrinho() {
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.elementToBeClickable(proceed_cart));
		driver.findElement(proceed_cart).click();
	}
	
	public void selecionar_cor_e_ir_ao_carrinho(String cor) {
		selecionar_cor(cor);
		adicionar_ao_carrinho();
		proceder_ao_carrinho();
	}
		
	
}
