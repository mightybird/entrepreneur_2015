package org.sicdlab.entrepreneur.test;

import org.junit.Test;
import org.sicdlab.entrepreneur.test.service.ITestService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ITestService us = (ITestService) ctx.getBean("userService");
		us.test();
	}
}
