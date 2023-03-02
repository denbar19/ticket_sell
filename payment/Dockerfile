FROM amazoncorretto:11-alpine3.14-jdk AS stage1
ENV APP payment
ENV JVM_OPTS "-Xms512m -Xmx512m"
ARG APP_VERSION=${APP_VERSION}
WORKDIR /$APP
COPY /target/payment-"${APP_VERSION}".jar /$APP
EXPOSE 8080
ENTRYPOINT ["./entrypoint.sh"]
