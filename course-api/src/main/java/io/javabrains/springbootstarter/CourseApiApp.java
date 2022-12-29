package io.javabrains.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @ SpringBootApplication
 * The annotation below tells Springboot that this class contains the main method
 * for our spring application
 * 
 */

@SpringBootApplication
public class CourseApiApp {

	public static void main(String[] args) {
		
		/*
		 * We now need to create our application in a servlet container that we can run, 
		 * we do this using the static method below. 
		 * 
		 * SpringApplication (class where we have main method, arguments to be passed to the app)
		 */
		
		SpringApplication.run(CourseApiApp.class, args);

	}

}
