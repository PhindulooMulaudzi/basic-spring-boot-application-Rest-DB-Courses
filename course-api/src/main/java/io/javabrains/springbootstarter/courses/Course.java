package io.javabrains.springbootstarter.courses;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.javabrains.springbootstarter.topic.Topic;

/*
 * We need to tell Java Persistance API(JPA)  that this is an entity class (@Entity), this means that 
 * JPA knows to create a Table called topic, this table will have columns
 * corresponding to the class variables.
 * 
 * We also needs to tell JPA the Primary Key, we use a field level annotation called @Id
 */

@Entity
public class Course {
	
	@Id
	private String id;
	private String name;
	private String description;
	
	/* we need to tie courses to Topic instances
	* we need to tell spring know that Topic is a foreign key to the primary key of course table
	* we basically are relating two sql tables
	* Many to one relationship, many courses associated with a topic
	* Also gets SPRING to initialise this topic instance
	*/
	@ManyToOne
	private Topic topic;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Course() {

	}
	
	public Course(String id, String name, String description, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.setTopic(new Topic(topicId, "",""));
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}
