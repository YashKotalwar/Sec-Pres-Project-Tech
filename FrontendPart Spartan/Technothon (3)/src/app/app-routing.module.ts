import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AddTranscriptComponent } from './add-transcript/add-transcript.component';
import { LoginComponent } from './login/login.component';
import { UploadTranscriptComponent } from './upload-transcript/upload-transcript.component';

const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'addTranscript',component:AddTranscriptComponent},
  {path:'login',component:LoginComponent},
  {path:'uploadTranscript',component:UploadTranscriptComponent},
  {path:'**',redirectTo:'',pathMatch:'full',}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
