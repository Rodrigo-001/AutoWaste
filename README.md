**APP de Coleta de resíduos inteligente**

### Pré-requisitos

- **Maven**: Certifique-se de ter o gerenciador de pacotes Maven instalado.
- **Docker**: Necessário para executar em container.


## Executando a Aplicação Localmente

1. **Abra o projeto** na IDE de sua preferência.

2. **Localize o arquivo JavaApplication** no caminho: `AutoWaste/src/main/java/com/autowaste/demo`.

3. **Abra o terminal** pressionando `Alt + F12`.

4. **Empacote a aplicação** com o comando: mvn package

5. Aguarde o Maven completar as importações.

6. **Configure o arquivo application.properties**: insira username e password com suas credenciais do Oracle SQL.

7. **Execute o projeto na IDE.**

----------------------------------------------

## Testando o CRUD via API
1. Abra uma ferramenta de teste de API (como Insomnia ou Postman).
2. **Importe o arquivo de configuração**:
   - Na ferramenta, escolha a opção “import” e importe o arquivo `API-AUTO-WASTE`, localizado na raiz do projeto.
3. Explore as operações CRUD:
   - O arquivo importado contém duas pastas com rotas para Lixeira e Coleta, oferecendo operações de POST, READ, UPDATE, DELETE.

   ### Exemplo de Operações na API:
- **Criar uma Lixeira**:
   - Vá para a pasta LIXEIRA > CRIAR > clique na aba Body > pressione SEND.
- **Consultar Lixeiras**:
   - Acesse o arquivo CONSULTAR TODAS e pressione SEND.
- **Atualizar Lixeira**:
   - Após consultar as lixeiras, copie o ID desejado.
   - Abra ATUALIZAR, cole o ID na URL e clique em SEND.
- **Deletar Lixeira**:
   - Acesse DELETAR, insira o ID da lixeira na URL e pressione SEND.

Nota: Para criar e manipular coletas, siga o mesmo procedimento nas pastas de Coleta.

----------------------------------------------

## Executando Testes Automatizados
### Para Testar Cadastro de Lixeira
1. Cadastro bem-sucedido:
   - No arquivo **CadastroLixeiras.feature** (localizado em AutoWaste/src/test/resources/features), execute o cenário Cadastro bem-sucedido de lixeira.
2. Cadastro mal sucedido:
   - No mesmo arquivo, execute o cenário Cadastro de lixeira sem sucesso, passando um campo de localização inválido.

### Para Testar Exclusão de Lixeira
- Abra o arquivo **DeletarLixeiras.feature** e execute o cenário Deve ser possível deletar uma lixeira.

Com esses passos, você deve ser capaz de executar o projeto em diferentes ambientes e utilizar as APIs para operações de CRUD.