# Desafio Backend

📌 Um sistema completo para gerenciamento de clientes com API RESTful, desenvolvido com Spring Boot e segurança JWT. Inclui validação de CPF, integração com serviço de CEP e gerenciamento de múltiplos contatos.

## 🔍 Visão Geral

Repositório contendo uma API RESTful completa para gerenciamento de clientes, implementada com Spring Boot e segurança JWT. O sistema permite:
- Cadastro de clientes com validação de CPF
- Integração com serviço de CEP
- Gerenciamento de múltiplos telefones e emails
- Autenticação por JWT com diferentes níveis de acesso

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot** 3.x
- **Spring Security** com JWT Authentication
- **Spring Data JPA** com Hibernate ORM
- **MySQL Database**
- **Docker & Docker Compose**
- **Maven**

## ⚙️ Configuração do Ambiente

### Pré-requisitos

- Java 17 ou superior
- Docker e Docker Compose
- Maven

### Instalação

```bash
# Clonar repositório
git clone https://github.com/Cabr1to/Desafio-Backend.git
cd Desafio-Backend/desafio/desafio

# Iniciar banco de dados MySQL com Docker
docker-compose up -d

# Compilar e executar a aplicação
./mvnw spring-boot:run
```

## 🏗️ Arquitetura

O projeto segue a arquitetura MVC (Model-View-Controller) com a seguinte estrutura:
```bash
com.sea.desafio/
├── config/           # Configurações do Spring e da aplicação
├── controller/       # Controladores REST
├── dto/              # Objetos de transferência de dados
├── exception/        # Tratamento de exceções
├── mapper/           # Conversores entre entidades e DTOs
├── model/            # Entidades JPA
├── repository/       # Interfaces de acesso a dados
├── security/         # Configuração de segurança e JWT
├── service/          # Lógica de negócios
└── resources/        # Propriedades da aplicação 
```

## 🔒 Segurança

Autenticação via JWT (JSON Web Token) com dois níveis de acesso:

ADMIN: Acesso completo (CRUD)

USER: Acesso limitado (leitura e criação)

Credenciais padrão para testes:

Admin: admin / password

Usuário: user / password


## 📝 Endpoints da API
Autenticação
```bash
POST /api/v1/auth/login      # Autenticar usuário e obter token JWT
```
Clientes
```bash
GET /api/v1/clients          # Listar todos os clientes

GET /api/v1/clients/{id}     # Buscar cliente por ID

POST /api/v1/clients         # Criar novo cliente

PUT /api/v1/clients/{id}     # Atualizar cliente existente

DELETE /api/v1/clients/{id}  # Excluir cliente
```

## 📊 Modelo de Dados (Exemplo)
```json
{
  "id": 1,
  "name": "Nome do Cliente",
  "cpf": "12345678900",  
  "address": {
    "cep": "12345678",
    "logradouro": "Rua Exemplo",
    "complemento": "Apto 101",
    "bairro": "Centro",
    "cidade": "São Paulo",
    "uf": "SP"
  },
  "phones": [
    {
      "type": "CELULAR",
      "number": "11987654321"
    },
    {
      "type": "RESIDENCIAL",
      "number": "1123456789"
    }
  ],
  "emails": [
    "exemplo@email.com",
    "contato@email.com"
  ]
}
```

## ✅ Validações Implementadas
Cliente
Nome: 3-100 caracteres, apenas letras, espaços e números

CPF: Validação de formato e algoritmo

Obrigatório: Pelo menos um telefone e um email

Endereço
CEP: Formato válido, com consulta automática

Campos obrigatórios: Logradouro, Bairro, Cidade e UF

Telefones
Tipos suportados: CELULAR, RESIDENCIAL ou COMERCIAL

Formato: Validação e máscara específica por tipo


## 🧪 Testando a API com Postman

Para facilitar os testes da API, disponibilizei uma Collection do Postman com todos os endpoints configurados.

### Como importar a Collection

1. Abra o Postman
2. Clique em "Import" no canto superior esquerdo
3. Selecione a opção "Raw text"
4. Cole o conteúdo JSON da Collection abaixo
5. Clique em "Import"
