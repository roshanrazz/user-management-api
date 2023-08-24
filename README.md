
# User Management System Api

This  project is built using java spring boot. This is an api to manage user using endpoints. H2 inmemory database is used as database for the project with default credentials.

A full documentation is created using swagger which can be accessed using http://localhost:8080/swagger-ui/index.html

Spring Security is implemented using jwt and authentication and authorization. You need to use postman with authorization header set else you will gwt access denied to api endpoints.

## Running the project
#### 1. git clone https://github.com/roshanrazz/user-management-api
#### 2. Open in editor like eclipse, spring-tool-suite,intelliJ IDEA, preferably spring-tool-suite as I have used for creation.
#### 3. Right click on project. Goto -> Run As -> Maven Build.
#### 4. In Goals type spring-boot:run and run the project.
#### Alternatively run the project from command prompt using mvn spring-boot:run command.
#### 5. Also project can be run from Dockerfile provided in project.
#### 6. You can also run project from docker image pushed in my docker hub repository by using -> docker pull roshanrazz/user-api
#### 7. Lastly you can use live link as it is deployed on server. Just replace localhost with 129.146.33.61 , Cannot gurantee if it works all the time

### Note : Port 8080 should be open else you need to change the port in application.properties

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
