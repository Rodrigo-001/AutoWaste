# language: pt
Funcionalidade: Deletar uma lixeira
  Como usuário da API
  Quero conseguir deletar uma lixeira
  Para que o registro seja apagado corretamente no sistema
  Contexto: Cadastro bem-sucedido de lixeira
    Dado que eu tenha os seguintes dados da lixeira:
      | campo            | valor        |
      | localizacao      | Setor A BL 1 |
      | capacidadeTotal  | 500          |
      | capacidadeAtual  | 20           |
    Quando eu enviar a requisição para o endpoint "/lixeira" de cadastro de lixeiras
    Então o status code da resposta deve ser 201

  Cenário: Deve ser possível deletar uma lixeira
    Dado que eu recupere o ID da lixeira criada no contexto
    Quando eu enviar a requisição com o ID para o endpoint "/lixeira" de deleção de lixeira
    Então o status code da resposta deve ser 204