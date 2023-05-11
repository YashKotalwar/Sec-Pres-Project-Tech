import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MeetingInfo } from '../entity/meetingInfo';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  // baseApiUrl = "https://file.io"
  baseApiUrl = "http://localhost:9090";
  constructor(private http:HttpClient) { }

  userAuth(){
    return localStorage.getItem('user');
  }

  // Returns an observable
  upload(file:File):Observable<any> {

      // Create form data
      const formData = new FormData();
      // Store form name as "file" with file data
      formData.append("file", file, file.name);
      return this.http.post(`${this.baseApiUrl}/transcription/upload`, formData)
  }

  getAllTranscriptList(){
    return this.http.get<any>(`${this.baseApiUrl}/meetings/all`);
  }

  generateNotesByFileName(name: any): Observable<File> {
    return this.http.get<any>(`${this.baseApiUrl}/transcription/${name}`);
  }

  uploadTranscriptToAWS(file: any): Observable<MeetingInfo>{
    return this.http.post<any>(`${this.baseApiUrl}/transcription/upload`, file);
  }

  sendMeetingNotes(meetingId:number):Observable<any>{
    return this.http.get<any>(`${this.baseApiUrl}/transcription/send/${meetingId}`);
  }
}
