#language: pt
Funcionalidade: Cadastro de nova lixeira
  Como usuário da API
  Quero cadastrar uma nova lixeira
  Para que o registro seja salvo corretamente no sistema
  Cenário: Cadastro bem-sucedido de lixeira
    Dado que eu tenha os seguintes dados da lixeira:
      | campo            | valor        |
      | localizacao      | Setor F BL 10|
      | capacidadeTotal  | 500          |
      | capacidadeAtual  | 10           |
    Quando eu enviar a requisição para o endpoint "/lixeira" de cadastro de lixeiras
    Então o status code da resposta deve ser 201

  Cenário: Cadastro de lixeira sem sucesso ao passar o campo localização inválido
    Dado que eu tenha os seguintes dados da lixeira:
      | campo            | valor        |
      | localizacao      | s            |
      | capacidadeTotal  | 500          |
      | capacidadeAtual  | 20           |
    Quando eu enviar a requisição para o endpoint "/lixeira" de cadastro de lixeiras
    Então o status code da resposta deve ser 400
    E o corpo de resposta de erro da api deve retornar a mensagem "Os dados fornecidos são inválidos."