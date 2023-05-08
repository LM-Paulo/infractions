API de gerenciamento de registros de veículos infratores

Este é um projeto de API em Java 11 e Spring Boot que permite o gerenciamento de uma única tabela em um banco de dados, chamada "records". Essa tabela é responsável 
por armazenar informações sobre registros de veículos infratores, incluindo data/hora, velocidade, placa e classe do veículo.

Tecnologias utilizadas:
Java 11
Spring Boot
Spring Data JPA
Postgresql

Para configurar o ambiente de desenvolvimento local, siga os passos abaixo:

Certifique-se de ter o Java 11 instalado na sua máquina. Caso ainda não tenha, faça o download e a instalação a partir do site oficial do Java.
Clone o repositório do projeto.
Configure as credenciais de acesso ao banco de dados no arquivo "application.properties".
Execute o projeto com o comando "mvn spring-boot:run".


https://github.com/LM-Paulo/infractionsconsumer

Clone o repositório do serviço para que a API possa consumir as chamadas. Para que funcione corretamente é preciso executar os dois projetos simultaneamente.
