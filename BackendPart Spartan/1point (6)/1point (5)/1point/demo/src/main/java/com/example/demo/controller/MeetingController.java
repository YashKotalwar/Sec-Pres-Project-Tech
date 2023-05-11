package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Meeting;

import com.example.demo.service.MeetingSerivce;

@RestController
@RequestMapping("/meetings")
@CrossOrigin(origins = "http://localhost:4200/") 
public class MeetingController {

    
    @Autowired
    private MeetingSerivce meetingSerivce;

    
    @GetMapping("/all")
    public List<Meeting> getAllData() {
    	return this.meetingSerivce.getAllData();
    }
}
