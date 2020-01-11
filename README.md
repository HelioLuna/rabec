# RA Backend Challenge

API desenvolvida utilizando Java / Maven / Spring Boot (version 2.2.2) / MongoDB

# Pré requisitos

- Docker (https://www.docker.com/)
- Lombok instalado na IDE (IntelliJ IDEA Ex: https://dicasdejava.com.br/como-configurar-o-lombok-no-intellij-idea/)

# 3 Passos para rodar o projeto

1 - Rodar arquivo docker-compose.yml na raiz do projeto. (Ex: docker-compose up -d)
2 - Baixar as dependências do projeto com o Maven.
3 - Startar o projeto da IDE.

# Documentação

## Endpoints

Complaint
```
localhost:8080/api/complaint
localhost:8080/api/complaint/{id}
localhost:8080/api/complaint/all
localhost:8080/api/complaint/city/{idCity}/company/{idCompany}
```

Company 
```
localhost:8080/api/company
localhost:8080/api/company/{id}
localhost:8080/api/company/all
```

City
 
```
localhost:8080/api/city
localhost:8080/api/city/{id}
localhost:8080/api/ccityy/all
```