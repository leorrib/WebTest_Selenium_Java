# Teste E2E em http://automationpractice.com/
Este teste executa 3 cenários diferentes:

- Adição de uma T-Shirt ao carrinho
Neste cenário, um usuário digita "T-SHIRT" no campo de busca e confere se o produto exibido contém T-SHIRT no nome. Em seguida, clica no produto para ter acesso aos seus detalhes, muda sua cor e o adiciona ao carrinho. Por fim, o usuário verifica se a quantidade, o nome do produto e o seu preço estão corretos. Adicionalmente, o usuário também confere se o preço total (antes de serem adicionadas as taxas) está correto.

- Adição de uma Blouse ao carrinho
Neste cenário, um usuário digita "Blouse" no campo de busca e confere se o produto exibido contém Blouse no nome. Em seguida, clica no produto para ter acesso aos seus detalhes e o adiciona ao carrinho. Por fim, o usuário verifica se a quantidade, o nome do produto e o seu preço estão corretos. Adicionalmente, o usuário também confere se o preço total (antes de serem adicionadas as taxas) da soma dos valores de T-SHIRT e Blouse está correto.

- Busca por produto inexistente
Neste cenário, um usuário digita "inexistente" no campo de busca e confere se a mensagem de erro exibida (indicando que não há um produto com esse nome) está correta.

- Obs:
Eu optei por usar localizadores xpath (mesmo estes sendo mais lento que os css) pois eles permitem a passagem de filho para pai. Com isso, a análise do carrinho é executada de forma mais limpa, de modo que os localizadores de preço/quantidade estão vinculados apenas ao nome do item correspondente. Dessa forma, a adição de novos itens ao carrinho e sua posterior análise torna-se simples e a automação passa a ser mais abrangente.

## Como executar
No diretório do arquivo pom.xml, use o comando "mvn test verify". Isto executará o teste e gerará relatórios em html no diretório target/cucumber-html-reports.

## Requerimentos
- maven.