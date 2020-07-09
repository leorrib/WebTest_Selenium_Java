# language: pt

Funcionalidade: Carrinho de Compras
	Gostaria de testar o site automationPractice.com
	Para validar o carrinho de compras
	
	Cenario: Validar Carrinho de Compras: T-Shirt
		Dado que o usuário pesquisa por "T-SHIRT" na página inicial
		Quando escolhe uma cor "azul" para a "T-SHIRT" e adiciona o produto ao carrinho
		Então verifica que "1" item "T-SHIRT", com o preço "$16.51", foi adicionado e confere a soma total

	Cenario: Validar Carrinho de Compras: Blouse
		Dado que o usuário pesquisa por "Blouse" na página inicial
		Quando escolhe uma cor "qualquer" para a "Blouse" e adiciona o produto ao carrinho
		Então verifica que "1" item "Blouse", com o preço "$27.00", foi adicionado e confere a soma total
	
	Cenario: Validar Carrinho de Compras: produto inexistente
		Dado que o usuário pesquisa por "inexistente" na página inicial
    Então verifica que o item procurado não existe e que uma mensagem contendo "No results were found for your search" é exibida