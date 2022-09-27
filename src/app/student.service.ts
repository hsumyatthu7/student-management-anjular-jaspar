import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Student } from './student';
@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private baseURL = "http://localhost:8081/student";
  constructor(private httpClient: HttpClient) { }

  getStudentList(): Observable<Student[]>{
    return this.httpClient.get<Student[]>(`${this.baseURL}`);
  }

  createStudent(student: Student): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, student);
  }

  getStudentByStudentId(studentId: string): Observable<Student>{
    return this.httpClient.get<Student>(`${this.baseURL}/${studentId}`);
  }

  updateStudent(studentId: string, student: Student): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${studentId}`, student);
  }


  deleteStudent(studentId: string): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${studentId}`);
  }
  searchStudent(studentId:string, studentName:string, studentCourse:String):Observable<object>{
    return this.httpClient.get<Student>(`${this.baseURL}/${studentId},${studentName},${studentCourse}`)
  }

  export(format:string){
    return this.httpClient.get<any>(`${this.baseURL}/report/${format}`);
  }
}
