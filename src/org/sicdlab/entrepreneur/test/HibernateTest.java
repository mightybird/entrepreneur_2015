package org.sicdlab.entrepreneur.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.sicdlab.entrepreneur.beans.Entrepreneur;
import org.sicdlab.entrepreneur.beans.Industry;
import org.sicdlab.entrepreneur.beans.Project;
import org.sicdlab.entrepreneur.beans.ProjectLabel;
import org.sicdlab.entrepreneur.beans.User;
import org.sicdlab.entrepreneur.service.user.UserService;
import org.sicdlab.entrepreneur.service.user.impl.UserServiceImpl;
import org.sicdlab.entrepreneur.utils.UUIDGenerator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateTest {
	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		// UserServiceImpl us = (UserServiceImpl)
		// ctx.getBean("UserServiceImpl");
		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		// User user = (User)
		// session.createCriteria(User.class).add(Restrictions.eq("id",
		// "54454bdc587f4a4e93264afd82cf8769")).list().iterator().next();
		// List el =
		// session.createCriteria(User.class).add(Restrictions.eq("name",
		// "聂鹏")).createCriteria("entrepreneur").list();
		// System.out.println(el.size());
		// User user = (User) el.iterator().next();
		// System.out.println(user.getEntrepreneur().getId());
		// System.out.println(user.getEntrepreneur().getDegree());
		// System.out.println(user.getEntrepreneur().getExperience());
		// System.out.println(user.getEntrepreneur().getMajor());
		List il = session.createCriteria(Industry.class).list();
		System.out.println(il.size());
		for (Iterator iterator = il.iterator(); iterator.hasNext();) {
			Industry i = (Industry) iterator.next();
			System.out.println(i.getName());
		}

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
