package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	public WebDriver driver;
	
	By searchBox = By.id("search_query_top");
	By searchButton = By.name("submit_search");
    		
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private void digitar(String item) {
		driver.findElement(searchBox).sendKeys(item);
	}
	
	private void buscar() {
		driver.findElement(searchButton).click();
	}
	
	public void pesquisar(String item) {
		digitar(item);
		buscar();
	}
	
}
