[![Gitpod ready-to-code](https://img.shields.io/badge/Gitpod-ready--to--code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/Tuv01/rquarkusweb)

#  Quarkus Backend development with Java and GraalVM
## Learn how to build native backend applications with Quarkus. 
###### Project based on the [Udemy course](https://www.udemy.com/course/quarkus-backend-development-java/) created by Dmytro Chaban CEO at DonauTech

Course Content:

    Use Quarkus framework for backend development
    REST API with Quarkus
    Hibernate, JPA, Websockets with Quarkus
    Documentation of endpoints with Quarkus
    Reactive approach
    Swagger, Open API and documentation made easy with Quarkus
    RDBMS, NO-SQL with Quarkus
    Messaging with Quarkus
    Backend Security with Quarkus
    Cloud, Kubernetes, Native images with Quarkus
    Using Kotlin with Quarkus
    
# rquarkusweb project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `rquarkusweb-1.0.0-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/rquarkusweb-1.0.0-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/rquarkusweb-1.0.0-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.
