package io.javabrains.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * We add annotations to make this a spring controller
 * We will still be using RestAPI
 * 
 * 1. This class will work with the Topics class and returns a list of topics 
 * based on the mapping we have defined
 * 
 * 2. We also want to have CRUD funcionality, so we will impliment it for the topcis class
 * CRUD -> GET, POST, PUT, DELETE. We had already did a mapping for GET
 */

@RestController
public class TopicController {
	
	/* Injects a dependency of Topic controller to TopicService
	* It wires it to the existing TopicService that spring create when it boots up
	* Recall that service is a singleton, so we can only wire to the existing instance
	*/
	@Autowired
	private TopicService topicService;
	
	// The method below serves GET requests using our Topic Service
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		
		/* return objects are converted to JSON and sent back with HTTP response	
		* notice that we nerve init topicService since its done through AutoWired and linked to singleton
		*/
		return topicService.getAllTopics();
	}
	
	
	// The blow method also servers GET requests
	/* We use curly braces to map to different endpoints, this is a wild card
	 * Recall that id can be java or any other course so we need to do this dynamic mapping
	 * 
	 * in Spring these are known as Variable paths
	 */
	@RequestMapping(method = RequestMethod.GET, value = "topics/{var}")
	
	// Also note that we tell spring to send the Pathvariable as a paramater and equate it to String id
	public Topic getTopic(@PathVariable("var") String id) {
		return topicService.getTopic(id);
	}
	
	// We handle post requests that will be made at "/topics" 
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		/*
		 * We need to access the body of the post request
		 * and then tell spring to convert the JSON into a Topic object
		 */
		topicService.addTopic(topic);
	}
	
	// We handle PUT update requests that will be made at "/topics" 
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		/*
		 * We need to access the body of the post request
		 * and then tell spring to convert the JSON into a Topic object
		 */
		topicService.updateTopic(topic, id);
	}
	
	// We handle DELETE requests that will be made at "/topics" 
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		/*
		 * We need to access the body of the post request
		 * and then tell spring to convert the JSON into a Topic object
		 */
		topicService.deleteTopic(id);
	}
}
