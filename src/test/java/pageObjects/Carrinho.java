package pageObjects;

import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Carrinho {
	
	By valor = By.id("total_product");
	By valor_ind = By.cssSelector("span span[class='price']");
	By nome;
	By preco;
	By quantidade;
	
	
	public WebDriver driver;
    
	public Carrinho(WebDriver driver) {
		this.driver = driver;
	}
	
	public float obterTotal() {
		return Float.parseFloat(driver.findElement(valor).getText().substring(1));
	}
	
	public float somarValoresIndividuais() {
		List<WebElement> lista_de_valores = driver.findElements(valor_ind);
		float sum = 0;
		for (int i = 0; i < lista_de_valores.size(); i++) {
			sum += Float.parseFloat(lista_de_valores.get(i).getText().substring(1).toString());
		}
		DecimalFormat df = new DecimalFormat("0.00");
		return Float.parseFloat(df.format(sum));
	}
	
	private String capNome(String item) {
		return item.substring(0, 1).toUpperCase() + item.substring(1).toLowerCase();
	}
	
	public String obterNome(String item) {
		nome = By.xpath("//td //a[text()[contains(.,'" + capNome(item) + "')]]");
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOfElementLocated(nome));
		return driver.findElement(nome).getText().toUpperCase();
	}
	
	public String obterPreco(String item) {
		preco = By.xpath("//a[text()[contains(.,'"+ capNome(item) +"')]]/../../following-sibling::td[2] //* //span");
		return driver.findElement(preco).getText().toString();
	}
	
	public String obterQuantidade(String item) {
		quantidade = By.xpath(("//a[text()[contains(.,'" + capNome(item) + "')]]/../../following-sibling::td[3] //input[1]"));
		return driver.findElement(quantidade).getAttribute("value");
	}
	
}
