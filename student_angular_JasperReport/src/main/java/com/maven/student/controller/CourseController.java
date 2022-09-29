package com.maven.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.maven.student.dao.CourseService;
import com.maven.student.dto.Course;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	@ModelAttribute("courseBean")
	public Course getCourseBean() {
		return new Course();
	}
	
	@RequestMapping(value="/course" , method = RequestMethod.GET)
    public List<Course> displayView(ModelMap model){
		return courseService.getAllCourse();
	}
    
	
	@PostMapping(value="/course",produces="application/json")
	public Course addcourse(@RequestBody Course course) {
		
		Course dto=new Course();
		dto.setCourseId(course.getCourseId());
		dto.setCourseName(course.getCourseName());
		return courseService.save(dto);
	}
}
