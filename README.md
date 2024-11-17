# MitoCode Technical Challenge

## Overview

This API REST based in Java with Spring Boot.

---

## Getting Started

1. Clone this repository.
2. Run `mvn clean install` to install the project dependencies.

---
## Services

### Students

- Description: Get list of students
- Path: `/api/v1/students`
- HTTP Verb: GET
- Body: none
- Response:

```json
{
  "status": 200,
  "message": "success",
  "data": [
    {
      "id": 1,
      "dni": "12312312",
      "nombres": "Mito",
      "apellidos": "X",
      "edad": 9
    },
    {
      "id": 2,
      "dni": "12312312",
      "nombres": "Code",
      "apellidos": "Y",
      "edad": 35
    }
  ]
}
```

- Title: Create students resource
- Path: `/api/v1/students`
- HTTP Verb: POST
- Body:
```json
{
  "nombres": "MitoCode",
  "apellidos": "XYZ",
  "dni": "12312312",
  "edad": 99
}

```
- Response:
```json
{
  "status": 201,
  "message": "success",
  "data": [
    {
      "id": 3,
      "dni": "12312312",
      "nombres": "MitoCode",
      "apellidos": "XYZ",
      "edad": 99
    }
  ]
}
```

### Courses

- Description: Get list of courses
- Path: `/api/v1/courses`
- HTTP Verb: GET
- Body: none
- Response:

```json
{
  "status": 200,
  "message": "success",
  "data": [
    {
      "id": 1,
      "nombre": "Kubernetes",
      "siglas": "K8S",
      "estado": true
    },
    {
      "id": 2,
      "nombre": "Backend Java 21",
      "siglas": "J21",
      "estado": true
    },
    {
      "id": 3,
      "nombre": "Base de Datos",
      "siglas": "BD",
      "estado": true
    }
  ]
}
```

- Title: Create course resource
- Path: `/api/v1/courses`
- HTTP Verb: POST
- Body:
```json
{
  "nombre": "Base de datos",
  "siglas": "BD",
  "estado": true
}

```
- Response:
```json
{
  "status": 201,
  "message": "success",
  "data": [
    {
      "id": 2,
      "nombre": "Base de datos",
      "siglas": "BD",
      "estado": true
    }
  ]
}
```

### Enrollment

- Description: Get list of enrollments
- Path: `/api/v1/enrollments`
- HTTP Verb: GET
- Body: none
- Response:

```json
{
  "status": 200,
  "message": "success",
  "data": [
    {
      "id": 1,
      "fecha_matricula": "2024-11-16T01:27:25",
      "estudiante": {
        "id": 1,
        "dni": "45645710",
        "nombres": "Joaquin",
        "apellidos": "Rojas Morales",
        "edad": 11
      },
      "detalle_matricula": [
        {
          "id": 1,
          "curso": {
            "id": 2,
            "nombre": "Backend Java 21",
            "siglas": "BD",
            "estado": true
          },
          "aula": "A-101"
        }
      ],
      "estado": true
    },
    {
      "id": 2,
      "fecha_matricula": "2024-11-16T01:27:25",
      "estudiante": {
        "id": 2,
        "dni": "45645710",
        "nombres": "Roger",
        "apellidos": "Rojas Effio",
        "edad": 35
      },
      "detalle_matricula": [
        {
          "id": 2,
          "curso": {
            "id": 2,
            "nombre": "Backend Java 21",
            "siglas": "BD",
            "estado": true
          },
          "aula": "A-101"
        }
      ],
      "estado": true
    },
    {
      "id": 3,
      "fecha_matricula": "2024-11-16T01:27:25",
      "estudiante": {
        "id": 3,
        "dni": "45645710",
        "nombres": "Lorenzo",
        "apellidos": "Rojas Morales",
        "edad": 9
      },
      "detalle_matricula": [
        {
          "id": 3,
          "curso": {
            "id": 1,
            "nombre": "Base de Datos",
            "siglas": "BD",
            "estado": true
          },
          "aula": "A-101"
        }
      ],
      "estado": true
    }
  ]
}
```

- Title: Create enrollments resource
- Path: `/api/v1/enrollments`
- HTTP Verb: POST
- Body:
```json
{
  "fecha_matricula": "2024-11-16T01:27:25",
  "estudiante": {
    "id": 3
  },
  "detalle_matricula": [
    {
      "curso": {
        "id": 2
      },
      "aula": "A-101"
    }
  ],
  "estado": true
}

```
- Response:
```json
{
  "status": 201,
  "message": "success",
  "data": [
    {
      "id": 3,
      "fecha_matricula": "2024-11-16T01:27:25",
      "estudiante": {
        "id": 3,
        "edad": 0
      },
      "detalle_matricula": [
        {
          "id": 3,
          "curso": {
            "id": 2,
            "estado": false
          },
          "aula": "A-101"
        }
      ],
      "estado": true
    }
  ]
}
```

- Description: Get list of courses enrollments and students
- Path: `/api/v1/enrollments/related/courses`
- HTTP Verb: GET
- Body: none
- Response:

```json
{
  "Base de datos": [
    "Joaquin Rojas Morales"
  ],
  "Backend Java 21": [
    "Lorenzo Rojas Morales",
    "Roger Rojas Effio"
  ]
}
```