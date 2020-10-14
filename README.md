# JWT Token Based Authentication
## Introduction
This application use Spring Security with JWT Authentication to secure Jersey API's. Database provider used is MongoDB.

## Technologies
* Spring Security
* Spring Boot
* Spring Data Mongodb
* JWT
* Jersey

## Run application
```sh
$ mvn clean install
```
```sh
$ cd recruvia-backend/recruvia-rs/
```
```sh
$ java -jar target/recruvia-rs.jar
```

## Endpoints
### Register User
*POST* http://localhost:8095/recruvia/api/v1/user/register
{
	"email":"abc@gmail.com",
	"firstName":"somesh",
	"password":"test"
}

### Login
*POST* http://localhost:8095/recruvia/api/v1/login
{
	"email":"abc@gmail.com",
	"password":"test"
}

### Refresh Token
*GET* http://localhost:8095/recruvia/api/v1/refreshtoken

* NOTE :
Set Bearer Token in Authorization Header as refreshToken returned in the Login API response
	


