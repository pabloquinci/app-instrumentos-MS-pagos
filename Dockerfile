FROM eclipse-temurin:17
LABEL mentainer="pquinci@gmail.com"
WORKDIR /app
COPY target/springboot-instr-mp-docker.jar /app/springboot-instr-mp-docker.jar
ENTRYPOINT ["java","-jar","springboot-instr-mp-docker.jar"]