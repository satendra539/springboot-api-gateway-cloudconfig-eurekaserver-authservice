FROM java:8-jdk-alpine
COPY ./target/ephs-auth-service-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch ephs-auth-service-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","ephs-auth-service-0.0.1-SNAPSHOT.jar"]