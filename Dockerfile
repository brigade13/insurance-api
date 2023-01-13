# Define base docker image
FROM openjdk:11
COPY target/insurance-1.0.jar /insurance.jar
ENTRYPOINT ["java","-jar", "insurance.jar"]