import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  loginForm!:FormGroup;
  constructor(private formBuilder:FormBuilder, private router:Router){}
  ngOnInit(){
    this.loginForm = this.formBuilder.group({
      fullName:[''],
      email:[''],
      password:['']
    })
  }

  onSubmit(){
    // localStorage.setItem('userRegeistered',JSON.stringify(this.loginForm.value))
    console.log('userCredentials',this.loginForm.value);
    const loginValue = this.loginForm.value;
    const registeredUser = JSON.parse(localStorage.getItem('userRegeistered')||'');
    if(loginValue.email === registeredUser.email&& loginValue.password === registeredUser.password)
    {
      localStorage.setItem('user',JSON.stringify(this.loginForm.value))
      alert('login successful');
      this.router.navigateByUrl('')
    }
    else{
      alert('wrong credentials');
    }
    
  }
}
