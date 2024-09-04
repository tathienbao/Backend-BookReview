# Backend-BookReview-Paf

## Set up

Running this backend app requires `Java 21`, the lasted version of `Spring-boot` and `Maven`.

### Set up mySQL in Docker:

```bash
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=bookreview -p 3306:3306 -d mysql
```

### Build

```bash
mvn clean package
```

```bash
mvn clean install
```

```bash
mvn spring-boot:run
```

### URL page

```
localhost:8080
```

## Secrets

```
get secrets from google drive and put them on this path as it is
backend/src/main/resources/application.properties
```
Delete soon:
https://docs.google.com/document/d/1etwpTNFNgPUxStUjCu2acNNpMdUIY3wmANcV2q0UEHU/edit?usp=sharing