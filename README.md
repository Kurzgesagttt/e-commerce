# 🛒 E-Commerce Distribuído com Autenticação e Comunicação via Kafka

## 🧪 Tecnologias Utilizadas

<div style="display: flex; flex-wrap: wrap; gap: 10px;">

![Java](https://img.shields.io/badge/Java-17-007396?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-secure-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-auth-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)
![Apache Kafka](https://img.shields.io/badge/Kafka-EventDriven-231F20?style=for-the-badge&logo=apache-kafka&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16.x-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Container-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-BuildTool-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

</div>

---

## 🧱 Arquitetura de Microsserviços

O sistema é dividido em 4 microsserviços principais:

### 🔐 AuthService
Responsável pela autenticação e gestão de usuários.

- Cadastro de novos usuários
- Login com autenticação baseada em JWT
- Segurança configurada com **Spring Security**
- Validação de tokens para acesso aos outros serviços
- Endpoints públicos para login e registro
- Endpoints protegidos por roles (`USER`,`SELLER`, `ADMIN`)

### 📦 OrderService
Gerencia pedidos e compras dos usuários.

- Criação de pedidos autenticados
- Validação do token JWT recebido via `Authorization: Bearer`
- Comunicação assíncrona com o **StockService** via **Kafka** para verificar e atualizar o estoque
- Emissão de eventos de compra para o **EmailService**

### 🏬 StockService
Controla o estoque dos produtos.

- Recebe mensagens do OrderService via Kafka
- Atualiza o estoque conforme as compras
- Publica mensagens de confirmação ou erro de estoque

### 📧 EmailService
Responsável por enviar e-mails aos usuários.

- Escuta eventos Kafka de login e compras
- Envia confirmações de compra e login
- Pode ser estendido para enviar notificações de promoções, alertas e redefinição de senha

## 🔁 Comunicação Entre Serviços

- **Kafka Topics**:
  - `order.created` — emitido pelo `OrderService` para o `StockService`
  - `stock.updated` — emitido pelo `StockService` de volta ao `OrderService`
  - `user.logged_in` e `order.confirmed` — emitidos para o `EmailService`

## 🛡️ Segurança

- Tokens JWT são gerados pelo `AuthService` e utilizados pelos demais serviços.
- Cada requisição aos serviços protegidos deve conter o header:
  ```http
  Authorization: Bearer <token>
