import { Component, OnInit } from '@angular/core';
import { of } from 'rxjs';
import { User } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import * as XLSX from "xlsx";


@Component({
  selector: 'app-userdisplay',
  templateUrl: './userdisplay.component.html',
  styleUrls: ['./userdisplay.component.css']
})
export class UserdisplayComponent implements OnInit {
  fileName = 'userExcel.xlsx';
  pdf = 'pdf';
  html = 'html';
  excel = 'excel';


  searchId: any;
  searchName: any;
  time = new Date().toDateString();
  users: User[];
  currentUser = sessionStorage.getItem("userId");
  constructor(private userService: UserService,
    private router: Router) {
    this.users = [];
  }

  ngOnInit(): void {
    this.getUsers();
  }
  private getUsers() {
    this.userService.getUserList().subscribe(data => {
      this.users = data;
    });
  }
  userDetails(userId: string) {
    this.router.navigate(['user', userId]);
  }
  updateUser(userId: string) {
    this.router.navigate(['userupdate', userId]);
  }
  deleteUser(userId: string) {
    this.userService.deleteUser(userId).subscribe(data => {
      console.log(data);
      this.getUsers();
    })

  }


  export(path: string) {
    this.userService.export(path).subscribe((data) => {
      alert("successfully export")
    })

  }

  exportExcel(): void {

    const ws: XLSX.WorkSheet = XLSX.utils.json_to_sheet(this.users);
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'Sheet1');

    /* save to file */
    XLSX.writeFile(wb, this.fileName);
    alert("exported successfully")
  }


}

