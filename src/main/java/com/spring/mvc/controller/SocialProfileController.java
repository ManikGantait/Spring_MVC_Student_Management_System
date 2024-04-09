package com.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.entity.SocialProfile;
import com.spring.mvc.service.SocialProfileService;

@Controller
public class SocialProfileController {
	
	@Autowired
	public SocialProfileService service;
	
	@RequestMapping("/viewProfile")
	public ModelAndView viewProfile(int studentId)
	{
		return service.viewProfile(studentId);
	}
	
	
	
	@RequestMapping("/addProfile")
	public ModelAndView addProfile(int studentId)
	{
		ModelAndView view=new ModelAndView("addProfile.jsp");
		view.addObject("studentId", studentId);
		return view;
	}
	
	
	
	
	
	@RequestMapping("/saveProfile")
	public ModelAndView saveProfile(SocialProfile profile,  int studentId)
	{
		
		return service.saveProfile(profile,studentId);
	}
	
	@RequestMapping("/updateProfile")
	public ModelAndView fetchUpdateProfileData(int profileId, int studentId)
	{
		return service.fetchUpdateProfileData(profileId,studentId);
	}
	
	@RequestMapping("/saveUpdateProfile")
	public ModelAndView saveUpdateProfile(SocialProfile profile,int studentId)
	{
		return service.saveUpdateProfile(profile,studentId);
	}
	
	@RequestMapping("/deleteProfile")
	public ModelAndView deleteProfile(int profileId, int studentId)
	{
//		System.out.println(profileId+"/"+studentId);
		return service.deleteProfile(profileId,studentId) ;
	}

}
