package com.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.entity.Student;
import com.spring.mvc.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	public StudentRepository repository;
	public ModelAndView saveStudent(Student student)
	{
		repository.savestudent(student);		
		ModelAndView mvm=new ModelAndView();
		mvm.setViewName("output.jsp");
		mvm.addObject("message", "Successfull");
		return mvm;
	}
	public ModelAndView fetchStudent()
	{		
		List<Student> list =repository.fetchStudent();
		ModelAndView mvm=new ModelAndView();
		mvm.setViewName("DisplayAllStudent.jsp");
		mvm.addObject("studentList", list);
		return mvm;
	}

	public ModelAndView fetchUpdataData(int studentId)
	{
		 
		 Student student = repository.fetchUpdateData(studentId);
			ModelAndView mvm=new ModelAndView();
			mvm.setViewName("UpdateStudent.jsp");
			mvm.addObject("student", student);
			return mvm;
	}
	public void saveUpdateStudent(Student student)
	{
		repository.saveUpdateStudent(student);
	}
	public void deleteStudent(int studentId)
	{
		repository.deleteStudent(studentId);
	}

}
