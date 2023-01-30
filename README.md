# Sistema de Control Ingresos y Gastos 💵

Sistema de Control de Ingresos y Gastos, para la administración financiera de una persona.

BEDU: Developer Engineering


MySQL container

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

## Construido con 🛠️

* [Java]() Lenguaje utilizado
* [SpringBoot]() Framework Java
* [Jenkins]() CI/CD
* [GitHub]() SCM
* [Docker]() Servidor de contenedores
* [IntelliJ IDEA]() Editor utilizado

## Autor ✒️

* **Carlos Jaimez** - *Código inicial* - [carlosjz18](https://github.com/carlosjz18)