import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  currentUser= sessionStorage.getItem("userId");
  time = new Date().toDateString();
  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
    // this.loginService.logOut();
  }

}
