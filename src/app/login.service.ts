import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Login } from './login';
import { User } from './user';
import { UserService } from './user.service';
import { ActivatedRoute, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private baseURL = "http://localhost:8081/login";
  user: User = new User();

  constructor(private userService: UserService,
              private route : ActivatedRoute,
              private router : Router) { }

  login(userId: string,userPassword: string){
    this.userService.getUserByUserId(userId).subscribe(data=>{
      this.user = data;

    },error => console.log(error));

    if(userId === this.user.userId && userPassword === this.user.userPassword){
      sessionStorage.setItem('userId', userId)
      return true;
    }else{
      return false;
    }
 
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('userId')
    console.log(!(user === null))
    return !(user === null)
  }


  // logOut() {
  //   sessionStorage.removeItem('userId')
  // }

     
}
