import { Component, OnInit } from '@angular/core';
import { of } from 'rxjs';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';
import * as XLSX from "xlsx";

@Component({
  selector: 'app-studentdisplay',
  templateUrl: './studentdisplay.component.html',
  styleUrls: ['./studentdisplay.component.css']
})
export class StudentdisplayComponent implements OnInit {
  fileName = 'studentExcel.xlsx';
  pdf = 'pdf';
  html = 'html';
  excel = 'excel';

  searchId: any;
  searchName: any;
  searchCourse: any;
  time = new Date().toDateString();
  student: Student = new Student();
  students: Student[];
  currentUser = sessionStorage.getItem("userId");
  constructor(private studentService: StudentService,
    private router: Router) {
    this.students = [];
  }

  ngOnInit(): void {
    this.getStudents();
  }

  private getStudents() {
    this.studentService.getStudentList().subscribe(data => {
      this.students = data;
    });
  }

  studentDetails(studentId: string) {
    this.router.navigate(['student', studentId]);
  }
  updateStudent(studentId: string) {
    this.router.navigate(['studentupdate', studentId]);
  }
  deleteStudent(studentId: string) {
    this.studentService.deleteStudent(studentId).subscribe(data => {
      console.log(data);
      this.getStudents();
    })

  }

  export(path: string) {
    this.studentService.export(path).subscribe((data) => {
      alert("exported successfully")
    })

  }

  exportExcel(): void {

    const ws: XLSX.WorkSheet = XLSX.utils.json_to_sheet(this.students);
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'Sheet1');

    /* save to file */
    XLSX.writeFile(wb, this.fileName);
    alert("exported successfully")
  }


}
