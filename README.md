# springboot-mongodb-docker
### Build project using maven
```bash
mvn clean install
```

### Create docker image
```docker
docker build -t school/spring-mongo-docker .
```

### Deploy Application Using Docker Compose 

```docker-compose 
docker-compose up -d 
```
