package org.sicdlab.entrepreneur.test.tutor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.integrator.spi.Integrator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sicdlab.entrepreneur.beans.DataDictionary;
import org.sicdlab.entrepreneur.beans.Entrepreneur;
import org.sicdlab.entrepreneur.beans.Project;
import org.sicdlab.entrepreneur.beans.ProjectEntrepreneur;
import org.sicdlab.entrepreneur.beans.ProjectTutor;
import org.sicdlab.entrepreneur.beans.Tutor;
import org.sicdlab.entrepreneur.beans.User;
import org.sicdlab.entrepreneur.service.baseservice.impl.BaseServiceImpl;
import org.sicdlab.entrepreneur.service.tutor.impl.TutorHelp;
import org.sicdlab.entrepreneur.service.tutor.impl.TutorServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

public class test extends BaseServiceImpl{
	@BeforeClass
	public static void beforeClass(){
	}
	/*@Test
	public void test(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");
		Session s = sf.openSession();
		s.beginTransaction();
		Query q=s.createQuery("from Tutor where type like:name");
		q.setParameter("name", "经营管理导师");
		List<Tutor> tutors=(List<Tutor>)q.list();
		s.getTransaction().commit();
		s.close();
		System.out.println(tutors.size());
		//System.out.println("bdga");
		//System.out.println(tutors.size());
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");
		Session s = sf.openSession();
		s.beginTransaction();
		Query q=s.createQuery("from DataDictionary where ddkey='tutor_type'");
		List<DataDictionary> dataDictionaries=(List<DataDictionary>)q.list();
		s.getTransaction().commit();
		s.close();
		
		for(DataDictionary d:dataDictionaries){
			System.out.println(d.getId()+"*****"+d.getDdkey()+"*****"+d.getDdvalue());
		}
		System.out.println("符合条件的有四条数据"+dataDictionaries.size());
		Tutor t=(Tutor) s.load(Tutor.class, "12");
		t.getId();
		Project p1=(Project) s.load(Project.class, "3");
		p1.getId();
		ProjectTutor p=new ProjectTutor();
		p.setId("3");
		p.setComment("hello");
		p.setTutor(t);
		p.setProject(p1);
		
		s.save(p);
		
		s.getTransaction().commit();
		s.close();
	}*/
	
	/*@Test
	public void test(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");
		Session s = sf.openSession();
		s.beginTransaction();
		
		Query q=s.createQuery("from Tutor");
		List<Tutor> tutors=(List<Tutor>)q.list();
		s.getTransaction().commit();
		Map<String, String> maps=new HashMap<String, String>();
		for(Tutor t:tutors){
			maps.put("id", t.getId());
			maps.put("name", t.getUser().getName());
		}
		System.out.println(maps.size());
		s.close();
	}*/
	@Test
	public void test(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");
		Session s = sf.openSession();
		s.beginTransaction();
		
		/*Query q=s.createQuery("from Entrepreneur where id like:name");
		q.setString("name","1");*/
		
		//Entrepreneur projectentrepreneur
		//Criteria q=s.createCriteria(ProjectEntrepreneur.class).createCriteria("entrepreneur").add(Restrictions.eq("id", "54454bdc587f4a4e93264afd82cf8769"));
		Criteria q=s.createCriteria(ProjectEntrepreneur.class).add(Restrictions.eq("entrepreneur.id", "54454bdc587f4a4e93264afd82cf8769")).createCriteria("project");
		
		List<ProjectEntrepreneur> tutors=(List<ProjectEntrepreneur>)q.list();
		/*Criteria q=s.createCriteria(Project.class).add(Restrictions.eq("id", "1"));
		List<Project> tutors=(List<Project>)q.list();*/
		System.out.println(tutors.size());
		for(ProjectEntrepreneur p:tutors){
			System.out.println(p.getProject().getName());
		}
		/*List<Tutor> tutors=s.createCriteria(Tutor.class).createCriteria("user").add(Restrictions.eq("role.id", "2")).list();
		System.out.println(tutors.size());*/
		s.getTransaction().commit();
		s.close();
	}
	public static void main(String[] args) { 
		beforeClass();
	}
	@AfterClass
	public static void afterClass(){
	}

}

