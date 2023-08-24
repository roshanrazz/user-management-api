
# User Management System Api

This  project is built using java spring boot. This is an api to manage user using endpoints. H2 inmemory database is used as database for the project with default credentials.

A full documentation is created using swagger which can be accessed using http://localhost:8080/swagger-ui/index.html

Spring Security is implemented using jwt and authentication and authorization.

## Credentials
### Role User
Username : roshan

password : pass123

### Role Admin 
Username : admin

password : admin123

## Endpoints

### Get jwt token 
POST -> http://localhost:8080/auth/login

Note : Use the generated token in header with request as:
Authorization: Bearer {jwt_token_here}

### List all users (only admin feature)
GET -> http://localhost:8080/api/users
### Get a single user
GET -> http://localhost:8080/api/users/{username}
### Add user (No jwt token required to create user)
POST -> http://localhost:8080/api/users
### Get users by first name
GET -> http://localhost:8080/api/users/first-name/{firstName}

### Get users by last name
GET -> http://localhost:8080/api/users/last-name/{lastName}
### Get user by email
GET -> http://localhost:8080/api/users/email/{email}
### Update user
PUT -> http://localhost:8080/api/users/{id}
### Delete User (only admin feature)
DELETE -> http://localhost:8080/api/users/{id}
