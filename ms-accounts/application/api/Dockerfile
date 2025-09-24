# ---------- BUILD STAGE ----------
FROM gradle:8.3.1-jdk17 AS build
WORKDIR /app

# Copiamos archivos de build
COPY build.gradle settings.gradle ./
COPY src ./src

# Construimos el JAR
RUN gradle clean bootJar --no-daemon

# ---------- RUNTIME STAGE ----------
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copiamos el JAR generado
COPY --from=build /app/build/libs/*.jar app.jar

# Exponemos el puerto del microservicio
EXPOSE 8082

# Comando para ejecutar
ENTRYPOINT ["java","-jar","app.jar"]
