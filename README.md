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

RESPONSE: HTTP 201 (Created)
```

```
PUT - localhost:8080/api/city
Accept: application/json
Content-Type: application/json

{
   "id": "5e179a597f80820d649600ec",
   "name": "Maceió" 
}

RESPONSE: HTTP 200 (OK)
```

```
GET - localhost:8080/api/city/{id} ex: "5e179a597f80820d649600ec"

{
   "id": "5e179a597f80820d649600ec",
   "name": "Maceió" 
}

RESPONSE: HTTP 200 (OK)
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

RESPONSE: HTTP 200 (OK)
```

## Company

```
POST - localhost:8080/api/company
Accept: application/json
Content-Type: application/json

{
   "name": "Lojas Americanas" 
}

RESPONSE: HTTP 201 (Created)
```

```
PUT - localhost:8080/api/company
Accept: application/json
Content-Type: application/json

{
   "id": "5e179a597f80820d649600ec",
   "name": "Maceió" 
}

RESPONSE: HTTP 200 (OK)
```

```
GET - localhost:8080/api/city/{id} ex: "5e178f1721fa515a918d69e9"

{
   "id": "5e178f1721fa515a918d69e9",
   "name": "Lojas Americanas" 
}

RESPONSE: HTTP 200 (OK)
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

RESPONSE: HTTP 200 (OK)
```

## Complaint

```
POST - localhost:8080/api/complaint
Accept: application/json
Content-Type: application/json

{
    "description": "MEU PRODUTO NÃO CHEGOU",
    "locale": {
        "id": "5e179a597f80820d649600ec",
        "name": "Maceió"
    },
    "company": {
        "id": "5e178f1721fa515a918d69e9",
        "name": "Lojas Americanas"
    }
}

RESPONSE: HTTP 201 (Created)
```

```
PUT - localhost:8080/api/complaint
Accept: application/json
Content-Type: application/json

{
    "id": "5e195dc0dc99e03dbb08d678",
    "description": "MEU PRODUTO NÃO CHEGOU NA DATA X",
    "locale": {
        "id": "5e179a597f80820d649600ec",
        "name": "Maceió"
    },
    "company": {
        "id": "5e178f1721fa515a918d69e9",
        "name": "Lojas Americanas"
    }
}

RESPONSE: HTTP 200 (OK)
```


```
GET - localhost:8080/api/complaint/{id} ex: "5e195dc0dc99e03dbb08d678"

{
    "id": "5e195dc0dc99e03dbb08d678",
    "description": "MEU PRODUTO NÃO CHEGOU NA DATA X",
    "locale": {
        "id": "5e179a597f80820d649600ec",
        "name": "Maceió"
    },
    "company": {
        "id": "5e178f1721fa515a918d69e9",
        "name": "Lojas Americanas"
    }
}

RESPONSE: HTTP 200 (OK)
```

```
GET - localhost:8080/api/complaint/all

[
    {
        "id": "5e195dc0dc99e03dbb08d678",
        "description": "MEU PRODUTO NÃO CHEGOU",
        "locale": {
            "id": "5e179a597f80820d649600ec",
            "name": "Maceió"
        },
        "company": {
            "id": "5e178f1721fa515a918d69e9",
            "name": "Lojas Americanas"
        }
    },
    {
        "id": "5e195dc0dc99e03dbb08d679",
        "description": "PRODUTO QUEBRADO",
        "locale": {
            "id": "5e179a597f80820d649600ec",
            "name": "Maceió"
        },
        "company": {
            "id": "5e178f1721fa515a918d69e9",
            "name": "Wallmart"
        }
    }
]

RESPONSE: HTTP 200 (OK)
```


```
GET - localhost:8080/api/complaint/city/{idCity}/company/{idCompany} ex: city - 5e179a597f80820d649600ec , company - 5e178f1721fa515a918d69e9 (Maceió, Lojas Americanas)

[
    {
        "id": "5e195dc0dc99e03dbb08d678",
        "description": "MEU PRODUTO NÃO CHEGOU",
        "locale": {
            "id": "5e179a597f80820d649600ec",
            "name": "Maceió"
        },
        "company": {
            "id": "5e178f1721fa515a918d69e9",
            "name": "Lojas Americanas"
        }
    }
]

RESPONSE: HTTP 200 (OK)
```