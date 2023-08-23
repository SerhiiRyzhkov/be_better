# Use Ubuntu 22.04 as the base image
FROM ubuntu:22.04

# Install JDK 18
RUN apt-get update && \
    apt-get install -y openjdk-18-jdk

# Install Apache Maven 3.6.0
RUN apt-get update && \
    apt-get install -y maven

# Set the environment variables
ENV JAVA_HOME /usr/lib/jvm/java-18-openjdk-amd64
ENV MAVEN_HOME /usr/share/maven

# Add the Maven bin directory to the PATH environment variable
ENV PATH $MAVEN_HOME/bin:$PATH


WORKDIR /app

COPY pom.xml .
COPY src ./src
COPY application.properties ./src/main/resources/


RUN mvn clean package -DskipTests

CMD mvn org.codehaus.cargo:cargo-maven2-plugin:run

EXPOSE 8084