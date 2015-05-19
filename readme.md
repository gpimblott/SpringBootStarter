# Starter project for Spring Boot using Gradle

This project is designed to get you up and running as fast as possible with a deployment ready
REST service.

It uses the following technologies:

 * Java
 * Spring Boot
 * Gradle

It demonstrates the following:

 * Seperate projects for the services, the domain objects and test client
 * End-to-End unit tests
 * Using Jetty instead of Tomcat as the container
 * Security on endpoints
 * Metrics
 * Standard and custom health checks
 * 'Fat JAR' deployment packaging
 * Default logging to both console and file
 
## Structure

The application is actually split into 3 project

 * Main Service
 * Domain models passed used by the service and client
 * Client example application
 
## Building the application
The application can be built outside of an IDE using the standard Gradle commands

* gradlew build
* gradle build (mac osx/unix)

The resulting application will be placed in the sub directory 'build/libs'

##Running the application
To run the standard Gradle utilities can be used

 * gradlew run
 * gradle run (mac osx/unix)

## Trying it out

Once the application is running it will expose a default REST service on port 8080

http://localhost:8080

The metrics services are also available on the following ports

 * http://localhost:8080/health
 