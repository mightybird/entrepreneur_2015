package org.sicdlab.entrepreneur.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.sicdlab.entrepreneur.beans.Mail;
import org.sicdlab.entrepreneur.beans.User;
import org.sicdlab.entrepreneur.service.user.impl.UserServiceImpl;
import org.sicdlab.entrepreneur.utils.UUIDGenerator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateTest {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		UserServiceImpl us = (UserServiceImpl) ctx.getBean("UserServiceImpl");
		User sessionuser = us.getByStringProperty(User.class, "id", "54454bdc587f4a4e93264afd82cf8769").iterator().next();
		List<Mail> receivedMail = us.getReceivedMail(sessionuser);
		System.out.println(receivedMail.size());
		Iterator<Mail> it = receivedMail.iterator();
		while (it.hasNext()) {
			Mail mail = (Mail) it.next();
			System.out.println(mail.getTitle());
			System.out.println(mail.getContent());
		}
		List<Mail> p = us.getReceivedMail(sessionuser, 3, 0);
		System.out.println(p.size());
		Iterator<Mail> iterator = p.iterator();
		while (iterator.hasNext()) {
			Mail mail = (Mail) iterator.next();
			System.out.println(mail.getTitle());
			System.out.println(mail.getContent());
		}
		// SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");
		// Session session = sf.getCurrentSession();
		// Transaction tx = session.beginTransaction();
		// tx.commit();
		ctx.close();

	}

	// @Test
	public void test1() {
		// System.out.println(UUIDGenerator.randomUUID());
		// System.out.println(UUIDGenerator.randomUUID());
		// System.out.println(UUIDGenerator.randomUUID());
		// System.out.println(UUIDGenerator.randomUUID());
	}

}
