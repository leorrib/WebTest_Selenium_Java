package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultadoBusca {

	public WebDriver driver;
	
    By resultText = By.cssSelector("[itemprop='name'] a");
    By image = By.cssSelector("ul[class*='list'] img");
    By erro = By.cssSelector("[class*='alert']");
    		
	public ResultadoBusca(WebDriver driver) {
		this.driver = driver;
	}
	
	public String obterResultado() {
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOfElementLocated(resultText));
		return driver.findElement(resultText).getText().toUpperCase();
	}
	
	public void verDetalhes() {
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.elementToBeClickable(image));
		driver.findElement(image).click();
	}
	
	public String obterErro() {
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOfElementLocated(erro));
		return driver.findElement(erro).getText();
	}
}
