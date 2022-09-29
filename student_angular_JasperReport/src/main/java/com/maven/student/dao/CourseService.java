package com.maven.student.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.maven.student.dto.Course;
@Service
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
	
	public List<Course> getAllCourse(){
		List<Course> courselist=(List<Course>) courseRepository.findAll();
		return courselist;
	}
	
	public Course save(Course course) {
		return courseRepository.save(course);
	}

}
