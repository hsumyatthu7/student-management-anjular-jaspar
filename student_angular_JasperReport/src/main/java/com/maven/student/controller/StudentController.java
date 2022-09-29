package com.maven.student.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.maven.student.dao.CourseService;
import com.maven.student.dao.StudentService;

import com.maven.student.dto.Student;
import com.maven.student.model.CourseBean;
import com.maven.student.model.StudentBean;
import com.maven.student.reportService.StudentReportService;
import com.maven.student.reportService.UserReportService;

import net.sf.jasperreports.engine.JRException;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentReportService reportService;
	
	@ModelAttribute("studentBean")
	public StudentBean getStudentBean() {
		return new StudentBean();
	}
	
	@ModelAttribute("courseBean")
	public CourseBean getCourseBean() {
		return new CourseBean();
	}
	
	@GetMapping("/student")
    public List<Student> displayView (ModelMap model) { 
		return studentService.getAllStudent();
	}
	
	@GetMapping("/student/report/{format}")
	public  void generateReport(@PathVariable String format,HttpServletResponse response) throws JRException, IOException{
		reportService.exportReport(format,response);
	}
	
	@RequestMapping(value="/student" , method = RequestMethod.POST ,produces = "application/json")
	public Student addstudent(@RequestBody Student student) { 
	Student dto=new Student();
	dto.setStudentId(student.getStudentId());
	dto.setStudentName(student.getStudentName());
	dto.setStudentDob(student.getStudentDob());
	dto.setStudentGender(student.getStudentGender());
	dto.setStudentPhone(student.getStudentPhone());
	dto.setStudentEducation(student.getStudentEducation());
	dto.setStudentCourse(student.getStudentCourse());
	return studentService.save(dto);
		
	}
		
	@GetMapping("/student/{studentId}")
	public ResponseEntity<Student> getStudentByStudentId(@PathVariable String studentId){
		Student student =new Student();
		student=studentService.getStudentByStudentId(studentId);
		return ResponseEntity.ok(student);
	}
	 
	@PutMapping(value="/student/{studentId}",produces= "application/json")
	public ResponseEntity<Student> updateStudent(@PathVariable String studentId,@RequestBody Student studentdata){
		Student student=new Student();
		student=studentService.getStudentByStudentId(studentId);
		student.setStudentName(studentdata.getStudentName());
		student.setStudentDob(studentdata.getStudentDob());
		student.setStudentGender(studentdata.getStudentGender());
	    student.setStudentPhone(studentdata.getStudentPhone());
	    student.setStudentEducation(studentdata.getStudentEducation());
	    student.setStudentCourse(studentdata.getStudentCourse());
	    
	    Student updateStudent=studentService.update(student, studentId);
	    return ResponseEntity.ok(updateStudent);
	}

	@DeleteMapping("/student/{studentId}")
	public ResponseEntity<Map<String,Boolean>> deleteStudent(@PathVariable String studentId){
		studentService.delete(studentId);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}	
}
