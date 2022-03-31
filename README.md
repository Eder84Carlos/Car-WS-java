# Car-WS-java

Marcas
Listar todas as marcas
GET /brands

Se sucesso, retorna todas as marcas
Listar uma marca por id
GET /brands/{id}

Retorna erro:
Se não existir marca com id informado
Se sucesso, retorna marca do id informado
Inserir uma marca
POST /brands com corpo em JSON: {"description":"descricaoDaMarca"}

Retorna erro
Se enviar id no corpo
Se enviar corpo sem nenhum atributo
Se faltar um do(s) atributo(s) (description) no corpo
Se sucesso, retorna marca inserida
Remover uma marca por id
DELETE /brands/{id}

Retorna erro
Se não existir marca com id informado
Se sucesso, retorna status OK
Alterar um atributo de uma marca por id
PATCH /brands/{id} com corpo em JSON: {"description":"descricaoDaMarca"}

Retorna erro
Se não existir marca com id informado
Se enviar id no corpo
Se enviar corpo sem nenhum atributo
Se sucesso, retorna o objeto inteiro atualizado
Alterar todos os atributos de uma marca por id
PUT /brands/{id} com corpo em JSON: {"description":"descricaoDaMarca"}

Retorna erro
Se não existir marca com id informado
Se enviar id no corpo
Se enviar corpo sem nenhum atributo
Se faltar um do(s) atributo(s) (description) no corpo
Se sucesso, retorna o objeto inteiro atualizado
Carros
Listar todos os carros
GET /cars

Se sucesso, retorna todos os carros
Listar um carro por id
GET /cars/{id}

Retorna erro:
Se não existir carro com id informado
Se sucesso, retorna carro do id informado
Inserir um carro
POST /cars com corpo em JSON: {"brandId":IdDaMarca, "model":"ModeloDoCarro", "color":"CorDoCarro"}

Retorna erro
Se enviar id no corpo
Se enviar corpo sem nenhum atributo
Se faltar um do(s) atributo(s) (brandId, model e color) no corpo
Se não existir marca com o brandId informado
Se sucesso, retorna carro inserido
Remover um carro por id
DELETE /cars/{id}

Retorna erro
Se não existir carro com id informado
Se sucesso, retorna status OK
Alterar um atributo de um carro por id
PATCH /cars/{id} com corpo em JSON: {"brandId":IdDaMarca} ou {"model":"ModeloDoCarro"} ou {"color":"CorDoCarro"}

Retorna erro
Se não existir carro com id informado
Se enviar id no corpo
Se não existir marca com o brandId informado
Se enviar corpo sem nenhum atributo
Se possuir mais de um atributo no corpo, apenas o de maior prioridade será gravado. As prioridades são, do maior para o menor
brandId
model
color
Se sucesso, retorna o objeto inteiro atualizado
Alterar todos os atributos de um carro por id
PUT /cars/{id} com corpo em JSON: {"brandId":IdDaMarca, "model":"ModeloDoCarro", "color":"CorDoCarro"}

Retorna erro
Se não existir carro com id informado
Se enviar id no corpo
Se não existir marca com o brandId informado
Se enviar corpo sem nenhum atributo
Se faltar um do(s) atributo(s) (brandId, model e color) no corpo
Se sucesso, retorna o objeto inteiro atualizado
