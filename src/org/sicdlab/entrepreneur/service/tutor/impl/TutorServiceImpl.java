package org.sicdlab.entrepreneur.service.tutor.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sicdlab.entrepreneur.beans.Tutor;
import org.sicdlab.entrepreneur.service.baseservice.impl.BaseServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TutorServiceImpl extends BaseServiceImpl{
	public List<Tutor> select(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");
		Session session = sf.openSession();
		session.beginTransaction();
		Query q=(Query) session.createQuery("from Tutor");
		List<Tutor> tutors=(List<Tutor>)q.list();
		/*for(Object o:q.list()){
			Tutor1 t=(Tutor1) o;
			System.out.println(t.getOccupation());
		}*/	
		return tutors;
	}
	//每一页显示的条数
	public List<Tutor> select(int pageSize,int currentPage){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");
		Session session = sf.openSession();
		session.beginTransaction();
		Query q=(Query) session.createQuery("from Tutor");
		q.setMaxResults(pageSize);
		q.setFirstResult((currentPage-1)*pageSize+1);
		List<Tutor> tutors=(List<Tutor>)q.list();
		/*for(Object o:q.list()){
			Tutor1 t=(Tutor1) o;
			System.out.println(t.getOccupation());
		}*/	
		return tutors;
	}
	
}
