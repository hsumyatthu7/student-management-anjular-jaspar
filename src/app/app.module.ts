import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { UseraddComponent } from './useradd/useradd.component';
import { UserupdateComponent } from './userupdate/userupdate.component';
import { UserdisplayComponent } from './userdisplay/userdisplay.component';
import { MenuComponent } from './menu/menu.component';
import { CourseComponent } from './course/course.component';
import { StudentaddComponent } from './studentadd/studentadd.component';
import { StudentupdateComponent } from './studentupdate/studentupdate.component';
import { StudentdisplayComponent } from './studentdisplay/studentdisplay.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'; 
import { RouterModule } from '@angular/router';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UseraddComponent,
    UserupdateComponent,
    UserdisplayComponent,
    MenuComponent,
    CourseComponent,
    StudentaddComponent,
    StudentupdateComponent,
    StudentdisplayComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    FormsModule,
    Ng2SearchPipeModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
