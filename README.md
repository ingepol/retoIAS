# retoIAS
Reto tecnológico Ingeniería, Aplicaciones y Software IAS

## Prerequisitos

Java JDK 8 y Maven son requeridos para correr el api.
NodeJs - Npm son requeridos para el front


## Api Rest

Para correr la api rest ingresar a la carpeta rest-api-ias y posteriormente ejecutar los comandos

```bash
mvnw clean package
java -jar target\rest-api-ias-0.0.1-SNAPSHOT.jar
```
o para correr con spring boot

```bash
mvnw spring-boot:run
```

El api tiene una restricción de origen de las peticiones solo permite guardar, borrar o actualizar desde la aplicación front, es decir, desde el origen localhost:4200  La api solo permite desde cualquier origen la petición GET a la URL http://localhost:8083/birds

## Front-End

Para correr la app web ingresar a la carpeta front-ias y posteriormente ejecutar los comandos

```bash
npm install 
npm start o ng serve
```

Para ingresar a la app abrir un navegador y acceder a localhost:4200
