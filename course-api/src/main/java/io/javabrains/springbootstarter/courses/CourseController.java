package io.javabrains.springbootstarter.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

/*
 * We add annotations to make this a spring controller
 * We will still be using RestAPI
 * 
 * 1. This class will work with the Topics class and returns a list of topics 
 * based on the mapping we have defined
 * 
 * 2. We also want to have CRUD functionality, so we will implement it for the topics class
 * CRUD -> GET, POST, PUT, DELETE. We had already did a mapping for GET
 */

@RestController
public class CourseController {
	
	/* Injects a dependency of Topic controller to TopicService
	* It wires it to the existing TopicService that spring create when it boots up
	* Recall that service is a singleton, so we can only wire to the existing instance
	*/
	@Autowired
	private CourseService courseService;
	
	// The method below serves GET requests using our Topic Service
	@RequestMapping("topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		
		/* return objects are converted to JSON and sent back with HTTP response	
		* notice that we nerve init topicService since its done through AutoWired and linked to singleton
		*/
		return courseService.getAllCourses(id);
	}
	
	
	// The blow method also servers GET requests
	/* We use curly braces to map to different endpoints, this is a wild card
	 * Recall that id can be java or any other course so we need to do this dynamic mapping
	 * 
	 * in Spring these are known as Variable paths
	 */
	@RequestMapping(method = RequestMethod.GET, value = "topics/{topicId}/courses/{id}")
	
	// Also note that we tell spring to send the Pathvariable as a paramater and equate it to String id
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	// We handle post requests that will be made at "/topics" 
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		/*
		 * We need to access the body of the post request
		 * and then tell spring to convert the JSON into a Topic object
		 */
		
		// The below line commented out doesnt seem to make sense
		// Apparently its to make sure that we dont have to specify a topic in order to update a course
		course.setTopic(new Topic(topicId, "",""));
		
		courseService.addCourse(course);
	}
	
	// We handle PUT update requests that will be made at "/topics" 
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId ,@PathVariable String id) {
		/*
		 * We need to access the body of the post request
		 * and then tell spring to convert the JSON into a Topic object
		 */
		
		// The below line commented out doesnt seem to make sense
		// Apparently its to make sure that we dont have to specify a topic in order to update a course
		course.setTopic(new Topic(topicId, "",""));
		
		courseService.updateCourse(course);
	}
	
	// We handle DELETE requests that will be made at "/topics" 
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id) {
		/*
		 * We need to access the body of the post request
		 * and then tell spring to convert the JSON into a Topic object
		 */
		
		//This will just delete the course regardless of the Topic`
		courseService.deleteCourse(id);
	}
}
