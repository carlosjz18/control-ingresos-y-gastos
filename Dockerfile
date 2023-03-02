# Nos basamos en la ultima versión de openjdk
FROM openjdk:oracle

# Copiamos el archivo jar al contenedor
COPY target/control-ingresos-y-gastos-0.0.1-SNAPSHOT.jar control-ingresos-y-gastos.jar

# Exponemos el puerto del contenedor para aceptar conexiones
EXPOSE 8080

# Iniciamos la aplicación
CMD ["java", "-jar", "control-ingresos-y-gastos.jar"]