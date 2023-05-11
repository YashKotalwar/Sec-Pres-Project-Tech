package com.example.demo.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Meeting;
import com.example.demo.repo.MeetingRepository;

@Service
public class MeetingSerivce {

	@Autowired
	private MeetingRepository meetingRepository;

	
	
	@Value("${application.bucket.name}")
    private String s3Bucket;
	
	// create meetingInfo
	public Meeting createMeetingInfo(String meetingTitle) {
		Meeting meeting = new Meeting();
		meeting.setMeetingTitle(meetingTitle);
		meeting.setMeetingNoteStatus(false);
		meeting.setMailSendStatus(false);
		meeting.setAttendiesEmails("yashkotalwar10@gmail.com, rishikeshvaidya1999@gmail.com,poojabshelke0807@gmail.com");
		return meetingRepository.save(meeting);
	}
	
	
	// Get MeetingInfo by MeetingTitle
	public Meeting getMeetingbyTitle(String meetingTitle) {
		return meetingRepository.findByMeetingTitle(meetingTitle);
	}
	
	// Get Meeting by Id
	public Meeting getMeetingById(int meetingId) {
		return meetingRepository.findById(meetingId).orElseThrow();
	}
	
	// Update MeetingInfo 
	public Meeting updateMeeting(File meetingNotes, Meeting meeting) {
		meeting.setMeetingNotes(meetingNotes);
		meeting.setMeetingNoteStatus(true);
		return meetingRepository.save(meeting);
	}
	
	// Update MeetingInfo by Id
	public void updateSentStatus(int id) {
		Meeting meeting = this.getMeetingById(id);
		meeting.setMailSendStatus(true);
		this.meetingRepository.save(meeting);
	}
	
	// Get All Data
	public List<Meeting> getAllData() {
		return this.meetingRepository.findAll();
	}

}
