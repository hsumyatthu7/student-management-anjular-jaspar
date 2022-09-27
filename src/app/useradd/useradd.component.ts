import { Component, OnInit } from '@angular/core';
import { of } from 'rxjs';
import { User } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { FormGroup ,FormBuilder,Validators} from '@angular/forms';
@Component({
  selector: 'app-useradd',
  templateUrl: './useradd.component.html',
 
})
export class UseraddComponent implements OnInit {
  time = new Date().toDateString();
  currentUser= sessionStorage.getItem("userId");
    userForm !: FormGroup;
    submitted = false;
    user:User=new User();

    constructor(private userService: UserService,
    private router: Router,
    private formBuilder : FormBuilder) { }

  ngOnInit(): void {
    this.userForm = this.formBuilder.group({

      'userId' : ['', Validators.required],
      'userName' : ['', Validators.required],
      'userEmail' : ['', Validators.required],
      'userPassword' : ['', Validators.required],
      'userConfirmpassword' : ['', Validators.required]

      
    })

  }
  saveUser(){
    this.userService.createUser(this.user)
    .subscribe(data =>{
      console.log(data);
      this.goToUserList();
    }
    );
  }
    goToUserList(){
      this.router.navigate(['/user']);
    }
  onSubmit(){
    

    console.log(this.user);
    this.saveUser();

    this.submitted=true
    if(this.userForm.invalid){
      return
    }
    alert("successful")
   }
}
