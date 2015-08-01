package org.sicdlab.entrepreneur.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.sicdlab.entrepreneur.beans.Entrepreneur;
import org.sicdlab.entrepreneur.beans.Project;
import org.sicdlab.entrepreneur.utils.UUIDGenerator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateTest {
	@SuppressWarnings("rawtypes")
	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		// List list = session.createCriteria(User.class).createAlias("role",
		// "r").add(Restrictions.eq("r.name", "institution")).list();
		List ul = session.createCriteria(Entrepreneur.class).add(Restrictions.eq("id", "54454bdc587f4a4e93264afd82cf8769")).list();
		Entrepreneur entrepreneur = (Entrepreneur) ul.iterator().next();
		List list = session.createCriteria(Project.class).createAlias("projectEntrepreneurs", "rpt").add(Restrictions.eq("rpt.entrepreneur", entrepreneur)).list();
		Project p = (Project) list.iterator().next();
		System.out.println(list.size());
		System.out.println(p.getName());
		tx.commit();

	}

	@Test
	public void test1() {
		System.out.println(UUIDGenerator.randomUUID());
		System.out.println(UUIDGenerator.randomUUID());
		System.out.println(UUIDGenerator.randomUUID());
		System.out.println(UUIDGenerator.randomUUID());
	}

}
