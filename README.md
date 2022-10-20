# Commerce
Projeto Commerce - 17/10 à 21/10


_________

  
### ✨ Sobre o projeto:
O commerce foi desenvolvido pensando como um e-commerce funciona.
 
## Modelagem utilizada:

![image](https://user-images.githubusercontent.com/62778974/196843617-7281da53-b829-4367-9492-12ebb102b7b7.png)

* Banco de Dados usado em ambiente de teste foi o H2
* Banco de Dados usado em ambiente de desenvolvimento foi o MySQL
 
## Técnologias usadas:

## Back-end:

* Java 11
  1. API Rest
  2. Exceptions personalizadas
  3. Documentação swagger
* Spring Boot
* Maven
* Hibernate
* MySQL

## Deploy

* Heroku


 
<h2 align="center"> 📷 Screenshot da API do projeto: </h2>
<p align="center"></p>
<img src="https://user-images.githubusercontent.com/62778974/196845405-390a4c3b-6892-4f21-a29c-e5ce31e3ab7e.png">

_________

<h2 align="center"> Instruções para reproduzir o projeto</h2>

## Ambiente de teste:

* Clonar repositório em sua máquina
* Importar em uma IDE de suapreferência (Sugiro Intellij)
* Rodar aplicação CommerceApplication
* Entre no link do banco de dados em memoria H2(usado pata teste), caso queira ver a estrutura do banco de dados http://localhost:8080/h2-console/
* Para fazer chamada da API pode ser feito através da colletion do Postman passado por email/whatsapp ou via swagger http://localhost:8080/swagger-ui.html

## Ambiente de desenvolvimento:

* O ambiente de desenvolvimento foi feito deploy no Heroku
* Banco de dados configurado é o MySQL
* Deploy para o Heroku (https://diogo-alves-commerce.herokuapp.com/)
* Para consumir a API basta chamar remotamente pela colletion do Postman passado por email/whatsapp ou via swagger https://diogo-alves-commerce.herokuapp.com/swagger-ui.html. Obs: ao realizar a primeira chamada o retorno pode demorar um pouco devido ao periodo hibernação , mas isso apenas na primeira requisição.
* Documentação Swagger (https://diogo-alves-commerce.herokuapp.com/swagger-ui.html)
