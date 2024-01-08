FROM eclipse-temurin:17-jre-alpine


WORKDIR /springboot-software

COPY springboot-rest-demo-ws/target/springboot-rest-demo-ws-1.0.0-SNAPSHOT.jar .
COPY springboot-rest-demo-config/src/main/resources/springboot-rest-demo.yml .


###########
EXPOSE 8080

CMD ["java","-jar","springboot-rest-demo-ws-1.0.0-SNAPSHOT.jar"]
#pour tout executer cmd : "docker build ."