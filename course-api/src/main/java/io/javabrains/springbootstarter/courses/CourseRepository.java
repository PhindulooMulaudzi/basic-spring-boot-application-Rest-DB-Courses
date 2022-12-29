package io.javabrains.springbootstarter.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/*
 * Spring framework provides a repository for all CRUD related entity classes
 * We just extend it
 * 
 * Takes a generic type (Entity class we working with, Type of Id that entity class has
 */
public interface CourseRepository extends CrudRepository<Course, String>{
	// All CRUD methods already available and dont need to be implimented
	
	// We create this method since basic CRUD operation inssufficient
	public List<Course> findByTopicId(String topicId);
	
	
	// Custom method starting with word find
	// Spring will then provide the implimentation as long as its defind according
	// to the naming convention
	public Course findByName(String name);
}
