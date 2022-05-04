
Steps to run the application with a connection to a MongoDB.
## 1. Create a docker volume
### ` docker volume create <name> `
## 2. Create a docker network
### ` docker netork create <name> `
## 3. Start a MongoDB docker image on port 27017
### `docker run -d --network pizzademo --volume pizza1 -p 27017:27017 mongo:4.0`
## 4. Start the application as a docker image on port 8080
### `docker run  -d --network pizzademo --volume pizza1 -p 8080:8080 ghcr.io/felixjacobsen/pizza:1.0.6` 
