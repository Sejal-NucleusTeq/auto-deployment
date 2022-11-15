FROM openjdk:8
LABEL maintainer="sejal.jain"
ADD target/inventory-management-docker.jar inventory-management-docker.jar
ENTRYPOINT ["java", "-jar", "/inventory-management-docker.jar"]
EXPOSE 8080
