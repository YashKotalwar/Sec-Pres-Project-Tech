package com.example.demo.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.io.File;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

//import javax.persistence.Table;

// org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "MeetInfo")
public class Meeting {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int meetingId;
	
	@Column(name="MeetingTitle", unique=true)
	private String meetingTitle ;
	
	@Column(name="MeetingNoteStatus")
	private Boolean meetingNoteStatus ;
	
	@Column(name="MeetingNotes")
	private File meetingNotes;

	@Column(name="MailSendStatus")
	private Boolean mailSendStatus;

	@Column(name="AttendiesEmails")
	private String attendiesEmails;

	public Meeting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Meeting(int meetingId, String meetingTitle, Boolean meetingNoteStatus,
			File meetingNotes, Boolean mailSendStatus, String attendiesEmails) {
		super();
		this.meetingId = meetingId;
		this.meetingTitle = meetingTitle;
		this.meetingNoteStatus = meetingNoteStatus;
		this.meetingNotes = meetingNotes;
		this.mailSendStatus = mailSendStatus;
		this.attendiesEmails = attendiesEmails;
	}

	public int getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}

	public String getMeetingTitle() {
		return meetingTitle;
	}

	public void setMeetingTitle(String meetingTitle) {
		this.meetingTitle = meetingTitle;
	}

	public Boolean getMeetingNoteStatus() {
		return meetingNoteStatus;
	}

	public void setMeetingNoteStatus(Boolean meetingNoteStatus) {
		this.meetingNoteStatus = meetingNoteStatus;
	}

	public File getMeetingNotes() {
		return meetingNotes;
	}

	public void setMeetingNotes(File meetingNotes) {
		this.meetingNotes = meetingNotes;
	}

	public Boolean getMailSendStatus() {
		return mailSendStatus;
	}

	public void setMailSendStatus(Boolean mailSendStatus) {
		this.mailSendStatus = mailSendStatus;
	}

	public String getAttendiesEmails() {
		return attendiesEmails;
	}

	public void setAttendiesEmails(String attendiesEmails) {
		this.attendiesEmails = attendiesEmails;
	}

	
	
}