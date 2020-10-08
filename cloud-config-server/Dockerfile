FROM java:8-jdk-alpine
COPY ./target/ephs-cloud-config-server-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch ephs-cloud-config-server-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","ephs-cloud-config-server-0.0.1-SNAPSHOT.jar"]
