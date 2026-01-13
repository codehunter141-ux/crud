FROM amazoncorretto:17
WORKDIR /app

# Sabhi .jar files ko target folder se copy karein aur app.jar naam de dein
COPY target/*.jar app.jar

EXPOSE 8080

# app.jar ko run karein
ENTRYPOINT ["java", "-jar", "app.jar"]
