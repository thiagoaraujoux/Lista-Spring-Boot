# 📝 Projeto Lista de Tarefas

Uma aplicação simples de gerenciamento de tarefas (To-Do List) construída com Spring Boot, Thymeleaf e MySQL, utilizando Docker para facilitar a execução.

## 🚀 Funcionalidades

- Adicionar, editar e excluir tarefas
- Layout moderno com estilo Neomórfico
- Responsivo para dispositivos móveis
- Confirmação antes de excluir tarefas

---

## ✅ Pré-requisitos

Antes de executar o projeto, certifique-se de ter os seguintes itens instalados:

- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)

> Obs: Docker Desktop já inclui o Docker Compose por padrão.

---

## ⚙️ Como executar o projeto com Docker

1. Clone o repositório:
```bash
git clone https://github.com/thiagoaraujoux/Lista-Spring-Boot
```

2. Construa e inicie os containers com o Docker Compose:
```bash
docker-compose up -d
```

3. Acesse no navegador:
```
http://localhost:8080/tasks
```

## 🛠 Tecnologias

- Java 17+
- Spring Boot
- Thymeleaf
- MySQL
- Docker / Docker Compose
- CSS Neomorphism
