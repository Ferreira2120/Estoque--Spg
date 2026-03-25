# 📦 Sistema de Controle de Estoque - Spring Boot

🚀 Projeto desenvolvido com foco em **boas práticas de backend**, utilizando **Java + Spring Boot**, com arquitetura organizada e pronta para evolução.

---

## 📌 Sobre o Projeto

O EstoqueSPG é uma API REST para gerenciamento de produtos em estoque, permitindo operações completas de cadastro, consulta, atualização e filtragem.

💡 Ideal para demonstrar habilidades em:

* Desenvolvimento Backend
* Arquitetura em camadas
* Integração com banco de dados
* Boas práticas com Spring Boot

---

## 🛠️ Tecnologias Utilizadas

* ☕ Java 21
* 🌱 Spring Boot 4
* 📦 Spring Data JPA
* 🌐 Spring Web MVC
* ✅ Bean Validation
* 🐬 MySQL
* 🔧 Lombok
* 📦 Maven

---

## 🧱 Estrutura do Projeto

O projeto segue uma arquitetura em camadas bem definida:

```
📁 controller   → Camada de entrada (API REST)
📁 service      → Regras de negócio
📁 repository   → Acesso ao banco (JPA)
📁 entity       → Entidades do sistema
📁 dto          → Transferência de dados
📁 enums        → Tipos e categorias (Medida, TipoProduto)
```

---

## ⚙️ Funcionalidades

✅ Cadastro de produtos

✅ Exclusão de produtos

✅ Atualização de produtos

✅ Listagem de produtos

✅ Busca por ID

✅ Filtro por medida (ex: KG, GM)

✅ Filtro por tipo do produto (ex: ALIMENTO, HIGIENE)

✅ Validação de dados de entrada

✅ Conversão entre Entity ↔ DTO

---

## 🔎 Exemplo de Endpoints

| Método | Endpoint                    | Descrição                |
| ------ | --------------------------- | ------------------------ |
| GET    | `/produtos`                 | Listar Todos os Produtos |
| GET    | `/produtos/buscar-id/{id}`            | Buscar por ID            |
| GET    | `/produtos/medida/{medida}` | Buscar por Medida        |
| GET    | `/produtos/tipo/{tipoProduto}`     | Buscar por Tipo do Produto        |
| GET    | `/produtos/buscar-nome/{nome}` | Buscar por Nome        |
| POST   | `/produtos/novo`                 | Criar Produto            |
| PUT    | `/produtos/atualziar`            | Atualizar Produto        |
| DELETE    | `/produtos/deletar/{id}` | Deletar Produto por Id       |

---

## 🧪 Como Executar o Projeto

### 🔹 Pré-requisitos

* Java 21 instalado
* Maven instalado
* MySQL rodando

---

### 🔹 Passos

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/estoqueSpg.git

# Acesse a pasta
cd estoqueSpg

# Execute o projeto
./mvnw spring-boot:run
```

---

## 🗄️ Configuração do Banco de Dados

No arquivo `application.properties`, configure:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco
spring.datasource.username=root
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 📚 Conceitos Aplicados

✔️ Programação Orientada a Objetos (POO)

✔️ API REST

✔️ DTO Pattern

✔️ Injeção de Dependência

✔️ Separação de responsabilidades

✔️ Tratamento de dados com Enum

---

## 📈 Melhorias Futuras

🔹 Tratamento global de exceções

🔹 Implementação de autenticação (Spring Security)

🔹 Paginação e ordenação

🔹 Testes unitários e de integração

---

## 👨‍💻 Autor

Desenvolvido por **Pedro Ferreira Gomes** 🚀

📚 Estudante de Análise e Desenvolvimento de Sistemas

💼 Focado em Backend Java

---

## ⭐ Objetivo

Este projeto foi desenvolvido com foco em aprendizado e evolução profissional, servindo como base sólida para aplicações mais robustas no futuro.

---

💬 *Sinta-se à vontade para contribuir ou dar sugestões!*
