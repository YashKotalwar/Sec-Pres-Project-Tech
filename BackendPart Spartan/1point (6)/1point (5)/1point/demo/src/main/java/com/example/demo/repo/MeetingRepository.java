package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Meeting;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Integer> {

	Meeting findByMeetingTitle(String meetingTitle);


}
