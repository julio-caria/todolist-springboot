# RocketSeat - Java Curso Online

## URL's

- Acesso à API Padrão: <http://localhost:8080/firstroute>
- Acesso ao banco de dados: <http://localhost:8080/h2-console>

## Instalações

- Instalar o Java: Necessário versão 17 ou superior devido o suporte e compatibilidade com o SpringBoot 3.0
- Instalar o Maven: Gerenciador de dependências e build para se trabalhar com Java.
- Instalar as extensões: Necessárias para compatibilidade do código Java no VSCode.
- Instalar ferramenta para API: Necessário para realizar as requisições a fim de testar API.

## Criando a estrutura

### 1º Forma

Existem algumas formas de inicializar uma aplicação utilizando spring boot, sendo a primeira delas, através do site [Spring initializr](https://start.spring.io/)
Dentro do site em questão, conseguimos configurar o spring boot, e no final será gerado um arquivo `.zip` com todas as configurações para serem repassadas para a IDE.

### 2º Forma

Utilizar o próprio maven através do CLI (Terminal) para estruturação do archetype do projeto.
Através do site oficial do Maven, conseguimos obter um guia de inicialização, [Maven Quickstart Archhetype](https://maven.apache.org/archetypes/maven-archetype-quickstart/).

### 3º Forma

Utilizar a própria IDE.

- Atalho: `CTRL + SHIFT + P`
- Selecionar `Spring Initializr: Create a Maven Project...`

## Controller

O que é uma Controller?
Uma controller nada mais é do que, um componente utilizado para ser uma camada entre a requisição do usuário e o banco de dados.
Em outras palavras, o principal propósito de uma controller é agir como intermediária entre o modelo (que representa os dados e a lógica de negócios) e a visualização (que é a interface do usuário).

Está englobada dentro da arquitetura MVC (Model View Controller).

```java
@Controller - Utilizado para estruturas que retorne páginas/templates.
@RestController - Utilizada para retornar informações de API.
```

## Library Lombok

Biblioteca para facilitar a criação de métodos.

```java
@Data //- Tanto Getter quanto setter
@Getters //- Estrutura apenas Getters
@Setters //- Estrutura o setters
```

## Spring Data JPA

Comunicação com o banco de dados e manipulação dos arquivos dentro do banco de dados.
Utiliza o conceito de ORM.

## H2 Database Engine

Banco de dados em memória.
Não sendo recomendado para produção, pois os dados se perdem, por se tratar de um banco que armazena as informações em memória.

## Repositório

Interface: Apenas a representação dos métodos.

> Quando alguma classe tem presente o seguinte contexto `<>`, indica que é uma maneira de tornar o código mais genérico e flexível, permitindo que você escreva classes e métodos que podem trabalhar com diferentes tipos de dados sem a necessidade de duplicar o código para cada tipo.

Annotation `Autowired`: Utilizada para indicar que o Spring deverá gerenciar o repositório sem a necessidade de ficar instanciando-o manualmente.

## Retorno de Requisição

`ResponseEntity`: Utilizado para fornecer uma resposta da requisição, se foi bem aceito ou não a requisição. Podendo ser retornado um status code.
