package io.javabrains.springbootstarter.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * We need to tell Java Persistance API(JPA)  that this is an entity class (@Entity), this means that 
 * JPA knows to create a Table called topic, this table will have columns
 * corresponding to the class variables.
 * 
 * We also needs to tell JPA the Primary Key, we use a field level annotation called @Id
 */

@Entity
public class Topic {
	
	@Id
	private String id;
	private String name;
	private String description;
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

	public Topic() {

	}
	
	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
