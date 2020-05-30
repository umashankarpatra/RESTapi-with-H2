FROM openjdk:8
EXPOSE 8081
ADD target/pagination-docker.jar pagination-docker.jar
ENTRYPOINT ["java","-jar","/pagination-docker.jar"]