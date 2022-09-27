import { Component, OnInit } from '@angular/core';
import { of } from 'rxjs';
import { User } from '../user';
import { UserService } from '../user.service';
import { FormGroup ,FormBuilder,Validators} from '@angular/forms';

import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-userupdate',
  templateUrl: './userupdate.component.html',
})
export class UserupdateComponent implements OnInit {
  time = new Date().toDateString();
  userId!:string;
  user:User=new User();
  // userUpdateForm !: FormGroup;
  // submitted = false;
  currentUser= sessionStorage.getItem("userId");
  
  constructor(private userService: UserService,
    private route: ActivatedRoute,
    private router: Router,
    private formBuilder : FormBuilder) { }

  ngOnInit(): void {

    // this.userUpdateForm = this.formBuilder.group({

    //   'userId' : ['', Validators.required],
    //   'userName' : ['', Validators.required],
    //   'userEmail' : ['', Validators.required],
    //   'userPassword' : ['', Validators.required],
    //   'userConfirmpassword' : ['', Validators.required]

      
    // })
    this.userId = this.route.snapshot.params['userId'];
    this.userService.getUserByUserId(this.userId).subscribe(data => {
    this.user = data;

    

  }
    );
}

  onSubmit(){

    if(this.user.userId==="" ||
    this.user.userName=== "" ||
    this.user.userEmail === "" ||
    this.user.userPassword === "" ||
    this.user.userConfirmpassword==="" ||
    this.user.userRole===""){
    alert("insert all data")
    this.router.navigate(['/userupdate/']);
  }else {
    this.userService.updateUser(this.userId, this.user)
    .subscribe( data =>{
    console.log(data);

      this.goToUserList();
    }
    );
  }

    
  }

  goToUserList(){
    this.router.navigate(['/user']);
  }
}
