package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * If you are using Gradle, you can run the application from /complete using 
 *    ./gradlew bootRun. 
 * Or you can build the JAR file using 
 *    ./gradlew build. 
 * Then you can run the JAR file:
 *    java -jar build/libs/gs-accessing-mongodb-data-rest-0.1.0.jar
 *
 * If you are using Maven, you can run the application using ./mvnw spring-boot:run. 
 * Or you can build the JAR file with ./mvnw clean package. Then you can run the JAR file:
 *    java -jar target/gs-accessing-mongodb-data-rest-0.1.0.jar
 */

/*
@SpringBootApplication is a convenience annotation that adds all of the following:
	@Configuration tags the class as a source of bean definitions for the application context.
	@EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
	Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath. This flags the application as a web application and activates key behaviors such as setting up a DispatcherServlet.
	@ComponentScan tells Spring to look for other components, configurations, and services in the hello package, allowing it to find the controllers.
@reference: https://spring.io/guides/gs/rest-service	
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

/*
   Although it is possible to package this service as a traditional WAR file for deployment
   to an external application server, the simpler approach demonstrated above creates a 
   standalone application.
   You package everything in a single, executable JAR file, driven by a good old 
   Java main() method. Along the way, you use Spring’s support for embedding the 
   Tomcat servlet container as the HTTP runtime, instead of deploying to an external 
   instance.
   @reference: https://spring.io/guides/gs/rest-service/#_make_the_application_executable
*/   
