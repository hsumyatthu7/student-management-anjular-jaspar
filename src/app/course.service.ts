import { Injectable } from '@angular/core';
import { Course } from './course';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private baseURL = "http://localhost:8081/course";
  constructor(private httpClient: HttpClient) { }

  getCourseList(): Observable<Course[]>{
    return this.httpClient.get<Course[]>(`${this.baseURL}`);
  }

  createCourse(course: Course): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, course);
  }
}
