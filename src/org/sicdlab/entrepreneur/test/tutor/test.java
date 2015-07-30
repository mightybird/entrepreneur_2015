package org.sicdlab.entrepreneur.test.tutor;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sicdlab.entrepreneur.service.baseservice.impl.BaseServiceImpl;
import org.sicdlab.entrepreneur.service.tutor.impl.TutorServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

public class test extends BaseServiceImpl{
	@BeforeClass
	public static void beforeClass(){
	}
	@Test
	public void test(){
		/*ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");
		Session s = sf.openSession();
		s.beginTransaction();
		Query q=s.createQuery("from Tutor1");
		//List<Tutor> tutors=(List<Tutor>)q.list();
		for(Object o:q.list()){
			Tutor1 t=(Tutor1) o;
			System.out.println(t.getOccupation());
		}
		s.getTransaction().commit();
		s.close();
		System.out.println("bdga");
		//System.out.println(tutors.size());*/
		TutorServiceImpl t=new TutorServiceImpl();
	}
	public static void main(String[] args) { 
		beforeClass();
	}
	@AfterClass
	public static void afterClass(){
	}

}

