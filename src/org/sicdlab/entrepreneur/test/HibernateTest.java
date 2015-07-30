package org.sicdlab.entrepreneur.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.sicdlab.entrepreneur.beans.FriendlyLink;
import org.sicdlab.entrepreneur.beans.User;
import org.sicdlab.entrepreneur.utils.UUIDGenerator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateTest {
	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");
		Session s = sf.getCurrentSession();
		Transaction tx = s.beginTransaction();
		// DataDictionary dd = new DataDictionary("1", "2", "3");
		// FriendlyLink dd = new FriendlyLink("4", "2", "3", "4");
		// System.out.println(dd.getId() + dd.getKey() + dd.getValue());
		// User user = new User();
		// user.setEmail("1@1.com");
		// user.setPassword("12345");
		List list = s.createCriteria(User.class).list();
		int t = 0;
		System.out.println(t);
		System.out.println(list.size());
		for (Object object : list) {
			System.out.println(object.toString());
		}

		FriendlyLink friendlyLink = new FriendlyLink(UUIDGenerator.randomUUID(), "xjtu", "http://www.xjtu.edu.cn",
				"imagepath");
		// friendlyLink.setId(null);
		System.out.println(s.save(friendlyLink));
		// user.setRole((Role) list.iterator().next());
		// Entrepreneur enterpreneur = new Entrepreneur(user);
		// s.save(user);
		// s.save(enterpreneur);
		tx.commit();
		// s.createCriteria(User.class).add(Restrictions.in)

	}

	@Test
	public void test1() {
		System.out.println(UUIDGenerator.randomUUID());
		System.out.println(UUIDGenerator.randomUUID());
		System.out.println(UUIDGenerator.randomUUID());
		System.out.println(UUIDGenerator.randomUUID());
	}

}
