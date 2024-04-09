package com.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.entity.Student;
import com.spring.mvc.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	public StudentService service;
	
	@RequestMapping("/")
	public ModelAndView redireact()
	{
		ModelAndView mvm=new ModelAndView();
		mvm.setViewName("home.jsp");
		return mvm;
		
	}
	@RequestMapping("/saveStudent")
	public ModelAndView saveStudent(Student student)
	{
		return service.saveStudent(student);		
	}
	@RequestMapping("/fetchStudent")
	public ModelAndView fetchStudent()
	{
		return service.fetchStudent();
		
	}
	@RequestMapping("/update")
	public ModelAndView fetchUpdateData(int studentId)
	{
		return service.fetchUpdataData(studentId);
		
	}
	
	@RequestMapping("/saveUpdateStudent")
	public ModelAndView saveUpdateData(Student student)
	{
		service.saveUpdateStudent(student);
		return service.fetchStudent();
		
	}
	@RequestMapping("/delete")
	public ModelAndView deleteStudent(int studentId)
	{
		service.deleteStudent(studentId);
		return service.fetchStudent();
		
	}
}
