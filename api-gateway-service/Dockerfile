FROM java:8-jdk-alpine
COPY ./target/ephs-api-gateway-service-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch ephs-api-gateway-service-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","ephs-api-gateway-service-0.0.1-SNAPSHOT.jar"]
