FROM openjdk:8
EXPOSE 8081
ADD target/springboot-instr-ms-pago-docker.jar springboot-instr-ms-pago-docker.jar
ENTRYPOINT ["java","-jar","/springboot-instr-ms-pago-docker.jar"]