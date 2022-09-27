import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { User } from './user';
@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseURL = "http://localhost:8081/user";
  constructor(private httpClient: HttpClient) { }

  
  getUserList(): Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.baseURL}`);
  }

  createUser(user: User): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, user);
  }

  getUserByUserId(userId: string): Observable<User>{
    return this.httpClient.get<User>(`${this.baseURL}/${userId}`);
  }

  updateUser(userId: string, user: User): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${userId}`, user);
  }


  deleteUser(userId: string): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${userId}`);
  }
  searchUser(userId:String ,userName:String):Observable<object>{
    return this.httpClient.get<User>(`${this.baseURL}/${userId},${userName}`)
  }

  
  export(format:string){
    return this.httpClient.get<any>(`${this.baseURL}/report/${format}`);
  }

}
