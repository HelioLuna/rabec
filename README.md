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

City
```
localhost:8080/api/city
localhost:8080/api/city/{id}
localhost:8080/api/ccityy/all
```

Company 
```
localhost:8080/api/company
localhost:8080/api/company/{id}
localhost:8080/api/company/all
```

Complaint
```
localhost:8080/api/complaint
localhost:8080/api/complaint/{id}
localhost:8080/api/complaint/all
localhost:8080/api/complaint/city/{idCity}/company/{idCompany}
```

## City

```
POST - localhost:8080/api/city
Accept: application/json
Content-Type: application/json

{
   "name": "Maceió" 
}
```

```
PUT - localhost:8080/api/city
Accept: application/json
Content-Type: application/json

{
   "id": "5e179a597f80820d649600ec",
   "name": "Maceió" 
}
```

```
GET - localhost:8080/api/city/{id} ex: "5e179a597f80820d649600ec"

{
   "id": "5e179a597f80820d649600ec",
   "name": "Maceió" 
}
```

```
GET - localhost:8080/api/city/all

[
    {
        "id": "5e179a597f80820d649600ec",
        "name": "Maceió" 
    },
    {
        "id": "5e195cf5dc99e03dbb08d676",
        "name": "Recife"
    }
]
```

## Company

```
POST - localhost:8080/api/company
Accept: application/json
Content-Type: application/json

{
   "name": "Lojas Americanas" 
}
```

```
PUT - localhost:8080/api/company
Accept: application/json
Content-Type: application/json

{
   "id": "5e179a597f80820d649600ec",
   "name": "Maceió" 
}
```

```
GET - localhost:8080/api/city/{id} ex: "5e178f1721fa515a918d69e9"

{
   "id": "5e178f1721fa515a918d69e9",
   "name": "Lojas Americanas" 
}
```

```
GET - localhost:8080/api/company/all

[
    {
        "id": "5e178f1721fa515a918d69e9",
        "name": "Lojas Americanas" 
    },
    {
        "id": "5e178f1721fa515a918d69e5",
        "name": "Wallmart"
    }
]
```

## Complaint

```
POST - localhost:8080/api/complaint
Accept: application/json
Content-Type: application/json

{
    "id": "5e195dc0dc99e03dbb08d678",
    "description": "QUEIXA ihuuuuuu",
    "locale": {
        "id": "5e179a597f80820d649600ec",
        "name": "Maceió"
    },
    "company": {
        "id": "5e178f1721fa515a918d69e9",
        "name": "Lojas Americanas"
    }
}
```
