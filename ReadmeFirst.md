# DesafiosBHut

-Repositorio do desenvolvimento do desafio.

```bash
#Tecnoloogias Ultilizadas
- JDK 18
- Maven
- MongoDb
- Pacote Spring
- Api Externa para testes
#Pré-requisitos
- MongoDB
- PostMan
- JDK18+
- IDE, sugiro usar o Springo tols suit.

#Como Executar o projeto.

# clonar repositório
git clone https://github.com/lucaslopeslima95/BHut.git

Logo após do clone concluído, importe o projeto em sua IDE.
Caso seu banco mongo tenha usuario e senha, adicione  no arquivo aplication.properties.
Rode o projeto, com o servidor acesse o postman para testar os endpoits.

Cadastrar carro
http://localhost:8080/api/createcar 
Metodo Post
Exemplo:
{
  "title": "Amarock",
  "brand": "Volkswagen",
  "price": "200000",
  "age": 1
}
Listar Todos os carros cadastrados
http://localhost:8080/api/listcars
Metodo Get

A cada operação é gerado um log de regitro, para aconsultar teste o
http://localhost:8080/api/logs

Para cadastrar um log
Metodo Post
Exemplo
{
        "id": "62eac51aa5cdb62caba1d4b6",
        "data_hora": "2022-08-03T15:57:30.609511",
        "car_id": (pode ser id do carro cadastrado ou log de consulta)
    }


Obs: Foi desenvolvido apenas o Back-end.
