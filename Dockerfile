# Dokerfile
FROM openjdk:21-ea-24-oracle

WORKDIR /app

COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
COPY Wallet_WMTRTPPFEQWRRW3C /app/Wallet_WMTRTPPFEQWRRW3C

EXPOSE 8080
CMD [ "java", "-jar", "app.jar" ]