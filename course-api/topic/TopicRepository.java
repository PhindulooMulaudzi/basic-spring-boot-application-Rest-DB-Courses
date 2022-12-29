package io.javabrains.springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;

/*
 * Spring framework provides a repository for all CRUD related entity classes
 * We just extend it
 * 
 * Takes a generic type (Entity class we working with, Type of Id that entity class has
 */
public interface TopicRepository extends CrudRepository<Topic, String>{
	// All CRUD methods already available and dont need to be implimented
}
