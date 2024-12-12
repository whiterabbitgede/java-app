# Use an official OpenJDK runtime as a parent image

#jdk small size 185 Mb
# FROM openjdk:17-jdk-alpine AS base
# FROM base AS build
FROM openjdk:17-jdk-alpine AS build

RUN apk update && apk add maven


# Set the working directory in the container
WORKDIR /app

ADD test-helloworld .


# with mvnw
# RUN chmod +x mvnw && \
#     ./mvnw install -DskipTests && \
#     ./mvnw compile -DskipTests && \
#     ./mvnw package -DskipTests 

# with mvn
RUN mvn install -DskipTests && \
    mvn compile -DskipTests && \
    mvn package -DskipTests 

# Expose port 34521 (default for itec)
EXPOSE 34521

CMD ["java", "-jar", "/app/target/test-helloworld-0.0.1-SNAPSHOT.jar"]

# link test https://localhost:34521/hello

# docker build -t java-17-alpine-app:0.0.1 .
# docker build -t java-17-app:0.0.1 .
# docker run -it -p 34521:34521 java-17-alpine-app:0.0.1 /bin/sh



# FROM openjdk:17-jdk-alpine AS runner
# WORKDIR /deployments
# COPY --from=build /app/target/*-SNAPSHOT.jar /deployments/app.jar  

# EXPOSE 34521
# USER 1001
# CMD java -jar /deployments/app.jar
