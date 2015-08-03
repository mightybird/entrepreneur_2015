package org.sicdlab.entrepreneur.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.sicdlab.entrepreneur.utils.UUIDGenerator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateTest {
	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		tx.commit();
		ctx.close();

	}

	// @Test
	public void test1() {
		System.out.println(UUIDGenerator.randomUUID());
		System.out.println(UUIDGenerator.randomUUID());
		System.out.println(UUIDGenerator.randomUUID());
		System.out.println(UUIDGenerator.randomUUID());
	}

}
