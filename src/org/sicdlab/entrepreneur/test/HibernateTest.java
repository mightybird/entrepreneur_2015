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
		// List list = session.createCriteria(User.class).createAlias("role",
		// "r").add(Restrictions.eq("r.name", "institution")).list();
		// List ul =
		// session.createCriteria(Entrepreneur.class).add(Restrictions.eq("id",
		// "54454bdc587f4a4e93264afd82cf8769")).list();
		// Entrepreneur entrepreneur = (Entrepreneur) ul.iterator().next();
		// List list =
		// session.createCriteria(Project.class).createAlias("projectEntrepreneurs",
		// "rpt").add(Restrictions.eq("rpt.entrepreneur", entrepreneur)).list();
		// Project p = (Project) list.iterator().next();
		// System.out.println(list.size());
		// System.out.println(p.getName());
		// List list =
		// session.createCriteria(Entrepreneur.class).add(Restrictions.eq("id",
		// "67c92fa2a7f342deb171bf1e59277c9f")).list();
		// System.out.println(list.size());
		// Entrepreneur entre = (Entrepreneur) list.iterator().next();
		// List ul =
		// session.createCriteria(User.class).add(Restrictions.eq("entrepreneur",
		// entre)).list();
		// System.out.println(ul.size());
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
