package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	public WebDriver driver;
	
	By searchBox = By.id("search_query_top");
	By searchButton = By.name("submit_search");
    		
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private void digitar(String item) {
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
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
