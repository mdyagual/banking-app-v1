# ---------- BUILD STAGE ----------
FROM gradle:8-jdk17 AS build
WORKDIR /app

# Copiamos build.gradle y la carpeta src
COPY build.gradle ./
COPY src ./src

# Construimos el JAR
RUN gradle clean build --no-daemon

# ---------- RUNTIME STAGE ----------
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copiamos el JAR generado
COPY build/libs/*.jar api.jar

# Exponemos el puerto del microservicio
EXPOSE 8082

# Comando para ejecutar
ENTRYPOINT ["java","-jar","api.jar"]
