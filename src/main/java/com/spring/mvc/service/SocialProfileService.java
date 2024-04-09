package com.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.spring.mvc.entity.SocialProfile;
import com.spring.mvc.entity.Student;
import com.spring.mvc.repository.SocialProfileRepository;

@Service
public class SocialProfileService {

	@Autowired
	public SocialProfileRepository repository;

	public ModelAndView viewProfile(int studentId) {
		
		List<SocialProfile> profiles = repository.viewProfile(studentId);
		ModelAndView view = new ModelAndView("View.jsp");
		
		view.addObject("socialList", profiles);
		view.addObject("studentId",studentId);
		return view;

	}

	public ModelAndView saveProfile(SocialProfile profile, int studentId) {
		
			
		repository.saveProfile(profile,studentId);

		
		List<SocialProfile> profiles = repository.viewProfile(studentId);
		ModelAndView view = new ModelAndView("View.jsp");		
		view.addObject("socialList", profiles);
		view.addObject("studentId",studentId);
		return view;

	}
	public ModelAndView fetchUpdateProfileData(int profileId,int studentId)
	{
		SocialProfile profileData = repository.fetchUpdateProfileData(profileId);
		ModelAndView view = new ModelAndView("UpdateProfile.jsp");		
		view.addObject("profileData", profileData);
		view.addObject("studentId", studentId);
		return view;
	}
	public ModelAndView saveUpdateProfile(SocialProfile profile,int studentId)
	{
		repository.saveUpdateProfile(profile,studentId);
		List<SocialProfile> profiles = repository.viewProfile(studentId);
		ModelAndView view = new ModelAndView("View.jsp");		
		view.addObject("socialList", profiles);
		view.addObject("studentId",studentId);
		return view;
		
	}
	public ModelAndView deleteProfile(int profileId,int studentId)
	{
		repository.deleteProfile(profileId);
		List<SocialProfile> profiles = repository.viewProfile(studentId);
		ModelAndView view = new ModelAndView("View.jsp");		
		view.addObject("socialList", profiles);
		view.addObject("studentId",studentId);
		return view;
		
	}

}
