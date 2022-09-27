import { Component, OnInit } from '@angular/core';
import { of } from 'rxjs';
import { Course } from '../course';
import { CourseService } from '../course.service';
import { Router } from '@angular/router';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { LoginService } from '../login.service';


@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
})
export class CourseComponent implements OnInit {

  currentUser = sessionStorage.getItem("userId");
  courseForm !: FormGroup;
  submitted = false;
  time = new Date().toDateString();
  course: Course = new Course();

  constructor(private courseService: CourseService,
    private router: Router,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {

    this.courseForm = this.formBuilder.group({

      'courseId': ['', Validators.required],
      'courseName': ['', Validators.required]
    })

  }

  saveCourse() {
    this.courseService.createCourse(this.course)
      .subscribe(data => {
        console.log(data);
        this.goToCourseList();
      }
      );
  }
  goToCourseList() {
    this.router.navigate(['/studentadd']);
  }


  onSubmit() {
    console.log(this.course);
    this.saveCourse();

    this.submitted = true
    if (this.courseForm.invalid) {
      return
    }
    alert("successful")
  }

}
