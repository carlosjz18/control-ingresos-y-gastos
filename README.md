# Sistema de Control Ingresos y Gastos 💵

Sistema de Control de Ingresos y Gastos, para la administración financiera de una persona.

BEDU: Developer Engineering

## MySQL Container

- nombre: MYSQL_IP
- valor: 172.17.0.2 / 172.17.0.3
---
- nombre: MYSQL_PASSWORD
- valor: abcD_1234
---
- nombre: MYSQL_USER
- valor: root
---

- Conectarse a la BD MySQL desde terminal de container
> mysql -h localhost -u root -p

- Crear base de datos
> mysql> create database control_ingresos_gastos;

- Ver bases de datos
> mysql> show databases;

- Usar BD
> mysql> use control_ingresos_gastos;

- Mostrar tablas de la BD
> mysql> show tables;


- Mostrar datos de la tabla usuarios
> mysql> select * from usuarios;

- Imagen y Container Docker para la aplicación (Dockerfile)
> docker image build -t my-app-java:latest .

> docker container run -p 8080:8080 -d --name container-app-jar my-app-java
> 
## Dependencias del proyecto

| Dependencia                             | Versión |
|-----------------------------------------|---------|
| JDK                                     | 17      |
| Spring Boot                             | 3.0.2   |   
| Spring Data JPA                         | 3.0.2   |
| Spring Validation (Hibernate validator) | 3.0.2   |
| Spring Security                         | 6.0.1   |
| MySQL Connector                         | 8.0.32  |
| Lombok                                  | 1.18.24 |
| MapStruct                               | 1.5.3   |
| JJWT                                    | 0.11.5  |

 
## Perfiles de Usuario

| Rol   | API Methods / Endpoints                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
|-------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ADMIN | `GET /api/usuarios`<br/>`GET /api/usuarios/{idUsuario}`<br/>`POST /api/usuarios`<br/>`PUT /api/usuarios/{idUsuario}`<br/>`DELETE /api/usuarios/{idUsuario}`                                                                                                                                                                                                                                                                                                                   |
| USER  | `GET /api/ingresos`<br/>`GET /api/ingresos/{idIngreso}`<br/>`POST /api/ingresos`<br/>`PUT /api/ingresos/{idIngreso}`<br/>`DELETE /api/ingresos/{idIngreso}`<br/><br/>`GET /api/gastos`<br/>`GET /api/gastos/{idGasto}`<br/>`POST /api/gastos`<br/>`PUT /api/gastos/{idGasto}`<br/>`DELETE /api/gastos/{idGasto}`<br/><br/>`GET /api/cuentas`<br/>`GET /api/cuentas/{idCuenta}`<br/>`POST /api/cuentas`<br/>`PUT /api/cuentas/{idCuenta}`<br/>`DELETE /api/cuentas/{idCuenta}` |

## Usuarios
| Nombre        | Correo           | Password | Rol   |
|---------------|------------------|----------|-------|
| Carlos Jaimez | carlos@gmail.com | 123      | ADMIN |
| Pedro Juárez  | pepe@gmail.com   | 123      | USER  |
| Ana López     | ana@gmail.com    | 123      | USER  |

## Objeto Success Response
```
@Data
public class ResponseSuccess {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private String status;
    private int statusCode;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;
}
```

## Objeto Error Response
```
@Data
public class ResponseError {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private String status;
    private int statusCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, String> errors;
    private String message;
    private String path;
}
```

## Success Responses

### Ok
* `HTTP CODE: 200`
* Respuesta éxitosa.  
<br/>
* GET Usuarios

```
{
    "timestamp": "2023-02-23T21:44:46.3495584",
    "status": "OK",
    "statusCode": 200,
    "message": "Información recuperada con éxito!",
    "data": [
        {
            "usuarioId": 1,
            "nombre": "Carlos Jaimez",
            "correo": "carlos@gmail.com",
            "contrasena": "$2a$10$cSMFz/pDfrPOvDmpSA7OhO/TtuiYYEf.IGv7SvvWX/gd6/g0MxchK",
            "rol": "ADMIN"
        },
        {
            "usuarioId": 2,
            "nombre": "Pedro Juárez",
            "correo": "pepe@gmail.com",
            "contrasena": "$2a$10$fCaJQoi2aDn/fpj80VQ6A.ISiQs7X6nUxXyEvLjvZb4NVAUDwEsUK",
            "rol": "USER"
        },
        {
            "usuarioId": 3,
            "nombre": "Ana López",
            "correo": "ana@gmail.com",
            "contrasena": "$2a$10$4jpwUOcDJUvdNcWTN4sAN.kCXvo.zpO9kXwz1yXg9HecszKQoU0om",
            "rol": "USER"
        }
    ]
}
```
* GET Usuario por Id

```
{
    "timestamp": "2023-02-23T21:51:57.6762281",
    "status": "OK",
    "statusCode": 200,
    "message": "Información recuperada con éxito!",
    "data": {
        "usuarioId": 1,
        "nombre": "Carlos Jaimez",
        "correo": "carlos@gmail.com",
        "contrasena": "$2a$10$cSMFz/pDfrPOvDmpSA7OhO/TtuiYYEf.IGv7SvvWX/gd6/g0MxchK",
        "rol": "ADMIN"
    }
}
```
* POST Usuario

```
{
    "timestamp": "2023-02-23T21:37:14.4704776",
    "status": "OK",
    "statusCode": 200,
    "message": "Usuario agregado correctamente.",
    "data": {
        "usuarioId": 4,
        "nombre": "Raul Castillo",
        "correo": "raul.castillo@gmail.com",
        "contrasena": "12345678",
        "rol": "USER"
    }
}
```
* PUT Usuario

```
{
    "timestamp": "2023-02-23T21:55:02.7449624",
    "status": "OK",
    "statusCode": 200,
    "message": "Usuario actualizado correctamente."
}
```
* DELETE Usuario

```
{
    "timestamp": "2023-02-23T21:40:15.5529935",
    "status": "OK",
    "statusCode": 200,
    "message": "Usuario eliminado correctamente."
}
```

### No Content
* `HTTP CODE: 204`
* Código HTTP 204 significa «Sin contenido». Indica que el servidor ha procesado correctamente la solicitud del cliente, pero no tiene nada que devolver.

## Error Responses

### MethodArgumentNotValidException
* `HTTP CODE: 400`
* Error reponse para excepciones de validaciones Spring MVC Validation.
```
{
    "timestamp": "2023-02-22T22:47:50.8787905",
    "status": "Bad Request",
    "statusCode": 400,
    "errors": {
        "contrasena": "La contraseña no puede estar vacía",
        "correo": "El correo debe ser valido",
        "nombre": "El nombre del usuario debe tener al menos 5 letras y ser menor a 45",
        "rol": "El rol no puede estar vacío"
    },
    "message": "Los campos no cumplen la validación",
    "path": "/api/usuarios"
}
```

### HttpRequestMethodNotSupportedException
* `HTTP CODE: 405`
* Error reponse cuando el método no es soportado por el endpoint GET/POST/PUT/DELETE.
```
{
    "timestamp": "2023-02-22T22:51:16.317774",
    "status": "Method Not Allowed",
    "statusCode": 405,
    "message": "El método POST no está soportado para esta petición. Los métodos soportados son DELETE, PUT, GET",
    "path": "/api/usuarios/1"
}
```

### NoHandlerFoundException
* `HTTP CODE: 404`
* Error reponse para recursos no encontrados.
```
{
    "timestamp": "2023-02-22T22:52:50.2975251",
    "status": "Not Found",
    "statusCode": 404,
    "message": "No se encontró el recurso solicitado: /api/graficas",
    "path": "/api/graficas"
}
```

### ResourceNotFoundException (Custom Exception)
* `HTTP CODE: 404`
* Error reponse para excepciones cuando información no es encontrada en BD.
```
{
    "timestamp": "2023-02-22T22:54:53.1108177",
    "status": "Not Found",
    "statusCode": 404,
    "message": "Usuario no encontrado con id: 33",
    "path": "/api/usuarios/33"
}
```

### AuthenticationException
* `HTTP CODE: 401`
* Error reponse para AuthenticationException, cuando se intenta iniciar sesión con las credenciales incorrectas.
```
{
    "timestamp": "2023-02-22T22:16:36.3223809",
    "status": "Unauthorized",
    "statusCode": 401,
    "message": "Full authentication is required to access this resource",
    "path": "/error"
}
```

### AccessDeniedException
* `HTTP CODE: 401`
* Error reponse para AccessDeniedException, cuando se intenta acceder a un endpoint sin el rol correspondiente.
```
{
    "timestamp": "2023-02-22T22:38:23.841598",
    "status": "Unauthorized",
    "statusCode": 401,
    "message": "Access Denied",
    "path": "/api/usuarios/1"
}
```

### Exception
* `HTTP CODE: 500`
* Error reponse para el manejo del resto de las excepciones que pudieran ocurrir.
```
{
    "timestamp": "2023-02-22T23:04:30.0169205",
    "status": "Internal Server Error",
    "statusCode": 500,
    "message": "Could not open JPA EntityManager for transaction",
    "path": "/api/usuarios/33"
}
```

## Construido con 🛠️

* [Java]() Lenguaje utilizado
* [SpringBoot]() Framework Java
* [Jenkins]() CI/CD
* [GitHub]() SCM
* [Docker]() Servidor de contenedores
* [IntelliJ IDEA]() Editor utilizado

## Autor ✒️

* **Carlos Jaimez** - *Código inicial* - [carlosjz18](https://github.com/carlosjz18)