package com.spring.mvc.repository;

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
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.entity.SocialProfile;
import com.spring.mvc.entity.Student;

@Repository
public class SocialProfileRepository {
	
	static EntityManager getEntityManager()
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("manikMysql");
		return emf.createEntityManager();
		
	}
	

	public List<SocialProfile> viewProfile(int studentId)
	{
		EntityManager em=getEntityManager();
		EntityTransaction trans=em.getTransaction();
		trans.begin();	
		
		Student student = em.find(Student.class, studentId);
		System.out.println("+++++++++++++++++");
		List<SocialProfile> profiles= student.getProfiles();
		
		trans.commit();
		em.close();
		return profiles;
		
	}
	
	public void saveProfile(SocialProfile profile,int studentId)
	{
		EntityManager em=getEntityManager();
		EntityTransaction trans=em.getTransaction();
		trans.begin();
		Student student = em.find(Student.class, studentId);
		profile.setStudent(student);		
		em.persist(profile);
		trans.commit();
		em.close();		
	}
	
	public SocialProfile fetchUpdateProfileData(int profileId)
	{
		EntityManager em=getEntityManager();
		EntityTransaction trans=em.getTransaction();
		trans.begin();
		SocialProfile profile = em.find(SocialProfile.class, profileId);
		trans.commit();
		em.close();
		return profile;
	}
	
	public void saveUpdateProfile(SocialProfile profile,int studentId)
	{
		EntityManager em=getEntityManager();
		EntityTransaction trans=em.getTransaction();
		trans.begin();
		Student student = em.find(Student.class, studentId);
		profile.setStudent(student);
		em.merge(profile);
		trans.commit();
		em.close();		
	}
	public void deleteProfile(int profileId)
	{
		EntityManager em=getEntityManager();
		EntityTransaction trans=em.getTransaction();
		trans.begin();
		CriteriaBuilder builder=em.getCriteriaBuilder();
		CriteriaDelete<SocialProfile> criteriaDelete=builder.createCriteriaDelete(SocialProfile.class);
		Root<SocialProfile> root=criteriaDelete.from(SocialProfile.class);
		criteriaDelete.where(builder.equal(root.get("profileId"), profileId));
		
		Query query=em.createQuery(criteriaDelete);
		query.executeUpdate();
		trans.commit();
		em.close();
		
	}
}
