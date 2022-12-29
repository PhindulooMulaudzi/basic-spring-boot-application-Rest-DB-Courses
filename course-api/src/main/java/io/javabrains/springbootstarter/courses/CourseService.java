package io.javabrains.springbootstarter.courses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class CourseService {
	
	// Remember Spring will create instances at Runtime, so we autowire it
	@Autowired
	private CourseRepository courseRepository;
	
	// this is our method that will get all topics from the business service
	// the only reason for this service in this case is persistance
	public List<Course> getAllCourses(String topicId){
		List<Course> courses = new ArrayList<>();
		
		// the findAll method comes with Spring JPA
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id) {
		// the findOne method comes with Spring JPA
		// Remember we indicated the the Key is a String so findOne needs an id string
//		return courseRepository.findOne(id);
		
		
		// we also do this using custom methods
		return courseRepository.findByName(id);
	}
	
	public void addCourse(Course course) {
		
		// the save method comes with Spring JPA
		courseRepository.save(course);	
	}
	
	public void updateCourse(Course course) {
		
		// the save method will do add and or update. It will overwrite if existing
		// if the instance doesnt exist it will do an insert
		courseRepository.save(course);
	}
	
	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}
}
