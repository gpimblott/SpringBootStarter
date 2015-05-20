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

---
## Structure

The application is actually split into 3 project

 * Main Service
 * Domain models used by the service and client
 * Client example application

---
## Building the application
The application can be built outside of an IDE using the standard Gradle commands

 * gradlew build

The resulting application will be placed in the sub directory 'build/libs'

## Running the application
To run the standard Gradle utilities can be used

 * gradlew run

---
## Trying it out

Once the application is running it will expose several REST services, all of which are protected by basic authentication.  If you
are using a browser you will be prompted for credentials, you could also use a tool such as Postman and enter the basic authentication
credentials.

Default users configured.
User: admin Password: password
User: user1 Password: password
User: user2 Password: password
User: user3 Password: password

 * http://localhost:8080/

This will display a hello message.

The metrics services are also available on the following paths

 * http://localhost:8080/health
 * http://localhost:8080/metrics
 * http://localhost:8080/env
 * http://localhost:8080/autoconfig
 * http://localhost:8080/beans
 * http://localhost:8080/configprops
 * http://localhost:8080/dump
 * http://localhost:8080/info
 * http://localhost:8080/trace
 * http://localhost:8080/mappings
 * http://localhost:8080/shutdown

## More complex security examples

There is also a default 'person' service that demonstrates more complex security scenarios.

 * http://localhost:8080/person/

Only admin user can access this service and it will list all the defined users.

 * http://localhost:8080/person/{username}

Only the authenticated user, or admin, can access the profile