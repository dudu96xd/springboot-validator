FROM java:8

VOLUME /tmp

EXPOSE 8081

ADD /target/api-validator-0.0.1.jar api-validator-0.0.1.jar

ENTRYPOINT ["java","-jar","api-validator-0.0.1.jar"]