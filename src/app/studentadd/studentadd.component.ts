import { Component, OnInit } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';
import { Course } from '../course';
import { CourseService } from '../course.service';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';
@Component({
  selector: 'app-studentadd',
  templateUrl: './studentadd.component.html',
})
export class StudentaddComponent implements OnInit {

  // studentForm !: FormGroup;
  // submitted = false;
  time = new Date().toDateString();
  student:Student=new Student();
  courses : Course[] = [];
  currentUser= sessionStorage.getItem("userId");

  
  constructor(private studentService: StudentService, private courseService : CourseService ,
    private router: Router,
    private formBuilder : FormBuilder) { }
     
    
    ngOnInit(): void {
      this.student.studentCourse = '';
      this.courseService.getCourseList()
      .subscribe(data => {
        // console.log(data)
        this.courses = data;
      })
   }
  saveStudent(){
    console.log( this.student)
    this.studentService.createStudent(this.student)
    .subscribe(data =>{
      console.log(data);
      this.goToStudentList();
    }
    );

    // this.studentForm = this.formBuilder.group({
    //   'studentId' : ['', Validators.required],
    //   'studentName' : ['', Validators.required],
    //   'studentDob' : ['', Validators.required],
    //   'studentGender' : ['', Validators.required],
    //   'studentPhone' : ['', Validators.required]
    // })

  }
    goToStudentList(){
      this.router.navigate(['/student']);
    }
  onSubmit(){
    if(this.student.studentId==="" ||
      this.student.studentName=== "" ||
      this.student.studentDob === "" ||
      this.student.studentPhone === "" ||
      this.student.studentGender==="" ||
      this.student.studentEducation===""||
      this.student.studentCourse.length===0){
      alert("insert all data")
      this.router.navigate(['/studentadd/']);
    }else {
      console.log(this.student);
      this.saveStudent();
    }

    
  
   }

   handleSetCourse( courseId : string ){
    // console.log(courseId)
      if( this.student.studentCourse.includes(courseId) ){
        this.student.studentCourse = this.student.studentCourse.replace( `${courseId},` , "");
      }else{
        this.student.studentCourse += courseId+",";
      }
      console.log(this.student.studentCourse  )
   }
}
