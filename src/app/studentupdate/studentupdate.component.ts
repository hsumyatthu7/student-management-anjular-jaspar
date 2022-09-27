import { Component, OnInit } from '@angular/core';
import { of } from 'rxjs';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { Router,ActivatedRoute } from '@angular/router';
import { Course } from '../course';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-studentupdate',
  templateUrl: './studentupdate.component.html',
  styleUrls: ['./studentupdate.component.css']
})
export class StudentupdateComponent implements OnInit {
  time = new Date().toDateString();
  studentId! : string;
  student:Student=new Student();
  courses : Course[] = [];
  currentUser= sessionStorage.getItem("userId");

  constructor(
    private studentService: StudentService,
    private route : ActivatedRoute,
    private router: Router,
    private courseService : CourseService
    ) { }



  ngOnInit(): void {
    this.student.studentCourse = '';
    this.studentId = this.route.snapshot.params['studentId'];
    this.studentService.getStudentByStudentId(this.studentId).subscribe(data => {
    this.student = data;
    this.courseService.getCourseList();
    
  }
  );

  this.course();

}
  
updateStudent(studentId: string,student:Student){
  this.studentService.updateStudent(studentId,student)
  .subscribe(data =>{
    console.log(data);
    this.goToStudentList();
  }
  );
}

deleteStudent(studentId :string){
  this.studentService.deleteStudent(studentId)
  .subscribe(data =>{
    console.log(data);
    this.goToStudentList();
  }
  );
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
      this.router.navigate(['/studentupdate/']);
    }else {
      console.log(this.student);
      this.goToStudentList();
    }

  
  

 }

 course(){
  this.student.studentCourse = '';
  this.courseService.getCourseList().subscribe(data=>{
   this.courses= data;
  });
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







