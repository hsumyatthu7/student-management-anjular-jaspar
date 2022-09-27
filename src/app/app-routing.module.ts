import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import{ UserdisplayComponent } from './userdisplay/userdisplay.component';
import { UseraddComponent } from './useradd/useradd.component';
import { LoginComponent } from './login/login.component';
import { UserupdateComponent } from './userupdate/userupdate.component';
import { CourseComponent } from './course/course.component';
import { StudentdisplayComponent } from './studentdisplay/studentdisplay.component';
import { StudentaddComponent } from './studentadd/studentadd.component';
import { StudentupdateComponent } from './studentupdate/studentupdate.component';
import { MenuComponent } from './menu/menu.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path:'',redirectTo:'login',pathMatch:'full'},
  {path: 'user', component:UserdisplayComponent},
  {path:'useradd',component:UseraddComponent},
  {path:'userupdate/:userId',component:UserupdateComponent},
  // {path:'',redirectTo:'user',pathMatch:'full'},

  {path:'course',component:CourseComponent},
  // {path:'',redirectTo:'course',pathMatch:'full'},
  
  {path:'student',component:StudentdisplayComponent},
{path:'studentadd',component:StudentaddComponent},
{path:'studentupdate/:studentId',component:StudentupdateComponent},
// {path:'',redirectTo:'student',pathMatch:'full'},

{path:'menu',component:MenuComponent}
// {path:'',redirectTo:'menu',pathMatch:'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
