package stepDefinitions;

import org.testng.Assert;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pageObjects.Carrinho;
import pageObjects.HomePage;
import pageObjects.Produto;
import pageObjects.ResultadoBusca;
import resources.DriverInit;

public class Steps extends DriverInit {
	
	@Dado("^que o usuário pesquisa por \"([^\"]*)\" na página inicial$")
	public void que_o_usuário_pesquisa_por_na_página_inicial(String item) throws Throwable {
		HomePage hp = new HomePage(driver);
		
		hp.pesquisar(item);
	}

	@Quando("^escolhe uma cor \"([^\"]*)\" para a \"([^\"]*)\" e adiciona o produto ao carrinho$")
	public void escolhe_a_e_adiciona_o_produto_ao_carrinho(String cor, String item) throws Throwable {
		ResultadoBusca rb = new ResultadoBusca(driver);
		Produto prd = new Produto(driver);
		
		Assert.assertTrue(rb.obterResultado().contains(item.toUpperCase()));
		rb.verDetalhes();
		prd.selecionarCorIrCarrinho(cor);
	}

	@Então("^verifica que \"([^\"]*)\" item \"([^\"]*)\", com o preço \"([^\"]*)\", foi adicionado e confere a soma total$")
	public void verifica_que_item_foi_adicionado_com_sucesso_e_com_o_preço(String quantidade, String item, String preco) throws Throwable {
		Carrinho car = new Carrinho(driver);
		
		Assert.assertEquals(car.obterQuantidade(item), quantidade);
		Assert.assertTrue(car.obterNome(item).contains(item) || car.obterNome(item).equalsIgnoreCase(item));
		Assert.assertEquals(car.obterPreco(item), preco);
		
		Assert.assertEquals(car.somarValoresIndividuais(), car.obterTotal());
	}

	@Então("^verifica que o item procurado não existe e que uma mensagem contendo \"([^\"]*)\" é exibida$")
	public void verifica_que_o_item_procurado_não_existe_e_que_uma_mensagem_contendo_é_exibida(String erro) throws Throwable {
		ResultadoBusca rb = new ResultadoBusca(driver);
		Assert.assertTrue(rb.obterErro().contains(erro));
	}
	
}
