package com.spring.mvc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
	
	@Id
	private int studentId;
	private String studentName;
	private String studentEmail;
	private int studentMarks;
	
	@OneToMany(mappedBy = "student",fetch = FetchType.EAGER)
	private List<SocialProfile> profiles=new ArrayList<SocialProfile>();
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public int getStudentMarks() {
		return studentMarks;
	}
	public void setStudentMarks(int studentMarks) {
		this.studentMarks = studentMarks;
	}
	public List<SocialProfile> getProfiles() {
		return profiles;
	}
	public void setProfiles(List<SocialProfile> profiles) {
		this.profiles = profiles;
	}
	
	
	
	
	

}
