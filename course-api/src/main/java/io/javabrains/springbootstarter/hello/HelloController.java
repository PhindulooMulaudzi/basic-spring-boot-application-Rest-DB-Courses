package io.javabrains.springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Need to annotate it for spring framework so that it knows it is a controller
 * 
 * We are going to use RestAPI in our case to generate JSON responses
 * 
 * The controller class will determine what happens when a URI request is received
 * 
 * Basically we have methods that will map to URL requests
 */

@RestController
public class HelloController {
	
/*
 * 
 * We create a request mapping for GET request as follows
 * The aim is when "/hello" URL is accessed the method with the relevant mapping is invoked 
 *  
 */
	
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hi";
	}
}
