package org.sicdlab.entrepreneur.test.institute;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.sicdlab.entrepreneur.beans.DataDictionary;
import org.sicdlab.entrepreneur.beans.Institution;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	@SuppressWarnings("unchecked")
	/*@Test
	public void test(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");
		Session s = sf.openSession();
		s.beginTransaction();
		
		Query q=s.createQuery("from DataDictionary where ddkey='institution_type'");
		List<DataDictionary> dataDictionaries=(List<DataDictionary>)q.list();
		System.out.println(dataDictionaries.size());
		for(DataDictionary d:dataDictionaries){
			System.out.println(d.getDdvalue());
		}
		s.getTransaction().commit();
		s.close();
	}*/
	
	@Test
	public void test(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");
		Session s = sf.openSession();
		s.beginTransaction();
		
		List<Institution> institutions=s.createCriteria(Institution.class).add(Restrictions.eq("type", "人才培训")).createCriteria("user").list();
		//session.getTransaction().commit();
		System.out.println(institutions.size());
		for(Institution institution:institutions){
			System.out.println(institution.getId());
		}
		s.getTransaction().commit();
		s.close();
	}
}
