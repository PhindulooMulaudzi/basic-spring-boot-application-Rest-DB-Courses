package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/*
 * Instead of creating a new List that is converted to JSON everytime "/endpoint" is requested, 
 * we use a spring business service that will be persistant and we can just add or remove from it.
 * 
 * When application starts up, all service classes have an instance created
 * 
 * @Service annotation lets Spring know our class is a business service
 * 
 */

@Service
public class TopicService {
	
	// Remember Spring will create instances at Runtime, so we autowire it
	@Autowired
	private TopicRepository topicRepository;
	
	// this is our method that will get all topics from the business service
	// the only reason for this service in this case is persistance
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		
		// the findAll method comes with Spring JPA
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		// the findOne method comes with Spring JPA
		// Remember we indicated the the Key is a String so findOne needs an id string
		return topicRepository.findOne(id);
	}
	
	public void addTopic(Topic topic) {
		
		// the save method comes with Spring JPA
		topicRepository.save(topic);	
	}
	
	public void updateTopic(Topic topic, String id) {
		
		// the save method will do add and or update. It will overwrite if existing
		// if the instance doesnt exist it will do an insert
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		topicRepository.delete(id);
	}
}
