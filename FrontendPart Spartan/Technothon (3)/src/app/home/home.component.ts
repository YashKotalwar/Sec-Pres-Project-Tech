import { Component } from '@angular/core';
import { DataService } from '../services/data.service';
import {MeetingInfo} from '../entity/meetingInfo'
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
  constructor(private dataService:DataService, private router:Router){}
  transcriptList!:MeetingInfo[];

  ngOnInit(){
    this.getAllList();
    console.log(this.transcriptList);

  }
  getAllList(){
    this.dataService.getAllTranscriptList().subscribe({
      next:(list)=>{this.transcriptList = list;
      console.log(this.transcriptList);
      },
      error:(err)=>console.log(err)

    })
  }

  generateNotes(name:any){
    const transcript = this.dataService.generateNotesByFileName(name).subscribe({
      next:(response)=>console.log(response),
      error:(err)=>console.log(err),
      complete:() => {
        }

    });
    console.log('transcript');
    setTimeout(()=>{
      this.getAllList()
    },25000)
  }

  sendMeetingNotes(id:any){
    this.dataService.sendMeetingNotes(id).subscribe({
      next:(response)=>console.log(response),
      error:(err)=>console.log(err),
      complete:() => {this.getAllList()}
    }
    );
    setTimeout(()=>{
      this.getAllList()
    },2000)
  }
}
