package pageObjects;

import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Carrinho {
	
	By valor = By.id("total_product");
	By valor_ind = By.cssSelector("span span[class='price']");
	
	public WebDriver driver;
    
	public Carrinho(WebDriver driver) {
		this.driver = driver;
	}
	
	public float obter_total() {
		return Float.parseFloat(driver.findElement(valor).getText().substring(1));
	}
	
	public float somar_valores_individuais() {
		List<WebElement> lista_de_valores = driver.findElements(valor_ind);
		float sum = 0;
		for (int i = 0; i < lista_de_valores.size(); i++) {
			sum += Float.parseFloat(lista_de_valores.get(i).getText().substring(1).toString());
		}
		DecimalFormat df = new DecimalFormat("0.00");
		return Float.parseFloat(df.format(sum));
	}
	
	private String cap_nome(String item) {
		return item.substring(0, 1).toUpperCase() + item.substring(1).toLowerCase();
	}
	
	public String obterNome(String item) {
		By nome = By.xpath("//td //a[text()[contains(.,'" + cap_nome(item) + "')]]");
		return driver.findElement(nome).getText().toUpperCase();
	}
	
	public String obterPreco(String item) {
		By preco = By.xpath("//a[text()[contains(.,'"+ cap_nome(item) +"')]]/../../following-sibling::td[2] //* //span");
		return driver.findElement(preco).getText().toString();
	}
	
	public String obterQuantidade(String item) {
		By quantidade = By.xpath(("//a[text()[contains(.,'" + cap_nome(item) + "')]]/../../following-sibling::td[3] //input[1]"));
		return driver.findElement(quantidade).getAttribute("value");
	}
	
}
