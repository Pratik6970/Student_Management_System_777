FROM openjdk:17

WORKDIR /app

COPY ./target/Student_Management_MVC_111-0.0.1-SNAPSHOT.jar /app/Student_Management_MVC_111-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT [ "java" ,"-jar","Student_Management_MVC_111-0.0.1-SNAPSHOT.jar"]
