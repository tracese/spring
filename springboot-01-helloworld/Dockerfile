FROM java:8
VOLUME /tmp
ADD springboot-01-helloworld-1.0-SNAPSHOT.jar webapp.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/webapp.jar"]