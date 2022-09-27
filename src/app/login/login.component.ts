import { Component, OnInit } from '@angular/core';
import { of } from 'rxjs';
import { Login } from '../login';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  userId ='';
  userPassword ='';

  invalidLogin = false;



  constructor(private loginService: LoginService,
    private router: Router) { }

  ngOnInit(): void {
    this.handleLogin();

  }

  handleLogin() {
    if(this.loginService.login(this.userId, this.userPassword))  {
      this.router.navigate(['/menu'])
      this.invalidLogin= false
      alert("Login Successful")
    }else{
      this.invalidLogin=true
      alert("Login Failed")
    }
  }

  onSubmit(){
   this.router.navigate(['/menu']);
  }
}
