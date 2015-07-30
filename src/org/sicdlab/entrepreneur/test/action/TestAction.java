package org.sicdlab.entrepreneur.test.action;

import org.sicdlab.entrepreneur.test.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;

//@Controller("TestAction")
//@Scope("prototype")
public class TestAction {
	@Autowired
	private ITestService userService;

	public void test() {
		System.out.println("TestAction的test方法被调用");
		userService.test();
	}

//	@Action(value = "register", results = {
//			@Result(name = "success", location = "/jsp/register.jsp") }, className = "TestAction")
	public String test1() {
		System.out.println("TestAction的test1方法被调用");
		userService.test();
		return "success";
	}
}
