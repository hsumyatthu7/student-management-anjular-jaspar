package com.maven.student.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.student.dto.Student;


@Service
public class StudentService {
@Autowired
StudentRepository studentRepository;

public List<Student> getAllStudent(){
	List<Student> studlist=(List<Student>) studentRepository.findAll();
	return studlist;
}
public Student getStudentByStudentId(String studentid) {

return studentRepository.findBystudentId(studentid);

}
public Student save(Student student) {
	return studentRepository.save(student);
}
public void delete(String studentid) {
	studentRepository.deleteById(studentid);
}
public Student update(Student student,String studentid) {
	return studentRepository.save(student);
}
public List<Student> searchStudent(String studentid, String studentname, String studentcourse){
    List<Student> list=studentRepository.searchStudent(studentid, studentname,studentcourse);
    return list;
}
}
