# ---------- BUILD STAGE ----------
FROM gradle:8-jdk17 AS build
WORKDIR /application

COPY . .
RUN chmod +x ./gradlew
RUN  ./gradlew clean :api:bootJar --no-daemon --rerun-tasks


# ---------- RUNTIME STAGE ----------
FROM openjdk:17-jdk-slim
WORKDIR /app

COPY --from=build /application/api/build/libs/*.jar api.jar

EXPOSE 8082
ENTRYPOINT ["java","-jar","api.jar"]
