<h1 align = "center"> User Registration and Login API </h1>

<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.0.6-brightgreen.svg" />
</a>
  </p>

  ## Technologies Used
* Java
* Spring Boot
* Mysq
* Hibernate

* ## Database Configuration
* To connect to a MySQL database, update the application.properties file with the appropriate database URL, username, and password. The following properties need to be updated:
```
SERVER.PORT=8080
spring.datasource.url=jdbc:mysql://localhost:3306/UserLogin?autoReconnect=true&useSSL=false&createDatabaseIfNotExist=true
#spring.datasource.url = jdbc:mysql://localhost:3306/UserLogin
spring.datasource.username=root
spring.datasource.password=ankit@9145
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true

```



>## API Endpoints
> Endpoint: POST /api/register
>### EndPoint for Register - http://localhost:8080/api/register


 * validation add for email and password (upper case special symbol and digit)
   
```JSON
{
  "username": "ankit",
  "email": "ankit@gmail.com",
  "password": "P@ssw0rd",  
  "phone_no": "9370215465"
}

```
> Endpoint: POST /api/logIn
>### EndPoint for LogIn - http://localhost:8080/api/logIn 

```JSON
{
  "email": "ankit@gmail.com",
  "password": "P@ssw0rd"
}
```

![Screenshot (1800)](https://github.com/ankitSarwar/User_RegisterAnd_Login/assets/111841677/6ec56e7f-e7ce-4fbd-af9d-33f06b09c9a2)


![Screenshot (1801)](https://github.com/ankitSarwar/User_RegisterAnd_Login/assets/111841677/fc4b9954-8734-4f30-8ac6-ecb794d23a2a)
