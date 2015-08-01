package org.sicdlab.entrepreneur.test.tutor;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sicdlab.entrepreneur.beans.DataDictionary;
import org.sicdlab.entrepreneur.beans.Tutor;
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
		Query q=s.createQuery("from Tutor where type like:name");
		q.setParameter("name", "经营管理导师");
		List<Tutor> tutors=(List<Tutor>)q.list();
		s.getTransaction().commit();
		s.close();
		System.out.println(tutors.size());*/
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
	}
	public static void main(String[] args) { 
		beforeClass();
	}
	@AfterClass
	public static void afterClass(){
	}

}

