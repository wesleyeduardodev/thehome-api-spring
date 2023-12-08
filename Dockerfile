FROM openjdk:17-jdk-alpine

RUN apk update
RUN apk add tzdata
RUN cp /usr/share/zoneinfo/America/Sao_Paulo /etc/localtime
RUN echo "America/Sao_Paulo" >  /etc/timezone
RUN apk update && apk add bash

ENV TZ America/Sao_Paulo
ENV LANG pt_BR.UTF-8
ENV LANGUAGE pt_BR.UTF-8
ENV LC_ALL pt_BR.UTF-8


COPY /target/thehome-api-spring-0.0.1-SNAPSHOT.jarr /thehome-api.jar

#WORKDIR /app
ENTRYPOINT bash -c "java --add-opens java.base/java.lang=ALL-UNNAMED $JAVA_OPTS -Dmanagement.endpoints.web.exposure.include=health -Djava.security.egd=file:/dev/./urandom -jar /thehome-api.jar"
