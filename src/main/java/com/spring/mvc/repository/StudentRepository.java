package com.spring.mvc.repository;

import java.lang.annotation.Target;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.spring.mvc.entity.Student;

@Repository
public class StudentRepository {
	
	private Object singleResult;
	public void savestudent(Student student)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("manikMysql");
		EntityManager em=emf.createEntityManager();
		EntityTransaction trans=em.getTransaction();
		trans.begin();
		em.persist(student);
		trans.commit();
		em.close();
		
	}
	public List<Student> fetchStudent()
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("manikMysql");
		EntityManager em=emf.createEntityManager();
		EntityTransaction trans=em.getTransaction();
		trans.begin();
		CriteriaBuilder builder=em.getCriteriaBuilder();
		CriteriaQuery< Student> criteriaQuery=builder.createQuery(Student.class);
		Root<Student> root=criteriaQuery.from(Student.class);
		criteriaQuery.select(root);
		Query query=em.createQuery(criteriaQuery);
		List list = query.getResultList();
		trans.commit();
		em.close();
		return list;
	}
	
	public Student fetchUpdateData(int studentId)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("manikMysql");
		EntityManager em=emf.createEntityManager();
		EntityTransaction trans=em.getTransaction();
		trans.begin();
		Student student = em.find(Student.class, studentId);
		trans.commit();
		em.close();
		return student;
		
	}
	
	public void saveUpdateStudent(Student student)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("manikMysql");
		EntityManager em=emf.createEntityManager();
		EntityTransaction trans=em.getTransaction();
		trans.begin();
		em.merge(student);
		trans.commit();
		em.close();
		
	}
	public void deleteStudent(int studentId)
	{

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("manikMysql");
		EntityManager em=emf.createEntityManager();
		EntityTransaction trans=em.getTransaction();
		trans.begin();
		CriteriaBuilder builder=em.getCriteriaBuilder();
		CriteriaDelete< Student> criteriaQuery=builder.createCriteriaDelete(Student.class);
		Root<Student> root=criteriaQuery.from(Student.class);
		criteriaQuery.where(builder.equal(root.get("studentId"), studentId));
		
		Query query=em.createQuery(criteriaQuery);
		 query.executeUpdate();
	
		
		trans.commit();
		
		em.close();
		
	}
	

}
