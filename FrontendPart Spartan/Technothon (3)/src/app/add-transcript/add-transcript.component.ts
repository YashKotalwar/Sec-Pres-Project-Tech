import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-transcript',
  templateUrl: './add-transcript.component.html',
  styleUrls: ['./add-transcript.component.scss']
})
export class AddTranscriptComponent {
  transcriptUploadForm!:FormGroup; 
  constructor(private formBuilder:FormBuilder){}

  ngOnInit():void{
    this.transcriptUploadForm = this.formBuilder.group({
      meetingId:['',Validators.required],
      organizerId:['',Validators.required]
    })
  }

  onSubmit(){
    console.log('onSubmit',this.transcriptUploadForm.value);
    
  }
}
