import { Component } from '@angular/core';
import { DataService } from '../services/data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-upload-transcript',
  templateUrl: './upload-transcript.component.html',
  styleUrls: ['./upload-transcript.component.scss']
})
export class UploadTranscriptComponent {
 // Variable to store shortLink from api response
 shortLink: string = "";
 loading: boolean = false; // Flag variable
 file!: File ; // Variable to store file

 // Inject service
 constructor(private fileUploadService: DataService, private router:Router) { }

 ngOnInit(): void {
 }

 // On file Select
 onChange(event:any) {
     this.file = event.target.files[0];
 }

 // OnClick of button Upload
 onUpload(event : Event) {
     this.loading = !this.loading;
     console.log(this.file);
     this.fileUploadService.upload(this.file).subscribe(
        {
          next:(response)=>console.log(response),
          error:(err)=>console.log(err),
          complete:()=>{
            alert('Successfully Uploaded');
          this.router.navigateByUrl('')
          }

        }
     );
     event.preventDefault();
 }
  }




